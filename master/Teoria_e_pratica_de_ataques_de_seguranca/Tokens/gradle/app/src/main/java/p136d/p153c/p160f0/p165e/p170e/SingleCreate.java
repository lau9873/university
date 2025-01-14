package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleEmitter;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleOnSubscribe;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.d */
/* loaded from: classes.dex */
public final class SingleCreate<T> extends Single<T> {

    /* renamed from: a */
    public final SingleOnSubscribe<T> f7415a;

    /* compiled from: SingleCreate.java */
    /* renamed from: d.c.f0.e.e.d$a */
    /* loaded from: classes.dex */
    public static final class C1659a<T> extends AtomicReference<Disposable> implements SingleEmitter<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7416a;

        public C1659a(SingleObserver<? super T> singleObserver) {
            this.f7416a = singleObserver;
        }

        /* renamed from: a */
        public void m3508a(Throwable th) {
            Disposable andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && (andSet = getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                try {
                    this.f7416a.mo3283a(th);
                    if (andSet != null) {
                        return;
                    }
                    return;
                } finally {
                    if (andSet != null) {
                        andSet.mo578b();
                    }
                }
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }
    }

    public SingleCreate(SingleOnSubscribe<T> singleOnSubscribe) {
        this.f7415a = singleOnSubscribe;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        C1659a c1659a = new C1659a(singleObserver);
        singleObserver.mo3284a(c1659a);
        try {
            this.f7415a.m3281a(c1659a);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            c1659a.m3508a(th);
        }
    }
}
