package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SafeParcelable.Class(creator = "MetadataBundleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MetadataBundle extends AbstractSafeParcelable implements ReflectedParcelable {
    @SafeParcelable.Field(id = 2)
    private final Bundle b;
    private static final GmsLogger a = new GmsLogger("MetadataBundle", "");
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzj();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MetadataBundle(@SafeParcelable.Param(id = 2) Bundle bundle) {
        int i;
        this.b = (Bundle) Preconditions.checkNotNull(bundle);
        this.b.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.b.keySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (zzf.zzd(next) == null) {
                arrayList.add(next);
                a.wfmt("MetadataBundle", "Ignored unknown metadata field in bundle: %s", next);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            this.b.remove((String) obj);
        }
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzaw = zzaw();
        zzaw.zzb(metadataField, t);
        return zzaw;
    }

    public static MetadataBundle zzaw() {
        return new MetadataBundle(new Bundle());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.b.keySet();
        if (!keySet.equals(metadataBundle.b.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!Objects.equal(this.b.get(str), metadataBundle.b.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (String str : this.b.keySet()) {
            i = (i * 31) + this.b.get(str).hashCode();
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.b);
    }

    public final void zza(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzhp.zzka);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.setTempDir(context.getCacheDir());
        }
    }

    public final MetadataBundle zzax() {
        return new MetadataBundle(new Bundle(this.b));
    }

    public final Set<MetadataField<?>> zzay() {
        HashSet hashSet = new HashSet();
        for (String str : this.b.keySet()) {
            hashSet.add(zzf.zzd(str));
        }
        return hashSet;
    }

    public final <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zzf.zzd(metadataField.getName()) == null) {
            String valueOf = String.valueOf(metadataField.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unregistered field: ".concat(valueOf) : new String("Unregistered field: "));
        } else {
            metadataField.zza(t, this.b);
        }
    }

    public final <T> T zzc(MetadataField<T> metadataField) {
        T t = (T) zza(metadataField);
        this.b.remove(metadataField.getName());
        return t;
    }

    public final boolean zzd(MetadataField<?> metadataField) {
        return this.b.containsKey(metadataField.getName());
    }
}
