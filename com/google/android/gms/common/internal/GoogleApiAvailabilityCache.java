package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class GoogleApiAvailabilityCache {
    private final SparseIntArray a;
    private GoogleApiAvailabilityLight b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.a = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.b = googleApiAvailabilityLight;
    }

    public void flush() {
        this.a.clear();
    }

    public int getClientAvailability(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.a.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.a.size()) {
                int keyAt = this.a.keyAt(i2);
                if (keyAt > minApkVersion && this.a.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.b.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.a.put(minApkVersion, i);
        return i;
    }
}
