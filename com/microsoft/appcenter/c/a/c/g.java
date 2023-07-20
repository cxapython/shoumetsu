package com.microsoft.appcenter.c.a.c;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    public static f a(String str) {
        if ("boolean".equals(str)) {
            return new a();
        }
        if ("dateTime".equals(str)) {
            return new b();
        }
        if ("double".equals(str)) {
            return new c();
        }
        if (Constants.LONG.equals(str)) {
            return new d();
        }
        if ("string".equals(str)) {
            return new e();
        }
        throw new JSONException("Unsupported type: " + str);
    }

    public static List<f> a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("typedProperties");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                f a = a(jSONObject2.getString(net.gree.gamelib.payment.internal.a.e.J));
                a.a(jSONObject2);
                arrayList.add(a);
            }
            return arrayList;
        }
        return null;
    }
}
