package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import org.apache.james.mime4j.util.MimeUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.ENCODE.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.NO_PADDING.toString();
    private static final String d = zzb.INPUT_FORMAT.toString();
    private static final String e = zzb.OUTPUT_FORMAT.toString();

    public ab() {
        super(a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String str;
        byte[] decode;
        String encodeToString;
        zzl zzlVar = map.get(b);
        if (zzlVar == null || zzlVar == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzlVar);
        zzl zzlVar2 = map.get(d);
        String zzc2 = zzlVar2 == null ? "text" : zzgj.zzc(zzlVar2);
        zzl zzlVar3 = map.get(e);
        String zzc3 = zzlVar3 == null ? "base16" : zzgj.zzc(zzlVar3);
        int i = 2;
        zzl zzlVar4 = map.get(c);
        if (zzlVar4 != null && zzgj.zzg(zzlVar4).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(zzc2)) {
                decode = zzc.getBytes();
            } else if ("base16".equals(zzc2)) {
                decode = zzo.decode(zzc);
            } else if (MimeUtil.ENC_BASE64.equals(zzc2)) {
                decode = Base64.decode(zzc, i);
            } else if (!"base64url".equals(zzc2)) {
                String valueOf = String.valueOf(zzc2);
                zzdi.zzav(valueOf.length() != 0 ? "Encode: unknown input format: ".concat(valueOf) : new String("Encode: unknown input format: "));
                return zzgj.zzkc();
            } else {
                decode = Base64.decode(zzc, i | 8);
            }
        } catch (IllegalArgumentException unused) {
            str = "Encode: invalid input:";
        }
        if ("base16".equals(zzc3)) {
            encodeToString = zzo.encode(decode);
        } else if (MimeUtil.ENC_BASE64.equals(zzc3)) {
            encodeToString = Base64.encodeToString(decode, i);
        } else if (!"base64url".equals(zzc3)) {
            String valueOf2 = String.valueOf(zzc3);
            str = valueOf2.length() != 0 ? "Encode: unknown output format: ".concat(valueOf2) : new String("Encode: unknown output format: ");
            zzdi.zzav(str);
            return zzgj.zzkc();
        } else {
            encodeToString = Base64.encodeToString(decode, i | 8);
        }
        return zzgj.zzi(encodeToString);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
