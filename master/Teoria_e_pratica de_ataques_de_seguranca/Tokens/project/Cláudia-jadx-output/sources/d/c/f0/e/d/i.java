package d.c.f0.e.d;

import d.c.r;
import d.c.s;
/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes.dex */
public final class i<T> extends d.c.f0.e.d.a<T, T> {
    public i(r<T> rVar) {
        super(rVar);
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        this.f4959a.a(new a(sVar));
    }

    /* compiled from: ObservableIgnoreElements.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super T> f5020a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f5021b;

        public a(s<? super T> sVar) {
            this.f5020a = sVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f5021b = bVar;
            this.f5020a.a((d.c.c0.b) this);
        }

        @Override // d.c.s
        public void a(T t) {
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5021b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5021b.c();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            this.f5020a.a(th);
        }

        @Override // d.c.s
        public void a() {
            this.f5020a.a();
        }
    }
}
