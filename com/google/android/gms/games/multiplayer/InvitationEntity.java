package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

@UsedByReflection("GamesClientImpl.java")
@RetainForClient
@SafeParcelable.Class(creator = "InvitationEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
    @SafeParcelable.Field(getter = "getGame", id = 1)
    private final GameEntity a;
    @SafeParcelable.Field(getter = "getInvitationId", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 3)
    private final long c;
    @SafeParcelable.Field(getter = "getInvitationType", id = 4)
    private final int d;
    @SafeParcelable.Field(getter = "getInviter", id = 5)
    private final ParticipantEntity e;
    @SafeParcelable.Field(getter = "getParticipants", id = 6)
    private final ArrayList<ParticipantEntity> f;
    @SafeParcelable.Field(getter = "getVariant", id = 7)
    private final int g;
    @SafeParcelable.Field(getter = "getAvailableAutoMatchSlots", id = 8)
    private final int h;

    /* loaded from: classes.dex */
    static final class a extends zza {
        a() {
        }

        @Override // com.google.android.gms.games.multiplayer.zza, android.os.Parcelable.Creator
        public final /* synthetic */ InvitationEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // com.google.android.gms.games.multiplayer.zza
        public final InvitationEntity zze(Parcel parcel) {
            if (InvitationEntity.b(InvitationEntity.a()) || InvitationEntity.a(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public InvitationEntity(@SafeParcelable.Param(id = 1) GameEntity gameEntity, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) int i, @SafeParcelable.Param(id = 5) ParticipantEntity participantEntity, @SafeParcelable.Param(id = 6) ArrayList<ParticipantEntity> arrayList, @SafeParcelable.Param(id = 7) int i2, @SafeParcelable.Param(id = 8) int i3) {
        this.a = gameEntity;
        this.b = str;
        this.c = j;
        this.d = i;
        this.e = participantEntity;
        this.f = arrayList;
        this.g = i2;
        this.h = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvitationEntity(Invitation invitation) {
        this(invitation, ParticipantEntity.zza(invitation.getParticipants()));
    }

    private InvitationEntity(Invitation invitation, ArrayList<ParticipantEntity> arrayList) {
        ParticipantEntity participantEntity;
        this.a = new GameEntity(invitation.getGame());
        this.b = invitation.getInvitationId();
        this.c = invitation.getCreationTimestamp();
        this.d = invitation.getInvitationType();
        this.g = invitation.getVariant();
        this.h = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        this.f = arrayList;
        ArrayList<ParticipantEntity> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                participantEntity = null;
                break;
            }
            ParticipantEntity participantEntity2 = arrayList2.get(i);
            i++;
            participantEntity = participantEntity2;
            if (participantEntity.getParticipantId().equals(participantId)) {
                break;
            }
        }
        Preconditions.checkNotNull(participantEntity, "Must have a valid inviter!");
        this.e = participantEntity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Invitation invitation) {
        return Objects.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return Objects.equal(invitation2.getGame(), invitation.getGame()) && Objects.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && Objects.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && Objects.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && Objects.equal(invitation2.getInviter(), invitation.getInviter()) && Objects.equal(invitation2.getParticipants(), invitation.getParticipants()) && Objects.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && Objects.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Invitation invitation) {
        return Objects.toStringHelper(invitation).add("Game", invitation.getGame()).add("InvitationId", invitation.getInvitationId()).add("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).add("InvitationType", Integer.valueOf(invitation.getInvitationType())).add("Inviter", invitation.getInviter()).add("Participants", invitation.getParticipants()).add("Variant", Integer.valueOf(invitation.getVariant())).add("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Invitation mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getAvailableAutoMatchSlots() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final long getCreationTimestamp() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Game getGame() {
        return this.a;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final String getInvitationId() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getInvitationType() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Participant getInviter() {
        return this.e;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getVariant() {
        return this.g;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        this.a.setShouldDowngrade(z);
        this.e.setShouldDowngrade(z);
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).setShouldDowngrade(z);
        }
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!b()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
            SafeParcelWriter.writeString(parcel, 2, getInvitationId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getInvitationType());
            SafeParcelWriter.writeParcelable(parcel, 5, getInviter(), i, false);
            SafeParcelWriter.writeTypedList(parcel, 6, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 7, getVariant());
            SafeParcelWriter.writeInt(parcel, 8, getAvailableAutoMatchSlots());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        this.a.writeToParcel(parcel, i);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeInt(this.d);
        this.e.writeToParcel(parcel, i);
        int size = this.f.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.f.get(i2).writeToParcel(parcel, i);
        }
    }
}
