package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleCache.java */
/* loaded from: classes.dex */
public final class b<T> extends d.c.u<T> implements d.c.w<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final a[] f5062f = new a[0];

    /* renamed from: g  reason: collision with root package name */
    public static final a[] f5063g = new a[0];

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5064a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f5065b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<a<T>[]> f5066c = new AtomicReference<>(f5062f);

    /* renamed from: d  reason: collision with root package name */
    public T f5067d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f5068e;

    /* compiled from: SingleCache.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicBoolean implements d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5069a;

        /* renamed from: b  reason: collision with root package name */
        public final b<T> f5070b;

        public a(d.c.w<? super T> wVar, b<T> bVar) {
            this.f5069a = wVar;
            this.f5070b = bVar;
        }

        @Override // d.c.c0.b
        public void b() {
            if (compareAndSet(false, true)) {
                this.f5070b.b((a) this);
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get();
        }
    }

    public b(d.c.z<? extends T> zVar) {
        this.f5064a = zVar;
    }

    @Override // d.c.w
    public void a(d.c.c0.b bVar) {
    }

    public boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f5066c.get();
            if (aVarArr == f5063g) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f5066c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f5066c.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f5062f;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f5066c.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        a<T> aVar = new a<>(wVar, this);
        wVar.a(aVar);
        if (a((a) aVar)) {
            if (aVar.c()) {
                b((a) aVar);
            }
            if (this.f5065b.getAndIncrement() == 0) {
                this.f5064a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f5068e;
        if (th != null) {
            wVar.a(th);
        } else {
            wVar.b((T) this.f5067d);
        }
    }

    @Override // d.c.w
    public void a(Throwable th) {
        a<T>[] andSet;
        this.f5068e = th;
        for (a<T> aVar : this.f5066c.getAndSet(f5063g)) {
            if (!aVar.c()) {
                aVar.f5069a.a(th);
            }
        }
    }

    @Override // d.c.w
    public void b(T t) {
        a<T>[] andSet;
        this.f5067d = t;
        for (a<T> aVar : this.f5066c.getAndSet(f5063g)) {
            if (!aVar.c()) {
                aVar.f5069a.b(t);
            }
        }
    }
}
