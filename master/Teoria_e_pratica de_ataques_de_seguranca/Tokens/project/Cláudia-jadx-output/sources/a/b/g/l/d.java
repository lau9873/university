package a.b.g.l;

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
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class d extends Drawable implements Animatable {

    /* renamed from: g  reason: collision with root package name */
    public static final Interpolator f1209g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    public static final Interpolator f1210h = new a.b.g.k.f0.b();

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1211i = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    public final c f1212a;

    /* renamed from: b  reason: collision with root package name */
    public float f1213b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f1214c;

    /* renamed from: d  reason: collision with root package name */
    public Animator f1215d;

    /* renamed from: e  reason: collision with root package name */
    public float f1216e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1217f;

    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1218a;

        public a(c cVar) {
            this.f1218a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.b(floatValue, this.f1218a);
            d.this.a(floatValue, this.f1218a, false);
            d.this.invalidateSelf();
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f1220a;

        public b(c cVar) {
            this.f1220a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            d.this.a(1.0f, this.f1220a, true);
            this.f1220a.l();
            this.f1220a.j();
            d dVar = d.this;
            if (dVar.f1217f) {
                dVar.f1217f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f1220a.a(false);
                return;
            }
            dVar.f1216e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f1216e = 0.0f;
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: i  reason: collision with root package name */
        public int[] f1230i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public Path o;
        public float q;
        public int r;
        public int s;
        public int u;

        /* renamed from: a  reason: collision with root package name */
        public final RectF f1222a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f1223b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        public final Paint f1224c = new Paint();

        /* renamed from: d  reason: collision with root package name */
        public final Paint f1225d = new Paint();

        /* renamed from: e  reason: collision with root package name */
        public float f1226e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1227f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1228g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f1229h = 5.0f;
        public float p = 1.0f;
        public int t = 255;

        public c() {
            this.f1223b.setStrokeCap(Paint.Cap.SQUARE);
            this.f1223b.setAntiAlias(true);
            this.f1223b.setStyle(Paint.Style.STROKE);
            this.f1224c.setStyle(Paint.Style.FILL);
            this.f1224c.setAntiAlias(true);
            this.f1225d.setColor(0);
        }

        public void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        public void b(int i2) {
            this.u = i2;
        }

        public void c(int i2) {
            this.j = i2;
            this.u = this.f1230i[this.j];
        }

        public int d() {
            return (this.j + 1) % this.f1230i.length;
        }

        public void e(float f2) {
            this.f1226e = f2;
        }

        public void f(float f2) {
            this.f1229h = f2;
            this.f1223b.setStrokeWidth(f2);
        }

        public float g() {
            return this.l;
        }

        public float h() {
            return this.m;
        }

        public float i() {
            return this.k;
        }

        public void j() {
            c(d());
        }

        public void k() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            e(0.0f);
            c(0.0f);
            d(0.0f);
        }

        public void l() {
            this.k = this.f1226e;
            this.l = this.f1227f;
            this.m = this.f1228g;
        }

        public float b() {
            return this.f1227f;
        }

        public void d(float f2) {
            this.f1228g = f2;
        }

        public float e() {
            return this.f1226e;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1222a;
            float f2 = this.q;
            float f3 = (this.f1229h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f1229h / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.f1226e;
            float f5 = this.f1228g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f1227f + f5) * 360.0f) - f6;
            this.f1223b.setColor(this.u);
            this.f1223b.setAlpha(this.t);
            float f8 = this.f1229h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1225d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f1223b);
            a(canvas, f6, f7, rectF);
        }

        public void b(float f2) {
            this.q = f2;
        }

        public int c() {
            return this.f1230i[d()];
        }

        public int f() {
            return this.f1230i[this.j];
        }

        public void c(float f2) {
            this.f1227f = f2;
        }

        public void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path2 = this.o;
                float f4 = this.p;
                path2.lineTo((this.r * f4) / 2.0f, this.s * f4);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.r * this.p) / 2.0f), rectF.centerY() + (this.f1229h / 2.0f));
                this.o.close();
                this.f1224c.setColor(this.u);
                this.f1224c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f1224c);
                canvas.restore();
            }
        }

        public void a(int[] iArr) {
            this.f1230i = iArr;
            c(0);
        }

        public void a(ColorFilter colorFilter) {
            this.f1223b.setColorFilter(colorFilter);
        }

        public void a(int i2) {
            this.t = i2;
        }

        public int a() {
            return this.t;
        }

        public void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        public void a(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public d(Context context) {
        a.b.g.j.m.a(context);
        this.f1214c = context.getResources();
        this.f1212a = new c();
        this.f1212a.a(f1211i);
        d(2.5f);
        a();
    }

    public final int a(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    public final void a(float f2, float f3, float f4, float f5) {
        c cVar = this.f1212a;
        float f6 = this.f1214c.getDisplayMetrics().density;
        cVar.f(f3 * f6);
        cVar.b(f2 * f6);
        cVar.c(0);
        cVar.a(f4 * f6, f5 * f6);
    }

    public void b(float f2) {
        this.f1212a.d(f2);
        invalidateSelf();
    }

    public final void c(float f2) {
        this.f1213b = f2;
    }

    public void d(float f2) {
        this.f1212a.f(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1213b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1212a.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1212a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1215d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1212a.a(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1212a.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f1215d.cancel();
        this.f1212a.l();
        if (this.f1212a.b() != this.f1212a.e()) {
            this.f1217f = true;
            this.f1215d.setDuration(666L);
            this.f1215d.start();
            return;
        }
        this.f1212a.c(0);
        this.f1212a.k();
        this.f1215d.setDuration(1332L);
        this.f1215d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f1215d.cancel();
        c(0.0f);
        this.f1212a.a(false);
        this.f1212a.c(0);
        this.f1212a.k();
        invalidateSelf();
    }

    public void b(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.b(a((f2 - 0.75f) / 0.25f, cVar.f(), cVar.c()));
        } else {
            cVar.b(cVar.f());
        }
    }

    public void a(int i2) {
        if (i2 == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f1212a.a(z);
        invalidateSelf();
    }

    public void a(float f2) {
        this.f1212a.a(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f1212a.e(f2);
        this.f1212a.c(f3);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f1212a.a(iArr);
        this.f1212a.c(0);
        invalidateSelf();
    }

    public final void a(float f2, c cVar) {
        b(f2, cVar);
        cVar.e(cVar.i() + (((cVar.g() - 0.01f) - cVar.i()) * f2));
        cVar.c(cVar.g());
        cVar.d(cVar.h() + ((((float) (Math.floor(cVar.h() / 0.8f) + 1.0d)) - cVar.h()) * f2));
    }

    public void a(float f2, c cVar, boolean z) {
        float i2;
        float interpolation;
        if (this.f1217f) {
            a(f2, cVar);
        } else if (f2 != 1.0f || z) {
            float h2 = cVar.h();
            if (f2 < 0.5f) {
                float i3 = cVar.i();
                i2 = (f1210h.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + i3;
                interpolation = i3;
            } else {
                i2 = cVar.i() + 0.79f;
                interpolation = i2 - (((1.0f - f1210h.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            cVar.e(interpolation);
            cVar.c(i2);
            cVar.d(h2 + (0.20999998f * f2));
            c((f2 + this.f1216e) * 216.0f);
        }
    }

    public final void a() {
        c cVar = this.f1212a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1209g);
        ofFloat.addListener(new b(cVar));
        this.f1215d = ofFloat;
    }
}
