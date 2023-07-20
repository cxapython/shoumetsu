package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class bv implements ar {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final bx b;
    private volatile aa c;
    private final as d;
    private final Context e;
    private final String f;
    private long g;
    private Clock h;
    private final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(as asVar, Context context) {
        this(asVar, context, "gtm_urls.db", 2000);
    }

    @VisibleForTesting
    private bv(as asVar, Context context, String str, int i) {
        this.e = context.getApplicationContext();
        this.f = str;
        this.d = asVar;
        this.h = DefaultClock.getInstance();
        this.b = new bx(this, this.e, this.f);
        this.c = new dm(this.e, new bw(this));
        this.g = 0L;
        this.i = 2000;
    }

    private final SQLiteDatabase a(String str) {
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0073, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> a(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzdi.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase a2 = a("Error opening database for peekHitIds.");
        if (a2 == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(cursor.getLong(0)));
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzdi.zzac(valueOf.length() != 0 ? "Error in peekHits fetching hitIds: ".concat(valueOf) : new String("Error in peekHits fetching hitIds: "));
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j) {
        a(new String[]{String.valueOf(j)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j, long j2) {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        if (a2 == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            a2.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException unused) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
            sb.append(j);
            zzdi.zzac(sb.toString());
            a(j);
        }
    }

    private final void a(String[] strArr) {
        SQLiteDatabase a2;
        if (strArr == null || strArr.length == 0 || (a2 = a("Error opening database for deleteHits.")) == null) {
            return;
        }
        boolean z = true;
        try {
            a2.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            as asVar = this.d;
            if (c() != 0) {
                z = false;
            }
            asVar.a(z);
        } catch (SQLiteException unused) {
            zzdi.zzac("Error deleting hits");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<am> b(int i) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase a2 = a("Error opening database for peekHits");
        if (a2 == null) {
            return arrayList2;
        }
        Cursor cursor = null;
        try {
            try {
                int i2 = 0;
                cursor = a2.query("gtm_hits", new String[]{"hit_id", "hit_time", "hit_first_send_time"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(40));
                ArrayList arrayList3 = new ArrayList();
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            try {
                                arrayList3.add(new am(cursor.getLong(0), cursor.getLong(1), cursor.getLong(2)));
                            } catch (SQLiteException e) {
                                e = e;
                                arrayList2 = arrayList3;
                                String valueOf = String.valueOf(e.getMessage());
                                zzdi.zzac(valueOf.length() != 0 ? "Error in peekHits fetching hitIds: ".concat(valueOf) : new String("Error in peekHits fetching hitIds: "));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return arrayList2;
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                            cursor.close();
                        }
                        try {
                            try {
                                arrayList = arrayList3;
                                try {
                                    cursor = a2.query("gtm_hits", new String[]{"hit_id", "hit_url"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(40));
                                    if (cursor.moveToFirst()) {
                                        return arrayList;
                                    }
                                    int i3 = 0;
                                    do {
                                        if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
                                            ((am) arrayList.get(i3)).a(cursor.getString(1));
                                        } else {
                                            zzdi.zzac(String.format("HitString for hitId %d too large.  Hit will be deleted.", Long.valueOf(((am) arrayList.get(i3)).a())));
                                        }
                                        i3++;
                                    } while (cursor.moveToNext());
                                    return arrayList;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    String valueOf2 = String.valueOf(e.getMessage());
                                    zzdi.zzac(valueOf2.length() != 0 ? "Error in peekHits fetching hit url: ".concat(valueOf2) : new String("Error in peekHits fetching hit url: "));
                                    ArrayList arrayList4 = new ArrayList();
                                    ArrayList arrayList5 = arrayList;
                                    int size = arrayList5.size();
                                    boolean z = false;
                                    while (i2 < size) {
                                        Object obj = arrayList5.get(i2);
                                        i2++;
                                        am amVar = (am) obj;
                                        if (TextUtils.isEmpty(amVar.c())) {
                                            if (z) {
                                                break;
                                            }
                                            z = true;
                                        }
                                        arrayList4.add(amVar);
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList4;
                                }
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            arrayList = arrayList3;
                        }
                    } else {
                        if (cursor != null) {
                        }
                        arrayList = arrayList3;
                        cursor = a2.query("gtm_hits", new String[]{"hit_id", "hit_url"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(40));
                        if (cursor.moveToFirst()) {
                        }
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    arrayList2 = arrayList3;
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        } catch (SQLiteException e5) {
            e = e5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        if (r2 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int c() {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        int i = 0;
        if (a2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting numStoredHits");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r9 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int d() {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        int i = 0;
        if (a2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
                i = cursor.getCount();
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting num untried hits");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.ar
    public final void a() {
        zzdi.zzab("GTM Dispatch running...");
        if (!this.c.a()) {
            return;
        }
        List<am> b = b(40);
        if (b.isEmpty()) {
            zzdi.zzab("...nothing to dispatch");
            this.d.a(true);
            return;
        }
        this.c.a(b);
        if (d() <= 0) {
            return;
        }
        dg.a().dispatch();
    }

    @Override // com.google.android.gms.tagmanager.ar
    public final void a(long j, String str) {
        long currentTimeMillis = this.h.currentTimeMillis();
        if (currentTimeMillis > this.g + 86400000) {
            this.g = currentTimeMillis;
            SQLiteDatabase a2 = a("Error opening database for deleteStaleHits.");
            if (a2 != null) {
                a2.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.h.currentTimeMillis() - 2592000000L)});
                this.d.a(c() == 0);
            }
        }
        int c = (c() - this.i) + 1;
        if (c > 0) {
            List<String> a3 = a(c);
            int size = a3.size();
            StringBuilder sb = new StringBuilder(51);
            sb.append("Store full, deleting ");
            sb.append(size);
            sb.append(" hits to make room.");
            zzdi.zzab(sb.toString());
            a((String[]) a3.toArray(new String[0]));
        }
        SQLiteDatabase a4 = a("Error opening database for putHit");
        if (a4 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", (Integer) 0);
            try {
                a4.insert("gtm_hits", null, contentValues);
                this.d.a(false);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error storing hit");
            }
        }
    }
}
