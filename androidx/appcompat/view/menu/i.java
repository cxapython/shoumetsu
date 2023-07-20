package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class i extends androidx.appcompat.view.menu.c<androidx.core.b.a.b> implements MenuItem {
    private Method c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends androidx.core.g.b {
        final ActionProvider a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.a = actionProvider;
        }

        @Override // androidx.core.g.b
        public View a() {
            return this.a.onCreateActionView();
        }

        @Override // androidx.core.g.b
        public void a(SubMenu subMenu) {
            this.a.onPrepareSubMenu(i.this.a(subMenu));
        }

        @Override // androidx.core.g.b
        public boolean b() {
            return this.a.onPerformDefaultAction();
        }

        @Override // androidx.core.g.b
        public boolean c() {
            return this.a.hasSubMenu();
        }
    }

    /* loaded from: classes.dex */
    static class b extends FrameLayout implements androidx.appcompat.view.b {
        final CollapsibleActionView a;

        b(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.b
        public void a() {
            this.a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.b
        public void b() {
            this.a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.a;
        }
    }

    /* loaded from: classes.dex */
    private class c extends androidx.appcompat.view.menu.d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.b).onMenuItemActionCollapse(i.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.b).onMenuItemActionExpand(i.this.a(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class d extends androidx.appcompat.view.menu.d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.b).onMenuItemClick(i.this.a(menuItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = ((androidx.core.b.a.b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.c.invoke(this.b, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((androidx.core.b.a.b) this.b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((androidx.core.b.a.b) this.b).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.g.b a2 = ((androidx.core.b.a.b) this.b).a();
        if (a2 instanceof a) {
            return ((a) a2).a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((androidx.core.b.a.b) this.b).getActionView();
        return actionView instanceof b ? ((b) actionView).c() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((androidx.core.b.a.b) this.b).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((androidx.core.b.a.b) this.b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((androidx.core.b.a.b) this.b).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((androidx.core.b.a.b) this.b).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((androidx.core.b.a.b) this.b).getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((androidx.core.b.a.b) this.b).getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((androidx.core.b.a.b) this.b).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((androidx.core.b.a.b) this.b).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((androidx.core.b.a.b) this.b).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((androidx.core.b.a.b) this.b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((androidx.core.b.a.b) this.b).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((androidx.core.b.a.b) this.b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((androidx.core.b.a.b) this.b).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(((androidx.core.b.a.b) this.b).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((androidx.core.b.a.b) this.b).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((androidx.core.b.a.b) this.b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((androidx.core.b.a.b) this.b).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((androidx.core.b.a.b) this.b).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((androidx.core.b.a.b) this.b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((androidx.core.b.a.b) this.b).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((androidx.core.b.a.b) this.b).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((androidx.core.b.a.b) this.b).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((androidx.core.b.a.b) this.b).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((androidx.core.b.a.b) this.b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((androidx.core.b.a.b) this.b).setActionView(i);
        View actionView = ((androidx.core.b.a.b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((androidx.core.b.a.b) this.b).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((androidx.core.b.a.b) this.b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((androidx.core.b.a.b) this.b).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((androidx.core.b.a.b) this.b).setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((androidx.core.b.a.b) this.b).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((androidx.core.b.a.b) this.b).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.b).a(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((androidx.core.b.a.b) this.b).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((androidx.core.b.a.b) this.b).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((androidx.core.b.a.b) this.b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((androidx.core.b.a.b) this.b).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((androidx.core.b.a.b) this.b).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((androidx.core.b.a.b) this.b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((androidx.core.b.a.b) this.b).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        ((androidx.core.b.a.b) this.b).setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((androidx.core.b.a.b) this.b).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((androidx.core.b.a.b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((androidx.core.b.a.b) this.b).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((androidx.core.b.a.b) this.b).setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((androidx.core.b.a.b) this.b).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((androidx.core.b.a.b) this.b).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((androidx.core.b.a.b) this.b).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.b).b(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((androidx.core.b.a.b) this.b).setVisible(z);
    }
}
