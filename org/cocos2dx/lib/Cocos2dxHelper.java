package org.cocos2dx.lib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.enhance.gameservice.IGameTuningService;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class Cocos2dxHelper {
    private static final int BOOST_TIME = 7;
    private static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static final int RUNNABLES_PER_FRAME = 5;
    private static final String TAG = "Cocos2dxHelper";
    private static boolean sAccelerometerEnabled;
    private static Activity sActivity;
    private static boolean sActivityVisible;
    private static AssetManager sAssetManager;
    private static Cocos2dxAccelerometer sCocos2dxAccelerometer;
    private static Cocos2dxHelperListener sCocos2dxHelperListener;
    private static boolean sCompassEnabled;
    private static String sPackageName;
    private static Set<PreferenceManager.OnActivityResultListener> onActivityResultListeners = new LinkedHashSet();
    private static Vibrator sVibrateService = null;
    private static IGameTuningService mGameServiceBinder = null;
    private static String sAssetsPath = "";
    private static com.a.b.b.a.b sOBBFile = null;
    private static boolean sInited = false;
    private static ServiceConnection connection = new ServiceConnection() { // from class: org.cocos2dx.lib.Cocos2dxHelper.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGameTuningService unused = Cocos2dxHelper.mGameServiceBinder = IGameTuningService.Stub.asInterface(iBinder);
            Cocos2dxHelper.fastLoading(7);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Cocos2dxHelper.sActivity.getApplicationContext().unbindService(Cocos2dxHelper.connection);
        }
    };

    /* loaded from: classes.dex */
    public interface Cocos2dxHelperListener {
        void runOnGLThread(Runnable runnable);

        void showDialog(String str, String str2);
    }

    public static void addOnActivityResultListener(PreferenceManager.OnActivityResultListener onActivityResultListener) {
        onActivityResultListeners.add(onActivityResultListener);
    }

    public static byte[] conversionEncoding(byte[] bArr, String str, String str2) {
        try {
            return new String(bArr, str).getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteValueForKey(String str) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void disableAccelerometer() {
        sAccelerometerEnabled = false;
        getAccelerometer().disable();
    }

    public static void enableAccelerometer() {
        sAccelerometerEnabled = true;
        getAccelerometer().enableAccel();
    }

    public static void enableCompass() {
        sCompassEnabled = true;
        getAccelerometer().enableCompass();
    }

    public static int fastLoading(int i) {
        try {
            if (mGameServiceBinder == null) {
                return -1;
            }
            return mGameServiceBinder.boostUp(i);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static float[] getAccelValue() {
        return getAccelerometer().accelerometerValues;
    }

    private static Cocos2dxAccelerometer getAccelerometer() {
        if (sCocos2dxAccelerometer == null) {
            sCocos2dxAccelerometer = new Cocos2dxAccelerometer(sActivity);
        }
        return sCocos2dxAccelerometer;
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static String getAssetsPath() {
        if (sAssetsPath.equals("")) {
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + sPackageName;
            String[] list = new File(str).list(new FilenameFilter() { // from class: org.cocos2dx.lib.Cocos2dxHelper.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("main.") && str2.endsWith(".obb");
                }
            });
            String str2 = "";
            if (list != null && list.length > 0) {
                str2 = str + "/" + list[0];
            }
            if (new File(str2).exists()) {
                sAssetsPath = str2;
            } else {
                sAssetsPath = sActivity.getApplicationInfo().sourceDir;
            }
        }
        return sAssetsPath;
    }

    public static boolean getBoolForKey(String str, boolean z) {
        SharedPreferences sharedPreferences = sActivity.getSharedPreferences(PREFS_NAME, 0);
        try {
            return sharedPreferences.getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = sharedPreferences.getAll().get(str);
            return obj instanceof String ? Boolean.parseBoolean(obj.toString()) : obj instanceof Integer ? ((Integer) obj).intValue() != 0 : obj instanceof Float ? ((Float) obj).floatValue() != 0.0f : z;
        }
    }

    public static String getCocos2dxPackageName() {
        return sPackageName;
    }

    public static String getCocos2dxWritablePath() {
        return sActivity.getFilesDir().getAbsolutePath();
    }

    public static float[] getCompassValue() {
        return getAccelerometer().compassFieldValues;
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getDPI() {
        Display defaultDisplay;
        if (sActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = sActivity.getWindowManager();
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return -1;
            }
            defaultDisplay.getMetrics(displayMetrics);
            return (int) (displayMetrics.density * 160.0f);
        }
        return -1;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static double getDoubleForKey(String str, double d) {
        return getFloatForKey(str, (float) d);
    }

    public static float getFloatForKey(String str, float f) {
        SharedPreferences sharedPreferences = sActivity.getSharedPreferences(PREFS_NAME, 0);
        try {
            return sharedPreferences.getFloat(str, f);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = sharedPreferences.getAll().get(str);
            if (obj instanceof String) {
                return Float.parseFloat(obj.toString());
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                return 1.0f;
            }
            return f;
        }
    }

    public static int getIntegerForKey(String str, int i) {
        SharedPreferences sharedPreferences = sActivity.getSharedPreferences(PREFS_NAME, 0);
        try {
            return sharedPreferences.getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            Object obj = sharedPreferences.getAll().get(str);
            if (obj instanceof String) {
                return Integer.parseInt(obj.toString());
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                return 1;
            }
            return i;
        }
    }

    public static long[] getObbAssetFileDescriptor(String str) {
        AssetFileDescriptor a;
        String str2;
        String invocationTargetException;
        long[] jArr = new long[3];
        if (getObbFile() != null && (a = getObbFile().a(str)) != null) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = a.getParcelFileDescriptor();
                jArr[0] = ((Integer) parcelFileDescriptor.getClass().getMethod("getFd", new Class[0]).invoke(parcelFileDescriptor, new Object[0])).intValue();
                jArr[1] = a.getStartOffset();
                jArr[2] = a.getLength();
            } catch (IllegalAccessException e) {
                str2 = TAG;
                invocationTargetException = e.toString();
                Log.e(str2, invocationTargetException);
            } catch (NoSuchMethodException unused) {
                Log.e(TAG, "Accessing file descriptor directly from the OBB is only supported from Android 3.1 (API level 12) and above.");
            } catch (InvocationTargetException e2) {
                str2 = TAG;
                invocationTargetException = e2.toString();
                Log.e(str2, invocationTargetException);
            }
        }
        return jArr;
    }

    public static com.a.b.b.a.b getObbFile() {
        if (sOBBFile == null) {
            int i = 1;
            try {
                i = Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(getCocos2dxPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            try {
                sOBBFile = com.a.b.b.a.a.b(Cocos2dxActivity.getContext(), i, 0);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return sOBBFile;
    }

    public static Set<PreferenceManager.OnActivityResultListener> getOnActivityResultListeners() {
        return onActivityResultListeners;
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    @SuppressLint({"NewApi"})
    public static int[] getSafeInsets() {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        int[] iArr = {0, 0, 0, 0};
        if (Build.VERSION.SDK_INT >= 28 && (displayCutout = sActivity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout()) != null && (boundingRects = displayCutout.getBoundingRects()) != null && boundingRects.size() != 0) {
            iArr[0] = displayCutout.getSafeInsetBottom();
            iArr[1] = displayCutout.getSafeInsetLeft();
            iArr[2] = displayCutout.getSafeInsetRight();
            iArr[3] = displayCutout.getSafeInsetTop();
        }
        return iArr;
    }

    public static String getStringForKey(String str, String str2) {
        SharedPreferences sharedPreferences = sActivity.getSharedPreferences(PREFS_NAME, 0);
        try {
            return sharedPreferences.getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return sharedPreferences.getAll().get(str).toString();
        }
    }

    public static int getTemperature() {
        try {
            if (mGameServiceBinder == null) {
                return -1;
            }
            return mGameServiceBinder.getAbstractTemperature();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getVersion() {
        try {
            return Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(Cocos2dxActivity.getContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean hasSoftKeys() {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = sActivity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            int i3 = displayMetrics2.heightPixels;
            if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
                return true;
            }
        } else {
            boolean hasPermanentMenuKey = ViewConfiguration.get(sActivity).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (!hasPermanentMenuKey && !deviceHasKey) {
                return true;
            }
        }
        return false;
    }

    public static void init(Activity activity) {
        String str;
        String str2;
        sActivity = activity;
        sCocos2dxHelperListener = (Cocos2dxHelperListener) activity;
        if (!sInited) {
            boolean hasSystemFeature = activity.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            Log.d(TAG, "isSupportLowLatency:" + hasSystemFeature);
            int i = 44100;
            int i2 = 192;
            if (Build.VERSION.SDK_INT >= 17) {
                AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
                String str3 = (String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{String.class}, new Object[]{Cocos2dxReflectionHelper.getConstantValue(AudioManager.class, "PROPERTY_OUTPUT_SAMPLE_RATE")});
                String str4 = (String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{String.class}, new Object[]{Cocos2dxReflectionHelper.getConstantValue(AudioManager.class, "PROPERTY_OUTPUT_FRAMES_PER_BUFFER")});
                try {
                    i = Integer.parseInt(str3);
                    i2 = Integer.parseInt(str4);
                } catch (NumberFormatException e) {
                    Log.e(TAG, "parseInt failed", e);
                }
                str = TAG;
                str2 = "sampleRate: " + i + ", framesPerBuffer: " + i2;
            } else {
                str = TAG;
                str2 = "android version is lower than 17";
            }
            Log.d(str, str2);
            nativeSetAudioDeviceInfo(hasSystemFeature, i, i2);
            sPackageName = activity.getApplicationInfo().packageName;
            sAssetManager = activity.getAssets();
            nativeSetContext(activity, sAssetManager);
            Cocos2dxBitmap.setContext(activity);
            sVibrateService = (Vibrator) activity.getSystemService("vibrator");
            sInited = true;
            Intent intent = new Intent(IGameTuningService.class.getName());
            intent.setPackage("com.enhance.gameservice");
            activity.getApplicationContext().bindService(intent, connection, 1);
        }
    }

    public static boolean isActivityVisible() {
        return sActivityVisible;
    }

    @SuppressLint({"InlinedApi"})
    public static boolean isCutoutEnabled() {
        return Build.VERSION.SDK_INT >= 28 && sActivity.getWindow().getAttributes().layoutInDisplayCutoutMode == 1;
    }

    public static boolean isScreenRound() {
        return Build.VERSION.SDK_INT >= 23 && sActivity.getResources().getConfiguration().isScreenRound();
    }

    private static native void nativeSetAudioDeviceInfo(boolean z, int i, int i2);

    private static native void nativeSetContext(Context context, AssetManager assetManager);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetEditTextDialogResult(byte[] bArr);

    public static void onPause() {
        sActivityVisible = false;
        if (sAccelerometerEnabled) {
            getAccelerometer().disable();
        }
    }

    public static void onResume() {
        sActivityVisible = true;
        if (sAccelerometerEnabled) {
            getAccelerometer().enableAccel();
        }
        if (sCompassEnabled) {
            getAccelerometer().enableCompass();
        }
    }

    public static boolean openURL(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            sActivity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void runOnGLThread(Runnable runnable) {
        ((Cocos2dxActivity) sActivity).runOnGLThread(runnable);
    }

    public static void setAccelerometerInterval(float f) {
        getAccelerometer().setInterval(f);
    }

    public static void setBoolForKey(String str, boolean z) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setDoubleForKey(String str, double d) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.putFloat(str, (float) d);
        edit.apply();
    }

    public static void setEditTextDialogResult(String str) {
        try {
            final byte[] bytes = str.getBytes("UTF8");
            sCocos2dxHelperListener.runOnGLThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    Cocos2dxHelper.nativeSetEditTextDialogResult(bytes);
                }
            });
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static int setFPS(int i) {
        try {
            if (mGameServiceBinder == null) {
                return -1;
            }
            return mGameServiceBinder.setFramePerSecond(i);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void setFloatForKey(String str, float f) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public static void setIntegerForKey(String str, int i) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void setKeepScreenOn(boolean z) {
        ((Cocos2dxActivity) sActivity).setKeepScreenOn(z);
    }

    public static int setLowPowerMode(boolean z) {
        try {
            if (mGameServiceBinder == null) {
                return -1;
            }
            return mGameServiceBinder.setGamePowerSaving(z);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int setResolutionPercent(int i) {
        try {
            if (mGameServiceBinder == null) {
                return -1;
            }
            return mGameServiceBinder.setPreferredResolution(i);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void setStringForKey(String str, String str2) {
        SharedPreferences.Editor edit = sActivity.getSharedPreferences(PREFS_NAME, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private static void showDialog(String str, String str2) {
        sCocos2dxHelperListener.showDialog(str, str2);
    }

    public static void terminateProcess() {
        if (Build.VERSION.SDK_INT >= 21) {
            sActivity.finishAndRemoveTask();
        }
        Process.killProcess(Process.myPid());
    }

    public static void vibrate(float f) {
        sVibrateService.vibrate(f * 1000.0f);
    }
}
