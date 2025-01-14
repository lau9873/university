package p000a.p006b.p012d.p026x;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p030g.p038e.C0222a;
import p000a.p006b.p030g.p043i.TextDirectionHeuristicsCompat;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p063k.TintTypedArray;

/* renamed from: a.b.d.x.c */
/* loaded from: classes.dex */
public final class CollapsingTextHelper {

    /* renamed from: T */
    public static final boolean f567T;

    /* renamed from: U */
    public static final Paint f568U;

    /* renamed from: A */
    public Paint f569A;

    /* renamed from: B */
    public float f570B;

    /* renamed from: C */
    public float f571C;

    /* renamed from: D */
    public float f572D;

    /* renamed from: E */
    public float f573E;

    /* renamed from: F */
    public int[] f574F;

    /* renamed from: G */
    public boolean f575G;

    /* renamed from: J */
    public TimeInterpolator f578J;

    /* renamed from: K */
    public TimeInterpolator f579K;

    /* renamed from: L */
    public float f580L;

    /* renamed from: M */
    public float f581M;

    /* renamed from: N */
    public float f582N;

    /* renamed from: O */
    public int f583O;

    /* renamed from: P */
    public float f584P;

    /* renamed from: Q */
    public float f585Q;

    /* renamed from: R */
    public float f586R;

    /* renamed from: S */
    public int f587S;

    /* renamed from: a */
    public final View f588a;

    /* renamed from: b */
    public boolean f589b;

    /* renamed from: c */
    public float f590c;

    /* renamed from: k */
    public ColorStateList f598k;

    /* renamed from: l */
    public ColorStateList f599l;

    /* renamed from: m */
    public float f600m;

    /* renamed from: n */
    public float f601n;

    /* renamed from: o */
    public float f602o;

    /* renamed from: p */
    public float f603p;

    /* renamed from: q */
    public float f604q;

    /* renamed from: r */
    public float f605r;

    /* renamed from: s */
    public Typeface f606s;

    /* renamed from: t */
    public Typeface f607t;

    /* renamed from: u */
    public Typeface f608u;

    /* renamed from: v */
    public CharSequence f609v;

    /* renamed from: w */
    public CharSequence f610w;

    /* renamed from: x */
    public boolean f611x;

    /* renamed from: y */
    public boolean f612y;

    /* renamed from: z */
    public Bitmap f613z;

    /* renamed from: g */
    public int f594g = 16;

    /* renamed from: h */
    public int f595h = 16;

    /* renamed from: i */
    public float f596i = 15.0f;

    /* renamed from: j */
    public float f597j = 15.0f;

    /* renamed from: H */
    public final TextPaint f576H = new TextPaint(129);

    /* renamed from: I */
    public final TextPaint f577I = new TextPaint(this.f576H);

    /* renamed from: e */
    public final Rect f592e = new Rect();

    /* renamed from: d */
    public final Rect f591d = new Rect();

    /* renamed from: f */
    public final RectF f593f = new RectF();

    static {
        f567T = Build.VERSION.SDK_INT < 18;
        f568U = null;
        Paint paint = f568U;
        if (paint != null) {
            paint.setAntiAlias(true);
            f568U.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.f588a = view;
    }

    /* renamed from: a */
    public void m10839a(TimeInterpolator timeInterpolator) {
        this.f578J = timeInterpolator;
        m10807m();
    }

    /* renamed from: b */
    public void m10826b(TimeInterpolator timeInterpolator) {
        this.f579K = timeInterpolator;
        m10807m();
    }

    /* renamed from: c */
    public void m10821c(int i) {
        if (this.f595h != i) {
            this.f595h = i;
            m10807m();
        }
    }

    /* renamed from: d */
    public void m10819d(float f) {
        if (this.f596i != f) {
            this.f596i = f;
            m10807m();
        }
    }

    /* renamed from: e */
    public void m10816e(float f) {
        float m9831a = C0222a.m9831a(f, 0.0f, 1.0f);
        if (m9831a != this.f590c) {
            this.f590c = m9831a;
            m10823c();
        }
    }

    /* renamed from: f */
    public final void m10814f(float f) {
        m10829b(f);
        this.f612y = f567T && this.f572D != 1.0f;
        if (this.f612y) {
            m10817e();
        }
        ViewCompat.m9464A(this.f588a);
    }

    /* renamed from: g */
    public float m10813g() {
        m10833a(this.f577I);
        return -this.f577I.ascent();
    }

    /* renamed from: h */
    public int m10812h() {
        int[] iArr = this.f574F;
        if (iArr != null) {
            return this.f599l.getColorForState(iArr, 0);
        }
        return this.f599l.getDefaultColor();
    }

    /* renamed from: i */
    public final int m10811i() {
        int[] iArr = this.f574F;
        if (iArr != null) {
            return this.f598k.getColorForState(iArr, 0);
        }
        return this.f598k.getDefaultColor();
    }

    /* renamed from: j */
    public float m10810j() {
        return this.f590c;
    }

    /* renamed from: k */
    public final boolean m10809k() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f599l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f598k) != null && colorStateList.isStateful());
    }

    /* renamed from: l */
    public void m10808l() {
        this.f589b = this.f592e.width() > 0 && this.f592e.height() > 0 && this.f591d.width() > 0 && this.f591d.height() > 0;
    }

    /* renamed from: m */
    public void m10807m() {
        if (this.f588a.getHeight() <= 0 || this.f588a.getWidth() <= 0) {
            return;
        }
        m10846a();
        m10823c();
    }

    /* renamed from: a */
    public void m10838a(ColorStateList colorStateList) {
        if (this.f599l != colorStateList) {
            this.f599l = colorStateList;
            m10807m();
        }
    }

    /* renamed from: b */
    public void m10825b(ColorStateList colorStateList) {
        if (this.f598k != colorStateList) {
            this.f598k = colorStateList;
            m10807m();
        }
    }

    /* renamed from: c */
    public final void m10823c() {
        m10845a(this.f590c);
    }

    /* renamed from: d */
    public void m10818d(int i) {
        if (this.f594g != i) {
            this.f594g = i;
            m10807m();
        }
    }

    /* renamed from: c */
    public final void m10822c(float f) {
        this.f593f.left = m10843a(this.f591d.left, this.f592e.left, f, this.f578J);
        this.f593f.top = m10843a(this.f600m, this.f601n, f, this.f578J);
        this.f593f.right = m10843a(this.f591d.right, this.f592e.right, f, this.f578J);
        this.f593f.bottom = m10843a(this.f591d.bottom, this.f592e.bottom, f, this.f578J);
    }

    /* renamed from: e */
    public final void m10817e() {
        if (this.f613z != null || this.f591d.isEmpty() || TextUtils.isEmpty(this.f610w)) {
            return;
        }
        m10845a(0.0f);
        this.f570B = this.f576H.ascent();
        this.f571C = this.f576H.descent();
        TextPaint textPaint = this.f576H;
        CharSequence charSequence = this.f610w;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.f571C - this.f570B);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.f613z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f613z);
        CharSequence charSequence2 = this.f610w;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.f576H.descent(), this.f576H);
        if (this.f569A == null) {
            this.f569A = new Paint(3);
        }
    }

    /* renamed from: a */
    public void m10840a(int i, int i2, int i3, int i4) {
        if (m10836a(this.f592e, i, i2, i3, i4)) {
            return;
        }
        this.f592e.set(i, i2, i3, i4);
        this.f575G = true;
        m10808l();
    }

    /* renamed from: b */
    public void m10827b(int i, int i2, int i3, int i4) {
        if (m10836a(this.f591d, i, i2, i3, i4)) {
            return;
        }
        this.f591d.set(i, i2, i3, i4);
        this.f575G = true;
        m10808l();
    }

    /* renamed from: f */
    public ColorStateList m10815f() {
        return this.f599l;
    }

    /* renamed from: d */
    public final void m10820d() {
        Bitmap bitmap = this.f613z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f613z = null;
        }
    }

    /* renamed from: a */
    public void m10835a(RectF rectF) {
        boolean m10832a = m10832a(this.f609v);
        Rect rect = this.f592e;
        rectF.left = !m10832a ? rect.left : rect.right - m10830b();
        Rect rect2 = this.f592e;
        rectF.top = rect2.top;
        rectF.right = !m10832a ? rectF.left + m10830b() : rect2.right;
        rectF.bottom = this.f592e.top + m10813g();
    }

    /* renamed from: b */
    public float m10830b() {
        if (this.f609v == null) {
            return 0.0f;
        }
        m10833a(this.f577I);
        TextPaint textPaint = this.f577I;
        CharSequence charSequence = this.f609v;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    /* renamed from: b */
    public void m10828b(int i) {
        TintTypedArray m8259a = TintTypedArray.m8259a(this.f588a.getContext(), i, C0363j.TextAppearance);
        if (m8259a.m8245g(C0363j.TextAppearance_android_textColor)) {
            this.f599l = m8259a.m8264a(C0363j.TextAppearance_android_textColor);
        }
        if (m8259a.m8245g(C0363j.TextAppearance_android_textSize)) {
            this.f597j = m8259a.m8252c(C0363j.TextAppearance_android_textSize, (int) this.f597j);
        }
        this.f583O = m8259a.m8250d(C0363j.TextAppearance_android_shadowColor, 0);
        this.f581M = m8259a.m8255b(C0363j.TextAppearance_android_shadowDx, 0.0f);
        this.f582N = m8259a.m8255b(C0363j.TextAppearance_android_shadowDy, 0.0f);
        this.f580L = m8259a.m8255b(C0363j.TextAppearance_android_shadowRadius, 0.0f);
        m8259a.m8265a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f606s = m10842a(i);
        }
        m10807m();
    }

    /* renamed from: a */
    public final void m10833a(TextPaint textPaint) {
        textPaint.setTextSize(this.f597j);
        textPaint.setTypeface(this.f606s);
    }

    /* renamed from: a */
    public final Typeface m10842a(int i) {
        TypedArray obtainStyledAttributes = this.f588a.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public void m10834a(Typeface typeface) {
        this.f607t = typeface;
        this.f606s = typeface;
        m10807m();
    }

    /* renamed from: a */
    public final boolean m10831a(int[] iArr) {
        this.f574F = iArr;
        if (m10809k()) {
            m10807m();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void m10845a(float f) {
        m10822c(f);
        this.f604q = m10843a(this.f602o, this.f603p, f, this.f578J);
        this.f605r = m10843a(this.f600m, this.f601n, f, this.f578J);
        m10814f(m10843a(this.f596i, this.f597j, f, this.f579K));
        if (this.f599l != this.f598k) {
            this.f576H.setColor(m10841a(m10811i(), m10812h(), f));
        } else {
            this.f576H.setColor(m10812h());
        }
        this.f576H.setShadowLayer(m10843a(this.f584P, this.f580L, f, (TimeInterpolator) null), m10843a(this.f585Q, this.f581M, f, (TimeInterpolator) null), m10843a(this.f586R, this.f582N, f, (TimeInterpolator) null), m10841a(this.f587S, this.f583O, f));
        ViewCompat.m9464A(this.f588a);
    }

    /* renamed from: b */
    public final void m10829b(float f) {
        float f2;
        boolean z;
        boolean z2;
        if (this.f609v == null) {
            return;
        }
        float width = this.f592e.width();
        float width2 = this.f591d.width();
        if (m10844a(f, this.f597j)) {
            float f3 = this.f597j;
            this.f572D = 1.0f;
            Typeface typeface = this.f608u;
            Typeface typeface2 = this.f606s;
            if (typeface != typeface2) {
                this.f608u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
            f2 = f3;
            z = z2;
        } else {
            f2 = this.f596i;
            Typeface typeface3 = this.f608u;
            Typeface typeface4 = this.f607t;
            if (typeface3 != typeface4) {
                this.f608u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (m10844a(f, this.f596i)) {
                this.f572D = 1.0f;
            } else {
                this.f572D = f / this.f596i;
            }
            float f4 = this.f597j / this.f596i;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
        }
        if (width > 0.0f) {
            z = this.f573E != f2 || this.f575G || z;
            this.f573E = f2;
            this.f575G = false;
        }
        if (this.f610w == null || z) {
            this.f576H.setTextSize(this.f573E);
            this.f576H.setTypeface(this.f608u);
            this.f576H.setLinearText(this.f572D != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.f609v, this.f576H, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.f610w)) {
                return;
            }
            this.f610w = ellipsize;
            this.f611x = m10832a(this.f610w);
        }
    }

    /* renamed from: a */
    public final void m10846a() {
        float f = this.f573E;
        m10829b(this.f597j);
        CharSequence charSequence = this.f610w;
        float measureText = charSequence != null ? this.f576H.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int m9579a = GravityCompat.m9579a(this.f595h, this.f611x ? 1 : 0);
        int i = m9579a & 112;
        if (i == 48) {
            this.f601n = this.f592e.top - this.f576H.ascent();
        } else if (i != 80) {
            this.f601n = this.f592e.centerY() + (((this.f576H.descent() - this.f576H.ascent()) / 2.0f) - this.f576H.descent());
        } else {
            this.f601n = this.f592e.bottom;
        }
        int i2 = m9579a & 8388615;
        if (i2 == 1) {
            this.f603p = this.f592e.centerX() - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.f603p = this.f592e.left;
        } else {
            this.f603p = this.f592e.right - measureText;
        }
        m10829b(this.f596i);
        CharSequence charSequence2 = this.f610w;
        float measureText2 = charSequence2 != null ? this.f576H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int m9579a2 = GravityCompat.m9579a(this.f594g, this.f611x ? 1 : 0);
        int i3 = m9579a2 & 112;
        if (i3 == 48) {
            this.f600m = this.f591d.top - this.f576H.ascent();
        } else if (i3 != 80) {
            this.f600m = this.f591d.centerY() + (((this.f576H.descent() - this.f576H.ascent()) / 2.0f) - this.f576H.descent());
        } else {
            this.f600m = this.f591d.bottom;
        }
        int i4 = m9579a2 & 8388615;
        if (i4 == 1) {
            this.f602o = this.f591d.centerX() - (measureText2 / 2.0f);
        } else if (i4 != 5) {
            this.f602o = this.f591d.left;
        } else {
            this.f602o = this.f591d.right - measureText2;
        }
        m10820d();
        m10814f(f);
    }

    /* renamed from: b */
    public void m10824b(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f609v)) {
            this.f609v = charSequence;
            this.f610w = null;
            m10820d();
            m10807m();
        }
    }

    /* renamed from: a */
    public void m10837a(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.f610w != null && this.f589b) {
            float f = this.f604q;
            float f2 = this.f605r;
            boolean z = this.f612y && this.f613z != null;
            if (z) {
                ascent = this.f570B * this.f572D;
            } else {
                ascent = this.f576H.ascent() * this.f572D;
                this.f576H.descent();
            }
            if (z) {
                f2 += ascent;
            }
            float f3 = f2;
            float f4 = this.f572D;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f, f3);
            }
            if (z) {
                canvas.drawBitmap(this.f613z, f, f3, this.f569A);
            } else {
                CharSequence charSequence = this.f610w;
                canvas.drawText(charSequence, 0, charSequence.length(), f, f3, this.f576H);
            }
        }
        canvas.restoreToCount(save);
    }

    /* renamed from: a */
    public final boolean m10832a(CharSequence charSequence) {
        return (ViewCompat.m9422k(this.f588a) == 1 ? TextDirectionHeuristicsCompat.f1540b : TextDirectionHeuristicsCompat.f1539a).mo9688a(charSequence, 0, charSequence.length());
    }

    /* renamed from: a */
    public static boolean m10844a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* renamed from: a */
    public static int m10841a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* renamed from: a */
    public static float m10843a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.m10973a(f, f2, f3);
    }

    /* renamed from: a */
    public static boolean m10836a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
