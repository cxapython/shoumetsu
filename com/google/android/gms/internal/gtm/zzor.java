package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzg;
import com.google.android.gms.tagmanager.zzgj;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzor {
    private static zzg.zza a(zzl zzlVar) {
        if (((zzg.zza) zzlVar.zza(zzg.zza.zzpx)) == null) {
            String valueOf = String.valueOf(zzlVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 54);
            sb.append("Expected a ServingValue and didn't get one. Value is: ");
            sb.append(valueOf);
            a(sb.toString());
        }
        return (zzg.zza) zzlVar.zza(zzg.zza.zzpx);
    }

    private static zzl a(int i, zzi zziVar, zzl[] zzlVarArr, Set<Integer> set) {
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 90);
            sb.append("Value cycle detected.  Current value reference: ");
            sb.append(i);
            sb.append(".  Previous value references: ");
            sb.append(valueOf);
            sb.append(".");
            a(sb.toString());
        }
        zzl zzlVar = (zzl) a(zziVar.zzpj, i, "values");
        if (zzlVarArr[i] != null) {
            return zzlVarArr[i];
        }
        zzl zzlVar2 = null;
        set.add(Integer.valueOf(i));
        int i2 = 0;
        switch (zzlVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zzlVar2 = zzlVar;
                break;
            case 2:
                zzg.zza a = a(zzlVar);
                zzl zzk = zzk(zzlVar);
                zzk.zzqn = new zzl[a.zzpz.length];
                int[] iArr = a.zzpz;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    zzk.zzqn[i3] = a(iArr[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i3 = i4;
                }
                zzlVar2 = zzk;
                break;
            case 3:
                zzlVar2 = zzk(zzlVar);
                zzg.zza a2 = a(zzlVar);
                if (a2.zzqa.length != a2.zzqb.length) {
                    int length2 = a2.zzqa.length;
                    int length3 = a2.zzqb.length;
                    StringBuilder sb2 = new StringBuilder(58);
                    sb2.append("Uneven map keys (");
                    sb2.append(length2);
                    sb2.append(") and map values (");
                    sb2.append(length3);
                    sb2.append(")");
                    a(sb2.toString());
                }
                zzlVar2.zzqo = new zzl[a2.zzqa.length];
                zzlVar2.zzqp = new zzl[a2.zzqa.length];
                int[] iArr2 = a2.zzqa;
                int length4 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length4) {
                    zzlVar2.zzqo[i6] = a(iArr2[i5], zziVar, zzlVarArr, set);
                    i5++;
                    i6++;
                }
                int[] iArr3 = a2.zzqb;
                int length5 = iArr3.length;
                int i7 = 0;
                while (i2 < length5) {
                    zzlVar2.zzqp[i7] = a(iArr3[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i7++;
                }
                break;
            case 4:
                zzlVar2 = zzk(zzlVar);
                zzlVar2.zzqq = zzgj.zzc(a(a(zzlVar).zzqe, zziVar, zzlVarArr, set));
                break;
            case 7:
                zzlVar2 = zzk(zzlVar);
                zzg.zza a3 = a(zzlVar);
                zzlVar2.zzqu = new zzl[a3.zzqd.length];
                int[] iArr4 = a3.zzqd;
                int length6 = iArr4.length;
                int i8 = 0;
                while (i2 < length6) {
                    zzlVar2.zzqu[i8] = a(iArr4[i2], zziVar, zzlVarArr, set);
                    i2++;
                    i8++;
                }
                break;
        }
        if (zzlVar2 == null) {
            String valueOf2 = String.valueOf(zzlVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 15);
            sb3.append("Invalid value: ");
            sb3.append(valueOf2);
            a(sb3.toString());
        }
        zzlVarArr[i] = zzlVar2;
        set.remove(Integer.valueOf(i));
        return zzlVar2;
    }

    private static zzot a(zzc.zzb zzbVar, zzi zziVar, zzl[] zzlVarArr, int i) {
        zzou zzml = zzot.zzml();
        for (Integer num : zzbVar.zze()) {
            zzc.zzd zzdVar = (zzc.zzd) a(zziVar.zzpk, num.intValue(), "properties");
            String str = (String) a(zziVar.zzpi, zzdVar.zzl(), "keys");
            zzl zzlVar = (zzl) a(zzlVarArr, zzdVar.getValue(), "values");
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzml.zzm(zzlVar);
            } else {
                zzml.zzb(str, zzlVar);
            }
        }
        return zzml.zzmm();
    }

    private static <T> T a(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
            sb.append("Index out of bounds detected: ");
            sb.append(i);
            sb.append(" in ");
            sb.append(str);
            a(sb.toString());
        }
        return tArr[i];
    }

    private static void a(String str) {
        com.google.android.gms.tagmanager.zzdi.zzav(str);
        throw new zzoz(str);
    }

    public static zzov zza(zzi zziVar) {
        zzc.zze[] zzeVarArr;
        zzl[] zzlVarArr = new zzl[zziVar.zzpj.length];
        for (int i = 0; i < zziVar.zzpj.length; i++) {
            a(i, zziVar, zzlVarArr, new HashSet(0));
        }
        zzow zzmn = zzov.zzmn();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zziVar.zzpm.length; i2++) {
            arrayList.add(a(zziVar.zzpm[i2], zziVar, zzlVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zziVar.zzpn.length; i3++) {
            arrayList2.add(a(zziVar.zzpn[i3], zziVar, zzlVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zziVar.zzpl.length; i4++) {
            zzot a = a(zziVar.zzpl[i4], zziVar, zzlVarArr, i4);
            zzmn.zzc(a);
            arrayList3.add(a);
        }
        for (zzc.zze zzeVar : zziVar.zzpo) {
            zzoy zzoyVar = new zzoy();
            for (Integer num : zzeVar.zzn()) {
                zzoyVar.zzd((zzot) arrayList2.get(num.intValue()));
            }
            for (Integer num2 : zzeVar.zzo()) {
                zzoyVar.zze((zzot) arrayList2.get(num2.intValue()));
            }
            for (Integer num3 : zzeVar.zzp()) {
                zzoyVar.zzf((zzot) arrayList.get(num3.intValue()));
            }
            for (Integer num4 : zzeVar.zzr()) {
                zzoyVar.zzct(zziVar.zzpj[num4.intValue()].string);
            }
            for (Integer num5 : zzeVar.zzq()) {
                zzoyVar.zzg((zzot) arrayList.get(num5.intValue()));
            }
            for (Integer num6 : zzeVar.zzs()) {
                zzoyVar.zzcu(zziVar.zzpj[num6.intValue()].string);
            }
            for (Integer num7 : zzeVar.zzt()) {
                zzoyVar.zzh((zzot) arrayList3.get(num7.intValue()));
            }
            for (Integer num8 : zzeVar.zzv()) {
                zzoyVar.zzcv(zziVar.zzpj[num8.intValue()].string);
            }
            for (Integer num9 : zzeVar.zzu()) {
                zzoyVar.zzi((zzot) arrayList3.get(num9.intValue()));
            }
            for (Integer num10 : zzeVar.zzw()) {
                zzoyVar.zzcw(zziVar.zzpj[num10.intValue()].string);
            }
            zzmn.zzb(zzoyVar.zzms());
        }
        zzmn.zzcs(zziVar.version);
        zzmn.zzaf(zziVar.zzpw);
        return zzmn.zzmp();
    }

    public static void zza(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static zzl zzk(zzl zzlVar) {
        zzl zzlVar2 = new zzl();
        zzlVar2.type = zzlVar.type;
        zzlVar2.zzqv = (int[]) zzlVar.zzqv.clone();
        if (zzlVar.zzqw) {
            zzlVar2.zzqw = zzlVar.zzqw;
        }
        return zzlVar2;
    }
}
