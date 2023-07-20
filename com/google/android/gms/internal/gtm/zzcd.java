package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import cz.msebera.android.httpclient.impl.client.cache.CacheConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzcd {
    private final Map<String, String> a;
    private final List<zzbk> b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final String g;

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z) {
        this(zzamVar, map, j, z, 0L, 0, null);
    }

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzamVar, map, j, z, j2, i, null);
    }

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbk> list) {
        String str;
        String a;
        String a2;
        Preconditions.checkNotNull(zzamVar);
        Preconditions.checkNotNull(map);
        this.d = j;
        this.f = z;
        this.c = j2;
        this.e = i;
        this.b = list != null ? list : Collections.emptyList();
        String str2 = null;
        if (list != null) {
            for (zzbk zzbkVar : list) {
                if ("appendVersion".equals(zzbkVar.getId())) {
                    str = zzbkVar.getValue();
                    break;
                }
            }
        }
        str = null;
        this.g = !TextUtils.isEmpty(str) ? str : str2;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (a(entry.getKey()) && (a2 = a(zzamVar, entry.getKey())) != null) {
                hashMap.put(a2, b(zzamVar, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!a(entry2.getKey()) && (a = a(zzamVar, entry2.getKey())) != null) {
                hashMap.put(a, b(zzamVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            zzcz.zzb(hashMap, "_v", this.g);
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.a = Collections.unmodifiableMap(hashMap);
    }

    private static String a(zzam zzamVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzamVar.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (!TextUtils.isEmpty(obj2)) {
            return obj2;
        }
        return null;
    }

    private final String a(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(!str.startsWith("&"), "Short param name required");
        String str3 = this.a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String b(zzam zzamVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length > 8192) {
            String substring = obj2.substring(0, CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES);
            zzamVar.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
            return substring;
        }
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.d);
        if (this.c != 0) {
            sb.append(", dbId=");
            sb.append(this.c);
        }
        if (this.e != 0) {
            sb.append(", appUID=");
            sb.append(this.e);
        }
        ArrayList arrayList = new ArrayList(this.a.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append(this.a.get(str));
        }
        return sb.toString();
    }

    public final Map<String, String> zzdm() {
        return this.a;
    }

    public final int zzff() {
        return this.e;
    }

    public final long zzfg() {
        return this.c;
    }

    public final long zzfh() {
        return this.d;
    }

    public final List<zzbk> zzfi() {
        return this.b;
    }

    public final boolean zzfj() {
        return this.f;
    }

    public final long zzfk() {
        return zzcz.zzag(a("_s", "0"));
    }

    public final String zzfl() {
        return a("_m", "");
    }
}
