package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
/* loaded from: classes.dex */
public final class QuestRef extends DataBufferRef implements Quest {
    private final Game c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = new GameRef(dataHolder, i);
        this.d = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return QuestEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Quest mo28freeze() {
        return new QuestEntity(this);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getAcceptedTimestamp() {
        return a("accepted_ts");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getBannerImageUri() {
        return g("quest_banner_image_uri");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getBannerImageUrl() {
        return d("quest_banner_image_url");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Milestone getCurrentMilestone() {
        return zzdq().get(0);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getDescription() {
        return d("quest_description");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        a("quest_description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getEndTimestamp() {
        return a("quest_end_ts");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Game getGame() {
        return this.c;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getIconImageUri() {
        return g("quest_icon_image_uri");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getIconImageUrl() {
        return d("quest_icon_image_url");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getLastUpdatedTimestamp() {
        return a("quest_last_updated_ts");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getName() {
        return d("quest_name");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getName(CharArrayBuffer charArrayBuffer) {
        a("quest_name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getQuestId() {
        return d("external_quest_id");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getStartTimestamp() {
        return a("quest_start_ts");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getState() {
        return b("quest_state");
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getType() {
        return b("quest_type");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return QuestEntity.a(this);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final boolean isEndingSoon() {
        return a("notification_ts") <= System.currentTimeMillis() + 1800000;
    }

    public final String toString() {
        return QuestEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((QuestEntity) ((Quest) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final List<Milestone> zzdq() {
        ArrayList arrayList = new ArrayList(this.d);
        for (int i = 0; i < this.d; i++) {
            arrayList.add(new zzb(this.a, this.b + i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long zzdr() {
        return a("notification_ts");
    }
}
