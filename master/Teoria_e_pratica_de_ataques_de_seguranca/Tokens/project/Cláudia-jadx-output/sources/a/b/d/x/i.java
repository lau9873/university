package a.b.d.x;

import a.b.g.k.u;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
public abstract class i<V extends View> extends q<V> {

    /* renamed from: d  reason: collision with root package name */
    public Runnable f348d;

    /* renamed from: e  reason: collision with root package name */
    public OverScroller f349e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f350f;

    /* renamed from: g  reason: collision with root package name */
    public int f351g;

    /* renamed from: h  reason: collision with root package name */
    public int f352h;

    /* renamed from: i  reason: collision with root package name */
    public int f353i;
    public VelocityTracker j;

    /* compiled from: HeaderBehavior.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final CoordinatorLayout f354a;

        /* renamed from: b  reason: collision with root package name */
        public final V f355b;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f354a = coordinatorLayout;
            this.f355b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f355b == null || (overScroller = i.this.f349e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                i iVar = i.this;
                iVar.c(this.f354a, (CoordinatorLayout) this.f355b, iVar.f349e.getCurrY());
                u.a(this.f355b, this);
                return;
            }
            i.this.e(this.f354a, this.f355b);
        }
    }

    public i() {
        this.f351g = -1;
        this.f353i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // android.support.design.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.support.design.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f353i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f353i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f350f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.f351g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f352h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f353i
            if (r6 <= r0) goto L83
            r4.f350f = r2
            r4.f352h = r5
            goto L83
        L51:
            r4.f350f = r3
            r4.f351g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.j = r5
            goto L83
        L60:
            r4.f350f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.a(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.a(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f352h = r1
            int r5 = r7.getPointerId(r3)
            r4.f351g = r5
            r4.c()
        L83:
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f350f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.x.i.a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract boolean a(V v);

    public abstract int b(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    public abstract int b(V v);

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // android.support.design.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(android.support.design.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f353i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f353i = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            r3 = -1
            if (r0 == r1) goto L5c
            r4 = 2
            if (r0 == r4) goto L25
            r12 = 3
            if (r0 == r12) goto L7e
            goto Lae
        L25:
            int r0 = r11.f351g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f352h
            int r2 = r2 - r0
            boolean r3 = r11.f350f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f353i
            if (r3 <= r4) goto L49
            r11.f350f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f350f
            if (r2 == 0) goto Lae
            r11.f352h = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.a(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.j
            int r4 = r11.f351g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
        L7e:
            r11.f350f = r2
            r11.f351g = r3
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.a(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.a(r13)
            if (r12 == 0) goto Lb6
            r11.f352h = r3
            int r12 = r14.getPointerId(r2)
            r11.f351g = r12
            r11.c()
        Lae:
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.d.x.i.b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public int c(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return b(coordinatorLayout, (CoordinatorLayout) v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int c(V v);

    public abstract int d();

    public abstract void e(CoordinatorLayout coordinatorLayout, V v);

    public final void c() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f351g = -1;
        this.f353i = -1;
    }

    public final int a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return b(coordinatorLayout, (CoordinatorLayout) v, d() - i2, i3, i4);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.f348d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f348d = null;
        }
        if (this.f349e == null) {
            this.f349e = new OverScroller(v.getContext());
        }
        this.f349e.fling(0, b(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f349e.computeScrollOffset()) {
            this.f348d = new a(coordinatorLayout, v);
            u.a(v, this.f348d);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }
}
