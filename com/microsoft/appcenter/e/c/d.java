package com.microsoft.appcenter.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import com.microsoft.appcenter.e.c.e;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements b {
    private e.c a(e.d dVar, int i) {
        return dVar.b("RSA/ECB/PKCS1Padding", i >= 23 ? "AndroidKeyStoreBCWorkaround" : "AndroidOpenSSL");
    }

    @Override // com.microsoft.appcenter.e.c.b
    public String a() {
        return "RSA/ECB/PKCS1Padding/2048";
    }

    @Override // com.microsoft.appcenter.e.c.b
    @SuppressLint({"InlinedApi", "TrulyRandom"})
    public void a(e.d dVar, String str, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, 1);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(context).setAlias(str);
        keyPairGenerator.initialize(alias.setSubject(new X500Principal("CN=" + str)).setStartDate(new Date()).setEndDate(calendar.getTime()).setSerialNumber(BigInteger.TEN).setKeySize(2048).build());
        keyPairGenerator.generateKeyPair();
    }

    @Override // com.microsoft.appcenter.e.c.b
    public byte[] a(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr) {
        e.c a = a(dVar, i);
        X509Certificate x509Certificate = (X509Certificate) ((KeyStore.PrivateKeyEntry) entry).getCertificate();
        try {
            x509Certificate.checkValidity();
            a.a(1, x509Certificate.getPublicKey());
            return a.a(bArr);
        } catch (CertificateExpiredException e) {
            throw new InvalidKeyException(e);
        }
    }

    @Override // com.microsoft.appcenter.e.c.b
    public byte[] b(e.d dVar, int i, KeyStore.Entry entry, byte[] bArr) {
        e.c a = a(dVar, i);
        a.a(2, ((KeyStore.PrivateKeyEntry) entry).getPrivateKey());
        return a.a(bArr);
    }
}
