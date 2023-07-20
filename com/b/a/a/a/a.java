package com.b.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.b.a.a.b.a;
import com.b.a.a.b.b;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends com.b.a.a.a.b {
    private static d b;
    private static g c;
    private static f d;
    private static e e;
    private static h f;
    private static final Object l = new Object();
    private com.b.a.a.b.a a;
    private Context g;
    private boolean h = false;
    private b i = b.DISCONNECT;
    private boolean j = false;
    private ServiceConnection k = new ServiceConnectionC0039a();
    private Handler m = new Handler();
    private b.a n = new b.a() { // from class: com.b.a.a.a.a.1
        @Override // com.b.a.a.b.b
        public void a(int i, String str, String str2, Map map) {
            if (a.b != null) {
                a.b.onAuthorizeLicenseResult(i, str, str2, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void a(int i, String str, Map map) {
            if (a.e != null) {
                a.e.a(i, str, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void a(int i, Map map) {
            if (a.c != null) {
                a.c.a(i, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void b(int i, String str, String str2, Map map) {
            if (a.d != null) {
                a.d.onIssueReceiptResult(i, str, str2, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void b(int i, Map map) {
            if (a.c != null) {
                a.c.b(i, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void c(int i, String str, String str2, Map map) {
            if (a.d != null) {
                a.d.onUpdateReceiptResult(i, str, str2, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void c(int i, Map map) {
            if (a.d != null) {
                a.d.onInvalidateItemResult(i, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void d(int i, String str, String str2, Map map) {
            if (a.d != null) {
                a.d.onConfirmReceiptResult(i, str, str2, map);
            }
        }

        @Override // com.b.a.a.b.b
        public void e(int i, String str, String str2, Map map) {
            if (a.f != null) {
                a.f.a(i, str, str2, map);
            }
        }
    };

    /* renamed from: com.b.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class ServiceConnectionC0039a implements ServiceConnection {
        private c b;

        public ServiceConnectionC0039a() {
        }

        public void a(c cVar) {
            this.b = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.l) {
                a.this.i = b.CONNECTING;
                a.this.a = a.AbstractBinderC0040a.a(iBinder);
                if (a.this.a == null) {
                    if (this.b != null) {
                        this.b.a(-99);
                    }
                    a.this.i = b.DISCONNECT;
                    return;
                }
                a.this.i = b.CONNECTED;
                if (this.b != null) {
                    this.b.b();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(-98);
            }
            a.this.a = null;
            a.this.i = b.DISCONNECT;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        DISCONNECT,
        CONNECTING,
        CONNECTED;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            int length = valuesCustom.length;
            b[] bVarArr = new b[length];
            System.arraycopy(valuesCustom, 0, bVarArr, 0, length);
            return bVarArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(int i);

        void b();
    }

    /* loaded from: classes.dex */
    public interface d {
        void onAuthorizeLicenseResult(int i, String str, String str2, Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(int i, String str, Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface f {
        void onConfirmReceiptResult(int i, String str, String str2, Map<String, Object> map);

        void onInvalidateItemResult(int i, Map<String, Object> map);

        void onIssueReceiptResult(int i, String str, String str2, Map<String, Object> map);

        void onUpdateReceiptResult(int i, String str, String str2, Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(int i, Map<String, Object> map);

        void b(int i, Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(int i, String str, String str2, Map<String, Object> map);
    }

    private void a(final c cVar) {
        this.m.post(new Runnable() { // from class: com.b.a.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.l) {
                    cVar.a();
                    if (a.this.a != null) {
                        cVar.b();
                    } else if (a.this.a == null && b.CONNECTING == a.this.i) {
                        ((ServiceConnectionC0039a) a.this.k).a(cVar);
                    } else {
                        cVar.a(-99);
                        a.this.i = b.DISCONNECT;
                    }
                }
            }
        });
    }

    private Intent g() {
        Intent intent = new Intent(com.b.a.a.b.a.class.getName());
        if (Build.VERSION.SDK_INT >= 21) {
            intent.setPackage("com.kddi.market");
        }
        return intent;
    }

    public int a(Context context) {
        this.g = context;
        try {
            if (!b(context)) {
                return -1;
            }
            context.startService(g());
            if (b.DISCONNECT == this.i) {
                this.i = b.CONNECTING;
            }
            boolean bindService = context.bindService(g(), this.k, 1);
            this.h = true;
            if (!bindService) {
                this.i = b.DISCONNECT;
            }
            return bindService ? 0 : -99;
        } catch (SecurityException unused) {
            this.i = b.DISCONNECT;
            return -2;
        }
    }

    public void a(final String str, final d dVar, final long j, final String str2) {
        if (dVar != null) {
            a(new c() { // from class: com.b.a.a.a.a.3
                @Override // com.b.a.a.a.a.c
                public void a() {
                    a.b = dVar;
                }

                @Override // com.b.a.a.a.a.c
                public void a(int i) {
                    dVar.onAuthorizeLicenseResult(i, null, null, null);
                }

                @Override // com.b.a.a.a.a.c
                public void b() {
                    try {
                        a.this.a.a(str, a.this.n, j, str2);
                    } catch (DeadObjectException unused) {
                        a(-99);
                        a.this.i = b.DISCONNECT;
                    } catch (RemoteException unused2) {
                        a(-99);
                    }
                }
            });
            return;
        }
        throw new NullPointerException();
    }

    public void a(final String str, final d dVar, final String str2) {
        if (dVar != null) {
            a(new c() { // from class: com.b.a.a.a.a.4
                @Override // com.b.a.a.a.a.c
                public void a() {
                    a.b = dVar;
                }

                @Override // com.b.a.a.a.a.c
                public void a(int i) {
                    dVar.onAuthorizeLicenseResult(i, null, null, null);
                }

                @Override // com.b.a.a.a.a.c
                public void b() {
                    try {
                        a.this.a.a(str, a.this.n, str2);
                    } catch (DeadObjectException unused) {
                        a(-99);
                        a.this.i = b.DISCONNECT;
                    } catch (RemoteException unused2) {
                        a(-99);
                    }
                }
            });
            return;
        }
        throw new NullPointerException();
    }

    public void a(final String str, final f fVar, final String str2, final String str3, final String str4) {
        if (fVar != null) {
            a(new c() { // from class: com.b.a.a.a.a.5
                @Override // com.b.a.a.a.a.c
                public void a() {
                    a.d = fVar;
                }

                @Override // com.b.a.a.a.a.c
                public void a(int i) {
                    fVar.onIssueReceiptResult(i, null, null, null);
                }

                @Override // com.b.a.a.a.a.c
                public void b() {
                    try {
                        a.this.a.a(str, a.this.n, str2, str3, str4, 1);
                    } catch (DeadObjectException unused) {
                        a(-99);
                        a.this.i = b.DISCONNECT;
                    } catch (RemoteException unused2) {
                        a(-99);
                    }
                }
            });
            return;
        }
        throw new NullPointerException();
    }

    public void a(final String str, final f fVar, final String str2, final String str3, final String str4, final int i) {
        if (fVar != null) {
            a(new c() { // from class: com.b.a.a.a.a.6
                @Override // com.b.a.a.a.a.c
                public void a() {
                    a.d = fVar;
                }

                @Override // com.b.a.a.a.a.c
                public void a(int i2) {
                    fVar.onConfirmReceiptResult(i2, null, null, null);
                }

                @Override // com.b.a.a.a.a.c
                public void b() {
                    try {
                        a.this.a.b(str, a.this.n, str2, str3, str4, i);
                    } catch (DeadObjectException unused) {
                        a(-99);
                        a.this.i = b.DISCONNECT;
                    } catch (RemoteException unused2) {
                        a(-99);
                    }
                }
            });
            return;
        }
        throw new NullPointerException();
    }

    public void b(final String str, final f fVar, final String str2, final String str3, final String str4) {
        if (fVar != null) {
            a(new c() { // from class: com.b.a.a.a.a.7
                @Override // com.b.a.a.a.a.c
                public void a() {
                    a.d = fVar;
                }

                @Override // com.b.a.a.a.a.c
                public void a(int i) {
                    fVar.onInvalidateItemResult(i, null);
                }

                @Override // com.b.a.a.a.a.c
                public void b() {
                    try {
                        a.this.a.c(str, a.this.n, str2, str3, str4, 9);
                    } catch (RemoteException unused) {
                        a(-99);
                    }
                }
            });
            return;
        }
        throw new NullPointerException();
    }
}
