package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFile;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: classes.dex */
public final class CrashUtils {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager b = null;
    private static boolean c = false;
    private static int d = -1;
    @GuardedBy("CrashUtils.class")
    private static int e = 0;
    @GuardedBy("CrashUtils.class")
    private static int f = 0;

    private static boolean a(Context context, Throwable th, int i) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }

    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        return a(context, th, DriveFile.MODE_WRITE_ONLY);
    }
}
