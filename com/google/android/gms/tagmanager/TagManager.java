package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
/* loaded from: classes.dex */
public class TagManager {
    private static TagManager g;
    private final zza a;
    private final Context b;
    private final DataLayer c;
    private final zzfm d;
    private final ConcurrentMap<String, eo> e;
    private final k f;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface zza {
        zzy zza(Context context, TagManager tagManager, Looper looper, String str, int i, k kVar);
    }

    @VisibleForTesting
    private TagManager(Context context, zza zzaVar, DataLayer dataLayer, zzfm zzfmVar) {
        if (context != null) {
            this.b = context.getApplicationContext();
            this.d = zzfmVar;
            this.a = zzaVar;
            this.e = new ConcurrentHashMap();
            this.c = dataLayer;
            this.c.a(new ds(this));
            this.c.a(new dr(this.b));
            this.f = new k();
            this.b.registerComponentCallbacks(new du(this));
            com.google.android.gms.tagmanager.zza.zzf(this.b);
            return;
        }
        throw new NullPointerException("context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        for (eo eoVar : this.e.values()) {
            eoVar.a(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (g == null) {
                if (context == null) {
                    zzdi.zzav("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                g = new TagManager(context, new dt(), new DataLayer(new q(context)), dg.a());
            }
            tagManager = g;
        }
        return tagManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(Uri uri) {
        boolean z;
        ca a = ca.a();
        if (a.a(uri)) {
            String d = a.d();
            switch (dv.a[a.b().ordinal()]) {
                case 1:
                    eo eoVar = this.e.get(d);
                    if (eoVar != null) {
                        eoVar.b(null);
                        eoVar.refresh();
                        break;
                    }
                    break;
                case 2:
                case 3:
                    for (String str : this.e.keySet()) {
                        eo eoVar2 = this.e.get(str);
                        if (str.equals(d)) {
                            eoVar2.b(a.c());
                        } else if (eoVar2.b() != null) {
                            eoVar2.b(null);
                        }
                        eoVar2.refresh();
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public void dispatch() {
        this.d.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.c;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        zzy zza2 = this.a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhf();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        zzy zza2 = this.a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhf();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        zzy zza2 = this.a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhh();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        zzy zza2 = this.a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhh();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        zzy zza2 = this.a.zza(this.b, this, null, str, i, this.f);
        zza2.zzhg();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        zzy zza2 = this.a.zza(this.b, this, handler.getLooper(), str, i, this.f);
        zza2.zzhg();
        return zza2;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzdi.setLogLevel(z ? 2 : 5);
    }

    @VisibleForTesting
    public final int zza(eo eoVar) {
        this.e.put(eoVar.a(), eoVar);
        return this.e.size();
    }

    @VisibleForTesting
    public final boolean zzb(eo eoVar) {
        return this.e.remove(eoVar.a()) != null;
    }
}
