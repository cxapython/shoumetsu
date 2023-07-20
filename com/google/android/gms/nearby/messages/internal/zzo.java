package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.internal.nearby.zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzafVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzafVar);
        b(1, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(List<Update> list) {
        Parcel a = a();
        a.writeTypedList(list);
        b(4, a);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzafVar) {
        Parcel a = a();
        com.google.android.gms.internal.nearby.zzc.zza(a, zzafVar);
        b(2, a);
    }
}
