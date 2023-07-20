package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    public final Uri a;

    public a(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (this != obj) {
            return Objects.equal(((a) obj).a, this.a);
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }
}
