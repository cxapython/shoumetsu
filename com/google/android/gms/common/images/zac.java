package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zac extends zaa {
    private WeakReference<ImageView> c;

    public zac(ImageView imageView, int i) {
        super(null, i);
        Asserts.checkNotNull(imageView);
        this.c = new WeakReference<>(imageView);
    }

    public zac(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.c = new WeakReference<>(imageView);
    }

    @Override // com.google.android.gms.common.images.zaa
    protected final void a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = this.c.get();
        if (imageView != null) {
            int i = 0;
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zaj)) {
                int zach = zaj.zach();
                if (this.b != 0 && zach == this.b) {
                    return;
                }
            }
            boolean a = a(z, z2);
            Uri uri = null;
            if (a) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof com.google.android.gms.internal.base.zae) {
                    drawable2 = ((com.google.android.gms.internal.base.zae) drawable2).zacf();
                }
                drawable = new com.google.android.gms.internal.base.zae(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                if (z3) {
                    uri = this.a.a;
                }
                zaj.zaa(uri);
                if (z4) {
                    i = this.b;
                }
                zaj.zai(i);
            }
            if (!a) {
                return;
            }
            ((com.google.android.gms.internal.base.zae) drawable).startTransition(250);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zac)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ImageView imageView = this.c.get();
        ImageView imageView2 = ((zac) obj).c.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }
}
