package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.base.zac;

/* loaded from: classes.dex */
public interface IResolveAccountCallbacks extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IResolveAccountCallbacks {

        /* loaded from: classes.dex */
        public static class Proxy extends com.google.android.gms.internal.base.zaa implements IResolveAccountCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
            }

            @Override // com.google.android.gms.common.internal.IResolveAccountCallbacks
            public void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse) {
                Parcel a = a();
                zac.zaa(a, resolveAccountResponse);
                b(2, a);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        }

        public static IResolveAccountCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return queryLocalInterface instanceof IResolveAccountCallbacks ? (IResolveAccountCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 2) {
                onAccountResolutionComplete((ResolveAccountResponse) zac.zaa(parcel, ResolveAccountResponse.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return false;
        }
    }

    void onAccountResolutionComplete(ResolveAccountResponse resolveAccountResponse);
}
