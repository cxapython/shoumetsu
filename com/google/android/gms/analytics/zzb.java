package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzaa;
import com.google.android.gms.internal.gtm.zzab;
import com.google.android.gms.internal.gtm.zzac;
import com.google.android.gms.internal.gtm.zzam;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzr;
import com.google.android.gms.internal.gtm.zzs;
import com.google.android.gms.internal.gtm.zzt;
import com.google.android.gms.internal.gtm.zzu;
import com.google.android.gms.internal.gtm.zzv;
import com.google.android.gms.internal.gtm.zzw;
import com.google.android.gms.internal.gtm.zzx;
import com.google.android.gms.internal.gtm.zzy;
import com.google.android.gms.internal.gtm.zzz;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzb extends zzam implements zzo {
    private static DecimalFormat a;
    private final zzap b;
    private final String c;
    private final Uri d;

    public zzb(zzap zzapVar, String str) {
        this(zzapVar, str, true, false);
    }

    private zzb(zzap zzapVar, String str, boolean z, boolean z2) {
        super(zzapVar);
        Preconditions.checkNotEmpty(str);
        this.b = zzapVar;
        this.c = str;
        this.d = a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri a(String str) {
        Preconditions.checkNotEmpty(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static String a(double d) {
        if (a == null) {
            a = new DecimalFormat("0.######");
        }
        return a.format(d);
    }

    @VisibleForTesting
    private static Map<String, String> a(zzg zzgVar) {
        HashMap hashMap = new HashMap();
        zzu zzuVar = (zzu) zzgVar.zza(zzu.class);
        if (zzuVar != null) {
            for (Map.Entry<String, Object> entry : zzuVar.zzbm().entrySet()) {
                Object value = entry.getValue();
                String str = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str2 = (String) value;
                        if (!TextUtils.isEmpty(str2)) {
                            str = str2;
                        }
                    } else if (value instanceof Double) {
                        Double d = (Double) value;
                        if (d.doubleValue() != 0.0d) {
                            str = a(d.doubleValue());
                        }
                    } else if (!(value instanceof Boolean)) {
                        str = String.valueOf(value);
                    } else if (value != Boolean.FALSE) {
                        str = "1";
                    }
                }
                if (str != null) {
                    hashMap.put(entry.getKey(), str);
                }
            }
        }
        zzz zzzVar = (zzz) zzgVar.zza(zzz.class);
        if (zzzVar != null) {
            a(hashMap, "t", zzzVar.zzbs());
            a(hashMap, "cid", zzzVar.zzbt());
            a(hashMap, "uid", zzzVar.zzbu());
            a(hashMap, "sc", zzzVar.zzbx());
            a(hashMap, "sf", zzzVar.zzbz());
            a(hashMap, "ni", zzzVar.zzby());
            a(hashMap, "adid", zzzVar.zzbv());
            a(hashMap, "ate", zzzVar.zzbw());
        }
        zzaa zzaaVar = (zzaa) zzgVar.zza(zzaa.class);
        if (zzaaVar != null) {
            a(hashMap, "cd", zzaaVar.zzca());
            a(hashMap, "a", zzaaVar.zzcb());
            a(hashMap, "dr", zzaaVar.zzcc());
        }
        zzx zzxVar = (zzx) zzgVar.zza(zzx.class);
        if (zzxVar != null) {
            a(hashMap, "ec", zzxVar.zzbr());
            a(hashMap, "ea", zzxVar.getAction());
            a(hashMap, "el", zzxVar.getLabel());
            a(hashMap, "ev", zzxVar.getValue());
        }
        zzr zzrVar = (zzr) zzgVar.zza(zzr.class);
        if (zzrVar != null) {
            a(hashMap, "cn", zzrVar.getName());
            a(hashMap, "cs", zzrVar.getSource());
            a(hashMap, "cm", zzrVar.zzbd());
            a(hashMap, "ck", zzrVar.zzbe());
            a(hashMap, "cc", zzrVar.zzbf());
            a(hashMap, "ci", zzrVar.getId());
            a(hashMap, "anid", zzrVar.zzbg());
            a(hashMap, "gclid", zzrVar.zzbh());
            a(hashMap, "dclid", zzrVar.zzbi());
            a(hashMap, "aclid", zzrVar.zzbj());
        }
        zzy zzyVar = (zzy) zzgVar.zza(zzy.class);
        if (zzyVar != null) {
            a(hashMap, "exd", zzyVar.zzuq);
            a(hashMap, "exf", zzyVar.zzur);
        }
        zzab zzabVar = (zzab) zzgVar.zza(zzab.class);
        if (zzabVar != null) {
            a(hashMap, "sn", zzabVar.zzvh);
            a(hashMap, "sa", zzabVar.zzvi);
            a(hashMap, "st", zzabVar.zzvj);
        }
        zzac zzacVar = (zzac) zzgVar.zza(zzac.class);
        if (zzacVar != null) {
            a(hashMap, "utv", zzacVar.zzvk);
            a(hashMap, "utt", zzacVar.zzvl);
            a(hashMap, "utc", zzacVar.mCategory);
            a(hashMap, "utl", zzacVar.zzvm);
        }
        zzs zzsVar = (zzs) zzgVar.zza(zzs.class);
        if (zzsVar != null) {
            for (Map.Entry<Integer, String> entry2 : zzsVar.zzbk().entrySet()) {
                String zze = zzd.zze(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(zze)) {
                    hashMap.put(zze, entry2.getValue());
                }
            }
        }
        zzt zztVar = (zzt) zzgVar.zza(zzt.class);
        if (zztVar != null) {
            for (Map.Entry<Integer, Double> entry3 : zztVar.zzbl().entrySet()) {
                String zzg = zzd.zzg(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(zzg)) {
                    hashMap.put(zzg, a(entry3.getValue().doubleValue()));
                }
            }
        }
        zzw zzwVar = (zzw) zzgVar.zza(zzw.class);
        if (zzwVar != null) {
            ProductAction zzbn = zzwVar.zzbn();
            if (zzbn != null) {
                for (Map.Entry<String, String> entry4 : zzbn.build().entrySet()) {
                    hashMap.put(entry4.getKey().startsWith("&") ? entry4.getKey().substring(1) : entry4.getKey(), entry4.getValue());
                }
            }
            int i = 1;
            for (Promotion promotion : zzwVar.zzbq()) {
                hashMap.putAll(promotion.zzn(zzd.zzk(i)));
                i++;
            }
            int i2 = 1;
            for (Product product : zzwVar.zzbo()) {
                hashMap.putAll(product.zzn(zzd.zzi(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzwVar.zzbp().entrySet()) {
                String zzn = zzd.zzn(i3);
                int i4 = 1;
                for (Product product2 : entry5.getValue()) {
                    String valueOf = String.valueOf(zzn);
                    String valueOf2 = String.valueOf(zzd.zzl(i4));
                    hashMap.putAll(product2.zzn(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    String valueOf3 = String.valueOf(zzn);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), entry5.getKey());
                }
                i3++;
            }
        }
        zzv zzvVar = (zzv) zzgVar.zza(zzv.class);
        if (zzvVar != null) {
            a(hashMap, "ul", zzvVar.getLanguage());
            a(hashMap, "sd", zzvVar.zzuk);
            a(hashMap, "sr", zzvVar.zzul, zzvVar.zzum);
            a(hashMap, "vp", zzvVar.zzun, zzvVar.zzuo);
        }
        zzq zzqVar = (zzq) zzgVar.zza(zzq.class);
        if (zzqVar != null) {
            a(hashMap, "an", zzqVar.zzaz());
            a(hashMap, "aid", zzqVar.zzbb());
            a(hashMap, "aiid", zzqVar.zzbc());
            a(hashMap, "av", zzqVar.zzba());
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, a(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        map.put(str, sb.toString());
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    @Override // com.google.android.gms.analytics.zzo
    public final Uri zzae() {
        return this.d;
    }

    @Override // com.google.android.gms.analytics.zzo
    public final void zzb(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkArgument(zzgVar.zzan(), "Can't deliver not submitted measurement");
        Preconditions.checkNotMainThread("deliver should be called on worker thread");
        zzg zzai = zzgVar.zzai();
        zzz zzzVar = (zzz) zzai.zzb(zzz.class);
        if (TextUtils.isEmpty(zzzVar.zzbs())) {
            f().zza(a(zzai), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzzVar.zzbt())) {
            f().zza(a(zzai), "Ignoring measurement without client id");
        } else if (!this.b.zzde().getAppOptOut()) {
            double zzbz = zzzVar.zzbz();
            if (zzcz.zza(zzbz, zzzVar.zzbt())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzbz));
                return;
            }
            Map<String, String> a2 = a(zzai);
            a2.put("v", "1");
            a2.put("_v", zzao.zzwe);
            a2.put("tid", this.c);
            if (this.b.zzde().isDryRunEnabled()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : a2.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                }
                zzc("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
                return;
            }
            HashMap hashMap = new HashMap();
            zzcz.zzb(hashMap, "uid", zzzVar.zzbu());
            zzq zzqVar = (zzq) zzgVar.zza(zzq.class);
            if (zzqVar != null) {
                zzcz.zzb(hashMap, "an", zzqVar.zzaz());
                zzcz.zzb(hashMap, "aid", zzqVar.zzbb());
                zzcz.zzb(hashMap, "av", zzqVar.zzba());
                zzcz.zzb(hashMap, "aiid", zzqVar.zzbc());
            }
            a2.put("_s", String.valueOf(i().zza(new zzas(0L, zzzVar.zzbt(), this.c, !TextUtils.isEmpty(zzzVar.zzbv()), 0L, hashMap))));
            i().zza(new zzcd(f(), a2, zzgVar.zzal(), true));
        }
    }
}
