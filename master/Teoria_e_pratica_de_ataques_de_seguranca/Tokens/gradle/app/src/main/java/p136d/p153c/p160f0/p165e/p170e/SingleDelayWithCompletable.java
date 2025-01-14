package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p164d.ResumeSingleObserver;

/* renamed from: d.c.f0.e.e.g */
/* loaded from: classes.dex */
public final class SingleDelayWithCompletable<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7438a;

    /* renamed from: b */
    public final CompletableSource f7439b;

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.f7438a = singleSource;
        this.f7439b = completableSource;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7439b.subscribe(new C1666a(singleObserver, this.f7438a));
    }

    /* compiled from: SingleDelayWithCompletable.java */
    /* renamed from: d.c.f0.e.e.g$a */
    /* loaded from: classes.dex */
    public static final class C1666a<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7440a;

        /* renamed from: b */
        public final SingleSource<T> f7441b;

        public C1666a(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f7440a = singleObserver;
            this.f7441b = singleSource;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable)) {
                this.f7440a.mo3284a(this);
            }
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

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7440a.mo3283a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7441b.subscribe(new ResumeSingleObserver(this, this.f7440a));
        }
    }
}
