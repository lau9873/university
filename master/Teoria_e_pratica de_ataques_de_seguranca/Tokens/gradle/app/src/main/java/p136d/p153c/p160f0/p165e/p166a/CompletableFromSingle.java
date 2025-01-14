package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.a.t */
/* loaded from: classes.dex */
public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: a */
    public final SingleSource<T> f7063a;

    /* compiled from: CompletableFromSingle.java */
    /* renamed from: d.c.f0.e.a.t$a */
    /* loaded from: classes.dex */
    public static final class C1592a<T> implements SingleObserver<T> {

        /* renamed from: a */
        public final CompletableObserver f7064a;

        public C1592a(CompletableObserver completableObserver) {
            this.f7064a = completableObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7064a.mo3501a(th);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7064a.mo3489a();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7064a.mo3502a(disposable);
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f7063a = singleSource;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7063a.subscribe(new C1592a(completableObserver));
    }
}
