package p136d.p153c.p160f0.p161a;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.a.e */
/* loaded from: classes.dex */
public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    public SequentialDisposable() {
    }

    /* renamed from: a */
    public boolean m3632a(Disposable disposable) {
        return DisposableHelper.m3646a((AtomicReference<Disposable>) this, disposable);
    }

    /* renamed from: b */
    public boolean m3631b(Disposable disposable) {
        return DisposableHelper.m3645b(this, disposable);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return DisposableHelper.m3649a(get());
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        DisposableHelper.m3647a((AtomicReference<Disposable>) this);
    }
}
