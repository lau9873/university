package android.support.v4.app;

import a.a.b.c;
import a.a.b.p;
import a.a.b.q;
import a.b.g.a.e0;
import a.b.g.a.f0;
import a.b.g.a.g;
import a.b.g.a.h;
import a.b.g.a.j;
import a.b.g.a.k;
import a.b.g.a.l;
import a.b.g.a.m;
import a.b.g.a.v;
import a.b.g.j.n;
import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, a.a.b.e, q {
    public static final n<String, Class<?>> X = new n<>();
    public static final Object Y = new Object();
    public String A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean H;
    public ViewGroup I;
    public View J;
    public View K;
    public boolean L;
    public d N;
    public boolean O;
    public boolean P;
    public float Q;
    public LayoutInflater R;
    public boolean S;
    public a.a.b.f U;
    public a.a.b.e V;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f2249b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Parcelable> f2250c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f2251d;

    /* renamed from: f  reason: collision with root package name */
    public String f2253f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f2254g;

    /* renamed from: h  reason: collision with root package name */
    public Fragment f2255h;
    public int j;
    public boolean k;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public l s;
    public j t;
    public l u;
    public m v;
    public p w;
    public Fragment x;
    public int y;
    public int z;

    /* renamed from: a  reason: collision with root package name */
    public int f2248a = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f2252e = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f2256i = -1;
    public boolean G = true;
    public boolean M = true;
    public a.a.b.f T = new a.a.b.f(this);
    public a.a.b.j<a.a.b.e> W = new a.a.b.j<>();

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.h();
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.a.b.e {
        public c() {
        }

        @Override // a.a.b.e
        public a.a.b.c a() {
            Fragment fragment = Fragment.this;
            if (fragment.U == null) {
                fragment.U = new a.a.b.f(fragment.V);
            }
            return Fragment.this.U;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f2260a;

        /* renamed from: b  reason: collision with root package name */
        public Animator f2261b;

        /* renamed from: c  reason: collision with root package name */
        public int f2262c;

        /* renamed from: d  reason: collision with root package name */
        public int f2263d;

        /* renamed from: e  reason: collision with root package name */
        public int f2264e;

        /* renamed from: f  reason: collision with root package name */
        public int f2265f;

        /* renamed from: g  reason: collision with root package name */
        public Object f2266g = null;

        /* renamed from: h  reason: collision with root package name */
        public Object f2267h;

        /* renamed from: i  reason: collision with root package name */
        public Object f2268i;
        public Object j;
        public Object k;
        public Object l;
        public Boolean m;
        public Boolean n;
        public e0 o;
        public e0 p;
        public boolean q;
        public e r;
        public boolean s;

        public d() {
            Object obj = Fragment.Y;
            this.f2267h = obj;
            this.f2268i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public Object A() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.j;
        return obj == Y ? t() : obj;
    }

    public final Resources B() {
        return l0().getResources();
    }

    public Object C() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f2267h;
        return obj == Y ? r() : obj;
    }

    public Object D() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.k;
    }

    public Object E() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.l;
        return obj == Y ? D() : obj;
    }

    public int F() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2262c;
    }

    public final Fragment G() {
        return this.f2255h;
    }

    public View H() {
        return this.J;
    }

    public void I() {
        this.f2252e = -1;
        this.f2253f = null;
        this.k = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.E = false;
    }

    public void J() {
        if (this.t != null) {
            this.u = new l();
            this.u.a(this.t, new b(), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    public final boolean K() {
        return this.t != null && this.k;
    }

    public final boolean L() {
        return this.B;
    }

    public boolean M() {
        d dVar = this.N;
        if (dVar == null) {
            return false;
        }
        return dVar.s;
    }

    public final boolean N() {
        return this.r > 0;
    }

    public boolean O() {
        d dVar = this.N;
        if (dVar == null) {
            return false;
        }
        return dVar.q;
    }

    public final boolean P() {
        return this.m;
    }

    public final boolean Q() {
        return this.f2248a >= 4;
    }

    public final boolean R() {
        l lVar = this.s;
        if (lVar == null) {
            return false;
        }
        return lVar.d();
    }

    public final boolean S() {
        View view;
        return (!K() || L() || (view = this.J) == null || view.getWindowToken() == null || this.J.getVisibility() != 0) ? false : true;
    }

    public void T() {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
        }
    }

    public void U() {
        boolean z = true;
        this.H = true;
        g j = j();
        z = (j == null || !j.isChangingConfigurations()) ? false : false;
        p pVar = this.w;
        if (pVar == null || z) {
            return;
        }
        pVar.a();
    }

    public void V() {
    }

    public void W() {
        this.H = true;
    }

    public void X() {
        this.H = true;
    }

    public void Y() {
        this.H = true;
    }

    public void Z() {
        this.H = true;
    }

    @Override // a.a.b.e
    public a.a.b.c a() {
        return this.T;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i2, boolean z, int i3) {
        return null;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(int i2, String[] strArr, int[] iArr) {
    }

    public void a(Fragment fragment) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(boolean z) {
    }

    public void a0() {
        this.H = true;
    }

    public Animator b(int i2, boolean z, int i3) {
        return null;
    }

    public void b(Bundle bundle) {
        this.H = true;
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void b0() {
        this.H = true;
    }

    public void c(Bundle bundle) {
        this.H = true;
        k(bundle);
        l lVar = this.u;
        if (lVar == null || lVar.d(1)) {
            return;
        }
        this.u.k();
    }

    public void c(boolean z) {
    }

    public boolean c(MenuItem menuItem) {
        return false;
    }

    public k c0() {
        return this.u;
    }

    @Override // a.a.b.q
    public p d() {
        if (q() != null) {
            if (this.w == null) {
                this.w = new p();
            }
            return this.w;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void d0() {
        this.T.a(c.a.ON_DESTROY);
        l lVar = this.u;
        if (lVar != null) {
            lVar.l();
        }
        this.f2248a = 0;
        this.H = false;
        this.S = false;
        U();
        if (this.H) {
            this.u = null;
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public void e(Bundle bundle) {
    }

    public void e(boolean z) {
        c(z);
        l lVar = this.u;
        if (lVar != null) {
            lVar.b(z);
        }
    }

    public void e0() {
        if (this.J != null) {
            this.U.a(c.a.ON_DESTROY);
        }
        l lVar = this.u;
        if (lVar != null) {
            lVar.m();
        }
        this.f2248a = 1;
        this.H = false;
        W();
        if (this.H) {
            v.a(this).a();
            this.q = false;
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(boolean z) {
        if (this.F != z) {
            this.F = z;
            if (!K() || L()) {
                return;
            }
            this.t.i();
        }
    }

    public void f0() {
        this.H = false;
        X();
        this.R = null;
        if (this.H) {
            l lVar = this.u;
            if (lVar != null) {
                if (this.E) {
                    lVar.l();
                    this.u = null;
                    return;
                }
                throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
            }
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onDetach()");
    }

    public void g(Bundle bundle) {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
        }
        this.f2248a = 2;
        this.H = false;
        b(bundle);
        if (this.H) {
            l lVar2 = this.u;
            if (lVar2 != null) {
                lVar2.j();
                return;
            }
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public void g0() {
        onLowMemory();
        l lVar = this.u;
        if (lVar != null) {
            lVar.n();
        }
    }

    public void h(boolean z) {
        if (this.G != z) {
            this.G = z;
            if (this.F && K() && !L()) {
                this.t.i();
            }
        }
    }

    public void h0() {
        if (this.J != null) {
            this.U.a(c.a.ON_PAUSE);
        }
        this.T.a(c.a.ON_PAUSE);
        l lVar = this.u;
        if (lVar != null) {
            lVar.o();
        }
        this.f2248a = 3;
        this.H = false;
        Y();
        if (this.H) {
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onPause()");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(boolean z) {
        this.D = z;
    }

    public void i0() {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
            this.u.u();
        }
        this.f2248a = 4;
        this.H = false;
        Z();
        if (this.H) {
            l lVar2 = this.u;
            if (lVar2 != null) {
                lVar2.p();
                this.u.u();
            }
            this.T.a(c.a.ON_RESUME);
            if (this.J != null) {
                this.U.a(c.a.ON_RESUME);
                return;
            }
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onResume()");
    }

    public final g j() {
        j jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return (g) jVar.b();
    }

    public void j0() {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
            this.u.u();
        }
        this.f2248a = 3;
        this.H = false;
        a0();
        if (this.H) {
            l lVar2 = this.u;
            if (lVar2 != null) {
                lVar2.q();
            }
            this.T.a(c.a.ON_START);
            if (this.J != null) {
                this.U.a(c.a.ON_START);
                return;
            }
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onStart()");
    }

    public void k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.u == null) {
            J();
        }
        this.u.a(parcelable, this.v);
        this.v = null;
        this.u.k();
    }

    public void k0() {
        if (this.J != null) {
            this.U.a(c.a.ON_STOP);
        }
        this.T.a(c.a.ON_STOP);
        l lVar = this.u;
        if (lVar != null) {
            lVar.r();
        }
        this.f2248a = 2;
        this.H = false;
        b0();
        if (this.H) {
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onStop()");
    }

    public final void l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f2250c;
        if (sparseArray != null) {
            this.K.restoreHierarchyState(sparseArray);
            this.f2250c = null;
        }
        this.H = false;
        f(bundle);
        if (this.H) {
            if (this.J != null) {
                this.U.a(c.a.ON_CREATE);
                return;
            }
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public final Context l0() {
        Context q = q();
        if (q != null) {
            return q;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void m(Bundle bundle) {
        if (this.f2252e >= 0 && R()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.f2254g = bundle;
    }

    public void m0() {
        l lVar = this.s;
        if (lVar != null && lVar.n != null) {
            if (Looper.myLooper() != this.s.n.e().getLooper()) {
                this.s.n.e().postAtFrontOfQueue(new a());
                return;
            } else {
                h();
                return;
            }
        }
        i().q = false;
    }

    public Animator n() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f2261b;
    }

    public final Bundle o() {
        return this.f2254g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        j().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.H = true;
    }

    public final k p() {
        if (this.u == null) {
            J();
            int i2 = this.f2248a;
            if (i2 >= 4) {
                this.u.p();
            } else if (i2 >= 3) {
                this.u.q();
            } else if (i2 >= 2) {
                this.u.j();
            } else if (i2 >= 1) {
                this.u.k();
            }
        }
        return this.u;
    }

    public Context q() {
        j jVar = this.t;
        if (jVar == null) {
            return null;
        }
        return jVar.c();
    }

    public Object r() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f2266g;
    }

    public e0 s() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.o;
    }

    public void startActivityForResult(Intent intent, int i2) {
        a(intent, i2, (Bundle) null);
    }

    public Object t() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f2268i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a.b.g.j.d.a(this, sb);
        if (this.f2252e >= 0) {
            sb.append(" #");
            sb.append(this.f2252e);
        }
        if (this.y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.y));
        }
        if (this.A != null) {
            sb.append(" ");
            sb.append(this.A);
        }
        sb.append('}');
        return sb.toString();
    }

    public e0 u() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.p;
    }

    public final k v() {
        return this.s;
    }

    public int w() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2263d;
    }

    public int x() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2264e;
    }

    public int y() {
        d dVar = this.N;
        if (dVar == null) {
            return 0;
        }
        return dVar.f2265f;
    }

    public final Fragment z() {
        return this.x;
    }

    /* loaded from: classes.dex */
    public static class f implements Parcelable {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f2269a;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<f> {
            @Override // android.os.Parcelable.Creator
            public f[] newArray(int i2) {
                return new f[i2];
            }

            @Override // android.os.Parcelable.Creator
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }
        }

        public f(Bundle bundle) {
            this.f2269a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f2269a);
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f2269a = parcel.readBundle();
            if (classLoader == null || (bundle = this.f2269a) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.m(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (java.lang.InstantiationException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    public void b(Object obj) {
        i().f2268i = obj;
    }

    public LayoutInflater i(Bundle bundle) {
        this.R = d(bundle);
        return this.R;
    }

    public void j(boolean z) {
        if (!this.M && z && this.f2248a < 3 && this.s != null && K() && this.S) {
            this.s.l(this);
        }
        this.M = z;
        this.L = this.f2248a < 3 && !z;
        if (this.f2249b != null) {
            this.f2251d = Boolean.valueOf(z);
        }
    }

    /* loaded from: classes.dex */
    public class b extends h {
        public b() {
        }

        @Override // a.b.g.a.h
        public View a(int i2) {
            View view = Fragment.this.J;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // a.b.g.a.h
        public boolean a() {
            return Fragment.this.J != null;
        }

        @Override // a.b.g.a.h
        public Fragment a(Context context, String str, Bundle bundle) {
            return Fragment.this.t.a(context, str, bundle);
        }
    }

    public void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
        }
        this.q = true;
        this.V = new c();
        this.U = null;
        this.J = a(layoutInflater, viewGroup, bundle);
        if (this.J != null) {
            this.V.a();
            this.W.b((a.a.b.j<a.a.b.e>) this.V);
        } else if (this.U == null) {
            this.V = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    public boolean e(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (this.F && this.G && c(menuItem)) {
            return true;
        }
        l lVar = this.u;
        return lVar != null && lVar.b(menuItem);
    }

    public View m() {
        d dVar = this.N;
        if (dVar == null) {
            return null;
        }
        return dVar.f2260a;
    }

    public void f(Bundle bundle) {
        this.H = true;
    }

    public void h() {
        d dVar = this.N;
        e eVar = null;
        if (dVar != null) {
            dVar.q = false;
            e eVar2 = dVar.r;
            dVar.r = null;
            eVar = eVar2;
        }
        if (eVar != null) {
            eVar.a();
        }
    }

    public final d i() {
        if (this.N == null) {
            this.N = new d();
        }
        return this.N;
    }

    public void c(Object obj) {
        i().f2267h = obj;
    }

    public LayoutInflater d(Bundle bundle) {
        return a(bundle);
    }

    public void c(Menu menu) {
        if (this.B) {
            return;
        }
        if (this.F && this.G) {
            a(menu);
        }
        l lVar = this.u;
        if (lVar != null) {
            lVar.a(menu);
        }
    }

    public void d(boolean z) {
        b(z);
        l lVar = this.u;
        if (lVar != null) {
            lVar.a(z);
        }
    }

    public boolean k() {
        Boolean bool;
        d dVar = this.N;
        if (dVar == null || (bool = dVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j(Bundle bundle) {
        Parcelable B;
        e(bundle);
        l lVar = this.u;
        if (lVar == null || (B = lVar.B()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", B);
    }

    public boolean d(Menu menu) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            b(menu);
            z = true;
        }
        l lVar = this.u;
        return lVar != null ? z | lVar.b(menu) : z;
    }

    public void g(boolean z) {
        i().s = z;
    }

    public void h(Bundle bundle) {
        l lVar = this.u;
        if (lVar != null) {
            lVar.y();
        }
        this.f2248a = 1;
        this.H = false;
        c(bundle);
        this.S = true;
        if (this.H) {
            this.T.a(c.a.ON_CREATE);
            return;
        }
        throw new f0("Fragment " + this + " did not call through to super.onCreate()");
    }

    public boolean l() {
        Boolean bool;
        d dVar = this.N;
        if (dVar == null || (bool = dVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void c(int i2) {
        i().f2262c = i2;
    }

    public static boolean a(Context context, String str) {
        try {
            Class<?> cls = X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            a(menu, menuInflater);
            z = true;
        }
        l lVar = this.u;
        return lVar != null ? z | lVar.a(menu, menuInflater) : z;
    }

    public boolean d(MenuItem menuItem) {
        if (this.B) {
            return false;
        }
        if (b(menuItem)) {
            return true;
        }
        l lVar = this.u;
        return lVar != null && lVar.a(menuItem);
    }

    public final void a(int i2, Fragment fragment) {
        this.f2252e = i2;
        if (fragment != null) {
            this.f2253f = fragment.f2253f + ":" + this.f2252e;
            return;
        }
        this.f2253f = "android:fragment:" + this.f2252e;
    }

    public void a(f fVar) {
        if (this.f2252e < 0) {
            this.f2249b = (fVar == null || (r2 = fVar.f2269a) == null) ? null : null;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void b(int i2) {
        if (this.N == null && i2 == 0) {
            return;
        }
        i().f2263d = i2;
    }

    public void a(Fragment fragment, int i2) {
        k v = v();
        k v2 = fragment != null ? fragment.v() : null;
        if (v != null && v2 != null && v != v2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.G()) {
            if (fragment2 == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        this.f2255h = fragment;
        this.j = i2;
    }

    public final String a(int i2) {
        return B().getString(i2);
    }

    public void a(Intent intent) {
        a(intent, (Bundle) null);
    }

    public void a(Intent intent, Bundle bundle) {
        j jVar = this.t;
        if (jVar != null) {
            jVar.a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void a(Intent intent, int i2, Bundle bundle) {
        j jVar = this.t;
        if (jVar != null) {
            jVar.a(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final void a(String[] strArr, int i2) {
        j jVar = this.t;
        if (jVar != null) {
            jVar.a(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater a(Bundle bundle) {
        j jVar = this.t;
        if (jVar != null) {
            LayoutInflater f2 = jVar.f();
            p();
            l lVar = this.u;
            lVar.w();
            a.b.g.k.f.b(f2, lVar);
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
        j jVar = this.t;
        Activity b2 = jVar == null ? null : jVar.b();
        if (b2 != null) {
            this.H = false;
            a(b2, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
    }

    public void a(Context context) {
        this.H = true;
        j jVar = this.t;
        Activity b2 = jVar == null ? null : jVar.b();
        if (b2 != null) {
            this.H = false;
            a(b2);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.H = true;
    }

    public void a(Object obj) {
        i().f2266g = obj;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mTag=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f2248a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f2252e);
        printWriter.print(" mWho=");
        printWriter.print(this.f2253f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.B);
        printWriter.print(" mDetached=");
        printWriter.print(this.C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.M);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.x);
        }
        if (this.f2254g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f2254g);
        }
        if (this.f2249b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f2249b);
        }
        if (this.f2250c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f2250c);
        }
        if (this.f2255h != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f2255h);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (w() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(w());
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.J);
        }
        if (m() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(F());
        }
        if (q() != null) {
            v.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.u + ":");
            l lVar = this.u;
            lVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public Fragment a(String str) {
        if (str.equals(this.f2253f)) {
            return this;
        }
        l lVar = this.u;
        if (lVar != null) {
            return lVar.b(str);
        }
        return null;
    }

    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        l lVar = this.u;
        if (lVar != null) {
            lVar.a(configuration);
        }
    }

    public void a(e eVar) {
        i();
        e eVar2 = this.N.r;
        if (eVar == eVar2) {
            return;
        }
        if (eVar != null && eVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        d dVar = this.N;
        if (dVar.q) {
            dVar.r = eVar;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    public void a(int i2, int i3) {
        if (this.N == null && i2 == 0 && i3 == 0) {
            return;
        }
        i();
        d dVar = this.N;
        dVar.f2264e = i2;
        dVar.f2265f = i3;
    }

    public void a(View view) {
        i().f2260a = view;
    }

    public void a(Animator animator) {
        i().f2261b = animator;
    }
}
