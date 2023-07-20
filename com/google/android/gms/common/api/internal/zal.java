package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference<aw> c;
    protected final GoogleApiAvailability d;
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: protected */
    public zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.c = new AtomicReference<>(null);
        this.e = new zap(Looper.getMainLooper());
        this.d = googleApiAvailability;
    }

    private static int a(aw awVar) {
        if (awVar == null) {
            return -1;
        }
        return awVar.a();
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(ConnectionResult connectionResult, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.c.set(null);
        a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onActivityResult(int i, int i2, Intent intent) {
        aw awVar = this.c.get();
        boolean z = true;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        int i3 = 13;
                        if (intent != null) {
                            i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        aw awVar2 = new aw(new ConnectionResult(i3, null), a(awVar));
                        this.c.set(awVar2);
                        awVar = awVar2;
                    }
                    z = false;
                    break;
                }
                break;
            case 2:
                int isGooglePlayServicesAvailable = this.d.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable != 0) {
                    z = false;
                }
                if (awVar == null) {
                    return;
                }
                if (awVar.b().getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            c();
        } else if (awVar == null) {
        } else {
            a(awVar.b(), awVar.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), a(this.c.get()));
        c();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new aw(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        aw awVar = this.c.get();
        if (awVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", awVar.a());
            bundle.putInt("failed_status", awVar.b().getErrorCode());
            bundle.putParcelable("failed_resolution", awVar.b().getResolution());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.b = false;
    }

    public final void zab(ConnectionResult connectionResult, int i) {
        aw awVar = new aw(connectionResult, i);
        if (this.c.compareAndSet(null, awVar)) {
            this.e.post(new ax(this, awVar));
        }
    }
}
