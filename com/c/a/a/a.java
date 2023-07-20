package com.c.a.a;

import android.content.Context;
import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.client.cache.CacheConfig;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.SyncBasicHttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class a {
    public static h a = new g();
    private final DefaultHttpClient b;
    private final HttpContext c;
    private final Map<Context, List<l>> d;
    private final Map<String, String> e;
    private int f;
    private int g;
    private int h;
    private ExecutorService i;
    private boolean j;

    /* renamed from: com.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0043a extends HttpEntityWrapper {
        InputStream a;
        PushbackInputStream b;
        GZIPInputStream c;

        public C0043a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void consumeContent() {
            a.a(this.a);
            a.a((InputStream) this.b);
            a.a(this.c);
            super.consumeContent();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public InputStream getContent() {
            this.a = this.wrappedEntity.getContent();
            this.b = new PushbackInputStream(this.a, 2);
            if (a.a(this.b)) {
                this.c = new GZIPInputStream(this.b);
                return this.c;
            }
            return this.b;
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public long getContentLength() {
            if (this.wrappedEntity == null) {
                return 0L;
            }
            return this.wrappedEntity.getContentLength();
        }
    }

    public a() {
        this(false, 80, 443);
    }

    public a(SchemeRegistry schemeRegistry) {
        this.f = 10;
        this.g = 10000;
        this.h = 10000;
        boolean z = true;
        this.j = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.g);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.h);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.g);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager a2 = a(schemeRegistry, basicHttpParams);
        p.a(a2 == null ? false : z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.i = a();
        this.d = Collections.synchronizedMap(new WeakHashMap());
        this.e = new HashMap();
        this.c = new SyncBasicHttpContext(new BasicHttpContext());
        this.b = new DefaultHttpClient(a2, basicHttpParams);
        this.b.addRequestInterceptor(new HttpRequestInterceptor() { // from class: com.c.a.a.a.1
            @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (!httpRequest.containsHeader(HttpHeaders.ACCEPT_ENCODING)) {
                    httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
                }
                for (String str : a.this.e.keySet()) {
                    if (httpRequest.containsHeader(str)) {
                        Header firstHeader = httpRequest.getFirstHeader(str);
                        a.a.b("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", str, a.this.e.get(str), firstHeader.getName(), firstHeader.getValue()));
                        httpRequest.removeHeader(firstHeader);
                    }
                    httpRequest.addHeader(str, (String) a.this.e.get(str));
                }
            }
        });
        this.b.addResponseInterceptor(new HttpResponseInterceptor() { // from class: com.c.a.a.a.2
            @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
            public void process(HttpResponse httpResponse, HttpContext httpContext) {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
                    return;
                }
                for (HeaderElement headerElement : contentEncoding.getElements()) {
                    if (headerElement.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new C0043a(entity));
                        return;
                    }
                }
            }
        });
        this.b.addRequestInterceptor(new HttpRequestInterceptor() { // from class: com.c.a.a.a.3
            @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                Credentials credentials;
                AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
                CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
                HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                if (authState.getAuthScheme() != null || (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) == null) {
                    return;
                }
                authState.setAuthScheme(new BasicScheme());
                authState.setCredentials(credentials);
            }
        }, 0);
        this.b.setHttpRequestRetryHandler(new o(5, 1500));
    }

    public a(boolean z, int i, int i2) {
        this(a(z, i, i2));
    }

    private static SchemeRegistry a(boolean z, int i, int i2) {
        if (z) {
            a.b("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            a.b("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            a.b("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
        }
        SSLSocketFactory b = z ? j.b() : SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme(Constants.SCHEME, b, i2));
        return schemeRegistry;
    }

    public static String a(boolean z, String str, m mVar) {
        if (str == null) {
            return null;
        }
        if (z) {
            try {
                URL url = new URL(URLDecoder.decode(str, "UTF-8"));
                str = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
            } catch (Exception e) {
                a.b("AsyncHttpClient", "getUrlWithQueryString encoding URL", e);
            }
        }
        if (mVar == null) {
            return str;
        }
        String trim = mVar.b().trim();
        if (trim.equals("") || trim.equals("?")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.contains("?") ? "&" : "?");
        String sb2 = sb.toString();
        return sb2 + trim;
    }

    public static void a(HttpEntity httpEntity) {
        if (httpEntity instanceof HttpEntityWrapper) {
            Field field = null;
            try {
                Field[] declaredFields = HttpEntityWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Field field2 = declaredFields[i];
                    if (field2.getName().equals("wrappedEntity")) {
                        field = field2;
                        break;
                    }
                    i++;
                }
                if (field == null) {
                    return;
                }
                field.setAccessible(true);
                HttpEntity httpEntity2 = (HttpEntity) field.get(httpEntity);
                if (httpEntity2 == null) {
                    return;
                }
                httpEntity2.consumeContent();
            } catch (Throwable th) {
                a.b("AsyncHttpClient", "wrappedEntity consume", th);
            }
        }
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                a.a("AsyncHttpClient", "Cannot close input stream", e);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                a.a("AsyncHttpClient", "Cannot close output stream", e);
            }
        }
    }

    public static void a(Class<?> cls) {
        if (cls != null) {
            o.a(cls);
        }
    }

    public static boolean a(PushbackInputStream pushbackInputStream) {
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int i = 0;
        while (i < 2) {
            try {
                int read = pushbackInputStream.read(bArr, i, 2 - i);
                if (read < 0) {
                    return false;
                }
                i += read;
            } finally {
                pushbackInputStream.unread(bArr, 0, i);
            }
        }
        pushbackInputStream.unread(bArr, 0, i);
        return 35615 == ((bArr[0] & 255) | ((bArr[1] << 8) & 65280));
    }

    protected b a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, n nVar, Context context) {
        return new b(defaultHttpClient, httpContext, httpUriRequest, nVar);
    }

    public l a(Context context, String str, m mVar, n nVar) {
        return b(this.b, this.c, new f(a(this.j, str, mVar)), null, nVar, context);
    }

    public l a(Context context, String str, n nVar) {
        return a(context, str, null, nVar);
    }

    public l a(Context context, String str, Header[] headerArr, m mVar, n nVar) {
        HttpHead httpHead = new HttpHead(a(this.j, str, mVar));
        if (headerArr != null) {
            httpHead.setHeaders(headerArr);
        }
        return b(this.b, this.c, httpHead, null, nVar, context);
    }

    protected ClientConnectionManager a(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    protected ExecutorService a() {
        return Executors.newCachedThreadPool();
    }

    public void a(int i) {
        if (i < 1000) {
            i = 10000;
        }
        b(i);
        c(i);
    }

    public void a(boolean z) {
        a(z, z, z);
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.b.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !z2);
        this.b.getParams().setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, z3);
        this.b.setRedirectHandler(new i(z));
    }

    public l b(Context context, String str, Header[] headerArr, m mVar, n nVar) {
        f fVar = new f(a(this.j, str, mVar));
        if (headerArr != null) {
            fVar.setHeaders(headerArr);
        }
        return b(this.b, this.c, fVar, null, nVar, context);
    }

    protected l b(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, n nVar, Context context) {
        List<l> list;
        if (httpUriRequest != null) {
            if (nVar == null) {
                throw new IllegalArgumentException("ResponseHandler must not be null");
            }
            if (nVar.b() && !nVar.c()) {
                throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
            }
            if (str != null) {
                if (!(httpUriRequest instanceof HttpEntityEnclosingRequestBase) || ((HttpEntityEnclosingRequestBase) httpUriRequest).getEntity() == null || !httpUriRequest.containsHeader("Content-Type")) {
                    httpUriRequest.setHeader("Content-Type", str);
                } else {
                    a.c("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
                }
            }
            nVar.a(httpUriRequest.getAllHeaders());
            nVar.a(httpUriRequest.getURI());
            b a2 = a(defaultHttpClient, httpContext, httpUriRequest, str, nVar, context);
            this.i.submit(a2);
            l lVar = new l(a2);
            if (context != null) {
                synchronized (this.d) {
                    list = this.d.get(context);
                    if (list == null) {
                        list = Collections.synchronizedList(new LinkedList());
                        this.d.put(context, list);
                    }
                }
                list.add(lVar);
                Iterator<l> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().c()) {
                        it.remove();
                    }
                }
            }
            return lVar;
        }
        throw new IllegalArgumentException("HttpUriRequest must not be null");
    }

    public void b(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.g = i;
        HttpParams params = this.b.getParams();
        ConnManagerParams.setTimeout(params, this.g);
        HttpConnectionParams.setConnectionTimeout(params, this.g);
    }

    public void b(boolean z) {
        this.j = z;
    }

    public void c(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.h = i;
        HttpConnectionParams.setSoTimeout(this.b.getParams(), this.h);
    }
}
