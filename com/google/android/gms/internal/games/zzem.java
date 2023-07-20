package com.google.android.gms.internal.games;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzem {
    private HashMap<String, Integer> a = new HashMap<>();
    private int b = 0;

    public final zzek zzdh() {
        return new zzek(this.b, this.a);
    }

    public final zzem zzh(String str, int i) {
        boolean z;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.a.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public final zzem zzo(int i) {
        this.b = i;
        return this;
    }
}
