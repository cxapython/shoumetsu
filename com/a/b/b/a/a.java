package com.a.b.b.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.Vector;

/* loaded from: classes.dex */
public class a {
    public static b a(String[] strArr) {
        b bVar = null;
        for (String str : strArr) {
            if (bVar == null) {
                bVar = new b(str);
            } else {
                bVar.b(str);
            }
        }
        return bVar;
    }

    static String[] a(Context context, int i, int i2) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory.toString() + "/Android/obb/" + packageName);
            if (file.exists()) {
                if (i > 0) {
                    String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                    if (new File(str).isFile()) {
                        vector.add(str);
                    }
                }
                if (i2 > 0) {
                    String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                    if (new File(str2).isFile()) {
                        vector.add(str2);
                    }
                }
            }
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public static b b(Context context, int i, int i2) {
        return a(a(context, i, i2));
    }
}
