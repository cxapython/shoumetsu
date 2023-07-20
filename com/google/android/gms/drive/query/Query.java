package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import com.google.android.gms.drive.query.internal.zzt;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@SafeParcelable.Class(creator = "QueryCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class Query extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zzb();
    @SafeParcelable.Field(id = 5)
    final List<String> a;
    @SafeParcelable.Field(id = 6)
    final boolean b;
    @SafeParcelable.Field(id = 8)
    final boolean c;
    @SafeParcelable.Field(id = 1)
    private final zzr d;
    @SafeParcelable.Field(id = 3)
    private final String e;
    @SafeParcelable.Field(id = 4)
    private final SortOrder f;
    @SafeParcelable.Field(id = 7)
    private final List<DriveSpace> g;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class Builder {
        private final List<Filter> a;
        private String b;
        private SortOrder c;
        private List<String> d;
        private boolean e;
        private Set<DriveSpace> f;
        private boolean g;

        public Builder() {
            this.a = new ArrayList();
            this.d = Collections.emptyList();
            this.f = Collections.emptySet();
        }

        public Builder(Query query) {
            this.a = new ArrayList();
            this.d = Collections.emptyList();
            this.f = Collections.emptySet();
            this.a.add(query.getFilter());
            this.b = query.getPageToken();
            this.c = query.getSortOrder();
            this.d = query.a;
            this.e = query.b;
            query.zzba();
            this.f = query.zzba();
            this.g = query.c;
        }

        public Builder addFilter(Filter filter) {
            Preconditions.checkNotNull(filter, "Filter may not be null.");
            if (!(filter instanceof zzt)) {
                this.a.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new zzr(zzx.zzmf, this.a), this.b, this.c, this.d, this.e, this.f, this.g);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.b = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.c = sortOrder;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Query(@SafeParcelable.Param(id = 1) zzr zzrVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) SortOrder sortOrder, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) List<DriveSpace> list2, @SafeParcelable.Param(id = 8) boolean z2) {
        this.d = zzrVar;
        this.e = str;
        this.f = sortOrder;
        this.a = list;
        this.b = z;
        this.g = list2;
        this.c = z2;
    }

    private Query(zzr zzrVar, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set, boolean z2) {
        this(zzrVar, str, sortOrder, list, z, new ArrayList(set), z2);
    }

    public Filter getFilter() {
        return this.d;
    }

    @Deprecated
    public String getPageToken() {
        return this.e;
    }

    public SortOrder getSortOrder() {
        return this.f;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.d, this.f, this.e, this.g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.d, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.e, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f, i, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.a, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.b);
        SafeParcelWriter.writeTypedList(parcel, 7, this.g, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Set<DriveSpace> zzba() {
        return new HashSet(this.g);
    }
}
