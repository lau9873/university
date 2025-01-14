package a.a.b;
/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle.java */
    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public abstract b a();

    public abstract void a(d dVar);

    public abstract void b(d dVar);
}
