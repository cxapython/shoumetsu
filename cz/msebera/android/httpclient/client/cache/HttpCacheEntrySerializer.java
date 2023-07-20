package cz.msebera.android.httpclient.client.cache;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface HttpCacheEntrySerializer {
    HttpCacheEntry readFrom(InputStream inputStream);

    void writeTo(HttpCacheEntry httpCacheEntry, OutputStream outputStream);
}
