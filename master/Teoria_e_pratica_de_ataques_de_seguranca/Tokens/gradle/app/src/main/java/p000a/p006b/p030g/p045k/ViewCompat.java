package p000a.p006b.p030g.p045k;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p006b.p007a.C0017b;

/* renamed from: a.b.g.k.u */
/* loaded from: classes.dex */
public class ViewCompat {

    /* renamed from: a */
    public static Field f1643a;

    /* renamed from: b */
    public static boolean f1644b;

    /* renamed from: c */
    public static Field f1645c;

    /* renamed from: d */
    public static boolean f1646d;

    /* renamed from: e */
    public static WeakHashMap<View, String> f1647e;

    /* renamed from: f */
    public static WeakHashMap<View, ViewPropertyAnimatorCompat> f1648f;

    /* renamed from: g */
    public static Field f1649g;

    /* renamed from: h */
    public static boolean f1650h;

    /* renamed from: i */
    public static ThreadLocal<Rect> f1651i;

    /* compiled from: ViewCompat.java */
    /* renamed from: a.b.g.k.u$a */
    /* loaded from: classes.dex */
    public static class View$OnApplyWindowInsetsListenerC0287a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        public final /* synthetic */ OnApplyWindowInsetsListener f1652a;

        public View$OnApplyWindowInsetsListenerC0287a(OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            this.f1652a = onApplyWindowInsetsListener;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) WindowInsetsCompat.m9575a(this.f1652a.mo7712a(view, WindowInsetsCompat.m9574a(windowInsets)));
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: a.b.g.k.u$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0288b {
        /* renamed from: a */
        boolean m9406a(View view, KeyEvent keyEvent);
    }

    static {
        new AtomicInteger(1);
        f1648f = null;
        f1650h = false;
    }

    /* renamed from: A */
    public static void m9464A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: B */
    public static void m9463B(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: C */
    public static void m9462C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    /* renamed from: D */
    public static void m9461D(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: a */
    public static Rect m9460a() {
        if (f1651i == null) {
            f1651i = new ThreadLocal<>();
        }
        Rect rect = f1651i.get();
        if (rect == null) {
            rect = new Rect();
            f1651i.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: b */
    public static void m9437b(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    /* renamed from: c */
    public static ColorStateList m9436c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* renamed from: d */
    public static PorterDuff.Mode m9434d(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* renamed from: e */
    public static void m9431e(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    /* renamed from: f */
    public static void m9429f(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            view.setImportantForAccessibility(i);
        } else if (i2 >= 16) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    /* renamed from: g */
    public static void m9427g(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    /* renamed from: h */
    public static boolean m9426h(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    /* renamed from: i */
    public static int m9424i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: j */
    public static int m9423j(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* renamed from: k */
    public static int m9422k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* renamed from: l */
    public static int m9421l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1646d) {
            try {
                f1645c = View.class.getDeclaredField("mMinHeight");
                f1645c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1646d = true;
        }
        Field field = f1645c;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: m */
    public static int m9420m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1644b) {
            try {
                f1643a = View.class.getDeclaredField("mMinWidth");
                f1643a.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1644b = true;
        }
        Field field = f1643a;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: n */
    public static int m9419n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    /* renamed from: o */
    public static int m9418o(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    /* renamed from: p */
    public static String m9417p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1647e;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    /* renamed from: q */
    public static int m9416q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: r */
    public static float m9415r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: s */
    public static boolean m9414s(View view) {
        if (f1650h) {
            return false;
        }
        if (f1649g == null) {
            try {
                f1649g = View.class.getDeclaredField("mAccessibilityDelegate");
                f1649g.setAccessible(true);
            } catch (Throwable unused) {
                f1650h = true;
                return false;
            }
        }
        try {
            return f1649g.get(view) != null;
        } catch (Throwable unused2) {
            f1650h = true;
            return false;
        }
    }

    /* renamed from: t */
    public static boolean m9413t(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: u */
    public static boolean m9412u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    /* renamed from: v */
    public static boolean m9411v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* renamed from: w */
    public static boolean m9410w(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* renamed from: x */
    public static boolean m9409x(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: y */
    public static boolean m9408y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* renamed from: z */
    public static boolean m9407z(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: a.b.g.k.u$c */
    /* loaded from: classes.dex */
    public static class C0289c {

        /* renamed from: d */
        public static final ArrayList<WeakReference<View>> f1653d = new ArrayList<>();

        /* renamed from: a */
        public WeakHashMap<View, Boolean> f1654a = null;

        /* renamed from: b */
        public SparseArray<WeakReference<View>> f1655b = null;

        /* renamed from: c */
        public WeakReference<KeyEvent> f1656c = null;

        /* renamed from: a */
        public final SparseArray<WeakReference<View>> m9405a() {
            if (this.f1655b == null) {
                this.f1655b = new SparseArray<>();
            }
            return this.f1655b;
        }

        /* renamed from: b */
        public final View m9400b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1654a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View m9400b = m9400b(viewGroup.getChildAt(childCount), keyEvent);
                        if (m9400b != null) {
                            return m9400b;
                        }
                    }
                }
                if (m9399c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /* renamed from: c */
        public final boolean m9399c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C0017b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((InterfaceC0288b) arrayList.get(size)).m9406a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        /* renamed from: a */
        public static C0289c m9403a(View view) {
            C0289c c0289c = (C0289c) view.getTag(C0017b.tag_unhandled_key_event_manager);
            if (c0289c == null) {
                C0289c c0289c2 = new C0289c();
                view.setTag(C0017b.tag_unhandled_key_event_manager, c0289c2);
                return c0289c2;
            }
            return c0289c;
        }

        /* renamed from: a */
        public boolean m9402a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m9401b();
            }
            View m9400b = m9400b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (m9400b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m9405a().put(keyCode, new WeakReference<>(m9400b));
                }
            }
            return m9400b != null;
        }

        /* renamed from: b */
        public final void m9401b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1654a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1653d.isEmpty()) {
                return;
            }
            synchronized (f1653d) {
                if (this.f1654a == null) {
                    this.f1654a = new WeakHashMap<>();
                }
                for (int size = f1653d.size() - 1; size >= 0; size--) {
                    View view = f1653d.get(size).get();
                    if (view == null) {
                        f1653d.remove(size);
                    } else {
                        this.f1654a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1654a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public boolean m9404a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1656c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.f1656c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> m9405a = m9405a();
                if (keyEvent.getAction() == 1 && (indexOfKey = m9405a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = m9405a.valueAt(indexOfKey);
                    m9405a.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = m9405a.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && ViewCompat.m9410w(view)) {
                        m9399c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: b */
    public static int m9441b(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: e */
    public static Rect m9432e(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    /* renamed from: g */
    public static float m9428g(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* renamed from: h */
    public static void m9425h(View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).mo6951a(i);
        } else if (i == 0) {
            m9462C(view);
        }
    }

    /* renamed from: f */
    public static Display m9430f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m9410w(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* renamed from: b */
    public static WindowInsetsCompat m9439b(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.m9575a(windowInsetsCompat);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return WindowInsetsCompat.m9574a(windowInsets);
        }
        return windowInsetsCompat;
    }

    /* renamed from: c */
    public static void m9435c(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
        } else if (i2 >= 21) {
            Rect m9460a = m9460a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                m9460a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !m9460a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m9457a(view, i);
            if (z && m9460a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(m9460a);
            }
        } else {
            m9457a(view, i);
        }
    }

    /* renamed from: d */
    public static void m9433d(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
        } else if (i2 >= 21) {
            Rect m9460a = m9460a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                m9460a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !m9460a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m9440b(view, i);
            if (z && m9460a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(m9460a);
            }
        } else {
            m9440b(view, i);
        }
    }

    /* renamed from: a */
    public static void m9454a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.m9587a());
    }

    /* renamed from: a */
    public static void m9445a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: b */
    public static void m9440b(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m9461D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m9461D((View) parent);
            }
        }
    }

    /* renamed from: a */
    public static void m9444a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: a */
    public static void m9455a(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    /* renamed from: b */
    public static boolean m9438b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0289c.m9403a(view).m9404a(keyEvent);
    }

    /* renamed from: a */
    public static ViewPropertyAnimatorCompat m9459a(View view) {
        if (f1648f == null) {
            f1648f = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = f1648f.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            f1648f.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    /* renamed from: a */
    public static void m9458a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    /* renamed from: a */
    public static void m9443a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1647e == null) {
            f1647e = new WeakHashMap<>();
        }
        f1647e.put(view, str);
    }

    @Deprecated
    /* renamed from: a */
    public static void m9442a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: a */
    public static void m9452a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListenerC0287a(onApplyWindowInsetsListener));
            }
        }
    }

    /* renamed from: a */
    public static WindowInsetsCompat m9453a(View view, WindowInsetsCompat windowInsetsCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.m9575a(windowInsetsCompat);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (dispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(dispatchApplyWindowInsets);
            }
            return WindowInsetsCompat.m9574a(windowInsets);
        }
        return windowInsetsCompat;
    }

    /* renamed from: a */
    public static void m9447a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: a */
    public static void m9450a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m9449a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: a */
    public static void m9457a(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m9461D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m9461D((View) parent);
            }
        }
    }

    /* renamed from: a */
    public static void m9448a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: a */
    public static void m9456a(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: a */
    public static void m9451a(View view, PointerIconCompat pointerIconCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.m9466a() : null));
        }
    }

    /* renamed from: a */
    public static boolean m9446a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0289c.m9403a(view).m9402a(view, keyEvent);
    }
}
