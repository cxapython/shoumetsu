package androidx.core.g.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    private final Object a;

    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {
        final b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            androidx.core.g.a.a a = this.a.a(i);
            if (a == null) {
                return null;
            }
            return a.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<androidx.core.g.a.a> a = this.a.a(str, i);
            if (a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.a(i, i2, bundle);
        }
    }

    /* renamed from: androidx.core.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0026b extends a {
        C0026b(b bVar) {
            super(bVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            androidx.core.g.a.a b = this.a.b(i);
            if (b == null) {
                return null;
            }
            return b.a();
        }
    }

    public b() {
        this.a = Build.VERSION.SDK_INT >= 19 ? new C0026b(this) : Build.VERSION.SDK_INT >= 16 ? new a(this) : null;
    }

    public b(Object obj) {
        this.a = obj;
    }

    public androidx.core.g.a.a a(int i) {
        return null;
    }

    public Object a() {
        return this.a;
    }

    public List<androidx.core.g.a.a> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public androidx.core.g.a.a b(int i) {
        return null;
    }
}
