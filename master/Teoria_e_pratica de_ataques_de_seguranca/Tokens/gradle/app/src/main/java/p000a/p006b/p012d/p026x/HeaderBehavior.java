package p000a.p006b.p012d.p026x;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.d.x.i */
/* loaded from: classes.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: d */
    public Runnable f671d;

    /* renamed from: e */
    public OverScroller f672e;

    /* renamed from: f */
    public boolean f673f;

    /* renamed from: g */
    public int f674g;

    /* renamed from: h */
    public int f675h;

    /* renamed from: i */
    public int f676i;

    /* renamed from: j */
    public VelocityTracker f677j;

    /* compiled from: HeaderBehavior.java */
    /* renamed from: a.b.d.x.i$a */
    /* loaded from: classes.dex */
    public class RunnableC0074a implements Runnable {

        /* renamed from: a */
        public final CoordinatorLayout f678a;

        /* renamed from: b */
        public final V f679b;

        public RunnableC0074a(CoordinatorLayout coordinatorLayout, V v) {
            this.f678a = coordinatorLayout;
            this.f679b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f679b == null || (overScroller = HeaderBehavior.this.f672e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = HeaderBehavior.this;
                headerBehavior.m10738c(this.f678a, (CoordinatorLayout) this.f679b, headerBehavior.f672e.getCurrY());
                ViewCompat.m9445a(this.f679b, this);
                return;
            }
            HeaderBehavior.this.mo7816e(this.f678a, this.f679b);
        }
    }

    public HeaderBehavior() {
        this.f674g = -1;
        this.f676i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo7608a(android.support.design.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f676i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f676i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f673f
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
            int r6 = r4.f674g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f675h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f676i
            if (r6 <= r0) goto L83
            r4.f673f = r2
            r4.f675h = r5
            goto L83
        L51:
            r4.f673f = r3
            r4.f674g = r5
            android.view.VelocityTracker r5 = r4.f677j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.f677j = r5
            goto L83
        L60:
            r4.f673f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.mo7828a(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.m7744a(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f675h = r1
            int r5 = r7.getPointerId(r3)
            r4.f674g = r5
            r4.m10739c()
        L83:
            android.view.VelocityTracker r5 = r4.f677j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f673f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p012d.p026x.HeaderBehavior.mo7608a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public abstract boolean mo7828a(V v);

    /* renamed from: b */
    public abstract int mo7824b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* renamed from: b */
    public abstract int mo7823b(V v);

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo7602b(android.support.design.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f676i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f676i = r0
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
            int r0 = r11.f674g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f675h
            int r2 = r2 - r0
            boolean r3 = r11.f673f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f676i
            if (r3 <= r4) goto L49
            r11.f673f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f673f
            if (r2 == 0) goto Lae
            r11.f675h = r0
            int r7 = r11.mo7823b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.m10740a(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.f677j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f677j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f677j
            int r4 = r11.f674g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.mo7819c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.m10741a(r6, r7, r8, r9, r10)
        L7e:
            r11.f673f = r2
            r11.f674g = r3
            android.view.VelocityTracker r12 = r11.f677j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.f677j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.m7744a(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.mo7828a(r13)
            if (r12 == 0) goto Lb6
            r11.f675h = r3
            int r12 = r14.getPointerId(r2)
            r11.f674g = r12
            r11.m10739c()
        Lae:
            android.view.VelocityTracker r12 = r11.f677j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p012d.p026x.HeaderBehavior.mo7602b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: c */
    public int m10738c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo7824b(coordinatorLayout, (CoordinatorLayout) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: c */
    public abstract int mo7819c(V v);

    /* renamed from: d */
    public abstract int mo7818d();

    /* renamed from: e */
    public abstract void mo7816e(CoordinatorLayout coordinatorLayout, V v);

    /* renamed from: c */
    public final void m10739c() {
        if (this.f677j == null) {
            this.f677j = VelocityTracker.obtain();
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f674g = -1;
        this.f676i = -1;
    }

    /* renamed from: a */
    public final int m10740a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo7824b(coordinatorLayout, (CoordinatorLayout) v, mo7818d() - i, i2, i3);
    }

    /* renamed from: a */
    public final boolean m10741a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.f671d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f671d = null;
        }
        if (this.f672e == null) {
            this.f672e = new OverScroller(v.getContext());
        }
        this.f672e.fling(0, m10657b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f672e.computeScrollOffset()) {
            this.f671d = new RunnableC0074a(coordinatorLayout, v);
            ViewCompat.m9445a(v, this.f671d);
            return true;
        }
        mo7816e(coordinatorLayout, v);
        return false;
    }
}
