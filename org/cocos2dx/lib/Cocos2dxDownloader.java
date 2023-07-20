package org.cocos2dx.lib;

import com.c.a.a.l;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public class Cocos2dxDownloader {
    private static HashMap<String, Boolean> _resumingSupport = new HashMap<>();
    private int _countOfMaxProcessingTasks;
    private int _id;
    private String _tempFileNameSufix;
    private com.c.a.a.a _httpClient = new com.c.a.a.a();
    private HashMap _taskMap = new HashMap();
    private Queue<Runnable> _taskQueue = new LinkedList();
    private int _runningTaskCount = 0;

    public static void cancelAllRequests(Cocos2dxDownloader cocos2dxDownloader) {
        Cocos2dxHelper.getActivity().runOnUiThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxDownloader.4
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : Cocos2dxDownloader.this._taskMap.entrySet()) {
                    b bVar = (b) entry.getValue();
                    if (bVar.a != null) {
                        bVar.a.a(true);
                    }
                }
            }
        });
    }

    public static Cocos2dxDownloader createDownloader(int i, int i2, String str, int i3) {
        Cocos2dxDownloader cocos2dxDownloader = new Cocos2dxDownloader();
        cocos2dxDownloader._id = i;
        cocos2dxDownloader._httpClient.a(true);
        if (i2 > 0) {
            cocos2dxDownloader._httpClient.a(i2 * 1000);
        }
        com.c.a.a.a aVar = cocos2dxDownloader._httpClient;
        com.c.a.a.a.a(SSLException.class);
        cocos2dxDownloader._httpClient.b(false);
        cocos2dxDownloader._tempFileNameSufix = str;
        cocos2dxDownloader._countOfMaxProcessingTasks = i3;
        return cocos2dxDownloader;
    }

    public static void createTask(final Cocos2dxDownloader cocos2dxDownloader, final int i, final String str, final String str2) {
        cocos2dxDownloader.enqueueTask(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxDownloader.3
            @Override // java.lang.Runnable
            public void run() {
                l b;
                b bVar = new b();
                if (str2.length() == 0) {
                    bVar.b = new a(cocos2dxDownloader, i);
                    bVar.a = cocos2dxDownloader._httpClient.a(Cocos2dxHelper.getActivity(), str, bVar.b);
                }
                if (str2.length() != 0) {
                    try {
                        String host = new URI(str).getHost();
                        if (host.startsWith("www.")) {
                            host = host.substring(4);
                        }
                        String str3 = host;
                        Boolean bool = false;
                        Boolean bool2 = true;
                        if (Cocos2dxDownloader._resumingSupport.containsKey(str3)) {
                            bool = (Boolean) Cocos2dxDownloader._resumingSupport.get(str3);
                            bool2 = false;
                        }
                        if (bool2.booleanValue()) {
                            bVar.b = new d(cocos2dxDownloader, i, str3, str, str2);
                            b = cocos2dxDownloader._httpClient.a(Cocos2dxHelper.getActivity(), str, null, null, bVar.b);
                        } else {
                            File file = new File(str2 + cocos2dxDownloader._tempFileNameSufix);
                            if (!file.isDirectory()) {
                                File parentFile = file.getParentFile();
                                if (parentFile.isDirectory() || parentFile.mkdirs()) {
                                    File file2 = new File(str2);
                                    if (!file2.isDirectory()) {
                                        bVar.b = new c(cocos2dxDownloader, i, file, file2);
                                        Header[] headerArr = null;
                                        long length = file.length();
                                        if (bool.booleanValue() && length > 0) {
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(new BasicHeader("Range", "bytes=" + length + "-"));
                                            headerArr = (Header[]) arrayList.toArray(new Header[arrayList.size()]);
                                        } else if (length > 0) {
                                            try {
                                                PrintWriter printWriter = new PrintWriter(file);
                                                printWriter.print("");
                                                printWriter.close();
                                            } catch (FileNotFoundException unused) {
                                            }
                                        }
                                        b = cocos2dxDownloader._httpClient.b(Cocos2dxHelper.getActivity(), str, headerArr, null, bVar.b);
                                    }
                                }
                            }
                        }
                        bVar.a = b;
                    } catch (URISyntaxException unused2) {
                    }
                }
                if (bVar.a != null) {
                    cocos2dxDownloader._taskMap.put(Integer.valueOf(i), bVar);
                    return;
                }
                final String str4 = "Can't create DownloadTask for " + str;
                Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxDownloader.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cocos2dxDownloader.nativeOnFinish(cocos2dxDownloader._id, i, 0, str4, null);
                    }
                });
            }
        });
    }

    public static void setResumingSupport(String str, Boolean bool) {
        _resumingSupport.put(str, bool);
    }

    public void enqueueTask(Runnable runnable) {
        synchronized (this._taskQueue) {
            if (this._runningTaskCount < this._countOfMaxProcessingTasks) {
                Cocos2dxHelper.getActivity().runOnUiThread(runnable);
                this._runningTaskCount++;
            } else {
                this._taskQueue.add(runnable);
            }
        }
    }

    native void nativeOnFinish(int i, int i2, int i3, String str, byte[] bArr);

    native void nativeOnProgress(int i, int i2, long j, long j2, long j3);

    public void onFinish(final int i, final int i2, final String str, final byte[] bArr) {
        if (((b) this._taskMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        this._taskMap.remove(Integer.valueOf(i));
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxDownloader.2
            @Override // java.lang.Runnable
            public void run() {
                Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
                cocos2dxDownloader.nativeOnFinish(cocos2dxDownloader._id, i, i2, str, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProgress(final int i, final long j, final long j2, final long j3) {
        b bVar = (b) this._taskMap.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.c = j;
            bVar.d = j2;
            bVar.e = j3;
        }
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: org.cocos2dx.lib.Cocos2dxDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
                cocos2dxDownloader.nativeOnProgress(cocos2dxDownloader._id, i, j, j2, j3);
            }
        });
    }

    public void onStart(int i) {
        b bVar = (b) this._taskMap.get(Integer.valueOf(i));
        if (bVar != null) {
            bVar.a();
        }
    }

    public void runNextTaskIfExists() {
        synchronized (this._taskQueue) {
            Runnable poll = this._taskQueue.poll();
            if (poll != null) {
                Cocos2dxHelper.getActivity().runOnUiThread(poll);
            } else {
                this._runningTaskCount--;
            }
        }
    }
}
