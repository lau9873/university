package p000a.p006b.p030g.p048l;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.g.l.s */
/* loaded from: classes.dex */
public class ViewDragHelper {

    /* renamed from: w */
    public static final Interpolator f1846w = new animationInterpolatorC0318a();

    /* renamed from: a */
    public int f1847a;

    /* renamed from: b */
    public int f1848b;

    /* renamed from: d */
    public float[] f1850d;

    /* renamed from: e */
    public float[] f1851e;

    /* renamed from: f */
    public float[] f1852f;

    /* renamed from: g */
    public float[] f1853g;

    /* renamed from: h */
    public int[] f1854h;

    /* renamed from: i */
    public int[] f1855i;

    /* renamed from: j */
    public int[] f1856j;

    /* renamed from: k */
    public int f1857k;

    /* renamed from: l */
    public VelocityTracker f1858l;

    /* renamed from: m */
    public float f1859m;

    /* renamed from: n */
    public float f1860n;

    /* renamed from: o */
    public int f1861o;

    /* renamed from: p */
    public int f1862p;

    /* renamed from: q */
    public OverScroller f1863q;

    /* renamed from: r */
    public final AbstractC0320c f1864r;

    /* renamed from: s */
    public View f1865s;

    /* renamed from: t */
    public boolean f1866t;

    /* renamed from: u */
    public final ViewGroup f1867u;

    /* renamed from: c */
    public int f1849c = -1;

    /* renamed from: v */
    public final Runnable f1868v = new RunnableC0319b();

    /* compiled from: ViewDragHelper.java */
    /* renamed from: a.b.g.l.s$a  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class animationInterpolatorC0318a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* renamed from: a.b.g.l.s$b */
    /* loaded from: classes.dex */
    public class RunnableC0319b implements Runnable {
        public RunnableC0319b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.m9163e(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* renamed from: a.b.g.l.s$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0320c {
        /* renamed from: a */
        public int m9162a(int i) {
            return i;
        }

        /* renamed from: a */
        public int mo7601a(View view) {
            return 0;
        }

        /* renamed from: a */
        public abstract int mo7597a(View view, int i, int i2);

        /* renamed from: a */
        public void m9161a(int i, int i2) {
        }

        /* renamed from: a */
        public abstract void mo7599a(View view, float f, float f2);

        /* renamed from: a */
        public void mo7598a(View view, int i) {
        }

        /* renamed from: a */
        public abstract void mo7596a(View view, int i, int i2, int i3, int i4);

        /* renamed from: b */
        public int mo7756b(View view) {
            return 0;
        }

        /* renamed from: b */
        public abstract int mo7594b(View view, int i, int i2);

        /* renamed from: b */
        public void m9159b(int i, int i2) {
        }

        /* renamed from: b */
        public boolean m9160b(int i) {
            return false;
        }

        /* renamed from: b */
        public abstract boolean mo7595b(View view, int i);

        /* renamed from: c */
        public abstract void mo7593c(int i);
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, AbstractC0320c abstractC0320c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0320c != null) {
            this.f1867u = viewGroup;
            this.f1864r = abstractC0320c;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1861o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1848b = viewConfiguration.getScaledTouchSlop();
            this.f1859m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1860n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1863q = new OverScroller(context, f1846w);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    /* renamed from: a */
    public static ViewDragHelper m9181a(ViewGroup viewGroup, AbstractC0320c abstractC0320c) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, abstractC0320c);
    }

    /* renamed from: b */
    public boolean m9171b(View view, int i, int i2) {
        this.f1865s = view;
        this.f1849c = -1;
        boolean m9174b = m9174b(i, i2, 0, 0);
        if (!m9174b && this.f1847a == 0 && this.f1865s != null) {
            this.f1865s = null;
        }
        return m9174b;
    }

    /* renamed from: c */
    public int m9170c() {
        return this.f1848b;
    }

    /* renamed from: d */
    public boolean m9164d(int i, int i2) {
        if (this.f1866t) {
            return m9174b(i, i2, (int) this.f1858l.getXVelocity(this.f1849c), (int) this.f1858l.getYVelocity(this.f1849c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: e */
    public void m9163e(int i) {
        this.f1867u.removeCallbacks(this.f1868v);
        if (this.f1847a != i) {
            this.f1847a = i;
            this.f1864r.mo7593c(i);
            if (this.f1847a == 0) {
                this.f1865s = null;
            }
        }
    }

    /* renamed from: a */
    public static ViewDragHelper m9182a(ViewGroup viewGroup, float f, AbstractC0320c abstractC0320c) {
        ViewDragHelper m9181a = m9181a(viewGroup, abstractC0320c);
        m9181a.f1848b = (int) (m9181a.f1848b * (1.0f / f));
        return m9181a;
    }

    /* renamed from: c */
    public boolean m9169c(int i) {
        return ((1 << i) & this.f1857k) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m9167c(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p048l.ViewDragHelper.m9167c(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public void m9185a(View view, int i) {
        if (view.getParent() == this.f1867u) {
            this.f1865s = view;
            this.f1849c = i;
            this.f1864r.mo7598a(view, i);
            m9163e(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1867u + ")");
    }

    /* renamed from: b */
    public final boolean m9174b(int i, int i2, int i3, int i4) {
        int left = this.f1865s.getLeft();
        int top = this.f1865s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1863q.abortAnimation();
            m9163e(0);
            return false;
        }
        this.f1863q.startScroll(left, top, i5, i6, m9183a(this.f1865s, i5, i6, i3, i4));
        m9163e(2);
        return true;
    }

    /* renamed from: d */
    public final void m9166d() {
        this.f1858l.computeCurrentVelocity(1000, this.f1859m);
        m9195a(m9194a(this.f1858l.getXVelocity(this.f1849c), this.f1860n, this.f1859m), m9194a(this.f1858l.getYVelocity(this.f1849c), this.f1860n, this.f1859m));
    }

    /* renamed from: a */
    public void m9197a() {
        this.f1849c = -1;
        m9179b();
        VelocityTracker velocityTracker = this.f1858l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1858l = null;
        }
    }

    /* renamed from: b */
    public final int m9175b(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.f1867u.getWidth();
        float f = width / 2;
        float m9196a = f + (m9196a(Math.min(1.0f, Math.abs(i) / width)) * f);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m9196a / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* renamed from: a */
    public final int m9183a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int m9189a = m9189a(i3, (int) this.f1860n, (int) this.f1859m);
        int m9189a2 = m9189a(i4, (int) this.f1860n, (int) this.f1859m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(m9189a);
        int abs4 = Math.abs(m9189a2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (m9189a != 0) {
            f = abs3;
            f2 = i5;
        } else {
            f = abs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (m9189a2 != 0) {
            f3 = abs4;
            f4 = i5;
        } else {
            f3 = abs2;
            f4 = i6;
        }
        return (int) ((m9175b(i, m9189a, this.f1864r.mo7601a(view)) * f5) + (m9175b(i2, m9189a2, this.f1864r.mo7756b(view)) * (f3 / f4)));
    }

    /* renamed from: d */
    public final boolean m9165d(int i) {
        if (m9169c(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: b */
    public final void m9179b() {
        float[] fArr = this.f1850d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1851e, 0.0f);
        Arrays.fill(this.f1852f, 0.0f);
        Arrays.fill(this.f1853g, 0.0f);
        Arrays.fill(this.f1854h, 0);
        Arrays.fill(this.f1855i, 0);
        Arrays.fill(this.f1856j, 0);
        this.f1857k = 0;
    }

    /* renamed from: a */
    public final int m9189a(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    /* renamed from: a */
    public final float m9194a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    /* renamed from: a */
    public final float m9196a(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* renamed from: a */
    public boolean m9180a(boolean z) {
        if (this.f1847a == 2) {
            boolean computeScrollOffset = this.f1863q.computeScrollOffset();
            int currX = this.f1863q.getCurrX();
            int currY = this.f1863q.getCurrY();
            int left = currX - this.f1865s.getLeft();
            int top = currY - this.f1865s.getTop();
            if (left != 0) {
                ViewCompat.m9435c(this.f1865s, left);
            }
            if (top != 0) {
                ViewCompat.m9433d(this.f1865s, top);
            }
            if (left != 0 || top != 0) {
                this.f1864r.mo7596a(this.f1865s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1863q.getFinalX() && currY == this.f1863q.getFinalY()) {
                this.f1863q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f1867u.post(this.f1868v);
                } else {
                    m9163e(0);
                }
            }
        }
        return this.f1847a == 2;
    }

    /* renamed from: b */
    public final void m9177b(int i) {
        float[] fArr = this.f1850d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f1850d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1851e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f1852f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f1853g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f1854h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1855i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1856j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1850d = fArr2;
            this.f1851e = fArr3;
            this.f1852f = fArr4;
            this.f1853g = fArr5;
            this.f1854h = iArr;
            this.f1855i = iArr2;
            this.f1856j = iArr3;
        }
    }

    /* renamed from: a */
    public final void m9195a(float f, float f2) {
        this.f1866t = true;
        this.f1864r.mo7599a(this.f1865s, f, f2);
        this.f1866t = false;
        if (this.f1847a == 1) {
            m9163e(0);
        }
    }

    /* renamed from: a */
    public final void m9191a(int i) {
        if (this.f1850d == null || !m9169c(i)) {
            return;
        }
        this.f1850d[i] = 0.0f;
        this.f1851e[i] = 0.0f;
        this.f1852f[i] = 0.0f;
        this.f1853g[i] = 0.0f;
        this.f1854h[i] = 0;
        this.f1855i[i] = 0;
        this.f1856j[i] = 0;
        this.f1857k = (~(1 << i)) & this.f1857k;
    }

    /* renamed from: b */
    public final void m9178b(float f, float f2, int i) {
        m9177b(i);
        float[] fArr = this.f1850d;
        this.f1852f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f1851e;
        this.f1853g[i] = f2;
        fArr2[i] = f2;
        this.f1854h[i] = m9176b((int) f, (int) f2);
        this.f1857k |= 1 << i;
    }

    /* renamed from: a */
    public void m9187a(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m9197a();
        }
        if (this.f1858l == null) {
            this.f1858l = VelocityTracker.obtain();
        }
        this.f1858l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View m9190a = m9190a((int) x, (int) y);
            m9178b(x, y, pointerId);
            m9172b(m9190a, pointerId);
            int i3 = this.f1854h[pointerId];
            int i4 = this.f1862p;
            if ((i3 & i4) != 0) {
                this.f1864r.m9159b(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1847a == 1) {
                m9166d();
            }
            m9197a();
        } else if (actionMasked == 2) {
            if (this.f1847a == 1) {
                if (m9165d(this.f1849c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1849c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f1852f;
                    int i5 = this.f1849c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f1853g[i5]);
                    m9188a(this.f1865s.getLeft() + i6, this.f1865s.getTop() + i7, i6, i7);
                    m9173b(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (m9165d(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f1850d[pointerId2];
                    float f2 = y3 - this.f1851e[pointerId2];
                    m9193a(f, f2, pointerId2);
                    if (this.f1847a != 1) {
                        View m9190a2 = m9190a((int) x3, (int) y3);
                        if (m9186a(m9190a2, f, f2) && m9172b(m9190a2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m9173b(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f1847a == 1) {
                m9195a(0.0f, 0.0f);
            }
            m9197a();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            m9178b(x4, y4, pointerId3);
            if (this.f1847a == 0) {
                m9172b(m9190a((int) x4, (int) y4), pointerId3);
                int i8 = this.f1854h[pointerId3];
                int i9 = this.f1862p;
                if ((i8 & i9) != 0) {
                    this.f1864r.m9159b(i8 & i9, pointerId3);
                }
            } else if (m9168c((int) x4, (int) y4)) {
                m9172b(this.f1865s, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f1847a == 1 && pointerId4 == this.f1849c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i2);
                    if (pointerId5 != this.f1849c) {
                        View m9190a3 = m9190a((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.f1865s;
                        if (m9190a3 == view && m9172b(view, pointerId5)) {
                            i = this.f1849c;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    m9166d();
                }
            }
            m9191a(pointerId4);
        }
    }

    /* renamed from: c */
    public boolean m9168c(int i, int i2) {
        return m9184a(this.f1865s, i, i2);
    }

    /* renamed from: b */
    public final void m9173b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m9165d(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1852f[pointerId] = x;
                this.f1853g[pointerId] = y;
            }
        }
    }

    /* renamed from: b */
    public boolean m9172b(View view, int i) {
        if (view == this.f1865s && this.f1849c == i) {
            return true;
        }
        if (view == null || !this.f1864r.mo7595b(view, i)) {
            return false;
        }
        this.f1849c = i;
        m9185a(view, i);
        return true;
    }

    /* renamed from: b */
    public final int m9176b(int i, int i2) {
        int i3 = i < this.f1867u.getLeft() + this.f1861o ? 1 : 0;
        if (i2 < this.f1867u.getTop() + this.f1861o) {
            i3 |= 4;
        }
        if (i > this.f1867u.getRight() - this.f1861o) {
            i3 |= 2;
        }
        return i2 > this.f1867u.getBottom() - this.f1861o ? i3 | 8 : i3;
    }

    /* renamed from: a */
    public final void m9193a(float f, float f2, int i) {
        int i2 = m9192a(f, f2, i, 1) ? 1 : 0;
        if (m9192a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m9192a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m9192a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1855i;
            iArr[i] = iArr[i] | i2;
            this.f1864r.m9161a(i2, i);
        }
    }

    /* renamed from: a */
    public final boolean m9192a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1854h[i] & i2) != i2 || (this.f1862p & i2) == 0 || (this.f1856j[i] & i2) == i2 || (this.f1855i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f1848b;
        if (abs > i3 || abs2 > i3) {
            if (abs >= abs2 * 0.5f || !this.f1864r.m9160b(i2)) {
                return (this.f1855i[i] & i2) == 0 && abs > ((float) this.f1848b);
            }
            int[] iArr = this.f1856j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m9186a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1864r.mo7601a(view) > 0;
        boolean z2 = this.f1864r.mo7756b(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f1848b) : z2 && Math.abs(f2) > ((float) this.f1848b);
        }
        int i = this.f1848b;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    /* renamed from: a */
    public final void m9188a(int i, int i2, int i3, int i4) {
        int left = this.f1865s.getLeft();
        int top = this.f1865s.getTop();
        if (i3 != 0) {
            i = this.f1864r.mo7597a(this.f1865s, i, i3);
            ViewCompat.m9435c(this.f1865s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f1864r.mo7594b(this.f1865s, i2, i4);
            ViewCompat.m9433d(this.f1865s, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f1864r.mo7596a(this.f1865s, i5, i6, i5 - left, i6 - top);
    }

    /* renamed from: a */
    public boolean m9184a(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: a */
    public View m9190a(int i, int i2) {
        for (int childCount = this.f1867u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.f1867u;
            this.f1864r.m9162a(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
