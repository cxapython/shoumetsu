package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.quest.Quests;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq extends zze.u<Quests.ClaimMilestoneResult> {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(BaseImplementation.ResultHolder resultHolder, String str) {
        super(resultHolder);
        this.a = str;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
    public final void zzai(DataHolder dataHolder) {
        a(new zze.ap(dataHolder, this.a));
    }
}
