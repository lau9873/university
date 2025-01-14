package d.c.f0.e.a;

import java.util.concurrent.Callable;
/* compiled from: CompletableToSingle.java */
/* loaded from: classes.dex */
public final class m0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4746a;

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f4747b;

    /* renamed from: c  reason: collision with root package name */
    public final T f4748c;

    public m0(d.c.g gVar, Callable<? extends T> callable, T t) {
        this.f4746a = gVar;
        this.f4748c = t;
        this.f4747b = callable;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f4746a.subscribe(new a(wVar));
    }

    /* compiled from: CompletableToSingle.java */
    /* loaded from: classes.dex */
    public class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.c.w f4749a;

        public a(d.c.w wVar) {
            this.f4749a = wVar;
        }

        @Override // d.c.d
        public void a() {
            T call;
            m0 m0Var = m0.this;
            Callable<? extends T> callable = m0Var.f4747b;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    this.f4749a.a(th);
                    return;
                }
            } else {
                call = m0Var.f4748c;
            }
            if (call == null) {
                this.f4749a.a(new NullPointerException("The value supplied is null"));
            } else {
                this.f4749a.b(call);
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4749a.a(th);
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4749a.a(bVar);
        }
    }
}
