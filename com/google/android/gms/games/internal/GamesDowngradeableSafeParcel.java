package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

/* loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(Integer num) {
        if (num == null) {
            return false;
        }
        return GmsVersion.isAtLeastFenacho(num.intValue());
    }

    public boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!b(Integer.valueOf(i)));
        return true;
    }
}
