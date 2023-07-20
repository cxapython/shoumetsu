package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

@SafeParcelable.Class(creator = "OnChangesResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzez extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzez> CREATOR = new zzfa();
    @SafeParcelable.Field(id = 2)
    private final DataHolder a;
    @SafeParcelable.Field(id = 3)
    private final List<DriveId> b;
    @SafeParcelable.Field(id = 4)
    private final com.google.android.gms.drive.zza c;
    @SafeParcelable.Field(id = 5)
    private final boolean d;

    @SafeParcelable.Constructor
    public zzez(@SafeParcelable.Param(id = 2) DataHolder dataHolder, @SafeParcelable.Param(id = 3) List<DriveId> list, @SafeParcelable.Param(id = 4) com.google.android.gms.drive.zza zzaVar, @SafeParcelable.Param(id = 5) boolean z) {
        this.a = dataHolder;
        this.b = list;
        this.c = zzaVar;
        this.d = z;
    }

    @Override // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.a, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.c, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
