package com.google.android.gms.tagmanager;

import com.adjust.sdk.Constants;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.HASH.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.ALGORITHM.toString();
    private static final String d = zzb.INPUT_FORMAT.toString();

    public al() {
        super(a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String concat;
        byte[] decode;
        zzl zzlVar = map.get(b);
        if (zzlVar == null || zzlVar == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzlVar);
        zzl zzlVar2 = map.get(c);
        String zzc2 = zzlVar2 == null ? Constants.MD5 : zzgj.zzc(zzlVar2);
        zzl zzlVar3 = map.get(d);
        String zzc3 = zzlVar3 == null ? "text" : zzgj.zzc(zzlVar3);
        if ("text".equals(zzc3)) {
            decode = zzc.getBytes();
        } else if (!"base16".equals(zzc3)) {
            String valueOf = String.valueOf(zzc3);
            concat = valueOf.length() != 0 ? "Hash: unknown input format: ".concat(valueOf) : new String("Hash: unknown input format: ");
            zzdi.zzav(concat);
            return zzgj.zzkc();
        } else {
            decode = zzo.decode(zzc);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(zzc2);
            messageDigest.update(decode);
            return zzgj.zzi(zzo.encode(messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            String valueOf2 = String.valueOf(zzc2);
            concat = valueOf2.length() != 0 ? "Hash: unknown algorithm: ".concat(valueOf2) : new String("Hash: unknown algorithm: ");
        }
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
