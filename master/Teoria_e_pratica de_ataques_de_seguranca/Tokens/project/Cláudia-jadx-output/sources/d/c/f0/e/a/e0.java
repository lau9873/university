package d.c.f0.e.a;

import io.reactivex.exceptions.CompositeException;
/* compiled from: CompletableOnErrorComplete.java */
/* loaded from: classes.dex */
public final class e0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4670a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.p<? super Throwable> f4671b;

    /* compiled from: CompletableOnErrorComplete.java */
    /* loaded from: classes.dex */
    public class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4672a;

        public a(d.c.d dVar) {
            this.f4672a = dVar;
        }

        @Override // d.c.d
        public void a() {
            this.f4672a.a();
        }

        @Override // d.c.d
        public void a(Throwable th) {
            try {
                if (e0.this.f4671b.a(th)) {
                    this.f4672a.a();
                } else {
                    this.f4672a.a(th);
                }
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.f4672a.a(new CompositeException(th, th2));
            }
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4672a.a(bVar);
        }
    }

    public e0(d.c.g gVar, d.c.e0.p<? super Throwable> pVar) {
        this.f4670a = gVar;
        this.f4671b = pVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4670a.subscribe(new a(dVar));
    }
}
