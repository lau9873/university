package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.e.c0 */
/* loaded from: classes.dex */
public final class SingleHide<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7412a;

    /* compiled from: SingleHide.java */
    /* renamed from: d.c.f0.e.e.c0$a */
    /* loaded from: classes.dex */
    public static final class C1658a<T> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7413a;

        /* renamed from: b */
        public Disposable f7414b;

        public C1658a(SingleObserver<? super T> singleObserver) {
            this.f7413a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7414b, disposable)) {
                this.f7414b = disposable;
                this.f7413a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7414b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7414b.mo577c();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7413a.mo3282b(t);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7413a.mo3283a(th);
        }
    }

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f7412a = singleSource;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7412a.subscribe(new C1658a(singleObserver));
    }
}
