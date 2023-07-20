package com.adjust.sdk;

/* loaded from: classes.dex */
public interface Constants {
    public static final String ACTIVITY_STATE_FILENAME = "AdjustIoActivityState";
    public static final String ADJUST_PREINSTALL_CONTENT_PROVIDER_INTENT_ACTION = "com.attribution.REFERRAL_PROVIDER";
    public static final String ADJUST_PREINSTALL_CONTENT_URI_AUTHORITY = "com.adjust.preinstall";
    public static final String ADJUST_PREINSTALL_CONTENT_URI_PATH = "trackers";
    public static final String ADJUST_PREINSTALL_FILE_SYSTEM_PATH = "/data/local/tmp/adjust.preinstall";
    public static final String ADJUST_PREINSTALL_SYSTEM_PROPERTY_PATH = "adjust.preinstall.path";
    public static final String ADJUST_PREINSTALL_SYSTEM_PROPERTY_PREFIX = "adjust.preinstall.";
    public static final String ATTRIBUTION_FILENAME = "AdjustAttribution";
    public static final String AUTHORITY = "app.adjust.com";
    public static final String BASE_URL = "https://app.adjust.com";
    public static final String CALLBACK_PARAMETERS = "callback_params";
    public static final String CLIENT_SDK = "android4.27.0";
    public static final int CONNECTION_TIMEOUT = 60000;
    public static final String CONTENT_PROVIDER = "content_provider";
    public static final String CONTENT_PROVIDER_INTENT_ACTION = "content_provider_intent_action";
    public static final String CONTENT_PROVIDER_NO_PERMISSION = "content_provider_no_permission";
    public static final String DEEPLINK = "deeplink";
    public static final String ENCODING = "UTF-8";
    public static final String FB_AUTH_REGEX = "^(fb|vk)[0-9]{5,}[^:]*://authorize.*access_token=.*";
    public static final String FILE_SYSTEM = "file_system";
    public static final String GDPR_URL = "https://gdpr.adjust.com";
    public static final String HIGH = "high";
    public static final String INSTALL_REFERRER = "install_referrer";
    public static final String LARGE = "large";
    public static final String LOGTAG = "Adjust";
    public static final String LONG = "long";
    public static final String LOW = "low";
    public static final String MALFORMED = "malformed";
    public static final int MAX_INSTALL_REFERRER_RETRIES = 2;
    public static final int MAX_WAIT_INTERVAL = 60000;
    public static final String MD5 = "MD5";
    public static final String MEDIUM = "medium";
    public static final int MINIMAL_ERROR_STATUS_CODE = 400;
    public static final String NORMAL = "normal";
    public static final int ONE_HOUR = 3600000;
    public static final int ONE_MINUTE = 60000;
    public static final int ONE_SECOND = 1000;
    public static final String PARTNER_PARAMETERS = "partner_params";
    public static final String PREINSTALL = "preinstall";
    public static final String PUSH = "push";
    public static final String REFERRER = "referrer";
    public static final String REFERRER_API_GOOGLE = "google";
    public static final String REFERRER_API_HUAWEI = "huawei";
    public static final String REFTAG = "reftag";
    public static final String SCHEME = "https";
    public static final String SESSION_CALLBACK_PARAMETERS_FILENAME = "AdjustSessionCallbackParameters";
    public static final String SESSION_PARTNER_PARAMETERS_FILENAME = "AdjustSessionPartnerParameters";
    public static final String SHA1 = "SHA-1";
    public static final String SHA256 = "SHA-256";
    public static final String SMALL = "small";
    public static final int SOCKET_TIMEOUT = 60000;
    public static final String SUBSCRIPTION_URL = "https://subscription.adjust.com";
    public static final String SYSTEM_PROPERTIES = "system_properties";
    public static final String SYSTEM_PROPERTIES_PATH = "system_properties_path";
    public static final String SYSTEM_PROPERTIES_PATH_REFLECTION = "system_properties_path_reflection";
    public static final String SYSTEM_PROPERTIES_REFLECTION = "system_properties_reflection";
    public static final int THIRTY_MINUTES = 1800000;
    public static final String THREAD_PREFIX = "Adjust-";
    public static final String XLARGE = "xlarge";
}
