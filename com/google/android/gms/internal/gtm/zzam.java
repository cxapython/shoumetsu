package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* loaded from: classes.dex */
public class zzam {
    private final zzap a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzam(zzap zzapVar) {
        Preconditions.checkNotNull(zzapVar);
        this.a = zzapVar;
    }

    private static String a(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a = a(obj);
        String a2 = a(obj2);
        String a3 = a(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            sb.append(str2);
            sb.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
        }
        return sb.toString();
    }

    private final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzap zzapVar = this.a;
        zzci zzdd = zzapVar != null ? zzapVar.zzdd() : null;
        if (zzdd == null) {
            String str2 = zzby.zzzb.get();
            if (!Log.isLoggable(str2, i)) {
                return;
            }
            Log.println(i, str2, a(str, obj, obj2, obj3));
            return;
        }
        String str3 = zzby.zzzb.get();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, zzci.a(str, obj, obj2, obj3));
        }
        if (i < 5) {
            return;
        }
        zzdd.zzb(i, str, obj, obj2, obj3);
    }

    public static boolean zzda() {
        return Log.isLoggable(zzby.zzzb.get(), 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Clock d() {
        return this.a.zzcn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context e() {
        return this.a.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzci f() {
        return this.a.zzco();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbq g() {
        return this.a.zzcp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.analytics.zzk h() {
        return this.a.zzcq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzae i() {
        return this.a.zzcs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbv j() {
        return this.a.zzct();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzda k() {
        return this.a.zzcu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcm l() {
        return this.a.zzcv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbh m() {
        return this.a.zzdh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzad n() {
        return this.a.zzdg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzba o() {
        return this.a.zzcy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbu p() {
        return this.a.zzcz();
    }

    public final void zza(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        a(3, str, obj, obj2, obj3);
    }

    public final void zzb(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void zzb(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        a(5, str, obj, obj2, obj3);
    }

    public final void zzc(String str, Object obj) {
        a(4, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final zzap zzcm() {
        return this.a;
    }

    public final GoogleAnalytics zzcr() {
        return this.a.zzde();
    }

    public final void zzd(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public final void zze(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public final void zzq(String str) {
        a(2, str, null, null, null);
    }

    public final void zzr(String str) {
        a(3, str, null, null, null);
    }

    public final void zzs(String str) {
        a(4, str, null, null, null);
    }

    public final void zzt(String str) {
        a(5, str, null, null, null);
    }

    public final void zzu(String str) {
        a(6, str, null, null, null);
    }
}
