package a.b.g.l;

import a.b.g.k.u;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int s = ViewConfiguration.getTapTimeout();

    /* renamed from: c  reason: collision with root package name */
    public final View f1187c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f1188d;

    /* renamed from: g  reason: collision with root package name */
    public int f1191g;

    /* renamed from: h  reason: collision with root package name */
    public int f1192h;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: a  reason: collision with root package name */
    public final C0034a f1185a = new C0034a();

    /* renamed from: b  reason: collision with root package name */
    public final Interpolator f1186b = new AccelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public float[] f1189e = {0.0f, 0.0f};

    /* renamed from: f  reason: collision with root package name */
    public float[] f1190f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i  reason: collision with root package name */
    public float[] f1193i = {0.0f, 0.0f};
    public float[] j = {0.0f, 0.0f};
    public float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: a.b.g.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {

        /* renamed from: a  reason: collision with root package name */
        public int f1194a;

        /* renamed from: b  reason: collision with root package name */
        public int f1195b;

        /* renamed from: c  reason: collision with root package name */
        public float f1196c;

        /* renamed from: d  reason: collision with root package name */
        public float f1197d;
        public float j;
        public int k;

        /* renamed from: e  reason: collision with root package name */
        public long f1198e = Long.MIN_VALUE;

        /* renamed from: i  reason: collision with root package name */
        public long f1202i = -1;

        /* renamed from: f  reason: collision with root package name */
        public long f1199f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f1200g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f1201h = 0;

        public final float a(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a(int i2) {
            this.f1195b = i2;
        }

        public void b(int i2) {
            this.f1194a = i2;
        }

        public int c() {
            return this.f1201h;
        }

        public int d() {
            float f2 = this.f1196c;
            return (int) (f2 / Math.abs(f2));
        }

        public int e() {
            float f2 = this.f1197d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean f() {
            return this.f1202i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1202i + ((long) this.k);
        }

        public void g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f1198e), 0, this.f1195b);
            this.j = a(currentAnimationTimeMillis);
            this.f1202i = currentAnimationTimeMillis;
        }

        public void h() {
            this.f1198e = AnimationUtils.currentAnimationTimeMillis();
            this.f1202i = -1L;
            this.f1199f = this.f1198e;
            this.j = 0.5f;
            this.f1200g = 0;
            this.f1201h = 0;
        }

        public final float a(long j) {
            if (j < this.f1198e) {
                return 0.0f;
            }
            long j2 = this.f1202i;
            if (j2 >= 0 && j >= j2) {
                long j3 = j - j2;
                float f2 = this.j;
                return (1.0f - f2) + (f2 * a.a(((float) j3) / this.k, 0.0f, 1.0f));
            }
            return a.a(((float) (j - this.f1198e)) / this.f1194a, 0.0f, 1.0f) * 0.5f;
        }

        public int b() {
            return this.f1200g;
        }

        public void a() {
            if (this.f1199f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f1199f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f1199f)) * a2;
                this.f1200g = (int) (this.f1196c * f2);
                this.f1201h = (int) (f2 * this.f1197d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.f1196c = f2;
            this.f1197d = f3;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.f1185a.h();
                }
                C0034a c0034a = a.this.f1185a;
                if (!c0034a.f() && a.this.c()) {
                    a aVar2 = a.this;
                    if (aVar2.o) {
                        aVar2.o = false;
                        aVar2.a();
                    }
                    c0034a.a();
                    a.this.a(c0034a.b(), c0034a.c());
                    u.a(a.this.f1187c, this);
                    return;
                }
                a.this.p = false;
            }
        }
    }

    public a(View view) {
        this.f1187c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        c(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        d(f4, f4);
        d(1);
        b(Float.MAX_VALUE, Float.MAX_VALUE);
        e(0.2f, 0.2f);
        f(1.0f, 1.0f);
        c(s);
        f(500);
        e(500);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public a a(boolean z) {
        if (this.q && !z) {
            b();
        }
        this.q = z;
        return this;
    }

    public abstract void a(int i2, int i3);

    public abstract boolean a(int i2);

    public a b(float f2, float f3) {
        float[] fArr = this.f1190f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public abstract boolean b(int i2);

    public a c(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.f1189e;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a f(float f2, float f3) {
        float[] fArr = this.f1193i;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.b()
            goto L58
        L1a:
            r5.o = r2
            r5.m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1187c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1187c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            a.b.g.l.a$a r7 = r5.f1185a
            r7.a(r0, r6)
            boolean r6 = r5.p
            if (r6 != 0) goto L58
            boolean r6 = r5.c()
            if (r6 == 0) goto L58
            r5.d()
        L58:
            boolean r6 = r5.r
            if (r6 == 0) goto L61
            boolean r6 = r5.p
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.l.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void b() {
        if (this.n) {
            this.p = false;
        } else {
            this.f1185a.g();
        }
    }

    public a c(int i2) {
        this.f1192h = i2;
        return this;
    }

    public a d(int i2) {
        this.f1191g = i2;
        return this;
    }

    public a e(int i2) {
        this.f1185a.a(i2);
        return this;
    }

    public a f(int i2) {
        this.f1185a.b(i2);
        return this;
    }

    public final float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.f1189e[i2], f3, this.f1190f[i2], f2);
        int i3 = (a2 > 0.0f ? 1 : (a2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.f1193i[i2];
        float f6 = this.j[i2];
        float f7 = this.k[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    public boolean c() {
        C0034a c0034a = this.f1185a;
        int e2 = c0034a.e();
        int d2 = c0034a.d();
        return (e2 != 0 && b(e2)) || (d2 != 0 && a(d2));
    }

    public final void d() {
        int i2;
        if (this.f1188d == null) {
            this.f1188d = new b();
        }
        this.p = true;
        this.n = true;
        if (!this.m && (i2 = this.f1192h) > 0) {
            u.a(this.f1187c, this.f1188d, i2);
        } else {
            this.f1188d.run();
        }
        this.m = true;
    }

    public final float a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float a2 = a(f2 * f3, 0.0f, f4);
        float a3 = a(f3 - f5, a2) - a(f5, a2);
        if (a3 < 0.0f) {
            interpolation = -this.f1186b.getInterpolation(-a3);
        } else if (a3 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f1186b.getInterpolation(a3);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    public final float a(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1191g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.p && this.f1191g == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    public void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1187c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
