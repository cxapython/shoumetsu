package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

@SafeParcelable.Class(creator = "OnEventResponseCreator")
@SafeParcelable.Reserved({1, 4, 8})
/* loaded from: classes.dex */
public final class zzfj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfj> CREATOR = new zzfk();
    @SafeParcelable.Field(id = 2)
    private final int a;
    @SafeParcelable.Field(id = 3)
    private final ChangeEvent b;
    @SafeParcelable.Field(id = 5)
    private final CompletionEvent c;
    @SafeParcelable.Field(id = 6)
    private final com.google.android.gms.drive.events.zzo d;
    @SafeParcelable.Field(id = 7)
    private final com.google.android.gms.drive.events.zzb e;
    @SafeParcelable.Field(id = 9)
    private final com.google.android.gms.drive.events.zzv f;
    @SafeParcelable.Field(id = 10)
    private final com.google.android.gms.drive.events.zzr g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzfj(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) ChangeEvent changeEvent, @SafeParcelable.Param(id = 5) CompletionEvent completionEvent, @SafeParcelable.Param(id = 6) com.google.android.gms.drive.events.zzo zzoVar, @SafeParcelable.Param(id = 7) com.google.android.gms.drive.events.zzb zzbVar, @SafeParcelable.Param(id = 9) com.google.android.gms.drive.events.zzv zzvVar, @SafeParcelable.Param(id = 10) com.google.android.gms.drive.events.zzr zzrVar) {
        this.a = i;
        this.b = changeEvent;
        this.c = completionEvent;
        this.d = zzoVar;
        this.e = zzbVar;
        this.f = zzvVar;
        this.g = zzrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.a);
        SafeParcelWriter.writeParcelable(parcel, 3, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.d, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.e, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.g, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DriveEvent zzak() {
        int i = this.a;
        switch (i) {
            case 1:
                return this.b;
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
            case 6:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected event type ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
            case 7:
                return this.f;
            case 8:
                return this.g;
        }
    }
}
