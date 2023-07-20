package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.List;

@ThreadSafe
/* loaded from: classes.dex */
public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList httpRequestInterceptorList, HttpResponseInterceptorList httpResponseInterceptorList) {
        if (httpRequestInterceptorList != null) {
            int requestInterceptorCount = httpRequestInterceptorList.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i = 0; i < requestInterceptorCount; i++) {
                this.requestInterceptors[i] = httpRequestInterceptorList.getRequestInterceptor(i);
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorList == null) {
            this.responseInterceptors = new HttpResponseInterceptor[0];
            return;
        }
        int responseInterceptorCount = httpResponseInterceptorList.getResponseInterceptorCount();
        this.responseInterceptors = new HttpResponseInterceptor[responseInterceptorCount];
        for (int i2 = 0; i2 < responseInterceptorCount; i2++) {
            this.responseInterceptors[i2] = httpResponseInterceptorList.getResponseInterceptor(i2);
        }
    }

    public ImmutableHttpProcessor(List<HttpRequestInterceptor> list, List<HttpResponseInterceptor> list2) {
        this.requestInterceptors = list != null ? (HttpRequestInterceptor[]) list.toArray(new HttpRequestInterceptor[list.size()]) : new HttpRequestInterceptor[0];
        this.responseInterceptors = list2 != null ? (HttpResponseInterceptor[]) list2.toArray(new HttpResponseInterceptor[list2.size()]) : new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor... httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            this.requestInterceptors = new HttpRequestInterceptor[length];
            System.arraycopy(httpRequestInterceptorArr, 0, this.requestInterceptors, 0, length);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr == null) {
            this.responseInterceptors = new HttpResponseInterceptor[0];
            return;
        }
        int length2 = httpResponseInterceptorArr.length;
        this.responseInterceptors = new HttpResponseInterceptor[length2];
        System.arraycopy(httpResponseInterceptorArr, 0, this.responseInterceptors, 0, length2);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor... httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
            httpRequestInterceptor.process(httpRequest, httpContext);
        }
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors) {
            httpResponseInterceptor.process(httpResponse, httpContext);
        }
    }
}
