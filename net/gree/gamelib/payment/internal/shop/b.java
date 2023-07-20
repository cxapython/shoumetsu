package net.gree.gamelib.payment.internal.shop;

import android.database.Cursor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    public static String a = "uuid";
    public static String b = "purchase_id";
    public static String c = "product_id";
    public static String d = "transaction_id";
    public static String e = "error";
    public static String f = "status";
    public static String g = "issue_date";
    public static String h = "receipt";
    public static String i = "request_id";
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p;
    private int q;
    private String r;

    /* loaded from: classes.dex */
    public class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 10;

        public a() {
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Cursor cursor) {
        if (cursor != null) {
            this.j = cursor.getString(a(cursor, a));
            this.l = cursor.getString(a(cursor, c));
            this.k = cursor.getString(a(cursor, b));
            this.m = cursor.getString(a(cursor, d));
            this.o = cursor.getString(a(cursor, h));
            this.n = cursor.getString(a(cursor, g));
            this.p = cursor.getInt(a(cursor, e));
            this.q = cursor.getInt(a(cursor, f));
            this.r = cursor.getString(a(cursor, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, String str3) {
        this.k = str;
        this.l = str2;
        this.j = str3;
    }

    private static int a(Cursor cursor, String str) {
        return cursor.getColumnIndex(str);
    }

    public String a() {
        return this.k;
    }

    public void a(int i2) {
        this.p = i2;
    }

    public void a(String str) {
        this.k = str;
    }

    public String b() {
        return this.l;
    }

    public void b(int i2) {
        this.q = i2;
    }

    public void b(String str) {
        this.l = str;
    }

    public String c() {
        return this.m;
    }

    public void c(String str) {
        this.m = str;
    }

    public String d() {
        return this.n;
    }

    public void d(String str) {
        this.o = str;
    }

    public String e() {
        return this.o;
    }

    public String f() {
        return this.j;
    }

    public int g() {
        return this.p;
    }

    public int h() {
        return this.q;
    }

    public String i() {
        return this.r;
    }

    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.j);
            jSONObject.put(b, this.k);
            jSONObject.put(c, this.l);
            jSONObject.put(d, this.m);
            jSONObject.put(f, this.q);
            jSONObject.put(e, this.p);
            jSONObject.put(g, this.n);
            jSONObject.put(h, this.o);
            jSONObject.put(i, this.r);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
