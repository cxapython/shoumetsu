package net.gree.gamelib.moderation.a;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.gree.gamelib.core.Core;
import org.json.JSONException;

/* loaded from: classes.dex */
public class d {
    protected static final String a = "kwlt";
    protected static final String b = "kwlt.tmp";
    protected Context c;

    public d(Context context) {
        this.c = context;
    }

    public synchronized c a() {
        c cVar;
        cVar = null;
        try {
            cVar = a(b());
        } catch (JSONException e) {
            e.printStackTrace();
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
                fileOutputStream.write(a.a(Long.parseLong(cVar.a())));
                fileOutputStream.write(b2.getBytes());
            }
            if (exists) {
                File fileStreamPath2 = this.c.getFileStreamPath(b);
                fileStreamPath2.renameTo(fileStreamPath);
                fileStreamPath2.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        a.a(fileOutputStream);
    }

    String b() {
        FileInputStream fileInputStream;
        Throwable th;
        if (!this.c.getFileStreamPath(a).exists()) {
            return new String();
        }
        try {
            fileInputStream = this.c.openFileInput(a);
        } catch (IOException e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            a.a(fileInputStream);
            throw th;
        }
        try {
            try {
                fileInputStream.read(new byte[8]);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                a.a(fileInputStream);
                return str;
            } catch (Throwable th3) {
                th = th3;
                a.a(fileInputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            a.a(fileInputStream);
            return null;
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
