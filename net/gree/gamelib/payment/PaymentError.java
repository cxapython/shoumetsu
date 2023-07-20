package net.gree.gamelib.payment;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class PaymentError {
    public static final int ERROR_CODE_AUTHORIZE_ERROR = 2001;
    public static final int ERROR_CODE_AUTHORIZE_INIT_ERROR = 1001;
    public static final int ERROR_CODE_CLEAR_3RD_PARTY_ACCOUNT_ERROR = 8061;
    public static final int ERROR_CODE_CLEAR_3RD_PARTY_ACCOUNT_INVALID_ACCESS_TOKEN = 8062;
    public static final int ERROR_CODE_CLEAR_3RD_PARTY_ACCOUNT_NOT_REGISTERED_USER_ACCOUNT = 8063;
    public static final int ERROR_CODE_COMMON_ALREADY_RECIEVED_SAME_REQUEST = 13;
    public static final int ERROR_CODE_COMMON_APP_VERSION_IS_OLD = 3;
    public static final int ERROR_CODE_COMMON_AUTHORIZE_APP_ERROR = 10;
    public static final int ERROR_CODE_COMMON_AUTHORIZE_SERVER_ERROR = 12;
    public static final int ERROR_CODE_COMMON_AUTHORIZE_USER_ERROR = 11;
    public static final int ERROR_CODE_COMMON_INTERNAL_CLIENT_ERROR = 17220;
    public static final int ERROR_CODE_COMMON_INTERNAL_SERVER_ERROR = 19;
    public static final int ERROR_CODE_COMMON_INVALID_APPLICATION_STATUS = 17;
    public static final int ERROR_CODE_COMMON_INVALID_AUTHORIZATION_HEADER = 6;
    public static final int ERROR_CODE_COMMON_INVALID_BODY_HASH = 16;
    public static final int ERROR_CODE_COMMON_INVALID_GAMELIB_HEADER = 9;
    public static final int ERROR_CODE_COMMON_INVALID_HTTP_METHOD = 8;
    public static final int ERROR_CODE_COMMON_INVALID_JSON = 7;
    public static final int ERROR_CODE_COMMON_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_COMMON_INVALID_SERVER_INFO = 5;
    public static final int ERROR_CODE_COMMON_INVALID_SIGNATURE = 4;
    public static final int ERROR_CODE_COMMON_INVALID_USER_STATUS = 14;
    public static final int ERROR_CODE_COMMON_JSON_PARSING_ERROR = 2000;
    public static final int ERROR_CODE_COMMON_MIGRATED_DEVICE = 20;
    public static final int ERROR_CODE_COMMON_MISSING_PARAMETER = 2;
    public static final int ERROR_CODE_COMMON_NETWORK_ERROR = 1000;
    public static final int ERROR_CODE_COMMON_NOT_EXIST_APPLICATION = 18;
    public static final int ERROR_CODE_COMMON_NOT_EXIST_USER = 15;
    public static final int ERROR_CODE_COMMON_PAYMENT_API_TOKEN_CHECK_ERROR = 10003;
    public static final int ERROR_CODE_COMMON_PAYMENT_INACTIVATED_USER = 10007;
    public static final int ERROR_CODE_COMMON_PAYMENT_INVALID_PARAMETER = 10001;
    public static final int ERROR_CODE_COMMON_PAYMENT_INVALID_REGION = 10004;
    public static final int ERROR_CODE_COMMON_PAYMENT_INVALID_SCHEME = 10005;
    public static final int ERROR_CODE_COMMON_PAYMENT_MISSION_PARAMETER = 10002;
    public static final int ERROR_CODE_COMMON_PAYMENT_UNDER_MAINTENANCE = 10006;
    public static final int ERROR_CODE_COMMON_PROCESSING_IS_PROGRESS = 17219;
    public static final int ERROR_CODE_GET_PURCHASE_ALERT_SETTING_ERROR = 32001;
    public static final int ERROR_CODE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR = 40000;
    public static final int ERROR_CODE_MIGRATION_ERROR = 8001;
    public static final int ERROR_CODE_MIGRATION_EXPIRED_TOKEN = 8003;
    public static final int ERROR_CODE_MIGRATION_INCORRECT_TOKEN = 8002;
    public static final int ERROR_CODE_MIGRATION_USER_LOCKED = 8004;
    public static final int ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND = 17217;
    public static final int ERROR_CODE_PAYMENT_SERVICE_UNAVAILABLE = 17214;
    public static final int ERROR_CODE_QUERY_3RD_PARTY_ACCOUNT_ERROR = 8031;
    public static final int ERROR_CODE_QUERY_BALANCE_ERROR = 11001;
    public static final int ERROR_CODE_QUERY_BALANCE_LIST_ERROR = 12001;
    public static final int ERROR_CODE_QUERY_COUNTRY_ERROR = 26001;
    public static final int ERROR_CODE_QUERY_COUNTRY_UNKNOWN_COUNTRY = 26002;
    public static final int ERROR_CODE_QUERY_DEFAULT_PRODUCT_LIST_ERROR = 27001;
    public static final int ERROR_CODE_QUERY_ORDER_ERROR = 16004;
    public static final int ERROR_CODE_QUERY_ORDER_EXCEEDED_MAX_AMOUNT = 16002;
    public static final int ERROR_CODE_QUERY_ORDER_EXCEEDED_MAX_GEM_BALANCE = 16005;
    public static final int ERROR_CODE_QUERY_ORDER_EXPIRED_TICKET = 16008;
    public static final int ERROR_CODE_QUERY_ORDER_NOT_SUPPORTED_COUNTRY = 16007;
    public static final int ERROR_CODE_QUERY_ORDER_PRODUCT_ID_NOT_EXIST = 16001;
    public static final int ERROR_CODE_QUERY_ORDER_REFUSED_IN_CLOSED_APP = 16006;
    public static final int ERROR_CODE_QUERY_ORDER_TICKET_OVER_MAX_VALID_DAYS = 16009;
    public static final int ERROR_CODE_QUERY_PRODUCT_LIST_ERROR = 15001;
    public static final int ERROR_CODE_QUERY_PURCHASE_ALERT_ERROR = 30002;
    public static final int ERROR_CODE_QUERY_PURCHASE_ALERT_NOT_SUPPORTED_COUNTRY = 30004;
    public static final int ERROR_CODE_QUERY_PURCHASE_ALERT_PRODUCT_ID_NOT_EXIST = 30001;
    public static final int ERROR_CODE_QUERY_PURCHASE_ALERT_REFUSED_IN_CLOSED_APP = 30003;
    public static final int ERROR_CODE_QUERY_TICKET_STATUS_ERROR = 28001;
    public static final int ERROR_CODE_QUERY_TICKET_STATUS_GET_AMENITY_FAILED = 28002;
    public static final int ERROR_CODE_QUERY_TRANSACTION_HISTORY_ERROR = 13001;
    public static final int ERROR_CODE_QUERY_XUID_ERROR = 3001;
    public static final int ERROR_CODE_REGISTER_3RD_PARTY_ACCOUNT_ALREADY_REGISTERED_ACCOUNT = 8044;
    public static final int ERROR_CODE_REGISTER_3RD_PARTY_ACCOUNT_ALREADY_REGISTERED_UUID = 8043;
    public static final int ERROR_CODE_REGISTER_3RD_PARTY_ACCOUNT_ERROR = 8041;
    public static final int ERROR_CODE_REGISTER_3RD_PARTY_ACCOUNT_INVALID_ACCESS_TOKEN = 8042;
    public static final int ERROR_CODE_REGISTER_AGE_CHANGE_ADULT_TO_MINOR = 21005;
    public static final int ERROR_CODE_REGISTER_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY = 21001;
    public static final int ERROR_CODE_REGISTER_AGE_ERROR = 21002;
    public static final int ERROR_CODE_REGISTER_AGE_UPDATE_MINOR_USER_BIRTHDAY = 21004;
    public static final int ERROR_CODE_REGISTER_MIGRATION_ACCOUNT_ERROR = 8021;
    public static final int ERROR_CODE_REGISTER_MIGRATION_ACCOUNT_INVALID_ACCOUNT = 8022;
    public static final int ERROR_CODE_REGISTER_XUID_ERROR = 4001;
    public static final int ERROR_CODE_REGISTER_XUID_REGISTERED_AS_OTHER_UUID = 4004;
    public static final int ERROR_CODE_REGISTER_XUID_REGISTERED_UUID = 4003;
    public static final int ERROR_CODE_REGISTER_XUID_REGISTERED_UUID_XUID = 4002;
    public static final int ERROR_CODE_REQUEST_MIGRATION_CODE_CAN_NOT_RENEW = 5002;
    public static final int ERROR_CODE_REQUEST_MIGRATION_CODE_ERROR = 5001;
    public static final int ERROR_CODE_REQUEST_MIGRATION_PASSWORD_CODE_NOT_EXIST = 6002;
    public static final int ERROR_CODE_REQUEST_MIGRATION_PASSWORD_ERROR = 6001;
    public static final int ERROR_CODE_RESTORE_ORDER_NO_REMAIN_ORDER = 17000;
    public static final int ERROR_CODE_SUBMIT_CANCELED = 17100;
    public static final int ERROR_CODE_SUBMIT_DUMP_INVALID_PURCHASE = 17006;
    public static final int ERROR_CODE_SUBMIT_DUPLICATE_PURCHASE_ID = 17002;
    public static final int ERROR_CODE_SUBMIT_ERROR = 17005;
    public static final int ERROR_CODE_SUBMIT_FAMILY_DEFFERED = 17007;
    public static final int ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID = 17213;
    public static final int ERROR_CODE_SUBMIT_INVALID_RECEIPT = 17003;
    public static final int ERROR_CODE_SUBMIT_PRODUCT_ID_IS_NOT_EXIST = 17001;
    public static final int ERROR_CODE_SUBMIT_RECEIPT_VERIFICATION = 17004;
    public static final int ERROR_CODE_UNREGISTER_3RD_PARTY_ACCOUNT_ALREADY_UNREGISTERED = 8052;
    public static final int ERROR_CODE_UNREGISTER_3RD_PARTY_ACCOUNT_ERROR = 8051;
    public static final int ERROR_CODE_UPDATE_PURCHASE_ALERT_SETTING_ERROR = 31001;
    public static final int ERROR_CODE_UPDATE_USER_TOKEN_ERROR = 8011;
    public static final int ERROR_CODE_UPDATE_USER_TOKEN_INVALID_USER = 8012;
    public static final int ERROR_CODE_VERIFY_3RD_PARTY_ACCOUNT_ERROR = 8071;
    public static final int ERROR_CODE_VERIFY_3RD_PARTY_ACCOUNT_INVALID_ACCESS_TOKEN = 8072;
    public static final int ERROR_CODE_VERIFY_3RD_PARTY_ACCOUNT_LOCKED = 8074;
    public static final int ERROR_CODE_VERIFY_3RD_PARTY_ACCOUNT_NOT_REGISTERED_USER_ACCOUNT = 8073;
    public static final int ERROR_CODE_VERIFY_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY = 20001;
    public static final int ERROR_CODE_VERIFY_AGE_ERROR = 20002;
    public static final int ERROR_CODE_VERIFY_MIGRATION_CODE_NOT_EXIST = 7002;
    public static final int ERROR_CODE_VERIFY_MIGRATION_ERROR = 7001;
    public static final int ERROR_CODE_VERIFY_MIGRATION_INCORRECT_PASSWORD = 7004;
    public static final int ERROR_CODE_VERIFY_MIGRATION_LOCKED = 7005;
    public static final int ERROR_CODE_VERIFY_MIGRATION_PASSWORD_NOT_EXIST = 7003;
    public static final int ERROR_CODE_VERIFY_MIGRATION_USER_ACCOUNT_ERROR = 7011;
    public static final int ERROR_CODE_VERIFY_MIGRATION_USER_ACCOUNT_LOCKED = 7013;
    public static final int ERROR_CODE_VERIFY_MIGRATION_USER_ACCOUNT_PASSWORD = 7012;
    public static final int ERROR_CODE_XUID_NOT_REGISTERED = 3000;
    public static final int ERROR_LEVEL_ERROR = 2;
    public static final int ERROR_LEVEL_INFO = 0;
    public static final int ERROR_LEVEL_WARNING = 1;
    public static final int ERROR_LOCATION_CLIENT = 0;
    public static final int ERROR_LOCATION_SERVER = 1;
    public static final String ERROR_MESSAGE_AU_SERVICE_BIND = "au Service Bind Error";
    public static final String ERROR_MESSAGE_COMMON_INTERNAL_CLIENT_ERROR = "Internal Client Error";
    public static final String ERROR_MESSAGE_COMMON_JSON_PARSING_ERROR = "Failed to parse JSON";
    public static final String ERROR_MESSAGE_COMMON_NETWORK_ERROR = "Network error";
    public static final String ERROR_MESSAGE_COMMON_PROCESSING_IS_PROGRESS = "The process is already in progress";
    public static final String ERROR_MESSAGE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR = "Not found Auth info in local storage";
    public static final String ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND = "Local History DB is not found";
    public static final String ERROR_MESSAGE_PAYMENT_NOT_INITIALIZED = "Payment.initialize must be called.";
    public static final String ERROR_MESSAGE_PAYMENT_SERVICE_UNAVAILABLE = "Payment service is unavailable";
    public static final String ERROR_MESSAGE_REGISTER_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY = "Contradict between age_group and birthday";
    public static final String ERROR_MESSAGE_REGISTER_AGE_UPDATE_MINOR_USER_BIRTHDAY = "Prohibited updating minor user birthday";
    public static final String ERROR_MESSAGE_RESTORE_ORDER_NO_REMAIN_ORDER = "There is no remain order";
    public static final String ERROR_MESSAGE_SUBMIT_CANCELED = "The payment transaction is cancelled";
    public static final String ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID = "ProductIdentifier is invalid";
    public static final String ERROR_MESSAGE_VERIFY_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY = "Contradict between age_group and birthday";
    public static final String ERROR_MESSAGE_XUID_NOT_REGISTERED = "Xuid has not been registerd yet";
    protected static final SparseIntArray mErrorLevelMap;
    protected static final SparseIntArray mErrorLocationMap;
    protected static final SparseArray<String> mErrorMessgeMap = new SparseArray<>();
    protected int mErrorCode;
    protected int mErrorLevel;
    protected int mErrorLocation;
    protected String mErrorMessage;

    static {
        mErrorMessgeMap.append(1000, "Network error");
        mErrorMessgeMap.append(2000, ERROR_MESSAGE_COMMON_JSON_PARSING_ERROR);
        mErrorMessgeMap.append(17219, "The process is already in progress");
        mErrorMessgeMap.append(17220, ERROR_MESSAGE_COMMON_INTERNAL_CLIENT_ERROR);
        mErrorMessgeMap.append(ERROR_CODE_RESTORE_ORDER_NO_REMAIN_ORDER, ERROR_MESSAGE_RESTORE_ORDER_NO_REMAIN_ORDER);
        mErrorMessgeMap.append(ERROR_CODE_SUBMIT_CANCELED, ERROR_MESSAGE_SUBMIT_CANCELED);
        mErrorMessgeMap.append(ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID);
        mErrorMessgeMap.append(ERROR_CODE_PAYMENT_SERVICE_UNAVAILABLE, ERROR_MESSAGE_PAYMENT_SERVICE_UNAVAILABLE);
        mErrorMessgeMap.append(ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND);
        mErrorMessgeMap.append(ERROR_CODE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR, ERROR_MESSAGE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR);
        mErrorLevelMap = new SparseIntArray();
        mErrorLevelMap.append(1, 1);
        mErrorLevelMap.append(14, 1);
        mErrorLevelMap.append(20, 1);
        mErrorLevelMap.append(1000, 1);
        mErrorLevelMap.append(17219, 1);
        mErrorLevelMap.append(10001, 1);
        mErrorLevelMap.append(10006, 1);
        mErrorLevelMap.append(10007, 1);
        mErrorLevelMap.append(3000, 1);
        mErrorLevelMap.append(7002, 1);
        mErrorLevelMap.append(7003, 1);
        mErrorLevelMap.append(7004, 1);
        mErrorLevelMap.append(7005, 1);
        mErrorLevelMap.append(ERROR_CODE_VERIFY_MIGRATION_USER_ACCOUNT_PASSWORD, 1);
        mErrorLevelMap.append(ERROR_CODE_VERIFY_MIGRATION_USER_ACCOUNT_LOCKED, 1);
        mErrorLevelMap.append(8004, 1);
        mErrorLevelMap.append(ERROR_CODE_REGISTER_MIGRATION_ACCOUNT_INVALID_ACCOUNT, 1);
        mErrorLevelMap.append(ERROR_CODE_QUERY_ORDER_EXCEEDED_MAX_AMOUNT, 1);
        mErrorLevelMap.append(ERROR_CODE_QUERY_ORDER_EXCEEDED_MAX_GEM_BALANCE, 1);
        mErrorLevelMap.append(ERROR_CODE_QUERY_ORDER_NOT_SUPPORTED_COUNTRY, 1);
        mErrorLevelMap.append(ERROR_CODE_QUERY_ORDER_EXPIRED_TICKET, 1);
        mErrorLevelMap.append(ERROR_CODE_QUERY_ORDER_TICKET_OVER_MAX_VALID_DAYS, 1);
        mErrorLevelMap.append(ERROR_CODE_SUBMIT_DUPLICATE_PURCHASE_ID, 1);
        mErrorLevelMap.append(ERROR_CODE_SUBMIT_FAMILY_DEFFERED, 1);
        mErrorLevelMap.append(ERROR_CODE_SUBMIT_CANCELED, 1);
        mErrorLevelMap.append(ERROR_CODE_VERIFY_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY, 1);
        mErrorLevelMap.append(ERROR_CODE_REGISTER_AGE_CONTRADICT_AGE_GROUP_BIRTHDAY, 1);
        mErrorLevelMap.append(ERROR_CODE_REGISTER_AGE_UPDATE_MINOR_USER_BIRTHDAY, 1);
        mErrorLocationMap = new SparseIntArray();
        mErrorLocationMap.append(1000, 0);
        mErrorLocationMap.append(2000, 0);
        mErrorLocationMap.append(17219, 0);
        mErrorLocationMap.append(17220, 0);
        mErrorLocationMap.append(ERROR_CODE_RESTORE_ORDER_NO_REMAIN_ORDER, 0);
        mErrorLocationMap.append(ERROR_CODE_SUBMIT_CANCELED, 0);
        mErrorLocationMap.append(ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, 0);
        mErrorLocationMap.append(ERROR_CODE_PAYMENT_SERVICE_UNAVAILABLE, 0);
        mErrorLocationMap.append(ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, 0);
        mErrorLocationMap.append(ERROR_CODE_LOGIN_LOCAL_AUTH_NOT_FOUND_ERROR, 0);
    }

    public PaymentError(int i) {
        this(i, mErrorMessgeMap.get(i, ""));
    }

    public PaymentError(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
        this.mErrorLevel = mErrorLevelMap.get(this.mErrorCode, 2);
        this.mErrorLocation = mErrorLocationMap.get(this.mErrorCode, 1);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getErrorLevel() {
        return this.mErrorLevel;
    }

    public int getErrorLocation() {
        return this.mErrorLocation;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }
}
