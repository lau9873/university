package p000a.p006b.p030g.p048l;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.g.l.a */
/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: s */
    public static final int f1745s = ViewConfiguration.getTapTimeout();

    /* renamed from: c */
    public final View f1748c;

    /* renamed from: d */
    public Runnable f1749d;

    /* renamed from: g */
    public int f1752g;

    /* renamed from: h */
    public int f1753h;

    /* renamed from: m */
    public boolean f1757m;

    /* renamed from: n */
    public boolean f1758n;

    /* renamed from: o */
    public boolean f1759o;

    /* renamed from: p */
    public boolean f1760p;

    /* renamed from: q */
    public boolean f1761q;

    /* renamed from: r */
    public boolean f1762r;

    /* renamed from: a */
    public final C0308a f1746a = new C0308a();

    /* renamed from: b */
    public final Interpolator f1747b = new AccelerateInterpolator();

    /* renamed from: e */
    public float[] f1750e = {0.0f, 0.0f};

    /* renamed from: f */
    public float[] f1751f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i */
    public float[] f1754i = {0.0f, 0.0f};

    /* renamed from: j */
    public float[] f1755j = {0.0f, 0.0f};

    /* renamed from: k */
    public float[] f1756k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: a.b.g.l.a$a */
    /* loaded from: classes.dex */
    public static class C0308a {

        /* renamed from: a */
        public int f1763a;

        /* renamed from: b */
        public int f1764b;

        /* renamed from: c */
        public float f1765c;

        /* renamed from: d */
        public float f1766d;

        /* renamed from: j */
        public float f1772j;

        /* renamed from: k */
        public int f1773k;

        /* renamed from: e */
        public long f1767e = Long.MIN_VALUE;

        /* renamed from: i */
        public long f1771i = -1;

        /* renamed from: f */
        public long f1768f = 0;

        /* renamed from: g */
        public int f1769g = 0;

        /* renamed from: h */
        public int f1770h = 0;

        /* renamed from: a */
        public final float m9306a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        /* renamed from: a */
        public void m9304a(int i) {
            this.f1764b = i;
        }

        /* renamed from: b */
        public void m9301b(int i) {
            this.f1763a = i;
        }

        /* renamed from: c */
        public int m9300c() {
            return this.f1770h;
        }

        /* renamed from: d */
        public int m9299d() {
            float f = this.f1765c;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: e */
        public int m9298e() {
            float f = this.f1766d;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: f */
        public boolean m9297f() {
            return this.f1771i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1771i + ((long) this.f1773k);
        }

        /* renamed from: g */
        public void m9296g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1773k = AutoScrollHelper.m9321a((int) (currentAnimationTimeMillis - this.f1767e), 0, this.f1764b);
            this.f1772j = m9303a(currentAnimationTimeMillis);
            this.f1771i = currentAnimationTimeMillis;
        }

        /* renamed from: h */
        public void m9295h() {
            this.f1767e = AnimationUtils.currentAnimationTimeMillis();
            this.f1771i = -1L;
            this.f1768f = this.f1767e;
            this.f1772j = 0.5f;
            this.f1769g = 0;
            this.f1770h = 0;
        }

        /* renamed from: a */
        public final float m9303a(long j) {
            if (j < this.f1767e) {
                return 0.0f;
            }
            long j2 = this.f1771i;
            if (j2 >= 0 && j >= j2) {
                long j3 = j - j2;
                float f = this.f1772j;
                return (1.0f - f) + (f * AutoScrollHelper.m9324a(((float) j3) / this.f1773k, 0.0f, 1.0f));
            }
            return AutoScrollHelper.m9324a(((float) (j - this.f1767e)) / this.f1763a, 0.0f, 1.0f) * 0.5f;
        }

        /* renamed from: b */
        public int m9302b() {
            return this.f1769g;
        }

        /* renamed from: a */
        public void m9307a() {
            if (this.f1768f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float m9306a = m9306a(m9303a(currentAnimationTimeMillis));
                this.f1768f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f1768f)) * m9306a;
                this.f1769g = (int) (this.f1765c * f);
                this.f1770h = (int) (f * this.f1766d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: a */
        public void m9305a(float f, float f2) {
            this.f1765c = f;
            this.f1766d = f2;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: a.b.g.l.a$b */
    /* loaded from: classes.dex */
    public class RunnableC0309b implements Runnable {
        public RunnableC0309b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f1760p) {
                if (autoScrollHelper.f1758n) {
                    autoScrollHelper.f1758n = false;
                    autoScrollHelper.f1746a.m9295h();
                }
                C0308a c0308a = AutoScrollHelper.this.f1746a;
                if (!c0308a.m9297f() && AutoScrollHelper.this.m9317c()) {
                    AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                    if (autoScrollHelper2.f1759o) {
                        autoScrollHelper2.f1759o = false;
                        autoScrollHelper2.m9326a();
                    }
                    c0308a.m9307a();
                    AutoScrollHelper.this.mo9226a(c0308a.m9302b(), c0308a.m9300c());
                    ViewCompat.m9445a(AutoScrollHelper.this.f1748c, this);
                    return;
                }
                AutoScrollHelper.this.f1760p = false;
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.f1748c = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        m9316c(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        m9313d(f3, f3);
        m9312d(1);
        m9318b(Float.MAX_VALUE, Float.MAX_VALUE);
        m9311e(0.2f, 0.2f);
        m9309f(1.0f, 1.0f);
        m9315c(f1745s);
        m9308f(500);
        m9310e(500);
    }

    /* renamed from: a */
    public static float m9324a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: a */
    public static int m9321a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    public AutoScrollHelper m9320a(boolean z) {
        if (this.f1761q && !z) {
            m9319b();
        }
        this.f1761q = z;
        return this;
    }

    /* renamed from: a */
    public abstract void mo9226a(int i, int i2);

    /* renamed from: a */
    public abstract boolean mo9227a(int i);

    /* renamed from: b */
    public AutoScrollHelper m9318b(float f, float f2) {
        float[] fArr = this.f1751f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: b */
    public abstract boolean mo9225b(int i);

    /* renamed from: c */
    public AutoScrollHelper m9316c(float f, float f2) {
        float[] fArr = this.f1756k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: d */
    public AutoScrollHelper m9313d(float f, float f2) {
        float[] fArr = this.f1755j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: e */
    public AutoScrollHelper m9311e(float f, float f2) {
        float[] fArr = this.f1750e;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: f */
    public AutoScrollHelper m9309f(float f, float f2) {
        float[] fArr = this.f1754i;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f1761q
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
            r5.m9319b()
            goto L58
        L1a:
            r5.f1759o = r2
            r5.f1757m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1748c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m9322a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1748c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m9322a(r2, r7, r6, r3)
            a.b.g.l.a$a r7 = r5.f1746a
            r7.m9305a(r0, r6)
            boolean r6 = r5.f1760p
            if (r6 != 0) goto L58
            boolean r6 = r5.m9317c()
            if (r6 == 0) goto L58
            r5.m9314d()
        L58:
            boolean r6 = r5.f1762r
            if (r6 == 0) goto L61
            boolean r6 = r5.f1760p
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p048l.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    public final void m9319b() {
        if (this.f1758n) {
            this.f1760p = false;
        } else {
            this.f1746a.m9296g();
        }
    }

    /* renamed from: c */
    public AutoScrollHelper m9315c(int i) {
        this.f1753h = i;
        return this;
    }

    /* renamed from: d */
    public AutoScrollHelper m9312d(int i) {
        this.f1752g = i;
        return this;
    }

    /* renamed from: e */
    public AutoScrollHelper m9310e(int i) {
        this.f1746a.m9304a(i);
        return this;
    }

    /* renamed from: f */
    public AutoScrollHelper m9308f(int i) {
        this.f1746a.m9301b(i);
        return this;
    }

    /* renamed from: a */
    public final float m9322a(int i, float f, float f2, float f3) {
        float m9323a = m9323a(this.f1750e[i], f2, this.f1751f[i], f);
        int i2 = (m9323a > 0.0f ? 1 : (m9323a == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0.0f;
        }
        float f4 = this.f1754i[i];
        float f5 = this.f1755j[i];
        float f6 = this.f1756k[i];
        float f7 = f4 * f3;
        if (i2 > 0) {
            return m9324a(m9323a * f7, f5, f6);
        }
        return -m9324a((-m9323a) * f7, f5, f6);
    }

    /* renamed from: c */
    public boolean m9317c() {
        C0308a c0308a = this.f1746a;
        int m9298e = c0308a.m9298e();
        int m9299d = c0308a.m9299d();
        return (m9298e != 0 && mo9225b(m9298e)) || (m9299d != 0 && mo9227a(m9299d));
    }

    /* renamed from: d */
    public final void m9314d() {
        int i;
        if (this.f1749d == null) {
            this.f1749d = new RunnableC0309b();
        }
        this.f1760p = true;
        this.f1758n = true;
        if (!this.f1757m && (i = this.f1753h) > 0) {
            ViewCompat.m9444a(this.f1748c, this.f1749d, i);
        } else {
            this.f1749d.run();
        }
        this.f1757m = true;
    }

    /* renamed from: a */
    public final float m9323a(float f, float f2, float f3, float f4) {
        float interpolation;
        float m9324a = m9324a(f * f2, 0.0f, f3);
        float m9325a = m9325a(f2 - f4, m9324a) - m9325a(f4, m9324a);
        if (m9325a < 0.0f) {
            interpolation = -this.f1747b.getInterpolation(-m9325a);
        } else if (m9325a <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f1747b.getInterpolation(m9325a);
        }
        return m9324a(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: a */
    public final float m9325a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f1752g;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f1760p && this.f1752g == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    /* renamed from: a */
    public void m9326a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1748c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
