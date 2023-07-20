package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import com.adjust.sdk.network.ActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import com.google.android.gms.drive.DriveFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActivityHandler implements IActivityHandler {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String SESSION_CALLBACK_PARAMETERS_NAME = "Session Callback parameters";
    private static long SESSION_INTERVAL = 0;
    private static final String SESSION_PARAMETERS_NAME = "Session parameters";
    private static final String SESSION_PARTNER_PARAMETERS_NAME = "Session Partner parameters";
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    private ActivityState activityState;
    private AdjustConfig adjustConfig;
    private AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private TimerOnce delayStartTimer;
    private DeviceInfo deviceInfo;
    private ThreadExecutor executor;
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private InstallReferrer installReferrer;
    private InstallReferrerHuawei installReferrerHuawei;
    private InternalState internalState;
    private ILogger logger;
    private IPackageHandler packageHandler;
    private ISdkClickHandler sdkClickHandler;
    private SessionParameters sessionParameters;
    private String subscriptionPath;

    /* loaded from: classes.dex */
    public class InternalState {
        boolean background;
        boolean delayStart;
        boolean enabled;
        boolean firstLaunch;
        boolean firstSdkStart;
        boolean offline;
        boolean preinstallHasBeenRead;
        boolean sessionResponseProcessed;
        boolean updatePackages;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasPreinstallBeenRead() {
            return this.preinstallHasBeenRead;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            return this.background;
        }

        public boolean isInDelayedStart() {
            return this.delayStart;
        }

        public boolean isInForeground() {
            return !this.background;
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isNotInDelayedStart() {
            return !this.delayStart;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }

        public boolean itHasToUpdatePackages() {
            return this.updatePackages;
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig) {
        init(adjustConfig);
        this.logger = AdjustFactory.getLogger();
        this.logger.lockLogLevel();
        this.executor = new SingleThreadCachedScheduler("ActivityHandler");
        this.internalState = new InternalState();
        this.internalState.enabled = adjustConfig.startEnabled != null ? adjustConfig.startEnabled.booleanValue() : true;
        this.internalState.offline = adjustConfig.startOffline;
        InternalState internalState = this.internalState;
        internalState.background = true;
        internalState.delayStart = false;
        internalState.updatePackages = false;
        internalState.sessionResponseProcessed = false;
        internalState.firstSdkStart = false;
        internalState.preinstallHasBeenRead = false;
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.initI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private boolean checkActivityStateI(ActivityState activityState) {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            this.logger.error("Sdk did not yet start", new Object[0]);
            return false;
        }
        return true;
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(new SharedPreferencesManager(getContext()));
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        checkForPreinstallI();
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
    }

    private void checkAttributionStateI() {
        if (!checkActivityStateI(this.activityState)) {
            return;
        }
        if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
            return;
        }
        if (this.attribution != null && !this.activityState.askingAttribution) {
            return;
        }
        this.attributionHandler.getAttribution();
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        ILogger iLogger;
        String str;
        if (adjustEvent == null) {
            iLogger = this.logger;
            str = "Event missing";
        } else if (adjustEvent.isValid()) {
            return true;
        } else {
            iLogger = this.logger;
            str = "Event not initialized correctly";
        }
        iLogger.error(str, new Object[0]);
        return false;
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (!sdkClickResponseData.isInstallReferrer) {
            return;
        }
        if (!(sdkClickResponseData.referrerApi != null && sdkClickResponseData.referrerApi.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI))) {
            this.activityState.clickTime = sdkClickResponseData.clickTime;
            this.activityState.installBegin = sdkClickResponseData.installBegin;
            this.activityState.installReferrer = sdkClickResponseData.installReferrer;
            this.activityState.clickTimeServer = sdkClickResponseData.clickTimeServer;
            this.activityState.installBeginServer = sdkClickResponseData.installBeginServer;
            this.activityState.installVersion = sdkClickResponseData.installVersion;
            this.activityState.googlePlayInstant = sdkClickResponseData.googlePlayInstant;
        } else {
            this.activityState.clickTimeHuawei = sdkClickResponseData.clickTime;
            this.activityState.installBeginHuawei = sdkClickResponseData.installBegin;
            this.activityState.installReferrerHuawei = sdkClickResponseData.installReferrer;
        }
        writeActivityStateI();
    }

    private void checkForPreinstallI() {
        ActivityState activityState = this.activityState;
        if (activityState != null && activityState.enabled && !this.activityState.isGdprForgotten && this.adjustConfig.preinstallTrackingEnabled && !this.internalState.hasPreinstallBeenRead()) {
            if (this.deviceInfo.packageName == null || this.deviceInfo.packageName.isEmpty()) {
                this.logger.debug("Can't read preinstall payload, invalid package name", new Object[0]);
                return;
            }
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
            long preinstallPayloadReadStatus = sharedPreferencesManager.getPreinstallPayloadReadStatus();
            if (PreinstallUtil.hasAllLocationsBeenRead(preinstallPayloadReadStatus)) {
                this.internalState.preinstallHasBeenRead = true;
                return;
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus)) {
                String payloadFromSystemProperty = PreinstallUtil.getPayloadFromSystemProperty(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemProperty == null || payloadFromSystemProperty.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemProperty, Constants.SYSTEM_PROPERTIES);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyReflection = PreinstallUtil.getPayloadFromSystemPropertyReflection(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyReflection == null || payloadFromSystemPropertyReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyReflection, Constants.SYSTEM_PROPERTIES_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePath = PreinstallUtil.getPayloadFromSystemPropertyFilePath(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyFilePath == null || payloadFromSystemPropertyFilePath.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePath, Constants.SYSTEM_PROPERTIES_PATH);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePathReflection = PreinstallUtil.getPayloadFromSystemPropertyFilePathReflection(this.deviceInfo.packageName, this.logger);
                if (payloadFromSystemPropertyFilePathReflection == null || payloadFromSystemPropertyFilePathReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePathReflection, Constants.SYSTEM_PROPERTIES_PATH_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus)) {
                String payloadFromContentProviderDefault = PreinstallUtil.getPayloadFromContentProviderDefault(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadFromContentProviderDefault == null || payloadFromContentProviderDefault.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromContentProviderDefault, Constants.CONTENT_PROVIDER);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderIntentAction = PreinstallUtil.getPayloadsFromContentProviderIntentAction(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadsFromContentProviderIntentAction == null || payloadsFromContentProviderIntentAction.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus);
                } else {
                    for (String str : payloadsFromContentProviderIntentAction) {
                        this.sdkClickHandler.sendPreinstallPayload(str, Constants.CONTENT_PROVIDER_INTENT_ACTION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderNoPermission = PreinstallUtil.getPayloadsFromContentProviderNoPermission(this.adjustConfig.context, this.deviceInfo.packageName, this.logger);
                if (payloadsFromContentProviderNoPermission == null || payloadsFromContentProviderNoPermission.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus);
                } else {
                    for (String str2 : payloadsFromContentProviderNoPermission) {
                        this.sdkClickHandler.sendPreinstallPayload(str2, Constants.CONTENT_PROVIDER_NO_PERMISSION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus)) {
                String payloadFromFileSystem = PreinstallUtil.getPayloadFromFileSystem(this.deviceInfo.packageName, this.logger);
                if (payloadFromFileSystem == null || payloadFromFileSystem.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromFileSystem, Constants.FILE_SYSTEM);
                }
            }
            sharedPreferencesManager.setPreinstallPayloadReadStatus(preinstallPayloadReadStatus);
            this.internalState.preinstallHasBeenRead = true;
        }
    }

    private boolean checkOrderIdI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.findOrderId(str)) {
                this.logger.info("Skipping duplicated order ID '%s'", str);
                return false;
            }
            this.activityState.addOrderId(str);
            this.logger.verbose("Added order ID '%s'", str);
        }
        return true;
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent = this.adjustConfig.deepLinkComponent == null ? new Intent("android.intent.action.VIEW", uri) : new Intent("android.intent.action.VIEW", uri, this.adjustConfig.context, this.adjustConfig.deepLinkComponent);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayStartI() {
        if (!this.internalState.isNotInDelayedStart() && !isToUpdatePackagesI()) {
            double doubleValue = this.adjustConfig.delayStart != null ? this.adjustConfig.delayStart.doubleValue() : 0.0d;
            long maxDelayStart = AdjustFactory.getMaxDelayStart();
            long j = (long) (1000.0d * doubleValue);
            if (j > maxDelayStart) {
                double d = maxDelayStart / 1000;
                this.logger.warn("Delay start of %s seconds bigger than max allowed value of %s seconds", Util.SecondsDisplayFormat.format(doubleValue), Util.SecondsDisplayFormat.format(d));
                doubleValue = d;
            } else {
                maxDelayStart = j;
            }
            this.logger.info("Waiting %s seconds before starting first session", Util.SecondsDisplayFormat.format(doubleValue));
            this.delayStartTimer.startIn(maxDelayStart);
            this.internalState.updatePackages = true;
            ActivityState activityState = this.activityState;
            if (activityState == null) {
                return;
            }
            activityState.updatePackages = true;
            writeActivityStateI();
        }
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteSessionCallbackParameters(Context context) {
        return context.deleteFile(Constants.SESSION_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteSessionPartnerParameters(Context context) {
        return context.deleteFile(Constants.SESSION_PARTNER_PARAMETERS_FILENAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteSessionCallbackParameters(context);
        deleteSessionPartnerParameters(context);
        new SharedPreferencesManager(context).clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableThirdPartySharingI() {
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
        sharedPreferencesManager.setDisableThirdPartySharing();
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten && !this.activityState.isThirdPartySharingDisabled) {
            this.activityState.isThirdPartySharingDisabled = true;
            writeActivityStateI();
            ActivityPackage buildDisableThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildDisableThirdPartySharingPackage();
            this.packageHandler.addPackage(buildDisableThirdPartySharingPackage);
            sharedPreferencesManager.removeDisableThirdPartySharing();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildDisableThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (!updateActivityStateI(System.currentTimeMillis())) {
            return;
        }
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.activityState.isGdprForgotten = true;
            writeActivityStateI();
            ActivityPackage buildGdprPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildGdprPackage();
            this.packageHandler.addPackage(buildGdprPackage);
            new SharedPreferencesManager(getContext()).removeGdprForgetMe();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildGdprPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        } else if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        } else {
            if (adjustConfig.processName != null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) adjustConfig.context.getSystemService("activity");
                if (activityManager != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            if (!next.processName.equalsIgnoreCase(adjustConfig.processName)) {
                                AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", next.processName);
                                return null;
                            }
                        }
                    }
                } else {
                    return null;
                }
            }
            return new ActivityHandler(adjustConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private boolean hasChangedStateI(boolean z, boolean z2, String str, String str2) {
        if (z != z2) {
            return true;
        }
        if (z) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initI() {
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.sessionParameters = new SessionParameters();
        readSessionCallbackParametersI(this.adjustConfig.context);
        readSessionPartnerParametersI(this.adjustConfig.context);
        if (this.adjustConfig.startEnabled != null) {
            this.adjustConfig.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.ActivityHandler.32
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
                }
            });
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            this.internalState.enabled = this.activityState.enabled;
            this.internalState.updatePackages = this.activityState.updatePackages;
            this.internalState.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        this.deviceInfo = new DeviceInfo(this.adjustConfig.context, this.adjustConfig.sdkPrefix);
        if (this.adjustConfig.eventBufferingEnabled) {
            this.logger.info("Event buffering is enabled", new Object[0]);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        if (this.deviceInfo.playAdId == null) {
            this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            if (this.deviceInfo.macSha1 == null && this.deviceInfo.macShortMd5 == null && this.deviceInfo.androidId == null) {
                this.logger.error("Unable to get any device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        if (this.adjustConfig.defaultTracker != null) {
            this.logger.info("Default tracker: '%s'", this.adjustConfig.defaultTracker);
        }
        if (this.adjustConfig.pushToken != null) {
            this.logger.info("Push token: '%s'", this.adjustConfig.pushToken);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                new SharedPreferencesManager(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred()) {
            setPushToken(new SharedPreferencesManager(getContext()).getPushToken(), true);
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
            if (sharedPreferencesManager.getGdprForgetMe()) {
                gdprForgetMe();
            } else {
                if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                    disableThirdPartySharing();
                }
                for (AdjustThirdPartySharing adjustThirdPartySharing : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharing(adjustThirdPartySharing);
                }
                if (this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked != null) {
                    trackMeasurementConsent(this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
            }
        }
        this.foregroundTimer = new TimerCycle(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.33
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.foregroundTimerFired();
            }
        }, FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.sendInBackground) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.34
                @Override // java.lang.Runnable
                public void run() {
                    ActivityHandler.this.backgroundTimerFired();
                }
            }, BACKGROUND_TIMER_NAME);
        }
        if (this.internalState.hasFirstSdkStartNotOcurred() && this.adjustConfig.delayStart != null && this.adjustConfig.delayStart.doubleValue() > 0.0d) {
            this.logger.info("Delay start configured", new Object[0]);
            this.internalState.delayStart = true;
            this.delayStartTimer = new TimerOnce(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.35
                @Override // java.lang.Runnable
                public void run() {
                    ActivityHandler.this.sendFirstPackages();
                }
            }, DELAY_START_TIMER_NAME);
        }
        UtilNetworking.setUserAgent(this.adjustConfig.userAgent);
        this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false), new ActivityPackageSender(this.adjustConfig.urlStrategy, this.adjustConfig.basePath, this.adjustConfig.gdprPath, this.adjustConfig.subscriptionPath, this.deviceInfo.clientSdk));
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false), new ActivityPackageSender(this.adjustConfig.urlStrategy, this.adjustConfig.basePath, this.adjustConfig.gdprPath, this.adjustConfig.subscriptionPath, this.deviceInfo.clientSdk));
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true), new ActivityPackageSender(this.adjustConfig.urlStrategy, this.adjustConfig.basePath, this.adjustConfig.gdprPath, this.adjustConfig.subscriptionPath, this.deviceInfo.clientSdk));
        if (isToUpdatePackagesI()) {
            updatePackagesI();
        }
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new InstallReferrerReadListener() { // from class: com.adjust.sdk.ActivityHandler.36
            @Override // com.adjust.sdk.InstallReferrerReadListener
            public void onInstallReferrerRead(ReferrerDetails referrerDetails) {
                ActivityHandler.this.sendInstallReferrer(referrerDetails, "google");
            }
        });
        this.installReferrerHuawei = new InstallReferrerHuawei(this.adjustConfig.context, new InstallReferrerReadListener() { // from class: com.adjust.sdk.ActivityHandler.37
            @Override // com.adjust.sdk.InstallReferrerReadListener
            public void onInstallReferrerRead(ReferrerDetails referrerDetails) {
                ActivityHandler.this.sendInstallReferrer(referrerDetails, Constants.REFERRER_API_HUAWEI);
            }
        });
        preLaunchActionsI(this.adjustConfig.preLaunchActions.preLaunchActionsArray);
        sendReftagReferrerI();
    }

    private boolean isEnabledI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.enabled : this.internalState.isEnabled();
    }

    private boolean isToUpdatePackagesI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.updatePackages : this.internalState.itHasToUpdatePackages();
    }

    private boolean isValidReferrerDetails(ReferrerDetails referrerDetails) {
        return (referrerDetails == null || referrerDetails.installReferrer == null || referrerDetails.installReferrer.length() == 0) ? false : true;
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.42
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onAttributionChangedListener == null) {
                    return;
                }
                ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchDeeplinkMain(Intent intent, Uri uri) {
        if (!(this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() > 0)) {
            this.logger.error("Unable to open deferred deep link (%s)", uri);
            return;
        }
        this.logger.info("Open deferred deep link (%s)", uri);
        this.adjustConfig.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchEventResponseTasksI(final EventResponseData eventResponseData) {
        Runnable runnable;
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (eventResponseData.success && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            runnable = new Runnable() { // from class: com.adjust.sdk.ActivityHandler.38
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener == null) {
                        return;
                    }
                    ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(eventResponseData.getSuccessResponseData());
                }
            };
        } else if (eventResponseData.success || this.adjustConfig.onEventTrackingFailedListener == null) {
            return;
        } else {
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            runnable = new Runnable() { // from class: com.adjust.sdk.ActivityHandler.39
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingFailedListener == null) {
                        return;
                    }
                    ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onFinishedEventTrackingFailed(eventResponseData.getFailureResponseData());
                }
            };
        }
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
    }

    private void launchSessionResponseListenerI(final SessionResponseData sessionResponseData, Handler handler) {
        Runnable runnable;
        if (sessionResponseData.success && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            runnable = new Runnable() { // from class: com.adjust.sdk.ActivityHandler.40
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener == null) {
                        return;
                    }
                    ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(sessionResponseData.getSuccessResponseData());
                }
            };
        } else if (sessionResponseData.success || this.adjustConfig.onSessionTrackingFailedListener == null) {
            return;
        } else {
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            runnable = new Runnable() { // from class: com.adjust.sdk.ActivityHandler.41
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener == null) {
                        return;
                    }
                    ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(sessionResponseData.getFailureResponseData());
                }
            };
        }
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        this.logger.debug("Launching SessionResponse tasks", new Object[0]);
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            new SharedPreferencesManager(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (!toSendI(true)) {
            this.sdkClickHandler.pauseSending();
        } else {
            this.sdkClickHandler.resumeSending();
        }
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private boolean pausedI(boolean z) {
        return z ? this.internalState.isOffline() || !isEnabledI() : this.internalState.isOffline() || !isEnabledI() || this.internalState.isInDelayedStart();
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list == null) {
            return;
        }
        for (IRunActivityHandler iRunActivityHandler : list) {
            iRunActivityHandler.run(this);
        }
    }

    private void prepareDeeplinkI(final Uri uri, Handler handler) {
        if (uri == null) {
            return;
        }
        this.logger.info("Deferred deeplink received (%s)", uri);
        final Intent createDeeplinkIntentI = createDeeplinkIntentI(uri);
        handler.post(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.43
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityHandler.this.adjustConfig == null) {
                    return;
                }
                boolean z = true;
                if (ActivityHandler.this.adjustConfig.onDeeplinkResponseListener != null) {
                    z = ActivityHandler.this.adjustConfig.onDeeplinkResponseListener.launchReceivedDeeplink(uri);
                }
                if (!z) {
                    return;
                }
                ActivityHandler.this.launchDeeplinkMain(createDeeplinkIntentI, uri);
            }
        });
    }

    private void processCachedDeeplinkI() {
        if (!checkActivityStateI(this.activityState)) {
            return;
        }
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
        String deeplinkUrl = sharedPreferencesManager.getDeeplinkUrl();
        long deeplinkClickTime = sharedPreferencesManager.getDeeplinkClickTime();
        if (deeplinkUrl == null || deeplinkClickTime == -1) {
            return;
        }
        readOpenUrl(Uri.parse(deeplinkUrl), deeplinkClickTime);
        sharedPreferencesManager.removeDeeplink();
    }

    private void processSessionI() {
        if (this.activityState.isGdprForgotten) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.activityState.lastActivity;
        if (j < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            this.activityState.lastActivity = currentTimeMillis;
            writeActivityStateI();
        } else if (j > SESSION_INTERVAL) {
            trackNewSessionI(currentTimeMillis);
            checkAfterNewStartI();
        } else if (j <= SUBSESSION_INTERVAL) {
            this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
        } else {
            this.activityState.subsessionCount++;
            this.activityState.sessionLength += j;
            ActivityState activityState = this.activityState;
            activityState.lastActivity = currentTimeMillis;
            this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(activityState.subsessionCount), Integer.valueOf(this.activityState.sessionCount));
            writeActivityStateI();
            checkForPreinstallI();
            this.installReferrer.startConnection();
            this.installReferrerHuawei.readReferrer();
        }
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) {
        try {
            InputStream open = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property == null) {
                return;
            }
            this.adjustConfig.defaultTracker = property;
        } catch (Exception e) {
            this.logger.debug("%s file not found in this app", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readOpenUrlI(Uri uri, long j) {
        if (!isEnabledI()) {
            return;
        }
        if (!Util.isUrlFilteredOut(uri)) {
            ActivityPackage buildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
            if (buildDeeplinkSdkClickPackage == null) {
                return;
            }
            this.sdkClickHandler.sendSdkClick(buildDeeplinkSdkClickPackage);
            return;
        }
        ILogger iLogger = this.logger;
        iLogger.debug("Deep link (" + uri.toString() + ") processing skipped", new Object[0]);
    }

    private void readSessionCallbackParametersI(Context context) {
        try {
            this.sessionParameters.callbackParameters = (Map) Util.readObject(context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", SESSION_CALLBACK_PARAMETERS_NAME, e.getMessage());
            this.sessionParameters.callbackParameters = null;
        }
    }

    private void readSessionPartnerParametersI(Context context) {
        try {
            this.sessionParameters.partnerParameters = (Map) Util.readObject(context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", SESSION_PARTNER_PARAMETERS_NAME, e.getMessage());
            this.sessionParameters.partnerParameters = null;
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirstPackagesI() {
        if (this.internalState.isNotInDelayedStart()) {
            this.logger.info("Start delay expired or never configured", new Object[0]);
            return;
        }
        updatePackagesI();
        this.internalState.delayStart = false;
        this.delayStartTimer.cancel();
        this.delayStartTimer = null;
        updateHandlersStatusAndSendI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInstallReferrerI(ReferrerDetails referrerDetails, String str) {
        if (isEnabledI() && isValidReferrerDetails(referrerDetails) && !Util.isEqualReferrerDetails(referrerDetails, str, this.activityState)) {
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(referrerDetails, str, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAskingAttributionI(boolean z) {
        this.activityState.askingAttribution = z;
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledI(boolean z) {
        ActivityState activityState;
        if (!hasChangedStateI(isEnabledI(), z, "Adjust already enabled", "Adjust already disabled")) {
            return;
        }
        if (z && (activityState = this.activityState) != null && activityState.isGdprForgotten) {
            this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
            return;
        }
        InternalState internalState = this.internalState;
        internalState.enabled = z;
        if (internalState.hasFirstSdkStartNotOcurred()) {
            updateStatusI(!z, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
            return;
        }
        this.activityState.enabled = z;
        writeActivityStateI();
        if (z) {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
            if (sharedPreferencesManager.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                for (AdjustThirdPartySharing adjustThirdPartySharing : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharingI(adjustThirdPartySharing);
                }
                if (this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked != null) {
                    trackMeasurementConsentI(this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
            }
            if (!sharedPreferencesManager.getInstallTracked()) {
                this.logger.debug("Detected that install was not tracked at enable time", new Object[0]);
                trackNewSessionI(System.currentTimeMillis());
            }
            checkAfterNewStartI(sharedPreferencesManager);
        }
        updateStatusI(!z, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflineModeI(boolean z) {
        String str;
        String str2;
        String str3;
        if (!hasChangedStateI(this.internalState.isOffline(), z, "Adjust already in offline mode", "Adjust already in online mode")) {
            return;
        }
        InternalState internalState = this.internalState;
        internalState.offline = z;
        if (internalState.hasFirstSdkStartNotOcurred()) {
            str = "Handlers will start paused due to SDK being offline";
            str2 = "Handlers will still start as paused";
            str3 = "Handlers will start as active due to SDK being online";
        } else {
            str = "Pausing handlers to put SDK offline mode";
            str2 = "Handlers remain paused";
            str3 = "Resuming handlers to put SDK in online mode";
        }
        updateStatusI(z, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten && str != null && !str.equals(this.activityState.pushToken)) {
            this.activityState.pushToken = str;
            writeActivityStateI();
            ActivityPackage buildInfoPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildInfoPackage(Constants.PUSH);
            this.packageHandler.addPackage(buildInfoPackage);
            new SharedPreferencesManager(getContext()).removePushToken();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildInfoPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        this.activityState = new ActivityState();
        this.internalState.firstSdkStart = true;
        updateHandlersStatusAndSendI();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
        this.activityState.pushToken = sharedPreferencesManager.getPushToken();
        if (this.internalState.isEnabled()) {
            if (sharedPreferencesManager.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                for (AdjustThirdPartySharing adjustThirdPartySharing : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharingI(adjustThirdPartySharing);
                }
                if (this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked != null) {
                    trackMeasurementConsentI(this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                this.activityState.sessionCount = 1;
                transferSessionPackageI(currentTimeMillis);
                checkAfterNewStartI(sharedPreferencesManager);
            }
        }
        this.activityState.resetSessionAttributes(currentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        this.activityState.updatePackages = this.internalState.itHasToUpdatePackages();
        writeActivityStateI();
        sharedPreferencesManager.removePushToken();
        sharedPreferencesManager.removeGdprForgetMe();
        sharedPreferencesManager.removeDisableThirdPartySharing();
        processCachedDeeplinkI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForegroundTimerI() {
        if (!isEnabledI()) {
            return;
        }
        this.foregroundTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
        } else if (!this.activityState.enabled) {
        } else {
            AdjustSigner.onResume(this.adjustConfig.logger);
            updateHandlersStatusAndSendI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce == null) {
            return;
        }
        timerOnce.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            if (this.activityState == null) {
                return;
            }
            this.activityState = null;
        }
    }

    private void teardownAllSessionParametersS() {
        synchronized (SessionParameters.class) {
            if (this.sessionParameters == null) {
                return;
            }
            this.sessionParameters = null;
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            if (this.attribution == null) {
                return;
            }
            this.attribution = null;
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    private boolean toSendI(boolean z) {
        if (pausedI(z)) {
            return false;
        }
        if (!this.adjustConfig.sendInBackground) {
            return this.internalState.isInForeground();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackAdRevenueI(String str, JSONObject jSONObject) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(str, jSONObject));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && checkOrderIdI(adjustEvent.orderId) && !this.activityState.isGdprForgotten) {
            long currentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(currentTimeMillis);
            ActivityPackage buildEventPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, currentTimeMillis).buildEventPackage(adjustEvent, this.internalState.isInDelayedStart());
            this.packageHandler.addPackage(buildEventPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildEventPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
            if (this.adjustConfig.sendInBackground && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackMeasurementConsentI(boolean z) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z);
        } else if (!isEnabledI() || this.activityState.isGdprForgotten) {
        } else {
            ActivityPackage buildMeasurementConsentPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildMeasurementConsentPackage(z);
            this.packageHandler.addPackage(buildMeasurementConsentPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildMeasurementConsentPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void trackNewSessionI(long j) {
        this.activityState.sessionCount++;
        this.activityState.lastInterval = j - this.activityState.lastActivity;
        transferSessionPackageI(j);
        this.activityState.resetSessionAttributes(j);
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildSubscriptionPackage(adjustPlayStoreSubscription, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackThirdPartySharingI(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else if (!isEnabledI() || this.activityState.isGdprForgotten) {
        } else {
            ActivityPackage buildThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(adjustThirdPartySharing);
            this.packageHandler.addPackage(buildThirdPartySharingPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void transferSessionPackageI(long j) {
        this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, j).buildSessionPackage(this.internalState.isInDelayedStart()));
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        long j2 = j - this.activityState.lastActivity;
        if (j2 > SESSION_INTERVAL) {
            return false;
        }
        ActivityState activityState = this.activityState;
        activityState.lastActivity = j;
        if (j2 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState.sessionLength += j2;
        this.activityState.timeSpent += j2;
        return true;
    }

    private void updateAdidI(String str) {
        if (str != null && !str.equals(this.activityState.adid)) {
            this.activityState.adid = str;
            writeActivityStateI();
        }
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
            return;
        }
        resumeSendingI();
        if (this.adjustConfig.eventBufferingEnabled && (!this.internalState.isFirstLaunch() || !this.internalState.hasSessionResponseNotBeenProcessed())) {
            return;
        }
        this.packageHandler.sendFirstPackage();
    }

    private void updatePackagesI() {
        this.packageHandler.updatePackages(this.sessionParameters);
        this.internalState.updatePackages = false;
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.updatePackages = false;
            writeActivityStateI();
        }
    }

    private void updateStatusI(boolean z, String str, String str2, String str3) {
        ILogger iLogger;
        if (!z) {
            if (!pausedI(false)) {
                this.logger.info(str3, new Object[0]);
            } else if (pausedI(true)) {
                this.logger.info(str2, new Object[0]);
            } else {
                iLogger = this.logger;
                str = str2 + ", except the Sdk Click Handler";
            }
            updateHandlersStatusAndSendI();
        }
        iLogger = this.logger;
        iLogger.info(str, new Object[0]);
        updateHandlersStatusAndSendI();
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            if (this.activityState == null) {
                return;
            }
            Util.writeObject(this.activityState, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            if (this.attribution == null) {
                return;
            }
            Util.writeObject(this.attribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
        }
    }

    private void writeSessionCallbackParametersI() {
        synchronized (SessionParameters.class) {
            if (this.sessionParameters == null) {
                return;
            }
            Util.writeObject(this.sessionParameters.callbackParameters, this.adjustConfig.context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME);
        }
    }

    private void writeSessionPartnerParametersI() {
        synchronized (SessionParameters.class) {
            if (this.sessionParameters == null) {
                return;
            }
            Util.writeObject(this.sessionParameters.partnerParameters, this.adjustConfig.context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME);
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionCallbackParameter(final String str, final String str2) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.16
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.addSessionCallbackParameterI(str, str2);
            }
        });
    }

    public void addSessionCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Callback") && Util.isValidParameter(str2, "value", "Session Callback")) {
            if (this.sessionParameters.callbackParameters == null) {
                this.sessionParameters.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.callbackParameters.put(str, str2);
            writeSessionCallbackParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionPartnerParameter(final String str, final String str2) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.17
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.addSessionPartnerParameterI(str, str2);
            }
        });
    }

    public void addSessionPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Partner") && Util.isValidParameter(str2, "value", "Session Partner")) {
            if (this.sessionParameters.partnerParameters == null) {
                this.sessionParameters.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.partnerParameters.put(str, str2);
            writeSessionPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.31
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.backgroundTimerFiredI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void disableThirdPartySharing() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.24
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.disableThirdPartySharingI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.logger.debug("Finished tracking session", new Object[0]);
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
        } else if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (!(responseData instanceof EventResponseData)) {
        } else {
            launchEventResponseTasks((EventResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.30
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.foregroundTimerFiredI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gdprForgetMe() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.23
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.gdprForgetMeI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public ActivityState getActivityState() {
        return this.activityState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getAdid() {
        ActivityState activityState = this.activityState;
        if (activityState == null) {
            return null;
        }
        return activityState.adid;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustAttribution getAttribution() {
        return this.attribution;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public Context getContext() {
        return this.adjustConfig.context;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public InternalState getInternalState() {
        return this.internalState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public SessionParameters getSessionParameters() {
        return this.sessionParameters;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gotOptOutResponse() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.29
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.gotOptOutResponseI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void init(AdjustConfig adjustConfig) {
        this.adjustConfig = adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean isEnabled() {
        return isEnabledI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchAttributionResponseTasks(final AttributionResponseData attributionResponseData) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.14
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.launchAttributionResponseTasksI(attributionResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchEventResponseTasks(final EventResponseData eventResponseData) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.11
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.launchEventResponseTasksI(eventResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSdkClickResponseTasks(final SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.12
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.launchSdkClickResponseTasksI(sdkClickResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSessionResponseTasks(final SessionResponseData sessionResponseData) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.13
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.launchSessionResponseTasksI(sessionResponseData);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onPause() {
        this.internalState.background = true;
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.3
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.stopForegroundTimerI();
                ActivityHandler.this.startBackgroundTimerI();
                ActivityHandler.this.logger.verbose("Subsession end", new Object[0]);
                ActivityHandler.this.endI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onResume() {
        this.internalState.background = false;
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.2
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.delayStartI();
                ActivityHandler.this.stopBackgroundTimerI();
                ActivityHandler.this.startForegroundTimerI();
                ActivityHandler.this.logger.verbose("Subsession start", new Object[0]);
                ActivityHandler.this.startI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void readOpenUrl(final Uri uri, final long j) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.7
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.readOpenUrlI(uri, j);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionCallbackParameter(final String str) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.18
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.removeSessionCallbackParameterI(str);
            }
        });
    }

    public void removeSessionCallbackParameterI(String str) {
        if (!Util.isValidParameter(str, "key", "Session Callback")) {
            return;
        }
        if (this.sessionParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        } else if (this.sessionParameters.callbackParameters.remove(str) == null) {
            this.logger.warn("Key %s does not exist", str);
        } else {
            this.logger.debug("Key %s will be removed", str);
            writeSessionCallbackParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionPartnerParameter(final String str) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.19
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.removeSessionPartnerParameterI(str);
            }
        });
    }

    public void removeSessionPartnerParameterI(String str) {
        if (!Util.isValidParameter(str, "key", "Session Partner")) {
            return;
        }
        if (this.sessionParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        } else if (this.sessionParameters.partnerParameters.remove(str) == null) {
            this.logger.warn("Key %s does not exist", str);
        } else {
            this.logger.debug("Key %s will be removed", str);
            writeSessionPartnerParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionCallbackParameters() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.20
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.resetSessionCallbackParametersI();
            }
        });
    }

    public void resetSessionCallbackParametersI() {
        if (this.sessionParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.sessionParameters.callbackParameters = null;
        writeSessionCallbackParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionPartnerParameters() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.21
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.resetSessionPartnerParametersI();
            }
        });
    }

    public void resetSessionPartnerParametersI() {
        if (this.sessionParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.sessionParameters.partnerParameters = null;
        writeSessionPartnerParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendFirstPackages() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.15
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.sendFirstPackagesI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendInstallReferrer(final ReferrerDetails referrerDetails, final String str) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.10
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.sendInstallReferrerI(referrerDetails, str);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendReftagReferrer() {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.9
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.sendReftagReferrerI();
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setAskingAttribution(final boolean z) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.8
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.setAskingAttributionI(z);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setEnabled(final boolean z) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.5
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.setEnabledI(z);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setOfflineMode(final boolean z) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.6
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.setOfflineModeI(z);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setPushToken(final String str, final boolean z) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.22
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    new SharedPreferencesManager(ActivityHandler.this.getContext()).savePushToken(str);
                }
                if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                    return;
                }
                ActivityHandler.this.setPushTokenI(str);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        TimerOnce timerOnce2 = this.delayStartTimer;
        if (timerOnce2 != null) {
            timerOnce2.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        SessionParameters sessionParameters = this.sessionParameters;
        if (sessionParameters != null) {
            if (sessionParameters.callbackParameters != null) {
                this.sessionParameters.callbackParameters.clear();
            }
            if (this.sessionParameters.partnerParameters != null) {
                this.sessionParameters.partnerParameters.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllSessionParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.delayStartTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.sessionParameters = null;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackAdRevenue(final String str, final JSONObject jSONObject) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.27
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.trackAdRevenueI(str, jSONObject);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackEvent(final AdjustEvent adjustEvent) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.4
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                    ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                    ActivityHandler.this.startI();
                }
                ActivityHandler.this.trackEventI(adjustEvent);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackMeasurementConsent(final boolean z) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.26
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.trackMeasurementConsentI(z);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackPlayStoreSubscription(final AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.28
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.trackSubscriptionI(adjustPlayStoreSubscription);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackThirdPartySharing(final AdjustThirdPartySharing adjustThirdPartySharing) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.ActivityHandler.25
            @Override // java.lang.Runnable
            public void run() {
                ActivityHandler.this.trackThirdPartySharingI(adjustThirdPartySharing);
            }
        });
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution != null && !adjustAttribution.equals(this.attribution)) {
            this.attribution = adjustAttribution;
            writeAttributionI();
            return true;
        }
        return false;
    }
}
