package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzbb implements zzbx {
    private static zzbb a;
    private static final Object b = new Object();
    private cc c;
    private an d;

    private zzbb(Context context) {
        this(ao.a(context), new df());
    }

    @VisibleForTesting
    private zzbb(an anVar, cc ccVar) {
        this.d = anVar;
        this.c = ccVar;
    }

    public static zzbx zzg(Context context) {
        zzbb zzbbVar;
        synchronized (b) {
            if (a == null) {
                a = new zzbb(context);
            }
            zzbbVar = a;
        }
        return zzbbVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbx
    public final boolean zzay(String str) {
        if (!this.c.a()) {
            zzdi.zzac("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        this.d.a(str);
        return true;
    }
}
