package d.c.f0.e.e;

import io.reactivex.exceptions.CompositeException;
/* compiled from: SingleOnErrorReturn.java */
/* loaded from: classes.dex */
public final class j0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5133a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super Throwable, ? extends T> f5134b;

    /* renamed from: c  reason: collision with root package name */
    public final T f5135c;

    public j0(d.c.z<? extends T> zVar, d.c.e0.n<? super Throwable, ? extends T> nVar, T t) {
        this.f5133a = zVar;
        this.f5134b = nVar;
        this.f5135c = t;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5133a.subscribe(new a(wVar));
    }

    /* compiled from: SingleOnErrorReturn.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5136a;

        public a(d.c.w wVar) {
            this.f5136a = wVar;
        }

        @Override // d.c.w
        public void a(Throwable th) {
            T a2;
            j0 j0Var = j0.this;
            d.c.e0.n<? super Throwable, ? extends T> nVar = j0Var.f5134b;
            if (nVar != null) {
                try {
                    a2 = nVar.a(th);
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    this.f5136a.a(new CompositeException(th, th2));
                    return;
                }
            } else {
                a2 = j0Var.f5135c;
            }
            if (a2 == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f5136a.a(nullPointerException);
                return;
            }
            this.f5136a.b(a2);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5136a.b(t);
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5136a.a(bVar);
        }
    }
}
