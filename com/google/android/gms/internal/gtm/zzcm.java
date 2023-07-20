package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class zzcm extends zzan {
    private SharedPreferences a;
    private long b;
    private long c;
    private final zzco d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcm(zzap zzapVar) {
        super(zzapVar);
        this.c = -1L;
        this.d = new zzco(this, "monitoring", zzby.zzaao.get().longValue());
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        this.a = e().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final void zzad(String str) {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        SharedPreferences.Editor edit = this.a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzt("Failed to commit campaign data");
        }
    }

    public final long zzfv() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (this.b == 0) {
            long j = this.a.getLong("first_run", 0L);
            if (j == 0) {
                j = d().currentTimeMillis();
                SharedPreferences.Editor edit = this.a.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    zzt("Failed to commit first run time");
                }
            }
            this.b = j;
        }
        return this.b;
    }

    public final ai zzfw() {
        return new ai(d(), zzfv());
    }

    public final long zzfx() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (this.c == -1) {
            this.c = this.a.getLong("last_dispatch", 0L);
        }
        return this.c;
    }

    public final void zzfy() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        long currentTimeMillis = d().currentTimeMillis();
        SharedPreferences.Editor edit = this.a.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.c = currentTimeMillis;
    }

    public final String zzfz() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        String string = this.a.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final zzco zzga() {
        return this.d;
    }
}
