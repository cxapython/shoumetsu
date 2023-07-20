package com.google.android.gms.games.multiplayer.turnbased;

@Deprecated
/* loaded from: classes.dex */
public interface OnTurnBasedMatchUpdateReceivedListener {
    void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    void onTurnBasedMatchRemoved(String str);
}
