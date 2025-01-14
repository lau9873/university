package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.e.v */
/* loaded from: classes.dex */
public final class SingleFlatMapCompletable<T> extends Completable {

    /* renamed from: a */
    public final SingleSource<T> f7579a;

    /* renamed from: b */
    public final Function<? super T, ? extends CompletableSource> f7580b;

    /* compiled from: SingleFlatMapCompletable.java */
    /* renamed from: d.c.f0.e.e.v$a */
    /* loaded from: classes.dex */
    public static final class C1699a<T> extends AtomicReference<Disposable> implements SingleObserver<T>, CompletableObserver, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7581a;

        /* renamed from: b */
        public final Function<? super T, ? extends CompletableSource> f7582b;

        public C1699a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f7581a = completableObserver;
            this.f7582b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, disposable);
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

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7581a.mo3501a(th);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                CompletableSource mo3490a = this.f7582b.mo3490a(t);
                ObjectHelper.m3598a(mo3490a, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = mo3490a;
                if (mo577c()) {
                    return;
                }
                completableSource.subscribe(this);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                mo3283a(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7581a.mo3489a();
        }
    }

    public SingleFlatMapCompletable(SingleSource<T> singleSource, Function<? super T, ? extends CompletableSource> function) {
        this.f7579a = singleSource;
        this.f7580b = function;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1699a c1699a = new C1699a(completableObserver, this.f7580b);
        completableObserver.mo3502a(c1699a);
        this.f7579a.subscribe(c1699a);
    }
}
