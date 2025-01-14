package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.y */
/* loaded from: classes.dex */
public final class CompletableMergeArray extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f7081a;

    /* compiled from: CompletableMergeArray.java */
    /* renamed from: d.c.f0.e.a.y$a */
    /* loaded from: classes.dex */
    public static final class C1596a extends AtomicInteger implements CompletableObserver {

        /* renamed from: a */
        public final CompletableObserver f7082a;

        /* renamed from: b */
        public final AtomicBoolean f7083b;

        /* renamed from: c */
        public final CompositeDisposable f7084c;

        public C1596a(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i) {
            this.f7082a = completableObserver;
            this.f7083b = atomicBoolean;
            this.f7084c = compositeDisposable;
            lazySet(i);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7084c.mo3633c(disposable);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7084c.mo578b();
            if (this.f7083b.compareAndSet(false, true)) {
                this.f7082a.mo3501a(th);
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (decrementAndGet() == 0 && this.f7083b.compareAndSet(false, true)) {
                this.f7082a.mo3489a();
            }
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.f7081a = completableSourceArr;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableSource[] completableSourceArr;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        C1596a c1596a = new C1596a(completableObserver, new AtomicBoolean(), compositeDisposable, this.f7081a.length + 1);
        completableObserver.mo3502a(compositeDisposable);
        for (CompletableSource completableSource : this.f7081a) {
            if (compositeDisposable.mo577c()) {
                return;
            }
            if (completableSource == null) {
                compositeDisposable.mo578b();
                c1596a.mo3501a(new NullPointerException("A completable source is null"));
                return;
            }
            completableSource.subscribe(c1596a);
        }
        c1596a.mo3489a();
    }
}
