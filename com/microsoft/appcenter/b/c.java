package com.microsoft.appcenter.b;

import android.net.TrafficStats;
import android.os.AsyncTask;
import android.util.Pair;
import com.microsoft.appcenter.b.d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask<Void, Void, Object> {
    private static final Pattern a = Pattern.compile("token=[^&]+");
    private static final Pattern b = Pattern.compile("token\":\"[^\"]+\"");
    private static final Pattern c = Pattern.compile("redirect_uri\":\"[^\"]+\"");
    private final String d;
    private final String e;
    private final Map<String, String> f;
    private final d.a g;
    private final l h;
    private final a i;
    private final boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, Map<String, String> map, d.a aVar, l lVar, a aVar2, boolean z) {
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = aVar;
        this.h = lVar;
        this.i = aVar2;
        this.j = z;
    }

    private Pair<String, Map<String, String>> a() {
        String str;
        byte[] bArr;
        String replaceAll;
        URL url = new URL(this.d);
        HttpsURLConnection a2 = j.a(url);
        try {
            a2.setRequestMethod(this.e);
            boolean z = false;
            if (!this.e.equals("POST") || this.g == null) {
                str = null;
                bArr = null;
            } else {
                str = this.g.a();
                bArr = str.getBytes("UTF-8");
                if (this.j && bArr.length >= 1400) {
                    z = true;
                }
                if (!this.f.containsKey("Content-Type")) {
                    this.f.put("Content-Type", "application/json");
                }
            }
            if (z) {
                this.f.put("Content-Encoding", "gzip");
            }
            for (Map.Entry<String, String> entry : this.f.entrySet()) {
                a2.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if (isCancelled()) {
                return null;
            }
            if (this.g != null) {
                this.g.a(url, this.f);
            }
            if (bArr != null) {
                if (com.microsoft.appcenter.e.a.a() <= 2) {
                    if (str.length() < 4096) {
                        str = a.matcher(str).replaceAll("token=***");
                        if ("application/json".equals(this.f.get("Content-Type"))) {
                            str = new JSONObject(str).toString(2);
                        }
                    }
                    com.microsoft.appcenter.e.a.a("AppCenter", str);
                }
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                }
                a2.setDoOutput(true);
                a2.setFixedLengthStreamingMode(bArr.length);
                OutputStream outputStream = a2.getOutputStream();
                a(outputStream, bArr);
                outputStream.close();
            }
            if (isCancelled()) {
                return null;
            }
            int responseCode = a2.getResponseCode();
            String b2 = b(a2);
            if (com.microsoft.appcenter.e.a.a() <= 2) {
                String headerField = a2.getHeaderField("Content-Type");
                if (headerField != null && !headerField.startsWith("text/") && !headerField.startsWith("application/")) {
                    replaceAll = "<binary>";
                    com.microsoft.appcenter.e.a.a("AppCenter", "HTTP response status=" + responseCode + " payload=" + replaceAll);
                }
                replaceAll = c.matcher(b.matcher(b2).replaceAll("token\":\"***\"")).replaceAll("redirect_uri\":\"***\"");
                com.microsoft.appcenter.e.a.a("AppCenter", "HTTP response status=" + responseCode + " payload=" + replaceAll);
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry entry2 : a2.getHeaderFields().entrySet()) {
                hashMap.put(entry2.getKey(), ((List) entry2.getValue()).iterator().next());
            }
            if (responseCode >= 200 && responseCode < 300) {
                return new Pair<>(b2, hashMap);
            }
            throw new i(responseCode, b2, hashMap);
        } finally {
            a2.disconnect();
        }
    }

    private static InputStream a(HttpsURLConnection httpsURLConnection) {
        int responseCode = httpsURLConnection.getResponseCode();
        return (responseCode < 200 || responseCode >= 400) ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream();
    }

    private void a(OutputStream outputStream, byte[] bArr) {
        for (int i = 0; i < bArr.length; i += 1024) {
            outputStream.write(bArr, i, Math.min(bArr.length - i, 1024));
            if (isCancelled()) {
                return;
            }
        }
    }

    private String b(HttpsURLConnection httpsURLConnection) {
        StringBuilder sb = new StringBuilder(Math.max(httpsURLConnection.getContentLength(), 16));
        InputStream a2 = a(httpsURLConnection);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(a2, "UTF-8");
            char[] cArr = new char[1024];
            do {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            } while (!isCancelled());
            return sb.toString();
        } finally {
            a2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Object doInBackground(Void... voidArr) {
        TrafficStats.setThreadStatsTag(-667034599);
        try {
            return a();
        } catch (Exception e) {
            return e;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled(Object obj) {
        if ((obj instanceof Pair) || (obj instanceof i)) {
            onPostExecute(obj);
        } else {
            this.i.b(this);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object obj) {
        this.i.b(this);
        if (obj instanceof Exception) {
            this.h.a((Exception) obj);
            return;
        }
        Pair pair = (Pair) obj;
        this.h.a((String) pair.first, (Map) pair.second);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.i.a(this);
    }
}
