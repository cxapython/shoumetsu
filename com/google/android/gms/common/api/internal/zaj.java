package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zaj extends zal {
    private final SparseArray<a> e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GoogleApiClient.OnConnectionFailedListener {
        public final int a;
        public final GoogleApiClient b;
        public final GoogleApiClient.OnConnectionFailedListener c;

        public a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.a = i;
            this.b = googleApiClient;
            this.c = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zaj.this.zab(connectionResult, this.a);
        }
    }

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.e = new SparseArray<>();
        this.a.addCallback("AutoManageHelper", this);
    }

    private final a a(int i) {
        if (this.e.size() <= i) {
            return null;
        }
        SparseArray<a> sparseArray = this.e;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public static zaj zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment a2 = a(lifecycleActivity);
        zaj zajVar = (zaj) a2.getCallbackOrNull("AutoManageHelper", zaj.class);
        return zajVar != null ? zajVar : new zaj(a2);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void a() {
        for (int i = 0; i < this.e.size(); i++) {
            a a2 = a(i);
            if (a2 != null) {
                a2.b.connect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.e.get(i);
        if (aVar == null) {
            return;
        }
        zaa(i);
        GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = aVar.c;
        if (onConnectionFailedListener == null) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.e.size(); i++) {
            a a2 = a(i);
            if (a2 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(a2.a);
                printWriter.println(":");
                a2.b.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        boolean z = this.b;
        String valueOf = String.valueOf(this.e);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.c.get() == null) {
            for (int i = 0; i < this.e.size(); i++) {
                a a2 = a(i);
                if (a2 != null) {
                    a2.b.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.e.size(); i++) {
            a a2 = a(i);
            if (a2 != null) {
                a2.b.disconnect();
            }
        }
    }

    public final void zaa(int i) {
        a aVar = this.e.get(i);
        this.e.remove(i);
        if (aVar != null) {
            aVar.b.unregisterConnectionFailedListener(aVar);
            aVar.b.disconnect();
        }
    }

    public final void zaa(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.e.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        aw awVar = this.c.get();
        boolean z2 = this.b;
        String valueOf = String.valueOf(awVar);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.e.put(i, new a(i, googleApiClient, onConnectionFailedListener));
        if (!this.b || awVar != null) {
            return;
        }
        String valueOf2 = String.valueOf(googleApiClient);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
        sb3.append("connecting ");
        sb3.append(valueOf2);
        Log.d("AutoManageHelper", sb3.toString());
        googleApiClient.connect();
    }
}
