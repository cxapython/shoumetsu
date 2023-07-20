package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
class ca {
    private static ca a;
    private volatile a b = a.NONE;
    private volatile String d = null;
    private volatile String c = null;
    private volatile String e = null;

    /* loaded from: classes.dex */
    enum a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    ca() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ShowFirstParty
    public static ca a() {
        ca caVar;
        synchronized (ca.class) {
            if (a == null) {
                a = new ca();
            }
            caVar = a;
        }
        return caVar;
    }

    private static String a(String str) {
        return str.split("&")[0].split("=")[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                String valueOf = String.valueOf(decode);
                zzdi.zzab(valueOf.length() != 0 ? "Container preview url: ".concat(valueOf) : new String("Container preview url: "));
                this.b = decode.matches(".*?&gtm_debug=x$") ? a.CONTAINER_DEBUG : a.CONTAINER;
                this.e = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.b == a.CONTAINER || this.b == a.CONTAINER_DEBUG) {
                    String valueOf2 = String.valueOf("/r?");
                    String valueOf3 = String.valueOf(this.e);
                    this.d = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                }
                this.c = a(this.e);
                return true;
            } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                String valueOf4 = String.valueOf(decode);
                zzdi.zzac(valueOf4.length() != 0 ? "Invalid preview uri: ".concat(valueOf4) : new String("Invalid preview uri: "));
                return false;
            } else if (!a(uri.getQuery()).equals(this.c)) {
                return false;
            } else {
                String valueOf5 = String.valueOf(this.c);
                zzdi.zzab(valueOf5.length() != 0 ? "Exit preview mode for container: ".concat(valueOf5) : new String("Exit preview mode for container: "));
                this.b = a.NONE;
                this.d = null;
                return true;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.c;
    }
}
