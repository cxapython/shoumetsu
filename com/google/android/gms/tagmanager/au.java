package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au extends ag {
    private static final String a = com.google.android.gms.internal.gtm.zza.JOINER.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.ITEM_SEPARATOR.toString();
    private static final String d = zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String e = zzb.ESCAPE.toString();

    public au() {
        super(a, b);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Set<Ljava/lang/Character;>;)Ljava/lang/String; */
    private static String a(String str, int i, Set set) {
        switch (av.a[i - 1]) {
            case 1:
                try {
                    return ec.a(str);
                } catch (UnsupportedEncodingException e2) {
                    zzdi.zza("Joiner: unsupported encoding", e2);
                    return str;
                }
            case 2:
                String replace = str.replace("\\", "\\\\");
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String ch = ((Character) it.next()).toString();
                    String valueOf = String.valueOf(ch);
                    replace = replace.replace(ch, valueOf.length() != 0 ? "\\".concat(valueOf) : new String("\\"));
                }
                return replace;
            default:
                return str;
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Set<Ljava/lang/Character;>;)V */
    private static void a(StringBuilder sb, String str, int i, Set set) {
        sb.append(a(str, i, set));
    }

    private static void a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        zzl zzlVar = map.get(b);
        if (zzlVar == null) {
            return zzgj.zzkc();
        }
        zzl zzlVar2 = map.get(c);
        String zzc = zzlVar2 != null ? zzgj.zzc(zzlVar2) : "";
        zzl zzlVar3 = map.get(d);
        String zzc2 = zzlVar3 != null ? zzgj.zzc(zzlVar3) : "=";
        int i = zzcz.zzahp;
        zzl zzlVar4 = map.get(e);
        HashSet hashSet = null;
        if (zzlVar4 != null) {
            String zzc3 = zzgj.zzc(zzlVar4);
            if (ImagesContract.URL.equals(zzc3)) {
                i = zzcz.zzahq;
            } else if (!"backslash".equals(zzc3)) {
                String valueOf = String.valueOf(zzc3);
                zzdi.zzav(valueOf.length() != 0 ? "Joiner: unsupported escape type: ".concat(valueOf) : new String("Joiner: unsupported escape type: "));
                return zzgj.zzkc();
            } else {
                i = zzcz.zzahr;
                hashSet = new HashSet();
                a(hashSet, zzc);
                a(hashSet, zzc2);
                hashSet.remove(Character.valueOf(TokenParser.ESCAPE));
            }
        }
        StringBuilder sb = new StringBuilder();
        switch (zzlVar.type) {
            case 2:
                zzl[] zzlVarArr = zzlVar.zzqn;
                int length = zzlVarArr.length;
                int i2 = 0;
                boolean z = true;
                while (i2 < length) {
                    zzl zzlVar5 = zzlVarArr[i2];
                    if (!z) {
                        sb.append(zzc);
                    }
                    a(sb, zzgj.zzc(zzlVar5), i, hashSet);
                    i2++;
                    z = false;
                }
                break;
            case 3:
                for (int i3 = 0; i3 < zzlVar.zzqo.length; i3++) {
                    if (i3 > 0) {
                        sb.append(zzc);
                    }
                    String zzc4 = zzgj.zzc(zzlVar.zzqo[i3]);
                    String zzc5 = zzgj.zzc(zzlVar.zzqp[i3]);
                    a(sb, zzc4, i, hashSet);
                    sb.append(zzc2);
                    a(sb, zzc5, i, hashSet);
                }
                break;
            default:
                a(sb, zzgj.zzc(zzlVar), i, hashSet);
                break;
        }
        return zzgj.zzi(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }
}
