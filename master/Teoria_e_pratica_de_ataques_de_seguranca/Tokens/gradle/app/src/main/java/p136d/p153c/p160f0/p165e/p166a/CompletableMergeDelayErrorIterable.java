package p136d.p153c.p160f0.p165e.p166a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p165e.p166a.CompletableMergeDelayErrorArray;
import p136d.p153c.p160f0.p175j.AtomicThrowable;

/* renamed from: d.c.f0.e.a.a0 */
/* loaded from: classes.dex */
public final class CompletableMergeDelayErrorIterable extends Completable {

    /* renamed from: a */
    public final Iterable<? extends CompletableSource> f6923a;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.f6923a = iterable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.mo3502a(compositeDisposable);
        try {
            Iterator<? extends CompletableSource> it = this.f6923a.iterator();
            ObjectHelper.m3598a(it, "The source iterator returned is null");
            Iterator<? extends CompletableSource> it2 = it;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!compositeDisposable.mo577c()) {
                try {
                    if (it2.hasNext()) {
                        if (compositeDisposable.mo577c()) {
                            return;
                        }
                        try {
                            CompletableSource next = it2.next();
                            ObjectHelper.m3598a(next, "The iterator returned a null CompletableSource");
                            CompletableSource completableSource = next;
                            if (compositeDisposable.mo577c()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.subscribe(new CompletableMergeDelayErrorArray.C1597a(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                        } catch (Throwable th) {
                            Exceptions.m3660b(th);
                            atomicThrowable.m3418a(th);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    atomicThrowable.m3418a(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable m3419a = atomicThrowable.m3419a();
                    if (m3419a == null) {
                        completableObserver.mo3489a();
                        return;
                    } else {
                        completableObserver.mo3501a(m3419a);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            Exceptions.m3660b(th3);
            completableObserver.mo3501a(th3);
        }
    }
}
