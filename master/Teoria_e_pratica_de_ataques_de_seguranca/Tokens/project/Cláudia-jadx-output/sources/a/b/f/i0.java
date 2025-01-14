package a.b.f;

import a.b.f.a;
import a.b.f.m;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class i0 extends m {
    public static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    public int K = 3;

    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f538a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f539b;

        public a(i0 i0Var, w wVar, View view) {
            this.f538a = wVar;
            this.f539b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f538a.b(this.f539b);
        }
    }

    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.InterfaceC0011a {

        /* renamed from: a  reason: collision with root package name */
        public final View f540a;

        /* renamed from: b  reason: collision with root package name */
        public final int f541b;

        /* renamed from: c  reason: collision with root package name */
        public final ViewGroup f542c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f543d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f544e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f545f = false;

        public b(View view, int i2, boolean z) {
            this.f540a = view;
            this.f541b = i2;
            this.f542c = (ViewGroup) view.getParent();
            this.f543d = z;
            a(true);
        }

        @Override // a.b.f.m.f
        public void a(m mVar) {
            a(false);
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            a();
            mVar.b(this);
        }

        @Override // a.b.f.m.f
        public void c(m mVar) {
        }

        @Override // a.b.f.m.f
        public void d(m mVar) {
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f545f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.b.f.a.InterfaceC0011a
        public void onAnimationPause(Animator animator) {
            if (this.f545f) {
                return;
            }
            d0.a(this.f540a, this.f541b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.b.f.a.InterfaceC0011a
        public void onAnimationResume(Animator animator) {
            if (this.f545f) {
                return;
            }
            d0.a(this.f540a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public final void a() {
            if (!this.f545f) {
                d0.a(this.f540a, this.f541b);
                ViewGroup viewGroup = this.f542c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        public final void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f543d || this.f544e == z || (viewGroup = this.f542c) == null) {
                return;
            }
            this.f544e = z;
            x.a(viewGroup, z);
        }
    }

    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f546a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f547b;

        /* renamed from: c  reason: collision with root package name */
        public int f548c;

        /* renamed from: d  reason: collision with root package name */
        public int f549d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f550e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f551f;
    }

    public abstract Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public void a(int i2) {
        if ((i2 & (-4)) == 0) {
            this.K = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public final c b(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f546a = false;
        cVar.f547b = false;
        if (sVar != null && sVar.f586a.containsKey("android:visibility:visibility")) {
            cVar.f548c = ((Integer) sVar.f586a.get("android:visibility:visibility")).intValue();
            cVar.f550e = (ViewGroup) sVar.f586a.get("android:visibility:parent");
        } else {
            cVar.f548c = -1;
            cVar.f550e = null;
        }
        if (sVar2 != null && sVar2.f586a.containsKey("android:visibility:visibility")) {
            cVar.f549d = ((Integer) sVar2.f586a.get("android:visibility:visibility")).intValue();
            cVar.f551f = (ViewGroup) sVar2.f586a.get("android:visibility:parent");
        } else {
            cVar.f549d = -1;
            cVar.f551f = null;
        }
        if (sVar != null && sVar2 != null) {
            if (cVar.f548c == cVar.f549d && cVar.f550e == cVar.f551f) {
                return cVar;
            }
            int i2 = cVar.f548c;
            int i3 = cVar.f549d;
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f547b = false;
                    cVar.f546a = true;
                } else if (i3 == 0) {
                    cVar.f547b = true;
                    cVar.f546a = true;
                }
            } else if (cVar.f551f == null) {
                cVar.f547b = false;
                cVar.f546a = true;
            } else if (cVar.f550e == null) {
                cVar.f547b = true;
                cVar.f546a = true;
            }
        } else if (sVar == null && cVar.f549d == 0) {
            cVar.f547b = true;
            cVar.f546a = true;
        } else if (sVar2 == null && cVar.f548c == 0) {
            cVar.f547b = false;
            cVar.f546a = true;
        }
        return cVar;
    }

    public abstract Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // a.b.f.m
    public void c(s sVar) {
        d(sVar);
    }

    public final void d(s sVar) {
        sVar.f586a.put("android:visibility:visibility", Integer.valueOf(sVar.f587b.getVisibility()));
        sVar.f586a.put("android:visibility:parent", sVar.f587b.getParent());
        int[] iArr = new int[2];
        sVar.f587b.getLocationOnScreen(iArr);
        sVar.f586a.put("android:visibility:screenLocation", iArr);
    }

    @Override // a.b.f.m
    public String[] o() {
        return L;
    }

    @Override // a.b.f.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // a.b.f.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        c b2 = b(sVar, sVar2);
        if (b2.f546a) {
            if (b2.f550e == null && b2.f551f == null) {
                return null;
            }
            if (b2.f547b) {
                return a(viewGroup, sVar, b2.f548c, sVar2, b2.f549d);
            }
            return b(viewGroup, sVar, b2.f548c, sVar2, b2.f549d);
        }
        return null;
    }

    public Animator a(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        if ((this.K & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f587b.getParent();
            if (b(b(view, false), c(view, false)).f546a) {
                return null;
            }
        }
        return a(viewGroup, sVar2.f587b, sVar, sVar2);
    }

    @Override // a.b.f.m
    public boolean a(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar == null || sVar2 == null || sVar2.f586a.containsKey("android:visibility:visibility") == sVar.f586a.containsKey("android:visibility:visibility")) {
            c b2 = b(sVar, sVar2);
            if (b2.f546a) {
                return b2.f548c == 0 || b2.f549d == 0;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator b(android.view.ViewGroup r7, a.b.f.s r8, int r9, a.b.f.s r10, int r11) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.i0.b(android.view.ViewGroup, a.b.f.s, int, a.b.f.s, int):android.animation.Animator");
    }
}
