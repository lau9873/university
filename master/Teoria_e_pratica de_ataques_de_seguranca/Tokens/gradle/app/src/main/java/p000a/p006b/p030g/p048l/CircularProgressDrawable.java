package p000a.p006b.p030g.p048l;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import p000a.p006b.p030g.p044j.Preconditions;
import p000a.p006b.p030g.p045k.p047f0.FastOutSlowInInterpolator;

/* renamed from: a.b.g.l.d */
/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {

    /* renamed from: g */
    public static final Interpolator f1781g = new LinearInterpolator();

    /* renamed from: h */
    public static final Interpolator f1782h = new FastOutSlowInInterpolator();

    /* renamed from: i */
    public static final int[] f1783i = {-16777216};

    /* renamed from: a */
    public final C0313c f1784a;

    /* renamed from: b */
    public float f1785b;

    /* renamed from: c */
    public Resources f1786c;

    /* renamed from: d */
    public Animator f1787d;

    /* renamed from: e */
    public float f1788e;

    /* renamed from: f */
    public boolean f1789f;

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: a.b.g.l.d$a */
    /* loaded from: classes.dex */
    public class C0311a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ C0313c f1790a;

        public C0311a(C0313c c0313c) {
            this.f1790a = c0313c;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.m9280b(floatValue, this.f1790a);
            CircularProgressDrawable.this.m9285a(floatValue, this.f1790a, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: a.b.g.l.d$b */
    /* loaded from: classes.dex */
    public class C0312b implements Animator.AnimatorListener {

        /* renamed from: a */
        public final /* synthetic */ C0313c f1792a;

        public C0312b(C0313c c0313c) {
            this.f1792a = c0313c;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.m9285a(1.0f, this.f1792a, true);
            this.f1792a.m9251l();
            this.f1792a.m9253j();
            CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
            if (circularProgressDrawable.f1789f) {
                circularProgressDrawable.f1789f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f1792a.m9270a(false);
                return;
            }
            circularProgressDrawable.f1788e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.f1788e = 0.0f;
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: a.b.g.l.d$c */
    /* loaded from: classes.dex */
    public static class C0313c {

        /* renamed from: i */
        public int[] f1802i;

        /* renamed from: j */
        public int f1803j;

        /* renamed from: k */
        public float f1804k;

        /* renamed from: l */
        public float f1805l;

        /* renamed from: m */
        public float f1806m;

        /* renamed from: n */
        public boolean f1807n;

        /* renamed from: o */
        public Path f1808o;

        /* renamed from: q */
        public float f1810q;

        /* renamed from: r */
        public int f1811r;

        /* renamed from: s */
        public int f1812s;

        /* renamed from: u */
        public int f1814u;

        /* renamed from: a */
        public final RectF f1794a = new RectF();

        /* renamed from: b */
        public final Paint f1795b = new Paint();

        /* renamed from: c */
        public final Paint f1796c = new Paint();

        /* renamed from: d */
        public final Paint f1797d = new Paint();

        /* renamed from: e */
        public float f1798e = 0.0f;

        /* renamed from: f */
        public float f1799f = 0.0f;

        /* renamed from: g */
        public float f1800g = 0.0f;

        /* renamed from: h */
        public float f1801h = 5.0f;

        /* renamed from: p */
        public float f1809p = 1.0f;

        /* renamed from: t */
        public int f1813t = 255;

        public C0313c() {
            this.f1795b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1795b.setAntiAlias(true);
            this.f1795b.setStyle(Paint.Style.STROKE);
            this.f1796c.setStyle(Paint.Style.FILL);
            this.f1796c.setAntiAlias(true);
            this.f1797d.setColor(0);
        }

        /* renamed from: a */
        public void m9275a(float f, float f2) {
            this.f1811r = (int) f;
            this.f1812s = (int) f2;
        }

        /* renamed from: b */
        public void m9266b(int i) {
            this.f1814u = i;
        }

        /* renamed from: c */
        public void m9263c(int i) {
            this.f1803j = i;
            this.f1814u = this.f1802i[this.f1803j];
        }

        /* renamed from: d */
        public int m9262d() {
            return (this.f1803j + 1) % this.f1802i.length;
        }

        /* renamed from: e */
        public void m9259e(float f) {
            this.f1798e = f;
        }

        /* renamed from: f */
        public void m9257f(float f) {
            this.f1801h = f;
            this.f1795b.setStrokeWidth(f);
        }

        /* renamed from: g */
        public float m9256g() {
            return this.f1805l;
        }

        /* renamed from: h */
        public float m9255h() {
            return this.f1806m;
        }

        /* renamed from: i */
        public float m9254i() {
            return this.f1804k;
        }

        /* renamed from: j */
        public void m9253j() {
            m9263c(m9262d());
        }

        /* renamed from: k */
        public void m9252k() {
            this.f1804k = 0.0f;
            this.f1805l = 0.0f;
            this.f1806m = 0.0f;
            m9259e(0.0f);
            m9264c(0.0f);
            m9261d(0.0f);
        }

        /* renamed from: l */
        public void m9251l() {
            this.f1804k = this.f1798e;
            this.f1805l = this.f1799f;
            this.f1806m = this.f1800g;
        }

        /* renamed from: b */
        public float m9268b() {
            return this.f1799f;
        }

        /* renamed from: d */
        public void m9261d(float f) {
            this.f1800g = f;
        }

        /* renamed from: e */
        public float m9260e() {
            return this.f1798e;
        }

        /* renamed from: a */
        public void m9272a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1794a;
            float f = this.f1810q;
            float f2 = (this.f1801h / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f1811r * this.f1809p) / 2.0f, this.f1801h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.f1798e;
            float f4 = this.f1800g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f1799f + f4) * 360.0f) - f5;
            this.f1795b.setColor(this.f1814u);
            this.f1795b.setAlpha(this.f1813t);
            float f7 = this.f1801h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1797d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f1795b);
            m9273a(canvas, f5, f6, rectF);
        }

        /* renamed from: b */
        public void m9267b(float f) {
            this.f1810q = f;
        }

        /* renamed from: c */
        public int m9265c() {
            return this.f1802i[m9262d()];
        }

        /* renamed from: f */
        public int m9258f() {
            return this.f1802i[this.f1803j];
        }

        /* renamed from: c */
        public void m9264c(float f) {
            this.f1799f = f;
        }

        /* renamed from: a */
        public void m9273a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.f1807n) {
                Path path = this.f1808o;
                if (path == null) {
                    this.f1808o = new Path();
                    this.f1808o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f1808o.moveTo(0.0f, 0.0f);
                this.f1808o.lineTo(this.f1811r * this.f1809p, 0.0f);
                Path path2 = this.f1808o;
                float f3 = this.f1809p;
                path2.lineTo((this.f1811r * f3) / 2.0f, this.f1812s * f3);
                this.f1808o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.f1811r * this.f1809p) / 2.0f), rectF.centerY() + (this.f1801h / 2.0f));
                this.f1808o.close();
                this.f1796c.setColor(this.f1814u);
                this.f1796c.setAlpha(this.f1813t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f1808o, this.f1796c);
                canvas.restore();
            }
        }

        /* renamed from: a */
        public void m9269a(int[] iArr) {
            this.f1802i = iArr;
            m9263c(0);
        }

        /* renamed from: a */
        public void m9271a(ColorFilter colorFilter) {
            this.f1795b.setColorFilter(colorFilter);
        }

        /* renamed from: a */
        public void m9274a(int i) {
            this.f1813t = i;
        }

        /* renamed from: a */
        public int m9277a() {
            return this.f1813t;
        }

        /* renamed from: a */
        public void m9270a(boolean z) {
            if (this.f1807n != z) {
                this.f1807n = z;
            }
        }

        /* renamed from: a */
        public void m9276a(float f) {
            if (f != this.f1809p) {
                this.f1809p = f;
            }
        }
    }

    public CircularProgressDrawable(Context context) {
        Preconditions.m9621a(context);
        this.f1786c = context.getResources();
        this.f1784a = new C0313c();
        this.f1784a.m9269a(f1783i);
        m9278d(2.5f);
        m9291a();
    }

    /* renamed from: a */
    public final int m9287a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
    }

    /* renamed from: a */
    public final void m9288a(float f, float f2, float f3, float f4) {
        C0313c c0313c = this.f1784a;
        float f5 = this.f1786c.getDisplayMetrics().density;
        c0313c.m9257f(f2 * f5);
        c0313c.m9267b(f * f5);
        c0313c.m9263c(0);
        c0313c.m9275a(f3 * f5, f4 * f5);
    }

    /* renamed from: b */
    public void m9281b(float f) {
        this.f1784a.m9261d(f);
        invalidateSelf();
    }

    /* renamed from: c */
    public final void m9279c(float f) {
        this.f1785b = f;
    }

    /* renamed from: d */
    public void m9278d(float f) {
        this.f1784a.m9257f(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1785b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1784a.m9272a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1784a.m9277a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1787d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1784a.m9274a(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1784a.m9271a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1787d.cancel();
        this.f1784a.m9251l();
        if (this.f1784a.m9268b() != this.f1784a.m9260e()) {
            this.f1789f = true;
            this.f1787d.setDuration(666L);
            this.f1787d.start();
            return;
        }
        this.f1784a.m9263c(0);
        this.f1784a.m9252k();
        this.f1787d.setDuration(1332L);
        this.f1787d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1787d.cancel();
        m9279c(0.0f);
        this.f1784a.m9270a(false);
        this.f1784a.m9263c(0);
        this.f1784a.m9252k();
        invalidateSelf();
    }

    /* renamed from: b */
    public void m9280b(float f, C0313c c0313c) {
        if (f > 0.75f) {
            c0313c.m9266b(m9287a((f - 0.75f) / 0.25f, c0313c.m9258f(), c0313c.m9265c()));
        } else {
            c0313c.m9266b(c0313c.m9258f());
        }
    }

    /* renamed from: a */
    public void m9284a(int i) {
        if (i == 0) {
            m9288a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m9288a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public void m9283a(boolean z) {
        this.f1784a.m9270a(z);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m9290a(float f) {
        this.f1784a.m9276a(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m9289a(float f, float f2) {
        this.f1784a.m9259e(f);
        this.f1784a.m9264c(f2);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m9282a(int... iArr) {
        this.f1784a.m9269a(iArr);
        this.f1784a.m9263c(0);
        invalidateSelf();
    }

    /* renamed from: a */
    public final void m9286a(float f, C0313c c0313c) {
        m9280b(f, c0313c);
        c0313c.m9259e(c0313c.m9254i() + (((c0313c.m9256g() - 0.01f) - c0313c.m9254i()) * f));
        c0313c.m9264c(c0313c.m9256g());
        c0313c.m9261d(c0313c.m9255h() + ((((float) (Math.floor(c0313c.m9255h() / 0.8f) + 1.0d)) - c0313c.m9255h()) * f));
    }

    /* renamed from: a */
    public void m9285a(float f, C0313c c0313c, boolean z) {
        float m9254i;
        float interpolation;
        if (this.f1789f) {
            m9286a(f, c0313c);
        } else if (f != 1.0f || z) {
            float m9255h = c0313c.m9255h();
            if (f < 0.5f) {
                float m9254i2 = c0313c.m9254i();
                m9254i = (f1782h.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + m9254i2;
                interpolation = m9254i2;
            } else {
                m9254i = c0313c.m9254i() + 0.79f;
                interpolation = m9254i - (((1.0f - f1782h.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            c0313c.m9259e(interpolation);
            c0313c.m9264c(m9254i);
            c0313c.m9261d(m9255h + (0.20999998f * f));
            m9279c((f + this.f1788e) * 216.0f);
        }
    }

    /* renamed from: a */
    public final void m9291a() {
        C0313c c0313c = this.f1784a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C0311a(c0313c));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1781g);
        ofFloat.addListener(new C0312b(c0313c));
        this.f1787d = ofFloat;
    }
}
