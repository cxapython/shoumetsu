package com.google.firebase;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements com.google.firebase.c.a {
    private final b a;
    private final Context b;

    private c(b bVar, Context context) {
        this.a = bVar;
        this.b = context;
    }

    public static com.google.firebase.c.a a(b bVar, Context context) {
        return new c(bVar, context);
    }

    @Override // com.google.firebase.c.a
    public Object a() {
        return b.a(this.a, this.b);
    }
}
