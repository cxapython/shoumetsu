package net.gree.gamelib.core.http;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.GLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    private static final String a = "a";
    protected static final String DEFAULT_USER_AGENT = "Gamelib/" + Core.getVersion() + " (Android " + Build.VERSION.RELEASE + ")";
    protected static Executor sExecutor = null;
    protected Executor mExecutor = null;
    protected String mEntity = null;

    public a() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private static void a(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper.getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(mainLooper).post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection) {
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(this.mEntity.getBytes("UTF-8"));
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection, HttpRequest httpRequest) {
        Map<String, String> headers = httpRequest.getHeaders();
        for (String str : headers.keySet()) {
            httpURLConnection.setRequestProperty(str, headers.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpResponse b(HttpURLConnection httpURLConnection) {
        StringBuffer stringBuffer = new StringBuffer();
        int responseCode = httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            stringBuffer.append(readLine);
        }
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : headerFields.get(str)) {
                sb.append(str2);
                sb.append(" ");
            }
            hashMap.put(str, sb.toString());
        }
        return new HttpResponse(responseCode, hashMap, stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final ResponseListener responseListener, final HttpResponse httpResponse, final String str) {
        if (responseListener != null) {
            a(new Runnable() { // from class: net.gree.gamelib.core.http.a.2
                @Override // java.lang.Runnable
                public void run() {
                    ResponseListener.this.onResponse(httpResponse, str);
                    if (httpResponse != null) {
                        String str2 = a.a;
                        GLog.i(str2, "Response status code:" + httpResponse.getStatusCode());
                        String str3 = a.a;
                        GLog.i(str3, "Response headers:" + httpResponse.getHeaders().toString());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setUseCaches(false);
        if (Build.VERSION.SDK_INT < 19) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
    }

    protected HttpURLConnection getHttpURLConnection(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    protected HttpResponse onPostRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        return httpResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onPreRequest(HttpRequest httpRequest) {
        return true;
    }

    public void request(final String str, final String str2, final ResponseListener responseListener) {
        String str3 = a;
        GLog.i(str3, "URL:" + str2);
        if (!net.gree.gamelib.core.a.b.a.q(str)) {
            b(responseListener, null, null);
            return;
        }
        if (this.mExecutor == null) {
            if (sExecutor == null) {
                sExecutor = Executors.newCachedThreadPool();
            }
            this.mExecutor = sExecutor;
        }
        this.mExecutor.execute(new Runnable() { // from class: net.gree.gamelib.core.http.a.1
            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                HttpResponse httpResponse;
                HttpResponse httpResponse2;
                HttpRequest httpRequest = new HttpRequest(str, str2);
                httpRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
                httpRequest.setEntity(a.this.mEntity);
                String str4 = null;
                try {
                    httpURLConnection = a.this.getHttpURLConnection(str2);
                } catch (Exception e) {
                    e = e;
                    httpURLConnection = null;
                    httpResponse = null;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = null;
                }
                try {
                    try {
                        httpURLConnection.setRequestMethod(str);
                        httpURLConnection.setDoInput(true);
                        if (a.this.mEntity != null) {
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(a.this.mEntity.getBytes().length);
                        }
                        a.this.c(httpURLConnection);
                    } catch (Exception e2) {
                        e = e2;
                        httpResponse = null;
                    }
                    if (!a.this.onPreRequest(httpRequest)) {
                        a.b(responseListener, null, null);
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                        return;
                    }
                    a.this.a(httpURLConnection, httpRequest);
                    GLog.i(a.a, "Request headers:" + httpURLConnection.getRequestProperties().toString());
                    httpURLConnection.connect();
                    if (a.this.mEntity != null) {
                        a.this.a(httpURLConnection);
                    }
                    httpResponse = a.this.b(httpURLConnection);
                    try {
                        httpResponse2 = a.this.onPostRequest(httpRequest, httpResponse);
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        str4 = httpResponse2.getEntity();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e4) {
                        httpResponse = httpResponse2;
                        e = e4;
                        e.printStackTrace();
                        GLog.w(a.a, "Request failed: " + str2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        httpResponse2 = httpResponse;
                        a.b(responseListener, httpResponse2, str4);
                    }
                    a.b(responseListener, httpResponse2, str4);
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        });
    }

    public void setEntity(String str) {
        this.mEntity = str;
    }

    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }
}
