package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends zze {
    private final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, Looper looper) {
        super(looper);
        this.a = xVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.a(message);
    }
}
