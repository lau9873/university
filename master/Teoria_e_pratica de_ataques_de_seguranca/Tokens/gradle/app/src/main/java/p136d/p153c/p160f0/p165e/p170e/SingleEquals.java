package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.s */
/* loaded from: classes.dex */
public final class SingleEquals<T> extends Single<Boolean> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7553a;

    /* renamed from: b */
    public final SingleSource<? extends T> f7554b;

    /* compiled from: SingleEquals.java */
    /* renamed from: d.c.f0.e.e.s$a */
    /* loaded from: classes.dex */
    public class C1692a implements SingleObserver<T> {

        /* renamed from: a */
        public final int f7555a;

        /* renamed from: b */
        public final /* synthetic */ CompositeDisposable f7556b;

        /* renamed from: c */
        public final /* synthetic */ Object[] f7557c;

        /* renamed from: d */
        public final /* synthetic */ AtomicInteger f7558d;

        /* renamed from: e */
        public final /* synthetic */ SingleObserver f7559e;

        public C1692a(SingleEquals singleEquals, int i, CompositeDisposable compositeDisposable, Object[] objArr, AtomicInteger atomicInteger, SingleObserver singleObserver) {
            this.f7556b = compositeDisposable;
            this.f7557c = objArr;
            this.f7558d = atomicInteger;
            this.f7559e = singleObserver;
            this.f7555a = i;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7556b.mo3633c(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7557c[this.f7555a] = t;
            if (this.f7558d.incrementAndGet() == 2) {
                SingleObserver singleObserver = this.f7559e;
                Object[] objArr = this.f7557c;
                singleObserver.mo3282b(Boolean.valueOf(ObjectHelper.m3599a(objArr[0], objArr[1])));
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            int i;
            do {
                i = this.f7558d.get();
                if (i >= 2) {
                    RxJavaPlugins.m3371b(th);
                    return;
                }
            } while (!this.f7558d.compareAndSet(i, 2));
            this.f7556b.mo578b();
            this.f7559e.mo3283a(th);
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.f7553a = singleSource;
        this.f7554b = singleSource2;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.mo3284a(compositeDisposable);
        this.f7553a.subscribe(new C1692a(this, 0, compositeDisposable, objArr, atomicInteger, singleObserver));
        this.f7554b.subscribe(new C1692a(this, 1, compositeDisposable, objArr, atomicInteger, singleObserver));
    }
}
