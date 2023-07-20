package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f<T> {
    private final T a;
    private final b<T> b;

    /* loaded from: classes.dex */
    private static class a implements b<Context> {
        private a() {
        }

        private static Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.f.b
        public List<String> a(Context context) {
            Bundle b = b(context);
            if (b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    interface b<T> {
        List<String> a(T t);
    }

    f(T t, b<T> bVar) {
        this.a = t;
        this.b = bVar;
    }

    public static f<Context> a(Context context) {
        return new f<>(context, new a());
    }

    private static List<h> a(List<String> list) {
        String str;
        String str2;
        Object[] objArr;
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            try {
                Class<?> cls = Class.forName(str3);
                if (!h.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str3, "com.google.firebase.components.ComponentRegistrar"));
                } else {
                    arrayList.add((h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e) {
                e = e;
                str = "ComponentDiscovery";
                str2 = "Class %s is not an found.";
                objArr = new Object[]{str3};
                Log.w(str, String.format(str2, objArr), e);
            } catch (IllegalAccessException e2) {
                e = e2;
                str = "ComponentDiscovery";
                str2 = "Could not instantiate %s.";
                objArr = new Object[]{str3};
                Log.w(str, String.format(str2, objArr), e);
            } catch (InstantiationException e3) {
                e = e3;
                str = "ComponentDiscovery";
                str2 = "Could not instantiate %s.";
                objArr = new Object[]{str3};
                Log.w(str, String.format(str2, objArr), e);
            } catch (NoSuchMethodException e4) {
                e = e4;
                str = "ComponentDiscovery";
                str2 = "Could not instantiate %s";
                objArr = new Object[]{str3};
                Log.w(str, String.format(str2, objArr), e);
            } catch (InvocationTargetException e5) {
                e = e5;
                str = "ComponentDiscovery";
                str2 = "Could not instantiate %s";
                objArr = new Object[]{str3};
                Log.w(str, String.format(str2, objArr), e);
            }
        }
        return arrayList;
    }

    public List<h> a() {
        return a(this.b.a(this.a));
    }
}
