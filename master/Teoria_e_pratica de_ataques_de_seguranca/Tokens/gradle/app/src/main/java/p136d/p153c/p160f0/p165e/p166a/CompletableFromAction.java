package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;

/* renamed from: d.c.f0.e.a.o */
/* loaded from: classes.dex */
public final class CompletableFromAction extends Completable {

    /* renamed from: a */
    public final Action f7055a;

    public CompletableFromAction(Action action) {
        this.f7055a = action;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable m3664b = Disposables.m3664b();
        completableObserver.mo3502a(m3664b);
        try {
            this.f7055a.run();
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
