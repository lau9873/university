package p136d.p153c.p160f0.p164d;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.i */
/* loaded from: classes.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements InterfaceC1730s<T>, Disposable {

    /* renamed from: a */
    public final Consumer<? super T> f6910a;

    /* renamed from: b */
    public final Consumer<? super Throwable> f6911b;

    /* renamed from: c */
    public final Action f6912c;

    /* renamed from: d */
    public final Consumer<? super Disposable> f6913d;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f6910a = consumer;
        this.f6911b = consumer2;
        this.f6912c = action;
        this.f6913d = consumer3;
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo572a(Disposable disposable) {
        if (DisposableHelper.m3644c(this, disposable)) {
            try {
                this.f6913d.accept(this);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                mo569a(th);
            }
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo570a(T t) {
        if (mo577c()) {
            return;
        }
        try {
            this.f6910a.accept(t);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            mo569a(th);
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo569a(Throwable th) {
        if (mo577c()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f6911b.accept(th);
        } catch (Throwable th2) {
            Exceptions.m3660b(th2);
            RxJavaPlugins.m3371b(new CompositeException(th, th2));
        }
    }

    @Override // p136d.p153c.InterfaceC1730s
    /* renamed from: a */
    public void mo573a() {
        if (mo577c()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f6912c.run();
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            RxJavaPlugins.m3371b(th);
        }
    }
}
