package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public final class GameRef extends DataBufferRef implements Game {
    public GameRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean areSnapshotsEnabled() {
        return b("snapshots_enabled") > 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return GameEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Game mo28freeze() {
        return new GameEntity(this);
    }

    @Override // com.google.android.gms.games.Game
    public final int getAchievementTotalCount() {
        return b("achievement_total_count");
    }

    @Override // com.google.android.gms.games.Game
    public final String getApplicationId() {
        return d("external_game_id");
    }

    @Override // com.google.android.gms.games.Game
    public final String getDescription() {
        return d("game_description");
    }

    @Override // com.google.android.gms.games.Game
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        a("game_description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final String getDeveloperName() {
        return d("developer_name");
    }

    @Override // com.google.android.gms.games.Game
    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        a("developer_name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final String getDisplayName() {
        return d("display_name");
    }

    @Override // com.google.android.gms.games.Game
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        a("display_name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getFeaturedImageUri() {
        return g("featured_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public final String getFeaturedImageUrl() {
        return d("featured_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getHiResImageUri() {
        return g("game_hi_res_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public final String getHiResImageUrl() {
        return d("game_hi_res_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public final Uri getIconImageUri() {
        return g("game_icon_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public final String getIconImageUrl() {
        return d("game_icon_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public final int getLeaderboardCount() {
        return b("leaderboard_count");
    }

    @Override // com.google.android.gms.games.Game
    public final String getPrimaryCategory() {
        return d("primary_category");
    }

    @Override // com.google.android.gms.games.Game
    public final String getSecondaryCategory() {
        return d("secondary_category");
    }

    @Override // com.google.android.gms.games.Game
    public final String getThemeColor() {
        return d("theme_color");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean hasGamepadSupport() {
        return b("gamepad_support") > 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return GameEntity.a(this);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isMuted() {
        return c("muted");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isRealTimeMultiplayerEnabled() {
        return b("real_time_support") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean isTurnBasedMultiplayerEnabled() {
        return b("turn_based_support") > 0;
    }

    public final String toString() {
        return GameEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((GameEntity) ((Game) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzb() {
        return c("play_enabled_game");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzc() {
        return c("identity_sharing_confirmed");
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzd() {
        return b("installed") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public final String zze() {
        return d("package_name");
    }
}
