package com.b.a.a.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

/* loaded from: classes.dex */
public interface b extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.b.a.a.b.b$a$a */
        /* loaded from: classes.dex */
        public static class C0042a implements b {
            private IBinder a;

            C0042a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.b.a.a.b.b
            public void a(int i, String str, String str2, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void a(int i, String str, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void a(int i, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeMap(map);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.b.a.a.b.b
            public void b(int i, String str, String str2, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void b(int i, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeMap(map);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void c(int i, String str, String str2, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void c(int i, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeMap(map);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void d(int i, String str, String str2, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.b.a.a.b.b
            public void e(int i, String str, String str2, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0042a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    a(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    a(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    b(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    b(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    c(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    d(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    c(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    a(parcel.readInt(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.kddi.market.alml.service.IAppAuthorizeServiceCallback");
                    e(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, String str, String str2, Map map);

    void a(int i, String str, Map map);

    void a(int i, Map map);

    void b(int i, String str, String str2, Map map);

    void b(int i, Map map);

    void c(int i, String str, String str2, Map map);

    void c(int i, Map map);

    void d(int i, String str, String str2, Map map);

    void e(int i, String str, String str2, Map map);
}
