package androidx.e.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: androidx.e.a.m.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public m[] newArray(int i) {
            return new m[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    d l;

    m(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        boolean z = true;
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() == 0 ? false : z;
        this.k = parcel.readBundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.a = dVar.getClass().getName();
        this.b = dVar.mIndex;
        this.c = dVar.mFromLayout;
        this.d = dVar.mFragmentId;
        this.e = dVar.mContainerId;
        this.f = dVar.mTag;
        this.g = dVar.mRetainInstance;
        this.h = dVar.mDetached;
        this.i = dVar.mArguments;
        this.j = dVar.mHidden;
    }

    public d a(h hVar, f fVar, d dVar, k kVar, androidx.lifecycle.r rVar) {
        if (this.l == null) {
            Context i = hVar.i();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(i.getClassLoader());
            }
            this.l = fVar != null ? fVar.a(i, this.a, this.i) : d.instantiate(i, this.a, this.i);
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(i.getClassLoader());
                this.l.mSavedFragmentState = this.k;
            }
            this.l.setIndex(this.b, dVar);
            d dVar2 = this.l;
            dVar2.mFromLayout = this.c;
            dVar2.mRestored = true;
            dVar2.mFragmentId = this.d;
            dVar2.mContainerId = this.e;
            dVar2.mTag = this.f;
            dVar2.mRetainInstance = this.g;
            dVar2.mDetached = this.h;
            dVar2.mHidden = this.j;
            dVar2.mFragmentManager = hVar.b;
            if (j.a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        d dVar3 = this.l;
        dVar3.mChildNonConfig = kVar;
        dVar3.mViewModelStore = rVar;
        return dVar3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }
}
