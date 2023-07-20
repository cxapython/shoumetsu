package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
    private static final Builder k = new a(new String[0], null);
    @SafeParcelable.VersionField(id = 1000)
    private final int a;
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] b;
    private Bundle c;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] d;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int e;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    private final Bundle f;
    private int[] g;
    private int h;
    private boolean i;
    private boolean j;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder {
        private final String[] a;
        private final ArrayList<HashMap<String, Object>> b;
        private final String c;
        private final HashMap<Object, Integer> d;
        private boolean e;
        private String f;

        private Builder(String[] strArr, String str) {
            this.a = (String[]) Preconditions.checkNotNull(strArr);
            this.b = new ArrayList<>();
            this.c = str;
            this.d = new HashMap<>();
            this.e = false;
            this.f = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Builder(String[] strArr, String str, a aVar) {
            this(strArr, null);
        }

        @KeepForSdk
        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null, (a) null);
        }

        @KeepForSdk
        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1, (a) null);
        }

        @KeepForSdk
        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder zaa(HashMap<String, Object> hashMap) {
            Object obj;
            int intValue;
            Asserts.checkNotNull(hashMap);
            String str = this.c;
            if (str != null && (obj = hashMap.get(str)) != null) {
                Integer num = this.d.get(obj);
                if (num != null) {
                    intValue = num.intValue();
                    if (intValue != -1) {
                        this.b.add(hashMap);
                    } else {
                        this.b.remove(intValue);
                        this.b.add(intValue, hashMap);
                    }
                    this.e = false;
                    return this;
                }
                this.d.put(obj, Integer.valueOf(this.b.size()));
            }
            intValue = -1;
            if (intValue != -1) {
            }
            this.e = false;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.i = false;
        this.j = true;
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    @KeepForSdk
    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new CursorWrapper(cursor), i, bundle);
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.a, a(builder, -1), i, (Bundle) null);
    }

    private DataHolder(Builder builder, int i, Bundle bundle, int i2) {
        this(builder.a, a(builder, -1), i, bundle);
    }

    /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, int i2, a aVar) {
        this(builder, i, bundle, -1);
    }

    /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, a aVar) {
        this(builder, i, (Bundle) null);
    }

    private DataHolder(CursorWrapper cursorWrapper, int i, Bundle bundle) {
        this(cursorWrapper.getColumnNames(), a(cursorWrapper), i, bundle);
    }

    @KeepForSdk
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.i = false;
        this.j = true;
        this.a = 1;
        this.b = (String[]) Preconditions.checkNotNull(strArr);
        this.d = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.e = i;
        this.f = bundle;
        zaca();
    }

    private final void a(String str, int i) {
        Bundle bundle = this.c;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else {
            if (i >= 0 && i < this.h) {
                return;
            }
            throw new CursorIndexOutOfBoundsException(i, this.h);
        }
    }

    private static CursorWindow[] a(Builder builder, int i) {
        long j;
        if (builder.a.length == 0) {
            return new CursorWindow[0];
        }
        List subList = (i < 0 || i >= builder.b.size()) ? builder.b : builder.b.subList(0, i);
        int size = subList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.a.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i2);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder.a.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) subList.get(i2);
                boolean z2 = true;
                for (int i3 = 0; i3 < builder.a.length && z2; i3++) {
                    String str = builder.a[i3];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow2.putNull(i2, i3);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow2.putString((String) obj, i2, i3);
                    } else {
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow2.putLong(((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            j = ((Boolean) obj).booleanValue() ? 1L : 0L;
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (!(obj instanceof Float)) {
                            String valueOf = String.valueOf(obj);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                            sb2.append("Unsupported object for column ");
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(valueOf);
                            throw new IllegalArgumentException(sb2.toString());
                        } else {
                            z2 = cursorWindow2.putDouble(((Float) obj).floatValue(), i2, i3);
                        }
                        z2 = cursorWindow2.putLong(j, i2, i3);
                    }
                }
                if (z2) {
                    z = false;
                } else if (z) {
                    throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i2);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder.a.length);
                    arrayList.add(cursorWindow2);
                    i2--;
                    z = true;
                }
                i2++;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((CursorWindow) arrayList.get(i4)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    private static CursorWindow[] a(CursorWrapper cursorWrapper) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            while (i < count) {
                if (cursorWrapper.moveToPosition(i)) {
                    CursorWindow window2 = cursorWrapper.getWindow();
                    if (window2 != null) {
                        window2.acquireReference();
                        cursorWrapper.setWindow(null);
                    } else {
                        window2 = new CursorWindow(false);
                        window2.setStartPosition(i);
                        cursorWrapper.fillWindow(i, window2);
                    }
                    if (window2.getNumRows() == 0) {
                        break;
                    }
                    arrayList.add(window2);
                    i = window2.getStartPosition() + window2.getNumRows();
                } else {
                    break;
                }
            }
            cursorWrapper.close();
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            cursorWrapper.close();
            throw th;
        }
    }

    @KeepForSdk
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null, null);
    }

    @KeepForSdk
    public static DataHolder empty(int i) {
        return new DataHolder(k, i, (Bundle) null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public final void close() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                for (int i = 0; i < this.d.length; i++) {
                    this.d[i].close();
                }
            }
        }
    }

    protected final void finalize() {
        try {
            if (this.j && this.d.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public final boolean getBoolean(String str, int i, int i2) {
        a(str, i);
        return Long.valueOf(this.d[i2].getLong(i, this.c.getInt(str))).longValue() == 1;
    }

    @KeepForSdk
    public final byte[] getByteArray(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getBlob(i, this.c.getInt(str));
    }

    @KeepForSdk
    public final int getCount() {
        return this.h;
    }

    @KeepForSdk
    public final int getInteger(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getInt(i, this.c.getInt(str));
    }

    @KeepForSdk
    public final long getLong(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getLong(i, this.c.getInt(str));
    }

    @KeepForSdk
    public final Bundle getMetadata() {
        return this.f;
    }

    @KeepForSdk
    public final int getStatusCode() {
        return this.e;
    }

    @KeepForSdk
    public final String getString(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getString(i, this.c.getInt(str));
    }

    @KeepForSdk
    public final int getWindowIndex(int i) {
        int i2 = 0;
        Preconditions.checkState(i >= 0 && i < this.h);
        while (true) {
            int[] iArr = this.g;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.g.length ? i2 - 1 : i2;
    }

    @KeepForSdk
    public final boolean hasColumn(String str) {
        return this.c.containsKey(str);
    }

    @KeepForSdk
    public final boolean hasNull(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].isNull(i, this.c.getInt(str));
    }

    @KeepForSdk
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.b, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.d, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final float zaa(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getFloat(i, this.c.getInt(str));
    }

    public final void zaa(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        a(str, i);
        this.d[i2].copyStringToBuffer(i, this.c.getInt(str), charArrayBuffer);
    }

    public final double zab(String str, int i, int i2) {
        a(str, i);
        return this.d[i2].getDouble(i, this.c.getInt(str));
    }

    public final void zaca() {
        this.c = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.b;
            if (i2 >= strArr.length) {
                break;
            }
            this.c.putInt(strArr[i2], i2);
            i2++;
        }
        this.g = new int[this.d.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.d;
            if (i >= cursorWindowArr.length) {
                this.h = i3;
                return;
            }
            this.g[i] = i3;
            i3 += this.d[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }
}
