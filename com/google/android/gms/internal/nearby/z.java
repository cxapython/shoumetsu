package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
final class z {
    private final String a;
    private final long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (Objects.equal(this.a, zVar.a) && Objects.equal(Long.valueOf(this.b), Long.valueOf(zVar.b))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Long.valueOf(this.b));
    }
}
