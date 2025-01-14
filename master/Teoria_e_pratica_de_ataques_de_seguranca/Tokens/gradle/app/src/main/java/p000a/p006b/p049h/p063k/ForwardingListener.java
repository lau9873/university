package p000a.p006b.p049h.p063k;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import p000a.p006b.p049h.p061j.p062j.ShowableListMenu;

/* renamed from: a.b.h.k.o0 */
/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final float f2820a;

    /* renamed from: b */
    public final int f2821b;

    /* renamed from: c */
    public final int f2822c;

    /* renamed from: d */
    public final View f2823d;

    /* renamed from: e */
    public Runnable f2824e;

    /* renamed from: f */
    public Runnable f2825f;

    /* renamed from: g */
    public boolean f2826g;

    /* renamed from: h */
    public int f2827h;

    /* renamed from: i */
    public final int[] f2828i = new int[2];

    /* compiled from: ForwardingListener.java */
    /* renamed from: a.b.h.k.o0$a */
    /* loaded from: classes.dex */
    public class RunnableC0485a implements Runnable {
        public RunnableC0485a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f2823d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: a.b.h.k.o0$b */
    /* loaded from: classes.dex */
    public class RunnableC0486b implements Runnable {
        public RunnableC0486b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.m8163e();
        }
    }

    public ForwardingListener(View view) {
        this.f2823d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2820a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f2821b = ViewConfiguration.getTapTimeout();
        this.f2822c = (this.f2821b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: a */
    public final void m8170a() {
        Runnable runnable = this.f2825f;
        if (runnable != null) {
            this.f2823d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2824e;
        if (runnable2 != null) {
            this.f2823d.removeCallbacks(runnable2);
        }
    }

    /* renamed from: b */
    public abstract ShowableListMenu mo7141b();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m8166b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2823d
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
            int r1 = r5.f2827h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f2820a
            boolean r6 = m8168a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.m8170a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.m8170a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2827h = r6
            java.lang.Runnable r6 = r5.f2824e
            if (r6 != 0) goto L52
            a.b.h.k.o0$a r6 = new a.b.h.k.o0$a
            r6.<init>()
            r5.f2824e = r6
        L52:
            java.lang.Runnable r6 = r5.f2824e
            int r1 = r5.f2821b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2825f
            if (r6 != 0) goto L65
            a.b.h.k.o0$b r6 = new a.b.h.k.o0$b
            r6.<init>()
            r5.f2825f = r6
        L65:
            java.lang.Runnable r6 = r5.f2825f
            int r1 = r5.f2822c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.ForwardingListener.m8166b(android.view.MotionEvent):boolean");
    }

    /* renamed from: c */
    public abstract boolean mo7140c();

    /* renamed from: d */
    public boolean mo8164d() {
        ShowableListMenu mo7141b = mo7141b();
        if (mo7141b == null || !mo7141b.mo8079f()) {
            return true;
        }
        mo7141b.dismiss();
        return true;
    }

    /* renamed from: e */
    public void m8163e() {
        m8170a();
        View view = this.f2823d;
        if (view.isEnabled() && !view.isLongClickable() && mo7140c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f2826g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f2826g;
        if (z2) {
            z = m8169a(motionEvent) || !mo8164d();
        } else {
            z = m8166b(motionEvent) && mo7140c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2823d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f2826g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2826g = false;
        this.f2827h = -1;
        Runnable runnable = this.f2824e;
        if (runnable != null) {
            this.f2823d.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    public final boolean m8169a(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f2823d;
        ShowableListMenu mo7141b = mo7141b();
        if (mo7141b == null || !mo7141b.mo8079f() || (dropDownListView = (DropDownListView) mo7141b.mo8081e()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m8167a(view, obtainNoHistory);
        m8165b(dropDownListView, obtainNoHistory);
        boolean m8274a = dropDownListView.m8274a(obtainNoHistory, this.f2827h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return m8274a && (actionMasked != 1 && actionMasked != 3);
    }

    /* renamed from: a */
    public static boolean m8168a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: a */
    public final boolean m8167a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2828i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* renamed from: b */
    public final boolean m8165b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2828i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }
}
