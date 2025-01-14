package i;

import i.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
/* compiled from: ExecutorCallAdapterFactory.java */
/* loaded from: classes.dex */
public final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f7428a;

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* loaded from: classes.dex */
    public class a implements c<Object, i.b<?>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Type f7429a;

        public a(Type type) {
            this.f7429a = type;
        }

        @Override // i.c
        public Type a() {
            return this.f7429a;
        }

        @Override // i.c
        /* renamed from: a */
        public i.b<?> a2(i.b<Object> bVar) {
            return new b(g.this.f7428a, bVar);
        }
    }

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements i.b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Executor f7431a;

        /* renamed from: b  reason: collision with root package name */
        public final i.b<T> f7432b;

        /* compiled from: ExecutorCallAdapterFactory.java */
        /* loaded from: classes.dex */
        public class a implements d<T> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f7433a;

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: i.g$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0170a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l f7435a;

                public RunnableC0170a(l lVar) {
                    this.f7435a = lVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f7432b.k()) {
                        a aVar = a.this;
                        aVar.f7433a.a(b.this, new IOException("Canceled"));
                        return;
                    }
                    a aVar2 = a.this;
                    aVar2.f7433a.a(b.this, this.f7435a);
                }
            }

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: i.g$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0171b implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Throwable f7437a;

                public RunnableC0171b(Throwable th) {
                    this.f7437a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f7433a.a(b.this, this.f7437a);
                }
            }

            public a(d dVar) {
                this.f7433a = dVar;
            }

            @Override // i.d
            public void a(i.b<T> bVar, l<T> lVar) {
                b.this.f7431a.execute(new RunnableC0170a(lVar));
            }

            @Override // i.d
            public void a(i.b<T> bVar, Throwable th) {
                b.this.f7431a.execute(new RunnableC0171b(th));
            }
        }

        public b(Executor executor, i.b<T> bVar) {
            this.f7431a = executor;
            this.f7432b = bVar;
        }

        @Override // i.b
        public void a(d<T> dVar) {
            o.a(dVar, "callback == null");
            this.f7432b.a(new a(dVar));
        }

        @Override // i.b
        public void cancel() {
            this.f7432b.cancel();
        }

        @Override // i.b
        public l<T> j() {
            return this.f7432b.j();
        }

        @Override // i.b
        public boolean k() {
            return this.f7432b.k();
        }

        @Override // i.b
        public i.b<T> clone() {
            return new b(this.f7431a, this.f7432b.clone());
        }
    }

    public g(Executor executor) {
        this.f7428a = executor;
    }

    @Override // i.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (c.a.a(type) != i.b.class) {
            return null;
        }
        return new a(o.b(type));
    }
}
