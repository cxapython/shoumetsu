package net.gree.gamelib.core.a.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class a {
    private static final String a = "_gamelib";
    private static final String b = "_pub_key";
    private static final String c = "_prv_key";
    private static final String d = "_u_uid";
    private static final String e = "_x_uid";
    private static final String f = "_x_appid";
    private static final String g = "_devid";
    private SharedPreferences h;
    private boolean i;

    public a(Context context, String str) {
        this.h = null;
        this.i = false;
        this.h = context.getSharedPreferences(str + a, 0);
        try {
            SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            this.i = true;
        } catch (NoSuchMethodException unused) {
            this.i = false;
        }
    }

    private void a(SharedPreferences.Editor editor) {
        if (i()) {
            b(editor);
        } else {
            editor.commit();
        }
    }

    @TargetApi(9)
    private static void b(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public String a() {
        return a(b, null);
    }

    String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, str2);
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(g, str);
            a(edit);
        }
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(b, str);
            edit.putString(c, str2);
            edit.putString(d, str3);
            a(edit);
        }
    }

    public String b() {
        return a(c, null);
    }

    public void b(String str, String str2) {
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(e, str);
            edit.putString(f, str2);
            a(edit);
        }
    }

    public String c() {
        return a(d, null);
    }

    public String d() {
        return a(e, null);
    }

    public String e() {
        return a(f, null);
    }

    public String f() {
        return a(g, null);
    }

    public boolean g() {
        return c() == null && a() == null && b() == null;
    }

    public void h() {
        SharedPreferences sharedPreferences = this.h;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(b);
            edit.remove(c);
            edit.remove(d);
            edit.remove(e);
            edit.remove(f);
            a(edit);
        }
    }

    boolean i() {
        return this.i;
    }
}
