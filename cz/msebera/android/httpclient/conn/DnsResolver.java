package cz.msebera.android.httpclient.conn;

import java.net.InetAddress;

/* loaded from: classes.dex */
public interface DnsResolver {
    InetAddress[] resolve(String str);
}
