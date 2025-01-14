package h.b.a.d;

import h.b.a.d.f;
/* compiled from: AsyncResult.java */
/* loaded from: classes.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f6902a;

    /* compiled from: AsyncResult.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(b<T> bVar);
    }

    /* compiled from: AsyncResult.java */
    /* renamed from: h.b.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0157b<T> extends b<T> {
        public f.a d() {
            return null;
        }
    }

    public abstract T a();

    public void a(a<T> aVar) {
        synchronized (this) {
            this.f6902a = aVar;
            if (b()) {
                aVar.a(this);
            }
        }
    }

    public abstract boolean b();

    public void c() {
        synchronized (this) {
            if (this.f6902a != null) {
                this.f6902a.a(this);
            }
        }
    }
}
