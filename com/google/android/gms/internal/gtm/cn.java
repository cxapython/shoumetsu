package com.google.android.gms.internal.gtm;

/* loaded from: classes.dex */
final class cn implements ct {
    private ct[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ct... ctVarArr) {
        this.a = ctVarArr;
    }

    @Override // com.google.android.gms.internal.gtm.ct
    public final boolean a(Class<?> cls) {
        for (ct ctVar : this.a) {
            if (ctVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.ct
    public final cs b(Class<?> cls) {
        ct[] ctVarArr;
        for (ct ctVar : this.a) {
            if (ctVar.a(cls)) {
                return ctVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
