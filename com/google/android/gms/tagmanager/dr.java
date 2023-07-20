package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dr implements DataLayer.b {
    private final Context a;

    public dr(Context context) {
        this.a = context;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get(ImagesContract.URL);
        }
        if (obj2 == null || !(obj2 instanceof String) || (queryParameter = Uri.parse((String) obj2).getQueryParameter(Constants.REFERRER)) == null) {
            return;
        }
        zzcw.zzf(this.a, queryParameter);
    }
}
