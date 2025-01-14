package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Predicate;

/* renamed from: d.c.f0.e.a.e0 */
/* loaded from: classes.dex */
public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: a */
    public final CompletableSource f6965a;

    /* renamed from: b */
    public final Predicate<? super Throwable> f6966b;

    /* compiled from: CompletableOnErrorComplete.java */
    /* renamed from: d.c.f0.e.a.e0$a */
    /* loaded from: classes.dex */
    public class C1570a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ CompletableObserver f6967a;

        public C1570a(CompletableObserver completableObserver) {
            this.f6967a = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f6967a.mo3489a();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.f6966b.mo3613a(th)) {
                    this.f6967a.mo3489a();
                } else {
                    this.f6967a.mo3501a(th);
                }
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f6967a.mo3501a(new CompositeException(th, th2));
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6967a.mo3502a(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f6965a = completableSource;
        this.f6966b = predicate;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f6965a.subscribe(new C1570a(completableObserver));
    }
}
