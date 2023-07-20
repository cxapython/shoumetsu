package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/* loaded from: classes.dex */
public class YouTubeBaseActivity extends Activity {
    private a a;
    private YouTubePlayerView b;
    private int c;
    private Bundle d;

    /* loaded from: classes.dex */
    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubeBaseActivity youTubeBaseActivity, byte b) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
            if (YouTubeBaseActivity.this.b != null && YouTubeBaseActivity.this.b != youTubePlayerView) {
                YouTubeBaseActivity.this.b.c(true);
            }
            YouTubeBaseActivity.this.b = youTubePlayerView;
            if (YouTubeBaseActivity.this.c > 0) {
                youTubePlayerView.a();
            }
            if (YouTubeBaseActivity.this.c >= 2) {
                youTubePlayerView.b();
            }
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            YouTubeBaseActivity youTubeBaseActivity = YouTubeBaseActivity.this;
            youTubePlayerView.a(youTubeBaseActivity, youTubePlayerView, str, onInitializedListener, youTubeBaseActivity.d);
            YouTubeBaseActivity.this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final YouTubePlayerView.b a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this, (byte) 0);
        this.d = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b(isFinishing());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        this.c = 1;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.c();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.c = 2;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.b();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.b;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", youTubePlayerView != null ? youTubePlayerView.e() : this.d);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.c = 1;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.c = 0;
        YouTubePlayerView youTubePlayerView = this.b;
        if (youTubePlayerView != null) {
            youTubePlayerView.d();
        }
        super.onStop();
    }
}
