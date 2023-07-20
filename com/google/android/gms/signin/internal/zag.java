package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) {
        Parcel a = a();
        com.google.android.gms.internal.base.zac.zaa(a, iAccountAccessor);
        a.writeInt(i);
        com.google.android.gms.internal.base.zac.writeBoolean(a, z);
        b(9, a);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(zah zahVar, zad zadVar) {
        Parcel a = a();
        com.google.android.gms.internal.base.zac.zaa(a, zahVar);
        com.google.android.gms.internal.base.zac.zaa(a, zadVar);
        b(12, a);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zam(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(7, a);
    }
}
