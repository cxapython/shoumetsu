package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzcf extends zzm implements zzce {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    @Override // com.google.android.gms.internal.gtm.zzce
    public final void zza(Map map, long j, String str, List<zzbk> list) {
        Parcel a = a();
        a.writeMap(map);
        a.writeLong(j);
        a.writeString(str);
        a.writeTypedList(list);
        a(1, a);
    }

    @Override // com.google.android.gms.internal.gtm.zzce
    public final void zzch() {
        a(2, a());
    }
}
