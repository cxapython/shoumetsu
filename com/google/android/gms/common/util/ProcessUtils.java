package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
/* loaded from: classes.dex */
public class ProcessUtils {
    private static String a;
    private static int b;

    private ProcessUtils() {
    }

    private static BufferedReader a(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @Nullable
    private static String a(int i) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = a(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
            } catch (IOException unused) {
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                IOUtils.closeQuietly(bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        IOUtils.closeQuietly(bufferedReader);
        return str;
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            a = a(b);
        }
        return a;
    }
}
