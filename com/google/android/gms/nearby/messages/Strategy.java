package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@SafeParcelable.Class(creator = "StrategyCreator")
@Immutable
/* loaded from: classes.dex */
public class Strategy extends AbstractSafeParcelable {
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzg();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    private static final Strategy a;
    @SafeParcelable.VersionField(id = 1000)
    private final int b;
    @SafeParcelable.Field(id = 1)
    @Deprecated
    private final int c;
    @SafeParcelable.Field(id = 2)
    private final int d;
    @SafeParcelable.Field(id = 3)
    private final int e;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    private final boolean f;
    @SafeParcelable.Field(getter = "getDiscoveryMedium", id = 5)
    private final int g;
    @SafeParcelable.Field(getter = "getDiscoveryMode", id = 6)
    private final int h;
    @SafeParcelable.Field(getter = "getBackgroundScanMode", id = 7)
    private final int i;

    /* loaded from: classes.dex */
    public static class Builder {
        private int a = 3;
        private int b = 300;
        private int c = 0;
        private int d = -1;
        private int e = 0;

        public Strategy build() {
            if (this.d == 2 && this.c == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.b, this.c, false, this.d, this.a, 0);
        }

        public Builder setDiscoveryMode(int i) {
            this.a = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.c = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            Preconditions.checkArgument(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), Integer.valueOf((int) Strategy.TTL_SECONDS_MAX));
            this.b = i;
            return this;
        }

        public final Builder zze(int i) {
            this.d = 2;
            return this;
        }
    }

    static {
        Strategy build = new Builder().zze(2).setTtlSeconds(Integer.MAX_VALUE).build();
        BLE_ONLY = build;
        a = build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Strategy(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) int i6, @SafeParcelable.Param(id = 7) int i7) {
        int i8;
        this.b = i;
        this.c = i2;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    i8 = 1;
                    this.h = i8;
                    break;
                case 3:
                    this.h = 2;
                    break;
                default:
                    i8 = 3;
                    this.h = i8;
                    break;
            }
        } else {
            this.h = i6;
        }
        this.e = i4;
        this.f = z;
        if (z) {
            this.g = 2;
            this.d = Integer.MAX_VALUE;
        } else {
            this.d = i3;
            if (i5 != 6) {
                switch (i5) {
                    case -1:
                    case 0:
                    case 1:
                        break;
                    default:
                        this.g = i5;
                        break;
                }
            }
            this.g = -1;
        }
        this.i = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.b == strategy.b && this.h == strategy.h && this.d == strategy.d && this.e == strategy.e && this.g == strategy.g && this.i == strategy.i;
    }

    public int hashCode() {
        return (((((((((this.b * 31) + this.h) * 31) + this.d) * 31) + this.e) * 31) + this.g) * 31) + this.i;
    }

    public String toString() {
        String str;
        String obj;
        String obj2;
        String str2;
        int i = this.d;
        int i2 = this.e;
        switch (i2) {
            case 0:
                str = "DEFAULT";
                break;
            case 1:
                str = "EARSHOT";
                break;
            default:
                StringBuilder sb = new StringBuilder(19);
                sb.append("UNKNOWN:");
                sb.append(i2);
                str = sb.toString();
                break;
        }
        int i3 = this.g;
        if (i3 == -1) {
            obj = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append("UNKNOWN:");
                sb2.append(i3);
                obj = sb2.toString();
            } else {
                obj = arrayList.toString();
            }
        }
        int i4 = this.h;
        if (i4 == 3) {
            obj2 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                StringBuilder sb3 = new StringBuilder(19);
                sb3.append("UNKNOWN:");
                sb3.append(i4);
                obj2 = sb3.toString();
            } else {
                obj2 = arrayList2.toString();
            }
        }
        int i5 = this.i;
        switch (i5) {
            case 0:
                str2 = "DEFAULT";
                break;
            case 1:
                str2 = "ALWAYS_ON";
                break;
            default:
                StringBuilder sb4 = new StringBuilder(20);
                sb4.append("UNKNOWN: ");
                sb4.append(i5);
                str2 = sb4.toString();
                break;
        }
        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 102 + String.valueOf(obj).length() + String.valueOf(obj2).length() + String.valueOf(str2).length());
        sb5.append("Strategy{ttlSeconds=");
        sb5.append(i);
        sb5.append(", distanceType=");
        sb5.append(str);
        sb5.append(", discoveryMedium=");
        sb5.append(obj);
        sb5.append(", discoveryMode=");
        sb5.append(obj2);
        sb5.append(", backgroundScanMode=");
        sb5.append(str2);
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.c);
        SafeParcelWriter.writeInt(parcel, 2, this.d);
        SafeParcelWriter.writeInt(parcel, 3, this.e);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f);
        SafeParcelWriter.writeInt(parcel, 5, this.g);
        SafeParcelWriter.writeInt(parcel, 6, this.h);
        SafeParcelWriter.writeInt(parcel, 7, this.i);
        SafeParcelWriter.writeInt(parcel, 1000, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzae() {
        return this.i;
    }
}
