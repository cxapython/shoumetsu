package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public final class zzj extends zza implements zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel a = a();
        zzc.zza(a, iObjectWrapper);
        a.writeString(str);
        zzc.writeBoolean(a, z);
        Parcel a2 = a(3, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel a = a();
        zzc.zza(a, iObjectWrapper);
        a.writeString(str);
        a.writeInt(i);
        Parcel a2 = a(2, a);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzak() {
        Parcel a = a(6, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel a = a();
        zzc.zza(a, iObjectWrapper);
        a.writeString(str);
        zzc.writeBoolean(a, z);
        Parcel a2 = a(5, a);
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel a = a();
        zzc.zza(a, iObjectWrapper);
        a.writeString(str);
        a.writeInt(i);
        Parcel a2 = a(4, a);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }
}
