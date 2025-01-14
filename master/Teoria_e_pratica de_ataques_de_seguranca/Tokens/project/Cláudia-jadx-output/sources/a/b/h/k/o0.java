package a.b.h.k;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class o0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final float f1858a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1859b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1860c;

    /* renamed from: d  reason: collision with root package name */
    public final View f1861d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f1862e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f1863f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1864g;

    /* renamed from: h  reason: collision with root package name */
    public int f1865h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f1866i = new int[2];

    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = o0.this.f1861d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.this.e();
        }
    }

    public o0(View view) {
        this.f1861d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1858a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1859b = ViewConfiguration.getTapTimeout();
        this.f1860c = (this.f1859b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public final void a() {
        Runnable runnable = this.f1863f;
        if (runnable != null) {
            this.f1861d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1862e;
        if (runnable2 != null) {
            this.f1861d.removeCallbacks(runnable2);
        }
    }

    public abstract a.b.h.j.j.t b();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1861d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1865h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1858a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1865h = r6
            java.lang.Runnable r6 = r5.f1862e
            if (r6 != 0) goto L52
            a.b.h.k.o0$a r6 = new a.b.h.k.o0$a
            r6.<init>()
            r5.f1862e = r6
        L52:
            java.lang.Runnable r6 = r5.f1862e
            int r1 = r5.f1859b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1863f
            if (r6 != 0) goto L65
            a.b.h.k.o0$b r6 = new a.b.h.k.o0$b
            r6.<init>()
            r5.f1863f = r6
        L65:
            java.lang.Runnable r6 = r5.f1863f
            int r1 = r5.f1860c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.k.o0.b(android.view.MotionEvent):boolean");
    }

    public abstract boolean c();

    public boolean d() {
        a.b.h.j.j.t b2 = b();
        if (b2 == null || !b2.f()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f1861d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1864g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1864g;
        if (z2) {
            z = a(motionEvent) || !d();
        } else {
            z = b(motionEvent) && c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1861d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1864g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1864g = false;
        this.f1865h = -1;
        Runnable runnable = this.f1862e;
        if (runnable != null) {
            this.f1861d.removeCallbacks(runnable);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        l0 l0Var;
        View view = this.f1861d;
        a.b.h.j.j.t b2 = b();
        if (b2 == null || !b2.f() || (l0Var = (l0) b2.e()) == null || !l0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a(view, obtainNoHistory);
        b(l0Var, obtainNoHistory);
        boolean a2 = l0Var.a(obtainNoHistory, this.f1865h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a2 && (actionMasked != 1 && actionMasked != 3);
    }

    public static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1866i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    public final boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1866i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }
}
