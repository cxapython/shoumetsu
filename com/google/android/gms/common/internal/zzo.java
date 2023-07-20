package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* loaded from: classes.dex */
public final class zzo extends zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final boolean zza(com.google.android.gms.common.zzk zzkVar, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        com.google.android.gms.internal.common.zzc.zza(a, zzkVar);
        com.google.android.gms.internal.common.zzc.zza(a, iObjectWrapper);
        Parcel a2 = a(5, a);
        boolean zza = com.google.android.gms.internal.common.zzc.zza(a2);
        a2.recycle();
        return zza;
    }
}
