package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.DnsResolver;
import java.net.InetAddress;

/* loaded from: classes.dex */
public class SystemDefaultDnsResolver implements DnsResolver {
    public static final SystemDefaultDnsResolver INSTANCE = new SystemDefaultDnsResolver();

    @Override // cz.msebera.android.httpclient.conn.DnsResolver
    public InetAddress[] resolve(String str) {
        return InetAddress.getAllByName(str);
    }
}
