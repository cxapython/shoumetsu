package com.google.firebase.iid;

import com.google.firebase.iid.Registrar;

/* loaded from: classes.dex */
final /* synthetic */ class r implements com.google.firebase.components.g {
    static final com.google.firebase.components.g a = new r();

    private r() {
    }

    @Override // com.google.firebase.components.g
    public final Object a(com.google.firebase.components.e eVar) {
        return new Registrar.a((FirebaseInstanceId) eVar.a(FirebaseInstanceId.class));
    }
}
