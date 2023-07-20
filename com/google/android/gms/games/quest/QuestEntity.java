package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "QuestEntityCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes.dex */
public final class QuestEntity extends zzd implements Quest {
    public static final Parcelable.Creator<QuestEntity> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getGame", id = 1)
    private final GameEntity a;
    @SafeParcelable.Field(getter = "getQuestId", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getAcceptedTimestamp", id = 3)
    private final long c;
    @SafeParcelable.Field(getter = "getBannerImageUri", id = 4)
    private final Uri d;
    @SafeParcelable.Field(getter = "getBannerImageUrl", id = 5)
    private final String e;
    @SafeParcelable.Field(getter = "getDescription", id = 6)
    private final String f;
    @SafeParcelable.Field(getter = "getEndTimestamp", id = 7)
    private final long g;
    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", id = 8)
    private final long h;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 9)
    private final Uri i;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 10)
    private final String j;
    @SafeParcelable.Field(getter = "getName", id = 12)
    private final String k;
    @SafeParcelable.Field(getter = "getNotifyTimestamp", id = 13)
    private final long l;
    @SafeParcelable.Field(getter = "getStartTimestamp", id = 14)
    private final long m;
    @SafeParcelable.Field(getter = "getState", id = 15)
    private final int n;
    @SafeParcelable.Field(getter = "getType", id = 16)
    private final int o;
    @SafeParcelable.Field(getter = "getMilestones", id = 17)
    private final ArrayList<MilestoneEntity> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public QuestEntity(@SafeParcelable.Param(id = 1) GameEntity gameEntity, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) long j2, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 9) Uri uri2, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 12) String str5, @SafeParcelable.Param(id = 13) long j4, @SafeParcelable.Param(id = 14) long j5, @SafeParcelable.Param(id = 15) int i, @SafeParcelable.Param(id = 16) int i2, @SafeParcelable.Param(id = 17) ArrayList<MilestoneEntity> arrayList) {
        this.a = gameEntity;
        this.b = str;
        this.c = j;
        this.d = uri;
        this.e = str2;
        this.f = str3;
        this.g = j2;
        this.h = j3;
        this.i = uri2;
        this.j = str4;
        this.k = str5;
        this.l = j4;
        this.m = j5;
        this.n = i;
        this.o = i2;
        this.p = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.a = new GameEntity(quest.getGame());
        this.b = quest.getQuestId();
        this.c = quest.getAcceptedTimestamp();
        this.f = quest.getDescription();
        this.d = quest.getBannerImageUri();
        this.e = quest.getBannerImageUrl();
        this.g = quest.getEndTimestamp();
        this.i = quest.getIconImageUri();
        this.j = quest.getIconImageUrl();
        this.h = quest.getLastUpdatedTimestamp();
        this.k = quest.getName();
        this.l = quest.zzdr();
        this.m = quest.getStartTimestamp();
        this.n = quest.getState();
        this.o = quest.getType();
        List<Milestone> zzdq = quest.zzdq();
        int size = zzdq.size();
        this.p = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.p.add((MilestoneEntity) zzdq.get(i).mo28freeze());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Quest quest) {
        return Objects.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzdq(), quest.getName(), Long.valueOf(quest.zzdr()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return Objects.equal(quest2.getGame(), quest.getGame()) && Objects.equal(quest2.getQuestId(), quest.getQuestId()) && Objects.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && Objects.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && Objects.equal(quest2.getDescription(), quest.getDescription()) && Objects.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && Objects.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && Objects.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && Objects.equal(quest2.zzdq(), quest.zzdq()) && Objects.equal(quest2.getName(), quest.getName()) && Objects.equal(Long.valueOf(quest2.zzdr()), Long.valueOf(quest.zzdr())) && Objects.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && Objects.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Quest quest) {
        return Objects.toStringHelper(quest).add("Game", quest.getGame()).add("QuestId", quest.getQuestId()).add("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).add("BannerImageUri", quest.getBannerImageUri()).add("BannerImageUrl", quest.getBannerImageUrl()).add("Description", quest.getDescription()).add("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).add("IconImageUri", quest.getIconImageUri()).add("IconImageUrl", quest.getIconImageUrl()).add("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).add("Milestones", quest.zzdq()).add("Name", quest.getName()).add("NotifyTimestamp", Long.valueOf(quest.zzdr())).add("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).add("State", Integer.valueOf(quest.getState())).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ Quest mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getAcceptedTimestamp() {
        return this.c;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getBannerImageUri() {
        return this.d;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getBannerImageUrl() {
        return this.e;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Milestone getCurrentMilestone() {
        return zzdq().get(0);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getDescription() {
        return this.f;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.f, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getEndTimestamp() {
        return this.g;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Game getGame() {
        return this.a;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getIconImageUri() {
        return this.i;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getIconImageUrl() {
        return this.j;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getLastUpdatedTimestamp() {
        return this.h;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getName() {
        return this.k;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.k, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getQuestId() {
        return this.b;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getStartTimestamp() {
        return this.m;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getState() {
        return this.n;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getType() {
        return this.o;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final boolean isEndingSoon() {
        return this.l <= System.currentTimeMillis() + 1800000;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getQuestId(), false);
        SafeParcelWriter.writeLong(parcel, 3, getAcceptedTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 4, getBannerImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getBannerImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 6, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 7, getEndTimestamp());
        SafeParcelWriter.writeLong(parcel, 8, getLastUpdatedTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 9, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 10, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 12, getName(), false);
        SafeParcelWriter.writeLong(parcel, 13, this.l);
        SafeParcelWriter.writeLong(parcel, 14, getStartTimestamp());
        SafeParcelWriter.writeInt(parcel, 15, getState());
        SafeParcelWriter.writeInt(parcel, 16, this.o);
        SafeParcelWriter.writeTypedList(parcel, 17, zzdq(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final List<Milestone> zzdq() {
        return new ArrayList(this.p);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long zzdr() {
        return this.l;
    }
}
