package com.google.android.gms.tagmanager;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
final class am {
    private final long a;
    private final long b;
    private final long c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return;
        }
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.d;
    }
}
