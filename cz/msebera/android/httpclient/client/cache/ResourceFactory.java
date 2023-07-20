package cz.msebera.android.httpclient.client.cache;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface ResourceFactory {
    Resource copy(String str, Resource resource);

    Resource generate(String str, InputStream inputStream, InputLimit inputLimit);
}
