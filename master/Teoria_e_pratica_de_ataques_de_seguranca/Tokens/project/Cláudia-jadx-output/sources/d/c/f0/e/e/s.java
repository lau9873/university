package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: SingleEquals.java */
/* loaded from: classes.dex */
public final class s<T> extends d.c.u<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5218a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.z<? extends T> f5219b;

    /* compiled from: SingleEquals.java */
    /* loaded from: classes.dex */
    public class a implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f5220a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.c0.a f5221b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object[] f5222c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f5223d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.c.w f5224e;

        public a(s sVar, int i2, d.c.c0.a aVar, Object[] objArr, AtomicInteger atomicInteger, d.c.w wVar) {
            this.f5221b = aVar;
            this.f5222c = objArr;
            this.f5223d = atomicInteger;
            this.f5224e = wVar;
            this.f5220a = i2;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5221b.c(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5222c[this.f5220a] = t;
            if (this.f5223d.incrementAndGet() == 2) {
                d.c.w wVar = this.f5224e;
                Object[] objArr = this.f5222c;
                wVar.b(Boolean.valueOf(d.c.f0.b.b.a(objArr[0], objArr[1])));
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            int i2;
            do {
                i2 = this.f5223d.get();
                if (i2 >= 2) {
                    d.c.h0.a.b(th);
                    return;
                }
            } while (!this.f5223d.compareAndSet(i2, 2));
            this.f5221b.b();
            this.f5224e.a(th);
        }
    }

    public s(d.c.z<? extends T> zVar, d.c.z<? extends T> zVar2) {
        this.f5218a = zVar;
        this.f5219b = zVar2;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super Boolean> wVar) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        d.c.c0.a aVar = new d.c.c0.a();
        wVar.a(aVar);
        this.f5218a.subscribe(new a(this, 0, aVar, objArr, atomicInteger, wVar));
        this.f5219b.subscribe(new a(this, 1, aVar, objArr, atomicInteger, wVar));
    }
}
