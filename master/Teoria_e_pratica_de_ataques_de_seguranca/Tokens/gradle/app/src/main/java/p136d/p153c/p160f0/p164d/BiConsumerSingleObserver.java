package p136d.p153c.p160f0.p164d;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BiConsumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.c */
/* loaded from: classes.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

    /* renamed from: a */
    public final BiConsumer<? super T, ? super Throwable> f6898a;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f6898a = biConsumer;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        try {
            this.f6898a.m3658a(null, th);
        } catch (Throwable th2) {
            Exceptions.m3660b(th2);
            RxJavaPlugins.m3371b(new CompositeException(th, th2));
        }
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        try {
            this.f6898a.m3658a(t, null);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            RxJavaPlugins.m3371b(th);
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3284a(Disposable disposable) {
        DisposableHelper.m3644c(this, disposable);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        DisposableHelper.m3647a((AtomicReference<Disposable>) this);
    }
}
