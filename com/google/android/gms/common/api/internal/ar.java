package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar extends zap {
    private final /* synthetic */ zacm a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(zacm zacmVar, Looper looper) {
        super(looper);
        this.a = zacmVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        zacm zacmVar;
        zacm zacmVar2;
        zacm zacmVar3;
        switch (message.what) {
            case 0:
                PendingResult<?> pendingResult = (PendingResult) message.obj;
                obj = this.a.e;
                synchronized (obj) {
                    if (pendingResult == null) {
                        zacmVar3 = this.a.b;
                        zacmVar3.a(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zacd) {
                        zacmVar2 = this.a.b;
                        zacmVar2.a(((zacd) pendingResult).a());
                    } else {
                        zacmVar = this.a.b;
                        zacmVar.zaa(pendingResult);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            default:
                int i = message.what;
                StringBuilder sb = new StringBuilder(70);
                sb.append("TransformationResultHandler received unknown message type: ");
                sb.append(i);
                Log.e("TransformedResultImpl", sb.toString());
                return;
        }
    }
}
