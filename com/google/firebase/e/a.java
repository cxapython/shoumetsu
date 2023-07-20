package com.google.firebase.e;

import javax.annotation.Nonnull;

/* loaded from: classes.dex */
final class a extends e {
    private final String a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        if (str != null) {
            this.a = str;
            if (str2 == null) {
                throw new NullPointerException("Null version");
            }
            this.b = str2;
            return;
        }
        throw new NullPointerException("Null libraryName");
    }

    @Override // com.google.firebase.e.e
    @Nonnull
    public String a() {
        return this.a;
    }

    @Override // com.google.firebase.e.e
    @Nonnull
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a.equals(eVar.a()) && this.b.equals(eVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.b + "}";
    }
}
