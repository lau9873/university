package i.p.a;

import d.c.o;
import d.c.s;
import i.l;
import io.reactivex.exceptions.CompositeException;
/* compiled from: ResultObservable.java */
/* loaded from: classes.dex */
public final class e<T> extends o<d<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final o<l<T>> f7542a;

    /* compiled from: ResultObservable.java */
    /* loaded from: classes.dex */
    public static class a<R> implements s<l<R>> {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super d<R>> f7543a;

        public a(s<? super d<R>> sVar) {
            this.f7543a = sVar;
        }

        @Override // d.c.s
        public /* bridge */ /* synthetic */ void a(Object obj) {
            a((l) ((l) obj));
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f7543a.a(bVar);
        }

        public void a(l<R> lVar) {
            this.f7543a.a((s<? super d<R>>) d.a(lVar));
        }

        @Override // d.c.s
        public void a(Throwable th) {
            try {
                this.f7543a.a((s<? super d<R>>) d.a(th));
                this.f7543a.a();
            } catch (Throwable th2) {
                try {
                    this.f7543a.a(th2);
                } catch (Throwable th3) {
                    d.c.d0.a.b(th3);
                    d.c.h0.a.b(new CompositeException(th2, th3));
                }
            }
        }

        @Override // d.c.s
        public void a() {
            this.f7543a.a();
        }
    }

    public e(o<l<T>> oVar) {
        this.f7542a = oVar;
    }

    @Override // d.c.o
    public void b(s<? super d<T>> sVar) {
        this.f7542a.a(new a(sVar));
    }
}
