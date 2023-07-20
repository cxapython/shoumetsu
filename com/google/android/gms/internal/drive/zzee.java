package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.events.DriveEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzee extends zzet {
    private static final GmsLogger a = new GmsLogger("EventCallback", "");
    private final com.google.android.gms.drive.events.zzi c;
    private final cl d;
    private final List<Integer> e = new ArrayList();
    private final int b = 1;

    public zzee(Looper looper, Context context, int i, com.google.android.gms.drive.events.zzi zziVar) {
        this.c = zziVar;
        this.d = new cl(looper, context);
    }

    @Override // com.google.android.gms.internal.drive.zzes
    public final void zzc(zzfj zzfjVar) {
        DriveEvent zzak = zzfjVar.zzak();
        Preconditions.checkState(this.b == zzak.getType());
        Preconditions.checkState(this.e.contains(Integer.valueOf(zzak.getType())));
        cl clVar = this.d;
        clVar.sendMessage(clVar.obtainMessage(1, new Pair(this.c, zzak)));
    }

    public final void zzf(int i) {
        this.e.add(1);
    }

    public final boolean zzg(int i) {
        return this.e.contains(1);
    }
}
