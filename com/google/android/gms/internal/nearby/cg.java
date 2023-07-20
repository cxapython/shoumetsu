package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import java.util.List;

/* loaded from: classes.dex */
final class cg extends zzha<MessageListener> {
    private final /* synthetic */ List a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(zzgw zzgwVar, List list) {
        this.a = list;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        zzgw.zza(this.a, (MessageListener) obj);
    }
}
