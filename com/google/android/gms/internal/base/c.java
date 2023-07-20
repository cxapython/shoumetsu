package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
final class c extends Drawable.ConstantState {
    private c() {
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        b bVar;
        bVar = b.a;
        return bVar;
    }
}
