package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements IGmsServiceBroker {
            private final IBinder a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // com.google.android.gms.common.internal.IGmsServiceBroker
            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
            if (r5.readInt() != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00af, code lost:
            if (r5.readInt() != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
            if (r5.readInt() != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00c1, code lost:
            android.os.Bundle.CREATOR.createFromParcel(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d5, code lost:
            if (r5.readInt() != 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00dc, code lost:
            if (r5.readInt() == 0) goto L43;
         */
        @Override // android.os.Binder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IGmsCallbacks zzlVar;
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            GetServiceRequest getServiceRequest = null;
            if (readStrongBinder == null) {
                zzlVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                zzlVar = queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new zzl(readStrongBinder);
            }
            if (i == 46) {
                if (parcel.readInt() != 0) {
                    getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                getService(zzlVar, getServiceRequest);
                parcel2.writeNoException();
                return true;
            } else if (i == 47) {
                if (parcel.readInt() != 0) {
                    zzr.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            } else {
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                }
                if (i != 23 && i != 25 && i != 27) {
                    if (i != 30) {
                        if (i == 34) {
                            parcel.readString();
                        } else if (i != 41 && i != 43) {
                            switch (i) {
                                case 1:
                                    parcel.readString();
                                    parcel.createStringArray();
                                    parcel.readString();
                                    break;
                                default:
                                    switch (i) {
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                            break;
                                        case 9:
                                            parcel.readString();
                                            parcel.createStringArray();
                                            parcel.readString();
                                            parcel.readStrongBinder();
                                            parcel.readString();
                                            break;
                                        case 10:
                                            parcel.readString();
                                            parcel.createStringArray();
                                            break;
                                        case 19:
                                            parcel.readStrongBinder();
                                            break;
                                        case 20:
                                            break;
                                        default:
                                            switch (i) {
                                            }
                                    }
                                case 2:
                                    break;
                            }
                        }
                        throw new UnsupportedOperationException();
                    }
                    parcel.createStringArray();
                    parcel.readString();
                }
            }
        }
    }

    @KeepForSdk
    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
