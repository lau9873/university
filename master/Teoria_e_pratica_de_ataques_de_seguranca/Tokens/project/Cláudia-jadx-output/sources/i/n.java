package i;

import e.b0;
import e.c0;
import e.d0;
import e.e;
import e.e0;
import e.t;
import e.u;
import e.w;
import e.x;
import i.i;
import i.r.p;
import i.r.q;
import i.r.r;
import i.r.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: ServiceMethod.java */
/* loaded from: classes.dex */
public final class n<R, T> {
    public static final Pattern m = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    public static final Pattern n = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: a  reason: collision with root package name */
    public final e.a f7508a;

    /* renamed from: b  reason: collision with root package name */
    public final c<R, T> f7509b;

    /* renamed from: c  reason: collision with root package name */
    public final u f7510c;

    /* renamed from: d  reason: collision with root package name */
    public final e<e0, R> f7511d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7512e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7513f;

    /* renamed from: g  reason: collision with root package name */
    public final t f7514g;

    /* renamed from: h  reason: collision with root package name */
    public final w f7515h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7516i;
    public final boolean j;
    public final boolean k;
    public final i<?>[] l;

    public n(a<R, T> aVar) {
        this.f7508a = aVar.f7517a.b();
        this.f7509b = aVar.w;
        this.f7510c = aVar.f7517a.a();
        this.f7511d = aVar.v;
        this.f7512e = aVar.m;
        this.f7513f = aVar.q;
        this.f7514g = aVar.r;
        this.f7515h = aVar.s;
        this.f7516i = aVar.n;
        this.j = aVar.o;
        this.k = aVar.p;
        this.l = aVar.u;
    }

    public b0 a(Object... objArr) {
        k kVar = new k(this.f7512e, this.f7510c, this.f7513f, this.f7514g, this.f7515h, this.f7516i, this.j, this.k);
        i<?>[] iVarArr = this.l;
        int length = objArr != null ? objArr.length : 0;
        if (length == iVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                iVarArr[i2].a(kVar, objArr[i2]);
            }
            return kVar.a();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + iVarArr.length + ")");
    }

    public R a(e0 e0Var) {
        return this.f7511d.a(e0Var);
    }

    public static Set<String> a(String str) {
        Matcher matcher = m.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    public static Class<?> a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    /* compiled from: ServiceMethod.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final m f7517a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f7518b;

        /* renamed from: c  reason: collision with root package name */
        public final Annotation[] f7519c;

        /* renamed from: d  reason: collision with root package name */
        public final Annotation[][] f7520d;

        /* renamed from: e  reason: collision with root package name */
        public final Type[] f7521e;

        /* renamed from: f  reason: collision with root package name */
        public Type f7522f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7523g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f7524h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f7525i;
        public boolean j;
        public boolean k;
        public boolean l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public String q;
        public t r;
        public w s;
        public Set<String> t;
        public i<?>[] u;
        public e<e0, T> v;
        public c<T, R> w;

        public a(m mVar, Method method) {
            this.f7517a = mVar;
            this.f7518b = method;
            this.f7519c = method.getAnnotations();
            this.f7521e = method.getGenericParameterTypes();
            this.f7520d = method.getParameterAnnotations();
        }

        public n a() {
            this.w = b();
            this.f7522f = this.w.a();
            Type type = this.f7522f;
            if (type != l.class && type != d0.class) {
                this.v = c();
                for (Annotation annotation : this.f7519c) {
                    a(annotation);
                }
                if (this.m != null) {
                    if (!this.n) {
                        if (!this.p) {
                            if (this.o) {
                                throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                            }
                        } else {
                            throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    }
                    int length = this.f7520d.length;
                    this.u = new i[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        Type type2 = this.f7521e[i2];
                        if (!o.d(type2)) {
                            Annotation[] annotationArr = this.f7520d[i2];
                            if (annotationArr != null) {
                                this.u[i2] = a(i2, type2, annotationArr);
                            } else {
                                throw a(i2, "No Retrofit annotation found.", new Object[0]);
                            }
                        } else {
                            throw a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                        }
                    }
                    if (this.q != null || this.l) {
                        if (!this.o && !this.p && !this.n && this.f7525i) {
                            throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                        }
                        if (this.o && !this.f7523g) {
                            throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
                        }
                        if (this.p && !this.f7524h) {
                            throw a("Multipart method must contain at least one @Part.", new Object[0]);
                        }
                        return new n(this);
                    }
                    throw a("Missing either @%s URL or @Url parameter.", this.m);
                }
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            throw a("'" + o.c(this.f7522f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }

        public final c<T, R> b() {
            Type genericReturnType = this.f7518b.getGenericReturnType();
            if (!o.d(genericReturnType)) {
                if (genericReturnType != Void.TYPE) {
                    try {
                        return (c<T, R>) this.f7517a.a(genericReturnType, this.f7518b.getAnnotations());
                    } catch (RuntimeException e2) {
                        throw a(e2, "Unable to create call adapter for %s", genericReturnType);
                    }
                }
                throw a("Service methods cannot return void.", new Object[0]);
            }
            throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }

        public final e<e0, T> c() {
            try {
                return this.f7517a.b(this.f7522f, this.f7518b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a(e2, "Unable to create converter for %s", this.f7522f);
            }
        }

        public final void a(Annotation annotation) {
            if (annotation instanceof i.r.b) {
                a("DELETE", ((i.r.b) annotation).value(), false);
            } else if (annotation instanceof i.r.e) {
                a("GET", ((i.r.e) annotation).value(), false);
            } else if (annotation instanceof i.r.f) {
                a("HEAD", ((i.r.f) annotation).value(), false);
                if (!Void.class.equals(this.f7522f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof i.r.l) {
                a("PATCH", ((i.r.l) annotation).value(), true);
            } else if (annotation instanceof i.r.m) {
                a("POST", ((i.r.m) annotation).value(), true);
            } else if (annotation instanceof i.r.n) {
                a("PUT", ((i.r.n) annotation).value(), true);
            } else if (annotation instanceof i.r.k) {
                a("OPTIONS", ((i.r.k) annotation).value(), false);
            } else if (annotation instanceof i.r.g) {
                i.r.g gVar = (i.r.g) annotation;
                a(gVar.method(), gVar.path(), gVar.hasBody());
            } else if (annotation instanceof i.r.i) {
                String[] value = ((i.r.i) annotation).value();
                if (value.length != 0) {
                    this.r = a(value);
                    return;
                }
                throw a("@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof i.r.j) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        public final void a(String str, String str2, boolean z) {
            String str3 = this.m;
            if (str3 == null) {
                this.m = str;
                this.n = z;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (n.m.matcher(substring).find()) {
                        throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.q = str2;
                this.t = n.a(str2);
                return;
            }
            throw a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        public final t a(String[] strArr) {
            t.a aVar = new t.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        w a2 = w.a(trim);
                        if (a2 != null) {
                            this.s = a2;
                        } else {
                            throw a("Malformed content type: %s", trim);
                        }
                    } else {
                        aVar.a(substring, trim);
                    }
                } else {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return aVar.a();
        }

        public final i<?> a(int i2, Type type, Annotation[] annotationArr) {
            i<?> iVar = null;
            for (Annotation annotation : annotationArr) {
                i<?> a2 = a(i2, type, annotationArr, annotation);
                if (a2 != null) {
                    if (iVar != null) {
                        throw a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    iVar = a2;
                }
            }
            if (iVar != null) {
                return iVar;
            }
            throw a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        public final i<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof q) {
                if (!this.k) {
                    if (!this.l) {
                        if (this.q != null) {
                            this.j = true;
                            q qVar = (q) annotation;
                            String value = qVar.value();
                            a(i2, value);
                            return new i.C0172i(value, this.f7517a.c(type, annotationArr), qVar.encoded());
                        }
                        throw a(i2, "@Path can only be used with relative url on @%s", this.m);
                    }
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (annotation instanceof r) {
                r rVar = (r) annotation;
                String value2 = rVar.value();
                boolean encoded = rVar.encoded();
                Class<?> c2 = o.c(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(c2)) {
                    if (type instanceof ParameterizedType) {
                        return new i.j(value2, this.f7517a.c(o.a(0, (ParameterizedType) type), annotationArr), encoded).b();
                    }
                    throw a(i2, c2.getSimpleName() + " must include generic type (e.g., " + c2.getSimpleName() + "<String>)", new Object[0]);
                } else if (c2.isArray()) {
                    return new i.j(value2, this.f7517a.c(n.a(c2.getComponentType()), annotationArr), encoded).a();
                } else {
                    return new i.j(value2, this.f7517a.c(type, annotationArr), encoded);
                }
            } else if (annotation instanceof i.r.t) {
                boolean encoded2 = ((i.r.t) annotation).encoded();
                Class<?> c3 = o.c(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(c3)) {
                    if (type instanceof ParameterizedType) {
                        return new i.l(this.f7517a.c(o.a(0, (ParameterizedType) type), annotationArr), encoded2).b();
                    }
                    throw a(i2, c3.getSimpleName() + " must include generic type (e.g., " + c3.getSimpleName() + "<String>)", new Object[0]);
                } else if (c3.isArray()) {
                    return new i.l(this.f7517a.c(n.a(c3.getComponentType()), annotationArr), encoded2).a();
                } else {
                    return new i.l(this.f7517a.c(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof s) {
                Class<?> c4 = o.c(type);
                if (Map.class.isAssignableFrom(c4)) {
                    Type b2 = o.b(type, c4, Map.class);
                    if (b2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b2;
                        Type a2 = o.a(0, parameterizedType);
                        if (String.class == a2) {
                            return new i.k(this.f7517a.c(o.a(1, parameterizedType), annotationArr), ((s) annotation).encoded());
                        }
                        throw a(i2, "@QueryMap keys must be of type String: " + a2, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof i.r.h) {
                String value3 = ((i.r.h) annotation).value();
                Class<?> c5 = o.c(type);
                if (Iterable.class.isAssignableFrom(c5)) {
                    if (type instanceof ParameterizedType) {
                        return new i.f(value3, this.f7517a.c(o.a(0, (ParameterizedType) type), annotationArr)).b();
                    }
                    throw a(i2, c5.getSimpleName() + " must include generic type (e.g., " + c5.getSimpleName() + "<String>)", new Object[0]);
                } else if (c5.isArray()) {
                    return new i.f(value3, this.f7517a.c(n.a(c5.getComponentType()), annotationArr)).a();
                } else {
                    return new i.f(value3, this.f7517a.c(type, annotationArr));
                }
            } else if (annotation instanceof i.r.c) {
                if (this.o) {
                    i.r.c cVar = (i.r.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f7523g = true;
                    Class<?> c6 = o.c(type);
                    if (Iterable.class.isAssignableFrom(c6)) {
                        if (type instanceof ParameterizedType) {
                            return new i.d(value4, this.f7517a.c(o.a(0, (ParameterizedType) type), annotationArr), encoded3).b();
                        }
                        throw a(i2, c6.getSimpleName() + " must include generic type (e.g., " + c6.getSimpleName() + "<String>)", new Object[0]);
                    } else if (c6.isArray()) {
                        return new i.d(value4, this.f7517a.c(n.a(c6.getComponentType()), annotationArr), encoded3).a();
                    } else {
                        return new i.d(value4, this.f7517a.c(type, annotationArr), encoded3);
                    }
                }
                throw a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof i.r.d) {
                if (this.o) {
                    Class<?> c7 = o.c(type);
                    if (Map.class.isAssignableFrom(c7)) {
                        Type b3 = o.b(type, c7, Map.class);
                        if (b3 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                            Type a3 = o.a(0, parameterizedType2);
                            if (String.class == a3) {
                                e<T, String> c8 = this.f7517a.c(o.a(1, parameterizedType2), annotationArr);
                                this.f7523g = true;
                                return new i.e(c8, ((i.r.d) annotation).encoded());
                            }
                            throw a(i2, "@FieldMap keys must be of type String: " + a3, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof i.r.o) {
                if (this.p) {
                    i.r.o oVar = (i.r.o) annotation;
                    this.f7524h = true;
                    String value5 = oVar.value();
                    Class<?> c9 = o.c(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(c9)) {
                            if (type instanceof ParameterizedType) {
                                if (x.b.class.isAssignableFrom(o.c(o.a(0, (ParameterizedType) type)))) {
                                    return i.m.f7476a.b();
                                }
                                throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw a(i2, c9.getSimpleName() + " must include generic type (e.g., " + c9.getSimpleName() + "<String>)", new Object[0]);
                        } else if (c9.isArray()) {
                            if (x.b.class.isAssignableFrom(c9.getComponentType())) {
                                return i.m.f7476a.a();
                            }
                            throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else if (x.b.class.isAssignableFrom(c9)) {
                            return i.m.f7476a;
                        } else {
                            throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    }
                    t a4 = t.a("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", oVar.encoding());
                    if (Iterable.class.isAssignableFrom(c9)) {
                        if (type instanceof ParameterizedType) {
                            Type a5 = o.a(0, (ParameterizedType) type);
                            if (!x.b.class.isAssignableFrom(o.c(a5))) {
                                return new i.g(a4, this.f7517a.a(a5, annotationArr, this.f7519c)).b();
                            }
                            throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw a(i2, c9.getSimpleName() + " must include generic type (e.g., " + c9.getSimpleName() + "<String>)", new Object[0]);
                    } else if (c9.isArray()) {
                        Class<?> a6 = n.a(c9.getComponentType());
                        if (!x.b.class.isAssignableFrom(a6)) {
                            return new i.g(a4, this.f7517a.a(a6, annotationArr, this.f7519c)).a();
                        }
                        throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!x.b.class.isAssignableFrom(c9)) {
                        return new i.g(a4, this.f7517a.a(type, annotationArr, this.f7519c));
                    } else {
                        throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                }
                throw a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof p) {
                if (this.p) {
                    this.f7524h = true;
                    Class<?> c10 = o.c(type);
                    if (Map.class.isAssignableFrom(c10)) {
                        Type b4 = o.b(type, c10, Map.class);
                        if (b4 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) b4;
                            Type a7 = o.a(0, parameterizedType3);
                            if (String.class == a7) {
                                Type a8 = o.a(1, parameterizedType3);
                                if (!x.b.class.isAssignableFrom(o.c(a8))) {
                                    return new i.h(this.f7517a.a(a8, annotationArr, this.f7519c), ((p) annotation).encoding());
                                }
                                throw a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw a(i2, "@PartMap keys must be of type String: " + a7, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof i.r.a) {
                if (!this.o && !this.p) {
                    if (!this.f7525i) {
                        try {
                            e<T, c0> a9 = this.f7517a.a(type, annotationArr, this.f7519c);
                            this.f7525i = true;
                            return new i.c(a9);
                        } catch (RuntimeException e2) {
                            throw a(e2, i2, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw a(i2, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw a(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else {
                return null;
            }
        }

        public final void a(int i2, String str) {
            if (n.n.matcher(str).matches()) {
                if (!this.t.contains(str)) {
                    throw a(i2, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
                }
                return;
            }
            throw a(i2, "@Path parameter name must match %s. Found: %s", n.m.pattern(), str);
        }

        public final RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        public final RuntimeException a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            return new IllegalArgumentException(format + "\n    for method " + this.f7518b.getDeclaringClass().getSimpleName() + "." + this.f7518b.getName(), th);
        }

        public final RuntimeException a(Throwable th, int i2, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i2 + 1) + ")", objArr);
        }

        public final RuntimeException a(int i2, String str, Object... objArr) {
            return a(str + " (parameter #" + (i2 + 1) + ")", objArr);
        }
    }
}
