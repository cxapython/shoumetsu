package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends zzb implements IFragmentWrapper {

        /* loaded from: classes.dex */
        public static class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final Bundle getArguments() {
                Parcel a = a(3, a());
                Bundle bundle = (Bundle) zzc.zza(a, Bundle.CREATOR);
                a.recycle();
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int getId() {
                Parcel a = a(4, a());
                int readInt = a.readInt();
                a.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean getRetainInstance() {
                Parcel a = a(7, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final String getTag() {
                Parcel a = a(8, a());
                String readString = a.readString();
                a.recycle();
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int getTargetRequestCode() {
                Parcel a = a(10, a());
                int readInt = a.readInt();
                a.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean getUserVisibleHint() {
                Parcel a = a(11, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isAdded() {
                Parcel a = a(13, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isDetached() {
                Parcel a = a(14, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isHidden() {
                Parcel a = a(15, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isInLayout() {
                Parcel a = a(16, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isRemoving() {
                Parcel a = a(17, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isResumed() {
                Parcel a = a(18, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isVisible() {
                Parcel a = a(19, a());
                boolean zza = zzc.zza(a);
                a.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setHasOptionsMenu(boolean z) {
                Parcel a = a();
                zzc.writeBoolean(a, z);
                b(21, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setMenuVisibility(boolean z) {
                Parcel a = a();
                zzc.writeBoolean(a, z);
                b(22, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setRetainInstance(boolean z) {
                Parcel a = a();
                zzc.writeBoolean(a, z);
                b(23, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setUserVisibleHint(boolean z) {
                Parcel a = a();
                zzc.writeBoolean(a, z);
                b(24, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void startActivity(Intent intent) {
                Parcel a = a();
                zzc.zza(a, intent);
                b(25, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void startActivityForResult(Intent intent, int i) {
                Parcel a = a();
                zzc.zza(a, intent);
                a.writeInt(i);
                b(26, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(IObjectWrapper iObjectWrapper) {
                Parcel a = a();
                zzc.zza(a, iObjectWrapper);
                b(20, a);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzae() {
                Parcel a = a(2, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
                a.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzaf() {
                Parcel a = a(5, a());
                IFragmentWrapper asInterface = Stub.asInterface(a.readStrongBinder());
                a.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzag() {
                Parcel a = a(6, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
                a.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzah() {
                Parcel a = a(9, a());
                IFragmentWrapper asInterface = Stub.asInterface(a.readStrongBinder());
                a.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzai() {
                Parcel a = a(12, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
                a.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(IObjectWrapper iObjectWrapper) {
                Parcel a = a();
                zzc.zza(a, iObjectWrapper);
                b(27, a);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface zzae;
            int id;
            boolean retainInstance;
            switch (i) {
                case 2:
                    zzae = zzae();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    return true;
                case 4:
                    id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 5:
                    zzae = zzaf();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 6:
                    zzae = zzag();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 7:
                    retainInstance = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                case 9:
                    zzae = zzah();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 10:
                    id = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 11:
                    retainInstance = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 12:
                    zzae = zzai();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 13:
                    retainInstance = isAdded();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 14:
                    retainInstance = isDetached();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 15:
                    retainInstance = isHidden();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 16:
                    retainInstance = isInLayout();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 17:
                    retainInstance = isRemoving();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 18:
                    retainInstance = isResumed();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 19:
                    retainInstance = isVisible();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 20:
                    zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    startActivity((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    Bundle getArguments();

    int getId();

    boolean getRetainInstance();

    String getTag();

    int getTargetRequestCode();

    boolean getUserVisibleHint();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isRemoving();

    boolean isResumed();

    boolean isVisible();

    void setHasOptionsMenu(boolean z);

    void setMenuVisibility(boolean z);

    void setRetainInstance(boolean z);

    void setUserVisibleHint(boolean z);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int i);

    void zza(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzae();

    IFragmentWrapper zzaf();

    IObjectWrapper zzag();

    IFragmentWrapper zzah();

    IObjectWrapper zzai();

    void zzb(IObjectWrapper iObjectWrapper);
}
