package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class az extends UnregisterListenerMethod<zzaw, bs> {
    private final /* synthetic */ DriveResource a;
    private final /* synthetic */ bs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(zzch zzchVar, ListenerHolder.ListenerKey listenerKey, DriveResource driveResource, bs bsVar) {
        super(listenerKey);
        this.a = driveResource;
        this.b = bsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void a(zzaw zzawVar, TaskCompletionSource taskCompletionSource) {
        ((zzeo) zzawVar.getService()).zza(new zzgm(this.a.getDriveId(), 1), bs.a(this.b), (String) null, new zzhk(taskCompletionSource));
    }
}
