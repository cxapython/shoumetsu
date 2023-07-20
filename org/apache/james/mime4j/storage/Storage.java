package org.apache.james.mime4j.storage;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface Storage {
    void delete();

    InputStream getInputStream();
}
