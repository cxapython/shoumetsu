package com.microsoft.appcenter.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements Closeable {
    public static final String[] a = {"oid"};
    private final Context b;
    private final String c;
    private final String d;
    private final ContentValues e;
    private final InterfaceC0065a f;
    private SQLiteOpenHelper g;

    /* renamed from: com.microsoft.appcenter.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void a(SQLiteDatabase sQLiteDatabase);

        boolean a(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    public a(Context context, String str, String str2, int i, ContentValues contentValues, InterfaceC0065a interfaceC0065a) {
        this(context, str, str2, i, contentValues, interfaceC0065a, null);
    }

    a(Context context, String str, String str2, int i, ContentValues contentValues, InterfaceC0065a interfaceC0065a, final String[] strArr) {
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = contentValues;
        this.f = interfaceC0065a;
        this.g = new SQLiteOpenHelper(context, str, null, i) { // from class: com.microsoft.appcenter.e.d.a.1
            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                a aVar = a.this;
                aVar.a(sQLiteDatabase, aVar.d, a.this.e, strArr);
                a.this.f.a(sQLiteDatabase);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                if (!a.this.f.a(sQLiteDatabase, i2, i3)) {
                    c.a(sQLiteDatabase, a.this.d);
                    onCreate(sQLiteDatabase);
                }
            }
        };
    }

    private static ContentValues a(Cursor cursor, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (!cursor.isNull(i)) {
                String columnName = cursor.getColumnName(i);
                if (!columnName.equals("oid")) {
                    Object obj = contentValues.get(columnName);
                    if (obj instanceof byte[]) {
                        contentValues2.put(columnName, cursor.getBlob(i));
                    } else if (obj instanceof Double) {
                        contentValues2.put(columnName, Double.valueOf(cursor.getDouble(i)));
                    } else if (obj instanceof Float) {
                        contentValues2.put(columnName, Float.valueOf(cursor.getFloat(i)));
                    } else if (obj instanceof Integer) {
                        contentValues2.put(columnName, Integer.valueOf(cursor.getInt(i)));
                    } else if (!(obj instanceof Long)) {
                        if (obj instanceof Short) {
                            contentValues2.put(columnName, Short.valueOf(cursor.getShort(i)));
                        } else if (obj instanceof Boolean) {
                            boolean z = true;
                            if (cursor.getInt(i) != 1) {
                                z = false;
                            }
                            contentValues2.put(columnName, Boolean.valueOf(z));
                        } else {
                            contentValues2.put(columnName, cursor.getString(i));
                        }
                    }
                }
                contentValues2.put(columnName, Long.valueOf(cursor.getLong(i)));
            }
        }
        return contentValues2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String[] strArr) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS `");
        sb.append(str);
        sb.append("` (oid INTEGER PRIMARY KEY AUTOINCREMENT");
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            sb.append(", `");
            sb.append(entry.getKey());
            sb.append("` ");
            Object value = entry.getValue();
            sb.append(((value instanceof Double) || (value instanceof Float)) ? "REAL" : ((value instanceof Number) || (value instanceof Boolean)) ? "INTEGER" : value instanceof byte[] ? "BLOB" : "TEXT");
        }
        if (strArr != null && strArr.length > 0) {
            sb.append(", UNIQUE(`");
            sb.append(TextUtils.join("`, `", strArr));
            sb.append("`)");
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    private void a(String str, long j) {
        a(str, "oid", Long.valueOf(j));
    }

    public int a(String str, Object obj) {
        return a(this.d, str, obj);
    }

    public int a(String str, String str2, Object obj) {
        return a(str, str2 + " = ?", new String[]{String.valueOf(obj)});
    }

    public int a(String str, String str2, String[] strArr) {
        try {
            return a().delete(str, str2, strArr);
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", String.format("Failed to delete values that match condition=\"%s\" and values=\"%s\" from database %s.", str2, Arrays.toString(strArr), this.c), e);
            return 0;
        }
    }

    public long a(ContentValues contentValues, String str) {
        Long l = null;
        Cursor cursor = null;
        while (l == null) {
            try {
                try {
                    l = Long.valueOf(a().insertOrThrow(this.d, null, contentValues));
                } catch (SQLiteFullException e) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Storage is full, trying to delete the oldest log that has the lowest priority which is lower or equal priority than the new log");
                    if (cursor == null) {
                        String asString = contentValues.getAsString(str);
                        SQLiteQueryBuilder a2 = c.a();
                        a2.appendWhere(str + " <= ?");
                        cursor = a(a2, a, new String[]{asString}, str + " , oid");
                    }
                    if (!cursor.moveToNext()) {
                        throw e;
                    }
                    long j = cursor.getLong(0);
                    a(j);
                    com.microsoft.appcenter.e.a.b("AppCenter", "Deleted log id=" + j);
                }
            } catch (RuntimeException e2) {
                l = -1L;
                com.microsoft.appcenter.e.a.b("AppCenter", String.format("Failed to insert values (%s) to database %s.", contentValues.toString(), this.c), e2);
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException unused) {
            }
        }
        return l.longValue();
    }

    public ContentValues a(Cursor cursor) {
        return a(cursor, this.e);
    }

    public Cursor a(SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr, String[] strArr2, String str) {
        return a(this.d, sQLiteQueryBuilder, strArr, strArr2, str);
    }

    public Cursor a(String str, SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr, String[] strArr2, String str2) {
        if (sQLiteQueryBuilder == null) {
            sQLiteQueryBuilder = c.a();
        }
        SQLiteQueryBuilder sQLiteQueryBuilder2 = sQLiteQueryBuilder;
        sQLiteQueryBuilder2.setTables(str);
        return sQLiteQueryBuilder2.query(a(), strArr, null, strArr2, null, null, str2);
    }

    SQLiteDatabase a() {
        try {
            return this.g.getWritableDatabase();
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.a("AppCenter", "Failed to open database. Trying to delete database (may be corrupted).", e);
            if (this.b.deleteDatabase(this.c)) {
                com.microsoft.appcenter.e.a.c("AppCenter", "The database was successfully deleted.");
            } else {
                com.microsoft.appcenter.e.a.d("AppCenter", "Failed to delete database.");
            }
            return this.g.getWritableDatabase();
        }
    }

    public void a(long j) {
        a(this.d, j);
    }

    public long b() {
        try {
            return a().getMaximumSize();
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Could not get maximum database size.", e);
            return -1L;
        }
    }

    public ContentValues b(Cursor cursor) {
        try {
            if (!cursor.moveToNext()) {
                return null;
            }
            return a(cursor);
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Failed to get next cursor value: ", e);
            return null;
        }
    }

    public boolean b(long j) {
        String str;
        String str2;
        try {
            SQLiteDatabase a2 = a();
            long maximumSize = a2.setMaximumSize(j);
            long pageSize = a2.getPageSize();
            long j2 = j / pageSize;
            if (j % pageSize != 0) {
                j2++;
            }
            if (maximumSize != j2 * pageSize) {
                com.microsoft.appcenter.e.a.e("AppCenter", "Could not change maximum database size to " + j + " bytes, current maximum size is " + maximumSize + " bytes.");
                return false;
            }
            if (j == maximumSize) {
                str = "AppCenter";
                str2 = "Changed maximum database size to " + maximumSize + " bytes.";
            } else {
                str = "AppCenter";
                str2 = "Changed maximum database size to " + maximumSize + " bytes (next multiple of page size).";
            }
            com.microsoft.appcenter.e.a.c(str, str2);
            return true;
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Could not change maximum database size.", e);
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.g.close();
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Failed to close the database.", e);
        }
    }
}
