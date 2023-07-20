package com.google.firebase.iid;

import android.os.Bundle;

/* loaded from: classes.dex */
final class n extends m<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.m
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a((n) null);
        } else {
            a(new p(4, "Invalid response to one way request"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.m
    public final boolean a() {
        return true;
    }
}
