package com.google.android.youtube.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.e.a.d;
import androidx.e.a.e;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.internal.ab;

/* loaded from: classes.dex */
public class YouTubePlayerSupportFragment extends d implements YouTubePlayer.Provider {
    private final a a = new a(this, (byte) 0);
    private Bundle b;
    private YouTubePlayerView c;
    private String d;
    private YouTubePlayer.OnInitializedListener e;
    private boolean f;

    /* loaded from: classes.dex */
    private final class a implements YouTubePlayerView.b {
        private a() {
        }

        /* synthetic */ a(YouTubePlayerSupportFragment youTubePlayerSupportFragment, byte b) {
            this();
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView) {
        }

        @Override // com.google.android.youtube.player.YouTubePlayerView.b
        public final void a(YouTubePlayerView youTubePlayerView, String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
            YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.this;
            youTubePlayerSupportFragment.initialize(str, youTubePlayerSupportFragment.e);
        }
    }

    private void a() {
        YouTubePlayerView youTubePlayerView = this.c;
        if (youTubePlayerView == null || this.e == null) {
            return;
        }
        youTubePlayerView.a(this.f);
        this.c.a(getActivity(), this, this.d, this.e, this.b);
        this.b = null;
        this.e = null;
    }

    public static YouTubePlayerSupportFragment newInstance() {
        return new YouTubePlayerSupportFragment();
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.Provider
    public void initialize(String str, YouTubePlayer.OnInitializedListener onInitializedListener) {
        this.d = ab.a(str, (Object) "Developer key cannot be null or empty");
        this.e = onInitializedListener;
        a();
    }

    @Override // androidx.e.a.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = bundle != null ? bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override // androidx.e.a.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = new YouTubePlayerView(getActivity(), null, 0, this.a);
        a();
        return this.c;
    }

    @Override // androidx.e.a.d
    public void onDestroy() {
        if (this.c != null) {
            e activity = getActivity();
            this.c.b(activity == null || activity.isFinishing());
        }
        super.onDestroy();
    }

    @Override // androidx.e.a.d
    public void onDestroyView() {
        this.c.c(getActivity().isFinishing());
        this.c = null;
        super.onDestroyView();
    }

    @Override // androidx.e.a.d
    public void onPause() {
        this.c.c();
        super.onPause();
    }

    @Override // androidx.e.a.d
    public void onResume() {
        super.onResume();
        this.c.b();
    }

    @Override // androidx.e.a.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        YouTubePlayerView youTubePlayerView = this.c;
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", youTubePlayerView != null ? youTubePlayerView.e() : this.b);
    }

    @Override // androidx.e.a.d
    public void onStart() {
        super.onStart();
        this.c.a();
    }

    @Override // androidx.e.a.d
    public void onStop() {
        this.c.d();
        super.onStop();
    }
}
