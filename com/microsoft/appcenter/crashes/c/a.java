package com.microsoft.appcenter.crashes.c;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.microsoft.appcenter.crashes.a.a.c;
import com.microsoft.appcenter.crashes.a.a.e;
import com.microsoft.appcenter.crashes.a.a.g;
import com.microsoft.appcenter.e.b;
import com.microsoft.appcenter.e.b.f;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class a {
    private static File a;
    private static File b;
    private static File c;

    public static c a(Throwable th) {
        LinkedList<Throwable> linkedList = new LinkedList();
        while (th != null) {
            linkedList.add(th);
            th = th.getCause();
        }
        if (linkedList.size() > 16) {
            com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Crash causes truncated from " + linkedList.size() + " to 16 causes.");
            linkedList.subList(8, linkedList.size() - 8).clear();
        }
        c cVar = null;
        c cVar2 = null;
        for (Throwable th2 : linkedList) {
            c cVar3 = new c();
            cVar3.a(th2.getClass().getName());
            cVar3.b(th2.getMessage());
            cVar3.a(b(th2));
            if (cVar == null) {
                cVar = cVar3;
            } else {
                cVar2.b(Collections.singletonList(cVar3));
            }
            cVar2 = cVar3;
        }
        return cVar;
    }

    public static e a(Context context, Thread thread, c cVar, Map<Thread, StackTraceElement[]> map, long j, boolean z) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        e eVar = new e();
        eVar.a(UUID.randomUUID());
        eVar.b(new Date());
        eVar.f(f.a().b());
        try {
            eVar.a(b.a(context));
        } catch (b.a e) {
            com.microsoft.appcenter.e.a.b("AppCenterCrashes", "Could not attach device properties snapshot to error log, will attach at sending time", e);
        }
        eVar.a(Integer.valueOf(Process.myPid()));
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    eVar.a(runningAppProcessInfo.processName);
                }
            }
        }
        if (eVar.d() == null) {
            eVar.a("");
        }
        eVar.d(g());
        eVar.a(Long.valueOf(thread.getId()));
        eVar.c(thread.getName());
        eVar.a(Boolean.valueOf(z));
        eVar.a(new Date(j));
        eVar.a(cVar);
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            g gVar = new g();
            gVar.a(entry.getKey().getId());
            gVar.a(entry.getKey().getName());
            gVar.a(a(entry.getValue()));
            arrayList.add(gVar);
        }
        eVar.a((List<g>) arrayList);
        return eVar;
    }

    private static com.microsoft.appcenter.crashes.a.a.f a(StackTraceElement stackTraceElement) {
        com.microsoft.appcenter.crashes.a.a.f fVar = new com.microsoft.appcenter.crashes.a.a.f();
        fVar.a(stackTraceElement.getClassName());
        fVar.b(stackTraceElement.getMethodName());
        fVar.a(Integer.valueOf(stackTraceElement.getLineNumber()));
        fVar.c(stackTraceElement.getFileName());
        return fVar;
    }

    public static com.microsoft.appcenter.crashes.b.a a(e eVar, String str) {
        com.microsoft.appcenter.crashes.b.a aVar = new com.microsoft.appcenter.crashes.b.a();
        aVar.a(eVar.b().toString());
        aVar.b(eVar.h());
        aVar.c(str);
        aVar.a(eVar.j());
        aVar.b(eVar.n());
        aVar.a(eVar.r());
        return aVar;
    }

    public static synchronized File a() {
        File file;
        synchronized (a.class) {
            if (a == null) {
                a = new File(com.microsoft.appcenter.f.a, "error");
                com.microsoft.appcenter.e.d.b.a(a.getAbsolutePath());
            }
            file = a;
        }
        return file;
    }

    public static File a(UUID uuid) {
        return a(uuid, ".throwable");
    }

    private static File a(final UUID uuid, final String str) {
        File[] listFiles = a().listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.c.a.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.startsWith(uuid.toString()) && str2.endsWith(str);
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        return listFiles[0];
    }

    private static List<com.microsoft.appcenter.crashes.a.a.f> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(a(stackTraceElement));
        }
        return arrayList;
    }

    public static synchronized File b() {
        File file;
        synchronized (a.class) {
            if (b == null) {
                b = new File(new File(a().getAbsolutePath(), "minidump"), "new");
                com.microsoft.appcenter.e.d.b.a(b.getPath());
            }
            file = b;
        }
        return file;
    }

    private static List<com.microsoft.appcenter.crashes.a.a.f> b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace.length > 256) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[256];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, 128);
            System.arraycopy(stackTrace, stackTrace.length - 128, stackTraceElementArr, 128, 128);
            th.setStackTrace(stackTraceElementArr);
            com.microsoft.appcenter.e.a.d("AppCenterCrashes", "Crash frames truncated from " + stackTrace.length + " to " + stackTraceElementArr.length + " frames.");
            stackTrace = stackTraceElementArr;
        }
        return a(stackTrace);
    }

    public static void b(UUID uuid) {
        File a2 = a(uuid);
        if (a2 != null) {
            com.microsoft.appcenter.e.a.c("AppCenterCrashes", "Deleting throwable file " + a2.getName());
            com.microsoft.appcenter.e.d.b.c(a2);
        }
    }

    public static synchronized File c() {
        File file;
        synchronized (a.class) {
            if (c == null) {
                c = new File(new File(a().getAbsolutePath(), "minidump"), "pending");
                com.microsoft.appcenter.e.d.b.a(c.getPath());
            }
            file = c;
        }
        return file;
    }

    static File c(UUID uuid) {
        return a(uuid, ".json");
    }

    public static void d(UUID uuid) {
        File c2 = c(uuid);
        if (c2 != null) {
            com.microsoft.appcenter.e.a.c("AppCenterCrashes", "Deleting error log file " + c2.getName());
            com.microsoft.appcenter.e.d.b.c(c2);
        }
    }

    public static File[] d() {
        File[] listFiles = a().listFiles(new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.c.a.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
        return listFiles != null ? listFiles : new File[0];
    }

    public static File[] e() {
        File[] listFiles = b().listFiles();
        return listFiles != null ? listFiles : new File[0];
    }

    public static File f() {
        return com.microsoft.appcenter.e.d.b.a(a(), new FilenameFilter() { // from class: com.microsoft.appcenter.crashes.c.a.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".json");
            }
        });
    }

    @TargetApi(21)
    private static String g() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS[0] : Build.CPU_ABI;
    }
}
