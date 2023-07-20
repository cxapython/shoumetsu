package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzow;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class aw {
    public static zzov a(String str) {
        zzl zzi = zzgj.zzi(a(new JSONObject(str)));
        zzow zzmn = zzov.zzmn();
        for (int i = 0; i < zzi.zzqo.length; i++) {
            zzmn.zzc(zzot.zzml().zzb(zzb.INSTANCE_NAME.toString(), zzi.zzqo[i]).zzb(zzb.FUNCTION.toString(), zzgj.zzbp(em.a())).zzb(em.b(), zzi.zzqp[i]).zzmm());
        }
        return zzmn.zzmp();
    }

    @VisibleForTesting
    private static Object a(Object obj) {
        if (!(obj instanceof JSONArray)) {
            if (JSONObject.NULL.equals(obj)) {
                throw new RuntimeException("JSON nulls are not supported");
            }
            if (!(obj instanceof JSONObject)) {
                return obj;
            }
            JSONObject jSONObject = (JSONObject) obj;
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, a(jSONObject.get(next)));
            }
            return hashMap;
        }
        throw new RuntimeException("JSONArrays are not supported");
    }
}
