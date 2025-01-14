package d.c.f0.e.e;
/* compiled from: SingleDoOnSuccess.java */
/* loaded from: classes.dex */
public final class r<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5206a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super T> f5207b;

    /* compiled from: SingleDoOnSuccess.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5208a;

        public a(d.c.w wVar) {
            this.f5208a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5208a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                r.this.f5207b.accept(t);
                this.f5208a.b(t);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5208a.a(th);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5208a.a(th);
        }
    }

    public r(d.c.z<T> zVar, d.c.e0.f<? super T> fVar) {
        this.f5206a = zVar;
        this.f5207b = fVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5206a.subscribe(new a(wVar));
    }
}
