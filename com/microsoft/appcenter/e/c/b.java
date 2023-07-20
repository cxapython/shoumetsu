package com.microsoft.appcenter.e.c;

import android.content.Context;
import com.microsoft.appcenter.e.c.e;
import java.security.KeyStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface b {
    String a();

    void a(e.d dVar, String str, Context context);

    byte[] a(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr);

    byte[] b(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr);
}
