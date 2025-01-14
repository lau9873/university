package d.c.f0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableConcatArray.java */
/* loaded from: classes.dex */
public final class b<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<? extends T>[] f4803b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4804c;

    /* compiled from: FlowableConcatArray.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends d.c.f0.i.f implements d.c.k<T> {

        /* renamed from: h  reason: collision with root package name */
        public final g.b.c<? super T> f4805h;

        /* renamed from: i  reason: collision with root package name */
        public final g.b.b<? extends T>[] f4806i;
        public final boolean j;
        public final AtomicInteger k = new AtomicInteger();
        public int m;
        public List<Throwable> n;
        public long o;

        public a(g.b.b<? extends T>[] bVarArr, boolean z, g.b.c<? super T> cVar) {
            this.f4805h = cVar;
            this.f4806i = bVarArr;
            this.j = z;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            b(dVar);
        }

        @Override // g.b.c
        public void a(T t) {
            this.o++;
            this.f4805h.a((g.b.c<? super T>) t);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.j) {
                List list = this.n;
                if (list == null) {
                    list = new ArrayList((this.f4806i.length - this.m) + 1);
                    this.n = list;
                }
                list.add(th);
                a();
                return;
            }
            this.f4805h.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.k.getAndIncrement() == 0) {
                g.b.b<? extends T>[] bVarArr = this.f4806i;
                int length = bVarArr.length;
                int i2 = this.m;
                while (i2 != length) {
                    g.b.b<? extends T> bVar = bVarArr[i2];
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.j) {
                            List list = this.n;
                            if (list == null) {
                                list = new ArrayList((length - i2) + 1);
                                this.n = list;
                            }
                            list.add(nullPointerException);
                            i2++;
                        } else {
                            this.f4805h.a((Throwable) nullPointerException);
                            return;
                        }
                    } else {
                        long j = this.o;
                        if (j != 0) {
                            this.o = 0L;
                            b(j);
                        }
                        bVar.a(this);
                        i2++;
                        this.m = i2;
                        if (this.k.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.n;
                if (list2 != null) {
                    if (list2.size() == 1) {
                        this.f4805h.a(list2.get(0));
                        return;
                    } else {
                        this.f4805h.a((Throwable) new CompositeException(list2));
                        return;
                    }
                }
                this.f4805h.a();
            }
        }
    }

    public b(g.b.b<? extends T>[] bVarArr, boolean z) {
        this.f4803b = bVarArr;
        this.f4804c = z;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        a aVar = new a(this.f4803b, this.f4804c, cVar);
        cVar.a((g.b.d) aVar);
        aVar.a();
    }
}
