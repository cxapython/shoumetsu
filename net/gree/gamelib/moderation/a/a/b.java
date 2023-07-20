package net.gree.gamelib.moderation.a.a;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    protected static final String a = "commit_list.dat";
    private Context b;

    public b(Context context) {
        this.b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0050 A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:5:0x000f, B:14:0x0035, B:30:0x0050, B:34:0x0058, B:35:0x005b), top: B:41:0x0001 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized JSONArray a() {
        Throwable th;
        FileInputStream fileInputStream;
        ?? r0 = this.b;
        ?? r1 = a;
        if (!r0.getFileStreamPath(r1).exists()) {
            return new JSONArray();
        }
        JSONArray jSONArray = null;
        try {
            try {
                fileInputStream = this.b.openFileInput(a);
            } catch (IOException e) {
                e = e;
                fileInputStream = null;
            } catch (JSONException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                r1 = 0;
                th = th2;
                net.gree.gamelib.moderation.a.a.a((Closeable) r1);
                throw th;
            }
            try {
                int available = fileInputStream.available();
                r1 = fileInputStream;
                if (available > 0) {
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr);
                    jSONArray = new JSONArray(new String(bArr));
                    r1 = fileInputStream;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                r1 = fileInputStream;
                net.gree.gamelib.moderation.a.a.a((Closeable) r1);
                if (jSONArray == null) {
                }
                return jSONArray;
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                r1 = fileInputStream;
                net.gree.gamelib.moderation.a.a.a((Closeable) r1);
                if (jSONArray == null) {
                }
                return jSONArray;
            }
            net.gree.gamelib.moderation.a.a.a((Closeable) r1);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            return jSONArray;
        } catch (Throwable th3) {
            th = th3;
            net.gree.gamelib.moderation.a.a.a((Closeable) r1);
            throw th;
        }
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            JSONArray a2 = a();
            try {
                a2.put(new JSONObject(aVar.toString()));
                a(a2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.b.openFileOutput(a, 0);
                    fileOutputStream.write(jSONArray.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                net.gree.gamelib.moderation.a.a.a(fileOutputStream);
            }
        }
    }

    public synchronized void b() {
        File fileStreamPath = this.b.getFileStreamPath(a);
        if (fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
    }

    public synchronized void b(JSONArray jSONArray) {
        boolean z;
        JSONArray a2 = a();
        JSONArray jSONArray2 = new JSONArray();
        int length = a2.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = a2.getJSONObject(i);
                String string = jSONObject.getString("timestamp");
                int length2 = jSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z = false;
                        break;
                    } else if (jSONArray.getJSONObject(i2).getString("timestamp").equals(string)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    jSONArray2.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a(jSONArray2);
    }
}
