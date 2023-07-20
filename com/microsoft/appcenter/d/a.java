package com.microsoft.appcenter.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.microsoft.appcenter.c.a.b.k;
import com.microsoft.appcenter.c.a.d;
import com.microsoft.appcenter.d.b;
import com.microsoft.appcenter.e.d.a;
import com.microsoft.appcenter.e.d.c;
import com.microsoft.appcenter.f;
import com.microsoft.appcenter.g;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.gree.gamelib.payment.internal.a.e;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONException;

/* loaded from: classes.dex */
public class a extends b {
    static final ContentValues a = a("", "", "", "", "", 0, 0L);
    final com.microsoft.appcenter.e.d.a b;
    final Map<String, List<Long>> c;
    final Set<Long> d;
    private final Context e;
    private final File f;

    public a(Context context) {
        this(context, 5, a);
    }

    a(Context context, int i, ContentValues contentValues) {
        this.e = context;
        this.c = new HashMap();
        this.d = new HashSet();
        this.b = new com.microsoft.appcenter.e.d.a(context, "com.microsoft.appcenter.persistence", "logs", i, contentValues, new a.InterfaceC0065a() { // from class: com.microsoft.appcenter.d.a.1
            private void b(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
            }

            @Override // com.microsoft.appcenter.e.d.a.InterfaceC0065a
            public void a(SQLiteDatabase sQLiteDatabase) {
                b(sQLiteDatabase);
            }

            @Override // com.microsoft.appcenter.e.d.a.InterfaceC0065a
            public boolean a(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
                if (i2 < 2) {
                    sQLiteDatabase.execSQL("ALTER TABLE logs ADD COLUMN `target_token` TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE logs ADD COLUMN `type` TEXT");
                }
                if (i2 < 3) {
                    sQLiteDatabase.execSQL("ALTER TABLE logs ADD COLUMN `target_key` TEXT");
                }
                if (i2 < 4) {
                    sQLiteDatabase.execSQL("ALTER TABLE logs ADD COLUMN `priority` INTEGER DEFAULT 1");
                }
                sQLiteDatabase.execSQL("ALTER TABLE logs ADD COLUMN `timestamp` INTEGER DEFAULT 0");
                b(sQLiteDatabase);
                return true;
            }
        });
        this.f = new File(f.a + "/appcenter/database_large_payloads");
        this.f.mkdirs();
    }

    private int a(String str, String... strArr) {
        SQLiteQueryBuilder a2 = c.a();
        a2.appendWhere(str);
        int i = 0;
        try {
            Cursor a3 = this.b.a(a2, new String[]{"COUNT(*)"}, strArr, (String) null);
            a3.moveToNext();
            i = a3.getInt(0);
            a3.close();
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Failed to get logs count: ", e);
        }
        return i;
    }

    private static ContentValues a(String str, String str2, String str3, String str4, String str5, int i, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("persistence_group", str);
        contentValues.put("log", str2);
        contentValues.put("target_token", str3);
        contentValues.put(e.J, str4);
        contentValues.put("target_key", str5);
        contentValues.put(Product.KEY_PRIORITY, Integer.valueOf(i));
        contentValues.put("timestamp", l);
        return contentValues;
    }

    private List<Long> a(SQLiteQueryBuilder sQLiteQueryBuilder, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor a2 = this.b.a(sQLiteQueryBuilder, com.microsoft.appcenter.e.d.a.a, strArr, (String) null);
            while (a2.moveToNext()) {
                arrayList.add(this.b.a(a2).getAsLong("oid"));
            }
            a2.close();
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Failed to get corrupted ids: ", e);
        }
        return arrayList;
    }

    private void b(File file, long j) {
        a(file, j).delete();
        this.b.a(j);
    }

    @Override // com.microsoft.appcenter.d.b
    public int a(Date date) {
        return a("timestamp < ?", String.valueOf(date.getTime()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
        r7 = null;
     */
    @Override // com.microsoft.appcenter.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(d dVar, String str, int i) {
        String str2;
        String str3;
        try {
            try {
                com.microsoft.appcenter.e.a.b("AppCenter", "Storing a log to the Persistence database for log type " + dVar.a() + " with flags=" + i);
                String a2 = b().a(dVar);
                int length = a2.getBytes("UTF-8").length;
                boolean z = length >= 1992294;
                if (!(dVar instanceof com.microsoft.appcenter.c.a.b.c)) {
                    str2 = null;
                    str3 = null;
                } else if (z) {
                    throw new b.a("Log is larger than 1992294 bytes, cannot send to OneCollector.");
                } else {
                    String next = dVar.t().iterator().next();
                    str3 = k.a(next);
                    str2 = com.microsoft.appcenter.e.c.e.a(this.e).a(next);
                }
                long b = this.b.b();
                if (b == -1) {
                    throw new b.a("Failed to store a log to the Persistence database.");
                }
                if (!z && b <= length) {
                    throw new b.a("Log is too large (" + length + " bytes) to store in database. Current maximum database size is " + b + " bytes.");
                }
                String str4 = a2;
                long a3 = this.b.a(a(str, str4, str2, dVar.a(), str3, g.a(i, false), Long.valueOf(dVar.n().getTime())), Product.KEY_PRIORITY);
                if (a3 == -1) {
                    throw new b.a("Failed to store a log to the Persistence database for log type " + dVar.a() + ".");
                }
                com.microsoft.appcenter.e.a.b("AppCenter", "Stored a log to the Persistence database for log type " + dVar.a() + " with databaseId=" + a3);
                if (z) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Payload is larger than what SQLite supports, storing payload in a separate file.");
                    File a4 = a(str);
                    a4.mkdir();
                    File a5 = a(a4, a3);
                    try {
                        com.microsoft.appcenter.e.d.b.a(a5, a2);
                        com.microsoft.appcenter.e.a.b("AppCenter", "Payload written to " + a5);
                    } catch (IOException e) {
                        this.b.a(a3);
                        throw e;
                    }
                }
                return a3;
            } catch (JSONException e2) {
                throw new b.a("Cannot convert to JSON string.", e2);
            }
        } catch (IOException e3) {
            throw new b.a("Cannot save large payload in a file.", e3);
        }
    }

    File a(File file, long j) {
        return new File(file, j + ".json");
    }

    File a(String str) {
        return new File(this.f, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microsoft.appcenter.d.b
    public String a(String str, Collection<String> collection, int i, List<d> list, Date date, Date date2) {
        Cursor cursor;
        com.microsoft.appcenter.e.a.b("AppCenter", "Trying to get " + i + " logs from the Persistence database for " + str);
        SQLiteQueryBuilder a2 = c.a();
        a2.appendWhere("persistence_group = ?");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!collection.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < collection.size(); i2++) {
                sb.append("?,");
            }
            sb.deleteCharAt(sb.length() - 1);
            a2.appendWhere(" AND ");
            a2.appendWhere("target_key NOT IN (" + sb.toString() + ")");
            arrayList.addAll(collection);
        }
        if (date != null) {
            a2.appendWhere(" AND ");
            a2.appendWhere("timestamp >= ?");
            arrayList.add(String.valueOf(date.getTime()));
        }
        if (date2 != null) {
            a2.appendWhere(" AND ");
            a2.appendWhere("timestamp < ?");
            arrayList.add(String.valueOf(date2.getTime()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<Long> arrayList2 = new ArrayList();
        File a3 = a(str);
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        try {
            cursor = this.b.a(a2, (String[]) null, strArr, "priority DESC, oid");
        } catch (RuntimeException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Failed to get logs: ", e);
            cursor = null;
        }
        int i3 = 0;
        while (cursor != null) {
            ContentValues b = this.b.b(cursor);
            if (b == null || i3 >= i) {
                break;
            }
            Long asLong = b.getAsLong("oid");
            if (asLong == null) {
                com.microsoft.appcenter.e.a.e("AppCenter", "Empty database record, probably content was larger than 2MB, need to delete as it's now corrupted.");
                Iterator<Long> it = a(a2, strArr).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Long next = it.next();
                        if (!this.d.contains(next) && !linkedHashMap.containsKey(next)) {
                            b(a3, next.longValue());
                            com.microsoft.appcenter.e.a.e("AppCenter", "Empty database corrupted empty record deleted, id=" + next);
                            break;
                        }
                    }
                }
            } else if (!this.d.contains(asLong)) {
                try {
                    String asString = b.getAsString("log");
                    if (asString == null) {
                        File a4 = a(a3, asLong.longValue());
                        com.microsoft.appcenter.e.a.b("AppCenter", "Read payload file " + a4);
                        asString = com.microsoft.appcenter.e.d.b.a(a4);
                        if (asString == null) {
                            throw new JSONException("Log payload is null and not stored as a file.");
                            break;
                        }
                    }
                    d a5 = b().a(asString, b.getAsString(e.J));
                    String asString2 = b.getAsString("target_token");
                    if (asString2 != null) {
                        try {
                            a5.g(com.microsoft.appcenter.e.c.e.a(this.e).a(asString2, false).a());
                        } catch (JSONException e2) {
                            e = e2;
                            com.microsoft.appcenter.e.a.b("AppCenter", "Cannot deserialize a log in the database", e);
                            arrayList2.add(asLong);
                        }
                    }
                    linkedHashMap.put(asLong, a5);
                    i3++;
                } catch (JSONException e3) {
                    e = e3;
                }
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (RuntimeException unused) {
            }
        }
        if (arrayList2.size() > 0) {
            for (Long l : arrayList2) {
                b(a3, l.longValue());
            }
            com.microsoft.appcenter.e.a.d("AppCenter", "Deleted logs that cannot be deserialized");
        }
        if (linkedHashMap.size() <= 0) {
            com.microsoft.appcenter.e.a.b("AppCenter", "No logs found in the Persistence database at the moment");
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        com.microsoft.appcenter.e.a.b("AppCenter", "Returning " + linkedHashMap.size() + " log(s) with an ID, " + uuid);
        com.microsoft.appcenter.e.a.b("AppCenter", "The SID/ID pairs for returning log(s) is/are:");
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Long l2 = (Long) entry.getKey();
            this.d.add(l2);
            arrayList3.add(l2);
            list.add(entry.getValue());
            com.microsoft.appcenter.e.a.b("AppCenter", "\t" + ((d) entry.getValue()).o() + " / " + l2);
        }
        this.c.put(str + uuid, arrayList3);
        return uuid;
    }

    @Override // com.microsoft.appcenter.d.b
    public void a() {
        this.d.clear();
        this.c.clear();
        com.microsoft.appcenter.e.a.b("AppCenter", "Cleared pending log states");
    }

    @Override // com.microsoft.appcenter.d.b
    public void a(String str, String str2) {
        com.microsoft.appcenter.e.a.b("AppCenter", "Deleting logs from the Persistence database for " + str + " with " + str2);
        com.microsoft.appcenter.e.a.b("AppCenter", "The IDs for deleting log(s) is/are:");
        Map<String, List<Long>> map = this.c;
        List<Long> remove = map.remove(str + str2);
        File a2 = a(str);
        if (remove != null) {
            for (Long l : remove) {
                com.microsoft.appcenter.e.a.b("AppCenter", "\t" + l);
                b(a2, l.longValue());
                this.d.remove(l);
            }
        }
    }

    @Override // com.microsoft.appcenter.d.b
    public boolean a(long j) {
        return this.b.b(j);
    }

    @Override // com.microsoft.appcenter.d.b
    public void b(String str) {
        com.microsoft.appcenter.e.a.b("AppCenter", "Deleting all logs from the Persistence database for " + str);
        File a2 = a(str);
        File[] listFiles = a2.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        a2.delete();
        com.microsoft.appcenter.e.a.b("AppCenter", "Deleted " + this.b.a("persistence_group", str) + " logs.");
        Iterator<String> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().startsWith(str)) {
                it.remove();
            }
        }
    }

    @Override // com.microsoft.appcenter.d.b
    public int c(String str) {
        return a("persistence_group = ?", str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }
}
