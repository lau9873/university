package i.p.a;

import d.c.o;
import d.c.s;
import i.l;
import io.reactivex.exceptions.CompositeException;
/* compiled from: CallExecuteObservable.java */
/* loaded from: classes.dex */
public final class c<T> extends o<l<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final i.b<T> f7540a;

    /* compiled from: CallExecuteObservable.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final i.b<?> f7541a;

        public a(i.b<?> bVar) {
            this.f7541a = bVar;
        }

        @Override // d.c.c0.b
        public void b() {
            this.f7541a.cancel();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f7541a.k();
        }
    }

    public c(i.b<T> bVar) {
        this.f7540a = bVar;
    }

    @Override // d.c.o
    public void b(s<? super l<T>> sVar) {
        boolean z;
        i.b<T> clone = this.f7540a.clone();
        sVar.a((d.c.c0.b) new a(clone));
        try {
            l<T> j = clone.j();
            if (!clone.k()) {
                sVar.a((s<? super l<T>>) j);
            }
            if (clone.k()) {
                return;
            }
            try {
                sVar.a();
            } catch (Throwable th) {
                th = th;
                z = true;
                d.c.d0.a.b(th);
                if (z) {
                    d.c.h0.a.b(th);
                } else if (clone.k()) {
                } else {
                    try {
                        sVar.a(th);
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        d.c.h0.a.b(new CompositeException(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
