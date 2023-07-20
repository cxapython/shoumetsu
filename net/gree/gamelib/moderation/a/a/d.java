package net.gree.gamelib.moderation.a.a;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import net.gree.gamelib.core.Core;
import org.json.JSONException;

/* loaded from: classes.dex */
public class d {
    protected static final String a = "restriction.dat";
    protected static final String b = "restriction.tmp";
    private Context c;
    private c d;

    public d(Context context) {
        this.c = context;
    }

    public synchronized c a() {
        c cVar;
        if (this.d != null) {
            cVar = this.d;
        } else {
            String b2 = b();
            c cVar2 = null;
            if (b2 == null) {
                return null;
            }
            try {
                cVar = a(b2);
            } catch (JSONException e) {
                e = e;
            }
            try {
                this.d = cVar;
            } catch (JSONException e2) {
                cVar2 = cVar;
                e = e2;
                e.printStackTrace();
                cVar = cVar2;
                return cVar;
            }
        }
        return cVar;
    }

    protected c a(String str) {
        if (str != null) {
            return new c(Core.descramble(str));
        }
        return null;
    }

    public synchronized void a(c cVar) {
        File fileStreamPath = this.c.getFileStreamPath(a);
        boolean exists = fileStreamPath.exists();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.c.openFileOutput(exists ? b : a, 0);
            String b2 = b(cVar);
            if (b2 != null) {
                fileOutputStream.write(b2.getBytes());
            }
            if (exists) {
                File fileStreamPath2 = this.c.getFileStreamPath(b);
                fileStreamPath2.renameTo(fileStreamPath);
                fileStreamPath2.delete();
            }
            this.d = cVar;
        } catch (IOException e) {
            e.printStackTrace();
        }
        net.gree.gamelib.moderation.a.a.a(fileOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    String b() {
        ?? exists = this.c.getFileStreamPath(a).exists();
        try {
            if (exists == 0) {
                return null;
            }
            try {
                exists = this.c.openFileInput(a);
            } catch (IOException e) {
                e = e;
                exists = 0;
            } catch (Throwable th) {
                th = th;
                exists = 0;
                net.gree.gamelib.moderation.a.a.a((Closeable) exists);
                throw th;
            }
            try {
                byte[] bArr = new byte[exists.available()];
                exists.read(bArr);
                String str = new String(bArr);
                net.gree.gamelib.moderation.a.a.a((Closeable) exists);
                return str;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                net.gree.gamelib.moderation.a.a.a((Closeable) exists);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected String b(c cVar) {
        if (cVar != null) {
            return Core.scramble(cVar.toString());
        }
        return null;
    }

    public synchronized void c() {
        File fileStreamPath = this.c.getFileStreamPath(a);
        if (fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
    }
}
