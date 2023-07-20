package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes.dex */
public class h extends EditText implements androidx.core.g.n {
    private final f a;
    private final o b;

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.a;
        if (fVar != null) {
            fVar.c();
        }
        o oVar = this.b;
        if (oVar != null) {
            oVar.a();
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

    @Override // android.widget.EditText, android.widget.TextView
    /* renamed from: getText */
    public Editable mo0getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.h.a(this, callback));
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        o oVar = this.b;
        if (oVar != null) {
            oVar.a(context, i);
        }
    }
}
