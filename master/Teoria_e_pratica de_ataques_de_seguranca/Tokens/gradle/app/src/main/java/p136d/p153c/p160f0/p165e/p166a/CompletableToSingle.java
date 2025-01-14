package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.Callable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;

/* renamed from: d.c.f0.e.a.m0 */
/* loaded from: classes.dex */
public final class CompletableToSingle<T> extends Single<T> {

    /* renamed from: a */
    public final CompletableSource f7041a;

    /* renamed from: b */
    public final Callable<? extends T> f7042b;

    /* renamed from: c */
    public final T f7043c;

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.f7041a = completableSource;
        this.f7043c = t;
        this.f7042b = callable;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7041a.subscribe(new C1588a(singleObserver));
    }

    /* compiled from: CompletableToSingle.java */
    /* renamed from: d.c.f0.e.a.m0$a */
    /* loaded from: classes.dex */
    public class C1588a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7044a;

        public C1588a(SingleObserver singleObserver) {
            this.f7044a = singleObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            T call;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Callable<? extends T> callable = completableToSingle.f7042b;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    this.f7044a.mo3283a(th);
                    return;
                }
            } else {
                call = completableToSingle.f7043c;
            }
            if (call == null) {
                this.f7044a.mo3283a(new NullPointerException("The value supplied is null"));
            } else {
                this.f7044a.mo3282b(call);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7044a.mo3283a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7044a.mo3284a(disposable);
        }
    }
}
