package com.microsoft.appcenter.c.a;

import java.util.List;

/* loaded from: classes.dex */
public class e {
    private List<d> a;

    public List<d> a() {
        return this.a;
    }

    public void a(List<d> list) {
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        List<d> list = this.a;
        return list != null ? list.equals(eVar.a) : eVar.a == null;
    }

    public int hashCode() {
        List<d> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}
