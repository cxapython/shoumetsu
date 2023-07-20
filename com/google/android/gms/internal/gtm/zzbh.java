package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class zzbh extends zzan {
    private volatile String a;
    private Future<String> b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbh(zzap zzapVar) {
        super(zzapVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String a(Context context) {
        FileInputStream fileInputStream;
        Preconditions.checkNotMainThread("ClientId should be loaded from worker thread");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = context.openFileInput("gaClientId");
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[36];
                int read = fileInputStream.read(bArr, 0, 36);
                if (fileInputStream.available() > 0) {
                    zzt("clientId file seems corrupted, deleting it.");
                    fileInputStream.close();
                    context.deleteFile("gaClientId");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            zze("Failed to close client id reading stream", e2);
                        }
                    }
                    return null;
                } else if (read < 14) {
                    zzt("clientId file is empty, deleting it.");
                    fileInputStream.close();
                    context.deleteFile("gaClientId");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            zze("Failed to close client id reading stream", e3);
                        }
                    }
                    return null;
                } else {
                    fileInputStream.close();
                    String str = new String(bArr, 0, read);
                    zza("Read client id from disk", str);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            zze("Failed to close client id reading stream", e4);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        zze("Failed to close client id reading stream", e5);
                    }
                }
                return null;
            } catch (IOException e6) {
                e = e6;
                zze("Error reading client id file, deleting it", e);
                context.deleteFile("gaClientId");
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        zze("Failed to close client id reading stream", e7);
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (IOException e8) {
                    zze("Failed to close client id reading stream", e8);
                }
            }
            throw th;
        }
    }

    private final boolean a(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                zza("Storing clientId", str);
                fileOutputStream = context.openFileOutput("gaClientId", 0);
                fileOutputStream.write(str.getBytes());
                if (fileOutputStream == null) {
                    return true;
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e) {
                    zze("Failed to close clientId writing stream", e);
                    return true;
                }
            } catch (FileNotFoundException e2) {
                zze("Error creating clientId file", e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        zze("Failed to close clientId writing stream", e3);
                    }
                }
                return false;
            } catch (IOException e4) {
                zze("Error writing to clientId file", e4);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        zze("Failed to close clientId writing stream", e5);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @VisibleForTesting
    public final String r() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !a(h().getContext(), lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        synchronized (this) {
            this.a = null;
            this.b = h().zza(new t(this));
        }
        return zzeh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String c() {
        String a = a(h().getContext());
        return a == null ? r() : a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0017, B:9:0x001b, B:16:0x003a, B:18:0x003e, B:19:0x0042, B:20:0x004c, B:21:0x004e, B:12:0x0027, B:13:0x002e, B:15:0x0032), top: B:26:0x0004, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzeh() {
        String str;
        q();
        synchronized (this) {
            if (this.a == null) {
                this.b = h().zza(new s(this));
            }
            if (this.b != null) {
                try {
                    try {
                        this.a = this.b.get();
                    } catch (InterruptedException e) {
                        zzd("ClientId loading or generation was interrupted", e);
                        str = "0";
                        this.a = str;
                        if (this.a == null) {
                        }
                        zza("Loaded clientId", this.a);
                        this.b = null;
                        return this.a;
                    }
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    str = "0";
                    this.a = str;
                    if (this.a == null) {
                    }
                    zza("Loaded clientId", this.a);
                    this.b = null;
                    return this.a;
                }
                if (this.a == null) {
                    this.a = "0";
                }
                zza("Loaded clientId", this.a);
                this.b = null;
            }
        }
        return this.a;
    }
}
