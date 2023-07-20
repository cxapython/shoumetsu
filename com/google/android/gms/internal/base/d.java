package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class d extends Drawable.ConstantState {
    int a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(d dVar) {
        if (dVar != null) {
            this.a = dVar.a;
            this.b = dVar.b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zae(this);
    }
}
