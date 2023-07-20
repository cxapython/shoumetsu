package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzdd extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.LANGUAGE.toString();

    public zzdd() {
        super(a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String language;
        Locale locale = Locale.getDefault();
        if (locale != null && (language = locale.getLanguage()) != null) {
            return zzgj.zzi(language.toLowerCase());
        }
        return zzgj.zzkc();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }
}
