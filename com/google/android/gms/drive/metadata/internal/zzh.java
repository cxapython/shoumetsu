package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;

/* loaded from: classes.dex */
public final class zzh extends com.google.android.gms.drive.metadata.zza<Integer> {
    public zzh(String str, int i) {
        super(str, GmsVersion.VERSION_JARLSBERG);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Integer a(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Integer b(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }
}
