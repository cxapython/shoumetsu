package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "WakeLockEventCreator")
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long b;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private int c;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String d;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String e;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String f;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int g;
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    private final List<String> h;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String i;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long j;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private int k;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String l;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float m;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long n;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean o;
    private long p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 14) int i4, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f, @SafeParcelable.Param(id = 16) long j3, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str3;
        this.f = str5;
        this.g = i3;
        this.p = -1L;
        this.h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.l = str4;
        this.m = f;
        this.n = j3;
        this.o = z;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeLong(parcel, 2, getTimeMillis());
        SafeParcelWriter.writeString(parcel, 4, this.d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.g);
        SafeParcelWriter.writeStringList(parcel, 6, this.h, false);
        SafeParcelWriter.writeLong(parcel, 8, this.j);
        SafeParcelWriter.writeString(parcel, 10, this.e, false);
        SafeParcelWriter.writeInt(parcel, 11, getEventType());
        SafeParcelWriter.writeString(parcel, 12, this.i, false);
        SafeParcelWriter.writeString(parcel, 13, this.l, false);
        SafeParcelWriter.writeInt(parcel, 14, this.k);
        SafeParcelWriter.writeFloat(parcel, 15, this.m);
        SafeParcelWriter.writeLong(parcel, 16, this.n);
        SafeParcelWriter.writeString(parcel, 17, this.f, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.o);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzu() {
        return this.p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzv() {
        String str = this.d;
        int i = this.g;
        List<String> list = this.h;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.k;
        String str2 = this.e;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.l;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.m;
        String str4 = this.f;
        if (str4 == null) {
            str4 = "";
        }
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }
}
