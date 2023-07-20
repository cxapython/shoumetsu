package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: classes.dex */
public class TurnBasedMultiplayerClient extends zzt {
    private static final zzbl<TurnBasedMatch> b = new bw();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchesResult, LoadMatchesResponse> c = new bf();
    private static final zzbm<TurnBasedMultiplayer.LoadMatchesResult> d = new bg();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchResult, TurnBasedMatch> e = new bh();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.CancelMatchResult, String> f = new bi();
    private static final zzbn g = new bj();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, Void> h = new bk();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, TurnBasedMatch> i = new bl();
    private static final zzbn j = new bm();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> k = new bn();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.InitiateMatchResult, TurnBasedMatch> l = new bo();

    /* loaded from: classes.dex */
    public static class MatchOutOfDateApiException extends ApiException {
        protected final TurnBasedMatch b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MatchOutOfDateApiException(Status status, TurnBasedMatch turnBasedMatch) {
            super(status);
            this.b = turnBasedMatch;
        }

        public TurnBasedMatch getMatch() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TurnBasedMultiplayerClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TurnBasedMultiplayerClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    private static Task<Void> a(PendingResult<TurnBasedMultiplayer.LeaveMatchResult> pendingResult) {
        return zzbe.zza(pendingResult, g, h, i, b);
    }

    private static Task<TurnBasedMatch> b(PendingResult<TurnBasedMultiplayer.UpdateMatchResult> pendingResult) {
        zzbn zzbnVar = j;
        PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> resultConverter = k;
        return zzbe.zza(pendingResult, zzbnVar, resultConverter, resultConverter, b);
    }

    public Task<TurnBasedMatch> acceptInvitation(String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.acceptInvitation(asGoogleApiClient(), str), l);
    }

    public Task<String> cancelMatch(String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.cancelMatch(asGoogleApiClient(), str), f);
    }

    public Task<TurnBasedMatch> createMatch(TurnBasedMatchConfig turnBasedMatchConfig) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.createMatch(asGoogleApiClient(), turnBasedMatchConfig), l);
    }

    public Task<Void> declineInvitation(String str) {
        return doWrite(new bs(this, str));
    }

    public Task<Void> dismissInvitation(String str) {
        return doWrite(new bt(this, str));
    }

    public Task<Void> dismissMatch(String str) {
        return doWrite(new bv(this, str));
    }

    public Task<TurnBasedMatch> finishMatch(String str) {
        return b(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str));
    }

    public Task<TurnBasedMatch> finishMatch(String str, byte[] bArr, List<ParticipantResult> list) {
        return b(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, list));
    }

    public Task<TurnBasedMatch> finishMatch(String str, byte[] bArr, ParticipantResult... participantResultArr) {
        return b(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, participantResultArr));
    }

    public Task<Intent> getInboxIntent() {
        return doRead(new be(this));
    }

    public Task<Integer> getMaxMatchDataSize() {
        return doRead(new bu(this));
    }

    public Task<Intent> getSelectOpponentsIntent(int i2, int i3) {
        return getSelectOpponentsIntent(i2, i3, true);
    }

    public Task<Intent> getSelectOpponentsIntent(int i2, int i3, boolean z) {
        return doRead(new br(this, i2, i3, z));
    }

    public Task<Void> leaveMatch(String str) {
        return a(Games.TurnBasedMultiplayer.leaveMatch(asGoogleApiClient(), str));
    }

    public Task<Void> leaveMatchDuringTurn(String str, String str2) {
        return a(Games.TurnBasedMultiplayer.leaveMatchDuringTurn(asGoogleApiClient(), str, str2));
    }

    public Task<AnnotatedData<TurnBasedMatch>> loadMatch(String str) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatch(asGoogleApiClient(), str), e);
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(int i2, int[] iArr) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), i2, iArr), c, d);
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(int[] iArr) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), iArr), c, d);
    }

    public Task<Void> registerTurnBasedMatchUpdateCallback(TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        ListenerHolder<L> registerListener = registerListener(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName());
        return doRegisterEventListener(new bp(this, registerListener, registerListener), new bq(this, registerListener.getListenerKey()));
    }

    public Task<TurnBasedMatch> rematch(String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.rematch(asGoogleApiClient(), str), l);
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2) {
        return b(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2));
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return b(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, list));
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        return b(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, participantResultArr));
    }

    public Task<Boolean> unregisterTurnBasedMatchUpdateCallback(TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName()));
    }
}
