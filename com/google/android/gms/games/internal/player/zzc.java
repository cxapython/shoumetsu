package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public final class zzc extends DataBufferRef implements zza {
    private final zzd c;

    public zzc(DataHolder dataHolder, int i, zzd zzdVar) {
        super(dataHolder, i);
        this.c = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ zza mo28freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.a(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) ((zza) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdb() {
        return d(this.c.zzmu);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzdc() {
        return d(this.c.zzmv);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zzdd() {
        return a(this.c.zzmw);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzde() {
        return g(this.c.zzmx);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdf() {
        return g(this.c.zzmy);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzdg() {
        return g(this.c.zzmz);
    }
}
