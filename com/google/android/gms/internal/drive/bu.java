package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu extends zzl {
    private final ListenerToken a;
    private final ListenerHolder<OpenFileCallback> b;
    private final /* synthetic */ zzch c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(zzch zzchVar, ListenerToken listenerToken, ListenerHolder<OpenFileCallback> listenerHolder) {
        this.c = zzchVar;
        this.a = listenerToken;
        this.b = listenerHolder;
    }

    private final void a(bq<OpenFileCallback> bqVar) {
        this.b.notifyListener(new by(this, bqVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Status status, OpenFileCallback openFileCallback) {
        openFileCallback.onError(ApiExceptionUtil.fromStatus(status));
        this.c.cancelOpenFileCallback(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzfb zzfbVar, OpenFileCallback openFileCallback) {
        openFileCallback.onContents(new zzbi(zzfbVar.a));
        this.c.cancelOpenFileCallback(this.a);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        a(new bq(this, status) { // from class: com.google.android.gms.internal.drive.bv
            private final bu a;
            private final Status b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = status;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                this.a.a(this.b, (OpenFileCallback) obj);
            }
        });
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfb zzfbVar) {
        a(new bq(this, zzfbVar) { // from class: com.google.android.gms.internal.drive.bx
            private final bu a;
            private final zzfb b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = zzfbVar;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                this.a.a(this.b, (OpenFileCallback) obj);
            }
        });
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzff zzffVar) {
        a(new bq(zzffVar) { // from class: com.google.android.gms.internal.drive.bw
            private final zzff a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = zzffVar;
            }

            @Override // com.google.android.gms.internal.drive.bq
            public final void a(Object obj) {
                zzff zzffVar2 = this.a;
                ((OpenFileCallback) obj).onProgress(zzffVar2.a, zzffVar2.b);
            }
        });
    }
}
