package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.zza;

@UsedByReflection("GamesClientImpl.java")
@RetainForClient
@SafeParcelable.Class(creator = "PlayerEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new a();
    @SafeParcelable.Field(getter = "getPlayerId", id = 1)
    private String a;
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    private String b;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 3)
    private final Uri c;
    @SafeParcelable.Field(getter = "getHiResImageUri", id = 4)
    private final Uri d;
    @SafeParcelable.Field(getter = "getRetrievedTimestamp", id = 5)
    private final long e;
    @SafeParcelable.Field(getter = "isInCircles", id = 6)
    private final int f;
    @SafeParcelable.Field(getter = "getLastPlayedWithTimestamp", id = 7)
    private final long g;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 8)
    private final String h;
    @SafeParcelable.Field(getter = "getHiResImageUrl", id = 9)
    private final String i;
    @SafeParcelable.Field(getter = "getTitle", id = 14)
    private final String j;
    @SafeParcelable.Field(getter = "getMostRecentGameInfo", id = 15)
    private final MostRecentGameInfoEntity k;
    @SafeParcelable.Field(getter = "getLevelInfo", id = 16)
    private final PlayerLevelInfo l;
    @SafeParcelable.Field(getter = "isProfileVisible", id = 18)
    private final boolean m;
    @SafeParcelable.Field(getter = "hasDebugAccess", id = 19)
    private final boolean n;
    @SafeParcelable.Field(getter = "getGamerTag", id = 20)
    private final String o;
    @SafeParcelable.Field(getter = "getName", id = 21)
    private final String p;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUri", id = 22)
    private final Uri q;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUrl", id = 23)
    private final String r;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUri", id = 24)
    private final Uri s;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUrl", id = 25)
    private final String t;
    @SafeParcelable.Field(getter = "getGamerFriendStatus", id = 26)
    private final int u;
    @SafeParcelable.Field(getter = "getGamerFriendUpdateTimestamp", id = 27)
    private final long v;
    @SafeParcelable.Field(getter = "isMuted", id = 28)
    private final boolean w;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTotalUnlockedAchievement", id = 29)
    private final long x;

    /* loaded from: classes.dex */
    static final class a extends zzap {
        a() {
        }

        @Override // com.google.android.gms.games.zzap, android.os.Parcelable.Creator
        public final /* synthetic */ PlayerEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // com.google.android.gms.games.zzap
        public final PlayerEntity zzc(Parcel parcel) {
            if (PlayerEntity.b(PlayerEntity.a()) || PlayerEntity.a(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1, -1L, false, -1L);
        }
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    private PlayerEntity(Player player, boolean z) {
        this.a = player.getPlayerId();
        this.b = player.getDisplayName();
        this.c = player.getIconImageUri();
        this.h = player.getIconImageUrl();
        this.d = player.getHiResImageUri();
        this.i = player.getHiResImageUrl();
        this.e = player.getRetrievedTimestamp();
        this.f = player.zzj();
        this.g = player.getLastPlayedWithTimestamp();
        this.j = player.getTitle();
        this.m = player.zzk();
        zza zzl = player.zzl();
        this.k = zzl == null ? null : new MostRecentGameInfoEntity(zzl);
        this.l = player.getLevelInfo();
        this.n = player.zzi();
        this.o = player.zzh();
        this.p = player.getName();
        this.q = player.getBannerImageLandscapeUri();
        this.r = player.getBannerImageLandscapeUrl();
        this.s = player.getBannerImagePortraitUri();
        this.t = player.getBannerImagePortraitUrl();
        this.u = player.zzm();
        this.v = player.zzn();
        this.w = player.isMuted();
        this.x = player.zzo();
        Asserts.checkNotNull(this.a);
        Asserts.checkNotNull(this.b);
        Asserts.checkState(this.e > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlayerEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) Uri uri2, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) int i, @SafeParcelable.Param(id = 7) long j2, @SafeParcelable.Param(id = 8) String str3, @SafeParcelable.Param(id = 9) String str4, @SafeParcelable.Param(id = 14) String str5, @SafeParcelable.Param(id = 15) MostRecentGameInfoEntity mostRecentGameInfoEntity, @SafeParcelable.Param(id = 16) PlayerLevelInfo playerLevelInfo, @SafeParcelable.Param(id = 18) boolean z, @SafeParcelable.Param(id = 19) boolean z2, @SafeParcelable.Param(id = 20) String str6, @SafeParcelable.Param(id = 21) String str7, @SafeParcelable.Param(id = 22) Uri uri3, @SafeParcelable.Param(id = 23) String str8, @SafeParcelable.Param(id = 24) Uri uri4, @SafeParcelable.Param(id = 25) String str9, @SafeParcelable.Param(id = 26) int i2, @SafeParcelable.Param(id = 27) long j3, @SafeParcelable.Param(id = 28) boolean z3, @SafeParcelable.Param(id = 29) long j4) {
        this.a = str;
        this.b = str2;
        this.c = uri;
        this.h = str3;
        this.d = uri2;
        this.i = str4;
        this.e = j;
        this.f = i;
        this.g = j2;
        this.j = str5;
        this.m = z;
        this.k = mostRecentGameInfoEntity;
        this.l = playerLevelInfo;
        this.n = z2;
        this.o = str6;
        this.p = str7;
        this.q = uri3;
        this.r = str8;
        this.s = uri4;
        this.t = str9;
        this.u = i2;
        this.v = j3;
        this.w = z3;
        this.x = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzi()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzh(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Integer.valueOf(player.zzm()), Long.valueOf(player.zzn()), Boolean.valueOf(player.isMuted()), Long.valueOf(player.zzo()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzi()), Boolean.valueOf(player.zzi())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzh(), player.zzh()) && Objects.equal(player2.getName(), player.getName()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Integer.valueOf(player2.zzm()), Integer.valueOf(player.zzm())) && Objects.equal(Long.valueOf(player2.zzn()), Long.valueOf(player.zzn())) && Objects.equal(Boolean.valueOf(player2.isMuted()), Boolean.valueOf(player.isMuted())) && Objects.equal(Long.valueOf(player2.zzo()), Long.valueOf(player.zzo()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Player player) {
        return Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzi())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zzh()).add("Name", player.getName()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("GamerFriendStatus", Integer.valueOf(player.zzm())).add("GamerFriendUpdateTimestamp", Long.valueOf(player.zzn())).add("IsMuted", Boolean.valueOf(player.isMuted())).add("totalUnlockedAchievement", Long.valueOf(player.zzo())).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Player mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return this.q;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return this.r;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return this.s;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return this.t;
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.b, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return this.i;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return this.h;
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        return this.g;
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.l;
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return this.p;
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return this.e;
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.j, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean isMuted() {
        return this.w;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (b()) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            Uri uri = this.c;
            String str = null;
            parcel.writeString(uri == null ? null : uri.toString());
            Uri uri2 = this.d;
            if (uri2 != null) {
                str = uri2.toString();
            }
            parcel.writeString(str);
            parcel.writeLong(this.e);
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
        SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
        SafeParcelWriter.writeInt(parcel, 6, this.f);
        SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
        SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.k, i, false);
        SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.m);
        SafeParcelWriter.writeBoolean(parcel, 19, this.n);
        SafeParcelWriter.writeString(parcel, 20, this.o, false);
        SafeParcelWriter.writeString(parcel, 21, this.p, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
        SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
        SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
        SafeParcelWriter.writeInt(parcel, 26, this.u);
        SafeParcelWriter.writeLong(parcel, 27, this.v);
        SafeParcelWriter.writeBoolean(parcel, 28, this.w);
        SafeParcelWriter.writeLong(parcel, 29, this.x);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzh() {
        return this.o;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzi() {
        return this.n;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzj() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzk() {
        return this.m;
    }

    @Override // com.google.android.gms.games.Player
    public final zza zzl() {
        return this.k;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzm() {
        return this.u;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzn() {
        return this.v;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzo() {
        return this.x;
    }
}
