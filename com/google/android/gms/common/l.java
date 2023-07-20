package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class l extends j {
    private final Callable<String> b;

    private l(Callable<String> callable) {
        super(false, null, null);
        this.b = callable;
    }

    @Override // com.google.android.gms.common.j
    final String b() {
        try {
            return this.b.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
