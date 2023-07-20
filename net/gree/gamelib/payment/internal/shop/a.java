package net.gree.gamelib.payment.internal.shop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Vector;
import net.gree.gamelib.payment.internal.a.g;
import net.gree.gamelib.payment.shop.Product;

/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    private static final String a = "a";
    private static final String b = "payment_log";
    private static final int c = 1;
    private static final String[] d = {"create table if not exists payment_log (uuid text,purchase_id text,product_id  text,issue_date  text default(strftime('%Y-%m-%dT%H:%M:%S', 'now')),transaction_id  text,receipt text,request_id text default(''),error   int default 0,status  int default 0);", "create unique index idx_purchase_id on payment_log(purchase_id);", "create unique index idx_uuid_purchase_id on payment_log(uuid, purchase_id);", "create unique index idx_transaction_id on payment_log(transaction_id);", "create index idx_request_id on payment_log(request_id);", "create index idx_issue_date on payment_log(issue_date);"};

    public a(Context context) {
        super(context, a(context), (SQLiteDatabase.CursorFactory) null, 1);
        if (getWritableDatabase() == null) {
            Log.w(a, "To open database is faled");
        }
    }

    static String a(Context context) {
        return b;
    }

    public Vector<b> a(String str) {
        Vector<b> vector = new Vector<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where purchase_id=? order by issue_date desc;", new String[]{str});
        while (rawQuery.moveToNext()) {
            vector.add(new b(rawQuery));
        }
        rawQuery.close();
        return vector;
    }

    public b a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where request_id=? and uuid=?;", new String[]{str, str2});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public b a(String str, String str2, int i) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where product_id=? and uuid=? and status=? limit 1;", new String[]{str, str2, Integer.toString(i)});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public b a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("purchase_id", str);
        contentValues.put(Product.KEY_ID, str2);
        contentValues.put(net.gree.gamelib.core.a.b.a.s, str3);
        if (getWritableDatabase().insert(b, null, contentValues) > -1) {
            return new b(str, str2, str3);
        }
        return null;
    }

    public void a() {
        close();
    }

    public boolean a(String str, int i) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        contentValues.put("status", (Integer) 10);
        contentValues.put("error", Integer.valueOf(i));
        return getWritableDatabase().update(b, contentValues, "request_id=?", strArr) > 0;
    }

    public boolean a(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str4, str, str3};
        contentValues.put("status", (Integer) 2);
        contentValues.put("transaction_id", str2);
        return getWritableDatabase().update(b, contentValues, "uuid=? and product_id=? and purchase_id=?", strArr) > 0;
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str, str2, str5};
        contentValues.put("status", (Integer) 2);
        contentValues.put("transaction_id", str3);
        contentValues.put(g.e, str4);
        return getWritableDatabase().update(b, contentValues, "product_id=? and request_id=? and uuid=?", strArr) > 0;
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        String[] strArr = {bVar.c(), bVar.b()};
        contentValues.put(g.e, bVar.e());
        contentValues.put(net.gree.gamelib.core.a.b.a.s, bVar.f());
        return getWritableDatabase().update(b, contentValues, "transaction_id=? and product_id=?", strArr) > 0;
    }

    public b b(String str) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where uuid=? and status > 0 and status < 3 order by issue_date desc limit 1;", new String[]{str});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public b b(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where purchase_id=? and uuid=?;", new String[]{str, str2});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public b b(String str, String str2, String str3) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where purchase_id=? and product_id=? and uuid=?;", new String[]{str, str2, str3});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public boolean b(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str2, str};
        contentValues.put("status", (Integer) 10);
        contentValues.put("error", Integer.valueOf(i));
        return getWritableDatabase().update(b, contentValues, "uuid=? and product_id=? and status=1", strArr) > 0;
    }

    public boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        String[] strArr = {bVar.a(), bVar.b()};
        contentValues.put("status", Integer.valueOf(bVar.h()));
        contentValues.put("error", Integer.valueOf(bVar.g()));
        return getWritableDatabase().update(b, contentValues, "purchase_id=? and product_id=?", strArr) > 0;
    }

    public b c(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where uuid=? and product_id=? and status=10 order by issue_date desc limit 1;", new String[]{str2, str});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public b c(String str, String str2, String str3) {
        Cursor rawQuery = getReadableDatabase().rawQuery("select * from payment_log where transaction_id=? and product_id=? and uuid=? limit 1;", new String[]{str, str2, str3});
        b bVar = rawQuery.moveToNext() ? new b(rawQuery) : null;
        rawQuery.close();
        return bVar;
    }

    public boolean c(b bVar) {
        if (bVar != null) {
            bVar.b(1);
        }
        return b(bVar);
    }

    public boolean d(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str3, str};
        contentValues.put("status", (Integer) 2);
        contentValues.put("transaction_id", str2);
        return getWritableDatabase().update(b, contentValues, "uuid=? and product_id=? and status=1", strArr) > 0;
    }

    public boolean e(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str, str2};
        contentValues.put("request_id", str3);
        contentValues.put("status", (Integer) 1);
        return getWritableDatabase().update(b, contentValues, "product_id=? and purchase_id=?", strArr) > 0;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (String str : d) {
            sQLiteDatabase.execSQL(str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w(a, "To upgrade LocalIAPDataSource is not available");
    }
}
