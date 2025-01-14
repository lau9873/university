package p136d.p153c.p160f0.p165e.p166a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.b0 */
/* loaded from: classes.dex */
public final class CompletableMergeIterable extends Completable {

    /* renamed from: a */
    public final Iterable<? extends CompletableSource> f6932a;

    /* compiled from: CompletableMergeIterable.java */
    /* renamed from: d.c.f0.e.a.b0$a */
    /* loaded from: classes.dex */
    public static final class C1564a extends AtomicBoolean implements CompletableObserver {

        /* renamed from: a */
        public final CompositeDisposable f6933a;

        /* renamed from: b */
        public final CompletableObserver f6934b;

        /* renamed from: c */
        public final AtomicInteger f6935c;

        public C1564a(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f6934b = completableObserver;
            this.f6933a = compositeDisposable;
            this.f6935c = atomicInteger;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6933a.mo3633c(disposable);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f6933a.mo578b();
            if (compareAndSet(false, true)) {
                this.f6934b.mo3501a(th);
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (this.f6935c.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f6934b.mo3489a();
            }
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.f6932a = iterable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.mo3502a(compositeDisposable);
        try {
            Iterator<? extends CompletableSource> it = this.f6932a.iterator();
            ObjectHelper.m3598a(it, "The source iterator returned is null");
            Iterator<? extends CompletableSource> it2 = it;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            C1564a c1564a = new C1564a(completableObserver, compositeDisposable, atomicInteger);
            while (!compositeDisposable.mo577c()) {
                try {
                    if (!it2.hasNext()) {
                        c1564a.mo3489a();
                        return;
                    } else if (compositeDisposable.mo577c()) {
                        return;
                    } else {
                        try {
                            CompletableSource next = it2.next();
                            ObjectHelper.m3598a(next, "The iterator returned a null CompletableSource");
                            CompletableSource completableSource = next;
                            if (compositeDisposable.mo577c()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.subscribe(c1564a);
                        } catch (Throwable th) {
                            Exceptions.m3660b(th);
                            compositeDisposable.mo578b();
                            c1564a.mo3501a(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    compositeDisposable.mo578b();
                    c1564a.mo3501a(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.m3660b(th3);
            completableObserver.mo3501a(th3);
        }
    }
}
