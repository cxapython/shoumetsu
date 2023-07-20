package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.UUID;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzaa extends com.google.android.gms.analytics.zzi<zzaa> {
    private String a;
    private int b;
    private int c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;

    public zzaa() {
        this(false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzaa(boolean z) {
        this(false, r1);
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = Integer.MAX_VALUE;
        }
    }

    @ShowFirstParty
    @VisibleForTesting
    private zzaa(boolean z, int i) {
        Preconditions.checkNotZero(i);
        this.b = i;
        this.g = false;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.a);
        hashMap.put("interstitial", Boolean.valueOf(this.f));
        hashMap.put("automatic", Boolean.valueOf(this.g));
        hashMap.put("screenId", Integer.valueOf(this.b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.c));
        hashMap.put("referrerScreenName", this.d);
        hashMap.put("referrerUri", this.e);
        return zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzaa zzaaVar) {
        zzaa zzaaVar2 = zzaaVar;
        if (!TextUtils.isEmpty(this.a)) {
            zzaaVar2.a = this.a;
        }
        int i = this.b;
        if (i != 0) {
            zzaaVar2.b = i;
        }
        int i2 = this.c;
        if (i2 != 0) {
            zzaaVar2.c = i2;
        }
        if (!TextUtils.isEmpty(this.d)) {
            zzaaVar2.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            String str = this.e;
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            zzaaVar2.e = str;
        }
        boolean z = this.f;
        if (z) {
            zzaaVar2.f = z;
        }
        boolean z2 = this.g;
        if (z2) {
            zzaaVar2.g = z2;
        }
    }

    public final String zzca() {
        return this.a;
    }

    public final int zzcb() {
        return this.b;
    }

    public final String zzcc() {
        return this.e;
    }
}
