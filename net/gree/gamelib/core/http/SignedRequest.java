package net.gree.gamelib.core.http;

import java.util.TreeMap;
import java.util.concurrent.Executor;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.a.c.d;
import net.gree.gamelib.core.a.i;

/* loaded from: classes.dex */
public class SignedRequest extends a {
    private d a = null;
    private i b = null;
    private TreeMap<String, String> c;

    private void a(HttpRequest httpRequest) {
        i iVar = this.b;
        if (iVar != null) {
            httpRequest.setHeader("User-Agent", iVar.b() == null ? DEFAULT_USER_AGENT : this.b.b());
            httpRequest.setHeader(net.gree.gamelib.core.a.b.a.e, net.gree.gamelib.core.a.b.a.a(Core.getVersion(), this.c, this.b.c(), this.b.d(), this.b.e(), this.b.f(), this.b.g()));
        }
    }

    public void addCustomValues(String str, String str2) {
        if (this.c == null) {
            this.c = new TreeMap<>();
        }
        this.c.put(str, str2);
    }

    @Override // net.gree.gamelib.core.http.a
    protected HttpResponse onPostRequest(HttpRequest httpRequest, HttpResponse httpResponse) {
        d dVar = this.a;
        return (dVar == null || dVar.a(httpRequest, httpResponse)) ? httpResponse : new HttpResponse(0, null, httpResponse.getEntity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.gree.gamelib.core.http.a
    public boolean onPreRequest(HttpRequest httpRequest) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(httpRequest);
        }
        a(httpRequest);
        return super.onPreRequest(httpRequest);
    }

    @Override // net.gree.gamelib.core.http.a
    public /* bridge */ /* synthetic */ void request(String str, String str2, ResponseListener responseListener) {
        super.request(str, str2, responseListener);
    }

    @Override // net.gree.gamelib.core.http.a
    public /* bridge */ /* synthetic */ void setEntity(String str) {
        super.setEntity(str);
    }

    @Override // net.gree.gamelib.core.http.a
    public /* bridge */ /* synthetic */ void setExecutor(Executor executor) {
        super.setExecutor(executor);
    }

    public void setSettings(i iVar) {
        this.b = iVar;
    }

    public void setSigner(d dVar) {
        this.a = dVar;
    }

    public String sign(String str) {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.a(str);
        }
        return null;
    }
}
