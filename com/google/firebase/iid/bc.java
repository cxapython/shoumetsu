package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc {
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[Catch: Throwable -> 0x00ab, TryCatch #6 {Throwable -> 0x00ab, blocks: (B:8:0x0047, B:10:0x004e, B:13:0x0056, B:21:0x0069, B:23:0x0071, B:24:0x0095), top: B:53:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: Throwable -> 0x00ba, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x00c4, blocks: (B:6:0x0039, B:16:0x0062, B:27:0x00a4, B:7:0x0043, B:15:0x005f, B:36:0x00b3, B:37:0x00b6, B:26:0x00a1), top: B:55:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: Throwable -> 0x00ba, TRY_ENTER, TryCatch #5 {IOException -> 0x00c4, blocks: (B:6:0x0039, B:16:0x0062, B:27:0x00a4, B:7:0x0043, B:15:0x005f, B:36:0x00b3, B:37:0x00b6, B:26:0x00a1), top: B:55:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final bb a(Context context, String str, bb bbVar, boolean z) {
        String b;
        String c;
        long j;
        Throwable th;
        Throwable th2;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to properties file");
        }
        Properties properties = new Properties();
        b = bbVar.b();
        properties.setProperty("pub", b);
        c = bbVar.c();
        properties.setProperty("pri", c);
        j = bbVar.b;
        properties.setProperty("cre", String.valueOf(j));
        File e = e(context, str);
        try {
            e.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(e, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            try {
                channel.lock();
                if (z && channel.size() > 0) {
                    try {
                        channel.position(0L);
                        bb a = a(channel);
                        if (channel != null) {
                            a((Throwable) null, channel);
                        }
                        a((Throwable) null, randomAccessFile);
                        return a;
                    } catch (d e2) {
                        e = e2;
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String valueOf = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 64);
                            sb.append("Tried reading key pair before writing new one, but failed with: ");
                            sb.append(valueOf);
                            Log.d("FirebaseInstanceId", sb.toString());
                        }
                        channel.position(0L);
                        properties.store(Channels.newOutputStream(channel), (String) null);
                        if (channel != null) {
                        }
                        a((Throwable) null, randomAccessFile);
                        return bbVar;
                    } catch (IOException e3) {
                        e = e3;
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        }
                        channel.position(0L);
                        properties.store(Channels.newOutputStream(channel), (String) null);
                        if (channel != null) {
                        }
                        a((Throwable) null, randomAccessFile);
                        return bbVar;
                    } catch (Throwable th3) {
                        th2 = th3;
                        th = null;
                        if (channel != null) {
                        }
                        throw th2;
                    }
                }
                channel.position(0L);
                properties.store(Channels.newOutputStream(channel), (String) null);
                if (channel != null) {
                    a((Throwable) null, channel);
                }
                a((Throwable) null, randomAccessFile);
                return bbVar;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    th = th4;
                    th2 = th5;
                    if (channel != null) {
                        a(th, channel);
                    }
                    throw th2;
                }
            }
        } catch (IOException e4) {
            String valueOf2 = String.valueOf(e4);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf2);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        }
    }

    private static bb a(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(y.a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(y.a(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new bb(a(string, string2), b(sharedPreferences, str));
    }

    private final bb a(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            channel.lock(0L, Long.MAX_VALUE, true);
            bb a = a(channel);
            if (channel != null) {
                a((Throwable) null, channel);
            }
            a((Throwable) null, fileInputStream);
            return a;
        } finally {
        }
    }

    private static bb a(FileChannel fileChannel) {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new d("Invalid properties file");
        }
        try {
            return new bb(a(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new d(e);
        }
    }

    private static KeyPair a(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new d(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        File[] listFiles;
        for (File file : b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private final void a(Context context, String str, bb bbVar) {
        String b;
        String c;
        long j;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (bbVar.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (d unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String a = y.a(str, "|P|");
        b = bbVar.b();
        edit.putString(a, b);
        String a2 = y.a(str, "|K|");
        c = bbVar.c();
        edit.putString(a2, c);
        String a3 = y.a(str, "cre");
        j = bbVar.b;
        edit.putString(a3, String.valueOf(j));
        edit.commit();
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, RandomAccessFile randomAccessFile) {
        if (th == null) {
            randomAccessFile.close();
            return;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable th2) {
            zzn.zza(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, FileChannel fileChannel) {
        if (th == null) {
            fileChannel.close();
            return;
        }
        try {
            fileChannel.close();
        } catch (Throwable th2) {
            zzn.zza(th, th2);
        }
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(y.a(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private static File b(Context context) {
        File a = androidx.core.a.a.a(context);
        if (a == null || !a.isDirectory()) {
            Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
            return context.getFilesDir();
        }
        return a;
    }

    private final bb c(Context context, String str) {
        bb d;
        try {
            d = d(context, str);
        } catch (d e) {
            e = e;
        }
        if (d != null) {
            a(context, str, d);
            return d;
        }
        e = null;
        try {
            bb a = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (a != null) {
                a(context, str, a, false);
                return a;
            }
        } catch (d e2) {
            e = e2;
        }
        if (e != null) {
            throw e;
        }
        return null;
    }

    private final bb d(Context context, String str) {
        File e = e(context, str);
        if (!e.exists()) {
            return null;
        }
        try {
            return a(e);
        } catch (d | IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            try {
                return a(e);
            } catch (IOException e3) {
                String valueOf2 = String.valueOf(e3);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new d(e3);
            }
        }
    }

    private static File e(Context context, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb2 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb2.append("com.google.InstanceId_");
                sb2.append(encodeToString);
                sb2.append(".properties");
                sb = sb2.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(b(context), sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final bb a(Context context, String str) {
        bb c = c(context, str);
        return c != null ? c : b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final bb b(Context context, String str) {
        bb bbVar = new bb(c.a(), System.currentTimeMillis());
        bb a = a(context, str, bbVar, true);
        if (a != null && !a.equals(bbVar)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
            }
            return a;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        a(context, str, bbVar);
        return bbVar;
    }
}
