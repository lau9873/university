package p136d.p153c.p160f0.p164d;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.f */
/* loaded from: classes.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

    /* renamed from: a */
    public final Consumer<? super T> f6905a;

    /* renamed from: b */
    public final Consumer<? super Throwable> f6906b;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.f6905a = consumer;
        this.f6906b = consumer2;
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: a */
    public void mo3283a(Throwable th) {
        try {
            this.f6906b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m3660b(th2);
            RxJavaPlugins.m3371b(new CompositeException(th, th2));
        }
    }

    @Override // p136d.p153c.SingleObserver
    /* renamed from: b */
    public void mo3282b(T t) {
        try {
            this.f6905a.accept(t);
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
