package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.JsonArray;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.JsonNull;
import p070c.p084d.p105b.JsonObject;
import p070c.p084d.p105b.JsonPrimitive;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p106u.SerializedName;
import p070c.p084d.p105b.p107v.LazilyParsedNumber;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.n */
/* loaded from: classes.dex */
public final class TypeAdapters {

    /* renamed from: a */
    public static final TypeAdapter<Class> f5847a = new C1333k().m4888a();

    /* renamed from: b */
    public static final TypeAdapterFactory f5848b = m4786a(Class.class, f5847a);

    /* renamed from: c */
    public static final TypeAdapter<BitSet> f5849c = new C1346v().m4888a();

    /* renamed from: d */
    public static final TypeAdapterFactory f5850d = m4786a(BitSet.class, f5849c);

    /* renamed from: e */
    public static final TypeAdapter<Boolean> f5851e = new C1320d0();

    /* renamed from: f */
    public static final TypeAdapter<Boolean> f5852f = new C1322e0();

    /* renamed from: g */
    public static final TypeAdapterFactory f5853g = m4785a(Boolean.TYPE, Boolean.class, f5851e);

    /* renamed from: h */
    public static final TypeAdapter<Number> f5854h = new C1324f0();

    /* renamed from: i */
    public static final TypeAdapterFactory f5855i = m4785a(Byte.TYPE, Byte.class, f5854h);

    /* renamed from: j */
    public static final TypeAdapter<Number> f5856j = new C1326g0();

    /* renamed from: k */
    public static final TypeAdapterFactory f5857k = m4785a(Short.TYPE, Short.class, f5856j);

    /* renamed from: l */
    public static final TypeAdapter<Number> f5858l = new C1328h0();

    /* renamed from: m */
    public static final TypeAdapterFactory f5859m = m4785a(Integer.TYPE, Integer.class, f5858l);

    /* renamed from: n */
    public static final TypeAdapter<AtomicInteger> f5860n = new C1330i0().m4888a();

    /* renamed from: o */
    public static final TypeAdapterFactory f5861o = m4786a(AtomicInteger.class, f5860n);

    /* renamed from: p */
    public static final TypeAdapter<AtomicBoolean> f5862p = new C1332j0().m4888a();

    /* renamed from: q */
    public static final TypeAdapterFactory f5863q = m4786a(AtomicBoolean.class, f5862p);

    /* renamed from: r */
    public static final TypeAdapter<AtomicIntegerArray> f5864r = new C1312a().m4888a();

    /* renamed from: s */
    public static final TypeAdapterFactory f5865s = m4786a(AtomicIntegerArray.class, f5864r);

    /* renamed from: t */
    public static final TypeAdapter<Number> f5866t = new C1314b();

    /* renamed from: u */
    public static final TypeAdapter<Number> f5867u = new C1317c();

    /* renamed from: v */
    public static final TypeAdapter<Number> f5868v = new C1319d();

    /* renamed from: w */
    public static final TypeAdapter<Number> f5869w = new C1321e();

    /* renamed from: x */
    public static final TypeAdapterFactory f5870x = m4786a(Number.class, f5869w);

    /* renamed from: y */
    public static final TypeAdapter<Character> f5871y = new C1323f();

    /* renamed from: z */
    public static final TypeAdapterFactory f5872z = m4785a(Character.TYPE, Character.class, f5871y);

    /* renamed from: A */
    public static final TypeAdapter<String> f5821A = new C1325g();

    /* renamed from: B */
    public static final TypeAdapter<BigDecimal> f5822B = new C1327h();

    /* renamed from: C */
    public static final TypeAdapter<BigInteger> f5823C = new C1329i();

    /* renamed from: D */
    public static final TypeAdapterFactory f5824D = m4786a(String.class, f5821A);

    /* renamed from: E */
    public static final TypeAdapter<StringBuilder> f5825E = new C1331j();

    /* renamed from: F */
    public static final TypeAdapterFactory f5826F = m4786a(StringBuilder.class, f5825E);

    /* renamed from: G */
    public static final TypeAdapter<StringBuffer> f5827G = new C1335l();

    /* renamed from: H */
    public static final TypeAdapterFactory f5828H = m4786a(StringBuffer.class, f5827G);

    /* renamed from: I */
    public static final TypeAdapter<URL> f5829I = new C1336m();

    /* renamed from: J */
    public static final TypeAdapterFactory f5830J = m4786a(URL.class, f5829I);

    /* renamed from: K */
    public static final TypeAdapter<URI> f5831K = new C1337n();

    /* renamed from: L */
    public static final TypeAdapterFactory f5832L = m4786a(URI.class, f5831K);

    /* renamed from: M */
    public static final TypeAdapter<InetAddress> f5833M = new C1338o();

    /* renamed from: N */
    public static final TypeAdapterFactory f5834N = m4784b(InetAddress.class, f5833M);

    /* renamed from: O */
    public static final TypeAdapter<UUID> f5835O = new C1339p();

    /* renamed from: P */
    public static final TypeAdapterFactory f5836P = m4786a(UUID.class, f5835O);

    /* renamed from: Q */
    public static final TypeAdapter<Currency> f5837Q = new C1340q().m4888a();

    /* renamed from: R */
    public static final TypeAdapterFactory f5838R = m4786a(Currency.class, f5837Q);

    /* renamed from: S */
    public static final TypeAdapterFactory f5839S = new C1341r();

    /* renamed from: T */
    public static final TypeAdapter<Calendar> f5840T = new C1343s();

    /* renamed from: U */
    public static final TypeAdapterFactory f5841U = m4783b(Calendar.class, GregorianCalendar.class, f5840T);

    /* renamed from: V */
    public static final TypeAdapter<Locale> f5842V = new C1344t();

    /* renamed from: W */
    public static final TypeAdapterFactory f5843W = m4786a(Locale.class, f5842V);

    /* renamed from: X */
    public static final TypeAdapter<JsonElement> f5844X = new C1345u();

    /* renamed from: Y */
    public static final TypeAdapterFactory f5845Y = m4784b(JsonElement.class, f5844X);

    /* renamed from: Z */
    public static final TypeAdapterFactory f5846Z = new C1347w();

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$a0 */
    /* loaded from: classes.dex */
    public static class C1313a0 implements TypeAdapterFactory {

        /* renamed from: a */
        public final /* synthetic */ Class f5873a;

        /* renamed from: b */
        public final /* synthetic */ Class f5874b;

        /* renamed from: c */
        public final /* synthetic */ TypeAdapter f5875c;

        public C1313a0(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f5873a = cls;
            this.f5874b = cls2;
            this.f5875c = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.f5873a || rawType == this.f5874b) {
                return this.f5875c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5873a.getName() + "+" + this.f5874b.getName() + ",adapter=" + this.f5875c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$b0 */
    /* loaded from: classes.dex */
    public static class C1315b0 implements TypeAdapterFactory {

        /* renamed from: a */
        public final /* synthetic */ Class f5876a;

        /* renamed from: b */
        public final /* synthetic */ TypeAdapter f5877b;

        /* compiled from: TypeAdapters.java */
        /* renamed from: c.d.b.v.n.n$b0$a */
        /* loaded from: classes.dex */
        public class C1316a extends TypeAdapter<T1> {

            /* renamed from: a */
            public final /* synthetic */ Class f5878a;

            public C1316a(Class cls) {
                this.f5878a = cls;
            }

            @Override // p070c.p084d.p105b.TypeAdapter
            /* renamed from: a */
            public void mo4752a(JsonWriter jsonWriter, T1 t1) {
                C1315b0.this.f5877b.mo4752a(jsonWriter, t1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
            @Override // p070c.p084d.p105b.TypeAdapter
            /* renamed from: a */
            public T1 mo4753a(JsonReader jsonReader) {
                ?? mo4753a = C1315b0.this.f5877b.mo4753a(jsonReader);
                if (mo4753a == 0 || this.f5878a.isInstance(mo4753a)) {
                    return mo4753a;
                }
                throw new JsonSyntaxException("Expected a " + this.f5878a.getName() + " but was " + mo4753a.getClass().getName());
            }
        }

        public C1315b0(Class cls, TypeAdapter typeAdapter) {
            this.f5876a = cls;
            this.f5877b = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T2> TypeAdapter<T2> mo4750a(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> rawType = typeToken.getRawType();
            if (this.f5876a.isAssignableFrom(rawType)) {
                return new C1316a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f5876a.getName() + ",adapter=" + this.f5877b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$c0 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1318c0 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5880a = new int[JsonToken.values().length];

        static {
            try {
                f5880a[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5880a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5880a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5880a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5880a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5880a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5880a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5880a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5880a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5880a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$k */
    /* loaded from: classes.dex */
    public static class C1333k extends TypeAdapter<Class> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ Class mo4753a(JsonReader jsonReader) {
            mo4753a(jsonReader);
            throw null;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo4752a(JsonWriter jsonWriter, Class cls) {
            m4765a(jsonWriter, cls);
            throw null;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void m4765a(JsonWriter jsonWriter, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Class mo4753a(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$k0 */
    /* loaded from: classes.dex */
    public static final class C1334k0<T extends Enum<T>> extends TypeAdapter<T> {

        /* renamed from: a */
        public final Map<String, T> f5881a = new HashMap();

        /* renamed from: b */
        public final Map<T, String> f5882b = new HashMap();

        public C1334k0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    SerializedName serializedName = (SerializedName) cls.getField(name).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.f5881a.put(str, t);
                        }
                    }
                    this.f5881a.put(name, t);
                    this.f5882b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo4752a(JsonWriter jsonWriter, Object obj) {
            m4764a(jsonWriter, (JsonWriter) ((Enum) obj));
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public T mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return this.f5881a.get(jsonReader.mo4740A());
        }

        /* renamed from: a */
        public void m4764a(JsonWriter jsonWriter, T t) {
            jsonWriter.mo4691e(t == null ? null : this.f5882b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$r */
    /* loaded from: classes.dex */
    public static class C1341r implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new C1342a(this, gson.m4934a((Class) Date.class));
        }

        /* compiled from: TypeAdapters.java */
        /* renamed from: c.d.b.v.n.n$r$a */
        /* loaded from: classes.dex */
        public class C1342a extends TypeAdapter<Timestamp> {

            /* renamed from: a */
            public final /* synthetic */ TypeAdapter f5883a;

            public C1342a(C1341r c1341r, TypeAdapter typeAdapter) {
                this.f5883a = typeAdapter;
            }

            @Override // p070c.p084d.p105b.TypeAdapter
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public Timestamp mo4753a(JsonReader jsonReader) {
                Date date = (Date) this.f5883a.mo4753a(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // p070c.p084d.p105b.TypeAdapter
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo4752a(JsonWriter jsonWriter, Timestamp timestamp) {
                this.f5883a.mo4752a(jsonWriter, timestamp);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$w */
    /* loaded from: classes.dex */
    public static class C1347w implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            Class rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = (Class<? super Object>) rawType.getSuperclass();
            }
            return new C1334k0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$x */
    /* loaded from: classes.dex */
    public static class C1348x implements TypeAdapterFactory {

        /* renamed from: a */
        public final /* synthetic */ TypeToken f5884a;

        /* renamed from: b */
        public final /* synthetic */ TypeAdapter f5885b;

        public C1348x(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.f5884a = typeToken;
            this.f5885b = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(this.f5884a)) {
                return this.f5885b;
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$y */
    /* loaded from: classes.dex */
    public static class C1349y implements TypeAdapterFactory {

        /* renamed from: a */
        public final /* synthetic */ Class f5886a;

        /* renamed from: b */
        public final /* synthetic */ TypeAdapter f5887b;

        public C1349y(Class cls, TypeAdapter typeAdapter) {
            this.f5886a = cls;
            this.f5887b = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.f5886a) {
                return this.f5887b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5886a.getName() + ",adapter=" + this.f5887b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$z */
    /* loaded from: classes.dex */
    public static class C1350z implements TypeAdapterFactory {

        /* renamed from: a */
        public final /* synthetic */ Class f5888a;

        /* renamed from: b */
        public final /* synthetic */ Class f5889b;

        /* renamed from: c */
        public final /* synthetic */ TypeAdapter f5890c;

        public C1350z(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f5888a = cls;
            this.f5889b = cls2;
            this.f5890c = typeAdapter;
        }

        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.f5888a || rawType == this.f5889b) {
                return this.f5890c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f5889b.getName() + "+" + this.f5888a.getName() + ",adapter=" + this.f5890c + "]";
        }
    }

    /* renamed from: a */
    public static <TT> TypeAdapterFactory m4787a(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new C1348x(typeToken, typeAdapter);
    }

    /* renamed from: b */
    public static <TT> TypeAdapterFactory m4783b(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new C1313a0(cls, cls2, typeAdapter);
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$a */
    /* loaded from: classes.dex */
    public static class C1312a extends TypeAdapter<AtomicIntegerArray> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AtomicIntegerArray mo4753a(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.mo4722j();
            while (jsonReader.mo4714r()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.mo4709w()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.mo4717o();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) {
            jsonWriter.mo4687l();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo4690g(atomicIntegerArray.get(i));
            }
            jsonWriter.mo4685n();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$b */
    /* loaded from: classes.dex */
    public static class C1314b extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.mo4708x());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$c */
    /* loaded from: classes.dex */
    public static class C1317c extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
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
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$d */
    /* loaded from: classes.dex */
    public static class C1319d extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
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
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$d0 */
    /* loaded from: classes.dex */
    public static class C1320d0 extends TypeAdapter<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Boolean mo4753a(JsonReader jsonReader) {
            JsonToken mo4738C = jsonReader.mo4738C();
            if (mo4738C == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            } else if (mo4738C == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.mo4740A()));
            } else {
                return Boolean.valueOf(jsonReader.mo4711u());
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.mo4701a(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$e */
    /* loaded from: classes.dex */
    public static class C1321e extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            JsonToken mo4738C = jsonReader.mo4738C();
            int i = C1318c0.f5880a[mo4738C.ordinal()];
            if (i == 1 || i == 3) {
                return new LazilyParsedNumber(jsonReader.mo4740A());
            }
            if (i == 4) {
                jsonReader.mo4706z();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + mo4738C);
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$e0 */
    /* loaded from: classes.dex */
    public static class C1322e0 extends TypeAdapter<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Boolean mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return Boolean.valueOf(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Boolean bool) {
            jsonWriter.mo4691e(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$f */
    /* loaded from: classes.dex */
    public static class C1323f extends TypeAdapter<Character> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Character mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            String mo4740A = jsonReader.mo4740A();
            if (mo4740A.length() == 1) {
                return Character.valueOf(mo4740A.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + mo4740A);
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Character ch) {
            jsonWriter.mo4691e(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$f0 */
    /* loaded from: classes.dex */
    public static class C1324f0 extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.mo4709w());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$g */
    /* loaded from: classes.dex */
    public static class C1325g extends TypeAdapter<String> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public String mo4753a(JsonReader jsonReader) {
            JsonToken mo4738C = jsonReader.mo4738C();
            if (mo4738C == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            } else if (mo4738C == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.mo4711u());
            } else {
                return jsonReader.mo4740A();
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, String str) {
            jsonWriter.mo4691e(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$g0 */
    /* loaded from: classes.dex */
    public static class C1326g0 extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.mo4709w());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$h */
    /* loaded from: classes.dex */
    public static class C1327h extends TypeAdapter<BigDecimal> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public BigDecimal mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.mo4740A());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, BigDecimal bigDecimal) {
            jsonWriter.mo4700a(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$h0 */
    /* loaded from: classes.dex */
    public static class C1328h0 extends TypeAdapter<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public Number mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.mo4709w());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Number number) {
            jsonWriter.mo4700a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$i */
    /* loaded from: classes.dex */
    public static class C1329i extends TypeAdapter<BigInteger> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public BigInteger mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                return new BigInteger(jsonReader.mo4740A());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, BigInteger bigInteger) {
            jsonWriter.mo4700a(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$i0 */
    /* loaded from: classes.dex */
    public static class C1330i0 extends TypeAdapter<AtomicInteger> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AtomicInteger mo4753a(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.mo4709w());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, AtomicInteger atomicInteger) {
            jsonWriter.mo4690g(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$j */
    /* loaded from: classes.dex */
    public static class C1331j extends TypeAdapter<StringBuilder> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public StringBuilder mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return new StringBuilder(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, StringBuilder sb) {
            jsonWriter.mo4691e(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$j0 */
    /* loaded from: classes.dex */
    public static class C1332j0 extends TypeAdapter<AtomicBoolean> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public AtomicBoolean mo4753a(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.mo4711u());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) {
            jsonWriter.mo4692d(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$l */
    /* loaded from: classes.dex */
    public static class C1335l extends TypeAdapter<StringBuffer> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public StringBuffer mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return new StringBuffer(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, StringBuffer stringBuffer) {
            jsonWriter.mo4691e(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$m */
    /* loaded from: classes.dex */
    public static class C1336m extends TypeAdapter<URL> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public URL mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            String mo4740A = jsonReader.mo4740A();
            if ("null".equals(mo4740A)) {
                return null;
            }
            return new URL(mo4740A);
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, URL url) {
            jsonWriter.mo4691e(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$n */
    /* loaded from: classes.dex */
    public static class C1337n extends TypeAdapter<URI> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public URI mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            try {
                String mo4740A = jsonReader.mo4740A();
                if ("null".equals(mo4740A)) {
                    return null;
                }
                return new URI(mo4740A);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, URI uri) {
            jsonWriter.mo4691e(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$o */
    /* loaded from: classes.dex */
    public static class C1338o extends TypeAdapter<InetAddress> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public InetAddress mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return InetAddress.getByName(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, InetAddress inetAddress) {
            jsonWriter.mo4691e(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$p */
    /* loaded from: classes.dex */
    public static class C1339p extends TypeAdapter<UUID> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public UUID mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            return UUID.fromString(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, UUID uuid) {
            jsonWriter.mo4691e(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$q */
    /* loaded from: classes.dex */
    public static class C1340q extends TypeAdapter<Currency> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Currency mo4753a(JsonReader jsonReader) {
            return Currency.getInstance(jsonReader.mo4740A());
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Currency currency) {
            jsonWriter.mo4691e(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$s */
    /* loaded from: classes.dex */
    public static class C1343s extends TypeAdapter<Calendar> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Calendar mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            jsonReader.mo4721k();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.mo4738C() != JsonToken.END_OBJECT) {
                String mo4707y = jsonReader.mo4707y();
                int mo4709w = jsonReader.mo4709w();
                if ("year".equals(mo4707y)) {
                    i = mo4709w;
                } else if ("month".equals(mo4707y)) {
                    i2 = mo4709w;
                } else if ("dayOfMonth".equals(mo4707y)) {
                    i3 = mo4709w;
                } else if ("hourOfDay".equals(mo4707y)) {
                    i4 = mo4709w;
                } else if ("minute".equals(mo4707y)) {
                    i5 = mo4709w;
                } else if ("second".equals(mo4707y)) {
                    i6 = mo4709w;
                }
            }
            jsonReader.mo4716p();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Calendar calendar) {
            if (calendar == null) {
                jsonWriter.mo4679t();
                return;
            }
            jsonWriter.mo4686m();
            jsonWriter.mo4697b("year");
            jsonWriter.mo4690g(calendar.get(1));
            jsonWriter.mo4697b("month");
            jsonWriter.mo4690g(calendar.get(2));
            jsonWriter.mo4697b("dayOfMonth");
            jsonWriter.mo4690g(calendar.get(5));
            jsonWriter.mo4697b("hourOfDay");
            jsonWriter.mo4690g(calendar.get(11));
            jsonWriter.mo4697b("minute");
            jsonWriter.mo4690g(calendar.get(12));
            jsonWriter.mo4697b("second");
            jsonWriter.mo4690g(calendar.get(13));
            jsonWriter.mo4684o();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$t */
    /* loaded from: classes.dex */
    public static class C1344t extends TypeAdapter<Locale> {
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Locale mo4753a(JsonReader jsonReader) {
            if (jsonReader.mo4738C() == JsonToken.NULL) {
                jsonReader.mo4706z();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.mo4740A(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, Locale locale) {
            jsonWriter.mo4691e(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$u */
    /* loaded from: classes.dex */
    public static class C1345u extends TypeAdapter<JsonElement> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a */
        public JsonElement mo4753a(JsonReader jsonReader) {
            switch (C1318c0.f5880a[jsonReader.mo4738C().ordinal()]) {
                case 1:
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.mo4740A()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.mo4711u()));
                case 3:
                    return new JsonPrimitive(jsonReader.mo4740A());
                case 4:
                    jsonReader.mo4706z();
                    return JsonNull.f5685a;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.mo4722j();
                    while (jsonReader.mo4714r()) {
                        jsonArray.m4912a(mo4753a(jsonReader));
                    }
                    jsonReader.mo4717o();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.mo4721k();
                    while (jsonReader.mo4714r()) {
                        jsonObject.m4904a(jsonReader.mo4707y(), mo4753a(jsonReader));
                    }
                    jsonReader.mo4716p();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, JsonElement jsonElement) {
            if (jsonElement != null && !jsonElement.m4907r()) {
                if (jsonElement.m4905t()) {
                    JsonPrimitive m4909o = jsonElement.m4909o();
                    if (m4909o.m4901B()) {
                        jsonWriter.mo4700a(m4909o.m4890z());
                        return;
                    } else if (m4909o.m4902A()) {
                        jsonWriter.mo4692d(m4909o.m4895u());
                        return;
                    } else {
                        jsonWriter.mo4691e(m4909o.mo4896p());
                        return;
                    }
                } else if (jsonElement.m4908q()) {
                    jsonWriter.mo4687l();
                    Iterator<JsonElement> it = jsonElement.m4911a().iterator();
                    while (it.hasNext()) {
                        mo4752a(jsonWriter, it.next());
                    }
                    jsonWriter.mo4685n();
                    return;
                } else if (jsonElement.m4906s()) {
                    jsonWriter.mo4686m();
                    for (Map.Entry<String, JsonElement> entry : jsonElement.m4910n().m4903u()) {
                        jsonWriter.mo4697b(entry.getKey());
                        mo4752a(jsonWriter, entry.getValue());
                    }
                    jsonWriter.mo4684o();
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
            }
            jsonWriter.mo4679t();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$v */
    /* loaded from: classes.dex */
    public static class C1346v extends TypeAdapter<BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.mo4709w() != 0) goto L15;
         */
        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet mo4753a(p070c.p084d.p105b.p112x.JsonReader r8) {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.mo4722j()
                c.d.b.x.b r1 = r8.mo4738C()
                r2 = 0
                r3 = 0
            Le:
                c.d.b.x.b r4 = p070c.p084d.p105b.p112x.JsonToken.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = p070c.p084d.p105b.p107v.p108n.TypeAdapters.C1318c0.f5880a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.mo4740A()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                com.google.gson.JsonSyntaxException r8 = new com.google.gson.JsonSyntaxException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.mo4711u()
                goto L69
            L63:
                int r1 = r8.mo4709w()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                c.d.b.x.b r1 = r8.mo4738C()
                goto Le
            L75:
                r8.mo4717o()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p107v.p108n.TypeAdapters.C1346v.mo4753a(c.d.b.x.a):java.util.BitSet");
        }

        @Override // p070c.p084d.p105b.TypeAdapter
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4752a(JsonWriter jsonWriter, BitSet bitSet) {
            jsonWriter.mo4687l();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo4690g(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.mo4685n();
        }
    }

    /* renamed from: a */
    public static <TT> TypeAdapterFactory m4786a(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new C1349y(cls, typeAdapter);
    }

    /* renamed from: b */
    public static <T1> TypeAdapterFactory m4784b(Class<T1> cls, TypeAdapter<T1> typeAdapter) {
        return new C1315b0(cls, typeAdapter);
    }

    /* renamed from: a */
    public static <TT> TypeAdapterFactory m4785a(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new C1350z(cls, cls2, typeAdapter);
    }
}
