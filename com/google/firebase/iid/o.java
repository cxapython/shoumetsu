package com.google.firebase.iid;

import android.os.Bundle;

/* loaded from: classes.dex */
final class o extends m<Bundle> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.m
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a((o) bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.m
    public final boolean a() {
        return false;
    }
}
