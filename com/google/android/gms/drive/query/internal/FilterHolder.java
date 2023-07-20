package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

@SafeParcelable.Class(creator = "FilterHolderCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzh();
    @SafeParcelable.Field(id = 1)
    private final zzb<?> a;
    @SafeParcelable.Field(id = 2)
    private final zzd b;
    @SafeParcelable.Field(id = 3)
    private final zzr c;
    @SafeParcelable.Field(id = 4)
    private final zzv d;
    @SafeParcelable.Field(id = 5)
    private final zzp<?> e;
    @SafeParcelable.Field(id = 6)
    private final zzt f;
    @SafeParcelable.Field(id = 7)
    private final zzn g;
    @SafeParcelable.Field(id = 8)
    private final zzl h;
    @SafeParcelable.Field(id = 9)
    private final zzz i;
    private final Filter j;

    public FilterHolder(Filter filter) {
        Preconditions.checkNotNull(filter, "Null filter.");
        zzz zzzVar = null;
        this.a = filter instanceof zzb ? (zzb) filter : null;
        this.b = filter instanceof zzd ? (zzd) filter : null;
        this.c = filter instanceof zzr ? (zzr) filter : null;
        this.d = filter instanceof zzv ? (zzv) filter : null;
        this.e = filter instanceof zzp ? (zzp) filter : null;
        this.f = filter instanceof zzt ? (zzt) filter : null;
        this.g = filter instanceof zzn ? (zzn) filter : null;
        this.h = filter instanceof zzl ? (zzl) filter : null;
        this.i = filter instanceof zzz ? (zzz) filter : zzzVar;
        if (this.a == null && this.b == null && this.c == null && this.d == null && this.e == null && this.f == null && this.g == null && this.h == null && this.i == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.j = filter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public FilterHolder(@SafeParcelable.Param(id = 1) zzb<?> zzbVar, @SafeParcelable.Param(id = 2) zzd zzdVar, @SafeParcelable.Param(id = 3) zzr zzrVar, @SafeParcelable.Param(id = 4) zzv zzvVar, @SafeParcelable.Param(id = 5) zzp<?> zzpVar, @SafeParcelable.Param(id = 6) zzt zztVar, @SafeParcelable.Param(id = 7) zzn<?> zznVar, @SafeParcelable.Param(id = 8) zzl zzlVar, @SafeParcelable.Param(id = 9) zzz zzzVar) {
        this.a = zzbVar;
        this.b = zzdVar;
        this.c = zzrVar;
        this.d = zzvVar;
        this.e = zzpVar;
        this.f = zztVar;
        this.g = zznVar;
        this.h = zzlVar;
        this.i = zzzVar;
        zzb<?> zzbVar2 = this.a;
        if (zzbVar2 != null) {
            this.j = zzbVar2;
            return;
        }
        zzd zzdVar2 = this.b;
        if (zzdVar2 != null) {
            this.j = zzdVar2;
            return;
        }
        zzr zzrVar2 = this.c;
        if (zzrVar2 != null) {
            this.j = zzrVar2;
            return;
        }
        zzv zzvVar2 = this.d;
        if (zzvVar2 != null) {
            this.j = zzvVar2;
            return;
        }
        zzp<?> zzpVar2 = this.e;
        if (zzpVar2 != null) {
            this.j = zzpVar2;
            return;
        }
        zzt zztVar2 = this.f;
        if (zztVar2 != null) {
            this.j = zztVar2;
            return;
        }
        zzn zznVar2 = this.g;
        if (zznVar2 != null) {
            this.j = zznVar2;
            return;
        }
        zzl zzlVar2 = this.h;
        if (zzlVar2 != null) {
            this.j = zzlVar2;
            return;
        }
        zzz zzzVar2 = this.i;
        if (zzzVar2 == null) {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
        this.j = zzzVar2;
    }

    public final Filter getFilter() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.a, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.b, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.c, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.e, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.g, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.h, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.i, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
