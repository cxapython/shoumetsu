package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.OnChangeListener;

/* loaded from: classes.dex */
public final class bs {
    private OnChangeListener a;
    private DriveId b;
    private zzee c;

    public bs(zzch zzchVar, OnChangeListener onChangeListener, DriveId driveId) {
        Preconditions.checkState(com.google.android.gms.drive.events.zzj.zza(1, driveId));
        this.a = onChangeListener;
        this.b = driveId;
        Looper looper = zzchVar.getLooper();
        Context applicationContext = zzchVar.getApplicationContext();
        onChangeListener.getClass();
        this.c = new zzee(looper, applicationContext, 1, bt.a(onChangeListener));
        this.c.zzf(1);
    }

    public static /* synthetic */ zzee a(bs bsVar) {
        return bsVar.c;
    }
}
