package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dm implements aa {
    private final String a;
    private final Context b;
    private final Cdo c;
    private final zzfw d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public dm(Context context, zzfw zzfwVar) {
        this(new dn(), context, zzfwVar);
    }

    @VisibleForTesting
    private dm(Cdo cdo, Context context, zzfw zzfwVar) {
        this.c = cdo;
        this.b = context.getApplicationContext();
        this.d = zzfwVar;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str2 = sb.toString();
        }
        this.a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", str, str2, Build.MODEL, Build.ID);
    }

    @VisibleForTesting
    private static URL a(am amVar) {
        try {
            return new URL(amVar.c());
        } catch (MalformedURLException unused) {
            zzdi.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }

    @Override // com.google.android.gms.tagmanager.aa
    public final void a(List<am> list) {
        int min = Math.min(list.size(), 40);
        boolean z = true;
        for (int i = 0; i < min; i++) {
            am amVar = list.get(i);
            URL a = a(amVar);
            if (a == null) {
                zzdi.zzac("No destination: discarding hit.");
                this.d.zzb(amVar);
            } else {
                try {
                    HttpURLConnection a2 = this.c.a(a);
                    if (z) {
                        bh.a(this.b);
                        z = false;
                    }
                    a2.setRequestProperty("User-Agent", this.a);
                    int responseCode = a2.getResponseCode();
                    InputStream inputStream = a2.getInputStream();
                    if (responseCode != 200) {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("Bad response: ");
                        sb.append(responseCode);
                        zzdi.zzac(sb.toString());
                        this.d.zzc(amVar);
                    } else {
                        this.d.zza(amVar);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    a2.disconnect();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getClass().getSimpleName());
                    zzdi.zzac(valueOf.length() != 0 ? "Exception sending hit: ".concat(valueOf) : new String("Exception sending hit: "));
                    zzdi.zzac(e.getMessage());
                    this.d.zzc(amVar);
                }
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.aa
    public final boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzdi.zzab("...no network connectivity");
            return false;
        }
        return true;
    }
}
