package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {
    private static final Object a = new Object();
    private static GmsClientSupervisor b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class zza {
        private final String a;
        private final String b;
        private final ComponentName c;
        private final int d;

        public zza(ComponentName componentName, int i) {
            this.a = null;
            this.b = null;
            this.c = (ComponentName) Preconditions.checkNotNull(componentName);
            this.d = 129;
        }

        public zza(String str, int i) {
            this.a = Preconditions.checkNotEmpty(str);
            this.b = "com.google.android.gms";
            this.c = null;
            this.d = 129;
        }

        public zza(String str, String str2, int i) {
            this.a = Preconditions.checkNotEmpty(str);
            this.b = Preconditions.checkNotEmpty(str2);
            this.c = null;
            this.d = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return Objects.equal(this.a, zzaVar.a) && Objects.equal(this.b, zzaVar.b) && Objects.equal(this.c, zzaVar.c) && this.d == zzaVar.d;
        }

        public final ComponentName getComponentName() {
            return this.c;
        }

        public final String getPackage() {
            return this.b;
        }

        public final int hashCode() {
            return Objects.hashCode(this.a, this.b, this.c, Integer.valueOf(this.d));
        }

        public final String toString() {
            String str = this.a;
            return str == null ? this.c.flattenToString() : str;
        }

        public final Intent zzb(Context context) {
            String str = this.a;
            return str != null ? new Intent(str).setPackage(this.b) : new Intent().setComponent(this.c);
        }

        public final int zzq() {
            return this.d;
        }
    }

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (a) {
            if (b == null) {
                b = new k(context.getApplicationContext());
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(zza zzaVar, ServiceConnection serviceConnection, String str);

    protected abstract void b(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new zza(componentName, 129), serviceConnection, str);
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return a(new zza(str, 129), serviceConnection, str2);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        b(new zza(componentName, 129), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        b(new zza(str, 129), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new zza(str, str2, i), serviceConnection, str3);
    }
}
