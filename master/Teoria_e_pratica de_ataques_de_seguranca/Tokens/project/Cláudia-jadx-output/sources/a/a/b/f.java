package a.a.b;

import a.a.b.c;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class f extends c {

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<e> f36c;

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.b.a<d, b> f34a = new a.a.a.b.a<>();

    /* renamed from: d  reason: collision with root package name */
    public int f37d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39f = false;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.b> f40g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public c.b f35b = c.b.INITIALIZED;

    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f42b = new int[c.b.values().length];

        static {
            try {
                f42b[c.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42b[c.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42b[c.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42b[c.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42b[c.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f41a = new int[c.a.values().length];
            try {
                f41a[c.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41a[c.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41a[c.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41a[c.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41a[c.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41a[c.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41a[c.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c.b f43a;

        /* renamed from: b  reason: collision with root package name */
        public GenericLifecycleObserver f44b;

        public b(d dVar, c.b bVar) {
            this.f44b = h.a(dVar);
            this.f43a = bVar;
        }

        public void a(e eVar, c.a aVar) {
            c.b b2 = f.b(aVar);
            this.f43a = f.a(this.f43a, b2);
            this.f44b.a(eVar, aVar);
            this.f43a = b2;
        }
    }

    public f(e eVar) {
        this.f36c = new WeakReference<>(eVar);
    }

    public static c.a d(c.b bVar) {
        int i2 = a.f42b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return c.a.ON_PAUSE;
                }
                return c.a.ON_STOP;
            }
            return c.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    public static c.a e(c.b bVar) {
        int i2 = a.f42b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return c.a.ON_START;
            }
            if (i2 == 3) {
                return c.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            }
            if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return c.a.ON_CREATE;
    }

    public void a(c.b bVar) {
        b(bVar);
    }

    public final void b(c.b bVar) {
        if (this.f35b == bVar) {
            return;
        }
        this.f35b = bVar;
        if (!this.f38e && this.f37d == 0) {
            this.f38e = true;
            d();
            this.f38e = false;
            return;
        }
        this.f39f = true;
    }

    public final c.b c(d dVar) {
        Map.Entry<d, b> b2 = this.f34a.b(dVar);
        c.b bVar = null;
        c.b bVar2 = b2 != null ? b2.getValue().f43a : null;
        if (!this.f40g.isEmpty()) {
            ArrayList<c.b> arrayList = this.f40g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f35b, bVar2), bVar);
    }

    public void a(c.a aVar) {
        b(b(aVar));
    }

    @Override // a.a.b.c
    public void a(d dVar) {
        e eVar;
        c.b bVar = this.f35b;
        c.b bVar2 = c.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = c.b.INITIALIZED;
        }
        b bVar3 = new b(dVar, bVar2);
        if (this.f34a.b(dVar, bVar3) == null && (eVar = this.f36c.get()) != null) {
            boolean z = this.f37d != 0 || this.f38e;
            c.b c2 = c(dVar);
            this.f37d++;
            while (bVar3.f43a.compareTo(c2) < 0 && this.f34a.contains(dVar)) {
                c(bVar3.f43a);
                bVar3.a(eVar, e(bVar3.f43a));
                c();
                c2 = c(dVar);
            }
            if (!z) {
                d();
            }
            this.f37d--;
        }
    }

    public final void c() {
        ArrayList<c.b> arrayList = this.f40g;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void c(c.b bVar) {
        this.f40g.add(bVar);
    }

    public final boolean b() {
        if (this.f34a.size() == 0) {
            return true;
        }
        c.b bVar = this.f34a.n().getValue().f43a;
        c.b bVar2 = this.f34a.p().getValue().f43a;
        return bVar == bVar2 && this.f35b == bVar2;
    }

    public final void d() {
        e eVar = this.f36c.get();
        if (eVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f39f = false;
            if (this.f35b.compareTo(this.f34a.n().getValue().f43a) < 0) {
                a(eVar);
            }
            Map.Entry<d, b> p = this.f34a.p();
            if (!this.f39f && p != null && this.f35b.compareTo(p.getValue().f43a) > 0) {
                b(eVar);
            }
        }
        this.f39f = false;
    }

    @Override // a.a.b.c
    public void b(d dVar) {
        this.f34a.remove(dVar);
    }

    public static c.b b(c.a aVar) {
        switch (a.f41a[aVar.ordinal()]) {
            case 1:
            case 2:
                return c.b.CREATED;
            case 3:
            case 4:
                return c.b.STARTED;
            case 5:
                return c.b.RESUMED;
            case 6:
                return c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    @Override // a.a.b.c
    public c.b a() {
        return this.f35b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(e eVar) {
        a.a.a.b.b<d, b>.e o = this.f34a.o();
        while (o.hasNext() && !this.f39f) {
            Map.Entry next = o.next();
            b bVar = (b) next.getValue();
            while (bVar.f43a.compareTo(this.f35b) < 0 && !this.f39f && this.f34a.contains(next.getKey())) {
                c(bVar.f43a);
                bVar.a(eVar, e(bVar.f43a));
                c();
            }
        }
    }

    public final void a(e eVar) {
        Iterator<Map.Entry<d, b>> a2 = this.f34a.a();
        while (a2.hasNext() && !this.f39f) {
            Map.Entry<d, b> next = a2.next();
            b value = next.getValue();
            while (value.f43a.compareTo(this.f35b) > 0 && !this.f39f && this.f34a.contains(next.getKey())) {
                c.a d2 = d(value.f43a);
                c(b(d2));
                value.a(eVar, d2);
                c();
            }
        }
    }

    public static c.b a(c.b bVar, c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
