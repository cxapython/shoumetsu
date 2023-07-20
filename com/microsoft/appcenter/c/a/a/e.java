package com.microsoft.appcenter.c.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class e {
    public static Integer a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        return null;
    }

    public static <M extends com.microsoft.appcenter.c.a.g> List<M> a(JSONObject jSONObject, String str, h<M> hVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List<M> a = hVar.a(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            M c = hVar.c();
            c.a(jSONObject2);
            a.add(c);
        }
        return a;
    }

    public static void a(JSONStringer jSONStringer, String str, Object obj) {
        if (obj != null) {
            jSONStringer.key(str).value(obj);
        }
    }

    public static void a(JSONStringer jSONStringer, String str, List<? extends com.microsoft.appcenter.c.a.g> list) {
        if (list != null) {
            jSONStringer.key(str).array();
            for (com.microsoft.appcenter.c.a.g gVar : list) {
                jSONStringer.object();
                gVar.a(jSONStringer);
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
        }
    }

    public static void a(JSONStringer jSONStringer, String str, Map<String, String> map) {
        if (map != null) {
            jSONStringer.key(str).object();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONStringer.key(entry.getKey()).value(entry.getValue());
            }
            jSONStringer.endObject();
        }
    }

    public static Long b(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        return null;
    }

    public static void b(JSONStringer jSONStringer, String str, List<String> list) {
        if (list != null) {
            jSONStringer.key(str).array();
            for (String str2 : list) {
                jSONStringer.value(str2);
            }
            jSONStringer.endArray();
        }
    }

    public static Boolean c(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        return null;
    }

    public static Map<String, String> d(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap(optJSONObject.length());
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, optJSONObject.getString(next));
        }
        return hashMap;
    }

    public static List<String> e(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return arrayList;
    }
}
