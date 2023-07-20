package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes.dex */
final class cd extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.REGEX_GROUP.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.ARG1.toString();
    private static final String d = zzb.IGNORE_CASE.toString();
    private static final String e = zzb.GROUP.toString();

    public cd() {
        super(a, b, c);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        Long zze;
        zzl zzlVar = map.get(b);
        zzl zzlVar2 = map.get(c);
        if (zzlVar == null || zzlVar == zzgj.zzkc() || zzlVar2 == null || zzlVar2 == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        int i = 64;
        if (zzgj.zzg(map.get(d)).booleanValue()) {
            i = 66;
        }
        int i2 = 1;
        zzl zzlVar3 = map.get(e);
        if (zzlVar3 == null || ((zze = zzgj.zze(zzlVar3)) != zzgj.zzjx() && (i2 = zze.intValue()) >= 0)) {
            try {
                String zzc = zzgj.zzc(zzlVar);
                String zzc2 = zzgj.zzc(zzlVar2);
                String str = null;
                Matcher matcher = Pattern.compile(zzc2, i).matcher(zzc);
                if (matcher.find() && matcher.groupCount() >= i2) {
                    str = matcher.group(i2);
                }
                return str == null ? zzgj.zzkc() : zzgj.zzi(str);
            } catch (PatternSyntaxException unused) {
                return zzgj.zzkc();
            }
        }
        return zzgj.zzkc();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
