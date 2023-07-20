package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.f;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.drive.DriveFile;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class e {
    private static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context b;
    private final String c;
    @GuardedBy("this")
    private Bundle d;

    public e(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    private final int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.b.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.c);
            if (identifier != 0 && a(identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.c);
            if (identifier2 != 0 && a(identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = a().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !a(i)) {
            try {
                i = b(0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i == 0 || !a(i)) {
            return 17301651;
        }
        return i;
    }

    private final PendingIntent a(int i, Intent intent) {
        return PendingIntent.getBroadcast(this.b, i, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.b, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private final synchronized Bundle a() {
        if (this.d != null) {
            return this.d;
        }
        try {
            ApplicationInfo b = b(128);
            if (b != null && b.metaData != null) {
                this.d = b.metaData;
                return this.d;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    public static String a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static void a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    @TargetApi(26)
    private final boolean a(int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.b.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private final ApplicationInfo b(int i) {
        return this.b.getPackageManager().getApplicationInfo(this.c, i);
    }

    private final Integer b(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = a().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(androidx.core.a.a.c(this.b, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    public static boolean b(Bundle bundle) {
        return "1".equals(a(bundle, "gcm.n.e")) || a(bundle, "gcm.n.icon") != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object[] b(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String a2 = a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a2);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException unused) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_args");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(a2).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(a2);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    public static String c(Bundle bundle) {
        String a2 = a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(a2) ? a(bundle, "gcm.n.sound") : a2;
    }

    public static String c(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    @TargetApi(26)
    private final String c(String str) {
        String str2;
        String str3;
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        int i = 0;
        try {
            i = b(0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (i < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(str)) {
            if (notificationManager.getNotificationChannel(str) != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
            sb.append("Notification Channel requested (");
            sb.append(str);
            sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        String string = a().getString("com.google.firebase.messaging.default_notification_channel_id");
        if (TextUtils.isEmpty(string)) {
            str2 = "FirebaseMessaging";
            str3 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
        } else if (notificationManager.getNotificationChannel(string) != null) {
            return string;
        } else {
            str2 = "FirebaseMessaging";
            str3 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
        }
        Log.w(str2, str3);
        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") != null) {
            return "fcm_fallback_notification_channel";
        }
        notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.b.getString(this.b.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.c)), 3));
        return "fcm_fallback_notification_channel";
    }

    static Uri d(Bundle bundle) {
        String a2 = a(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(a2)) {
            a2 = a(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(a2)) {
            return Uri.parse(a2);
        }
        return null;
    }

    private final String d(Bundle bundle, String str) {
        String a2 = a(bundle, str);
        return !TextUtils.isEmpty(a2) ? a2 : e(bundle, str);
    }

    private final CharSequence e(Bundle bundle) {
        String d = d(bundle, "gcm.n.title");
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            return b(0).loadLabel(this.b.getPackageManager());
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return "";
        }
    }

    private final String e(Bundle bundle, String str) {
        String c = c(bundle, str);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        Resources resources = this.b.getResources();
        int identifier = resources.getIdentifier(c, "string", this.c);
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            String substring = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(str).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(str);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] b = b(bundle, str);
        if (b == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, b);
        } catch (MissingFormatArgumentException e) {
            String arrays = Arrays.toString(b);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e);
            return null;
        }
    }

    private static boolean f(Bundle bundle) {
        return bundle != null && "1".equals(bundle.getString("google.c.a.e"));
    }

    public final d a(Bundle bundle) {
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        f.d dVar = new f.d(this.b, c(a(bundle, "gcm.n.android_channel_id")));
        dVar.a(true);
        dVar.a(e(bundle));
        String d = d(bundle, "gcm.n.body");
        if (!TextUtils.isEmpty(d)) {
            dVar.b(d);
            dVar.a(new f.c().a(d));
        }
        dVar.a(a(a(bundle, "gcm.n.icon")));
        String c = c(bundle);
        PendingIntent pendingIntent = null;
        if (TextUtils.isEmpty(c)) {
            defaultUri = null;
        } else if (CookieSpecs.DEFAULT.equals(c) || this.b.getResources().getIdentifier(c, "raw", this.c) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            String str = this.c;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(c).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(c);
            defaultUri = Uri.parse(sb.toString());
        }
        if (defaultUri != null) {
            dVar.a(defaultUri);
        }
        String a2 = a(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(a2)) {
            launchIntentForPackage = new Intent(a2);
            launchIntentForPackage.setPackage(this.c);
            launchIntentForPackage.setFlags(DriveFile.MODE_READ_ONLY);
        } else {
            Uri d2 = d(bundle);
            if (d2 != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(this.c);
                launchIntentForPackage.setData(d2);
            } else {
                launchIntentForPackage = this.b.getPackageManager().getLaunchIntentForPackage(this.c);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.startsWith("google.c.")) {
                    it.remove();
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            for (String str2 : bundle2.keySet()) {
                if (str2.startsWith("gcm.n.") || str2.startsWith("gcm.notification.")) {
                    launchIntentForPackage.removeExtra(str2);
                }
            }
            activity = PendingIntent.getActivity(this.b, a.incrementAndGet(), launchIntentForPackage, 1073741824);
            if (f(bundle)) {
                Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                a(intent, bundle);
                intent.putExtra("pending_intent", activity);
                activity = a(a.incrementAndGet(), intent);
            }
        }
        dVar.a(activity);
        if (f(bundle)) {
            Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            a(intent2, bundle);
            pendingIntent = a(a.incrementAndGet(), intent2);
        }
        if (pendingIntent != null) {
            dVar.b(pendingIntent);
        }
        Integer b = b(a(bundle, "gcm.n.color"));
        if (b != null) {
            dVar.d(b.intValue());
        }
        String a3 = a(bundle, "gcm.n.tag");
        if (TextUtils.isEmpty(a3)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(uptimeMillis);
            a3 = sb2.toString();
        }
        return new d(dVar, a3, 0);
    }
}
