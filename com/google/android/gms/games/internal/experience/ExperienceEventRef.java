package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.games.Game;

/* loaded from: classes.dex */
public final class ExperienceEventRef extends DataBufferRef implements ExperienceEvent {
    @Override // android.os.Parcelable
    public final int describeContents() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ ExperienceEvent mo28freeze() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Game getGame() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Uri getIconImageUri() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String getIconImageUrl() {
        return d("icon_url");
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int getType() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        throw new NoSuchMethodError();
    }

    public final String toString() {
        throw new NoSuchMethodError();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcu() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcv() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzcw() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcx() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcy() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzcz() {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzda() {
        throw new NoSuchMethodError();
    }
}
