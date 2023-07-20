package net.wrightflyer.shoumetsu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.a.a.f;

/* loaded from: classes.dex */
public class AthenaImageView extends ImageView implements View.OnClickListener {
    private static final int LOGO_HEIGHT = 36;
    private static final int LOGO_MERGIN_TOP = 35;
    private static final int LOGO_WIDTH = 162;
    private static final int SHADOW_HEIGHT = 21;
    private static final String TAG = "AthenaImageView";
    private static AthenaActivity sActivity;
    private static BitmapDrawable sBottomDraw;
    private static BitmapDrawable sBottomShadowDraw;
    private static BitmapDrawable sLeftDraw;
    private static BitmapDrawable sLeftShadowDraw;
    private static BitmapDrawable sLogoDraw;
    private static BitmapDrawable sRightDraw;
    private static BitmapDrawable sRightShadowDraw;
    private static BitmapDrawable sTopDraw;
    private static BitmapDrawable sTopShadowDraw;
    public float GameScale;
    public Point GameSize;
    public DisplayMetrics Metrics;
    public Rect Padding;

    public AthenaImageView(Context context) {
        super(context);
    }

    private void initView() {
        AthenaActivity athenaActivity = sActivity;
        if (athenaActivity != null) {
            try {
                Point availableDisplayPoint = athenaActivity.getAvailableDisplayPoint();
                AthenaActivity athenaActivity2 = sActivity;
                AthenaActivity athenaActivity3 = sActivity;
                this.GameScale = Math.min(availableDisplayPoint.x / 1136.0f, availableDisplayPoint.y / 640.0f);
                AthenaActivity athenaActivity4 = sActivity;
                int round = Math.round(this.GameScale * 1386.0f);
                AthenaActivity athenaActivity5 = sActivity;
                this.GameSize = new Point(round, Math.round(this.GameScale * 640.0f));
                int ceil = (int) Math.ceil((availableDisplayPoint.y - this.GameSize.y) * 0.5f);
                int ceil2 = (int) Math.ceil((availableDisplayPoint.x - this.GameSize.x) * 0.5f);
                if (ceil < 0) {
                    ceil = 0;
                }
                if (ceil2 < 0) {
                    ceil2 = 0;
                }
                this.Padding = new Rect(ceil2, ceil, ceil2, ceil);
                Log.d(TAG, "vx:" + availableDisplayPoint.x);
                Log.d(TAG, "vy:" + availableDisplayPoint.y);
                Log.d(TAG, "gs:" + this.GameScale);
                Log.d(TAG, "gx:" + this.GameSize.x);
                Log.d(TAG, "gy:" + this.GameSize.y);
                Log.d(TAG, "pd:" + ceil);
                Log.d(TAG, "pdLR:" + ceil2);
                if (this.Padding.top > 0) {
                    sTopDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.top, null);
                    sTopShadowDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.shadow_top, null);
                }
                if (this.Padding.bottom > 0) {
                    sBottomDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.bottom, null);
                    sBottomShadowDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.shadow_bottom, null);
                    if (this.Padding.bottom >= Math.round(53.0f)) {
                        sLogoDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.logo, null);
                    }
                }
                if (this.Padding.left > 0) {
                    sLeftDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.left, null);
                    sLeftShadowDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.shadow_left, null);
                }
                if (this.Padding.right > 0) {
                    sRightDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.right, null);
                    sRightShadowDraw = (BitmapDrawable) f.a(sActivity.getResources(), R.drawable.shadow_right, null);
                }
                this.Metrics = new DisplayMetrics();
                sActivity.getWindowManager().getDefaultDisplay().getMetrics(this.Metrics);
                Log.d(TAG, "density=" + this.Metrics.density);
                Log.d(TAG, "densityDpi=" + this.Metrics.densityDpi);
                Log.d(TAG, "scaledDensity=" + this.Metrics.scaledDensity);
                Log.d(TAG, "widthPixels=" + this.Metrics.widthPixels);
                Log.d(TAG, "heightPixels=" + this.Metrics.heightPixels);
                Log.d(TAG, "xDpi=" + this.Metrics.xdpi);
                Log.d(TAG, "yDpi=" + this.Metrics.ydpi);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                sActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                Log.d(TAG, "MetricW=" + i + " | MetricH=" + i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        if (view != null) {
            switch (view.getId()) {
                case R.drawable.bottom /* 2131099732 */:
                    str = TAG;
                    str2 = "touch bottom";
                    break;
                case R.drawable.logo /* 2131099756 */:
                    str = TAG;
                    str2 = "touch logo";
                    break;
                case R.drawable.shadow_bottom /* 2131099772 */:
                    str = TAG;
                    str2 = "touch bottom shadow";
                    break;
                case R.drawable.shadow_top /* 2131099775 */:
                    str = TAG;
                    str2 = "touch top shadow";
                    break;
                case R.drawable.top /* 2131099778 */:
                    str = TAG;
                    str2 = "touch top";
                    break;
                default:
                    return;
            }
            Log.d(str, str2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int ceil = (int) Math.ceil(this.Metrics.densityDpi * (this.GameScale / this.Metrics.density));
        int ceil2 = (int) Math.ceil(this.GameScale * 1.0f);
        BitmapDrawable bitmapDrawable = sTopDraw;
        if (bitmapDrawable != null) {
            bitmapDrawable.setGravity(83);
            sTopDraw.setBounds(this.Padding.left, (this.Padding.bottom + this.GameSize.y) - ceil2, this.GameSize.x, this.Padding.top + ceil2);
            sTopDraw.setTargetDensity(ceil);
            sTopDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable2 = sTopShadowDraw;
        if (bitmapDrawable2 != null) {
            bitmapDrawable2.setGravity(83);
            sTopShadowDraw.setBounds(this.Padding.left, (this.Padding.bottom + this.GameSize.y) - ceil2, this.GameSize.x, this.Padding.top + ceil2);
            sTopShadowDraw.setTargetDensity(ceil);
            sTopShadowDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable3 = sBottomDraw;
        if (bitmapDrawable3 != null) {
            bitmapDrawable3.setGravity(51);
            sBottomDraw.setBounds(this.Padding.left, this.Padding.top + this.GameSize.y, this.GameSize.x, this.Padding.bottom);
            sBottomDraw.setTargetDensity(ceil);
            sBottomDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable4 = sBottomShadowDraw;
        if (bitmapDrawable4 != null) {
            bitmapDrawable4.setGravity(51);
            sBottomShadowDraw.setBounds(this.Padding.left, this.Padding.top + this.GameSize.y, this.GameSize.x, 21);
            sBottomShadowDraw.setTargetDensity(ceil);
            sBottomShadowDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable5 = sLogoDraw;
        if (bitmapDrawable5 != null) {
            bitmapDrawable5.setGravity(51);
            sLogoDraw.setTargetDensity(ceil);
            sLogoDraw.setBounds(this.Padding.left + Math.round((this.GameSize.x * 0.5f) - ((this.GameScale * 162.0f) * 0.5f)), this.Padding.top + this.GameSize.y + Math.round(this.GameScale * 35.0f), Math.round(this.GameScale * 162.0f), Math.round(this.GameScale * 36.0f));
            sLogoDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable6 = sLeftDraw;
        if (bitmapDrawable6 != null) {
            bitmapDrawable6.setGravity(53);
            sLeftDraw.setBounds(this.Padding.left, 0, this.Padding.left, this.GameSize.y);
            sLeftDraw.setTargetDensity(ceil);
            sLeftDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable7 = sLeftShadowDraw;
        if (bitmapDrawable7 != null) {
            bitmapDrawable7.setGravity(53);
            sLeftShadowDraw.setBounds(this.Padding.left, 0, this.Padding.left, this.GameSize.y);
            sLeftShadowDraw.setTargetDensity(ceil);
            sLeftShadowDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable8 = sRightDraw;
        if (bitmapDrawable8 != null) {
            bitmapDrawable8.setGravity(51);
            sRightDraw.setBounds(this.Padding.left + this.GameSize.x, 0, this.Padding.right, this.GameSize.y);
            sRightDraw.setTargetDensity(ceil);
            sRightDraw.draw(canvas);
        }
        BitmapDrawable bitmapDrawable9 = sRightShadowDraw;
        if (bitmapDrawable9 != null) {
            bitmapDrawable9.setGravity(51);
            sRightShadowDraw.setBounds(this.Padding.left + this.GameSize.x, 0, this.Padding.right, this.GameSize.y);
            sRightShadowDraw.setTargetDensity(ceil);
            sRightShadowDraw.draw(canvas);
        }
    }

    public void setActivity(AthenaActivity athenaActivity) {
        sActivity = athenaActivity;
        initView();
    }
}
