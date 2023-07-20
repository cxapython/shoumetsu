package com.microsoft.appcenter.e.d;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/* loaded from: classes.dex */
public class c {
    public static SQLiteQueryBuilder a() {
        return new SQLiteQueryBuilder();
    }

    public static String a(String str) {
        return String.format("DROP TABLE `%s`", str);
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(a(str));
    }
}
