package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dj implements zzfq {
    final /* synthetic */ dg a;
    private Handler b;

    private dj(dg dgVar) {
        Context context;
        this.a = dgVar;
        context = this.a.b;
        this.b = new zzdj(context.getMainLooper(), new dk(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dj(dg dgVar, dh dhVar) {
        this(dgVar);
    }

    private final Message a() {
        Object obj;
        Handler handler = this.b;
        obj = dg.a;
        return handler.obtainMessage(1, obj);
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void cancel() {
        Object obj;
        Handler handler = this.b;
        obj = dg.a;
        handler.removeMessages(1, obj);
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void zzh(long j) {
        Object obj;
        Handler handler = this.b;
        obj = dg.a;
        handler.removeMessages(1, obj);
        this.b.sendMessageDelayed(a(), j);
    }

    @Override // com.google.android.gms.tagmanager.zzfq
    public final void zzjt() {
        Object obj;
        Handler handler = this.b;
        obj = dg.a;
        handler.removeMessages(1, obj);
        this.b.sendMessage(a());
    }
}
