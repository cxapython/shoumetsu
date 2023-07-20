package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

/* loaded from: classes.dex */
public final class zzk implements zzj<Boolean> {
    private Boolean a = false;

    private zzk() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzk())).booleanValue();
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(zzx zzxVar, MetadataField metadataField, Object obj) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(zzx zzxVar, List<Boolean> list) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zza(Boolean bool) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzbb() {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzbc() {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzc(MetadataField metadataField, Object obj) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zze(MetadataField metadataField) {
        return this.a;
    }

    @Override // com.google.android.gms.drive.query.internal.zzj
    public final /* synthetic */ Boolean zzg(String str) {
        if (!str.isEmpty()) {
            this.a = true;
        }
        return this.a;
    }
}
