package com.google.firebase.components;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {
    private final Map.Entry a;
    private final com.google.firebase.b.a b;

    private r(Map.Entry entry, com.google.firebase.b.a aVar) {
        this.a = entry;
        this.b = aVar;
    }

    public static Runnable a(Map.Entry entry, com.google.firebase.b.a aVar) {
        return new r(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((com.google.firebase.b.b) this.a.getKey()).a(this.b);
    }
}
