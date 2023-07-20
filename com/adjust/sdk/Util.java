package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return formatString("%0" + (bArr.length << 1) + "x", bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum r0, Enum r1) {
        return equalObject(r0, r1);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l, Long l2) {
        return equalObject(l, l2);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d, Double d2) {
        return (d == null || d2 == null) ? d == null && d2 == null : Double.doubleToLongBits(d.doubleValue()) == Double.doubleToLongBits(d2.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(final Context context, long j) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Object>() { // from class: com.adjust.sdk.Util.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                try {
                    return Reflection.getAdvertisingInfoObject(context);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, j);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static int getConnectivityType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            getLogger().warn("Couldn't read connectivity type (%s)", e.getMessage());
        }
        if (connectivityManager == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return connectivityManager.getActiveNetworkInfo().getType();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            return 1;
        }
        if (networkCapabilities.hasTransport(0)) {
            return 0;
        }
        if (networkCapabilities.hasTransport(3)) {
            return 3;
        }
        if (networkCapabilities.hasTransport(4)) {
            return 4;
        }
        if (networkCapabilities.hasTransport(2)) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return -1;
        }
        if (networkCapabilities.hasTransport(5)) {
            return 5;
        }
        return (Build.VERSION.SDK_INT >= 27 && networkCapabilities.hasTransport(6)) ? 6 : -1;
    }

    public static String getCpuAbi() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        return null;
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getGoogleAdId(Context context) {
        Object advertisingInfoObject;
        String str = null;
        try {
            GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
            if (googlePlayServicesInfo != null) {
                str = googlePlayServicesInfo.getGpsAdid();
            }
        } catch (Exception unused) {
        }
        return (str != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? str : getPlayAdId(context, advertisingInfoObject, 1000L);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.adjust.sdk.Util$5] */
    public static void getGoogleAdId(Context context, final OnDeviceIdsRead onDeviceIdsRead) {
        ILogger logger = AdjustFactory.getLogger();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            logger.debug("GoogleAdId being read in the foreground", new Object[0]);
            new AsyncTask<Context, Void, String>() { // from class: com.adjust.sdk.Util.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public String doInBackground(Context... contextArr) {
                    ILogger logger2 = AdjustFactory.getLogger();
                    String googleAdId = Util.getGoogleAdId(contextArr[0]);
                    logger2.debug("GoogleAdId read " + googleAdId, new Object[0]);
                    return googleAdId;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str) {
                    AdjustFactory.getLogger();
                    OnDeviceIdsRead.this.onGoogleAdIdRead(str);
                }
            }.execute(context);
            return;
        }
        logger.debug("GoogleAdId being read in the background", new Object[0]);
        String googleAdId = getGoogleAdId(context);
        logger.debug("GoogleAdId read " + googleAdId, new Object[0]);
        onDeviceIdsRead.onGoogleAdIdRead(googleAdId);
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT < 24 || (locales = configuration.getLocales()) == null || locales.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            return configuration.locale;
        }
        return locales.get(0);
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getMacAddress(Context context) {
        return MacAddressUtil.getMacAddress(context);
    }

    public static String getMcc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    public static String getMnc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
            return null;
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return Build.VERSION.SDK_INT >= 30 ? telephonyManager.getDataNetworkType() : telephonyManager.getNetworkType();
        } catch (Exception e) {
            getLogger().warn("Couldn't read network type (%s)", e.getMessage());
            return -1;
        }
    }

    public static String getPlayAdId(final Context context, final Object obj, long j) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<String>() { // from class: com.adjust.sdk.Util.2
            @Override // java.util.concurrent.Callable
            public String call() {
                return Reflection.getPlayAdId(context, obj);
            }
        }, j);
    }

    public static String getReasonString(String str, Throwable th) {
        return th != null ? formatString("%s: %s", str, th) : formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int indexOf = stringWriter2.indexOf("Caused by:");
        return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] split;
        if (str != null && str.contains("@") && (split = str.split("@")) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] split;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (split = sdkPrefix.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    public static long getWaitingTime(int i, BackoffStrategy backoffStrategy) {
        if (i < backoffStrategy.minRetries) {
            return 0L;
        }
        return (long) (Math.min(((long) Math.pow(2.0d, i - backoffStrategy.minRetries)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public static int hashDouble(Double d) {
        if (d == null) {
            return 0;
        }
        return d.hashCode();
    }

    public static int hashEnum(Enum r0) {
        if (r0 == null) {
            return 0;
        }
        return r0.hashCode();
    }

    public static int hashLong(Long l) {
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public static int hashObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static int hashString(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals("google")) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (!str.equals(Constants.REFERRER_API_HUAWEI)) {
            return false;
        }
        return isEqualHuaweiReferrerDetails(referrerDetails, activityState);
    }

    public static Boolean isPlayTrackingEnabled(final Context context, final Object obj, long j) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Boolean>() { // from class: com.adjust.sdk.Util.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            /* renamed from: call */
            public Boolean mo1call() {
                return Reflection.isPlayTrackingEnabled(context, obj);
            }
        }, j);
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String uri2;
        return uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0 || uri2.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        ILogger logger;
        String str4;
        Object[] objArr;
        if (str == null) {
            logger = getLogger();
            str4 = "%s parameter %s is missing";
            objArr = new Object[]{str3, str2};
        } else if (!str.equals("")) {
            return true;
        } else {
            logger = getLogger();
            str4 = "%s parameter %s is empty";
            objArr = new Object[]{str3, str2};
        }
        logger.error(str4, objArr);
        return false;
    }

    public static String md5(String str) {
        return hash(str, Constants.MD5);
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) hashMap.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return hashMap;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    private static double randomInRange(double d, double d2) {
        return (new Random().nextDouble() * (d2 - d)) + d;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z) {
        try {
            return getField.get(str, z);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return z;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i) {
        try {
            return getField.get(str, i);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return i;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j) {
        try {
            return getField.get(str, j);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T readObject(Context context, String str, String str2, Class<T> cls) {
        ObjectInputStream objectInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        ILogger logger;
        String str3;
        Object[] objArr;
        T t = null;
        try {
            inputStream = context.openFileInput(str);
            try {
                try {
                    InputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        objectInputStream = new ObjectInputStream(bufferedInputStream);
                        try {
                            t = cls.cast(objectInputStream.readObject());
                            getLogger().debug("Read %s: %s", str2, t);
                            inputStream2 = objectInputStream;
                        } catch (ClassCastException e) {
                            logger = getLogger();
                            str3 = "Failed to cast %s object (%s)";
                            objArr = new Object[]{str2, e.getMessage()};
                            logger.error(str3, objArr);
                            inputStream2 = objectInputStream;
                            if (inputStream2 != null) {
                            }
                            return t;
                        } catch (ClassNotFoundException e2) {
                            logger = getLogger();
                            str3 = "Failed to find %s class (%s)";
                            objArr = new Object[]{str2, e2.getMessage()};
                            logger.error(str3, objArr);
                            inputStream2 = objectInputStream;
                            if (inputStream2 != null) {
                            }
                            return t;
                        } catch (Exception e3) {
                            logger = getLogger();
                            str3 = "Failed to read %s object (%s)";
                            objArr = new Object[]{str2, e3.getMessage()};
                            logger.error(str3, objArr);
                            inputStream2 = objectInputStream;
                            if (inputStream2 != null) {
                            }
                            return t;
                        }
                    } catch (FileNotFoundException unused) {
                        inputStream = bufferedInputStream;
                        getLogger().debug("%s file not found", str2);
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                        }
                        return t;
                    } catch (Exception e4) {
                        e = e4;
                        objectInputStream = bufferedInputStream;
                        getLogger().error("Failed to open %s file for reading (%s)", str2, e);
                        inputStream2 = objectInputStream;
                        if (inputStream2 != null) {
                        }
                        return t;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (FileNotFoundException unused2) {
            }
        } catch (FileNotFoundException unused3) {
            inputStream = null;
        } catch (Exception e6) {
            e = e6;
            objectInputStream = 0;
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (Exception e7) {
                getLogger().error("Failed to close %s file for reading (%s)", str2, e7);
            }
        }
        return t;
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return t;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.adjust.sdk.Util$4] */
    public static void runInBackground(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
        } else {
            new AsyncTask<Object, Void, Void>() { // from class: com.adjust.sdk.Util.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Object... objArr) {
                    ((Runnable) objArr[0]).run();
                    return null;
                }
            }.execute(runnable);
        }
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public static String sha1(String str) {
        return hash(str, Constants.SHA1);
    }

    public static String sha256(String str) {
        return hash(str, Constants.SHA256);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void writeObject(T t, Context context, String str, String str2) {
        ObjectOutputStream objectOutputStream;
        try {
            try {
                ?? bufferedOutputStream = new BufferedOutputStream(context.openFileOutput(str, 0));
                try {
                    objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
                    try {
                        objectOutputStream.writeObject(t);
                        getLogger().debug("Wrote %s: %s", str2, t);
                    } catch (NotSerializableException unused) {
                        getLogger().error("Failed to serialize %s", str2);
                    }
                } catch (Exception e) {
                    e = e;
                    objectOutputStream = bufferedOutputStream;
                    getLogger().error("Failed to open %s for writing (%s)", str2, e);
                    if (objectOutputStream != null) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
                getLogger().error("Failed to open %s for writing (%s)", str2, e);
                if (objectOutputStream != null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream = null;
        }
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (Exception e4) {
                getLogger().error("Failed to close %s file for writing (%s)", str2, e4);
            }
        }
    }
}
