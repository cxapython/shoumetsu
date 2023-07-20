package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

/* loaded from: classes.dex */
public abstract class zaa {
    final a a;
    protected int b;
    private int c = 0;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;

    public zaa(Uri uri, int i) {
        this.b = 0;
        this.a = new a(uri);
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, zak zakVar) {
        if (this.g) {
            a(null, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, zak zakVar, boolean z) {
        int i = this.b;
        a(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    protected abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(boolean z, boolean z2) {
        return this.e && !z2 && !z;
    }
}
