package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.util.Args;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        this.local = (HttpParams) Args.notNull(httpParams, "Local HTTP parameters");
        this.defaults = httpParams2;
    }

    private Set<String> getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    @Override // cz.msebera.android.httpclient.params.AbstractHttpParams, cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        HashSet hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public Object getParameter(String str) {
        HttpParams httpParams;
        Object parameter = this.local.getParameter(str);
        return (parameter != null || (httpParams = this.defaults) == null) ? parameter : httpParams.getParameter(str);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }
}
