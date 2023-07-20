package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements Runnable {
    final /* synthetic */ zal a;
    private final aw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(zal zalVar, aw awVar) {
        this.a = zalVar;
        this.b = awVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.b) {
            return;
        }
        ConnectionResult b = this.b.b();
        if (b.hasResolution()) {
            this.a.a.startActivityForResult(GoogleApiActivity.zaa(this.a.getActivity(), b.getResolution(), this.b.a(), false), 1);
        } else if (this.a.d.isUserResolvableError(b.getErrorCode())) {
            this.a.d.zaa(this.a.getActivity(), this.a.a, b.getErrorCode(), 2, this.a);
        } else if (b.getErrorCode() != 18) {
            this.a.a(b, this.b.a());
        } else {
            this.a.d.zaa(this.a.getActivity().getApplicationContext(), new ay(this, GoogleApiAvailability.zaa(this.a.getActivity(), this.a)));
        }
    }
}
