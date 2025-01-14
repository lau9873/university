package i.p.a;

import d.c.o;
import d.c.s;
import i.l;
import io.reactivex.exceptions.CompositeException;
/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes.dex */
public final class b<T> extends o<l<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final i.b<T> f7536a;

    public b(i.b<T> bVar) {
        this.f7536a = bVar;
    }

    @Override // d.c.o
    public void b(s<? super l<T>> sVar) {
        i.b<T> clone = this.f7536a.clone();
        a aVar = new a(clone, sVar);
        sVar.a((d.c.c0.b) aVar);
        clone.a(aVar);
    }

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.c0.b, i.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public final i.b<?> f7537a;

        /* renamed from: b  reason: collision with root package name */
        public final s<? super l<T>> f7538b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7539c = false;

        public a(i.b<?> bVar, s<? super l<T>> sVar) {
            this.f7537a = bVar;
            this.f7538b = sVar;
        }

        @Override // i.d
        public void a(i.b<T> bVar, l<T> lVar) {
            if (bVar.k()) {
                return;
            }
            try {
                this.f7538b.a((s<? super l<T>>) lVar);
                if (bVar.k()) {
                    return;
                }
                this.f7539c = true;
                this.f7538b.a();
            } catch (Throwable th) {
                if (this.f7539c) {
                    d.c.h0.a.b(th);
                } else if (bVar.k()) {
                } else {
                    try {
                        this.f7538b.a(th);
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        d.c.h0.a.b(new CompositeException(th, th2));
                    }
                }
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f7537a.cancel();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f7537a.k();
        }

        @Override // i.d
        public void a(i.b<T> bVar, Throwable th) {
            if (bVar.k()) {
                return;
            }
            try {
                this.f7538b.a(th);
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                d.c.h0.a.b(new CompositeException(th, th2));
            }
        }
    }
}
