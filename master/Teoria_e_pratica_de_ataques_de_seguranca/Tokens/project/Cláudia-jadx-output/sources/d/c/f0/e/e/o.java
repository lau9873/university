package d.c.f0.e.e;

import io.reactivex.exceptions.CompositeException;
/* compiled from: SingleDoOnError.java */
/* loaded from: classes.dex */
public final class o<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5184a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f5185b;

    /* compiled from: SingleDoOnError.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5186a;

        public a(d.c.w wVar) {
            this.f5186a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5186a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5186a.b(t);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            try {
                o.this.f5185b.accept(th);
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f5186a.a(th);
        }
    }

    public o(d.c.z<T> zVar, d.c.e0.f<? super Throwable> fVar) {
        this.f5184a = zVar;
        this.f5185b = fVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5184a.subscribe(new a(wVar));
    }
}
