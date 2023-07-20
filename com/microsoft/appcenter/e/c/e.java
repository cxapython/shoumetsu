package com.microsoft.appcenter.e.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public class e {
    static final d a = new d() { // from class: com.microsoft.appcenter.e.c.e.1
        @Override // com.microsoft.appcenter.e.c.e.d
        public InterfaceC0064e a(String str, String str2) {
            final KeyGenerator keyGenerator = KeyGenerator.getInstance(str, str2);
            return new InterfaceC0064e() { // from class: com.microsoft.appcenter.e.c.e.1.1
                @Override // com.microsoft.appcenter.e.c.e.InterfaceC0064e
                public void a() {
                    keyGenerator.generateKey();
                }

                @Override // com.microsoft.appcenter.e.c.e.InterfaceC0064e
                public void a(AlgorithmParameterSpec algorithmParameterSpec) {
                    keyGenerator.init(algorithmParameterSpec);
                }
            };
        }

        @Override // com.microsoft.appcenter.e.c.e.d
        public c b(String str, String str2) {
            final Cipher cipher = Cipher.getInstance(str, str2);
            return new c() { // from class: com.microsoft.appcenter.e.c.e.1.2
                @Override // com.microsoft.appcenter.e.c.e.c
                public void a(int i, Key key) {
                    cipher.init(i, key);
                }

                @Override // com.microsoft.appcenter.e.c.e.c
                public void a(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) {
                    cipher.init(i, key, algorithmParameterSpec);
                }

                @Override // com.microsoft.appcenter.e.c.e.c
                public byte[] a() {
                    return cipher.getIV();
                }

                @Override // com.microsoft.appcenter.e.c.e.c
                public byte[] a(byte[] bArr) {
                    return cipher.doFinal(bArr);
                }

                @Override // com.microsoft.appcenter.e.c.e.c
                public byte[] a(byte[] bArr, int i, int i2) {
                    return cipher.doFinal(bArr, i, i2);
                }

                @Override // com.microsoft.appcenter.e.c.e.c
                public int b() {
                    return cipher.getBlockSize();
                }
            };
        }
    };
    @SuppressLint({"StaticFieldLeak"})
    private static e c;
    final Map<String, a> b;
    private final Context d;
    private final d e;
    private final int f;
    private final KeyStore g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        final com.microsoft.appcenter.e.c.b a;
        int b;
        final int c;

        a(int i, int i2, com.microsoft.appcenter.e.c.b bVar) {
            this.b = i;
            this.c = i2;
            this.a = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        final String a;
        final String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    interface c {
        void a(int i, Key key);

        void a(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec);

        byte[] a();

        byte[] a(byte[] bArr);

        byte[] a(byte[] bArr, int i, int i2);

        int b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface d {
        InterfaceC0064e a(String str, String str2);

        c b(String str, String str2);
    }

    /* renamed from: com.microsoft.appcenter.e.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    interface InterfaceC0064e {
        void a();

        void a(AlgorithmParameterSpec algorithmParameterSpec);
    }

    private e(Context context) {
        this(context, a, Build.VERSION.SDK_INT);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @TargetApi(23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    e(Context context, d dVar, int i) {
        this.b = new LinkedHashMap();
        this.d = context.getApplicationContext();
        this.e = dVar;
        this.f = i;
        KeyStore keyStore = null;
        if (i >= 19) {
            try {
                KeyStore keyStore2 = KeyStore.getInstance("AndroidKeyStore");
                try {
                    keyStore2.load(null);
                    keyStore = keyStore2;
                } catch (Exception unused) {
                    keyStore = keyStore2;
                    com.microsoft.appcenter.e.a.e("AppCenter", "Cannot use secure keystore on this device.");
                    this.g = keyStore;
                    if (keyStore != null) {
                        try {
                            a(new com.microsoft.appcenter.e.c.a());
                        } catch (Exception unused2) {
                            com.microsoft.appcenter.e.a.e("AppCenter", "Cannot use modern encryption on this device.");
                        }
                    }
                    if (keyStore != null) {
                    }
                    com.microsoft.appcenter.e.c.c cVar = new com.microsoft.appcenter.e.c.c();
                    this.b.put(cVar.a(), new a(0, 0, cVar));
                }
            } catch (Exception unused3) {
            }
        }
        this.g = keyStore;
        if (keyStore != null && i >= 23) {
            a(new com.microsoft.appcenter.e.c.a());
        }
        if (keyStore != null) {
            try {
                a(new com.microsoft.appcenter.e.c.d());
            } catch (Exception unused4) {
                com.microsoft.appcenter.e.a.e("AppCenter", "Cannot use old encryption on this device.");
            }
        }
        com.microsoft.appcenter.e.c.c cVar2 = new com.microsoft.appcenter.e.c.c();
        this.b.put(cVar2.a(), new a(0, 0, cVar2));
    }

    private b a(com.microsoft.appcenter.e.c.b bVar, int i, String str, boolean z) {
        String str2 = new String(bVar.b(this.e, this.f, b(bVar, i, z), Base64.decode(str, 0)), "UTF-8");
        return new b(str2, bVar != this.b.values().iterator().next().a ? a(str2) : null);
    }

    public static e a(Context context) {
        if (c == null) {
            c = new e(context);
        }
        return c;
    }

    private String a(com.microsoft.appcenter.e.c.b bVar, int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "mobile.center" : "appcenter");
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(bVar.a());
        return sb.toString();
    }

    private KeyStore.Entry a(a aVar) {
        return b(aVar.a, aVar.b, false);
    }

    private void a(com.microsoft.appcenter.e.c.b bVar) {
        int i;
        int i2 = 0;
        String a2 = a(bVar, 0, false);
        String a3 = a(bVar, 1, false);
        String a4 = a(bVar, 0, true);
        String a5 = a(bVar, 1, true);
        Date creationDate = this.g.getCreationDate(a2);
        Date creationDate2 = this.g.getCreationDate(a3);
        Date creationDate3 = this.g.getCreationDate(a4);
        Date creationDate4 = this.g.getCreationDate(a5);
        if (creationDate2 == null || !creationDate2.after(creationDate)) {
            i = 0;
        } else {
            a2 = a3;
            i = 1;
        }
        if (creationDate4 != null && creationDate4.after(creationDate3)) {
            i2 = 1;
        }
        if (this.b.isEmpty() && !this.g.containsAlias(a2)) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Creating alias: " + a2);
            bVar.a(this.e, a2, this.d);
        }
        com.microsoft.appcenter.e.a.b("AppCenter", "Using " + a2);
        this.b.put(bVar.a(), new a(i, i2, bVar));
    }

    private KeyStore.Entry b(com.microsoft.appcenter.e.c.b bVar, int i, boolean z) {
        if (this.g == null) {
            return null;
        }
        return this.g.getEntry(a(bVar, i, z), null);
    }

    public b a(String str, boolean z) {
        if (str == null) {
            return new b(null, null);
        }
        String[] split = str.split(":");
        a aVar = split.length == 2 ? this.b.get(split[0]) : null;
        com.microsoft.appcenter.e.c.b bVar = aVar == null ? null : aVar.a;
        if (bVar == null) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Failed to decrypt data.");
            return new b(str, null);
        }
        try {
            try {
                return a(bVar, aVar.b, split[1], z);
            } catch (Exception unused) {
                com.microsoft.appcenter.e.a.e("AppCenter", "Failed to decrypt data.");
                return new b(str, null);
            }
        } catch (Exception unused2) {
            return a(bVar, aVar.b ^ 1, split[1], z);
        }
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            a next = this.b.values().iterator().next();
            com.microsoft.appcenter.e.c.b bVar = next.a;
            try {
                String encodeToString = Base64.encodeToString(bVar.a(this.e, this.f, a(next), str.getBytes("UTF-8")), 0);
                return bVar.a() + ":" + encodeToString;
            } catch (InvalidKeyException unused) {
                com.microsoft.appcenter.e.a.b("AppCenter", "Alias expired: " + next.b);
                next.b = next.b ^ 1;
                String a2 = a(bVar, next.b, false);
                if (this.g.containsAlias(a2)) {
                    com.microsoft.appcenter.e.a.b("AppCenter", "Deleting alias: " + a2);
                    this.g.deleteEntry(a2);
                }
                com.microsoft.appcenter.e.a.b("AppCenter", "Creating alias: " + a2);
                bVar.a(this.e, a2, this.d);
                return a(str);
            }
        } catch (Exception unused2) {
            com.microsoft.appcenter.e.a.e("AppCenter", "Failed to encrypt data.");
            return str;
        }
    }
}
