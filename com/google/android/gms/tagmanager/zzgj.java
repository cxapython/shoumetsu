package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzgj {
    private static final Object a = null;
    private static Long b = new Long(0);
    private static Double c = new Double(0.0d);
    private static dz d = dz.a(0);
    private static String e = new String("");
    private static Boolean f = new Boolean(false);
    private static List<Object> g = new ArrayList(0);
    private static Map<Object, Object> h = new HashMap();
    private static zzl i = zzi(e);

    private static dz a(String str) {
        try {
            return dz.a(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
            sb.append("Failed to convert '");
            sb.append(str);
            sb.append("' to a number.");
            zzdi.zzav(sb.toString());
            return d;
        }
    }

    private static String a(Object obj) {
        return obj == null ? e : obj.toString();
    }

    private static boolean b(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        return (obj instanceof dz) && ((dz) obj).a();
    }

    private static double c(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzdi.zzav("getDouble received non-Number");
        return 0.0d;
    }

    private static boolean d(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return (obj instanceof dz) && ((dz) obj).b();
    }

    private static long e(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdi.zzav("getInt64 received non-Number");
        return 0L;
    }

    public static zzl zzbp(String str) {
        zzl zzlVar = new zzl();
        zzlVar.type = 5;
        zzlVar.zzqr = str;
        return zzlVar;
    }

    public static String zzc(zzl zzlVar) {
        return a(zzh(zzlVar));
    }

    public static dz zzd(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        return zzh instanceof dz ? (dz) zzh : d(zzh) ? dz.a(e(zzh)) : b(zzh) ? dz.a(Double.valueOf(c(zzh))) : a(a(zzh));
    }

    public static Long zze(zzl zzlVar) {
        long longValue;
        Object zzh = zzh(zzlVar);
        if (d(zzh)) {
            longValue = e(zzh);
        } else {
            dz a2 = a(a(zzh));
            if (a2 == d) {
                return b;
            }
            longValue = a2.longValue();
        }
        return Long.valueOf(longValue);
    }

    public static Double zzf(zzl zzlVar) {
        double doubleValue;
        Object zzh = zzh(zzlVar);
        if (b(zzh)) {
            doubleValue = c(zzh);
        } else {
            dz a2 = a(a(zzh));
            if (a2 == d) {
                return c;
            }
            doubleValue = a2.doubleValue();
        }
        return Double.valueOf(doubleValue);
    }

    public static Boolean zzg(zzl zzlVar) {
        Object zzh = zzh(zzlVar);
        if (zzh instanceof Boolean) {
            return (Boolean) zzh;
        }
        String a2 = a(zzh);
        return "true".equalsIgnoreCase(a2) ? Boolean.TRUE : "false".equalsIgnoreCase(a2) ? Boolean.FALSE : f;
    }

    public static Object zzh(zzl zzlVar) {
        String str;
        if (zzlVar == null) {
            return null;
        }
        int i2 = 0;
        switch (zzlVar.type) {
            case 1:
                return zzlVar.string;
            case 2:
                ArrayList arrayList = new ArrayList(zzlVar.zzqn.length);
                zzl[] zzlVarArr = zzlVar.zzqn;
                int length = zzlVarArr.length;
                while (i2 < length) {
                    Object zzh = zzh(zzlVarArr[i2]);
                    if (zzh == null) {
                        return null;
                    }
                    arrayList.add(zzh);
                    i2++;
                }
                return arrayList;
            case 3:
                if (zzlVar.zzqo.length != zzlVar.zzqp.length) {
                    String valueOf = String.valueOf(zzlVar.toString());
                    zzdi.zzav(valueOf.length() != 0 ? "Converting an invalid value to object: ".concat(valueOf) : new String("Converting an invalid value to object: "));
                    return null;
                }
                HashMap hashMap = new HashMap(zzlVar.zzqp.length);
                while (i2 < zzlVar.zzqo.length) {
                    Object zzh2 = zzh(zzlVar.zzqo[i2]);
                    Object zzh3 = zzh(zzlVar.zzqp[i2]);
                    if (zzh2 == null || zzh3 == null) {
                        return null;
                    }
                    hashMap.put(zzh2, zzh3);
                    i2++;
                }
                return hashMap;
            case 4:
                str = "Trying to convert a macro reference to object";
                break;
            case 5:
                str = "Trying to convert a function id to object";
                break;
            case 6:
                return Long.valueOf(zzlVar.zzqs);
            case 7:
                StringBuilder sb = new StringBuilder();
                zzl[] zzlVarArr2 = zzlVar.zzqu;
                int length2 = zzlVarArr2.length;
                while (i2 < length2) {
                    String a2 = a(zzh(zzlVarArr2[i2]));
                    if (a2 == e) {
                        return null;
                    }
                    sb.append(a2);
                    i2++;
                }
                return sb.toString();
            case 8:
                return Boolean.valueOf(zzlVar.zzqt);
            default:
                int i3 = zzlVar.type;
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed to convert a value of type: ");
                sb2.append(i3);
                str = sb2.toString();
                break;
        }
        zzdi.zzav(str);
        return null;
    }

    public static zzl zzi(Object obj) {
        String obj2;
        zzl zzlVar = new zzl();
        if (obj instanceof zzl) {
            return (zzl) obj;
        }
        boolean z = false;
        if (!(obj instanceof String)) {
            if (obj instanceof List) {
                zzlVar.type = 2;
                List<Object> list = (List) obj;
                ArrayList arrayList = new ArrayList(list.size());
                boolean z2 = false;
                for (Object obj3 : list) {
                    zzl zzi = zzi(obj3);
                    zzl zzlVar2 = i;
                    if (zzi == zzlVar2) {
                        return zzlVar2;
                    }
                    z2 = z2 || zzi.zzqw;
                    arrayList.add(zzi);
                }
                zzlVar.zzqn = (zzl[]) arrayList.toArray(new zzl[0]);
                z = z2;
            } else if (obj instanceof Map) {
                zzlVar.type = 3;
                Set<Map.Entry> entrySet = ((Map) obj).entrySet();
                ArrayList arrayList2 = new ArrayList(entrySet.size());
                ArrayList arrayList3 = new ArrayList(entrySet.size());
                boolean z3 = false;
                for (Map.Entry entry : entrySet) {
                    zzl zzi2 = zzi(entry.getKey());
                    zzl zzi3 = zzi(entry.getValue());
                    zzl zzlVar3 = i;
                    if (zzi2 == zzlVar3 || zzi3 == zzlVar3) {
                        return i;
                    }
                    z3 = z3 || zzi2.zzqw || zzi3.zzqw;
                    arrayList2.add(zzi2);
                    arrayList3.add(zzi3);
                }
                zzlVar.zzqo = (zzl[]) arrayList2.toArray(new zzl[0]);
                zzlVar.zzqp = (zzl[]) arrayList3.toArray(new zzl[0]);
                z = z3;
            } else if (b(obj)) {
                zzlVar.type = 1;
                obj2 = obj.toString();
            } else if (d(obj)) {
                zzlVar.type = 6;
                zzlVar.zzqs = e(obj);
            } else if (!(obj instanceof Boolean)) {
                String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
                zzdi.zzav(valueOf.length() != 0 ? "Converting to Value from unknown object type: ".concat(valueOf) : new String("Converting to Value from unknown object type: "));
                return i;
            } else {
                zzlVar.type = 8;
                zzlVar.zzqt = ((Boolean) obj).booleanValue();
            }
            zzlVar.zzqw = z;
            return zzlVar;
        }
        zzlVar.type = 1;
        obj2 = (String) obj;
        zzlVar.string = obj2;
        zzlVar.zzqw = z;
        return zzlVar;
    }

    public static Object zzjw() {
        return null;
    }

    public static Long zzjx() {
        return b;
    }

    public static Double zzjy() {
        return c;
    }

    public static Boolean zzjz() {
        return f;
    }

    public static dz zzka() {
        return d;
    }

    public static String zzkb() {
        return e;
    }

    public static zzl zzkc() {
        return i;
    }
}
