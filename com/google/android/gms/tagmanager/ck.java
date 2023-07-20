package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzpc;
import com.google.android.gms.internal.gtm.zzpd;
import com.google.android.gms.internal.gtm.zzpe;
import com.google.android.gms.internal.gtm.zzuw;
import com.google.android.gms.tagmanager.ca;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class ck implements Runnable {
    private final Context a;
    private final zzpd b;
    private final String c;
    private final String d;
    private bc<zzk> e;
    private volatile k f;
    private volatile String g;
    private volatile String h;

    @VisibleForTesting
    private ck(Context context, String str, zzpd zzpdVar, k kVar) {
        this.a = context;
        this.b = zzpdVar;
        this.c = str;
        this.f = kVar;
        String valueOf = String.valueOf("/r?id=");
        String valueOf2 = String.valueOf(str);
        this.d = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.g = this.d;
        this.h = null;
    }

    public ck(Context context, String str, k kVar) {
        this(context, str, new zzpd(), kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(bc<zzk> bcVar) {
        this.e = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(String str) {
        if (str == null) {
            str = this.d;
        } else {
            String valueOf = String.valueOf(str);
            zzdi.zzax(valueOf.length() != 0 ? "Setting CTFE URL path: ".concat(valueOf) : new String("Setting CTFE URL path: "));
        }
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void b(String str) {
        String valueOf = String.valueOf(str);
        zzdi.zzax(valueOf.length() != 0 ? "Setting previous container version: ".concat(valueOf) : new String("Setting previous container version: "));
        this.h = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        bc<zzk> bcVar = this.e;
        if (bcVar != null) {
            bcVar.a();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                zzdi.zzab("...no network connectivity");
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                this.e.a(zzcz.zzaht);
                return;
            }
            zzdi.zzab("Start loading resource from network ...");
            String a = this.f.a();
            String str = this.g;
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 12 + String.valueOf(str).length());
            sb.append(a);
            sb.append(str);
            sb.append("&v=a65833898");
            String sb2 = sb.toString();
            if (this.h != null && !this.h.trim().equals("")) {
                String valueOf = String.valueOf(sb2);
                String str2 = this.h;
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(str2).length());
                sb3.append(valueOf);
                sb3.append("&pv=");
                sb3.append(str2);
                sb2 = sb3.toString();
            }
            if (ca.a().b().equals(ca.a.CONTAINER_DEBUG)) {
                String valueOf2 = String.valueOf(sb2);
                String valueOf3 = String.valueOf("&gtm_debug=x");
                sb2 = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            zzpc zzmt = zzpd.zzmt();
            InputStream inputStream = null;
            try {
                try {
                    try {
                        inputStream = zzmt.zzcj(sb2);
                    } catch (zzpe unused) {
                        String valueOf4 = String.valueOf(sb2);
                        zzdi.zzac(valueOf4.length() != 0 ? "Error when loading resource for url: ".concat(valueOf4) : new String("Error when loading resource for url: "));
                        this.e.a(zzcz.zzahw);
                    } catch (FileNotFoundException unused2) {
                        String str3 = this.c;
                        StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 79 + String.valueOf(str3).length());
                        sb4.append("No data is retrieved from the given url: ");
                        sb4.append(sb2);
                        sb4.append(". Make sure container_id: ");
                        sb4.append(str3);
                        sb4.append(" is correct.");
                        zzdi.zzac(sb4.toString());
                        this.e.a(zzcz.zzahv);
                        zzmt.close();
                        return;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        zzor.zza(inputStream, byteArrayOutputStream);
                        zzk zzkVar = (zzk) zzuw.zza(new zzk(), byteArrayOutputStream.toByteArray());
                        String valueOf5 = String.valueOf(zzkVar);
                        StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf5).length() + 43);
                        sb5.append("Successfully loaded supplemented resource: ");
                        sb5.append(valueOf5);
                        zzdi.zzab(sb5.toString());
                        if (zzkVar.zzqk == null && zzkVar.zzqj.length == 0) {
                            String valueOf6 = String.valueOf(this.c);
                            zzdi.zzab(valueOf6.length() != 0 ? "No change for container: ".concat(valueOf6) : new String("No change for container: "));
                        }
                        this.e.a((bc<zzk>) zzkVar);
                        zzmt.close();
                        zzdi.zzab("Load resource from network finished.");
                        return;
                    } catch (IOException e) {
                        String message = e.getMessage();
                        StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 51 + String.valueOf(message).length());
                        sb6.append("Error when parsing downloaded resources from url: ");
                        sb6.append(sb2);
                        sb6.append(" ");
                        sb6.append(message);
                        zzdi.zzb(sb6.toString(), e);
                        this.e.a(zzcz.zzahv);
                        zzmt.close();
                        return;
                    }
                } catch (IOException e2) {
                    String message2 = e2.getMessage();
                    StringBuilder sb7 = new StringBuilder(String.valueOf(sb2).length() + 40 + String.valueOf(message2).length());
                    sb7.append("Error when loading resources from url: ");
                    sb7.append(sb2);
                    sb7.append(" ");
                    sb7.append(message2);
                    zzdi.zzb(sb7.toString(), e2);
                    this.e.a(zzcz.zzahu);
                    zzmt.close();
                    return;
                }
            } catch (Throwable th) {
                zzmt.close();
                throw th;
            }
        }
        throw new IllegalStateException("callback must be set before execute");
    }
}
