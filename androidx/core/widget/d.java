package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class d {
    public static ColorStateList a(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (!(imageView instanceof i)) {
            return null;
        }
        return ((i) imageView).getSupportImageTintList();
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT < 21) {
            if (!(imageView instanceof i)) {
                return;
            }
            ((i) imageView).setSupportImageTintList(colorStateList);
            return;
        }
        imageView.setImageTintList(colorStateList);
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
        if (drawable == null || !z) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static void a(ImageView imageView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT < 21) {
            if (!(imageView instanceof i)) {
                return;
            }
            ((i) imageView).setSupportImageTintMode(mode);
            return;
        }
        imageView.setImageTintMode(mode);
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
        if (drawable == null || !z) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (!(imageView instanceof i)) {
            return null;
        }
        return ((i) imageView).getSupportImageTintMode();
    }
}
