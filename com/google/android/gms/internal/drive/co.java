package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.Collection;

/* loaded from: classes.dex */
final class co extends com.google.android.gms.drive.metadata.internal.zzb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public co(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.internal.zzb
    public final Boolean a_(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger("trashed", i, i2) == 2);
    }

    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Boolean b(DataHolder dataHolder, int i, int i2) {
        return b(dataHolder, i, i2);
    }
}
