package d.c.f0.e.e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleResumeNext.java */
/* loaded from: classes.dex */
public final class k0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5143a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super Throwable, ? extends d.c.z<? extends T>> f5144b;

    /* compiled from: SingleResumeNext.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5145a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super Throwable, ? extends d.c.z<? extends T>> f5146b;

        public a(d.c.w<? super T> wVar, d.c.e0.n<? super Throwable, ? extends d.c.z<? extends T>> nVar) {
            this.f5145a = wVar;
            this.f5146b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar)) {
                this.f5145a.a(this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5145a.b(t);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            try {
                ((d.c.z) d.c.f0.b.b.a(this.f5146b.a(th), "The nextFunction returned a null SingleSource.")).subscribe(new d.c.f0.d.j(this, this.f5145a));
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.f5145a.a(new CompositeException(th, th2));
            }
        }
    }

    public k0(d.c.z<? extends T> zVar, d.c.e0.n<? super Throwable, ? extends d.c.z<? extends T>> nVar) {
        this.f5143a = zVar;
        this.f5144b = nVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5143a.subscribe(new a(wVar, this.f5144b));
    }
}
