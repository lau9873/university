package i.p.a;

import d.c.o;
import d.c.s;
import i.l;
import io.reactivex.exceptions.CompositeException;
import retrofit2.adapter.rxjava2.HttpException;
/* compiled from: BodyObservable.java */
/* loaded from: classes.dex */
public final class a<T> extends o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final o<l<T>> f7533a;

    /* compiled from: BodyObservable.java */
    /* renamed from: i.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0174a<R> implements s<l<R>> {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super R> f7534a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7535b;

        public C0174a(s<? super R> sVar) {
            this.f7534a = sVar;
        }

        @Override // d.c.s
        public /* bridge */ /* synthetic */ void a(Object obj) {
            a((l) ((l) obj));
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f7534a.a(bVar);
        }

        public void a(l<R> lVar) {
            if (lVar.c()) {
                this.f7534a.a((s<? super R>) lVar.a());
                return;
            }
            this.f7535b = true;
            HttpException httpException = new HttpException(lVar);
            try {
                this.f7534a.a((Throwable) httpException);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.h0.a.b(new CompositeException(httpException, th));
            }
        }

        @Override // d.c.s
        public void a() {
            if (this.f7535b) {
                return;
            }
            this.f7534a.a();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (!this.f7535b) {
                this.f7534a.a(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            d.c.h0.a.b(assertionError);
        }
    }

    public a(o<l<T>> oVar) {
        this.f7533a = oVar;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        this.f7533a.a(new C0174a(sVar));
    }
}
