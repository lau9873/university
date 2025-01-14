package d.c.f0.e.e;

import io.reactivex.exceptions.CompositeException;
/* compiled from: SingleDoOnEvent.java */
/* loaded from: classes.dex */
public final class p<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5192a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.b<? super T, ? super Throwable> f5193b;

    /* compiled from: SingleDoOnEvent.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5194a;

        public a(d.c.w wVar) {
            this.f5194a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5194a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                p.this.f5193b.a(t, null);
                this.f5194a.b(t);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5194a.a(th);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            try {
                p.this.f5193b.a(null, th);
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f5194a.a(th);
        }
    }

    public p(d.c.z<T> zVar, d.c.e0.b<? super T, ? super Throwable> bVar) {
        this.f5192a = zVar;
        this.f5193b = bVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5192a.subscribe(new a(wVar));
    }
}
