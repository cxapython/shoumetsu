package com.google.android.gms.internal.drive;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl extends Handler {
    private final Context a;

    private cl(Looper looper, Context context) {
        super(looper);
        this.a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        GmsLogger gmsLogger;
        GmsLogger gmsLogger2;
        if (message.what != 1) {
            gmsLogger2 = zzee.a;
            gmsLogger2.efmt("EventCallback", "Don't know how to handle this event in context %s", this.a);
            return;
        }
        Pair pair = (Pair) message.obj;
        com.google.android.gms.drive.events.zzi zziVar = (com.google.android.gms.drive.events.zzi) pair.first;
        DriveEvent driveEvent = (DriveEvent) pair.second;
        int type = driveEvent.getType();
        if (type == 8) {
            ((com.google.android.gms.drive.events.zzl) zziVar).zza(new zze(((com.google.android.gms.drive.events.zzr) driveEvent).zzab()));
            return;
        }
        switch (type) {
            case 1:
                ((ChangeListener) zziVar).onChange((ChangeEvent) driveEvent);
                return;
            case 2:
                ((CompletionListener) zziVar).onCompletion((CompletionEvent) driveEvent);
                return;
            case 3:
                com.google.android.gms.drive.events.zzq zzqVar = (com.google.android.gms.drive.events.zzq) zziVar;
                com.google.android.gms.drive.events.zzo zzoVar = (com.google.android.gms.drive.events.zzo) driveEvent;
                DataHolder zzy = zzoVar.zzy();
                if (zzy != null) {
                    zzqVar.zza(new cm(new MetadataBuffer(zzy)));
                }
                if (!zzoVar.zzz()) {
                    return;
                }
                zzqVar.zzc(zzoVar.zzaa());
                return;
            case 4:
                ((zzd) zziVar).zza((com.google.android.gms.drive.events.zzb) driveEvent);
                return;
            default:
                gmsLogger = zzee.a;
                gmsLogger.wfmt("EventCallback", "Unexpected event: %s", driveEvent);
                return;
        }
    }
}
