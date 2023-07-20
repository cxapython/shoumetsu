package com.microsoft.appcenter.c.a.b;

import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes.dex */
public class f implements com.microsoft.appcenter.c.a.g {
    private h a;
    private l b;
    private n c;
    private e d;
    private j e;
    private a f;
    private i g;
    private m h;
    private g i;

    public h a() {
        return this.a;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    public void a(g gVar) {
        this.i = gVar;
    }

    public void a(h hVar) {
        this.a = hVar;
    }

    public void a(i iVar) {
        this.g = iVar;
    }

    public void a(j jVar) {
        this.e = jVar;
    }

    public void a(l lVar) {
        this.b = lVar;
    }

    public void a(m mVar) {
        this.h = mVar;
    }

    public void a(n nVar) {
        this.c = nVar;
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONObject jSONObject) {
        if (jSONObject.has("metadata")) {
            h hVar = new h();
            hVar.a(jSONObject.getJSONObject("metadata"));
            a(hVar);
        }
        if (jSONObject.has("protocol")) {
            l lVar = new l();
            lVar.a(jSONObject.getJSONObject("protocol"));
            a(lVar);
        }
        if (jSONObject.has("user")) {
            n nVar = new n();
            nVar.a(jSONObject.getJSONObject("user"));
            a(nVar);
        }
        if (jSONObject.has("device")) {
            e eVar = new e();
            eVar.a(jSONObject.getJSONObject("device"));
            a(eVar);
        }
        if (jSONObject.has("os")) {
            j jVar = new j();
            jVar.a(jSONObject.getJSONObject("os"));
            a(jVar);
        }
        if (jSONObject.has("app")) {
            a aVar = new a();
            aVar.a(jSONObject.getJSONObject("app"));
            a(aVar);
        }
        if (jSONObject.has("net")) {
            i iVar = new i();
            iVar.a(jSONObject.getJSONObject("net"));
            a(iVar);
        }
        if (jSONObject.has("sdk")) {
            m mVar = new m();
            mVar.a(jSONObject.getJSONObject("sdk"));
            a(mVar);
        }
        if (jSONObject.has("loc")) {
            g gVar = new g();
            gVar.a(jSONObject.getJSONObject("loc"));
            a(gVar);
        }
    }

    @Override // com.microsoft.appcenter.c.a.g
    public void a(JSONStringer jSONStringer) {
        if (a() != null) {
            jSONStringer.key("metadata").object();
            a().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (b() != null) {
            jSONStringer.key("protocol").object();
            b().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (c() != null) {
            jSONStringer.key("user").object();
            c().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (d() != null) {
            jSONStringer.key("device").object();
            d().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (e() != null) {
            jSONStringer.key("os").object();
            e().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (f() != null) {
            jSONStringer.key("app").object();
            f().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (g() != null) {
            jSONStringer.key("net").object();
            g().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (h() != null) {
            jSONStringer.key("sdk").object();
            h().a(jSONStringer);
            jSONStringer.endObject();
        }
        if (i() != null) {
            jSONStringer.key("loc").object();
            i().a(jSONStringer);
            jSONStringer.endObject();
        }
    }

    public l b() {
        return this.b;
    }

    public n c() {
        return this.c;
    }

    public e d() {
        return this.d;
    }

    public j e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        h hVar = this.a;
        if (hVar == null ? fVar.a != null : !hVar.equals(fVar.a)) {
            return false;
        }
        l lVar = this.b;
        if (lVar == null ? fVar.b != null : !lVar.equals(fVar.b)) {
            return false;
        }
        n nVar = this.c;
        if (nVar == null ? fVar.c != null : !nVar.equals(fVar.c)) {
            return false;
        }
        e eVar = this.d;
        if (eVar == null ? fVar.d != null : !eVar.equals(fVar.d)) {
            return false;
        }
        j jVar = this.e;
        if (jVar == null ? fVar.e != null : !jVar.equals(fVar.e)) {
            return false;
        }
        a aVar = this.f;
        if (aVar == null ? fVar.f != null : !aVar.equals(fVar.f)) {
            return false;
        }
        i iVar = this.g;
        if (iVar == null ? fVar.g != null : !iVar.equals(fVar.g)) {
            return false;
        }
        m mVar = this.h;
        if (mVar == null ? fVar.h != null : !mVar.equals(fVar.h)) {
            return false;
        }
        g gVar = this.i;
        return gVar != null ? gVar.equals(fVar.i) : fVar.i == null;
    }

    public a f() {
        return this.f;
    }

    public i g() {
        return this.g;
    }

    public m h() {
        return this.h;
    }

    public int hashCode() {
        h hVar = this.a;
        int i = 0;
        int hashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        l lVar = this.b;
        int hashCode2 = (hashCode + (lVar != null ? lVar.hashCode() : 0)) * 31;
        n nVar = this.c;
        int hashCode3 = (hashCode2 + (nVar != null ? nVar.hashCode() : 0)) * 31;
        e eVar = this.d;
        int hashCode4 = (hashCode3 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        j jVar = this.e;
        int hashCode5 = (hashCode4 + (jVar != null ? jVar.hashCode() : 0)) * 31;
        a aVar = this.f;
        int hashCode6 = (hashCode5 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        i iVar = this.g;
        int hashCode7 = (hashCode6 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        m mVar = this.h;
        int hashCode8 = (hashCode7 + (mVar != null ? mVar.hashCode() : 0)) * 31;
        g gVar = this.i;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        return hashCode8 + i;
    }

    public g i() {
        return this.i;
    }
}
