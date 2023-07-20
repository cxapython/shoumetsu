package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class di extends dh<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public di(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.gtm.dh
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b = b(i);
                if (((zzqv) b.getKey()).zzoz()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            Iterator it = d().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzqv) entry.getKey()).zzoz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
