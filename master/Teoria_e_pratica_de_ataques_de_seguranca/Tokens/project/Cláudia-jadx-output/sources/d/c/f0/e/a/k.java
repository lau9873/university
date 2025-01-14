package d.c.f0.e.a;

import io.reactivex.exceptions.CompositeException;
/* compiled from: CompletableDoOnEvent.java */
/* loaded from: classes.dex */
public final class k extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4737a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f4738b;

    public k(d.c.g gVar, d.c.e0.f<? super Throwable> fVar) {
        this.f4737a = gVar;
        this.f4738b = fVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4737a.subscribe(new a(dVar));
    }

    /* compiled from: CompletableDoOnEvent.java */
    /* loaded from: classes.dex */
    public class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4739a;

        public a(d.c.d dVar) {
            this.f4739a = dVar;
        }

        @Override // d.c.d
        public void a() {
            try {
                k.this.f4738b.accept(null);
                this.f4739a.a();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f4739a.a(th);
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            try {
                k.this.f4738b.accept(th);
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f4739a.a(th);
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4739a.a(bVar);
        }
    }
}
