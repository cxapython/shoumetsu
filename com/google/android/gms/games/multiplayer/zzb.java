package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import net.gree.gamelib.payment.internal.a.e;

/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements Invitation {
    private final Game c;
    private final ParticipantRef d;
    private final ArrayList<Participant> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = new GameRef(dataHolder, i);
        this.e = new ArrayList<>(i2);
        String d = d("external_inviter_id");
        ParticipantRef participantRef = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef2 = new ParticipantRef(this.a, this.b + i3);
            if (participantRef2.getParticipantId().equals(d)) {
                participantRef = participantRef2;
            }
            this.e.add(participantRef2);
        }
        this.d = (ParticipantRef) Preconditions.checkNotNull(participantRef, "Must have a valid inviter!");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return InvitationEntity.a(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final /* synthetic */ Invitation mo28freeze() {
        return new InvitationEntity(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getAvailableAutoMatchSlots() {
        if (!c("has_automatch_criteria")) {
            return 0;
        }
        return b("automatch_max_players");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final long getCreationTimestamp() {
        return Math.max(a("creation_timestamp"), a("last_modified_timestamp"));
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Game getGame() {
        return this.c;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final String getInvitationId() {
        return d("external_invitation_id");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getInvitationType() {
        return b(e.J);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Participant getInviter() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public final ArrayList<Participant> getParticipants() {
        return this.e;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getVariant() {
        return b("variant");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return InvitationEntity.a(this);
    }

    public final String toString() {
        return InvitationEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) ((Invitation) mo28freeze())).writeToParcel(parcel, i);
    }
}
