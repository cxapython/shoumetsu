package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;

@SafeParcelable.Class(creator = "MessageCreator")
/* loaded from: classes.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    @SafeParcelable.VersionField(id = 1000)
    private final int b;
    @SafeParcelable.Field(getter = "getContent", id = 1)
    private final byte[] c;
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final String d;
    @SafeParcelable.Field(getter = "getNamespace", id = 3)
    private final String e;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    private final zzgs[] f;
    @SafeParcelable.Field(getter = "getProjectId", id = 5)
    private final long g;
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final zzgs[] a = {zzgs.zzgv};

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Message(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) byte[] bArr, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 4) zzgs[] zzgsVarArr, @SafeParcelable.Param(id = 5) long j) {
        this.b = i;
        this.d = (String) Preconditions.checkNotNull(str2);
        this.e = str == null ? "" : str;
        this.g = j;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), Integer.valueOf((int) MAX_CONTENT_SIZE_BYTES));
        this.c = bArr;
        this.f = (zzgsVarArr == null || zzgsVarArr.length == 0) ? a : zzgsVarArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public Message(byte[] bArr) {
        this(bArr, "", "");
    }

    public Message(byte[] bArr, String str) {
        this(bArr, "", str);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, a);
    }

    private Message(byte[] bArr, String str, String str2, zzgs[] zzgsVarArr) {
        this(bArr, str, str2, zzgsVarArr, 0L);
    }

    private Message(byte[] bArr, String str, String str2, zzgs[] zzgsVarArr, long j) {
        this(2, bArr, str, str2, zzgsVarArr, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.e, message.e) && TextUtils.equals(this.d, message.d) && Arrays.equals(this.c, message.c) && this.g == message.g;
    }

    public byte[] getContent() {
        return this.c;
    }

    public String getNamespace() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public int hashCode() {
        return Objects.hashCode(this.e, this.d, Integer.valueOf(Arrays.hashCode(this.c)), Long.valueOf(this.g));
    }

    public String toString() {
        String str = this.e;
        String str2 = this.d;
        byte[] bArr = this.c;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59 + String.valueOf(str2).length());
        sb.append("Message{namespace='");
        sb.append(str);
        sb.append("', type='");
        sb.append(str2);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.f, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.g);
        SafeParcelWriter.writeInt(parcel, 1000, this.b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zzl(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }
}
