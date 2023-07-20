package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes.dex */
public final class Registrar implements com.google.firebase.components.h {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.google.firebase.iid.a.a {
        private final FirebaseInstanceId a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.a = firebaseInstanceId;
        }
    }

    @Override // com.google.firebase.components.h
    @Keep
    public final List<com.google.firebase.components.b<?>> getComponents() {
        return Arrays.asList(com.google.firebase.components.b.a(FirebaseInstanceId.class).a(com.google.firebase.components.n.a(com.google.firebase.b.class)).a(com.google.firebase.components.n.a(com.google.firebase.b.d.class)).a(com.google.firebase.components.n.a(com.google.firebase.e.g.class)).a(s.a).a().b(), com.google.firebase.components.b.a(com.google.firebase.iid.a.a.class).a(com.google.firebase.components.n.a(FirebaseInstanceId.class)).a(r.a).b(), com.google.firebase.e.f.a("fire-iid", "18.0.0"));
    }
}
