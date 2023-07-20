package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.tagmanager.DataLayer;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements DataLayer.c {
    private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", ClientCookie.EXPIRES_ATTR);
    private final Executor b;
    private final Context c;
    private u d;
    private Clock e;
    private int f;

    public q(Context context) {
        this(context, DefaultClock.getInstance(), "google_tagmanager.db", 2000, zzdf.zzgp().zzr(com.google.android.gms.internal.gtm.zzdi.zzadg));
    }

    @VisibleForTesting
    private q(Context context, Clock clock, String str, int i, Executor executor) {
        this.c = context;
        this.e = clock;
        this.f = 2000;
        this.b = executor;
        this.d = new u(this, this.c, str);
    }

    private static Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException unused) {
            objectInputStream = null;
        } catch (ClassNotFoundException unused2) {
            objectInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
            } catch (IOException unused3) {
            }
            return readObject;
        } catch (IOException unused4) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused5) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (ClassNotFoundException unused6) {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException unused7) {
                    return null;
                }
            }
            byteArrayInputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException unused8) {
                    throw th;
                }
            }
            byteArrayInputStream.close();
            throw th;
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
            zzdi.zzac("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase c = c("Error opening database for peekEntryIds.");
        if (c == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = c.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", "ID"), Integer.toString(i));
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(cursor.getLong(0)));
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzdi.zzac(valueOf.length() != 0 ? "Error in peekEntries fetching entryIds: ".concat(valueOf) : new String("Error in peekEntries fetching entryIds: "));
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final void a(long j) {
        SQLiteDatabase c = c("Error opening database for deleteOlderThan.");
        if (c == null) {
            return;
        }
        try {
            int delete = c.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
            StringBuilder sb = new StringBuilder(33);
            sb.append("Deleted ");
            sb.append(delete);
            sb.append(" expired items");
            zzdi.zzab(sb.toString());
        } catch (SQLiteException unused) {
            zzdi.zzac("Error deleting old entries.");
        }
    }

    private static byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException unused) {
            objectOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            return byteArray;
        } catch (IOException unused3) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException unused4) {
                    return null;
                }
            }
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused5) {
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DataLayer.a> b() {
        try {
            a(this.e.currentTimeMillis());
            List<v> c = c();
            ArrayList arrayList = new ArrayList();
            for (v vVar : c) {
                arrayList.add(new DataLayer.a(vVar.a, a(vVar.b)));
            }
            return arrayList;
        } finally {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        SQLiteDatabase c = c("Error opening database for clearKeysWithPrefix.");
        try {
            if (c == null) {
                return;
            }
            int delete = c.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
            StringBuilder sb = new StringBuilder(25);
            sb.append("Cleared ");
            sb.append(delete);
            sb.append(" items");
            zzdi.zzab(sb.toString());
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 44 + String.valueOf(valueOf).length());
            sb2.append("Error deleting entries with key prefix: ");
            sb2.append(str);
            sb2.append(" (");
            sb2.append(valueOf);
            sb2.append(").");
            zzdi.zzac(sb2.toString());
        } finally {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b(List<v> list, long j) {
        SQLiteDatabase c;
        long currentTimeMillis = this.e.currentTimeMillis();
        a(currentTimeMillis);
        int d = (d() - this.f) + list.size();
        if (d > 0) {
            List<String> a2 = a(d);
            int size = a2.size();
            StringBuilder sb = new StringBuilder(64);
            sb.append("DataLayer store full, deleting ");
            sb.append(size);
            sb.append(" entries to make room.");
            zzdi.zzaw(sb.toString());
            String[] strArr = (String[]) a2.toArray(new String[0]);
            if (strArr != null && strArr.length != 0 && (c = c("Error opening database for deleteEntries.")) != null) {
                try {
                    c.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                } catch (SQLiteException unused) {
                    String valueOf = String.valueOf(Arrays.toString(strArr));
                    zzdi.zzac(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
                }
            }
        }
        long j2 = currentTimeMillis + j;
        SQLiteDatabase c2 = c("Error opening database for writeEntryToDatabase.");
        if (c2 != null) {
            for (v vVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(ClientCookie.EXPIRES_ATTR, Long.valueOf(j2));
                contentValues.put("key", vVar.a);
                contentValues.put("value", vVar.b);
                c2.insert("datalayer", null, contentValues);
            }
        }
        e();
    }

    private final SQLiteDatabase c(String str) {
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    private final List<v> c() {
        SQLiteDatabase c = c("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (c == null) {
            return arrayList;
        }
        Cursor query = c.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new v(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
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
    private final int d() {
        SQLiteDatabase c = c("Error opening database for getNumStoredEntries.");
        int i = 0;
        if (c == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = c.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting numStoredEntries");
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final void e() {
        try {
            this.d.close();
        } catch (SQLiteException unused) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(zzaq zzaqVar) {
        this.b.execute(new s(this, zzaqVar));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(String str) {
        this.b.execute(new t(this, str));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(List<DataLayer.a> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.a aVar : list) {
            arrayList.add(new v(aVar.a, a(aVar.b)));
        }
        this.b.execute(new r(this, arrayList, j));
    }
}
