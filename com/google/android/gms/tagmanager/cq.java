package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzop;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.internal.gtm.zzuv;
import com.google.android.gms.internal.gtm.zzuw;
import com.google.android.gms.tagmanager.ca;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cq implements h {
    private final Context a;
    private final String b;
    private final ExecutorService c = zzdf.zzgp().zzr(com.google.android.gms.internal.gtm.zzdi.zzadg);
    private bc<zzop> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static zzov a(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return aw.a(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            zzdi.zzax("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException unused2) {
            zzdi.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private static zzov a(byte[] bArr) {
        try {
            zzov zza = zzor.zza((zzi) zzuw.zza(new zzi(), bArr));
            if (zza != null) {
                zzdi.zzab("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        } catch (zzoz unused) {
            zzdi.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzuv unused2) {
            zzdi.zzav("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @VisibleForTesting
    private final File c() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.b);
        return new File(this.a.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    @Override // com.google.android.gms.tagmanager.h
    public final zzov a(int i) {
        String sb;
        InputStream openRawResource;
        try {
            openRawResource = this.a.getResources().openRawResource(i);
            String resourceName = this.a.getResources().getResourceName(i);
            StringBuilder sb2 = new StringBuilder(String.valueOf(resourceName).length() + 66);
            sb2.append("Attempting to load a container from the resource ID ");
            sb2.append(i);
            sb2.append(" (");
            sb2.append(resourceName);
            sb2.append(")");
            zzdi.zzab(sb2.toString());
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(98);
            sb3.append("Failed to load the container. No default container resource found with the resource ID ");
            sb3.append(i);
            sb = sb3.toString();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zzor.zza(openRawResource, byteArrayOutputStream);
            zzov a = a(byteArrayOutputStream);
            if (a == null) {
                return a(byteArrayOutputStream.toByteArray());
            }
            zzdi.zzab("The container was successfully loaded from the resource (using JSON file format)");
            return a;
        } catch (IOException unused2) {
            String resourceName2 = this.a.getResources().getResourceName(i);
            StringBuilder sb4 = new StringBuilder(String.valueOf(resourceName2).length() + 67);
            sb4.append("Error reading the default container with resource ID ");
            sb4.append(i);
            sb4.append(" (");
            sb4.append(resourceName2);
            sb4.append(")");
            sb = sb4.toString();
            zzdi.zzac(sb);
            return null;
        }
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a() {
        this.c.execute(new cr(this));
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a(zzop zzopVar) {
        this.c.execute(new cs(this, zzopVar));
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a(bc<zzop> bcVar) {
        this.d = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void b() {
        bc<zzop> bcVar = this.d;
        if (bcVar != null) {
            bcVar.a();
            zzdi.zzab("Attempting to load resource from disk");
            if ((ca.a().b() == ca.a.CONTAINER || ca.a().b() == ca.a.CONTAINER_DEBUG) && this.b.equals(ca.a().d())) {
                this.d.a(zzcz.zzaht);
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(c());
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        zzor.zza(fileInputStream, byteArrayOutputStream);
                        zzop zzopVar = (zzop) zzuw.zza(new zzop(), byteArrayOutputStream.toByteArray());
                        if (zzopVar.zzqk == null && zzopVar.zzauy == null) {
                            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
                        }
                        this.d.a((bc<zzop>) zzopVar);
                    } catch (IOException unused) {
                        this.d.a(zzcz.zzahu);
                        zzdi.zzac("Failed to read the resource from disk");
                    } catch (IllegalArgumentException unused2) {
                        this.d.a(zzcz.zzahu);
                        zzdi.zzac("Failed to read the resource from disk. The resource is inconsistent");
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                        zzdi.zzac("Error closing stream for reading resource from disk");
                    }
                    zzdi.zzab("The Disk resource was successfully read.");
                    return;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                        zzdi.zzac("Error closing stream for reading resource from disk");
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
                zzdi.zzax("Failed to find the resource in the disk");
                this.d.a(zzcz.zzaht);
                return;
            }
        }
        throw new IllegalStateException("Callback must be set before execute");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean b(zzop zzopVar) {
        FileOutputStream fileOutputStream;
        File c = c();
        try {
            try {
                fileOutputStream = new FileOutputStream(c);
                try {
                    byte[] bArr = new byte[zzopVar.zzpe()];
                    zzuw.zza(zzopVar, bArr, 0, bArr.length);
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused) {
                        zzdi.zzac("error closing stream for writing resource to disk");
                        return true;
                    }
                } catch (IOException unused2) {
                    zzdi.zzac("Error writing resource to disk. Removing resource from disk.");
                    c.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzdi.zzac("error closing stream for writing resource to disk");
                    }
                    return false;
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzdi.zzac("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzdi.zzav("Error opening resource file for writing");
            return false;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        this.c.shutdown();
    }
}
