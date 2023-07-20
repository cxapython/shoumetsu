package net.gree.gamelib.moderation.a;

import net.gree.gamelib.moderation.KeywordFilterListener;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class c extends net.gree.gamelib.moderation.a.b.a {
    protected static final String a = "timestamp";
    protected static final String b = "keywords";
    private static final String k = "c";
    protected String c;
    protected b[] d;

    /* loaded from: classes.dex */
    public static class a extends net.gree.gamelib.moderation.a.b.b<c> {
        public a(KeywordFilterListener<c> keywordFilterListener) {
            super(c.k, keywordFilterListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.moderation.a.b.b
        /* renamed from: a */
        public c b(String str) {
            return new c(str);
        }
    }

    public c(String str) {
        super(str);
        this.c = null;
        this.d = null;
        this.c = d().getString(a);
        JSONArray optJSONArray = d().optJSONArray(b);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            this.d = new b[length];
            for (int i = 0; i < length; i++) {
                this.d[i] = new b(optJSONArray.getJSONObject(i));
            }
        }
    }

    public String a() {
        return this.c;
    }

    public b[] b() {
        return this.d;
    }
}
