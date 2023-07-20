package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzew extends zza implements zzeu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IEventReleaseCallback");
    }

    @Override // com.google.android.gms.internal.drive.zzeu
    public final void zza(boolean z) {
        Parcel a = a();
        zzc.zza(a, z);
        c(1, a);
    }
}
