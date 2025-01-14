package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableConcatArray.java */
/* loaded from: classes.dex */
public final class d extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g[] f4656a;

    /* compiled from: CompletableConcatArray.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4657a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.g[] f4658b;

        /* renamed from: c  reason: collision with root package name */
        public int f4659c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.f0.a.e f4660d = new d.c.f0.a.e();

        public a(d.c.d dVar, d.c.g[] gVarArr) {
            this.f4657a = dVar;
            this.f4658b = gVarArr;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4660d.b(bVar);
        }

        public void b() {
            if (!this.f4660d.c() && getAndIncrement() == 0) {
                d.c.g[] gVarArr = this.f4658b;
                while (!this.f4660d.c()) {
                    int i2 = this.f4659c;
                    this.f4659c = i2 + 1;
                    if (i2 == gVarArr.length) {
                        this.f4657a.a();
                        return;
                    }
                    gVarArr[i2].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4657a.a(th);
        }

        @Override // d.c.d
        public void a() {
            b();
        }
    }

    public d(d.c.g[] gVarArr) {
        this.f4656a = gVarArr;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar, this.f4656a);
        dVar.a(aVar.f4660d);
        aVar.b();
    }
}
