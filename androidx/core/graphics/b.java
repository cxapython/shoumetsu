package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int a;
        boolean b;

        a() {
        }
    }

    /* renamed from: androidx.core.graphics.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0028b {
        public char a;
        public float[] b;

        C0028b(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        C0028b(C0028b c0028b) {
            this.a = c0028b.a;
            float[] fArr = c0028b.b;
            this.b = b.a(fArr, 0, fArr.length);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ceil;
            double d19 = d5;
            double d20 = d6;
            double d21 = d17;
            double d22 = d14;
            int i = 0;
            double d23 = d8;
            while (i < ceil) {
                double d24 = d23 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d23;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                int i2 = ceil;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d19 + (d22 * sin4)), (float) (d20 + (d21 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                i++;
                d18 = d18;
                ceil = i2;
                sin = sin;
                d20 = d26;
                d15 = d15;
                d23 = d24;
                d21 = d28;
                d22 = d27;
                cos = cos;
                d10 = d3;
                d19 = d25;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = d3 * cos;
            double d5 = f2;
            double d6 = f5;
            double d7 = (d4 + (d5 * sin)) / d6;
            double d8 = f6;
            double d9 = (((-f) * sin) + (d5 * cos)) / d8;
            double d10 = f4;
            double d11 = ((f3 * cos) + (d10 * sin)) / d6;
            double d12 = (((-f3) * sin) + (d10 * cos)) / d8;
            double d13 = d7 - d11;
            double d14 = d9 - d12;
            double d15 = (d7 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d17);
                float sqrt = (float) (Math.sqrt(d17) / 1.99999d);
                a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d18);
            double d19 = d13 * sqrt2;
            double d20 = sqrt2 * d14;
            if (z == z2) {
                d = d15 - d20;
                d2 = d16 + d19;
            } else {
                d = d15 + d20;
                d2 = d16 - d19;
            }
            double atan2 = Math.atan2(d9 - d2, d7 - d);
            double atan22 = Math.atan2(d12 - d2, d11 - d) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d21 = d * d6;
            double d22 = d2 * d8;
            a(path, (d21 * cos) - (d22 * sin), (d21 * sin) + (d22 * cos), d6, d8, d3, d5, radians, atan2, atan22);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            Path path2 = path;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                    i = 2;
                    break;
            }
            float f19 = f13;
            float f20 = f14;
            float f21 = f17;
            float f22 = f18;
            int i3 = 0;
            char c3 = c;
            while (i3 < fArr2.length) {
                float f23 = 0.0f;
                switch (c2) {
                    case 'A':
                        i2 = i3;
                        int i4 = i2 + 5;
                        int i5 = i2 + 6;
                        a(path, f19, f20, fArr2[i4], fArr2[i5], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f19 = fArr2[i4];
                        f20 = fArr2[i5];
                        f16 = f20;
                        f15 = f19;
                        break;
                    case 'C':
                        i2 = i3;
                        int i6 = i2 + 2;
                        int i7 = i2 + 3;
                        int i8 = i2 + 4;
                        int i9 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f19 = fArr2[i8];
                        float f24 = fArr2[i9];
                        float f25 = fArr2[i6];
                        float f26 = fArr2[i7];
                        f20 = f24;
                        f16 = f26;
                        f15 = f25;
                        break;
                    case 'H':
                        i2 = i3;
                        int i10 = i2 + 0;
                        path2.lineTo(fArr2[i10], f20);
                        f19 = fArr2[i10];
                        break;
                    case 'L':
                        i2 = i3;
                        int i11 = i2 + 0;
                        int i12 = i2 + 1;
                        path2.lineTo(fArr2[i11], fArr2[i12]);
                        f19 = fArr2[i11];
                        f20 = fArr2[i12];
                        break;
                    case 'M':
                        i2 = i3;
                        int i13 = i2 + 0;
                        f19 = fArr2[i13];
                        int i14 = i2 + 1;
                        f20 = fArr2[i14];
                        if (i2 <= 0) {
                            path2.moveTo(fArr2[i13], fArr2[i14]);
                            f22 = f20;
                            f21 = f19;
                            break;
                        } else {
                            path2.lineTo(fArr2[i13], fArr2[i14]);
                            break;
                        }
                    case 'Q':
                        i2 = i3;
                        int i15 = i2 + 0;
                        int i16 = i2 + 1;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        path2.quadTo(fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        f = fArr2[i15];
                        f2 = fArr2[i16];
                        f19 = fArr2[i17];
                        f20 = fArr2[i18];
                        f15 = f;
                        f16 = f2;
                        break;
                    case 'S':
                        float f27 = f20;
                        float f28 = f19;
                        i2 = i3;
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f29 = (f28 * 2.0f) - f15;
                            f3 = (f27 * 2.0f) - f16;
                            f4 = f29;
                        } else {
                            f4 = f28;
                            f3 = f27;
                        }
                        int i19 = i2 + 0;
                        int i20 = i2 + 1;
                        int i21 = i2 + 2;
                        int i22 = i2 + 3;
                        path.cubicTo(f4, f3, fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                        f = fArr2[i19];
                        f2 = fArr2[i20];
                        f19 = fArr2[i21];
                        f20 = fArr2[i22];
                        f15 = f;
                        f16 = f2;
                        break;
                    case 'T':
                        float f30 = f20;
                        float f31 = f19;
                        i2 = i3;
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f30 = (f30 * 2.0f) - f16;
                            f31 = (f31 * 2.0f) - f15;
                        }
                        int i23 = i2 + 0;
                        int i24 = i2 + 1;
                        path2.quadTo(f31, f30, fArr2[i23], fArr2[i24]);
                        f19 = fArr2[i23];
                        f5 = fArr2[i24];
                        f15 = f31;
                        f16 = f30;
                        f20 = f5;
                        break;
                    case 'V':
                        float f32 = f19;
                        i2 = i3;
                        int i25 = i2 + 0;
                        path2 = path;
                        path2.lineTo(f32, fArr2[i25]);
                        f5 = fArr2[i25];
                        f19 = f32;
                        f20 = f5;
                        break;
                    case 'a':
                        int i26 = i3 + 5;
                        float f33 = fArr2[i26] + f19;
                        int i27 = i3 + 6;
                        float f34 = fArr2[i27] + f20;
                        float f35 = fArr2[i3 + 0];
                        float f36 = fArr2[i3 + 1];
                        float f37 = fArr2[i3 + 2];
                        float f38 = f19;
                        boolean z = fArr2[i3 + 3] != 0.0f;
                        i2 = i3;
                        a(path, f19, f20, f33, f34, f35, f36, f37, z, fArr2[i3 + 4] != 0.0f);
                        f19 = f38 + fArr2[i26];
                        f20 += fArr2[i27];
                        f16 = f20;
                        f15 = f19;
                        path2 = path;
                        break;
                    case 'c':
                        int i28 = i3 + 2;
                        int i29 = i3 + 3;
                        int i30 = i3 + 4;
                        int i31 = i3 + 5;
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                        f6 = fArr2[i28] + f19;
                        f7 = fArr2[i29] + f20;
                        f19 += fArr2[i30];
                        f8 = fArr2[i31];
                        f20 += f8;
                        f15 = f6;
                        f16 = f7;
                        i2 = i3;
                        break;
                    case 'h':
                        int i32 = i3 + 0;
                        path2.rLineTo(fArr2[i32], 0.0f);
                        f19 += fArr2[i32];
                        i2 = i3;
                        break;
                    case 'l':
                        int i33 = i3 + 0;
                        int i34 = i3 + 1;
                        path2.rLineTo(fArr2[i33], fArr2[i34]);
                        f19 += fArr2[i33];
                        f9 = fArr2[i34];
                        f20 += f9;
                        i2 = i3;
                        break;
                    case 'm':
                        int i35 = i3 + 0;
                        f19 += fArr2[i35];
                        int i36 = i3 + 1;
                        f20 += fArr2[i36];
                        if (i3 > 0) {
                            path2.rLineTo(fArr2[i35], fArr2[i36]);
                        } else {
                            path2.rMoveTo(fArr2[i35], fArr2[i36]);
                            f22 = f20;
                            f21 = f19;
                        }
                        i2 = i3;
                        break;
                    case 'q':
                        int i37 = i3 + 0;
                        int i38 = i3 + 1;
                        int i39 = i3 + 2;
                        int i40 = i3 + 3;
                        path2.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                        f6 = fArr2[i37] + f19;
                        f7 = fArr2[i38] + f20;
                        f19 += fArr2[i39];
                        f8 = fArr2[i40];
                        f20 += f8;
                        f15 = f6;
                        f16 = f7;
                        i2 = i3;
                        break;
                    case 's':
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f39 = f19 - f15;
                            f10 = f20 - f16;
                            f11 = f39;
                        } else {
                            f11 = 0.0f;
                            f10 = 0.0f;
                        }
                        int i41 = i3 + 0;
                        int i42 = i3 + 1;
                        int i43 = i3 + 2;
                        int i44 = i3 + 3;
                        path.rCubicTo(f11, f10, fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                        f6 = fArr2[i41] + f19;
                        f7 = fArr2[i42] + f20;
                        f19 += fArr2[i43];
                        f8 = fArr2[i44];
                        f20 += f8;
                        f15 = f6;
                        f16 = f7;
                        i2 = i3;
                        break;
                    case 't':
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f23 = f19 - f15;
                            f12 = f20 - f16;
                        } else {
                            f12 = 0.0f;
                        }
                        int i45 = i3 + 0;
                        int i46 = i3 + 1;
                        path2.rQuadTo(f23, f12, fArr2[i45], fArr2[i46]);
                        float f40 = f23 + f19;
                        float f41 = f12 + f20;
                        f19 += fArr2[i45];
                        f20 += fArr2[i46];
                        f16 = f41;
                        i2 = i3;
                        f15 = f40;
                        break;
                    case 'v':
                        int i47 = i3 + 0;
                        path2.rLineTo(0.0f, fArr2[i47]);
                        f9 = fArr2[i47];
                        f20 += f9;
                        i2 = i3;
                        break;
                    default:
                        i2 = i3;
                        f20 = f20;
                        break;
                }
                i3 = i2 + i;
                c3 = c2;
            }
            fArr[0] = f19;
            fArr[1] = f20;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f21;
            fArr[5] = f22;
        }

        public static void a(C0028b[] c0028bArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < c0028bArr.length; i++) {
                a(path, fArr, c, c0028bArr[i].a, c0028bArr[i].b);
                c = c0028bArr[i].a;
            }
        }

        public void a(C0028b c0028b, C0028b c0028b2, float f) {
            int i = 0;
            while (true) {
                float[] fArr = c0028b.b;
                if (i < fArr.length) {
                    this.b[i] = (fArr[i] * (1.0f - f)) + (c0028b2.b[i] * f);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static Path a(String str) {
        Path path = new Path();
        C0028b[] b = b(str);
        if (b != null) {
            try {
                C0028b.a(b, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException("Error in parsing " + str, e);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r2 == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038 A[LOOP:0: B:3:0x0007->B:24:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, a aVar) {
        aVar.b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i) {
                            }
                            z = false;
                            break;
                        case '.':
                            if (!z2) {
                                z = false;
                                z2 = true;
                                break;
                            }
                            aVar.b = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (!z3) {
                    aVar.a = i2;
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
            }
        }
        aVar.a = i2;
    }

    private static void a(ArrayList<C0028b> arrayList, char c, float[] fArr) {
        arrayList.add(new C0028b(c, fArr));
    }

    public static boolean a(C0028b[] c0028bArr, C0028b[] c0028bArr2) {
        if (c0028bArr == null || c0028bArr2 == null || c0028bArr.length != c0028bArr2.length) {
            return false;
        }
        for (int i = 0; i < c0028bArr.length; i++) {
            if (c0028bArr[i].a != c0028bArr2[i].a || c0028bArr[i].b.length != c0028bArr2[i].b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static C0028b[] a(C0028b[] c0028bArr) {
        if (c0028bArr == null) {
            return null;
        }
        C0028b[] c0028bArr2 = new C0028b[c0028bArr.length];
        for (int i = 0; i < c0028bArr.length; i++) {
            c0028bArr2[i] = new C0028b(c0028bArr[i]);
        }
        return c0028bArr2;
    }

    public static void b(C0028b[] c0028bArr, C0028b[] c0028bArr2) {
        for (int i = 0; i < c0028bArr2.length; i++) {
            c0028bArr[i].a = c0028bArr2[i].a;
            for (int i2 = 0; i2 < c0028bArr2[i].b.length; i2++) {
                c0028bArr[i].b[i2] = c0028bArr2[i].b[i2];
            }
        }
    }

    public static C0028b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a2 = a(str, i);
            String trim = str.substring(i2, a2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i2 = a2;
            i = a2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0028b[]) arrayList.toArray(new C0028b[arrayList.size()]);
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
