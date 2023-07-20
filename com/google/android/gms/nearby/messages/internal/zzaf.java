package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Message;

@SafeParcelable.Class(creator = "MessageWrapperCreator")
/* loaded from: classes.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    @SafeParcelable.VersionField(id = 1000)
    private final int a;
    @SafeParcelable.Field(id = 1)
    private final Message b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaf(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) Message message) {
        this.a = i;
        this.b = (Message) Preconditions.checkNotNull(message);
    }

    public static final zzaf zza(Message message) {
        return new zzaf(1, message);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaf) {
            return Objects.equal(this.b, ((zzaf) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.b);
    }

    public final String toString() {
        String message = this.b.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 24);
        sb.append("MessageWrapper{message=");
        sb.append(message);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.b, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
