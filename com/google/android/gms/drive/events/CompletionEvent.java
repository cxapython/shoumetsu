package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhp;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "CompletionEventCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    @SafeParcelable.Field(id = 2)
    private final DriveId b;
    @SafeParcelable.Field(id = 3)
    private final String c;
    @SafeParcelable.Field(id = 4)
    private final ParcelFileDescriptor d;
    @SafeParcelable.Field(id = 5)
    private final ParcelFileDescriptor e;
    @SafeParcelable.Field(id = 6)
    private final MetadataBundle f;
    @SafeParcelable.Field(id = 7)
    private final List<String> g;
    @SafeParcelable.Field(id = 8)
    private final int h;
    @SafeParcelable.Field(id = 9)
    private final IBinder i;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private static final GmsLogger a = new GmsLogger("CompletionEvent", "");
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zzg();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CompletionEvent(@SafeParcelable.Param(id = 2) DriveId driveId, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) ParcelFileDescriptor parcelFileDescriptor2, @SafeParcelable.Param(id = 6) MetadataBundle metadataBundle, @SafeParcelable.Param(id = 7) List<String> list, @SafeParcelable.Param(id = 8) int i, @SafeParcelable.Param(id = 9) IBinder iBinder) {
        this.b = driveId;
        this.c = str;
        this.d = parcelFileDescriptor;
        this.e = parcelFileDescriptor2;
        this.f = metadataBundle;
        this.g = list;
        this.h = i;
        this.i = iBinder;
    }

    private final void a() {
        if (!this.l) {
            return;
        }
        throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }

    private final void a(boolean z) {
        a();
        this.l = true;
        IOUtils.closeQuietly(this.d);
        IOUtils.closeQuietly(this.e);
        MetadataBundle metadataBundle = this.f;
        if (metadataBundle != null && metadataBundle.zzd(zzhp.zzka)) {
            ((BitmapTeleporter) this.f.zza(zzhp.zzka)).release();
        }
        IBinder iBinder = this.i;
        if (iBinder == null) {
            a.efmt("CompletionEvent", "No callback on %s", z ? "snooze" : "dismiss");
            return;
        }
        try {
            zzev.zza(iBinder).zza(z);
        } catch (RemoteException e) {
            a.e("CompletionEvent", String.format("RemoteException on %s", z ? "snooze" : "dismiss"), e);
        }
    }

    public final void dismiss() {
        a(false);
    }

    public final String getAccountName() {
        a();
        return this.c;
    }

    public final InputStream getBaseContentsInputStream() {
        a();
        ParcelFileDescriptor parcelFileDescriptor = this.d;
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (this.j) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.j = true;
        return new FileInputStream(parcelFileDescriptor.getFileDescriptor());
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        a();
        return this.b;
    }

    public final InputStream getModifiedContentsInputStream() {
        a();
        ParcelFileDescriptor parcelFileDescriptor = this.e;
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (this.k) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.k = true;
        return new FileInputStream(parcelFileDescriptor.getFileDescriptor());
    }

    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        a();
        MetadataBundle metadataBundle = this.f;
        if (metadataBundle != null) {
            return new MetadataChangeSet(metadataBundle);
        }
        return null;
    }

    public final int getStatus() {
        a();
        return this.h;
    }

    public final List<String> getTrackingTags() {
        a();
        return new ArrayList(this.g);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 2;
    }

    public final void snooze() {
        a(true);
    }

    public final String toString() {
        String sb;
        List<String> list = this.g;
        if (list == null) {
            sb = "<null>";
        } else {
            String join = TextUtils.join("','", list);
            StringBuilder sb2 = new StringBuilder(String.valueOf(join).length() + 2);
            sb2.append("'");
            sb2.append(join);
            sb2.append("'");
            sb = sb2.toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.b, Integer.valueOf(this.h), sb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.e, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i2, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.g, false);
        SafeParcelWriter.writeInt(parcel, 8, this.h);
        SafeParcelWriter.writeIBinder(parcel, 9, this.i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
