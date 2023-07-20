package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dc implements cs {
    private final zzsk a;
    private final String b;
    private final Object[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(zzsk zzskVar, String str, Object[] objArr) {
        this.a = zzskVar;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i2);
                return;
            }
            i |= (charAt2 & 8191) << i2;
            i2 += 13;
            i3 = i4;
        }
    }

    @Override // com.google.android.gms.internal.gtm.cs
    public final int a() {
        return (this.d & 1) == 1 ? zzrc.zze.zzbaz : zzrc.zze.zzbba;
    }

    @Override // com.google.android.gms.internal.gtm.cs
    public final boolean b() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.gtm.cs
    public final zzsk c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.c;
    }
}
