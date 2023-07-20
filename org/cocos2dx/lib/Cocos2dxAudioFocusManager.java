package org.cocos2dx.lib;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Cocos2dxAudioFocusManager {
    private static AudioManager.OnAudioFocusChangeListener a = new AudioManager.OnAudioFocusChangeListener() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Runnable runnable;
            Log.d("AudioFocusManager", "onAudioFocusChange: " + i + ", thread: " + Thread.currentThread().getName());
            if (i == -1) {
                Log.d("AudioFocusManager", "Pause music by AUDIOFOCUS_LOSS");
                runnable = new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(1);
                    }
                };
            } else if (i == -2) {
                Log.d("AudioFocusManager", "Pause music by AUDIOFOCUS_LOSS_TRANSILENT");
                runnable = new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(2);
                    }
                };
            } else if (i == -3) {
                Log.d("AudioFocusManager", "Lower the volume, keep playing by AUDIOFOCUS_LOSS_TRANSILENT_CAN_DUCK");
                runnable = new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(3);
                    }
                };
            } else if (i != 1) {
                return;
            } else {
                Log.d("AudioFocusManager", "Resume music by AUDIOFOCUS_GAIN");
                runnable = new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
                    }
                };
            }
            Cocos2dxHelper.runOnGLThread(runnable);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        if (((AudioManager) context.getSystemService("audio")).requestAudioFocus(a, 3, 1) == 1) {
            Log.d("AudioFocusManager", "requestAudioFocus succeed");
            return true;
        }
        Log.e("AudioFocusManager", "requestAudioFocus failed!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        if (((AudioManager) context.getSystemService("audio")).abandonAudioFocus(a) == 1) {
            Log.d("AudioFocusManager", "abandonAudioFocus succeed!");
        } else {
            Log.e("AudioFocusManager", "abandonAudioFocus failed!");
        }
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxAudioFocusManager.2
            @Override // java.lang.Runnable
            public void run() {
                Cocos2dxAudioFocusManager.nativeOnAudioFocusChange(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnAudioFocusChange(int i);
}
