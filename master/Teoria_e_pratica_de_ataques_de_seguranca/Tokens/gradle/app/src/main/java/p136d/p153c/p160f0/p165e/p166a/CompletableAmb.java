package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.a */
/* loaded from: classes.dex */
public final class CompletableAmb extends Completable {

    /* renamed from: a */
    public final CompletableSource[] f6918a;

    /* renamed from: b */
    public final Iterable<? extends CompletableSource> f6919b;

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.f6918a = completableSourceArr;
        this.f6919b = iterable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        int length;
        CompletableSource[] completableSourceArr = this.f6918a;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                length = 0;
                for (CompletableSource completableSource : this.f6919b) {
                    if (completableSource == null) {
                        EmptyDisposable.m3639a(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (length == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[(length >> 2) + length];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i = length + 1;
                    completableSourceArr[length] = completableSource;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                EmptyDisposable.m3639a(th, completableObserver);
                return;
            }
        } else {
            length = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.mo3502a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C1562a c1562a = new C1562a(this, atomicBoolean, compositeDisposable, completableObserver);
        for (int i2 = 0; i2 < length; i2++) {
            CompletableSource completableSource2 = completableSourceArr[i2];
            if (compositeDisposable.mo577c()) {
                return;
            }
            if (completableSource2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeDisposable.mo578b();
                    completableObserver.mo3501a(nullPointerException);
                    return;
                }
                RxJavaPlugins.m3371b(nullPointerException);
                return;
            }
            completableSource2.subscribe(c1562a);
        }
        if (length == 0) {
            completableObserver.mo3489a();
        }
    }

    /* compiled from: CompletableAmb.java */
    /* renamed from: d.c.f0.e.a.a$a */
    /* loaded from: classes.dex */
    public class C1562a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ AtomicBoolean f6920a;

        /* renamed from: b */
        public final /* synthetic */ CompositeDisposable f6921b;

        /* renamed from: c */
        public final /* synthetic */ CompletableObserver f6922c;

        public C1562a(CompletableAmb completableAmb, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f6920a = atomicBoolean;
            this.f6921b = compositeDisposable;
            this.f6922c = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (this.f6920a.compareAndSet(false, true)) {
                this.f6921b.mo578b();
                this.f6922c.mo3489a();
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            if (this.f6920a.compareAndSet(false, true)) {
                this.f6921b.mo578b();
                this.f6922c.mo3501a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6921b.mo3633c(disposable);
        }
    }
}
