package android.support.design.widget;

import a.b.d.x.o;
import a.b.g.k.d0;
import a.b.g.k.e0.b;
import a.b.g.k.u;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final Handler j;
    public static final boolean k;
    public static final int[] l;

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f2120a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2121b;

    /* renamed from: c  reason: collision with root package name */
    public final p f2122c;

    /* renamed from: d  reason: collision with root package name */
    public final a.b.d.u.a f2123d;

    /* renamed from: e  reason: collision with root package name */
    public int f2124e;

    /* renamed from: f  reason: collision with root package name */
    public List<l<B>> f2125f;

    /* renamed from: g  reason: collision with root package name */
    public Behavior f2126g;

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f2127h;

    /* renamed from: i  reason: collision with root package name */
    public final o.b f2128i = new f();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        public final m k = new m(this);

        public final void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.a(baseTransientBottomBar);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        public boolean a(View view) {
            return this.k.a(view);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
        }
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2129a;

        public a(int i2) {
            this.f2129a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.d(this.f2129a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f2123d.b(0, 180);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public int f2131a = 0;

        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.k) {
                u.d(BaseTransientBottomBar.this.f2122c, intValue - this.f2131a);
            } else {
                BaseTransientBottomBar.this.f2122c.setTranslationY(intValue);
            }
            this.f2131a = intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).n();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).c(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.b.g.k.p {
        public d(BaseTransientBottomBar baseTransientBottomBar) {
        }

        @Override // a.b.g.k.p
        public d0 a(View view, d0 d0Var) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), d0Var.a());
            return d0Var;
        }
    }

    /* loaded from: classes.dex */
    public class f implements o.b {
        public f() {
        }

        @Override // a.b.d.x.o.b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.j;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // a.b.d.x.o.b
        public void d() {
            Handler handler = BaseTransientBottomBar.j;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* loaded from: classes.dex */
    public class h implements n {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.d(3);
            }
        }

        public h() {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.n
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.n
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.j()) {
                BaseTransientBottomBar.j.post(new a());
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements o {
        public i() {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.o
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.f2122c.setOnLayoutChangeListener(null);
            if (BaseTransientBottomBar.this.l()) {
                BaseTransientBottomBar.this.a();
            } else {
                BaseTransientBottomBar.this.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.k();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f2123d.a(70, 180);
        }
    }

    /* loaded from: classes.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public int f2140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2141b;

        public k(int i2) {
            this.f2141b = i2;
            this.f2140a = this.f2141b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.k) {
                u.d(BaseTransientBottomBar.this.f2122c, intValue - this.f2140a);
            } else {
                BaseTransientBottomBar.this.f2122c.setTranslationY(intValue);
            }
            this.f2140a = intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public o.b f2143a;

        public m(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.b(0.1f);
            swipeDismissBehavior.a(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f2143a = baseTransientBottomBar.f2128i;
        }

        public boolean a(View view) {
            return view instanceof p;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    a.b.d.x.o.b().g(this.f2143a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                a.b.d.x.o.b().h(this.f2143a);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface n {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* loaded from: classes.dex */
    public interface o {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes.dex */
    public static class p extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityManager f2144a;

        /* renamed from: b  reason: collision with root package name */
        public final b.a f2145b;

        /* renamed from: c  reason: collision with root package name */
        public o f2146c;

        /* renamed from: d  reason: collision with root package name */
        public n f2147d;

        /* loaded from: classes.dex */
        public class a implements b.a {
            public a() {
            }

            @Override // a.b.g.k.e0.b.a
            public void onTouchExplorationStateChanged(boolean z) {
                p.this.setClickableOrFocusableBasedOnAccessibility(z);
            }
        }

        public p(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            n nVar = this.f2147d;
            if (nVar != null) {
                nVar.onViewAttachedToWindow(this);
            }
            u.B(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            n nVar = this.f2147d;
            if (nVar != null) {
                nVar.onViewDetachedFromWindow(this);
            }
            a.b.g.k.e0.b.b(this.f2144a, this.f2145b);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            o oVar = this.f2146c;
            if (oVar != null) {
                oVar.a(this, i2, i3, i4, i5);
            }
        }

        public void setOnAttachStateChangeListener(n nVar) {
            this.f2147d = nVar;
        }

        public void setOnLayoutChangeListener(o oVar) {
            this.f2146c = oVar;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.d.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(a.b.d.k.SnackbarLayout_elevation)) {
                u.a(this, obtainStyledAttributes.getDimensionPixelSize(a.b.d.k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.f2144a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f2145b = new a();
            a.b.g.k.e0.b.a(this.f2144a, this.f2145b);
            setClickableOrFocusableBasedOnAccessibility(this.f2144a.isTouchExplorationEnabled());
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        k = i2 >= 16 && i2 <= 19;
        l = new int[]{a.b.d.b.snackbarStyle};
        j = new Handler(Looper.getMainLooper(), new c());
    }

    public BaseTransientBottomBar(ViewGroup viewGroup, View view, a.b.d.u.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar != null) {
            this.f2120a = viewGroup;
            this.f2123d = aVar;
            this.f2121b = viewGroup.getContext();
            a.b.d.q.g.a(this.f2121b);
            this.f2122c = (p) LayoutInflater.from(this.f2121b).inflate(f(), this.f2120a, false);
            this.f2122c.addView(view);
            u.e(this.f2122c, 1);
            u.f(this.f2122c, 1);
            u.a((View) this.f2122c, true);
            u.a(this.f2122c, new d(this));
            u.a(this.f2122c, new e());
            this.f2127h = (AccessibilityManager) this.f2121b.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }

    public void b() {
        b(3);
    }

    public Context c() {
        return this.f2121b;
    }

    public int d() {
        return this.f2124e;
    }

    public B e(int i2) {
        this.f2124e = i2;
        return this;
    }

    public int f() {
        return h() ? a.b.d.h.mtrl_layout_snackbar : a.b.d.h.design_layout_snackbar;
    }

    public final int g() {
        int height = this.f2122c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f2122c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public boolean h() {
        TypedArray obtainStyledAttributes = this.f2121b.obtainStyledAttributes(l);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public boolean i() {
        return a.b.d.x.o.b().a(this.f2128i);
    }

    public boolean j() {
        return a.b.d.x.o.b().b(this.f2128i);
    }

    public void k() {
        a.b.d.x.o.b().f(this.f2128i);
        List<l<B>> list = this.f2125f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2125f.get(size).a(this);
            }
        }
    }

    public boolean l() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.f2127h.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void m() {
        a.b.d.x.o.b().a(d(), this.f2128i);
    }

    public final void n() {
        if (this.f2122c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f2122c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f2126g;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = e();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehavior.a(new g());
                fVar.a(swipeDismissBehavior);
                fVar.f2191g = 80;
            }
            this.f2120a.addView(this.f2122c);
        }
        this.f2122c.setOnAttachStateChangeListener(new h());
        if (u.x(this.f2122c)) {
            if (l()) {
                a();
                return;
            } else {
                k();
                return;
            }
        }
        this.f2122c.setOnLayoutChangeListener(new i());
    }

    /* loaded from: classes.dex */
    public class g implements SwipeDismissBehavior.b {
        public g() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior.b
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.b(0);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior.b
        public void a(int i2) {
            if (i2 == 0) {
                a.b.d.x.o.b().h(BaseTransientBottomBar.this.f2128i);
            } else if (i2 == 1 || i2 == 2) {
                a.b.d.x.o.b().g(BaseTransientBottomBar.this.f2128i);
            }
        }
    }

    public B a(l<B> lVar) {
        if (lVar == null) {
            return this;
        }
        if (this.f2125f == null) {
            this.f2125f = new ArrayList();
        }
        this.f2125f.add(lVar);
        return this;
    }

    public void b(int i2) {
        a.b.d.x.o.b().a(this.f2128i, i2);
    }

    public final void c(int i2) {
        if (l() && this.f2122c.getVisibility() == 0) {
            a(i2);
        } else {
            d(i2);
        }
    }

    public void d(int i2) {
        a.b.d.x.o.b().e(this.f2128i);
        List<l<B>> list = this.f2125f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2125f.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f2122c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f2122c);
        }
    }

    public SwipeDismissBehavior<? extends View> e() {
        return new Behavior();
    }

    /* loaded from: classes.dex */
    public class e extends a.b.g.k.b {
        public e() {
        }

        @Override // a.b.g.k.b
        public void a(View view, a.b.g.k.e0.c cVar) {
            super.a(view, cVar);
            cVar.a(1048576);
            cVar.d(true);
        }

        @Override // a.b.g.k.b
        public boolean a(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                BaseTransientBottomBar.this.b();
                return true;
            }
            return super.a(view, i2, bundle);
        }
    }

    public void a() {
        int g2 = g();
        if (k) {
            u.d(this.f2122c, g2);
        } else {
            this.f2122c.setTranslationY(g2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(g2, 0);
        valueAnimator.setInterpolator(a.b.d.l.a.f211b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new j());
        valueAnimator.addUpdateListener(new k(g2));
        valueAnimator.start();
    }

    public final void a(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, g());
        valueAnimator.setInterpolator(a.b.d.l.a.f211b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new a(i2));
        valueAnimator.addUpdateListener(new b());
        valueAnimator.start();
    }
}
