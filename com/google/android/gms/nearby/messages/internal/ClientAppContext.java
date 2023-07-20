package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "ClientAppContextCreator")
/* loaded from: classes.dex */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zzd();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(id = 2)
    private final String b;
    @SafeParcelable.Field(id = 3)
    private final String c;
    @SafeParcelable.Field(id = 4)
    private final boolean d;
    @SafeParcelable.Field(id = 6)
    private final String e;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public final int zzhf;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ClientAppContext(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) String str3) {
        this.a = i;
        this.b = (String) Preconditions.checkNotNull(str);
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            String valueOf = String.valueOf("0p:");
            String valueOf2 = String.valueOf(str2);
            str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.c = str2;
        this.d = z;
        this.zzhf = i2;
        this.e = str3;
    }

    public ClientAppContext(String str, String str2, boolean z, String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ClientAppContext a(ClientAppContext clientAppContext, String str, String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str != null || str2 != null) {
            return new ClientAppContext(str, str2, z, null, 0);
        }
        return null;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return a(this.b, clientAppContext.b) && a(this.c, clientAppContext.c) && this.d == clientAppContext.d && a(this.e, clientAppContext.e) && this.zzhf == clientAppContext.zzhf;
    }

    public final int hashCode() {
        return Objects.hashCode(this.b, this.c, Boolean.valueOf(this.d), this.e, Integer.valueOf(this.zzhf));
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.b, this.c, Boolean.valueOf(this.d), this.e, Integer.valueOf(this.zzhf));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeString(parcel, 2, this.b, false);
        SafeParcelWriter.writeString(parcel, 3, this.c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.d);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhf);
        SafeParcelWriter.writeString(parcel, 6, this.e, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
