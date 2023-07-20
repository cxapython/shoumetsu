package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "PayloadTransferUpdateCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class PayloadTransferUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getPayloadId", id = 1)
    private long a;
    @SafeParcelable.Field(getter = "getStatus", id = 2)
    private int b;
    @SafeParcelable.Field(getter = "getTotalBytes", id = 3)
    private long c;
    @SafeParcelable.Field(getter = "getBytesTransferred", id = 4)
    private long d;

    @Deprecated
    /* loaded from: classes.dex */
    public static final class Builder {
        private final PayloadTransferUpdate a = new PayloadTransferUpdate();

        public Builder() {
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate) {
            this.a.a = payloadTransferUpdate.a;
            this.a.b = payloadTransferUpdate.b;
            this.a.c = payloadTransferUpdate.c;
            this.a.d = payloadTransferUpdate.d;
        }

        public final PayloadTransferUpdate build() {
            return this.a;
        }

        public final Builder setBytesTransferred(long j) {
            this.a.d = j;
            return this;
        }

        public final Builder setPayloadId(long j) {
            this.a.a = j;
            return this;
        }

        public final Builder setStatus(int i) {
            this.a.b = i;
            return this;
        }

        public final Builder setTotalBytes(long j) {
            this.a.c = j;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    private PayloadTransferUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PayloadTransferUpdate(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) long j3) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.d = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            if (Objects.equal(Long.valueOf(this.a), Long.valueOf(payloadTransferUpdate.a)) && Objects.equal(Integer.valueOf(this.b), Integer.valueOf(payloadTransferUpdate.b)) && Objects.equal(Long.valueOf(this.c), Long.valueOf(payloadTransferUpdate.c)) && Objects.equal(Long.valueOf(this.d), Long.valueOf(payloadTransferUpdate.d))) {
                return true;
            }
        }
        return false;
    }

    public final long getBytesTransferred() {
        return this.d;
    }

    public final long getPayloadId() {
        return this.a;
    }

    public final int getStatus() {
        return this.b;
    }

    public final long getTotalBytes() {
        return this.c;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getPayloadId());
        SafeParcelWriter.writeInt(parcel, 2, getStatus());
        SafeParcelWriter.writeLong(parcel, 3, getTotalBytes());
        SafeParcelWriter.writeLong(parcel, 4, getBytesTransferred());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
