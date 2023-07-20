package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes.dex */
final class ao implements Quests.LoadQuestsResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
    public final QuestBuffer getQuests() {
        return new QuestBuffer(DataHolder.empty(this.a.getStatusCode()));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
