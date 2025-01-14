package a.b.d.n;

import a.b.d.k;
import a.b.d.q.h;
import a.b.g.k.u;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
public class c {
    public static final boolean w;

    /* renamed from: a  reason: collision with root package name */
    public final a f239a;

    /* renamed from: b  reason: collision with root package name */
    public int f240b;

    /* renamed from: c  reason: collision with root package name */
    public int f241c;

    /* renamed from: d  reason: collision with root package name */
    public int f242d;

    /* renamed from: e  reason: collision with root package name */
    public int f243e;

    /* renamed from: f  reason: collision with root package name */
    public int f244f;

    /* renamed from: g  reason: collision with root package name */
    public int f245g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f246h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f247i;
    public ColorStateList j;
    public ColorStateList k;
    public GradientDrawable o;
    public Drawable p;
    public GradientDrawable q;
    public Drawable r;
    public GradientDrawable s;
    public GradientDrawable t;
    public GradientDrawable u;
    public final Paint l = new Paint(1);
    public final Rect m = new Rect();
    public final RectF n = new RectF();
    public boolean v = false;

    static {
        w = Build.VERSION.SDK_INT >= 21;
    }

    public c(a aVar) {
        this.f239a = aVar;
    }

    public void a(TypedArray typedArray) {
        this.f240b = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetLeft, 0);
        this.f241c = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetRight, 0);
        this.f242d = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetTop, 0);
        this.f243e = typedArray.getDimensionPixelOffset(k.MaterialButton_android_insetBottom, 0);
        this.f244f = typedArray.getDimensionPixelSize(k.MaterialButton_cornerRadius, 0);
        this.f245g = typedArray.getDimensionPixelSize(k.MaterialButton_strokeWidth, 0);
        this.f246h = h.a(typedArray.getInt(k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f247i = a.b.d.r.a.a(this.f239a.getContext(), typedArray, k.MaterialButton_backgroundTint);
        this.j = a.b.d.r.a.a(this.f239a.getContext(), typedArray, k.MaterialButton_strokeColor);
        this.k = a.b.d.r.a.a(this.f239a.getContext(), typedArray, k.MaterialButton_rippleColor);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(this.f245g);
        Paint paint = this.l;
        ColorStateList colorStateList = this.j;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f239a.getDrawableState(), 0) : 0);
        int o = u.o(this.f239a);
        int paddingTop = this.f239a.getPaddingTop();
        int n = u.n(this.f239a);
        int paddingBottom = this.f239a.getPaddingBottom();
        this.f239a.setInternalBackground(w ? b() : a());
        u.a(this.f239a, o + this.f240b, paddingTop + this.f242d, n + this.f241c, paddingBottom + this.f243e);
    }

    @TargetApi(21)
    public final Drawable b() {
        this.s = new GradientDrawable();
        this.s.setCornerRadius(this.f244f + 1.0E-5f);
        this.s.setColor(-1);
        n();
        this.t = new GradientDrawable();
        this.t.setCornerRadius(this.f244f + 1.0E-5f);
        this.t.setColor(0);
        this.t.setStroke(this.f245g, this.j);
        InsetDrawable a2 = a(new LayerDrawable(new Drawable[]{this.s, this.t}));
        this.u = new GradientDrawable();
        this.u.setCornerRadius(this.f244f + 1.0E-5f);
        this.u.setColor(-1);
        return new b(a.b.d.s.a.a(this.k), a2, this.u);
    }

    public void c(ColorStateList colorStateList) {
        if (this.f247i != colorStateList) {
            this.f247i = colorStateList;
            if (w) {
                n();
                return;
            }
            Drawable drawable = this.p;
            if (drawable != null) {
                a.b.g.c.j.a.a(drawable, this.f247i);
            }
        }
    }

    public ColorStateList d() {
        return this.k;
    }

    public ColorStateList e() {
        return this.j;
    }

    public int f() {
        return this.f245g;
    }

    public ColorStateList g() {
        return this.f247i;
    }

    public PorterDuff.Mode h() {
        return this.f246h;
    }

    public boolean i() {
        return this.v;
    }

    public void j() {
        this.v = true;
        this.f239a.setSupportBackgroundTintList(this.f247i);
        this.f239a.setSupportBackgroundTintMode(this.f246h);
    }

    public final GradientDrawable k() {
        if (!w || this.f239a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f239a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    public final GradientDrawable l() {
        if (!w || this.f239a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f239a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    public final void m() {
        if (w && this.t != null) {
            this.f239a.setInternalBackground(b());
        } else if (w) {
        } else {
            this.f239a.invalidate();
        }
    }

    public final void n() {
        GradientDrawable gradientDrawable = this.s;
        if (gradientDrawable != null) {
            a.b.g.c.j.a.a(gradientDrawable, this.f247i);
            PorterDuff.Mode mode = this.f246h;
            if (mode != null) {
                a.b.g.c.j.a.a(this.s, mode);
            }
        }
    }

    public void c(int i2) {
        if (this.f245g != i2) {
            this.f245g = i2;
            this.l.setStrokeWidth(i2);
            m();
        }
    }

    public int c() {
        return this.f244f;
    }

    public void b(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            this.l.setColor(colorStateList != null ? colorStateList.getColorForState(this.f239a.getDrawableState(), 0) : 0);
            m();
        }
    }

    public void b(int i2) {
        GradientDrawable gradientDrawable;
        if (this.f244f != i2) {
            this.f244f = i2;
            if (w && this.s != null && this.t != null && this.u != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f2 = i2 + 1.0E-5f;
                    k().setCornerRadius(f2);
                    l().setCornerRadius(f2);
                }
                float f3 = i2 + 1.0E-5f;
                this.s.setCornerRadius(f3);
                this.t.setCornerRadius(f3);
                this.u.setCornerRadius(f3);
            } else if (w || (gradientDrawable = this.o) == null || this.q == null) {
            } else {
                float f4 = i2 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f4);
                this.q.setCornerRadius(f4);
                this.f239a.invalidate();
            }
        }
    }

    public void a(Canvas canvas) {
        if (canvas == null || this.j == null || this.f245g <= 0) {
            return;
        }
        this.m.set(this.f239a.getBackground().getBounds());
        RectF rectF = this.n;
        Rect rect = this.m;
        int i2 = this.f245g;
        rectF.set(rect.left + (i2 / 2.0f) + this.f240b, rect.top + (i2 / 2.0f) + this.f242d, (rect.right - (i2 / 2.0f)) - this.f241c, (rect.bottom - (i2 / 2.0f)) - this.f243e);
        float f2 = this.f244f - (this.f245g / 2.0f);
        canvas.drawRoundRect(this.n, f2, f2, this.l);
    }

    public final Drawable a() {
        this.o = new GradientDrawable();
        this.o.setCornerRadius(this.f244f + 1.0E-5f);
        this.o.setColor(-1);
        this.p = a.b.g.c.j.a.i(this.o);
        a.b.g.c.j.a.a(this.p, this.f247i);
        PorterDuff.Mode mode = this.f246h;
        if (mode != null) {
            a.b.g.c.j.a.a(this.p, mode);
        }
        this.q = new GradientDrawable();
        this.q.setCornerRadius(this.f244f + 1.0E-5f);
        this.q.setColor(-1);
        this.r = a.b.g.c.j.a.i(this.q);
        a.b.g.c.j.a.a(this.r, this.k);
        return a(new LayerDrawable(new Drawable[]{this.p, this.r}));
    }

    public final InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f240b, this.f242d, this.f241c, this.f243e);
    }

    public void a(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.f246h != mode) {
            this.f246h = mode;
            if (w) {
                n();
                return;
            }
            Drawable drawable = this.p;
            if (drawable == null || (mode2 = this.f246h) == null) {
                return;
            }
            a.b.g.c.j.a.a(drawable, mode2);
        }
    }

    public void a(int i2, int i3) {
        GradientDrawable gradientDrawable = this.u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f240b, this.f242d, i3 - this.f241c, i2 - this.f243e);
        }
    }

    public void a(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (w && (gradientDrawable2 = this.s) != null) {
            gradientDrawable2.setColor(i2);
        } else if (w || (gradientDrawable = this.o) == null) {
        } else {
            gradientDrawable.setColor(i2);
        }
    }

    public void a(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (w && (this.f239a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f239a.getBackground()).setColor(colorStateList);
            } else if (w || (drawable = this.r) == null) {
            } else {
                a.b.g.c.j.a.a(drawable, colorStateList);
            }
        }
    }
}
