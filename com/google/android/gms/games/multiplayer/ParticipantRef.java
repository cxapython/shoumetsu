package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class ParticipantRef extends DataBufferRef implements Participant {
    private final PlayerRef c;

    public ParticipantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.c = new PlayerRef(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return ParticipantEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Participant mo28freeze() {
        return new ParticipantEntity(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getCapabilities() {
        return b("capabilities");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getDisplayName() {
        return h("external_player_id") ? d("default_display_name") : this.c.getDisplayName();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (h("external_player_id")) {
            a("default_display_name", charArrayBuffer);
        } else {
            this.c.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getHiResImageUri() {
        return h("external_player_id") ? g("default_display_hi_res_image_uri") : this.c.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getHiResImageUrl() {
        return h("external_player_id") ? d("default_display_hi_res_image_url") : this.c.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getIconImageUri() {
        return h("external_player_id") ? g("default_display_image_uri") : this.c.getIconImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getIconImageUrl() {
        return h("external_player_id") ? d("default_display_image_url") : this.c.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getParticipantId() {
        return d("external_participant_id");
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Player getPlayer() {
        if (h("external_player_id")) {
            return null;
        }
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final ParticipantResult getResult() {
        if (h("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), b("result_type"), b("placing"));
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getStatus() {
        return b("player_status");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return ParticipantEntity.a(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final boolean isConnectedToRoom() {
        return b("connected") > 0;
    }

    public final String toString() {
        return ParticipantEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) ((Participant) mo28freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String zzdn() {
        return d("client_address");
    }
}
