package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzqv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class bv<FieldDescriptorType extends zzqv<FieldDescriptorType>> {
    private static final bv d = new bv(true);
    private boolean b;
    private boolean c = false;
    final dh<FieldDescriptorType, Object> a = dh.a(16);

    private bv() {
    }

    private bv(boolean z) {
        b();
    }

    public static int a(zzqv<?> zzqvVar, Object obj) {
        zzug zzox = zzqvVar.zzox();
        int zzc = zzqvVar.zzc();
        if (zzqvVar.zzoz()) {
            int i = 0;
            if (zzqvVar.zzpa()) {
                for (Object obj2 : (List) obj) {
                    i += b(zzox, obj2);
                }
                return zzqj.zzbb(zzc) + i + zzqj.zzbj(i);
            }
            for (Object obj3 : (List) obj) {
                i += a(zzox, zzc, obj3);
            }
            return i;
        }
        return a(zzox, zzc, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzug zzugVar, int i, Object obj) {
        int zzbb = zzqj.zzbb(i);
        if (zzugVar == zzug.GROUP) {
            zzre.a((zzsk) obj);
            zzbb <<= 1;
        }
        return zzbb + b(zzugVar, obj);
    }

    public static <T extends zzqv<T>> bv<T> a() {
        return d;
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.a.get(fielddescriptortype);
        return obj instanceof zzrn ? zzrn.zzpy() : obj;
    }

    private static Object a(Object obj) {
        if (obj instanceof zzsq) {
            return ((zzsq) obj).zzqo();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzqj zzqjVar, zzug zzugVar, int i, Object obj) {
        if (zzugVar == zzug.GROUP) {
            zzsk zzskVar = (zzsk) obj;
            zzre.a(zzskVar);
            zzqjVar.zzd(i, 3);
            zzskVar.zzb(zzqjVar);
            zzqjVar.zzd(i, 4);
            return;
        }
        zzqjVar.zzd(i, zzugVar.zzrt());
        switch (bw.b[zzugVar.ordinal()]) {
            case 1:
                zzqjVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzqjVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 4:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 5:
                zzqjVar.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 7:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzqjVar.zzi(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzsk) obj).zzb(zzqjVar);
                return;
            case 10:
                zzqjVar.zzb((zzsk) obj);
                return;
            case 11:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                } else {
                    zzqjVar.zzcz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzqjVar.a(bArr, 0, bArr.length);
                return;
            case 13:
                zzqjVar.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 16:
                zzqjVar.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzqjVar.zzq(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzrf) {
                    zzqjVar.zzax(((zzrf) obj).zzc());
                    return;
                } else {
                    zzqjVar.zzax(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.gtm.zzrf) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.gtm.zzrn) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(zzug zzugVar, Object obj) {
        boolean z;
        zzre.a(obj);
        boolean z2 = false;
        switch (bw.a[zzugVar.zzrs().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzps)) {
                    break;
                }
                z2 = true;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = true;
                break;
            case 9:
                if (!(obj instanceof zzsk)) {
                    break;
                }
                z2 = true;
                break;
        }
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzoy() == zzul.MESSAGE) {
            if (key.zzoz()) {
                for (zzsk zzskVar : (List) entry.getValue()) {
                    if (!zzskVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzsk)) {
                    if (!(value instanceof zzrn)) {
                        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    }
                    return true;
                } else if (!((zzsk) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int b(zzug zzugVar, Object obj) {
        switch (bw.b[zzugVar.ordinal()]) {
            case 1:
                return zzqj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzqj.zzb(((Float) obj).floatValue());
            case 3:
                return zzqj.zzs(((Long) obj).longValue());
            case 4:
                return zzqj.zzt(((Long) obj).longValue());
            case 5:
                return zzqj.zzbc(((Integer) obj).intValue());
            case 6:
                return zzqj.zzv(((Long) obj).longValue());
            case 7:
                return zzqj.zzbf(((Integer) obj).intValue());
            case 8:
                return zzqj.zzj(((Boolean) obj).booleanValue());
            case 9:
                return zzqj.zzd((zzsk) obj);
            case 10:
                return obj instanceof zzrn ? zzqj.zza((zzrn) obj) : zzqj.zzc((zzsk) obj);
            case 11:
                return obj instanceof zzps ? zzqj.zzb((zzps) obj) : zzqj.zzda((String) obj);
            case 12:
                return obj instanceof zzps ? zzqj.zzb((zzps) obj) : zzqj.zzh((byte[]) obj);
            case 13:
                return zzqj.zzbd(((Integer) obj).intValue());
            case 14:
                return zzqj.zzbg(((Integer) obj).intValue());
            case 15:
                return zzqj.zzw(((Long) obj).longValue());
            case 16:
                return zzqj.zzbe(((Integer) obj).intValue());
            case 17:
                return zzqj.zzu(((Long) obj).longValue());
            case 18:
                return obj instanceof zzrf ? zzqj.zzbh(((zzrf) obj).zzc()) : zzqj.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzoz()) {
            a(fielddescriptortype.zzox(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                a(fielddescriptortype.zzox(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzrn) {
            this.c = true;
        }
        this.a.a((dh<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzrn) {
            value = zzrn.zzpy();
        }
        if (key.zzoz()) {
            Object a = a((bv<FieldDescriptorType>) key);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) a).add(a(obj));
            }
            this.a.a((dh<FieldDescriptorType, Object>) key, (FieldDescriptorType) a);
        } else if (key.zzoy() != zzul.MESSAGE) {
            this.a.a((dh<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
        } else {
            Object a2 = a((bv<FieldDescriptorType>) key);
            if (a2 == null) {
                this.a.a((dh<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            } else {
                this.a.a((dh<FieldDescriptorType, Object>) key, (FieldDescriptorType) (a2 instanceof zzsq ? key.zza((zzsq) a2, (zzsq) value) : key.zza(((zzsk) a2).zzpg(), (zzsk) value).zzpm()));
            }
        }
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        return (key.zzoy() != zzul.MESSAGE || key.zzoz() || key.zzpa()) ? a((zzqv<?>) key, value) : value instanceof zzrn ? zzqj.zzb(entry.getKey().zzc(), (zzrn) value) : zzqj.zzd(entry.getKey().zzc(), (zzsk) value);
    }

    public final void a(bv<FieldDescriptorType> bvVar) {
        for (int i = 0; i < bvVar.a.c(); i++) {
            b(bvVar.a.b(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : bvVar.a.d()) {
            b(entry);
        }
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.a.a();
        this.b = true;
    }

    public final boolean c() {
        return this.b;
    }

    public final /* synthetic */ Object clone() {
        bv bvVar = new bv();
        for (int i = 0; i < this.a.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b = this.a.b(i);
            bvVar.b((bv) b.getKey(), b.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.d()) {
            bvVar.b((bv) entry.getKey(), entry.getValue());
        }
        bvVar.c = this.c;
        return bvVar;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        return this.c ? new cf(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        return this.c ? new cf(this.a.e().iterator()) : this.a.e().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bv) {
            return this.a.equals(((bv) obj).a);
        }
        return false;
    }

    public final boolean f() {
        for (int i = 0; i < this.a.c(); i++) {
            if (!a((Map.Entry) this.a.b(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.d()) {
            if (!a((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.c(); i2++) {
            i += c(this.a.b(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.a.d()) {
            i += c(entry);
        }
        return i;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
