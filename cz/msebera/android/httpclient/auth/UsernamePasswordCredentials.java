package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

@Immutable
/* loaded from: classes.dex */
public class UsernamePasswordCredentials implements Credentials, Serializable {
    private static final long serialVersionUID = 243343858802739403L;
    private final String password;
    private final BasicUserPrincipal principal;

    public UsernamePasswordCredentials(String str) {
        String str2;
        Args.notNull(str, "Username:password string");
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.principal = new BasicUserPrincipal(str.substring(0, indexOf));
            str2 = str.substring(indexOf + 1);
        } else {
            this.principal = new BasicUserPrincipal(str);
            str2 = null;
        }
        this.password = str2;
    }

    public UsernamePasswordCredentials(String str, String str2) {
        Args.notNull(str, "Username");
        this.principal = new BasicUserPrincipal(str);
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UsernamePasswordCredentials) && LangUtils.equals(this.principal, ((UsernamePasswordCredentials) obj).principal);
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.principal.getName();
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public Principal getUserPrincipal() {
        return this.principal;
    }

    public int hashCode() {
        return this.principal.hashCode();
    }

    public String toString() {
        return this.principal.toString();
    }
}
