package p136d.p153c.p160f0.p164d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.d.g */
/* loaded from: classes.dex */
public final class EmptyCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3489a() {
        lazySet(DisposableHelper.DISPOSED);
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

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3501a(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        RxJavaPlugins.m3371b(new OnErrorNotImplementedException(th));
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3502a(Disposable disposable) {
        DisposableHelper.m3644c(this, disposable);
    }
}
