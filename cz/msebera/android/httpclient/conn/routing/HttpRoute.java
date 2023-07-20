package cz.msebera.android.httpclient.conn.routing;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Immutable
/* loaded from: classes.dex */
public final class HttpRoute implements RouteInfo, Cloneable {
    private final RouteInfo.LayerType layered;
    private final InetAddress localAddress;
    private final List<HttpHost> proxyChain;
    private final boolean secure;
    private final HttpHost targetHost;
    private final RouteInfo.TunnelType tunnelled;

    public HttpRoute(HttpHost httpHost) {
        this(httpHost, (InetAddress) null, (List<HttpHost>) Collections.emptyList(), false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, HttpHost httpHost2) {
        this(httpHost, null, httpHost2, false);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean z) {
        this(httpHost, inetAddress, Collections.singletonList(Args.notNull(httpHost2, "Proxy host")), z, z ? RouteInfo.TunnelType.TUNNELLED : RouteInfo.TunnelType.PLAIN, z ? RouteInfo.LayerType.LAYERED : RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(httpHost, inetAddress, httpHost2 != null ? Collections.singletonList(httpHost2) : null, z, tunnelType, layerType);
    }

    private HttpRoute(HttpHost httpHost, InetAddress inetAddress, List<HttpHost> list, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        Args.notNull(httpHost, "Target host");
        this.targetHost = normalize(httpHost);
        this.localAddress = inetAddress;
        this.proxyChain = (list == null || list.isEmpty()) ? null : new ArrayList(list);
        if (tunnelType == RouteInfo.TunnelType.TUNNELLED) {
            Args.check(this.proxyChain != null, "Proxy required if tunnelled");
        }
        this.secure = z;
        this.tunnelled = tunnelType == null ? RouteInfo.TunnelType.PLAIN : tunnelType;
        this.layered = layerType == null ? RouteInfo.LayerType.PLAIN : layerType;
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, boolean z) {
        this(httpHost, inetAddress, Collections.emptyList(), z, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost[] httpHostArr, boolean z, RouteInfo.TunnelType tunnelType, RouteInfo.LayerType layerType) {
        this(httpHost, inetAddress, httpHostArr != null ? Arrays.asList(httpHostArr) : null, z, tunnelType, layerType);
    }

    private static int getDefaultPort(String str) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(str)) {
            return 80;
        }
        return Constants.SCHEME.equalsIgnoreCase(str) ? 443 : -1;
    }

    private static HttpHost normalize(HttpHost httpHost) {
        if (httpHost.getPort() >= 0) {
            return httpHost;
        }
        InetAddress address = httpHost.getAddress();
        String schemeName = httpHost.getSchemeName();
        return address != null ? new HttpHost(address, getDefaultPort(schemeName), schemeName) : new HttpHost(httpHost.getHostName(), getDefaultPort(schemeName), schemeName);
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRoute)) {
            return false;
        }
        HttpRoute httpRoute = (HttpRoute) obj;
        return this.secure == httpRoute.secure && this.tunnelled == httpRoute.tunnelled && this.layered == httpRoute.layered && LangUtils.equals(this.targetHost, httpRoute.targetHost) && LangUtils.equals(this.localAddress, httpRoute.localAddress) && LangUtils.equals(this.proxyChain, httpRoute.proxyChain);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final int getHopCount() {
        List<HttpHost> list = this.proxyChain;
        if (list != null) {
            return 1 + list.size();
        }
        return 1;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getHopTarget(int i) {
        Args.notNegative(i, "Hop index");
        int hopCount = getHopCount();
        Args.check(i < hopCount, "Hop index exceeds tracked route length");
        return i < hopCount - 1 ? this.proxyChain.get(i) : this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.LayerType getLayerType() {
        return this.layered;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final InetSocketAddress getLocalSocketAddress() {
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            return new InetSocketAddress(inetAddress, 0);
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getProxyHost() {
        List<HttpHost> list = this.proxyChain;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.proxyChain.get(0);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final RouteInfo.TunnelType getTunnelType() {
        return this.tunnelled;
    }

    public final int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        List<HttpHost> list = this.proxyChain;
        if (list != null) {
            for (HttpHost httpHost : list) {
                hashCode = LangUtils.hashCode(hashCode, httpHost);
            }
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(hashCode, this.secure), this.tunnelled), this.layered);
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isLayered() {
        return this.layered == RouteInfo.LayerType.LAYERED;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isSecure() {
        return this.secure;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.RouteInfo
    public final boolean isTunnelled() {
        return this.tunnelled == RouteInfo.TunnelType.TUNNELLED;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((getHopCount() * 30) + 50);
        InetAddress inetAddress = this.localAddress;
        if (inetAddress != null) {
            sb.append(inetAddress);
            sb.append("->");
        }
        sb.append('{');
        if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
            sb.append('t');
        }
        if (this.layered == RouteInfo.LayerType.LAYERED) {
            sb.append('l');
        }
        if (this.secure) {
            sb.append('s');
        }
        sb.append("}->");
        List<HttpHost> list = this.proxyChain;
        if (list != null) {
            for (HttpHost httpHost : list) {
                sb.append(httpHost);
                sb.append("->");
            }
        }
        sb.append(this.targetHost);
        return sb.toString();
    }
}
