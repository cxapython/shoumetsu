package net.gree.gamelib.core.a;

/* loaded from: classes.dex */
public class d {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private i g;

    /* loaded from: classes.dex */
    public static class a {
        private String a = null;
        private String b = null;
        private String c = null;
        private String d = null;
        private String e = null;
        private String f = null;
        private i g;

        public a(i iVar) {
            this.g = null;
            this.g = iVar;
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public a e(String str) {
            this.d = str;
            return this;
        }

        public a f(String str) {
            this.c = str;
            return this;
        }
    }

    d(a aVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = aVar.a;
        this.b = aVar.b;
        this.e = aVar.e;
        this.f = aVar.f;
        this.d = aVar.d;
        this.c = aVar.c;
        this.g = aVar.g;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.c;
    }

    public i g() {
        return this.g;
    }
}
