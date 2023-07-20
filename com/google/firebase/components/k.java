package com.google.firebase.components;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements com.google.firebase.c.a {
    private final Set a;

    private k(Set set) {
        this.a = set;
    }

    public static com.google.firebase.c.a a(Set set) {
        return new k(set);
    }

    @Override // com.google.firebase.c.a
    public Object a() {
        return i.a(this.a);
    }
}
