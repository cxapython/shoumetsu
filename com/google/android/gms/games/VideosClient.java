package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public class VideosClient extends zzt {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;
    private static final PendingResultUtil.ResultConverter<Videos.CaptureAvailableResult, Boolean> b = new cc();
    private static final PendingResultUtil.ResultConverter<Videos.CaptureStateResult, CaptureState> c = new cd();
    private static final PendingResultUtil.ResultConverter<Videos.CaptureCapabilitiesResult, VideoCapabilities> d = new ce();

    /* loaded from: classes.dex */
    public interface OnCaptureOverlayStateListener extends Videos.CaptureOverlayStateListener {
        @Override // com.google.android.gms.games.video.Videos.CaptureOverlayStateListener
        void onCaptureOverlayStateChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideosClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<VideoCapabilities> getCaptureCapabilities() {
        return zzbe.toTask(Games.Videos.getCaptureCapabilities(asGoogleApiClient()), d);
    }

    public Task<Intent> getCaptureOverlayIntent() {
        return doRead(new bx(this));
    }

    public Task<CaptureState> getCaptureState() {
        return zzbe.toTask(Games.Videos.getCaptureState(asGoogleApiClient()), c);
    }

    public Task<Boolean> isCaptureAvailable(int i) {
        return zzbe.toTask(Games.Videos.isCaptureAvailable(asGoogleApiClient(), i), b);
    }

    public Task<Boolean> isCaptureSupported() {
        return doRead(new by(this));
    }

    public Task<Void> registerOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        ListenerHolder<L> registerListener = registerListener(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName());
        return doRegisterEventListener(new bz(this, registerListener, registerListener), new ca(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener onCaptureOverlayStateListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(onCaptureOverlayStateListener, OnCaptureOverlayStateListener.class.getSimpleName()));
    }
}
