package a.b.h.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
/* compiled from: FastScroller.java */
/* loaded from: classes.dex */
public class m0 extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];

    /* renamed from: a  reason: collision with root package name */
    public final int f1824a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1825b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f1826c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f1827d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1828e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1829f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f1830g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f1831h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1832i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public RecyclerView s;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z = ValueAnimator.ofFloat(0.0f, 1.0f);
    public int A = 0;
    public final Runnable B = new a();
    public final RecyclerView.t C = new b();

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m0.this.a(500);
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // android.support.v7.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2, int i3) {
            m0.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1835a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1835a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1835a) {
                this.f1835a = false;
            } else if (((Float) m0.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                m0 m0Var = m0.this;
                m0Var.A = 0;
                m0Var.c(0);
            } else {
                m0 m0Var2 = m0.this;
                m0Var2.A = 2;
                m0Var2.f();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            m0.this.f1826c.setAlpha(floatValue);
            m0.this.f1827d.setAlpha(floatValue);
            m0.this.f();
        }
    }

    public m0(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.f1826c = stateListDrawable;
        this.f1827d = drawable;
        this.f1830g = stateListDrawable2;
        this.f1831h = drawable2;
        this.f1828e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f1829f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f1832i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f1824a = i3;
        this.f1825b = i4;
        this.f1826c.setAlpha(255);
        this.f1827d.setAlpha(255);
        this.z.addListener(new c());
        this.z.addUpdateListener(new d());
        a(recyclerView);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            b();
        }
        this.s = recyclerView;
        if (this.s != null) {
            g();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.s
    public void a(boolean z) {
    }

    public final void b() {
        this.s.b((RecyclerView.n) this);
        this.s.b((RecyclerView.s) this);
        this.s.b(this.C);
        a();
    }

    public void c(int i2) {
        if (i2 == 2 && this.v != 2) {
            this.f1826c.setState(D);
            a();
        }
        if (i2 == 0) {
            f();
        } else {
            h();
        }
        if (this.v == 2 && i2 != 2) {
            this.f1826c.setState(E);
            b(1200);
        } else if (i2 == 1) {
            b(1500);
        }
        this.v = i2;
    }

    public final int[] d() {
        int[] iArr = this.x;
        int i2 = this.f1825b;
        iArr[0] = i2;
        iArr[1] = this.r - i2;
        return iArr;
    }

    public final boolean e() {
        return a.b.g.k.u.k(this.s) == 1;
    }

    public void f() {
        this.s.invalidate();
    }

    public final void g() {
        this.s.a((RecyclerView.n) this);
        this.s.a((RecyclerView.s) this);
        this.s.a(this.C);
    }

    public void h() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            }
            this.z.cancel();
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }

    public final void b(int i2) {
        a();
        this.s.postDelayed(this.B, i2);
    }

    public void a(int i2) {
        int i3 = this.A;
        if (i3 == 1) {
            this.z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.z.setDuration(i2);
        this.z.start();
    }

    @Override // android.support.v7.widget.RecyclerView.n
    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.q == this.s.getWidth() && this.r == this.s.getHeight()) {
            if (this.A != 0) {
                if (this.t) {
                    b(canvas);
                }
                if (this.u) {
                    a(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.q = this.s.getWidth();
        this.r = this.s.getHeight();
        c(0);
    }

    public final int[] c() {
        int[] iArr = this.y;
        int i2 = this.f1825b;
        iArr[0] = i2;
        iArr[1] = this.q - i2;
        return iArr;
    }

    public final void a() {
        this.s.removeCallbacks(this.B);
    }

    public final void a(Canvas canvas) {
        int i2 = this.r;
        int i3 = this.f1832i;
        int i4 = i2 - i3;
        int i5 = this.o;
        int i6 = this.n;
        int i7 = i5 - (i6 / 2);
        this.f1830g.setBounds(0, 0, i6, i3);
        this.f1831h.setBounds(0, 0, this.q, this.j);
        canvas.translate(0.0f, i4);
        this.f1831h.draw(canvas);
        canvas.translate(i7, 0.0f);
        this.f1830g.draw(canvas);
        canvas.translate(-i7, -i4);
    }

    public final void b(Canvas canvas) {
        int i2 = this.q;
        int i3 = this.f1828e;
        int i4 = i2 - i3;
        int i5 = this.l;
        int i6 = this.k;
        int i7 = i5 - (i6 / 2);
        this.f1826c.setBounds(0, 0, i3, i6);
        this.f1827d.setBounds(0, 0, this.f1829f, this.r);
        if (e()) {
            this.f1827d.draw(canvas);
            canvas.translate(this.f1828e, i7);
            canvas.scale(-1.0f, 1.0f);
            this.f1826c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f1828e, -i7);
            return;
        }
        canvas.translate(i4, 0.0f);
        this.f1827d.draw(canvas);
        canvas.translate(0.0f, i7);
        this.f1826c.draw(canvas);
        canvas.translate(-i4, -i7);
    }

    public void a(int i2, int i3) {
        int computeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i4 = this.r;
        this.t = computeVerticalScrollRange - i4 > 0 && i4 >= this.f1824a;
        int computeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i5 = this.q;
        this.u = computeHorizontalScrollRange - i5 > 0 && i5 >= this.f1824a;
        if (!this.t && !this.u) {
            if (this.v != 0) {
                c(0);
                return;
            }
            return;
        }
        if (this.t) {
            float f2 = i4;
            this.l = (int) ((f2 * (i3 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.k = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
        }
        if (this.u) {
            float f3 = i5;
            this.o = (int) ((f3 * (i2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.n = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
        }
        int i6 = this.v;
        if (i6 == 0 || i6 == 1) {
            c(1);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.s
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!b2 && !a2) {
                return false;
            }
            if (a2) {
                this.w = 1;
                this.p = (int) motionEvent.getX();
            } else if (b2) {
                this.w = 2;
                this.m = (int) motionEvent.getY();
            }
            c(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (b2 || a2) {
                if (a2) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (b2) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                c(2);
            }
        } else if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            c(1);
            this.w = 0;
        } else if (motionEvent.getAction() == 2 && this.v == 2) {
            h();
            if (this.w == 1) {
                a(motionEvent.getX());
            }
            if (this.w == 2) {
                b(motionEvent.getY());
            }
        }
    }

    public final void b(float f2) {
        int[] d2 = d();
        float max = Math.max(d2[0], Math.min(d2[1], f2));
        if (Math.abs(this.l - max) < 2.0f) {
            return;
        }
        int a2 = a(this.m, max, d2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (a2 != 0) {
            this.s.scrollBy(0, a2);
        }
        this.m = max;
    }

    public boolean b(float f2, float f3) {
        if (!e() ? f2 >= this.q - this.f1828e : f2 <= this.f1828e / 2) {
            int i2 = this.l;
            int i3 = this.k;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    public final void a(float f2) {
        int[] c2 = c();
        float max = Math.max(c2[0], Math.min(c2[1], f2));
        if (Math.abs(this.o - max) < 2.0f) {
            return;
        }
        int a2 = a(this.p, max, c2, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (a2 != 0) {
            this.s.scrollBy(a2, 0);
        }
        this.p = max;
    }

    public final int a(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public boolean a(float f2, float f3) {
        if (f3 >= this.r - this.f1832i) {
            int i2 = this.o;
            int i3 = this.n;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }
}
