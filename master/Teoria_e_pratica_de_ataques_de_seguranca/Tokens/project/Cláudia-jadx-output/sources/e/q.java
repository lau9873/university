package e;
/* compiled from: EventListener.java */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f5908a = new a();

    /* compiled from: EventListener.java */
    /* loaded from: classes.dex */
    public class a extends q {
    }

    /* compiled from: EventListener.java */
    /* loaded from: classes.dex */
    public class b implements c {
        public b() {
        }

        @Override // e.q.c
        public q a(e eVar) {
            return q.this;
        }
    }

    /* compiled from: EventListener.java */
    /* loaded from: classes.dex */
    public interface c {
        q a(e eVar);
    }

    public static c a(q qVar) {
        return new b();
    }
}
