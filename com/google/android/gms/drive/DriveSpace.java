package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.stats.CodePackage;
import java.util.Set;
import java.util.regex.Pattern;

@SafeParcelable.Class(creator = "DriveSpaceCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class DriveSpace extends AbstractSafeParcelable implements ReflectedParcelable {
    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String d;
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzm();
    public static final DriveSpace zzaf = new DriveSpace(CodePackage.DRIVE);
    public static final DriveSpace zzag = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzah = new DriveSpace("PHOTOS");
    private static final Set<DriveSpace> a = CollectionUtils.setOf(zzaf, zzag, zzah);
    private static final String b = TextUtils.join(",", a.toArray());
    private static final Pattern c = Pattern.compile("[A-Z0-9_]*");

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DriveSpace(@SafeParcelable.Param(id = 2) String str) {
        this.d = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.d.equals(((DriveSpace) obj).d);
    }

    public int hashCode() {
        return this.d.hashCode() ^ 1247068382;
    }

    public String toString() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
