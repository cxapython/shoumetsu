package org.cocos2dx.lib;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import org.cocos2dx.lib.Cocos2dxVideoView;

/* loaded from: classes.dex */
public class Cocos2dxVideoHelper {
    static final int KeyEventBack = 1000;
    private static final int VideoTaskCreate = 0;
    private static final int VideoTaskFullScreen = 12;
    private static final int VideoTaskKeepRatio = 11;
    private static final int VideoTaskPause = 5;
    private static final int VideoTaskRemove = 1;
    private static final int VideoTaskRestart = 10;
    private static final int VideoTaskResume = 6;
    private static final int VideoTaskSeek = 8;
    private static final int VideoTaskSetLooping = 13;
    private static final int VideoTaskSetRect = 3;
    private static final int VideoTaskSetSource = 2;
    private static final int VideoTaskSetUserInputEnabled = 14;
    private static final int VideoTaskSetVisible = 9;
    private static final int VideoTaskStart = 4;
    private static final int VideoTaskStop = 7;
    static b mVideoHandler;
    private static int videoTag;
    private Cocos2dxActivity mActivity;
    private FrameLayout mLayout;
    private SparseArray<Cocos2dxVideoView> sVideoViews;
    Cocos2dxVideoView.OnVideoEventListener videoEventListener = new Cocos2dxVideoView.OnVideoEventListener() { // from class: org.cocos2dx.lib.Cocos2dxVideoHelper.1
        @Override // org.cocos2dx.lib.Cocos2dxVideoView.OnVideoEventListener
        public void onVideoEvent(int i, int i2) {
            Cocos2dxVideoHelper.this.mActivity.runOnGLThread(new a(i, i2));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private int b;
        private int c;

        public a(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cocos2dxVideoHelper.nativeExecuteVideoCallback(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Handler {
        WeakReference<Cocos2dxVideoHelper> a;

        b(Cocos2dxVideoHelper cocos2dxVideoHelper) {
            this.a = new WeakReference<>(cocos2dxVideoHelper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1000) {
                boolean z = false;
                switch (i) {
                    case 0:
                        this.a.get()._createVideoView(message.arg1);
                        break;
                    case 1:
                        this.a.get()._removeVideoView(message.arg1);
                        break;
                    case 2:
                        this.a.get()._setVideoURL(message.arg1, message.arg2, (String) message.obj);
                        break;
                    case 3:
                        Cocos2dxVideoHelper cocos2dxVideoHelper = this.a.get();
                        Rect rect = (Rect) message.obj;
                        cocos2dxVideoHelper._setVideoRect(message.arg1, rect.left, rect.top, rect.right, rect.bottom);
                        break;
                    case 4:
                        this.a.get()._startVideo(message.arg1);
                        break;
                    case 5:
                        this.a.get()._pauseVideo(message.arg1);
                        break;
                    case 6:
                        this.a.get()._resumeVideo(message.arg1);
                        break;
                    case 7:
                        this.a.get()._stopVideo(message.arg1);
                        break;
                    case 8:
                        this.a.get()._seekVideoTo(message.arg1, message.arg2);
                        break;
                    case 9:
                        Cocos2dxVideoHelper cocos2dxVideoHelper2 = this.a.get();
                        if (message.arg2 != 1) {
                            cocos2dxVideoHelper2._setVideoVisible(message.arg1, false);
                            break;
                        } else {
                            cocos2dxVideoHelper2._setVideoVisible(message.arg1, true);
                            break;
                        }
                    case 10:
                        this.a.get()._restartVideo(message.arg1);
                        break;
                    case 11:
                        Cocos2dxVideoHelper cocos2dxVideoHelper3 = this.a.get();
                        if (message.arg2 != 1) {
                            cocos2dxVideoHelper3._setVideoKeepRatio(message.arg1, false);
                            break;
                        } else {
                            cocos2dxVideoHelper3._setVideoKeepRatio(message.arg1, true);
                            break;
                        }
                    case 12:
                        Cocos2dxVideoHelper cocos2dxVideoHelper4 = this.a.get();
                        Rect rect2 = (Rect) message.obj;
                        if (message.arg2 != 1) {
                            cocos2dxVideoHelper4._setFullScreenEnabled(message.arg1, false, rect2.right, rect2.bottom);
                            break;
                        } else {
                            cocos2dxVideoHelper4._setFullScreenEnabled(message.arg1, true, rect2.right, rect2.bottom);
                            break;
                        }
                    case 13:
                        Cocos2dxVideoHelper cocos2dxVideoHelper5 = this.a.get();
                        int i2 = message.arg1;
                        if (message.arg2 != 0) {
                            z = true;
                        }
                        cocos2dxVideoHelper5._setLooping(i2, z);
                        break;
                    case 14:
                        Cocos2dxVideoHelper cocos2dxVideoHelper6 = this.a.get();
                        int i3 = message.arg1;
                        if (message.arg2 != 0) {
                            z = true;
                        }
                        cocos2dxVideoHelper6._setUserInputEnabled(i3, z);
                        break;
                }
            } else {
                this.a.get().onBackKeyEvent();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cocos2dxVideoHelper(Cocos2dxActivity cocos2dxActivity, FrameLayout frameLayout) {
        this.mLayout = null;
        this.mActivity = null;
        this.sVideoViews = null;
        this.mActivity = cocos2dxActivity;
        this.mLayout = frameLayout;
        mVideoHandler = new b(this);
        this.sVideoViews = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _createVideoView(int i) {
        Cocos2dxVideoView cocos2dxVideoView = new Cocos2dxVideoView(this.mActivity, i);
        this.sVideoViews.put(i, cocos2dxVideoView);
        this.mLayout.addView(cocos2dxVideoView, new FrameLayout.LayoutParams(-2, -2));
        cocos2dxVideoView.setZOrderOnTop(true);
        cocos2dxVideoView.setOnCompletionListener(this.videoEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _pauseVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _removeVideoView(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.stopPlayback();
            this.sVideoViews.remove(i);
            this.mLayout.removeView(cocos2dxVideoView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _restartVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _resumeVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _seekVideoTo(int i, int i2) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.seekTo(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setFullScreenEnabled(int i, boolean z, int i2, int i3) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setFullScreenEnabled(z, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setLooping(int i, boolean z) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setLooping(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setUserInputEnabled(int i, boolean z) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setUserInputEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setVideoKeepRatio(int i, boolean z) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setKeepRatio(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setVideoRect(int i, int i2, int i3, int i4, int i5) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setVideoRect(i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setVideoURL(int i, int i2, String str) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            switch (i2) {
                case 0:
                    cocos2dxVideoView.setVideoFileName(str);
                    return;
                case 1:
                    cocos2dxVideoView.setVideoURL(str);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setVideoVisible(int i, boolean z) {
        int i2;
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            if (z) {
                cocos2dxVideoView.fixSize();
                i2 = 0;
            } else {
                i2 = 4;
            }
            cocos2dxVideoView.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _startVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _stopVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.stop();
        }
    }

    public static int createVideoWidget() {
        Message message = new Message();
        message.what = 0;
        message.arg1 = videoTag;
        mVideoHandler.sendMessage(message);
        int i = videoTag;
        videoTag = i + 1;
        return i;
    }

    public static native void nativeExecuteVideoCallback(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackKeyEvent() {
        int size = this.sVideoViews.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.sVideoViews.keyAt(i);
            Cocos2dxVideoView cocos2dxVideoView = this.sVideoViews.get(keyAt);
            if (cocos2dxVideoView != null) {
                cocos2dxVideoView.setFullScreenEnabled(false, 0, 0);
                this.mActivity.runOnGLThread(new a(keyAt, 1000));
            }
        }
    }

    public static void pauseVideo(int i) {
        Message message = new Message();
        message.what = 5;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void removeVideoWidget(int i) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void restartVideo(int i) {
        Message message = new Message();
        message.what = 10;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void resumeVideo(int i) {
        Message message = new Message();
        message.what = 6;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void seekVideoTo(int i, int i2) {
        Message message = new Message();
        message.what = 8;
        message.arg1 = i;
        message.arg2 = i2;
        mVideoHandler.sendMessage(message);
    }

    public static void setFullScreenEnabled(int i, boolean z, int i2, int i3) {
        Message message = new Message();
        message.what = 12;
        message.arg1 = i;
        if (z) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        message.obj = new Rect(0, 0, i2, i3);
        mVideoHandler.sendMessage(message);
    }

    public static void setLooping(int i, boolean z) {
        Message message = new Message();
        message.what = 13;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setUserInputEnabled(int i, boolean z) {
        Message message = new Message();
        message.what = 14;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoKeepRatioEnabled(int i, boolean z) {
        Message message = new Message();
        message.what = 11;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoRect(int i, int i2, int i3, int i4, int i5) {
        Message message = new Message();
        message.what = 3;
        message.arg1 = i;
        message.obj = new Rect(i2, i3, i4, i5);
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoUrl(int i, int i2, String str) {
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = str;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoVisible(int i, boolean z) {
        Message message = new Message();
        message.what = 9;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void startVideo(int i) {
        Message message = new Message();
        message.what = 4;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void stopVideo(int i) {
        Message message = new Message();
        message.what = 7;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }
}
