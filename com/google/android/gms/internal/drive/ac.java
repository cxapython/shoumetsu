package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes.dex */
final class ac implements DriveFile.DownloadProgressListener {
    private final ListenerHolder<DriveFile.DownloadProgressListener> a;

    public ac(ListenerHolder<DriveFile.DownloadProgressListener> listenerHolder) {
        this.a = listenerHolder;
    }

    @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
    public final void onProgress(long j, long j2) {
        this.a.notifyListener(new ad(this, j, j2));
    }
}
