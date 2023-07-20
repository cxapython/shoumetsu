package net.wrightflyer.shoumetsu;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {
    private final String TAG = "OnSwipeTouchListener";
    private final GestureDetector gestureDetector;

    /* loaded from: classes.dex */
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return OnSwipeTouchListener.this.onDownEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            try {
                float y = motionEvent2.getY() - motionEvent.getY();
                float x = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x) > Math.abs(y)) {
                    if (Math.abs(x) <= 100.0f) {
                        return false;
                    }
                    int i = (Math.abs(f) > 100.0f ? 1 : (Math.abs(f) == 100.0f ? 0 : -1));
                    return false;
                } else if (Math.abs(y) <= 100.0f || Math.abs(f2) <= 100.0f) {
                    return false;
                } else {
                    if (y > 0.0f) {
                        if (f2 > 0.0f) {
                            f2 *= -1.0f;
                        }
                        OnSwipeTouchListener.this.onSwipeTop(motionEvent, motionEvent2, f, f2);
                    } else {
                        if (f2 < 0.0f) {
                            f2 = Math.abs(f2);
                        }
                        OnSwipeTouchListener.this.onSwipeBottom(motionEvent, motionEvent2, f, f2);
                    }
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public OnSwipeTouchListener(Context context) {
        this.gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public boolean onDownEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onSwipeBottom(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public void onSwipeLeft(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public void onSwipeRight(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    public void onSwipeTop(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }
}
