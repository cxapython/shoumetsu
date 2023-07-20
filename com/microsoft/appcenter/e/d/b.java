package com.microsoft.appcenter.e.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

/* loaded from: classes.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})
    private static Context a;

    public static File a(File file, FilenameFilter filenameFilter) {
        File file2 = null;
        if (file.exists()) {
            File[] listFiles = file.listFiles(filenameFilter);
            long j = 0;
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    if (file3.lastModified() > j) {
                        j = file3.lastModified();
                        file2 = file3;
                    }
                }
            }
        }
        return file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    public static String a(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String property = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                while (true) {
                    sb.append(readLine);
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(property);
                }
            }
            bufferedReader.close();
            file = sb.toString();
            return file;
        } catch (IOException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Could not read file " + file.getAbsolutePath(), e);
            return null;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (a == null) {
                a = context;
            }
        }
    }

    public static void a(File file, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.getTrimmedLength(str) <= 0) {
            return;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(str);
        } finally {
            bufferedWriter.close();
        }
    }

    public static void a(String str) {
        new File(str).mkdirs();
    }

    public static byte[] b(File file) {
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            new DataInputStream(fileInputStream).readFully(bArr);
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Could not read file " + file.getAbsolutePath(), e);
            return null;
        }
    }

    public static boolean c(File file) {
        return file.delete();
    }
}
