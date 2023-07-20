package androidx.core.app;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {
    private final String a;
    private final CharSequence b;
    private final CharSequence[] c;
    private final boolean d;
    private final Bundle e;
    private final Set<String> f;

    static RemoteInput a(i iVar) {
        return new RemoteInput.Builder(iVar.a()).setLabel(iVar.b()).setChoices(iVar.c()).setAllowFreeFormInput(iVar.e()).addExtras(iVar.f()).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] a(i[] iVarArr) {
        if (iVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            remoteInputArr[i] = a(iVarArr[i]);
        }
        return remoteInputArr;
    }

    public String a() {
        return this.a;
    }

    public CharSequence b() {
        return this.b;
    }

    public CharSequence[] c() {
        return this.c;
    }

    public Set<String> d() {
        return this.f;
    }

    public boolean e() {
        return this.d;
    }

    public Bundle f() {
        return this.e;
    }
}
