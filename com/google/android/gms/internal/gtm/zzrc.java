package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrc.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzrc<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpl<MessageType, BuilderType> {
    private static Map<Object, zzrc<?, ?>> zzbam = new ConcurrentHashMap();
    protected zzts zzbak = zzts.zzrj();
    private int zzbal = -1;

    /* loaded from: classes.dex */
    public static abstract class zza<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpm<MessageType, BuilderType> {
        private final MessageType a;
        private MessageType b;
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.a = messagetype;
            this.b = (MessageType) messagetype.a(zze.zzbau, null, null);
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            db.a().a((db) messagetype).b(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.gtm.zzpm
        protected final /* synthetic */ zzpm a(zzpl zzplVar) {
            return zza((zza<MessageType, BuilderType>) ((zzrc) zzplVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.gtm.zzpm
        public /* synthetic */ Object clone() {
            zza zzaVar = (zza) this.a.a(zze.zzbav, null, null);
            zzaVar.zza((zza) ((zzrc) zzpl()));
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final boolean isInitialized() {
            return zzrc.a(this.b, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.c) {
                MessageType messagetype2 = (MessageType) this.b.a(zze.zzbau, null, null);
                a(messagetype2, this.b);
                this.b = messagetype2;
                this.c = false;
            }
            a(this.b, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        public final /* synthetic */ zzpm zzmx() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final /* synthetic */ zzsk zzpi() {
            return this.a;
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpj */
        public MessageType zzpl() {
            if (this.c) {
                return this.b;
            }
            this.b.c();
            this.c = true;
            return this.b;
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpk */
        public final MessageType zzpm() {
            MessageType messagetype = (MessageType) zzpl();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zztq(messagetype);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb<T extends zzrc<T, ?>> extends zzpn<T> {
        private final T a;

        public zzb(T t) {
            this.a = t;
        }

        @Override // com.google.android.gms.internal.gtm.zzsu
        public final /* synthetic */ Object zza(zzqe zzqeVar, zzqp zzqpVar) {
            return zzrc.a(this.a, zzqeVar, zzqpVar);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzrc<MessageType, BuilderType> implements zzsm {
        protected bv<Object> zzbaq = bv.a();
    }

    /* loaded from: classes.dex */
    public static class zzd<ContainingType extends zzsk, Type> extends zzqn<ContainingType, Type> {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public static final class zze {
        public static final int zzbar = 1;
        public static final int zzbas = 2;
        public static final int zzbat = 3;
        public static final int zzbau = 4;
        public static final int zzbav = 5;
        public static final int zzbaw = 6;
        public static final int zzbax = 7;
        private static final /* synthetic */ int[] a = {zzbar, zzbas, zzbat, zzbau, zzbav, zzbaw, zzbax};
        public static final int zzbaz = 1;
        public static final int zzbba = 2;
        private static final /* synthetic */ int[] b = {zzbaz, zzbba};
        public static final int zzbbc = 1;
        public static final int zzbbd = 2;
        private static final /* synthetic */ int[] c = {zzbbc, zzbbd};

        public static int[] zzpn() {
            return (int[]) a.clone();
        }
    }

    static <T extends zzrc<T, ?>> T a(T t, zzqe zzqeVar, zzqp zzqpVar) {
        T t2 = (T) t.a(zze.zzbau, null, null);
        try {
            db.a().a((db) t2).a(t2, bm.a(zzqeVar), zzqpVar);
            t2.c();
            return t2;
        } catch (IOException e) {
            if (!(e.getCause() instanceof zzrk)) {
                throw new zzrk(e.getMessage()).zzg(t2);
            }
            throw ((zzrk) e.getCause());
        } catch (RuntimeException e2) {
            if (!(e2.getCause() instanceof zzrk)) {
                throw e2;
            }
            throw ((zzrk) e2.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzrc<?, ?>> T a(Class<T> cls) {
        zzrc<?, ?> zzrcVar = zzbam.get(cls);
        if (zzrcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzrcVar = zzbam.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzrcVar == null) {
            zzrcVar = (T) ((zzrc) dz.a(cls)).a(zze.zzbaw, (Object) null, (Object) null);
            if (zzrcVar == null) {
                throw new IllegalStateException();
            }
            zzbam.put(cls, zzrcVar);
        }
        return (T) zzrcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzsk zzskVar, String str, Object[] objArr) {
        return new dc(zzskVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (!(cause instanceof Error)) {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((Error) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzrc<?, ?>> void a(Class<T> cls, T t) {
        zzbam.put(cls, t);
    }

    protected static final <T extends zzrc<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.zzbar, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = db.a().a((db) t).d(t);
        if (z) {
            t.a(zze.zzbas, d ? t : null, null);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.gtm.cc, com.google.android.gms.internal.gtm.zzri] */
    public static zzri d() {
        return cc.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.gtm.zzpl
    final void a(int i) {
        this.zzbal = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzpl
    final int b() {
        return this.zzbal;
    }

    protected final void c() {
        db.a().a((db) this).c(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzrc) a(zze.zzbaw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return db.a().a((db) this).a(this, (zzrc) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zzavp != 0) {
            return this.zzavp;
        }
        this.zzavp = db.a().a((db) this).a(this);
        return this.zzavp;
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final boolean isInitialized() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return cu.a(this, super.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final void zzb(zzqj zzqjVar) {
        db.a().a((Class) getClass()).a((de) this, (em) bp.a(zzqjVar));
    }

    public final BuilderType zzpd() {
        BuilderType buildertype = (BuilderType) a(zze.zzbav, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final int zzpe() {
        if (this.zzbal == -1) {
            this.zzbal = db.a().a((db) this).b(this);
        }
        return this.zzbal;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzpg() {
        zza zzaVar = (zza) a(zze.zzbav, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzph() {
        return (zza) a(zze.zzbav, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final /* synthetic */ zzsk zzpi() {
        return (zzrc) a(zze.zzbaw, (Object) null, (Object) null);
    }
}
