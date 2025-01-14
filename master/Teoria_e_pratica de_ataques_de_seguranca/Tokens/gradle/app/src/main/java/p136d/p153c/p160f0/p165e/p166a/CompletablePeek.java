package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.f0 */
/* loaded from: classes.dex */
public final class CompletablePeek extends Completable {

    /* renamed from: a */
    public final CompletableSource f6971a;

    /* renamed from: b */
    public final Consumer<? super Disposable> f6972b;

    /* renamed from: c */
    public final Consumer<? super Throwable> f6973c;

    /* renamed from: d */
    public final Action f6974d;

    /* renamed from: e */
    public final Action f6975e;

    /* renamed from: f */
    public final Action f6976f;

    /* renamed from: g */
    public final Action f6977g;

    /* compiled from: CompletablePeek.java */
    /* renamed from: d.c.f0.e.a.f0$b */
    /* loaded from: classes.dex */
    public final class C1573b implements CompletableObserver, Disposable {

        /* renamed from: a */
        public final CompletableObserver f6978a;

        /* renamed from: b */
        public Disposable f6979b;

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            try {
                CompletablePeek.this.f6972b.accept(disposable);
                if (DisposableHelper.m3648a(this.f6979b, disposable)) {
                    this.f6979b = disposable;
                    this.f6978a.mo3502a(this);
                }
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                disposable.mo578b();
                this.f6979b = DisposableHelper.DISPOSED;
                EmptyDisposable.m3639a(th, this.f6978a);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            try {
                CompletablePeek.this.f6977g.run();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                RxJavaPlugins.m3371b(th);
            }
            this.f6979b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f6979b.mo577c();
        }

        /* renamed from: d */
        public void m3578d() {
            try {
                CompletablePeek.this.f6976f.run();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                RxJavaPlugins.m3371b(th);
            }
        }

        public C1573b(CompletableObserver completableObserver) {
            this.f6978a = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            if (this.f6979b == DisposableHelper.DISPOSED) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            try {
                CompletablePeek.this.f6973c.accept(th);
                CompletablePeek.this.f6975e.run();
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                th = new CompositeException(th, th2);
            }
            this.f6978a.mo3501a(th);
            m3578d();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (this.f6979b == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                CompletablePeek.this.f6974d.run();
                CompletablePeek.this.f6975e.run();
                this.f6978a.mo3489a();
                m3578d();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f6978a.mo3501a(th);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f6971a = completableSource;
        this.f6972b = consumer;
        this.f6973c = consumer2;
        this.f6974d = action;
        this.f6975e = action2;
        this.f6976f = action3;
        this.f6977g = action4;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f6971a.subscribe(new C1573b(completableObserver));
    }
}
