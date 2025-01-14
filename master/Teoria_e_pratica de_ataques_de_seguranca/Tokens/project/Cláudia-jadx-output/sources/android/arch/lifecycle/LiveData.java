package android.arch.lifecycle;

import a.a.b.c;
import a.a.b.e;
import a.a.b.k;
/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object j = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f2023a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public a.a.a.b.b<k<T>, LiveData<T>.b> f2024b = new a.a.a.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    public int f2025c = 0;

    /* renamed from: d  reason: collision with root package name */
    public volatile Object f2026d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f2027e;

    /* renamed from: f  reason: collision with root package name */
    public int f2028f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2029g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2030h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f2031i;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f2023a) {
                obj = LiveData.this.f2027e;
                LiveData.this.f2027e = LiveData.j;
            }
            LiveData.this.b((LiveData) obj);
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public final k<T> f2035a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2036b;

        /* renamed from: c  reason: collision with root package name */
        public int f2037c = -1;

        public b(k<T> kVar) {
            this.f2035a = kVar;
        }

        public void a() {
        }

        public void a(boolean z) {
            if (z == this.f2036b) {
                return;
            }
            this.f2036b = z;
            boolean z2 = LiveData.this.f2025c == 0;
            LiveData.this.f2025c += this.f2036b ? 1 : -1;
            if (z2 && this.f2036b) {
                LiveData.this.c();
            }
            if (LiveData.this.f2025c == 0 && !this.f2036b) {
                LiveData.this.d();
            }
            if (this.f2036b) {
                LiveData.this.b(this);
            }
        }

        public boolean a(e eVar) {
            return false;
        }

        public abstract boolean b();
    }

    public LiveData() {
        Object obj = j;
        this.f2026d = obj;
        this.f2027e = obj;
        this.f2028f = -1;
        this.f2031i = new a();
    }

    public void c() {
    }

    public void d() {
    }

    public final void b(LiveData<T>.b bVar) {
        if (this.f2029g) {
            this.f2030h = true;
            return;
        }
        this.f2029g = true;
        do {
            this.f2030h = false;
            if (bVar != null) {
                a((b) bVar);
                bVar = null;
            } else {
                a.a.a.b.b<k<T>, LiveData<T>.b>.e o = this.f2024b.o();
                while (o.hasNext()) {
                    a((b) ((b) o.next().getValue()));
                    if (this.f2030h) {
                        break;
                    }
                }
            }
        } while (this.f2030h);
        this.f2029g = false;
    }

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.b implements GenericLifecycleObserver {

        /* renamed from: e  reason: collision with root package name */
        public final e f2032e;

        public LifecycleBoundObserver(e eVar, k<T> kVar) {
            super(kVar);
            this.f2032e = eVar;
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        public void a(e eVar, c.a aVar) {
            if (this.f2032e.a().a() == c.b.DESTROYED) {
                LiveData.this.a((k) this.f2035a);
            } else {
                a(b());
            }
        }

        @Override // android.arch.lifecycle.LiveData.b
        public boolean b() {
            return this.f2032e.a().a().a(c.b.STARTED);
        }

        @Override // android.arch.lifecycle.LiveData.b
        public boolean a(e eVar) {
            return this.f2032e == eVar;
        }

        @Override // android.arch.lifecycle.LiveData.b
        public void a() {
            this.f2032e.a().b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(LiveData<T>.b bVar) {
        if (bVar.f2036b) {
            if (!bVar.b()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.f2037c;
            int i3 = this.f2028f;
            if (i2 >= i3) {
                return;
            }
            bVar.f2037c = i3;
            bVar.f2035a.a(this.f2026d);
        }
    }

    public void a(e eVar, k<T> kVar) {
        if (eVar.a().a() == c.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(eVar, kVar);
        LiveData<T>.b b2 = this.f2024b.b(kVar, lifecycleBoundObserver);
        if (b2 != null && !b2.a(eVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (b2 != null) {
            return;
        }
        eVar.a().a(lifecycleBoundObserver);
    }

    public void b(T t) {
        a("setValue");
        this.f2028f++;
        this.f2026d = t;
        b((b) null);
    }

    public void a(k<T> kVar) {
        a("removeObserver");
        LiveData<T>.b remove = this.f2024b.remove(kVar);
        if (remove == null) {
            return;
        }
        remove.a();
        remove.a(false);
    }

    public boolean b() {
        return this.f2025c > 0;
    }

    public void a(T t) {
        boolean z;
        synchronized (this.f2023a) {
            z = this.f2027e == j;
            this.f2027e = t;
        }
        if (z) {
            a.a.a.a.a.b().b(this.f2031i);
        }
    }

    public T a() {
        T t = (T) this.f2026d;
        if (t != j) {
            return t;
        }
        return null;
    }

    public static void a(String str) {
        if (a.a.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
