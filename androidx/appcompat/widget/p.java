package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.e.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class p extends TextView implements androidx.core.g.n, androidx.core.widget.b {
    private final f a;
    private final o b;
    private Future<androidx.core.e.a> c;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public p(Context context, AttributeSet attributeSet, int i) {
        super(ag.a(context), attributeSet, i);
        this.a = new f(this);
        this.a.a(attributeSet, i);
        this.b = new o(this);
        this.b.a(attributeSet, i);
        this.b.a();
    }

    private void a() {
        Future<androidx.core.e.a> future = this.c;
        if (future != null) {
            try {
                this.c = null;
                androidx.core.widget.h.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d) {
            return super.getAutoSizeMaxTextSize();
        }
        o oVar = this.b;
        if (oVar == null) {
            return -1;
        }
        return oVar.g();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d) {
            return super.getAutoSizeMinTextSize();
        }
        o oVar = this.b;
        if (oVar == null) {
            return -1;
        }
        return oVar.f();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d) {
            return super.getAutoSizeStepGranularity();
        }
        o oVar = this.b;
        if (oVar == null) {
            return -1;
        }
        return oVar.e();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        o oVar = this.b;
        return oVar != null ? oVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        o oVar = this.b;
        if (oVar == null) {
            return 0;
        }
        return oVar.d();
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.h.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.h.b(this);
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

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    public a.C0023a getTextMetricsParamsCompat() {
        return androidx.core.widget.h.c(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        o oVar = this.b;
        if (oVar != null) {
            oVar.a(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.b == null || d || !this.b.c()) {
            return;
        }
        this.b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        o oVar = this.b;
        if (oVar == null) {
            return;
        }
        oVar.a(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        o oVar = this.b;
        if (oVar == null) {
            return;
        }
        oVar.a(iArr, i);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (d) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        o oVar = this.b;
        if (oVar == null) {
            return;
        }
        oVar.a(i);
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.h.a(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.h.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.h.c(this, i);
    }

    public void setPrecomputedText(androidx.core.e.a aVar) {
        androidx.core.widget.h.a(this, aVar);
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

    public void setTextFuture(Future<androidx.core.e.a> future) {
        this.c = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(a.C0023a c0023a) {
        androidx.core.widget.h.a(this, c0023a);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (d) {
            super.setTextSize(i, f);
            return;
        }
        o oVar = this.b;
        if (oVar == null) {
            return;
        }
        oVar.a(i, f);
    }
}
