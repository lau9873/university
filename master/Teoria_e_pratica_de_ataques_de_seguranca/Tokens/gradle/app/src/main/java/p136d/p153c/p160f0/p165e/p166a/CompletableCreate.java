package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableEmitter;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableOnSubscribe;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.f */
/* loaded from: classes.dex */
public final class CompletableCreate extends Completable {

    /* renamed from: a */
    public final CompletableOnSubscribe f6969a;

    /* compiled from: CompletableCreate.java */
    /* renamed from: d.c.f0.e.a.f$a */
    /* loaded from: classes.dex */
    public static final class C1571a extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {

        /* renamed from: a */
        public final CompletableObserver f6970a;

        public C1571a(CompletableObserver completableObserver) {
            this.f6970a = completableObserver;
        }

        /* renamed from: a */
        public void m3579a(Throwable th) {
            Disposable andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && (andSet = getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                try {
                    this.f6970a.mo3501a(th);
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

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.f6969a = completableOnSubscribe;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1571a c1571a = new C1571a(completableObserver);
        completableObserver.mo3502a(c1571a);
        try {
            this.f6969a.m3659a(c1571a);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            c1571a.m3579a(th);
        }
    }
}
