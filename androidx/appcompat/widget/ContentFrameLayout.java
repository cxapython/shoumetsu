package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    private TypedValue a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;
    private a h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.a == null) {
            this.a = new TypedValue();
        }
        return this.a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int measuredWidth;
        TypedValue typedValue;
        int i4;
        float fraction;
        int i5;
        float fraction2;
        int i6;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.d : this.c;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    fraction3 = typedValue2.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                } else {
                    i6 = 0;
                    if (i6 > 0) {
                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i6 - (this.g.left + this.g.right), View.MeasureSpec.getSize(i)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z3 ? this.e : this.f;
                            if (typedValue3 != null && typedValue3.type != 0) {
                                if (typedValue3.type == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (typedValue3.type == 6) {
                                    fraction2 = typedValue3.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels);
                                } else {
                                    i5 = 0;
                                    if (i5 > 0) {
                                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                                    }
                                }
                                i5 = (int) fraction2;
                                if (i5 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i3, i2);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z && mode == Integer.MIN_VALUE) {
                            typedValue = !z3 ? this.b : this.a;
                            if (typedValue != null && typedValue.type != 0) {
                                if (typedValue.type != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (typedValue.type == 6) {
                                    fraction = typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                                } else {
                                    i4 = 0;
                                    if (i4 > 0) {
                                        i4 -= this.g.left + this.g.right;
                                    }
                                    if (measuredWidth < i4) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                        if (!z2) {
                                            return;
                                        }
                                        super.onMeasure(makeMeasureSpec, i2);
                                        return;
                                    }
                                }
                                i4 = (int) fraction;
                                if (i4 > 0) {
                                }
                                if (measuredWidth < i4) {
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                        }
                    }
                }
                i6 = (int) fraction3;
                if (i6 > 0) {
                }
            }
        }
        i3 = i;
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i3, i2);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z) {
            if (!z3) {
            }
            if (typedValue != null) {
                if (typedValue.type != 5) {
                }
                i4 = (int) fraction;
                if (i4 > 0) {
                }
                if (measuredWidth < i4) {
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
    }

    public void setAttachListener(a aVar) {
        this.h = aVar;
    }
}
