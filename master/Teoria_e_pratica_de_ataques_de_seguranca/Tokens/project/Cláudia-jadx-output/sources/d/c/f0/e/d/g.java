package d.c.f0.e.d;

import d.c.s;
/* compiled from: ObservableFromArray.java */
/* loaded from: classes.dex */
public final class g<T> extends d.c.o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T[] f5013a;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends d.c.f0.d.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super T> f5014a;

        /* renamed from: b  reason: collision with root package name */
        public final T[] f5015b;

        /* renamed from: c  reason: collision with root package name */
        public int f5016c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5017d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5018e;

        public a(s<? super T> sVar, T[] tArr) {
            this.f5014a = sVar;
            this.f5015b = tArr;
        }

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 1) != 0) {
                this.f5017d = true;
                return 1;
            }
            return 0;
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5018e = true;
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5018e;
        }

        @Override // d.c.f0.c.n
        public void clear() {
            this.f5016c = this.f5015b.length;
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return this.f5016c == this.f5015b.length;
        }

        @Override // d.c.f0.c.n
        public T poll() {
            int i2 = this.f5016c;
            T[] tArr = this.f5015b;
            if (i2 != tArr.length) {
                this.f5016c = i2 + 1;
                T t = tArr[i2];
                d.c.f0.b.b.a((Object) t, "The array element is null");
                return t;
            }
            return null;
        }

        public void a() {
            T[] tArr = this.f5015b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !c(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    s<? super T> sVar = this.f5014a;
                    sVar.a((Throwable) new NullPointerException("The " + i2 + "th element is null"));
                    return;
                }
                this.f5014a.a((s<? super T>) t);
            }
            if (c()) {
                return;
            }
            this.f5014a.a();
        }
    }

    public g(T[] tArr) {
        this.f5013a = tArr;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        a aVar = new a(sVar, this.f5013a);
        sVar.a((d.c.c0.b) aVar);
        if (aVar.f5017d) {
            return;
        }
        aVar.a();
    }
}
