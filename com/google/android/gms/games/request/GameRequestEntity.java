package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.james.mime4j.field.FieldName;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "GameRequestEntityCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes.dex */
public final class GameRequestEntity extends zzd implements GameRequest {
    public static final Parcelable.Creator<GameRequestEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getGame", id = 1)
    private final GameEntity a;
    @SafeParcelable.Field(getter = "getSender", id = 2)
    private final PlayerEntity b;
    @SafeParcelable.Field(getter = "getData", id = 3)
    private final byte[] c;
    @SafeParcelable.Field(getter = "getRequestId", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getRecipients", id = 5)
    private final ArrayList<PlayerEntity> e;
    @SafeParcelable.Field(getter = "getType", id = 7)
    private final int f;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 9)
    private final long g;
    @SafeParcelable.Field(getter = "getExpirationTimestamp", id = 10)
    private final long h;
    @SafeParcelable.Field(getter = "getRecipientStatusBundle", id = 11)
    private final Bundle i;
    @SafeParcelable.Field(getter = "getStatus", id = 12)
    private final int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GameRequestEntity(@SafeParcelable.Param(id = 1) GameEntity gameEntity, @SafeParcelable.Param(id = 2) PlayerEntity playerEntity, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) ArrayList<PlayerEntity> arrayList, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 9) long j, @SafeParcelable.Param(id = 10) long j2, @SafeParcelable.Param(id = 11) Bundle bundle, @SafeParcelable.Param(id = 12) int i2) {
        this.a = gameEntity;
        this.b = playerEntity;
        this.c = bArr;
        this.d = str;
        this.e = arrayList;
        this.f = i;
        this.g = j;
        this.h = j2;
        this.i = bundle;
        this.j = i2;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.a = new GameEntity(gameRequest.getGame());
        this.b = new PlayerEntity(gameRequest.getSender());
        this.d = gameRequest.getRequestId();
        this.f = gameRequest.getType();
        this.g = gameRequest.getCreationTimestamp();
        this.h = gameRequest.getExpirationTimestamp();
        this.j = gameRequest.getStatus();
        byte[] data = gameRequest.getData();
        if (data == null) {
            this.c = null;
        } else {
            this.c = new byte[data.length];
            System.arraycopy(data, 0, this.c, 0, data.length);
        }
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.e = new ArrayList<>(size);
        this.i = new Bundle();
        for (int i = 0; i < size; i++) {
            Player freeze = recipients.get(i).mo28freeze();
            String playerId = freeze.getPlayerId();
            this.e.add((PlayerEntity) freeze);
            this.i.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(GameRequest gameRequest) {
        return (Arrays.hashCode(c(gameRequest)) * 31) + Objects.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return Objects.equal(gameRequest2.getGame(), gameRequest.getGame()) && Objects.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && Objects.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && Objects.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(c(gameRequest2), c(gameRequest)) && Objects.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && Objects.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && Objects.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(GameRequest gameRequest) {
        return Objects.toStringHelper(gameRequest).add("Game", gameRequest.getGame()).add(FieldName.SENDER, gameRequest.getSender()).add("Recipients", gameRequest.getRecipients()).add("Data", gameRequest.getData()).add("RequestId", gameRequest.getRequestId()).add("Type", Integer.valueOf(gameRequest.getType())).add("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).add("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    private static int[] c(GameRequest gameRequest) {
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(recipients.get(i).getPlayerId());
        }
        return iArr;
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* bridge */ /* synthetic */ GameRequest mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getCreationTimestamp() {
        return this.g;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final byte[] getData() {
        return this.c;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getExpirationTimestamp() {
        return this.h;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Game getGame() {
        return this.a;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getRecipientStatus(String str) {
        return this.i.getInt(str, 0);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final List<Player> getRecipients() {
        return new ArrayList(this.e);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final String getRequestId() {
        return this.d;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Player getSender() {
        return this.b;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getStatus() {
        return this.j;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getType() {
        return this.f;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
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
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getSender(), i, false);
        SafeParcelWriter.writeByteArray(parcel, 3, getData(), false);
        SafeParcelWriter.writeString(parcel, 4, getRequestId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getRecipients(), false);
        SafeParcelWriter.writeInt(parcel, 7, getType());
        SafeParcelWriter.writeLong(parcel, 9, getCreationTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getExpirationTimestamp());
        SafeParcelWriter.writeBundle(parcel, 11, this.i, false);
        SafeParcelWriter.writeInt(parcel, 12, getStatus());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
