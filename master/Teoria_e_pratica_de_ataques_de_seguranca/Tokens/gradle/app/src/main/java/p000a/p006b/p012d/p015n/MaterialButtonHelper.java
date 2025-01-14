package p000a.p006b.p012d.p015n;

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
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p019q.ViewUtils;
import p000a.p006b.p012d.p020r.MaterialResources;
import p000a.p006b.p012d.p021s.RippleUtils;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.d.n.c */
/* loaded from: classes.dex */
public class MaterialButtonHelper {

    /* renamed from: w */
    public static final boolean f451w;

    /* renamed from: a */
    public final MaterialButton f452a;

    /* renamed from: b */
    public int f453b;

    /* renamed from: c */
    public int f454c;

    /* renamed from: d */
    public int f455d;

    /* renamed from: e */
    public int f456e;

    /* renamed from: f */
    public int f457f;

    /* renamed from: g */
    public int f458g;

    /* renamed from: h */
    public PorterDuff.Mode f459h;

    /* renamed from: i */
    public ColorStateList f460i;

    /* renamed from: j */
    public ColorStateList f461j;

    /* renamed from: k */
    public ColorStateList f462k;

    /* renamed from: o */
    public GradientDrawable f466o;

    /* renamed from: p */
    public Drawable f467p;

    /* renamed from: q */
    public GradientDrawable f468q;

    /* renamed from: r */
    public Drawable f469r;

    /* renamed from: s */
    public GradientDrawable f470s;

    /* renamed from: t */
    public GradientDrawable f471t;

    /* renamed from: u */
    public GradientDrawable f472u;

    /* renamed from: l */
    public final Paint f463l = new Paint(1);

    /* renamed from: m */
    public final Rect f464m = new Rect();

    /* renamed from: n */
    public final RectF f465n = new RectF();

    /* renamed from: v */
    public boolean f473v = false;

    static {
        f451w = Build.VERSION.SDK_INT >= 21;
    }

    public MaterialButtonHelper(MaterialButton materialButton) {
        this.f452a = materialButton;
    }

    /* renamed from: a */
    public void m10930a(TypedArray typedArray) {
        this.f453b = typedArray.getDimensionPixelOffset(C0049k.MaterialButton_android_insetLeft, 0);
        this.f454c = typedArray.getDimensionPixelOffset(C0049k.MaterialButton_android_insetRight, 0);
        this.f455d = typedArray.getDimensionPixelOffset(C0049k.MaterialButton_android_insetTop, 0);
        this.f456e = typedArray.getDimensionPixelOffset(C0049k.MaterialButton_android_insetBottom, 0);
        this.f457f = typedArray.getDimensionPixelSize(C0049k.MaterialButton_cornerRadius, 0);
        this.f458g = typedArray.getDimensionPixelSize(C0049k.MaterialButton_strokeWidth, 0);
        this.f459h = ViewUtils.m10859a(typedArray.getInt(C0049k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f460i = MaterialResources.m10857a(this.f452a.getContext(), typedArray, C0049k.MaterialButton_backgroundTint);
        this.f461j = MaterialResources.m10857a(this.f452a.getContext(), typedArray, C0049k.MaterialButton_strokeColor);
        this.f462k = MaterialResources.m10857a(this.f452a.getContext(), typedArray, C0049k.MaterialButton_rippleColor);
        this.f463l.setStyle(Paint.Style.STROKE);
        this.f463l.setStrokeWidth(this.f458g);
        Paint paint = this.f463l;
        ColorStateList colorStateList = this.f461j;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f452a.getDrawableState(), 0) : 0);
        int m9418o = ViewCompat.m9418o(this.f452a);
        int paddingTop = this.f452a.getPaddingTop();
        int m9419n = ViewCompat.m9419n(this.f452a);
        int paddingBottom = this.f452a.getPaddingBottom();
        this.f452a.setInternalBackground(f451w ? m10926b() : m10934a());
        ViewCompat.m9455a(this.f452a, m9418o + this.f453b, paddingTop + this.f455d, m9419n + this.f454c, paddingBottom + this.f456e);
    }

    @TargetApi(21)
    /* renamed from: b */
    public final Drawable m10926b() {
        this.f470s = new GradientDrawable();
        this.f470s.setCornerRadius(this.f457f + 1.0E-5f);
        this.f470s.setColor(-1);
        m10910n();
        this.f471t = new GradientDrawable();
        this.f471t.setCornerRadius(this.f457f + 1.0E-5f);
        this.f471t.setColor(0);
        this.f471t.setStroke(this.f458g, this.f461j);
        InsetDrawable m10927a = m10927a(new LayerDrawable(new Drawable[]{this.f470s, this.f471t}));
        this.f472u = new GradientDrawable();
        this.f472u.setCornerRadius(this.f457f + 1.0E-5f);
        this.f472u.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.m10854a(this.f462k), m10927a, this.f472u);
    }

    /* renamed from: c */
    public void m10921c(ColorStateList colorStateList) {
        if (this.f460i != colorStateList) {
            this.f460i = colorStateList;
            if (f451w) {
                m10910n();
                return;
            }
            Drawable drawable = this.f467p;
            if (drawable != null) {
                DrawableCompat.m9861a(drawable, this.f460i);
            }
        }
    }

    /* renamed from: d */
    public ColorStateList m10920d() {
        return this.f462k;
    }

    /* renamed from: e */
    public ColorStateList m10919e() {
        return this.f461j;
    }

    /* renamed from: f */
    public int m10918f() {
        return this.f458g;
    }

    /* renamed from: g */
    public ColorStateList m10917g() {
        return this.f460i;
    }

    /* renamed from: h */
    public PorterDuff.Mode m10916h() {
        return this.f459h;
    }

    /* renamed from: i */
    public boolean m10915i() {
        return this.f473v;
    }

    /* renamed from: j */
    public void m10914j() {
        this.f473v = true;
        this.f452a.setSupportBackgroundTintList(this.f460i);
        this.f452a.setSupportBackgroundTintMode(this.f459h);
    }

    /* renamed from: k */
    public final GradientDrawable m10913k() {
        if (!f451w || this.f452a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f452a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    /* renamed from: l */
    public final GradientDrawable m10912l() {
        if (!f451w || this.f452a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f452a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    /* renamed from: m */
    public final void m10911m() {
        if (f451w && this.f471t != null) {
            this.f452a.setInternalBackground(m10926b());
        } else if (f451w) {
        } else {
            this.f452a.invalidate();
        }
    }

    /* renamed from: n */
    public final void m10910n() {
        GradientDrawable gradientDrawable = this.f470s;
        if (gradientDrawable != null) {
            DrawableCompat.m9861a(gradientDrawable, this.f460i);
            PorterDuff.Mode mode = this.f459h;
            if (mode != null) {
                DrawableCompat.m9858a(this.f470s, mode);
            }
        }
    }

    /* renamed from: c */
    public void m10922c(int i) {
        if (this.f458g != i) {
            this.f458g = i;
            this.f463l.setStrokeWidth(i);
            m10911m();
        }
    }

    /* renamed from: c */
    public int m10923c() {
        return this.f457f;
    }

    /* renamed from: b */
    public void m10924b(ColorStateList colorStateList) {
        if (this.f461j != colorStateList) {
            this.f461j = colorStateList;
            this.f463l.setColor(colorStateList != null ? colorStateList.getColorForState(this.f452a.getDrawableState(), 0) : 0);
            m10911m();
        }
    }

    /* renamed from: b */
    public void m10925b(int i) {
        GradientDrawable gradientDrawable;
        if (this.f457f != i) {
            this.f457f = i;
            if (f451w && this.f470s != null && this.f471t != null && this.f472u != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f = i + 1.0E-5f;
                    m10913k().setCornerRadius(f);
                    m10912l().setCornerRadius(f);
                }
                float f2 = i + 1.0E-5f;
                this.f470s.setCornerRadius(f2);
                this.f471t.setCornerRadius(f2);
                this.f472u.setCornerRadius(f2);
            } else if (f451w || (gradientDrawable = this.f466o) == null || this.f468q == null) {
            } else {
                float f3 = i + 1.0E-5f;
                gradientDrawable.setCornerRadius(f3);
                this.f468q.setCornerRadius(f3);
                this.f452a.invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m10929a(Canvas canvas) {
        if (canvas == null || this.f461j == null || this.f458g <= 0) {
            return;
        }
        this.f464m.set(this.f452a.getBackground().getBounds());
        RectF rectF = this.f465n;
        Rect rect = this.f464m;
        int i = this.f458g;
        rectF.set(rect.left + (i / 2.0f) + this.f453b, rect.top + (i / 2.0f) + this.f455d, (rect.right - (i / 2.0f)) - this.f454c, (rect.bottom - (i / 2.0f)) - this.f456e);
        float f = this.f457f - (this.f458g / 2.0f);
        canvas.drawRoundRect(this.f465n, f, f, this.f463l);
    }

    /* renamed from: a */
    public final Drawable m10934a() {
        this.f466o = new GradientDrawable();
        this.f466o.setCornerRadius(this.f457f + 1.0E-5f);
        this.f466o.setColor(-1);
        this.f467p = DrawableCompat.m9848i(this.f466o);
        DrawableCompat.m9861a(this.f467p, this.f460i);
        PorterDuff.Mode mode = this.f459h;
        if (mode != null) {
            DrawableCompat.m9858a(this.f467p, mode);
        }
        this.f468q = new GradientDrawable();
        this.f468q.setCornerRadius(this.f457f + 1.0E-5f);
        this.f468q.setColor(-1);
        this.f469r = DrawableCompat.m9848i(this.f468q);
        DrawableCompat.m9861a(this.f469r, this.f462k);
        return m10927a(new LayerDrawable(new Drawable[]{this.f467p, this.f469r}));
    }

    /* renamed from: a */
    public final InsetDrawable m10927a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f453b, this.f455d, this.f454c, this.f456e);
    }

    /* renamed from: a */
    public void m10928a(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.f459h != mode) {
            this.f459h = mode;
            if (f451w) {
                m10910n();
                return;
            }
            Drawable drawable = this.f467p;
            if (drawable == null || (mode2 = this.f459h) == null) {
                return;
            }
            DrawableCompat.m9858a(drawable, mode2);
        }
    }

    /* renamed from: a */
    public void m10932a(int i, int i2) {
        GradientDrawable gradientDrawable = this.f472u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f453b, this.f455d, i2 - this.f454c, i - this.f456e);
        }
    }

    /* renamed from: a */
    public void m10933a(int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (f451w && (gradientDrawable2 = this.f470s) != null) {
            gradientDrawable2.setColor(i);
        } else if (f451w || (gradientDrawable = this.f466o) == null) {
        } else {
            gradientDrawable.setColor(i);
        }
    }

    /* renamed from: a */
    public void m10931a(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f462k != colorStateList) {
            this.f462k = colorStateList;
            if (f451w && (this.f452a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f452a.getBackground()).setColor(colorStateList);
            } else if (f451w || (drawable = this.f469r) == null) {
            } else {
                DrawableCompat.m9861a(drawable, colorStateList);
            }
        }
    }
}
