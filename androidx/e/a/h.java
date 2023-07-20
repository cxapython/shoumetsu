package androidx.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class h<E> extends f {
    private final Activity a;
    final j b;
    private final Context c;
    private final Handler d;
    private final int e;

    h(Activity activity, Context context, Handler handler, int i) {
        this.b = new j();
        this.a = activity;
        this.c = (Context) androidx.core.f.d.a(context, "context == null");
        this.d = (Handler) androidx.core.f.d.a(handler, "handler == null");
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this(eVar, eVar, eVar.a, 0);
    }

    @Override // androidx.e.a.f
    public View a(int i) {
        return null;
    }

    public void a(d dVar, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            androidx.core.app.a.a(this.a, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void a(d dVar, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.e.a.f
    public boolean a() {
        return true;
    }

    public boolean a(d dVar) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
    }

    public void d() {
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return this.e;
    }

    public abstract E g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity h() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler j() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j k() {
        return this.b;
    }
}
