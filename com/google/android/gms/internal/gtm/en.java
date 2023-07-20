package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class en implements Cloneable {
    private zzur<?, ?> a;
    private Object b;
    private List<eo> c = new ArrayList();

    private final byte[] b() {
        byte[] bArr = new byte[a()];
        a(zzuo.zzl(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public final en clone() {
        Object clone;
        en enVar = new en();
        try {
            enVar.a = this.a;
            if (this.c == null) {
                enVar.c = null;
            } else {
                enVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zzuw) {
                    clone = (zzuw) ((zzuw) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    clone = ((byte[]) this.b).clone();
                } else {
                    int i = 0;
                    if (this.b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.b;
                        byte[][] bArr2 = new byte[bArr.length];
                        enVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.b instanceof boolean[]) {
                        clone = ((boolean[]) this.b).clone();
                    } else if (this.b instanceof int[]) {
                        clone = ((int[]) this.b).clone();
                    } else if (this.b instanceof long[]) {
                        clone = ((long[]) this.b).clone();
                    } else if (this.b instanceof float[]) {
                        clone = ((float[]) this.b).clone();
                    } else if (this.b instanceof double[]) {
                        clone = ((double[]) this.b).clone();
                    } else if (this.b instanceof zzuw[]) {
                        zzuw[] zzuwVarArr = (zzuw[]) this.b;
                        zzuw[] zzuwVarArr2 = new zzuw[zzuwVarArr.length];
                        enVar.b = zzuwVarArr2;
                        while (i < zzuwVarArr.length) {
                            zzuwVarArr2[i] = (zzuw) zzuwVarArr[i].clone();
                            i++;
                        }
                    }
                }
                enVar.b = clone;
            }
            return enVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        Object obj = this.b;
        if (obj == null) {
            int i = 0;
            for (eo eoVar : this.c) {
                i += zzuo.zzbj(eoVar.a) + 0 + eoVar.b.length;
            }
            return i;
        }
        zzur<?, ?> zzurVar = this.a;
        if (!zzurVar.b) {
            return zzurVar.a(obj);
        }
        int length = Array.getLength(obj);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj2 = Array.get(obj, i3);
            if (obj2 != null) {
                i2 += zzurVar.a(obj2);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(zzur<?, T> zzurVar) {
        if (this.b == null) {
            this.a = zzurVar;
            this.b = zzurVar.a(this.c);
            this.c = null;
        } else if (!this.a.equals(zzurVar)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [com.google.android.gms.internal.gtm.zzuw[]] */
    public final void a(eo eoVar) {
        Object a;
        Object obj;
        int length;
        int length2;
        zzsk[] zzskVarArr;
        List<eo> list = this.c;
        if (list != null) {
            list.add(eoVar);
            return;
        }
        Object obj2 = this.b;
        if (obj2 instanceof zzuw) {
            byte[] bArr = eoVar.b;
            zzun zzj = zzun.zzj(bArr, 0, bArr.length);
            int zzoa = zzj.zzoa();
            if (zzoa != bArr.length - zzuo.zzbc(zzoa)) {
                throw zzuv.a();
            }
            a = ((zzuw) this.b).zza(zzj);
        } else {
            if (obj2 instanceof zzuw[]) {
                ?? r5 = (zzuw[]) this.a.a(Collections.singletonList(eoVar));
                zzuw[] zzuwVarArr = (zzuw[]) this.b;
                obj = (zzuw[]) Arrays.copyOf(zzuwVarArr, zzuwVarArr.length + r5.length);
                length = zzuwVarArr.length;
                length2 = r5.length;
                zzskVarArr = r5;
            } else if (obj2 instanceof zzsk) {
                a = ((zzsk) this.b).zzpg().zza((zzsk) this.a.a(Collections.singletonList(eoVar))).zzpm();
            } else if (obj2 instanceof zzsk[]) {
                zzsk[] zzskVarArr2 = (zzsk[]) this.a.a(Collections.singletonList(eoVar));
                zzsk[] zzskVarArr3 = (zzsk[]) this.b;
                obj = (zzsk[]) Arrays.copyOf(zzskVarArr3, zzskVarArr3.length + zzskVarArr2.length);
                length = zzskVarArr3.length;
                length2 = zzskVarArr2.length;
                zzskVarArr = zzskVarArr2;
            } else {
                a = this.a.a(Collections.singletonList(eoVar));
            }
            System.arraycopy(zzskVarArr, 0, obj, length, length2);
            a = obj;
        }
        this.a = this.a;
        this.b = a;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzuo zzuoVar) {
        Object obj = this.b;
        if (obj == null) {
            for (eo eoVar : this.c) {
                zzuoVar.zzcb(eoVar.a);
                zzuoVar.zzm(eoVar.b);
            }
            return;
        }
        zzur<?, ?> zzurVar = this.a;
        if (!zzurVar.b) {
            zzurVar.a(obj, zzuoVar);
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzurVar.a(obj2, zzuoVar);
            }
        }
    }

    public final boolean equals(Object obj) {
        List<eo> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof en)) {
            return false;
        }
        en enVar = (en) obj;
        if (this.b == null || enVar.b == null) {
            List<eo> list2 = this.c;
            if (list2 != null && (list = enVar.c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(b(), enVar.b());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        zzur<?, ?> zzurVar = this.a;
        if (zzurVar != enVar.a) {
            return false;
        }
        if (!zzurVar.a.isArray()) {
            return this.b.equals(enVar.b);
        }
        Object obj2 = this.b;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) enVar.b) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) enVar.b) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) enVar.b) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) enVar.b) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) enVar.b) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) enVar.b) : Arrays.deepEquals((Object[]) obj2, (Object[]) enVar.b);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
