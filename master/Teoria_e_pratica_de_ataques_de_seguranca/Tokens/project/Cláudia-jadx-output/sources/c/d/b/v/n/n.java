package c.d.b.v.n;

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
/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final c.d.b.s<Class> f3859a = new k().a();

    /* renamed from: b  reason: collision with root package name */
    public static final c.d.b.t f3860b = a(Class.class, f3859a);

    /* renamed from: c  reason: collision with root package name */
    public static final c.d.b.s<BitSet> f3861c = new v().a();

    /* renamed from: d  reason: collision with root package name */
    public static final c.d.b.t f3862d = a(BitSet.class, f3861c);

    /* renamed from: e  reason: collision with root package name */
    public static final c.d.b.s<Boolean> f3863e = new d0();

    /* renamed from: f  reason: collision with root package name */
    public static final c.d.b.s<Boolean> f3864f = new e0();

    /* renamed from: g  reason: collision with root package name */
    public static final c.d.b.t f3865g = a(Boolean.TYPE, Boolean.class, f3863e);

    /* renamed from: h  reason: collision with root package name */
    public static final c.d.b.s<Number> f3866h = new f0();

    /* renamed from: i  reason: collision with root package name */
    public static final c.d.b.t f3867i = a(Byte.TYPE, Byte.class, f3866h);
    public static final c.d.b.s<Number> j = new g0();
    public static final c.d.b.t k = a(Short.TYPE, Short.class, j);
    public static final c.d.b.s<Number> l = new h0();
    public static final c.d.b.t m = a(Integer.TYPE, Integer.class, l);
    public static final c.d.b.s<AtomicInteger> n = new i0().a();
    public static final c.d.b.t o = a(AtomicInteger.class, n);
    public static final c.d.b.s<AtomicBoolean> p = new j0().a();
    public static final c.d.b.t q = a(AtomicBoolean.class, p);
    public static final c.d.b.s<AtomicIntegerArray> r = new a().a();
    public static final c.d.b.t s = a(AtomicIntegerArray.class, r);
    public static final c.d.b.s<Number> t = new b();
    public static final c.d.b.s<Number> u = new c();
    public static final c.d.b.s<Number> v = new d();
    public static final c.d.b.s<Number> w = new e();
    public static final c.d.b.t x = a(Number.class, w);
    public static final c.d.b.s<Character> y = new f();
    public static final c.d.b.t z = a(Character.TYPE, Character.class, y);
    public static final c.d.b.s<String> A = new g();
    public static final c.d.b.s<BigDecimal> B = new h();
    public static final c.d.b.s<BigInteger> C = new i();
    public static final c.d.b.t D = a(String.class, A);
    public static final c.d.b.s<StringBuilder> E = new j();
    public static final c.d.b.t F = a(StringBuilder.class, E);
    public static final c.d.b.s<StringBuffer> G = new l();
    public static final c.d.b.t H = a(StringBuffer.class, G);
    public static final c.d.b.s<URL> I = new m();
    public static final c.d.b.t J = a(URL.class, I);
    public static final c.d.b.s<URI> K = new C0067n();
    public static final c.d.b.t L = a(URI.class, K);
    public static final c.d.b.s<InetAddress> M = new o();
    public static final c.d.b.t N = b(InetAddress.class, M);
    public static final c.d.b.s<UUID> O = new p();
    public static final c.d.b.t P = a(UUID.class, O);
    public static final c.d.b.s<Currency> Q = new q().a();
    public static final c.d.b.t R = a(Currency.class, Q);
    public static final c.d.b.t S = new r();
    public static final c.d.b.s<Calendar> T = new s();
    public static final c.d.b.t U = b(Calendar.class, GregorianCalendar.class, T);
    public static final c.d.b.s<Locale> V = new t();
    public static final c.d.b.t W = a(Locale.class, V);
    public static final c.d.b.s<c.d.b.l> X = new u();
    public static final c.d.b.t Y = b(c.d.b.l.class, X);
    public static final c.d.b.t Z = new w();

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class a0 implements c.d.b.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Class f3868a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f3869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.d.b.s f3870c;

        public a0(Class cls, Class cls2, c.d.b.s sVar) {
            this.f3868a = cls;
            this.f3869b = cls2;
            this.f3870c = sVar;
        }

        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f3868a || rawType == this.f3869b) {
                return this.f3870c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f3868a.getName() + "+" + this.f3869b.getName() + ",adapter=" + this.f3870c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class b0 implements c.d.b.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Class f3871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d.b.s f3872b;

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.s<T1> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Class f3873a;

            public a(Class cls) {
                this.f3873a = cls;
            }

            @Override // c.d.b.s
            public void a(c.d.b.x.c cVar, T1 t1) {
                b0.this.f3872b.a(cVar, t1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, T1] */
            @Override // c.d.b.s
            public T1 a(c.d.b.x.a aVar) {
                ?? a2 = b0.this.f3872b.a(aVar);
                if (a2 == 0 || this.f3873a.isInstance(a2)) {
                    return a2;
                }
                throw new JsonSyntaxException("Expected a " + this.f3873a.getName() + " but was " + a2.getClass().getName());
            }
        }

        public b0(Class cls, c.d.b.s sVar) {
            this.f3871a = cls;
            this.f3872b = sVar;
        }

        @Override // c.d.b.t
        public <T2> c.d.b.s<T2> a(c.d.b.f fVar, c.d.b.w.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.f3871a.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f3871a.getName() + ",adapter=" + this.f3872b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3875a = new int[c.d.b.x.b.values().length];

        static {
            try {
                f3875a[c.d.b.x.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3875a[c.d.b.x.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3875a[c.d.b.x.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3875a[c.d.b.x.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3875a[c.d.b.x.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3875a[c.d.b.x.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3875a[c.d.b.x.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3875a[c.d.b.x.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3875a[c.d.b.x.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3875a[c.d.b.x.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class k extends c.d.b.s<Class> {
        @Override // c.d.b.s
        public /* bridge */ /* synthetic */ Class a(c.d.b.x.a aVar) {
            a(aVar);
            throw null;
        }

        @Override // c.d.b.s
        public /* bridge */ /* synthetic */ void a(c.d.b.x.c cVar, Class cls) {
            a2(cVar, cls);
            throw null;
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void a2(c.d.b.x.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Class a(c.d.b.x.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static final class k0<T extends Enum<T>> extends c.d.b.s<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, T> f3876a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<T, String> f3877b = new HashMap();

        public k0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    c.d.b.u.c cVar = (c.d.b.u.c) cls.getField(name).getAnnotation(c.d.b.u.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f3876a.put(str, t);
                        }
                    }
                    this.f3876a.put(name, t);
                    this.f3877b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.d.b.s
        public /* bridge */ /* synthetic */ void a(c.d.b.x.c cVar, Object obj) {
            a(cVar, (c.d.b.x.c) ((Enum) obj));
        }

        @Override // c.d.b.s
        public T a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return this.f3876a.get(aVar.A());
        }

        public void a(c.d.b.x.c cVar, T t) {
            cVar.e(t == null ? null : this.f3877b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class r implements c.d.b.t {
        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new a(this, fVar.a((Class) Date.class));
        }

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.s<Timestamp> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.d.b.s f3878a;

            public a(r rVar, c.d.b.s sVar) {
                this.f3878a = sVar;
            }

            @Override // c.d.b.s
            public Timestamp a(c.d.b.x.a aVar) {
                Date date = (Date) this.f3878a.a(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // c.d.b.s
            public void a(c.d.b.x.c cVar, Timestamp timestamp) {
                this.f3878a.a(cVar, timestamp);
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class w implements c.d.b.t {
        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            Class rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = (Class<? super Object>) rawType.getSuperclass();
            }
            return new k0(rawType);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class x implements c.d.b.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.d.b.w.a f3879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d.b.s f3880b;

        public x(c.d.b.w.a aVar, c.d.b.s sVar) {
            this.f3879a = aVar;
            this.f3880b = sVar;
        }

        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.equals(this.f3879a)) {
                return this.f3880b;
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class y implements c.d.b.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Class f3881a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d.b.s f3882b;

        public y(Class cls, c.d.b.s sVar) {
            this.f3881a = cls;
            this.f3882b = sVar;
        }

        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() == this.f3881a) {
                return this.f3882b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f3881a.getName() + ",adapter=" + this.f3882b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class z implements c.d.b.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Class f3883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f3884b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.d.b.s f3885c;

        public z(Class cls, Class cls2, c.d.b.s sVar) {
            this.f3883a = cls;
            this.f3884b = cls2;
            this.f3885c = sVar;
        }

        @Override // c.d.b.t
        public <T> c.d.b.s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f3883a || rawType == this.f3884b) {
                return this.f3885c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f3884b.getName() + "+" + this.f3883a.getName() + ",adapter=" + this.f3885c + "]";
        }
    }

    public static <TT> c.d.b.t a(c.d.b.w.a<TT> aVar, c.d.b.s<TT> sVar) {
        return new x(aVar, sVar);
    }

    public static <TT> c.d.b.t b(Class<TT> cls, Class<? extends TT> cls2, c.d.b.s<? super TT> sVar) {
        return new a0(cls, cls2, sVar);
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class a extends c.d.b.s<AtomicIntegerArray> {
        @Override // c.d.b.s
        public AtomicIntegerArray a(c.d.b.x.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.j();
            while (aVar.r()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.w()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.o();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.l();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.g(atomicIntegerArray.get(i2));
            }
            cVar.n();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class b extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return Long.valueOf(aVar.x());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class c extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Float.valueOf((float) aVar.v());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class d extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Double.valueOf(aVar.v());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class d0 extends c.d.b.s<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Boolean a(c.d.b.x.a aVar) {
            c.d.b.x.b C = aVar.C();
            if (C == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            } else if (C == c.d.b.x.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.A()));
            } else {
                return Boolean.valueOf(aVar.u());
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Boolean bool) {
            cVar.a(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class e extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            c.d.b.x.b C = aVar.C();
            int i2 = c0.f3875a[C.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new c.d.b.v.g(aVar.A());
            }
            if (i2 == 4) {
                aVar.z();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + C);
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class e0 extends c.d.b.s<Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Boolean a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Boolean.valueOf(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Boolean bool) {
            cVar.e(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class f extends c.d.b.s<Character> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Character a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            String A = aVar.A();
            if (A.length() == 1) {
                return Character.valueOf(A.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + A);
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Character ch) {
            cVar.e(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class f0 extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.w());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class g extends c.d.b.s<String> {
        @Override // c.d.b.s
        public String a(c.d.b.x.a aVar) {
            c.d.b.x.b C = aVar.C();
            if (C == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            } else if (C == c.d.b.x.b.BOOLEAN) {
                return Boolean.toString(aVar.u());
            } else {
                return aVar.A();
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, String str) {
            cVar.e(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class g0 extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.w());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class h extends c.d.b.s<BigDecimal> {
        @Override // c.d.b.s
        public BigDecimal a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return new BigDecimal(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, BigDecimal bigDecimal) {
            cVar.a(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class h0 extends c.d.b.s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return Integer.valueOf(aVar.w());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            cVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class i extends c.d.b.s<BigInteger> {
        @Override // c.d.b.s
        public BigInteger a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                return new BigInteger(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, BigInteger bigInteger) {
            cVar.a(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class i0 extends c.d.b.s<AtomicInteger> {
        @Override // c.d.b.s
        public AtomicInteger a(c.d.b.x.a aVar) {
            try {
                return new AtomicInteger(aVar.w());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, AtomicInteger atomicInteger) {
            cVar.g(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class j extends c.d.b.s<StringBuilder> {
        @Override // c.d.b.s
        public StringBuilder a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return new StringBuilder(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, StringBuilder sb) {
            cVar.e(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class j0 extends c.d.b.s<AtomicBoolean> {
        @Override // c.d.b.s
        public AtomicBoolean a(c.d.b.x.a aVar) {
            return new AtomicBoolean(aVar.u());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, AtomicBoolean atomicBoolean) {
            cVar.d(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class l extends c.d.b.s<StringBuffer> {
        @Override // c.d.b.s
        public StringBuffer a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return new StringBuffer(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, StringBuffer stringBuffer) {
            cVar.e(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class m extends c.d.b.s<URL> {
        @Override // c.d.b.s
        public URL a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            String A = aVar.A();
            if ("null".equals(A)) {
                return null;
            }
            return new URL(A);
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, URL url) {
            cVar.e(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: c.d.b.v.n.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0067n extends c.d.b.s<URI> {
        @Override // c.d.b.s
        public URI a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            try {
                String A = aVar.A();
                if ("null".equals(A)) {
                    return null;
                }
                return new URI(A);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, URI uri) {
            cVar.e(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class o extends c.d.b.s<InetAddress> {
        @Override // c.d.b.s
        public InetAddress a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return InetAddress.getByName(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, InetAddress inetAddress) {
            cVar.e(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class p extends c.d.b.s<UUID> {
        @Override // c.d.b.s
        public UUID a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return UUID.fromString(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, UUID uuid) {
            cVar.e(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class q extends c.d.b.s<Currency> {
        @Override // c.d.b.s
        public Currency a(c.d.b.x.a aVar) {
            return Currency.getInstance(aVar.A());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Currency currency) {
            cVar.e(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class s extends c.d.b.s<Calendar> {
        @Override // c.d.b.s
        public Calendar a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            aVar.k();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.C() != c.d.b.x.b.END_OBJECT) {
                String y = aVar.y();
                int w = aVar.w();
                if ("year".equals(y)) {
                    i2 = w;
                } else if ("month".equals(y)) {
                    i3 = w;
                } else if ("dayOfMonth".equals(y)) {
                    i4 = w;
                } else if ("hourOfDay".equals(y)) {
                    i5 = w;
                } else if ("minute".equals(y)) {
                    i6 = w;
                } else if ("second".equals(y)) {
                    i7 = w;
                }
            }
            aVar.p();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.t();
                return;
            }
            cVar.m();
            cVar.b("year");
            cVar.g(calendar.get(1));
            cVar.b("month");
            cVar.g(calendar.get(2));
            cVar.b("dayOfMonth");
            cVar.g(calendar.get(5));
            cVar.b("hourOfDay");
            cVar.g(calendar.get(11));
            cVar.b("minute");
            cVar.g(calendar.get(12));
            cVar.b("second");
            cVar.g(calendar.get(13));
            cVar.o();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class t extends c.d.b.s<Locale> {
        @Override // c.d.b.s
        public Locale a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.A(), "_");
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

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Locale locale) {
            cVar.e(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class u extends c.d.b.s<c.d.b.l> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public c.d.b.l a(c.d.b.x.a aVar) {
            switch (c0.f3875a[aVar.C().ordinal()]) {
                case 1:
                    return new c.d.b.o(new c.d.b.v.g(aVar.A()));
                case 2:
                    return new c.d.b.o(Boolean.valueOf(aVar.u()));
                case 3:
                    return new c.d.b.o(aVar.A());
                case 4:
                    aVar.z();
                    return c.d.b.m.f3733a;
                case 5:
                    c.d.b.i iVar = new c.d.b.i();
                    aVar.j();
                    while (aVar.r()) {
                        iVar.a(a(aVar));
                    }
                    aVar.o();
                    return iVar;
                case 6:
                    c.d.b.n nVar = new c.d.b.n();
                    aVar.k();
                    while (aVar.r()) {
                        nVar.a(aVar.y(), a(aVar));
                    }
                    aVar.p();
                    return nVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, c.d.b.l lVar) {
            if (lVar != null && !lVar.r()) {
                if (lVar.t()) {
                    c.d.b.o o = lVar.o();
                    if (o.B()) {
                        cVar.a(o.z());
                        return;
                    } else if (o.A()) {
                        cVar.d(o.u());
                        return;
                    } else {
                        cVar.e(o.p());
                        return;
                    }
                } else if (lVar.q()) {
                    cVar.l();
                    Iterator<c.d.b.l> it = lVar.a().iterator();
                    while (it.hasNext()) {
                        a(cVar, it.next());
                    }
                    cVar.n();
                    return;
                } else if (lVar.s()) {
                    cVar.m();
                    for (Map.Entry<String, c.d.b.l> entry : lVar.n().u()) {
                        cVar.b(entry.getKey());
                        a(cVar, entry.getValue());
                    }
                    cVar.o();
                    return;
                } else {
                    throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                }
            }
            cVar.t();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    public static class v extends c.d.b.s<BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
            if (r8.w() != 0) goto L15;
         */
        @Override // c.d.b.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet a(c.d.b.x.a r8) {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.j()
                c.d.b.x.b r1 = r8.C()
                r2 = 0
                r3 = 0
            Le:
                c.d.b.x.b r4 = c.d.b.x.b.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = c.d.b.v.n.n.c0.f3875a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.A()
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
                boolean r5 = r8.u()
                goto L69
            L63:
                int r1 = r8.w()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                c.d.b.x.b r1 = r8.C()
                goto Le
            L75:
                r8.o()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: c.d.b.v.n.n.v.a(c.d.b.x.a):java.util.BitSet");
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, BitSet bitSet) {
            cVar.l();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.g(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.n();
        }
    }

    public static <TT> c.d.b.t a(Class<TT> cls, c.d.b.s<TT> sVar) {
        return new y(cls, sVar);
    }

    public static <T1> c.d.b.t b(Class<T1> cls, c.d.b.s<T1> sVar) {
        return new b0(cls, sVar);
    }

    public static <TT> c.d.b.t a(Class<TT> cls, Class<TT> cls2, c.d.b.s<? super TT> sVar) {
        return new z(cls, cls2, sVar);
    }
}
