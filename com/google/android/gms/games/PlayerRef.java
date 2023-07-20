package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzc;
import com.google.android.gms.games.internal.player.zzd;

/* loaded from: classes.dex */
public final class PlayerRef extends DataBufferRef implements Player {
    private final zzd c;
    private final PlayerLevelInfo d;
    private final zzc e;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        PlayerLevelInfo playerLevelInfo;
        this.c = new zzd(str);
        this.e = new zzc(dataHolder, i, this.c);
        if (!h(this.c.zzml) && a(this.c.zzml) != -1) {
            int b = b(this.c.zzmm);
            int b2 = b(this.c.zzmp);
            PlayerLevel playerLevel = new PlayerLevel(b, a(this.c.zzmn), a(this.c.zzmo));
            playerLevelInfo = new PlayerLevelInfo(a(this.c.zzml), a(this.c.zzmr), playerLevel, b != b2 ? new PlayerLevel(b2, a(this.c.zzmo), a(this.c.zzmq)) : playerLevel);
        } else {
            playerLevelInfo = null;
        }
        this.d = playerLevelInfo;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return PlayerEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Player mo28freeze() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return g(this.c.zznb);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return d(this.c.zznc);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return g(this.c.zznd);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return d(this.c.zzne);
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return d(this.c.zzmd);
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        a(this.c.zzmd, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return g(this.c.zzmg);
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return d(this.c.zzmh);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return g(this.c.zzme);
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return d(this.c.zzmf);
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.c.zzmk) || h(this.c.zzmk)) {
            return -1L;
        }
        return a(this.c.zzmk);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return d(this.c.name);
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return d(this.c.zzmc);
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return a(this.c.zzmi);
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return d(this.c.zzcd);
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        a(this.c.zzcd, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.a(this);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean isMuted() {
        return c(this.c.zznh);
    }

    public final String toString() {
        return PlayerEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) ((Player) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzh() {
        return d(this.c.zzci);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzi() {
        return c(this.c.zzna);
    }

    @Override // com.google.android.gms.games.Player
    public final int zzj() {
        return b(this.c.zzmj);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzk() {
        return c(this.c.zzmt);
    }

    @Override // com.google.android.gms.games.Player
    public final zza zzl() {
        if (h(this.c.zzmu)) {
            return null;
        }
        return this.e;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzm() {
        return b(this.c.zznf);
    }

    @Override // com.google.android.gms.games.Player
    public final long zzn() {
        return a(this.c.zzng);
    }

    @Override // com.google.android.gms.games.Player
    public final long zzo() {
        return a(this.c.zzni);
    }
}
