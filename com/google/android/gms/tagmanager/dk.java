package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dk implements Handler.Callback {
    private final /* synthetic */ dj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar) {
        this.a = djVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj;
        boolean d;
        int i;
        if (1 == message.what) {
            obj = dg.a;
            if (obj.equals(message.obj)) {
                this.a.a.dispatch();
                d = this.a.a.d();
                if (!d) {
                    dj djVar = this.a;
                    i = djVar.a.e;
                    djVar.zzh(i);
                }
            }
        }
        return true;
    }
}
