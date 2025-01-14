package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: SingleDoFinally.java */
/* loaded from: classes.dex */
public final class m<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5157a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.a f5158b;

    public m(d.c.z<T> zVar, d.c.e0.a aVar) {
        this.f5157a = zVar;
        this.f5158b = aVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5157a.subscribe(new a(wVar, this.f5158b));
    }

    /* compiled from: SingleDoFinally.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5159a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.a f5160b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5161c;

        public a(d.c.w<? super T> wVar, d.c.e0.a aVar) {
            this.f5159a = wVar;
            this.f5160b = aVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5161c, bVar)) {
                this.f5161c = bVar;
                this.f5159a.a(this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5159a.b(t);
            a();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5161c.c();
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5161c.b();
            a();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5159a.a(th);
            a();
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f5160b.run();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    d.c.h0.a.b(th);
                }
            }
        }
    }
}
