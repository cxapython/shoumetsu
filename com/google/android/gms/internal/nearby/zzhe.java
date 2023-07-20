package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class zzhe {
    private static HashMap<String, String> f;
    private static Object k;
    private static boolean l;
    private static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static final Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean e = new AtomicBoolean();
    private static final HashMap<String, Boolean> g = new HashMap<>();
    private static final HashMap<String, Integer> h = new HashMap<>();
    private static final HashMap<String, Long> i = new HashMap<>();
    private static final HashMap<String, Float> j = new HashMap<>();
    private static String[] m = new String[0];

    private static <T> T a(HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzhe.class) {
            if (hashMap.containsKey(str)) {
                T t2 = hashMap.get(str);
                if (t2 == null) {
                    t2 = t;
                }
                return t2;
            }
            return null;
        }
    }

    private static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzhe.class) {
            a(contentResolver);
            Object obj = k;
            if (f.containsKey(str)) {
                String str3 = f.get(str);
                if (str3 == null) {
                    str3 = null;
                }
                return str3;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!l || f.isEmpty()) {
                        f.putAll(a(contentResolver, m));
                        l = true;
                        if (f.containsKey(str)) {
                            String str5 = f.get(str);
                            if (str5 == null) {
                                str5 = null;
                            }
                            return str5;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(a, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        a(obj, str, string);
                        if (string == null) {
                            string = null;
                        }
                        return string;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            a(obj, str, (String) null);
            if (query != null) {
                query.close();
            }
            return null;
        }
    }

    private static Map<String, String> a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void a(ContentResolver contentResolver) {
        if (f == null) {
            e.set(false);
            f = new HashMap<>();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(a, true, new ck(null));
        } else if (!e.getAndSet(false)) {
        } else {
            f.clear();
            g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    private static void a(Object obj, String str, String str2) {
        synchronized (zzhe.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }

    private static Object b(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzhe.class) {
            a(contentResolver);
            obj = k;
        }
        return obj;
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object b2 = b(contentResolver);
        boolean z2 = true;
        Boolean bool = (Boolean) a((HashMap<String, boolean>) g, str, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        String a2 = a(contentResolver, str, (String) null);
        if (a2 != null && !a2.equals("")) {
            if (c.matcher(a2).matches()) {
                bool = true;
            } else if (d.matcher(a2).matches()) {
                bool = false;
                z2 = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + a2 + "\") as boolean");
            }
        }
        HashMap<String, Boolean> hashMap = g;
        synchronized (zzhe.class) {
            if (b2 == k) {
                hashMap.put(str, bool);
                f.remove(str);
            }
        }
        return z2;
    }
}
