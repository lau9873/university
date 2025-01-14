package a.b.g.i;

import a.b.g.j.i;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class b implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    public final Spannable f1017a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1018b;

    /* renamed from: c  reason: collision with root package name */
    public final PrecomputedText f1019c;

    public a a() {
        return this.f1018b;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f1017a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f1017a.charAt(i2);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1017a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1017a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1017a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.f1019c.getSpans(i2, i3, cls);
        }
        return (T[]) this.f1017a.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1017a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f1017a.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1019c.removeSpan(obj);
                return;
            } else {
                this.f1017a.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1019c.setSpan(obj, i2, i3, i4);
                return;
            } else {
                this.f1017a.setSpan(obj, i2, i3, i4);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f1017a.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1017a.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f1020a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f1021b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1022c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1023d;

        /* renamed from: e  reason: collision with root package name */
        public final PrecomputedText.Params f1024e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: a.b.g.i.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0029a {

            /* renamed from: a  reason: collision with root package name */
            public final TextPaint f1025a;

            /* renamed from: b  reason: collision with root package name */
            public TextDirectionHeuristic f1026b;

            /* renamed from: c  reason: collision with root package name */
            public int f1027c;

            /* renamed from: d  reason: collision with root package name */
            public int f1028d;

            public C0029a(TextPaint textPaint) {
                this.f1025a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1027c = 1;
                    this.f1028d = 1;
                } else {
                    this.f1028d = 0;
                    this.f1027c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1026b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1026b = null;
                }
            }

            public C0029a a(int i2) {
                this.f1027c = i2;
                return this;
            }

            public C0029a b(int i2) {
                this.f1028d = i2;
                return this;
            }

            public C0029a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1026b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f1025a, this.f1026b, this.f1027c, this.f1028d);
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f1024e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1024e = null;
            }
            this.f1020a = textPaint;
            this.f1021b = textDirectionHeuristic;
            this.f1022c = i2;
            this.f1023d = i3;
        }

        public int a() {
            return this.f1022c;
        }

        public int b() {
            return this.f1023d;
        }

        public TextDirectionHeuristic c() {
            return this.f1021b;
        }

        public TextPaint d() {
            return this.f1020a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            PrecomputedText.Params params = this.f1024e;
            if (params != null) {
                return params.equals(aVar.f1024e);
            }
            if (Build.VERSION.SDK_INT < 23 || (this.f1022c == aVar.a() && this.f1023d == aVar.b())) {
                if ((Build.VERSION.SDK_INT < 18 || this.f1021b == aVar.c()) && this.f1020a.getTextSize() == aVar.d().getTextSize() && this.f1020a.getTextScaleX() == aVar.d().getTextScaleX() && this.f1020a.getTextSkewX() == aVar.d().getTextSkewX()) {
                    if ((Build.VERSION.SDK_INT < 21 || (this.f1020a.getLetterSpacing() == aVar.d().getLetterSpacing() && TextUtils.equals(this.f1020a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) && this.f1020a.getFlags() == aVar.d().getFlags()) {
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 24) {
                            if (!this.f1020a.getTextLocales().equals(aVar.d().getTextLocales())) {
                                return false;
                            }
                        } else if (i2 >= 17 && !this.f1020a.getTextLocale().equals(aVar.d().getTextLocale())) {
                            return false;
                        }
                        if (this.f1020a.getTypeface() == null) {
                            if (aVar.d().getTypeface() != null) {
                                return false;
                            }
                        } else if (!this.f1020a.getTypeface().equals(aVar.d().getTypeface())) {
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
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return i.a(Float.valueOf(this.f1020a.getTextSize()), Float.valueOf(this.f1020a.getTextScaleX()), Float.valueOf(this.f1020a.getTextSkewX()), Float.valueOf(this.f1020a.getLetterSpacing()), Integer.valueOf(this.f1020a.getFlags()), this.f1020a.getTextLocales(), this.f1020a.getTypeface(), Boolean.valueOf(this.f1020a.isElegantTextHeight()), this.f1021b, Integer.valueOf(this.f1022c), Integer.valueOf(this.f1023d));
            }
            if (i2 >= 21) {
                return i.a(Float.valueOf(this.f1020a.getTextSize()), Float.valueOf(this.f1020a.getTextScaleX()), Float.valueOf(this.f1020a.getTextSkewX()), Float.valueOf(this.f1020a.getLetterSpacing()), Integer.valueOf(this.f1020a.getFlags()), this.f1020a.getTextLocale(), this.f1020a.getTypeface(), Boolean.valueOf(this.f1020a.isElegantTextHeight()), this.f1021b, Integer.valueOf(this.f1022c), Integer.valueOf(this.f1023d));
            }
            if (i2 >= 18) {
                return i.a(Float.valueOf(this.f1020a.getTextSize()), Float.valueOf(this.f1020a.getTextScaleX()), Float.valueOf(this.f1020a.getTextSkewX()), Integer.valueOf(this.f1020a.getFlags()), this.f1020a.getTextLocale(), this.f1020a.getTypeface(), this.f1021b, Integer.valueOf(this.f1022c), Integer.valueOf(this.f1023d));
            }
            if (i2 >= 17) {
                return i.a(Float.valueOf(this.f1020a.getTextSize()), Float.valueOf(this.f1020a.getTextScaleX()), Float.valueOf(this.f1020a.getTextSkewX()), Integer.valueOf(this.f1020a.getFlags()), this.f1020a.getTextLocale(), this.f1020a.getTypeface(), this.f1021b, Integer.valueOf(this.f1022c), Integer.valueOf(this.f1023d));
            }
            return i.a(Float.valueOf(this.f1020a.getTextSize()), Float.valueOf(this.f1020a.getTextScaleX()), Float.valueOf(this.f1020a.getTextSkewX()), Integer.valueOf(this.f1020a.getFlags()), this.f1020a.getTypeface(), this.f1021b, Integer.valueOf(this.f1022c), Integer.valueOf(this.f1023d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1020a.getTextSize());
            sb.append(", textScaleX=" + this.f1020a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1020a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1020a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1020a.isElegantTextHeight());
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f1020a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.f1020a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1020a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1020a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1021b);
            sb.append(", breakStrategy=" + this.f1022c);
            sb.append(", hyphenationFrequency=" + this.f1023d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f1020a = params.getTextPaint();
            this.f1021b = params.getTextDirection();
            this.f1022c = params.getBreakStrategy();
            this.f1023d = params.getHyphenationFrequency();
            this.f1024e = params;
        }
    }
}
