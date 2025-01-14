package p000a.p001a.p005b;

/* renamed from: a.a.b.c */
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* compiled from: Lifecycle.java */
    /* renamed from: a.a.b.c$a */
    /* loaded from: classes.dex */
    public enum EnumC0011a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: a.a.b.c$b */
    /* loaded from: classes.dex */
    public enum EnumC0012b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean m11299a(EnumC0012b enumC0012b) {
            return compareTo(enumC0012b) >= 0;
        }
    }

    /* renamed from: a */
    public abstract EnumC0012b mo11298a();

    /* renamed from: a */
    public abstract void mo11294a(LifecycleObserver lifecycleObserver);

    /* renamed from: b */
    public abstract void mo11289b(LifecycleObserver lifecycleObserver);
}
