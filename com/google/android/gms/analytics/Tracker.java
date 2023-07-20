package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzan;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzcg;
import com.google.android.gms.internal.gtm.zzcy;
import com.google.android.gms.internal.gtm.zzcz;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@VisibleForTesting
/* loaded from: classes.dex */
public class Tracker extends zzan {
    private boolean a;
    private final Map<String, String> b;
    private final Map<String, String> c;
    private final zzcg d;
    private final a e;
    private ExceptionReporter f;
    private zzcy g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends zzan implements GoogleAnalytics.a {
        private boolean a;
        private int b;
        private long c;
        private boolean d;
        private long e;

        protected a(zzap zzapVar) {
            super(zzapVar);
            this.c = -1L;
        }

        private final void c() {
            if (this.c >= 0 || this.a) {
                zzcr().a(Tracker.this.e);
            } else {
                zzcr().b(Tracker.this.e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzan
        protected final void a() {
        }

        public final void a(long j) {
            this.c = j;
            c();
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.a
        public final void a(Activity activity) {
            String canonicalName;
            if (this.b == 0) {
                if (d().elapsedRealtime() >= this.e + Math.max(1000L, this.c)) {
                    this.d = true;
                }
            }
            this.b++;
            if (this.a) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker tracker = Tracker.this;
                if (tracker.g != null) {
                    zzcy zzcyVar = Tracker.this.g;
                    canonicalName = activity.getClass().getCanonicalName();
                    String str = zzcyVar.zzacs.get(canonicalName);
                    if (str != null) {
                        canonicalName = str;
                    }
                } else {
                    canonicalName = activity.getClass().getCanonicalName();
                }
                tracker.set("&cd", canonicalName);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    Preconditions.checkNotNull(activity);
                    Intent intent2 = activity.getIntent();
                    String str2 = null;
                    if (intent2 != null) {
                        String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str2 = stringExtra;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("&dr", str2);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        public final void a(boolean z) {
            this.a = z;
            c();
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.a
        public final void b(Activity activity) {
            this.b--;
            this.b = Math.max(0, this.b);
            if (this.b == 0) {
                this.e = d().elapsedRealtime();
            }
        }

        public final synchronized boolean b() {
            boolean z;
            z = this.d;
            this.d = false;
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tracker(zzap zzapVar, String str, zzcg zzcgVar) {
        super(zzapVar);
        this.b = new HashMap();
        this.c = new HashMap();
        if (str != null) {
            this.b.put("&tid", str);
        }
        this.b.put("useSecure", "1");
        this.b.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.d = new zzcg("tracking", d());
        this.e = new a(zzapVar);
    }

    private static String a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (!(key.startsWith("&") && key.length() >= 2)) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    private static void a(Map<String, String> map, Map<String, String> map2) {
        Preconditions.checkNotNull(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String a2 = a(entry);
            if (a2 != null) {
                map2.put(a2, entry.getValue());
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        this.e.zzag();
        String zzaz = k().zzaz();
        if (zzaz != null) {
            set("&an", zzaz);
        }
        String zzba = k().zzba();
        if (zzba != null) {
            set("&av", zzba);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzcy zzcyVar) {
        zzq("Loading Tracker config values");
        this.g = zzcyVar;
        boolean z = false;
        if (this.g.zzacm != null) {
            String str = this.g.zzacm;
            set("&tid", str);
            zza("trackingId loaded", str);
        }
        if (this.g.zzacn >= 0.0d) {
            String d = Double.toString(this.g.zzacn);
            set("&sf", d);
            zza("Sample frequency loaded", d);
        }
        if (this.g.zzaco >= 0) {
            int i = this.g.zzaco;
            setSessionTimeout(i);
            zza("Session timeout loaded", Integer.valueOf(i));
        }
        if (this.g.zzacp != -1) {
            boolean z2 = this.g.zzacp == 1;
            enableAutoActivityTracking(z2);
            zza("Auto activity tracking loaded", Boolean.valueOf(z2));
        }
        if (this.g.zzacq != -1) {
            boolean z3 = this.g.zzacq == 1;
            if (z3) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(z3));
        }
        if (this.g.zzacr == 1) {
            z = true;
        }
        enableExceptionReporting(z);
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.a = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.e.a(z);
    }

    public void enableExceptionReporting(boolean z) {
        String str;
        synchronized (this) {
            if ((this.f != null) == z) {
                return;
            }
            if (z) {
                this.f = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), e());
                Thread.setDefaultUncaughtExceptionHandler(this.f);
                str = "Uncaught exceptions will be reported to Google Analytics";
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.f.a());
                str = "Uncaught exceptions will not be reported to Google Analytics";
            }
            zzq(str);
        }
    }

    public String get(String str) {
        q();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        if (str.equals("&ul")) {
            return zzcz.zza(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return m().zzeh();
        }
        if (str.equals("&sr")) {
            return p().zzfb();
        }
        if (str.equals("&aid")) {
            return o().zzdv().zzbb();
        }
        if (str.equals("&an")) {
            return o().zzdv().zzaz();
        }
        if (str.equals("&av")) {
            return o().zzdv().zzba();
        }
        if (!str.equals("&aiid")) {
            return null;
        }
        return o().zzdv().zzbc();
    }

    public void send(Map<String, String> map) {
        long currentTimeMillis = d().currentTimeMillis();
        if (zzcr().getAppOptOut()) {
            zzr("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzcr().isDryRunEnabled();
        HashMap hashMap = new HashMap();
        a(this.b, hashMap);
        a(map, hashMap);
        boolean zzb = zzcz.zzb(this.b.get("useSecure"), true);
        Map<String, String> map2 = this.c;
        Preconditions.checkNotNull(hashMap);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String a2 = a(entry);
                if (a2 != null && !hashMap.containsKey(a2)) {
                    hashMap.put(a2, entry.getValue());
                }
            }
        }
        this.c.clear();
        String str = hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            f().zza(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            f().zza(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.a;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.b.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.b.put("&a", Integer.toString(parseInt));
            }
        }
        h().zza(new e(this, hashMap, z, str, currentTimeMillis, isDryRunEnabled, zzb, str2));
    }

    public void set(String str, String str2) {
        Preconditions.checkNotNull(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzcz.zzc(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter(Constants.REFERRER);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        String valueOf = String.valueOf(queryParameter);
        Uri parse = Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?"));
        String queryParameter2 = parse.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.c.put("&ci", queryParameter2);
        }
        String queryParameter3 = parse.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.c.put("&anid", queryParameter3);
        }
        String queryParameter4 = parse.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.c.put("&cn", queryParameter4);
        }
        String queryParameter5 = parse.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.c.put("&cc", queryParameter5);
        }
        String queryParameter6 = parse.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.c.put("&cm", queryParameter6);
        }
        String queryParameter7 = parse.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.c.put("&cs", queryParameter7);
        }
        String queryParameter8 = parse.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.c.put("&ck", queryParameter8);
        }
        String queryParameter9 = parse.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.c.put("&dclid", queryParameter9);
        }
        String queryParameter10 = parse.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.c.put("&gclid", queryParameter10);
        }
        String queryParameter11 = parse.getQueryParameter("aclid");
        if (queryParameter11 == null) {
            return;
        }
        this.c.put("&aclid", queryParameter11);
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i < 0 && i2 < 0) {
            zzt("Invalid width or height. The values should be non-negative.");
            return;
        }
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        set("&sr", sb.toString());
    }

    public void setSessionTimeout(long j) {
        this.e.a(j * 1000);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzcz.zzc(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }
}
