package net.gree.gamelib.moderation.a.b;

import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.moderation.KeywordFilterListener;
import net.gree.gamelib.moderation.a.b.a;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b<T extends a> extends ResponseAdapter<T> {
    public b(String str, KeywordFilterListener<T> keywordFilterListener) {
        super(str, keywordFilterListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.gree.gamelib.core.http.ResponseAdapter
    /* renamed from: a */
    public T mo48jsonObjectToResponseData(JSONObject jSONObject) {
        return null;
    }

    protected abstract T b(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.gree.gamelib.core.http.ResponseAdapter
    /* renamed from: c */
    public T mo49jsonStringToResponseData(String str) {
        return b(str);
    }
}
