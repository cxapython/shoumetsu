package com.google.android.gms.games.multiplayer;

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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@RetainForClient
@SafeParcelable.Class(creator = "ParticipantEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new a();
    @SafeParcelable.Field(getter = "getParticipantId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 3)
    private final Uri c;
    @SafeParcelable.Field(getter = "getHiResImageUri", id = 4)
    private final Uri d;
    @SafeParcelable.Field(getter = "getStatus", id = 5)
    private final int e;
    @SafeParcelable.Field(getter = "getClientAddress", id = 6)
    private final String f;
    @SafeParcelable.Field(getter = "isConnectedToRoom", id = 7)
    private final boolean g;
    @SafeParcelable.Field(getter = "getPlayer", id = 8)
    private final PlayerEntity h;
    @SafeParcelable.Field(getter = "getCapabilities", id = 9)
    private final int i;
    @SafeParcelable.Field(getter = "getResult", id = 10)
    private final ParticipantResult j;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 11)
    private final String k;
    @SafeParcelable.Field(getter = "getHiResImageUrl", id = 12)
    private final String l;

    /* loaded from: classes.dex */
    static final class a extends zzc {
        a() {
        }

        @Override // com.google.android.gms.games.multiplayer.zzc, android.os.Parcelable.Creator
        public final /* synthetic */ ParticipantEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // com.google.android.gms.games.multiplayer.zzc
        public final ParticipantEntity zzf(Parcel parcel) {
            if (ParticipantEntity.b(ParticipantEntity.a()) || ParticipantEntity.a(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            return new ParticipantEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), readInt, readString5, z2, z ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ParticipantEntity(Participant participant) {
        this(participant, r0 == null ? null : new PlayerEntity(r0));
        Player player = participant.getPlayer();
    }

    private ParticipantEntity(Participant participant, PlayerEntity playerEntity) {
        this.a = participant.getParticipantId();
        this.b = participant.getDisplayName();
        this.c = participant.getIconImageUri();
        this.d = participant.getHiResImageUri();
        this.e = participant.getStatus();
        this.f = participant.zzdn();
        this.g = participant.isConnectedToRoom();
        this.h = playerEntity;
        this.i = participant.getCapabilities();
        this.j = participant.getResult();
        this.k = participant.getIconImageUrl();
        this.l = participant.getHiResImageUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ParticipantEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) Uri uri2, @SafeParcelable.Param(id = 5) int i, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) PlayerEntity playerEntity, @SafeParcelable.Param(id = 9) int i2, @SafeParcelable.Param(id = 10) ParticipantResult participantResult, @SafeParcelable.Param(id = 11) String str4, @SafeParcelable.Param(id = 12) String str5) {
        this.a = str;
        this.b = str2;
        this.c = uri;
        this.d = uri2;
        this.e = i;
        this.f = str3;
        this.g = z;
        this.h = playerEntity;
        this.i = i2;
        this.j = participantResult;
        this.k = str4;
        this.l = str5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Participant participant) {
        return Objects.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzdn(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return Objects.equal(participant2.getPlayer(), participant.getPlayer()) && Objects.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && Objects.equal(participant2.zzdn(), participant.zzdn()) && Objects.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && Objects.equal(participant2.getDisplayName(), participant.getDisplayName()) && Objects.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && Objects.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && Objects.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && Objects.equal(participant2.getResult(), participant.getResult()) && Objects.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Participant participant) {
        return Objects.toStringHelper(participant).add("ParticipantId", participant.getParticipantId()).add("Player", participant.getPlayer()).add("Status", Integer.valueOf(participant.getStatus())).add("ClientAddress", participant.zzdn()).add("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).add("DisplayName", participant.getDisplayName()).add("IconImage", participant.getIconImageUri()).add("IconImageUrl", participant.getIconImageUrl()).add("HiResImage", participant.getHiResImageUri()).add("HiResImageUrl", participant.getHiResImageUrl()).add("Capabilities", Integer.valueOf(participant.getCapabilities())).add("Result", participant.getResult()).toString();
    }

    public static ArrayList<ParticipantEntity> zza(List<Participant> list) {
        ArrayList<ParticipantEntity> arrayList = new ArrayList<>(list.size());
        for (Participant participant : list) {
            arrayList.add(participant instanceof ParticipantEntity ? (ParticipantEntity) participant : new ParticipantEntity(participant));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Participant mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getCapabilities() {
        return this.i;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getDisplayName() {
        PlayerEntity playerEntity = this.h;
        return playerEntity == null ? this.b : playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.h;
        if (playerEntity != null) {
            playerEntity.getDisplayName(charArrayBuffer);
            return;
        }
        String str = this.b;
        if (str == null) {
            charArrayBuffer.sizeCopied = 0;
        } else {
            DataUtils.copyStringToBuffer(str, charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getHiResImageUri() {
        PlayerEntity playerEntity = this.h;
        return playerEntity == null ? this.d : playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getHiResImageUrl() {
        PlayerEntity playerEntity = this.h;
        return playerEntity == null ? this.l : playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getIconImageUri() {
        PlayerEntity playerEntity = this.h;
        return playerEntity == null ? this.c : playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getIconImageUrl() {
        PlayerEntity playerEntity = this.h;
        return playerEntity == null ? this.k : playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getParticipantId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Player getPlayer() {
        return this.h;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final ParticipantResult getResult() {
        return this.j;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getStatus() {
        return this.e;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final boolean isConnectedToRoom() {
        return this.g;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        PlayerEntity playerEntity = this.h;
        if (playerEntity != null) {
            playerEntity.setShouldDowngrade(z);
        }
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!b()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeInt(parcel, 5, getStatus());
            SafeParcelWriter.writeString(parcel, 6, this.f, false);
            SafeParcelWriter.writeBoolean(parcel, 7, isConnectedToRoom());
            SafeParcelWriter.writeParcelable(parcel, 8, getPlayer(), i, false);
            SafeParcelWriter.writeInt(parcel, 9, this.i);
            SafeParcelWriter.writeParcelable(parcel, 10, getResult(), i, false);
            SafeParcelWriter.writeString(parcel, 11, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 12, getHiResImageUrl(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
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
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        if (this.h == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.h.writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String zzdn() {
        return this.f;
    }
}
