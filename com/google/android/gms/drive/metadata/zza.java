package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zza<T> implements MetadataField<T> {
    private final String a;
    private final Set<String> b;
    private final Set<String> c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str, int i) {
        this.a = (String) Preconditions.checkNotNull(str, "fieldName");
        this.b = Collections.singleton(str);
        this.c = Collections.emptySet();
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.a = (String) Preconditions.checkNotNull(str, "fieldName");
        this.b = Collections.unmodifiableSet(new HashSet(collection));
        this.c = Collections.unmodifiableSet(new HashSet(collection2));
        this.d = i;
    }

    protected abstract T a(Bundle bundle);

    protected abstract void a(Bundle bundle, T t);

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(DataHolder dataHolder, int i, int i2) {
        for (String str : this.b) {
            if (!dataHolder.hasColumn(str) || dataHolder.hasNull(str, i, i2)) {
                return false;
            }
            while (r0.hasNext()) {
            }
        }
        return true;
    }

    protected abstract T b(DataHolder dataHolder, int i, int i2);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final String getName() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zza(Bundle bundle) {
        Preconditions.checkNotNull(bundle, "bundle");
        if (bundle.get(this.a) != null) {
            return a(bundle);
        }
        return null;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zza(DataHolder dataHolder, int i, int i2) {
        if (a(dataHolder, i, i2)) {
            return b(dataHolder, i, i2);
        }
        return null;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        Preconditions.checkNotNull(dataHolder, "dataHolder");
        Preconditions.checkNotNull(metadataBundle, "bundle");
        if (a(dataHolder, i, i2)) {
            metadataBundle.zzb(this, b(dataHolder, i, i2));
        }
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(T t, Bundle bundle) {
        Preconditions.checkNotNull(bundle, "bundle");
        if (t == null) {
            bundle.putString(this.a, null);
        } else {
            a(bundle, t);
        }
    }

    public final Collection<String> zzar() {
        return this.b;
    }
}
