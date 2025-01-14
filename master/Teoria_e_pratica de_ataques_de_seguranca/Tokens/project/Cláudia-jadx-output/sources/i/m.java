package i;

import e.c0;
import e.e;
import e.e0;
import e.u;
import e.y;
import i.a;
import i.c;
import i.e;
import i.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
/* compiled from: Retrofit.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Method, n<?, ?>> f7492a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final e.a f7493b;

    /* renamed from: c  reason: collision with root package name */
    public final u f7494c;

    /* renamed from: d  reason: collision with root package name */
    public final List<e.a> f7495d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a> f7496e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f7497f;

    /* compiled from: Retrofit.java */
    /* loaded from: classes.dex */
    public class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public final j f7498a = j.c();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f7499b;

        public a(Class cls) {
            this.f7499b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f7498a.a(method)) {
                return this.f7498a.a(method, this.f7499b, obj, objArr);
            }
            n<?, ?> a2 = m.this.a(method);
            return a2.f7509b.a(new h(a2, objArr));
        }
    }

    /* compiled from: Retrofit.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final j f7501a;

        /* renamed from: b  reason: collision with root package name */
        public e.a f7502b;

        /* renamed from: c  reason: collision with root package name */
        public u f7503c;

        /* renamed from: d  reason: collision with root package name */
        public final List<e.a> f7504d;

        /* renamed from: e  reason: collision with root package name */
        public final List<c.a> f7505e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f7506f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7507g;

        public b(j jVar) {
            this.f7504d = new ArrayList();
            this.f7505e = new ArrayList();
            this.f7501a = jVar;
            this.f7504d.add(new i.a());
        }

        public b a(y yVar) {
            o.a(yVar, "client == null");
            a((e.a) yVar);
            return this;
        }

        public b a(e.a aVar) {
            o.a(aVar, "factory == null");
            this.f7502b = aVar;
            return this;
        }

        public b a(String str) {
            o.a(str, "baseUrl == null");
            u d2 = u.d(str);
            if (d2 != null) {
                a(d2);
                return this;
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public b() {
            this(j.c());
        }

        public b a(u uVar) {
            o.a(uVar, "baseUrl == null");
            List<String> j = uVar.j();
            if ("".equals(j.get(j.size() - 1))) {
                this.f7503c = uVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + uVar);
        }

        public b a(e.a aVar) {
            List<e.a> list = this.f7504d;
            o.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f7505e;
            o.a(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public m a() {
            if (this.f7503c != null) {
                e.a aVar = this.f7502b;
                if (aVar == null) {
                    aVar = new y();
                }
                e.a aVar2 = aVar;
                Executor executor = this.f7506f;
                if (executor == null) {
                    executor = this.f7501a.a();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f7505e);
                arrayList.add(this.f7501a.a(executor2));
                return new m(aVar2, this.f7503c, new ArrayList(this.f7504d), arrayList, executor2, this.f7507g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    public m(e.a aVar, u uVar, List<e.a> list, List<c.a> list2, Executor executor, boolean z) {
        this.f7493b = aVar;
        this.f7494c = uVar;
        this.f7495d = Collections.unmodifiableList(list);
        this.f7496e = Collections.unmodifiableList(list2);
        this.f7497f = z;
    }

    public <T> T a(Class<T> cls) {
        o.a((Class) cls);
        if (this.f7497f) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public final void b(Class<?> cls) {
        Method[] declaredMethods;
        j c2 = j.c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!c2.a(method)) {
                a(method);
            }
        }
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int size = this.f7495d.size();
        for (int i2 = 0; i2 < size; i2++) {
            e<T, String> eVar = (e<T, String>) this.f7495d.get(i2).b(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return a.d.f7424a;
    }

    public n<?, ?> a(Method method) {
        n nVar;
        n<?, ?> nVar2 = this.f7492a.get(method);
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (this.f7492a) {
            nVar = this.f7492a.get(method);
            if (nVar == null) {
                nVar = new n.a(this, method).a();
                this.f7492a.put(method, nVar);
            }
        }
        return nVar;
    }

    public e.a b() {
        return this.f7493b;
    }

    public <T> e<e0, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    public u a() {
        return this.f7494c;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(c.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "returnType == null");
        o.a(annotationArr, "annotations == null");
        int indexOf = this.f7496e.indexOf(aVar) + 1;
        int size = this.f7496e.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            c<?, ?> a2 = this.f7496e.get(i2).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f7496e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7496e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7496e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, c0> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> e<T, c0> a(e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        o.a(type, "type == null");
        o.a(annotationArr, "parameterAnnotations == null");
        o.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f7495d.indexOf(aVar) + 1;
        int size = this.f7495d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<T, c0> eVar = (e<T, c0>) this.f7495d.get(i2).a(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f7495d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7495d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7495d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<e0, T> a(e.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int indexOf = this.f7495d.indexOf(aVar) + 1;
        int size = this.f7495d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<e0, T> eVar = (e<e0, T>) this.f7495d.get(i2).a(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f7495d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f7495d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f7495d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
