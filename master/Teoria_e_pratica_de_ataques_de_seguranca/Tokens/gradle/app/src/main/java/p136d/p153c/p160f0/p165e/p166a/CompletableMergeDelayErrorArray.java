package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.z */
/* loaded from: classes.dex */
public final class CompletableMergeDelayErrorArray extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f7085a;

    /* compiled from: CompletableMergeDelayErrorArray.java */
    /* renamed from: d.c.f0.e.a.z$a */
    /* loaded from: classes.dex */
    public static final class C1597a implements CompletableObserver {

        /* renamed from: a */
        public final CompletableObserver f7086a;

        /* renamed from: b */
        public final CompositeDisposable f7087b;

        /* renamed from: c */
        public final AtomicThrowable f7088c;

        /* renamed from: d */
        public final AtomicInteger f7089d;

        public C1597a(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f7086a = completableObserver;
            this.f7087b = compositeDisposable;
            this.f7088c = atomicThrowable;
            this.f7089d = atomicInteger;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7087b.mo3633c(disposable);
        }

        /* renamed from: b */
        public void m3571b() {
            if (this.f7089d.decrementAndGet() == 0) {
                Throwable m3419a = this.f7088c.m3419a();
                if (m3419a == null) {
                    this.f7086a.mo3489a();
                } else {
                    this.f7086a.mo3501a(m3419a);
                }
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            if (this.f7088c.m3418a(th)) {
                m3571b();
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            m3571b();
        }
    }

    public CompletableMergeDelayErrorArray(CompletableSource[] completableSourceArr) {
        this.f7085a = completableSourceArr;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableSource[] completableSourceArr;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.f7085a.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        completableObserver.mo3502a(compositeDisposable);
        for (CompletableSource completableSource : this.f7085a) {
            if (compositeDisposable.mo577c()) {
                return;
            }
            if (completableSource == null) {
                atomicThrowable.m3418a(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completableSource.subscribe(new C1597a(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable m3419a = atomicThrowable.m3419a();
            if (m3419a == null) {
                completableObserver.mo3489a();
            } else {
                completableObserver.mo3501a(m3419a);
            }
        }
    }
}
