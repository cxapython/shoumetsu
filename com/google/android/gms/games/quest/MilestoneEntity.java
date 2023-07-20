package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "MilestoneEntityCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes.dex */
public final class MilestoneEntity extends zzd implements Milestone {
    public static final Parcelable.Creator<MilestoneEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getMilestoneId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getCurrentProgress", id = 2)
    private final long b;
    @SafeParcelable.Field(getter = "getTargetProgress", id = 3)
    private final long c;
    @SafeParcelable.Field(getter = "getCompletionRewardData", id = 4)
    private final byte[] d;
    @SafeParcelable.Field(getter = "getState", id = 5)
    private final int e;
    @SafeParcelable.Field(getter = "getEventId", id = 6)
    private final String f;

    public MilestoneEntity(Milestone milestone) {
        this.a = milestone.getMilestoneId();
        this.b = milestone.getCurrentProgress();
        this.c = milestone.getTargetProgress();
        this.e = milestone.getState();
        this.f = milestone.getEventId();
        byte[] completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.d = null;
            return;
        }
        this.d = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.d, 0, completionRewardData.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MilestoneEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 6) String str2) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = bArr;
        this.e = i;
        this.f = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Milestone milestone) {
        return Objects.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return Objects.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && Objects.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && Objects.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && Objects.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && Objects.equal(milestone2.getEventId(), milestone.getEventId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Milestone milestone) {
        return Objects.toStringHelper(milestone).add("MilestoneId", milestone.getMilestoneId()).add("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).add("TargetProgress", Long.valueOf(milestone.getTargetProgress())).add("State", Integer.valueOf(milestone.getState())).add("CompletionRewardData", milestone.getCompletionRewardData()).add("EventId", milestone.getEventId()).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ Milestone mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final byte[] getCompletionRewardData() {
        return this.d;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getCurrentProgress() {
        return this.b;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getEventId() {
        return this.f;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getMilestoneId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final int getState() {
        return this.e;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getTargetProgress() {
        return this.c;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getMilestoneId(), false);
        SafeParcelWriter.writeLong(parcel, 2, getCurrentProgress());
        SafeParcelWriter.writeLong(parcel, 3, getTargetProgress());
        SafeParcelWriter.writeByteArray(parcel, 4, getCompletionRewardData(), false);
        SafeParcelWriter.writeInt(parcel, 5, getState());
        SafeParcelWriter.writeString(parcel, 6, getEventId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
