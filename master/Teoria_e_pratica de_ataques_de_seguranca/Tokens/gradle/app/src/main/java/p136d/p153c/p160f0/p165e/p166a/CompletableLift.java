package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableOperator;
import p136d.p153c.CompletableSource;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.w */
/* loaded from: classes.dex */
public final class CompletableLift extends Completable {

    /* renamed from: a */
    public final CompletableSource f7069a;

    /* renamed from: b */
    public final CompletableOperator f7070b;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f7069a = completableSource;
        this.f7070b = completableOperator;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f7069a.subscribe(this.f7070b.m3650a(completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            RxJavaPlugins.m3371b(th);
        }
    }
}
