package net.gree.gamelib.moderation.a.a;

import net.gree.gamelib.moderation.KeywordFilterListener;

/* loaded from: classes.dex */
public class c extends net.gree.gamelib.moderation.a.b.a {
    protected static final String a = "restriction";
    private static final String c = "c";
    protected String b;

    /* loaded from: classes.dex */
    public static class a extends net.gree.gamelib.moderation.a.b.b<c> {
        public a(KeywordFilterListener<c> keywordFilterListener) {
            super(c.c, keywordFilterListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.moderation.a.b.b
        /* renamed from: a */
        public c b(String str) {
            return new c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(String str) {
        super(str);
        this.b = null;
        String optString = d().optString(a);
        if (optString != null) {
            this.b = optString.replace("[", "").replace("]", "").replace("\"", "").replace(",", "|");
        }
    }

    public String a() {
        return this.b;
    }
}
