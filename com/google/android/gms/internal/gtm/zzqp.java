package com.google.android.gms.internal.gtm;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.internal.gtm.zzrc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzqp {
    private static volatile boolean b = false;
    private static volatile zzqp d;
    private final Map<a, zzrc.zzd<?, ?>> e;
    private static final Class<?> c = b();
    static final zzqp a = new zzqp(true);

    /* loaded from: classes.dex */
    static final class a {
        private final Object a;
        private final int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * GameRequest.TYPE_ALL) + this.b;
        }
    }

    zzqp() {
        this.e = new HashMap();
    }

    private zzqp(boolean z) {
        this.e = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqp a() {
        return ca.a(zzqp.class);
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzqp zzoq() {
        return br.a();
    }

    public static zzqp zzor() {
        zzqp zzqpVar = d;
        if (zzqpVar == null) {
            synchronized (zzqp.class) {
                zzqpVar = d;
                if (zzqpVar == null) {
                    zzqpVar = br.b();
                    d = zzqpVar;
                }
            }
        }
        return zzqpVar;
    }

    public final <ContainingType extends zzsk> zzrc.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzrc.zzd<ContainingType, ?>) this.e.get(new a(containingtype, i));
    }
}
