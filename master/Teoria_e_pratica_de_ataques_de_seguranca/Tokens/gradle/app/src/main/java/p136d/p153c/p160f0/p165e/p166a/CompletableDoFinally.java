package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.j */
/* loaded from: classes.dex */
public final class CompletableDoFinally extends Completable {

    /* renamed from: a */
    public final CompletableSource f7023a;

    /* renamed from: b */
    public final Action f7024b;

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f7023a = completableSource;
        this.f7024b = action;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7023a.subscribe(new C1584a(completableObserver, this.f7024b));
    }

    /* compiled from: CompletableDoFinally.java */
    /* renamed from: d.c.f0.e.a.j$a */
    /* loaded from: classes.dex */
    public static final class C1584a extends AtomicInteger implements CompletableObserver, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7025a;

        /* renamed from: b */
        public final Action f7026b;

        /* renamed from: c */
        public Disposable f7027c;

        public C1584a(CompletableObserver completableObserver, Action action) {
            this.f7025a = completableObserver;
            this.f7026b = action;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7027c, disposable)) {
                this.f7027c = disposable;
                this.f7025a.mo3502a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7027c.mo578b();
            m3577d();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7027c.mo577c();
        }

        /* renamed from: d */
        public void m3577d() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f7026b.run();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    RxJavaPlugins.m3371b(th);
                }
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7025a.mo3501a(th);
            m3577d();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7025a.mo3489a();
            m3577d();
        }
    }
}
