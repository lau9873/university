package p220i;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import p220i.CallAdapter;

/* renamed from: i.g */
/* loaded from: classes.dex */
public final class ExecutorCallAdapterFactory extends CallAdapter.AbstractC2601a {

    /* renamed from: a */
    public final Executor f10382a;

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* renamed from: i.g$a */
    /* loaded from: classes.dex */
    public class C2605a implements CallAdapter<Object, InterfaceC2600b<?>> {

        /* renamed from: a */
        public final /* synthetic */ Type f10383a;

        public C2605a(Type type) {
            this.f10383a = type;
        }

        @Override // p220i.CallAdapter
        /* renamed from: a */
        public Type mo568a() {
            return this.f10383a;
        }

        @Override // p220i.CallAdapter
        /* renamed from: a */
        public InterfaceC2600b<?> mo567a(InterfaceC2600b<Object> interfaceC2600b) {
            return new C2606b(ExecutorCallAdapterFactory.this.f10382a, interfaceC2600b);
        }
    }

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* renamed from: i.g$b */
    /* loaded from: classes.dex */
    public static final class C2606b<T> implements InterfaceC2600b<T> {

        /* renamed from: a */
        public final Executor f10385a;

        /* renamed from: b */
        public final InterfaceC2600b<T> f10386b;

        /* compiled from: ExecutorCallAdapterFactory.java */
        /* renamed from: i.g$b$a */
        /* loaded from: classes.dex */
        public class C2607a implements InterfaceC2602d<T> {

            /* renamed from: a */
            public final /* synthetic */ InterfaceC2602d f10387a;

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: i.g$b$a$a */
            /* loaded from: classes.dex */
            public class RunnableC2608a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ C2632l f10389a;

                public RunnableC2608a(C2632l c2632l) {
                    this.f10389a = c2632l;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (C2606b.this.f10386b.mo679k()) {
                        C2607a c2607a = C2607a.this;
                        c2607a.f10387a.mo579a(C2606b.this, new IOException("Canceled"));
                        return;
                    }
                    C2607a c2607a2 = C2607a.this;
                    c2607a2.f10387a.mo580a(C2606b.this, this.f10389a);
                }
            }

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: i.g$b$a$b */
            /* loaded from: classes.dex */
            public class RunnableC2609b implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ Throwable f10391a;

                public RunnableC2609b(Throwable th) {
                    this.f10391a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C2607a c2607a = C2607a.this;
                    c2607a.f10387a.mo579a(C2606b.this, this.f10391a);
                }
            }

            public C2607a(InterfaceC2602d interfaceC2602d) {
                this.f10387a = interfaceC2602d;
            }

            @Override // p220i.InterfaceC2602d
            /* renamed from: a */
            public void mo580a(InterfaceC2600b<T> interfaceC2600b, C2632l<T> c2632l) {
                C2606b.this.f10385a.execute(new RunnableC2608a(c2632l));
            }

            @Override // p220i.InterfaceC2602d
            /* renamed from: a */
            public void mo579a(InterfaceC2600b<T> interfaceC2600b, Throwable th) {
                C2606b.this.f10385a.execute(new RunnableC2609b(th));
            }
        }

        public C2606b(Executor executor, InterfaceC2600b<T> interfaceC2600b) {
            this.f10385a = executor;
            this.f10386b = interfaceC2600b;
        }

        @Override // p220i.InterfaceC2600b
        /* renamed from: a */
        public void mo681a(InterfaceC2602d<T> interfaceC2602d) {
            C2636o.m595a(interfaceC2602d, "callback == null");
            this.f10386b.mo681a(new C2607a(interfaceC2602d));
        }

        @Override // p220i.InterfaceC2600b
        public void cancel() {
            this.f10386b.cancel();
        }

        @Override // p220i.InterfaceC2600b
        /* renamed from: j */
        public C2632l<T> mo680j() {
            return this.f10386b.mo680j();
        }

        @Override // p220i.InterfaceC2600b
        /* renamed from: k */
        public boolean mo679k() {
            return this.f10386b.mo679k();
        }

        @Override // p220i.InterfaceC2600b
        public InterfaceC2600b<T> clone() {
            return new C2606b(this.f10385a, this.f10386b.clone());
        }
    }

    public ExecutorCallAdapterFactory(Executor executor) {
        this.f10382a = executor;
    }

    @Override // p220i.CallAdapter.AbstractC2601a
    /* renamed from: a */
    public CallAdapter<?, ?> mo565a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.AbstractC2601a.m685a(type) != InterfaceC2600b.class) {
            return null;
        }
        return new C2605a(C2636o.m586b(type));
    }
}
