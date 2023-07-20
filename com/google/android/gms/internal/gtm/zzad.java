package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzad extends zzan {
    private static boolean a;
    private AdvertisingIdClient.Info b;
    private final ai c;
    private String d;
    private boolean e;
    private final Object f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzap zzapVar) {
        super(zzapVar);
        this.e = false;
        this.f = new Object();
        this.c = new ai(zzapVar.zzcn());
    }

    private static String a(String str) {
        MessageDigest zzai = zzcz.zzai(Constants.MD5);
        if (zzai == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzai.digest(str.getBytes())));
    }

    private final boolean a(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzeh = m().zzeh();
        synchronized (this.f) {
            if (!this.e) {
                this.d = r();
                this.e = true;
            } else if (TextUtils.isEmpty(this.d)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    String valueOf = String.valueOf(id);
                    String valueOf2 = String.valueOf(zzeh);
                    return b(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                String valueOf3 = String.valueOf(str);
                String valueOf4 = String.valueOf(zzeh);
                this.d = a(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            }
            String valueOf5 = String.valueOf(id);
            String valueOf6 = String.valueOf(zzeh);
            String a2 = a(valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (a2.equals(this.d)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.d)) {
                zzq("Resetting the client id because Advertising Id changed.");
                zzeh = m().b();
                zza("New client Id", zzeh);
            }
            String valueOf7 = String.valueOf(id);
            String valueOf8 = String.valueOf(zzeh);
            return b(valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7));
        }
    }

    private final synchronized AdvertisingIdClient.Info b() {
        if (this.c.a(1000L)) {
            this.c.a();
            AdvertisingIdClient.Info c = c();
            if (!a(this.b, c)) {
                zzu("Failed to reset client id on adid change. Not using adid");
                c = new AdvertisingIdClient.Info("", false);
            }
            this.b = c;
        }
        return this.b;
    }

    private final boolean b(String str) {
        try {
            String a2 = a(str);
            zzq("Storing hashed adid.");
            FileOutputStream openFileOutput = e().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a2.getBytes());
            openFileOutput.close();
            this.d = a2;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private final AdvertisingIdClient.Info c() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(e());
        } catch (IllegalStateException unused) {
            zzt("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Exception e) {
            if (!a) {
                a = true;
                zzd("Error getting advertiser id", e);
            }
            return null;
        }
    }

    private final String r() {
        String str = null;
        try {
            FileInputStream openFileInput = e().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzt("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                e().deleteFile("gaClientIdData");
            } else if (read <= 0) {
                zzq("Hash file is empty.");
                openFileInput.close();
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException unused) {
                } catch (IOException e) {
                    e = e;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    e().deleteFile("gaClientIdData");
                    return str;
                }
                str = str2;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e2) {
            e = e2;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final boolean zzbw() {
        q();
        AdvertisingIdClient.Info b = b();
        return b != null && !b.isLimitAdTrackingEnabled();
    }

    public final String zzcd() {
        q();
        AdvertisingIdClient.Info b = b();
        String id = b != null ? b.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }
}
