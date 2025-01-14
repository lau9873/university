package p136d.p153c.p160f0.p164d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.e */
/* loaded from: classes.dex */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable> {

    /* renamed from: a */
    public final Consumer<? super Throwable> f6903a;

    /* renamed from: b */
    public final Action f6904b;

    public CallbackCompletableObserver(Action action) {
        this.f6903a = this;
        this.f6904b = action;
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3489a() {
        try {
            this.f6904b.run();
            lazySet(DisposableHelper.DISPOSED);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            mo3501a(th);
        }
    }

    @Override // p136d.p153c.p159e0.Consumer
    /* renamed from: b */
    public void accept(Throwable th) {
        RxJavaPlugins.m3371b(new OnErrorNotImplementedException(th));
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        DisposableHelper.m3647a((AtomicReference<Disposable>) this);
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.f6903a = consumer;
        this.f6904b = action;
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3501a(Throwable th) {
        try {
            this.f6903a.accept(th);
        } catch (Throwable th2) {
            Exceptions.m3660b(th2);
            RxJavaPlugins.m3371b(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3502a(Disposable disposable) {
        DisposableHelper.m3644c(this, disposable);
    }
}
