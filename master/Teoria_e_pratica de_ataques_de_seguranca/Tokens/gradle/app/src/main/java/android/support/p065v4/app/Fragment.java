package android.support.p065v4.app;

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
import com.j256.ormlite.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.LifecycleRegistry;
import p000a.p001a.p005b.MutableLiveData;
import p000a.p001a.p005b.ViewModelStore;
import p000a.p001a.p005b.ViewModelStoreOwner;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p031a.FragmentContainer;
import p000a.p006b.p030g.p031a.FragmentHostCallback;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p031a.FragmentManagerNonConfig;
import p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l;
import p000a.p006b.p030g.p031a.LoaderManager;
import p000a.p006b.p030g.p031a.SharedElementCallback;
import p000a.p006b.p030g.p031a.SuperNotCalledException;
import p000a.p006b.p030g.p044j.DebugUtils;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p000a.p006b.p030g.p045k.LayoutInflaterCompat;

/* renamed from: android.support.v4.app.Fragment */
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner {

    /* renamed from: X */
    public static final SimpleArrayMap<String, Class<?>> f3462X = new SimpleArrayMap<>();

    /* renamed from: Y */
    public static final Object f3463Y = new Object();

    /* renamed from: A */
    public String f3464A;

    /* renamed from: B */
    public boolean f3465B;

    /* renamed from: C */
    public boolean f3466C;

    /* renamed from: D */
    public boolean f3467D;

    /* renamed from: E */
    public boolean f3468E;

    /* renamed from: F */
    public boolean f3469F;

    /* renamed from: H */
    public boolean f3471H;

    /* renamed from: I */
    public ViewGroup f3472I;

    /* renamed from: J */
    public View f3473J;

    /* renamed from: K */
    public View f3474K;

    /* renamed from: L */
    public boolean f3475L;

    /* renamed from: N */
    public C0604d f3477N;

    /* renamed from: O */
    public boolean f3478O;

    /* renamed from: P */
    public boolean f3479P;

    /* renamed from: Q */
    public float f3480Q;

    /* renamed from: R */
    public LayoutInflater f3481R;

    /* renamed from: S */
    public boolean f3482S;

    /* renamed from: U */
    public LifecycleRegistry f3484U;

    /* renamed from: V */
    public LifecycleOwner f3485V;

    /* renamed from: b */
    public Bundle f3488b;

    /* renamed from: c */
    public SparseArray<Parcelable> f3489c;

    /* renamed from: d */
    public Boolean f3490d;

    /* renamed from: f */
    public String f3492f;

    /* renamed from: g */
    public Bundle f3493g;

    /* renamed from: h */
    public Fragment f3494h;

    /* renamed from: j */
    public int f3496j;

    /* renamed from: k */
    public boolean f3497k;

    /* renamed from: m */
    public boolean f3498m;

    /* renamed from: n */
    public boolean f3499n;

    /* renamed from: o */
    public boolean f3500o;

    /* renamed from: p */
    public boolean f3501p;

    /* renamed from: q */
    public boolean f3502q;

    /* renamed from: r */
    public int f3503r;

    /* renamed from: s */
    public LayoutInflater$Factory2C0152l f3504s;

    /* renamed from: t */
    public FragmentHostCallback f3505t;

    /* renamed from: u */
    public LayoutInflater$Factory2C0152l f3506u;

    /* renamed from: v */
    public FragmentManagerNonConfig f3507v;

    /* renamed from: w */
    public ViewModelStore f3508w;

    /* renamed from: x */
    public Fragment f3509x;

    /* renamed from: y */
    public int f3510y;

    /* renamed from: z */
    public int f3511z;

    /* renamed from: a */
    public int f3487a = 0;

    /* renamed from: e */
    public int f3491e = -1;

    /* renamed from: i */
    public int f3495i = -1;

    /* renamed from: G */
    public boolean f3470G = true;

    /* renamed from: M */
    public boolean f3476M = true;

    /* renamed from: T */
    public LifecycleRegistry f3483T = new LifecycleRegistry(this);

    /* renamed from: W */
    public MutableLiveData<LifecycleOwner> f3486W = new MutableLiveData<>();

    /* renamed from: android.support.v4.app.Fragment$InstantiationException */
    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$a */
    /* loaded from: classes.dex */
    public class RunnableC0601a implements Runnable {
        public RunnableC0601a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m7476h();
        }
    }

    /* renamed from: android.support.v4.app.Fragment$c */
    /* loaded from: classes.dex */
    public class C0603c implements LifecycleOwner {
        public C0603c() {
        }

        @Override // p000a.p001a.p005b.LifecycleOwner
        /* renamed from: a */
        public Lifecycle mo7439a() {
            Fragment fragment = Fragment.this;
            if (fragment.f3484U == null) {
                fragment.f3484U = new LifecycleRegistry(fragment.f3485V);
            }
            return Fragment.this.f3484U;
        }
    }

    /* renamed from: android.support.v4.app.Fragment$d */
    /* loaded from: classes.dex */
    public static class C0604d {

        /* renamed from: a */
        public View f3515a;

        /* renamed from: b */
        public Animator f3516b;

        /* renamed from: c */
        public int f3517c;

        /* renamed from: d */
        public int f3518d;

        /* renamed from: e */
        public int f3519e;

        /* renamed from: f */
        public int f3520f;

        /* renamed from: g */
        public Object f3521g = null;

        /* renamed from: h */
        public Object f3522h;

        /* renamed from: i */
        public Object f3523i;

        /* renamed from: j */
        public Object f3524j;

        /* renamed from: k */
        public Object f3525k;

        /* renamed from: l */
        public Object f3526l;

        /* renamed from: m */
        public Boolean f3527m;

        /* renamed from: n */
        public Boolean f3528n;

        /* renamed from: o */
        public SharedElementCallback f3529o;

        /* renamed from: p */
        public SharedElementCallback f3530p;

        /* renamed from: q */
        public boolean f3531q;

        /* renamed from: r */
        public InterfaceC0605e f3532r;

        /* renamed from: s */
        public boolean f3533s;

        public C0604d() {
            Object obj = Fragment.f3463Y;
            this.f3522h = obj;
            this.f3523i = null;
            this.f3524j = obj;
            this.f3525k = null;
            this.f3526l = obj;
            this.f3529o = null;
            this.f3530p = null;
        }
    }

    /* renamed from: android.support.v4.app.Fragment$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0605e {
        /* renamed from: a */
        void mo7438a();

        /* renamed from: b */
        void mo7437b();
    }

    /* renamed from: A */
    public Object m7550A() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        Object obj = c0604d.f3524j;
        return obj == f3463Y ? m7449t() : obj;
    }

    /* renamed from: B */
    public final Resources m7549B() {
        return m7459l0().getResources();
    }

    /* renamed from: C */
    public Object m7548C() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        Object obj = c0604d.f3522h;
        return obj == f3463Y ? m7451r() : obj;
    }

    /* renamed from: D */
    public Object m7547D() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3525k;
    }

    /* renamed from: E */
    public Object m7546E() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        Object obj = c0604d.f3526l;
        return obj == f3463Y ? m7547D() : obj;
    }

    /* renamed from: F */
    public int m7545F() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return 0;
        }
        return c0604d.f3517c;
    }

    /* renamed from: G */
    public final Fragment m7544G() {
        return this.f3494h;
    }

    /* renamed from: H */
    public View m7543H() {
        return this.f3473J;
    }

    /* renamed from: I */
    public void m7542I() {
        this.f3491e = -1;
        this.f3492f = null;
        this.f3497k = false;
        this.f3498m = false;
        this.f3499n = false;
        this.f3500o = false;
        this.f3501p = false;
        this.f3503r = 0;
        this.f3504s = null;
        this.f3506u = null;
        this.f3505t = null;
        this.f3510y = 0;
        this.f3511z = 0;
        this.f3464A = null;
        this.f3465B = false;
        this.f3466C = false;
        this.f3468E = false;
    }

    /* renamed from: J */
    public void m7541J() {
        if (this.f3505t != null) {
            this.f3506u = new LayoutInflater$Factory2C0152l();
            this.f3506u.m10257a(this.f3505t, new C0602b(), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    /* renamed from: K */
    public final boolean m7540K() {
        return this.f3505t != null && this.f3497k;
    }

    /* renamed from: L */
    public final boolean m7539L() {
        return this.f3465B;
    }

    /* renamed from: M */
    public boolean m7538M() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return false;
        }
        return c0604d.f3533s;
    }

    /* renamed from: N */
    public final boolean m7537N() {
        return this.f3503r > 0;
    }

    /* renamed from: O */
    public boolean m7536O() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return false;
        }
        return c0604d.f3531q;
    }

    /* renamed from: P */
    public final boolean m7535P() {
        return this.f3498m;
    }

    /* renamed from: Q */
    public final boolean m7534Q() {
        return this.f3487a >= 4;
    }

    /* renamed from: R */
    public final boolean m7533R() {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3504s;
        if (layoutInflater$Factory2C0152l == null) {
            return false;
        }
        return layoutInflater$Factory2C0152l.mo10199d();
    }

    /* renamed from: S */
    public final boolean m7532S() {
        View view;
        return (!m7540K() || m7539L() || (view = this.f3473J) == null || view.getWindowToken() == null || this.f3473J.getVisibility() != 0) ? false : true;
    }

    /* renamed from: T */
    public void m7531T() {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
        }
    }

    /* renamed from: U */
    public void mo897U() {
        boolean z = true;
        this.f3471H = true;
        FragmentActivity m7468j = m7468j();
        z = (m7468j == null || !m7468j.isChangingConfigurations()) ? false : false;
        ViewModelStore viewModelStore = this.f3508w;
        if (viewModelStore == null || z) {
            return;
        }
        viewModelStore.m11262a();
    }

    /* renamed from: V */
    public void m7530V() {
    }

    /* renamed from: W */
    public void mo7529W() {
        this.f3471H = true;
    }

    /* renamed from: X */
    public void mo779X() {
        this.f3471H = true;
    }

    /* renamed from: Y */
    public void mo887Y() {
        this.f3471H = true;
    }

    /* renamed from: Z */
    public void mo873Z() {
        this.f3471H = true;
    }

    @Override // p000a.p001a.p005b.LifecycleOwner
    /* renamed from: a */
    public Lifecycle mo7439a() {
        return this.f3483T;
    }

    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* renamed from: a */
    public Animation m7525a(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: a */
    public void mo1127a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo872a(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: a */
    public void mo948a(Fragment fragment) {
    }

    /* renamed from: a */
    public void m7510a(Menu menu) {
    }

    /* renamed from: a */
    public void mo947a(Menu menu, MenuInflater menuInflater) {
    }

    /* renamed from: a */
    public void mo715a(View view, Bundle bundle) {
    }

    /* renamed from: a */
    public void m7507a(boolean z) {
    }

    /* renamed from: a0 */
    public void mo5376a0() {
        this.f3471H = true;
    }

    /* renamed from: b */
    public Animator m7504b(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: b */
    public void mo7503b(Bundle bundle) {
        this.f3471H = true;
    }

    /* renamed from: b */
    public void m7501b(Menu menu) {
    }

    /* renamed from: b */
    public void m7497b(boolean z) {
    }

    /* renamed from: b */
    public boolean m7499b(MenuItem menuItem) {
        return false;
    }

    /* renamed from: b0 */
    public void mo883b0() {
        this.f3471H = true;
    }

    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        this.f3471H = true;
        m7463k(bundle);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l == null || layoutInflater$Factory2C0152l.m10198d(1)) {
            return;
        }
        this.f3506u.m10177k();
    }

    /* renamed from: c */
    public void m7493c(boolean z) {
    }

    /* renamed from: c */
    public boolean mo930c(MenuItem menuItem) {
        return false;
    }

    /* renamed from: c0 */
    public FragmentManager m7492c0() {
        return this.f3506u;
    }

    @Override // p000a.p001a.p005b.ViewModelStoreOwner
    /* renamed from: d */
    public ViewModelStore mo7491d() {
        if (m7452q() != null) {
            if (this.f3508w == null) {
                this.f3508w = new ViewModelStore();
            }
            return this.f3508w;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    /* renamed from: d0 */
    public void m7486d0() {
        this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_DESTROY);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10175l();
        }
        this.f3487a = 0;
        this.f3471H = false;
        this.f3482S = false;
        mo897U();
        if (this.f3471H) {
            this.f3506u = null;
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* renamed from: e */
    public void mo924e(Bundle bundle) {
    }

    /* renamed from: e */
    public void m7484e(boolean z) {
        m7493c(z);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10207b(z);
        }
    }

    /* renamed from: e0 */
    public void m7483e0() {
        if (this.f3473J != null) {
            this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_DESTROY);
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10173m();
        }
        this.f3487a = 1;
        this.f3471H = false;
        mo7529W();
        if (this.f3471H) {
            LoaderManager.m10076a(this).mo7436a();
            this.f3502q = false;
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public void m7481f(boolean z) {
        if (this.f3469F != z) {
            this.f3469F = z;
            if (!m7540K() || m7539L()) {
                return;
            }
            this.f3505t.mo10285i();
        }
    }

    /* renamed from: f0 */
    public void m7480f0() {
        this.f3471H = false;
        mo779X();
        this.f3481R = null;
        if (this.f3471H) {
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
            if (layoutInflater$Factory2C0152l != null) {
                if (this.f3468E) {
                    layoutInflater$Factory2C0152l.m10175l();
                    this.f3506u = null;
                    return;
                }
                throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* renamed from: g */
    public void m7479g(Bundle bundle) {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
        }
        this.f3487a = 2;
        this.f3471H = false;
        mo7503b(bundle);
        if (this.f3471H) {
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l2 = this.f3506u;
            if (layoutInflater$Factory2C0152l2 != null) {
                layoutInflater$Factory2C0152l2.m10179j();
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* renamed from: g0 */
    public void m7477g0() {
        onLowMemory();
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10171n();
        }
    }

    /* renamed from: h */
    public void m7474h(boolean z) {
        if (this.f3470G != z) {
            this.f3470G = z;
            if (this.f3469F && m7540K() && !m7539L()) {
                this.f3505t.mo10285i();
            }
        }
    }

    /* renamed from: h0 */
    public void m7473h0() {
        if (this.f3473J != null) {
            this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_PAUSE);
        }
        this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_PAUSE);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10169o();
        }
        this.f3487a = 3;
        this.f3471H = false;
        mo887Y();
        if (this.f3471H) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public void m7470i(boolean z) {
        this.f3467D = z;
    }

    /* renamed from: i0 */
    public void m7469i0() {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
            this.f3506u.m10160u();
        }
        this.f3487a = 4;
        this.f3471H = false;
        mo873Z();
        if (this.f3471H) {
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l2 = this.f3506u;
            if (layoutInflater$Factory2C0152l2 != null) {
                layoutInflater$Factory2C0152l2.m10167p();
                this.f3506u.m10160u();
            }
            this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_RESUME);
            if (this.f3473J != null) {
                this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_RESUME);
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }

    /* renamed from: j */
    public final FragmentActivity m7468j() {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.m10293b();
    }

    /* renamed from: j0 */
    public void m7465j0() {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
            this.f3506u.m10160u();
        }
        this.f3487a = 3;
        this.f3471H = false;
        mo5376a0();
        if (this.f3471H) {
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l2 = this.f3506u;
            if (layoutInflater$Factory2C0152l2 != null) {
                layoutInflater$Factory2C0152l2.m10165q();
            }
            this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_START);
            if (this.f3473J != null) {
                this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_START);
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }

    /* renamed from: k */
    public void m7463k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.f3506u == null) {
            m7541J();
        }
        this.f3506u.m10246a(parcelable, this.f3507v);
        this.f3507v = null;
        this.f3506u.m10177k();
    }

    /* renamed from: k0 */
    public void m7462k0() {
        if (this.f3473J != null) {
            this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_STOP);
        }
        this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_STOP);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10163r();
        }
        this.f3487a = 2;
        this.f3471H = false;
        mo883b0();
        if (this.f3471H) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    /* renamed from: l */
    public final void m7460l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f3489c;
        if (sparseArray != null) {
            this.f3474K.restoreHierarchyState(sparseArray);
            this.f3489c = null;
        }
        this.f3471H = false;
        m7482f(bundle);
        if (this.f3471H) {
            if (this.f3473J != null) {
                this.f3484U.m11297a(Lifecycle.EnumC0011a.ON_CREATE);
                return;
            }
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    /* renamed from: l0 */
    public final Context m7459l0() {
        Context m7452q = m7452q();
        if (m7452q != null) {
            return m7452q;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* renamed from: m */
    public void m7457m(Bundle bundle) {
        if (this.f3491e >= 0 && m7533R()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.f3493g = bundle;
    }

    /* renamed from: m0 */
    public void m7456m0() {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3504s;
        if (layoutInflater$Factory2C0152l != null && layoutInflater$Factory2C0152l.f1151n != null) {
            if (Looper.myLooper() != this.f3504s.f1151n.m10289e().getLooper()) {
                this.f3504s.f1151n.m10289e().postAtFrontOfQueue(new RunnableC0601a());
                return;
            } else {
                m7476h();
                return;
            }
        }
        m7472i().f3531q = false;
    }

    /* renamed from: n */
    public Animator m7455n() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3516b;
    }

    /* renamed from: o */
    public final Bundle m7454o() {
        return this.f3493g;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f3471H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m7468j().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f3471H = true;
    }

    /* renamed from: p */
    public final FragmentManager m7453p() {
        if (this.f3506u == null) {
            m7541J();
            int i = this.f3487a;
            if (i >= 4) {
                this.f3506u.m10167p();
            } else if (i >= 3) {
                this.f3506u.m10165q();
            } else if (i >= 2) {
                this.f3506u.m10179j();
            } else if (i >= 1) {
                this.f3506u.m10177k();
            }
        }
        return this.f3506u;
    }

    /* renamed from: q */
    public Context m7452q() {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.m10291c();
    }

    /* renamed from: r */
    public Object m7451r() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3521g;
    }

    /* renamed from: s */
    public SharedElementCallback m7450s() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3529o;
    }

    public void startActivityForResult(Intent intent, int i) {
        m7517a(intent, i, (Bundle) null);
    }

    /* renamed from: t */
    public Object m7449t() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3523i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        DebugUtils.m9667a(this, sb);
        if (this.f3491e >= 0) {
            sb.append(" #");
            sb.append(this.f3491e);
        }
        if (this.f3510y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3510y));
        }
        if (this.f3464A != null) {
            sb.append(" ");
            sb.append(this.f3464A);
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: u */
    public SharedElementCallback m7448u() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3530p;
    }

    /* renamed from: v */
    public final FragmentManager m7447v() {
        return this.f3504s;
    }

    /* renamed from: w */
    public int m7446w() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return 0;
        }
        return c0604d.f3518d;
    }

    /* renamed from: x */
    public int m7445x() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return 0;
        }
        return c0604d.f3519e;
    }

    /* renamed from: y */
    public int m7444y() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return 0;
        }
        return c0604d.f3520f;
    }

    /* renamed from: z */
    public final Fragment m7443z() {
        return this.f3509x;
    }

    /* renamed from: android.support.v4.app.Fragment$f */
    /* loaded from: classes.dex */
    public static class C0606f implements Parcelable {
        public static final Parcelable.Creator<C0606f> CREATOR = new C0607a();

        /* renamed from: a */
        public final Bundle f3534a;

        /* renamed from: android.support.v4.app.Fragment$f$a */
        /* loaded from: classes.dex */
        public static class C0607a implements Parcelable.ClassLoaderCreator<C0606f> {
            @Override // android.os.Parcelable.Creator
            public C0606f[] newArray(int i) {
                return new C0606f[i];
            }

            @Override // android.os.Parcelable.Creator
            public C0606f createFromParcel(Parcel parcel) {
                return new C0606f(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public C0606f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0606f(parcel, classLoader);
            }
        }

        public C0606f(Bundle bundle) {
            this.f3534a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f3534a);
        }

        public C0606f(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f3534a = parcel.readBundle();
            if (classLoader == null || (bundle = this.f3534a) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    /* renamed from: a */
    public static Fragment m7519a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = f3462X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f3462X.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.m7457m(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* renamed from: b */
    public void m7498b(Object obj) {
        m7472i().f3523i = obj;
    }

    /* renamed from: i */
    public LayoutInflater m7471i(Bundle bundle) {
        this.f3481R = mo7490d(bundle);
        return this.f3481R;
    }

    /* renamed from: j */
    public void m7466j(boolean z) {
        if (!this.f3476M && z && this.f3487a < 3 && this.f3504s != null && m7540K() && this.f3482S) {
            this.f3504s.m10174l(this);
        }
        this.f3476M = z;
        this.f3475L = this.f3487a < 3 && !z;
        if (this.f3488b != null) {
            this.f3490d = Boolean.valueOf(z);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$b */
    /* loaded from: classes.dex */
    public class C0602b extends FragmentContainer {
        public C0602b() {
        }

        @Override // p000a.p006b.p030g.p031a.FragmentContainer
        /* renamed from: a */
        public View mo7441a(int i) {
            View view = Fragment.this.f3473J;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        @Override // p000a.p006b.p030g.p031a.FragmentContainer
        /* renamed from: a */
        public boolean mo7442a() {
            return Fragment.this.f3473J != null;
        }

        @Override // p000a.p006b.p030g.p031a.FragmentContainer
        /* renamed from: a */
        public Fragment mo7440a(Context context, String str, Bundle bundle) {
            return Fragment.this.f3505t.mo7440a(context, str, bundle);
        }
    }

    /* renamed from: b */
    public void m7502b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
        }
        this.f3502q = true;
        this.f3485V = new C0603c();
        this.f3484U = null;
        this.f3473J = mo717a(layoutInflater, viewGroup, bundle);
        if (this.f3473J != null) {
            this.f3485V.mo7439a();
            this.f3486W.mo7425b((MutableLiveData<LifecycleOwner>) this.f3485V);
        } else if (this.f3484U == null) {
            this.f3485V = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* renamed from: e */
    public boolean m7485e(MenuItem menuItem) {
        if (this.f3465B) {
            return false;
        }
        if (this.f3469F && this.f3470G && mo930c(menuItem)) {
            return true;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        return layoutInflater$Factory2C0152l != null && layoutInflater$Factory2C0152l.m10212b(menuItem);
    }

    /* renamed from: m */
    public View m7458m() {
        C0604d c0604d = this.f3477N;
        if (c0604d == null) {
            return null;
        }
        return c0604d.f3515a;
    }

    /* renamed from: f */
    public void m7482f(Bundle bundle) {
        this.f3471H = true;
    }

    /* renamed from: h */
    public void m7476h() {
        C0604d c0604d = this.f3477N;
        InterfaceC0605e interfaceC0605e = null;
        if (c0604d != null) {
            c0604d.f3531q = false;
            InterfaceC0605e interfaceC0605e2 = c0604d.f3532r;
            c0604d.f3532r = null;
            interfaceC0605e = interfaceC0605e2;
        }
        if (interfaceC0605e != null) {
            interfaceC0605e.mo7438a();
        }
    }

    /* renamed from: i */
    public final C0604d m7472i() {
        if (this.f3477N == null) {
            this.f3477N = new C0604d();
        }
        return this.f3477N;
    }

    /* renamed from: c */
    public void m7494c(Object obj) {
        m7472i().f3522h = obj;
    }

    /* renamed from: d */
    public LayoutInflater mo7490d(Bundle bundle) {
        return m7514a(bundle);
    }

    /* renamed from: c */
    public void m7495c(Menu menu) {
        if (this.f3465B) {
            return;
        }
        if (this.f3469F && this.f3470G) {
            m7510a(menu);
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10237a(menu);
        }
    }

    /* renamed from: d */
    public void m7487d(boolean z) {
        m7497b(z);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10224a(z);
        }
    }

    /* renamed from: k */
    public boolean m7464k() {
        Boolean bool;
        C0604d c0604d = this.f3477N;
        if (c0604d == null || (bool = c0604d.f3528n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: j */
    public void m7467j(Bundle bundle) {
        Parcelable m10268B;
        mo924e(bundle);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l == null || (m10268B = layoutInflater$Factory2C0152l.m10268B()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", m10268B);
    }

    /* renamed from: d */
    public boolean m7489d(Menu menu) {
        boolean z = false;
        if (this.f3465B) {
            return false;
        }
        if (this.f3469F && this.f3470G) {
            m7501b(menu);
            z = true;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        return layoutInflater$Factory2C0152l != null ? z | layoutInflater$Factory2C0152l.m10213b(menu) : z;
    }

    /* renamed from: g */
    public void m7478g(boolean z) {
        m7472i().f3533s = z;
    }

    /* renamed from: h */
    public void m7475h(Bundle bundle) {
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10156y();
        }
        this.f3487a = 1;
        this.f3471H = false;
        mo728c(bundle);
        this.f3482S = true;
        if (this.f3471H) {
            this.f3483T.m11297a(Lifecycle.EnumC0011a.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* renamed from: l */
    public boolean m7461l() {
        Boolean bool;
        C0604d c0604d = this.f3477N;
        if (c0604d == null || (bool = c0604d.f3527m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: c */
    public void m7496c(int i) {
        m7472i().f3517c = i;
    }

    /* renamed from: a */
    public static boolean m7520a(Context context, String str) {
        try {
            Class<?> cls = f3462X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f3462X.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m7500b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f3465B) {
            return false;
        }
        if (this.f3469F && this.f3470G) {
            mo947a(menu, menuInflater);
            z = true;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        return layoutInflater$Factory2C0152l != null ? z | layoutInflater$Factory2C0152l.m10236a(menu, menuInflater) : z;
    }

    /* renamed from: d */
    public boolean m7488d(MenuItem menuItem) {
        if (this.f3465B) {
            return false;
        }
        if (m7499b(menuItem)) {
            return true;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        return layoutInflater$Factory2C0152l != null && layoutInflater$Factory2C0152l.m10235a(menuItem);
    }

    /* renamed from: a */
    public final void m7526a(int i, Fragment fragment) {
        this.f3491e = i;
        if (fragment != null) {
            this.f3492f = fragment.f3492f + ":" + this.f3491e;
            return;
        }
        this.f3492f = "android:fragment:" + this.f3491e;
    }

    /* renamed from: a */
    public void m7512a(C0606f c0606f) {
        if (this.f3491e < 0) {
            this.f3488b = (c0606f == null || (r2 = c0606f.f3534a) == null) ? null : null;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    /* renamed from: b */
    public void m7505b(int i) {
        if (this.f3477N == null && i == 0) {
            return;
        }
        m7472i().f3518d = i;
    }

    /* renamed from: a */
    public void m7511a(Fragment fragment, int i) {
        FragmentManager m7447v = m7447v();
        FragmentManager m7447v2 = fragment != null ? fragment.m7447v() : null;
        if (m7447v != null && m7447v2 != null && m7447v != m7447v2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.m7544G()) {
            if (fragment2 == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        this.f3494h = fragment;
        this.f3496j = i;
    }

    /* renamed from: a */
    public final String m7528a(int i) {
        return m7549B().getString(i);
    }

    /* renamed from: a */
    public void m7518a(Intent intent) {
        m7516a(intent, (Bundle) null);
    }

    /* renamed from: a */
    public void m7516a(Intent intent, Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mo10296a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* renamed from: a */
    public void m7517a(Intent intent, int i, Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mo10296a(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* renamed from: a */
    public final void m7506a(String[] strArr, int i) {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mo10295a(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    /* renamed from: a */
    public LayoutInflater m7514a(Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        if (fragmentHostCallback != null) {
            LayoutInflater mo10288f = fragmentHostCallback.mo10288f();
            m7453p();
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
            layoutInflater$Factory2C0152l.m10158w();
            LayoutInflaterCompat.m9511b(mo10288f, layoutInflater$Factory2C0152l);
            return mo10288f;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* renamed from: a */
    public void m7521a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f3471H = true;
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        Activity m10293b = fragmentHostCallback == null ? null : fragmentHostCallback.m10293b();
        if (m10293b != null) {
            this.f3471H = false;
            m7522a(m10293b, attributeSet, bundle);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m7522a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f3471H = true;
    }

    /* renamed from: a */
    public void mo778a(Context context) {
        this.f3471H = true;
        FragmentHostCallback fragmentHostCallback = this.f3505t;
        Activity m10293b = fragmentHostCallback == null ? null : fragmentHostCallback.m10293b();
        if (m10293b != null) {
            this.f3471H = false;
            m7523a(m10293b);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m7523a(Activity activity) {
        this.f3471H = true;
    }

    /* renamed from: a */
    public void mo1200a(Object obj) {
        m7472i().f3521g = obj;
    }

    /* renamed from: a */
    public void mo5378a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3510y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3511z));
        printWriter.print(" mTag=");
        printWriter.println(this.f3464A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3487a);
        printWriter.print(" mIndex=");
        printWriter.print(this.f3491e);
        printWriter.print(" mWho=");
        printWriter.print(this.f3492f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3503r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3497k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3498m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3499n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3500o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3465B);
        printWriter.print(" mDetached=");
        printWriter.print(this.f3466C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f3470G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f3469F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f3467D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f3468E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f3476M);
        if (this.f3504s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3504s);
        }
        if (this.f3505t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3505t);
        }
        if (this.f3509x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3509x);
        }
        if (this.f3493g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3493g);
        }
        if (this.f3488b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3488b);
        }
        if (this.f3489c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3489c);
        }
        if (this.f3494h != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f3494h);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3496j);
        }
        if (m7446w() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(m7446w());
        }
        if (this.f3472I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f3472I);
        }
        if (this.f3473J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f3473J);
        }
        if (this.f3474K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f3473J);
        }
        if (m7458m() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m7458m());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(m7545F());
        }
        if (m7452q() != null) {
            LoaderManager.m10076a(this).mo7435a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.f3506u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f3506u + ":");
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
            layoutInflater$Factory2C0152l.mo10229a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* renamed from: a */
    public Fragment m7508a(String str) {
        if (str.equals(this.f3492f)) {
            return this;
        }
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            return layoutInflater$Factory2C0152l.m10210b(str);
        }
        return null;
    }

    /* renamed from: a */
    public void m7515a(Configuration configuration) {
        onConfigurationChanged(configuration);
        LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f3506u;
        if (layoutInflater$Factory2C0152l != null) {
            layoutInflater$Factory2C0152l.m10249a(configuration);
        }
    }

    /* renamed from: a */
    public void m7513a(InterfaceC0605e interfaceC0605e) {
        m7472i();
        InterfaceC0605e interfaceC0605e2 = this.f3477N.f3532r;
        if (interfaceC0605e == interfaceC0605e2) {
            return;
        }
        if (interfaceC0605e != null && interfaceC0605e2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        C0604d c0604d = this.f3477N;
        if (c0604d.f3531q) {
            c0604d.f3532r = interfaceC0605e;
        }
        if (interfaceC0605e != null) {
            interfaceC0605e.mo7437b();
        }
    }

    /* renamed from: a */
    public void m7527a(int i, int i2) {
        if (this.f3477N == null && i == 0 && i2 == 0) {
            return;
        }
        m7472i();
        C0604d c0604d = this.f3477N;
        c0604d.f3519e = i;
        c0604d.f3520f = i2;
    }

    /* renamed from: a */
    public void m7509a(View view) {
        m7472i().f3515a = view;
    }

    /* renamed from: a */
    public void m7524a(Animator animator) {
        m7472i().f3516b = animator;
    }
}
