package net.wrightflyer.shoumetsu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.google.android.gms.drive.DriveFile;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.e.a.a;
import cz.msebera.android.httpclient.HttpHost;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import net.gree.gamelib.core.a.b.b;
import net.gree.gamelib.moderation.KeywordFilter;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.shop.Shop;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.SignalHandler;

/* loaded from: classes.dex */
public class AthenaActivity extends Cocos2dxActivity {
    public static final int DESIGN_RESOLUTION_HEIGHT = 640;
    public static final int DESIGN_RESOLUTION_WIDTH = 1136;
    public static final int DESIGN_RESOLUTION_WIDTH_MAX = 1386;
    private static final String TAG = "AthenaActivity";
    private static final String WEBVIEW_NATIVE_BRIDGE_SCHEME = "athena-native";
    private static AssetManager sAssetManager;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mSurfaceHolderFixedHeight;
    private int mSurfaceHolderFixedWidth;
    private static final String[] WEBVIEW_HOST_LIST1 = {".wrightflyer.net", ".gree.jp", ".gree.net", ".i.ytimg.com", ".cloudfront.net", ".gree-dev.net", ".www.wfs.games"};
    private static final String[] WEBVIEW_HOST_LIST2 = {"wrightflyer.net", "www.wfs.games"};
    private static String sFilesDir = "";
    private static CountDownLatch mCdl = null;
    private static AthenaActivity sActivity = null;
    private static boolean sOpenUrlResult = false;
    private static WebView sWebView = null;
    private String mUserAgent = null;
    private String mAppCenterId = null;
    private AthenaImageView mImageView = null;

    public static void cancelLocalNotification(int i) {
        Log.d(TAG, "cancelLocalNotification");
        ((AlarmManager) sActivity.getSystemService("alarm")).cancel(getPendingIntent(null, i));
    }

    public static void copyClipboard(final String str) {
        sActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.12
            @Override // java.lang.Runnable
            public void run() {
                ((ClipboardManager) AthenaActivity.sActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("user_id", str));
            }
        });
    }

    public static void dismissWebView() {
        Log.d("CocosWebView", "dismiss");
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (AthenaActivity.sWebView == null) {
                        return;
                    }
                    ((InputMethodManager) AthenaActivity.sActivity.getSystemService("input_method")).hideSoftInputFromWindow(AthenaActivity.sWebView.getWindowToken(), 0);
                    ((FrameLayout) AthenaActivity.sActivity.getWindow().getDecorView()).removeView(AthenaActivity.sWebView);
                    WebView unused = AthenaActivity.sWebView = null;
                    AthenaActivity.sActivity.getSurfaceView().requestFocus();
                    AthenaActivity.sActivity.onWebViewDismiss();
                }
            });
        }
    }

    private native boolean enableBreakPad();

    private int fromGLSize(int i) {
        return (int) ((i * getAvailableDisplayPoint().x) / 1136.0d);
    }

    private native String getAppCenterId();

    public static String getAppVersionCode() {
        PackageInfo packageInfo;
        try {
            packageInfo = sActivity.getPackageManager().getPackageInfo(sActivity.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return Integer.toString(packageInfo.versionCode);
        }
        return null;
    }

    public static String getAppVersionName() {
        PackageInfo packageInfo;
        try {
            packageInfo = sActivity.getPackageManager().getPackageInfo(sActivity.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String getAthenaAssetDataDirectory() {
        String concat = sFilesDir.concat("/athena/assets");
        File file = new File(concat);
        if (!file.exists()) {
            file.mkdirs();
        }
        return concat;
    }

    public static String getAthenaJsonDirectory() {
        String concat = sFilesDir.concat("/athena/json");
        File file = new File(concat);
        if (!file.exists()) {
            file.mkdirs();
        }
        return concat;
    }

    @TargetApi(18)
    public static Long getAvailableSize() {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(sFilesDir);
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return new Long(blockSize * availableBlocks);
    }

    public static Context getContext() {
        return sActivity;
    }

    public static String getDeviceName() {
        return Build.FINGERPRINT;
    }

    public static Long getElapsedRealTimeMilliseconds() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    private native String getGameLibAppId();

    private native String getGameLibAppSecret();

    public static String getInstalledUrlScheme(String str, String str2) {
        if (str.isEmpty() || str2.isEmpty()) {
            return "";
        }
        try {
            getContext().getPackageManager().getApplicationInfo(str2, 128);
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    private static PendingIntent getPendingIntent(String str, int i) {
        Intent intent = new Intent(sActivity.getApplicationContext(), LocalNotificationReceiver.class);
        intent.putExtra("notification_id", i);
        intent.putExtra(b.g, str);
        return PendingIntent.getBroadcast(sActivity, i, intent, 134217728);
    }

    public static String getSignature() {
        String str;
        NoSuchAlgorithmException e;
        PackageManager.NameNotFoundException e2;
        Signature[] signatureArr;
        try {
            str = null;
            for (Signature signature : sActivity.getPackageManager().getPackageInfo(sActivity.getPackageName(), 64).signatures) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                    messageDigest.update(signature.toByteArray());
                    byte[] digest = messageDigest.digest();
                    str = "";
                    int length = digest.length;
                    String str2 = str;
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = digest[i];
                            if (i2 < 0) {
                                i2 += 256;
                            }
                            if (i2 < 16) {
                                str2 = str2 + "0";
                            }
                            str2 = str2 + Integer.toString(i2, 16) + ":";
                        } catch (PackageManager.NameNotFoundException e3) {
                            e2 = e3;
                            str = str2;
                            e2.printStackTrace();
                            return str;
                        } catch (NoSuchAlgorithmException e4) {
                            e = e4;
                            str = str2;
                            e.printStackTrace();
                            return str;
                        }
                    }
                    str = str2.substring(0, str2.length() - 1).toUpperCase(Locale.US);
                } catch (PackageManager.NameNotFoundException e5) {
                    e2 = e5;
                } catch (NoSuchAlgorithmException e6) {
                    e = e6;
                }
            }
        } catch (PackageManager.NameNotFoundException e7) {
            str = null;
            e2 = e7;
        } catch (NoSuchAlgorithmException e8) {
            str = null;
            e = e8;
        }
        return str;
    }

    public static String getUserAgent() {
        Log.d(TAG, "getUserAgent");
        return sActivity.mUserAgent;
    }

    public static String getUserId() {
        return getUserIdForAppCenter();
    }

    private static native String getUserIdForAppCenter();

    private static native boolean isFromHiroba(String str, String str2, String str3);

    public static boolean isOnEmulator() {
        return GLES20.glGetString(7937).equals("Bluestacks") || Build.HARDWARE.equals("vbox86");
    }

    private native boolean isTestUserForGameLib();

    private static native void nativeOnActivityResult(Activity activity, int i, int i2, Intent intent);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onError();

    /* JADX INFO: Access modifiers changed from: private */
    public native void onNativeBridge(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onPageFinished();

    /* JADX INFO: Access modifiers changed from: private */
    public native void onPageStarted();

    /* JADX INFO: Access modifiers changed from: private */
    public native void onWebViewDismiss();

    private static native void onYouTubeResult(String str);

    public static void openGooglePlay() {
        sActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + sActivity.getPackageName())));
    }

    public static void openUrl(final String str) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.18
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    AthenaActivity.sActivity.startActivity(intent);
                }
            });
        }
    }

    public static boolean openUrlWithResult(final String str) {
        if (!TextUtils.isEmpty(str) && sActivity != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                try {
                    sActivity.startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    return false;
                }
            }
            mCdl = new CountDownLatch(1);
            sOpenUrlResult = false;
            sActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    try {
                        AthenaActivity.sActivity.startActivity(intent2);
                        boolean unused2 = AthenaActivity.sOpenUrlResult = true;
                    } catch (ActivityNotFoundException unused3) {
                        boolean unused4 = AthenaActivity.sOpenUrlResult = false;
                    }
                    AthenaActivity.mCdl.countDown();
                }
            });
            try {
                mCdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sOpenUrlResult;
        }
        return false;
    }

    public static void playYouTube(final String str) {
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity == null) {
            return;
        }
        athenaActivity.getSurfaceView().requestFocus();
        sActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.11
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setClass(AthenaActivity.getContext(), YouTubePlayerActivity.class);
                intent.putExtra(YouTubePlayerActivity.EXTRA_KEY_VIDEO_ID, str);
                AthenaActivity.sActivity.startActivity(intent);
            }
        });
    }

    public static void postWebViewWithMargins(final String str, final String str2, final int i, final int i2, final int i3, final int i4, final Map<String, String> map) {
        Log.d("CocosWebView", "postWebViewWithMargins");
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    AthenaActivity.sActivity.postWebViewWithMarginsInner(str, str2, i, i2, i3, i4, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postWebViewWithMarginsInner(String str, String str2, int i, int i2, int i3, int i4, Map<String, String> map) {
        if (sWebView == null) {
            sWebView = new WebView(this);
            sActivity.setUpWebView(str, true, str2, map);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(fromGLSize(i3) + getLetterBoxWidth(), fromGLSize(i) + getLetterBoxHeight(), fromGLSize(i4) + getLetterBoxWidth(), fromGLSize(i2) + getLetterBoxHeight());
            ((FrameLayout) getWindow().getDecorView()).addView(sWebView, layoutParams);
        }
    }

    public static void powerSavingMode(final String str) {
        AthenaActivity athenaActivity;
        Runnable runnable;
        if (str.equals("ON")) {
            athenaActivity = sActivity;
            runnable = new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = AthenaActivity.TAG;
                    Log.d(str2, "powerSavingMode:" + str);
                    AthenaActivity.sActivity.getWindow().clearFlags(128);
                    AthenaActivity.sActivity.getSurfaceView().setKeepScreenOn(false);
                }
            };
        } else if (!str.equals("OFF")) {
            return;
        } else {
            athenaActivity = sActivity;
            runnable = new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = AthenaActivity.TAG;
                    Log.d(str2, "powerSavingMode:" + str);
                    AthenaActivity.sActivity.getWindow().addFlags(128);
                    AthenaActivity.sActivity.getSurfaceView().setKeepScreenOn(true);
                }
            };
        }
        athenaActivity.runOnUiThread(runnable);
    }

    public static void sendActionSend(final String str) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("plain/text");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    AthenaActivity.sActivity.startActivity(intent);
                }
            });
        }
    }

    public static void sendLine(final String str) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AthenaActivity.sActivity.getPackageManager().getApplicationInfo("jp.naver.line.android", 128);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse("line://msg/text/" + URLEncoder.encode(str, "UTF-8")));
                        AthenaActivity.sActivity.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void sendMail(final String str, final String str2) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str2) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
                    intent.putExtra("android.intent.extra.SUBJECT", str);
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    AthenaActivity.sActivity.startActivity(Intent.createChooser(intent, "\u3000メールを送信"));
                }
            });
        }
    }

    public static void sendMail(final String str, final String str2, final String str3) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str, null));
                    intent.putExtra("android.intent.extra.SUBJECT", str2);
                    intent.putExtra("android.intent.extra.TEXT", str3);
                    AthenaActivity.sActivity.startActivity(Intent.createChooser(intent, "\u3000メールを送信"));
                }
            });
        }
    }

    public static void sendTwitter(final String str) {
        AthenaActivity athenaActivity;
        if (!TextUtils.isEmpty(str) && (athenaActivity = sActivity) != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse("http://www.twitter.com/intent/tweet?text=" + URLEncoder.encode(str, "utf-8")));
                        AthenaActivity.sActivity.startActivity(intent);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static native void setFriendRequestIds(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullscreenVisibility() {
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            View decorView = athenaActivity.getWindow().getDecorView();
            if (Build.VERSION.SDK_INT <= 18) {
                return;
            }
            decorView.setSystemUiVisibility(5894);
        }
    }

    private static native void setHirobaAuthStatus(String str);

    private static native void setHirobaToken(String str);

    private static native void setSerialCode(String str, String str2);

    private WebView setUpWebView(String str, Map<String, String> map) {
        return setUpWebView(str, false, null, map);
    }

    private WebView setUpWebView(String str, boolean z, String str2, final Map<String, String> map) {
        sWebView.setBackgroundColor(0);
        sWebView.setLayerType(1, null);
        sWebView.getSettings().setCacheMode(2);
        sWebView.getSettings().setAppCacheEnabled(false);
        sWebView.getSettings().setJavaScriptEnabled(true);
        sWebView.setVerticalScrollbarOverlay(true);
        sWebView.getSettings().setDomStorageEnabled(true);
        sWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        sWebView.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
        sWebView.getSettings().setUseWideViewPort(true);
        sWebView.getSettings().setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 24) {
            WebView webView = sWebView;
            WebView.enableSlowWholeDocumentDraw();
            sWebView.setOnTouchListener(new OnSwipeTouchListener(sActivity) { // from class: net.wrightflyer.shoumetsu.AthenaActivity.8
                @Override // net.wrightflyer.shoumetsu.OnSwipeTouchListener
                public boolean onDownEvent(MotionEvent motionEvent) {
                    return false;
                }

                @Override // net.wrightflyer.shoumetsu.OnSwipeTouchListener
                public void onSwipeBottom(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    AthenaActivity.sWebView.flingScroll(0, Math.round(f2));
                }

                @Override // net.wrightflyer.shoumetsu.OnSwipeTouchListener
                public void onSwipeLeft(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                }

                @Override // net.wrightflyer.shoumetsu.OnSwipeTouchListener
                public void onSwipeRight(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                }

                @Override // net.wrightflyer.shoumetsu.OnSwipeTouchListener
                public void onSwipeTop(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    AthenaActivity.sWebView.flingScroll(0, Math.round(f2));
                }
            });
        }
        sWebView.setOnKeyListener(new View.OnKeyListener() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.9
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return AthenaActivity.this.getSurfaceView().onKeyDown(i, keyEvent);
            }
        });
        sWebView.setWebViewClient(new WebViewClient() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.10
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str3) {
                super.onPageFinished(webView2, str3);
                Log.d("CocosWebView", "onPageFinished");
                AthenaActivity.this.onPageFinished();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str3, Bitmap bitmap) {
                super.onPageStarted(webView2, str3, bitmap);
                Log.d("CocosWebView", "onPageStarted");
                AthenaActivity.this.onPageStarted();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str3, String str4) {
                super.onReceivedError(webView2, i, str3, str4);
                Log.d("CocosWebView", "onReceivedError");
                AthenaActivity.this.onError();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                boolean z2;
                if (str3.startsWith(AthenaActivity.WEBVIEW_NATIVE_BRIDGE_SCHEME)) {
                    AthenaActivity.this.onNativeBridge(str3);
                    return true;
                } else if (!str3.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    if (!AthenaActivity.openUrlWithResult(str3)) {
                        return super.shouldOverrideUrlLoading(webView2, str3);
                    }
                    return true;
                } else {
                    try {
                        String host = new URL(str3).getHost();
                        String[] strArr = AthenaActivity.WEBVIEW_HOST_LIST1;
                        int length = strArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z2 = false;
                                break;
                            } else if (true == host.endsWith(strArr[i2])) {
                                z2 = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        String[] strArr2 = AthenaActivity.WEBVIEW_HOST_LIST2;
                        int length2 = strArr2.length;
                        while (true) {
                            if (i >= length2) {
                                break;
                            } else if (true == host.equals(strArr2[i])) {
                                z2 = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z2) {
                            AthenaActivity.openUrl(str3);
                            return true;
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    webView2.stopLoading();
                    webView2.loadUrl(str3, map);
                    return true;
                }
            }
        });
        if (z) {
            sWebView.postUrl(str, str2.getBytes());
        } else {
            sWebView.loadUrl(str, map);
        }
        sWebView.requestFocus();
        return sWebView;
    }

    private static native void setupLocalStorage(Context context, AssetManager assetManager);

    public static void showLocalNotification(String str, int i, int i2) {
        Log.d(TAG, "showLocalNotification");
        PendingIntent pendingIntent = getPendingIntent(str, i2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(13, i);
        ((AlarmManager) sActivity.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), pendingIntent);
    }

    public static void showWebView(final String str, final int i, final int i2, final int i3, final int i4, final Map<String, String> map) {
        Log.d("CocosWebView", "showWebView");
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    AthenaActivity.sActivity.showWebViewInner(str, i, i2, i3, i4, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebViewInner(String str, int i, int i2, int i3, int i4, Map<String, String> map) {
        if (sWebView == null) {
            sWebView = new WebView(this);
            sActivity.setUpWebView(str, map);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(fromGLSize(i), fromGLSize(i2), 0, 0);
            ((FrameLayout) getWindow().getDecorView()).addView(sWebView, layoutParams);
        }
    }

    public static void showWebViewWithMargins(final String str, final int i, final int i2, final int i3, final int i4, final Map<String, String> map) {
        Log.d("CocosWebView", "showWebViewWithMargins");
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            athenaActivity.runOnUiThread(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    AthenaActivity.sActivity.showWebViewWithMarginsInner(str, i, i2, i3, i4, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebViewWithMarginsInner(String str, int i, int i2, int i3, int i4, Map<String, String> map) {
        if (sWebView == null) {
            sWebView = new WebView(this);
            sActivity.setUpWebView(str, map);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(fromGLSize(i3) + getLetterBoxWidth(), fromGLSize(i) + getLetterBoxHeight(), fromGLSize(i4) + getLetterBoxWidth(), fromGLSize(i2) + getLetterBoxHeight());
            ((FrameLayout) getWindow().getDecorView()).addView(sWebView, layoutParams);
        }
    }

    public Point getAvailableDisplayPoint() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point(0, 0);
        if (Build.VERSION.SDK_INT > 18) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public int getLetterBoxHeight() {
        AthenaImageView athenaImageView = this.mImageView;
        if (athenaImageView != null) {
            return athenaImageView.Padding.top;
        }
        Point availableDisplayPoint = getAvailableDisplayPoint();
        return (availableDisplayPoint.y - ((availableDisplayPoint.x * DESIGN_RESOLUTION_HEIGHT) / DESIGN_RESOLUTION_WIDTH)) / 2;
    }

    public int getLetterBoxWidth() {
        AthenaImageView athenaImageView = this.mImageView;
        if (athenaImageView != null) {
            return athenaImageView.Padding.left;
        }
        Point availableDisplayPoint = getAvailableDisplayPoint();
        return (availableDisplayPoint.y - ((availableDisplayPoint.x * DESIGN_RESOLUTION_HEIGHT) / DESIGN_RESOLUTION_WIDTH)) / 2;
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity
    public int getSurfaceHolderFixedHeight() {
        return this.mSurfaceHolderFixedHeight;
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity
    public int getSurfaceHolderFixedWidth() {
        return this.mSurfaceHolderFixedWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(YouTubePlayerActivity.EXTRA_KEY_RETURN_STATE)) != null) {
            String str = TAG;
            Log.d(str, "YouTube::onActivityResult : " + stringExtra);
            onYouTubeResult(stringExtra);
        }
        if (!Shop.getInstance().handleActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        } else {
            Log.d(TAG, "onActivityResult handled by Shop.");
        }
        nativeOnActivityResult(this, i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getSurfaceView().getLayoutParams().width = this.mScreenWidth;
        getSurfaceView().getLayoutParams().height = this.mScreenHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.setEnableVirtualButton(false);
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        sActivity = this;
        if (Build.VERSION.SDK_INT > 18) {
            setFullscreenVisibility();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if ((i & 4) == 0) {
                        AthenaActivity.this.setFullscreenVisibility();
                    }
                }
            });
        }
        setVolumeControlStream(3);
        requestLetterBoxImage();
        TreeMap treeMap = new TreeMap();
        if (isTestUserForGameLib()) {
            treeMap.put("isTestUser", "true");
        }
        Payment.initialize(this, getGameLibAppId(), getGameLibAppSecret(), treeMap);
        KeywordFilter.initialize(this, getGameLibAppId(), getGameLibAppSecret(), treeMap);
        this.mAppCenterId = getAppCenterId();
        com.microsoft.appcenter.b.a(getApplication(), this.mAppCenterId, Analytics.class, Crashes.class);
        Crashes.n().a(new a<String>() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.3
            @Override // com.microsoft.appcenter.e.a.a
            public void accept(String str) {
                if (str != null) {
                    SignalHandler.setup(str);
                }
            }
        });
        com.microsoft.appcenter.b.a(getUserId());
        sAssetManager = sActivity.getAssets();
        sFilesDir = sActivity.getFilesDir().getAbsolutePath();
        setupLocalStorage(getContext(), sAssetManager);
        this.mUserAgent = new WebView(this).getSettings().getUserAgentString();
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity
    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView onCreateView = super.onCreateView();
        Point availableDisplayPoint = getAvailableDisplayPoint();
        this.mScreenWidth = availableDisplayPoint.x;
        this.mScreenHeight = availableDisplayPoint.y;
        this.mSurfaceHolderFixedWidth = this.mScreenWidth;
        this.mSurfaceHolderFixedHeight = this.mScreenHeight;
        return onCreateView;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity
    public void onResume() {
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            try {
                String queryParameter = data.getQueryParameter("serial_campaign_master_id");
                String queryParameter2 = data.getQueryParameter("serial_code");
                if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
                    setSerialCode(queryParameter, queryParameter2);
                }
                if (!TextUtils.isEmpty(data.getScheme()) && !TextUtils.isEmpty(data.getEncodedSchemeSpecificPart()) && !TextUtils.isEmpty(data.getFragment()) && isFromHiroba(data.getScheme(), data.getEncodedSchemeSpecificPart(), data.getFragment())) {
                    String lastPathSegment = data.getLastPathSegment();
                    if (!TextUtils.isEmpty(lastPathSegment)) {
                        if (lastPathSegment.equals("authorize_result")) {
                            String queryParameter3 = data.getQueryParameter("status");
                            String queryParameter4 = data.getQueryParameter(net.gree.gamelib.core.a.b.a.p);
                            if (queryParameter3.equals("success")) {
                                setHirobaToken(queryParameter4);
                            }
                            setHirobaAuthStatus(queryParameter3);
                        } else if (lastPathSegment.equals("friend_request")) {
                            setFriendRequestIds(data.getQueryParameter("ids"));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        super.onResume();
        try {
            String stringExtra = intent.getStringExtra(YouTubePlayerActivity.EXTRA_KEY_RETURN_STATE);
            if (stringExtra == null) {
                return;
            }
            String str = TAG;
            Log.d(str, "YouTube::onResume : " + stringExtra);
            onYouTubeResult(stringExtra);
        } catch (Exception unused2) {
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            new Handler().postDelayed(new Runnable() { // from class: net.wrightflyer.shoumetsu.AthenaActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    AthenaActivity.this.setFullscreenVisibility();
                }
            }, 200L);
        }
    }

    @Override // org.cocos2dx.lib.Cocos2dxActivity
    public void requestLetterBoxImage() {
        if (Build.VERSION.SDK_INT > 18) {
            this.mImageView = new AthenaImageView(this);
            this.mImageView.setActivity(sActivity);
            ((FrameLayout) getWindow().getDecorView()).addView(this.mImageView, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
