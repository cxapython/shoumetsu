package com.microsoft.appcenter.e.c;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import com.microsoft.appcenter.e.c.e;
import java.security.KeyStore;
import java.util.Calendar;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.microsoft.appcenter.e.c.b
    public String a() {
        return "AES/CBC/PKCS7Padding/256";
    }

    @Override // com.microsoft.appcenter.e.c.b
    public void a(e.d dVar, String str, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, 1);
        e.InterfaceC0064e a = dVar.a("AES", "AndroidKeyStore");
        a.a(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).setKeyValidityForOriginationEnd(calendar.getTime()).build());
        a.a();
    }

    @Override // com.microsoft.appcenter.e.c.b
    public byte[] a(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr) {
        e.c b = dVar.b("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        b.a(1, ((KeyStore.SecretKeyEntry) entry).getSecretKey());
        byte[] a = b.a();
        byte[] a2 = b.a(bArr);
        byte[] bArr2 = new byte[a.length + a2.length];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(a2, 0, bArr2, a.length, a2.length);
        return bArr2;
    }

    @Override // com.microsoft.appcenter.e.c.b
    public byte[] b(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr) {
        e.c b = dVar.b("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        int b2 = b.b();
        b.a(2, ((KeyStore.SecretKeyEntry) entry).getSecretKey(), new IvParameterSpec(bArr, 0, b2));
        return b.a(bArr, b2, bArr.length - b2);
    }
}
