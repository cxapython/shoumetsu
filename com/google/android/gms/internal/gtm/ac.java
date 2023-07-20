package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends zzan {
    private static final byte[] c = "\n".getBytes();
    private final String a;
    private final ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(zzap zzapVar) {
        super(zzapVar);
        this.a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.b = new ai(zzapVar.zzcn());
    }

    private final int a(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = b(url);
                httpURLConnection.connect();
                a(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    i().c();
                }
                zzb("GET status", Integer.valueOf(responseCode));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.net.URL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int a(URL url, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzda()) {
            zza("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            try {
                e().getPackageName();
                httpURLConnection = b(url);
            } catch (IOException e) {
                e = e;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                url = 0;
                if (0 != 0) {
                }
                if (url != 0) {
                }
                throw th;
            }
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                a(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    i().c();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http post connection output stream", e2);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                zzd("Network POST connection error", e);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        zze("Error closing http post connection output stream", e4);
                    }
                }
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    zze("Error closing http post connection output stream", e5);
                }
            }
            if (url != 0) {
                url.disconnect();
            }
            throw th;
        }
    }

    private final URL a(zzcd zzcdVar) {
        String valueOf;
        String valueOf2;
        String str;
        String str2;
        if (zzcdVar.zzfj()) {
            valueOf = String.valueOf(zzbq.zzet());
            valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() == 0) {
                str = new String(valueOf);
                str2 = str;
            }
            str2 = valueOf.concat(valueOf2);
        } else {
            valueOf = String.valueOf(zzbq.zzeu());
            valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() == 0) {
                str = new String(valueOf);
                str2 = str;
            }
            str2 = valueOf.concat(valueOf2);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL a(zzcd zzcdVar, String str) {
        String zzeu;
        String zzev;
        StringBuilder sb;
        if (zzcdVar.zzfj()) {
            zzeu = zzbq.zzet();
            zzev = zzbq.zzev();
            sb = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
        } else {
            zzeu = zzbq.zzeu();
            zzev = zzbq.zzev();
            sb = new StringBuilder(String.valueOf(zzeu).length() + 1 + String.valueOf(zzev).length() + String.valueOf(str).length());
        }
        sb.append(zzeu);
        sb.append(zzev);
        sb.append("?");
        sb.append(str);
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void a(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private final void a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream == null) {
                return;
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                zze("Error closing http connection input stream", e);
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int b(URL url, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        OutputStream outputStream = null;
        try {
            e().getPackageName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            zza("POST compressed size, ratio %, url", Integer.valueOf(byteArray.length), Long.valueOf((byteArray.length * 100) / bArr.length), url);
            if (byteArray.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray.length), Integer.valueOf(bArr.length));
            }
            if (zzda()) {
                String valueOf = String.valueOf(new String(bArr));
                zza("Post payload", valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n"));
            }
            HttpURLConnection b = b(url);
            try {
                b.setDoOutput(true);
                b.addRequestProperty("Content-Encoding", "gzip");
                b.setFixedLengthStreamingMode(byteArray.length);
                b.connect();
                OutputStream outputStream2 = b.getOutputStream();
                try {
                    outputStream2.write(byteArray);
                    outputStream2.close();
                    a(b);
                    int responseCode = b.getResponseCode();
                    if (responseCode == 200) {
                        i().c();
                    }
                    zzb("POST status", Integer.valueOf(responseCode));
                    if (b != null) {
                        b.disconnect();
                    }
                    return responseCode;
                } catch (IOException e) {
                    httpURLConnection = b;
                    e = e;
                    outputStream = outputStream2;
                    try {
                        zzd("Network compressed POST connection error", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                zze("Error closing http compressed post connection output stream", e2);
                            }
                        }
                        if (httpURLConnection == null) {
                            return 0;
                        }
                        httpURLConnection.disconnect();
                        return 0;
                    } catch (Throwable th) {
                        th = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                zze("Error closing http compressed post connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    httpURLConnection = b;
                    th = th2;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } catch (IOException e4) {
                httpURLConnection = b;
                e = e4;
            } catch (Throwable th3) {
                httpURLConnection = b;
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    @VisibleForTesting
    private final HttpURLConnection b(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.a);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL r() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String a(zzcd zzcdVar, boolean z) {
        Preconditions.checkNotNull(zzcdVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzcdVar.zzdm().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    a(sb, key, entry.getValue());
                }
            }
            a(sb, "ht", String.valueOf(zzcdVar.zzfh()));
            a(sb, "qt", String.valueOf(d().currentTimeMillis() - zzcdVar.zzfh()));
            if (z) {
                long zzfk = zzcdVar.zzfk();
                a(sb, "z", zzfk != 0 ? String.valueOf(zzfk) : String.valueOf(zzcdVar.zzfg()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0159, code lost:
        if (a(r5) == 200) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0192, code lost:
        if (a(r6, r5) == 200) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ac A[EDGE_INSN: B:77:0x01ac->B:74:0x01ac ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Long> a(List<zzcd> list) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        zzci f;
        String str2;
        boolean z4;
        com.google.android.gms.analytics.zzk.zzav();
        q();
        Preconditions.checkNotNull(list);
        if (g().zzew().isEmpty() || !this.b.a(zzby.zzaab.get().intValue() * 1000)) {
            z = false;
        } else {
            z = zzbg.zzz(zzby.zzzu.get()) != zzbg.NONE;
            if (zzbm.zzaa(zzby.zzzv.get()) == zzbm.GZIP) {
                z2 = z;
                z3 = true;
                if (!z2) {
                    Preconditions.checkArgument(!list.isEmpty());
                    zza("Uploading batched hits. compression, count", Boolean.valueOf(z3), Integer.valueOf(list.size()));
                    ad adVar = new ad(this);
                    ArrayList arrayList = new ArrayList();
                    for (zzcd zzcdVar : list) {
                        if (!adVar.a(zzcdVar)) {
                            break;
                        }
                        arrayList.add(Long.valueOf(zzcdVar.zzfg()));
                    }
                    if (adVar.a() == 0) {
                        return arrayList;
                    }
                    URL r = r();
                    if (r == null) {
                        zzu("Failed to build batching endpoint url");
                    } else {
                        int b = z3 ? b(r, adVar.b()) : a(r, adVar.b());
                        if (200 == b) {
                            zza("Batched upload completed. Hits batched", Integer.valueOf(adVar.a()));
                            return arrayList;
                        }
                        zza("Network error uploading hits. status code", Integer.valueOf(b));
                        if (g().zzew().contains(Integer.valueOf(b))) {
                            zzt("Server instructed the client to stop batching");
                            this.b.a();
                        }
                    }
                    return Collections.emptyList();
                }
                ArrayList arrayList2 = new ArrayList(list.size());
                for (zzcd zzcdVar2 : list) {
                    Preconditions.checkNotNull(zzcdVar2);
                    String a = a(zzcdVar2, !zzcdVar2.zzfj());
                    if (a != null) {
                        if (a.length() <= zzby.zzzt.get().intValue()) {
                            URL a2 = a(zzcdVar2, a);
                            if (a2 == null) {
                                str = "Failed to build collect GET endpoint url";
                                zzu(str);
                                z4 = false;
                            }
                        } else {
                            String a3 = a(zzcdVar2, false);
                            if (a3 == null) {
                                f = f();
                                str2 = "Error formatting hit for POST upload";
                            } else {
                                byte[] bytes = a3.getBytes();
                                if (bytes.length > zzby.zzzy.get().intValue()) {
                                    f = f();
                                    str2 = "Hit payload exceeds size limit";
                                } else {
                                    URL a4 = a(zzcdVar2);
                                    if (a4 == null) {
                                        str = "Failed to build collect POST endpoint url";
                                        zzu(str);
                                        z4 = false;
                                    }
                                }
                            }
                        }
                        if (z4) {
                            break;
                        }
                        arrayList2.add(Long.valueOf(zzcdVar2.zzfg()));
                        if (arrayList2.size() >= zzbq.zzer()) {
                            break;
                        }
                    } else {
                        f = f();
                        str2 = "Error formatting hit for upload";
                    }
                    f.zza(zzcdVar2, str2);
                    z4 = true;
                    if (z4) {
                    }
                }
                return arrayList2;
            }
        }
        z2 = z;
        z3 = false;
        if (!z2) {
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
        zza("Network initialized. User agent", this.a);
    }

    public final boolean b() {
        NetworkInfo networkInfo;
        com.google.android.gms.analytics.zzk.zzav();
        q();
        try {
            networkInfo = ((ConnectivityManager) e().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzq("No network connectivity");
            return false;
        }
        return true;
    }
}
