package com.c.a.a;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes.dex */
public abstract class d extends c {
    private String[] a;

    public d(String[] strArr) {
        this.a = new String[]{"application/octet-stream", "image/jpeg", "image/png", "image/gif"};
        if (strArr != null) {
            this.a = strArr;
        } else {
            a.a.d("BinaryHttpRH", "Constructor passed allowedContentTypes was null !");
        }
    }

    @Override // com.c.a.a.c, com.c.a.a.n
    public final void a(HttpResponse httpResponse) {
        String[] j;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        Header header = headers[0];
        boolean z = false;
        for (String str : j()) {
            try {
                if (Pattern.matches(str, header.getValue())) {
                    z = true;
                }
            } catch (PatternSyntaxException e) {
                a.a.b("BinaryHttpRH", "Given pattern is not valid: " + str, e);
            }
        }
        if (z) {
            super.a(httpResponse);
            return;
        }
        b(statusLine.getStatusCode(), httpResponse.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), "Content-Type (" + header.getValue() + ") not allowed!"));
    }

    public String[] j() {
        return this.a;
    }
}
