package a.b.d.x;

import a.b.g.k.u;
import a.b.h.k.l1;
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
/* compiled from: CollapsingTextHelper.java */
/* loaded from: classes.dex */
public final class c {
    public static final boolean T;
    public static final Paint U;
    public Paint A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int[] F;
    public boolean G;
    public TimeInterpolator J;
    public TimeInterpolator K;
    public float L;
    public float M;
    public float N;
    public int O;
    public float P;
    public float Q;
    public float R;
    public int S;

    /* renamed from: a  reason: collision with root package name */
    public final View f308a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f309b;

    /* renamed from: c  reason: collision with root package name */
    public float f310c;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public CharSequence v;
    public CharSequence w;
    public boolean x;
    public boolean y;
    public Bitmap z;

    /* renamed from: g  reason: collision with root package name */
    public int f314g = 16;

    /* renamed from: h  reason: collision with root package name */
    public int f315h = 16;

    /* renamed from: i  reason: collision with root package name */
    public float f316i = 15.0f;
    public float j = 15.0f;
    public final TextPaint H = new TextPaint(129);
    public final TextPaint I = new TextPaint(this.H);

    /* renamed from: e  reason: collision with root package name */
    public final Rect f312e = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f311d = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final RectF f313f = new RectF();

    static {
        T = Build.VERSION.SDK_INT < 18;
        U = null;
        Paint paint = U;
        if (paint != null) {
            paint.setAntiAlias(true);
            U.setColor(-65281);
        }
    }

    public c(View view) {
        this.f308a = view;
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        m();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        m();
    }

    public void c(int i2) {
        if (this.f315h != i2) {
            this.f315h = i2;
            m();
        }
    }

    public void d(float f2) {
        if (this.f316i != f2) {
            this.f316i = f2;
            m();
        }
    }

    public void e(float f2) {
        float a2 = a.b.g.e.a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f310c) {
            this.f310c = a2;
            c();
        }
    }

    public final void f(float f2) {
        b(f2);
        this.y = T && this.D != 1.0f;
        if (this.y) {
            e();
        }
        u.A(this.f308a);
    }

    public float g() {
        a(this.I);
        return -this.I.ascent();
    }

    public int h() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.l.getColorForState(iArr, 0);
        }
        return this.l.getDefaultColor();
    }

    public final int i() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.k.getColorForState(iArr, 0);
        }
        return this.k.getDefaultColor();
    }

    public float j() {
        return this.f310c;
    }

    public final boolean k() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    public void l() {
        this.f309b = this.f312e.width() > 0 && this.f312e.height() > 0 && this.f311d.width() > 0 && this.f311d.height() > 0;
    }

    public void m() {
        if (this.f308a.getHeight() <= 0 || this.f308a.getWidth() <= 0) {
            return;
        }
        a();
        c();
    }

    public void a(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            m();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            m();
        }
    }

    public final void c() {
        a(this.f310c);
    }

    public void d(int i2) {
        if (this.f314g != i2) {
            this.f314g = i2;
            m();
        }
    }

    public final void c(float f2) {
        this.f313f.left = a(this.f311d.left, this.f312e.left, f2, this.J);
        this.f313f.top = a(this.m, this.n, f2, this.J);
        this.f313f.right = a(this.f311d.right, this.f312e.right, f2, this.J);
        this.f313f.bottom = a(this.f311d.bottom, this.f312e.bottom, f2, this.J);
    }

    public final void e() {
        if (this.z != null || this.f311d.isEmpty() || TextUtils.isEmpty(this.w)) {
            return;
        }
        a(0.0f);
        this.B = this.H.ascent();
        this.C = this.H.descent();
        TextPaint textPaint = this.H;
        CharSequence charSequence = this.w;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.C - this.B);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.z);
        CharSequence charSequence2 = this.w;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.H.descent(), this.H);
        if (this.A == null) {
            this.A = new Paint(3);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (a(this.f312e, i2, i3, i4, i5)) {
            return;
        }
        this.f312e.set(i2, i3, i4, i5);
        this.G = true;
        l();
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (a(this.f311d, i2, i3, i4, i5)) {
            return;
        }
        this.f311d.set(i2, i3, i4, i5);
        this.G = true;
        l();
    }

    public ColorStateList f() {
        return this.l;
    }

    public final void d() {
        Bitmap bitmap = this.z;
        if (bitmap != null) {
            bitmap.recycle();
            this.z = null;
        }
    }

    public void a(RectF rectF) {
        boolean a2 = a(this.v);
        Rect rect = this.f312e;
        rectF.left = !a2 ? rect.left : rect.right - b();
        Rect rect2 = this.f312e;
        rectF.top = rect2.top;
        rectF.right = !a2 ? rectF.left + b() : rect2.right;
        rectF.bottom = this.f312e.top + g();
    }

    public float b() {
        if (this.v == null) {
            return 0.0f;
        }
        a(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.v;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void b(int i2) {
        l1 a2 = l1.a(this.f308a.getContext(), i2, a.b.h.b.j.TextAppearance);
        if (a2.g(a.b.h.b.j.TextAppearance_android_textColor)) {
            this.l = a2.a(a.b.h.b.j.TextAppearance_android_textColor);
        }
        if (a2.g(a.b.h.b.j.TextAppearance_android_textSize)) {
            this.j = a2.c(a.b.h.b.j.TextAppearance_android_textSize, (int) this.j);
        }
        this.O = a2.d(a.b.h.b.j.TextAppearance_android_shadowColor, 0);
        this.M = a2.b(a.b.h.b.j.TextAppearance_android_shadowDx, 0.0f);
        this.N = a2.b(a.b.h.b.j.TextAppearance_android_shadowDy, 0.0f);
        this.L = a2.b(a.b.h.b.j.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.s = a(i2);
        }
        m();
    }

    public final void a(TextPaint textPaint) {
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
    }

    public final Typeface a(int i2) {
        TypedArray obtainStyledAttributes = this.f308a.getContext().obtainStyledAttributes(i2, new int[]{16843692});
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

    public void a(Typeface typeface) {
        this.t = typeface;
        this.s = typeface;
        m();
    }

    public final boolean a(int[] iArr) {
        this.F = iArr;
        if (k()) {
            m();
            return true;
        }
        return false;
    }

    public final void a(float f2) {
        c(f2);
        this.q = a(this.o, this.p, f2, this.J);
        this.r = a(this.m, this.n, f2, this.J);
        f(a(this.f316i, this.j, f2, this.K));
        if (this.l != this.k) {
            this.H.setColor(a(i(), h(), f2));
        } else {
            this.H.setColor(h());
        }
        this.H.setShadowLayer(a(this.P, this.L, f2, (TimeInterpolator) null), a(this.Q, this.M, f2, (TimeInterpolator) null), a(this.R, this.N, f2, (TimeInterpolator) null), a(this.S, this.O, f2));
        u.A(this.f308a);
    }

    public final void b(float f2) {
        float f3;
        boolean z;
        boolean z2;
        if (this.v == null) {
            return;
        }
        float width = this.f312e.width();
        float width2 = this.f311d.width();
        if (a(f2, this.j)) {
            float f4 = this.j;
            this.D = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
            f3 = f4;
            z = z2;
        } else {
            f3 = this.f316i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (a(f2, this.f316i)) {
                this.D = 1.0f;
            } else {
                this.D = f2 / this.f316i;
            }
            float f5 = this.j / this.f316i;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
        }
        if (width > 0.0f) {
            z = this.E != f3 || this.G || z;
            this.E = f3;
            this.G = false;
        }
        if (this.w == null || z) {
            this.H.setTextSize(this.E);
            this.H.setTypeface(this.u);
            this.H.setLinearText(this.D != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.v, this.H, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.w)) {
                return;
            }
            this.w = ellipsize;
            this.x = a(this.w);
        }
    }

    public final void a() {
        float f2 = this.E;
        b(this.j);
        CharSequence charSequence = this.w;
        float measureText = charSequence != null ? this.H.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int a2 = a.b.g.k.d.a(this.f315h, this.x ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.n = this.f312e.top - this.H.ascent();
        } else if (i2 != 80) {
            this.n = this.f312e.centerY() + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
        } else {
            this.n = this.f312e.bottom;
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.p = this.f312e.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.p = this.f312e.left;
        } else {
            this.p = this.f312e.right - measureText;
        }
        b(this.f316i);
        CharSequence charSequence2 = this.w;
        float measureText2 = charSequence2 != null ? this.H.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int a3 = a.b.g.k.d.a(this.f314g, this.x ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.m = this.f311d.top - this.H.ascent();
        } else if (i4 != 80) {
            this.m = this.f311d.centerY() + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
        } else {
            this.m = this.f311d.bottom;
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.o = this.f311d.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.o = this.f311d.left;
        } else {
            this.o = this.f311d.right - measureText2;
        }
        d();
        f(f2);
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.v)) {
            this.v = charSequence;
            this.w = null;
            d();
            m();
        }
    }

    public void a(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.w != null && this.f309b) {
            float f2 = this.q;
            float f3 = this.r;
            boolean z = this.y && this.z != null;
            if (z) {
                ascent = this.B * this.D;
            } else {
                ascent = this.H.ascent() * this.D;
                this.H.descent();
            }
            if (z) {
                f3 += ascent;
            }
            float f4 = f3;
            float f5 = this.D;
            if (f5 != 1.0f) {
                canvas.scale(f5, f5, f2, f4);
            }
            if (z) {
                canvas.drawBitmap(this.z, f2, f4, this.A);
            } else {
                CharSequence charSequence = this.w;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f4, this.H);
            }
        }
        canvas.restoreToCount(save);
    }

    public final boolean a(CharSequence charSequence) {
        return (u.k(this.f308a) == 1 ? a.b.g.i.d.f1030b : a.b.g.i.d.f1029a).a(charSequence, 0, charSequence.length());
    }

    public static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    public static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return a.b.d.l.a.a(f2, f3, f4);
    }

    public static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
