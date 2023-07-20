package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.R;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class ConnectionErrorMessages {
    @GuardedBy("sCache")
    private static final androidx.b.g<String, String> a = new androidx.b.g<>();

    private ConnectionErrorMessages() {
    }

    private static String a(Context context, String str) {
        synchronized (a) {
            String str2 = a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                a.put(str, string);
                return string;
            }
            String valueOf2 = String.valueOf(str);
            Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
            return null;
        }
    }

    private static String a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a2 = a(context, str);
        if (a2 == null) {
            a2 = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a2, str2);
    }

    public static String getAppName(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        return context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
    }

    public static String getErrorDialogButtonMessage(Context context, int i) {
        int i2;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = com.google.android.gms.base.R.string.common_google_play_services_install_button;
                break;
            case 2:
                i2 = com.google.android.gms.base.R.string.common_google_play_services_update_button;
                break;
            case 3:
                i2 = com.google.android.gms.base.R.string.common_google_play_services_enable_button;
                break;
            default:
                i2 = 17039370;
                break;
        }
        return resources.getString(i2);
    }

    public static String getErrorMessage(Context context, int i) {
        Resources resources = context.getResources();
        String appName = getAppName(context);
        if (i != 5) {
            if (i == 7) {
                return a(context, "common_google_play_services_network_error_text", appName);
            }
            if (i == 9) {
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_unsupported_text, appName);
            }
            if (i == 20) {
                return a(context, "common_google_play_services_restricted_profile_text", appName);
            }
            switch (i) {
                case 1:
                    return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_text, appName);
                case 2:
                    return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(com.google.android.gms.base.R.string.common_google_play_services_wear_update_text) : resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_text, appName);
                case 3:
                    return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_text, appName);
                default:
                    switch (i) {
                        case 16:
                            return a(context, "common_google_play_services_api_unavailable_text", appName);
                        case 17:
                            return a(context, "common_google_play_services_sign_in_failed_text", appName);
                        case 18:
                            return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_updating_text, appName);
                        default:
                            return resources.getString(R.string.common_google_play_services_unknown_issue, appName);
                    }
            }
        }
        return a(context, "common_google_play_services_invalid_account_text", appName);
    }

    public static String getErrorNotificationMessage(Context context, int i) {
        return i == 6 ? a(context, "common_google_play_services_resolution_required_text", getAppName(context)) : getErrorMessage(context, i);
    }

    public static String getErrorNotificationTitle(Context context, int i) {
        String a2 = i == 6 ? a(context, "common_google_play_services_resolution_required_title") : getErrorTitle(context, i);
        return a2 == null ? context.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_ticker) : a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getErrorTitle(Context context, int i) {
        String str;
        String str2;
        Resources resources = context.getResources();
        if (i == 20) {
            Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
            return a(context, "common_google_play_services_restricted_profile_title");
        }
        switch (i) {
            case 1:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return a(context, "common_google_play_services_network_error_title");
            case 8:
                str = "GoogleApiAvailability";
                str2 = "Internal error occurred. Please see logs for detailed information";
                Log.e(str, str2);
                return null;
            case 9:
                str = "GoogleApiAvailability";
                str2 = "Google Play services is invalid. Cannot recover.";
                Log.e(str, str2);
                return null;
            case 10:
                str = "GoogleApiAvailability";
                str2 = "Developer error occurred. Please see logs for detailed information";
                Log.e(str, str2);
                return null;
            case 11:
                str = "GoogleApiAvailability";
                str2 = "The application is not licensed to the user.";
                Log.e(str, str2);
                return null;
            default:
                switch (i) {
                    case 16:
                        str = "GoogleApiAvailability";
                        str2 = "One of the API components you attempted to connect to is not available.";
                        Log.e(str, str2);
                        return null;
                    case 17:
                        Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                        return a(context, "common_google_play_services_sign_in_failed_title");
                    case 18:
                        break;
                    default:
                        str = "GoogleApiAvailability";
                        StringBuilder sb = new StringBuilder(33);
                        sb.append("Unexpected error code ");
                        sb.append(i);
                        str2 = sb.toString();
                        Log.e(str, str2);
                        return null;
                }
        }
    }
}
