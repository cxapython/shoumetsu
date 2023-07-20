package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zzf;
import com.google.android.gms.internal.drive.zzaa;
import com.google.android.gms.internal.drive.zzhp;

/* loaded from: classes.dex */
public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Metadata {
        private final DataHolder a;
        private final int b;
        private final int c;

        public a(DataHolder dataHolder, int i) {
            this.a = dataHolder;
            this.b = i;
            this.c = dataHolder.getWindowIndex(i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: freeze */
        public final /* synthetic */ Metadata mo28freeze() {
            MetadataBundle zzaw = MetadataBundle.zzaw();
            for (MetadataField<?> metadataField : zzf.zzau()) {
                if (metadataField != zzhp.zzka) {
                    metadataField.zza(this.a, zzaw, this.b, this.c);
                }
            }
            return new zzaa(zzaw);
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return !this.a.isClosed();
        }

        @Override // com.google.android.gms.drive.Metadata
        public final <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.a, this.b, this.c);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.getMetadata().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: get */
    public final Metadata mo27get(int i) {
        a aVar = this.b;
        if (aVar == null || aVar.b != i) {
            a aVar2 = new a(this.a, i);
            this.b = aVar2;
            return aVar2;
        }
        return aVar;
    }

    @Deprecated
    public final String getNextPageToken() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        if (this.a != null) {
            zzf.zza(this.a);
        }
        super.release();
    }
}
