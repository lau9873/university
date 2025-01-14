package android.arch.lifecycle;

import p000a.p001a.p002a.p003a.ArchTaskExecutor;
import p000a.p001a.p002a.p004b.SafeIterableMap;
import p000a.p001a.p005b.Lifecycle;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.Observer;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: j */
    public static final Object f3034j = new Object();

    /* renamed from: a */
    public final Object f3035a = new Object();

    /* renamed from: b */
    public SafeIterableMap<Observer<T>, LiveData<T>.AbstractC0519b> f3036b = new SafeIterableMap<>();

    /* renamed from: c */
    public int f3037c = 0;

    /* renamed from: d */
    public volatile Object f3038d;

    /* renamed from: e */
    public volatile Object f3039e;

    /* renamed from: f */
    public int f3040f;

    /* renamed from: g */
    public boolean f3041g;

    /* renamed from: h */
    public boolean f3042h;

    /* renamed from: i */
    public final Runnable f3043i;

    /* renamed from: android.arch.lifecycle.LiveData$a */
    /* loaded from: classes.dex */
    public class RunnableC0518a implements Runnable {
        public RunnableC0518a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3035a) {
                obj = LiveData.this.f3039e;
                LiveData.this.f3039e = LiveData.f3034j;
            }
            LiveData.this.mo7425b((LiveData) obj);
        }
    }

    /* renamed from: android.arch.lifecycle.LiveData$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC0519b {

        /* renamed from: a */
        public final Observer<T> f3047a;

        /* renamed from: b */
        public boolean f3048b;

        /* renamed from: c */
        public int f3049c = -1;

        public AbstractC0519b(Observer<T> observer) {
            this.f3047a = observer;
        }

        /* renamed from: a */
        public void mo7940a() {
        }

        /* renamed from: a */
        public void m7938a(boolean z) {
            if (z == this.f3048b) {
                return;
            }
            this.f3048b = z;
            boolean z2 = LiveData.this.f3037c == 0;
            LiveData.this.f3037c += this.f3048b ? 1 : -1;
            if (z2 && this.f3048b) {
                LiveData.this.mo7424c();
            }
            if (LiveData.this.f3037c == 0 && !this.f3048b) {
                LiveData.this.mo7423d();
            }
            if (this.f3048b) {
                LiveData.this.m7944b(this);
            }
        }

        /* renamed from: a */
        public boolean mo7939a(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* renamed from: b */
        public abstract boolean mo7937b();
    }

    public LiveData() {
        Object obj = f3034j;
        this.f3038d = obj;
        this.f3039e = obj;
        this.f3040f = -1;
        this.f3043i = new RunnableC0518a();
    }

    /* renamed from: c */
    public void mo7424c() {
    }

    /* renamed from: d */
    public void mo7423d() {
    }

    /* renamed from: b */
    public final void m7944b(LiveData<T>.AbstractC0519b abstractC0519b) {
        if (this.f3041g) {
            this.f3042h = true;
            return;
        }
        this.f3041g = true;
        do {
            this.f3042h = false;
            if (abstractC0519b != null) {
                m7952a((AbstractC0519b) abstractC0519b);
                abstractC0519b = null;
            } else {
                SafeIterableMap<Observer<T>, LiveData<T>.AbstractC0519b>.C0006e m11314o = this.f3036b.m11314o();
                while (m11314o.hasNext()) {
                    m7952a((AbstractC0519b) ((AbstractC0519b) m11314o.next().getValue()));
                    if (this.f3042h) {
                        break;
                    }
                }
            }
        } while (this.f3042h);
        this.f3041g = false;
    }

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.AbstractC0519b implements GenericLifecycleObserver {

        /* renamed from: e */
        public final LifecycleOwner f3044e;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            super(observer);
            this.f3044e = lifecycleOwner;
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        /* renamed from: a */
        public void mo7936a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
            if (this.f3044e.mo7439a().mo11298a() == Lifecycle.EnumC0012b.DESTROYED) {
                LiveData.this.mo7429a((Observer) this.f3047a);
            } else {
                m7938a(mo7937b());
            }
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0519b
        /* renamed from: b */
        public boolean mo7937b() {
            return this.f3044e.mo7439a().mo11298a().m11299a(Lifecycle.EnumC0012b.STARTED);
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0519b
        /* renamed from: a */
        public boolean mo7939a(LifecycleOwner lifecycleOwner) {
            return this.f3044e == lifecycleOwner;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0519b
        /* renamed from: a */
        public void mo7940a() {
            this.f3044e.mo7439a().mo11289b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m7952a(LiveData<T>.AbstractC0519b abstractC0519b) {
        if (abstractC0519b.f3048b) {
            if (!abstractC0519b.mo7937b()) {
                abstractC0519b.m7938a(false);
                return;
            }
            int i = abstractC0519b.f3049c;
            int i2 = this.f3040f;
            if (i >= i2) {
                return;
            }
            abstractC0519b.f3049c = i2;
            abstractC0519b.f3047a.m11273a(this.f3038d);
        }
    }

    /* renamed from: a */
    public void m7953a(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        if (lifecycleOwner.mo7439a().mo11298a() == Lifecycle.EnumC0012b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.AbstractC0519b mo11316b = this.f3036b.mo11316b(observer, lifecycleBoundObserver);
        if (mo11316b != null && !mo11316b.mo7939a(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (mo11316b != null) {
            return;
        }
        lifecycleOwner.mo7439a().mo11294a(lifecycleBoundObserver);
    }

    /* renamed from: b */
    public void mo7425b(T t) {
        m7946a("setValue");
        this.f3040f++;
        this.f3038d = t;
        m7944b((AbstractC0519b) null);
    }

    /* renamed from: a */
    public void mo7429a(Observer<T> observer) {
        m7946a("removeObserver");
        LiveData<T>.AbstractC0519b remove = this.f3036b.remove(observer);
        if (remove == null) {
            return;
        }
        remove.mo7940a();
        remove.m7938a(false);
    }

    /* renamed from: b */
    public boolean m7945b() {
        return this.f3037c > 0;
    }

    /* renamed from: a */
    public void mo7947a(T t) {
        boolean z;
        synchronized (this.f3035a) {
            z = this.f3039e == f3034j;
            this.f3039e = t;
        }
        if (z) {
            ArchTaskExecutor.m11325b().mo11322b(this.f3043i);
        }
    }

    /* renamed from: a */
    public T m7954a() {
        T t = (T) this.f3038d;
        if (t != f3034j) {
            return t;
        }
        return null;
    }

    /* renamed from: a */
    public static void m7946a(String str) {
        if (ArchTaskExecutor.m11325b().mo11324a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
