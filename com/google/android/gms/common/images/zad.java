package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zad extends zaa {
    private WeakReference<ImageManager.OnImageLoadedListener> c;

    public zad(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(onImageLoadedListener);
        this.c = new WeakReference<>(onImageLoadedListener);
    }

    @Override // com.google.android.gms.common.images.zaa
    protected final void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (z2 || (onImageLoadedListener = this.c.get()) == null) {
            return;
        }
        onImageLoadedListener.onImageLoaded(this.a.a, drawable, z3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zad)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zad zadVar = (zad) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.c.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zadVar.c.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.equal(onImageLoadedListener2, onImageLoadedListener) && Objects.equal(zadVar.a, this.a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }
}
