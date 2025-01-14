package d.c.f0.e.d;

import d.c.r;
import d.c.s;
import d.c.u;
import d.c.w;
import java.util.NoSuchElementException;
/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes.dex */
public final class o<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final r<? extends T> f5036a;

    /* renamed from: b  reason: collision with root package name */
    public final T f5037b;

    public o(r<? extends T> rVar, T t) {
        this.f5036a = rVar;
        this.f5037b = t;
    }

    @Override // d.c.u
    public void subscribeActual(w<? super T> wVar) {
        this.f5036a.a(new a(wVar, this.f5037b));
    }

    /* compiled from: ObservableSingleSingle.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final w<? super T> f5038a;

        /* renamed from: b  reason: collision with root package name */
        public final T f5039b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5040c;

        /* renamed from: d  reason: collision with root package name */
        public T f5041d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5042e;

        public a(w<? super T> wVar, T t) {
            this.f5038a = wVar;
            this.f5039b = t;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5040c, bVar)) {
                this.f5040c = bVar;
                this.f5038a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5040c.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5040c.c();
        }

        @Override // d.c.s
        public void a(T t) {
            if (this.f5042e) {
                return;
            }
            if (this.f5041d != null) {
                this.f5042e = true;
                this.f5040c.b();
                this.f5038a.a(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f5041d = t;
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f5042e) {
                d.c.h0.a.b(th);
                return;
            }
            this.f5042e = true;
            this.f5038a.a(th);
        }

        @Override // d.c.s
        public void a() {
            if (this.f5042e) {
                return;
            }
            this.f5042e = true;
            T t = this.f5041d;
            this.f5041d = null;
            if (t == null) {
                t = this.f5039b;
            }
            if (t != null) {
                this.f5038a.b(t);
            } else {
                this.f5038a.a(new NoSuchElementException());
            }
        }
    }
}
