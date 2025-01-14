package p220i;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import p181e.Headers;
import p181e.MultipartBody;
import p181e.RequestBody;

/* renamed from: i.i */
/* loaded from: classes.dex */
public abstract class ParameterHandler<T> {

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$a */
    /* loaded from: classes.dex */
    public class C2614a extends ParameterHandler<Iterable<T>> {
        public C2614a() {
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo662a(RequestBuilder requestBuilder, Object obj) {
            m667a(requestBuilder, (Iterable) ((Iterable) obj));
        }

        /* renamed from: a */
        public void m667a(RequestBuilder requestBuilder, Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            for (T t : iterable) {
                ParameterHandler.this.mo662a(requestBuilder, t);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$b */
    /* loaded from: classes.dex */
    public class C2615b extends ParameterHandler<Object> {
        public C2615b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                ParameterHandler.this.mo662a(requestBuilder, Array.get(obj, i));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$c */
    /* loaded from: classes.dex */
    public static final class C2616c<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final Converter<T, RequestBody> f10408a;

        public C2616c(Converter<T, RequestBody> converter) {
            this.f10408a = converter;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                try {
                    requestBuilder.m654a(this.f10408a.mo560a(t));
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
                }
            }
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$d */
    /* loaded from: classes.dex */
    public static final class C2617d<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final String f10409a;

        /* renamed from: b */
        public final Converter<T, String> f10410b;

        /* renamed from: c */
        public final boolean f10411c;

        public C2617d(String str, Converter<T, String> converter, boolean z) {
            C2636o.m595a(str, "name == null");
            this.f10409a = str;
            this.f10410b = converter;
            this.f10411c = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            String mo560a;
            if (t == null || (mo560a = this.f10410b.mo560a(t)) == null) {
                return;
            }
            requestBuilder.m649a(this.f10409a, mo560a, this.f10411c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$e */
    /* loaded from: classes.dex */
    public static final class C2618e<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        public final Converter<T, String> f10412a;

        /* renamed from: b */
        public final boolean f10413b;

        public C2618e(Converter<T, String> converter, boolean z) {
            this.f10412a = converter;
            this.f10413b = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo662a(RequestBuilder requestBuilder, Object obj) {
            m666a(requestBuilder, (Map) ((Map) obj));
        }

        /* renamed from: a */
        public void m666a(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String mo560a = this.f10412a.mo560a(value);
                            if (mo560a != null) {
                                requestBuilder.m649a(key, mo560a, this.f10413b);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f10412a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$f */
    /* loaded from: classes.dex */
    public static final class C2619f<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final String f10414a;

        /* renamed from: b */
        public final Converter<T, String> f10415b;

        public C2619f(String str, Converter<T, String> converter) {
            C2636o.m595a(str, "name == null");
            this.f10414a = str;
            this.f10415b = converter;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            String mo560a;
            if (t == null || (mo560a = this.f10415b.mo560a(t)) == null) {
                return;
            }
            requestBuilder.m650a(this.f10414a, mo560a);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$g */
    /* loaded from: classes.dex */
    public static final class C2620g<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final Headers f10416a;

        /* renamed from: b */
        public final Converter<T, RequestBody> f10417b;

        public C2620g(Headers headers, Converter<T, RequestBody> converter) {
            this.f10416a = headers;
            this.f10417b = converter;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.m653a(this.f10416a, this.f10417b.mo560a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$h */
    /* loaded from: classes.dex */
    public static final class C2621h<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        public final Converter<T, RequestBody> f10418a;

        /* renamed from: b */
        public final String f10419b;

        public C2621h(Converter<T, RequestBody> converter, String str) {
            this.f10418a = converter;
            this.f10419b = str;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo662a(RequestBuilder requestBuilder, Object obj) {
            m665a(requestBuilder, (Map) ((Map) obj));
        }

        /* renamed from: a */
        public void m665a(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            requestBuilder.m653a(Headers.m2764a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f10419b), this.f10418a.mo560a(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$i */
    /* loaded from: classes.dex */
    public static final class C2622i<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final String f10420a;

        /* renamed from: b */
        public final Converter<T, String> f10421b;

        /* renamed from: c */
        public final boolean f10422c;

        public C2622i(String str, Converter<T, String> converter, boolean z) {
            C2636o.m595a(str, "name == null");
            this.f10420a = str;
            this.f10421b = converter;
            this.f10422c = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            if (t != null) {
                requestBuilder.m647b(this.f10420a, this.f10421b.mo560a(t), this.f10422c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f10420a + "\" value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$j */
    /* loaded from: classes.dex */
    public static final class C2623j<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final String f10423a;

        /* renamed from: b */
        public final Converter<T, String> f10424b;

        /* renamed from: c */
        public final boolean f10425c;

        public C2623j(String str, Converter<T, String> converter, boolean z) {
            C2636o.m595a(str, "name == null");
            this.f10423a = str;
            this.f10424b = converter;
            this.f10425c = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            String mo560a;
            if (t == null || (mo560a = this.f10424b.mo560a(t)) == null) {
                return;
            }
            requestBuilder.m646c(this.f10423a, mo560a, this.f10425c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$k */
    /* loaded from: classes.dex */
    public static final class C2624k<T> extends ParameterHandler<Map<String, T>> {

        /* renamed from: a */
        public final Converter<T, String> f10426a;

        /* renamed from: b */
        public final boolean f10427b;

        public C2624k(Converter<T, String> converter, boolean z) {
            this.f10426a = converter;
            this.f10427b = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo662a(RequestBuilder requestBuilder, Object obj) {
            m664a(requestBuilder, (Map) ((Map) obj));
        }

        /* renamed from: a */
        public void m664a(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String mo560a = this.f10426a.mo560a(value);
                            if (mo560a != null) {
                                requestBuilder.m646c(key, mo560a, this.f10427b);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f10426a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$l */
    /* loaded from: classes.dex */
    public static final class C2625l<T> extends ParameterHandler<T> {

        /* renamed from: a */
        public final Converter<T, String> f10428a;

        /* renamed from: b */
        public final boolean f10429b;

        public C2625l(Converter<T, String> converter, boolean z) {
            this.f10428a = converter;
            this.f10429b = z;
        }

        @Override // p220i.ParameterHandler
        /* renamed from: a */
        public void mo662a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            requestBuilder.m646c(this.f10428a.mo560a(t), null, this.f10429b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$m */
    /* loaded from: classes.dex */
    public static final class C2626m extends ParameterHandler<MultipartBody.C1814b> {

        /* renamed from: a */
        public static final C2626m f10430a = new C2626m();

        @Override // p220i.ParameterHandler
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo662a(RequestBuilder requestBuilder, MultipartBody.C1814b c1814b) {
            if (c1814b != null) {
                requestBuilder.m652a(c1814b);
            }
        }
    }

    /* renamed from: a */
    public final ParameterHandler<Object> m669a() {
        return new C2615b();
    }

    /* renamed from: a */
    public abstract void mo662a(RequestBuilder requestBuilder, T t);

    /* renamed from: b */
    public final ParameterHandler<Iterable<T>> m668b() {
        return new C2614a();
    }
}
