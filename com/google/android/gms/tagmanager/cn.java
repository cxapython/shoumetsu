package com.google.android.gms.tagmanager;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn implements co {
    private final /* synthetic */ cl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cl clVar) {
        this.a = clVar;
    }

    @Override // com.google.android.gms.tagmanager.co
    public final ck a(k kVar) {
        Context context;
        String str;
        context = this.a.b;
        str = this.a.a;
        return new ck(context, str, kVar);
    }
}
