package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
final class ec {
    private static bs<zzl> a(bs<zzl> bsVar) {
        try {
            return new bs<>(zzgj.zzi(a(zzgj.zzc(bsVar.a()))), bsVar.b());
        } catch (UnsupportedEncodingException e) {
            zzdi.zza("Escape URI: unsupported encoding", e);
            return bsVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bs<zzl> a(bs<zzl> bsVar, int... iArr) {
        String sb;
        for (int i : iArr) {
            if (!(zzgj.zzh(bsVar.a()) instanceof String)) {
                sb = "Escaping can only be applied to strings.";
            } else if (i != 12) {
                StringBuilder sb2 = new StringBuilder(39);
                sb2.append("Unsupported Value Escaping: ");
                sb2.append(i);
                sb = sb2.toString();
            } else {
                bsVar = a(bsVar);
            }
            zzdi.zzav(sb);
        }
        return bsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }
}
