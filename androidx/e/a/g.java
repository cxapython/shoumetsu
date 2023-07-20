package androidx.e.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class g {
    private final h<?> a;

    private g(h<?> hVar) {
        this.a = hVar;
    }

    public static g a(h<?> hVar) {
        return new g(hVar);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.b.onCreateView(view, str, context, attributeSet);
    }

    public d a(String str) {
        return this.a.b.b(str);
    }

    public i a() {
        return this.a.k();
    }

    public void a(Configuration configuration) {
        this.a.b.a(configuration);
    }

    public void a(Parcelable parcelable, k kVar) {
        this.a.b.a(parcelable, kVar);
    }

    public void a(d dVar) {
        j jVar = this.a.b;
        h<?> hVar = this.a;
        jVar.a(hVar, hVar, dVar);
    }

    public void a(boolean z) {
        this.a.b.a(z);
    }

    public boolean a(Menu menu) {
        return this.a.b.a(menu);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.a.b.a(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.a.b.a(menuItem);
    }

    public void b() {
        this.a.b.m();
    }

    public void b(Menu menu) {
        this.a.b.b(menu);
    }

    public void b(boolean z) {
        this.a.b.b(z);
    }

    public boolean b(MenuItem menuItem) {
        return this.a.b.b(menuItem);
    }

    public Parcelable c() {
        return this.a.b.l();
    }

    public k d() {
        return this.a.b.j();
    }

    public void e() {
        this.a.b.n();
    }

    public void f() {
        this.a.b.o();
    }

    public void g() {
        this.a.b.p();
    }

    public void h() {
        this.a.b.q();
    }

    public void i() {
        this.a.b.r();
    }

    public void j() {
        this.a.b.s();
    }

    public void k() {
        this.a.b.u();
    }

    public void l() {
        this.a.b.v();
    }

    public boolean m() {
        return this.a.b.g();
    }
}
