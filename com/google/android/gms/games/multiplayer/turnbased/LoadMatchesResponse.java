package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzbd;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* loaded from: classes.dex */
public final class LoadMatchesResponse {
    private final InvitationBuffer a;
    private final TurnBasedMatchBuffer b;
    private final TurnBasedMatchBuffer c;
    private final TurnBasedMatchBuffer d;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder a = a(bundle, 0);
        if (a != null) {
            this.a = new InvitationBuffer(a);
        } else {
            this.a = null;
        }
        DataHolder a2 = a(bundle, 1);
        if (a2 != null) {
            this.b = new TurnBasedMatchBuffer(a2);
        } else {
            this.b = null;
        }
        DataHolder a3 = a(bundle, 2);
        if (a3 != null) {
            this.c = new TurnBasedMatchBuffer(a3);
        } else {
            this.c = null;
        }
        DataHolder a4 = a(bundle, 3);
        if (a4 != null) {
            this.d = new TurnBasedMatchBuffer(a4);
        } else {
            this.d = null;
        }
    }

    private static DataHolder a(Bundle bundle, int i) {
        String str;
        switch (i) {
            case 0:
                str = "TURN_STATUS_INVITED";
                break;
            case 1:
                str = "TURN_STATUS_MY_TURN";
                break;
            case 2:
                str = "TURN_STATUS_THEIR_TURN";
                break;
            case 3:
                str = "TURN_STATUS_COMPLETE";
                break;
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unknown match turn status: ");
                sb.append(i);
                zzbd.e("MatchTurnStatus", sb.toString());
                str = "TURN_STATUS_UNKNOWN";
                break;
        }
        if (!bundle.containsKey(str)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(str);
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.d;
    }

    public final InvitationBuffer getInvitations() {
        return this.a;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.b;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.c;
    }

    public final boolean hasData() {
        InvitationBuffer invitationBuffer = this.a;
        if (invitationBuffer == null || invitationBuffer.getCount() <= 0) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = this.b;
            if (turnBasedMatchBuffer != null && turnBasedMatchBuffer.getCount() > 0) {
                return true;
            }
            TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.c;
            if (turnBasedMatchBuffer2 != null && turnBasedMatchBuffer2.getCount() > 0) {
                return true;
            }
            TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.d;
            return turnBasedMatchBuffer3 != null && turnBasedMatchBuffer3.getCount() > 0;
        }
        return true;
    }

    public final void release() {
        InvitationBuffer invitationBuffer = this.a;
        if (invitationBuffer != null) {
            invitationBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.b;
        if (turnBasedMatchBuffer != null) {
            turnBasedMatchBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.c;
        if (turnBasedMatchBuffer2 != null) {
            turnBasedMatchBuffer2.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.d;
        if (turnBasedMatchBuffer3 != null) {
            turnBasedMatchBuffer3.release();
        }
    }
}
