package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.g.d;
import androidx.lifecycle.e;
import androidx.lifecycle.o;

/* loaded from: classes.dex */
public class d extends Activity implements d.a, androidx.lifecycle.g {
    private androidx.b.g<Class<? extends Object>, Object> a = new androidx.b.g<>();
    private androidx.lifecycle.h b = new androidx.lifecycle.h(this);

    @Override // androidx.core.g.d.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.g.d.a(decorView, keyEvent)) {
            return androidx.core.g.d.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.g.d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.e getLifecycle() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.b.a(e.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
