package com.google.android.gms.tagmanager;

import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
final class dn implements Cdo {
    @Override // com.google.android.gms.tagmanager.Cdo
    public final HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }
}
