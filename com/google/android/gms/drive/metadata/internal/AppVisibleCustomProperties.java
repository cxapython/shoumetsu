package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "AppVisibleCustomPropertiesCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class AppVisibleCustomProperties extends AbstractSafeParcelable implements ReflectedParcelable, Iterable<zzc> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new com.google.android.gms.drive.metadata.internal.zza();
    public static final AppVisibleCustomProperties zzil = new zza().zzat();
    @SafeParcelable.Field(id = 2)
    private final List<zzc> a;

    /* loaded from: classes.dex */
    public static class zza {
        private final Map<CustomPropertyKey, zzc> a = new HashMap();

        public final zza zza(CustomPropertyKey customPropertyKey, String str) {
            Preconditions.checkNotNull(customPropertyKey, "key");
            this.a.put(customPropertyKey, new zzc(customPropertyKey, str));
            return this;
        }

        public final zza zza(zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar, "property");
            this.a.put(zzcVar.a, zzcVar);
            return this;
        }

        public final AppVisibleCustomProperties zzat() {
            return new AppVisibleCustomProperties(this.a.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AppVisibleCustomProperties(@SafeParcelable.Param(id = 2) Collection<zzc> collection) {
        Preconditions.checkNotNull(collection);
        this.a = new ArrayList(collection);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return zzas().equals(((AppVisibleCustomProperties) obj).zzas());
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzc> iterator() {
        return this.a.iterator();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Map<CustomPropertyKey, String> zzas() {
        HashMap hashMap = new HashMap(this.a.size());
        for (zzc zzcVar : this.a) {
            hashMap.put(zzcVar.a, zzcVar.b);
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
