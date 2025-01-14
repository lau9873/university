package android.support.design.widget;

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
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0046h;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p012d.p023u.ContentViewCallback;
import p000a.p006b.p012d.p026x.SnackbarManager;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.WindowInsetsCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityManagerCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: j */
    public static final Handler f3226j;

    /* renamed from: k */
    public static final boolean f3227k;

    /* renamed from: l */
    public static final int[] f3228l;

    /* renamed from: a */
    public final ViewGroup f3229a;

    /* renamed from: b */
    public final Context f3230b;

    /* renamed from: c */
    public final C0560p f3231c;

    /* renamed from: d */
    public final ContentViewCallback f3232d;

    /* renamed from: e */
    public int f3233e;

    /* renamed from: f */
    public List<AbstractC0556l<B>> f3234f;

    /* renamed from: g */
    public Behavior f3235g;

    /* renamed from: h */
    public final AccessibilityManager f3236h;

    /* renamed from: i */
    public final SnackbarManager.InterfaceC0077b f3237i = new C0549f();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k */
        public final C0557m f3238k = new C0557m(this);

        /* renamed from: a */
        public final void m7785a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3238k.m7782a(baseTransientBottomBar);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior
        /* renamed from: a */
        public boolean mo7606a(View view) {
            return this.f3238k.m7780a(view);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior, android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7608a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f3238k.m7781a(coordinatorLayout, view, motionEvent);
            return super.mo7608a(coordinatorLayout, (CoordinatorLayout) view, motionEvent);
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$a */
    /* loaded from: classes.dex */
    public class C0544a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f3239a;

        public C0544a(int i) {
            this.f3239a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m7797d(this.f3239a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3232d.mo7613b(0, 180);
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$b */
    /* loaded from: classes.dex */
    public class C0545b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public int f3241a = 0;

        public C0545b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f3227k) {
                ViewCompat.m9433d(BaseTransientBottomBar.this.f3231c, intValue - this.f3241a);
            } else {
                BaseTransientBottomBar.this.f3231c.setTranslationY(intValue);
            }
            this.f3241a = intValue;
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$c */
    /* loaded from: classes.dex */
    public static class C0546c implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).m7788n();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).m7798c(message.arg1);
                return true;
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$d */
    /* loaded from: classes.dex */
    public class C0547d implements OnApplyWindowInsetsListener {
        public C0547d(BaseTransientBottomBar baseTransientBottomBar) {
        }

        @Override // p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener
        /* renamed from: a */
        public WindowInsetsCompat mo7712a(View view, WindowInsetsCompat windowInsetsCompat) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.m9577a());
            return windowInsetsCompat;
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$f */
    /* loaded from: classes.dex */
    public class C0549f implements SnackbarManager.InterfaceC0077b {
        public C0549f() {
        }

        @Override // p000a.p006b.p012d.p026x.SnackbarManager.InterfaceC0077b
        /* renamed from: a */
        public void mo7784a(int i) {
            Handler handler = BaseTransientBottomBar.f3226j;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }

        @Override // p000a.p006b.p012d.p026x.SnackbarManager.InterfaceC0077b
        /* renamed from: d */
        public void mo7783d() {
            Handler handler = BaseTransientBottomBar.f3226j;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$h */
    /* loaded from: classes.dex */
    public class C0551h implements InterfaceC0558n {

        /* renamed from: android.support.design.widget.BaseTransientBottomBar$h$a */
        /* loaded from: classes.dex */
        public class RunnableC0552a implements Runnable {
            public RunnableC0552a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.m7797d(3);
            }
        }

        public C0551h() {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0558n
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0558n
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.m7791j()) {
                BaseTransientBottomBar.f3226j.post(new RunnableC0552a());
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$i */
    /* loaded from: classes.dex */
    public class C0553i implements InterfaceC0559o {
        public C0553i() {
        }

        @Override // android.support.design.widget.BaseTransientBottomBar.InterfaceC0559o
        /* renamed from: a */
        public void mo7779a(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.f3231c.setOnLayoutChangeListener(null);
            if (BaseTransientBottomBar.this.m7789l()) {
                BaseTransientBottomBar.this.m7804a();
            } else {
                BaseTransientBottomBar.this.m7790k();
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$j */
    /* loaded from: classes.dex */
    public class C0554j extends AnimatorListenerAdapter {
        public C0554j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m7790k();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f3232d.mo7616a(70, 180);
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$k */
    /* loaded from: classes.dex */
    public class C0555k implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public int f3250a;

        /* renamed from: b */
        public final /* synthetic */ int f3251b;

        public C0555k(int i) {
            this.f3251b = i;
            this.f3250a = this.f3251b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f3227k) {
                ViewCompat.m9433d(BaseTransientBottomBar.this.f3231c, intValue - this.f3250a);
            } else {
                BaseTransientBottomBar.this.f3231c.setTranslationY(intValue);
            }
            this.f3250a = intValue;
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$l */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0556l<B> {
        /* renamed from: a */
        public void mo7617a(B b) {
        }

        /* renamed from: a */
        public void mo905a(B b, int i) {
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$m */
    /* loaded from: classes.dex */
    public static class C0557m {

        /* renamed from: a */
        public SnackbarManager.InterfaceC0077b f3253a;

        public C0557m(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.m7604b(0.1f);
            swipeDismissBehavior.m7612a(0.6f);
            swipeDismissBehavior.m7610a(0);
        }

        /* renamed from: a */
        public void m7782a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f3253a = baseTransientBottomBar.f3237i;
        }

        /* renamed from: a */
        public boolean m7780a(View view) {
            return view instanceof C0560p;
        }

        /* renamed from: a */
        public void m7781a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.m7744a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    SnackbarManager.m10673b().m10666g(this.f3253a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                SnackbarManager.m10673b().m10665h(this.f3253a);
            }
        }
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$n */
    /* loaded from: classes.dex */
    public interface InterfaceC0558n {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$o */
    /* loaded from: classes.dex */
    public interface InterfaceC0559o {
        /* renamed from: a */
        void mo7779a(View view, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$p */
    /* loaded from: classes.dex */
    public static class C0560p extends FrameLayout {

        /* renamed from: a */
        public final AccessibilityManager f3254a;

        /* renamed from: b */
        public final AccessibilityManagerCompat.InterfaceC0282a f3255b;

        /* renamed from: c */
        public InterfaceC0559o f3256c;

        /* renamed from: d */
        public InterfaceC0558n f3257d;

        /* renamed from: android.support.design.widget.BaseTransientBottomBar$p$a */
        /* loaded from: classes.dex */
        public class C0561a implements AccessibilityManagerCompat.InterfaceC0282a {
            public C0561a() {
            }

            @Override // p000a.p006b.p030g.p045k.p046e0.AccessibilityManagerCompat.InterfaceC0282a
            public void onTouchExplorationStateChanged(boolean z) {
                C0560p.this.setClickableOrFocusableBasedOnAccessibility(z);
            }
        }

        public C0560p(Context context) {
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
            InterfaceC0558n interfaceC0558n = this.f3257d;
            if (interfaceC0558n != null) {
                interfaceC0558n.onViewAttachedToWindow(this);
            }
            ViewCompat.m9463B(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            InterfaceC0558n interfaceC0558n = this.f3257d;
            if (interfaceC0558n != null) {
                interfaceC0558n.onViewDetachedFromWindow(this);
            }
            AccessibilityManagerCompat.m9560b(this.f3254a, this.f3255b);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            InterfaceC0559o interfaceC0559o = this.f3256c;
            if (interfaceC0559o != null) {
                interfaceC0559o.mo7779a(this, i, i2, i3, i4);
            }
        }

        public void setOnAttachStateChangeListener(InterfaceC0558n interfaceC0558n) {
            this.f3257d = interfaceC0558n;
        }

        public void setOnLayoutChangeListener(InterfaceC0559o interfaceC0559o) {
            this.f3256c = interfaceC0559o;
        }

        public C0560p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(C0049k.SnackbarLayout_elevation)) {
                ViewCompat.m9458a(this, obtainStyledAttributes.getDimensionPixelSize(C0049k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.f3254a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f3255b = new C0561a();
            AccessibilityManagerCompat.m9561a(this.f3254a, this.f3255b);
            setClickableOrFocusableBasedOnAccessibility(this.f3254a.isTouchExplorationEnabled());
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f3227k = i >= 16 && i <= 19;
        f3228l = new int[]{C0040b.snackbarStyle};
        f3226j = new Handler(Looper.getMainLooper(), new C0546c());
    }

    public BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback != null) {
            this.f3229a = viewGroup;
            this.f3232d = contentViewCallback;
            this.f3230b = viewGroup.getContext();
            ThemeEnforcement.m10868a(this.f3230b);
            this.f3231c = (C0560p) LayoutInflater.from(this.f3230b).inflate(m7794f(), this.f3229a, false);
            this.f3231c.addView(view);
            ViewCompat.m9431e(this.f3231c, 1);
            ViewCompat.m9429f(this.f3231c, 1);
            ViewCompat.m9442a((View) this.f3231c, true);
            ViewCompat.m9452a(this.f3231c, new C0547d(this));
            ViewCompat.m9454a(this.f3231c, new C0548e());
            this.f3236h = (AccessibilityManager) this.f3230b.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }

    /* renamed from: b */
    public void mo7623b() {
        m7800b(3);
    }

    /* renamed from: c */
    public Context m7799c() {
        return this.f3230b;
    }

    /* renamed from: d */
    public int mo7622d() {
        return this.f3233e;
    }

    /* renamed from: e */
    public B m7795e(int i) {
        this.f3233e = i;
        return this;
    }

    /* renamed from: f */
    public int m7794f() {
        return m7792h() ? C0046h.mtrl_layout_snackbar : C0046h.design_layout_snackbar;
    }

    /* renamed from: g */
    public final int m7793g() {
        int height = this.f3231c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f3231c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* renamed from: h */
    public boolean m7792h() {
        TypedArray obtainStyledAttributes = this.f3230b.obtainStyledAttributes(f3228l);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    /* renamed from: i */
    public boolean mo7620i() {
        return SnackbarManager.m10673b().m10677a(this.f3237i);
    }

    /* renamed from: j */
    public boolean m7791j() {
        return SnackbarManager.m10673b().m10672b(this.f3237i);
    }

    /* renamed from: k */
    public void m7790k() {
        SnackbarManager.m10673b().m10667f(this.f3237i);
        List<AbstractC0556l<B>> list = this.f3234f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3234f.get(size).mo7617a(this);
            }
        }
    }

    /* renamed from: l */
    public boolean m7789l() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.f3236h.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    /* renamed from: m */
    public void mo7619m() {
        SnackbarManager.m10673b().m10678a(mo7622d(), this.f3237i);
    }

    /* renamed from: n */
    public final void m7788n() {
        if (this.f3231c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f3231c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0578f) {
                CoordinatorLayout.C0578f c0578f = (CoordinatorLayout.C0578f) layoutParams;
                SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f3235g;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = m7796e();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).m7785a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehavior.m7607a(new C0550g());
                c0578f.m7684a(swipeDismissBehavior);
                c0578f.f3333g = 80;
            }
            this.f3229a.addView(this.f3231c);
        }
        this.f3231c.setOnAttachStateChangeListener(new C0551h());
        if (ViewCompat.m9409x(this.f3231c)) {
            if (m7789l()) {
                m7804a();
                return;
            } else {
                m7790k();
                return;
            }
        }
        this.f3231c.setOnLayoutChangeListener(new C0553i());
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$g */
    /* loaded from: classes.dex */
    public class C0550g implements SwipeDismissBehavior.InterfaceC0589b {
        public C0550g() {
        }

        @Override // android.support.design.widget.SwipeDismissBehavior.InterfaceC0589b
        /* renamed from: a */
        public void mo7591a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.m7800b(0);
        }

        @Override // android.support.design.widget.SwipeDismissBehavior.InterfaceC0589b
        /* renamed from: a */
        public void mo7592a(int i) {
            if (i == 0) {
                SnackbarManager.m10673b().m10665h(BaseTransientBottomBar.this.f3237i);
            } else if (i == 1 || i == 2) {
                SnackbarManager.m10673b().m10666g(BaseTransientBottomBar.this.f3237i);
            }
        }
    }

    /* renamed from: a */
    public B m7802a(AbstractC0556l<B> abstractC0556l) {
        if (abstractC0556l == null) {
            return this;
        }
        if (this.f3234f == null) {
            this.f3234f = new ArrayList();
        }
        this.f3234f.add(abstractC0556l);
        return this;
    }

    /* renamed from: b */
    public void m7800b(int i) {
        SnackbarManager.m10673b().m10676a(this.f3237i, i);
    }

    /* renamed from: c */
    public final void m7798c(int i) {
        if (m7789l() && this.f3231c.getVisibility() == 0) {
            m7803a(i);
        } else {
            m7797d(i);
        }
    }

    /* renamed from: d */
    public void m7797d(int i) {
        SnackbarManager.m10673b().m10668e(this.f3237i);
        List<AbstractC0556l<B>> list = this.f3234f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3234f.get(size).mo905a(this, i);
            }
        }
        ViewParent parent = this.f3231c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f3231c);
        }
    }

    /* renamed from: e */
    public SwipeDismissBehavior<? extends View> m7796e() {
        return new Behavior();
    }

    /* renamed from: android.support.design.widget.BaseTransientBottomBar$e */
    /* loaded from: classes.dex */
    public class C0548e extends AccessibilityDelegateCompat {
        public C0548e() {
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m9558a(1048576);
            accessibilityNodeInfoCompat.m9540d(true);
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public boolean mo7333a(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                BaseTransientBottomBar.this.mo7623b();
                return true;
            }
            return super.mo7333a(view, i, bundle);
        }
    }

    /* renamed from: a */
    public void m7804a() {
        int m7793g = m7793g();
        if (f3227k) {
            ViewCompat.m9433d(this.f3231c, m7793g);
        } else {
            this.f3231c.setTranslationY(m7793g);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(m7793g, 0);
        valueAnimator.setInterpolator(AnimationUtils.f422b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new C0554j());
        valueAnimator.addUpdateListener(new C0555k(m7793g));
        valueAnimator.start();
    }

    /* renamed from: a */
    public final void m7803a(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, m7793g());
        valueAnimator.setInterpolator(AnimationUtils.f422b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new C0544a(i));
        valueAnimator.addUpdateListener(new C0545b());
        valueAnimator.start();
    }
}
