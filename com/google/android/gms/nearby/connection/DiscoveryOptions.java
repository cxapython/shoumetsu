package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DiscoveryOptionsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getStrategy", id = 1)
    private Strategy a;
    @SafeParcelable.Field(defaultValue = "false", getter = "getForwardUnrecognizedBluetoothDevices", id = 2)
    private boolean b;
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBluetooth", id = 3)
    private boolean c;
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBle", id = 4)
    private boolean d;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final DiscoveryOptions a = new DiscoveryOptions();

        public Builder() {
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            this.a.a = discoveryOptions.a;
            this.a.b = discoveryOptions.b;
            this.a.c = discoveryOptions.c;
            this.a.d = discoveryOptions.d;
        }

        public final DiscoveryOptions build() {
            return this.a;
        }

        public final Builder setStrategy(Strategy strategy) {
            this.a.a = strategy;
            return this;
        }
    }

    private DiscoveryOptions() {
        this.b = false;
        this.c = true;
        this.d = true;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
        this.b = false;
        this.c = true;
        this.d = true;
        this.a = strategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DiscoveryOptions(@SafeParcelable.Param(id = 1) Strategy strategy, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.b = false;
        this.c = true;
        this.d = true;
        this.a = strategy;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (Objects.equal(this.a, discoveryOptions.a) && Objects.equal(Boolean.valueOf(this.b), Boolean.valueOf(discoveryOptions.b)) && Objects.equal(Boolean.valueOf(this.c), Boolean.valueOf(discoveryOptions.c)) && Objects.equal(Boolean.valueOf(this.d), Boolean.valueOf(discoveryOptions.d))) {
                return true;
            }
        }
        return false;
    }

    public final Strategy getStrategy() {
        return this.a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a, Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
