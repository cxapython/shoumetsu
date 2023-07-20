package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.a;

/* loaded from: classes.dex */
public class e extends AutoCompleteTextView implements androidx.core.g.n {
    private static final int[] a = {16843126};
    private final f b;
    private final o c;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.autoCompleteTextViewStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(ag.a(context), attributeSet, i);
        aj a2 = aj.a(getContext(), attributeSet, a, i, 0);
        if (a2.f(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.a();
        this.b = new f(this);
        this.b.a(attributeSet, i);
        this.c = new o(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.b;
        if (fVar != null) {
            fVar.c();
        }
        o oVar = this.c;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // androidx.core.g.n
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.b;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.g.n
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.b;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.h.a(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.g.n
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        o oVar = this.c;
        if (oVar != null) {
            oVar.a(context, i);
        }
    }
}
