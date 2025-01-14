package d.c.f0.e.d;

import d.c.s;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCreate.java */
/* loaded from: classes.dex */
public final class c<T> extends d.c.o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.q<T> f4985a;

    public c(d.c.q<T> qVar) {
        this.f4985a = qVar;
    }

    @Override // d.c.o
    public void b(s<? super T> sVar) {
        a aVar = new a(sVar);
        sVar.a((d.c.c0.b) aVar);
        try {
            this.f4985a.a(aVar);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            aVar.a(th);
        }
    }

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.p<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super T> f4986a;

        public a(s<? super T> sVar) {
            this.f4986a = sVar;
        }

        public void a(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!c()) {
                try {
                    this.f4986a.a(th);
                    return;
                } finally {
                    b();
                }
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.i
        public void a() {
            if (c()) {
                return;
            }
            try {
                this.f4986a.a();
            } finally {
                b();
            }
        }
    }
}
