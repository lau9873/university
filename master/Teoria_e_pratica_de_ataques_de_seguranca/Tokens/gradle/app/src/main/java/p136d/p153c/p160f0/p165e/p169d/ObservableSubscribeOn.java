package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.d.p */
/* loaded from: classes.dex */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: b */
    public final Scheduler f7378b;

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: d.c.f0.e.d.p$a */
    /* loaded from: classes.dex */
    public class RunnableC1651a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C1652b f7379a;

        public RunnableC1651a(C1652b c1652b) {
            this.f7379a = c1652b;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f7279a.mo3294a(this.f7379a);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: d.c.f0.e.d.p$b */
    /* loaded from: classes.dex */
    public static final class C1652b<T> extends AtomicReference<Disposable> implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7381a;

        /* renamed from: b */
        public final AtomicReference<Disposable> f7382b = new AtomicReference<>();

        public C1652b(InterfaceC1730s<? super T> interfaceC1730s) {
            this.f7381a = interfaceC1730s;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            DisposableHelper.m3644c(this.f7382b, disposable);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a(this.f7382b);
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            this.f7381a.mo570a((InterfaceC1730s<? super T>) t);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            this.f7381a.mo569a(th);
        }

        /* renamed from: b */
        public void m3512b(Disposable disposable) {
            DisposableHelper.m3644c(this, disposable);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7381a.mo573a();
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f7378b = scheduler;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        C1652b c1652b = new C1652b(interfaceC1730s);
        interfaceC1730s.mo572a((Disposable) c1652b);
        c1652b.m3512b(this.f7378b.mo3292a(new RunnableC1651a(c1652b)));
    }
}
