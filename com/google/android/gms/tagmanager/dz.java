package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
final class dz extends Number implements Comparable<dz> {
    private double a;
    private long b;
    private boolean c = false;

    private dz(double d) {
        this.a = d;
    }

    private dz(long j) {
        this.b = j;
    }

    public static dz a(long j) {
        return new dz(j);
    }

    public static dz a(Double d) {
        return new dz(d.doubleValue());
    }

    public static dz a(String str) {
        try {
            try {
                return new dz(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return new dz(Double.parseDouble(str));
            }
        } catch (NumberFormatException unused2) {
            throw new NumberFormatException(String.valueOf(str).concat(" is not a valid TypedNumber"));
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(dz dzVar) {
        return (!this.c || !dzVar.c) ? Double.compare(doubleValue(), dzVar.doubleValue()) : new Long(this.b).compareTo(Long.valueOf(dzVar.b));
    }

    public final boolean a() {
        return !this.c;
    }

    public final boolean b() {
        return this.c;
    }

    @Override // java.lang.Number
    public final byte byteValue() {
        return (byte) longValue();
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.c ? this.b : this.a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof dz) && compareTo((dz) obj) == 0;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) longValue();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.c ? this.b : (long) this.a;
    }

    @Override // java.lang.Number
    public final short shortValue() {
        return (short) longValue();
    }

    public final String toString() {
        return this.c ? Long.toString(this.b) : Double.toString(this.a);
    }
}
