package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "VideoConfigurationCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new zzb();
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    @SafeParcelable.Field(getter = "getQualityLevel", id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getCaptureMode", id = 2)
    private final int b;
    @SafeParcelable.Field(getter = "shouldShowToastAfterRecording", id = 7)
    private final boolean c;
    @SafeParcelable.Field(getter = "getCameraEnabled", id = 8)
    private final boolean d;
    @SafeParcelable.Field(getter = "getMicEnabled", id = 9)
    private final boolean e;

    /* loaded from: classes.dex */
    public static final class Builder {
        private int a;
        private int b;
        private boolean d = true;
        private boolean e = true;
        private boolean c = true;

        public Builder(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final VideoConfiguration build() {
            return new VideoConfiguration(this.a, this.b, this.c, this.d, this.e);
        }

        public final Builder setCameraEnabled(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder setCaptureMode(int i) {
            this.b = i;
            return this;
        }

        public final Builder setMicEnabled(boolean z) {
            this.e = z;
            return this;
        }

        public final Builder setQualityLevel(int i) {
            this.a = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ValidCaptureModes {
    }

    @SafeParcelable.Constructor
    public VideoConfiguration(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) boolean z3) {
        Preconditions.checkArgument(isValidQualityLevel(i, false));
        Preconditions.checkArgument(isValidCaptureMode(i2, false));
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
        this.e = z3;
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        switch (i) {
            case -1:
            case 1:
                return z;
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        switch (i) {
            case -1:
                return z;
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public final boolean getCameraEnabled() {
        return this.d;
    }

    public final int getCaptureMode() {
        return this.b;
    }

    public final boolean getMicEnabled() {
        return this.e;
    }

    public final int getQualityLevel() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getQualityLevel());
        SafeParcelWriter.writeInt(parcel, 2, getCaptureMode());
        SafeParcelWriter.writeBoolean(parcel, 7, this.c);
        SafeParcelWriter.writeBoolean(parcel, 8, getCameraEnabled());
        SafeParcelWriter.writeBoolean(parcel, 9, getMicEnabled());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
