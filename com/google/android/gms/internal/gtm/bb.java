package com.google.android.gms.internal.gtm;

import java.util.Comparator;

/* loaded from: classes.dex */
final class bb implements Comparator<zzps> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzps zzpsVar, zzps zzpsVar2) {
        int b;
        int b2;
        zzps zzpsVar3 = zzpsVar;
        zzps zzpsVar4 = zzpsVar2;
        zzpz zzpzVar = (zzpz) zzpsVar3.iterator();
        zzpz zzpzVar2 = (zzpz) zzpsVar4.iterator();
        while (zzpzVar.hasNext() && zzpzVar2.hasNext()) {
            b = zzps.b(zzpzVar.nextByte());
            b2 = zzps.b(zzpzVar2.nextByte());
            int compare = Integer.compare(b, b2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzpsVar3.size(), zzpsVar4.size());
    }
}
