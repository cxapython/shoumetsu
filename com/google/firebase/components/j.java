package com.google.firebase.components;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements com.google.firebase.c.a {
    private final i a;
    private final b b;

    private j(i iVar, b bVar) {
        this.a = iVar;
        this.b = bVar;
    }

    public static com.google.firebase.c.a a(i iVar, b bVar) {
        return new j(iVar, bVar);
    }

    @Override // com.google.firebase.c.a
    public Object a() {
        Object a;
        a = r1.c().a(new u(this.b, this.a));
        return a;
    }
}
