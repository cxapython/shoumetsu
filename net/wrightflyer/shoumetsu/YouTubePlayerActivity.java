package net.wrightflyer.shoumetsu;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/* loaded from: classes.dex */
public class YouTubePlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnFullscreenListener, YouTubePlayer.OnInitializedListener, YouTubePlayer.PlayerStateChangeListener {
    public static String EXTRA_KEY_RETURN_STATE = "RETURN_STATE";
    public static String EXTRA_KEY_VIDEO_ID = "VIDEO_ID";
    private static String TAG = "YouTubePlayerActivity";
    private static Boolean sPause = false;
    private static YouTubePlayer sPlayer = null;
    private static String sVideoId = "";
    private static YouTubePlayerView sView;
    private static ApplicationInfo sYouTubeInfo;

    public void errorHandle() {
        if (sYouTubeInfo != null) {
            goToYouTubeApp(sVideoId);
            return;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=" + sVideoId)));
    }

    public YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    public void goToYouTubeApp(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("vnd.youtube:" + str));
        intent.putExtra("VIDEO_ID", str);
        startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        Log.d(str, "onActivityResult:" + i + ":" + i2 + ":" + intent.toString());
        returnMainActivity("FROM_ACTIVITY_RESULT");
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onAdStarted() {
        Log.d(TAG, "onAdStarted");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        returnMainActivity("BACK_PRESS");
    }

    @Override // com.google.android.youtube.player.YouTubeBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate");
        sView = null;
        sPlayer = null;
        sYouTubeInfo = null;
        sVideoId = "";
        sPause = false;
        try {
            sVideoId = getIntent().getStringExtra(EXTRA_KEY_VIDEO_ID);
            if (sVideoId == null || sVideoId == "") {
                returnMainActivity("VIDEO_ID_EMPTY");
            }
            setContentView(R.layout.youtubeview);
            sView = (YouTubePlayerView) findViewById(R.id.youtube_view);
            getWindow().setSoftInputMode(3);
            try {
                sYouTubeInfo = getPackageManager().getApplicationInfo("com.google.android.youtube", 128);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d(TAG, "not found");
            }
            if (sPause.booleanValue()) {
                return;
            }
            try {
                sView.initialize(getString(R.string.youtube_data_api_key), this);
            } catch (Exception unused2) {
                returnMainActivity("EXCEPTION");
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.google.android.youtube.player.YouTubeBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        if (sPause.booleanValue()) {
            returnMainActivity("DESTROY");
        }
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onError(YouTubePlayer.ErrorReason errorReason) {
        String str = TAG;
        Log.d(str, "onError:" + errorReason.toString());
        returnMainActivity("PLAYER_ERROR");
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener
    public void onFullscreen(boolean z) {
        Log.d(TAG, "onFullscreen");
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        String str = TAG;
        Log.d(str, "onInitializationFailure:" + youTubeInitializationResult.toString());
        errorHandle();
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean z) {
        if (z) {
            Log.d(TAG, "onInitializationSuccess:wasRestored");
            return;
        }
        sPlayer = youTubePlayer;
        sPlayer.setPlayerStateChangeListener(this);
        sPlayer.addFullscreenControlFlag(4);
        sPlayer.setOnFullscreenListener(this);
        sPlayer.cueVideo(sVideoId);
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onLoaded(String str) {
        String str2 = TAG;
        Log.d(str2, "onLoaded:" + str);
        sPlayer.play();
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onLoading() {
        Log.d(TAG, "onLoading");
    }

    @Override // com.google.android.youtube.player.YouTubeBaseActivity, android.app.Activity
    public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        sPause = true;
    }

    @Override // com.google.android.youtube.player.YouTubeBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        if (sPause.booleanValue()) {
            returnMainActivity("FROM_RESUME");
        }
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onVideoEnded() {
        Log.d(TAG, "onVideoEnded");
        returnMainActivity("VIDEO_END");
    }

    @Override // com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener
    public void onVideoStarted() {
        Log.d(TAG, "onVideoStarted");
    }

    public void returnMainActivity(String str) {
        sPause = false;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(this, AthenaActivity.class);
        intent.putExtra(EXTRA_KEY_RETURN_STATE, str);
        startActivity(intent);
        finish();
    }
}
