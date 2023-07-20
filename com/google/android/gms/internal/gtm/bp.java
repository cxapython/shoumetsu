package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class bp implements em {
    private final zzqj a;

    private bp(zzqj zzqjVar) {
        this.a = (zzqj) zzre.a(zzqjVar, "output");
        this.a.a = this;
    }

    public static bp a(zzqj zzqjVar) {
        return zzqjVar.a != null ? zzqjVar.a : new bp(zzqjVar);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final int a() {
        return zzrc.zze.zzbbc;
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i) {
        this.a.zzd(i, 3);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, double d) {
        this.a.zza(i, d);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, float f) {
        this.a.zza(i, f);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, int i2) {
        this.a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final <K, V> void a(int i, co<K, V> coVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.zzd(i, 2);
            this.a.zzay(zzsc.a(coVar, entry.getKey(), entry.getValue()));
            zzsc.a(this.a, coVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, zzps zzpsVar) {
        this.a.zza(i, zzpsVar);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, Object obj) {
        if (obj instanceof zzps) {
            this.a.zzb(i, (zzps) obj);
        } else {
            this.a.zzb(i, (zzsk) obj);
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, Object obj, de deVar) {
        this.a.a(i, (zzsk) obj, deVar);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, String str) {
        this.a.zza(i, str);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, List<String> list) {
        int i2 = 0;
        if (!(list instanceof zzrt)) {
            while (i2 < list.size()) {
                this.a.zza(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzrt zzrtVar = (zzrt) list;
        while (i2 < list.size()) {
            Object zzbn = zzrtVar.zzbn(i2);
            if (zzbn instanceof String) {
                this.a.zza(i, (String) zzbn);
            } else {
                this.a.zza(i, (zzps) zzbn);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, List<?> list, de deVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), deVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbc(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzax(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void a(int i, boolean z) {
        this.a.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i) {
        this.a.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, int i2) {
        this.a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, Object obj, de deVar) {
        zzqj zzqjVar = this.a;
        zzqjVar.zzd(i, 3);
        deVar.a((de) ((zzsk) obj), (em) zzqjVar.a);
        zzqjVar.zzd(i, 4);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, List<zzps> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, List<?> list, de deVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), deVar);
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void b(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbf(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzba(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void c(int i, int i2) {
        this.a.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void c(int i, long j) {
        this.a.zza(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void c(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzs(list.get(i4).longValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzp(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void d(int i, int i2) {
        this.a.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void d(int i, long j) {
        this.a.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzt(list.get(i4).longValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzp(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void e(int i, int i2) {
        this.a.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void e(int i, long j) {
        this.a.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void e(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzv(list.get(i4).longValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzr(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void f(int i, int i2) {
        this.a.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void f(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzb(list.get(i4).floatValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zza(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void g(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zza(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzc(list.get(i4).doubleValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzb(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void h(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zze(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbh(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzax(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void i(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzj(list.get(i4).booleanValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzi(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void j(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbd(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzay(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void k(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbg(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzba(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void l(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzc(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzw(list.get(i4).longValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzr(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void m(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzbe(list.get(i4).intValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzaz(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.gtm.em
    public final void n(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.zzb(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.a.zzd(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzqj.zzu(list.get(i4).longValue());
        }
        this.a.zzay(i3);
        while (i2 < list.size()) {
            this.a.zzq(list.get(i2).longValue());
            i2++;
        }
    }
}
