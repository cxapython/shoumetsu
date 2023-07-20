package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: classes.dex */
public class j extends ImageButton implements androidx.core.g.n, androidx.core.widget.i {
    private final f a;
    private final k b;

    public j(Context context, AttributeSet attributeSet, int i) {
        super(ag.a(context), attributeSet, i);
        this.a = new f(this);
        this.a.a(attributeSet, i);
        this.b = new k(this);
        this.b.a(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.a;
        if (fVar != null) {
            fVar.c();
        }
        k kVar = this.b;
        if (kVar != null) {
            kVar.d();
        }
    }

    @Override // androidx.core.g.n
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.g.n
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.i
    public ColorStateList getSupportImageTintList() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.i
    public PorterDuff.Mode getSupportImageTintMode() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.b.a() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        k kVar = this.b;
        if (kVar != null) {
            kVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.b;
        if (kVar != null) {
            kVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.b.a(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.b;
        if (kVar != null) {
            kVar.d();
        }
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.widget.i
    public void setSupportImageTintList(ColorStateList colorStateList) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.i
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.a(mode);
        }
    }
}
