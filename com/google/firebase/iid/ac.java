package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac {
    private int a = 0;
    private final Map<Integer, TaskCompletionSource<Void>> b = new androidx.b.a();
    private final y c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.c = yVar;
    }

    private static boolean a(FirebaseInstanceId firebaseInstanceId, String str) {
        String str2;
        String str3;
        String[] split = str.split("!");
        if (split.length == 2) {
            String str4 = split[0];
            String str5 = split[1];
            char c = 65535;
            try {
                int hashCode = str4.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85 && str4.equals("U")) {
                        c = 1;
                    }
                } else if (str4.equals("S")) {
                    c = 0;
                }
                switch (c) {
                    case 0:
                        firebaseInstanceId.a(str5);
                        if (FirebaseInstanceId.e()) {
                            str2 = "FirebaseInstanceId";
                            str3 = "subscribe operation succeeded";
                            Log.d(str2, str3);
                            break;
                        }
                        break;
                    case 1:
                        firebaseInstanceId.b(str5);
                        if (FirebaseInstanceId.e()) {
                            str2 = "FirebaseInstanceId";
                            str3 = "unsubscribe operation succeeded";
                            Log.d(str2, str3);
                            break;
                        }
                        break;
                }
            } catch (IOException e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Topic sync failed: ".concat(valueOf) : new String("Topic sync failed: "));
                return false;
            }
        }
        return true;
    }

    private final synchronized boolean a(String str) {
        synchronized (this.c) {
            String a = this.c.a();
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (a.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                String valueOf3 = String.valueOf(",");
                String valueOf4 = String.valueOf(str);
                this.c.a(a.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length()));
                return true;
            }
            return false;
        }
    }

    private final String b() {
        String a;
        synchronized (this.c) {
            a = this.c.a();
        }
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split(",");
            if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                return split[1];
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a() {
        return b() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (com.google.firebase.iid.FirebaseInstanceId.e() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        android.util.Log.d("FirebaseInstanceId", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(FirebaseInstanceId firebaseInstanceId) {
        TaskCompletionSource<Void> remove;
        while (true) {
            synchronized (this) {
                String b = b();
                if (b == null) {
                    break;
                } else if (!a(firebaseInstanceId, b)) {
                    return false;
                } else {
                    synchronized (this) {
                        remove = this.b.remove(Integer.valueOf(this.a));
                        a(b);
                        this.a++;
                    }
                    if (remove != null) {
                        remove.setResult(null);
                    }
                }
            }
        }
    }
}
