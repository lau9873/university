package p220i;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Call;
import p181e.Headers;
import p181e.HttpUrl;
import p181e.MediaType;
import p181e.MultipartBody;
import p181e.RequestBody;
import p181e.ResponseBody;
import p220i.ParameterHandler;
import p220i.p225r.Body;
import p220i.p225r.DELETE;
import p220i.p225r.Field;
import p220i.p225r.FieldMap;
import p220i.p225r.GET;
import p220i.p225r.HEAD;
import p220i.p225r.HTTP;
import p220i.p225r.InterfaceC2644h;
import p220i.p225r.InterfaceC2645i;
import p220i.p225r.Multipart;
import p220i.p225r.OPTIONS;
import p220i.p225r.PATCH;
import p220i.p225r.POST;
import p220i.p225r.PUT;
import p220i.p225r.Part;
import p220i.p225r.PartMap;
import p220i.p225r.Path;
import p220i.p225r.Query;
import p220i.p225r.QueryMap;
import p220i.p225r.QueryName;

/* renamed from: i.n */
/* loaded from: classes.dex */
public final class ServiceMethod<R, T> {

    /* renamed from: m */
    public static final Pattern f10464m = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: n */
    public static final Pattern f10465n = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: a */
    public final Call.InterfaceC1746a f10466a;

    /* renamed from: b */
    public final CallAdapter<R, T> f10467b;

    /* renamed from: c */
    public final HttpUrl f10468c;

    /* renamed from: d */
    public final Converter<ResponseBody, R> f10469d;

    /* renamed from: e */
    public final String f10470e;

    /* renamed from: f */
    public final String f10471f;

    /* renamed from: g */
    public final Headers f10472g;

    /* renamed from: h */
    public final MediaType f10473h;

    /* renamed from: i */
    public final boolean f10474i;

    /* renamed from: j */
    public final boolean f10475j;

    /* renamed from: k */
    public final boolean f10476k;

    /* renamed from: l */
    public final ParameterHandler<?>[] f10477l;

    public ServiceMethod(C2635a<R, T> c2635a) {
        this.f10466a = c2635a.f10478a.m628b();
        this.f10467b = c2635a.f10500w;
        this.f10468c = c2635a.f10478a.m636a();
        this.f10469d = c2635a.f10499v;
        this.f10470e = c2635a.f10490m;
        this.f10471f = c2635a.f10494q;
        this.f10472g = c2635a.f10495r;
        this.f10473h = c2635a.f10496s;
        this.f10474i = c2635a.f10491n;
        this.f10475j = c2635a.f10492o;
        this.f10476k = c2635a.f10493p;
        this.f10477l = c2635a.f10498u;
    }

    /* renamed from: a */
    public C1737b0 m614a(Object... objArr) {
        RequestBuilder requestBuilder = new RequestBuilder(this.f10470e, this.f10468c, this.f10471f, this.f10472g, this.f10473h, this.f10474i, this.f10475j, this.f10476k);
        ParameterHandler<?>[] parameterHandlerArr = this.f10477l;
        int length = objArr != null ? objArr.length : 0;
        if (length == parameterHandlerArr.length) {
            for (int i = 0; i < length; i++) {
                parameterHandlerArr[i].mo662a(requestBuilder, objArr[i]);
            }
            return requestBuilder.m655a();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
    }

    /* renamed from: a */
    public R m617a(ResponseBody responseBody) {
        return this.f10469d.mo560a(responseBody);
    }

    /* renamed from: a */
    public static Set<String> m615a(String str) {
        Matcher matcher = f10464m.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public static Class<?> m616a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* compiled from: ServiceMethod.java */
    /* renamed from: i.n$a */
    /* loaded from: classes.dex */
    public static final class C2635a<T, R> {

        /* renamed from: a */
        public final Retrofit f10478a;

        /* renamed from: b */
        public final Method f10479b;

        /* renamed from: c */
        public final Annotation[] f10480c;

        /* renamed from: d */
        public final Annotation[][] f10481d;

        /* renamed from: e */
        public final Type[] f10482e;

        /* renamed from: f */
        public Type f10483f;

        /* renamed from: g */
        public boolean f10484g;

        /* renamed from: h */
        public boolean f10485h;

        /* renamed from: i */
        public boolean f10486i;

        /* renamed from: j */
        public boolean f10487j;

        /* renamed from: k */
        public boolean f10488k;

        /* renamed from: l */
        public boolean f10489l;

        /* renamed from: m */
        public String f10490m;

        /* renamed from: n */
        public boolean f10491n;

        /* renamed from: o */
        public boolean f10492o;

        /* renamed from: p */
        public boolean f10493p;

        /* renamed from: q */
        public String f10494q;

        /* renamed from: r */
        public Headers f10495r;

        /* renamed from: s */
        public MediaType f10496s;

        /* renamed from: t */
        public Set<String> f10497t;

        /* renamed from: u */
        public ParameterHandler<?>[] f10498u;

        /* renamed from: v */
        public Converter<ResponseBody, T> f10499v;

        /* renamed from: w */
        public CallAdapter<T, R> f10500w;

        public C2635a(Retrofit retrofit, Method method) {
            this.f10478a = retrofit;
            this.f10479b = method;
            this.f10480c = method.getAnnotations();
            this.f10482e = method.getGenericParameterTypes();
            this.f10481d = method.getParameterAnnotations();
        }

        /* renamed from: a */
        public ServiceMethod m613a() {
            this.f10500w = m602b();
            this.f10483f = this.f10500w.mo568a();
            Type type = this.f10483f;
            if (type != C2632l.class && type != C1744d0.class) {
                this.f10499v = m601c();
                for (Annotation annotation : this.f10480c) {
                    m604a(annotation);
                }
                if (this.f10490m != null) {
                    if (!this.f10491n) {
                        if (!this.f10493p) {
                            if (this.f10492o) {
                                throw m607a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            }
                        } else {
                            throw m607a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    }
                    int length = this.f10481d.length;
                    this.f10498u = new ParameterHandler[length];
                    for (int i = 0; i < length; i++) {
                        Type type2 = this.f10482e[i];
                        if (!C2636o.m583d(type2)) {
                            Annotation[] annotationArr = this.f10481d[i];
                            if (annotationArr != null) {
                                this.f10498u[i] = m610a(i, type2, annotationArr);
                            } else {
                                throw m611a(i, "No Retrofit annotation found.", new Object[0]);
                            }
                        } else {
                            throw m611a(i, "Parameter type must not include a type variable or wildcard: %s", type2);
                        }
                    }
                    if (this.f10494q != null || this.f10489l) {
                        if (!this.f10492o && !this.f10493p && !this.f10491n && this.f10486i) {
                            throw m607a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                        }
                        if (this.f10492o && !this.f10484g) {
                            throw m607a("Form-encoded method must contain at least one @Field.", new Object[0]);
                        }
                        if (this.f10493p && !this.f10485h) {
                            throw m607a("Multipart method must contain at least one @Part.", new Object[0]);
                        }
                        return new ServiceMethod(this);
                    }
                    throw m607a("Missing either @%s URL or @Url parameter.", this.f10490m);
                }
                throw m607a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            throw m607a("'" + C2636o.m584c(this.f10483f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }

        /* renamed from: b */
        public final CallAdapter<T, R> m602b() {
            Type genericReturnType = this.f10479b.getGenericReturnType();
            if (!C2636o.m583d(genericReturnType)) {
                if (genericReturnType != Void.TYPE) {
                    try {
                        return (CallAdapter<T, R>) this.f10478a.m630a(genericReturnType, this.f10479b.getAnnotations());
                    } catch (RuntimeException e) {
                        throw m605a(e, "Unable to create call adapter for %s", genericReturnType);
                    }
                }
                throw m607a("Service methods cannot return void.", new Object[0]);
            }
            throw m607a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }

        /* renamed from: c */
        public final Converter<ResponseBody, T> m601c() {
            try {
                return this.f10478a.m626b(this.f10483f, this.f10479b.getAnnotations());
            } catch (RuntimeException e) {
                throw m605a(e, "Unable to create converter for %s", this.f10483f);
            }
        }

        /* renamed from: a */
        public final void m604a(Annotation annotation) {
            if (annotation instanceof DELETE) {
                m608a("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                m608a("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                m608a("HEAD", ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.f10483f)) {
                    throw m607a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                m608a("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                m608a("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                m608a("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                m608a("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                m608a(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof InterfaceC2645i) {
                String[] value = ((InterfaceC2645i) annotation).value();
                if (value.length != 0) {
                    this.f10495r = m603a(value);
                    return;
                }
                throw m607a("@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof Multipart) {
                if (!this.f10492o) {
                    this.f10493p = true;
                    return;
                }
                throw m607a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        /* renamed from: a */
        public final void m608a(String str, String str2, boolean z) {
            String str3 = this.f10490m;
            if (str3 == null) {
                this.f10490m = str;
                this.f10491n = z;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (ServiceMethod.f10464m.matcher(substring).find()) {
                        throw m607a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.f10494q = str2;
                this.f10497t = ServiceMethod.m615a(str2);
                return;
            }
            throw m607a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        /* renamed from: a */
        public final Headers m603a(String[] strArr) {
            Headers.C1809a c1809a = new Headers.C1809a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        MediaType m2692a = MediaType.m2692a(trim);
                        if (m2692a != null) {
                            this.f10496s = m2692a;
                        } else {
                            throw m607a("Malformed content type: %s", trim);
                        }
                    } else {
                        c1809a.m2757a(substring, trim);
                    }
                } else {
                    throw m607a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return c1809a.m2759a();
        }

        /* renamed from: a */
        public final ParameterHandler<?> m610a(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation annotation : annotationArr) {
                ParameterHandler<?> m609a = m609a(i, type, annotationArr, annotation);
                if (m609a != null) {
                    if (parameterHandler != null) {
                        throw m611a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    parameterHandler = m609a;
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw m611a(i, "No Retrofit annotation found.", new Object[0]);
        }

        /* renamed from: a */
        public final ParameterHandler<?> m609a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Path) {
                if (!this.f10488k) {
                    if (!this.f10489l) {
                        if (this.f10494q != null) {
                            this.f10487j = true;
                            Path path = (Path) annotation;
                            String value = path.value();
                            m612a(i, value);
                            return new ParameterHandler.C2622i(value, this.f10478a.m625c(type, annotationArr), path.encoded());
                        }
                        throw m611a(i, "@Path can only be used with relative url on @%s", this.f10490m);
                    }
                    throw m611a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw m611a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (annotation instanceof Query) {
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> m584c = C2636o.m584c(type);
                this.f10488k = true;
                if (Iterable.class.isAssignableFrom(m584c)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.C2623j(value2, this.f10478a.m625c(C2636o.m600a(0, (ParameterizedType) type), annotationArr), encoded).m668b();
                    }
                    throw m611a(i, m584c.getSimpleName() + " must include generic type (e.g., " + m584c.getSimpleName() + "<String>)", new Object[0]);
                } else if (m584c.isArray()) {
                    return new ParameterHandler.C2623j(value2, this.f10478a.m625c(ServiceMethod.m616a(m584c.getComponentType()), annotationArr), encoded).m669a();
                } else {
                    return new ParameterHandler.C2623j(value2, this.f10478a.m625c(type, annotationArr), encoded);
                }
            } else if (annotation instanceof QueryName) {
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> m584c2 = C2636o.m584c(type);
                this.f10488k = true;
                if (Iterable.class.isAssignableFrom(m584c2)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.C2625l(this.f10478a.m625c(C2636o.m600a(0, (ParameterizedType) type), annotationArr), encoded2).m668b();
                    }
                    throw m611a(i, m584c2.getSimpleName() + " must include generic type (e.g., " + m584c2.getSimpleName() + "<String>)", new Object[0]);
                } else if (m584c2.isArray()) {
                    return new ParameterHandler.C2625l(this.f10478a.m625c(ServiceMethod.m616a(m584c2.getComponentType()), annotationArr), encoded2).m669a();
                } else {
                    return new ParameterHandler.C2625l(this.f10478a.m625c(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof QueryMap) {
                Class<?> m584c3 = C2636o.m584c(type);
                if (Map.class.isAssignableFrom(m584c3)) {
                    Type m585b = C2636o.m585b(type, m584c3, Map.class);
                    if (m585b instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) m585b;
                        Type m600a = C2636o.m600a(0, parameterizedType);
                        if (String.class == m600a) {
                            return new ParameterHandler.C2624k(this.f10478a.m625c(C2636o.m600a(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                        }
                        throw m611a(i, "@QueryMap keys must be of type String: " + m600a, new Object[0]);
                    }
                    throw m611a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw m611a(i, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof InterfaceC2644h) {
                String value3 = ((InterfaceC2644h) annotation).value();
                Class<?> m584c4 = C2636o.m584c(type);
                if (Iterable.class.isAssignableFrom(m584c4)) {
                    if (type instanceof ParameterizedType) {
                        return new ParameterHandler.C2619f(value3, this.f10478a.m625c(C2636o.m600a(0, (ParameterizedType) type), annotationArr)).m668b();
                    }
                    throw m611a(i, m584c4.getSimpleName() + " must include generic type (e.g., " + m584c4.getSimpleName() + "<String>)", new Object[0]);
                } else if (m584c4.isArray()) {
                    return new ParameterHandler.C2619f(value3, this.f10478a.m625c(ServiceMethod.m616a(m584c4.getComponentType()), annotationArr)).m669a();
                } else {
                    return new ParameterHandler.C2619f(value3, this.f10478a.m625c(type, annotationArr));
                }
            } else if (annotation instanceof Field) {
                if (this.f10492o) {
                    Field field = (Field) annotation;
                    String value4 = field.value();
                    boolean encoded3 = field.encoded();
                    this.f10484g = true;
                    Class<?> m584c5 = C2636o.m584c(type);
                    if (Iterable.class.isAssignableFrom(m584c5)) {
                        if (type instanceof ParameterizedType) {
                            return new ParameterHandler.C2617d(value4, this.f10478a.m625c(C2636o.m600a(0, (ParameterizedType) type), annotationArr), encoded3).m668b();
                        }
                        throw m611a(i, m584c5.getSimpleName() + " must include generic type (e.g., " + m584c5.getSimpleName() + "<String>)", new Object[0]);
                    } else if (m584c5.isArray()) {
                        return new ParameterHandler.C2617d(value4, this.f10478a.m625c(ServiceMethod.m616a(m584c5.getComponentType()), annotationArr), encoded3).m669a();
                    } else {
                        return new ParameterHandler.C2617d(value4, this.f10478a.m625c(type, annotationArr), encoded3);
                    }
                }
                throw m611a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof FieldMap) {
                if (this.f10492o) {
                    Class<?> m584c6 = C2636o.m584c(type);
                    if (Map.class.isAssignableFrom(m584c6)) {
                        Type m585b2 = C2636o.m585b(type, m584c6, Map.class);
                        if (m585b2 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType2 = (ParameterizedType) m585b2;
                            Type m600a2 = C2636o.m600a(0, parameterizedType2);
                            if (String.class == m600a2) {
                                Converter<T, String> m625c = this.f10478a.m625c(C2636o.m600a(1, parameterizedType2), annotationArr);
                                this.f10484g = true;
                                return new ParameterHandler.C2618e(m625c, ((FieldMap) annotation).encoded());
                            }
                            throw m611a(i, "@FieldMap keys must be of type String: " + m600a2, new Object[0]);
                        }
                        throw m611a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m611a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw m611a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof Part) {
                if (this.f10493p) {
                    Part part = (Part) annotation;
                    this.f10485h = true;
                    String value5 = part.value();
                    Class<?> m584c7 = C2636o.m584c(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(m584c7)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.C1814b.class.isAssignableFrom(C2636o.m584c(C2636o.m600a(0, (ParameterizedType) type)))) {
                                    return ParameterHandler.C2626m.f10430a.m668b();
                                }
                                throw m611a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw m611a(i, m584c7.getSimpleName() + " must include generic type (e.g., " + m584c7.getSimpleName() + "<String>)", new Object[0]);
                        } else if (m584c7.isArray()) {
                            if (MultipartBody.C1814b.class.isAssignableFrom(m584c7.getComponentType())) {
                                return ParameterHandler.C2626m.f10430a.m669a();
                            }
                            throw m611a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else if (MultipartBody.C1814b.class.isAssignableFrom(m584c7)) {
                            return ParameterHandler.C2626m.f10430a;
                        } else {
                            throw m611a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    }
                    Headers m2764a = Headers.m2764a("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
                    if (Iterable.class.isAssignableFrom(m584c7)) {
                        if (type instanceof ParameterizedType) {
                            Type m600a3 = C2636o.m600a(0, (ParameterizedType) type);
                            if (!MultipartBody.C1814b.class.isAssignableFrom(C2636o.m584c(m600a3))) {
                                return new ParameterHandler.C2620g(m2764a, this.f10478a.m629a(m600a3, annotationArr, this.f10480c)).m668b();
                            }
                            throw m611a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw m611a(i, m584c7.getSimpleName() + " must include generic type (e.g., " + m584c7.getSimpleName() + "<String>)", new Object[0]);
                    } else if (m584c7.isArray()) {
                        Class<?> m616a = ServiceMethod.m616a(m584c7.getComponentType());
                        if (!MultipartBody.C1814b.class.isAssignableFrom(m616a)) {
                            return new ParameterHandler.C2620g(m2764a, this.f10478a.m629a(m616a, annotationArr, this.f10480c)).m669a();
                        }
                        throw m611a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!MultipartBody.C1814b.class.isAssignableFrom(m584c7)) {
                        return new ParameterHandler.C2620g(m2764a, this.f10478a.m629a(type, annotationArr, this.f10480c));
                    } else {
                        throw m611a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                }
                throw m611a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof PartMap) {
                if (this.f10493p) {
                    this.f10485h = true;
                    Class<?> m584c8 = C2636o.m584c(type);
                    if (Map.class.isAssignableFrom(m584c8)) {
                        Type m585b3 = C2636o.m585b(type, m584c8, Map.class);
                        if (m585b3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) m585b3;
                            Type m600a4 = C2636o.m600a(0, parameterizedType3);
                            if (String.class == m600a4) {
                                Type m600a5 = C2636o.m600a(1, parameterizedType3);
                                if (!MultipartBody.C1814b.class.isAssignableFrom(C2636o.m584c(m600a5))) {
                                    return new ParameterHandler.C2621h(this.f10478a.m629a(m600a5, annotationArr, this.f10480c), ((PartMap) annotation).encoding());
                                }
                                throw m611a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw m611a(i, "@PartMap keys must be of type String: " + m600a4, new Object[0]);
                        }
                        throw m611a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw m611a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw m611a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof Body) {
                if (!this.f10492o && !this.f10493p) {
                    if (!this.f10486i) {
                        try {
                            Converter<T, RequestBody> m629a = this.f10478a.m629a(type, annotationArr, this.f10480c);
                            this.f10486i = true;
                            return new ParameterHandler.C2616c(m629a);
                        } catch (RuntimeException e) {
                            throw m606a(e, i, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw m611a(i, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw m611a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else {
                return null;
            }
        }

        /* renamed from: a */
        public final void m612a(int i, String str) {
            if (ServiceMethod.f10465n.matcher(str).matches()) {
                if (!this.f10497t.contains(str)) {
                    throw m611a(i, "URL \"%s\" does not contain \"{%s}\".", this.f10494q, str);
                }
                return;
            }
            throw m611a(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.f10464m.pattern(), str);
        }

        /* renamed from: a */
        public final RuntimeException m607a(String str, Object... objArr) {
            return m605a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        public final RuntimeException m605a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            return new IllegalArgumentException(format + "\n    for method " + this.f10479b.getDeclaringClass().getSimpleName() + "." + this.f10479b.getName(), th);
        }

        /* renamed from: a */
        public final RuntimeException m606a(Throwable th, int i, String str, Object... objArr) {
            return m605a(th, str + " (parameter #" + (i + 1) + ")", objArr);
        }

        /* renamed from: a */
        public final RuntimeException m611a(int i, String str, Object... objArr) {
            return m607a(str + " (parameter #" + (i + 1) + ")", objArr);
        }
    }
}
