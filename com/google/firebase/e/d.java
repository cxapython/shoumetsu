package com.google.firebase.e;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d {
    private static volatile d b;
    private final Set<e> a = new HashSet();

    d() {
    }

    public static d b() {
        d dVar = b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = b;
                if (dVar == null) {
                    dVar = new d();
                    b = dVar;
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<e> a() {
        Set<e> unmodifiableSet;
        synchronized (this.a) {
            unmodifiableSet = Collections.unmodifiableSet(this.a);
        }
        return unmodifiableSet;
    }
}
