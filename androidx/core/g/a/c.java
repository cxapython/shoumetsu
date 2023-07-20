package androidx.core.g.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class c {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityRecord accessibilityRecord = this.a;
        if (accessibilityRecord == null) {
            if (cVar.a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(cVar.a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
