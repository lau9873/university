package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.a.v */
/* loaded from: classes.dex */
public final class CompletableHide extends Completable {

    /* renamed from: a */
    public final CompletableSource f7066a;

    public CompletableHide(CompletableSource completableSource) {
        this.f7066a = completableSource;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7066a.subscribe(new C1593a(completableObserver));
    }

    /* compiled from: CompletableHide.java */
    /* renamed from: d.c.f0.e.a.v$a */
    /* loaded from: classes.dex */
    public static final class C1593a implements CompletableObserver, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7067a;

        /* renamed from: b */
        public Disposable f7068b;

        public C1593a(CompletableObserver completableObserver) {
            this.f7067a = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7068b, disposable)) {
                this.f7068b = disposable;
                this.f7067a.mo3502a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7068b.mo578b();
            this.f7068b = DisposableHelper.DISPOSED;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7068b.mo577c();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7067a.mo3501a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7067a.mo3489a();
        }
    }
}
