package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.util.EntityUtils;

@Immutable
/* loaded from: classes.dex */
public class BasicResponseHandler extends AbstractResponseHandler<String> {
    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler
    public String handleEntity(HttpEntity httpEntity) {
        return EntityUtils.toString(httpEntity);
    }

    @Override // cz.msebera.android.httpclient.impl.client.AbstractResponseHandler, cz.msebera.android.httpclient.client.ResponseHandler
    /* renamed from: handleResponse  reason: collision with other method in class */
    public String mo35handleResponse(HttpResponse httpResponse) {
        return (String) super.mo35handleResponse(httpResponse);
    }
}
