package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends zzan implements Closeable {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final m c;
    private final ai d;
    private final ai e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(zzap zzapVar) {
        super(zzapVar);
        this.d = new ai(d());
        this.e = new ai(d());
        this.c = new m(this, zzapVar.getContext(), "google_analytics_v4.db");
    }

    private final long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = v().rawQuery(str, null);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = v().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor == null) {
                    return 0L;
                }
                cursor.close();
                return 0L;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @VisibleForTesting
    private final Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return HttpUtils.parse(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @VisibleForTesting
    private final Map<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            return HttpUtils.parse(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Long> d(long j) {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (j <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase v = v();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = v.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(Long.valueOf(cursor.getLong(0)));
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                zzd("Error selecting hit ids", e);
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long x() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        return a("SELECT COUNT(*) FROM hits2", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String y() {
        return "google_analytics_v4.db";
    }

    public final long a(long j, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        q();
        com.google.android.gms.analytics.zzk.zzav();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzcd> a(long j) {
        Preconditions.checkArgument(j >= 0);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        Cursor cursor = null;
        try {
            try {
                cursor = v().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
                ArrayList arrayList = new ArrayList();
                if (!cursor.moveToFirst()) {
                    return arrayList;
                }
                do {
                    arrayList.add(new zzcd(this, a(cursor.getString(2)), cursor.getLong(1), zzcz.zzaj(cursor.getString(3)), cursor.getLong(0), cursor.getInt(4)));
                } while (cursor.moveToNext());
                return arrayList;
            } catch (SQLiteException e) {
                zze("Error loading hits from the database", e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final void a(zzcd zzcdVar) {
        Preconditions.checkNotNull(zzcdVar);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        Preconditions.checkNotNull(zzcdVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzcdVar.zzdm().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            f().zza(zzcdVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = zzby.zzze.get().intValue();
        long x = x();
        if (x > intValue - 1) {
            List<Long> d = d((x - intValue) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(d.size()));
            a(d);
        }
        SQLiteDatabase v = v();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzcdVar.zzfh()));
        contentValues.put("hit_app_id", Integer.valueOf(zzcdVar.zzff()));
        contentValues.put("hit_url", zzcdVar.zzfj() ? zzbq.zzet() : zzbq.zzeu());
        try {
            long insert = v.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzu("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzcdVar);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    public final void a(List<Long> list) {
        Preconditions.checkNotNull(list);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String sb2 = sb.toString();
        try {
            SQLiteDatabase v = v();
            zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int delete = v.delete("hits2", sb2, null);
            if (delete == list.size()) {
                return;
            }
            zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
        } catch (SQLiteException e) {
            zze("Error deleting hits", e);
            throw e;
        }
    }

    public final void b() {
        q();
        v().beginTransaction();
    }

    public final void b(long j) {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        a((List<Long>) arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0092 A[Catch: all -> 0x009d, SQLiteException -> 0x009f, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x009f, blocks: (B:3:0x000b, B:5:0x0045, B:9:0x0059, B:11:0x006e, B:14:0x0075, B:16:0x0086, B:15:0x0081, B:18:0x008c, B:20:0x0092), top: B:32:0x000b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzas> c(long j) {
        q();
        com.google.android.gms.analytics.zzk.zzav();
        SQLiteDatabase v = v();
        Cursor cursor = null;
        try {
            try {
                int intValue = zzby.zzzg.get().intValue();
                cursor = v.query("properties", new String[]{"cid", "tid", "adid", "hits_count", "params"}, "app_uid=?", new String[]{"0"}, null, null, null, String.valueOf(intValue));
                ArrayList arrayList = new ArrayList();
                if (!cursor.moveToFirst()) {
                    if (arrayList.size() >= intValue) {
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    boolean z = cursor.getInt(2) != 0;
                    long j2 = cursor.getInt(3);
                    Map<String, String> b2 = b(cursor.getString(4));
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        arrayList.add(new zzas(0L, string, string2, z, j2, b2));
                    }
                    zzc("Read property with empty client id or tracker id", string, string2);
                } while (cursor.moveToNext());
                if (arrayList.size() >= intValue) {
                    zzt("Sending hits to too many properties. Campaign report might be incorrect");
                }
                return arrayList;
            } catch (SQLiteException e) {
                zze("Error loading hits from the database", e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void c() {
        q();
        v().setTransactionSuccessful();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        String str;
        try {
            this.c.close();
        } catch (SQLiteException e) {
            e = e;
            str = "Sql error closing database";
            zze(str, e);
        } catch (IllegalStateException e2) {
            e = e2;
            str = "Error closing database";
            zze(str, e);
        }
    }

    public final void r() {
        q();
        v().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        return x() == 0;
    }

    public final int t() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (!this.d.a(86400000L)) {
            return 0;
        }
        this.d.a();
        zzq("Deleting stale hits (if any)");
        int delete = v().delete("hits2", "hit_time < ?", new String[]{Long.toString(d().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long u() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        return a(b, (String[]) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase v() {
        try {
            return this.c.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }
}
