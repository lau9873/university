package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.SequentialDisposable;

/* renamed from: d.c.f0.e.a.g0 */
/* loaded from: classes.dex */
public final class CompletableResumeNext extends Completable {

    /* renamed from: a */
    public final CompletableSource f6982a;

    /* renamed from: b */
    public final Function<? super Throwable, ? extends CompletableSource> f6983b;

    /* compiled from: CompletableResumeNext.java */
    /* renamed from: d.c.f0.e.a.g0$a */
    /* loaded from: classes.dex */
    public class C1574a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ CompletableObserver f6984a;

        /* renamed from: b */
        public final /* synthetic */ SequentialDisposable f6985b;

        /* compiled from: CompletableResumeNext.java */
        /* renamed from: d.c.f0.e.a.g0$a$a */
        /* loaded from: classes.dex */
        public class C1575a implements CompletableObserver {
            public C1575a() {
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3489a() {
                C1574a.this.f6984a.mo3489a();
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3501a(Throwable th) {
                C1574a.this.f6984a.mo3501a(th);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3502a(Disposable disposable) {
                C1574a.this.f6985b.m3631b(disposable);
            }
        }

        public C1574a(CompletableObserver completableObserver, SequentialDisposable sequentialDisposable) {
            this.f6984a = completableObserver;
            this.f6985b = sequentialDisposable;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f6984a.mo3489a();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            try {
                CompletableSource mo3490a = CompletableResumeNext.this.f6983b.mo3490a(th);
                if (mo3490a == null) {
                    NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                    nullPointerException.initCause(th);
                    this.f6984a.mo3501a(nullPointerException);
                    return;
                }
                mo3490a.subscribe(new C1575a());
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f6984a.mo3501a(new CompositeException(th2, th));
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6985b.m3631b(disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f6982a = completableSource;
        this.f6983b = function;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        completableObserver.mo3502a(sequentialDisposable);
        this.f6982a.subscribe(new C1574a(completableObserver, sequentialDisposable));
    }
}
