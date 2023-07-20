package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class zzm<T extends ReflectedParcelable> extends com.google.android.gms.drive.metadata.zza<T> {
    public zzm(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object a(Bundle bundle) {
        return (ReflectedParcelable) bundle.getParcelable(getName());
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void a(Bundle bundle, Object obj) {
        bundle.putParcelable(getName(), (ReflectedParcelable) obj);
    }
}
