package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.Collection;

/* loaded from: classes.dex */
final class cp extends com.google.android.gms.drive.metadata.internal.zzm<BitmapTeleporter> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_KENAFA);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object b(DataHolder dataHolder, int i, int i2) {
        throw new IllegalStateException("Thumbnail field is write only");
    }
}
