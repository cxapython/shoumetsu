package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhp;
import com.google.android.gms.internal.drive.zzia;
import com.google.android.gms.internal.drive.zzic;
import com.google.android.gms.internal.drive.zzik;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzf {
    private static final Map<String, MetadataField<?>> a = new HashMap();
    private static final Map<String, zzg> b = new HashMap();

    static {
        a(zzhp.zziv);
        a(zzhp.zzkb);
        a(zzhp.zzjs);
        a(zzhp.zzjz);
        a(zzhp.zzkc);
        a(zzhp.zzji);
        a(zzhp.zzjh);
        a(zzhp.zzjj);
        a(zzhp.zzjk);
        a(zzhp.zzjl);
        a(zzhp.zzjf);
        a(zzhp.zzjn);
        a(zzhp.zzjo);
        a(zzhp.zzjp);
        a(zzhp.zzjx);
        a(zzhp.zziw);
        a(zzhp.zzju);
        a(zzhp.zziy);
        a(zzhp.zzjg);
        a(zzhp.zziz);
        a(zzhp.zzja);
        a(zzhp.zzjb);
        a(zzhp.zzjc);
        a(zzhp.zzjr);
        a(zzhp.zzjm);
        a(zzhp.zzjt);
        a(zzhp.zzjv);
        a(zzhp.zzjw);
        a(zzhp.zzjy);
        a(zzhp.zzkd);
        a(zzhp.zzke);
        a(zzhp.zzje);
        a(zzhp.zzjd);
        a(zzhp.zzka);
        a(zzhp.zzjq);
        a(zzhp.zzix);
        a(zzhp.zzkf);
        a(zzhp.zzkg);
        a(zzhp.zzkh);
        a(zzhp.zzki);
        a(zzhp.zzkj);
        a(zzhp.zzkk);
        a(zzhp.zzkl);
        a(zzic.zzkn);
        a(zzic.zzkp);
        a(zzic.zzkq);
        a(zzic.zzkr);
        a(zzic.zzko);
        a(zzic.zzks);
        a(zzik.zzku);
        a(zzik.zzkv);
        a(zzo.zziu);
        a(zzia.zzkm);
    }

    private static void a(MetadataField<?> metadataField) {
        if (a.containsKey(metadataField.getName())) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate field name registered: ".concat(valueOf) : new String("Duplicate field name registered: "));
        } else {
            a.put(metadataField.getName(), metadataField);
        }
    }

    private static void a(zzg zzgVar) {
        if (b.put(zzgVar.zzav(), zzgVar) == null) {
            return;
        }
        String zzav = zzgVar.zzav();
        StringBuilder sb = new StringBuilder(String.valueOf(zzav).length() + 46);
        sb.append("A cleaner for key ");
        sb.append(zzav);
        sb.append(" has already been registered");
        throw new IllegalStateException(sb.toString());
    }

    public static void zza(DataHolder dataHolder) {
        for (zzg zzgVar : b.values()) {
            zzgVar.zzb(dataHolder);
        }
    }

    public static Collection<MetadataField<?>> zzau() {
        return Collections.unmodifiableCollection(a.values());
    }

    public static MetadataField<?> zzd(String str) {
        return a.get(str);
    }
}
