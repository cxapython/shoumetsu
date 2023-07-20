package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "ComparisonFilterCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzb<T> extends zza {
    public static final zzc CREATOR = new zzc();
    @SafeParcelable.Field(id = 1)
    private final zzx a;
    @SafeParcelable.Field(id = 2)
    private final MetadataBundle b;
    private final MetadataField<T> c;

    public zzb(zzx zzxVar, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(zzxVar, MetadataBundle.zza(searchableMetadataField, t));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) zzx zzxVar, @SafeParcelable.Param(id = 2) MetadataBundle metadataBundle) {
        this.a = zzxVar;
        this.b = metadataBundle;
        this.c = (MetadataField<T>) a.a(metadataBundle);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.a, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public final <F> F zza(zzj<F> zzjVar) {
        zzx zzxVar = this.a;
        MetadataField<T> metadataField = this.c;
        return zzjVar.zza(zzxVar, metadataField, this.b.zza(metadataField));
    }
}
