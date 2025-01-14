package d.c.f0.e.e;
/* compiled from: SingleContains.java */
/* loaded from: classes.dex */
public final class c<T> extends d.c.u<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5072a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5073b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.d<Object, Object> f5074c;

    /* compiled from: SingleContains.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5075a;

        public a(d.c.w wVar) {
            this.f5075a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5075a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                this.f5075a.b(Boolean.valueOf(c.this.f5074c.a(t, c.this.f5073b)));
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5075a.a(th);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5075a.a(th);
        }
    }

    public c(d.c.z<T> zVar, Object obj, d.c.e0.d<Object, Object> dVar) {
        this.f5072a = zVar;
        this.f5073b = obj;
        this.f5074c = dVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super Boolean> wVar) {
        this.f5072a.subscribe(new a(wVar));
    }
}
