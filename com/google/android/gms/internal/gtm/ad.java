package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad {
    private int a;
    private ByteArrayOutputStream b = new ByteArrayOutputStream();
    private final /* synthetic */ ac c;

    public ad(ac acVar) {
        this.c = acVar;
    }

    public final int a() {
        return this.a;
    }

    public final boolean a(zzcd zzcdVar) {
        byte[] bArr;
        Preconditions.checkNotNull(zzcdVar);
        if (this.a + 1 > zzbq.zzes()) {
            return false;
        }
        String a = this.c.a(zzcdVar, false);
        if (a == null) {
            this.c.f().zza(zzcdVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > zzbq.zzeo()) {
            this.c.f().zza(zzcdVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.b.size() > 0) {
            length++;
        }
        if (this.b.size() + length > zzby.zzzz.get().intValue()) {
            return false;
        }
        try {
            if (this.b.size() > 0) {
                ByteArrayOutputStream byteArrayOutputStream = this.b;
                bArr = ac.c;
                byteArrayOutputStream.write(bArr);
            }
            this.b.write(bytes);
            this.a++;
            return true;
        } catch (IOException e) {
            this.c.zze("Failed to write payload when batching hits", e);
            return true;
        }
    }

    public final byte[] b() {
        return this.b.toByteArray();
    }
}
