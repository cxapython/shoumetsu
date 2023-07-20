package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzk;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.tagmanager.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class Container {
    private final Context a;
    private final String b;
    private final DataLayer c;
    private cv d;
    private Map<String, FunctionCallMacroCallback> e;
    private Map<String, FunctionCallTagCallback> f;
    private volatile long g;
    private volatile String h;

    /* loaded from: classes.dex */
    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    /* loaded from: classes.dex */
    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements zzan {
        private a() {
        }

        @Override // com.google.android.gms.tagmanager.zzan
        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallMacroCallback a = Container.this.a(str);
            if (a == null) {
                return null;
            }
            return a.getValue(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements zzan {
        private b() {
        }

        @Override // com.google.android.gms.tagmanager.zzan
        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzam = Container.this.zzam(str);
            if (zzam != null) {
                zzam.execute(str, map);
            }
            return zzgj.zzkb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Container(Context context, DataLayer dataLayer, String str, long j, zzk zzkVar) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = "";
        this.a = context;
        this.c = dataLayer;
        this.b = str;
        this.g = j;
        zzi zziVar = zzkVar.zzqk;
        if (zziVar != null) {
            try {
                a(zzor.zza(zziVar));
            } catch (zzoz e) {
                String valueOf = String.valueOf(zziVar);
                String zzozVar = e.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(zzozVar).length());
                sb.append("Not loading resource: ");
                sb.append(valueOf);
                sb.append(" because it is invalid: ");
                sb.append(zzozVar);
                zzdi.zzav(sb.toString());
            }
            if (zzkVar.zzqj == null) {
                return;
            }
            zzj[] zzjVarArr = zzkVar.zzqj;
            ArrayList arrayList = new ArrayList();
            for (zzj zzjVar : zzjVarArr) {
                arrayList.add(zzjVar);
            }
            b().a(arrayList);
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Container(Context context, DataLayer dataLayer, String str, long j, zzov zzovVar) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = "";
        this.a = context;
        this.c = dataLayer;
        this.b = str;
        this.g = 0L;
        a(zzovVar);
    }

    private final void a(zzov zzovVar) {
        this.h = zzovVar.getVersion();
        String str = this.h;
        ca.a().b().equals(ca.a.CONTAINER_DEBUG);
        a(new cv(this.a, zzovVar, this.c, new a(), new b(), new bk()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.c.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.b));
        }
    }

    private final synchronized void a(cv cvVar) {
        this.d = cvVar;
    }

    private final synchronized cv b() {
        return this.d;
    }

    @VisibleForTesting
    final FunctionCallMacroCallback a(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.e) {
            functionCallMacroCallback = this.e.get(str);
        }
        return functionCallMacroCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.d = null;
    }

    public boolean getBoolean(String str) {
        String sb;
        cv b2 = b();
        if (b2 == null) {
            sb = "getBoolean called for closed container.";
        } else {
            try {
                return zzgj.zzg(b2.b(str).a()).booleanValue();
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 66);
                sb2.append("Calling getBoolean() threw an exception: ");
                sb2.append(message);
                sb2.append(" Returning default value.");
                sb = sb2.toString();
            }
        }
        zzdi.zzav(sb);
        return zzgj.zzjz().booleanValue();
    }

    public String getContainerId() {
        return this.b;
    }

    public double getDouble(String str) {
        String sb;
        cv b2 = b();
        if (b2 == null) {
            sb = "getDouble called for closed container.";
        } else {
            try {
                return zzgj.zzf(b2.b(str).a()).doubleValue();
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 65);
                sb2.append("Calling getDouble() threw an exception: ");
                sb2.append(message);
                sb2.append(" Returning default value.");
                sb = sb2.toString();
            }
        }
        zzdi.zzav(sb);
        return zzgj.zzjy().doubleValue();
    }

    public long getLastRefreshTime() {
        return this.g;
    }

    public long getLong(String str) {
        String sb;
        cv b2 = b();
        if (b2 == null) {
            sb = "getLong called for closed container.";
        } else {
            try {
                return zzgj.zze(b2.b(str).a()).longValue();
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 63);
                sb2.append("Calling getLong() threw an exception: ");
                sb2.append(message);
                sb2.append(" Returning default value.");
                sb = sb2.toString();
            }
        }
        zzdi.zzav(sb);
        return zzgj.zzjx().longValue();
    }

    public String getString(String str) {
        String sb;
        cv b2 = b();
        if (b2 == null) {
            sb = "getString called for closed container.";
        } else {
            try {
                return zzgj.zzc(b2.b(str).a());
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 65);
                sb2.append("Calling getString() threw an exception: ");
                sb2.append(message);
                sb2.append(" Returning default value.");
                sb = sb2.toString();
            }
        }
        zzdi.zzav(sb);
        return zzgj.zzkb();
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback != null) {
            synchronized (this.e) {
                this.e.put(str, functionCallMacroCallback);
            }
            return;
        }
        throw new NullPointerException("Macro handler must be non-null");
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback != null) {
            synchronized (this.f) {
                this.f.put(str, functionCallTagCallback);
            }
            return;
        }
        throw new NullPointerException("Tag callback must be non-null");
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.e) {
            this.e.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.f) {
            this.f.remove(str);
        }
    }

    @VisibleForTesting
    public final FunctionCallTagCallback zzam(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.f) {
            functionCallTagCallback = this.f.get(str);
        }
        return functionCallTagCallback;
    }

    @VisibleForTesting
    public final void zzan(String str) {
        b().a(str);
    }

    @VisibleForTesting
    public final String zzha() {
        return this.h;
    }
}
