package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@VisibleForTesting
/* loaded from: classes.dex */
final class ce extends dq {
    private static final String a = com.google.android.gms.internal.gtm.zza.REGEX.toString();
    private static final String b = zzb.IGNORE_CASE.toString();

    public ce() {
        super(a);
    }

    @Override // com.google.android.gms.tagmanager.dq
    protected final boolean a(String str, String str2, Map<String, zzl> map) {
        try {
            return Pattern.compile(str2, zzgj.zzg(map.get(b)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
