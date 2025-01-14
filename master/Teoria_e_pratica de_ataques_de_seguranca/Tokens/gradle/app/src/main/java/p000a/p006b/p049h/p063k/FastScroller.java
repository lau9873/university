package p000a.p006b.p049h.p063k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.p067v7.widget.RecyclerView;
import android.view.MotionEvent;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.h.k.m0 */
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.AbstractC0721n implements RecyclerView.InterfaceC0730s {

    /* renamed from: D */
    public static final int[] f2756D = {16842919};

    /* renamed from: E */
    public static final int[] f2757E = new int[0];

    /* renamed from: a */
    public final int f2761a;

    /* renamed from: b */
    public final int f2762b;

    /* renamed from: c */
    public final StateListDrawable f2763c;

    /* renamed from: d */
    public final Drawable f2764d;

    /* renamed from: e */
    public final int f2765e;

    /* renamed from: f */
    public final int f2766f;

    /* renamed from: g */
    public final StateListDrawable f2767g;

    /* renamed from: h */
    public final Drawable f2768h;

    /* renamed from: i */
    public final int f2769i;

    /* renamed from: j */
    public final int f2770j;

    /* renamed from: k */
    public int f2771k;

    /* renamed from: l */
    public int f2772l;

    /* renamed from: m */
    public float f2773m;

    /* renamed from: n */
    public int f2774n;

    /* renamed from: o */
    public int f2775o;

    /* renamed from: p */
    public float f2776p;

    /* renamed from: s */
    public RecyclerView f2779s;

    /* renamed from: q */
    public int f2777q = 0;

    /* renamed from: r */
    public int f2778r = 0;

    /* renamed from: t */
    public boolean f2780t = false;

    /* renamed from: u */
    public boolean f2781u = false;

    /* renamed from: v */
    public int f2782v = 0;

    /* renamed from: w */
    public int f2783w = 0;

    /* renamed from: x */
    public final int[] f2784x = new int[2];

    /* renamed from: y */
    public final int[] f2785y = new int[2];

    /* renamed from: z */
    public final ValueAnimator f2786z = ValueAnimator.ofFloat(0.0f, 1.0f);

    /* renamed from: A */
    public int f2758A = 0;

    /* renamed from: B */
    public final Runnable f2759B = new RunnableC0478a();

    /* renamed from: C */
    public final RecyclerView.AbstractC0731t f2760C = new C0479b();

    /* compiled from: FastScroller.java */
    /* renamed from: a.b.h.k.m0$a */
    /* loaded from: classes.dex */
    public class RunnableC0478a implements Runnable {
        public RunnableC0478a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.m8238a(500);
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: a.b.h.k.m0$b */
    /* loaded from: classes.dex */
    public class C0479b extends RecyclerView.AbstractC0731t {
        public C0479b() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0731t
        /* renamed from: a */
        public void mo1057a(RecyclerView recyclerView, int i, int i2) {
            FastScroller.this.m8237a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: a.b.h.k.m0$c */
    /* loaded from: classes.dex */
    public class C0480c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f2789a = false;

        public C0480c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2789a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2789a) {
                this.f2789a = false;
            } else if (((Float) FastScroller.this.f2786z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.f2758A = 0;
                fastScroller.m8228c(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.f2758A = 2;
                fastScroller2.m8225f();
            }
        }
    }

    /* compiled from: FastScroller.java */
    /* renamed from: a.b.h.k.m0$d */
    /* loaded from: classes.dex */
    public class C0481d implements ValueAnimator.AnimatorUpdateListener {
        public C0481d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f2763c.setAlpha(floatValue);
            FastScroller.this.f2764d.setAlpha(floatValue);
            FastScroller.this.m8225f();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f2763c = stateListDrawable;
        this.f2764d = drawable;
        this.f2767g = stateListDrawable2;
        this.f2768h = drawable2;
        this.f2765e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f2766f = Math.max(i, drawable.getIntrinsicWidth());
        this.f2769i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f2770j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f2761a = i2;
        this.f2762b = i3;
        this.f2763c.setAlpha(255);
        this.f2764d.setAlpha(255);
        this.f2786z.addListener(new C0480c());
        this.f2786z.addUpdateListener(new C0481d());
        m8235a(recyclerView);
    }

    /* renamed from: a */
    public void m8235a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2779s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m8234b();
        }
        this.f2779s = recyclerView;
        if (this.f2779s != null) {
            m8224g();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.InterfaceC0730s
    /* renamed from: a */
    public void mo6596a(boolean z) {
    }

    /* renamed from: b */
    public final void m8234b() {
        this.f2779s.m6907b((RecyclerView.AbstractC0721n) this);
        this.f2779s.m6906b((RecyclerView.InterfaceC0730s) this);
        this.f2779s.m6905b(this.f2760C);
        m8242a();
    }

    /* renamed from: c */
    public void m8228c(int i) {
        if (i == 2 && this.f2782v != 2) {
            this.f2763c.setState(f2756D);
            m8242a();
        }
        if (i == 0) {
            m8225f();
        } else {
            m8223h();
        }
        if (this.f2782v == 2 && i != 2) {
            this.f2763c.setState(f2757E);
            m8231b(1200);
        } else if (i == 1) {
            m8231b(1500);
        }
        this.f2782v = i;
    }

    /* renamed from: d */
    public final int[] m8227d() {
        int[] iArr = this.f2784x;
        int i = this.f2762b;
        iArr[0] = i;
        iArr[1] = this.f2778r - i;
        return iArr;
    }

    /* renamed from: e */
    public final boolean m8226e() {
        return ViewCompat.m9422k(this.f2779s) == 1;
    }

    /* renamed from: f */
    public void m8225f() {
        this.f2779s.invalidate();
    }

    /* renamed from: g */
    public final void m8224g() {
        this.f2779s.m6929a((RecyclerView.AbstractC0721n) this);
        this.f2779s.m6927a((RecyclerView.InterfaceC0730s) this);
        this.f2779s.m6926a(this.f2760C);
    }

    /* renamed from: h */
    public void m8223h() {
        int i = this.f2758A;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.f2786z.cancel();
        }
        this.f2758A = 1;
        ValueAnimator valueAnimator = this.f2786z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2786z.setDuration(500L);
        this.f2786z.setStartDelay(0L);
        this.f2786z.start();
    }

    /* renamed from: b */
    public final void m8231b(int i) {
        m8242a();
        this.f2779s.postDelayed(this.f2759B, i);
    }

    /* renamed from: a */
    public void m8238a(int i) {
        int i2 = this.f2758A;
        if (i2 == 1) {
            this.f2786z.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f2758A = 3;
        ValueAnimator valueAnimator = this.f2786z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f2786z.setDuration(i);
        this.f2786z.start();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0721n
    /* renamed from: b */
    public void mo6710b(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0702a0 c0702a0) {
        if (this.f2777q == this.f2779s.getWidth() && this.f2778r == this.f2779s.getHeight()) {
            if (this.f2758A != 0) {
                if (this.f2780t) {
                    m8230b(canvas);
                }
                if (this.f2781u) {
                    m8236a(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.f2777q = this.f2779s.getWidth();
        this.f2778r = this.f2779s.getHeight();
        m8228c(0);
    }

    /* renamed from: c */
    public final int[] m8229c() {
        int[] iArr = this.f2785y;
        int i = this.f2762b;
        iArr[0] = i;
        iArr[1] = this.f2777q - i;
        return iArr;
    }

    /* renamed from: a */
    public final void m8242a() {
        this.f2779s.removeCallbacks(this.f2759B);
    }

    /* renamed from: a */
    public final void m8236a(Canvas canvas) {
        int i = this.f2778r;
        int i2 = this.f2769i;
        int i3 = i - i2;
        int i4 = this.f2775o;
        int i5 = this.f2774n;
        int i6 = i4 - (i5 / 2);
        this.f2767g.setBounds(0, 0, i5, i2);
        this.f2768h.setBounds(0, 0, this.f2777q, this.f2770j);
        canvas.translate(0.0f, i3);
        this.f2768h.draw(canvas);
        canvas.translate(i6, 0.0f);
        this.f2767g.draw(canvas);
        canvas.translate(-i6, -i3);
    }

    /* renamed from: b */
    public final void m8230b(Canvas canvas) {
        int i = this.f2777q;
        int i2 = this.f2765e;
        int i3 = i - i2;
        int i4 = this.f2772l;
        int i5 = this.f2771k;
        int i6 = i4 - (i5 / 2);
        this.f2763c.setBounds(0, 0, i2, i5);
        this.f2764d.setBounds(0, 0, this.f2766f, this.f2778r);
        if (m8226e()) {
            this.f2764d.draw(canvas);
            canvas.translate(this.f2765e, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f2763c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f2765e, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f2764d.draw(canvas);
        canvas.translate(0.0f, i6);
        this.f2763c.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    /* renamed from: a */
    public void m8237a(int i, int i2) {
        int computeVerticalScrollRange = this.f2779s.computeVerticalScrollRange();
        int i3 = this.f2778r;
        this.f2780t = computeVerticalScrollRange - i3 > 0 && i3 >= this.f2761a;
        int computeHorizontalScrollRange = this.f2779s.computeHorizontalScrollRange();
        int i4 = this.f2777q;
        this.f2781u = computeHorizontalScrollRange - i4 > 0 && i4 >= this.f2761a;
        if (!this.f2780t && !this.f2781u) {
            if (this.f2782v != 0) {
                m8228c(0);
                return;
            }
            return;
        }
        if (this.f2780t) {
            float f = i3;
            this.f2772l = (int) ((f * (i2 + (f / 2.0f))) / computeVerticalScrollRange);
            this.f2771k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.f2781u) {
            float f2 = i4;
            this.f2775o = (int) ((f2 * (i + (f2 / 2.0f))) / computeHorizontalScrollRange);
            this.f2774n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.f2782v;
        if (i5 == 0 || i5 == 1) {
            m8228c(1);
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.InterfaceC0730s
    /* renamed from: b */
    public boolean mo6595b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f2782v;
        if (i == 1) {
            boolean m8232b = m8232b(motionEvent.getX(), motionEvent.getY());
            boolean m8240a = m8240a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!m8232b && !m8240a) {
                return false;
            }
            if (m8240a) {
                this.f2783w = 1;
                this.f2776p = (int) motionEvent.getX();
            } else if (m8232b) {
                this.f2783w = 2;
                this.f2773m = (int) motionEvent.getY();
            }
            m8228c(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.InterfaceC0730s
    /* renamed from: a */
    public void mo6597a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2782v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean m8232b = m8232b(motionEvent.getX(), motionEvent.getY());
            boolean m8240a = m8240a(motionEvent.getX(), motionEvent.getY());
            if (m8232b || m8240a) {
                if (m8240a) {
                    this.f2783w = 1;
                    this.f2776p = (int) motionEvent.getX();
                } else if (m8232b) {
                    this.f2783w = 2;
                    this.f2773m = (int) motionEvent.getY();
                }
                m8228c(2);
            }
        } else if (motionEvent.getAction() == 1 && this.f2782v == 2) {
            this.f2773m = 0.0f;
            this.f2776p = 0.0f;
            m8228c(1);
            this.f2783w = 0;
        } else if (motionEvent.getAction() == 2 && this.f2782v == 2) {
            m8223h();
            if (this.f2783w == 1) {
                m8241a(motionEvent.getX());
            }
            if (this.f2783w == 2) {
                m8233b(motionEvent.getY());
            }
        }
    }

    /* renamed from: b */
    public final void m8233b(float f) {
        int[] m8227d = m8227d();
        float max = Math.max(m8227d[0], Math.min(m8227d[1], f));
        if (Math.abs(this.f2772l - max) < 2.0f) {
            return;
        }
        int m8239a = m8239a(this.f2773m, max, m8227d, this.f2779s.computeVerticalScrollRange(), this.f2779s.computeVerticalScrollOffset(), this.f2778r);
        if (m8239a != 0) {
            this.f2779s.scrollBy(0, m8239a);
        }
        this.f2773m = max;
    }

    /* renamed from: b */
    public boolean m8232b(float f, float f2) {
        if (!m8226e() ? f >= this.f2777q - this.f2765e : f <= this.f2765e / 2) {
            int i = this.f2772l;
            int i2 = this.f2771k;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m8241a(float f) {
        int[] m8229c = m8229c();
        float max = Math.max(m8229c[0], Math.min(m8229c[1], f));
        if (Math.abs(this.f2775o - max) < 2.0f) {
            return;
        }
        int m8239a = m8239a(this.f2776p, max, m8229c, this.f2779s.computeHorizontalScrollRange(), this.f2779s.computeHorizontalScrollOffset(), this.f2777q);
        if (m8239a != 0) {
            this.f2779s.scrollBy(m8239a, 0);
        }
        this.f2776p = max;
    }

    /* renamed from: a */
    public final int m8239a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: a */
    public boolean m8240a(float f, float f2) {
        if (f2 >= this.f2778r - this.f2769i) {
            int i = this.f2775o;
            int i2 = this.f2774n;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }
}
