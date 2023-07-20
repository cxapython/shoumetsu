package com.google.android.gms.games.video;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class CaptureState {
    private final boolean a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    private CaptureState(boolean z, int i, int i2, boolean z2, boolean z3) {
        Preconditions.checkArgument(VideoConfiguration.isValidCaptureMode(i, true));
        Preconditions.checkArgument(VideoConfiguration.isValidQualityLevel(i2, true));
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = z2;
        this.e = z3;
    }

    public static CaptureState zzb(Bundle bundle) {
        if (bundle == null || bundle.get("IsCapturing") == null) {
            return null;
        }
        return new CaptureState(bundle.getBoolean("IsCapturing", false), bundle.getInt("CaptureMode", -1), bundle.getInt("CaptureQuality", -1), bundle.getBoolean("IsOverlayVisible", false), bundle.getBoolean("IsPaused", false));
    }

    public final int getCaptureMode() {
        return this.b;
    }

    public final int getCaptureQuality() {
        return this.c;
    }

    public final boolean isCapturing() {
        return this.a;
    }

    public final boolean isOverlayVisible() {
        return this.d;
    }

    public final boolean isPaused() {
        return this.e;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("IsCapturing", Boolean.valueOf(this.a)).add("CaptureMode", Integer.valueOf(this.b)).add("CaptureQuality", Integer.valueOf(this.c)).add("IsOverlayVisible", Boolean.valueOf(this.d)).add("IsPaused", Boolean.valueOf(this.e)).toString();
    }
}
