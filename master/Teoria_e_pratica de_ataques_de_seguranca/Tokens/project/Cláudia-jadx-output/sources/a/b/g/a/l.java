package a.b.g.a;

import a.b.g.a.k;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class l extends a.b.g.a.k implements LayoutInflater.Factory2 {
    public static boolean F = false;
    public static Field G;
    public static final Interpolator H = new DecelerateInterpolator(2.5f);
    public static final Interpolator I = new DecelerateInterpolator(1.5f);
    public ArrayList<n> C;
    public a.b.g.a.m D;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<InterfaceC0015l> f690a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f691b;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Fragment> f694e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.b.g.a.c> f695f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<Fragment> f696g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<a.b.g.a.c> f697h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Integer> f698i;
    public ArrayList<k.c> j;
    public a.b.g.a.j n;
    public a.b.g.a.h o;
    public Fragment p;
    public Fragment q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public boolean w;
    public ArrayList<a.b.g.a.c> x;
    public ArrayList<Boolean> y;
    public ArrayList<Fragment> z;

    /* renamed from: c  reason: collision with root package name */
    public int f692c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<Fragment> f693d = new ArrayList<>();
    public final CopyOnWriteArrayList<j> k = new CopyOnWriteArrayList<>();
    public int m = 0;
    public Bundle A = null;
    public SparseArray<Parcelable> B = null;
    public Runnable E = new a();

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.u();
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f700b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f701c;

        /* compiled from: FragmentManager.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f701c.m() != null) {
                    b.this.f701c.a((View) null);
                    b bVar = b.this;
                    l lVar = l.this;
                    Fragment fragment = bVar.f701c;
                    lVar.a(fragment, fragment.F(), 0, 0, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Animation.AnimationListener animationListener, ViewGroup viewGroup, Fragment fragment) {
            super(animationListener);
            this.f700b = viewGroup;
            this.f701c = fragment;
        }

        @Override // a.b.g.a.l.f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            this.f700b.post(new a());
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f706c;

        public c(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f704a = viewGroup;
            this.f705b = view;
            this.f706c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f704a.endViewTransition(this.f705b);
            Animator n = this.f706c.n();
            this.f706c.a((Animator) null);
            if (n == null || this.f704a.indexOfChild(this.f705b) >= 0) {
                return;
            }
            l lVar = l.this;
            Fragment fragment = this.f706c;
            lVar.a(fragment, fragment.F(), 0, 0, false);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f708a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f710c;

        public d(l lVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f708a = viewGroup;
            this.f709b = view;
            this.f710c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f708a.endViewTransition(this.f709b);
            animator.removeListener(this);
            View view = this.f710c.J;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        public View f711b;

        /* compiled from: FragmentManager.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f711b.setLayerType(0, null);
            }
        }

        public e(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f711b = view;
        }

        @Override // a.b.g.a.l.f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!a.b.g.k.u.w(this.f711b) && Build.VERSION.SDK_INT < 24) {
                this.f711b.setLayerType(0, null);
            } else {
                this.f711b.post(new a());
            }
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final Animation.AnimationListener f713a;

        public f(Animation.AnimationListener animationListener) {
            this.f713a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f713a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f713a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f713a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public View f716a;

        public h(View view) {
            this.f716a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f716a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f716a.setLayerType(2, null);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static final class j {

        /* renamed from: a  reason: collision with root package name */
        public final k.b f722a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f723b;
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f724a = {16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$l  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0015l {
        boolean a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public class m implements InterfaceC0015l {

        /* renamed from: a  reason: collision with root package name */
        public final String f725a;

        /* renamed from: b  reason: collision with root package name */
        public final int f726b;

        /* renamed from: c  reason: collision with root package name */
        public final int f727c;

        public m(String str, int i2, int i3) {
            this.f725a = str;
            this.f726b = i2;
            this.f727c = i3;
        }

        @Override // a.b.g.a.l.InterfaceC0015l
        public boolean a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2) {
            a.b.g.a.k c0;
            Fragment fragment = l.this.q;
            if (fragment == null || this.f726b >= 0 || this.f725a != null || (c0 = fragment.c0()) == null || !c0.f()) {
                return l.this.a(arrayList, arrayList2, this.f725a, this.f726b, this.f727c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class n implements Fragment.e {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f729a;

        /* renamed from: b  reason: collision with root package name */
        public final a.b.g.a.c f730b;

        /* renamed from: c  reason: collision with root package name */
        public int f731c;

        public n(a.b.g.a.c cVar, boolean z) {
            this.f729a = z;
            this.f730b = cVar;
        }

        @Override // android.support.v4.app.Fragment.e
        public void a() {
            this.f731c--;
            if (this.f731c != 0) {
                return;
            }
            this.f730b.f635a.D();
        }

        @Override // android.support.v4.app.Fragment.e
        public void b() {
            this.f731c++;
        }

        public void c() {
            a.b.g.a.c cVar = this.f730b;
            cVar.f635a.a(cVar, this.f729a, false, false);
        }

        public void d() {
            boolean z = this.f731c > 0;
            l lVar = this.f730b.f635a;
            int size = lVar.f693d.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = lVar.f693d.get(i2);
                fragment.a((Fragment.e) null);
                if (z && fragment.O()) {
                    fragment.m0();
                }
            }
            a.b.g.a.c cVar = this.f730b;
            cVar.f635a.a(cVar, this.f729a, !z, true);
        }

        public boolean e() {
            return this.f731c == 0;
        }
    }

    static {
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public static boolean a(g gVar) {
        Animation animation = gVar.f714a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i2 = 0; i2 < animations.size(); i2++) {
                if (animations.get(i2) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(gVar.f715b);
    }

    public static int b(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? 1 : 2;
        } else if (i2 == 4099) {
            return z ? 5 : 6;
        } else if (i2 != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    public static boolean b(View view, g gVar) {
        return view != null && gVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && a.b.g.k.u.u(view) && a(gVar);
    }

    public static int e(int i2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                return i2 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    public a.b.g.a.m A() {
        a(this.D);
        return this.D;
    }

    public Parcelable B() {
        int[] iArr;
        int size;
        v();
        t();
        u();
        this.s = true;
        a.b.g.a.d[] dVarArr = null;
        this.D = null;
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.f694e.size();
        o[] oVarArr = new o[size2];
        boolean z = false;
        for (int i2 = 0; i2 < size2; i2++) {
            Fragment valueAt = this.f694e.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.f2252e >= 0) {
                    o oVar = new o(valueAt);
                    oVarArr[i2] = oVar;
                    if (valueAt.f2248a > 0 && oVar.k == null) {
                        oVar.k = n(valueAt);
                        Fragment fragment = valueAt.f2255h;
                        if (fragment != null) {
                            if (fragment.f2252e >= 0) {
                                if (oVar.k == null) {
                                    oVar.k = new Bundle();
                                }
                                a(oVar.k, "android:target_state", valueAt.f2255h);
                                int i3 = valueAt.j;
                                if (i3 != 0) {
                                    oVar.k.putInt("android:target_req_state", i3);
                                }
                            } else {
                                a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.f2255h));
                                throw null;
                            }
                        }
                    } else {
                        oVar.k = valueAt.f2249b;
                    }
                    if (F) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + oVar.k);
                    }
                    z = true;
                } else {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.f2252e));
                    throw null;
                }
            }
        }
        if (!z) {
            if (F) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.f693d.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i4 = 0; i4 < size3; i4++) {
                iArr[i4] = this.f693d.get(i4).f2252e;
                if (iArr[i4] >= 0) {
                    if (F) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.f693d.get(i4));
                    }
                } else {
                    a(new IllegalStateException("Failure saving state: active " + this.f693d.get(i4) + " has cleared index: " + iArr[i4]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<a.b.g.a.c> arrayList = this.f695f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            dVarArr = new a.b.g.a.d[size];
            for (int i5 = 0; i5 < size; i5++) {
                dVarArr[i5] = new a.b.g.a.d(this.f695f.get(i5));
                if (F) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f695f.get(i5));
                }
            }
        }
        a.b.g.a.n nVar = new a.b.g.a.n();
        nVar.f735a = oVarArr;
        nVar.f736b = iArr;
        nVar.f737c = dVarArr;
        Fragment fragment2 = this.q;
        if (fragment2 != null) {
            nVar.f738d = fragment2.f2252e;
        }
        nVar.f739e = this.f692c;
        C();
        return nVar;
    }

    public void C() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        a.b.g.a.m mVar;
        if (this.f694e != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i2 = 0; i2 < this.f694e.size(); i2++) {
                Fragment valueAt = this.f694e.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.D) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        Fragment fragment = valueAt.f2255h;
                        valueAt.f2256i = fragment != null ? fragment.f2252e : -1;
                        if (F) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    l lVar = valueAt.u;
                    if (lVar != null) {
                        lVar.C();
                        mVar = valueAt.u.D;
                    } else {
                        mVar = valueAt.v;
                    }
                    if (arrayList2 == null && mVar != null) {
                        arrayList2 = new ArrayList(this.f694e.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(mVar);
                    }
                    if (arrayList3 == null && valueAt.w != null) {
                        arrayList3 = new ArrayList(this.f694e.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.w);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.D = null;
        } else {
            this.D = new a.b.g.a.m(arrayList, arrayList2, arrayList3);
        }
    }

    public void D() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.C == null || this.C.isEmpty()) ? false : true;
            if (this.f690a != null && this.f690a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.n.e().removeCallbacks(this.E);
                this.n.e().post(this.E);
            }
        }
    }

    public void E() {
        if (this.f694e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f694e.size(); i2++) {
            Fragment valueAt = this.f694e.valueAt(i2);
            if (valueAt != null) {
                l(valueAt);
            }
        }
    }

    @Override // a.b.g.a.k
    public List<Fragment> c() {
        List<Fragment> list;
        if (this.f693d.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f693d) {
            list = (List) this.f693d.clone();
        }
        return list;
    }

    public boolean d(int i2) {
        return this.m >= i2;
    }

    @Override // a.b.g.a.k
    public void e() {
        a((InterfaceC0015l) new m(null, -1, 0), false);
    }

    @Override // a.b.g.a.k
    public boolean f() {
        h();
        return a((String) null, -1, 0);
    }

    public void g(Fragment fragment) {
        if (F) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.B) {
            return;
        }
        fragment.B = true;
        fragment.P = true ^ fragment.P;
    }

    public void h(Fragment fragment) {
        if (fragment.f2252e >= 0) {
            return;
        }
        int i2 = this.f692c;
        this.f692c = i2 + 1;
        fragment.a(i2, this.p);
        if (this.f694e == null) {
            this.f694e = new SparseArray<>();
        }
        this.f694e.put(fragment.f2252e, fragment);
        if (F) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void i(Fragment fragment) {
        if (fragment.f2252e < 0) {
            return;
        }
        if (F) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f694e.put(fragment.f2252e, null);
        fragment.I();
    }

    public void j(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int i2 = this.m;
        if (fragment.m) {
            if (fragment.N()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, 0);
            }
        }
        a(fragment, i2, fragment.x(), fragment.y(), false);
        if (fragment.J != null) {
            Fragment f2 = f(fragment);
            if (f2 != null) {
                View view = f2.J;
                ViewGroup viewGroup = fragment.I;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.J);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.J, indexOfChild);
                }
            }
            if (fragment.O && fragment.I != null) {
                float f3 = fragment.Q;
                if (f3 > 0.0f) {
                    fragment.J.setAlpha(f3);
                }
                fragment.Q = 0.0f;
                fragment.O = false;
                g a2 = a(fragment, fragment.x(), true, fragment.y());
                if (a2 != null) {
                    a(fragment.J, a2);
                    Animation animation = a2.f714a;
                    if (animation != null) {
                        fragment.J.startAnimation(animation);
                    } else {
                        a2.f715b.setTarget(fragment.J);
                        a2.f715b.start();
                    }
                }
            }
        }
        if (fragment.P) {
            c(fragment);
        }
    }

    public void k(Fragment fragment) {
        a(fragment, this.m, 0, 0, false);
    }

    public void l(Fragment fragment) {
        if (fragment.L) {
            if (this.f691b) {
                this.w = true;
                return;
            }
            fragment.L = false;
            a(fragment, this.m, 0, 0, false);
        }
    }

    public void m(Fragment fragment) {
        if (F) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.r);
        }
        boolean z = !fragment.N();
        if (!fragment.C || z) {
            synchronized (this.f693d) {
                this.f693d.remove(fragment);
            }
            if (fragment.F && fragment.G) {
                this.r = true;
            }
            fragment.k = false;
            fragment.m = true;
        }
    }

    public Bundle n(Fragment fragment) {
        Bundle bundle;
        if (this.A == null) {
            this.A = new Bundle();
        }
        fragment.j(this.A);
        d(fragment, this.A, false);
        if (this.A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.A;
            this.A = null;
        }
        if (fragment.J != null) {
            o(fragment);
        }
        if (fragment.f2250c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f2250c);
        }
        if (!fragment.M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.M);
        }
        return bundle;
    }

    public void o(Fragment fragment) {
        if (fragment.K == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.B;
        if (sparseArray == null) {
            this.B = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.K.saveHierarchyState(this.B);
        if (this.B.size() > 0) {
            fragment.f2250c = this.B;
            this.B = null;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f724a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.a(this.n.c(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                Fragment b2 = resourceId != -1 ? b(resourceId) : null;
                if (b2 == null && string != null) {
                    b2 = a(string);
                }
                if (b2 == null && id != -1) {
                    b2 = b(id);
                }
                if (F) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + b2);
                }
                if (b2 == null) {
                    Fragment a2 = this.o.a(context, str2, null);
                    a2.n = true;
                    a2.y = resourceId != 0 ? resourceId : id;
                    a2.z = id;
                    a2.A = string;
                    a2.o = true;
                    a2.s = this;
                    a.b.g.a.j jVar = this.n;
                    a2.t = jVar;
                    a2.a(jVar.c(), attributeSet, a2.f2249b);
                    a(a2, true);
                    fragment = a2;
                } else if (!b2.o) {
                    b2.o = true;
                    a.b.g.a.j jVar2 = this.n;
                    b2.t = jVar2;
                    if (!b2.E) {
                        b2.a(jVar2.c(), attributeSet, b2.f2249b);
                    }
                    fragment = b2;
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                }
                if (this.m < 1 && fragment.n) {
                    a(fragment, 1, 0, 0, false);
                } else {
                    k(fragment);
                }
                View view2 = fragment.J;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.J.getTag() == null) {
                        fragment.J.setTag(string);
                    }
                    return fragment.J;
                }
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            return null;
        }
        return null;
    }

    public void p() {
        this.s = false;
        this.t = false;
        a(4);
    }

    public void q(Fragment fragment) {
        if (F) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.B) {
            fragment.B = false;
            fragment.P = !fragment.P;
        }
    }

    public void r() {
        this.t = true;
        a(2);
    }

    public void s() {
        if (this.w) {
            this.w = false;
            E();
        }
    }

    public final void t() {
        SparseArray<Fragment> sparseArray = this.f694e;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment valueAt = this.f694e.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.m() != null) {
                    int F2 = valueAt.F();
                    View m2 = valueAt.m();
                    Animation animation = m2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        m2.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, F2, 0, 0, false);
                } else if (valueAt.n() != null) {
                    valueAt.n().end();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.p;
        if (fragment != null) {
            a.b.g.j.d.a(fragment, sb);
        } else {
            a.b.g.j.d.a(this.n, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public boolean u() {
        c(true);
        boolean z = false;
        while (b(this.x, this.y)) {
            this.f691b = true;
            try {
                c(this.x, this.y);
                i();
                z = true;
            } catch (Throwable th) {
                i();
                throw th;
            }
        }
        s();
        g();
        return z;
    }

    public final void v() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    public LayoutInflater.Factory2 w() {
        return this;
    }

    public Fragment x() {
        return this.q;
    }

    public void y() {
        this.D = null;
        this.s = false;
        this.t = false;
        int size = this.f693d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null) {
                fragment.T();
            }
        }
    }

    public void z() {
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.j.get(i2).a();
            }
        }
    }

    public void d(Fragment fragment) {
        if (F) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.C) {
            return;
        }
        fragment.C = true;
        if (fragment.k) {
            if (F) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f693d) {
                this.f693d.remove(fragment);
            }
            if (fragment.F && fragment.G) {
                this.r = true;
            }
            fragment.k = false;
        }
    }

    public void e(Fragment fragment) {
        if (!fragment.n || fragment.q) {
            return;
        }
        fragment.b(fragment.i(fragment.f2249b), (ViewGroup) null, fragment.f2249b);
        View view = fragment.J;
        if (view != null) {
            fragment.K = view;
            view.setSaveFromParentEnabled(false);
            if (fragment.B) {
                fragment.J.setVisibility(8);
            }
            fragment.a(fragment.J, fragment.f2249b);
            a(fragment, fragment.J, fragment.f2249b, false);
            return;
        }
        fragment.K = null;
    }

    public void k() {
        this.s = false;
        this.t = false;
        a(1);
    }

    public final Fragment f(Fragment fragment) {
        ViewGroup viewGroup = fragment.I;
        View view = fragment.J;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f693d.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f693d.get(indexOf);
                if (fragment2.I == viewGroup && fragment2.J != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f714a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f715b;

        public g(Animation animation) {
            this.f714a = animation;
            this.f715b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public g(Animator animator) {
            this.f714a = null;
            this.f715b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public void p(Fragment fragment) {
        if (fragment != null && (this.f694e.get(fragment.f2252e) != fragment || (fragment.t != null && fragment.v() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.q = fragment;
    }

    @Override // a.b.g.a.k
    public int b() {
        ArrayList<a.b.g.a.c> arrayList = this.f695f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void g() {
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.f694e.valueAt(size) == null) {
                    SparseArray<Fragment> sparseArray2 = this.f694e;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    public final void i() {
        this.f691b = false;
        this.y.clear();
        this.x.clear();
    }

    public void q() {
        this.s = false;
        this.t = false;
        a(3);
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class i extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final ViewGroup f717a;

        /* renamed from: b  reason: collision with root package name */
        public final View f718b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f719c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f720d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f721e;

        public i(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f721e = true;
            this.f717a = viewGroup;
            this.f718b = view;
            addAnimation(animation);
            this.f717a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f721e = true;
            if (this.f719c) {
                return !this.f720d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f719c = true;
                c0.a(this.f717a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f719c && this.f721e) {
                this.f721e = false;
                this.f717a.post(this);
                return;
            }
            this.f717a.endViewTransition(this.f718b);
            this.f720d = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f721e = true;
            if (this.f719c) {
                return !this.f720d;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f719c = true;
                c0.a(this.f717a, this);
            }
            return true;
        }
    }

    public void b(Fragment fragment) {
        if (F) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            if (fragment.k) {
                return;
            }
            if (!this.f693d.contains(fragment)) {
                if (F) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.f693d) {
                    this.f693d.add(fragment);
                }
                fragment.k = true;
                if (fragment.F && fragment.G) {
                    this.r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public void c(Fragment fragment) {
        Animator animator;
        if (fragment.J != null) {
            g a2 = a(fragment, fragment.x(), !fragment.B, fragment.y());
            if (a2 != null && (animator = a2.f715b) != null) {
                animator.setTarget(fragment.J);
                if (fragment.B) {
                    if (fragment.M()) {
                        fragment.g(false);
                    } else {
                        ViewGroup viewGroup = fragment.I;
                        View view = fragment.J;
                        viewGroup.startViewTransition(view);
                        a2.f715b.addListener(new d(this, viewGroup, view, fragment));
                    }
                } else {
                    fragment.J.setVisibility(0);
                }
                a(fragment.J, a2);
                a2.f715b.start();
            } else {
                if (a2 != null) {
                    a(fragment.J, a2);
                    fragment.J.startAnimation(a2.f714a);
                    a2.f714a.start();
                }
                fragment.J.setVisibility((!fragment.B || fragment.M()) ? 0 : 8);
                if (fragment.M()) {
                    fragment.g(false);
                }
            }
        }
        if (fragment.k && fragment.F && fragment.G) {
            this.r = true;
        }
        fragment.P = false;
        fragment.a(fragment.B);
    }

    public void l() {
        this.u = true;
        u();
        a(0);
        this.n = null;
        this.o = null;
        this.p = null;
    }

    public static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h() {
        if (!d()) {
            if (this.v == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.v);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).f(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.e(this, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).g(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.f(this, fragment);
            }
        }
    }

    public void o() {
        a(3);
    }

    public void e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).e(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.d(this, fragment);
            }
        }
    }

    public void h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).h(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.g(this, fragment);
            }
        }
    }

    public void m() {
        a(1);
    }

    @Override // a.b.g.a.k
    public boolean d() {
        return this.s || this.t;
    }

    public void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).d(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.c(this, fragment);
            }
        }
    }

    public final void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a.b.g.j.e("FragmentManager"));
        a.b.g.a.j jVar = this.n;
        if (jVar != null) {
            try {
                jVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    public void n() {
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null) {
                fragment.g0();
            }
        }
    }

    public Fragment b(int i2) {
        for (int size = this.f693d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f693d.get(size);
            if (fragment != null && fragment.y == i2) {
                return fragment;
            }
        }
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray != null) {
            for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
                Fragment valueAt = this.f694e.valueAt(size2);
                if (valueAt != null && valueAt.y == i2) {
                    return valueAt;
                }
            }
            return null;
        }
        return null;
    }

    public void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).d(fragment, bundle, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.d(this, fragment, bundle);
            }
        }
    }

    @Override // a.b.g.a.k
    public q a() {
        return new a.b.g.a.c(this);
    }

    @Override // a.b.g.a.k
    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((InterfaceC0015l) new m(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public Fragment b(String str) {
        Fragment a2;
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment valueAt = this.f694e.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    public final boolean a(String str, int i2, int i3) {
        a.b.g.a.k c0;
        u();
        c(true);
        Fragment fragment = this.q;
        if (fragment == null || i2 >= 0 || str != null || (c0 = fragment.c0()) == null || !c0.f()) {
            boolean a2 = a(this.x, this.y, str, i2, i3);
            if (a2) {
                this.f691b = true;
                try {
                    c(this.x, this.y);
                } finally {
                    i();
                }
            }
            s();
            g();
            return a2;
        }
        return true;
    }

    public void j() {
        this.s = false;
        this.t = false;
        a(2);
    }

    public int b(a.b.g.a.c cVar) {
        synchronized (this) {
            if (this.f698i != null && this.f698i.size() > 0) {
                int intValue = this.f698i.remove(this.f698i.size() - 1).intValue();
                if (F) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + cVar);
                }
                this.f697h.set(intValue, cVar);
                return intValue;
            }
            if (this.f697h == null) {
                this.f697h = new ArrayList<>();
            }
            int size = this.f697h.size();
            if (F) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + cVar);
            }
            this.f697h.add(cVar);
            return size;
        }
    }

    public void c(int i2) {
        synchronized (this) {
            this.f697h.set(i2, null);
            if (this.f698i == null) {
                this.f698i = new ArrayList<>();
            }
            if (F) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.f698i.add(Integer.valueOf(i2));
        }
    }

    @Override // a.b.g.a.k
    public void a(Bundle bundle, String str, Fragment fragment) {
        int i2 = fragment.f2252e;
        if (i2 >= 0) {
            bundle.putInt(str, i2);
            return;
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public final void c(boolean z) {
        if (!this.f691b) {
            if (this.n != null) {
                if (Looper.myLooper() == this.n.e().getLooper()) {
                    if (!z) {
                        h();
                    }
                    if (this.x == null) {
                        this.x = new ArrayList<>();
                        this.y = new ArrayList<>();
                    }
                    this.f691b = true;
                    try {
                        a((ArrayList<a.b.g.a.c>) null, (ArrayList<Boolean>) null);
                        return;
                    } finally {
                        this.f691b = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    @Override // a.b.g.a.k
    public Fragment a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        Fragment fragment = this.f694e.get(i2);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        throw null;
    }

    public void b(InterfaceC0015l interfaceC0015l, boolean z) {
        if (z && (this.n == null || this.u)) {
            return;
        }
        c(z);
        if (interfaceC0015l.a(this.x, this.y)) {
            this.f691b = true;
            try {
                c(this.x, this.y);
            } finally {
                i();
            }
        }
        s();
        g();
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // a.b.g.a.k
    public Fragment.f a(Fragment fragment) {
        Bundle n2;
        if (fragment.f2252e >= 0) {
            if (fragment.f2248a <= 0 || (n2 = n(fragment)) == null) {
                return null;
            }
            return new Fragment.f(n2);
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    @Override // a.b.g.a.k
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment valueAt = this.f694e.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.f693d.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f693d.get(i3).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f696g;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.f696g.get(i4).toString());
            }
        }
        ArrayList<a.b.g.a.c> arrayList2 = this.f695f;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                a.b.g.a.c cVar = this.f695f.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(cVar.toString());
                cVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f697h != null && (size2 = this.f697h.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((a.b.g.a.c) this.f697h.get(i6));
                }
            }
            if (this.f698i != null && this.f698i.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f698i.toArray()));
            }
        }
        ArrayList<InterfaceC0015l> arrayList3 = this.f690a;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println((InterfaceC0015l) this.f690a.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.o);
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.v);
        }
    }

    public final void b(a.b.g.j.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment d2 = bVar.d(i2);
            if (!d2.k) {
                View H2 = d2.H();
                d2.Q = H2.getAlpha();
                H2.setAlpha(0.0f);
            }
        }
    }

    public final void c(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public static void b(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a.b.g.a.c cVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                cVar.b(-1);
                cVar.b(i2 == i3 + (-1));
            } else {
                cVar.b(1);
                cVar.e();
            }
            i2++;
        }
    }

    public final boolean b(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f690a != null && this.f690a.size() != 0) {
                int size = this.f690a.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    z |= this.f690a.get(i2).a(arrayList, arrayList2);
                }
                this.f690a.clear();
                this.n.e().removeCallbacks(this.E);
                return z;
            }
            return false;
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).c(fragment, bundle, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.c(this, fragment, bundle);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.f693d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f693d.get(size);
            if (fragment != null) {
                fragment.e(z);
            }
        }
    }

    public void c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).c(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.b(this, fragment);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.m < 1) {
            return false;
        }
        boolean z = false;
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null && fragment.d(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null && fragment.e(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).b(fragment, context, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.b(this, fragment, context);
            }
        }
    }

    public void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).b(fragment, bundle, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.b(this, fragment, bundle);
            }
        }
    }

    public void b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).b(fragment, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.a(this, fragment);
            }
        }
    }

    public static g a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(H);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(I);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    public static g a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(I);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    public g a(Fragment fragment, int i2, boolean z, int i3) {
        int b2;
        int w = fragment.w();
        Animation a2 = fragment.a(i2, z, w);
        if (a2 != null) {
            return new g(a2);
        }
        Animator b3 = fragment.b(i2, z, w);
        if (b3 != null) {
            return new g(b3);
        }
        if (w != 0) {
            boolean equals = "anim".equals(this.n.c().getResources().getResourceTypeName(w));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.n.c(), w);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.n.c(), w);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.n.c(), w);
                        if (loadAnimation2 != null) {
                            return new g(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 != 0 && (b2 = b(i2, z)) >= 0) {
            switch (b2) {
                case 1:
                    return a(this.n.c(), 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return a(this.n.c(), 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return a(this.n.c(), 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return a(this.n.c(), 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return a(this.n.c(), 0.0f, 1.0f);
                case 6:
                    return a(this.n.c(), 1.0f, 0.0f);
                default:
                    if (i3 == 0 && this.n.h()) {
                        i3 = this.n.g();
                    }
                    if (i3 == 0) {
                    }
                    return null;
            }
        }
        return null;
    }

    public static void a(View view, g gVar) {
        if (view == null || gVar == null || !b(view, gVar)) {
            return;
        }
        Animator animator = gVar.f715b;
        if (animator != null) {
            animator.addListener(new h(view));
            return;
        }
        Animation.AnimationListener a2 = a(gVar.f714a);
        view.setLayerType(2, null);
        gVar.f714a.setAnimationListener(new e(view, a2));
    }

    public static Animation.AnimationListener a(Animation animation) {
        try {
            if (G == null) {
                G = Animation.class.getDeclaredField("mListener");
                G.setAccessible(true);
            }
            return (Animation.AnimationListener) G.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r0 != 3) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.support.v4.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.a.l.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public final void a(Fragment fragment, g gVar, int i2) {
        View view = fragment.J;
        ViewGroup viewGroup = fragment.I;
        viewGroup.startViewTransition(view);
        fragment.c(i2);
        Animation animation = gVar.f714a;
        if (animation != null) {
            i iVar = new i(animation, viewGroup, view);
            fragment.a(fragment.J);
            iVar.setAnimationListener(new b(a(iVar), viewGroup, fragment));
            a(view, gVar);
            fragment.J.startAnimation(iVar);
            return;
        }
        Animator animator = gVar.f715b;
        fragment.a(animator);
        animator.addListener(new c(viewGroup, view, fragment));
        animator.setTarget(fragment.J);
        a(fragment.J, gVar);
        animator.start();
    }

    public void a(int i2, boolean z) {
        a.b.g.a.j jVar;
        if (this.n == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.m) {
            this.m = i2;
            if (this.f694e != null) {
                int size = this.f693d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    j(this.f693d.get(i3));
                }
                int size2 = this.f694e.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Fragment valueAt = this.f694e.valueAt(i4);
                    if (valueAt != null && ((valueAt.m || valueAt.C) && !valueAt.O)) {
                        j(valueAt);
                    }
                }
                E();
                if (this.r && (jVar = this.n) != null && this.m == 4) {
                    jVar.i();
                    this.r = false;
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (F) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        h(fragment);
        if (fragment.C) {
            return;
        }
        if (!this.f693d.contains(fragment)) {
            synchronized (this.f693d) {
                this.f693d.add(fragment);
            }
            fragment.k = true;
            fragment.m = false;
            if (fragment.J == null) {
                fragment.P = false;
            }
            if (fragment.F && fragment.G) {
                this.r = true;
            }
            if (z) {
                k(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    @Override // a.b.g.a.k
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f693d.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f693d.get(size);
                if (fragment != null && str.equals(fragment.A)) {
                    return fragment;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.f694e.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.A)) {
                return valueAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a.b.g.a.l.InterfaceC0015l r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.h()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.u     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            a.b.g.a.j r0 = r1.n     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<a.b.g.a.l$l> r3 = r1.f690a     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.f690a = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<a.b.g.a.l$l> r3 = r1.f690a     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.D()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.a.l.a(a.b.g.a.l$l, boolean):void");
    }

    public void a(int i2, a.b.g.a.c cVar) {
        synchronized (this) {
            if (this.f697h == null) {
                this.f697h = new ArrayList<>();
            }
            int size = this.f697h.size();
            if (i2 < size) {
                if (F) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + cVar);
                }
                this.f697h.set(i2, cVar);
            } else {
                while (size < i2) {
                    this.f697h.add(null);
                    if (this.f698i == null) {
                        this.f698i = new ArrayList<>();
                    }
                    if (F) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f698i.add(Integer.valueOf(size));
                    size++;
                }
                if (F) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + cVar);
                }
                this.f697h.add(cVar);
            }
        }
    }

    public final void a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.C.get(i2);
            if (arrayList != null && !nVar.f729a && (indexOf2 = arrayList.indexOf(nVar.f730b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                nVar.c();
            } else if (nVar.e() || (arrayList != null && nVar.f730b.a(arrayList, 0, arrayList.size()))) {
                this.C.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !nVar.f729a && (indexOf = arrayList.indexOf(nVar.f730b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                    nVar.c();
                } else {
                    nVar.d();
                }
            }
            i2++;
        }
    }

    public final void a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i2;
        boolean z = arrayList.get(i6).t;
        ArrayList<Fragment> arrayList3 = this.z;
        if (arrayList3 == null) {
            this.z = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.z.addAll(this.f693d);
        Fragment x = x();
        boolean z2 = false;
        for (int i7 = i6; i7 < i3; i7++) {
            a.b.g.a.c cVar = arrayList.get(i7);
            if (!arrayList2.get(i7).booleanValue()) {
                x = cVar.a(this.z, x);
            } else {
                x = cVar.b(this.z, x);
            }
            z2 = z2 || cVar.f643i;
        }
        this.z.clear();
        if (!z) {
            r.a(this, arrayList, arrayList2, i2, i3, false);
        }
        b(arrayList, arrayList2, i2, i3);
        if (z) {
            a.b.g.j.b<Fragment> bVar = new a.b.g.j.b<>();
            a(bVar);
            int a2 = a(arrayList, arrayList2, i2, i3, bVar);
            b(bVar);
            i4 = a2;
        } else {
            i4 = i3;
        }
        if (i4 != i6 && z) {
            r.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.m, true);
        }
        while (i6 < i3) {
            a.b.g.a.c cVar2 = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue() && (i5 = cVar2.m) >= 0) {
                c(i5);
                cVar2.m = -1;
            }
            cVar2.h();
            i6++;
        }
        if (z2) {
            z();
        }
    }

    public final int a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.b.g.j.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a.b.g.a.c cVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (cVar.g() && !cVar.a(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                n nVar = new n(cVar, booleanValue);
                this.C.add(nVar);
                cVar.a(nVar);
                if (booleanValue) {
                    cVar.e();
                } else {
                    cVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, cVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    public void a(a.b.g.a.c cVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            cVar.b(z3);
        } else {
            cVar.e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(cVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            r.a(this, (ArrayList<a.b.g.a.c>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.m, true);
        }
        SparseArray<Fragment> sparseArray = this.f694e;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment valueAt = this.f694e.valueAt(i2);
                if (valueAt != null && valueAt.J != null && valueAt.O && cVar.c(valueAt.z)) {
                    float f2 = valueAt.Q;
                    if (f2 > 0.0f) {
                        valueAt.J.setAlpha(f2);
                    }
                    if (z3) {
                        valueAt.Q = 0.0f;
                    } else {
                        valueAt.Q = -1.0f;
                        valueAt.O = false;
                    }
                }
            }
        }
    }

    public final void a(a.b.g.j.b<Fragment> bVar) {
        int i2 = this.m;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        int size = this.f693d.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f693d.get(i3);
            if (fragment.f2248a < min) {
                a(fragment, min, fragment.w(), fragment.x(), false);
                if (fragment.J != null && !fragment.B && fragment.O) {
                    bVar.add(fragment);
                }
            }
        }
    }

    public void a(a.b.g.a.c cVar) {
        if (this.f695f == null) {
            this.f695f = new ArrayList<>();
        }
        this.f695f.add(cVar);
    }

    public boolean a(ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int size;
        ArrayList<a.b.g.a.c> arrayList3 = this.f695f;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.f695f.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                size = this.f695f.size() - 1;
                while (size >= 0) {
                    a.b.g.a.c cVar = this.f695f.get(size);
                    if ((str != null && str.equals(cVar.f())) || (i2 >= 0 && i2 == cVar.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        a.b.g.a.c cVar2 = this.f695f.get(size);
                        if (str == null || !str.equals(cVar2.f())) {
                            if (i2 < 0 || i2 != cVar2.m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f695f.size() - 1) {
                return false;
            }
            for (int size3 = this.f695f.size() - 1; size3 > size; size3--) {
                arrayList.add(this.f695f.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public static void a(a.b.g.a.m mVar) {
        if (mVar == null) {
            return;
        }
        List<Fragment> b2 = mVar.b();
        if (b2 != null) {
            for (Fragment fragment : b2) {
                fragment.E = true;
            }
        }
        List<a.b.g.a.m> a2 = mVar.a();
        if (a2 != null) {
            for (a.b.g.a.m mVar2 : a2) {
                a(mVar2);
            }
        }
    }

    public void a(Parcelable parcelable, a.b.g.a.m mVar) {
        List<a.b.g.a.m> list;
        List<a.a.b.p> list2;
        if (parcelable == null) {
            return;
        }
        a.b.g.a.n nVar = (a.b.g.a.n) parcelable;
        if (nVar.f735a == null) {
            return;
        }
        if (mVar != null) {
            List<Fragment> b2 = mVar.b();
            list = mVar.a();
            list2 = mVar.c();
            int size = b2 != null ? b2.size() : 0;
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = b2.get(i2);
                if (F) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                int i3 = 0;
                while (true) {
                    o[] oVarArr = nVar.f735a;
                    if (i3 >= oVarArr.length || oVarArr[i3].f741b == fragment.f2252e) {
                        break;
                    }
                    i3++;
                }
                o[] oVarArr2 = nVar.f735a;
                if (i3 != oVarArr2.length) {
                    o oVar = oVarArr2[i3];
                    oVar.m = fragment;
                    fragment.f2250c = null;
                    fragment.r = 0;
                    fragment.o = false;
                    fragment.k = false;
                    fragment.f2255h = null;
                    Bundle bundle = oVar.k;
                    if (bundle != null) {
                        bundle.setClassLoader(this.n.c().getClassLoader());
                        fragment.f2250c = oVar.k.getSparseParcelableArray("android:view_state");
                        fragment.f2249b = oVar.k;
                    }
                } else {
                    a(new IllegalStateException("Could not find active fragment with index " + fragment.f2252e));
                    throw null;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.f694e = new SparseArray<>(nVar.f735a.length);
        int i4 = 0;
        while (true) {
            o[] oVarArr3 = nVar.f735a;
            if (i4 >= oVarArr3.length) {
                break;
            }
            o oVar2 = oVarArr3[i4];
            if (oVar2 != null) {
                Fragment a2 = oVar2.a(this.n, this.o, this.p, (list == null || i4 >= list.size()) ? null : list.get(i4), (list2 == null || i4 >= list2.size()) ? null : list2.get(i4));
                if (F) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a2);
                }
                this.f694e.put(a2.f2252e, a2);
                oVar2.m = null;
            }
            i4++;
        }
        if (mVar != null) {
            List<Fragment> b3 = mVar.b();
            int size2 = b3 != null ? b3.size() : 0;
            for (int i5 = 0; i5 < size2; i5++) {
                Fragment fragment2 = b3.get(i5);
                int i6 = fragment2.f2256i;
                if (i6 >= 0) {
                    fragment2.f2255h = this.f694e.get(i6);
                    if (fragment2.f2255h == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.f2256i);
                    }
                }
            }
        }
        this.f693d.clear();
        if (nVar.f736b != null) {
            int i7 = 0;
            while (true) {
                int[] iArr = nVar.f736b;
                if (i7 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f694e.get(iArr[i7]);
                if (fragment3 != null) {
                    fragment3.k = true;
                    if (F) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i7 + ": " + fragment3);
                    }
                    if (!this.f693d.contains(fragment3)) {
                        synchronized (this.f693d) {
                            this.f693d.add(fragment3);
                        }
                        i7++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    a(new IllegalStateException("No instantiated fragment for index #" + nVar.f736b[i7]));
                    throw null;
                }
            }
        }
        a.b.g.a.d[] dVarArr = nVar.f737c;
        if (dVarArr != null) {
            this.f695f = new ArrayList<>(dVarArr.length);
            int i8 = 0;
            while (true) {
                a.b.g.a.d[] dVarArr2 = nVar.f737c;
                if (i8 >= dVarArr2.length) {
                    break;
                }
                a.b.g.a.c a3 = dVarArr2[i8].a(this);
                if (F) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + a3.m + "): " + a3);
                    PrintWriter printWriter = new PrintWriter(new a.b.g.j.e("FragmentManager"));
                    a3.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.f695f.add(a3);
                int i9 = a3.m;
                if (i9 >= 0) {
                    a(i9, a3);
                }
                i8++;
            }
        } else {
            this.f695f = null;
        }
        int i10 = nVar.f738d;
        if (i10 >= 0) {
            this.q = this.f694e.get(i10);
        }
        this.f692c = nVar.f739e;
    }

    public void a(a.b.g.a.j jVar, a.b.g.a.h hVar, Fragment fragment) {
        if (this.n == null) {
            this.n = jVar;
            this.o = hVar;
            this.p = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void a(int i2) {
        try {
            this.f691b = true;
            a(i2, false);
            this.f691b = false;
            u();
        } catch (Throwable th) {
            this.f691b = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (int size = this.f693d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f693d.get(size);
            if (fragment != null) {
                fragment.d(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.m < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null && fragment.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f696g != null) {
            for (int i3 = 0; i3 < this.f696g.size(); i3++) {
                Fragment fragment2 = this.f696g.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.V();
                }
            }
        }
        this.f696g = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.m < 1) {
            return;
        }
        for (int i2 = 0; i2 < this.f693d.size(); i2++) {
            Fragment fragment = this.f693d.get(i2);
            if (fragment != null) {
                fragment.c(menu);
            }
        }
    }

    public void a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).a(fragment, context, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.a(this, fragment, context);
            }
        }
    }

    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).a(fragment, bundle, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.a(this, fragment, bundle);
            }
        }
    }

    public void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.p;
        if (fragment2 != null) {
            a.b.g.a.k v = fragment2.v();
            if (v instanceof l) {
                ((l) v).a(fragment, view, bundle, true);
            }
        }
        Iterator<j> it = this.k.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (!z || next.f723b) {
                next.f722a.a(this, fragment, view, bundle);
            }
        }
    }
}
