package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.SequentialDisposable;

/* renamed from: d.c.f0.e.a.d */
/* loaded from: classes.dex */
public final class CompletableConcatArray extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f6951a;

    /* compiled from: CompletableConcatArray.java */
    /* renamed from: d.c.f0.e.a.d$a */
    /* loaded from: classes.dex */
    public static final class C1567a extends AtomicInteger implements CompletableObserver {

        /* renamed from: a */
        public final CompletableObserver f6952a;

        /* renamed from: b */
        public final CompletableSource[] f6953b;

        /* renamed from: c */
        public int f6954c;

        /* renamed from: d */
        public final SequentialDisposable f6955d = new SequentialDisposable();

        public C1567a(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.f6952a = completableObserver;
            this.f6953b = completableSourceArr;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6955d.m3631b(disposable);
        }

        /* renamed from: b */
        public void m3581b() {
            if (!this.f6955d.mo577c() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.f6953b;
                while (!this.f6955d.mo577c()) {
                    int i = this.f6954c;
                    this.f6954c = i + 1;
                    if (i == completableSourceArr.length) {
                        this.f6952a.mo3489a();
                        return;
                    }
                    completableSourceArr[i].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f6952a.mo3501a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            m3581b();
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.f6951a = completableSourceArr;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        C1567a c1567a = new C1567a(completableObserver, this.f6951a);
        completableObserver.mo3502a(c1567a.f6955d);
        c1567a.m3581b();
    }
}
