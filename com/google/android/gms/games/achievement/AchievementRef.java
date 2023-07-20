package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import net.gree.gamelib.payment.internal.a.e;
import net.gree.gamelib.payment.shop.Product;

/* loaded from: classes.dex */
public final class AchievementRef extends DataBufferRef implements Achievement {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Achievement mo28freeze() {
        return new AchievementEntity(this);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return d("external_achievement_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getApplicationId() {
        return d("external_game_id");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return b("current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return d("description");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        a("description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return d("formatted_current_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        a("formatted_current_steps", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return d("formatted_total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        a("formatted_total_steps", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return a("last_updated_timestamp");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return d(Product.KEY_NAME);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer) {
        a(Product.KEY_NAME, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzw());
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return g("revealed_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getRevealedImageUrl() {
        return d("revealed_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return b("state");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return b("total_steps");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return b(e.J);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return g("unlocked_icon_image_uri");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getUnlockedImageUrl() {
        return d("unlocked_icon_image_url");
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return a((!hasColumn("instance_xp_value") || h("instance_xp_value")) ? "definition_xp_value" : "instance_xp_value");
    }

    public final String toString() {
        return AchievementEntity.a(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzw() {
        if (h("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.a, this.b);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zzx() {
        if (!hasColumn("rarity_percent") || h("rarity_percent")) {
            return -1.0f;
        }
        return e("rarity_percent");
    }
}
