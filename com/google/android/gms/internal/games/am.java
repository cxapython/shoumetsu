package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes.dex */
final class am implements Quests.ClaimMilestoneResult {
    private final /* synthetic */ Status a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, Status status) {
        this.a = status;
    }

    @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    public final Milestone getMilestone() {
        return null;
    }

    @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
    public final Quest getQuest() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.a;
    }
}
