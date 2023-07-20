package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzsk zzskVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(zzskVar, sb, 0);
        return sb.toString();
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f8, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01fa, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x020a, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x021b, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x022d, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(zzsk zzskVar, StringBuilder sb, int i) {
        Method[] declaredMethods;
        boolean booleanValue;
        Object obj;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzskVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i, a(concat), zzrc.a(method2, zzskVar, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i, a(concat2), zzrc.a(method3, zzskVar, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (!hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object a = zzrc.a(method4, zzskVar, new Object[0]);
                    if (method5 == null) {
                        if (!(a instanceof Boolean)) {
                            if (!(a instanceof Integer)) {
                                if (!(a instanceof Float)) {
                                    if (!(a instanceof Double)) {
                                        if (a instanceof String) {
                                            obj = "";
                                        } else if (a instanceof zzps) {
                                            obj = zzps.zzavx;
                                        } else {
                                            equals = !(a instanceof zzsk) ? false : false;
                                        }
                                        equals = a.equals(obj);
                                    }
                                }
                            }
                        }
                        booleanValue = !equals;
                    } else {
                        booleanValue = ((Boolean) zzrc.a(method5, zzskVar, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        a(sb, i, a(concat3), a);
                    }
                }
            }
        }
        if (zzskVar instanceof zzrc.zzc) {
            Iterator<Map.Entry<Object, Object>> d = ((zzrc.zzc) zzskVar).zzbaq.d();
            if (d.hasNext()) {
                d.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        zzrc zzrcVar = (zzrc) zzskVar;
        if (zzrcVar.zzbak != null) {
            zzrcVar.zzbak.a(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                a(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                a(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(TokenParser.SP);
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(ds.a(zzps.zzcy((String) obj)));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof zzps) {
                sb.append(": \"");
                sb.append(ds.a((zzps) obj));
                sb.append(TokenParser.DQUOTE);
            } else if (obj instanceof zzrc) {
                sb.append(" {");
                a((zzrc) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(TokenParser.SP);
                    i2++;
                }
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj.toString());
            } else {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                a(sb, i4, "key", entry2.getKey());
                a(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(TokenParser.SP);
                    i2++;
                }
                sb.append("}");
            }
        }
    }
}
