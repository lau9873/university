package p136d.p153c.p157c0;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.c0.e */
/* loaded from: classes.dex */
public abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t) {
        super(t);
        ObjectHelper.m3598a((Object) t, "value is null");
    }

    /* renamed from: a */
    public abstract void mo3663a(T t);

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public final void mo578b() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        mo3663a(andSet);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public final boolean mo577c() {
        return get() == null;
    }
}
