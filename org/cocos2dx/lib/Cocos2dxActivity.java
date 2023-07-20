package org.cocos2dx.lib;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import org.cocos2dx.lib.Cocos2dxHandler;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public abstract class Cocos2dxActivity extends Activity implements Cocos2dxHelper.Cocos2dxHelperListener {
    private static final String TAG = "Cocos2dxActivity";
    private static Cocos2dxActivity sContext;
    private Cocos2dxGLSurfaceView mGLSurfaceView = null;
    private int[] mGLContextAttrs = null;
    private Cocos2dxHandler mHandler = null;
    private Cocos2dxVideoHelper mVideoHelper = null;
    private Cocos2dxWebViewHelper mWebViewHelper = null;
    private Cocos2dxEditBoxHelper mEditBoxHelper = null;
    private boolean hasFocus = false;
    private boolean showVirtualButton = false;
    private boolean gainAudioFocus = false;
    private boolean paused = true;
    protected ResizeLayout mFrameLayout = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GLSurfaceView.EGLConfigChooser {
        private int[] b;
        private final int c = 4;
        private final int d = 64;

        public a(int[] iArr) {
            this.b = iArr;
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2) || iArr2[0] <= 0) {
                return null;
            }
            return eGLConfigArr[0];
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[][] iArr = new int[4];
            int[] iArr2 = new int[19];
            iArr2[0] = 12324;
            int[] iArr3 = this.b;
            iArr2[1] = iArr3[0];
            iArr2[2] = 12323;
            iArr2[3] = iArr3[1];
            iArr2[4] = 12322;
            iArr2[5] = iArr3[2];
            iArr2[6] = 12321;
            iArr2[7] = iArr3[3];
            iArr2[8] = 12325;
            iArr2[9] = iArr3[4];
            iArr2[10] = 12326;
            iArr2[11] = iArr3[5];
            iArr2[12] = 12338;
            iArr2[13] = iArr3[6] > 0 ? 1 : 0;
            iArr2[14] = 12337;
            int[] iArr4 = this.b;
            iArr2[15] = iArr4[6];
            iArr2[16] = 12352;
            iArr2[17] = 4;
            iArr2[18] = 12344;
            iArr[0] = iArr2;
            int[] iArr5 = new int[19];
            iArr5[0] = 12324;
            iArr5[1] = iArr4[0];
            iArr5[2] = 12323;
            iArr5[3] = iArr4[1];
            iArr5[4] = 12322;
            iArr5[5] = iArr4[2];
            iArr5[6] = 12321;
            iArr5[7] = iArr4[3];
            iArr5[8] = 12325;
            iArr5[9] = iArr4[4] >= 24 ? 16 : iArr4[4];
            iArr5[10] = 12326;
            int[] iArr6 = this.b;
            iArr5[11] = iArr6[5];
            iArr5[12] = 12338;
            iArr5[13] = iArr6[6] > 0 ? 1 : 0;
            iArr5[14] = 12337;
            int[] iArr7 = this.b;
            iArr5[15] = iArr7[6];
            iArr5[16] = 12352;
            iArr5[17] = 4;
            iArr5[18] = 12344;
            iArr[1] = iArr5;
            int[] iArr8 = new int[19];
            iArr8[0] = 12324;
            iArr8[1] = iArr7[0];
            iArr8[2] = 12323;
            iArr8[3] = iArr7[1];
            iArr8[4] = 12322;
            iArr8[5] = iArr7[2];
            iArr8[6] = 12321;
            iArr8[7] = iArr7[3];
            iArr8[8] = 12325;
            iArr8[9] = iArr7[4] >= 24 ? 16 : iArr7[4];
            iArr8[10] = 12326;
            iArr8[11] = this.b[5];
            iArr8[12] = 12338;
            iArr8[13] = 0;
            iArr8[14] = 12337;
            iArr8[15] = 0;
            iArr8[16] = 12352;
            iArr8[17] = 4;
            iArr8[18] = 12344;
            iArr[2] = iArr8;
            iArr[3] = new int[]{12352, 4, 12344};
            for (int[] iArr9 : iArr) {
                EGLConfig a = a(egl10, eGLDisplay, iArr9);
                if (a != null) {
                    return a;
                }
            }
            Log.e("device_policy", "Can not select an EGLConfig for rendering.");
            return null;
        }
    }

    public static Context getContext() {
        return sContext;
    }

    private static native int[] getGLContextAttrs();

    private static boolean isAndroidEmulator() {
        String str = Build.MODEL;
        String str2 = TAG;
        Log.d(str2, "model=" + str);
        String str3 = Build.PRODUCT;
        String str4 = TAG;
        Log.d(str4, "product=" + str3);
        boolean z = false;
        if (str3 != null && (str3.equals("sdk") || str3.contains("_sdk") || str3.contains("sdk_"))) {
            z = true;
        }
        String str5 = TAG;
        Log.d(str5, "isEmulator=" + z);
        return z;
    }

    private static boolean isDeviceAsleep() {
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
    }

    private static boolean isDeviceLocked() {
        return ((KeyguardManager) getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    private void resumeIfHasFocus() {
        boolean z = !isDeviceLocked() && !isDeviceAsleep();
        if (!this.hasFocus || !z) {
            return;
        }
        hideVirtualButton();
        Cocos2dxHelper.onResume();
        this.mGLSurfaceView.onResume();
    }

    public Cocos2dxGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public int getSurfaceHolderFixedHeight() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point(0, 0);
        if (Build.VERSION.SDK_INT > 18) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point.y;
    }

    public int getSurfaceHolderFixedWidth() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point(0, 0);
        if (Build.VERSION.SDK_INT > 18) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point.x;
    }

    public Cocos2dxGLSurfaceView getSurfaceView() {
        return this.mGLSurfaceView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideVirtualButton() {
        if (!this.showVirtualButton && Build.VERSION.SDK_INT >= 19) {
            try {
                int intValue = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION")).intValue();
                int intValue2 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN")).intValue();
                int intValue3 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION")).intValue();
                Cocos2dxReflectionHelper.invokeInstanceMethod(getWindow().getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE")).intValue() | intValue | intValue2 | intValue3 | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_FULLSCREEN")).intValue() | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_IMMERSIVE_STICKY")).intValue())});
            } catch (NullPointerException e) {
                Log.e(TAG, "hideVirtualButton", e);
            }
        }
    }

    public void init() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mFrameLayout = new ResizeLayout(this);
        this.mFrameLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        Cocos2dxEditBox cocos2dxEditBox = new Cocos2dxEditBox(this);
        cocos2dxEditBox.setLayoutParams(layoutParams2);
        this.mFrameLayout.addView(cocos2dxEditBox);
        this.mGLSurfaceView = onCreateView();
        this.mFrameLayout.addView(this.mGLSurfaceView);
        this.mGLSurfaceView.setCocos2dxRenderer(new Cocos2dxRenderer());
        this.mGLSurfaceView.setCocos2dxEditText(cocos2dxEditBox);
        setContentView(this.mFrameLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        for (PreferenceManager.OnActivityResultListener onActivityResultListener : Cocos2dxHelper.getOnActivityResultListeners()) {
            onActivityResultListener.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            finish();
            Log.w(TAG, "[Workaround] Ignore the activity started from icon!");
            return;
        }
        hideVirtualButton();
        onLoadNativeLibraries();
        sContext = this;
        this.mHandler = new Cocos2dxHandler(this);
        Cocos2dxHelper.init(this);
        this.mGLContextAttrs = getGLContextAttrs();
        init();
        if (this.mVideoHelper == null) {
            this.mVideoHelper = new Cocos2dxVideoHelper(this, this.mFrameLayout);
        }
        if (this.mWebViewHelper == null) {
            this.mWebViewHelper = new Cocos2dxWebViewHelper(this.mFrameLayout);
        }
        if (this.mEditBoxHelper == null) {
            this.mEditBoxHelper = new Cocos2dxEditBoxHelper(this.mFrameLayout);
        }
        getWindow().setSoftInputMode(32);
        setVolumeControlStream(3);
    }

    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView cocos2dxGLSurfaceView = new Cocos2dxGLSurfaceView(this);
        if (this.mGLContextAttrs[3] > 0) {
            cocos2dxGLSurfaceView.getHolder().setFormat(-3);
        }
        cocos2dxGLSurfaceView.setEGLConfigChooser(new a(this.mGLContextAttrs));
        return cocos2dxGLSurfaceView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.gainAudioFocus) {
            Cocos2dxAudioFocusManager.b(this);
        }
        super.onDestroy();
    }

    protected void onLoadNativeLibraries() {
        try {
            System.loadLibrary(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString("android.app.lib_name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        Log.d(TAG, "onPause()");
        this.paused = true;
        super.onPause();
        if (this.gainAudioFocus) {
            Cocos2dxAudioFocusManager.b(this);
        }
        Cocos2dxHelper.onPause();
        this.mGLSurfaceView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        Log.d(TAG, "onResume()");
        this.paused = false;
        super.onResume();
        if (this.gainAudioFocus) {
            Cocos2dxAudioFocusManager.a(this);
        }
        hideVirtualButton();
        resumeIfHasFocus();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        String str = TAG;
        Log.d(str, "onWindowFocusChanged() hasFocus=" + z);
        super.onWindowFocusChanged(z);
        this.hasFocus = z;
        resumeIfHasFocus();
    }

    public void requestLetterBoxImage() {
    }

    @Override // org.cocos2dx.lib.Cocos2dxHelper.Cocos2dxHelperListener
    public void runOnGLThread(Runnable runnable) {
        this.mGLSurfaceView.queueEvent(runnable);
    }

    public void setEnableAudioFocusGain(boolean z) {
        if (this.gainAudioFocus != z) {
            if (!this.paused) {
                if (z) {
                    Cocos2dxAudioFocusManager.a(this);
                } else {
                    Cocos2dxAudioFocusManager.b(this);
                }
            }
            this.gainAudioFocus = z;
        }
    }

    public void setEnableVirtualButton(boolean z) {
        this.showVirtualButton = z;
    }

    public void setKeepScreenOn(final boolean z) {
        runOnUiThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Cocos2dxActivity.this.mGLSurfaceView.setKeepScreenOn(z);
            }
        });
    }

    @Override // org.cocos2dx.lib.Cocos2dxHelper.Cocos2dxHelperListener
    public void showDialog(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new Cocos2dxHandler.DialogMessage(str, str2);
        this.mHandler.sendMessage(message);
    }
}
