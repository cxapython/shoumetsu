package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzgf {
    private GoogleAnalytics a;
    private Context b;
    private Tracker c;

    public zzgf(Context context) {
        this.b = context;
    }

    private final synchronized void a(String str) {
        if (this.a == null) {
            this.a = GoogleAnalytics.getInstance(this.b);
            this.a.setLogger(new dx());
            this.c = this.a.newTracker(str);
        }
    }

    public final Tracker zzbm(String str) {
        a(str);
        return this.c;
    }
}
