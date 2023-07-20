package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.a;
import com.google.android.gms.nearby.messages.BleSignal;

/* loaded from: classes.dex */
public class w extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        aj a2 = aj.a(context, attributeSet, a.j.LinearLayoutCompat, i, 0);
        int a3 = a2.a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(a.j.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.g = a2.a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a2.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a2.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(a.j.LinearLayoutCompat_divider));
        this.n = a2.a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = a2.e(a.j.LinearLayoutCompat_dividerPadding, 0);
        a2.a();
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                a aVar = (a) b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x02dd, code lost:
        if (r15 > 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02e8, code lost:
        if (r15 < 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02ea, code lost:
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02eb, code lost:
        r13.measure(r9, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & (-256));
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        int i10;
        boolean z;
        int i11;
        int max;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View view;
        int max2;
        boolean z2;
        int max3;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i20 = this.b;
        boolean z3 = this.h;
        float f2 = 0.0f;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i27 = 8;
            int i28 = i24;
            if (i26 >= virtualChildCount) {
                int i29 = i21;
                int i30 = i23;
                int i31 = i25;
                int i32 = virtualChildCount;
                int i33 = i22;
                int i34 = mode2;
                if (this.f > 0) {
                    i3 = i32;
                    if (c(i3)) {
                        this.f += this.m;
                    }
                } else {
                    i3 = i32;
                }
                if (z3) {
                    i4 = i34;
                    if (i4 == Integer.MIN_VALUE || i4 == 0) {
                        this.f = 0;
                        int i35 = 0;
                        while (i35 < i3) {
                            View b = b(i35);
                            if (b == null) {
                                max = this.f + d(i35);
                            } else if (b.getVisibility() == i27) {
                                i35 += a(b, i35);
                                i35++;
                                i27 = 8;
                            } else {
                                a aVar = (a) b.getLayoutParams();
                                int i36 = this.f;
                                max = Math.max(i36, i36 + i30 + aVar.topMargin + aVar.bottomMargin + b(b));
                            }
                            this.f = max;
                            i35++;
                            i27 = 8;
                        }
                    }
                } else {
                    i4 = i34;
                }
                this.f += getPaddingTop() + getPaddingBottom();
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
                int i37 = (16777215 & resolveSizeAndState) - this.f;
                if (z4 || (i37 != 0 && f2 > 0.0f)) {
                    float f3 = this.g;
                    if (f3 > 0.0f) {
                        f2 = f3;
                    }
                    this.f = 0;
                    float f4 = f2;
                    int i38 = 0;
                    int i39 = i31;
                    i5 = i29;
                    while (i38 < i3) {
                        View b2 = b(i38);
                        if (b2.getVisibility() == 8) {
                            f = f4;
                        } else {
                            a aVar2 = (a) b2.getLayoutParams();
                            float f5 = aVar2.g;
                            if (f5 > 0.0f) {
                                int i40 = (int) ((i37 * f5) / f4);
                                i8 = i37 - i40;
                                f = f4 - f5;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + aVar2.leftMargin + aVar2.rightMargin, aVar2.width);
                                if (aVar2.height == 0) {
                                    i11 = 1073741824;
                                    if (i4 == 1073741824) {
                                    }
                                } else {
                                    i11 = 1073741824;
                                }
                                i40 = b2.getMeasuredHeight() + i40;
                            } else {
                                i8 = i37;
                                f = f4;
                            }
                            int i41 = aVar2.leftMargin + aVar2.rightMargin;
                            int measuredWidth = b2.getMeasuredWidth() + i41;
                            i33 = Math.max(i33, measuredWidth);
                            if (mode != 1073741824) {
                                i9 = i5;
                                i10 = -1;
                                if (aVar2.width == -1) {
                                    z = true;
                                    if (!z) {
                                        i41 = measuredWidth;
                                    }
                                    i39 = Math.max(i39, i41);
                                    boolean z7 = !z5 && aVar2.width == i10;
                                    int i42 = this.f;
                                    this.f = Math.max(i42, b2.getMeasuredHeight() + i42 + aVar2.topMargin + aVar2.bottomMargin + b(b2));
                                    z5 = z7;
                                    i37 = i8;
                                    i5 = i9;
                                }
                            } else {
                                i9 = i5;
                                i10 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            i39 = Math.max(i39, i41);
                            if (!z5) {
                            }
                            int i422 = this.f;
                            this.f = Math.max(i422, b2.getMeasuredHeight() + i422 + aVar2.topMargin + aVar2.bottomMargin + b(b2));
                            z5 = z7;
                            i37 = i8;
                            i5 = i9;
                        }
                        i38++;
                        f4 = f;
                    }
                    i6 = i;
                    this.f += getPaddingTop() + getPaddingBottom();
                    i7 = i39;
                } else {
                    i7 = Math.max(i31, i28);
                    if (z3 && i4 != 1073741824) {
                        for (int i43 = 0; i43 < i3; i43++) {
                            View b3 = b(i43);
                            if (b3 != null && b3.getVisibility() != 8 && ((a) b3.getLayoutParams()).g > 0.0f) {
                                b3.measure(View.MeasureSpec.makeMeasureSpec(b3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i30, 1073741824));
                            }
                        }
                    }
                    i5 = i29;
                    i6 = i;
                }
                if (z5 || mode == 1073741824) {
                    i7 = i33;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i5), resolveSizeAndState);
                if (!z6) {
                    return;
                }
                c(i3, i2);
                return;
            }
            View b4 = b(i26);
            if (b4 == null) {
                this.f += d(i26);
                i15 = virtualChildCount;
                i24 = i28;
            } else {
                int i44 = i21;
                if (b4.getVisibility() == 8) {
                    i26 += a(b4, i26);
                    i15 = virtualChildCount;
                    i24 = i28;
                    i21 = i44;
                } else {
                    if (c(i26)) {
                        this.f += this.m;
                    }
                    a aVar3 = (a) b4.getLayoutParams();
                    float f6 = f2 + aVar3.g;
                    if (mode2 == 1073741824 && aVar3.height == 0 && aVar3.g > 0.0f) {
                        int i45 = this.f;
                        this.f = Math.max(i45, aVar3.topMargin + i45 + aVar3.bottomMargin);
                        max2 = i23;
                        view = b4;
                        i18 = i25;
                        i15 = virtualChildCount;
                        i13 = i44;
                        i14 = i22;
                        z4 = true;
                        i19 = i26;
                        i16 = mode2;
                        i17 = i28;
                    } else {
                        int i46 = i22;
                        if (aVar3.height != 0 || aVar3.g <= 0.0f) {
                            i12 = BleSignal.UNKNOWN_TX_POWER;
                        } else {
                            aVar3.height = -2;
                            i12 = 0;
                        }
                        i13 = i44;
                        int i47 = i12;
                        i14 = i46;
                        int i48 = i23;
                        i15 = virtualChildCount;
                        i16 = mode2;
                        i17 = i28;
                        i18 = i25;
                        i19 = i26;
                        a(b4, i26, i, 0, i2, f6 == 0.0f ? this.f : 0);
                        if (i47 != Integer.MIN_VALUE) {
                            aVar3.height = i47;
                        }
                        int measuredHeight = b4.getMeasuredHeight();
                        int i49 = this.f;
                        view = b4;
                        this.f = Math.max(i49, i49 + measuredHeight + aVar3.topMargin + aVar3.bottomMargin + b(view));
                        max2 = z3 ? Math.max(measuredHeight, i48) : i48;
                    }
                    if (i20 >= 0 && i20 == i19 + 1) {
                        this.c = this.f;
                    }
                    if (i19 < i20 && aVar3.g > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || aVar3.width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z6 = true;
                    }
                    int i50 = aVar3.leftMargin + aVar3.rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i50;
                    int max4 = Math.max(i14, measuredWidth2);
                    int combineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                    boolean z8 = z5 && aVar3.width == -1;
                    if (aVar3.g > 0.0f) {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        i17 = Math.max(i17, i50);
                        max3 = i18;
                    } else {
                        if (!z2) {
                            i50 = measuredWidth2;
                        }
                        max3 = Math.max(i18, i50);
                    }
                    i23 = max2;
                    z5 = z8;
                    i24 = i17;
                    f2 = f6;
                    i25 = max3;
                    i21 = combineMeasuredStates;
                    i26 = a(view, i19) + i19;
                    i22 = max4;
                    i26++;
                    mode2 = i16;
                    virtualChildCount = i15;
                }
            }
            i16 = mode2;
            i26++;
            mode2 = i16;
            virtualChildCount = i15;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.e;
        int i9 = i8 & 112;
        int i10 = i8 & 8388615;
        int paddingTop = i9 != 16 ? i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.f : getPaddingTop() + (((i4 - i2) - this.f) / 2);
        int i11 = 0;
        while (i11 < virtualChildCount) {
            View b = b(i11);
            if (b == null) {
                paddingTop += d(i11);
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                int i12 = aVar.h;
                if (i12 < 0) {
                    i12 = i10;
                }
                int a2 = androidx.core.g.c.a(i12, androidx.core.g.o.b(this)) & 7;
                if (a2 == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + aVar.leftMargin;
                } else if (a2 != 5) {
                    i6 = aVar.leftMargin + paddingLeft;
                    int i13 = i6;
                    if (c(i11)) {
                        paddingTop += this.m;
                    }
                    int i14 = paddingTop + aVar.topMargin;
                    a(b, i13, i14 + a(b), measuredWidth, measuredHeight);
                    i11 += a(b, i11);
                    paddingTop = i14 + measuredHeight + aVar.bottomMargin + b(b);
                } else {
                    i5 = paddingRight - measuredWidth;
                }
                i6 = i5 - aVar.rightMargin;
                int i132 = i6;
                if (c(i11)) {
                }
                int i142 = paddingTop + aVar.topMargin;
                a(b, i132, i142 + a(b), measuredWidth, measuredHeight);
                i11 += a(b, i11);
                paddingTop = i142 + measuredHeight + aVar.bottomMargin + b(b);
            }
            i11++;
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View b = b(i);
            if (b != null && b.getVisibility() != 8 && c(i)) {
                a(canvas, (b.getTop() - ((a) b.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            a(canvas, b2 == null ? (getHeight() - getPaddingBottom()) - this.m : b2.getBottom() + ((a) b2.getLayoutParams()).bottomMargin);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int b(View view) {
        return 0;
    }

    View b(int i) {
        return getChildAt(i);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x03ad, code lost:
        if (r8 > 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03b8, code lost:
        if (r8 < 0) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03ba, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03bb, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r4), r2);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & (-16777216));
        r2 = r2;
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void b(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int max;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        boolean z;
        int baseline;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        View view;
        int max2;
        int i14;
        boolean z4;
        int measuredHeight;
        int baseline2;
        int max3;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr2 = this.i;
        int[] iArr3 = this.j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.a;
        boolean z6 = this.h;
        int i15 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f2 = 0.0f;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z8 = false;
        int i21 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i16 >= virtualChildCount) {
                break;
            }
            View b = b(i16);
            if (b == null) {
                this.f += d(i16);
            } else if (b.getVisibility() == 8) {
                i16 += a(b, i16);
            } else {
                if (c(i16)) {
                    this.f += this.l;
                }
                a aVar = (a) b.getLayoutParams();
                float f3 = f2 + aVar.g;
                if (mode == i15 && aVar.width == 0 && aVar.g > 0.0f) {
                    if (z7) {
                        max3 = this.f + aVar.leftMargin + aVar.rightMargin;
                    } else {
                        int i22 = this.f;
                        max3 = Math.max(i22, aVar.leftMargin + i22 + aVar.rightMargin);
                    }
                    this.f = max3;
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(makeMeasureSpec, makeMeasureSpec);
                        i13 = i16;
                        z2 = z6;
                        z3 = z5;
                        view = b;
                    } else {
                        i13 = i16;
                        z2 = z6;
                        z3 = z5;
                        view = b;
                        i14 = 1073741824;
                        z8 = true;
                        if (mode2 == i14 && aVar.height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i23 = aVar.topMargin + aVar.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i23;
                        int combineMeasuredStates = View.combineMeasuredStates(i21, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            int i24 = ((((aVar.h >= 0 ? this.e : aVar.h) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i24] = Math.max(iArr2[i24], baseline2);
                            iArr[i24] = Math.max(iArr[i24], measuredHeight - baseline2);
                        }
                        int max4 = Math.max(i18, measuredHeight);
                        boolean z11 = !z9 && aVar.height == -1;
                        if (aVar.g <= 0.0f) {
                            if (!z4) {
                                i23 = measuredHeight;
                            }
                            i20 = Math.max(i20, i23);
                        } else {
                            int i25 = i20;
                            if (z4) {
                                measuredHeight = i23;
                            }
                            i19 = Math.max(i19, measuredHeight);
                            i20 = i25;
                        }
                        int i26 = i13;
                        i18 = max4;
                        i21 = combineMeasuredStates;
                        z9 = z11;
                        i16 = a(view, i26) + i26;
                        f2 = f3;
                        i16++;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i15 = 1073741824;
                    }
                } else {
                    if (aVar.width != 0 || aVar.g <= 0.0f) {
                        i12 = BleSignal.UNKNOWN_TX_POWER;
                    } else {
                        aVar.width = -2;
                        i12 = 0;
                    }
                    i13 = i16;
                    int i27 = i12;
                    z2 = z6;
                    z3 = z5;
                    a(b, i13, i, f3 == 0.0f ? this.f : 0, i2, 0);
                    if (i27 != Integer.MIN_VALUE) {
                        aVar.width = i27;
                    }
                    int measuredWidth = b.getMeasuredWidth();
                    if (z7) {
                        view = b;
                        max2 = this.f + aVar.leftMargin + measuredWidth + aVar.rightMargin + b(view);
                    } else {
                        view = b;
                        int i28 = this.f;
                        max2 = Math.max(i28, i28 + measuredWidth + aVar.leftMargin + aVar.rightMargin + b(view));
                    }
                    this.f = max2;
                    if (z2) {
                        i17 = Math.max(measuredWidth, i17);
                    }
                }
                i14 = 1073741824;
                if (mode2 == i14) {
                }
                z4 = false;
                int i232 = aVar.topMargin + aVar.bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i232;
                int combineMeasuredStates2 = View.combineMeasuredStates(i21, view.getMeasuredState());
                if (z3) {
                    int i242 = ((((aVar.h >= 0 ? this.e : aVar.h) & 112) >> 4) & (-2)) >> 1;
                    iArr2[i242] = Math.max(iArr2[i242], baseline2);
                    iArr[i242] = Math.max(iArr[i242], measuredHeight - baseline2);
                }
                int max42 = Math.max(i18, measuredHeight);
                if (!z9) {
                }
                if (aVar.g <= 0.0f) {
                }
                int i262 = i13;
                i18 = max42;
                i21 = combineMeasuredStates2;
                z9 = z11;
                i16 = a(view, i262) + i262;
                f2 = f3;
                i16++;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i15 = 1073741824;
            }
            z2 = z6;
            z3 = z5;
            i16++;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i15 = 1073741824;
        }
        boolean z12 = z6;
        boolean z13 = z5;
        int i29 = i18;
        int i30 = i19;
        int i31 = i20;
        int i32 = i21;
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            i3 = i32;
        } else {
            i3 = i32;
            i29 = Math.max(i29, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z12 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            int i33 = 0;
            while (i33 < virtualChildCount) {
                View b2 = b(i33);
                if (b2 == null) {
                    this.f += d(i33);
                } else if (b2.getVisibility() == 8) {
                    i33 += a(b2, i33);
                } else {
                    a aVar2 = (a) b2.getLayoutParams();
                    if (z7) {
                        this.f += aVar2.leftMargin + i17 + aVar2.rightMargin + b(b2);
                    } else {
                        int i34 = this.f;
                        i11 = i29;
                        this.f = Math.max(i34, i34 + i17 + aVar2.leftMargin + aVar2.rightMargin + b(b2));
                        i33++;
                        i29 = i11;
                    }
                }
                i11 = i29;
                i33++;
                i29 = i11;
            }
        }
        int i35 = i29;
        this.f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        int i36 = (16777215 & resolveSizeAndState) - this.f;
        if (z8 || (i36 != 0 && f2 > 0.0f)) {
            float f4 = this.g;
            if (f4 > 0.0f) {
                f2 = f4;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f = 0;
            int i37 = i30;
            int i38 = i3;
            int i39 = -1;
            float f5 = f2;
            int i40 = 0;
            while (i40 < virtualChildCount) {
                View b3 = b(i40);
                if (b3 == null || b3.getVisibility() == 8) {
                    i7 = i36;
                    i8 = virtualChildCount;
                } else {
                    a aVar3 = (a) b3.getLayoutParams();
                    float f6 = aVar3.g;
                    if (f6 > 0.0f) {
                        int i41 = (int) ((i36 * f6) / f5);
                        float f7 = f5 - f6;
                        int i42 = i36 - i41;
                        i8 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin, aVar3.height);
                        if (aVar3.width == 0) {
                            i10 = 1073741824;
                            if (mode == 1073741824) {
                            }
                        } else {
                            i10 = 1073741824;
                        }
                        i41 = b3.getMeasuredWidth() + i41;
                    } else {
                        i7 = i36;
                        i8 = virtualChildCount;
                    }
                    if (z7) {
                        this.f += b3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin + b(b3);
                        f = f5;
                    } else {
                        int i43 = this.f;
                        f = f5;
                        this.f = Math.max(i43, b3.getMeasuredWidth() + i43 + aVar3.leftMargin + aVar3.rightMargin + b(b3));
                    }
                    boolean z14 = mode2 != 1073741824 && aVar3.height == -1;
                    int i44 = aVar3.topMargin + aVar3.bottomMargin;
                    int measuredHeight2 = b3.getMeasuredHeight() + i44;
                    i39 = Math.max(i39, measuredHeight2);
                    if (!z14) {
                        i44 = measuredHeight2;
                    }
                    int max5 = Math.max(i37, i44);
                    if (z9) {
                        i9 = -1;
                        if (aVar3.height == -1) {
                            z = true;
                            if (!z13 && (baseline = b3.getBaseline()) != i9) {
                                int i45 = ((((aVar3.h < 0 ? this.e : aVar3.h) & 112) >> 4) & (-2)) >> 1;
                                iArr2[i45] = Math.max(iArr2[i45], baseline);
                                iArr[i45] = Math.max(iArr[i45], measuredHeight2 - baseline);
                            }
                            i37 = max5;
                            z9 = z;
                            f5 = f;
                        }
                    } else {
                        i9 = -1;
                    }
                    z = false;
                    if (!z13) {
                    }
                    i37 = max5;
                    z9 = z;
                    f5 = f;
                }
                i40++;
                i36 = i7;
                virtualChildCount = i8;
            }
            i4 = virtualChildCount;
            i5 = i2;
            this.f += getPaddingLeft() + getPaddingRight();
            max = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i39 : Math.max(i39, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i3 = i38;
            i6 = i37;
        } else {
            i6 = Math.max(i30, i31);
            if (z12 && mode != 1073741824) {
                for (int i46 = 0; i46 < virtualChildCount; i46++) {
                    View b4 = b(i46);
                    if (b4 != null && b4.getVisibility() != 8 && ((a) b4.getLayoutParams()).g > 0.0f) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = virtualChildCount;
            max = i35;
            i5 = i2;
        }
        if (z9 || mode2 == 1073741824) {
            i6 = max;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & (-16777216)), View.resolveSizeAndState(Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i3 << 16));
        if (z10) {
            d(i4, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean a2 = ap.a(this);
        int paddingTop = getPaddingTop();
        int i15 = i4 - i2;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.e;
        int i17 = i16 & 112;
        boolean z = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        int a3 = androidx.core.g.c.a(8388615 & i16, androidx.core.g.o.b(this));
        int paddingLeft = a3 != 1 ? a3 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.f : getPaddingLeft() + (((i3 - i) - this.f) / 2);
        if (a2) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i5 + (i6 * i18);
            View b = b(i19);
            if (b == null) {
                paddingLeft += d(i19);
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                a aVar = (a) b.getLayoutParams();
                if (z) {
                    i7 = i18;
                    i8 = virtualChildCount;
                    if (aVar.height != -1) {
                        i9 = b.getBaseline();
                        i10 = aVar.h;
                        if (i10 < 0) {
                            i10 = i17;
                        }
                        i11 = i10 & 112;
                        i12 = i17;
                        if (i11 != 16) {
                            i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                        } else if (i11 == 48) {
                            int i20 = aVar.topMargin + paddingTop;
                            if (i9 != -1) {
                                i20 += iArr[1] - i9;
                            }
                            i13 = i20;
                        } else if (i11 != 80) {
                            i13 = paddingTop;
                        } else {
                            int i21 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                            if (i9 != -1) {
                                i21 -= iArr2[2] - (b.getMeasuredHeight() - i9);
                            }
                            i13 = i21;
                        }
                        if (c(i19)) {
                            paddingLeft += this.l;
                        }
                        int i22 = aVar.leftMargin + paddingLeft;
                        i14 = paddingTop;
                        a(b, i22 + a(b), i13, measuredWidth, measuredHeight);
                        i18 = i7 + a(b, i19);
                        paddingLeft = i22 + measuredWidth + aVar.rightMargin + b(b);
                        i18++;
                        virtualChildCount = i8;
                        i17 = i12;
                        paddingTop = i14;
                    }
                } else {
                    i7 = i18;
                    i8 = virtualChildCount;
                }
                i9 = -1;
                i10 = aVar.h;
                if (i10 < 0) {
                }
                i11 = i10 & 112;
                i12 = i17;
                if (i11 != 16) {
                }
                if (c(i19)) {
                }
                int i222 = aVar.leftMargin + paddingLeft;
                i14 = paddingTop;
                a(b, i222 + a(b), i13, measuredWidth, measuredHeight);
                i18 = i7 + a(b, i19);
                paddingLeft = i222 + measuredWidth + aVar.rightMargin + b(b);
                i18++;
                virtualChildCount = i8;
                i17 = i12;
                paddingTop = i14;
            }
            i14 = paddingTop;
            i8 = virtualChildCount;
            i12 = i17;
            i18++;
            virtualChildCount = i8;
            i17 = i12;
            paddingTop = i14;
        }
    }

    void b(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = ap.a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View b = b(i2);
            if (b != null && b.getVisibility() != 8 && c(i2)) {
                a aVar = (a) b.getLayoutParams();
                b(canvas, a2 ? b.getRight() + aVar.rightMargin : (b.getLeft() - aVar.leftMargin) - this.l);
            }
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                a aVar2 = (a) b2.getLayoutParams();
                if (a2) {
                    left = b2.getLeft();
                    i = aVar2.leftMargin;
                    right = (left - i) - this.l;
                } else {
                    right = b2.getRight() + aVar2.rightMargin;
                }
            } else if (a2) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                i = getPaddingRight();
                right = (left - i) - this.l;
            }
            b(canvas, right);
        }
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.n & 4) != 0;
        } else if ((this.n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    int d(int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: g */
    public a generateDefaultLayoutParams() {
        int i = this.d;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i != 1) {
            return null;
        }
        return new a(-1, -2);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.b;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i3 = this.c;
        if (this.d == 1 && (i = this.e & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
            }
        }
        return i3 + ((a) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(w.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(w.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        boolean z = false;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.e;
        if ((8388615 & i3) != i2) {
            this.e = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.e;
        if ((i3 & 112) != i2) {
            this.e = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
