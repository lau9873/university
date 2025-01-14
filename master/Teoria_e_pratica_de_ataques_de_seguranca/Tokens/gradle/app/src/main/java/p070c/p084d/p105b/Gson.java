package p070c.p084d.p105b;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p070c.p084d.p105b.p107v.ConstructorConstructor;
import p070c.p084d.p105b.p107v.Excluder;
import p070c.p084d.p105b.p107v.Primitives;
import p070c.p084d.p105b.p107v.Streams;
import p070c.p084d.p105b.p107v.p108n.ArrayTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.CollectionTypeAdapterFactory;
import p070c.p084d.p105b.p107v.p108n.DateTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.JsonAdapterAnnotationTypeAdapterFactory;
import p070c.p084d.p105b.p107v.p108n.MapTypeAdapterFactory;
import p070c.p084d.p105b.p107v.p108n.ObjectTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.ReflectiveTypeAdapterFactory;
import p070c.p084d.p105b.p107v.p108n.SqlDateTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.TimeTypeAdapter;
import p070c.p084d.p105b.p107v.p108n.TypeAdapters;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.f */
/* loaded from: classes.dex */
public final class Gson {

    /* renamed from: k */
    public static final TypeToken<?> f5654k = TypeToken.get(Object.class);

    /* renamed from: a */
    public final ThreadLocal<Map<TypeToken<?>, C1261f<?>>> f5655a;

    /* renamed from: b */
    public final Map<TypeToken<?>, TypeAdapter<?>> f5656b;

    /* renamed from: c */
    public final ConstructorConstructor f5657c;

    /* renamed from: d */
    public final JsonAdapterAnnotationTypeAdapterFactory f5658d;

    /* renamed from: e */
    public final List<TypeAdapterFactory> f5659e;

    /* renamed from: f */
    public final boolean f5660f;

    /* renamed from: g */
    public final boolean f5661g;

    /* renamed from: h */
    public final boolean f5662h;

    /* renamed from: i */
    public final boolean f5663i;

    /* renamed from: j */
    public final boolean f5664j;

    public Gson() {
        this(Excluder.f5711g, FieldNamingPolicy.f5647a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.f5689a, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    /* renamed from: a */
    public final TypeAdapter<Number> m4926a(boolean z) {
        if (z) {
            return TypeAdapters.f5868v;
        }
        return new C1256a(this);
    }

    /* renamed from: b */
    public final TypeAdapter<Number> m4924b(boolean z) {
        if (z) {
            return TypeAdapters.f5867u;
        }
        return new C1257b(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.f5660f + ",factories:" + this.f5659e + ",instanceCreators:" + this.f5657c + "}";
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$a */
    /* loaded from: classes.dex */
    public class C1256a extends TypeAdapter<Number> {
        public C1256a(Gson gson) {
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return Double.valueOf(jsonReader.mo4710v());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.mo4679t();
                return;
            }
            Gson.m4946a(number.doubleValue());
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$b */
    /* loaded from: classes.dex */
    public class C1257b extends TypeAdapter<Number> {
        public C1257b(Gson gson) {
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return Float.valueOf((float) jsonReader.mo4710v());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.mo4679t();
                return;
            }
            Gson.m4946a(number.floatValue());
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$c */
    /* loaded from: classes.dex */
    public static class C1258c extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return Long.valueOf(jsonReader.mo4708x());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            if (number == null) {
                jsonWriter.mo4679t();
            } else {
                jsonWriter.mo4691e(number.toString());
            }
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$d */
    /* loaded from: classes.dex */
    public static class C1259d extends TypeAdapter<AtomicLong> {

        /* renamed from: a */
        public final /* synthetic */ TypeAdapter f5665a;

        public C1259d(TypeAdapter typeAdapter) {
            this.f5665a = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, AtomicLong atomicLong) {
            this.f5665a.mo4752a(jsonWriter, Long.valueOf(atomicLong.get()));
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AtomicLong mo4753a(JsonReader jsonReader) {
            return new AtomicLong(((Number) this.f5665a.mo4753a(jsonReader)).longValue());
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$e */
    /* loaded from: classes.dex */
    public static class C1260e extends TypeAdapter<AtomicLongArray> {

        /* renamed from: a */
        public final /* synthetic */ TypeAdapter f5666a;

        public C1260e(TypeAdapter typeAdapter) {
            this.f5666a = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) {
            jsonWriter.mo4687l();
            int length = atomicLongArray.length();
            for (int i = 0; i < length; i++) {
                this.f5666a.mo4752a(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
            }
            jsonWriter.mo4685n();
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AtomicLongArray mo4753a(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.mo4722j();
            while (jsonReader.mo4714r()) {
                arrayList.add(Long.valueOf(((Number) this.f5666a.mo4753a(jsonReader)).longValue()));
            }
            jsonReader.mo4717o();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i = 0; i < size; i++) {
                atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
            }
            return atomicLongArray;
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$f */
    /* loaded from: classes.dex */
    public static class C1261f<T> extends TypeAdapter<T> {

        /* renamed from: a */
        public TypeAdapter<T> f5667a;

        /* renamed from: a */
        public void m4918a(TypeAdapter<T> typeAdapter) {
            if (this.f5667a == null) {
                this.f5667a = typeAdapter;
                return;
            }
            throw new AssertionError();
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public T mo4753a(JsonReader jsonReader) {
            TypeAdapter<T> typeAdapter = this.f5667a;
            if (typeAdapter != null) {
                return typeAdapter.mo4753a(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public void mo4752a(JsonWriter jsonWriter, T t) {
            TypeAdapter<T> typeAdapter = this.f5667a;
            if (typeAdapter != null) {
                typeAdapter.mo4752a(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public static void m4946a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* renamed from: b */
    public static TypeAdapter<AtomicLongArray> m4925b(TypeAdapter<Number> typeAdapter) {
        return new C1260e(typeAdapter).m4888a();
    }

    /* renamed from: a */
    public static TypeAdapter<Number> m4942a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.f5689a) {
            return TypeAdapters.f5866t;
        }
        return new C1258c();
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List<TypeAdapterFactory> list, List<TypeAdapterFactory> list2, List<TypeAdapterFactory> list3) {
        this.f5655a = new ThreadLocal<>();
        this.f5656b = new ConcurrentHashMap();
        this.f5657c = new ConstructorConstructor(map);
        this.f5660f = z;
        this.f5661g = z3;
        this.f5662h = z4;
        this.f5663i = z5;
        this.f5664j = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f5845Y);
        arrayList.add(ObjectTypeAdapter.f5783b);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f5824D);
        arrayList.add(TypeAdapters.f5859m);
        arrayList.add(TypeAdapters.f5853g);
        arrayList.add(TypeAdapters.f5855i);
        arrayList.add(TypeAdapters.f5857k);
        TypeAdapter<Number> m4942a = m4942a(longSerializationPolicy);
        arrayList.add(TypeAdapters.m4785a(Long.TYPE, Long.class, m4942a));
        arrayList.add(TypeAdapters.m4785a(Double.TYPE, Double.class, m4926a(z7)));
        arrayList.add(TypeAdapters.m4785a(Float.TYPE, Float.class, m4924b(z7)));
        arrayList.add(TypeAdapters.f5870x);
        arrayList.add(TypeAdapters.f5861o);
        arrayList.add(TypeAdapters.f5863q);
        arrayList.add(TypeAdapters.m4786a(AtomicLong.class, m4941a(m4942a)));
        arrayList.add(TypeAdapters.m4786a(AtomicLongArray.class, m4925b(m4942a)));
        arrayList.add(TypeAdapters.f5865s);
        arrayList.add(TypeAdapters.f5872z);
        arrayList.add(TypeAdapters.f5826F);
        arrayList.add(TypeAdapters.f5828H);
        arrayList.add(TypeAdapters.m4786a(BigDecimal.class, TypeAdapters.f5822B));
        arrayList.add(TypeAdapters.m4786a(BigInteger.class, TypeAdapters.f5823C));
        arrayList.add(TypeAdapters.f5830J);
        arrayList.add(TypeAdapters.f5832L);
        arrayList.add(TypeAdapters.f5836P);
        arrayList.add(TypeAdapters.f5838R);
        arrayList.add(TypeAdapters.f5843W);
        arrayList.add(TypeAdapters.f5834N);
        arrayList.add(TypeAdapters.f5850d);
        arrayList.add(DateTypeAdapter.f5764b);
        arrayList.add(TypeAdapters.f5841U);
        arrayList.add(TimeTypeAdapter.f5804b);
        arrayList.add(SqlDateTypeAdapter.f5802b);
        arrayList.add(TypeAdapters.f5839S);
        arrayList.add(ArrayTypeAdapter.f5758c);
        arrayList.add(TypeAdapters.f5848b);
        arrayList.add(new CollectionTypeAdapterFactory(this.f5657c));
        arrayList.add(new MapTypeAdapterFactory(this.f5657c, z2));
        this.f5658d = new JsonAdapterAnnotationTypeAdapterFactory(this.f5657c);
        arrayList.add(this.f5658d);
        arrayList.add(TypeAdapters.f5846Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f5657c, fieldNamingStrategy, excluder, this.f5658d));
        this.f5659e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static TypeAdapter<AtomicLong> m4941a(TypeAdapter<Number> typeAdapter) {
        return new C1259d(typeAdapter).m4888a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> TypeAdapter<T> m4939a(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.f5656b.get(typeToken == null ? f5654k : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, C1261f<?>> map = this.f5655a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f5655a.set(map);
            z = true;
        }
        C1261f<?> c1261f = map.get(typeToken);
        if (c1261f != null) {
            return c1261f;
        }
        try {
            C1261f<?> c1261f2 = new C1261f<>();
            map.put(typeToken, c1261f2);
            for (TypeAdapterFactory typeAdapterFactory : this.f5659e) {
                TypeAdapter typeAdapter2 = (TypeAdapter<T>) typeAdapterFactory.mo4750a(this, typeToken);
                if (typeAdapter2 != null) {
                    c1261f2.m4918a((TypeAdapter<?>) typeAdapter2);
                    this.f5656b.put(typeToken, typeAdapter2);
                    return typeAdapter2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z) {
                this.f5655a.remove();
            }
        }
    }

    /* renamed from: a */
    public <T> TypeAdapter<T> m4940a(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f5659e.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f5658d;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f5659e) {
            if (z) {
                TypeAdapter<T> mo4750a = typeAdapterFactory2.mo4750a(this, typeToken);
                if (mo4750a != null) {
                    return mo4750a;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    /* renamed from: a */
    public <T> TypeAdapter<T> m4934a(Class<T> cls) {
        return m4939a((TypeToken) TypeToken.get((Class) cls));
    }

    /* renamed from: a */
    public String m4933a(Object obj) {
        if (obj == null) {
            return m4945a((JsonElement) JsonNull.f5685a);
        }
        return m4931a(obj, obj.getClass());
    }

    /* renamed from: a */
    public String m4931a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        m4929a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m4929a(Object obj, Type type, Appendable appendable) {
        try {
            m4930a(obj, type, m4935a(Streams.m4819a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    /* renamed from: a */
    public void m4930a(Object obj, Type type, JsonWriter jsonWriter) {
        TypeAdapter m4939a = m4939a((TypeToken) TypeToken.get(type));
        boolean m4681r = jsonWriter.m4681r();
        jsonWriter.m4696b(true);
        boolean m4682q = jsonWriter.m4682q();
        jsonWriter.m4699a(this.f5662h);
        boolean m4683p = jsonWriter.m4683p();
        jsonWriter.m4694c(this.f5660f);
        try {
            try {
                m4939a.mo4752a(jsonWriter, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.m4696b(m4681r);
            jsonWriter.m4699a(m4682q);
            jsonWriter.m4694c(m4683p);
        }
    }

    /* renamed from: a */
    public String m4945a(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        m4943a(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m4943a(JsonElement jsonElement, Appendable appendable) {
        try {
            m4944a(jsonElement, m4935a(Streams.m4819a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    /* renamed from: a */
    public JsonWriter m4935a(Writer writer) {
        if (this.f5661g) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f5663i) {
            jsonWriter.m4695c("  ");
        }
        jsonWriter.m4694c(this.f5660f);
        return jsonWriter;
    }

    /* renamed from: a */
    public JsonReader m4937a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.m4725b(this.f5664j);
        return jsonReader;
    }

    /* renamed from: a */
    public void m4944a(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean m4681r = jsonWriter.m4681r();
        jsonWriter.m4696b(true);
        boolean m4682q = jsonWriter.m4682q();
        jsonWriter.m4699a(this.f5662h);
        boolean m4683p = jsonWriter.m4683p();
        jsonWriter.m4694c(this.f5660f);
        try {
            try {
                Streams.m4821a(jsonElement, jsonWriter);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            jsonWriter.m4696b(m4681r);
            jsonWriter.m4699a(m4682q);
            jsonWriter.m4694c(m4683p);
        }
    }

    /* renamed from: a */
    public <T> T m4928a(String str, Class<T> cls) {
        return (T) Primitives.m4824a((Class) cls).cast(m4927a(str, (Type) cls));
    }

    /* renamed from: a */
    public <T> T m4927a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) m4936a((Reader) new StringReader(str), type);
    }

    /* renamed from: a */
    public <T> T m4936a(Reader reader, Type type) {
        JsonReader m4937a = m4937a(reader);
        T t = (T) m4938a(m4937a, type);
        m4932a(t, m4937a);
        return t;
    }

    /* renamed from: a */
    public static void m4932a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.mo4738C() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    /* renamed from: a */
    public <T> T m4938a(JsonReader jsonReader, Type type) {
        boolean m4713s = jsonReader.m4713s();
        boolean z = true;
        jsonReader.m4725b(true);
        try {
            try {
                try {
                    jsonReader.mo4738C();
                    z = false;
                    T mo4753a = m4939a((TypeToken) TypeToken.get(type)).mo4753a(jsonReader);
                    jsonReader.m4725b(m4713s);
                    return mo4753a;
                } catch (EOFException e) {
                    if (z) {
                        jsonReader.m4725b(m4713s);
                        return null;
                    }
                    throw new JsonSyntaxException(e);
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
                }
            } catch (IOException e3) {
                throw new JsonSyntaxException(e3);
            } catch (IllegalStateException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (Throwable th) {
            jsonReader.m4725b(m4713s);
            throw th;
        }
    }
}
