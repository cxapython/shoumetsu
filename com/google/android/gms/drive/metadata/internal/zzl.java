package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class zzl<T extends Parcelable> extends com.google.android.gms.drive.metadata.zzb<T> {
    public zzl(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void a(Bundle bundle, Object obj) {
        Collection collection = (Collection) obj;
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList<>(collection));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* renamed from: b */
    public Collection<T> a(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
