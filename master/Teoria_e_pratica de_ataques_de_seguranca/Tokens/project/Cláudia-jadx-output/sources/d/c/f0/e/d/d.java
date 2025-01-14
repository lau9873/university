package d.c.f0.e.d;

import d.c.r;
import d.c.s;
/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes.dex */
public final class d<T, U> extends d.c.o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final r<? extends T> f4987a;

    /* renamed from: b  reason: collision with root package name */
    public final r<U> f4988b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* loaded from: classes.dex */
    public class a implements s<U> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.f0.a.e f4990b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ s f4991c;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: d.c.f0.e.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0107a implements s<T> {
            public C0107a() {
            }

            @Override // d.c.s
            public void a(d.c.c0.b bVar) {
                a.this.f4990b.b(bVar);
            }

            @Override // d.c.s
            public void a(T t) {
                a.this.f4991c.a((s) t);
            }

            @Override // d.c.s
            public void a(Throwable th) {
                a.this.f4991c.a(th);
            }

            @Override // d.c.s
            public void a() {
                a.this.f4991c.a();
            }
        }

        public a(d.c.f0.a.e eVar, s sVar) {
            this.f4990b = eVar;
            this.f4991c = sVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f4990b.b(bVar);
        }

        @Override // d.c.s
        public void a(U u) {
            a();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f4989a) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4989a = true;
            this.f4991c.a(th);
        }

        @Override // d.c.s
        public void a() {
            if (this.f4989a) {
                return;
            }
            this.f4989a = true;
            d.this.f4987a.a(new C0107a());
        }
    }

    public d(r<? extends T> rVar, r<U> rVar2) {
        this.f4987a = rVar;
        this.f4988b = rVar2;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        d.c.f0.a.e eVar = new d.c.f0.a.e();
        sVar.a((d.c.c0.b) eVar);
        this.f4988b.a(new a(eVar, sVar));
    }
}
