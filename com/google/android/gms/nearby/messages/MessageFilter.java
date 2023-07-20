package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@SafeParcelable.Class(creator = "MessageFilterCreator")
/* loaded from: classes.dex */
public class MessageFilter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzc();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    @SafeParcelable.VersionField(id = 1000)
    private final int a;
    @SafeParcelable.Field(getter = "getMessageTypes", id = 1)
    private final List<zzad> b;
    @SafeParcelable.Field(getter = "getDeviceFilters", id = 2)
    private final List<zzgu> c;
    @SafeParcelable.Field(getter = "getIncludeAllMyTypes", id = 3)
    private final boolean d;
    @SafeParcelable.Field(getter = "getBleFilters", id = 4)
    private final List<zzgp> e;
    @SafeParcelable.Field(getter = "getNumRawAudioBytes", id = 5)
    private final int f;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean d;
        private final Set<zzad> a = new HashSet();
        private final List<zzgu> b = new ArrayList();
        private final Set<zzgp> c = new HashSet();
        private int e = 0;

        private final Builder a(String str, String str2) {
            this.a.add(new zzad(str, str2));
            return this;
        }

        public final MessageFilter build() {
            Preconditions.checkState(this.d || !this.a.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(new ArrayList(this.a), this.b, this.d, new ArrayList(this.c), this.e);
        }

        public final Builder includeAllMyTypes() {
            this.d = true;
            return this;
        }

        public final Builder includeAudioBytes(int i) {
            boolean z = true;
            Preconditions.checkArgument(this.e == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            boolean z2 = i > 0;
            StringBuilder sb = new StringBuilder(44);
            sb.append("Invalid value for numAudioBytes: ");
            sb.append(i);
            Preconditions.checkArgument(z2, sb.toString());
            if (i > 10) {
                z = false;
            }
            Preconditions.checkArgument(z, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.e = i;
            return this;
        }

        public final Builder includeEddystoneUids(String str, String str2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.b.add(zzgu.zzb(str, str2));
            return this;
        }

        public final Builder includeFilter(MessageFilter messageFilter) {
            this.a.addAll(messageFilter.zzaa());
            this.b.addAll(messageFilter.a());
            this.c.addAll(messageFilter.zzad());
            this.d = messageFilter.zzab() | this.d;
            return this;
        }

        public final Builder includeIBeaconIds(UUID uuid, Short sh, Short sh2) {
            a(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.b.add(zzgu.zza(uuid, sh, sh2));
            return this;
        }

        public final Builder includeNamespacedType(String str, String str2) {
            Preconditions.checkArgument(str != null && !str.isEmpty() && !str.contains("*"), "namespace(%s) cannot be null, empty or contain (*).", str);
            Preconditions.checkArgument(str2 != null && !str2.contains("*"), "type(%s) cannot be null or contain (*).", str2);
            return a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MessageFilter(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) List<zzad> list, @SafeParcelable.Param(id = 2) List<zzgu> list2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) List<zzgp> list3, @SafeParcelable.Param(id = 5) int i2) {
        this.a = i;
        this.b = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.d = z;
        this.c = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.e = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.f = i2;
    }

    private MessageFilter(List<zzad> list, List<zzgu> list2, boolean z, List<zzgp> list3, int i) {
        this(2, list, list2, z, list3, i);
    }

    final List<zzgu> a() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.d == messageFilter.d && Objects.equal(this.b, messageFilter.b) && Objects.equal(this.c, messageFilter.c) && Objects.equal(this.e, messageFilter.e);
    }

    public int hashCode() {
        return Objects.hashCode(this.b, this.c, Boolean.valueOf(this.d), this.e);
    }

    public String toString() {
        boolean z = this.d;
        String valueOf = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
        sb.append("MessageFilter{includeAllMyTypes=");
        sb.append(z);
        sb.append(", messageTypes=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.b, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.d);
        SafeParcelWriter.writeTypedList(parcel, 4, this.e, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f);
        SafeParcelWriter.writeInt(parcel, 1000, this.a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzad> zzaa() {
        return this.b;
    }

    public final boolean zzab() {
        return this.d;
    }

    public final List<zzgp> zzad() {
        return this.e;
    }
}
