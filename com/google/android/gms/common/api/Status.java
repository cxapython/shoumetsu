package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    @SafeParcelable.VersionField(id = 1000)
    private final int b;
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int c;
    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    private final String d;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent e;
    @VisibleForTesting
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    private static final Status a = new Status(17);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    @KeepForSdk
    public Status(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = pendingIntent;
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.b == status.b && this.c == status.c && Objects.equal(this.d, status.d) && Objects.equal(this.e, status.e);
    }

    public final PendingIntent getResolution() {
        return this.e;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.c;
    }

    public final String getStatusMessage() {
        return this.d;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.e != null;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.b), Integer.valueOf(this.c), this.d, this.e);
    }

    public final boolean isCanceled() {
        return this.c == 16;
    }

    public final boolean isInterrupted() {
        return this.c == 14;
    }

    public final boolean isSuccess() {
        return this.c <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) {
        if (!hasResolution()) {
            return;
        }
        activity.startIntentSenderForResult(this.e.getIntentSender(), i, null, 0, 0, 0);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("statusCode", zzg()).add("resolution", this.e).toString();
    }

    @Override // android.os.Parcelable
    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.e, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        String str = this.d;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.c);
    }
}
