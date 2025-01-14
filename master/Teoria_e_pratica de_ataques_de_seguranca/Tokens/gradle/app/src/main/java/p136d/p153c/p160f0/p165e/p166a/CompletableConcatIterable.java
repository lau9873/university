package p136d.p153c.p160f0.p165e.p166a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p161a.SequentialDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.a.e */
/* loaded from: classes.dex */
public final class CompletableConcatIterable extends Completable {

    /* renamed from: a */
    public final Iterable<? extends CompletableSource> f6961a;

    /* compiled from: CompletableConcatIterable.java */
    /* renamed from: d.c.f0.e.a.e$a */
    /* loaded from: classes.dex */
    public static final class C1569a extends AtomicInteger implements CompletableObserver {

        /* renamed from: a */
        public final CompletableObserver f6962a;

        /* renamed from: b */
        public final Iterator<? extends CompletableSource> f6963b;

        /* renamed from: c */
        public final SequentialDisposable f6964c = new SequentialDisposable();

        public C1569a(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.f6962a = completableObserver;
            this.f6963b = it;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6964c.m3631b(disposable);
        }

        /* renamed from: b */
        public void m3580b() {
            if (!this.f6964c.mo577c() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.f6963b;
                while (!this.f6964c.mo577c()) {
                    try {
                        if (!it.hasNext()) {
                            this.f6962a.mo3489a();
                            return;
                        }
                        try {
                            CompletableSource next = it.next();
                            ObjectHelper.m3598a(next, "The CompletableSource returned is null");
                            next.subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.m3660b(th);
                            this.f6962a.mo3501a(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        this.f6962a.mo3501a(th2);
                        return;
                    }
                }
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f6962a.mo3501a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            m3580b();
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.f6961a = iterable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Iterator<? extends CompletableSource> it = this.f6961a.iterator();
            ObjectHelper.m3598a(it, "The iterator returned is null");
            C1569a c1569a = new C1569a(completableObserver, it);
            completableObserver.mo3502a(c1569a.f6964c);
            c1569a.m3580b();
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptyDisposable.m3639a(th, completableObserver);
        }
    }
}
