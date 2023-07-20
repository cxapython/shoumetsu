package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.zzm;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzac;
import com.google.android.gms.internal.games.zzah;
import com.google.android.gms.internal.games.zzal;
import com.google.android.gms.internal.games.zzbb;
import com.google.android.gms.internal.games.zzbc;
import com.google.android.gms.internal.games.zzbd;
import com.google.android.gms.internal.games.zzbn;
import com.google.android.gms.internal.games.zzby;
import com.google.android.gms.internal.games.zzbz;
import com.google.android.gms.internal.games.zzch;
import com.google.android.gms.internal.games.zzcv;
import com.google.android.gms.internal.games.zzcz;
import com.google.android.gms.internal.games.zzdw;
import com.google.android.gms.internal.games.zzs;
import com.google.android.gms.internal.games.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class Games {
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    static final Api.ClientKey<zze> a = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zze, GamesOptions> b = new ci();
    private static final Api.AbstractClientBuilder<zze, GamesOptions> c = new cj();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    @Deprecated
    public static final Api<GamesOptions> API = new Api<>("Games.API", b, a);
    @ShowFirstParty
    public static final Scope zzam = new Scope(FirstPartyScopes.GAMES_1P);
    @ShowFirstParty
    private static final Api<GamesOptions> d = new Api<>("Games.API_1P", c, a);
    @Deprecated
    public static final GamesMetadata GamesMetadata = new zzac();
    @Deprecated
    public static final Achievements Achievements = new com.google.android.gms.internal.games.zze();
    private static final zzm e = new zzs();
    @Deprecated
    public static final Events Events = new zzu();
    @Deprecated
    public static final Leaderboards Leaderboards = new zzal();
    @Deprecated
    public static final Invitations Invitations = new zzah();
    @Deprecated
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new zzcz();
    @Deprecated
    public static final RealTimeMultiplayer RealTimeMultiplayer = new zzby();
    private static final Multiplayer f = new zzbb();
    @Deprecated
    public static final Players Players = new zzbd();
    @Deprecated
    public static final Notifications Notifications = new zzbc();
    @Deprecated
    public static final Quests Quests = new zzbn();
    @Deprecated
    public static final Requests Requests = new zzbz();
    @Deprecated
    public static final Snapshots Snapshots = new zzch();
    @Deprecated
    public static final Stats Stats = new zzcv();
    @Deprecated
    public static final Videos Videos = new zzdw();

    /* loaded from: classes.dex */
    public static final class GamesOptions implements GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions, Api.ApiOptions.Optional {
        public final boolean zzar;
        public final boolean zzas;
        public final int zzat;
        public final boolean zzau;
        public final int zzav;
        public final String zzaw;
        public final ArrayList<String> zzax;
        public final boolean zzay;
        public final boolean zzaz;
        public final boolean zzba;
        public final GoogleSignInAccount zzbb;
        public final String zzbc;

        /* loaded from: classes.dex */
        public static final class Builder {
            GoogleSignInAccount a;
            private boolean b;
            private boolean c;
            private int d;
            private boolean e;
            private int f;
            private String g;
            private ArrayList<String> h;
            private boolean i;
            private boolean j;
            private boolean k;
            private String l;

            private Builder() {
                this.b = false;
                this.c = true;
                this.d = 17;
                this.e = false;
                this.f = 4368;
                this.g = null;
                this.h = new ArrayList<>();
                this.i = false;
                this.j = false;
                this.k = false;
                this.a = null;
                this.l = null;
            }

            private Builder(GamesOptions gamesOptions) {
                this.b = false;
                this.c = true;
                this.d = 17;
                this.e = false;
                this.f = 4368;
                this.g = null;
                this.h = new ArrayList<>();
                this.i = false;
                this.j = false;
                this.k = false;
                this.a = null;
                this.l = null;
                if (gamesOptions != null) {
                    this.b = gamesOptions.zzar;
                    this.c = gamesOptions.zzas;
                    this.d = gamesOptions.zzat;
                    this.e = gamesOptions.zzau;
                    this.f = gamesOptions.zzav;
                    this.g = gamesOptions.zzaw;
                    this.h = gamesOptions.zzax;
                    this.i = gamesOptions.zzay;
                    this.j = gamesOptions.zzaz;
                    this.k = gamesOptions.zzba;
                    this.a = gamesOptions.zzbb;
                    this.l = gamesOptions.zzbc;
                }
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, ci ciVar) {
                this((GamesOptions) null);
            }

            /* synthetic */ Builder(ci ciVar) {
                this();
            }

            public final GamesOptions build() {
                return new GamesOptions(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.a, this.l, null);
            }

            public final Builder setSdkVariant(int i) {
                this.f = i;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z) {
                this.c = z;
                this.d = 17;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z, int i) {
                this.c = z;
                this.d = i;
                return this;
            }
        }

        private GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList<String> arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2) {
            this.zzar = z;
            this.zzas = z2;
            this.zzat = i;
            this.zzau = z3;
            this.zzav = i2;
            this.zzaw = str;
            this.zzax = arrayList;
            this.zzay = z4;
            this.zzaz = z5;
            this.zzba = z6;
            this.zzbb = googleSignInAccount;
            this.zzbc = str2;
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2, ci ciVar) {
            this(z, z2, i, z3, i2, str, arrayList, z4, z5, z6, googleSignInAccount, str2);
        }

        public static Builder builder() {
            return new Builder((ci) null);
        }

        public final boolean equals(Object obj) {
            String str;
            GoogleSignInAccount googleSignInAccount;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GamesOptions)) {
                return false;
            }
            GamesOptions gamesOptions = (GamesOptions) obj;
            return this.zzar == gamesOptions.zzar && this.zzas == gamesOptions.zzas && this.zzat == gamesOptions.zzat && this.zzau == gamesOptions.zzau && this.zzav == gamesOptions.zzav && ((str = this.zzaw) != null ? str.equals(gamesOptions.zzaw) : gamesOptions.zzaw == null) && this.zzax.equals(gamesOptions.zzax) && this.zzay == gamesOptions.zzay && this.zzaz == gamesOptions.zzaz && this.zzba == gamesOptions.zzba && ((googleSignInAccount = this.zzbb) != null ? googleSignInAccount.equals(gamesOptions.zzbb) : gamesOptions.zzbb == null) && TextUtils.equals(this.zzbc, gamesOptions.zzbc);
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final int getExtensionType() {
            return 1;
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions
        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzbb;
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final List<Scope> getImpliedScopes() {
            return Collections.singletonList(this.zzay ? Games.SCOPE_GAMES : Games.SCOPE_GAMES_LITE);
        }

        public final int hashCode() {
            int i = ((((((((((this.zzar ? 1 : 0) + 527) * 31) + (this.zzas ? 1 : 0)) * 31) + this.zzat) * 31) + (this.zzau ? 1 : 0)) * 31) + this.zzav) * 31;
            String str = this.zzaw;
            int i2 = 0;
            int hashCode = (((((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzax.hashCode()) * 31) + (this.zzay ? 1 : 0)) * 31) + (this.zzaz ? 1 : 0)) * 31) + (this.zzba ? 1 : 0)) * 31;
            GoogleSignInAccount googleSignInAccount = this.zzbb;
            int hashCode2 = (hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
            String str2 = this.zzbc;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode2 + i2;
        }

        @Override // com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
        public final Bundle toBundle() {
            return zzg();
        }

        public final Bundle zzg() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzar);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzas);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzat);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzau);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzav);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaw);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzax);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzay);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", this.zzaz);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", this.zzba);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzbb);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", this.zzbc);
            return bundle;
        }
    }

    @KeepForSdk
    @Deprecated
    /* loaded from: classes.dex */
    public interface GetServerAuthCodeResult extends Result {
        @KeepForSdk
        String getCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends Api.AbstractClientBuilder<zze, GamesOptions> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ci ciVar) {
            this();
        }

        @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
        public /* synthetic */ zze buildClient(Context context, Looper looper, ClientSettings clientSettings, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions2 = gamesOptions;
            if (gamesOptions2 == null) {
                gamesOptions2 = new GamesOptions.Builder((ci) null).build();
            }
            return new zze(context, looper, clientSettings, gamesOptions2, connectionCallbacks, onConnectionFailedListener);
        }

        @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
        public int getPriority() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends zza<GetServerAuthCodeResult> {
        private b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(GoogleApiClient googleApiClient, ci ciVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: createFailedResult */
        public /* synthetic */ Result mo8createFailedResult(Status status) {
            return new cm(this, status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c extends zza<Status> {
        private c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(GoogleApiClient googleApiClient, ci ciVar) {
            this(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* renamed from: createFailedResult */
        public /* synthetic */ Result mo8createFailedResult(Status status) {
            return status;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zza<T extends Result> extends BaseImplementation.ApiMethodImpl<T, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Games.a, googleApiClient);
        }
    }

    private Games() {
    }

    private static GamesOptions a(GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder builder = new GamesOptions.Builder(null, null);
        builder.a = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new AchievementsClient(activity, a(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new AchievementsClient(context, a(googleSignInAccount));
    }

    @Deprecated
    public static String getAppId(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbs();
    }

    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzav();
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, a(googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, a(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, a(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, a(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, a(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, a(googleSignInAccount));
    }

    @KeepForSdk
    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        return googleApiClient.execute(new ck(googleApiClient, str));
    }

    public static InvitationsClient getInvitationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, a(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, a(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(activity, a(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(context, a(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, a(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, a(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayerStatsClient(activity, a(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayerStatsClient(context, a(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(activity, a(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(context, a(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, a(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, a(googleSignInAccount));
    }

    @Deprecated
    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbq();
    }

    @Deprecated
    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbo();
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, a(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, a(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, a(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, a(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, a(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, a(googleSignInAccount));
    }

    @Deprecated
    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        zze zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zzk(i);
        }
    }

    @Deprecated
    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        Preconditions.checkNotNull(view);
        zze zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zza(view);
        }
    }

    @Deprecated
    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new cl(googleApiClient));
    }

    public static zze zza(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true);
    }

    public static zze zza(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzb(googleApiClient, z);
    }

    public static zze zzb(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkState(googleApiClient.hasApi(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            if (!hasConnectedApi) {
                return null;
            }
            return (zze) googleApiClient.getClient(a);
        }
        throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
    }
}
