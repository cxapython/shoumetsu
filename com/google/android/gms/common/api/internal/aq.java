package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class aq implements Runnable {
    private final /* synthetic */ Result a;
    private final /* synthetic */ zacm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(zacm zacmVar, Result result) {
        this.b = zacmVar;
        this.a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        ar arVar;
        ar arVar2;
        WeakReference weakReference2;
        ResultTransform resultTransform;
        ar arVar3;
        ar arVar4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.a.set(true);
                resultTransform = this.b.a;
                PendingResult onSuccess = resultTransform.onSuccess(this.a);
                arVar3 = this.b.h;
                arVar4 = this.b.h;
                arVar3.sendMessage(arVar4.obtainMessage(0, onSuccess));
                BasePendingResult.a.set(false);
                zacm zacmVar = this.b;
                zacm.a(this.a);
                weakReference3 = this.b.g;
                GoogleApiClient googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient == null) {
                    return;
                }
                googleApiClient.zab(this.b);
            } catch (RuntimeException e) {
                arVar = this.b.h;
                arVar2 = this.b.h;
                arVar.sendMessage(arVar2.obtainMessage(1, e));
                BasePendingResult.a.set(false);
                zacm zacmVar2 = this.b;
                zacm.a(this.a);
                weakReference2 = this.b.g;
                GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference2.get();
                if (googleApiClient2 == null) {
                    return;
                }
                googleApiClient2.zab(this.b);
            }
        } catch (Throwable th) {
            BasePendingResult.a.set(false);
            zacm zacmVar3 = this.b;
            zacm.a(this.a);
            weakReference = this.b.g;
            GoogleApiClient googleApiClient3 = (GoogleApiClient) weakReference.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.b);
            }
            throw th;
        }
    }
}
