package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.Callable;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p158d0.Exceptions;

/* renamed from: d.c.f0.e.a.p */
/* loaded from: classes.dex */
public final class CompletableFromCallable extends Completable {

    /* renamed from: a */
    public final Callable<?> f7056a;

    public CompletableFromCallable(Callable<?> callable) {
        this.f7056a = callable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable m3664b = Disposables.m3664b();
        completableObserver.mo3502a(m3664b);
        try {
            this.f7056a.call();
            if (m3664b.mo577c()) {
                return;
            }
            completableObserver.mo3489a();
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            if (m3664b.mo577c()) {
                return;
            }
            completableObserver.mo3501a(th);
        }
    }
}
