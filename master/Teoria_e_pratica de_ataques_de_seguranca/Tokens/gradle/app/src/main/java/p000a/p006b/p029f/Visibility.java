package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p029f.AnimatorUtils;
import p000a.p006b.p029f.Transition;

/* renamed from: a.b.f.i0 */
/* loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* renamed from: L */
    public static final String[] f918L = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: K */
    public int f919K = 3;

    /* compiled from: Visibility.java */
    /* renamed from: a.b.f.i0$a */
    /* loaded from: classes.dex */
    public class C0116a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroupOverlayImpl f920a;

        /* renamed from: b */
        public final /* synthetic */ View f921b;

        public C0116a(Visibility visibility, ViewGroupOverlayImpl viewGroupOverlayImpl, View view) {
            this.f920a = viewGroupOverlayImpl;
            this.f921b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f920a.mo10424b(this.f921b);
        }
    }

    /* compiled from: Visibility.java */
    /* renamed from: a.b.f.i0$b */
    /* loaded from: classes.dex */
    public static class C0117b extends AnimatorListenerAdapter implements Transition.InterfaceC0125f, AnimatorUtils.InterfaceC0094a {

        /* renamed from: a */
        public final View f922a;

        /* renamed from: b */
        public final int f923b;

        /* renamed from: c */
        public final ViewGroup f924c;

        /* renamed from: d */
        public final boolean f925d;

        /* renamed from: e */
        public boolean f926e;

        /* renamed from: f */
        public boolean f927f = false;

        public C0117b(View view, int i, boolean z) {
            this.f922a = view;
            this.f923b = i;
            this.f924c = (ViewGroup) view.getParent();
            this.f925d = z;
            m10506a(true);
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: a */
        public void mo10466a(Transition transition) {
            m10506a(false);
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            m10507a();
            transition.mo10442b(this);
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: c */
        public void mo10432c(Transition transition) {
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: d */
        public void mo10465d(Transition transition) {
            m10506a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f927f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m10507a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p000a.p006b.p029f.AnimatorUtils.InterfaceC0094a
        public void onAnimationPause(Animator animator) {
            if (this.f927f) {
                return;
            }
            C0109d0.m10542a(this.f922a, this.f923b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p000a.p006b.p029f.AnimatorUtils.InterfaceC0094a
        public void onAnimationResume(Animator animator) {
            if (this.f927f) {
                return;
            }
            C0109d0.m10542a(this.f922a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        /* renamed from: a */
        public final void m10507a() {
            if (!this.f927f) {
                C0109d0.m10542a(this.f922a, this.f923b);
                ViewGroup viewGroup = this.f924c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m10506a(false);
        }

        /* renamed from: a */
        public final void m10506a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f925d || this.f926e == z || (viewGroup = this.f924c) == null) {
                return;
            }
            this.f926e = z;
            ViewGroupUtils.m10422a(viewGroup, z);
        }
    }

    /* compiled from: Visibility.java */
    /* renamed from: a.b.f.i0$c */
    /* loaded from: classes.dex */
    public static class C0118c {

        /* renamed from: a */
        public boolean f928a;

        /* renamed from: b */
        public boolean f929b;

        /* renamed from: c */
        public int f930c;

        /* renamed from: d */
        public int f931d;

        /* renamed from: e */
        public ViewGroup f932e;

        /* renamed from: f */
        public ViewGroup f933f;
    }

    /* renamed from: a */
    public abstract Animator mo10512a(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2);

    /* renamed from: a */
    public void m10514a(int i) {
        if ((i & (-4)) == 0) {
            this.f919K = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    /* renamed from: b */
    public final C0118c m10511b(TransitionValues transitionValues, TransitionValues transitionValues2) {
        C0118c c0118c = new C0118c();
        c0118c.f928a = false;
        c0118c.f929b = false;
        if (transitionValues != null && transitionValues.f999a.containsKey("android:visibility:visibility")) {
            c0118c.f930c = ((Integer) transitionValues.f999a.get("android:visibility:visibility")).intValue();
            c0118c.f932e = (ViewGroup) transitionValues.f999a.get("android:visibility:parent");
        } else {
            c0118c.f930c = -1;
            c0118c.f932e = null;
        }
        if (transitionValues2 != null && transitionValues2.f999a.containsKey("android:visibility:visibility")) {
            c0118c.f931d = ((Integer) transitionValues2.f999a.get("android:visibility:visibility")).intValue();
            c0118c.f933f = (ViewGroup) transitionValues2.f999a.get("android:visibility:parent");
        } else {
            c0118c.f931d = -1;
            c0118c.f933f = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            if (c0118c.f930c == c0118c.f931d && c0118c.f932e == c0118c.f933f) {
                return c0118c;
            }
            int i = c0118c.f930c;
            int i2 = c0118c.f931d;
            if (i != i2) {
                if (i == 0) {
                    c0118c.f929b = false;
                    c0118c.f928a = true;
                } else if (i2 == 0) {
                    c0118c.f929b = true;
                    c0118c.f928a = true;
                }
            } else if (c0118c.f933f == null) {
                c0118c.f929b = false;
                c0118c.f928a = true;
            } else if (c0118c.f932e == null) {
                c0118c.f929b = true;
                c0118c.f928a = true;
            }
        } else if (transitionValues == null && c0118c.f931d == 0) {
            c0118c.f929b = true;
            c0118c.f928a = true;
        } else if (transitionValues2 == null && c0118c.f930c == 0) {
            c0118c.f929b = false;
            c0118c.f928a = true;
        }
        return c0118c;
    }

    /* renamed from: b */
    public abstract Animator mo10509b(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2);

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10440c(TransitionValues transitionValues) {
        m10508d(transitionValues);
    }

    /* renamed from: d */
    public final void m10508d(TransitionValues transitionValues) {
        transitionValues.f999a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f1000b.getVisibility()));
        transitionValues.f999a.put("android:visibility:parent", transitionValues.f1000b.getParent());
        int[] iArr = new int[2];
        transitionValues.f1000b.getLocationOnScreen(iArr);
        transitionValues.f999a.put("android:visibility:screenLocation", iArr);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: o */
    public String[] mo10470o() {
        return f918L;
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10449a(TransitionValues transitionValues) {
        m10508d(transitionValues);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public Animator mo10488a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        C0118c m10511b = m10511b(transitionValues, transitionValues2);
        if (m10511b.f928a) {
            if (m10511b.f932e == null && m10511b.f933f == null) {
                return null;
            }
            if (m10511b.f929b) {
                return m10513a(viewGroup, transitionValues, m10511b.f930c, transitionValues2, m10511b.f931d);
            }
            return m10510b(viewGroup, transitionValues, m10511b.f930c, transitionValues2, m10511b.f931d);
        }
        return null;
    }

    /* renamed from: a */
    public Animator m10513a(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.f919K & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f1000b.getParent();
            if (m10511b(m10482b(view, false), m10480c(view, false)).f928a) {
                return null;
            }
        }
        return mo10512a(viewGroup, transitionValues2.f1000b, transitionValues, transitionValues2);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public boolean mo10500a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues == null || transitionValues2 == null || transitionValues2.f999a.containsKey("android:visibility:visibility") == transitionValues.f999a.containsKey("android:visibility:visibility")) {
            C0118c m10511b = m10511b(transitionValues, transitionValues2);
            if (m10511b.f928a) {
                return m10511b.f930c == 0 || m10511b.f931d == 0;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee A[RETURN] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator m10510b(android.view.ViewGroup r7, p000a.p006b.p029f.TransitionValues r8, int r9, p000a.p006b.p029f.TransitionValues r10, int r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p029f.Visibility.m10510b(android.view.ViewGroup, a.b.f.s, int, a.b.f.s, int):android.animation.Animator");
    }
}
