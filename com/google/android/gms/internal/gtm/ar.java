package com.google.android.gms.internal.gtm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
final class ar implements zzpc {
    private HttpURLConnection a;
    private InputStream b = null;

    @Override // com.google.android.gms.internal.gtm.zzpc
    public final void close() {
        HttpURLConnection httpURLConnection = this.a;
        try {
            if (this.b != null) {
                this.b.close();
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            com.google.android.gms.tagmanager.zzdi.zza(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzpc
    public final InputStream zzcj(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.a = httpURLConnection;
        HttpURLConnection httpURLConnection2 = this.a;
        int responseCode = httpURLConnection2.getResponseCode();
        if (responseCode == 200) {
            this.b = httpURLConnection2.getInputStream();
            return this.b;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Bad response: ");
        sb.append(responseCode);
        String sb2 = sb.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb2);
        }
        if (responseCode != 503) {
            throw new IOException(sb2);
        }
        throw new zzpe(sb2);
    }
}
