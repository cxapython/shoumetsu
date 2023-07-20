package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzco {
    private final String a;
    private final long b;
    private final /* synthetic */ zzcm c;

    private zzco(zzcm zzcmVar, String str, long j) {
        this.c = zzcmVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.a = str;
        this.b = j;
    }

    private final void a() {
        SharedPreferences sharedPreferences;
        long currentTimeMillis = this.c.d().currentTimeMillis();
        sharedPreferences = this.c.a;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(d());
        edit.remove(e());
        edit.putLong(c(), currentTimeMillis);
        edit.commit();
    }

    private final long b() {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.c.a;
        return sharedPreferences.getLong(c(), 0L);
    }

    private final String c() {
        return String.valueOf(this.a).concat(":start");
    }

    private final String d() {
        return String.valueOf(this.a).concat(":count");
    }

    @VisibleForTesting
    private final String e() {
        return String.valueOf(this.a).concat(":value");
    }

    public final void zzae(String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences sharedPreferences3;
        if (b() == 0) {
            a();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            sharedPreferences = this.c.a;
            long j = sharedPreferences.getLong(d(), 0L);
            if (j <= 0) {
                sharedPreferences3 = this.c.a;
                SharedPreferences.Editor edit = sharedPreferences3.edit();
                edit.putString(e(), str);
                edit.putLong(d(), 1L);
                edit.apply();
                return;
            }
            long j2 = j + 1;
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / j2;
            sharedPreferences2 = this.c.a;
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            if (z) {
                edit2.putString(e(), str);
            }
            edit2.putLong(d(), j2);
            edit2.apply();
        }
    }

    public final Pair<String, Long> zzgc() {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        long b = b();
        long abs = b == 0 ? 0L : Math.abs(b - this.c.d().currentTimeMillis());
        long j = this.b;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            a();
            return null;
        }
        sharedPreferences = this.c.a;
        String string = sharedPreferences.getString(e(), null);
        sharedPreferences2 = this.c.a;
        long j2 = sharedPreferences2.getLong(d(), 0L);
        a();
        if (string != null && j2 > 0) {
            return new Pair<>(string, Long.valueOf(j2));
        }
        return null;
    }
}
