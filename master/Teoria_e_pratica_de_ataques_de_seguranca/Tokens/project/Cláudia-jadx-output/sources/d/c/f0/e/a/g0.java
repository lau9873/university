package d.c.f0.e.a;

import io.reactivex.exceptions.CompositeException;
/* compiled from: CompletableResumeNext.java */
/* loaded from: classes.dex */
public final class g0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4687a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super Throwable, ? extends d.c.g> f4688b;

    /* compiled from: CompletableResumeNext.java */
    /* loaded from: classes.dex */
    public class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4689a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.f0.a.e f4690b;

        /* compiled from: CompletableResumeNext.java */
        /* renamed from: d.c.f0.e.a.g0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0098a implements d.c.d {
            public C0098a() {
            }

            @Override // d.c.d
            public void a() {
                a.this.f4689a.a();
            }

            @Override // d.c.d
            public void a(Throwable th) {
                a.this.f4689a.a(th);
            }

            @Override // d.c.d
            public void a(d.c.c0.b bVar) {
                a.this.f4690b.b(bVar);
            }
        }

        public a(d.c.d dVar, d.c.f0.a.e eVar) {
            this.f4689a = dVar;
            this.f4690b = eVar;
        }

        @Override // d.c.d
        public void a() {
            this.f4689a.a();
        }

        @Override // d.c.d
        public void a(Throwable th) {
            try {
                d.c.g a2 = g0.this.f4688b.a(th);
                if (a2 == null) {
                    NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    this.f4689a.a(nullPointerException);
                    return;
                }
                a2.subscribe(new C0098a());
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.f4689a.a(new CompositeException(th2, th));
            }
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4690b.b(bVar);
        }
    }

    public g0(d.c.g gVar, d.c.e0.n<? super Throwable, ? extends d.c.g> nVar) {
        this.f4687a = gVar;
        this.f4688b = nVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.f0.a.e eVar = new d.c.f0.a.e();
        dVar.a(eVar);
        this.f4687a.subscribe(new a(dVar, eVar));
    }
}
