package d.c.f0.e.d;

import d.c.r;
import d.c.s;
/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes.dex */
public final class j<T> extends d.c.b implements d.c.f0.c.d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final r<T> f5022a;

    public j(r<T> rVar) {
        this.f5022a = rVar;
    }

    @Override // d.c.f0.c.d
    public d.c.o<T> b() {
        return d.c.h0.a.a(new i(this.f5022a));
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f5022a.a(new a(dVar));
    }

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f5023a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f5024b;

        public a(d.c.d dVar) {
            this.f5023a = dVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f5024b = bVar;
            this.f5023a.a(this);
        }

        @Override // d.c.s
        public void a(T t) {
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5024b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5024b.c();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            this.f5023a.a(th);
        }

        @Override // d.c.s
        public void a() {
            this.f5023a.a();
        }
    }
}
