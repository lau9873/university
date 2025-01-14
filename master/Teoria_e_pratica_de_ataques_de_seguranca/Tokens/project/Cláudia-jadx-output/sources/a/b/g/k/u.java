package a.b.g.k;

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
/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f1132a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1133b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f1134c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1135d;

    /* renamed from: e  reason: collision with root package name */
    public static WeakHashMap<View, String> f1136e;

    /* renamed from: f  reason: collision with root package name */
    public static WeakHashMap<View, z> f1137f;

    /* renamed from: g  reason: collision with root package name */
    public static Field f1138g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f1139h;

    /* renamed from: i  reason: collision with root package name */
    public static ThreadLocal<Rect> f1140i;

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f1141a;

        public a(p pVar) {
            this.f1141a = pVar;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return (WindowInsets) d0.a(this.f1141a.a(view, d0.a(windowInsets)));
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(View view, KeyEvent keyEvent);
    }

    static {
        new AtomicInteger(1);
        f1137f = null;
        f1139h = false;
    }

    public static void A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void B(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof k) {
            ((k) view).stopNestedScroll();
        }
    }

    public static void D(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static Rect a() {
        if (f1140i == null) {
            f1140i = new ThreadLocal<>();
        }
        Rect rect = f1140i.get();
        if (rect == null) {
            rect = new Rect();
            f1140i.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void b(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static ColorStateList c(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode d(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void e(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static void f(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static boolean h(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1135d) {
            try {
                f1134c = View.class.getDeclaredField("mMinHeight");
                f1134c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1135d = true;
        }
        Field field = f1134c;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1133b) {
            try {
                f1132a = View.class.getDeclaredField("mMinWidth");
                f1132a.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1133b = true;
        }
        Field field = f1132a;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static String p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1136e;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean s(View view) {
        if (f1139h) {
            return false;
        }
        if (f1138g == null) {
            try {
                f1138g = View.class.getDeclaredField("mAccessibilityDelegate");
                f1138g.setAccessible(true);
            } catch (Throwable unused) {
                f1139h = true;
                return false;
            }
        }
        try {
            return f1138g.get(view) != null;
        } catch (Throwable unused2) {
            f1139h = true;
            return false;
        }
    }

    public static boolean t(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean w(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof k) {
            return ((k) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean z(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f1142d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap<View, Boolean> f1143a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f1144b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<KeyEvent> f1145c = null;

        public final SparseArray<WeakReference<View>> a() {
            if (this.f1144b == null) {
                this.f1144b = new SparseArray<>();
            }
            return this.f1144b;
        }

        public final View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1143a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(a.b.a.b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((b) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public static c a(View view) {
            c cVar = (c) view.getTag(a.b.a.b.tag_unhandled_key_event_manager);
            if (cVar == null) {
                c cVar2 = new c();
                view.setTag(a.b.a.b.tag_unhandled_key_event_manager, cVar2);
                return cVar2;
            }
            return cVar;
        }

        public boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b2));
                }
            }
            return b2 != null;
        }

        public final void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1143a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1142d.isEmpty()) {
                return;
            }
            synchronized (f1142d) {
                if (this.f1143a == null) {
                    this.f1143a = new WeakHashMap<>();
                }
                for (int size = f1142d.size() - 1; size >= 0; size--) {
                    View view = f1142d.get(size).get();
                    if (view == null) {
                        f1142d.remove(size);
                    } else {
                        this.f1143a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1143a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        public boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1145c;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.f1145c = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> a2 = a();
                if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = a2.valueAt(indexOfKey);
                    a2.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = a2.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && u.w(view)) {
                        c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static int b(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static Rect e(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static float g(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void h(View view, int i2) {
        if (view instanceof j) {
            ((j) view).a(i2);
        } else if (i2 == 0) {
            C(view);
        }
    }

    public static Display f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (w(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static d0 b(View view, d0 d0Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) d0.a(d0Var);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (onApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(onApplyWindowInsets);
            }
            return d0.a(windowInsets);
        }
        return d0Var;
    }

    public static void c(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (i3 >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            a(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            a(view, i2);
        }
    }

    public static void d(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (i3 >= 21) {
            Rect a2 = a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            b(view, i2);
            if (z && a2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a2);
            }
        } else {
            b(view, i2);
        }
    }

    public static void a(View view, a.b.g.k.b bVar) {
        view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void b(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D((View) parent);
            }
        }
    }

    public static void a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(keyEvent);
    }

    public static z a(View view) {
        if (f1137f == null) {
            f1137f = new WeakHashMap<>();
        }
        z zVar = f1137f.get(view);
        if (zVar == null) {
            z zVar2 = new z(view);
            f1137f.put(view, zVar2);
            return zVar2;
        }
        return zVar;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1136e == null) {
            f1136e = new WeakHashMap<>();
        }
        f1136e.put(view, str);
    }

    @Deprecated
    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new a(pVar));
            }
        }
    }

    public static d0 a(View view, d0 d0Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets windowInsets = (WindowInsets) d0.a(d0Var);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (dispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(dispatchApplyWindowInsets);
            }
            return d0.a(windowInsets);
        }
        return d0Var;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
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
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, PorterDuff.Mode mode) {
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
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D((View) parent);
            }
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, r rVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (rVar != null ? rVar.a() : null));
        }
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(view, keyEvent);
    }
}
