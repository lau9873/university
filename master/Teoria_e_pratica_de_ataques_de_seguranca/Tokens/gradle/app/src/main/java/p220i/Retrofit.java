package p220i;

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
import p181e.Call;
import p181e.HttpUrl;
import p181e.OkHttpClient;
import p181e.RequestBody;
import p181e.ResponseBody;
import p220i.BuiltInConverters;
import p220i.CallAdapter;
import p220i.Converter;
import p220i.ServiceMethod;

/* renamed from: i.m */
/* loaded from: classes.dex */
public final class Retrofit {

    /* renamed from: a */
    public final Map<Method, ServiceMethod<?, ?>> f10448a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Call.InterfaceC1746a f10449b;

    /* renamed from: c */
    public final HttpUrl f10450c;

    /* renamed from: d */
    public final List<Converter.AbstractC2603a> f10451d;

    /* renamed from: e */
    public final List<CallAdapter.AbstractC2601a> f10452e;

    /* renamed from: f */
    public final boolean f10453f;

    /* compiled from: Retrofit.java */
    /* renamed from: i.m$a */
    /* loaded from: classes.dex */
    public class C2633a implements InvocationHandler {

        /* renamed from: a */
        public final C2627j f10454a = C2627j.m660c();

        /* renamed from: b */
        public final /* synthetic */ Class f10455b;

        public C2633a(Class cls) {
            this.f10455b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.f10454a.mo657a(method)) {
                return this.f10454a.mo656a(method, this.f10455b, obj, objArr);
            }
            ServiceMethod<?, ?> m631a = Retrofit.this.m631a(method);
            return m631a.f10467b.mo567a(new OkHttpCall(m631a, objArr));
        }
    }

    /* compiled from: Retrofit.java */
    /* renamed from: i.m$b */
    /* loaded from: classes.dex */
    public static final class C2634b {

        /* renamed from: a */
        public final C2627j f10457a;

        /* renamed from: b */
        public Call.InterfaceC1746a f10458b;

        /* renamed from: c */
        public HttpUrl f10459c;

        /* renamed from: d */
        public final List<Converter.AbstractC2603a> f10460d;

        /* renamed from: e */
        public final List<CallAdapter.AbstractC2601a> f10461e;

        /* renamed from: f */
        public Executor f10462f;

        /* renamed from: g */
        public boolean f10463g;

        public C2634b(C2627j c2627j) {
            this.f10460d = new ArrayList();
            this.f10461e = new ArrayList();
            this.f10457a = c2627j;
            this.f10460d.add(new BuiltInConverters());
        }

        /* renamed from: a */
        public C2634b m621a(OkHttpClient okHttpClient) {
            C2636o.m595a(okHttpClient, "client == null");
            m623a((Call.InterfaceC1746a) okHttpClient);
            return this;
        }

        /* renamed from: a */
        public C2634b m623a(Call.InterfaceC1746a interfaceC1746a) {
            C2636o.m595a(interfaceC1746a, "factory == null");
            this.f10458b = interfaceC1746a;
            return this;
        }

        /* renamed from: a */
        public C2634b m618a(String str) {
            C2636o.m595a(str, "baseUrl == null");
            HttpUrl m2734d = HttpUrl.m2734d(str);
            if (m2734d != null) {
                m622a(m2734d);
                return this;
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public C2634b() {
            this(C2627j.m660c());
        }

        /* renamed from: a */
        public C2634b m622a(HttpUrl httpUrl) {
            C2636o.m595a(httpUrl, "baseUrl == null");
            List<String> m2727j = httpUrl.m2727j();
            if ("".equals(m2727j.get(m2727j.size() - 1))) {
                this.f10459c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        /* renamed from: a */
        public C2634b m619a(Converter.AbstractC2603a abstractC2603a) {
            List<Converter.AbstractC2603a> list = this.f10460d;
            C2636o.m595a(abstractC2603a, "factory == null");
            list.add(abstractC2603a);
            return this;
        }

        /* renamed from: a */
        public C2634b m620a(CallAdapter.AbstractC2601a abstractC2601a) {
            List<CallAdapter.AbstractC2601a> list = this.f10461e;
            C2636o.m595a(abstractC2601a, "factory == null");
            list.add(abstractC2601a);
            return this;
        }

        /* renamed from: a */
        public Retrofit m624a() {
            if (this.f10459c != null) {
                Call.InterfaceC1746a interfaceC1746a = this.f10458b;
                if (interfaceC1746a == null) {
                    interfaceC1746a = new OkHttpClient();
                }
                Call.InterfaceC1746a interfaceC1746a2 = interfaceC1746a;
                Executor executor = this.f10462f;
                if (executor == null) {
                    executor = this.f10457a.mo659a();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f10461e);
                arrayList.add(this.f10457a.mo658a(executor2));
                return new Retrofit(interfaceC1746a2, this.f10459c, new ArrayList(this.f10460d), arrayList, executor2, this.f10463g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }

    public Retrofit(Call.InterfaceC1746a interfaceC1746a, HttpUrl httpUrl, List<Converter.AbstractC2603a> list, List<CallAdapter.AbstractC2601a> list2, Executor executor, boolean z) {
        this.f10449b = interfaceC1746a;
        this.f10450c = httpUrl;
        this.f10451d = Collections.unmodifiableList(list);
        this.f10452e = Collections.unmodifiableList(list2);
        this.f10453f = z;
    }

    /* renamed from: a */
    public <T> T m632a(Class<T> cls) {
        C2636o.m598a((Class) cls);
        if (this.f10453f) {
            m627b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C2633a(cls));
    }

    /* renamed from: b */
    public final void m627b(Class<?> cls) {
        Method[] declaredMethods;
        C2627j m660c = C2627j.m660c();
        for (Method method : cls.getDeclaredMethods()) {
            if (!m660c.mo657a(method)) {
                m631a(method);
            }
        }
    }

    /* renamed from: c */
    public <T> Converter<T, String> m625c(Type type, Annotation[] annotationArr) {
        C2636o.m595a(type, "type == null");
        C2636o.m595a(annotationArr, "annotations == null");
        int size = this.f10451d.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> converter = (Converter<T, String>) this.f10451d.get(i).m684b(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.C2598d.f10378a;
    }

    /* renamed from: a */
    public ServiceMethod<?, ?> m631a(Method method) {
        ServiceMethod serviceMethod;
        ServiceMethod<?, ?> serviceMethod2 = this.f10448a.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.f10448a) {
            serviceMethod = this.f10448a.get(method);
            if (serviceMethod == null) {
                serviceMethod = new ServiceMethod.C2635a(this, method).m613a();
                this.f10448a.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    /* renamed from: b */
    public Call.InterfaceC1746a m628b() {
        return this.f10449b;
    }

    /* renamed from: b */
    public <T> Converter<ResponseBody, T> m626b(Type type, Annotation[] annotationArr) {
        return m634a((Converter.AbstractC2603a) null, type, annotationArr);
    }

    /* renamed from: a */
    public HttpUrl m636a() {
        return this.f10450c;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> m630a(Type type, Annotation[] annotationArr) {
        return m635a((CallAdapter.AbstractC2601a) null, type, annotationArr);
    }

    /* renamed from: a */
    public CallAdapter<?, ?> m635a(CallAdapter.AbstractC2601a abstractC2601a, Type type, Annotation[] annotationArr) {
        C2636o.m595a(type, "returnType == null");
        C2636o.m595a(annotationArr, "annotations == null");
        int indexOf = this.f10452e.indexOf(abstractC2601a) + 1;
        int size = this.f10452e.size();
        for (int i = indexOf; i < size; i++) {
            CallAdapter<?, ?> mo565a = this.f10452e.get(i).mo565a(type, annotationArr, this);
            if (mo565a != null) {
                return mo565a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC2601a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f10452e.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f10452e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f10452e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> Converter<T, RequestBody> m629a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return m633a(null, type, annotationArr, annotationArr2);
    }

    /* renamed from: a */
    public <T> Converter<T, RequestBody> m633a(Converter.AbstractC2603a abstractC2603a, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        C2636o.m595a(type, "type == null");
        C2636o.m595a(annotationArr, "parameterAnnotations == null");
        C2636o.m595a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f10451d.indexOf(abstractC2603a) + 1;
        int size = this.f10451d.size();
        for (int i = indexOf; i < size; i++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.f10451d.get(i).mo562a(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC2603a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f10451d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f10451d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f10451d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public <T> Converter<ResponseBody, T> m634a(Converter.AbstractC2603a abstractC2603a, Type type, Annotation[] annotationArr) {
        C2636o.m595a(type, "type == null");
        C2636o.m595a(annotationArr, "annotations == null");
        int indexOf = this.f10451d.indexOf(abstractC2603a) + 1;
        int size = this.f10451d.size();
        for (int i = indexOf; i < size; i++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.f10451d.get(i).mo563a(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (abstractC2603a != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f10451d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f10451d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f10451d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }
}
