package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AdvertisingOptionsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class AdvertisingOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getStrategy", id = 1)
    private Strategy a;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAutoUpgradeBandwidth", id = 2)
    private boolean b;
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnforceTopologyConstraints", id = 3)
    private boolean c;
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBluetooth", id = 4)
    private boolean d;
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBle", id = 5)
    private boolean e;
    @SafeParcelable.Field(getter = "getNearbyNotificationsBeaconData", id = 6)
    private byte[] f;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final AdvertisingOptions a = new AdvertisingOptions();

        public Builder() {
        }

        public Builder(AdvertisingOptions advertisingOptions) {
            this.a.a = advertisingOptions.a;
            this.a.b = advertisingOptions.b;
            this.a.c = advertisingOptions.c;
            this.a.d = advertisingOptions.d;
            this.a.e = advertisingOptions.e;
            this.a.f = advertisingOptions.f;
        }

        public final AdvertisingOptions build() {
            return this.a;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.a.a = strategy;
            return this;
        }
    }

    private AdvertisingOptions() {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
    }

    @Deprecated
    public AdvertisingOptions(Strategy strategy) {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.a = strategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdvertisingOptions(@SafeParcelable.Param(id = 1) Strategy strategy, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) boolean z4, @SafeParcelable.Param(id = 6) byte[] bArr) {
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.a = strategy;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            if (Objects.equal(this.a, advertisingOptions.a) && Objects.equal(Boolean.valueOf(this.b), Boolean.valueOf(advertisingOptions.b)) && Objects.equal(Boolean.valueOf(this.c), Boolean.valueOf(advertisingOptions.c)) && Objects.equal(Boolean.valueOf(this.d), Boolean.valueOf(advertisingOptions.d)) && Objects.equal(Boolean.valueOf(this.e), Boolean.valueOf(advertisingOptions.e)) && Arrays.equals(this.f, advertisingOptions.f)) {
                return true;
            }
        }
        return false;
    }

    public final Strategy getStrategy() {
        return this.a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Integer.valueOf(Arrays.hashCode(this.f)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.e);
        SafeParcelWriter.writeByteArray(parcel, 6, this.f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
