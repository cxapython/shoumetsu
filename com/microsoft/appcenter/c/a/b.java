package com.microsoft.appcenter.c.a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class b extends a {
    private Map<String, Object> a;

    private static void a(JSONStringer jSONStringer, Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == null) {
            com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.e.J, "clear");
            return;
        }
        if (obj instanceof Boolean) {
            str = net.gree.gamelib.payment.internal.a.e.J;
            str2 = "boolean";
        } else if (obj instanceof Number) {
            str = net.gree.gamelib.payment.internal.a.e.J;
            str2 = "number";
        } else if (obj instanceof Date) {
            com.microsoft.appcenter.c.a.a.e.a(jSONStringer, net.gree.gamelib.payment.internal.a.e.J, "dateTime");
            str3 = "value";
            obj = com.microsoft.appcenter.c.a.a.d.a((Date) obj);
            com.microsoft.appcenter.c.a.a.e.a(jSONStringer, str3, obj);
        } else if (!(obj instanceof String)) {
            throw new JSONException("Invalid value type");
        } else {
            str = net.gree.gamelib.payment.internal.a.e.J;
            str2 = "string";
        }
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, str, str2);
        str3 = "value";
        com.microsoft.appcenter.c.a.a.e.a(jSONStringer, str3, obj);
    }

    private static void a(JSONStringer jSONStringer, Map<String, Object> map) {
        if (map != null) {
            jSONStringer.key("properties").array();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONStringer.object();
                com.microsoft.appcenter.c.a.a.e.a(jSONStringer, Product.KEY_NAME, entry.getKey());
                a(jSONStringer, entry.getValue());
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            return;
        }
        throw new JSONException("Properties cannot be null");
    }

    private static Map<String, Object> b(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("properties");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            hashMap.put(jSONObject2.getString(Product.KEY_NAME), c(jSONObject2));
        }
        return hashMap;
    }

    private static Object c(JSONObject jSONObject) {
        String string = jSONObject.getString(net.gree.gamelib.payment.internal.a.e.J);
        if (string.equals("clear")) {
            return null;
        }
        if (string.equals("boolean")) {
            return Boolean.valueOf(jSONObject.getBoolean("value"));
        }
        if (string.equals("number")) {
            Object obj = jSONObject.get("value");
            if (!(obj instanceof Number)) {
                throw new JSONException("Invalid value type");
            }
            return obj;
        } else if (string.equals("dateTime")) {
            return com.microsoft.appcenter.c.a.a.d.a(jSONObject.getString("value"));
        } else {
            if (!string.equals("string")) {
                throw new JSONException("Invalid value type");
            }
            return jSONObject.getString("value");
        }
    }

    @Override // com.microsoft.appcenter.c.a.d
    public String a() {
        return "customProperties";
    }

    public void a(Map<String, Object> map) {
        this.a = map;
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        a(b(jSONObject));
    }

    @Override // com.microsoft.appcenter.c.a.a, com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        super.a(jSONStringer);
        a(jSONStringer, b());
    }

    public Map<String, Object> b() {
        return this.a;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        Map<String, Object> map = this.a;
        return map != null ? map.equals(bVar.a) : bVar.a == null;
    }

    @Override // com.microsoft.appcenter.c.a.a
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Map<String, Object> map = this.a;
        return hashCode + (map != null ? map.hashCode() : 0);
    }
}
