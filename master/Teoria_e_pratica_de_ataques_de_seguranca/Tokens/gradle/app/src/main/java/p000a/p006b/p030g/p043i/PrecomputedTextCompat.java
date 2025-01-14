package p000a.p006b.p030g.p043i;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import p000a.p006b.p030g.p044j.ObjectsCompat;

/* renamed from: a.b.g.i.b */
/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: a */
    public final Spannable f1527a;

    /* renamed from: b */
    public final C0258a f1528b;

    /* renamed from: c */
    public final PrecomputedText f1529c;

    /* renamed from: a */
    public C0258a m9701a() {
        return this.f1528b;
    }

    /* renamed from: b */
    public PrecomputedText m9700b() {
        Spannable spannable = this.f1527a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f1527a.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1527a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1527a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1527a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.f1529c.getSpans(i, i2, cls);
        }
        return (T[]) this.f1527a.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1527a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f1527a.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1529c.removeSpan(obj);
                return;
            } else {
                this.f1527a.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1529c.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.f1527a.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f1527a.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1527a.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: a.b.g.i.b$a */
    /* loaded from: classes.dex */
    public static final class C0258a {

        /* renamed from: a */
        public final TextPaint f1530a;

        /* renamed from: b */
        public final TextDirectionHeuristic f1531b;

        /* renamed from: c */
        public final int f1532c;

        /* renamed from: d */
        public final int f1533d;

        /* renamed from: e */
        public final PrecomputedText.Params f1534e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: a.b.g.i.b$a$a */
        /* loaded from: classes.dex */
        public static class C0259a {

            /* renamed from: a */
            public final TextPaint f1535a;

            /* renamed from: b */
            public TextDirectionHeuristic f1536b;

            /* renamed from: c */
            public int f1537c;

            /* renamed from: d */
            public int f1538d;

            public C0259a(TextPaint textPaint) {
                this.f1535a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1537c = 1;
                    this.f1538d = 1;
                } else {
                    this.f1538d = 0;
                    this.f1537c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1536b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1536b = null;
                }
            }

            /* renamed from: a */
            public C0259a m9694a(int i) {
                this.f1537c = i;
                return this;
            }

            /* renamed from: b */
            public C0259a m9692b(int i) {
                this.f1538d = i;
                return this;
            }

            /* renamed from: a */
            public C0259a m9693a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1536b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: a */
            public C0258a m9695a() {
                return new C0258a(this.f1535a, this.f1536b, this.f1537c, this.f1538d);
            }
        }

        public C0258a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1534e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1534e = null;
            }
            this.f1530a = textPaint;
            this.f1531b = textDirectionHeuristic;
            this.f1532c = i;
            this.f1533d = i2;
        }

        /* renamed from: a */
        public int m9699a() {
            return this.f1532c;
        }

        /* renamed from: b */
        public int m9698b() {
            return this.f1533d;
        }

        /* renamed from: c */
        public TextDirectionHeuristic m9697c() {
            return this.f1531b;
        }

        /* renamed from: d */
        public TextPaint m9696d() {
            return this.f1530a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof C0258a)) {
                return false;
            }
            C0258a c0258a = (C0258a) obj;
            PrecomputedText.Params params = this.f1534e;
            if (params != null) {
                return params.equals(c0258a.f1534e);
            }
            if (Build.VERSION.SDK_INT < 23 || (this.f1532c == c0258a.m9699a() && this.f1533d == c0258a.m9698b())) {
                if ((Build.VERSION.SDK_INT < 18 || this.f1531b == c0258a.m9697c()) && this.f1530a.getTextSize() == c0258a.m9696d().getTextSize() && this.f1530a.getTextScaleX() == c0258a.m9696d().getTextScaleX() && this.f1530a.getTextSkewX() == c0258a.m9696d().getTextSkewX()) {
                    if ((Build.VERSION.SDK_INT < 21 || (this.f1530a.getLetterSpacing() == c0258a.m9696d().getLetterSpacing() && TextUtils.equals(this.f1530a.getFontFeatureSettings(), c0258a.m9696d().getFontFeatureSettings()))) && this.f1530a.getFlags() == c0258a.m9696d().getFlags()) {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 24) {
                            if (!this.f1530a.getTextLocales().equals(c0258a.m9696d().getTextLocales())) {
                                return false;
                            }
                        } else if (i >= 17 && !this.f1530a.getTextLocale().equals(c0258a.m9696d().getTextLocale())) {
                            return false;
                        }
                        if (this.f1530a.getTypeface() == null) {
                            if (c0258a.m9696d().getTypeface() != null) {
                                return false;
                            }
                        } else if (!this.f1530a.getTypeface().equals(c0258a.m9696d().getTypeface())) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return ObjectsCompat.m9626a(Float.valueOf(this.f1530a.getTextSize()), Float.valueOf(this.f1530a.getTextScaleX()), Float.valueOf(this.f1530a.getTextSkewX()), Float.valueOf(this.f1530a.getLetterSpacing()), Integer.valueOf(this.f1530a.getFlags()), this.f1530a.getTextLocales(), this.f1530a.getTypeface(), Boolean.valueOf(this.f1530a.isElegantTextHeight()), this.f1531b, Integer.valueOf(this.f1532c), Integer.valueOf(this.f1533d));
            }
            if (i >= 21) {
                return ObjectsCompat.m9626a(Float.valueOf(this.f1530a.getTextSize()), Float.valueOf(this.f1530a.getTextScaleX()), Float.valueOf(this.f1530a.getTextSkewX()), Float.valueOf(this.f1530a.getLetterSpacing()), Integer.valueOf(this.f1530a.getFlags()), this.f1530a.getTextLocale(), this.f1530a.getTypeface(), Boolean.valueOf(this.f1530a.isElegantTextHeight()), this.f1531b, Integer.valueOf(this.f1532c), Integer.valueOf(this.f1533d));
            }
            if (i >= 18) {
                return ObjectsCompat.m9626a(Float.valueOf(this.f1530a.getTextSize()), Float.valueOf(this.f1530a.getTextScaleX()), Float.valueOf(this.f1530a.getTextSkewX()), Integer.valueOf(this.f1530a.getFlags()), this.f1530a.getTextLocale(), this.f1530a.getTypeface(), this.f1531b, Integer.valueOf(this.f1532c), Integer.valueOf(this.f1533d));
            }
            if (i >= 17) {
                return ObjectsCompat.m9626a(Float.valueOf(this.f1530a.getTextSize()), Float.valueOf(this.f1530a.getTextScaleX()), Float.valueOf(this.f1530a.getTextSkewX()), Integer.valueOf(this.f1530a.getFlags()), this.f1530a.getTextLocale(), this.f1530a.getTypeface(), this.f1531b, Integer.valueOf(this.f1532c), Integer.valueOf(this.f1533d));
            }
            return ObjectsCompat.m9626a(Float.valueOf(this.f1530a.getTextSize()), Float.valueOf(this.f1530a.getTextScaleX()), Float.valueOf(this.f1530a.getTextSkewX()), Integer.valueOf(this.f1530a.getFlags()), this.f1530a.getTypeface(), this.f1531b, Integer.valueOf(this.f1532c), Integer.valueOf(this.f1533d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1530a.getTextSize());
            sb.append(", textScaleX=" + this.f1530a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1530a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1530a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1530a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f1530a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f1530a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1530a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1530a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1531b);
            sb.append(", breakStrategy=" + this.f1532c);
            sb.append(", hyphenationFrequency=" + this.f1533d);
            sb.append("}");
            return sb.toString();
        }

        public C0258a(PrecomputedText.Params params) {
            this.f1530a = params.getTextPaint();
            this.f1531b = params.getTextDirection();
            this.f1532c = params.getBreakStrategy();
            this.f1533d = params.getHyphenationFrequency();
            this.f1534e = params;
        }
    }
}
