package d.c.f0.e.e;

import java.util.NoSuchElementException;
/* compiled from: SingleFromPublisher.java */
/* loaded from: classes.dex */
public final class a0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.b<? extends T> f5056a;

    public a0(g.b.b<? extends T> bVar) {
        this.f5056a = bVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5056a.a(new a(wVar));
    }

    /* compiled from: SingleFromPublisher.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.k<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5057a;

        /* renamed from: b  reason: collision with root package name */
        public g.b.d f5058b;

        /* renamed from: c  reason: collision with root package name */
        public T f5059c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5060d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5061e;

        public a(d.c.w<? super T> wVar) {
            this.f5057a = wVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f5058b, dVar)) {
                this.f5058b = dVar;
                this.f5057a.a(this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5061e = true;
            this.f5058b.cancel();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5061e;
        }

        @Override // g.b.c
        public void a(T t) {
            if (this.f5060d) {
                return;
            }
            if (this.f5059c != null) {
                this.f5058b.cancel();
                this.f5060d = true;
                this.f5059c = null;
                this.f5057a.a(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                return;
            }
            this.f5059c = t;
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f5060d) {
                d.c.h0.a.b(th);
                return;
            }
            this.f5060d = true;
            this.f5059c = null;
            this.f5057a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f5060d) {
                return;
            }
            this.f5060d = true;
            T t = this.f5059c;
            this.f5059c = null;
            if (t == null) {
                this.f5057a.a(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f5057a.b(t);
            }
        }
    }
}
