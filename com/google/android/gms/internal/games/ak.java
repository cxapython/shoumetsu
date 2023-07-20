package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes.dex */
final class ak implements Quests.AcceptQuestResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
    public final Quest getQuest() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
