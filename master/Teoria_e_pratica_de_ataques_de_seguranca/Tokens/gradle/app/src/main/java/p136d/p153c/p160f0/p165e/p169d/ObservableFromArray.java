package p136d.p153c.p160f0.p165e.p169d;

import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p164d.BasicQueueDisposable;

/* renamed from: d.c.f0.e.d.g */
/* loaded from: classes.dex */
public final class ObservableFromArray<T> extends Observable<T> {

    /* renamed from: a */
    public final T[] f7348a;

    /* compiled from: ObservableFromArray.java */
    /* renamed from: d.c.f0.e.d.g$a */
    /* loaded from: classes.dex */
    public static final class C1644a<T> extends BasicQueueDisposable<T> {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7349a;

        /* renamed from: b */
        public final T[] f7350b;

        /* renamed from: c */
        public int f7351c;

        /* renamed from: d */
        public boolean f7352d;

        /* renamed from: e */
        public volatile boolean f7353e;

        public C1644a(InterfaceC1730s<? super T> interfaceC1730s, T[] tArr) {
            this.f7349a = interfaceC1730s;
            this.f7350b = tArr;
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 1) != 0) {
                this.f7352d = true;
                return 1;
            }
            return 0;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7353e = true;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7353e;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            this.f7351c = this.f7350b.length;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return this.f7351c == this.f7350b.length;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public T poll() {
            int i = this.f7351c;
            T[] tArr = this.f7350b;
            if (i != tArr.length) {
                this.f7351c = i + 1;
                T t = tArr[i];
                ObjectHelper.m3598a((Object) t, "The array element is null");
                return t;
            }
            return null;
        }

        /* renamed from: a */
        public void m3517a() {
            T[] tArr = this.f7350b;
            int length = tArr.length;
            for (int i = 0; i < length && !mo577c(); i++) {
                T t = tArr[i];
                if (t == null) {
                    InterfaceC1730s<? super T> interfaceC1730s = this.f7349a;
                    interfaceC1730s.mo569a((Throwable) new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.f7349a.mo570a((InterfaceC1730s<? super T>) t);
            }
            if (mo577c()) {
                return;
            }
            this.f7349a.mo573a();
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f7348a = tArr;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super T> interfaceC1730s) {
        C1644a c1644a = new C1644a(interfaceC1730s, this.f7348a);
        interfaceC1730s.mo572a((Disposable) c1644a);
        if (c1644a.f7352d) {
            return;
        }
        c1644a.m3517a();
    }
}
