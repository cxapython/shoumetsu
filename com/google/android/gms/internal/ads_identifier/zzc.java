package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

/* loaded from: classes.dex */
public class zzc {
    private static final ClassLoader a = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean zza(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
