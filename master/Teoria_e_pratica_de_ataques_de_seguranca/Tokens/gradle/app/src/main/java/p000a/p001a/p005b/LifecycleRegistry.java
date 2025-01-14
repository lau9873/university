package p000a.p001a.p005b;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000a.p001a.p002a.p004b.FastSafeIterableMap;
import p000a.p001a.p002a.p004b.SafeIterableMap;
import p000a.p001a.p005b.Lifecycle;

/* renamed from: a.a.b.f */
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: c */
    public final WeakReference<LifecycleOwner> f35c;

    /* renamed from: a */
    public FastSafeIterableMap<LifecycleObserver, C0014b> f33a = new FastSafeIterableMap<>();

    /* renamed from: d */
    public int f36d = 0;

    /* renamed from: e */
    public boolean f37e = false;

    /* renamed from: f */
    public boolean f38f = false;

    /* renamed from: g */
    public ArrayList<Lifecycle.EnumC0012b> f39g = new ArrayList<>();

    /* renamed from: b */
    public Lifecycle.EnumC0012b f34b = Lifecycle.EnumC0012b.INITIALIZED;

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: a.a.b.f$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0013a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f40a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f41b = new int[Lifecycle.EnumC0012b.values().length];

        static {
            try {
                f41b[Lifecycle.EnumC0012b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41b[Lifecycle.EnumC0012b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41b[Lifecycle.EnumC0012b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41b[Lifecycle.EnumC0012b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41b[Lifecycle.EnumC0012b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f40a = new int[Lifecycle.EnumC0011a.values().length];
            try {
                f40a[Lifecycle.EnumC0011a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f40a[Lifecycle.EnumC0011a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: a.a.b.f$b */
    /* loaded from: classes.dex */
    public static class C0014b {

        /* renamed from: a */
        public Lifecycle.EnumC0012b f42a;

        /* renamed from: b */
        public GenericLifecycleObserver f43b;

        public C0014b(LifecycleObserver lifecycleObserver, Lifecycle.EnumC0012b enumC0012b) {
            this.f43b = Lifecycling.m11279a(lifecycleObserver);
            this.f42a = enumC0012b;
        }

        /* renamed from: a */
        public void m11281a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a) {
            Lifecycle.EnumC0012b m11291b = LifecycleRegistry.m11291b(enumC0011a);
            this.f42a = LifecycleRegistry.m11295a(this.f42a, m11291b);
            this.f43b.mo7936a(lifecycleOwner, enumC0011a);
            this.f42a = m11291b;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.f35c = new WeakReference<>(lifecycleOwner);
    }

    /* renamed from: d */
    public static Lifecycle.EnumC0011a m11283d(Lifecycle.EnumC0012b enumC0012b) {
        int i = C0013a.f41b[enumC0012b.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + enumC0012b);
                        }
                        throw new IllegalArgumentException();
                    }
                    return Lifecycle.EnumC0011a.ON_PAUSE;
                }
                return Lifecycle.EnumC0011a.ON_STOP;
            }
            return Lifecycle.EnumC0011a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: e */
    public static Lifecycle.EnumC0011a m11282e(Lifecycle.EnumC0012b enumC0012b) {
        int i = C0013a.f41b[enumC0012b.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Lifecycle.EnumC0011a.ON_START;
            }
            if (i == 3) {
                return Lifecycle.EnumC0011a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + enumC0012b);
            }
        }
        return Lifecycle.EnumC0011a.ON_CREATE;
    }

    /* renamed from: a */
    public void m11296a(Lifecycle.EnumC0012b enumC0012b) {
        m11290b(enumC0012b);
    }

    /* renamed from: b */
    public final void m11290b(Lifecycle.EnumC0012b enumC0012b) {
        if (this.f34b == enumC0012b) {
            return;
        }
        this.f34b = enumC0012b;
        if (!this.f37e && this.f36d == 0) {
            this.f37e = true;
            m11284d();
            this.f37e = false;
            return;
        }
        this.f38f = true;
    }

    /* renamed from: c */
    public final Lifecycle.EnumC0012b m11285c(LifecycleObserver lifecycleObserver) {
        Map.Entry<LifecycleObserver, C0014b> m11321b = this.f33a.m11321b(lifecycleObserver);
        Lifecycle.EnumC0012b enumC0012b = null;
        Lifecycle.EnumC0012b enumC0012b2 = m11321b != null ? m11321b.getValue().f42a : null;
        if (!this.f39g.isEmpty()) {
            ArrayList<Lifecycle.EnumC0012b> arrayList = this.f39g;
            enumC0012b = arrayList.get(arrayList.size() - 1);
        }
        return m11295a(m11295a(this.f34b, enumC0012b2), enumC0012b);
    }

    /* renamed from: a */
    public void m11297a(Lifecycle.EnumC0011a enumC0011a) {
        m11290b(m11291b(enumC0011a));
    }

    @Override // p000a.p001a.p005b.Lifecycle
    /* renamed from: a */
    public void mo11294a(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Lifecycle.EnumC0012b enumC0012b = this.f34b;
        Lifecycle.EnumC0012b enumC0012b2 = Lifecycle.EnumC0012b.DESTROYED;
        if (enumC0012b != enumC0012b2) {
            enumC0012b2 = Lifecycle.EnumC0012b.INITIALIZED;
        }
        C0014b c0014b = new C0014b(lifecycleObserver, enumC0012b2);
        if (this.f33a.mo11316b(lifecycleObserver, c0014b) == null && (lifecycleOwner = this.f35c.get()) != null) {
            boolean z = this.f36d != 0 || this.f37e;
            Lifecycle.EnumC0012b m11285c = m11285c(lifecycleObserver);
            this.f36d++;
            while (c0014b.f42a.compareTo(m11285c) < 0 && this.f33a.contains(lifecycleObserver)) {
                m11286c(c0014b.f42a);
                c0014b.m11281a(lifecycleOwner, m11282e(c0014b.f42a));
                m11287c();
                m11285c = m11285c(lifecycleObserver);
            }
            if (!z) {
                m11284d();
            }
            this.f36d--;
        }
    }

    /* renamed from: c */
    public final void m11287c() {
        ArrayList<Lifecycle.EnumC0012b> arrayList = this.f39g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: c */
    public final void m11286c(Lifecycle.EnumC0012b enumC0012b) {
        this.f39g.add(enumC0012b);
    }

    /* renamed from: b */
    public final boolean m11292b() {
        if (this.f33a.size() == 0) {
            return true;
        }
        Lifecycle.EnumC0012b enumC0012b = this.f33a.m11315n().getValue().f42a;
        Lifecycle.EnumC0012b enumC0012b2 = this.f33a.m11313p().getValue().f42a;
        return enumC0012b == enumC0012b2 && this.f34b == enumC0012b2;
    }

    /* renamed from: d */
    public final void m11284d() {
        LifecycleOwner lifecycleOwner = this.f35c.get();
        if (lifecycleOwner == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m11292b()) {
            this.f38f = false;
            if (this.f34b.compareTo(this.f33a.m11315n().getValue().f42a) < 0) {
                m11293a(lifecycleOwner);
            }
            Map.Entry<LifecycleObserver, C0014b> m11313p = this.f33a.m11313p();
            if (!this.f38f && m11313p != null && this.f34b.compareTo(m11313p.getValue().f42a) > 0) {
                m11288b(lifecycleOwner);
            }
        }
        this.f38f = false;
    }

    @Override // p000a.p001a.p005b.Lifecycle
    /* renamed from: b */
    public void mo11289b(LifecycleObserver lifecycleObserver) {
        this.f33a.remove(lifecycleObserver);
    }

    /* renamed from: b */
    public static Lifecycle.EnumC0012b m11291b(Lifecycle.EnumC0011a enumC0011a) {
        switch (C0013a.f40a[enumC0011a.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.EnumC0012b.CREATED;
            case 3:
            case 4:
                return Lifecycle.EnumC0012b.STARTED;
            case 5:
                return Lifecycle.EnumC0012b.RESUMED;
            case 6:
                return Lifecycle.EnumC0012b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + enumC0011a);
        }
    }

    @Override // p000a.p001a.p005b.Lifecycle
    /* renamed from: a */
    public Lifecycle.EnumC0012b mo11298a() {
        return this.f34b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final void m11288b(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, C0014b>.C0006e m11314o = this.f33a.m11314o();
        while (m11314o.hasNext() && !this.f38f) {
            Map.Entry next = m11314o.next();
            C0014b c0014b = (C0014b) next.getValue();
            while (c0014b.f42a.compareTo(this.f34b) < 0 && !this.f38f && this.f33a.contains(next.getKey())) {
                m11286c(c0014b.f42a);
                c0014b.m11281a(lifecycleOwner, m11282e(c0014b.f42a));
                m11287c();
            }
        }
    }

    /* renamed from: a */
    public final void m11293a(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, C0014b>> m11320a = this.f33a.m11320a();
        while (m11320a.hasNext() && !this.f38f) {
            Map.Entry<LifecycleObserver, C0014b> next = m11320a.next();
            C0014b value = next.getValue();
            while (value.f42a.compareTo(this.f34b) > 0 && !this.f38f && this.f33a.contains(next.getKey())) {
                Lifecycle.EnumC0011a m11283d = m11283d(value.f42a);
                m11286c(m11291b(m11283d));
                value.m11281a(lifecycleOwner, m11283d);
                m11287c();
            }
        }
    }

    /* renamed from: a */
    public static Lifecycle.EnumC0012b m11295a(Lifecycle.EnumC0012b enumC0012b, Lifecycle.EnumC0012b enumC0012b2) {
        return (enumC0012b2 == null || enumC0012b2.compareTo(enumC0012b) >= 0) ? enumC0012b : enumC0012b2;
    }
}
