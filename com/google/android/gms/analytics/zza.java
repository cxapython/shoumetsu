package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzad;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzz;
import java.util.ListIterator;

@VisibleForTesting
/* loaded from: classes.dex */
public class zza extends zzj<zza> {
    private final zzap b;
    private boolean c;

    @VisibleForTesting
    public zza(zzap zzapVar) {
        super(zzapVar.zzcq(), zzapVar.zzcn());
        this.b = zzapVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzap a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.zzj
    public final void a(zzg zzgVar) {
        zzz zzzVar = (zzz) zzgVar.zzb(zzz.class);
        if (TextUtils.isEmpty(zzzVar.zzbt())) {
            zzzVar.setClientId(this.b.zzdh().zzeh());
        }
        if (!this.c || !TextUtils.isEmpty(zzzVar.zzbv())) {
            return;
        }
        zzad zzdg = this.b.zzdg();
        zzzVar.zzm(zzdg.zzcd());
        zzzVar.zza(zzdg.zzbw());
    }

    public final void enableAdvertisingIdCollection(boolean z) {
        this.c = z;
    }

    public final void zza(String str) {
        Preconditions.checkNotEmpty(str);
        Uri a = zzb.a(str);
        ListIterator<zzo> listIterator = this.a.zzak().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(listIterator.next().zzae())) {
                listIterator.remove();
            }
        }
        this.a.zzak().add(new zzb(this.b, str));
    }

    @Override // com.google.android.gms.analytics.zzj
    public final zzg zzac() {
        zzg zzai = this.a.zzai();
        zzai.zza(this.b.zzcy().zzdv());
        zzai.zza(this.b.zzcz().zzfa());
        b(zzai);
        return zzai;
    }
}
