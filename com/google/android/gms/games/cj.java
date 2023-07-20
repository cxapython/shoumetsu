package com.google.android.gms.games;

import com.google.android.gms.games.Games;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class cj extends Games.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cj() {
        super(null);
    }

    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final /* synthetic */ List getImpliedScopes(Object obj) {
        return Collections.singletonList(Games.zzam);
    }
}
