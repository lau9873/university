package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableCache.java */
/* loaded from: classes.dex */
public final class b extends d.c.b implements d.c.d {

    /* renamed from: e  reason: collision with root package name */
    public static final a[] f4631e = new a[0];

    /* renamed from: f  reason: collision with root package name */
    public static final a[] f4632f = new a[0];

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4633a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<a[]> f4634b = new AtomicReference<>(f4631e);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f4635c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public Throwable f4636d;

    /* compiled from: CompletableCache.java */
    /* loaded from: classes.dex */
    public final class a extends AtomicBoolean implements d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4637a;

        public a(d.c.d dVar) {
            this.f4637a = dVar;
        }

        @Override // d.c.c0.b
        public void b() {
            if (compareAndSet(false, true)) {
                b.this.b(this);
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get();
        }
    }

    public b(d.c.g gVar) {
        this.f4633a = gVar;
    }

    @Override // d.c.d
    public void a(d.c.c0.b bVar) {
    }

    @Override // d.c.d
    public void a(Throwable th) {
        a[] andSet;
        this.f4636d = th;
        for (a aVar : this.f4634b.getAndSet(f4632f)) {
            if (!aVar.get()) {
                aVar.f4637a.a(th);
            }
        }
    }

    public void b(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f4634b.get();
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
                aVarArr2 = f4631e;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f4634b.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar);
        dVar.a(aVar);
        if (a(aVar)) {
            if (aVar.c()) {
                b(aVar);
            }
            if (this.f4635c.compareAndSet(false, true)) {
                this.f4633a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f4636d;
        if (th != null) {
            dVar.a(th);
        } else {
            dVar.a();
        }
    }

    @Override // d.c.d
    public void a() {
        a[] andSet;
        for (a aVar : this.f4634b.getAndSet(f4632f)) {
            if (!aVar.get()) {
                aVar.f4637a.a();
            }
        }
    }

    public boolean a(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f4634b.get();
            if (aVarArr == f4632f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f4634b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }
}
