package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BiPredicate;

/* renamed from: d.c.f0.e.e.c */
/* loaded from: classes.dex */
public final class SingleContains<T> extends Single<Boolean> {

    /* renamed from: a */
    public final SingleSource<T> f7407a;

    /* renamed from: b */
    public final Object f7408b;

    /* renamed from: c */
    public final BiPredicate<Object, Object> f7409c;

    /* compiled from: SingleContains.java */
    /* renamed from: d.c.f0.e.e.c$a */
    /* loaded from: classes.dex */
    public class C1657a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7410a;

        public C1657a(SingleObserver singleObserver) {
            this.f7410a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7410a.mo3284a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                this.f7410a.mo3282b(Boolean.valueOf(SingleContains.this.f7409c.mo3597a(t, SingleContains.this.f7408b)));
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7410a.mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7410a.mo3283a(th);
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f7407a = singleSource;
        this.f7408b = obj;
        this.f7409c = biPredicate;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f7407a.subscribe(new C1657a(singleObserver));
    }
}
