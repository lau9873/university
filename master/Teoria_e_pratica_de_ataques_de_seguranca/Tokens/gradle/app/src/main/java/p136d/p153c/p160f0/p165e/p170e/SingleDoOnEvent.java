package p136d.p153c.p160f0.p165e.p170e;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BiConsumer;

/* renamed from: d.c.f0.e.e.p */
/* loaded from: classes.dex */
public final class SingleDoOnEvent<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7527a;

    /* renamed from: b */
    public final BiConsumer<? super T, ? super Throwable> f7528b;

    /* compiled from: SingleDoOnEvent.java */
    /* renamed from: d.c.f0.e.e.p$a */
    /* loaded from: classes.dex */
    public class C1686a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SingleObserver f7529a;

        public C1686a(SingleObserver singleObserver) {
            this.f7529a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7529a.mo3284a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                SingleDoOnEvent.this.f7528b.m3658a(t, null);
                this.f7529a.mo3282b(t);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7529a.mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            try {
                SingleDoOnEvent.this.f7528b.m3658a(null, th);
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                th = new CompositeException(th, th2);
            }
            this.f7529a.mo3283a(th);
        }
    }

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f7527a = singleSource;
        this.f7528b = biConsumer;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7527a.subscribe(new C1686a(singleObserver));
    }
}
