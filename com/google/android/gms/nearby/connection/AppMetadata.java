package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes.dex */
public final class AppMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getAppIdentifiers", id = 1)
    private final List<AppIdentifier> a;

    @SafeParcelable.Constructor
    public AppMetadata(@SafeParcelable.Param(id = 1) List<AppIdentifier> list) {
        this.a = (List) Preconditions.checkNotNull(list, "Must specify application identifiers");
        Preconditions.checkNotZero(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public final List<AppIdentifier> getAppIdentifiers() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getAppIdentifiers(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
