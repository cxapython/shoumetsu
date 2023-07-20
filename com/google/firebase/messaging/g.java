package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzj;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.internal.firebase_messaging.zzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Closeable {
    private final URL a;
    private Task<Bitmap> b;
    private volatile InputStream c;

    private g(URL url) {
        this.a = url;
    }

    public static g a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            zzn.zza(th, th2);
        }
    }

    public final Task<Bitmap> a() {
        return (Task) Preconditions.checkNotNull(this.b);
    }

    public final void a(Executor executor) {
        this.b = Tasks.call(executor, new Callable(this) { // from class: com.google.firebase.messaging.h
            private final g a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    public final Bitmap b() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        try {
            InputStream inputStream = this.a.openConnection().getInputStream();
            InputStream zza = zzj.zza(inputStream, 1048576L);
            this.c = inputStream;
            Bitmap decodeStream = BitmapFactory.decodeStream(zza);
            if (decodeStream == null) {
                String valueOf2 = String.valueOf(this.a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
                sb2.append("Failed to decode image: ");
                sb2.append(valueOf2);
                String sb3 = sb2.toString();
                Log.w("FirebaseMessaging", sb3);
                throw new IOException(sb3);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf3 = String.valueOf(this.a);
                StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf3).length() + 31);
                sb4.append("Successfully downloaded image: ");
                sb4.append(valueOf3);
                Log.d("FirebaseMessaging", sb4.toString());
            }
            a(null, zza);
            if (inputStream != null) {
                a(null, inputStream);
            }
            return decodeStream;
        } catch (IOException e) {
            String valueOf4 = String.valueOf(this.a);
            StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf4).length() + 26);
            sb5.append("Failed to download image: ");
            sb5.append(valueOf4);
            Log.w("FirebaseMessaging", sb5.toString());
            throw e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzk.zza(this.c);
    }
}
