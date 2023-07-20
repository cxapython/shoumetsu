package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean b;
    private ArrayList<Integer> c;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.b = false;
    }

    private final int a(int i) {
        if (i < 0 || i >= this.c.size()) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is out of bounds for this buffer");
            throw new IllegalArgumentException(sb.toString());
        }
        return this.c.get(i).intValue();
    }

    private final void c() {
        synchronized (this) {
            if (!this.b) {
                int count = this.a.getCount();
                this.c = new ArrayList<>();
                if (count > 0) {
                    this.c.add(0);
                    String a = a();
                    String string = this.a.getString(a, 0, this.a.getWindowIndex(0));
                    for (int i = 1; i < count; i++) {
                        int windowIndex = this.a.getWindowIndex(i);
                        String string2 = this.a.getString(a, i, windowIndex);
                        if (string2 == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(a);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(windowIndex);
                            throw new NullPointerException(sb.toString());
                        }
                        if (!string2.equals(string)) {
                            this.c.add(Integer.valueOf(i));
                            string = string2;
                        }
                    }
                }
                this.b = true;
            }
        }
    }

    @KeepForSdk
    protected abstract T a(int i, int i2);

    @KeepForSdk
    protected abstract String a();

    @KeepForSdk
    protected String b() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r6.a.getString(r4, r7, r3) == null) goto L16;
     */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    /* renamed from: get */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T mo27get(int i) {
        c();
        int a = a(i);
        int i2 = 0;
        if (i >= 0 && i != this.c.size()) {
            int count = (i == this.c.size() - 1 ? this.a.getCount() : this.c.get(i + 1).intValue()) - this.c.get(i).intValue();
            if (count == 1) {
                int a2 = a(i);
                int windowIndex = this.a.getWindowIndex(a2);
                String b = b();
                if (b != null) {
                }
            }
            i2 = count;
        }
        return a(a, i2);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        c();
        return this.c.size();
    }
}
