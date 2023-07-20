package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class zabu extends zal {
    private TaskCompletionSource<Void> e;

    private zabu(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.e = new TaskCompletionSource<>();
        this.a.addCallback("GmsAvailabilityHelper", this);
    }

    public static zabu zac(Activity activity) {
        LifecycleFragment fragment = getFragment(activity);
        zabu zabuVar = (zabu) fragment.getCallbackOrNull("GmsAvailabilityHelper", zabu.class);
        if (zabuVar != null) {
            if (zabuVar.e.getTask().isComplete()) {
                zabuVar.e = new TaskCompletionSource<>();
            }
            return zabuVar;
        }
        return new zabu(fragment);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void a() {
        int isGooglePlayServicesAvailable = this.d.isGooglePlayServicesAvailable(this.a.getLifecycleActivity());
        if (isGooglePlayServicesAvailable == 0) {
            this.e.setResult(null);
        } else if (this.e.getTask().isComplete()) {
        } else {
            zab(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        this.e.setException(ApiExceptionUtil.fromStatus(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution())));
    }

    public final Task<Void> getTask() {
        return this.e.getTask();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onDestroy() {
        super.onDestroy();
        this.e.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }
}
