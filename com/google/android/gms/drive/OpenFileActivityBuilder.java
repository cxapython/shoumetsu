package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzeo;
import com.google.android.gms.internal.drive.zzgg;

@Deprecated
/* loaded from: classes.dex */
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String a;
    private String[] b;
    private Filter c;
    private DriveId d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[] b() {
        return this.b;
    }

    public IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        e();
        Filter filter = this.c;
        try {
            return ((zzeo) ((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY)).getService()).zza(new zzgg(this.a, this.b, this.d, filter == null ? null : new FilterHolder(filter)));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Filter c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DriveId d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (this.b == null) {
            this.b = new String[0];
        }
        if (this.b.length <= 0 || this.c == null) {
            return;
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.d = (DriveId) Preconditions.checkNotNull(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.a = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        Preconditions.checkArgument(strArr != null, "mimeTypes may not be null");
        this.b = strArr;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        Preconditions.checkArgument(filter != null, "filter may not be null");
        Preconditions.checkArgument(true ^ com.google.android.gms.drive.query.internal.zzk.zza(filter), "FullTextSearchFilter cannot be used as a selection filter");
        this.c = filter;
        return this;
    }
}
