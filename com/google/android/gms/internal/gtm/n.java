package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends zzan {
    private boolean a;
    private final l b;
    private final ac c;
    private final ab d;
    private final zzat e;
    private long f;
    private final y g;
    private final y h;
    private final ai i;
    private long j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(zzap zzapVar, zzar zzarVar) {
        super(zzapVar);
        Preconditions.checkNotNull(zzarVar);
        this.f = Long.MIN_VALUE;
        this.d = new ab(zzapVar);
        this.b = new l(zzapVar);
        this.c = new ac(zzapVar);
        this.e = new zzat(zzapVar);
        this.i = new ai(d());
        this.g = new o(this, zzapVar);
        this.h = new p(this, zzapVar);
    }

    private final long A() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        try {
            return this.b.u();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    private final void B() {
        zzbv j = j();
        if (j.zzfc() && !j.zzez()) {
            long A = A();
            if (A == 0 || Math.abs(d().currentTimeMillis() - A) > zzby.zzzm.get().longValue()) {
                return;
            }
            zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzbq.zzeq()));
            j.zzfd();
        }
    }

    private final void C() {
        if (this.g.c()) {
            zzq("All hits dispatched or no network/service. Going to power save mode");
        }
        this.g.d();
        zzbv j = j();
        if (j.zzez()) {
            j.cancel();
        }
    }

    private final long D() {
        long j = this.f;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long longValue = zzby.zzzh.get().longValue();
        zzda k = k();
        k.q();
        if (!k.a) {
            return longValue;
        }
        zzda k2 = k();
        k2.q();
        return k2.b * 1000;
    }

    private final void E() {
        q();
        com.google.android.gms.analytics.zzk.zzav();
        this.k = true;
        this.e.disconnect();
        v();
    }

    private final void a(zzas zzasVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzasVar);
        Preconditions.checkNotNull(zzrVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzcm());
        zzaVar.zza(zzasVar.zzdj());
        zzaVar.enableAdvertisingIdCollection(zzasVar.zzdk());
        com.google.android.gms.analytics.zzg zzac = zzaVar.zzac();
        zzz zzzVar = (zzz) zzac.zzb(zzz.class);
        zzzVar.zzl("data");
        zzzVar.zzb(true);
        zzac.zza(zzrVar);
        zzu zzuVar = (zzu) zzac.zzb(zzu.class);
        zzq zzqVar = (zzq) zzac.zzb(zzq.class);
        for (Map.Entry<String, String> entry : zzasVar.zzdm().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zzqVar.setAppName(value);
            } else if ("av".equals(key)) {
                zzqVar.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zzqVar.setAppId(value);
            } else if ("aiid".equals(key)) {
                zzqVar.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzzVar.setUserId(value);
            } else {
                zzuVar.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzasVar.zzdj(), zzrVar);
        zzac.zza(l().zzfv());
        zzac.zzam();
    }

    private final boolean b(String str) {
        return Wrappers.packageManager(e()).checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        a((zzbw) new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        try {
            this.b.t();
            v();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.h.a(86400000L);
    }

    private final void y() {
        if (!this.k && zzbq.zzen() && !this.e.isConnected()) {
            if (!this.i.a(zzby.zzaan.get().longValue())) {
                return;
            }
            this.i.a();
            zzq("Connecting to service");
            if (!this.e.connect()) {
                return;
            }
            zzq("Connected to service");
            this.i.b();
            s();
        }
    }

    private final boolean z() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        zzq("Dispatching a batch of local hits");
        boolean z = !this.e.isConnected();
        boolean z2 = !this.c.b();
        if (z && z2) {
            zzq("No network or service available. Will retry later");
            return false;
        }
        long max = Math.max(zzbq.zzer(), zzbq.zzes());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        while (true) {
            try {
                this.b.b();
                arrayList.clear();
                try {
                    List<zzcd> a = this.b.a(max);
                    if (a.isEmpty()) {
                        zzq("Store is empty, nothing to dispatch");
                        C();
                        try {
                            this.b.c();
                            this.b.r();
                            return false;
                        } catch (SQLiteException e) {
                            zze("Failed to commit local dispatch transaction", e);
                            C();
                            return false;
                        }
                    }
                    zza("Hits loaded from store. count", Integer.valueOf(a.size()));
                    Iterator<zzcd> it = a.iterator();
                    while (it.hasNext()) {
                        if (it.next().zzfg() == j) {
                            zzd("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(a.size()));
                            C();
                            try {
                                this.b.c();
                                this.b.r();
                                return false;
                            } catch (SQLiteException e2) {
                                zze("Failed to commit local dispatch transaction", e2);
                                C();
                                return false;
                            }
                        }
                    }
                    if (this.e.isConnected()) {
                        zzq("Service connected, sending hits to the service");
                        while (!a.isEmpty()) {
                            zzcd zzcdVar = a.get(0);
                            if (!this.e.zzb(zzcdVar)) {
                                break;
                            }
                            j = Math.max(j, zzcdVar.zzfg());
                            a.remove(zzcdVar);
                            zzb("Hit sent do device AnalyticsService for delivery", zzcdVar);
                            try {
                                this.b.b(zzcdVar.zzfg());
                                arrayList.add(Long.valueOf(zzcdVar.zzfg()));
                            } catch (SQLiteException e3) {
                                zze("Failed to remove hit that was send for delivery", e3);
                                C();
                                try {
                                    this.b.c();
                                    this.b.r();
                                    return false;
                                } catch (SQLiteException e4) {
                                    zze("Failed to commit local dispatch transaction", e4);
                                    C();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.c.b()) {
                        List<Long> a2 = this.c.a(a);
                        for (Long l : a2) {
                            j = Math.max(j, l.longValue());
                        }
                        try {
                            this.b.a(a2);
                            arrayList.addAll(a2);
                        } catch (SQLiteException e5) {
                            zze("Failed to remove successfully uploaded hits", e5);
                            C();
                            try {
                                this.b.c();
                                this.b.r();
                                return false;
                            } catch (SQLiteException e6) {
                                zze("Failed to commit local dispatch transaction", e6);
                                C();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.b.c();
                            this.b.r();
                            return false;
                        } catch (SQLiteException e7) {
                            zze("Failed to commit local dispatch transaction", e7);
                            C();
                            return false;
                        }
                    }
                    try {
                        this.b.c();
                        this.b.r();
                    } catch (SQLiteException e8) {
                        zze("Failed to commit local dispatch transaction", e8);
                        C();
                        return false;
                    }
                } catch (SQLiteException e9) {
                    zzd("Failed to read hits from persisted store", e9);
                    C();
                    try {
                        this.b.c();
                        this.b.r();
                        return false;
                    } catch (SQLiteException e10) {
                        zze("Failed to commit local dispatch transaction", e10);
                        C();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.b.c();
                this.b.r();
                throw th;
            }
            try {
                this.b.c();
                this.b.r();
                throw th;
            } catch (SQLiteException e11) {
                zze("Failed to commit local dispatch transaction", e11);
                C();
                return false;
            }
        }
    }

    public final long a(zzas zzasVar, boolean z) {
        Preconditions.checkNotNull(zzasVar);
        q();
        com.google.android.gms.analytics.zzk.zzav();
        try {
            try {
                this.b.b();
                l lVar = this.b;
                long zzdi = zzasVar.zzdi();
                String zzbt = zzasVar.zzbt();
                Preconditions.checkNotEmpty(zzbt);
                lVar.q();
                com.google.android.gms.analytics.zzk.zzav();
                int i = 1;
                int delete = lVar.v().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzdi), zzbt});
                if (delete > 0) {
                    lVar.zza("Deleted property records", Integer.valueOf(delete));
                }
                long a = this.b.a(zzasVar.zzdi(), zzasVar.zzbt(), zzasVar.zzdj());
                zzasVar.zzb(1 + a);
                l lVar2 = this.b;
                Preconditions.checkNotNull(zzasVar);
                lVar2.q();
                com.google.android.gms.analytics.zzk.zzav();
                SQLiteDatabase v = lVar2.v();
                Map<String, String> zzdm = zzasVar.zzdm();
                Preconditions.checkNotNull(zzdm);
                Uri.Builder builder = new Uri.Builder();
                for (Map.Entry<String, String> entry : zzdm.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                String encodedQuery = builder.build().getEncodedQuery();
                if (encodedQuery == null) {
                    encodedQuery = "";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_uid", Long.valueOf(zzasVar.zzdi()));
                contentValues.put("cid", zzasVar.zzbt());
                contentValues.put("tid", zzasVar.zzdj());
                if (!zzasVar.zzdk()) {
                    i = 0;
                }
                contentValues.put("adid", Integer.valueOf(i));
                contentValues.put("hits_count", Long.valueOf(zzasVar.zzdl()));
                contentValues.put("params", encodedQuery);
                try {
                    if (v.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                        lVar2.zzu("Failed to insert/update a property (got -1)");
                    }
                } catch (SQLiteException e) {
                    lVar2.zze("Error storing a property", e);
                }
                this.b.c();
                try {
                    this.b.r();
                } catch (SQLiteException e2) {
                    zze("Failed to end transaction", e2);
                }
                return a;
            } catch (SQLiteException e3) {
                zze("Failed to update Analytics property", e3);
                try {
                    this.b.r();
                } catch (SQLiteException e4) {
                    zze("Failed to end transaction", e4);
                }
                return -1L;
            }
        } catch (Throwable th) {
            try {
                this.b.r();
            } catch (SQLiteException e5) {
                zze("Failed to end transaction", e5);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        this.b.zzag();
        this.c.zzag();
        this.e.zzag();
    }

    public final void a(long j) {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (j < 0) {
            j = 0;
        }
        this.f = j;
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzas zzasVar) {
        com.google.android.gms.analytics.zzk.zzav();
        zzb("Sending first hit to property", zzasVar.zzdj());
        if (l().zzfw().a(zzbq.zzex())) {
            return;
        }
        String zzfz = l().zzfz();
        if (TextUtils.isEmpty(zzfz)) {
            return;
        }
        zzr zza = zzcz.zza(f(), zzfz);
        zzb("Found relevant installation campaign", zza);
        a(zzasVar, zza);
    }

    public final void a(zzbw zzbwVar) {
        long j = this.j;
        com.google.android.gms.analytics.zzk.zzav();
        q();
        long zzfx = l().zzfx();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzfx != 0 ? Math.abs(d().currentTimeMillis() - zzfx) : -1L));
        y();
        try {
            z();
            l().zzfy();
            v();
            if (zzbwVar != null) {
                zzbwVar.zza(null);
            }
            if (this.j == j) {
                return;
            }
            this.d.c();
        } catch (Exception e) {
            zze("Local dispatch failed", e);
            l().zzfy();
            v();
            if (zzbwVar == null) {
                return;
            }
            zzbwVar.zza(e);
        }
    }

    public final void a(zzcd zzcdVar) {
        Pair<String, Long> zzgc;
        Preconditions.checkNotNull(zzcdVar);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (this.k) {
            zzr("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzcdVar);
        }
        if (TextUtils.isEmpty(zzcdVar.zzfl()) && (zzgc = l().zzga().zzgc()) != null) {
            String str = (String) zzgc.first;
            String valueOf = String.valueOf((Long) zzgc.second);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
            sb.append(valueOf);
            sb.append(":");
            sb.append(str);
            String sb2 = sb.toString();
            HashMap hashMap = new HashMap(zzcdVar.zzdm());
            hashMap.put("_m", sb2);
            zzcdVar = new zzcd(this, hashMap, zzcdVar.zzfh(), zzcdVar.zzfj(), zzcdVar.zzfg(), zzcdVar.zzff(), zzcdVar.zzfi());
        }
        y();
        if (this.e.zzb(zzcdVar)) {
            zzr("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.b.a(zzcdVar);
            v();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            f().zza(zzcdVar, "deliver: failed to insert hit to database");
        }
    }

    public final void a(String str) {
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.analytics.zzk.zzav();
        zzr zza = zzcz.zza(f(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzfz = l().zzfz();
        if (str.equals(zzfz)) {
            zzt("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzfz)) {
            zzd("Ignoring multiple install campaigns. original, new", zzfz, str);
        } else {
            l().zzad(str);
            if (l().zzfw().a(zzbq.zzex())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzas zzasVar : this.b.c(0L)) {
                a(zzasVar, zza);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        q();
        Preconditions.checkState(!this.a, "Analytics backend already started");
        this.a = true;
        h().zza(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        q();
        com.google.android.gms.analytics.zzk.zzav();
        Context context = zzcm().getContext();
        if (!zzcp.zza(context)) {
            zzt("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzcq.zze(context)) {
            zzu("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zza(context)) {
            zzt("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        l().zzfv();
        if (!b("android.permission.ACCESS_NETWORK_STATE")) {
            zzu("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            E();
        }
        if (!b("android.permission.INTERNET")) {
            zzu("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            E();
        }
        if (zzcq.zze(e())) {
            zzq("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzt("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.k && !this.b.s()) {
            y();
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        com.google.android.gms.analytics.zzk.zzav();
        this.j = d().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[LOOP:1: B:16:0x0044->B:23:0x0060, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0040 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        com.google.android.gms.analytics.zzk.zzav();
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (!zzbq.zzen()) {
            zzt("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.e.isConnected()) {
            zzq("Service not connected");
        } else if (this.b.s()) {
        } else {
            zzq("Dispatching local hits to device AnalyticsService");
            while (true) {
                try {
                    List<zzcd> a = this.b.a(zzbq.zzer());
                    if (!a.isEmpty()) {
                        v();
                        return;
                    }
                    while (true) {
                        if (!a.isEmpty()) {
                            zzcd zzcdVar = a.get(0);
                            if (!this.e.zzb(zzcdVar)) {
                                v();
                                return;
                            }
                            a.remove(zzcdVar);
                            try {
                                this.b.b(zzcdVar.zzfg());
                            } catch (SQLiteException e) {
                                zze("Failed to remove hit that was send for delivery", e);
                                C();
                                return;
                            }
                        }
                    }
                    List<zzcd> a2 = this.b.a(zzbq.zzer());
                    if (!a2.isEmpty()) {
                    }
                } catch (SQLiteException e2) {
                    zze("Failed to read hits from store", e2);
                    C();
                    return;
                }
            }
        }
    }

    public final void t() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        zzq("Delete all hits from local store");
        try {
            l lVar = this.b;
            com.google.android.gms.analytics.zzk.zzav();
            lVar.q();
            lVar.v().delete("hits2", null, null);
            l lVar2 = this.b;
            com.google.android.gms.analytics.zzk.zzav();
            lVar2.q();
            lVar2.v().delete("properties", null, null);
            v();
        } catch (SQLiteException e) {
            zzd("Failed to delete hits from store", e);
        }
        y();
        if (this.e.zzdn()) {
            zzq("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public final void u() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        zzr("Sync dispatching local hits");
        long j = this.j;
        y();
        try {
            z();
            l().zzfy();
            v();
            if (this.j == j) {
                return;
            }
            this.d.c();
        } catch (Exception e) {
            zze("Sync local dispatch failed", e);
            v();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r4 > 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v() {
        long min;
        com.google.android.gms.analytics.zzk.zzav();
        q();
        boolean z = true;
        if (!(!this.k && D() > 0)) {
            this.d.b();
            C();
        } else if (this.b.s()) {
            this.d.b();
            C();
        } else {
            if (!zzby.zzaai.get().booleanValue()) {
                this.d.a();
                z = this.d.d();
            }
            if (!z) {
                C();
                B();
                return;
            }
            B();
            long D = D();
            long zzfx = l().zzfx();
            if (zzfx != 0) {
                min = D - Math.abs(d().currentTimeMillis() - zzfx);
            }
            min = Math.min(zzbq.zzep(), D);
            zza("Dispatch scheduled (ms)", Long.valueOf(min));
            if (this.g.c()) {
                this.g.b(Math.max(1L, min + this.g.b()));
            } else {
                this.g.a(min);
            }
        }
    }
}
