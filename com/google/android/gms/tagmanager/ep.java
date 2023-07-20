package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.gtm.zzdj;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ep extends zzdj {
    private final ContainerHolder.ContainerAvailableListener a;
    private final /* synthetic */ eo b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(eo eoVar, ContainerHolder.ContainerAvailableListener containerAvailableListener, Looper looper) {
        super(looper);
        this.b = eoVar;
        this.a = containerAvailableListener;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            zzdi.zzav("Don't know how to handle this message.");
            return;
        }
        this.a.onContainerAvailable(this.b, (String) message.obj);
    }
}
