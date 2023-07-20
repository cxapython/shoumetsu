package com.microsoft.appcenter.c.a.b;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private static Object a(com.microsoft.appcenter.c.a.c.f fVar) {
        Object valueOf;
        String c = fVar.c();
        if (c != null) {
            if (c.equals("baseType") && !(fVar instanceof com.microsoft.appcenter.c.a.c.e)) {
                throw new IllegalArgumentException("baseType must be a string.");
            }
            if (c.startsWith("baseType.")) {
                throw new IllegalArgumentException("baseType must be a string.");
            }
            if (c.equals("baseData")) {
                throw new IllegalArgumentException("baseData must be an object.");
            }
            if (fVar instanceof com.microsoft.appcenter.c.a.c.e) {
                valueOf = ((com.microsoft.appcenter.c.a.c.e) fVar).b();
            } else if (fVar instanceof com.microsoft.appcenter.c.a.c.d) {
                valueOf = Long.valueOf(((com.microsoft.appcenter.c.a.c.d) fVar).b());
            } else if (fVar instanceof com.microsoft.appcenter.c.a.c.c) {
                valueOf = Double.valueOf(((com.microsoft.appcenter.c.a.c.c) fVar).b());
            } else if (fVar instanceof com.microsoft.appcenter.c.a.c.b) {
                valueOf = com.microsoft.appcenter.c.a.a.d.a(((com.microsoft.appcenter.c.a.c.b) fVar).b());
            } else if (!(fVar instanceof com.microsoft.appcenter.c.a.c.a)) {
                throw new IllegalArgumentException("Unsupported property type: " + fVar.a());
            } else {
                valueOf = Boolean.valueOf(((com.microsoft.appcenter.c.a.c.a) fVar).b());
            }
            if (valueOf != null) {
                return valueOf;
            }
            throw new IllegalArgumentException("Value of property with key '" + c + "' cannot be null.");
        }
        throw new IllegalArgumentException("Property key cannot be null.");
    }

    private static JSONObject a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("f");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            jSONObject.put("f", optJSONObject);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 == null) {
            JSONObject jSONObject2 = new JSONObject();
            optJSONObject.put(str, jSONObject2);
            return jSONObject2;
        }
        return optJSONObject2;
    }

    private static void a(Integer num, JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("f");
        if (num == null) {
            if (optJSONObject == null) {
                return;
            }
            optJSONObject.remove(str);
            return;
        }
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            jSONObject.put("f", optJSONObject);
        }
        optJSONObject.put(str, num);
    }

    public static void a(List<com.microsoft.appcenter.c.a.c.f> list, c cVar) {
        if (list == null) {
            return;
        }
        try {
            d dVar = new d();
            cVar.a(dVar);
            h hVar = new h();
            for (com.microsoft.appcenter.c.a.c.f fVar : list) {
                try {
                    Object a = a(fVar);
                    Integer b = b(fVar);
                    String[] split = fVar.c().split("\\.", -1);
                    int length = split.length - 1;
                    JSONObject a2 = dVar.a();
                    JSONObject a3 = hVar.a();
                    for (int i = 0; i < length; i++) {
                        String str = split[i];
                        JSONObject optJSONObject = a2.optJSONObject(str);
                        if (optJSONObject == null) {
                            if (a2.has(str)) {
                                com.microsoft.appcenter.e.a.d("AppCenter", "Property key '" + str + "' already has a value, the old value will be overridden.");
                            }
                            optJSONObject = new JSONObject();
                            a2.put(str, optJSONObject);
                        }
                        a2 = optJSONObject;
                        a3 = a(a3, str);
                    }
                    String str2 = split[length];
                    if (a2.has(str2)) {
                        com.microsoft.appcenter.e.a.d("AppCenter", "Property key '" + str2 + "' already has a value, the old value will be overridden.");
                    }
                    a2.put(str2, a);
                    a(b, a3, str2);
                } catch (IllegalArgumentException e) {
                    com.microsoft.appcenter.e.a.d("AppCenter", e.getMessage());
                }
            }
            JSONObject a4 = dVar.a();
            String optString = a4.optString("baseType", null);
            JSONObject optJSONObject2 = a4.optJSONObject("baseData");
            if (optString == null && optJSONObject2 != null) {
                com.microsoft.appcenter.e.a.d("AppCenter", "baseData was set but baseType is missing.");
                a4.remove("baseData");
                hVar.a().optJSONObject("f").remove("baseData");
            }
            if (optString != null && optJSONObject2 == null) {
                com.microsoft.appcenter.e.a.d("AppCenter", "baseType was set but baseData is missing.");
                a4.remove("baseType");
            }
            if (a(hVar.a())) {
                return;
            }
            if (cVar.h() == null) {
                cVar.a(new f());
            }
            cVar.h().a(hVar);
        } catch (JSONException unused) {
        }
    }

    private static boolean a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(keys.next());
            if (optJSONObject != null && a(optJSONObject)) {
                keys.remove();
            }
        }
        return jSONObject.length() == 0;
    }

    private static Integer b(com.microsoft.appcenter.c.a.c.f fVar) {
        int i;
        if (fVar instanceof com.microsoft.appcenter.c.a.c.d) {
            i = 4;
        } else if (fVar instanceof com.microsoft.appcenter.c.a.c.c) {
            i = 6;
        } else if (!(fVar instanceof com.microsoft.appcenter.c.a.c.b)) {
            return null;
        } else {
            i = 9;
        }
        return Integer.valueOf(i);
    }
}
