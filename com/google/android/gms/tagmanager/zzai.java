package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Random;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzai {
    private final Context a;
    private final Random b;
    private final String c;

    public zzai(Context context, String str) {
        this(context, str, new Random());
    }

    private zzai(Context context, String str, Random random) {
        this.a = (Context) Preconditions.checkNotNull(context);
        this.c = (String) Preconditions.checkNotNull(str);
        this.b = random;
    }

    private final long a(long j, long j2) {
        SharedPreferences a = a();
        long max = Math.max(0L, a.getLong("FORBIDDEN_COUNT", 0L));
        return this.b.nextFloat() * ((float) (j + ((((float) max) / ((float) ((max + Math.max(0L, a.getLong("SUCCESSFUL_COUNT", 0L))) + 1))) * ((float) (j2 - j)))));
    }

    private final SharedPreferences a() {
        Context context = this.a;
        String valueOf = String.valueOf("_gtmContainerRefreshPolicy_");
        String valueOf2 = String.valueOf(this.c);
        return context.getSharedPreferences(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), 0);
    }

    public final long zzhl() {
        return a(7200000L, 259200000L) + 43200000;
    }

    public final long zzhm() {
        return a(600000L, 86400000L) + 3600000;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzhn() {
        SharedPreferences a = a();
        long j = a.getLong("FORBIDDEN_COUNT", 0L);
        long j2 = a.getLong("SUCCESSFUL_COUNT", 0L);
        SharedPreferences.Editor edit = a.edit();
        long min = j == 0 ? 3L : Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        edit.putLong("FORBIDDEN_COUNT", min);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzho() {
        SharedPreferences a = a();
        long j = a.getLong("SUCCESSFUL_COUNT", 0L);
        long j2 = a.getLong("FORBIDDEN_COUNT", 0L);
        long min = Math.min(10L, j + 1);
        long max = Math.max(0L, Math.min(j2, 10 - min));
        SharedPreferences.Editor edit = a.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }
}
