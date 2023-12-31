package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.internal.player.zza;

@VisibleForTesting
/* loaded from: classes.dex */
public interface Player extends Parcelable, Freezable<Player> {
    public static final long CURRENT_XP_UNKNOWN = -1;
    public static final long TIMESTAMP_UNKNOWN = -1;

    Uri getBannerImageLandscapeUri();

    @KeepName
    @Deprecated
    String getBannerImageLandscapeUrl();

    Uri getBannerImagePortraitUri();

    @KeepName
    @Deprecated
    String getBannerImagePortraitUrl();

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getHiResImageUri();

    @KeepName
    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @KeepName
    @Deprecated
    String getIconImageUrl();

    long getLastPlayedWithTimestamp();

    PlayerLevelInfo getLevelInfo();

    String getName();

    String getPlayerId();

    long getRetrievedTimestamp();

    String getTitle();

    void getTitle(CharArrayBuffer charArrayBuffer);

    boolean hasHiResImage();

    boolean hasIconImage();

    boolean isMuted();

    String zzh();

    boolean zzi();

    @Deprecated
    int zzj();

    boolean zzk();

    zza zzl();

    int zzm();

    long zzn();

    long zzo();
}
