package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    final Handler a;
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks b;
    private int e;
    private long f;
    private long g;
    private int h;
    private long i;
    @VisibleForTesting
    private zzh j;
    private final Context k;
    private final Looper l;
    private final GmsClientSupervisor m;
    private final GoogleApiAvailabilityLight n;
    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker q;
    @GuardedBy("mLock")
    private T r;
    @GuardedBy("mLock")
    private zze t;
    private final BaseConnectionCallbacks v;
    private final BaseOnConnectionFailedListener w;
    private final int x;
    private final String y;
    private static final Feature[] d = new Feature[0];
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    private final Object o = new Object();
    private final Object p = new Object();
    private final ArrayList<zzc<?>> s = new ArrayList<>();
    @GuardedBy("mLock")
    private int u = 1;
    private ConnectionResult z = null;
    private boolean A = false;
    private volatile zzb B = null;
    @VisibleForTesting
    protected AtomicInteger c = new AtomicInteger(0);

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        void onConnected(Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.g());
            } else if (BaseGmsClient.this.w == null) {
            } else {
                BaseGmsClient.this.w.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    /* loaded from: classes.dex */
    private abstract class a extends zzc<Boolean> {
        private final int a;
        private final Bundle b;

        protected a(int i, Bundle bundle) {
            super(true);
            this.a = i;
            this.b = bundle;
        }

        protected abstract void a(ConnectionResult connectionResult);

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final /* synthetic */ void a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.b(1, null);
                return;
            }
            int i = this.a;
            if (i == 0) {
                if (a()) {
                    return;
                }
                BaseGmsClient.this.b(1, null);
                a(new ConnectionResult(8, null));
            } else if (i == 10) {
                BaseGmsClient.this.b(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), BaseGmsClient.this.getStartServiceAction(), BaseGmsClient.this.b()));
            } else {
                BaseGmsClient.this.b(1, null);
                Bundle bundle = this.b;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                }
                a(new ConnectionResult(this.a, pendingIntent));
            }
        }

        protected abstract boolean a();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        protected final void b() {
        }
    }

    /* loaded from: classes.dex */
    final class b extends com.google.android.gms.internal.common.zze {
        public b(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.b();
            zzcVar.unregister();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (BaseGmsClient.this.c.get() != message.arg1) {
                if (!b(message)) {
                    return;
                }
                a(message);
            } else if ((message.what == 1 || message.what == 7 || ((message.what == 4 && !BaseGmsClient.this.f()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                a(message);
            } else {
                PendingIntent pendingIntent = null;
                if (message.what == 4) {
                    BaseGmsClient.this.z = new ConnectionResult(message.arg2);
                    if (BaseGmsClient.this.j() && !BaseGmsClient.this.A) {
                        BaseGmsClient.this.b(3, null);
                        return;
                    }
                    ConnectionResult connectionResult = BaseGmsClient.this.z != null ? BaseGmsClient.this.z : new ConnectionResult(8);
                    BaseGmsClient.this.b.onReportServiceBinding(connectionResult);
                    BaseGmsClient.this.onConnectionFailed(connectionResult);
                } else if (message.what == 5) {
                    ConnectionResult connectionResult2 = BaseGmsClient.this.z != null ? BaseGmsClient.this.z : new ConnectionResult(8);
                    BaseGmsClient.this.b.onReportServiceBinding(connectionResult2);
                    BaseGmsClient.this.onConnectionFailed(connectionResult2);
                } else if (message.what == 3) {
                    if (message.obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) message.obj;
                    }
                    ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                    BaseGmsClient.this.b.onReportServiceBinding(connectionResult3);
                    BaseGmsClient.this.onConnectionFailed(connectionResult3);
                } else if (message.what == 6) {
                    BaseGmsClient.this.b(5, null);
                    if (BaseGmsClient.this.v != null) {
                        BaseGmsClient.this.v.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    BaseGmsClient.this.a(5, 1, (int) null);
                } else if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                    a(message);
                } else if (b(message)) {
                    ((zzc) message.obj).zzo();
                } else {
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public abstract class zzc<TListener> {
        private TListener a;
        private boolean b = false;

        public zzc(TListener tlistener) {
            this.a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public final void removeListener() {
            synchronized (this) {
                this.a = null;
            }
        }

        public final void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.s) {
                BaseGmsClient.this.s.remove(this);
            }
        }

        public final void zzo() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            unregister();
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class zzd extends IGmsCallbacks.zza {
        private BaseGmsClient a;
        private final int b;

        public zzd(BaseGmsClient baseGmsClient, int i) {
            this.a = baseGmsClient;
            this.b = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.checkNotNull(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.a(i, iBinder, bundle, this.b);
            this.a = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void zza(int i, IBinder iBinder, zzb zzbVar) {
            Preconditions.checkNotNull(this.a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzbVar);
            this.a.a(zzbVar);
            onPostInitComplete(i, iBinder, zzbVar.a);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public final class zze implements ServiceConnection {
        private final int a;

        public zze(int i) {
            this.a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker aVar;
            if (iBinder == null) {
                BaseGmsClient.this.a(16);
                return;
            }
            synchronized (BaseGmsClient.this.p) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    aVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new IGmsServiceBroker.Stub.a(iBinder) : (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient.q = aVar;
            }
            BaseGmsClient.this.a(0, (Bundle) null, this.a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.p) {
                BaseGmsClient.this.q = null;
            }
            BaseGmsClient.this.a.sendMessage(BaseGmsClient.this.a.obtainMessage(6, this.a, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzf extends a {
        private final IBinder a;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.a = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.w != null) {
                BaseGmsClient.this.w.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            try {
                String interfaceDescriptor = this.a.getInterfaceDescriptor();
                if (!BaseGmsClient.this.b().equals(interfaceDescriptor)) {
                    String b = BaseGmsClient.this.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(b);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface a = BaseGmsClient.this.a(this.a);
                if (a == null) {
                    return false;
                }
                if (!BaseGmsClient.this.a(2, 4, (int) a) && !BaseGmsClient.this.a(3, 4, (int) a)) {
                    return false;
                }
                BaseGmsClient.this.z = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.v != null) {
                    BaseGmsClient.this.v.onConnected(connectionHint);
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzg extends a {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final void a(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.f() && BaseGmsClient.this.j()) {
                BaseGmsClient.this.a(16);
                return;
            }
            BaseGmsClient.this.b.onReportServiceBinding(connectionResult);
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.a
        protected final boolean a() {
            BaseGmsClient.this.b.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.k = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.l = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.m = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.n = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.a = new b(looper);
        this.x = i;
        this.v = baseConnectionCallbacks;
        this.w = baseOnConnectionFailedListener;
        this.y = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        int i2;
        if (i()) {
            i2 = 5;
            this.A = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(i2, this.c.get(), 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzb zzbVar) {
        this.B = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(int i, int i2, T t) {
        synchronized (this.o) {
            if (this.u != i) {
                return false;
            }
            b(i2, t);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, T t) {
        Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.o) {
            this.u = i;
            this.r = t;
            a(i, (int) t);
            switch (i) {
                case 1:
                    if (this.t != null) {
                        this.m.zza(this.j.a(), this.j.b(), this.j.c(), this.t, h());
                        this.t = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (this.t != null && this.j != null) {
                        String a2 = this.j.a();
                        String b2 = this.j.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 70 + String.valueOf(b2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(a2);
                        sb.append(" on ");
                        sb.append(b2);
                        Log.e("GmsClient", sb.toString());
                        this.m.zza(this.j.a(), this.j.b(), this.j.c(), this.t, h());
                        this.c.incrementAndGet();
                    }
                    this.t = new zze(this.c.get());
                    this.j = (this.u != 3 || c() == null) ? new zzh(a(), getStartServiceAction(), false, 129) : new zzh(getContext().getPackageName(), c(), true, 129);
                    if (!this.m.a(new GmsClientSupervisor.zza(this.j.a(), this.j.b(), this.j.c()), this.t, h())) {
                        String a3 = this.j.a();
                        String b3 = this.j.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a3).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a3);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.c.get());
                        break;
                    }
                    break;
                case 4:
                    onConnectedLocked(t);
                    break;
            }
        }
    }

    private final String h() {
        String str = this.y;
        return str == null ? this.k.getClass().getName() : str;
    }

    private final boolean i() {
        boolean z;
        synchronized (this.o) {
            z = this.u == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (!this.A && !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(c())) {
            try {
                Class.forName(b());
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return false;
    }

    @KeepForSdk
    protected abstract T a(IBinder iBinder);

    @KeepForSdk
    protected String a() {
        return "com.google.android.gms";
    }

    protected final void a(int i, Bundle bundle, int i2) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    @KeepForSdk
    void a(int i, T t) {
    }

    @VisibleForTesting
    @KeepForSdk
    protected void a(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(3, this.c.get(), i, pendingIntent));
    }

    @KeepForSdk
    protected abstract String b();

    @KeepForSdk
    protected String c() {
        return null;
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.n.isGooglePlayServicesAvailable(this.k, getMinApkVersion());
        if (isGooglePlayServicesAvailable == 0) {
            connect(new LegacyClientCallbackAdapter());
            return;
        }
        b(1, null);
        a(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, (PendingIntent) null);
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.b = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public Bundle d() {
        return new Bundle();
    }

    @KeepForSdk
    public void disconnect() {
        this.c.incrementAndGet();
        synchronized (this.s) {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                this.s.get(i).removeListener();
            }
            this.s.clear();
        }
        synchronized (this.p) {
            this.q = null;
        }
        b(1, null);
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        String str2;
        String str3;
        synchronized (this.o) {
            i = this.u;
            t = this.r;
        }
        synchronized (this.p) {
            iGmsServiceBroker = this.q;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                str2 = "DISCONNECTED";
                break;
            case 2:
                str2 = "REMOTE_CONNECTING";
                break;
            case 3:
                str2 = "LOCAL_CONNECTING";
                break;
            case 4:
                str2 = "CONNECTED";
                break;
            case 5:
                str2 = "DISCONNECTING";
                break;
            default:
                str2 = "UNKNOWN";
                break;
        }
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) b()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.g > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.g;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.e;
            switch (i2) {
                case 1:
                    str3 = "CAUSE_SERVICE_DISCONNECTED";
                    break;
                case 2:
                    str3 = "CAUSE_NETWORK_LOST";
                    break;
                default:
                    str3 = String.valueOf(i2);
                    break;
            }
            printWriter.append((CharSequence) str3);
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.i > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.h));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.i;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public final void e() {
        if (isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    @KeepForSdk
    protected boolean f() {
        return false;
    }

    @KeepForSdk
    protected Set<Scope> g() {
        return Collections.EMPTY_SET;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return d;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzb zzbVar = this.B;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.b;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    public final Context getContext() {
        return this.k;
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        zzh zzhVar;
        if (!isConnected() || (zzhVar = this.j) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzhVar.b();
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.l;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle d2 = d();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.x);
        getServiceRequest.a = this.k.getPackageName();
        getServiceRequest.d = d2;
        if (set != null) {
            getServiceRequest.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.e = getAccount() != null ? getAccount() : new Account("<<default account>>", AccountType.GOOGLE);
            if (iAccountAccessor != null) {
                getServiceRequest.b = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.e = getAccount();
        }
        getServiceRequest.f = d;
        getServiceRequest.g = getApiFeatures();
        try {
            synchronized (this.p) {
                if (this.q != null) {
                    this.q.getService(new zzd(this, this.c.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(1);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            a(8, (IBinder) null, (Bundle) null, this.c.get());
        }
    }

    @KeepForSdk
    public final T getService() {
        T t;
        synchronized (this.o) {
            if (this.u == 5) {
                throw new DeadObjectException();
            }
            e();
            Preconditions.checkState(this.r != null, "Client is connected but service is null");
            t = this.r;
        }
        return t;
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.p) {
            if (this.q == null) {
                return null;
            }
            return this.q.asBinder();
        }
    }

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    protected abstract String getStartServiceAction();

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.o) {
            z = this.u == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.o) {
            if (this.u != 2 && this.u != 3) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectedLocked(T t) {
        this.g = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.h = connectionResult.getErrorCode();
        this.i = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public void onConnectionSuspended(int i) {
        this.e = i;
        this.f = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(6, this.c.get(), i));
    }
}
