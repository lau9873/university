package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: CompletableAmb.java */
/* loaded from: classes.dex */
public final class a extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g[] f4625a;

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends d.c.g> f4626b;

    public a(d.c.g[] gVarArr, Iterable<? extends d.c.g> iterable) {
        this.f4625a = gVarArr;
        this.f4626b = iterable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        int length;
        d.c.g[] gVarArr = this.f4625a;
        if (gVarArr == null) {
            gVarArr = new d.c.g[8];
            try {
                length = 0;
                for (d.c.g gVar : this.f4626b) {
                    if (gVar == null) {
                        d.c.f0.a.c.a(new NullPointerException("One of the sources is null"), dVar);
                        return;
                    }
                    if (length == gVarArr.length) {
                        d.c.g[] gVarArr2 = new d.c.g[(length >> 2) + length];
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                        gVarArr = gVarArr2;
                    }
                    int i2 = length + 1;
                    gVarArr[length] = gVar;
                    length = i2;
                }
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.f0.a.c.a(th, dVar);
                return;
            }
        } else {
            length = gVarArr.length;
        }
        d.c.c0.a aVar = new d.c.c0.a();
        dVar.a(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        C0096a c0096a = new C0096a(this, atomicBoolean, aVar, dVar);
        for (int i3 = 0; i3 < length; i3++) {
            d.c.g gVar2 = gVarArr[i3];
            if (aVar.c()) {
                return;
            }
            if (gVar2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    aVar.b();
                    dVar.a(nullPointerException);
                    return;
                }
                d.c.h0.a.b(nullPointerException);
                return;
            }
            gVar2.subscribe(c0096a);
        }
        if (length == 0) {
            dVar.a();
        }
    }

    /* compiled from: CompletableAmb.java */
    /* renamed from: d.c.f0.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0096a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f4627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f4628b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.c.d f4629c;

        public C0096a(a aVar, AtomicBoolean atomicBoolean, d.c.c0.a aVar2, d.c.d dVar) {
            this.f4627a = atomicBoolean;
            this.f4628b = aVar2;
            this.f4629c = dVar;
        }

        @Override // d.c.d
        public void a() {
            if (this.f4627a.compareAndSet(false, true)) {
                this.f4628b.b();
                this.f4629c.a();
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            if (this.f4627a.compareAndSet(false, true)) {
                this.f4628b.b();
                this.f4629c.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4628b.c(bVar);
        }
    }
}
