package androidx.core.e;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.f.c;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a implements Spannable {
    private static final Object a = new Object();
    private static Executor b = null;
    private final Spannable c;
    private final C0023a d;
    private final PrecomputedText e;

    /* renamed from: androidx.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0023a {
        final PrecomputedText.Params a;
        private final TextPaint b;
        private final TextDirectionHeuristic c;
        private final int d;
        private final int e;

        /* renamed from: androidx.core.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0024a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            public C0024a(TextPaint textPaint) {
                this.a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                this.b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public C0024a a(int i) {
                this.c = i;
                return this;
            }

            public C0024a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }

            public C0023a a() {
                return new C0023a(this.a, this.b, this.c, this.d);
            }

            public C0024a b(int i) {
                this.d = i;
                return this;
            }
        }

        public C0023a(PrecomputedText.Params params) {
            this.b = params.getTextPaint();
            this.c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.a = params;
        }

        C0023a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.a = Build.VERSION.SDK_INT >= 28 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build() : null;
            this.b = textPaint;
            this.c = textDirectionHeuristic;
            this.d = i;
            this.e = i2;
        }

        public TextPaint a() {
            return this.b;
        }

        public TextDirectionHeuristic b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof C0023a)) {
                return false;
            }
            C0023a c0023a = (C0023a) obj;
            PrecomputedText.Params params = this.a;
            if (params != null) {
                return params.equals(c0023a.a);
            }
            if (Build.VERSION.SDK_INT >= 23 && (this.d != c0023a.c() || this.e != c0023a.d())) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 18 && this.c != c0023a.b()) || this.b.getTextSize() != c0023a.a().getTextSize() || this.b.getTextScaleX() != c0023a.a().getTextScaleX() || this.b.getTextSkewX() != c0023a.a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.b.getLetterSpacing() != c0023a.a().getLetterSpacing() || !TextUtils.equals(this.b.getFontFeatureSettings(), c0023a.a().getFontFeatureSettings()))) || this.b.getFlags() != c0023a.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.b.getTextLocales().equals(c0023a.a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(c0023a.a().getTextLocale())) {
                return false;
            }
            if (this.b.getTypeface() == null) {
                if (c0023a.a().getTypeface() != null) {
                    return false;
                }
            } else if (!this.b.getTypeface().equals(c0023a.a().getTypeface())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return c.a(Build.VERSION.SDK_INT >= 24 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocales(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : Build.VERSION.SDK_INT >= 21 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : Build.VERSION.SDK_INT >= 18 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : Build.VERSION.SDK_INT >= 17 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)});
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00e7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb;
            Object textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.b.getTextSize());
            sb2.append(", textScaleX=" + this.b.getTextScaleX());
            sb2.append(", textSkewX=" + this.b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb2.append(", letterSpacing=" + this.b.getLetterSpacing());
                sb2.append(", elegantTextHeight=" + this.b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT < 24) {
                if (Build.VERSION.SDK_INT >= 17) {
                    sb = new StringBuilder();
                    sb.append(", textLocale=");
                    textLocale = this.b.getTextLocale();
                }
                sb2.append(", typeface=" + this.b.getTypeface());
                if (Build.VERSION.SDK_INT >= 26) {
                    sb2.append(", variationSettings=" + this.b.getFontVariationSettings());
                }
                sb2.append(", textDir=" + this.c);
                sb2.append(", breakStrategy=" + this.d);
                sb2.append(", hyphenationFrequency=" + this.e);
                sb2.append("}");
                return sb2.toString();
            }
            sb = new StringBuilder();
            sb.append(", textLocale=");
            textLocale = this.b.getTextLocales();
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
            }
            sb2.append(", textDir=" + this.c);
            sb2.append(", breakStrategy=" + this.d);
            sb2.append(", hyphenationFrequency=" + this.e);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public C0023a b() {
        return this.d;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 28 ? (T[]) this.e.getSpans(i, i2, cls) : (T[]) this.c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.removeSpan(obj);
                return;
            } else {
                this.c.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.c.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.c.toString();
    }
}
