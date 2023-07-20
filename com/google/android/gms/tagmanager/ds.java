package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ds implements DataLayer.b {
    private final /* synthetic */ TagManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(TagManager tagManager) {
        this.a = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        Object obj = map.get(DataLayer.EVENT_KEY);
        if (obj != null) {
            this.a.a(obj.toString());
        }
    }
}
