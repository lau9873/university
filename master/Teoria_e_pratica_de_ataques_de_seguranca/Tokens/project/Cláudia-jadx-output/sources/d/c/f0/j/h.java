package d.c.f0.j;

import d.c.s;
import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* loaded from: classes.dex */
public enum h {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    public static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.c0.b f5378a;

        public String toString() {
            return "NotificationLite.Disposable[" + this.f5378a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f5379a;

        public b(Throwable th) {
            this.f5379a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return d.c.f0.b.b.a(this.f5379a, ((b) obj).f5379a);
            }
            return false;
        }

        public int hashCode() {
            return this.f5379a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f5379a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    public static final class c implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.d f5380a;

        public c(g.b.d dVar) {
            this.f5380a = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f5380a + "]";
        }
    }

    public static <T> Object a(T t) {
        return t;
    }

    public static Object a(Throwable th) {
        return new b(th);
    }

    public static Object b() {
        return COMPLETE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object a(g.b.d dVar) {
        return new c(dVar);
    }

    public static <T> boolean a(Object obj, g.b.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.a();
            return true;
        } else if (obj instanceof b) {
            cVar.a(((b) obj).f5379a);
            return true;
        } else if (obj instanceof c) {
            cVar.a(((c) obj).f5380a);
            return false;
        } else {
            cVar.a((g.b.c<? super T>) obj);
            return false;
        }
    }

    public static <T> boolean a(Object obj, s<? super T> sVar) {
        if (obj == COMPLETE) {
            sVar.a();
            return true;
        } else if (obj instanceof b) {
            sVar.a(((b) obj).f5379a);
            return true;
        } else if (obj instanceof a) {
            sVar.a(((a) obj).f5378a);
            return false;
        } else {
            sVar.a((s<? super T>) obj);
            return false;
        }
    }
}
