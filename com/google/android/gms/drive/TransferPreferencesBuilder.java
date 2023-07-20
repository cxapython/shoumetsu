package com.google.android.gms.drive;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public class TransferPreferencesBuilder {
    public static final TransferPreferences DEFAULT_PREFERENCES = new a(1, true, 256);
    private int a;
    private boolean b;
    private int c;

    /* loaded from: classes.dex */
    static class a implements TransferPreferences {
        private final int a;
        private final boolean b;
        private final int c;

        a(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (aVar.a == this.a && aVar.b == this.b && aVar.c == this.c) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getBatteryUsagePreference() {
            return this.c;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getNetworkPreference() {
            return this.a;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.a), Boolean.valueOf(this.b), Integer.valueOf(this.c));
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final boolean isRoamingAllowed() {
            return this.b;
        }

        public final String toString() {
            return String.format("NetworkPreference: %s, IsRoamingAllowed %s, BatteryUsagePreference %s", Integer.valueOf(this.a), Boolean.valueOf(this.b), Integer.valueOf(this.c));
        }
    }

    public TransferPreferencesBuilder() {
        this(DEFAULT_PREFERENCES);
    }

    public TransferPreferencesBuilder(FileUploadPreferences fileUploadPreferences) {
        this.a = fileUploadPreferences.getNetworkTypePreference();
        this.b = fileUploadPreferences.isRoamingAllowed();
        this.c = fileUploadPreferences.getBatteryUsagePreference();
    }

    public TransferPreferencesBuilder(TransferPreferences transferPreferences) {
        this.a = transferPreferences.getNetworkPreference();
        this.b = transferPreferences.isRoamingAllowed();
        this.c = transferPreferences.getBatteryUsagePreference();
    }

    public TransferPreferences build() {
        return new a(this.a, this.b, this.c);
    }

    public TransferPreferencesBuilder setBatteryUsagePreference(int i) {
        this.c = i;
        return this;
    }

    public TransferPreferencesBuilder setIsRoamingAllowed(boolean z) {
        this.b = z;
        return this;
    }

    public TransferPreferencesBuilder setNetworkPreference(int i) {
        this.a = i;
        return this;
    }
}
