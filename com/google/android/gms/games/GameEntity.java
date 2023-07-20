package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesClientImpl.java")
@RetainForClient
@SafeParcelable.Class(creator = "GameEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new a();
    @SafeParcelable.Field(getter = "getApplicationId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getPrimaryCategory", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getSecondaryCategory", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getDescription", id = 5)
    private final String e;
    @SafeParcelable.Field(getter = "getDeveloperName", id = 6)
    private final String f;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 7)
    private final Uri g;
    @SafeParcelable.Field(getter = "getHiResImageUri", id = 8)
    private final Uri h;
    @SafeParcelable.Field(getter = "getFeaturedImageUri", id = 9)
    private final Uri i;
    @SafeParcelable.Field(getter = "isPlayEnabledGame", id = 10)
    private final boolean j;
    @SafeParcelable.Field(getter = "isInstanceInstalled", id = 11)
    private final boolean k;
    @SafeParcelable.Field(getter = "getInstancePackageName", id = 12)
    private final String l;
    @SafeParcelable.Field(getter = "getGameplayAclStatus", id = 13)
    private final int m;
    @SafeParcelable.Field(getter = "getAchievementTotalCount", id = 14)
    private final int n;
    @SafeParcelable.Field(getter = "getLeaderboardCount", id = 15)
    private final int o;
    @SafeParcelable.Field(getter = "isRealTimeMultiplayerEnabled", id = 16)
    private final boolean p;
    @SafeParcelable.Field(getter = "isTurnBasedMultiplayerEnabled", id = 17)
    private final boolean q;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 18)
    private final String r;
    @SafeParcelable.Field(getter = "getHiResImageUrl", id = 19)
    private final String s;
    @SafeParcelable.Field(getter = "getFeaturedImageUrl", id = 20)
    private final String t;
    @SafeParcelable.Field(getter = "isMuted", id = 21)
    private final boolean u;
    @SafeParcelable.Field(getter = "isIdentitySharingConfirmed", id = 22)
    private final boolean v;
    @SafeParcelable.Field(getter = "areSnapshotsEnabled", id = 23)
    private final boolean w;
    @SafeParcelable.Field(getter = "getThemeColor", id = 24)
    private final String x;
    @SafeParcelable.Field(getter = "hasGamepadSupport", id = 25)
    private final boolean y;

    /* loaded from: classes.dex */
    static final class a extends zzh {
        a() {
        }

        @Override // com.google.android.gms.games.zzh, android.os.Parcelable.Creator
        public final /* synthetic */ GameEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // com.google.android.gms.games.zzh
        public final GameEntity zzb(Parcel parcel) {
            if (GameEntity.b(GameEntity.a()) || GameEntity.a(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            String readString8 = parcel.readString();
            Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
            String readString9 = parcel.readString();
            return new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    public GameEntity(Game game) {
        this.a = game.getApplicationId();
        this.c = game.getPrimaryCategory();
        this.d = game.getSecondaryCategory();
        this.e = game.getDescription();
        this.f = game.getDeveloperName();
        this.b = game.getDisplayName();
        this.g = game.getIconImageUri();
        this.r = game.getIconImageUrl();
        this.h = game.getHiResImageUri();
        this.s = game.getHiResImageUrl();
        this.i = game.getFeaturedImageUri();
        this.t = game.getFeaturedImageUrl();
        this.j = game.zzb();
        this.k = game.zzd();
        this.l = game.zze();
        this.m = 1;
        this.n = game.getAchievementTotalCount();
        this.o = game.getLeaderboardCount();
        this.p = game.isRealTimeMultiplayerEnabled();
        this.q = game.isTurnBasedMultiplayerEnabled();
        this.u = game.isMuted();
        this.v = game.zzc();
        this.w = game.areSnapshotsEnabled();
        this.x = game.getThemeColor();
        this.y = game.hasGamepadSupport();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GameEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) String str5, @SafeParcelable.Param(id = 6) String str6, @SafeParcelable.Param(id = 7) Uri uri, @SafeParcelable.Param(id = 8) Uri uri2, @SafeParcelable.Param(id = 9) Uri uri3, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) boolean z2, @SafeParcelable.Param(id = 12) String str7, @SafeParcelable.Param(id = 13) int i, @SafeParcelable.Param(id = 14) int i2, @SafeParcelable.Param(id = 15) int i3, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) boolean z4, @SafeParcelable.Param(id = 18) String str8, @SafeParcelable.Param(id = 19) String str9, @SafeParcelable.Param(id = 20) String str10, @SafeParcelable.Param(id = 21) boolean z5, @SafeParcelable.Param(id = 22) boolean z6, @SafeParcelable.Param(id = 23) boolean z7, @SafeParcelable.Param(id = 24) String str11, @SafeParcelable.Param(id = 25) boolean z8) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = uri;
        this.r = str8;
        this.h = uri2;
        this.s = str9;
        this.i = uri3;
        this.t = str10;
        this.j = z;
        this.k = z2;
        this.l = str7;
        this.m = i;
        this.n = i2;
        this.o = i3;
        this.p = z3;
        this.q = z4;
        this.u = z5;
        this.v = z6;
        this.w = z7;
        this.x = str11;
        this.y = z8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Game game) {
        return Objects.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.zzd()), game.zze(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzc()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return Objects.equal(game2.getApplicationId(), game.getApplicationId()) && Objects.equal(game2.getDisplayName(), game.getDisplayName()) && Objects.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && Objects.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && Objects.equal(game2.getDescription(), game.getDescription()) && Objects.equal(game2.getDeveloperName(), game.getDeveloperName()) && Objects.equal(game2.getIconImageUri(), game.getIconImageUri()) && Objects.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && Objects.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && Objects.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd())) && Objects.equal(game2.zze(), game.zze()) && Objects.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && Objects.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && Objects.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && Objects.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && Objects.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && Objects.equal(game2.getThemeColor(), game.getThemeColor()) && Objects.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Game game) {
        return Objects.toStringHelper(game).add("ApplicationId", game.getApplicationId()).add("DisplayName", game.getDisplayName()).add("PrimaryCategory", game.getPrimaryCategory()).add("SecondaryCategory", game.getSecondaryCategory()).add("Description", game.getDescription()).add("DeveloperName", game.getDeveloperName()).add("IconImageUri", game.getIconImageUri()).add("IconImageUrl", game.getIconImageUrl()).add("HiResImageUri", game.getHiResImageUri()).add("HiResImageUrl", game.getHiResImageUrl()).add("FeaturedImageUri", game.getFeaturedImageUri()).add("FeaturedImageUrl", game.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game.zzb())).add("InstanceInstalled", Boolean.valueOf(game.zzd())).add("InstancePackageName", game.zze()).add("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).add("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).add("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).add("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).add("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).add("ThemeColor", game.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    @Override // com.google.android.gms.games.Game
    public final boolean areSnapshotsEnabled() {
        return this.w;
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Game mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Game
    public final int getAchievementTotalCount() {
        return this.n;
    }

    @Override // com.google.android.gms.games.Game
    public final String getApplicationId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.Game
    public final String getDescription() {
        return this.e;
    }

    @Override // com.google.android.gms.games.Game
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.e, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final String getDeveloperName() {
        return this.f;
    }

    @Override // com.google.android.gms.games.Game
    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.f, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final String getDisplayName() {
        return this.b;
    }

    @Override // com.google.android.gms.games.Game
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.b, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getFeaturedImageUri() {
        return this.i;
    }

    @Override // com.google.android.gms.games.Game
    public final String getFeaturedImageUrl() {
        return this.t;
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getHiResImageUri() {
        return this.h;
    }

    @Override // com.google.android.gms.games.Game
    public final String getHiResImageUrl() {
        return this.s;
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getIconImageUri() {
        return this.g;
    }

    @Override // com.google.android.gms.games.Game
    public final String getIconImageUrl() {
        return this.r;
    }

    @Override // com.google.android.gms.games.Game
    public final int getLeaderboardCount() {
        return this.o;
    }

    @Override // com.google.android.gms.games.Game
    public final String getPrimaryCategory() {
        return this.c;
    }

    @Override // com.google.android.gms.games.Game
    public final String getSecondaryCategory() {
        return this.d;
    }

    @Override // com.google.android.gms.games.Game
    public final String getThemeColor() {
        return this.x;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean hasGamepadSupport() {
        return this.y;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isMuted() {
        return this.u;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isRealTimeMultiplayerEnabled() {
        return this.p;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isTurnBasedMultiplayerEnabled() {
        return this.q;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (b()) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            Uri uri = this.g;
            String str = null;
            parcel.writeString(uri == null ? null : uri.toString());
            Uri uri2 = this.h;
            parcel.writeString(uri2 == null ? null : uri2.toString());
            Uri uri3 = this.i;
            if (uri3 != null) {
                str = uri3.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeInt(this.n);
            parcel.writeInt(this.o);
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getApplicationId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getPrimaryCategory(), false);
        SafeParcelWriter.writeString(parcel, 4, getSecondaryCategory(), false);
        SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeveloperName(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getIconImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.j);
        SafeParcelWriter.writeBoolean(parcel, 11, this.k);
        SafeParcelWriter.writeString(parcel, 12, this.l, false);
        SafeParcelWriter.writeInt(parcel, 13, this.m);
        SafeParcelWriter.writeInt(parcel, 14, getAchievementTotalCount());
        SafeParcelWriter.writeInt(parcel, 15, getLeaderboardCount());
        SafeParcelWriter.writeBoolean(parcel, 16, isRealTimeMultiplayerEnabled());
        SafeParcelWriter.writeBoolean(parcel, 17, isTurnBasedMultiplayerEnabled());
        SafeParcelWriter.writeString(parcel, 18, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 19, getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 20, getFeaturedImageUrl(), false);
        SafeParcelWriter.writeBoolean(parcel, 21, this.u);
        SafeParcelWriter.writeBoolean(parcel, 22, this.v);
        SafeParcelWriter.writeBoolean(parcel, 23, areSnapshotsEnabled());
        SafeParcelWriter.writeString(parcel, 24, getThemeColor(), false);
        SafeParcelWriter.writeBoolean(parcel, 25, hasGamepadSupport());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzb() {
        return this.j;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzc() {
        return this.v;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzd() {
        return this.k;
    }

    @Override // com.google.android.gms.games.Game
    public final String zze() {
        return this.l;
    }
}
