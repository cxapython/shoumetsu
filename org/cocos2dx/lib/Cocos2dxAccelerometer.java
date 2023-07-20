package org.cocos2dx.lib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class Cocos2dxAccelerometer implements SensorEventListener {
    static final float ALPHA = 0.25f;
    private static final String TAG = "Cocos2dxAccelerometer";
    final float[] accelerometerValues = new float[3];
    final float[] compassFieldValues = new float[3];
    private final Sensor mAccelerometer;
    private final Sensor mCompass;
    private final Context mContext;
    private final int mNaturalOrientation;
    private final SensorManager mSensorManager;

    public Cocos2dxAccelerometer(Context context) {
        this.mContext = context;
        this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mAccelerometer = this.mSensorManager.getDefaultSensor(1);
        this.mCompass = this.mSensorManager.getDefaultSensor(2);
        this.mNaturalOrientation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    public static native void onSensorChanged(float f, float f2, float f3, long j);

    public void disable() {
        this.mSensorManager.unregisterListener(this);
    }

    public void enableAccel() {
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
    }

    public void enableCompass() {
        this.mSensorManager.registerListener(this, this.mCompass, 1);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            if (sensorEvent.sensor.getType() != 2) {
                return;
            }
            this.compassFieldValues[0] = sensorEvent.values[0];
            this.compassFieldValues[1] = sensorEvent.values[1];
            this.compassFieldValues[2] = sensorEvent.values[2];
            return;
        }
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        float[] fArr = this.accelerometerValues;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 2 && this.mNaturalOrientation != 0) {
            float f4 = -f2;
            f2 = f;
            f = f4;
        } else if (i == 1 && this.mNaturalOrientation != 0) {
            f2 = -f;
            f = f2;
        }
        int rotation = Cocos2dxHelper.getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 2 || rotation == 3) {
            f = -f;
            f2 = -f2;
        }
        Cocos2dxGLSurfaceView.queueAccelerometer(f, f2, f3, sensorEvent.timestamp);
    }

    public void setInterval(float f) {
        if (Build.VERSION.SDK_INT < 11) {
            this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
        } else {
            this.mSensorManager.registerListener(this, this.mAccelerometer, (int) (f * 1000000.0f));
        }
    }
}
