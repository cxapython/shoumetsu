package androidx.e.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.e.a.a;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: androidx.e.a.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public b(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.b.size();
        this.a = new int[size * 6];
        if (aVar.i) {
            int i = 0;
            int i2 = 0;
            while (i < size) {
                a.C0030a c0030a = aVar.b.get(i);
                int i3 = i2 + 1;
                this.a[i2] = c0030a.a;
                int i4 = i3 + 1;
                this.a[i3] = c0030a.b != null ? c0030a.b.mIndex : -1;
                int i5 = i4 + 1;
                this.a[i4] = c0030a.c;
                int i6 = i5 + 1;
                this.a[i5] = c0030a.d;
                int i7 = i6 + 1;
                this.a[i6] = c0030a.e;
                this.a[i7] = c0030a.f;
                i++;
                i2 = i7 + 1;
            }
            this.b = aVar.g;
            this.c = aVar.h;
            this.d = aVar.k;
            this.e = aVar.m;
            this.f = aVar.n;
            this.g = aVar.o;
            this.h = aVar.p;
            this.i = aVar.q;
            this.j = aVar.r;
            this.k = aVar.s;
            this.l = aVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(j jVar) {
        a aVar = new a(jVar);
        int i = 0;
        int i2 = 0;
        while (i < this.a.length) {
            a.C0030a c0030a = new a.C0030a();
            int i3 = i + 1;
            c0030a.a = this.a[i];
            if (j.a) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.a[i3];
            c0030a.b = i5 >= 0 ? jVar.f.get(i5) : null;
            int[] iArr = this.a;
            int i6 = i4 + 1;
            c0030a.c = iArr[i4];
            int i7 = i6 + 1;
            c0030a.d = iArr[i6];
            int i8 = i7 + 1;
            c0030a.e = iArr[i7];
            c0030a.f = iArr[i8];
            aVar.c = c0030a.c;
            aVar.d = c0030a.d;
            aVar.e = c0030a.e;
            aVar.f = c0030a.f;
            aVar.a(c0030a);
            i2++;
            i = i8 + 1;
        }
        aVar.g = this.b;
        aVar.h = this.c;
        aVar.k = this.d;
        aVar.m = this.e;
        aVar.i = true;
        aVar.n = this.f;
        aVar.o = this.g;
        aVar.p = this.h;
        aVar.q = this.i;
        aVar.r = this.j;
        aVar.s = this.k;
        aVar.t = this.l;
        aVar.a(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}
