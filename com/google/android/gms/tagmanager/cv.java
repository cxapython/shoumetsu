package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzc;
import com.google.android.gms.internal.gtm.zzj;
import com.google.android.gms.internal.gtm.zzl;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzot;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzox;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes.dex */
public final class cv {
    private static final bs<zzl> a = new bs<>(zzgj.zzkc(), true);
    private final zzov b;
    private final ae c;
    private final Map<String, ag> d;
    private final Map<String, ag> e;
    private final Map<String, ag> f;
    private final ej<zzot, bs<zzl>> g;
    private final ej<String, db> h;
    private final Set<zzox> i;
    private final DataLayer j;
    private final Map<String, dc> k;
    private volatile String l;
    private int m;

    public cv(Context context, zzov zzovVar, DataLayer dataLayer, zzan zzanVar, zzan zzanVar2, ae aeVar) {
        if (zzovVar != null) {
            this.b = zzovVar;
            this.i = new HashSet(zzovVar.zzls());
            this.j = dataLayer;
            this.c = aeVar;
            cw cwVar = new cw(this);
            new ek();
            this.g = ek.a(1048576, cwVar);
            cx cxVar = new cx(this);
            new ek();
            this.h = ek.a(1048576, cxVar);
            this.d = new HashMap();
            b(new zzm(context));
            b(new l(zzanVar2));
            b(new w(dataLayer));
            b(new zzgk(context, dataLayer));
            this.e = new HashMap();
            c(new j());
            c(new ac());
            c(new zzbm());
            c(new ai());
            c(new aj());
            c(new az());
            c(new ba());
            c(new ce());
            c(new dp());
            this.f = new HashMap();
            a(new bt(context));
            a(new ct(context));
            a(new ed(context));
            a(new ee(context));
            a(new ef(context));
            a(new eg(context));
            a(new eh(context));
            a(new em());
            a(new i(this.b.getVersion()));
            a(new l(zzanVar));
            a(new p(dataLayer));
            a(new y(context));
            a(new z());
            a(new ab());
            a(new af(this));
            a(new ak());
            a(new al());
            a(new at(context));
            a(new au());
            a(new zzdd());
            a(new be());
            a(new bg(context));
            a(new bu());
            a(new by());
            a(new cb());
            a(new cd());
            a(new cf(context));
            a(new dd());
            a(new de());
            a(new dw());
            a(new ea());
            this.k = new HashMap();
            for (zzox zzoxVar : this.i) {
                for (int i = 0; i < zzoxVar.zzmq().size(); i++) {
                    zzot zzotVar = zzoxVar.zzmq().get(i);
                    dc a2 = a(this.k, a(zzotVar));
                    a2.a(zzoxVar);
                    a2.a(zzoxVar, zzotVar);
                    a2.a(zzoxVar, "Unknown");
                }
                for (int i2 = 0; i2 < zzoxVar.zzmr().size(); i2++) {
                    zzot zzotVar2 = zzoxVar.zzmr().get(i2);
                    dc a3 = a(this.k, a(zzotVar2));
                    a3.a(zzoxVar);
                    a3.b(zzoxVar, zzotVar2);
                    a3.b(zzoxVar, "Unknown");
                }
            }
            for (Map.Entry<String, List<zzot>> entry : this.b.zzmo().entrySet()) {
                for (zzot zzotVar3 : entry.getValue()) {
                    if (!zzgj.zzg(zzotVar3.zzlu().get(zzb.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                        a(this.k, entry.getKey()).a(zzotVar3);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("resource cannot be null");
    }

    private final bs<zzl> a(zzl zzlVar, Set<String> set, eb ebVar) {
        if (!zzlVar.zzqw) {
            return new bs<>(zzlVar, true);
        }
        int i = zzlVar.type;
        if (i == 7) {
            zzl zzk = zzor.zzk(zzlVar);
            zzk.zzqu = new zzl[zzlVar.zzqu.length];
            for (int i2 = 0; i2 < zzlVar.zzqu.length; i2++) {
                bs<zzl> a2 = a(zzlVar.zzqu[i2], set, ebVar.d(i2));
                bs<zzl> bsVar = a;
                if (a2 == bsVar) {
                    return bsVar;
                }
                zzk.zzqu[i2] = a2.a();
            }
            return new bs<>(zzk, false);
        }
        switch (i) {
            case 2:
                zzl zzk2 = zzor.zzk(zzlVar);
                zzk2.zzqn = new zzl[zzlVar.zzqn.length];
                for (int i3 = 0; i3 < zzlVar.zzqn.length; i3++) {
                    bs<zzl> a3 = a(zzlVar.zzqn[i3], set, ebVar.a(i3));
                    bs<zzl> bsVar2 = a;
                    if (a3 == bsVar2) {
                        return bsVar2;
                    }
                    zzk2.zzqn[i3] = a3.a();
                }
                return new bs<>(zzk2, false);
            case 3:
                zzl zzk3 = zzor.zzk(zzlVar);
                if (zzlVar.zzqo.length != zzlVar.zzqp.length) {
                    String valueOf = String.valueOf(zzlVar.toString());
                    zzdi.zzav(valueOf.length() != 0 ? "Invalid serving value: ".concat(valueOf) : new String("Invalid serving value: "));
                    return a;
                }
                zzk3.zzqo = new zzl[zzlVar.zzqo.length];
                zzk3.zzqp = new zzl[zzlVar.zzqo.length];
                for (int i4 = 0; i4 < zzlVar.zzqo.length; i4++) {
                    bs<zzl> a4 = a(zzlVar.zzqo[i4], set, ebVar.b(i4));
                    bs<zzl> a5 = a(zzlVar.zzqp[i4], set, ebVar.c(i4));
                    bs<zzl> bsVar3 = a;
                    if (a4 == bsVar3 || a5 == bsVar3) {
                        return a;
                    }
                    zzk3.zzqo[i4] = a4.a();
                    zzk3.zzqp[i4] = a5.a();
                }
                return new bs<>(zzk3, false);
            case 4:
                if (!set.contains(zzlVar.zzqq)) {
                    set.add(zzlVar.zzqq);
                    bs<zzl> a6 = ec.a(a(zzlVar.zzqq, set, ebVar.a()), zzlVar.zzqv);
                    set.remove(zzlVar.zzqq);
                    return a6;
                }
                String str = zzlVar.zzqq;
                String obj = set.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(obj).length());
                sb.append("Macro cycle detected.  Current macro reference: ");
                sb.append(str);
                sb.append(".  Previous macro references: ");
                sb.append(obj);
                sb.append(".");
                zzdi.zzav(sb.toString());
                return a;
            default:
                int i5 = zzlVar.type;
                StringBuilder sb2 = new StringBuilder(25);
                sb2.append("Unknown type: ");
                sb2.append(i5);
                zzdi.zzav(sb2.toString());
                return a;
        }
    }

    @VisibleForTesting
    private final bs<Boolean> a(zzot zzotVar, Set<String> set, cg cgVar) {
        bs<zzl> a2 = a(this.e, zzotVar, set, cgVar);
        Boolean zzg = zzgj.zzg(a2.a());
        cgVar.a(zzgj.zzi(zzg));
        return new bs<>(zzg, a2.b());
    }

    private final bs<zzl> a(String str, Set<String> set, bf bfVar) {
        zzot next;
        this.m++;
        db a2 = this.h.a(str);
        if (a2 != null) {
            this.c.a();
            a(a2.b(), set);
            this.m--;
            return a2.a();
        }
        dc dcVar = this.k.get(str);
        if (dcVar == null) {
            String b = b();
            StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 15 + String.valueOf(str).length());
            sb.append(b);
            sb.append("Invalid macro: ");
            sb.append(str);
            zzdi.zzav(sb.toString());
            this.m--;
            return a;
        }
        bs<Set<zzot>> a3 = a(dcVar.a(), set, new cy(this, dcVar.b(), dcVar.c(), dcVar.e(), dcVar.d()), bfVar.b());
        if (a3.a().isEmpty()) {
            next = dcVar.f();
        } else {
            if (a3.a().size() > 1) {
                String b2 = b();
                StringBuilder sb2 = new StringBuilder(String.valueOf(b2).length() + 37 + String.valueOf(str).length());
                sb2.append(b2);
                sb2.append("Multiple macros active for macroName ");
                sb2.append(str);
                zzdi.zzac(sb2.toString());
            }
            next = a3.a().iterator().next();
        }
        if (next == null) {
            this.m--;
            return a;
        }
        bs<zzl> a4 = a(this.f, next, set, bfVar.a());
        boolean z = a3.b() && a4.b();
        bs<zzl> bsVar = a;
        if (a4 != bsVar) {
            bsVar = new bs<>(a4.a(), z);
        }
        zzl zzji = next.zzji();
        if (bsVar.b()) {
            this.h.a(str, new db(bsVar, zzji));
        }
        a(zzji, set);
        this.m--;
        return bsVar;
    }

    private final bs<zzl> a(Map<String, ag> map, zzot zzotVar, Set<String> set, cg cgVar) {
        String sb;
        zzl zzlVar = zzotVar.zzlu().get(zzb.FUNCTION.toString());
        if (zzlVar == null) {
            sb = "No function id in properties";
        } else {
            String str = zzlVar.zzqr;
            ag agVar = map.get(str);
            if (agVar == null) {
                sb = String.valueOf(str).concat(" has no backing implementation.");
            } else {
                bs<zzl> a2 = this.g.a(zzotVar);
                if (a2 != null) {
                    this.c.a();
                    return a2;
                }
                HashMap hashMap = new HashMap();
                boolean z = true;
                boolean z2 = true;
                for (Map.Entry<String, zzl> entry : zzotVar.zzlu().entrySet()) {
                    bs<zzl> a3 = a(entry.getValue(), set, cgVar.a(entry.getKey()).a(entry.getValue()));
                    bs<zzl> bsVar = a;
                    if (a3 == bsVar) {
                        return bsVar;
                    }
                    if (a3.b()) {
                        zzotVar.zza(entry.getKey(), a3.a());
                    } else {
                        z2 = false;
                    }
                    hashMap.put(entry.getKey(), a3.a());
                }
                if (agVar.a(hashMap.keySet())) {
                    if (!z2 || !agVar.zzgw()) {
                        z = false;
                    }
                    bs<zzl> bsVar2 = new bs<>(agVar.zzb(hashMap), z);
                    if (z) {
                        this.g.a(zzotVar, bsVar2);
                    }
                    cgVar.a(bsVar2.a());
                    return bsVar2;
                }
                String valueOf = String.valueOf(agVar.zzig());
                String valueOf2 = String.valueOf(hashMap.keySet());
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                sb2.append("Incorrect keys for function ");
                sb2.append(str);
                sb2.append(" required ");
                sb2.append(valueOf);
                sb2.append(" had ");
                sb2.append(valueOf2);
                sb = sb2.toString();
            }
        }
        zzdi.zzav(sb);
        return a;
    }

    private final bs<Set<zzot>> a(Set<zzox> set, Set<String> set2, da daVar, cu cuVar) {
        bs bsVar;
        Set<zzot> hashSet = new HashSet<>();
        Set<zzot> hashSet2 = new HashSet<>();
        while (true) {
            boolean z = true;
            for (zzox zzoxVar : set) {
                cj a2 = cuVar.a();
                Iterator<zzot> it = zzoxVar.zzlx().iterator();
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<zzot> it2 = zzoxVar.zzlw().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    zzgj.zzi(true);
                                    bsVar = new bs(true, z2);
                                    break;
                                }
                                bs<Boolean> a3 = a(it2.next(), set2, a2.b());
                                if (!a3.a().booleanValue()) {
                                    zzgj.zzi(false);
                                    bsVar = new bs(false, a3.b());
                                    break;
                                }
                                z2 = z2 && a3.b();
                            }
                        } else {
                            bs<Boolean> a4 = a(it.next(), set2, a2.a());
                            if (a4.a().booleanValue()) {
                                zzgj.zzi(false);
                                bsVar = new bs(false, a4.b());
                                break;
                            } else if (!z2 || !a4.b()) {
                                z2 = false;
                            }
                        }
                    }
                }
                if (((Boolean) bsVar.a()).booleanValue()) {
                    daVar.a(zzoxVar, hashSet, hashSet2, a2);
                }
                if (!z || !bsVar.b()) {
                    z = false;
                }
            }
            hashSet.removeAll(hashSet2);
            cuVar.a(hashSet);
            return new bs<>(hashSet, z);
        }
    }

    private static dc a(Map<String, dc> map, String str) {
        dc dcVar = map.get(str);
        if (dcVar == null) {
            dc dcVar2 = new dc();
            map.put(str, dcVar2);
            return dcVar2;
        }
        return dcVar;
    }

    private static String a(zzot zzotVar) {
        return zzgj.zzc(zzotVar.zzlu().get(zzb.INSTANCE_NAME.toString()));
    }

    private final void a(zzl zzlVar, Set<String> set) {
        bs<zzl> a2;
        if (zzlVar == null || (a2 = a(zzlVar, set, new bq())) == a) {
            return;
        }
        Object zzh = zzgj.zzh(a2.a());
        if (zzh instanceof Map) {
            this.j.push((Map) zzh);
        } else if (!(zzh instanceof List)) {
            zzdi.zzac("pushAfterEvaluate: value not a Map or List");
        } else {
            for (Object obj : (List) zzh) {
                if (obj instanceof Map) {
                    this.j.push((Map) obj);
                } else {
                    zzdi.zzac("pushAfterEvaluate: value not a Map");
                }
            }
        }
    }

    @VisibleForTesting
    private final void a(ag agVar) {
        a(this.f, agVar);
    }

    private static void a(Map<String, ag> map, ag agVar) {
        if (map.containsKey(agVar.zzif())) {
            String valueOf = String.valueOf(agVar.zzif());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Duplicate function type name: ".concat(valueOf) : new String("Duplicate function type name: "));
        } else {
            map.put(agVar.zzif(), agVar);
        }
    }

    private final String b() {
        if (this.m <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.m));
        for (int i = 2; i < this.m; i++) {
            sb.append(TokenParser.SP);
        }
        sb.append(": ");
        return sb.toString();
    }

    @VisibleForTesting
    private final void b(ag agVar) {
        a(this.d, agVar);
    }

    @VisibleForTesting
    private final void c(ag agVar) {
        a(this.e, agVar);
    }

    @VisibleForTesting
    private final synchronized void c(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String a() {
        return this.l;
    }

    public final synchronized void a(String str) {
        c(str);
        o b = this.c.b(str).b();
        for (zzot zzotVar : a(this.i, new HashSet(), new cz(this), b.b()).a()) {
            a(this.d, zzotVar, new HashSet(), b.a());
        }
        c((String) null);
    }

    public final synchronized void a(List<zzj> list) {
        zzc.C0045zzc[] c0045zzcArr;
        String str;
        for (zzj zzjVar : list) {
            if (zzjVar.name != null && zzjVar.name.startsWith("gaExperiment:")) {
                DataLayer dataLayer = this.j;
                if (zzjVar.zzqi == null) {
                    zzdi.zzac("supplemental missing experimentSupplemental");
                } else {
                    for (zzl zzlVar : zzjVar.zzqi.zzpf) {
                        dataLayer.a(zzgj.zzc(zzlVar));
                    }
                    zzl[] zzlVarArr = zzjVar.zzqi.zzpe;
                    int length = zzlVarArr.length;
                    int i = 0;
                    while (true) {
                        Map<String, Object> map = null;
                        if (i >= length) {
                            break;
                        }
                        Object zzh = zzgj.zzh(zzlVarArr[i]);
                        if (!(zzh instanceof Map)) {
                            String valueOf = String.valueOf(zzh);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                            sb.append("value: ");
                            sb.append(valueOf);
                            sb.append(" is not a map value, ignored.");
                            zzdi.zzac(sb.toString());
                        } else {
                            map = (Map) zzh;
                        }
                        if (map != null) {
                            dataLayer.push(map);
                        }
                        i++;
                    }
                    for (zzc.C0045zzc c0045zzc : zzjVar.zzqi.zzpg) {
                        if (!c0045zzc.hasKey()) {
                            str = "GaExperimentRandom: No key";
                        } else {
                            Object obj = dataLayer.get(c0045zzc.getKey());
                            Long valueOf2 = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                            long zzg = c0045zzc.zzg();
                            long zzh2 = c0045zzc.zzh();
                            if (!c0045zzc.zzi() || valueOf2 == null || valueOf2.longValue() < zzg || valueOf2.longValue() > zzh2) {
                                if (zzg <= zzh2) {
                                    obj = Long.valueOf(Math.round((Math.random() * (zzh2 - zzg)) + zzg));
                                } else {
                                    str = "GaExperimentRandom: random range invalid";
                                }
                            }
                            dataLayer.a(c0045zzc.getKey());
                            Map<String, Object> a2 = DataLayer.a(c0045zzc.getKey(), obj);
                            if (c0045zzc.zzj() > 0) {
                                if (!a2.containsKey("gtm")) {
                                    a2.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c0045zzc.zzj())));
                                } else {
                                    Object obj2 = a2.get("gtm");
                                    if (obj2 instanceof Map) {
                                        ((Map) obj2).put("lifetime", Long.valueOf(c0045zzc.zzj()));
                                    } else {
                                        zzdi.zzac("GaExperimentRandom: gtm not a map");
                                    }
                                }
                            }
                            dataLayer.push(a2);
                        }
                        zzdi.zzac(str);
                    }
                }
            }
            String valueOf3 = String.valueOf(zzjVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 22);
            sb2.append("Ignored supplemental: ");
            sb2.append(valueOf3);
            zzdi.zzab(sb2.toString());
        }
    }

    public final bs<zzl> b(String str) {
        this.m = 0;
        return a(str, new HashSet(), this.c.a(str).a());
    }
}
