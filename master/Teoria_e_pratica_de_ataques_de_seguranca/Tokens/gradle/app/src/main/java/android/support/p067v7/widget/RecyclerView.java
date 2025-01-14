package android.support.p067v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.j256.ormlite.logger.Logger;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.p006b.p030g.p041g.TraceCompat;
import p000a.p006b.p030g.p044j.Preconditions;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.MotionEventCompat;
import p000a.p006b.p030g.p045k.NestedScrollingChild2;
import p000a.p006b.p030g.p045k.NestedScrollingChildHelper;
import p000a.p006b.p030g.p045k.ScrollingView;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.ViewConfigurationCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityEventCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p058g.C0406a;
import p000a.p006b.p049h.p058g.C0407b;
import p000a.p006b.p049h.p063k.AdapterHelper;
import p000a.p006b.p049h.p063k.ChildHelper;
import p000a.p006b.p049h.p063k.DefaultItemAnimator;
import p000a.p006b.p049h.p063k.FastScroller;
import p000a.p006b.p049h.p063k.GapWorker;
import p000a.p006b.p049h.p063k.RecyclerViewAccessibilityDelegate;
import p000a.p006b.p049h.p063k.ViewBoundsCheck;
import p000a.p006b.p049h.p063k.ViewInfoStore;

/* renamed from: android.support.v7.widget.RecyclerView */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2 {

    /* renamed from: A0 */
    public static final int[] f4101A0 = {16843830};

    /* renamed from: B0 */
    public static final int[] f4102B0 = {16842987};

    /* renamed from: C0 */
    public static final boolean f4103C0;

    /* renamed from: D0 */
    public static final boolean f4104D0;

    /* renamed from: E0 */
    public static final boolean f4105E0;

    /* renamed from: F0 */
    public static final boolean f4106F0;

    /* renamed from: G0 */
    public static final boolean f4107G0;

    /* renamed from: H0 */
    public static final boolean f4108H0;

    /* renamed from: I0 */
    public static final Class<?>[] f4109I0;

    /* renamed from: J0 */
    public static final Interpolator f4110J0;

    /* renamed from: A */
    public int f4111A;

    /* renamed from: B */
    public boolean f4112B;

    /* renamed from: C */
    public final AccessibilityManager f4113C;

    /* renamed from: D */
    public List<InterfaceC0728q> f4114D;

    /* renamed from: E */
    public boolean f4115E;

    /* renamed from: F */
    public boolean f4116F;

    /* renamed from: G */
    public int f4117G;

    /* renamed from: H */
    public int f4118H;

    /* renamed from: I */
    public C0715k f4119I;

    /* renamed from: J */
    public EdgeEffect f4120J;

    /* renamed from: K */
    public EdgeEffect f4121K;

    /* renamed from: L */
    public EdgeEffect f4122L;

    /* renamed from: M */
    public EdgeEffect f4123M;

    /* renamed from: N */
    public AbstractC0716l f4124N;

    /* renamed from: O */
    public int f4125O;

    /* renamed from: P */
    public int f4126P;

    /* renamed from: Q */
    public VelocityTracker f4127Q;

    /* renamed from: R */
    public int f4128R;

    /* renamed from: S */
    public int f4129S;

    /* renamed from: T */
    public int f4130T;

    /* renamed from: U */
    public int f4131U;

    /* renamed from: V */
    public int f4132V;

    /* renamed from: W */
    public AbstractC0729r f4133W;

    /* renamed from: a */
    public final C0736x f4134a;

    /* renamed from: a0 */
    public final int f4135a0;

    /* renamed from: b */
    public final C0734v f4136b;

    /* renamed from: b0 */
    public final int f4137b0;

    /* renamed from: c */
    public C0737y f4138c;

    /* renamed from: c0 */
    public float f4139c0;

    /* renamed from: d */
    public AdapterHelper f4140d;

    /* renamed from: d0 */
    public float f4141d0;

    /* renamed from: e */
    public ChildHelper f4142e;

    /* renamed from: e0 */
    public boolean f4143e0;

    /* renamed from: f */
    public final ViewInfoStore f4144f;

    /* renamed from: f0 */
    public final RunnableC0706c0 f4145f0;

    /* renamed from: g */
    public boolean f4146g;

    /* renamed from: g0 */
    public GapWorker f4147g0;

    /* renamed from: h */
    public final Runnable f4148h;

    /* renamed from: h0 */
    public GapWorker.C0490b f4149h0;

    /* renamed from: i */
    public final Rect f4150i;

    /* renamed from: i0 */
    public final C0702a0 f4151i0;

    /* renamed from: j */
    public final Rect f4152j;

    /* renamed from: j0 */
    public AbstractC0731t f4153j0;

    /* renamed from: k */
    public final RectF f4154k;

    /* renamed from: k0 */
    public List<AbstractC0731t> f4155k0;

    /* renamed from: l0 */
    public boolean f4156l0;

    /* renamed from: m */
    public AbstractC0711g f4157m;

    /* renamed from: m0 */
    public boolean f4158m0;

    /* renamed from: n */
    public AbstractC0722o f4159n;

    /* renamed from: n0 */
    public AbstractC0716l.InterfaceC0718b f4160n0;

    /* renamed from: o */
    public InterfaceC0735w f4161o;

    /* renamed from: o0 */
    public boolean f4162o0;

    /* renamed from: p */
    public final ArrayList<AbstractC0721n> f4163p;

    /* renamed from: p0 */
    public RecyclerViewAccessibilityDelegate f4164p0;

    /* renamed from: q */
    public final ArrayList<InterfaceC0730s> f4165q;

    /* renamed from: q0 */
    public InterfaceC0714j f4166q0;

    /* renamed from: r */
    public InterfaceC0730s f4167r;

    /* renamed from: r0 */
    public final int[] f4168r0;

    /* renamed from: s */
    public boolean f4169s;

    /* renamed from: s0 */
    public NestedScrollingChildHelper f4170s0;

    /* renamed from: t */
    public boolean f4171t;

    /* renamed from: t0 */
    public final int[] f4172t0;

    /* renamed from: u */
    public boolean f4173u;

    /* renamed from: u0 */
    public final int[] f4174u0;

    /* renamed from: v */
    public boolean f4175v;

    /* renamed from: v0 */
    public final int[] f4176v0;

    /* renamed from: w */
    public int f4177w;

    /* renamed from: w0 */
    public final int[] f4178w0;

    /* renamed from: x */
    public boolean f4179x;

    /* renamed from: x0 */
    public final List<AbstractC0708d0> f4180x0;

    /* renamed from: y */
    public boolean f4181y;

    /* renamed from: y0 */
    public Runnable f4182y0;

    /* renamed from: z */
    public boolean f4183z;

    /* renamed from: z0 */
    public final ViewInfoStore.InterfaceC0503b f4184z0;

    /* renamed from: android.support.v7.widget.RecyclerView$a */
    /* loaded from: classes.dex */
    public class RunnableC0701a implements Runnable {
        public RunnableC0701a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f4175v || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f4169s) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f4181y) {
                recyclerView2.f4179x = true;
            } else {
                recyclerView2.m6901c();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$b */
    /* loaded from: classes.dex */
    public class RunnableC0703b implements Runnable {
        public RunnableC0703b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0716l abstractC0716l = RecyclerView.this.f4124N;
            if (abstractC0716l != null) {
                abstractC0716l.mo1044i();
            }
            RecyclerView.this.f4162o0 = false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$b0 */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0704b0 {
        /* renamed from: a */
        public abstract View m6839a(C0734v c0734v, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$c  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class animationInterpolatorC0705c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$e */
    /* loaded from: classes.dex */
    public class C0709e implements ChildHelper.InterfaceC0459b {
        public C0709e() {
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: a */
        public int mo6788a() {
            return RecyclerView.this.getChildCount();
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: b */
        public void mo6783b() {
            int mo6788a = mo6788a();
            for (int i = 0; i < mo6788a; i++) {
                View mo6787a = mo6787a(i);
                RecyclerView.this.m6903b(mo6787a);
                mo6787a.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: c */
        public void mo6780c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.m6903b(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: d */
        public int mo6778d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: a */
        public void mo6785a(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.m6920a(view);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: a */
        public View mo6787a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: a */
        public void mo6784a(View view, int i, ViewGroup.LayoutParams layoutParams) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m != null) {
                if (!m6860m.m6795t() && !m6860m.m6789z()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + m6860m + RecyclerView.this.m6859n());
                }
                m6860m.m6810e();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: c */
        public void mo6779c(View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m != null) {
                m6860m.m6813b(RecyclerView.this);
            }
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: b */
        public AbstractC0708d0 mo6781b(View view) {
            return RecyclerView.m6860m(view);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: b */
        public void mo6782b(int i) {
            AbstractC0708d0 m6860m;
            View mo6787a = mo6787a(i);
            if (mo6787a != null && (m6860m = RecyclerView.m6860m(mo6787a)) != null) {
                if (m6860m.m6795t() && !m6860m.m6789z()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + m6860m + RecyclerView.this.m6859n());
                }
                m6860m.m6823a(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // p000a.p006b.p049h.p063k.ChildHelper.InterfaceC0459b
        /* renamed from: a */
        public void mo6786a(View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m != null) {
                m6860m.m6818a(RecyclerView.this);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$g */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0711g<VH extends AbstractC0708d0> {

        /* renamed from: a */
        public final C0712h f4233a = new C0712h();

        /* renamed from: b */
        public boolean f4234b = false;

        /* renamed from: a */
        public abstract int mo747a();

        /* renamed from: a */
        public void m6763a(VH vh, int i, List<Object> list) {
            mo743b((AbstractC0711g<VH>) vh, i);
        }

        /* renamed from: a */
        public void m6761a(RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public boolean m6765a(VH vh) {
            return false;
        }

        /* renamed from: b */
        public long mo6757b(int i) {
            return -1L;
        }

        /* renamed from: b */
        public abstract VH mo742b(ViewGroup viewGroup, int i);

        /* renamed from: b */
        public void mo1034b(VH vh) {
        }

        /* renamed from: b */
        public abstract void mo743b(VH vh, int i);

        /* renamed from: b */
        public void m6754b(RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public final boolean m6758b() {
            return this.f4233a.m6745a();
        }

        /* renamed from: c */
        public int mo739c(int i) {
            return 0;
        }

        /* renamed from: c */
        public void m6751c(VH vh) {
        }

        /* renamed from: c */
        public final boolean m6753c() {
            return this.f4234b;
        }

        /* renamed from: d */
        public final void m6750d() {
            this.f4233a.m6742b();
        }

        /* renamed from: d */
        public void m6748d(VH vh) {
        }

        /* renamed from: e */
        public final void m6747e(int i) {
            this.f4233a.m6740c(i, 1);
        }

        /* renamed from: f */
        public final void m6746f(int i) {
            this.f4233a.m6739d(i, 1);
        }

        /* renamed from: a */
        public final VH m6760a(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.m9736a("RV CreateView");
                VH mo742b = mo742b(viewGroup, i);
                if (mo742b.f4213a.getParent() == null) {
                    mo742b.f4218f = i;
                    return mo742b;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.m9737a();
            }
        }

        /* renamed from: b */
        public void m6755b(AbstractC0713i abstractC0713i) {
            this.f4233a.unregisterObserver(abstractC0713i);
        }

        /* renamed from: c */
        public final void m6752c(int i, int i2) {
            this.f4233a.m6739d(i, i2);
        }

        /* renamed from: d */
        public final void m6749d(int i) {
            this.f4233a.m6741b(i, 1);
        }

        /* renamed from: b */
        public final void m6756b(int i, int i2) {
            this.f4233a.m6740c(i, i2);
        }

        /* renamed from: a */
        public final void m6764a(VH vh, int i) {
            vh.f4215c = i;
            if (m6753c()) {
                vh.f4217e = mo6757b(i);
            }
            vh.m6822a(1, 519);
            TraceCompat.m9736a("RV OnBindView");
            m6763a((AbstractC0711g<VH>) vh, i, vh.m6802m());
            vh.m6812c();
            ViewGroup.LayoutParams layoutParams = vh.f4213a.getLayoutParams();
            if (layoutParams instanceof C0727p) {
                ((C0727p) layoutParams).f4270c = true;
            }
            TraceCompat.m9737a();
        }

        /* renamed from: a */
        public void m6759a(boolean z) {
            if (!m6758b()) {
                this.f4234b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        /* renamed from: a */
        public void m6762a(AbstractC0713i abstractC0713i) {
            this.f4233a.registerObserver(abstractC0713i);
        }

        /* renamed from: a */
        public final void m6766a(int i, Object obj) {
            this.f4233a.m6743a(i, 1, obj);
        }

        /* renamed from: a */
        public final void m6767a(int i, int i2, Object obj) {
            this.f4233a.m6743a(i, i2, obj);
        }

        /* renamed from: a */
        public final void m6768a(int i, int i2) {
            this.f4233a.m6744a(i, i2);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$h */
    /* loaded from: classes.dex */
    public static class C0712h extends Observable<AbstractC0713i> {
        /* renamed from: a */
        public boolean m6745a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        /* renamed from: b */
        public void m6742b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0713i) ((Observable) this).mObservers.get(size)).mo6542a();
            }
        }

        /* renamed from: c */
        public void m6740c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0713i) ((Observable) this).mObservers.get(size)).mo6538b(i, i2);
            }
        }

        /* renamed from: d */
        public void m6739d(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0713i) ((Observable) this).mObservers.get(size)).mo6537c(i, i2);
            }
        }

        /* renamed from: a */
        public void m6743a(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0713i) ((Observable) this).mObservers.get(size)).mo6540a(i, i2, obj);
            }
        }

        /* renamed from: b */
        public void m6741b(int i, int i2) {
            m6743a(i, i2, null);
        }

        /* renamed from: a */
        public void m6744a(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0713i) ((Observable) this).mObservers.get(size)).mo6541a(i, i2, 1);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$i */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0713i {
        /* renamed from: a */
        public void mo6542a() {
        }

        /* renamed from: a */
        public void m6738a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo6541a(int i, int i2, int i3) {
        }

        /* renamed from: a */
        public void mo6540a(int i, int i2, Object obj) {
            m6738a(i, i2);
        }

        /* renamed from: b */
        public void mo6538b(int i, int i2) {
        }

        /* renamed from: c */
        public void mo6537c(int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$j */
    /* loaded from: classes.dex */
    public interface InterfaceC0714j {
        /* renamed from: a */
        int m6737a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$k */
    /* loaded from: classes.dex */
    public static class C0715k {
        /* renamed from: a */
        public EdgeEffect m6736a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$l */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0716l {

        /* renamed from: a */
        public InterfaceC0718b f4235a = null;

        /* renamed from: b */
        public ArrayList<InterfaceC0717a> f4236b = new ArrayList<>();

        /* renamed from: c */
        public long f4237c = 120;

        /* renamed from: d */
        public long f4238d = 120;

        /* renamed from: e */
        public long f4239e = 250;

        /* renamed from: f */
        public long f4240f = 250;

        /* renamed from: android.support.v7.widget.RecyclerView$l$a */
        /* loaded from: classes.dex */
        public interface InterfaceC0717a {
            /* renamed from: a */
            void m6719a();
        }

        /* renamed from: android.support.v7.widget.RecyclerView$l$b */
        /* loaded from: classes.dex */
        public interface InterfaceC0718b {
            /* renamed from: a */
            void mo6716a(AbstractC0708d0 abstractC0708d0);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$l$c */
        /* loaded from: classes.dex */
        public static class C0719c {

            /* renamed from: a */
            public int f4241a;

            /* renamed from: b */
            public int f4242b;

            /* renamed from: a */
            public C0719c m6718a(AbstractC0708d0 abstractC0708d0) {
                m6717a(abstractC0708d0, 0);
                return this;
            }

            /* renamed from: a */
            public C0719c m6717a(AbstractC0708d0 abstractC0708d0, int i) {
                View view = abstractC0708d0.f4213a;
                this.f4241a = view.getLeft();
                this.f4242b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        /* renamed from: g */
        public static int m6721g(AbstractC0708d0 abstractC0708d0) {
            int i = abstractC0708d0.f4222j & 14;
            if (abstractC0708d0.m6799p()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int m6803l = abstractC0708d0.m6803l();
                int m6807h = abstractC0708d0.m6807h();
                return (m6803l == -1 || m6807h == -1 || m6803l == m6807h) ? i : i | 2048;
            }
            return i;
        }

        /* renamed from: a */
        public void m6730a(InterfaceC0718b interfaceC0718b) {
            this.f4235a = interfaceC0718b;
        }

        /* renamed from: a */
        public boolean mo6732a(AbstractC0708d0 abstractC0708d0) {
            return true;
        }

        /* renamed from: a */
        public abstract boolean mo1052a(AbstractC0708d0 abstractC0708d0, AbstractC0708d0 abstractC0708d02, C0719c c0719c, C0719c c0719c2);

        /* renamed from: a */
        public abstract boolean mo1051a(AbstractC0708d0 abstractC0708d0, C0719c c0719c, C0719c c0719c2);

        /* renamed from: b */
        public abstract void mo1050b();

        /* renamed from: b */
        public final void m6729b(AbstractC0708d0 abstractC0708d0) {
            m6724e(abstractC0708d0);
            InterfaceC0718b interfaceC0718b = this.f4235a;
            if (interfaceC0718b != null) {
                interfaceC0718b.mo6716a(abstractC0708d0);
            }
        }

        /* renamed from: b */
        public abstract boolean mo1049b(AbstractC0708d0 abstractC0708d0, C0719c c0719c, C0719c c0719c2);

        /* renamed from: c */
        public long m6728c() {
            return this.f4237c;
        }

        /* renamed from: c */
        public abstract boolean mo1048c(AbstractC0708d0 abstractC0708d0, C0719c c0719c, C0719c c0719c2);

        /* renamed from: d */
        public long m6726d() {
            return this.f4240f;
        }

        /* renamed from: d */
        public abstract void mo1047d(AbstractC0708d0 abstractC0708d0);

        /* renamed from: e */
        public long m6725e() {
            return this.f4239e;
        }

        /* renamed from: e */
        public void m6724e(AbstractC0708d0 abstractC0708d0) {
        }

        /* renamed from: f */
        public long m6723f() {
            return this.f4238d;
        }

        /* renamed from: f */
        public void m6722f(AbstractC0708d0 abstractC0708d0) {
        }

        /* renamed from: g */
        public abstract boolean mo1046g();

        /* renamed from: h */
        public C0719c m6720h() {
            return new C0719c();
        }

        /* renamed from: i */
        public abstract void mo1044i();

        /* renamed from: a */
        public C0719c m6733a(C0702a0 c0702a0, AbstractC0708d0 abstractC0708d0, int i, List<Object> list) {
            C0719c m6720h = m6720h();
            m6720h.m6718a(abstractC0708d0);
            return m6720h;
        }

        /* renamed from: c */
        public final void m6727c(AbstractC0708d0 abstractC0708d0) {
            m6722f(abstractC0708d0);
        }

        /* renamed from: a */
        public C0719c m6734a(C0702a0 c0702a0, AbstractC0708d0 abstractC0708d0) {
            C0719c m6720h = m6720h();
            m6720h.m6718a(abstractC0708d0);
            return m6720h;
        }

        /* renamed from: a */
        public boolean mo6731a(AbstractC0708d0 abstractC0708d0, List<Object> list) {
            return mo6732a(abstractC0708d0);
        }

        /* renamed from: a */
        public final void m6735a() {
            int size = this.f4236b.size();
            for (int i = 0; i < size; i++) {
                this.f4236b.get(i).m6719a();
            }
            this.f4236b.clear();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$m */
    /* loaded from: classes.dex */
    public class C0720m implements AbstractC0716l.InterfaceC0718b {
        public C0720m() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l.InterfaceC0718b
        /* renamed from: a */
        public void mo6716a(AbstractC0708d0 abstractC0708d0) {
            abstractC0708d0.m6816a(true);
            if (abstractC0708d0.f4220h != null && abstractC0708d0.f4221i == null) {
                abstractC0708d0.f4220h = null;
            }
            abstractC0708d0.f4221i = null;
            if (abstractC0708d0.m6790y() || RecyclerView.this.m6864k(abstractC0708d0.f4213a) || !abstractC0708d0.m6795t()) {
                return;
            }
            RecyclerView.this.removeDetachedView(abstractC0708d0.f4213a, false);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$n */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0721n {
        @Deprecated
        /* renamed from: a */
        public void m6715a(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public void m6714a(Canvas canvas, RecyclerView recyclerView, C0702a0 c0702a0) {
            m6715a(canvas, recyclerView);
        }

        @Deprecated
        /* renamed from: b */
        public void m6711b(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void mo6710b(Canvas canvas, RecyclerView recyclerView, C0702a0 c0702a0) {
            m6711b(canvas, recyclerView);
        }

        @Deprecated
        /* renamed from: a */
        public void m6713a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* renamed from: a */
        public void mo6712a(Rect rect, View view, RecyclerView recyclerView, C0702a0 c0702a0) {
            m6713a(rect, ((C0727p) view.getLayoutParams()).m6604a(), recyclerView);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$o */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0722o {

        /* renamed from: a */
        public ChildHelper f4244a;

        /* renamed from: b */
        public RecyclerView f4245b;

        /* renamed from: g */
        public AbstractC0739z f4250g;

        /* renamed from: m */
        public int f4256m;

        /* renamed from: n */
        public boolean f4257n;

        /* renamed from: o */
        public int f4258o;

        /* renamed from: p */
        public int f4259p;

        /* renamed from: q */
        public int f4260q;

        /* renamed from: r */
        public int f4261r;

        /* renamed from: c */
        public final ViewBoundsCheck.InterfaceC0494b f4246c = new C0723a();

        /* renamed from: d */
        public final ViewBoundsCheck.InterfaceC0494b f4247d = new C0724b();

        /* renamed from: e */
        public ViewBoundsCheck f4248e = new ViewBoundsCheck(this.f4246c);

        /* renamed from: f */
        public ViewBoundsCheck f4249f = new ViewBoundsCheck(this.f4247d);

        /* renamed from: h */
        public boolean f4251h = false;

        /* renamed from: i */
        public boolean f4252i = false;

        /* renamed from: j */
        public boolean f4253j = false;

        /* renamed from: k */
        public boolean f4254k = true;

        /* renamed from: l */
        public boolean f4255l = true;

        /* renamed from: android.support.v7.widget.RecyclerView$o$a */
        /* loaded from: classes.dex */
        public class C0723a implements ViewBoundsCheck.InterfaceC0494b {
            public C0723a() {
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public View mo6609a(int i) {
                return AbstractC0722o.this.m6657c(i);
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: b */
            public int mo6607b() {
                return AbstractC0722o.this.m6623n();
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public int mo6610a() {
                return AbstractC0722o.this.m6618q() - AbstractC0722o.this.m6621o();
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: b */
            public int mo6606b(View view) {
                return AbstractC0722o.this.m6632i(view) + ((ViewGroup.MarginLayoutParams) ((C0727p) view.getLayoutParams())).rightMargin;
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public int mo6608a(View view) {
                return AbstractC0722o.this.m6639f(view) - ((ViewGroup.MarginLayoutParams) ((C0727p) view.getLayoutParams())).leftMargin;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$o$b */
        /* loaded from: classes.dex */
        public class C0724b implements ViewBoundsCheck.InterfaceC0494b {
            public C0724b() {
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public View mo6609a(int i) {
                return AbstractC0722o.this.m6657c(i);
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: b */
            public int mo6607b() {
                return AbstractC0722o.this.m6619p();
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public int mo6610a() {
                return AbstractC0722o.this.m6635h() - AbstractC0722o.this.m6625m();
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: b */
            public int mo6606b(View view) {
                return AbstractC0722o.this.m6642e(view) + ((ViewGroup.MarginLayoutParams) ((C0727p) view.getLayoutParams())).bottomMargin;
            }

            @Override // p000a.p006b.p049h.p063k.ViewBoundsCheck.InterfaceC0494b
            /* renamed from: a */
            public int mo6608a(View view) {
                return AbstractC0722o.this.m6630j(view) - ((ViewGroup.MarginLayoutParams) ((C0727p) view.getLayoutParams())).topMargin;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$o$c */
        /* loaded from: classes.dex */
        public interface InterfaceC0725c {
            /* renamed from: a */
            void mo6605a(int i, int i2);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$o$d */
        /* loaded from: classes.dex */
        public static class C0726d {

            /* renamed from: a */
            public int f4264a;

            /* renamed from: b */
            public int f4265b;

            /* renamed from: c */
            public boolean f4266c;

            /* renamed from: d */
            public boolean f4267d;
        }

        /* renamed from: A */
        public boolean mo6709A() {
            return false;
        }

        /* renamed from: B */
        public void m6708B() {
            AbstractC0739z abstractC0739z = this.f4250g;
            if (abstractC0739z != null) {
                abstractC0739z.m6529d();
            }
        }

        /* renamed from: C */
        public boolean mo6478C() {
            return false;
        }

        /* renamed from: a */
        public int mo6462a(int i, C0734v c0734v, C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: a */
        public int mo6457a(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: a */
        public View mo6442a(View view, int i, C0734v c0734v, C0702a0 c0702a0) {
            return null;
        }

        /* renamed from: a */
        public void mo6464a(int i, int i2, C0702a0 c0702a0, InterfaceC0725c interfaceC0725c) {
        }

        /* renamed from: a */
        public void mo6702a(int i, InterfaceC0725c interfaceC0725c) {
        }

        /* renamed from: a */
        public void mo6459a(Rect rect, int i, int i2) {
            m6656c(m6705a(i, rect.width() + m6623n() + m6621o(), m6627l()), m6705a(i2, rect.height() + m6619p() + m6625m(), m6629k()));
        }

        /* renamed from: a */
        public void mo6458a(Parcelable parcelable) {
        }

        /* renamed from: a */
        public void m6697a(AbstractC0711g abstractC0711g, AbstractC0711g abstractC0711g2) {
        }

        /* renamed from: a */
        public void mo6448a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: a */
        public boolean mo6465a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo6455a(C0727p c0727p) {
            return c0727p != null;
        }

        /* renamed from: a */
        public boolean m6691a(C0734v c0734v, C0702a0 c0702a0, View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: a */
        public boolean m6682a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: b */
        public int mo6433b(int i, C0734v c0734v, C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: b */
        public int mo6432b(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: b */
        public void m6666b(int i, int i2) {
            this.f4260q = View.MeasureSpec.getSize(i);
            this.f4258o = View.MeasureSpec.getMode(i);
            if (this.f4258o == 0 && !RecyclerView.f4104D0) {
                this.f4260q = 0;
            }
            this.f4261r = View.MeasureSpec.getSize(i2);
            this.f4259p = View.MeasureSpec.getMode(i2);
            if (this.f4259p != 0 || RecyclerView.f4104D0) {
                return;
            }
            this.f4261r = 0;
        }

        /* renamed from: b */
        public void m6663b(RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void mo6427b(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: b */
        public boolean mo6435b() {
            return false;
        }

        /* renamed from: c */
        public int mo6421c(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: c */
        public int m6654c(C0734v c0734v, C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: c */
        public abstract C0727p mo6424c();

        /* renamed from: c */
        public View m6652c(View view) {
            View m6896c;
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null || (m6896c = recyclerView.m6896c(view)) == null || this.f4244a.m8363d(m6896c)) {
                return null;
            }
            return m6896c;
        }

        @Deprecated
        /* renamed from: c */
        public void m6653c(RecyclerView recyclerView) {
        }

        /* renamed from: c */
        public void mo6418c(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public int m6650d() {
            return -1;
        }

        /* renamed from: d */
        public int mo6414d(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: d */
        public View m6645d(View view, int i) {
            return null;
        }

        /* renamed from: d */
        public void m6649d(int i, int i2) {
            int m6644e = m6644e();
            if (m6644e == 0) {
                this.f4245b.m6899c(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < m6644e; i7++) {
                View m6657c = m6657c(i7);
                Rect rect = this.f4245b.f4150i;
                m6658b(m6657c, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f4245b.f4150i.set(i3, i4, i5, i6);
            mo6459a(this.f4245b.f4150i, i, i2);
        }

        /* renamed from: d */
        public void mo6413d(RecyclerView recyclerView) {
        }

        /* renamed from: d */
        public void m6647d(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public boolean m6648d(C0734v c0734v, C0702a0 c0702a0) {
            return false;
        }

        /* renamed from: e */
        public int mo6410e(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: e */
        public void mo6409e(C0734v c0734v, C0702a0 c0702a0) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* renamed from: f */
        public int mo6407f(C0702a0 c0702a0) {
            return 0;
        }

        /* renamed from: f */
        public void mo6408f(int i) {
        }

        /* renamed from: f */
        public void m6640f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f4245b = null;
                this.f4244a = null;
                this.f4260q = 0;
                this.f4261r = 0;
            } else {
                this.f4245b = recyclerView;
                this.f4244a = recyclerView.f4142e;
                this.f4260q = recyclerView.getWidth();
                this.f4261r = recyclerView.getHeight();
            }
            this.f4258o = 1073741824;
            this.f4259p = 1073741824;
        }

        /* renamed from: g */
        public void m6637g(int i) {
            if (m6657c(i) != null) {
                this.f4244a.m8360f(i);
            }
        }

        /* renamed from: g */
        public void mo6406g(C0702a0 c0702a0) {
        }

        /* renamed from: h */
        public int m6635h() {
            return this.f4261r;
        }

        /* renamed from: h */
        public void mo6405h(int i) {
        }

        /* renamed from: i */
        public int m6633i() {
            return this.f4259p;
        }

        /* renamed from: j */
        public int m6631j() {
            return ViewCompat.m9422k(this.f4245b);
        }

        /* renamed from: k */
        public int m6628k(View view) {
            return ((C0727p) view.getLayoutParams()).f4269b.left;
        }

        /* renamed from: l */
        public int m6626l(View view) {
            return ((C0727p) view.getLayoutParams()).m6604a();
        }

        /* renamed from: m */
        public int m6625m() {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        /* renamed from: n */
        public int m6623n() {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        /* renamed from: o */
        public void m6620o(View view) {
            this.f4244a.m8361e(view);
        }

        /* renamed from: p */
        public int m6619p() {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* renamed from: q */
        public int m6618q() {
            return this.f4260q;
        }

        /* renamed from: r */
        public int m6617r() {
            return this.f4258o;
        }

        /* renamed from: s */
        public boolean m6616s() {
            int m6644e = m6644e();
            for (int i = 0; i < m6644e; i++) {
                ViewGroup.LayoutParams layoutParams = m6657c(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: t */
        public boolean m6615t() {
            return this.f4252i;
        }

        /* renamed from: u */
        public boolean mo6387u() {
            return this.f4253j;
        }

        /* renamed from: v */
        public final boolean m6614v() {
            return this.f4255l;
        }

        /* renamed from: w */
        public boolean m6613w() {
            AbstractC0739z abstractC0739z = this.f4250g;
            return abstractC0739z != null && abstractC0739z.m6530c();
        }

        /* renamed from: x */
        public Parcelable mo6383x() {
            return null;
        }

        /* renamed from: y */
        public void m6612y() {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        /* renamed from: z */
        public void m6611z() {
            this.f4251h = true;
        }

        /* renamed from: e */
        public int m6644e() {
            ChildHelper childHelper = this.f4244a;
            if (childHelper != null) {
                return childHelper.m8376a();
            }
            return 0;
        }

        /* renamed from: h */
        public int m6634h(View view) {
            Rect rect = ((C0727p) view.getLayoutParams()).f4269b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* renamed from: i */
        public int m6632i(View view) {
            return view.getRight() + m6624m(view);
        }

        /* renamed from: j */
        public int m6630j(View view) {
            return view.getTop() - m6622n(view);
        }

        /* renamed from: k */
        public int m6629k() {
            return ViewCompat.m9421l(this.f4245b);
        }

        /* renamed from: l */
        public int m6627l() {
            return ViewCompat.m9420m(this.f4245b);
        }

        /* renamed from: m */
        public int m6624m(View view) {
            return ((C0727p) view.getLayoutParams()).f4269b.right;
        }

        /* renamed from: n */
        public int m6622n(View view) {
            return ((C0727p) view.getLayoutParams()).f4269b.top;
        }

        /* renamed from: o */
        public int m6621o() {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* renamed from: e */
        public void mo6412e(int i) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                recyclerView.m6883f(i);
            }
        }

        /* renamed from: g */
        public View m6638g() {
            View focusedChild;
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f4244a.m8363d(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* renamed from: c */
        public void m6651c(View view, int i) {
            m6675a(view, i, (C0727p) view.getLayoutParams());
        }

        /* renamed from: c */
        public View m6657c(int i) {
            ChildHelper childHelper = this.f4244a;
            if (childHelper != null) {
                return childHelper.m8366c(i);
            }
            return null;
        }

        /* renamed from: e */
        public int m6642e(View view) {
            return view.getBottom() + m6646d(view);
        }

        /* renamed from: a */
        public static int m6705a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* renamed from: c */
        public void m6655c(C0734v c0734v) {
            int m6553e = c0734v.m6553e();
            for (int i = m6553e - 1; i >= 0; i--) {
                View m6560c = c0734v.m6560c(i);
                AbstractC0708d0 m6860m = RecyclerView.m6860m(m6560c);
                if (!m6860m.m6789z()) {
                    m6860m.m6816a(false);
                    if (m6860m.m6795t()) {
                        this.f4245b.removeDetachedView(m6560c, false);
                    }
                    AbstractC0716l abstractC0716l = this.f4245b.f4124N;
                    if (abstractC0716l != null) {
                        abstractC0716l.mo1047d(m6860m);
                    }
                    m6860m.m6816a(true);
                    c0734v.m6569a(m6560c);
                }
            }
            c0734v.m6561c();
            if (m6553e > 0) {
                this.f4245b.invalidate();
            }
        }

        /* renamed from: e */
        public void m6643e(RecyclerView recyclerView) {
            m6666b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* renamed from: g */
        public int m6636g(View view) {
            Rect rect = ((C0727p) view.getLayoutParams()).f4269b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* renamed from: b */
        public void mo6426b(RecyclerView recyclerView, C0734v c0734v) {
            m6653c(recyclerView);
        }

        /* renamed from: a */
        public void mo6437a(String str) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                recyclerView.m6915a(str);
            }
        }

        /* renamed from: b */
        public void m6661b(View view) {
            m6660b(view, -1);
        }

        /* renamed from: b */
        public void m6660b(View view, int i) {
            m6674a(view, i, false);
        }

        /* renamed from: f */
        public boolean m6641f() {
            RecyclerView recyclerView = this.f4245b;
            return recyclerView != null && recyclerView.f4146g;
        }

        /* renamed from: a */
        public void m6689a(RecyclerView recyclerView) {
            this.f4252i = true;
            m6663b(recyclerView);
        }

        /* renamed from: b */
        public View mo6667b(int i) {
            int m6644e = m6644e();
            for (int i2 = 0; i2 < m6644e; i2++) {
                View m6657c = m6657c(i2);
                AbstractC0708d0 m6860m = RecyclerView.m6860m(m6657c);
                if (m6860m != null && m6860m.m6804k() == i && !m6860m.m6789z() && (this.f4245b.f4151i0.m6841d() || !m6860m.m6797r())) {
                    return m6657c;
                }
            }
            return null;
        }

        /* renamed from: d */
        public void mo6416d(int i) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                recyclerView.m6888e(i);
            }
        }

        /* renamed from: f */
        public int m6639f(View view) {
            return view.getLeft() - m6628k(view);
        }

        /* renamed from: a */
        public void m6686a(RecyclerView recyclerView, C0734v c0734v) {
            this.f4252i = false;
            mo6426b(recyclerView, c0734v);
        }

        /* renamed from: d */
        public int m6646d(View view) {
            return ((C0727p) view.getLayoutParams()).f4269b.bottom;
        }

        /* renamed from: a */
        public boolean m6668a(Runnable runnable) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* renamed from: b */
        public boolean m6659b(View view, int i, int i2, C0727p c0727p) {
            return (this.f4254k && m6665b(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) c0727p).width) && m6665b(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) c0727p).height)) ? false : true;
        }

        /* renamed from: a */
        public C0727p mo6439a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof C0727p) {
                return new C0727p((C0727p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new C0727p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new C0727p(layoutParams);
        }

        /* renamed from: c */
        public void m6656c(int i, int i2) {
            this.f4245b.setMeasuredDimension(i, i2);
        }

        /* renamed from: b */
        public static boolean m6665b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public void m6658b(View view, Rect rect) {
            RecyclerView.m6919a(view, rect);
        }

        /* renamed from: a */
        public C0727p mo6460a(Context context, AttributeSet attributeSet) {
            return new C0727p(context, attributeSet);
        }

        /* renamed from: b */
        public boolean m6662b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return m6684a(recyclerView, view, rect, z, false);
        }

        /* renamed from: a */
        public void m6681a(View view) {
            m6680a(view, -1);
        }

        /* renamed from: b */
        public void m6664b(C0734v c0734v) {
            for (int m6644e = m6644e() - 1; m6644e >= 0; m6644e--) {
                if (!RecyclerView.m6860m(m6657c(m6644e)).m6789z()) {
                    m6701a(m6644e, c0734v);
                }
            }
        }

        /* renamed from: a */
        public void m6680a(View view, int i) {
            m6674a(view, i, true);
        }

        /* renamed from: a */
        public final void m6674a(View view, int i, boolean z) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (!z && !m6860m.m6797r()) {
                this.f4245b.f4144f.m8052g(m6860m);
            } else {
                this.f4245b.f4144f.m8063a(m6860m);
            }
            C0727p c0727p = (C0727p) view.getLayoutParams();
            if (!m6860m.m6824B() && !m6860m.m6796s()) {
                if (view.getParent() == this.f4245b) {
                    int m8365c = this.f4244a.m8365c(view);
                    if (i == -1) {
                        i = this.f4244a.m8376a();
                    }
                    if (m8365c == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f4245b.indexOfChild(view) + this.f4245b.m6859n());
                    } else if (m8365c != i) {
                        this.f4245b.f4159n.m6706a(m8365c, i);
                    }
                } else {
                    this.f4244a.m8372a(view, i, false);
                    c0727p.f4270c = true;
                    AbstractC0739z abstractC0739z = this.f4250g;
                    if (abstractC0739z != null && abstractC0739z.m6530c()) {
                        this.f4250g.m6532a(view);
                    }
                }
            } else {
                if (m6860m.m6796s()) {
                    m6860m.m6825A();
                } else {
                    m6860m.m6811d();
                }
                this.f4244a.m8373a(view, i, view.getLayoutParams(), false);
            }
            if (c0727p.f4271d) {
                m6860m.f4213a.invalidate();
                c0727p.f4271d = false;
            }
        }

        /* renamed from: b */
        public int mo6429b(C0734v c0734v, C0702a0 c0702a0) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null || recyclerView.f4157m == null || !mo6435b()) {
                return 1;
            }
            return this.f4245b.f4157m.mo747a();
        }

        /* renamed from: a */
        public void m6707a(int i) {
            m6700a(i, m6657c(i));
        }

        /* renamed from: a */
        public final void m6700a(int i, View view) {
            this.f4244a.m8375a(i);
        }

        /* renamed from: a */
        public void m6675a(View view, int i, C0727p c0727p) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m.m6797r()) {
                this.f4245b.f4144f.m8063a(m6860m);
            } else {
                this.f4245b.f4144f.m8052g(m6860m);
            }
            this.f4244a.m8373a(view, i, c0727p, m6860m.m6797r());
        }

        /* renamed from: a */
        public void m6706a(int i, int i2) {
            View m6657c = m6657c(i);
            if (m6657c != null) {
                m6707a(i);
                m6651c(m6657c, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f4245b.toString());
        }

        /* renamed from: a */
        public void m6671a(View view, C0734v c0734v) {
            m6620o(view);
            c0734v.m6562b(view);
        }

        /* renamed from: a */
        public void m6701a(int i, C0734v c0734v) {
            View m6657c = m6657c(i);
            m6637g(i);
            c0734v.m6562b(m6657c);
        }

        /* renamed from: a */
        public void m6696a(C0734v c0734v) {
            for (int m6644e = m6644e() - 1; m6644e >= 0; m6644e--) {
                m6695a(c0734v, m6644e, m6657c(m6644e));
            }
        }

        /* renamed from: a */
        public final void m6695a(C0734v c0734v, int i, View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m.m6789z()) {
                return;
            }
            if (m6860m.m6799p() && !m6860m.m6797r() && !this.f4245b.f4157m.m6753c()) {
                m6637g(i);
                c0734v.m6554d(m6860m);
                return;
            }
            m6707a(i);
            c0734v.m6557c(view);
            this.f4245b.f4144f.m8055d(m6860m);
        }

        /* renamed from: a */
        public boolean m6677a(View view, int i, int i2, C0727p c0727p) {
            return (!view.isLayoutRequested() && this.f4254k && m6665b(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) c0727p).width) && m6665b(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) c0727p).height)) ? false : true;
        }

        /* renamed from: a */
        public void m6679a(View view, int i, int i2) {
            C0727p c0727p = (C0727p) view.getLayoutParams();
            Rect m6873h = this.f4245b.m6873h(view);
            int i3 = i + m6873h.left + m6873h.right;
            int i4 = i2 + m6873h.top + m6873h.bottom;
            int m6704a = m6704a(m6618q(), m6617r(), m6623n() + m6621o() + ((ViewGroup.MarginLayoutParams) c0727p).leftMargin + ((ViewGroup.MarginLayoutParams) c0727p).rightMargin + i3, ((ViewGroup.MarginLayoutParams) c0727p).width, mo6465a());
            int m6704a2 = m6704a(m6635h(), m6633i(), m6619p() + m6625m() + ((ViewGroup.MarginLayoutParams) c0727p).topMargin + ((ViewGroup.MarginLayoutParams) c0727p).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) c0727p).height, mo6435b());
            if (m6677a(view, m6704a, m6704a2, c0727p)) {
                view.measure(m6704a, m6704a2);
            }
        }

        /* renamed from: a */
        public static int m6704a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        /* renamed from: a */
        public void m6678a(View view, int i, int i2, int i3, int i4) {
            C0727p c0727p = (C0727p) view.getLayoutParams();
            Rect rect = c0727p.f4269b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) c0727p).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) c0727p).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) c0727p).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) c0727p).bottomMargin);
        }

        /* renamed from: a */
        public void m6670a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((C0727p) view.getLayoutParams()).f4269b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f4245b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f4245b.f4154k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* renamed from: a */
        public void m6672a(View view, Rect rect) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.m6873h(view));
            }
        }

        /* renamed from: a */
        public final int[] m6685a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int m6623n = m6623n();
            int m6619p = m6619p();
            int m6618q = m6618q() - m6621o();
            int m6635h = m6635h() - m6625m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - m6623n;
            int min = Math.min(0, i);
            int i2 = top - m6619p;
            int min2 = Math.min(0, i2);
            int i3 = width - m6618q;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - m6635h);
            if (m6631j() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        /* renamed from: a */
        public boolean m6684a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] m6685a = m6685a(recyclerView, view, rect, z);
            int i = m6685a[0];
            int i2 = m6685a[1];
            if ((!z2 || m6688a(recyclerView, i, i2)) && !(i == 0 && i2 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i, i2);
                } else {
                    recyclerView.m6868j(i, i2);
                }
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public boolean m6669a(View view, boolean z, boolean z2) {
            boolean z3 = this.f4248e.m8107a(view, 24579) && this.f4249f.m8107a(view, 24579);
            return z ? z3 : !z3;
        }

        /* renamed from: a */
        public final boolean m6688a(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int m6623n = m6623n();
            int m6619p = m6619p();
            int m6618q = m6618q() - m6621o();
            int m6635h = m6635h() - m6625m();
            Rect rect = this.f4245b.f4150i;
            m6658b(focusedChild, rect);
            return rect.left - i < m6618q && rect.right - i > m6623n && rect.top - i2 < m6635h && rect.bottom - i2 > m6619p;
        }

        @Deprecated
        /* renamed from: a */
        public boolean m6683a(RecyclerView recyclerView, View view, View view2) {
            return m6613w() || recyclerView.m6849x();
        }

        /* renamed from: a */
        public boolean m6687a(RecyclerView recyclerView, C0702a0 c0702a0, View view, View view2) {
            return m6683a(recyclerView, view, view2);
        }

        /* renamed from: a */
        public void mo6447a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m6647d(recyclerView, i, i2);
        }

        /* renamed from: a */
        public void m6694a(C0734v c0734v, C0702a0 c0702a0, int i, int i2) {
            this.f4245b.m6899c(i, i2);
        }

        /* renamed from: a */
        public void m6699a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f4245b;
            m6692a(recyclerView.f4136b, recyclerView.f4151i0, accessibilityNodeInfoCompat);
        }

        /* renamed from: a */
        public void m6692a(C0734v c0734v, C0702a0 c0702a0, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f4245b.canScrollVertically(-1) || this.f4245b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m9558a(8192);
                accessibilityNodeInfoCompat.m9538e(true);
            }
            if (this.f4245b.canScrollVertically(1) || this.f4245b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m9558a(4096);
                accessibilityNodeInfoCompat.m9538e(true);
            }
            accessibilityNodeInfoCompat.m9553a(AccessibilityNodeInfoCompat.C0284a.m9522a(mo6429b(c0734v, c0702a0), mo6451a(c0734v, c0702a0), m6648d(c0734v, c0702a0), m6654c(c0734v, c0702a0)));
        }

        /* renamed from: a */
        public void mo6438a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4245b;
            m6690a(recyclerView.f4136b, recyclerView.f4151i0, accessibilityEvent);
        }

        /* renamed from: a */
        public void m6690a(C0734v c0734v, C0702a0 c0702a0, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f4245b.canScrollVertically(-1) && !this.f4245b.canScrollHorizontally(-1) && !this.f4245b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            AbstractC0711g abstractC0711g = this.f4245b.f4157m;
            if (abstractC0711g != null) {
                accessibilityEvent.setItemCount(abstractC0711g.mo747a());
            }
        }

        /* renamed from: a */
        public void m6673a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m == null || m6860m.m6797r() || this.f4244a.m8363d(m6860m.f4213a)) {
                return;
            }
            RecyclerView recyclerView = this.f4245b;
            mo6450a(recyclerView.f4136b, recyclerView.f4151i0, view, accessibilityNodeInfoCompat);
        }

        /* renamed from: a */
        public void mo6450a(C0734v c0734v, C0702a0 c0702a0, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.m9547b(AccessibilityNodeInfoCompat.C0285b.m9520a(mo6435b() ? m6626l(view) : 0, 1, mo6465a() ? m6626l(view) : 0, 1, false, false));
        }

        /* renamed from: a */
        public int mo6451a(C0734v c0734v, C0702a0 c0702a0) {
            RecyclerView recyclerView = this.f4245b;
            if (recyclerView == null || recyclerView.f4157m == null || !mo6465a()) {
                return 1;
            }
            return this.f4245b.f4157m.mo747a();
        }

        /* renamed from: a */
        public boolean m6703a(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f4245b;
            return m6693a(recyclerView.f4136b, recyclerView.f4151i0, i, bundle);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m6693a(android.support.p067v7.widget.RecyclerView.C0734v r2, android.support.p067v7.widget.RecyclerView.C0702a0 r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                android.support.v7.widget.RecyclerView r2 = r1.f4245b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L42
                r5 = 8192(0x2000, float:1.148E-41)
                if (r4 == r5) goto L12
                r2 = 0
            L10:
                r4 = 0
                goto L6e
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.m6635h()
                int r5 = r1.m6619p()
                int r2 = r2 - r5
                int r5 = r1.m6625m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = 0
            L2a:
                android.support.v7.widget.RecyclerView r5 = r1.f4245b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L10
                int r4 = r1.m6618q()
                int r5 = r1.m6623n()
                int r4 = r4 - r5
                int r5 = r1.m6621o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L6e
            L42:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L57
                int r2 = r1.m6635h()
                int r4 = r1.m6619p()
                int r2 = r2 - r4
                int r4 = r1.m6625m()
                int r2 = r2 - r4
                goto L58
            L57:
                r2 = 0
            L58:
                android.support.v7.widget.RecyclerView r4 = r1.f4245b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L10
                int r4 = r1.m6618q()
                int r5 = r1.m6623n()
                int r4 = r4 - r5
                int r5 = r1.m6621o()
                int r4 = r4 - r5
            L6e:
                if (r2 != 0) goto L73
                if (r4 != 0) goto L73
                return r3
            L73:
                android.support.v7.widget.RecyclerView r3 = r1.f4245b
                r3.m6868j(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.AbstractC0722o.m6693a(android.support.v7.widget.RecyclerView$v, android.support.v7.widget.RecyclerView$a0, int, android.os.Bundle):boolean");
        }

        /* renamed from: a */
        public boolean m6676a(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f4245b;
            return m6691a(recyclerView.f4136b, recyclerView.f4151i0, view, i, bundle);
        }

        /* renamed from: a */
        public static C0726d m6698a(Context context, AttributeSet attributeSet, int i, int i2) {
            C0726d c0726d = new C0726d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0407b.RecyclerView, i, i2);
            c0726d.f4264a = obtainStyledAttributes.getInt(C0407b.RecyclerView_android_orientation, 1);
            c0726d.f4265b = obtainStyledAttributes.getInt(C0407b.RecyclerView_spanCount, 1);
            c0726d.f4266c = obtainStyledAttributes.getBoolean(C0407b.RecyclerView_reverseLayout, false);
            c0726d.f4267d = obtainStyledAttributes.getBoolean(C0407b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c0726d;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$q */
    /* loaded from: classes.dex */
    public interface InterfaceC0728q {
        /* renamed from: a */
        void m6600a(View view);

        /* renamed from: b */
        void m6599b(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$r */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0729r {
        /* renamed from: a */
        public abstract boolean m6598a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$s */
    /* loaded from: classes.dex */
    public interface InterfaceC0730s {
        /* renamed from: a */
        void mo6597a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: a */
        void mo6596a(boolean z);

        /* renamed from: b */
        boolean mo6595b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$t */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0731t {
        /* renamed from: a */
        public void mo5685a(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public void mo1057a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$v */
    /* loaded from: classes.dex */
    public final class C0734v {

        /* renamed from: a */
        public final ArrayList<AbstractC0708d0> f4278a = new ArrayList<>();

        /* renamed from: b */
        public ArrayList<AbstractC0708d0> f4279b = null;

        /* renamed from: c */
        public final ArrayList<AbstractC0708d0> f4280c = new ArrayList<>();

        /* renamed from: d */
        public final List<AbstractC0708d0> f4281d = Collections.unmodifiableList(this.f4278a);

        /* renamed from: e */
        public int f4282e = 2;

        /* renamed from: f */
        public int f4283f = 2;

        /* renamed from: g */
        public C0732u f4284g;

        /* renamed from: h */
        public AbstractC0704b0 f4285h;

        public C0734v() {
        }

        /* renamed from: a */
        public void m6582a() {
            this.f4278a.clear();
            m6545i();
        }

        /* renamed from: b */
        public View m6564b(int i, boolean z) {
            return m6577a(i, z, Long.MAX_VALUE).f4213a;
        }

        /* renamed from: c */
        public final void m6558c(AbstractC0708d0 abstractC0708d0) {
            View view = abstractC0708d0.f4213a;
            if (view instanceof ViewGroup) {
                m6568a((ViewGroup) view, false);
            }
        }

        /* renamed from: d */
        public View m6555d(int i) {
            return m6564b(i, false);
        }

        /* renamed from: e */
        public void m6552e(int i) {
            m6572a(this.f4280c.get(i), true);
            this.f4280c.remove(i);
        }

        /* renamed from: f */
        public void m6549f(int i) {
            this.f4282e = i;
            m6544j();
        }

        /* renamed from: g */
        public void m6547g() {
            int size = this.f4280c.size();
            for (int i = 0; i < size; i++) {
                C0727p c0727p = (C0727p) this.f4280c.get(i).f4213a.getLayoutParams();
                if (c0727p != null) {
                    c0727p.f4270c = true;
                }
            }
        }

        /* renamed from: h */
        public void m6546h() {
            int size = this.f4280c.size();
            for (int i = 0; i < size; i++) {
                AbstractC0708d0 abstractC0708d0 = this.f4280c.get(i);
                if (abstractC0708d0 != null) {
                    abstractC0708d0.m6823a(6);
                    abstractC0708d0.m6817a((Object) null);
                }
            }
            AbstractC0711g abstractC0711g = RecyclerView.this.f4157m;
            if (abstractC0711g == null || !abstractC0711g.m6753c()) {
                m6545i();
            }
        }

        /* renamed from: i */
        public void m6545i() {
            for (int size = this.f4280c.size() - 1; size >= 0; size--) {
                m6552e(size);
            }
            this.f4280c.clear();
            if (RecyclerView.f4106F0) {
                RecyclerView.this.f4149h0.m8143a();
            }
        }

        /* renamed from: j */
        public void m6544j() {
            AbstractC0722o abstractC0722o = RecyclerView.this.f4159n;
            this.f4283f = this.f4282e + (abstractC0722o != null ? abstractC0722o.f4256m : 0);
            for (int size = this.f4280c.size() - 1; size >= 0 && this.f4280c.size() > this.f4283f; size--) {
                m6552e(size);
            }
        }

        /* renamed from: b */
        public void m6562b(View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (m6860m.m6795t()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (m6860m.m6796s()) {
                m6860m.m6825A();
            } else if (m6860m.m6824B()) {
                m6860m.m6811d();
            }
            m6554d(m6860m);
        }

        /* renamed from: d */
        public void m6554d(AbstractC0708d0 abstractC0708d0) {
            boolean z;
            if (!abstractC0708d0.m6796s() && abstractC0708d0.f4213a.getParent() == null) {
                if (!abstractC0708d0.m6795t()) {
                    if (!abstractC0708d0.m6789z()) {
                        boolean m6808g = abstractC0708d0.m6808g();
                        AbstractC0711g abstractC0711g = RecyclerView.this.f4157m;
                        if ((abstractC0711g != null && m6808g && abstractC0711g.m6765a((AbstractC0711g) abstractC0708d0)) || abstractC0708d0.m6798q()) {
                            if (this.f4283f <= 0 || abstractC0708d0.m6814b(526)) {
                                z = false;
                            } else {
                                int size = this.f4280c.size();
                                if (size >= this.f4283f && size > 0) {
                                    m6552e(0);
                                    size--;
                                }
                                if (RecyclerView.f4106F0 && size > 0 && !RecyclerView.this.f4149h0.m8142a(abstractC0708d0.f4215c)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.f4149h0.m8142a(this.f4280c.get(i).f4215c)) {
                                            break;
                                        }
                                        i--;
                                    }
                                    size = i + 1;
                                }
                                this.f4280c.add(size, abstractC0708d0);
                                z = true;
                            }
                            if (!z) {
                                m6572a(abstractC0708d0, true);
                                r1 = true;
                            }
                        } else {
                            z = false;
                        }
                        RecyclerView.this.f4144f.m8051h(abstractC0708d0);
                        if (z || r1 || !m6808g) {
                            return;
                        }
                        abstractC0708d0.f4230s = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.m6859n());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + abstractC0708d0 + RecyclerView.this.m6859n());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(abstractC0708d0.m6796s());
            sb.append(" isAttached:");
            sb.append(abstractC0708d0.f4213a.getParent() != null);
            sb.append(RecyclerView.this.m6859n());
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public final boolean m6573a(AbstractC0708d0 abstractC0708d0, int i, int i2, long j) {
            abstractC0708d0.f4230s = RecyclerView.this;
            int m6805j = abstractC0708d0.m6805j();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j == Long.MAX_VALUE || this.f4284g.m6591a(m6805j, nanoTime, j)) {
                RecyclerView.this.f4157m.m6764a((AbstractC0711g) abstractC0708d0, i);
                this.f4284g.m6592a(abstractC0708d0.m6805j(), RecyclerView.this.getNanoTime() - nanoTime);
                m6574a(abstractC0708d0);
                if (RecyclerView.this.f4151i0.m6841d()) {
                    abstractC0708d0.f4219g = i2;
                    return true;
                }
                return true;
            }
            return false;
        }

        /* renamed from: c */
        public void m6557c(View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            if (!m6860m.m6814b(12) && m6860m.m6794u() && !RecyclerView.this.m6909b(m6860m)) {
                if (this.f4279b == null) {
                    this.f4279b = new ArrayList<>();
                }
                m6860m.m6819a(this, true);
                this.f4279b.add(m6860m);
            } else if (m6860m.m6799p() && !m6860m.m6797r() && !RecyclerView.this.f4157m.m6753c()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.m6859n());
            } else {
                m6860m.m6819a(this, false);
                this.f4278a.add(m6860m);
            }
        }

        /* renamed from: f */
        public List<AbstractC0708d0> m6550f() {
            return this.f4281d;
        }

        /* renamed from: e */
        public void m6551e(AbstractC0708d0 abstractC0708d0) {
            if (abstractC0708d0.f4227p) {
                this.f4279b.remove(abstractC0708d0);
            } else {
                this.f4278a.remove(abstractC0708d0);
            }
            abstractC0708d0.f4226o = null;
            abstractC0708d0.f4227p = false;
            abstractC0708d0.m6811d();
        }

        /* renamed from: f */
        public boolean m6548f(AbstractC0708d0 abstractC0708d0) {
            if (abstractC0708d0.m6797r()) {
                return RecyclerView.this.f4151i0.m6841d();
            }
            int i = abstractC0708d0.f4215c;
            if (i >= 0 && i < RecyclerView.this.f4157m.mo747a()) {
                if (RecyclerView.this.f4151i0.m6841d() || RecyclerView.this.f4157m.mo739c(abstractC0708d0.f4215c) == abstractC0708d0.m6805j()) {
                    return !RecyclerView.this.f4157m.m6753c() || abstractC0708d0.m6806i() == RecyclerView.this.f4157m.mo6757b(abstractC0708d0.f4215c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + abstractC0708d0 + RecyclerView.this.m6859n());
        }

        /* renamed from: b */
        public AbstractC0708d0 m6566b(int i) {
            int size;
            int m8466c;
            ArrayList<AbstractC0708d0> arrayList = this.f4279b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    AbstractC0708d0 abstractC0708d0 = this.f4279b.get(i2);
                    if (!abstractC0708d0.m6824B() && abstractC0708d0.m6804k() == i) {
                        abstractC0708d0.m6823a(32);
                        return abstractC0708d0;
                    }
                }
                if (RecyclerView.this.f4157m.m6753c() && (m8466c = RecyclerView.this.f4140d.m8466c(i)) > 0 && m8466c < RecyclerView.this.f4157m.mo747a()) {
                    long mo6757b = RecyclerView.this.f4157m.mo6757b(m8466c);
                    for (int i3 = 0; i3 < size; i3++) {
                        AbstractC0708d0 abstractC0708d02 = this.f4279b.get(i3);
                        if (!abstractC0708d02.m6824B() && abstractC0708d02.m6806i() == mo6757b) {
                            abstractC0708d02.m6823a(32);
                            return abstractC0708d02;
                        }
                    }
                }
            }
            return null;
        }

        /* renamed from: e */
        public int m6553e() {
            return this.f4278a.size();
        }

        /* renamed from: a */
        public int m6581a(int i) {
            if (i >= 0 && i < RecyclerView.this.f4151i0.m6846a()) {
                return !RecyclerView.this.f4151i0.m6841d() ? i : RecyclerView.this.f4140d.m8466c(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f4151i0.m6846a() + RecyclerView.this.m6859n());
        }

        /* renamed from: c */
        public View m6560c(int i) {
            return this.f4278a.get(i).f4213a;
        }

        /* renamed from: c */
        public void m6561c() {
            this.f4278a.clear();
            ArrayList<AbstractC0708d0> arrayList = this.f4279b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x022c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0210  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.support.p067v7.widget.RecyclerView.AbstractC0708d0 m6577a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 619
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.C0734v.m6577a(int, boolean, long):android.support.v7.widget.RecyclerView$d0");
        }

        /* renamed from: c */
        public void m6559c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f4280c.size() - 1; size >= 0; size--) {
                AbstractC0708d0 abstractC0708d0 = this.f4280c.get(size);
                if (abstractC0708d0 != null && (i3 = abstractC0708d0.f4215c) >= i && i3 < i4) {
                    abstractC0708d0.m6823a(2);
                    m6552e(size);
                }
            }
        }

        /* renamed from: b */
        public void m6563b(AbstractC0708d0 abstractC0708d0) {
            InterfaceC0735w interfaceC0735w = RecyclerView.this.f4161o;
            if (interfaceC0735w != null) {
                interfaceC0735w.m6543a(abstractC0708d0);
            }
            AbstractC0711g abstractC0711g = RecyclerView.this.f4157m;
            if (abstractC0711g != null) {
                abstractC0711g.m6748d((AbstractC0711g) abstractC0708d0);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4151i0 != null) {
                recyclerView.f4144f.m8051h(abstractC0708d0);
            }
        }

        /* renamed from: b */
        public void m6565b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.f4280c.size();
            for (int i7 = 0; i7 < size; i7++) {
                AbstractC0708d0 abstractC0708d0 = this.f4280c.get(i7);
                if (abstractC0708d0 != null && (i6 = abstractC0708d0.f4215c) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        abstractC0708d0.m6820a(i2 - i, false);
                    } else {
                        abstractC0708d0.m6820a(i5, false);
                    }
                }
            }
        }

        /* renamed from: d */
        public C0732u m6556d() {
            if (this.f4284g == null) {
                this.f4284g = new C0732u();
            }
            return this.f4284g;
        }

        /* renamed from: b */
        public void m6567b() {
            int size = this.f4280c.size();
            for (int i = 0; i < size; i++) {
                this.f4280c.get(i).m6815b();
            }
            int size2 = this.f4278a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f4278a.get(i2).m6815b();
            }
            ArrayList<AbstractC0708d0> arrayList = this.f4279b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f4279b.get(i3).m6815b();
                }
            }
        }

        /* renamed from: a */
        public final void m6574a(AbstractC0708d0 abstractC0708d0) {
            if (RecyclerView.this.m6850w()) {
                View view = abstractC0708d0.f4213a;
                if (ViewCompat.m9424i(view) == 0) {
                    ViewCompat.m9429f(view, 1);
                }
                if (ViewCompat.m9414s(view)) {
                    return;
                }
                abstractC0708d0.m6823a(16384);
                ViewCompat.m9454a(view, RecyclerView.this.f4164p0.mo7995b());
            }
        }

        /* renamed from: a */
        public final void m6568a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m6568a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: a */
        public void m6572a(AbstractC0708d0 abstractC0708d0, boolean z) {
            RecyclerView.m6886e(abstractC0708d0);
            if (abstractC0708d0.m6814b(16384)) {
                abstractC0708d0.m6822a(0, 16384);
                ViewCompat.m9454a(abstractC0708d0.f4213a, (AccessibilityDelegateCompat) null);
            }
            if (z) {
                m6563b(abstractC0708d0);
            }
            abstractC0708d0.f4230s = null;
            m6556d().m6589a(abstractC0708d0);
        }

        /* renamed from: a */
        public void m6569a(View view) {
            AbstractC0708d0 m6860m = RecyclerView.m6860m(view);
            m6860m.f4226o = null;
            m6860m.f4227p = false;
            m6860m.m6811d();
            m6554d(m6860m);
        }

        /* renamed from: a */
        public AbstractC0708d0 m6578a(int i, boolean z) {
            View m8369b;
            int size = this.f4278a.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0708d0 abstractC0708d0 = this.f4278a.get(i2);
                if (!abstractC0708d0.m6824B() && abstractC0708d0.m6804k() == i && !abstractC0708d0.m6799p() && (RecyclerView.this.f4151i0.f4193h || !abstractC0708d0.m6797r())) {
                    abstractC0708d0.m6823a(32);
                    return abstractC0708d0;
                }
            }
            if (!z && (m8369b = RecyclerView.this.f4142e.m8369b(i)) != null) {
                AbstractC0708d0 m6860m = RecyclerView.m6860m(m8369b);
                RecyclerView.this.f4142e.m8358g(m8369b);
                int m8365c = RecyclerView.this.f4142e.m8365c(m8369b);
                if (m8365c != -1) {
                    RecyclerView.this.f4142e.m8375a(m8365c);
                    m6557c(m8369b);
                    m6860m.m6823a(8224);
                    return m6860m;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + m6860m + RecyclerView.this.m6859n());
            }
            int size2 = this.f4280c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractC0708d0 abstractC0708d02 = this.f4280c.get(i3);
                if (!abstractC0708d02.m6799p() && abstractC0708d02.m6804k() == i) {
                    if (!z) {
                        this.f4280c.remove(i3);
                    }
                    return abstractC0708d02;
                }
            }
            return null;
        }

        /* renamed from: a */
        public AbstractC0708d0 m6576a(long j, int i, boolean z) {
            for (int size = this.f4278a.size() - 1; size >= 0; size--) {
                AbstractC0708d0 abstractC0708d0 = this.f4278a.get(size);
                if (abstractC0708d0.m6806i() == j && !abstractC0708d0.m6824B()) {
                    if (i == abstractC0708d0.m6805j()) {
                        abstractC0708d0.m6823a(32);
                        if (abstractC0708d0.m6797r() && !RecyclerView.this.f4151i0.m6841d()) {
                            abstractC0708d0.m6822a(2, 14);
                        }
                        return abstractC0708d0;
                    } else if (!z) {
                        this.f4278a.remove(size);
                        RecyclerView.this.removeDetachedView(abstractC0708d0.f4213a, false);
                        m6569a(abstractC0708d0.f4213a);
                    }
                }
            }
            int size2 = this.f4280c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                AbstractC0708d0 abstractC0708d02 = this.f4280c.get(size2);
                if (abstractC0708d02.m6806i() == j) {
                    if (i == abstractC0708d02.m6805j()) {
                        if (!z) {
                            this.f4280c.remove(size2);
                        }
                        return abstractC0708d02;
                    } else if (!z) {
                        m6552e(size2);
                        return null;
                    }
                }
            }
        }

        /* renamed from: a */
        public void m6571a(AbstractC0711g abstractC0711g, AbstractC0711g abstractC0711g2, boolean z) {
            m6582a();
            m6556d().m6588a(abstractC0711g, abstractC0711g2, z);
        }

        /* renamed from: a */
        public void m6580a(int i, int i2) {
            int size = this.f4280c.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0708d0 abstractC0708d0 = this.f4280c.get(i3);
                if (abstractC0708d0 != null && abstractC0708d0.f4215c >= i) {
                    abstractC0708d0.m6820a(i2, true);
                }
            }
        }

        /* renamed from: a */
        public void m6579a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f4280c.size() - 1; size >= 0; size--) {
                AbstractC0708d0 abstractC0708d0 = this.f4280c.get(size);
                if (abstractC0708d0 != null) {
                    int i4 = abstractC0708d0.f4215c;
                    if (i4 >= i3) {
                        abstractC0708d0.m6820a(-i2, z);
                    } else if (i4 >= i) {
                        abstractC0708d0.m6823a(8);
                        m6552e(size);
                    }
                }
            }
        }

        /* renamed from: a */
        public void m6575a(AbstractC0704b0 abstractC0704b0) {
            this.f4285h = abstractC0704b0;
        }

        /* renamed from: a */
        public void m6570a(C0732u c0732u) {
            C0732u c0732u2 = this.f4284g;
            if (c0732u2 != null) {
                c0732u2.m6583c();
            }
            this.f4284g = c0732u;
            if (this.f4284g == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f4284g.m6594a();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$w */
    /* loaded from: classes.dex */
    public interface InterfaceC0735w {
        /* renamed from: a */
        void m6543a(AbstractC0708d0 abstractC0708d0);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$z */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0739z {

        /* renamed from: android.support.v7.widget.RecyclerView$z$a */
        /* loaded from: classes.dex */
        public interface InterfaceC0740a {
        }

        /* renamed from: a */
        public abstract int m6535a();

        /* renamed from: a */
        public abstract void m6534a(int i);

        /* renamed from: a */
        public abstract void m6533a(int i, int i2);

        /* renamed from: a */
        public abstract void m6532a(View view);

        /* renamed from: b */
        public abstract boolean m6531b();

        /* renamed from: c */
        public abstract boolean m6530c();

        /* renamed from: d */
        public final void m6529d() {
            throw null;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f4103C0 = i == 18 || i == 19 || i == 20;
        f4104D0 = Build.VERSION.SDK_INT >= 23;
        f4105E0 = Build.VERSION.SDK_INT >= 16;
        f4106F0 = Build.VERSION.SDK_INT >= 21;
        f4107G0 = Build.VERSION.SDK_INT <= 15;
        f4108H0 = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        f4109I0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f4110J0 = new animationInterpolatorC0705c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.f4170s0 == null) {
            this.f4170s0 = new NestedScrollingChildHelper(this);
        }
        return this.f4170s0;
    }

    /* renamed from: A */
    public void m6969A() {
        this.f4117G++;
    }

    /* renamed from: B */
    public void m6968B() {
        m6914a(true);
    }

    /* renamed from: C */
    public void m6967C() {
        if (this.f4162o0 || !this.f4169s) {
            return;
        }
        ViewCompat.m9445a(this, this.f4182y0);
        this.f4162o0 = true;
    }

    /* renamed from: D */
    public final boolean m6966D() {
        return this.f4124N != null && this.f4159n.mo6478C();
    }

    /* renamed from: E */
    public final void m6965E() {
        if (this.f4115E) {
            this.f4140d.m8457f();
            if (this.f4116F) {
                this.f4159n.mo6413d(this);
            }
        }
        if (m6966D()) {
            this.f4140d.m8459e();
        } else {
            this.f4140d.m8471b();
        }
        boolean z = false;
        boolean z2 = this.f4156l0 || this.f4158m0;
        this.f4151i0.f4196k = this.f4175v && this.f4124N != null && (this.f4115E || z2 || this.f4159n.f4251h) && (!this.f4115E || this.f4157m.m6753c());
        C0702a0 c0702a0 = this.f4151i0;
        if (c0702a0.f4196k && z2 && !this.f4115E && m6966D()) {
            z = true;
        }
        c0702a0.f4197l = z;
    }

    /* renamed from: F */
    public final void m6964F() {
        View view;
        if (!this.f4143e0 || this.f4157m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (f4108H0 && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.f4142e.m8376a() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.f4142e.m8363d(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        AbstractC0708d0 m6941a = (this.f4151i0.f4199n == -1 || !this.f4157m.m6753c()) ? null : m6941a(this.f4151i0.f4199n);
        if (m6941a != null && !this.f4142e.m8363d(m6941a.f4213a) && m6941a.f4213a.hasFocusable()) {
            view2 = m6941a.f4213a;
        } else if (this.f4142e.m8376a() > 0) {
            view2 = m6858o();
        }
        if (view2 != null) {
            int i = this.f4151i0.f4200o;
            if (i == -1 || (view = view2.findViewById(i)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    /* renamed from: G */
    public final void m6963G() {
        boolean z;
        EdgeEffect edgeEffect = this.f4120J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.f4120J.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f4121K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.f4121K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4122L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.f4122L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4123M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.f4123M.isFinished();
        }
        if (z) {
            ViewCompat.m9464A(this);
        }
    }

    /* renamed from: H */
    public void m6962H() {
        AbstractC0716l abstractC0716l = this.f4124N;
        if (abstractC0716l != null) {
            abstractC0716l.mo1050b();
        }
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.m6664b(this.f4136b);
            this.f4159n.m6655c(this.f4136b);
        }
        this.f4136b.m6582a();
    }

    /* renamed from: I */
    public void m6961I() {
        AbstractC0708d0 abstractC0708d0;
        int m8376a = this.f4142e.m8376a();
        for (int i = 0; i < m8376a; i++) {
            View m8366c = this.f4142e.m8366c(i);
            AbstractC0708d0 m6881f = m6881f(m8366c);
            if (m6881f != null && (abstractC0708d0 = m6881f.f4221i) != null) {
                View view = abstractC0708d0.f4213a;
                int left = m8366c.getLeft();
                int top = m8366c.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* renamed from: J */
    public final void m6960J() {
        C0702a0 c0702a0 = this.f4151i0;
        c0702a0.f4199n = -1L;
        c0702a0.f4198m = -1;
        c0702a0.f4200o = -1;
    }

    /* renamed from: K */
    public final void m6959K() {
        VelocityTracker velocityTracker = this.f4127Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        mo6951a(0);
        m6963G();
    }

    /* renamed from: L */
    public final void m6958L() {
        int m6807h;
        View focusedChild = (this.f4143e0 && hasFocus() && this.f4157m != null) ? getFocusedChild() : null;
        AbstractC0708d0 m6890d = focusedChild != null ? m6890d(focusedChild) : null;
        if (m6890d == null) {
            m6960J();
            return;
        }
        this.f4151i0.f4199n = this.f4157m.m6753c() ? m6890d.m6806i() : -1L;
        C0702a0 c0702a0 = this.f4151i0;
        if (this.f4115E) {
            m6807h = -1;
        } else {
            m6807h = m6890d.m6797r() ? m6890d.f4216d : m6890d.m6807h();
        }
        c0702a0.f4198m = m6807h;
        this.f4151i0.f4200o = m6877g(m6890d.f4213a);
    }

    /* renamed from: M */
    public void m6957M() {
        int m8370b = this.f4142e.m8370b();
        for (int i = 0; i < m8370b; i++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i));
            if (!m6860m.m6789z()) {
                m6860m.m6791x();
            }
        }
    }

    /* renamed from: N */
    public void m6956N() {
        this.f4177w++;
        if (this.f4177w != 1 || this.f4181y) {
            return;
        }
        this.f4179x = false;
    }

    /* renamed from: O */
    public void m6955O() {
        setScrollState(0);
        m6954P();
    }

    /* renamed from: P */
    public final void m6954P() {
        this.f4145f0.m6830d();
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.m6708B();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null || !abstractC0722o.m6682a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* renamed from: b */
    public void m6907b(AbstractC0721n abstractC0721n) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.mo6437a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f4163p.remove(abstractC0721n);
        if (this.f4163p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m6848y();
        requestLayout();
    }

    /* renamed from: c */
    public void m6901c() {
        if (this.f4175v && !this.f4115E) {
            if (this.f4140d.m8467c()) {
                if (this.f4140d.m8462d(4) && !this.f4140d.m8462d(11)) {
                    TraceCompat.m9736a("RV PartialInvalidate");
                    m6956N();
                    m6969A();
                    this.f4140d.m8459e();
                    if (!this.f4179x) {
                        if (m6856q()) {
                            m6889e();
                        } else {
                            this.f4140d.m8478a();
                        }
                    }
                    m6895c(true);
                    m6968B();
                    TraceCompat.m9737a();
                    return;
                } else if (this.f4140d.m8467c()) {
                    TraceCompat.m9736a("RV FullInvalidate");
                    m6889e();
                    TraceCompat.m9737a();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        TraceCompat.m9736a("RV FullInvalidate");
        m6889e();
        TraceCompat.m9737a();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0727p) && this.f4159n.mo6455a((C0727p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6465a()) {
            return this.f4159n.mo6457a(this.f4151i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6465a()) {
            return this.f4159n.mo6432b(this.f4151i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6465a()) {
            return this.f4159n.mo6421c(this.f4151i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6435b()) {
            return this.f4159n.mo6414d(this.f4151i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6435b()) {
            return this.f4159n.mo6410e(this.f4151i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null && abstractC0722o.mo6435b()) {
            return this.f4159n.mo6407f(this.f4151i0);
        }
        return 0;
    }

    /* renamed from: d */
    public final void m6894d() {
        int i = this.f4111A;
        this.f4111A = 0;
        if (i == 0 || !m6850w()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        AccessibilityEventCompat.m9562a(obtain, i);
        sendAccessibilityEventUnchecked(obtain);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m9496a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m9497a(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m9491a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m9493a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.f4163p.size();
        boolean z3 = false;
        for (int i = 0; i < size; i++) {
            this.f4163p.get(i).mo6710b(canvas, this, this.f4151i0);
        }
        EdgeEffect edgeEffect = this.f4120J;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f4146g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f4120J;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f4121K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f4146g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f4121K;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f4122L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f4146g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f4122L;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f4123M;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f4146g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f4123M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.f4124N != null && this.f4163p.size() > 0 && this.f4124N.mo1046g()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.m9464A(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* renamed from: e */
    public void m6889e() {
        if (this.f4157m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f4159n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            C0702a0 c0702a0 = this.f4151i0;
            c0702a0.f4195j = false;
            if (c0702a0.f4190e == 1) {
                m6884f();
                this.f4159n.m6643e(this);
                m6880g();
            } else if (!this.f4140d.m8463d() && this.f4159n.m6618q() == getWidth() && this.f4159n.m6635h() == getHeight()) {
                this.f4159n.m6643e(this);
            } else {
                this.f4159n.m6643e(this);
                m6880g();
            }
            m6876h();
        }
    }

    /* renamed from: f */
    public boolean m6882f(int i, int i2) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f4181y) {
            return false;
        } else {
            boolean mo6465a = abstractC0722o.mo6465a();
            boolean mo6435b = this.f4159n.mo6435b();
            i = (!mo6465a || Math.abs(i) < this.f4135a0) ? 0 : 0;
            i2 = (!mo6435b || Math.abs(i2) < this.f4135a0) ? 0 : 0;
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = i;
            float f2 = i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = mo6465a || mo6435b;
                dispatchNestedFling(f, f2, z);
                AbstractC0729r abstractC0729r = this.f4133W;
                if (abstractC0729r != null && abstractC0729r.m6598a(i, i2)) {
                    return true;
                }
                if (z) {
                    int i3 = mo6465a ? 1 : 0;
                    if (mo6435b) {
                        i3 |= 2;
                    }
                    m6865k(i3, 1);
                    int i4 = this.f4137b0;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.f4137b0;
                    this.f4145f0.m6836a(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View m6645d = this.f4159n.m6645d(view, i);
        if (m6645d != null) {
            return m6645d;
        }
        boolean z2 = (this.f4157m == null || this.f4159n == null || m6849x() || this.f4181y) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.f4159n.mo6435b()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (f4107G0) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.f4159n.mo6465a()) {
                int i3 = (this.f4159n.m6631j() == 1) ^ (i == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (f4107G0) {
                    i = i3;
                }
            }
            if (z) {
                m6901c();
                if (m6896c(view) == null) {
                    return null;
                }
                m6956N();
                this.f4159n.mo6442a(view, i, this.f4136b, this.f4151i0);
                m6895c(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                m6901c();
                if (m6896c(view) == null) {
                    return null;
                }
                m6956N();
                view2 = this.f4159n.mo6442a(view, i, this.f4136b, this.f4151i0);
                m6895c(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return m6917a(view, view2, i) ? view2 : super.focusSearch(view, i);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            m6918a(view2, (View) null);
            return view;
        }
    }

    /* renamed from: g */
    public final int m6877g(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* renamed from: g */
    public void m6879g(int i) {
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            return abstractC0722o.mo6424c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m6859n());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            return abstractC0722o.mo6460a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m6859n());
    }

    public AbstractC0711g getAdapter() {
        return this.f4157m;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            return abstractC0722o.m6650d();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        InterfaceC0714j interfaceC0714j = this.f4166q0;
        if (interfaceC0714j == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return interfaceC0714j.m6737a(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f4146g;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.f4164p0;
    }

    public C0715k getEdgeEffectFactory() {
        return this.f4119I;
    }

    public AbstractC0716l getItemAnimator() {
        return this.f4124N;
    }

    public int getItemDecorationCount() {
        return this.f4163p.size();
    }

    public AbstractC0722o getLayoutManager() {
        return this.f4159n;
    }

    public int getMaxFlingVelocity() {
        return this.f4137b0;
    }

    public int getMinFlingVelocity() {
        return this.f4135a0;
    }

    public long getNanoTime() {
        if (f4106F0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public AbstractC0729r getOnFlingListener() {
        return this.f4133W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f4143e0;
    }

    public C0732u getRecycledViewPool() {
        return this.f4136b.m6556d();
    }

    public int getScrollState() {
        return this.f4125O;
    }

    /* renamed from: h */
    public void m6875h(int i) {
        if (this.f4181y) {
            return;
        }
        m6955O();
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        abstractC0722o.mo6405h(i);
        awakenScrollBars();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m9498a();
    }

    /* renamed from: i */
    public void m6872i() {
        int i;
        for (int size = this.f4180x0.size() - 1; size >= 0; size--) {
            AbstractC0708d0 abstractC0708d0 = this.f4180x0.get(size);
            if (abstractC0708d0.f4213a.getParent() == this && !abstractC0708d0.m6789z() && (i = abstractC0708d0.f4229r) != -1) {
                ViewCompat.m9429f(abstractC0708d0.f4213a, i);
                abstractC0708d0.f4229r = -1;
            }
        }
        this.f4180x0.clear();
    }

    /* renamed from: i */
    public void m6871i(int i, int i2) {
    }

    /* renamed from: i */
    public void m6870i(View view) {
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f4169s;
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m9487b();
    }

    /* renamed from: j */
    public void m6868j(int i, int i2) {
        m6947a(i, i2, (Interpolator) null);
    }

    /* renamed from: j */
    public void m6867j(View view) {
    }

    /* renamed from: k */
    public boolean m6864k(View view) {
        m6956N();
        boolean m8359f = this.f4142e.m8359f(view);
        if (m8359f) {
            AbstractC0708d0 m6860m = m6860m(view);
            this.f4136b.m6551e(m6860m);
            this.f4136b.m6554d(m6860m);
        }
        m6895c(!m8359f);
        return m8359f;
    }

    /* renamed from: l */
    public void m6863l() {
        if (this.f4122L != null) {
            return;
        }
        this.f4122L = this.f4119I.m6736a(this, 2);
        if (this.f4146g) {
            this.f4122L.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.f4122L.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: m */
    public void m6861m() {
        if (this.f4121K != null) {
            return;
        }
        this.f4121K = this.f4119I.m6736a(this, 1);
        if (this.f4146g) {
            this.f4121K.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.f4121K.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: n */
    public String m6859n() {
        return " " + super.toString() + ", adapter:" + this.f4157m + ", layout:" + this.f4159n + ", context:" + getContext();
    }

    /* renamed from: o */
    public final View m6858o() {
        AbstractC0708d0 m6900c;
        int i = this.f4151i0.f4198m;
        if (i == -1) {
            i = 0;
        }
        int m6846a = this.f4151i0.m6846a();
        for (int i2 = i; i2 < m6846a; i2++) {
            AbstractC0708d0 m6900c2 = m6900c(i2);
            if (m6900c2 == null) {
                break;
            } else if (m6900c2.f4213a.hasFocusable()) {
                return m6900c2.f4213a;
            }
        }
        int min = Math.min(m6846a, i);
        while (true) {
            min--;
            if (min < 0 || (m6900c = m6900c(min)) == null) {
                return null;
            }
            if (m6900c.f4213a.hasFocusable()) {
                return m6900c.f4213a;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r0 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.f4117G = r0
            r1 = 1
            r4.f4169s = r1
            boolean r2 = r4.f4175v
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.f4175v = r1
            android.support.v7.widget.RecyclerView$o r1 = r4.f4159n
            if (r1 == 0) goto L1e
            r1.m6689a(r4)
        L1e:
            r4.f4162o0 = r0
            boolean r0 = android.support.p067v7.widget.RecyclerView.f4106F0
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<a.b.h.k.p0> r0 = p000a.p006b.p049h.p063k.GapWorker.f2846e
            java.lang.Object r0 = r0.get()
            a.b.h.k.p0 r0 = (p000a.p006b.p049h.p063k.GapWorker) r0
            r4.f4147g0 = r0
            a.b.h.k.p0 r0 = r4.f4147g0
            if (r0 != 0) goto L62
            a.b.h.k.p0 r0 = new a.b.h.k.p0
            r0.<init>()
            r4.f4147g0 = r0
            android.view.Display r0 = p000a.p006b.p030g.p045k.ViewCompat.m9430f(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            a.b.h.k.p0 r1 = r4.f4147g0
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f2850c = r2
            java.lang.ThreadLocal<a.b.h.k.p0> r0 = p000a.p006b.p049h.p063k.GapWorker.f2846e
            r0.set(r1)
        L62:
            a.b.h.k.p0 r0 = r4.f4147g0
            r0.m8151a(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        AbstractC0716l abstractC0716l = this.f4124N;
        if (abstractC0716l != null) {
            abstractC0716l.mo1050b();
        }
        m6955O();
        this.f4169s = false;
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.m6686a(this, this.f4136b);
        }
        this.f4180x0.clear();
        removeCallbacks(this.f4182y0);
        this.f4144f.m8060b();
        if (!f4106F0 || (gapWorker = this.f4147g0) == null) {
            return;
        }
        gapWorker.m8145b(this);
        this.f4147g0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f4163p.size();
        for (int i = 0; i < size; i++) {
            this.f4163p.get(i).m6714a(canvas, this, this.f4151i0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.RecyclerView$o r0 = r5.f4159n
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f4181y
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            android.support.v7.widget.RecyclerView$o r0 = r5.f4159n
            boolean r0 = r0.mo6435b()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            android.support.v7.widget.RecyclerView$o r3 = r5.f4159n
            boolean r3 = r3.mo6465a()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            android.support.v7.widget.RecyclerView$o r3 = r5.f4159n
            boolean r3 = r3.mo6435b()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            android.support.v7.widget.RecyclerView$o r3 = r5.f4159n
            boolean r3 = r3.mo6465a()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.f4139c0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f4141d0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.m6948a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.f4181y) {
            return false;
        }
        if (m6904b(motionEvent)) {
            m6953a();
            return true;
        }
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            return false;
        }
        boolean mo6465a = abstractC0722o.mo6465a();
        boolean mo6435b = this.f4159n.mo6435b();
        if (this.f4127Q == null) {
            this.f4127Q = VelocityTracker.obtain();
        }
        this.f4127Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f4183z) {
                this.f4183z = false;
            }
            this.f4126P = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.f4130T = x;
            this.f4128R = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f4131U = y;
            this.f4129S = y;
            if (this.f4125O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f4176v0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = mo6465a ? 1 : 0;
            if (mo6435b) {
                i |= 2;
            }
            m6865k(i, 0);
        } else if (actionMasked == 1) {
            this.f4127Q.clear();
            mo6951a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f4126P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f4126P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.f4125O != 1) {
                int i2 = x2 - this.f4128R;
                int i3 = y2 - this.f4129S;
                if (!mo6465a || Math.abs(i2) <= this.f4132V) {
                    z = false;
                } else {
                    this.f4130T = x2;
                    z = true;
                }
                if (mo6435b && Math.abs(i3) > this.f4132V) {
                    this.f4131U = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            m6953a();
        } else if (actionMasked == 5) {
            this.f4126P = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f4130T = x3;
            this.f4128R = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f4131U = y3;
            this.f4129S = y3;
        } else if (actionMasked == 6) {
            m6897c(motionEvent);
        }
        return this.f4125O == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.m9736a("RV OnLayout");
        m6889e();
        TraceCompat.m9737a();
        this.f4175v = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            m6899c(i, i2);
            return;
        }
        boolean z = false;
        if (abstractC0722o.mo6387u()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f4159n.m6694a(this.f4136b, this.f4151i0, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.f4157m == null) {
                return;
            }
            if (this.f4151i0.f4190e == 1) {
                m6884f();
            }
            this.f4159n.m6666b(i, i2);
            this.f4151i0.f4195j = true;
            m6880g();
            this.f4159n.m6649d(i, i2);
            if (this.f4159n.mo6709A()) {
                this.f4159n.m6666b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f4151i0.f4195j = true;
                m6880g();
                this.f4159n.m6649d(i, i2);
            }
        } else if (this.f4171t) {
            this.f4159n.m6694a(this.f4136b, this.f4151i0, i, i2);
        } else {
            if (this.f4112B) {
                m6956N();
                m6969A();
                m6965E();
                m6968B();
                C0702a0 c0702a0 = this.f4151i0;
                if (c0702a0.f4197l) {
                    c0702a0.f4193h = true;
                } else {
                    this.f4140d.m8471b();
                    this.f4151i0.f4193h = false;
                }
                this.f4112B = false;
                m6895c(false);
            } else if (this.f4151i0.f4197l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            AbstractC0711g abstractC0711g = this.f4157m;
            if (abstractC0711g != null) {
                this.f4151i0.f4191f = abstractC0711g.mo747a();
            } else {
                this.f4151i0.f4191f = 0;
            }
            m6956N();
            this.f4159n.m6694a(this.f4136b, this.f4151i0, i, i2);
            m6895c(false);
            this.f4151i0.f4193h = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (m6849x()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0737y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.f4138c = (C0737y) parcelable;
        super.onRestoreInstanceState(this.f4138c.m9588a());
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null || (parcelable2 = this.f4138c.f4288c) == null) {
            return;
        }
        abstractC0722o.mo6458a(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        C0737y c0737y = new C0737y(super.onSaveInstanceState());
        C0737y c0737y2 = this.f4138c;
        if (c0737y2 != null) {
            c0737y.m6536a(c0737y2);
        } else {
            AbstractC0722o abstractC0722o = this.f4159n;
            if (abstractC0722o != null) {
                c0737y.f4288c = abstractC0722o.mo6383x();
            } else {
                c0737y.f4288c = null;
            }
        }
        return c0737y;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        m6852u();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public boolean m6857p() {
        return !this.f4175v || this.f4115E || this.f4140d.m8467c();
    }

    /* renamed from: q */
    public final boolean m6856q() {
        int m8376a = this.f4142e.m8376a();
        for (int i = 0; i < m8376a; i++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8366c(i));
            if (m6860m != null && !m6860m.m6789z() && m6860m.m6794u()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    public void m6855r() {
        this.f4140d = new AdapterHelper(new C0710f());
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        AbstractC0708d0 m6860m = m6860m(view);
        if (m6860m != null) {
            if (m6860m.m6795t()) {
                m6860m.m6810e();
            } else if (!m6860m.m6789z()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + m6860m + m6859n());
            }
        }
        view.clearAnimation();
        m6903b(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f4159n.m6687a(this, this.f4151i0, view, view2) && view2 != null) {
            m6918a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f4159n.m6662b(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f4165q.size();
        for (int i = 0; i < size; i++) {
            this.f4165q.get(i).mo6596a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4177w == 0 && !this.f4181y) {
            super.requestLayout();
        } else {
            this.f4179x = true;
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: s */
    public final void m6854s() {
        if (ViewCompat.m9423j(this) == 0) {
            ViewCompat.m9427g(this, 8);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f4181y) {
        } else {
            boolean mo6465a = abstractC0722o.mo6465a();
            boolean mo6435b = this.f4159n.mo6435b();
            if (mo6465a || mo6435b) {
                if (!mo6465a) {
                    i = 0;
                }
                if (!mo6435b) {
                    i2 = 0;
                }
                m6948a(i, i2, (MotionEvent) null);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (m6916a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.f4164p0 = recyclerViewAccessibilityDelegate;
        ViewCompat.m9454a(this, this.f4164p0);
    }

    public void setAdapter(AbstractC0711g abstractC0711g) {
        setLayoutFrozen(false);
        m6930a(abstractC0711g, false, true);
        m6902b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0714j interfaceC0714j) {
        if (interfaceC0714j == this.f4166q0) {
            return;
        }
        this.f4166q0 = interfaceC0714j;
        setChildrenDrawingOrderEnabled(this.f4166q0 != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f4146g) {
            m6852u();
        }
        this.f4146g = z;
        super.setClipToPadding(z);
        if (this.f4175v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0715k c0715k) {
        Preconditions.m9621a(c0715k);
        this.f4119I = c0715k;
        m6852u();
    }

    public void setHasFixedSize(boolean z) {
        this.f4171t = z;
    }

    public void setItemAnimator(AbstractC0716l abstractC0716l) {
        AbstractC0716l abstractC0716l2 = this.f4124N;
        if (abstractC0716l2 != null) {
            abstractC0716l2.mo1050b();
            this.f4124N.m6730a((AbstractC0716l.InterfaceC0718b) null);
        }
        this.f4124N = abstractC0716l;
        AbstractC0716l abstractC0716l3 = this.f4124N;
        if (abstractC0716l3 != null) {
            abstractC0716l3.m6730a(this.f4160n0);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f4136b.m6549f(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f4181y) {
            m6915a("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.f4181y = false;
                if (this.f4179x && this.f4159n != null && this.f4157m != null) {
                    requestLayout();
                }
                this.f4179x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f4181y = true;
            this.f4183z = true;
            m6955O();
        }
    }

    public void setLayoutManager(AbstractC0722o abstractC0722o) {
        if (abstractC0722o == this.f4159n) {
            return;
        }
        m6955O();
        if (this.f4159n != null) {
            AbstractC0716l abstractC0716l = this.f4124N;
            if (abstractC0716l != null) {
                abstractC0716l.mo1050b();
            }
            this.f4159n.m6664b(this.f4136b);
            this.f4159n.m6655c(this.f4136b);
            this.f4136b.m6582a();
            if (this.f4169s) {
                this.f4159n.m6686a(this, this.f4136b);
            }
            this.f4159n.m6640f((RecyclerView) null);
            this.f4159n = null;
        } else {
            this.f4136b.m6582a();
        }
        this.f4142e.m8367c();
        this.f4159n = abstractC0722o;
        if (abstractC0722o != null) {
            if (abstractC0722o.f4245b == null) {
                this.f4159n.m6640f(this);
                if (this.f4169s) {
                    this.f4159n.m6689a(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + abstractC0722o + " is already attached to a RecyclerView:" + abstractC0722o.f4245b.m6859n());
            }
        }
        this.f4136b.m6544j();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m9488a(z);
    }

    public void setOnFlingListener(AbstractC0729r abstractC0729r) {
        this.f4133W = abstractC0729r;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0731t abstractC0731t) {
        this.f4153j0 = abstractC0731t;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.f4143e0 = z;
    }

    public void setRecycledViewPool(C0732u c0732u) {
        this.f4136b.m6570a(c0732u);
    }

    public void setRecyclerListener(InterfaceC0735w interfaceC0735w) {
        this.f4161o = interfaceC0735w;
    }

    public void setScrollState(int i) {
        if (i == this.f4125O) {
            return;
        }
        this.f4125O = i;
        if (i != 2) {
            m6954P();
        }
        m6911b(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.f4132V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.f4132V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0704b0 abstractC0704b0) {
        this.f4136b.m6575a(abstractC0704b0);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m9484c(i);
    }

    @Override // android.view.View, p000a.p006b.p030g.p045k.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().m9485c();
    }

    /* renamed from: t */
    public final void m6853t() {
        this.f4142e = new ChildHelper(new C0709e());
    }

    /* renamed from: u */
    public void m6852u() {
        this.f4123M = null;
        this.f4121K = null;
        this.f4122L = null;
        this.f4120J = null;
    }

    /* renamed from: v */
    public void m6851v() {
        if (this.f4163p.size() == 0) {
            return;
        }
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.mo6437a("Cannot invalidate item decorations during a scroll or layout");
        }
        m6848y();
        requestLayout();
    }

    /* renamed from: w */
    public boolean m6850w() {
        AccessibilityManager accessibilityManager = this.f4113C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* renamed from: x */
    public boolean m6849x() {
        return this.f4117G > 0;
    }

    /* renamed from: y */
    public void m6848y() {
        int m8370b = this.f4142e.m8370b();
        for (int i = 0; i < m8370b; i++) {
            ((C0727p) this.f4142e.m8362e(i).getLayoutParams()).f4270c = true;
        }
        this.f4136b.m6547g();
    }

    /* renamed from: z */
    public void m6847z() {
        int m8370b = this.f4142e.m8370b();
        for (int i = 0; i < m8370b; i++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i));
            if (m6860m != null && !m6860m.m6789z()) {
                m6860m.m6823a(6);
            }
        }
        m6848y();
        this.f4136b.m6546h();
    }

    /* renamed from: android.support.v7.widget.RecyclerView$c0 */
    /* loaded from: classes.dex */
    public class RunnableC0706c0 implements Runnable {

        /* renamed from: a */
        public int f4204a;

        /* renamed from: b */
        public int f4205b;

        /* renamed from: c */
        public OverScroller f4206c;

        /* renamed from: d */
        public Interpolator f4207d = RecyclerView.f4110J0;

        /* renamed from: e */
        public boolean f4208e = false;

        /* renamed from: f */
        public boolean f4209f = false;

        public RunnableC0706c0() {
            this.f4206c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f4110J0);
        }

        /* renamed from: a */
        public final void m6838a() {
            this.f4209f = false;
            this.f4208e = true;
        }

        /* renamed from: b */
        public final void m6832b() {
            this.f4208e = false;
            if (this.f4209f) {
                m6831c();
            }
        }

        /* renamed from: c */
        public void m6831c() {
            if (this.f4208e) {
                this.f4209f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.m9445a(RecyclerView.this, this);
        }

        /* renamed from: d */
        public void m6830d() {
            RecyclerView.this.removeCallbacks(this);
            this.f4206c.abortAnimation();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
            if (r8 > 0) goto L43;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 418
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.RunnableC0706c0.run():void");
        }

        /* renamed from: a */
        public void m6836a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f4205b = 0;
            this.f4204a = 0;
            this.f4206c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m6831c();
        }

        /* renamed from: a */
        public final float m6837a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        /* renamed from: a */
        public final int m6835a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float m6837a = f2 + (m6837a(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(m6837a / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        /* renamed from: a */
        public void m6833a(int i, int i2, Interpolator interpolator) {
            int m6835a = m6835a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f4110J0;
            }
            m6834a(i, i2, m6835a, interpolator);
        }

        /* renamed from: a */
        public void m6834a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f4207d != interpolator) {
                this.f4207d = interpolator;
                this.f4206c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f4205b = 0;
            this.f4204a = 0;
            this.f4206c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4206c.computeScrollOffset();
            }
            m6831c();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$d0 */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0708d0 {

        /* renamed from: t */
        public static final List<Object> f4212t = Collections.emptyList();

        /* renamed from: a */
        public final View f4213a;

        /* renamed from: b */
        public WeakReference<RecyclerView> f4214b;

        /* renamed from: j */
        public int f4222j;

        /* renamed from: s */
        public RecyclerView f4230s;

        /* renamed from: c */
        public int f4215c = -1;

        /* renamed from: d */
        public int f4216d = -1;

        /* renamed from: e */
        public long f4217e = -1;

        /* renamed from: f */
        public int f4218f = -1;

        /* renamed from: g */
        public int f4219g = -1;

        /* renamed from: h */
        public AbstractC0708d0 f4220h = null;

        /* renamed from: i */
        public AbstractC0708d0 f4221i = null;

        /* renamed from: k */
        public List<Object> f4223k = null;

        /* renamed from: m */
        public List<Object> f4224m = null;

        /* renamed from: n */
        public int f4225n = 0;

        /* renamed from: o */
        public C0734v f4226o = null;

        /* renamed from: p */
        public boolean f4227p = false;

        /* renamed from: q */
        public int f4228q = 0;

        /* renamed from: r */
        public int f4229r = -1;

        public AbstractC0708d0(View view) {
            if (view != null) {
                this.f4213a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* renamed from: A */
        public void m6825A() {
            this.f4226o.m6551e(this);
        }

        /* renamed from: B */
        public boolean m6824B() {
            return (this.f4222j & 32) != 0;
        }

        /* renamed from: a */
        public void m6821a(int i, int i2, boolean z) {
            m6823a(8);
            m6820a(i2, z);
            this.f4215c = i;
        }

        /* renamed from: b */
        public void m6815b() {
            this.f4216d = -1;
            this.f4219g = -1;
        }

        /* renamed from: c */
        public void m6812c() {
            List<Object> list = this.f4223k;
            if (list != null) {
                list.clear();
            }
            this.f4222j &= -1025;
        }

        /* renamed from: d */
        public void m6811d() {
            this.f4222j &= -33;
        }

        /* renamed from: e */
        public void m6810e() {
            this.f4222j &= -257;
        }

        /* renamed from: f */
        public final void m6809f() {
            if (this.f4223k == null) {
                this.f4223k = new ArrayList();
                this.f4224m = Collections.unmodifiableList(this.f4223k);
            }
        }

        /* renamed from: g */
        public boolean m6808g() {
            return (this.f4222j & 16) == 0 && ViewCompat.m9411v(this.f4213a);
        }

        /* renamed from: h */
        public final int m6807h() {
            RecyclerView recyclerView = this.f4230s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.m6898c(this);
        }

        /* renamed from: i */
        public final long m6806i() {
            return this.f4217e;
        }

        /* renamed from: j */
        public final int m6805j() {
            return this.f4218f;
        }

        /* renamed from: k */
        public final int m6804k() {
            int i = this.f4219g;
            return i == -1 ? this.f4215c : i;
        }

        /* renamed from: l */
        public final int m6803l() {
            return this.f4216d;
        }

        /* renamed from: m */
        public List<Object> m6802m() {
            if ((this.f4222j & 1024) == 0) {
                List<Object> list = this.f4223k;
                if (list != null && list.size() != 0) {
                    return this.f4224m;
                }
                return f4212t;
            }
            return f4212t;
        }

        /* renamed from: n */
        public boolean m6801n() {
            return (this.f4222j & 512) != 0 || m6799p();
        }

        /* renamed from: o */
        public boolean m6800o() {
            return (this.f4222j & 1) != 0;
        }

        /* renamed from: p */
        public boolean m6799p() {
            return (this.f4222j & 4) != 0;
        }

        /* renamed from: q */
        public final boolean m6798q() {
            return (this.f4222j & 16) == 0 && !ViewCompat.m9411v(this.f4213a);
        }

        /* renamed from: r */
        public boolean m6797r() {
            return (this.f4222j & 8) != 0;
        }

        /* renamed from: s */
        public boolean m6796s() {
            return this.f4226o != null;
        }

        /* renamed from: t */
        public boolean m6795t() {
            return (this.f4222j & 256) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f4215c + " id=" + this.f4217e + ", oldPos=" + this.f4216d + ", pLpos:" + this.f4219g);
            if (m6796s()) {
                sb.append(" scrap ");
                sb.append(this.f4227p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m6799p()) {
                sb.append(" invalid");
            }
            if (!m6800o()) {
                sb.append(" unbound");
            }
            if (m6793v()) {
                sb.append(" update");
            }
            if (m6797r()) {
                sb.append(" removed");
            }
            if (m6789z()) {
                sb.append(" ignored");
            }
            if (m6795t()) {
                sb.append(" tmpDetached");
            }
            if (!m6798q()) {
                sb.append(" not recyclable(" + this.f4225n + ")");
            }
            if (m6801n()) {
                sb.append(" undefined adapter position");
            }
            if (this.f4213a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* renamed from: u */
        public boolean m6794u() {
            return (this.f4222j & 2) != 0;
        }

        /* renamed from: v */
        public boolean m6793v() {
            return (this.f4222j & 2) != 0;
        }

        /* renamed from: w */
        public void m6792w() {
            this.f4222j = 0;
            this.f4215c = -1;
            this.f4216d = -1;
            this.f4217e = -1L;
            this.f4219g = -1;
            this.f4225n = 0;
            this.f4220h = null;
            this.f4221i = null;
            m6812c();
            this.f4228q = 0;
            this.f4229r = -1;
            RecyclerView.m6886e(this);
        }

        /* renamed from: x */
        public void m6791x() {
            if (this.f4216d == -1) {
                this.f4216d = this.f4215c;
            }
        }

        /* renamed from: y */
        public boolean m6790y() {
            return (this.f4222j & 16) != 0;
        }

        /* renamed from: z */
        public boolean m6789z() {
            return (this.f4222j & Logger.DEFAULT_FULL_MESSAGE_LENGTH) != 0;
        }

        /* renamed from: b */
        public boolean m6814b(int i) {
            return (i & this.f4222j) != 0;
        }

        /* renamed from: a */
        public void m6820a(int i, boolean z) {
            if (this.f4216d == -1) {
                this.f4216d = this.f4215c;
            }
            if (this.f4219g == -1) {
                this.f4219g = this.f4215c;
            }
            if (z) {
                this.f4219g += i;
            }
            this.f4215c += i;
            if (this.f4213a.getLayoutParams() != null) {
                ((C0727p) this.f4213a.getLayoutParams()).f4270c = true;
            }
        }

        /* renamed from: b */
        public void m6813b(RecyclerView recyclerView) {
            recyclerView.m6934a(this, this.f4228q);
            this.f4228q = 0;
        }

        /* renamed from: a */
        public void m6819a(C0734v c0734v, boolean z) {
            this.f4226o = c0734v;
            this.f4227p = z;
        }

        /* renamed from: a */
        public void m6822a(int i, int i2) {
            this.f4222j = (i & i2) | (this.f4222j & (~i2));
        }

        /* renamed from: a */
        public void m6823a(int i) {
            this.f4222j = i | this.f4222j;
        }

        /* renamed from: a */
        public void m6817a(Object obj) {
            if (obj == null) {
                m6823a(1024);
            } else if ((1024 & this.f4222j) == 0) {
                m6809f();
                this.f4223k.add(obj);
            }
        }

        /* renamed from: a */
        public void m6818a(RecyclerView recyclerView) {
            int i = this.f4229r;
            if (i != -1) {
                this.f4228q = i;
            } else {
                this.f4228q = ViewCompat.m9424i(this.f4213a);
            }
            recyclerView.m6934a(this, 4);
        }

        /* renamed from: a */
        public final void m6816a(boolean z) {
            int i = this.f4225n;
            this.f4225n = z ? i - 1 : i + 1;
            int i2 = this.f4225n;
            if (i2 < 0) {
                this.f4225n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.f4222j |= 16;
            } else if (z && this.f4225n == 0) {
                this.f4222j &= -17;
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$f */
    /* loaded from: classes.dex */
    public class C0710f implements AdapterHelper.InterfaceC0450a {
        public C0710f() {
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: a */
        public AbstractC0708d0 mo6777a(int i) {
            AbstractC0708d0 m6942a = RecyclerView.this.m6942a(i, true);
            if (m6942a == null || RecyclerView.this.f4142e.m8363d(m6942a.f4213a)) {
                return null;
            }
            return m6942a;
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: b */
        public void mo6773b(int i, int i2) {
            RecyclerView.this.m6945a(i, i2, false);
            RecyclerView.this.f4156l0 = true;
        }

        /* renamed from: c */
        public void m6770c(AdapterHelper.C0451b c0451b) {
            int i = c0451b.f2581a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f4159n.mo6427b(recyclerView, c0451b.f2582b, c0451b.f2584d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f4159n.mo6418c(recyclerView2, c0451b.f2582b, c0451b.f2584d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f4159n.mo6447a(recyclerView3, c0451b.f2582b, c0451b.f2584d, c0451b.f2583c);
            } else if (i != 8) {
            } else {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f4159n.mo6448a(recyclerView4, c0451b.f2582b, c0451b.f2584d, 1);
            }
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: d */
        public void mo6769d(int i, int i2) {
            RecyclerView.this.m6945a(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4156l0 = true;
            recyclerView.f4151i0.f4189d += i2;
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: a */
        public void mo6775a(int i, int i2, Object obj) {
            RecyclerView.this.m6946a(i, i2, obj);
            RecyclerView.this.f4158m0 = true;
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: b */
        public void mo6772b(AdapterHelper.C0451b c0451b) {
            m6770c(c0451b);
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: a */
        public void mo6774a(AdapterHelper.C0451b c0451b) {
            m6770c(c0451b);
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: a */
        public void mo6776a(int i, int i2) {
            RecyclerView.this.m6874h(i, i2);
            RecyclerView.this.f4156l0 = true;
        }

        @Override // p000a.p006b.p049h.p063k.AdapterHelper.InterfaceC0450a
        /* renamed from: c */
        public void mo6771c(int i, int i2) {
            RecyclerView.this.m6878g(i, i2);
            RecyclerView.this.f4156l0 = true;
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: j */
    public void m6869j() {
        if (this.f4123M != null) {
            return;
        }
        this.f4123M = this.f4119I.m6736a(this, 3);
        if (this.f4146g) {
            this.f4123M.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.f4123M.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$u */
    /* loaded from: classes.dex */
    public static class C0732u {

        /* renamed from: a */
        public SparseArray<C0733a> f4272a = new SparseArray<>();

        /* renamed from: b */
        public int f4273b = 0;

        /* renamed from: android.support.v7.widget.RecyclerView$u$a */
        /* loaded from: classes.dex */
        public static class C0733a {

            /* renamed from: a */
            public final ArrayList<AbstractC0708d0> f4274a = new ArrayList<>();

            /* renamed from: b */
            public int f4275b = 5;

            /* renamed from: c */
            public long f4276c = 0;

            /* renamed from: d */
            public long f4277d = 0;
        }

        /* renamed from: a */
        public AbstractC0708d0 m6593a(int i) {
            C0733a c0733a = this.f4272a.get(i);
            if (c0733a == null || c0733a.f4274a.isEmpty()) {
                return null;
            }
            ArrayList<AbstractC0708d0> arrayList = c0733a.f4274a;
            return arrayList.remove(arrayList.size() - 1);
        }

        /* renamed from: b */
        public void m6587b() {
            for (int i = 0; i < this.f4272a.size(); i++) {
                this.f4272a.valueAt(i).f4274a.clear();
            }
        }

        /* renamed from: c */
        public void m6583c() {
            this.f4273b--;
        }

        /* renamed from: b */
        public void m6585b(int i, long j) {
            C0733a m6586b = m6586b(i);
            m6586b.f4276c = m6590a(m6586b.f4276c, j);
        }

        /* renamed from: a */
        public void m6589a(AbstractC0708d0 abstractC0708d0) {
            int m6805j = abstractC0708d0.m6805j();
            ArrayList<AbstractC0708d0> arrayList = m6586b(m6805j).f4274a;
            if (this.f4272a.get(m6805j).f4275b <= arrayList.size()) {
                return;
            }
            abstractC0708d0.m6792w();
            arrayList.add(abstractC0708d0);
        }

        /* renamed from: b */
        public boolean m6584b(int i, long j, long j2) {
            long j3 = m6586b(i).f4276c;
            return j3 == 0 || j + j3 < j2;
        }

        /* renamed from: b */
        public final C0733a m6586b(int i) {
            C0733a c0733a = this.f4272a.get(i);
            if (c0733a == null) {
                C0733a c0733a2 = new C0733a();
                this.f4272a.put(i, c0733a2);
                return c0733a2;
            }
            return c0733a;
        }

        /* renamed from: a */
        public long m6590a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* renamed from: a */
        public void m6592a(int i, long j) {
            C0733a m6586b = m6586b(i);
            m6586b.f4277d = m6590a(m6586b.f4277d, j);
        }

        /* renamed from: a */
        public boolean m6591a(int i, long j, long j2) {
            long j3 = m6586b(i).f4277d;
            return j3 == 0 || j + j3 < j2;
        }

        /* renamed from: a */
        public void m6594a() {
            this.f4273b++;
        }

        /* renamed from: a */
        public void m6588a(AbstractC0711g abstractC0711g, AbstractC0711g abstractC0711g2, boolean z) {
            if (abstractC0711g != null) {
                m6583c();
            }
            if (!z && this.f4273b == 0) {
                m6587b();
            }
            if (abstractC0711g2 != null) {
                m6594a();
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$x */
    /* loaded from: classes.dex */
    public class C0736x extends AbstractC0713i {
        public C0736x() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0713i
        /* renamed from: a */
        public void mo6542a() {
            RecyclerView.this.m6915a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4151i0.f4192g = true;
            recyclerView.m6902b(true);
            if (RecyclerView.this.f4140d.m8467c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0713i
        /* renamed from: b */
        public void mo6538b(int i, int i2) {
            RecyclerView.this.m6915a((String) null);
            if (RecyclerView.this.f4140d.m8469b(i, i2)) {
                m6539b();
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0713i
        /* renamed from: c */
        public void mo6537c(int i, int i2) {
            RecyclerView.this.m6915a((String) null);
            if (RecyclerView.this.f4140d.m8465c(i, i2)) {
                m6539b();
            }
        }

        /* renamed from: b */
        public void m6539b() {
            if (RecyclerView.f4105E0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f4171t && recyclerView.f4169s) {
                    ViewCompat.m9445a(recyclerView, recyclerView.f4148h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f4112B = true;
            recyclerView2.requestLayout();
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0713i
        /* renamed from: a */
        public void mo6540a(int i, int i2, Object obj) {
            RecyclerView.this.m6915a((String) null);
            if (RecyclerView.this.f4140d.m8474a(i, i2, obj)) {
                m6539b();
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0713i
        /* renamed from: a */
        public void mo6541a(int i, int i2, int i3) {
            RecyclerView.this.m6915a((String) null);
            if (RecyclerView.this.f4140d.m8475a(i, i2, i3)) {
                m6539b();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4134a = new C0736x();
        this.f4136b = new C0734v();
        this.f4144f = new ViewInfoStore();
        this.f4148h = new RunnableC0701a();
        this.f4150i = new Rect();
        this.f4152j = new Rect();
        this.f4154k = new RectF();
        this.f4163p = new ArrayList<>();
        this.f4165q = new ArrayList<>();
        this.f4177w = 0;
        this.f4115E = false;
        this.f4116F = false;
        this.f4117G = 0;
        this.f4118H = 0;
        this.f4119I = new C0715k();
        this.f4124N = new DefaultItemAnimator();
        this.f4125O = 0;
        this.f4126P = -1;
        this.f4139c0 = Float.MIN_VALUE;
        this.f4141d0 = Float.MIN_VALUE;
        boolean z = true;
        this.f4143e0 = true;
        this.f4145f0 = new RunnableC0706c0();
        this.f4149h0 = f4106F0 ? new GapWorker.C0490b() : null;
        this.f4151i0 = new C0702a0();
        this.f4156l0 = false;
        this.f4158m0 = false;
        this.f4160n0 = new C0720m();
        this.f4162o0 = false;
        this.f4168r0 = new int[2];
        this.f4172t0 = new int[2];
        this.f4174u0 = new int[2];
        this.f4176v0 = new int[2];
        this.f4178w0 = new int[2];
        this.f4180x0 = new ArrayList();
        this.f4182y0 = new RunnableC0703b();
        this.f4184z0 = new C0707d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4102B0, i, 0);
            this.f4146g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f4146g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4132V = viewConfiguration.getScaledTouchSlop();
        this.f4139c0 = ViewConfigurationCompat.m9396b(viewConfiguration, context);
        this.f4141d0 = ViewConfigurationCompat.m9395c(viewConfiguration, context);
        this.f4135a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4137b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f4124N.m6730a(this.f4160n0);
        m6855r();
        m6853t();
        m6854s();
        if (ViewCompat.m9424i(this) == 0) {
            ViewCompat.m9429f(this, 1);
        }
        this.f4113C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0407b.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(C0407b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(C0407b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.f4173u = obtainStyledAttributes2.getBoolean(C0407b.RecyclerView_fastScrollEnabled, false);
            if (this.f4173u) {
                m6937a((StateListDrawable) obtainStyledAttributes2.getDrawable(C0407b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(C0407b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(C0407b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(C0407b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            m6938a(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f4101A0, i, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$a0 */
    /* loaded from: classes.dex */
    public static class C0702a0 {

        /* renamed from: b */
        public SparseArray<Object> f4187b;

        /* renamed from: m */
        public int f4198m;

        /* renamed from: n */
        public long f4199n;

        /* renamed from: o */
        public int f4200o;

        /* renamed from: p */
        public int f4201p;

        /* renamed from: q */
        public int f4202q;

        /* renamed from: a */
        public int f4186a = -1;

        /* renamed from: c */
        public int f4188c = 0;

        /* renamed from: d */
        public int f4189d = 0;

        /* renamed from: e */
        public int f4190e = 1;

        /* renamed from: f */
        public int f4191f = 0;

        /* renamed from: g */
        public boolean f4192g = false;

        /* renamed from: h */
        public boolean f4193h = false;

        /* renamed from: i */
        public boolean f4194i = false;

        /* renamed from: j */
        public boolean f4195j = false;

        /* renamed from: k */
        public boolean f4196k = false;

        /* renamed from: l */
        public boolean f4197l = false;

        /* renamed from: a */
        public void m6845a(int i) {
            if ((this.f4190e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f4190e));
        }

        /* renamed from: b */
        public int m6843b() {
            return this.f4186a;
        }

        /* renamed from: c */
        public boolean m6842c() {
            return this.f4186a != -1;
        }

        /* renamed from: d */
        public boolean m6841d() {
            return this.f4193h;
        }

        /* renamed from: e */
        public boolean m6840e() {
            return this.f4197l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4186a + ", mData=" + this.f4187b + ", mItemCount=" + this.f4191f + ", mIsMeasuring=" + this.f4195j + ", mPreviousLayoutItemCount=" + this.f4188c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4189d + ", mStructureChanged=" + this.f4192g + ", mInPreLayout=" + this.f4193h + ", mRunSimpleAnimations=" + this.f4196k + ", mRunPredictiveAnimations=" + this.f4197l + '}';
        }

        /* renamed from: a */
        public void m6844a(AbstractC0711g abstractC0711g) {
            this.f4190e = 1;
            this.f4191f = abstractC0711g.mo747a();
            this.f4193h = false;
            this.f4194i = false;
            this.f4195j = false;
        }

        /* renamed from: a */
        public int m6846a() {
            return this.f4193h ? this.f4188c - this.f4189d : this.f4191f;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$p */
    /* loaded from: classes.dex */
    public static class C0727p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public AbstractC0708d0 f4268a;

        /* renamed from: b */
        public final Rect f4269b;

        /* renamed from: c */
        public boolean f4270c;

        /* renamed from: d */
        public boolean f4271d;

        public C0727p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4269b = new Rect();
            this.f4270c = true;
            this.f4271d = false;
        }

        /* renamed from: a */
        public int m6604a() {
            return this.f4268a.m6804k();
        }

        /* renamed from: b */
        public boolean m6603b() {
            return this.f4268a.m6794u();
        }

        /* renamed from: c */
        public boolean m6602c() {
            return this.f4268a.m6797r();
        }

        /* renamed from: d */
        public boolean m6601d() {
            return this.f4268a.m6799p();
        }

        public C0727p(int i, int i2) {
            super(i, i2);
            this.f4269b = new Rect();
            this.f4270c = true;
            this.f4271d = false;
        }

        public C0727p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4269b = new Rect();
            this.f4270c = true;
            this.f4271d = false;
        }

        public C0727p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4269b = new Rect();
            this.f4270c = true;
            this.f4271d = false;
        }

        public C0727p(C0727p c0727p) {
            super((ViewGroup.LayoutParams) c0727p);
            this.f4269b = new Rect();
            this.f4270c = true;
            this.f4271d = false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$y */
    /* loaded from: classes.dex */
    public static class C0737y extends AbsSavedState {
        public static final Parcelable.Creator<C0737y> CREATOR = new C0738a();

        /* renamed from: c */
        public Parcelable f4288c;

        /* renamed from: android.support.v7.widget.RecyclerView$y$a */
        /* loaded from: classes.dex */
        public static class C0738a implements Parcelable.ClassLoaderCreator<C0737y> {
            @Override // android.os.Parcelable.Creator
            public C0737y[] newArray(int i) {
                return new C0737y[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0737y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0737y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public C0737y createFromParcel(Parcel parcel) {
                return new C0737y(parcel, null);
            }
        }

        public C0737y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4288c = parcel.readParcelable(classLoader == null ? AbstractC0722o.class.getClassLoader() : classLoader);
        }

        /* renamed from: a */
        public void m6536a(C0737y c0737y) {
            this.f4288c = c0737y.f4288c;
        }

        @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f4288c, 0);
        }

        public C0737y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            return abstractC0722o.mo6439a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + m6859n());
    }

    /* renamed from: a */
    public final void m6938a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String m6939a = m6939a(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(m6939a).asSubclass(AbstractC0722o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(f4109I0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + m6939a, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0722o) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + m6939a, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + m6939a, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + m6939a, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + m6939a, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + m6939a, e7);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$d */
    /* loaded from: classes.dex */
    public class C0707d implements ViewInfoStore.InterfaceC0503b {
        public C0707d() {
        }

        @Override // p000a.p006b.p049h.p063k.ViewInfoStore.InterfaceC0503b
        /* renamed from: a */
        public void mo6828a(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2) {
            abstractC0708d0.m6816a(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4115E) {
                if (recyclerView.f4124N.mo1052a(abstractC0708d0, abstractC0708d0, c0719c, c0719c2)) {
                    RecyclerView.this.m6967C();
                }
            } else if (recyclerView.f4124N.mo1048c(abstractC0708d0, c0719c, c0719c2)) {
                RecyclerView.this.m6967C();
            }
        }

        @Override // p000a.p006b.p049h.p063k.ViewInfoStore.InterfaceC0503b
        /* renamed from: b */
        public void mo6827b(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2) {
            RecyclerView.this.f4136b.m6551e(abstractC0708d0);
            RecyclerView.this.m6908b(abstractC0708d0, c0719c, c0719c2);
        }

        @Override // p000a.p006b.p049h.p063k.ViewInfoStore.InterfaceC0503b
        /* renamed from: c */
        public void mo6826c(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2) {
            RecyclerView.this.m6931a(abstractC0708d0, c0719c, c0719c2);
        }

        @Override // p000a.p006b.p049h.p063k.ViewInfoStore.InterfaceC0503b
        /* renamed from: a */
        public void mo6829a(AbstractC0708d0 abstractC0708d0) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4159n.m6671a(abstractC0708d0.f4213a, recyclerView.f4136b);
        }
    }

    /* renamed from: g */
    public final void m6880g() {
        m6956N();
        m6969A();
        this.f4151i0.m6845a(6);
        this.f4140d.m8471b();
        this.f4151i0.f4191f = this.f4157m.mo747a();
        C0702a0 c0702a0 = this.f4151i0;
        c0702a0.f4189d = 0;
        c0702a0.f4193h = false;
        this.f4159n.mo6409e(this.f4136b, c0702a0);
        C0702a0 c0702a02 = this.f4151i0;
        c0702a02.f4192g = false;
        this.f4138c = null;
        c0702a02.f4196k = c0702a02.f4196k && this.f4124N != null;
        this.f4151i0.f4190e = 4;
        m6968B();
        m6895c(false);
    }

    /* renamed from: h */
    public final void m6876h() {
        this.f4151i0.m6845a(4);
        m6956N();
        m6969A();
        C0702a0 c0702a0 = this.f4151i0;
        c0702a0.f4190e = 1;
        if (c0702a0.f4196k) {
            for (int m8376a = this.f4142e.m8376a() - 1; m8376a >= 0; m8376a--) {
                AbstractC0708d0 m6860m = m6860m(this.f4142e.m8366c(m8376a));
                if (!m6860m.m6789z()) {
                    long m6891d = m6891d(m6860m);
                    AbstractC0716l.C0719c m6734a = this.f4124N.m6734a(this.f4151i0, m6860m);
                    AbstractC0708d0 m8066a = this.f4144f.m8066a(m6891d);
                    if (m8066a != null && !m8066a.m6789z()) {
                        boolean m8059b = this.f4144f.m8059b(m8066a);
                        boolean m8059b2 = this.f4144f.m8059b(m6860m);
                        if (m8059b && m8066a == m6860m) {
                            this.f4144f.m8058b(m6860m, m6734a);
                        } else {
                            AbstractC0716l.C0719c m8053f = this.f4144f.m8053f(m8066a);
                            this.f4144f.m8058b(m6860m, m6734a);
                            AbstractC0716l.C0719c m8054e = this.f4144f.m8054e(m6860m);
                            if (m8053f == null) {
                                m6940a(m6891d, m6860m, m8066a);
                            } else {
                                m6933a(m8066a, m6860m, m8053f, m8054e, m8059b, m8059b2);
                            }
                        }
                    } else {
                        this.f4144f.m8058b(m6860m, m6734a);
                    }
                }
            }
            this.f4144f.m8064a(this.f4184z0);
        }
        this.f4159n.m6655c(this.f4136b);
        C0702a0 c0702a02 = this.f4151i0;
        c0702a02.f4188c = c0702a02.f4191f;
        this.f4115E = false;
        this.f4116F = false;
        c0702a02.f4196k = false;
        c0702a02.f4197l = false;
        this.f4159n.f4251h = false;
        ArrayList<AbstractC0708d0> arrayList = this.f4136b.f4279b;
        if (arrayList != null) {
            arrayList.clear();
        }
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o.f4257n) {
            abstractC0722o.f4256m = 0;
            abstractC0722o.f4257n = false;
            this.f4136b.m6544j();
        }
        this.f4159n.mo6406g(this.f4151i0);
        m6968B();
        m6895c(false);
        this.f4144f.m8067a();
        int[] iArr = this.f4168r0;
        if (m6892d(iArr[0], iArr[1])) {
            m6887e(0, 0);
        }
        m6964F();
        m6960J();
    }

    /* renamed from: k */
    public void m6866k() {
        if (this.f4120J != null) {
            return;
        }
        this.f4120J = this.f4119I.m6736a(this, 0);
        if (this.f4146g) {
            this.f4120J.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.f4120J.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* renamed from: l */
    public static RecyclerView m6862l(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView m6862l = m6862l(viewGroup.getChildAt(i));
                if (m6862l != null) {
                    return m6862l;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: m */
    public static AbstractC0708d0 m6860m(View view) {
        if (view == null) {
            return null;
        }
        return ((C0727p) view.getLayoutParams()).f4268a;
    }

    /* renamed from: b */
    public void m6905b(AbstractC0731t abstractC0731t) {
        List<AbstractC0731t> list = this.f4155k0;
        if (list != null) {
            list.remove(abstractC0731t);
        }
    }

    /* renamed from: d */
    public final boolean m6892d(int i, int i2) {
        m6913a(this.f4168r0);
        int[] iArr = this.f4168r0;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* renamed from: b */
    public void m6910b(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.f4120J;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.f4120J.onRelease();
            z = this.f4120J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f4122L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f4122L.onRelease();
            z |= this.f4122L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4121K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.f4121K.onRelease();
            z |= this.f4121K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4123M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f4123M.onRelease();
            z |= this.f4123M.isFinished();
        }
        if (z) {
            ViewCompat.m9464A(this);
        }
    }

    /* renamed from: d */
    public long m6891d(AbstractC0708d0 abstractC0708d0) {
        return this.f4157m.m6753c() ? abstractC0708d0.m6806i() : abstractC0708d0.f4215c;
    }

    /* renamed from: d */
    public AbstractC0708d0 m6890d(View view) {
        View m6896c = m6896c(view);
        if (m6896c == null) {
            return null;
        }
        return m6881f(m6896c);
    }

    /* renamed from: d */
    public boolean m6893d(int i) {
        return getScrollingChildHelper().m9486b(i);
    }

    /* renamed from: k */
    public boolean m6865k(int i, int i2) {
        return getScrollingChildHelper().m9494a(i, i2);
    }

    /* renamed from: f */
    public final void m6884f() {
        boolean z = true;
        this.f4151i0.m6845a(1);
        m6936a(this.f4151i0);
        this.f4151i0.f4195j = false;
        m6956N();
        this.f4144f.m8067a();
        m6969A();
        m6965E();
        m6958L();
        C0702a0 c0702a0 = this.f4151i0;
        c0702a0.f4194i = (c0702a0.f4196k && this.f4158m0) ? false : false;
        this.f4158m0 = false;
        this.f4156l0 = false;
        C0702a0 c0702a02 = this.f4151i0;
        c0702a02.f4193h = c0702a02.f4197l;
        c0702a02.f4191f = this.f4157m.mo747a();
        m6913a(this.f4168r0);
        if (this.f4151i0.f4196k) {
            int m8376a = this.f4142e.m8376a();
            for (int i = 0; i < m8376a; i++) {
                AbstractC0708d0 m6860m = m6860m(this.f4142e.m8366c(i));
                if (!m6860m.m6789z() && (!m6860m.m6799p() || this.f4157m.m6753c())) {
                    this.f4144f.m8056c(m6860m, this.f4124N.m6733a(this.f4151i0, m6860m, AbstractC0716l.m6721g(m6860m), m6860m.m6802m()));
                    if (this.f4151i0.f4194i && m6860m.m6794u() && !m6860m.m6797r() && !m6860m.m6789z() && !m6860m.m6799p()) {
                        this.f4144f.m8065a(m6891d(m6860m), m6860m);
                    }
                }
            }
        }
        if (this.f4151i0.f4197l) {
            m6957M();
            C0702a0 c0702a03 = this.f4151i0;
            boolean z2 = c0702a03.f4192g;
            c0702a03.f4192g = false;
            this.f4159n.mo6409e(this.f4136b, c0702a03);
            this.f4151i0.f4192g = z2;
            for (int i2 = 0; i2 < this.f4142e.m8376a(); i2++) {
                AbstractC0708d0 m6860m2 = m6860m(this.f4142e.m8366c(i2));
                if (!m6860m2.m6789z() && !this.f4144f.m8057c(m6860m2)) {
                    int m6721g = AbstractC0716l.m6721g(m6860m2);
                    boolean m6814b = m6860m2.m6814b(8192);
                    if (!m6814b) {
                        m6721g |= 4096;
                    }
                    AbstractC0716l.C0719c m6733a = this.f4124N.m6733a(this.f4151i0, m6860m2, m6721g, m6860m2.m6802m());
                    if (m6814b) {
                        m6932a(m6860m2, m6733a);
                    } else {
                        this.f4144f.m8061a(m6860m2, m6733a);
                    }
                }
            }
            m6912b();
        } else {
            m6912b();
        }
        m6968B();
        m6895c(false);
        this.f4151i0.f4190e = 2;
    }

    /* renamed from: e */
    public int m6885e(View view) {
        AbstractC0708d0 m6860m = m6860m(view);
        if (m6860m != null) {
            return m6860m.m6807h();
        }
        return -1;
    }

    /* renamed from: e */
    public void m6888e(int i) {
        int m8376a = this.f4142e.m8376a();
        for (int i2 = 0; i2 < m8376a; i2++) {
            this.f4142e.m8366c(i2).offsetLeftAndRight(i);
        }
    }

    /* renamed from: e */
    public void m6887e(int i, int i2) {
        this.f4118H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m6871i(i, i2);
        AbstractC0731t abstractC0731t = this.f4153j0;
        if (abstractC0731t != null) {
            abstractC0731t.mo1057a(this, i, i2);
        }
        List<AbstractC0731t> list = this.f4155k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4155k0.get(size).mo1057a(this, i, i2);
            }
        }
        this.f4118H--;
    }

    /* renamed from: g */
    public void m6878g(int i, int i2) {
        int m8370b = this.f4142e.m8370b();
        for (int i3 = 0; i3 < m8370b; i3++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i3));
            if (m6860m != null && !m6860m.m6789z() && m6860m.f4215c >= i) {
                m6860m.m6820a(i2, false);
                this.f4151i0.f4192g = true;
            }
        }
        this.f4136b.m6580a(i, i2);
        requestLayout();
    }

    /* renamed from: b */
    public void m6906b(InterfaceC0730s interfaceC0730s) {
        this.f4165q.remove(interfaceC0730s);
        if (this.f4167r == interfaceC0730s) {
            this.f4167r = null;
        }
    }

    /* renamed from: c */
    public void m6895c(boolean z) {
        if (this.f4177w < 1) {
            this.f4177w = 1;
        }
        if (!z && !this.f4181y) {
            this.f4179x = false;
        }
        if (this.f4177w == 1) {
            if (z && this.f4179x && !this.f4181y && this.f4159n != null && this.f4157m != null) {
                m6889e();
            }
            if (!this.f4181y) {
                this.f4179x = false;
            }
        }
        this.f4177w--;
    }

    /* renamed from: a */
    public final String m6939a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* renamed from: b */
    public final boolean m6904b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f4167r = null;
        }
        int size = this.f4165q.size();
        for (int i = 0; i < size; i++) {
            InterfaceC0730s interfaceC0730s = this.f4165q.get(i);
            if (interfaceC0730s.mo6595b(this, motionEvent) && action != 3) {
                this.f4167r = interfaceC0730s;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m6930a(AbstractC0711g abstractC0711g, boolean z, boolean z2) {
        AbstractC0711g abstractC0711g2 = this.f4157m;
        if (abstractC0711g2 != null) {
            abstractC0711g2.m6755b(this.f4134a);
            this.f4157m.m6754b(this);
        }
        if (!z || z2) {
            m6962H();
        }
        this.f4140d.m8457f();
        AbstractC0711g abstractC0711g3 = this.f4157m;
        this.f4157m = abstractC0711g;
        if (abstractC0711g != null) {
            abstractC0711g.m6762a(this.f4134a);
            abstractC0711g.m6761a(this);
        }
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.m6697a(abstractC0711g3, this.f4157m);
        }
        this.f4136b.m6571a(abstractC0711g3, this.f4157m, z);
        this.f4151i0.f4192g = true;
    }

    /* renamed from: e */
    public static void m6886e(AbstractC0708d0 abstractC0708d0) {
        WeakReference<RecyclerView> weakReference = abstractC0708d0.f4214b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC0708d0.f4213a) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC0708d0.f4214b = null;
        }
    }

    /* renamed from: b */
    public void m6908b(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2) {
        m6935a(abstractC0708d0);
        abstractC0708d0.m6816a(false);
        if (this.f4124N.mo1049b(abstractC0708d0, c0719c, c0719c2)) {
            m6967C();
        }
    }

    /* renamed from: c */
    public final void m6897c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4126P) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f4126P = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.f4130T = x;
            this.f4128R = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.f4131U = y;
            this.f4129S = y;
        }
    }

    /* renamed from: b */
    public void m6912b() {
        int m8370b = this.f4142e.m8370b();
        for (int i = 0; i < m8370b; i++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i));
            if (!m6860m.m6789z()) {
                m6860m.m6815b();
            }
        }
        this.f4136b.m6567b();
    }

    /* renamed from: c */
    public void m6899c(int i, int i2) {
        setMeasuredDimension(AbstractC0722o.m6705a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.m9420m(this)), AbstractC0722o.m6705a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.m9421l(this)));
    }

    /* renamed from: b */
    public boolean m6909b(AbstractC0708d0 abstractC0708d0) {
        AbstractC0716l abstractC0716l = this.f4124N;
        return abstractC0716l == null || abstractC0716l.mo6731a(abstractC0708d0, abstractC0708d0.m6802m());
    }

    /* renamed from: a */
    public final void m6935a(AbstractC0708d0 abstractC0708d0) {
        View view = abstractC0708d0.f4213a;
        boolean z = view.getParent() == this;
        this.f4136b.m6551e(m6881f(view));
        if (abstractC0708d0.m6795t()) {
            this.f4142e.m8373a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.f4142e.m8371a(view, true);
        } else {
            this.f4142e.m8374a(view);
        }
    }

    /* renamed from: b */
    public void m6902b(boolean z) {
        this.f4116F = z | this.f4116F;
        this.f4115E = true;
        m6847z();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m6896c(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.m6896c(android.view.View):android.view.View");
    }

    /* renamed from: b */
    public void m6911b(int i) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.mo6408f(i);
        }
        m6879g(i);
        AbstractC0731t abstractC0731t = this.f4153j0;
        if (abstractC0731t != null) {
            abstractC0731t.mo5685a(this, i);
        }
        List<AbstractC0731t> list = this.f4155k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4155k0.get(size).mo5685a(this, i);
            }
        }
    }

    /* renamed from: a */
    public void m6928a(AbstractC0721n abstractC0721n, int i) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o != null) {
            abstractC0722o.mo6437a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f4163p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.f4163p.add(abstractC0721n);
        } else {
            this.f4163p.add(i, abstractC0721n);
        }
        m6848y();
        requestLayout();
    }

    /* renamed from: c */
    public AbstractC0708d0 m6900c(int i) {
        AbstractC0708d0 abstractC0708d0 = null;
        if (this.f4115E) {
            return null;
        }
        int m8370b = this.f4142e.m8370b();
        for (int i2 = 0; i2 < m8370b; i2++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i2));
            if (m6860m != null && !m6860m.m6797r() && m6898c(m6860m) == i) {
                if (!this.f4142e.m8363d(m6860m.f4213a)) {
                    return m6860m;
                }
                abstractC0708d0 = m6860m;
            }
        }
        return abstractC0708d0;
    }

    /* renamed from: h */
    public void m6874h(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int m8370b = this.f4142e.m8370b();
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < m8370b; i7++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i7));
            if (m6860m != null && (i6 = m6860m.f4215c) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    m6860m.m6820a(i2 - i, false);
                } else {
                    m6860m.m6820a(i5, false);
                }
                this.f4151i0.f4192g = true;
            }
        }
        this.f4136b.m6565b(i, i2);
        requestLayout();
    }

    /* renamed from: b */
    public void m6903b(View view) {
        AbstractC0708d0 m6860m = m6860m(view);
        m6867j(view);
        AbstractC0711g abstractC0711g = this.f4157m;
        if (abstractC0711g != null && m6860m != null) {
            abstractC0711g.m6751c((AbstractC0711g) m6860m);
        }
        List<InterfaceC0728q> list = this.f4114D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4114D.get(size).m6599b(view);
            }
        }
    }

    /* renamed from: c */
    public int m6898c(AbstractC0708d0 abstractC0708d0) {
        if (abstractC0708d0.m6814b(524) || !abstractC0708d0.m6800o()) {
            return -1;
        }
        return this.f4140d.m8477a(abstractC0708d0.f4215c);
    }

    /* renamed from: a */
    public void m6929a(AbstractC0721n abstractC0721n) {
        m6928a(abstractC0721n, -1);
    }

    /* renamed from: a */
    public void m6926a(AbstractC0731t abstractC0731t) {
        if (this.f4155k0 == null) {
            this.f4155k0 = new ArrayList();
        }
        this.f4155k0.add(abstractC0731t);
    }

    /* renamed from: h */
    public Rect m6873h(View view) {
        C0727p c0727p = (C0727p) view.getLayoutParams();
        if (!c0727p.f4270c) {
            return c0727p.f4269b;
        }
        if (this.f4151i0.m6841d() && (c0727p.m6603b() || c0727p.m6601d())) {
            return c0727p.f4269b;
        }
        Rect rect = c0727p.f4269b;
        rect.set(0, 0, 0, 0);
        int size = this.f4163p.size();
        for (int i = 0; i < size; i++) {
            this.f4150i.set(0, 0, 0, 0);
            this.f4163p.get(i).mo6712a(this.f4150i, view, this, this.f4151i0);
            int i2 = rect.left;
            Rect rect2 = this.f4150i;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        c0727p.f4270c = false;
        return rect;
    }

    /* renamed from: a */
    public void m6944a(int i, int i2, int[] iArr) {
        m6956N();
        m6969A();
        TraceCompat.m9736a("RV Scroll");
        m6936a(this.f4151i0);
        int mo6462a = i != 0 ? this.f4159n.mo6462a(i, this.f4136b, this.f4151i0) : 0;
        int mo6433b = i2 != 0 ? this.f4159n.mo6433b(i2, this.f4136b, this.f4151i0) : 0;
        TraceCompat.m9737a();
        m6961I();
        m6968B();
        m6895c(false);
        if (iArr != null) {
            iArr[0] = mo6462a;
            iArr[1] = mo6433b;
        }
    }

    /* renamed from: f */
    public AbstractC0708d0 m6881f(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return m6860m(view);
    }

    /* renamed from: f */
    public void m6883f(int i) {
        int m8376a = this.f4142e.m8376a();
        for (int i2 = 0; i2 < m8376a; i2++) {
            this.f4142e.m8366c(i2).offsetTopAndBottom(i);
        }
    }

    /* renamed from: a */
    public boolean m6948a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        m6901c();
        if (this.f4157m != null) {
            m6944a(i, i2, this.f4178w0);
            int[] iArr = this.f4178w0;
            int i7 = iArr[0];
            int i8 = iArr[1];
            i3 = i8;
            i6 = i7;
            i4 = i - i7;
            i5 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.f4163p.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (m6949a(i6, i3, i4, i5, this.f4172t0, 0)) {
            int i10 = this.f4130T;
            int[] iArr2 = this.f4172t0;
            this.f4130T = i10 - iArr2[0];
            this.f4131U -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.f4176v0;
            int i11 = iArr3[0];
            int[] iArr4 = this.f4172t0;
            iArr3[0] = i11 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.m9499a(motionEvent, 8194)) {
                m6952a(motionEvent.getX(), i4, motionEvent.getY(), i5);
            }
            m6910b(i, i2);
        }
        if (i6 != 0 || i9 != 0) {
            m6887e(i6, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i9 == 0) ? false : true;
    }

    /* renamed from: a */
    public void m6947a(int i, int i2, Interpolator interpolator) {
        AbstractC0722o abstractC0722o = this.f4159n;
        if (abstractC0722o == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.f4181y) {
        } else {
            if (!abstractC0722o.mo6465a()) {
                i = 0;
            }
            if (!this.f4159n.mo6435b()) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f4145f0.m6833a(i, i2, interpolator);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6952a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.m6866k()
            android.widget.EdgeEffect r3 = r6.f4120J
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            p000a.p006b.p030g.p048l.EdgeEffectCompat.m9232a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.m6863l()
            android.widget.EdgeEffect r3 = r6.f4122L
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            p000a.p006b.p030g.p048l.EdgeEffectCompat.m9232a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.m6861m()
            android.widget.EdgeEffect r9 = r6.f4121K
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            p000a.p006b.p030g.p048l.EdgeEffectCompat.m9232a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.m6869j()
            android.widget.EdgeEffect r9 = r6.f4123M
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            p000a.p006b.p030g.p048l.EdgeEffectCompat.m9232a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            p000a.p006b.p030g.p045k.ViewCompat.m9464A(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.m6952a(float, float, float, float):void");
    }

    /* renamed from: a */
    public void m6950a(int i, int i2) {
        if (i < 0) {
            m6866k();
            this.f4120J.onAbsorb(-i);
        } else if (i > 0) {
            m6863l();
            this.f4122L.onAbsorb(i);
        }
        if (i2 < 0) {
            m6861m();
            this.f4121K.onAbsorb(-i2);
        } else if (i2 > 0) {
            m6869j();
            this.f4123M.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ViewCompat.m9464A(this);
    }

    /* renamed from: a */
    public final boolean m6917a(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || m6896c(view2) == null) {
            return false;
        }
        if (view == null || m6896c(view) == null) {
            return true;
        }
        this.f4150i.set(0, 0, view.getWidth(), view.getHeight());
        this.f4152j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f4150i);
        offsetDescendantRectToMyCoords(view2, this.f4152j);
        char c = 65535;
        int i3 = this.f4159n.m6631j() == 1 ? -1 : 1;
        Rect rect = this.f4150i;
        int i4 = rect.left;
        int i5 = this.f4152j.left;
        if ((i4 < i5 || rect.right <= i5) && this.f4150i.right < this.f4152j.right) {
            i2 = 1;
        } else {
            Rect rect2 = this.f4150i;
            int i6 = rect2.right;
            int i7 = this.f4152j.right;
            i2 = ((i6 > i7 || rect2.left >= i7) && this.f4150i.left > this.f4152j.left) ? -1 : 0;
        }
        Rect rect3 = this.f4150i;
        int i8 = rect3.top;
        int i9 = this.f4152j.top;
        if ((i8 < i9 || rect3.bottom <= i9) && this.f4150i.bottom < this.f4152j.bottom) {
            c = 1;
        } else {
            Rect rect4 = this.f4150i;
            int i10 = rect4.bottom;
            int i11 = this.f4152j.bottom;
            if ((i10 <= i11 && rect4.top < i11) || this.f4150i.top <= this.f4152j.top) {
                c = 0;
            }
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 <= 0);
        } else if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 >= 0);
        } else if (i == 17) {
            return i2 < 0;
        } else if (i == 33) {
            return c < 0;
        } else if (i == 66) {
            return i2 > 0;
        } else if (i == 130) {
            return c > 0;
        } else {
            throw new IllegalArgumentException("Invalid direction: " + i + m6859n());
        }
    }

    /* renamed from: a */
    public final void m6918a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f4150i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0727p) {
            C0727p c0727p = (C0727p) layoutParams;
            if (!c0727p.f4270c) {
                Rect rect = c0727p.f4269b;
                Rect rect2 = this.f4150i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f4150i);
            offsetRectIntoDescendantCoords(view, this.f4150i);
        }
        this.f4159n.m6684a(this, view, this.f4150i, !this.f4175v, view2 == null);
    }

    /* renamed from: a */
    public void m6915a(String str) {
        if (m6849x()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + m6859n());
            }
            throw new IllegalStateException(str);
        } else if (this.f4118H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + m6859n()));
        }
    }

    /* renamed from: a */
    public void m6927a(InterfaceC0730s interfaceC0730s) {
        this.f4165q.add(interfaceC0730s);
    }

    /* renamed from: a */
    public final boolean m6921a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        InterfaceC0730s interfaceC0730s = this.f4167r;
        if (interfaceC0730s != null) {
            if (action == 0) {
                this.f4167r = null;
            } else {
                interfaceC0730s.mo6597a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f4167r = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f4165q.size();
            for (int i = 0; i < size; i++) {
                InterfaceC0730s interfaceC0730s2 = this.f4165q.get(i);
                if (interfaceC0730s2.mo6595b(this, motionEvent)) {
                    this.f4167r = interfaceC0730s2;
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void m6953a() {
        m6959K();
        setScrollState(0);
    }

    /* renamed from: a */
    public void m6914a(boolean z) {
        this.f4117G--;
        if (this.f4117G < 1) {
            this.f4117G = 0;
            if (z) {
                m6894d();
                m6872i();
            }
        }
    }

    /* renamed from: a */
    public boolean m6916a(AccessibilityEvent accessibilityEvent) {
        if (m6849x()) {
            int m9563a = accessibilityEvent != null ? AccessibilityEventCompat.m9563a(accessibilityEvent) : 0;
            if (m9563a == 0) {
                m9563a = 0;
            }
            this.f4111A = m9563a | this.f4111A;
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void m6936a(C0702a0 c0702a0) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f4145f0.f4206c;
            c0702a0.f4201p = overScroller.getFinalX() - overScroller.getCurrX();
            c0702a0.f4202q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        c0702a0.f4201p = 0;
        c0702a0.f4202q = 0;
    }

    /* renamed from: a */
    public final void m6940a(long j, AbstractC0708d0 abstractC0708d0, AbstractC0708d0 abstractC0708d02) {
        int m8376a = this.f4142e.m8376a();
        for (int i = 0; i < m8376a; i++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8366c(i));
            if (m6860m != abstractC0708d0 && m6891d(m6860m) == j) {
                AbstractC0711g abstractC0711g = this.f4157m;
                if (abstractC0711g != null && abstractC0711g.m6753c()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + m6860m + " \n View Holder 2:" + abstractC0708d0 + m6859n());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + m6860m + " \n View Holder 2:" + abstractC0708d0 + m6859n());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0708d02 + " cannot be found but it is necessary for " + abstractC0708d0 + m6859n());
    }

    /* renamed from: a */
    public void m6932a(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c) {
        abstractC0708d0.m6822a(0, 8192);
        if (this.f4151i0.f4194i && abstractC0708d0.m6794u() && !abstractC0708d0.m6797r() && !abstractC0708d0.m6789z()) {
            this.f4144f.m8065a(m6891d(abstractC0708d0), abstractC0708d0);
        }
        this.f4144f.m8056c(abstractC0708d0, c0719c);
    }

    /* renamed from: a */
    public final void m6913a(int[] iArr) {
        int m8376a = this.f4142e.m8376a();
        if (m8376a == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < m8376a; i3++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8366c(i3));
            if (!m6860m.m6789z()) {
                int m6804k = m6860m.m6804k();
                if (m6804k < i) {
                    i = m6804k;
                }
                if (m6804k > i2) {
                    i2 = m6804k;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    /* renamed from: a */
    public void m6931a(AbstractC0708d0 abstractC0708d0, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2) {
        abstractC0708d0.m6816a(false);
        if (this.f4124N.mo1051a(abstractC0708d0, c0719c, c0719c2)) {
            m6967C();
        }
    }

    /* renamed from: a */
    public final void m6933a(AbstractC0708d0 abstractC0708d0, AbstractC0708d0 abstractC0708d02, AbstractC0716l.C0719c c0719c, AbstractC0716l.C0719c c0719c2, boolean z, boolean z2) {
        abstractC0708d0.m6816a(false);
        if (z) {
            m6935a(abstractC0708d0);
        }
        if (abstractC0708d0 != abstractC0708d02) {
            if (z2) {
                m6935a(abstractC0708d02);
            }
            abstractC0708d0.f4220h = abstractC0708d02;
            m6935a(abstractC0708d0);
            this.f4136b.m6551e(abstractC0708d0);
            abstractC0708d02.m6816a(false);
            abstractC0708d02.f4221i = abstractC0708d0;
        }
        if (this.f4124N.mo1052a(abstractC0708d0, abstractC0708d02, c0719c, c0719c2)) {
            m6967C();
        }
    }

    /* renamed from: a */
    public void m6945a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int m8370b = this.f4142e.m8370b();
        for (int i4 = 0; i4 < m8370b; i4++) {
            AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i4));
            if (m6860m != null && !m6860m.m6789z()) {
                int i5 = m6860m.f4215c;
                if (i5 >= i3) {
                    m6860m.m6820a(-i2, z);
                    this.f4151i0.f4192g = true;
                } else if (i5 >= i) {
                    m6860m.m6821a(i - 1, -i2, z);
                    this.f4151i0.f4192g = true;
                }
            }
        }
        this.f4136b.m6579a(i, i2, z);
        requestLayout();
    }

    /* renamed from: a */
    public void m6946a(int i, int i2, Object obj) {
        int i3;
        int m8370b = this.f4142e.m8370b();
        int i4 = i + i2;
        for (int i5 = 0; i5 < m8370b; i5++) {
            View m8362e = this.f4142e.m8362e(i5);
            AbstractC0708d0 m6860m = m6860m(m8362e);
            if (m6860m != null && !m6860m.m6789z() && (i3 = m6860m.f4215c) >= i && i3 < i4) {
                m6860m.m6823a(2);
                m6860m.m6817a(obj);
                ((C0727p) m8362e.getLayoutParams()).f4270c = true;
            }
        }
        this.f4136b.m6559c(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.support.p067v7.widget.RecyclerView.AbstractC0708d0 m6942a(int r6, boolean r7) {
        /*
            r5 = this;
            a.b.h.k.g0 r0 = r5.f4142e
            int r0 = r0.m8370b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            a.b.h.k.g0 r3 = r5.f4142e
            android.view.View r3 = r3.m8362e(r2)
            android.support.v7.widget.RecyclerView$d0 r3 = m6860m(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.m6797r()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f4215c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m6804k()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            a.b.h.k.g0 r1 = r5.f4142e
            android.view.View r4 = r3.f4213a
            boolean r1 = r1.m8363d(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.widget.RecyclerView.m6942a(int, boolean):android.support.v7.widget.RecyclerView$d0");
    }

    /* renamed from: a */
    public AbstractC0708d0 m6941a(long j) {
        AbstractC0711g abstractC0711g = this.f4157m;
        AbstractC0708d0 abstractC0708d0 = null;
        if (abstractC0711g != null && abstractC0711g.m6753c()) {
            int m8370b = this.f4142e.m8370b();
            for (int i = 0; i < m8370b; i++) {
                AbstractC0708d0 m6860m = m6860m(this.f4142e.m8362e(i));
                if (m6860m != null && !m6860m.m6797r() && m6860m.m6806i() == j) {
                    if (!this.f4142e.m8363d(m6860m.f4213a)) {
                        return m6860m;
                    }
                    abstractC0708d0 = m6860m;
                }
            }
        }
        return abstractC0708d0;
    }

    /* renamed from: a */
    public static void m6919a(View view, Rect rect) {
        C0727p c0727p = (C0727p) view.getLayoutParams();
        Rect rect2 = c0727p.f4269b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) c0727p).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) c0727p).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) c0727p).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0727p).bottomMargin);
    }

    /* renamed from: a */
    public void m6920a(View view) {
        AbstractC0708d0 m6860m = m6860m(view);
        m6870i(view);
        AbstractC0711g abstractC0711g = this.f4157m;
        if (abstractC0711g != null && m6860m != null) {
            abstractC0711g.mo1034b((AbstractC0711g) m6860m);
        }
        List<InterfaceC0728q> list = this.f4114D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4114D.get(size).m6600a(view);
            }
        }
    }

    /* renamed from: a */
    public boolean m6934a(AbstractC0708d0 abstractC0708d0, int i) {
        if (m6849x()) {
            abstractC0708d0.f4229r = i;
            this.f4180x0.add(abstractC0708d0);
            return false;
        }
        ViewCompat.m9429f(abstractC0708d0.f4213a, i);
        return true;
    }

    /* renamed from: a */
    public void m6937a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0406a.fastscroll_default_thickness), resources.getDimensionPixelSize(C0406a.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0406a.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + m6859n());
    }

    @Override // p000a.p006b.p030g.p045k.NestedScrollingChild2
    /* renamed from: a */
    public void mo6951a(int i) {
        getScrollingChildHelper().m9483d(i);
    }

    /* renamed from: a */
    public boolean m6949a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m9492a(i, i2, i3, i4, iArr, i5);
    }

    /* renamed from: a */
    public boolean m6943a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m9490a(i, i2, iArr, iArr2, i3);
    }
}
