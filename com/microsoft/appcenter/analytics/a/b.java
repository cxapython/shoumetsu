package com.microsoft.appcenter.analytics.a;

import com.adjust.sdk.Constants;
import com.microsoft.appcenter.c.a.c.d;
import com.microsoft.appcenter.c.a.c.e;
import com.microsoft.appcenter.c.a.c.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends com.microsoft.appcenter.a.a {
    /* JADX WARN: Multi-variable type inference failed */
    private static f a(f fVar, String str) {
        e eVar;
        String a = fVar.a();
        if ("boolean".equals(a)) {
            com.microsoft.appcenter.c.a.c.a aVar = new com.microsoft.appcenter.c.a.c.a();
            aVar.a(((com.microsoft.appcenter.c.a.c.a) fVar).b());
            eVar = aVar;
        } else if ("dateTime".equals(a)) {
            com.microsoft.appcenter.c.a.c.b bVar = new com.microsoft.appcenter.c.a.c.b();
            bVar.a(((com.microsoft.appcenter.c.a.c.b) fVar).b());
            eVar = bVar;
        } else if ("double".equals(a)) {
            com.microsoft.appcenter.c.a.c.c cVar = new com.microsoft.appcenter.c.a.c.c();
            cVar.a(((com.microsoft.appcenter.c.a.c.c) fVar).b());
            eVar = cVar;
        } else if (Constants.LONG.equals(a)) {
            d dVar = new d();
            dVar.a(((d) fVar).b());
            eVar = dVar;
        } else {
            e eVar2 = new e();
            eVar2.a(((e) fVar).b());
            eVar = eVar2;
        }
        eVar.b(str);
        return eVar;
    }

    private static String a(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            if (str.length() <= 256) {
                return str;
            }
            com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("%s '%s' : name length cannot be longer than %s characters. Name will be truncated.", str2, str, 256));
            return str.substring(0, 256);
        }
        com.microsoft.appcenter.e.a.e("AppCenterAnalytics", str2 + " name cannot be null or empty.");
        return null;
    }

    private static Map<String, String> a(Map<String, String> map, String str, String str2) {
        String format;
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            String value = next.getValue();
            if (hashMap.size() >= 20) {
                com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("%s '%s' : properties cannot contain more than %s items. Skipping other properties.", str2, str, 20));
                break;
            }
            if (key == null || key.isEmpty()) {
                format = String.format("%s '%s' : a property key cannot be null or empty. Property will be skipped.", str2, str);
            } else if (value == null) {
                format = String.format("%s '%s' : property '%s' : property value cannot be null. Property '%s' will be skipped.", str2, str, key, key);
            } else {
                if (key.length() > 125) {
                    com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("%s '%s' : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", str2, str, key, 125));
                    key = key.substring(0, 125);
                }
                if (value.length() > 125) {
                    com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("%s '%s' : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", str2, str, key, 125));
                    value = value.substring(0, 125);
                }
                hashMap.put(key, value);
            }
            com.microsoft.appcenter.e.a.d("AppCenterAnalytics", format);
        }
        return hashMap;
    }

    private static void a(List<f> list) {
        boolean z;
        if (list == null) {
            return;
        }
        ListIterator<f> listIterator = list.listIterator();
        int i = 0;
        boolean z2 = false;
        while (listIterator.hasNext()) {
            f next = listIterator.next();
            String c = next.c();
            if (i >= 20) {
                if (!z2) {
                    com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("Typed properties cannot contain more than %s items. Skipping other properties.", 20));
                    z2 = true;
                }
            } else if (c == null || c.isEmpty()) {
                com.microsoft.appcenter.e.a.d("AppCenterAnalytics", "A typed property key cannot be null or empty. Property will be skipped.");
            } else {
                if (c.length() > 125) {
                    com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("Typed property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", c, 125));
                    c = c.substring(0, 125);
                    next = a(next, c);
                    listIterator.set(next);
                    z = false;
                } else {
                    z = true;
                }
                if (next instanceof e) {
                    e eVar = (e) next;
                    String b = eVar.b();
                    if (b == null) {
                        com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("Typed property '%s' : property value cannot be null. Property '%s' will be skipped.", c, c));
                    } else if (b.length() > 125) {
                        com.microsoft.appcenter.e.a.d("AppCenterAnalytics", String.format("A String property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", c, 125));
                        String substring = b.substring(0, 125);
                        if (z) {
                            e eVar2 = new e();
                            eVar2.b(c);
                            eVar2.a(substring);
                            listIterator.set(eVar2);
                        } else {
                            eVar.a(substring);
                        }
                    }
                }
                i++;
            }
            listIterator.remove();
        }
    }

    private boolean a(com.microsoft.appcenter.analytics.b.a.a aVar) {
        String a = a(aVar.d(), aVar.a());
        if (a == null) {
            return false;
        }
        a(aVar.c());
        aVar.a(a);
        return true;
    }

    private boolean a(com.microsoft.appcenter.analytics.b.a.b bVar) {
        String a = a(bVar.d(), bVar.a());
        if (a == null) {
            return false;
        }
        Map<String, String> a2 = a(bVar.e(), a, bVar.a());
        bVar.a(a);
        bVar.a(a2);
        return true;
    }

    @Override // com.microsoft.appcenter.a.a, com.microsoft.appcenter.a.b.InterfaceC0058b
    public boolean a(com.microsoft.appcenter.c.a.d dVar) {
        if (dVar instanceof com.microsoft.appcenter.analytics.b.a.c) {
            return !a((com.microsoft.appcenter.analytics.b.a.b) dVar);
        }
        if (!(dVar instanceof com.microsoft.appcenter.analytics.b.a.a)) {
            return false;
        }
        return !a((com.microsoft.appcenter.analytics.b.a.a) dVar);
    }
}
