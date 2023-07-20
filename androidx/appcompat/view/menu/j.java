package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.i;
import androidx.core.g.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {

    /* loaded from: classes.dex */
    class a extends i.a implements ActionProvider.VisibilityListener {
        b.InterfaceC0027b c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.g.b
        public View a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.g.b
        public void a(b.InterfaceC0027b interfaceC0027b) {
            this.c = interfaceC0027b;
            this.a.setVisibilityListener(interfaceC0027b != null ? this : null);
        }

        @Override // androidx.core.g.b
        public boolean d() {
            return this.a.overridesItemVisibility();
        }

        @Override // androidx.core.g.b
        public boolean e() {
            return this.a.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            b.InterfaceC0027b interfaceC0027b = this.c;
            if (interfaceC0027b != null) {
                interfaceC0027b.a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    @Override // androidx.appcompat.view.menu.i
    i.a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }
}
