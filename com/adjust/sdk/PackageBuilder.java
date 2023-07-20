package com.adjust.sdk;

import android.content.ContentResolver;
import android.text.TextUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.gree.gamelib.core.a.b.a;
import net.gree.gamelib.payment.internal.a.g;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private ActivityStateCopy activityStateCopy;
    private AdjustConfig adjustConfig;
    AdjustAttribution attribution;
    private long createdAt;
    String deeplink;
    private DeviceInfo deviceInfo;
    Map<String, String> extraParameters;
    Boolean googlePlayInstant;
    String installVersion;
    String preinstallLocation;
    String preinstallPayload;
    String rawReferrer;
    String referrer;
    String referrerApi;
    String reftag;
    private SessionParameters sessionParameters;
    long clickTimeInSeconds = -1;
    long clickTimeInMilliseconds = -1;
    long installBeginTimeInSeconds = -1;
    long clickTimeServerInSeconds = -1;
    long installBeginTimeServerInSeconds = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ActivityStateCopy {
        int eventCount;
        long lastInterval;
        String pushToken;
        int sessionCount;
        long sessionLength;
        int subsessionCount;
        long timeSpent;
        String uuid;

        ActivityStateCopy(ActivityState activityState) {
            this.eventCount = -1;
            this.sessionCount = -1;
            this.subsessionCount = -1;
            this.timeSpent = -1L;
            this.lastInterval = -1L;
            this.sessionLength = -1L;
            this.uuid = null;
            this.pushToken = null;
            if (activityState == null) {
                return;
            }
            this.eventCount = activityState.eventCount;
            this.sessionCount = activityState.sessionCount;
            this.subsessionCount = activityState.subsessionCount;
            this.timeSpent = activityState.timeSpent;
            this.lastInterval = activityState.lastInterval;
            this.sessionLength = activityState.sessionLength;
            this.uuid = activityState.uuid;
            this.pushToken = activityState.pushToken;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PackageBuilder(AdjustConfig adjustConfig, DeviceInfo deviceInfo, ActivityState activityState, SessionParameters sessionParameters, long j) {
        this.createdAt = j;
        this.deviceInfo = deviceInfo;
        this.adjustConfig = adjustConfig;
        this.activityStateCopy = new ActivityStateCopy(activityState);
        this.sessionParameters = sessionParameters;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (bool == null) {
            return;
        }
        addLong(map, str, bool.booleanValue() ? 1L : 0L);
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (date == null) {
            return;
        }
        addString(map, str, Util.dateFormatter.format(date));
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j) {
        if (j <= 0) {
            return;
        }
        addDate(map, str, new Date(j));
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j) {
        if (j <= 0) {
            return;
        }
        addDate(map, str, new Date(j * 1000));
    }

    private static void addDouble(Map<String, String> map, String str, Double d) {
        if (d == null) {
            return;
        }
        addString(map, str, Util.formatString("%.5f", d));
    }

    private static void addDuration(Map<String, String> map, String str, long j) {
        if (j < 0) {
            return;
        }
        addLong(map, str, (j + 500) / 1000);
    }

    static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        addString(map, str, jSONObject.toString());
    }

    public static void addLong(Map<String, String> map, String str, long j) {
        if (j < 0) {
            return;
        }
        addString(map, str, Long.toString(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addMapJson(Map<String, String> map, String str, Map map2) {
        if (map2 == null || map2.size() == 0) {
            return;
        }
        addString(map, str, new JSONObject(map2).toString());
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map == null || map.containsKey("mac_sha1") || map.containsKey("mac_md5") || map.containsKey("android_id") || map.containsKey("gps_adid") || map.containsKey("oaid") || map.containsKey("imei") || map.containsKey("meid") || map.containsKey(a.o) || map.containsKey("imeis") || map.containsKey("meids") || map.containsKey("device_ids")) {
            return;
        }
        logger.error("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
    }

    private boolean containsFireIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("fire_adid");
    }

    private boolean containsPlayIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(String str, JSONObject jSONObject) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addLong(hashMap, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addDuration(hashMap, "last_interval", this.activityStateCopy.lastInterval);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", true);
        addLong(hashMap, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addString(hashMap, "source", str);
        addJsonObject(hashMap, "payload", jSONObject);
        addLong(hashMap, "session_count", this.activityStateCopy.sessionCount);
        addDuration(hashMap, "session_length", this.activityStateCopy.sessionLength);
        addLong(hashMap, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(hashMap, "time_spent", this.activityStateCopy.timeSpent);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getAttributionParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "initiated_by", str);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getClickParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(hashMap, "tracker", adjustAttribution.trackerName);
            addString(hashMap, "campaign", this.attribution.campaign);
            addString(hashMap, "adgroup", this.attribution.adgroup);
            addString(hashMap, "creative", this.attribution.creative);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
        addDateInMilliseconds(hashMap, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(hashMap, "click_time", this.clickTimeInSeconds);
        addDateInSeconds(hashMap, "click_time_server", this.clickTimeServerInSeconds);
        addLong(hashMap, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, Constants.DEEPLINK, this.deeplink);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addBoolean(hashMap, "google_play_instant", this.googlePlayInstant);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addDateInSeconds(hashMap, "install_begin_time", this.installBeginTimeInSeconds);
        addDateInSeconds(hashMap, "install_begin_time_server", this.installBeginTimeServerInSeconds);
        addString(hashMap, "install_version", this.installVersion);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addDuration(hashMap, "last_interval", this.activityStateCopy.lastInterval);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", true);
        addLong(hashMap, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addMapJson(hashMap, "params", this.extraParameters);
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "raw_referrer", this.rawReferrer);
        addString(hashMap, Constants.REFERRER, this.referrer);
        addString(hashMap, "referrer_api", this.referrerApi);
        addString(hashMap, Constants.REFTAG, this.reftag);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, "session_count", this.activityStateCopy.sessionCount);
        addDuration(hashMap, "session_length", this.activityStateCopy.sessionLength);
        addString(hashMap, "source", str);
        addLong(hashMap, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(hashMap, "time_spent", this.activityStateCopy.timeSpent);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, "payload", this.preinstallPayload);
        addString(hashMap, "found_location", this.preinstallLocation);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private Map<String, String> getDisableThirdPartySharingParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        return adjustEvent.revenue == null ? Util.formatString("'%s'", adjustEvent.eventToken) : Util.formatString("(%.5f %s, '%s')", adjustEvent.revenue, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getInfoParameters(String str) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addString(hashMap, "source", str);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getMeasurementConsentParameters(boolean z) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        addString(hashMap, "measurement", z ? "enable" : "disable");
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSessionParameters(boolean z) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (!z) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addLong(hashMap, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addDuration(hashMap, "last_interval", this.activityStateCopy.lastInterval);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", true);
        addLong(hashMap, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, "session_count", this.activityStateCopy.sessionCount);
        addDuration(hashMap, "session_length", this.activityStateCopy.sessionLength);
        addLong(hashMap, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(hashMap, "time_spent", this.activityStateCopy.timeSpent);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        if (!z) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addLong(hashMap, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "installed_at", this.deviceInfo.appInstallTime);
        addString(hashMap, "language", this.deviceInfo.language);
        addDuration(hashMap, "last_interval", this.activityStateCopy.lastInterval);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", true);
        addLong(hashMap, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, "session_count", this.activityStateCopy.sessionCount);
        addDuration(hashMap, "session_length", this.activityStateCopy.sessionLength);
        addLong(hashMap, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(hashMap, "time_spent", this.activityStateCopy.timeSpent);
        addString(hashMap, "updated_at", this.deviceInfo.appUpdateTime);
        addString(hashMap, "billing_store", adjustPlayStoreSubscription.getBillingStore());
        addString(hashMap, "currency", adjustPlayStoreSubscription.getCurrency());
        addString(hashMap, Product.KEY_ID, adjustPlayStoreSubscription.getSku());
        addString(hashMap, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(hashMap, g.e, adjustPlayStoreSubscription.getSignature());
        addLong(hashMap, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(hashMap, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(hashMap, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getThirdPartySharingParameters(AdjustThirdPartySharing adjustThirdPartySharing) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (adjustThirdPartySharing.isEnabled != null) {
            addString(hashMap, "sharing", adjustThirdPartySharing.isEnabled.booleanValue() ? "enable" : "disable");
        }
        addMapJson(hashMap, "granular_third_party_sharing_options", adjustThirdPartySharing.granularOptions);
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", true);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildAdRevenuePackage(String str, JSONObject jSONObject) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(str, jSONObject);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.AD_REVENUE);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(adRevenueParameters, ActivityKind.AD_REVENUE.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(adRevenueParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.ATTRIBUTION);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(attributionParameters, ActivityKind.ATTRIBUTION.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.CLICK);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        defaultActivityPackage.setClickTimeServerInSeconds(this.clickTimeServerInSeconds);
        defaultActivityPackage.setInstallBeginTimeServerInSeconds(this.installBeginTimeServerInSeconds);
        defaultActivityPackage.setInstallVersion(this.installVersion);
        defaultActivityPackage.setGooglePlayInstant(this.googlePlayInstant);
        AdjustSigner.sign(clickParameters, ActivityKind.CLICK.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildDisableThirdPartySharingPackage() {
        Map<String, String> disableThirdPartySharingParameters = getDisableThirdPartySharingParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.DISABLE_THIRD_PARTY_SHARING);
        defaultActivityPackage.setPath("/disable_third_party_sharing");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(disableThirdPartySharingParameters, ActivityKind.DISABLE_THIRD_PARTY_SHARING.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(disableThirdPartySharingParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildEventPackage(AdjustEvent adjustEvent, boolean z) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent, z);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.EVENT);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        AdjustSigner.sign(eventParameters, ActivityKind.EVENT.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(eventParameters);
        if (z) {
            defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
            defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        }
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.GDPR);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(gdprParameters, ActivityKind.GDPR.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.INFO);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(infoParameters, ActivityKind.INFO.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildMeasurementConsentPackage(boolean z) {
        Map<String, String> measurementConsentParameters = getMeasurementConsentParameters(z);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.MEASUREMENT_CONSENT);
        defaultActivityPackage.setPath("/measurement_consent");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(measurementConsentParameters, ActivityKind.MEASUREMENT_CONSENT.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(measurementConsentParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildSessionPackage(boolean z) {
        Map<String, String> sessionParameters = getSessionParameters(z);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SESSION);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(sessionParameters, ActivityKind.SESSION.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(sessionParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription, z);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SUBSCRIPTION);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(subscriptionParameters, ActivityKind.SUBSCRIPTION.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityPackage buildThirdPartySharingPackage(AdjustThirdPartySharing adjustThirdPartySharing) {
        Map<String, String> thirdPartySharingParameters = getThirdPartySharingParameters(adjustThirdPartySharing);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.THIRD_PARTY_SHARING);
        defaultActivityPackage.setPath("/third_party_sharing");
        defaultActivityPackage.setSuffix("");
        AdjustSigner.sign(thirdPartySharingParameters, ActivityKind.THIRD_PARTY_SHARING.toString(), defaultActivityPackage.getClientSdk(), this.adjustConfig.context, this.adjustConfig.logger);
        defaultActivityPackage.setParameters(thirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent, boolean z) {
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Reflection.getImeiParameters(this.adjustConfig.context, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Reflection.getOaidParameters(this.adjustConfig.context, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (!z) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        addString(hashMap, "android_uuid", this.activityStateCopy.uuid);
        addString(hashMap, "gps_adid", this.deviceInfo.playAdId);
        addLong(hashMap, "gps_adid_attempt", this.deviceInfo.playAdIdAttempt);
        addString(hashMap, "gps_adid_src", this.deviceInfo.playAdIdSource);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(contentResolver));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(contentResolver));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.reloadNonPlayIds(this.adjustConfig.context);
            addString(hashMap, "android_id", this.deviceInfo.androidId);
            addString(hashMap, "mac_md5", this.deviceInfo.macShortMd5);
            addString(hashMap, "mac_sha1", this.deviceInfo.macSha1);
        }
        addString(hashMap, "api_level", this.deviceInfo.apiLevel);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, "app_token", this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.appVersion);
        addBoolean(hashMap, "attribution_deeplink", true);
        addLong(hashMap, "connectivity_type", Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.country);
        addString(hashMap, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "currency", adjustEvent.currency);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(hashMap, "device_name", this.deviceInfo.deviceName);
        addString(hashMap, "device_type", this.deviceInfo.deviceType);
        addString(hashMap, "display_height", this.deviceInfo.displayHeight);
        addString(hashMap, "display_width", this.deviceInfo.displayWidth);
        addString(hashMap, "environment", this.adjustConfig.environment);
        addString(hashMap, "event_callback_id", adjustEvent.callbackId);
        addLong(hashMap, "event_count", this.activityStateCopy.eventCount);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "event_token", adjustEvent.eventToken);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.fbAttributionId);
        addString(hashMap, "hardware_name", this.deviceInfo.hardwareName);
        addString(hashMap, "language", this.deviceInfo.language);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", true);
        addLong(hashMap, "network_type", Util.getNetworkType(this.adjustConfig.context));
        addString(hashMap, "os_build", this.deviceInfo.buildName);
        addString(hashMap, "os_name", this.deviceInfo.osName);
        addString(hashMap, "os_version", this.deviceInfo.osVersion);
        addString(hashMap, "package_name", this.deviceInfo.packageName);
        addString(hashMap, "push_token", this.activityStateCopy.pushToken);
        addDouble(hashMap, "revenue", adjustEvent.revenue);
        addString(hashMap, "screen_density", this.deviceInfo.screenDensity);
        addString(hashMap, "screen_format", this.deviceInfo.screenFormat);
        addString(hashMap, "screen_size", this.deviceInfo.screenSize);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, "session_count", this.activityStateCopy.sessionCount);
        addDuration(hashMap, "session_length", this.activityStateCopy.sessionLength);
        addLong(hashMap, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(hashMap, "time_spent", this.activityStateCopy.timeSpent);
        checkDeviceIds(hashMap);
        return hashMap;
    }
}
