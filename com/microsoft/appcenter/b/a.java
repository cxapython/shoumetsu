package com.microsoft.appcenter.b;

import com.microsoft.appcenter.b.d;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a implements d.a {
    @Override // com.microsoft.appcenter.b.d.a
    public void a(URL url, Map<String, String> map) {
        if (com.microsoft.appcenter.e.a.a() <= 2) {
            com.microsoft.appcenter.e.a.a("AppCenter", "Calling " + url + "...");
            HashMap hashMap = new HashMap(map);
            String str = (String) hashMap.get("App-Secret");
            if (str != null) {
                hashMap.put("App-Secret", j.a(str));
            }
            String str2 = (String) hashMap.get("Authorization");
            if (str2 != null) {
                hashMap.put("Authorization", j.d(str2));
            }
            com.microsoft.appcenter.e.a.a("AppCenter", "Headers: " + hashMap);
        }
    }
}
