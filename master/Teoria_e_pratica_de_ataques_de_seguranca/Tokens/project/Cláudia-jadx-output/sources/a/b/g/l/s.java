package a.b.g.l;

import a.b.g.k.u;
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
/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class s {
    public static final Interpolator w = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f1259a;

    /* renamed from: b  reason: collision with root package name */
    public int f1260b;

    /* renamed from: d  reason: collision with root package name */
    public float[] f1262d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f1263e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1264f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1265g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f1266h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1267i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public OverScroller q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;

    /* renamed from: c  reason: collision with root package name */
    public int f1261c = -1;
    public final Runnable v = new b();

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.e(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* loaded from: classes.dex */
    public static abstract class c {
        public int a(int i2) {
            return i2;
        }

        public int a(View view) {
            return 0;
        }

        public abstract int a(View view, int i2, int i3);

        public void a(int i2, int i3) {
        }

        public abstract void a(View view, float f2, float f3);

        public void a(View view, int i2) {
        }

        public abstract void a(View view, int i2, int i3, int i4, int i5);

        public int b(View view) {
            return 0;
        }

        public abstract int b(View view, int i2, int i3);

        public void b(int i2, int i3) {
        }

        public boolean b(int i2) {
            return false;
        }

        public abstract boolean b(View view, int i2);

        public abstract void c(int i2);
    }

    public s(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar != null) {
            this.u = viewGroup;
            this.r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1260b = viewConfiguration.getScaledTouchSlop();
            this.m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = new OverScroller(context, w);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public static s a(ViewGroup viewGroup, c cVar) {
        return new s(viewGroup.getContext(), viewGroup, cVar);
    }

    public boolean b(View view, int i2, int i3) {
        this.s = view;
        this.f1261c = -1;
        boolean b2 = b(i2, i3, 0, 0);
        if (!b2 && this.f1259a == 0 && this.s != null) {
            this.s = null;
        }
        return b2;
    }

    public int c() {
        return this.f1260b;
    }

    public boolean d(int i2, int i3) {
        if (this.t) {
            return b(i2, i3, (int) this.l.getXVelocity(this.f1261c), (int) this.l.getYVelocity(this.f1261c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public void e(int i2) {
        this.u.removeCallbacks(this.v);
        if (this.f1259a != i2) {
            this.f1259a = i2;
            this.r.c(i2);
            if (this.f1259a == 0) {
                this.s = null;
            }
        }
    }

    public static s a(ViewGroup viewGroup, float f2, c cVar) {
        s a2 = a(viewGroup, cVar);
        a2.f1260b = (int) (a2.f1260b * (1.0f / f2));
        return a2;
    }

    public boolean c(int i2) {
        return ((1 << i2) & this.k) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.l.s.c(android.view.MotionEvent):boolean");
    }

    public void a(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.f1261c = i2;
            this.r.a(view, i2);
            e(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public final boolean b(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.abortAnimation();
            e(0);
            return false;
        }
        this.q.startScroll(left, top, i6, i7, a(this.s, i6, i7, i4, i5));
        e(2);
        return true;
    }

    public final void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f1261c), this.n, this.m), a(this.l.getYVelocity(this.f1261c), this.n, this.m));
    }

    public void a() {
        this.f1261c = -1;
        b();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public final int b(int i2, int i3, int i4) {
        int abs;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = width / 2;
        float a2 = f2 + (a(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public final int a(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int a2 = a(i4, (int) this.n, (int) this.m);
        int a3 = a(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(a2);
        int abs4 = Math.abs(a3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (a2 != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (a3 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((b(i2, a2, this.r.a(view)) * f6) + (b(i3, a3, this.r.b(view)) * (f4 / f5)));
    }

    public final boolean d(int i2) {
        if (c(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void b() {
        float[] fArr = this.f1262d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1263e, 0.0f);
        Arrays.fill(this.f1264f, 0.0f);
        Arrays.fill(this.f1265g, 0.0f);
        Arrays.fill(this.f1266h, 0);
        Arrays.fill(this.f1267i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    public final int a(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    public final float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public final float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public boolean a(boolean z) {
        if (this.f1259a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                u.c(this.s, left);
            }
            if (top != 0) {
                u.d(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.a(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    e(0);
                }
            }
        }
        return this.f1259a == 2;
    }

    public final void b(int i2) {
        float[] fArr = this.f1262d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            float[] fArr6 = this.f1262d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1263e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f1264f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f1265g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f1266h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1267i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1262d = fArr2;
            this.f1263e = fArr3;
            this.f1264f = fArr4;
            this.f1265g = fArr5;
            this.f1266h = iArr;
            this.f1267i = iArr2;
            this.j = iArr3;
        }
    }

    public final void a(float f2, float f3) {
        this.t = true;
        this.r.a(this.s, f2, f3);
        this.t = false;
        if (this.f1259a == 1) {
            e(0);
        }
    }

    public final void a(int i2) {
        if (this.f1262d == null || !c(i2)) {
            return;
        }
        this.f1262d[i2] = 0.0f;
        this.f1263e[i2] = 0.0f;
        this.f1264f[i2] = 0.0f;
        this.f1265g[i2] = 0.0f;
        this.f1266h[i2] = 0;
        this.f1267i[i2] = 0;
        this.j[i2] = 0;
        this.k = (~(1 << i2)) & this.k;
    }

    public final void b(float f2, float f3, int i2) {
        b(i2);
        float[] fArr = this.f1262d;
        this.f1264f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f1263e;
        this.f1265g[i2] = f3;
        fArr2[i2] = f3;
        this.f1266h[i2] = b((int) f2, (int) f3);
        this.k |= 1 << i2;
    }

    public void a(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View a2 = a((int) x, (int) y);
            b(x, y, pointerId);
            b(a2, pointerId);
            int i4 = this.f1266h[pointerId];
            int i5 = this.p;
            if ((i4 & i5) != 0) {
                this.r.b(i4 & i5, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f1259a == 1) {
                d();
            }
            a();
        } else if (actionMasked == 2) {
            if (this.f1259a == 1) {
                if (d(this.f1261c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1261c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f1264f;
                    int i6 = this.f1261c;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.f1265g[i6]);
                    a(this.s.getLeft() + i7, this.s.getTop() + i8, i7, i8);
                    b(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (d(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f1262d[pointerId2];
                    float f3 = y3 - this.f1263e[pointerId2];
                    a(f2, f3, pointerId2);
                    if (this.f1259a != 1) {
                        View a3 = a((int) x3, (int) y3);
                        if (a(a3, f2, f3) && b(a3, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            b(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f1259a == 1) {
                a(0.0f, 0.0f);
            }
            a();
        } else if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            b(x4, y4, pointerId3);
            if (this.f1259a == 0) {
                b(a((int) x4, (int) y4), pointerId3);
                int i9 = this.f1266h[pointerId3];
                int i10 = this.p;
                if ((i9 & i10) != 0) {
                    this.r.b(i9 & i10, pointerId3);
                }
            } else if (c((int) x4, (int) y4)) {
                b(this.s, pointerId3);
            }
        } else if (actionMasked != 6) {
        } else {
            int pointerId4 = motionEvent.getPointerId(actionIndex);
            if (this.f1259a == 1 && pointerId4 == this.f1261c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i3 >= pointerCount2) {
                        i2 = -1;
                        break;
                    }
                    int pointerId5 = motionEvent.getPointerId(i3);
                    if (pointerId5 != this.f1261c) {
                        View a4 = a((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                        View view = this.s;
                        if (a4 == view && b(view, pointerId5)) {
                            i2 = this.f1261c;
                            break;
                        }
                    }
                    i3++;
                }
                if (i2 == -1) {
                    d();
                }
            }
            a(pointerId4);
        }
    }

    public boolean c(int i2, int i3) {
        return a(this.s, i2, i3);
    }

    public final void b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (d(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f1264f[pointerId] = x;
                this.f1265g[pointerId] = y;
            }
        }
    }

    public boolean b(View view, int i2) {
        if (view == this.s && this.f1261c == i2) {
            return true;
        }
        if (view == null || !this.r.b(view, i2)) {
            return false;
        }
        this.f1261c = i2;
        a(view, i2);
        return true;
    }

    public final int b(int i2, int i3) {
        int i4 = i2 < this.u.getLeft() + this.o ? 1 : 0;
        if (i3 < this.u.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.u.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.u.getBottom() - this.o ? i4 | 8 : i4;
    }

    public final void a(float f2, float f3, int i2) {
        int i3 = a(f2, f3, i2, 1) ? 1 : 0;
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f1267i;
            iArr[i2] = iArr[i2] | i3;
            this.r.a(i3, i2);
        }
    }

    public final boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f1266h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.j[i2] & i3) == i3 || (this.f1267i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f1260b;
        if (abs > i4 || abs2 > i4) {
            if (abs >= abs2 * 0.5f || !this.r.b(i3)) {
                return (this.f1267i[i2] & i3) == 0 && abs > ((float) this.f1260b);
            }
            int[] iArr = this.j;
            iArr[i2] = iArr[i2] | i3;
            return false;
        }
        return false;
    }

    public final boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.a(view) > 0;
        boolean z2 = this.r.b(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f1260b) : z2 && Math.abs(f3) > ((float) this.f1260b);
        }
        int i2 = this.f1260b;
        return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
    }

    public final void a(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i4 != 0) {
            i2 = this.r.a(this.s, i2, i4);
            u.c(this.s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.r.b(this.s, i3, i5);
            u.d(this.s, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.r.a(this.s, i6, i7, i6 - left, i7 - top);
    }

    public boolean a(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public View a(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            this.r.a(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
