package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private String gdprPath;
    private String pushToken;
    private String subscriptionPath;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private PreLaunchActions preLaunchActions = new PreLaunchActions();

    /* loaded from: classes.dex */
    public static class PreLaunchActions {
        public List<IRunActivityHandler> preLaunchActionsArray = new ArrayList();
        public List<AdjustThirdPartySharing> preLaunchAdjustThirdPartySharingArray = new ArrayList();
        public Boolean lastMeasurementConsentTracked = null;
    }

    private boolean checkActivityHandler() {
        return checkActivityHandler(null);
    }

    private boolean checkActivityHandler(String str) {
        if (this.activityHandler == null) {
            if (str != null) {
                AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
            } else {
                AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
            }
            return false;
        }
        return true;
    }

    private boolean checkActivityHandler(boolean z, String str, String str2) {
        return z ? checkActivityHandler(str) : checkActivityHandler(str2);
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDisableThirdPartySharing(final Context context) {
        Util.runInBackground(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.10
            @Override // java.lang.Runnable
            public void run() {
                new SharedPreferencesManager(context).setDisableThirdPartySharing();
            }
        });
    }

    private void saveGdprForgetMe(final Context context) {
        Util.runInBackground(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.9
            @Override // java.lang.Runnable
            public void run() {
                new SharedPreferencesManager(context).setGdprForgetMe();
            }
        });
    }

    private void savePushToken(final String str, final Context context) {
        Util.runInBackground(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.8
            @Override // java.lang.Runnable
            public void run() {
                new SharedPreferencesManager(context).savePushToken(str);
            }
        });
    }

    private void saveRawReferrer(final String str, final long j, final Context context) {
        Util.runInBackground(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.7
            @Override // java.lang.Runnable
            public void run() {
                new SharedPreferencesManager(context).saveRawReferrer(str, j);
            }
        });
    }

    private void setSendingReferrersAsNotSent(final Context context) {
        Util.runInBackground(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.11
            @Override // java.lang.Runnable
            public void run() {
                new SharedPreferencesManager(context).setSendingReferrersAsNotSent();
            }
        });
    }

    public void addSessionCallbackParameter(final String str, final String str2) {
        if (checkActivityHandler("adding session callback parameter")) {
            this.activityHandler.addSessionCallbackParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.1
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.addSessionCallbackParameterI(str, str2);
                }
            });
        }
    }

    public void addSessionPartnerParameter(final String str, final String str2) {
        if (checkActivityHandler("adding session partner parameter")) {
            this.activityHandler.addSessionPartnerParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.2
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.addSessionPartnerParameterI(str, str2);
                }
            });
        }
    }

    public void appWillOpenUrl(Uri uri) {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.readOpenUrl(uri, System.currentTimeMillis());
    }

    public void appWillOpenUrl(Uri uri, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!checkActivityHandler()) {
            new SharedPreferencesManager(context).saveDeeplink(uri, currentTimeMillis);
        } else {
            this.activityHandler.readOpenUrl(uri, currentTimeMillis);
        }
    }

    public void disableThirdPartySharing(Context context) {
        if (!checkActivityHandler("disable third party sharing")) {
            saveDisableThirdPartySharing(context);
        } else {
            this.activityHandler.disableThirdPartySharing();
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (!checkActivityHandler("gdpr") || !this.activityHandler.isEnabled()) {
            return;
        }
        this.activityHandler.gdprForgetMe();
    }

    public String getAdid() {
        if (!checkActivityHandler()) {
            return null;
        }
        return this.activityHandler.getAdid();
    }

    public AdjustAttribution getAttribution() {
        if (!checkActivityHandler()) {
            return null;
        }
        return this.activityHandler.getAttribution();
    }

    public String getSdkVersion() {
        return Util.getSdkVersion();
    }

    public boolean isEnabled() {
        return !checkActivityHandler() ? isInstanceEnabled() : this.activityHandler.isEnabled();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
        } else if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
        } else if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
        } else {
            adjustConfig.preLaunchActions = this.preLaunchActions;
            adjustConfig.pushToken = this.pushToken;
            adjustConfig.startEnabled = this.startEnabled;
            adjustConfig.startOffline = this.startOffline;
            adjustConfig.basePath = this.basePath;
            adjustConfig.gdprPath = this.gdprPath;
            adjustConfig.subscriptionPath = this.subscriptionPath;
            this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
            setSendingReferrersAsNotSent(adjustConfig.context);
        }
    }

    public void onPause() {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.onPause();
    }

    public void onResume() {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.onResume();
    }

    public void removeSessionCallbackParameter(final String str) {
        if (checkActivityHandler("removing session callback parameter")) {
            this.activityHandler.removeSessionCallbackParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.3
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.removeSessionCallbackParameterI(str);
                }
            });
        }
    }

    public void removeSessionPartnerParameter(final String str) {
        if (checkActivityHandler("removing session partner parameter")) {
            this.activityHandler.removeSessionPartnerParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.4
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.removeSessionPartnerParameterI(str);
                }
            });
        }
    }

    public void resetSessionCallbackParameters() {
        if (checkActivityHandler("resetting session callback parameters")) {
            this.activityHandler.resetSessionCallbackParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.5
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.resetSessionCallbackParametersI();
                }
            });
        }
    }

    public void resetSessionPartnerParameters() {
        if (checkActivityHandler("resetting session partner parameters")) {
            this.activityHandler.resetSessionPartnerParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.6
                @Override // com.adjust.sdk.IRunActivityHandler
                public void run(ActivityHandler activityHandler) {
                    activityHandler.resetSessionPartnerParametersI();
                }
            });
        }
    }

    public void sendFirstPackages() {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.sendFirstPackages();
    }

    public void sendReferrer(String str, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            return;
        }
        saveRawReferrer(str, currentTimeMillis, context);
        if (!checkActivityHandler(Constants.REFERRER) || !this.activityHandler.isEnabled()) {
            return;
        }
        this.activityHandler.sendReftagReferrer();
    }

    public void setEnabled(boolean z) {
        this.startEnabled = Boolean.valueOf(z);
        if (checkActivityHandler(z, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(z);
        }
    }

    public void setOfflineMode(boolean z) {
        if (!checkActivityHandler(z, "offline mode", "online mode")) {
            this.startOffline = z;
        } else {
            this.activityHandler.setOfflineMode(z);
        }
    }

    public void setPushToken(String str) {
        if (!checkActivityHandler("push token")) {
            this.pushToken = str;
        } else {
            this.activityHandler.setPushToken(str, false);
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (!checkActivityHandler("push token") || !this.activityHandler.isEnabled()) {
            return;
        }
        this.activityHandler.setPushToken(str, true);
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        if (adjustTestOptions.basePath != null) {
            this.basePath = adjustTestOptions.basePath;
        }
        if (adjustTestOptions.gdprPath != null) {
            this.gdprPath = adjustTestOptions.gdprPath;
        }
        if (adjustTestOptions.subscriptionPath != null) {
            this.subscriptionPath = adjustTestOptions.subscriptionPath;
        }
        if (adjustTestOptions.baseUrl != null) {
            AdjustFactory.setBaseUrl(adjustTestOptions.baseUrl);
        }
        if (adjustTestOptions.gdprUrl != null) {
            AdjustFactory.setGdprUrl(adjustTestOptions.gdprUrl);
        }
        if (adjustTestOptions.subscriptionUrl != null) {
            AdjustFactory.setSubscriptionUrl(adjustTestOptions.subscriptionUrl);
        }
        if (adjustTestOptions.timerIntervalInMilliseconds != null) {
            AdjustFactory.setTimerInterval(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        if (adjustTestOptions.sessionIntervalInMilliseconds != null) {
            AdjustFactory.setSessionInterval(adjustTestOptions.sessionIntervalInMilliseconds.longValue());
        }
        if (adjustTestOptions.subsessionIntervalInMilliseconds != null) {
            AdjustFactory.setSubsessionInterval(adjustTestOptions.subsessionIntervalInMilliseconds.longValue());
        }
        if (adjustTestOptions.tryInstallReferrer != null) {
            AdjustFactory.setTryInstallReferrer(adjustTestOptions.tryInstallReferrer.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            AdjustFactory.setPackageHandlerBackoffStrategy(BackoffStrategy.NO_WAIT);
            AdjustFactory.setSdkClickBackoffStrategy(BackoffStrategy.NO_WAIT);
        }
        if (adjustTestOptions.enableSigning != null && adjustTestOptions.enableSigning.booleanValue()) {
            AdjustFactory.enableSigning();
        }
        if (adjustTestOptions.disableSigning == null || !adjustTestOptions.disableSigning.booleanValue()) {
            return;
        }
        AdjustFactory.disableSigning();
    }

    public void teardown() {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.teardown();
        this.activityHandler = null;
    }

    public void trackAdRevenue(String str, JSONObject jSONObject) {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.trackAdRevenue(str, jSONObject);
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.trackEvent(adjustEvent);
    }

    public void trackMeasurementConsent(boolean z) {
        if (checkActivityHandler("measurement consent")) {
            this.activityHandler.trackMeasurementConsent(z);
            return;
        }
        this.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z);
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (!checkActivityHandler()) {
            return;
        }
        this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityHandler("third party sharing")) {
            this.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else {
            this.activityHandler.trackThirdPartySharing(adjustThirdPartySharing);
        }
    }
}
