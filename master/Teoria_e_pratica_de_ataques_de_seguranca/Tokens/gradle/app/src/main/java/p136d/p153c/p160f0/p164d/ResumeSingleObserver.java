package p136d.p153c.p160f0.p164d;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.d.j */
/* loaded from: classes.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: a */
    public final AtomicReference<Disposable> f6914a;

    /* renamed from: b */
    public final SingleObserver<? super T> f6915b;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f6914a = atomicReference;
        this.f6915b = singleObserver;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3284a(Disposable disposable) {
        DisposableHelper.m3646a(this.f6914a, disposable);
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        this.f6915b.mo3282b(t);
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        this.f6915b.mo3283a(th);
    }
}
