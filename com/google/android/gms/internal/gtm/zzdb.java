package com.google.android.gms.internal.gtm;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
/* loaded from: classes.dex */
public final class zzdb {
    private static final Method b = b();
    private static final Method c = c();
    private static volatile zzdd d = al.a;
    private final JobScheduler a;

    private zzdb(JobScheduler jobScheduler) {
        this.a = jobScheduler;
    }

    private final int a(JobInfo jobInfo, String str, int i, String str2) {
        Method method = b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.a, jobInfo, str, Integer.valueOf(i), str2)).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.a.schedule(jobInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ boolean a() {
        return false;
    }

    private static Method b() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                    return null;
                }
                Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                return null;
            }
        }
        return null;
    }

    private static Method c() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    private static int d() {
        Method method = c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        return (b == null || !d.zzgo() || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(jobInfo) : new zzdb(jobScheduler).a(jobInfo, str, d(), str2);
    }
}
