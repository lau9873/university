package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.CompositeException;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;

/* renamed from: d.c.f0.e.a.k */
/* loaded from: classes.dex */
public final class CompletableDoOnEvent extends Completable {

    /* renamed from: a */
    public final CompletableSource f7032a;

    /* renamed from: b */
    public final Consumer<? super Throwable> f7033b;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f7032a = completableSource;
        this.f7033b = consumer;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7032a.subscribe(new C1586a(completableObserver));
    }

    /* compiled from: CompletableDoOnEvent.java */
    /* renamed from: d.c.f0.e.a.k$a */
    /* loaded from: classes.dex */
    public class C1586a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ CompletableObserver f7034a;

        public C1586a(CompletableObserver completableObserver) {
            this.f7034a = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            try {
                CompletableDoOnEvent.this.f7033b.accept(null);
                this.f7034a.mo3489a();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7034a.mo3501a(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            try {
                CompletableDoOnEvent.this.f7033b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                th = new CompositeException(th, th2);
            }
            this.f7034a.mo3501a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7034a.mo3502a(disposable);
        }
    }
}
