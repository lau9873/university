package d.c.f0.e.d;

import d.c.r;
import d.c.s;
import d.c.t;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes.dex */
public final class p<T> extends d.c.f0.e.d.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    public final t f5043b;

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5044a;

        public a(b bVar) {
            this.f5044a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.f4959a.a(this.f5044a);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    public static final class b<T> extends AtomicReference<d.c.c0.b> implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super T> f5046a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<d.c.c0.b> f5047b = new AtomicReference<>();

        public b(s<? super T> sVar) {
            this.f5046a = sVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this.f5047b, bVar);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a(this.f5047b);
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.s
        public void a(T t) {
            this.f5046a.a((s<? super T>) t);
        }

        @Override // d.c.s
        public void a(Throwable th) {
            this.f5046a.a(th);
        }

        public void b(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
        }

        @Override // d.c.s
        public void a() {
            this.f5046a.a();
        }
    }

    public p(r<T> rVar, t tVar) {
        super(rVar);
        this.f5043b = tVar;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        b bVar = new b(sVar);
        sVar.a((d.c.c0.b) bVar);
        bVar.b(this.f5043b.a(new a(bVar)));
    }
}
