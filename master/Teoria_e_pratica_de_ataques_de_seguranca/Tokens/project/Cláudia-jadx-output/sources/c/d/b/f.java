package c.d.b;

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
/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class f {
    public static final c.d.b.w.a<?> k = c.d.b.w.a.get(Object.class);

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal<Map<c.d.b.w.a<?>, C0062f<?>>> f3711a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<c.d.b.w.a<?>, s<?>> f3712b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.b.v.c f3713c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.b.v.n.d f3714d;

    /* renamed from: e  reason: collision with root package name */
    public final List<t> f3715e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3716f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3717g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3718h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3719i;
    public final boolean j;

    public f() {
        this(c.d.b.v.d.f3759g, c.d.b.d.f3704a, Collections.emptyMap(), false, false, false, true, false, false, false, r.f3737a, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public final s<Number> a(boolean z) {
        if (z) {
            return c.d.b.v.n.n.v;
        }
        return new a(this);
    }

    public final s<Number> b(boolean z) {
        if (z) {
            return c.d.b.v.n.n.u;
        }
        return new b(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.f3716f + ",factories:" + this.f3715e + ",instanceCreators:" + this.f3713c + "}";
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class a extends s<Number> {
        public a(f fVar) {
        }

        @Override // c.d.b.s
        /* renamed from: a */
        public Number a2(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Double.valueOf(aVar.v());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            if (number == null) {
                cVar.t();
                return;
            }
            f.a(number.doubleValue());
            cVar.a(number);
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public class b extends s<Number> {
        public b(f fVar) {
        }

        @Override // c.d.b.s
        /* renamed from: a */
        public Number a2(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Float.valueOf((float) aVar.v());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            if (number == null) {
                cVar.t();
                return;
            }
            f.a(number.floatValue());
            cVar.a(number);
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class c extends s<Number> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.d.b.s
        public Number a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return Long.valueOf(aVar.x());
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, Number number) {
            if (number == null) {
                cVar.t();
            } else {
                cVar.e(number.toString());
            }
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class d extends s<AtomicLong> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f3720a;

        public d(s sVar) {
            this.f3720a = sVar;
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, AtomicLong atomicLong) {
            this.f3720a.a(cVar, Long.valueOf(atomicLong.get()));
        }

        @Override // c.d.b.s
        public AtomicLong a(c.d.b.x.a aVar) {
            return new AtomicLong(((Number) this.f3720a.a(aVar)).longValue());
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class e extends s<AtomicLongArray> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f3721a;

        public e(s sVar) {
            this.f3721a = sVar;
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, AtomicLongArray atomicLongArray) {
            cVar.l();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f3721a.a(cVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            cVar.n();
        }

        @Override // c.d.b.s
        public AtomicLongArray a(c.d.b.x.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.j();
            while (aVar.r()) {
                arrayList.add(Long.valueOf(((Number) this.f3721a.a(aVar)).longValue()));
            }
            aVar.o();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: c.d.b.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062f<T> extends s<T> {

        /* renamed from: a  reason: collision with root package name */
        public s<T> f3722a;

        public void a(s<T> sVar) {
            if (this.f3722a == null) {
                this.f3722a = sVar;
                return;
            }
            throw new AssertionError();
        }

        @Override // c.d.b.s
        public T a(c.d.b.x.a aVar) {
            s<T> sVar = this.f3722a;
            if (sVar != null) {
                return sVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, T t) {
            s<T> sVar = this.f3722a;
            if (sVar != null) {
                sVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static s<AtomicLongArray> b(s<Number> sVar) {
        return new e(sVar).a();
    }

    public static s<Number> a(r rVar) {
        if (rVar == r.f3737a) {
            return c.d.b.v.n.n.t;
        }
        return new c();
    }

    public f(c.d.b.v.d dVar, c.d.b.e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, r rVar, String str, int i2, int i3, List<t> list, List<t> list2, List<t> list3) {
        this.f3711a = new ThreadLocal<>();
        this.f3712b = new ConcurrentHashMap();
        this.f3713c = new c.d.b.v.c(map);
        this.f3716f = z;
        this.f3717g = z3;
        this.f3718h = z4;
        this.f3719i = z5;
        this.j = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.d.b.v.n.n.Y);
        arrayList.add(c.d.b.v.n.h.f3821b);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(c.d.b.v.n.n.D);
        arrayList.add(c.d.b.v.n.n.m);
        arrayList.add(c.d.b.v.n.n.f3865g);
        arrayList.add(c.d.b.v.n.n.f3867i);
        arrayList.add(c.d.b.v.n.n.k);
        s<Number> a2 = a(rVar);
        arrayList.add(c.d.b.v.n.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(c.d.b.v.n.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(c.d.b.v.n.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(c.d.b.v.n.n.x);
        arrayList.add(c.d.b.v.n.n.o);
        arrayList.add(c.d.b.v.n.n.q);
        arrayList.add(c.d.b.v.n.n.a(AtomicLong.class, a(a2)));
        arrayList.add(c.d.b.v.n.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(c.d.b.v.n.n.s);
        arrayList.add(c.d.b.v.n.n.z);
        arrayList.add(c.d.b.v.n.n.F);
        arrayList.add(c.d.b.v.n.n.H);
        arrayList.add(c.d.b.v.n.n.a(BigDecimal.class, c.d.b.v.n.n.B));
        arrayList.add(c.d.b.v.n.n.a(BigInteger.class, c.d.b.v.n.n.C));
        arrayList.add(c.d.b.v.n.n.J);
        arrayList.add(c.d.b.v.n.n.L);
        arrayList.add(c.d.b.v.n.n.P);
        arrayList.add(c.d.b.v.n.n.R);
        arrayList.add(c.d.b.v.n.n.W);
        arrayList.add(c.d.b.v.n.n.N);
        arrayList.add(c.d.b.v.n.n.f3862d);
        arrayList.add(c.d.b.v.n.c.f3812b);
        arrayList.add(c.d.b.v.n.n.U);
        arrayList.add(c.d.b.v.n.k.f3842b);
        arrayList.add(c.d.b.v.n.j.f3840b);
        arrayList.add(c.d.b.v.n.n.S);
        arrayList.add(c.d.b.v.n.a.f3806c);
        arrayList.add(c.d.b.v.n.n.f3860b);
        arrayList.add(new c.d.b.v.n.b(this.f3713c));
        arrayList.add(new c.d.b.v.n.g(this.f3713c, z2));
        this.f3714d = new c.d.b.v.n.d(this.f3713c);
        arrayList.add(this.f3714d);
        arrayList.add(c.d.b.v.n.n.Z);
        arrayList.add(new c.d.b.v.n.i(this.f3713c, eVar, dVar, this.f3714d));
        this.f3715e = Collections.unmodifiableList(arrayList);
    }

    public static s<AtomicLong> a(s<Number> sVar) {
        return new d(sVar).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> s<T> a(c.d.b.w.a<T> aVar) {
        s<T> sVar = (s<T>) this.f3712b.get(aVar == null ? k : aVar);
        if (sVar != null) {
            return sVar;
        }
        Map<c.d.b.w.a<?>, C0062f<?>> map = this.f3711a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f3711a.set(map);
            z = true;
        }
        C0062f<?> c0062f = map.get(aVar);
        if (c0062f != null) {
            return c0062f;
        }
        try {
            C0062f<?> c0062f2 = new C0062f<>();
            map.put(aVar, c0062f2);
            for (t tVar : this.f3715e) {
                s sVar2 = (s<T>) tVar.a(this, aVar);
                if (sVar2 != null) {
                    c0062f2.a((s<?>) sVar2);
                    this.f3712b.put(aVar, sVar2);
                    return sVar2;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.f3711a.remove();
            }
        }
    }

    public <T> s<T> a(t tVar, c.d.b.w.a<T> aVar) {
        if (!this.f3715e.contains(tVar)) {
            tVar = this.f3714d;
        }
        boolean z = false;
        for (t tVar2 : this.f3715e) {
            if (z) {
                s<T> a2 = tVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (tVar2 == tVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> s<T> a(Class<T> cls) {
        return a((c.d.b.w.a) c.d.b.w.a.get((Class) cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((l) m.f3733a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(c.d.b.v.l.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void a(Object obj, Type type, c.d.b.x.c cVar) {
        s a2 = a((c.d.b.w.a) c.d.b.w.a.get(type));
        boolean r = cVar.r();
        cVar.b(true);
        boolean q = cVar.q();
        cVar.a(this.f3718h);
        boolean p = cVar.p();
        cVar.c(this.f3716f);
        try {
            try {
                a2.a(cVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            cVar.b(r);
            cVar.a(q);
            cVar.c(p);
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) {
        try {
            a(lVar, a(c.d.b.v.l.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public c.d.b.x.c a(Writer writer) {
        if (this.f3717g) {
            writer.write(")]}'\n");
        }
        c.d.b.x.c cVar = new c.d.b.x.c(writer);
        if (this.f3719i) {
            cVar.c("  ");
        }
        cVar.c(this.f3716f);
        return cVar;
    }

    public c.d.b.x.a a(Reader reader) {
        c.d.b.x.a aVar = new c.d.b.x.a(reader);
        aVar.b(this.j);
        return aVar;
    }

    public void a(l lVar, c.d.b.x.c cVar) {
        boolean r = cVar.r();
        cVar.b(true);
        boolean q = cVar.q();
        cVar.a(this.f3718h);
        boolean p = cVar.p();
        cVar.c(this.f3716f);
        try {
            try {
                c.d.b.v.l.a(lVar, cVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            cVar.b(r);
            cVar.a(q);
            cVar.c(p);
        }
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) c.d.b.v.k.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) {
        c.d.b.x.a a2 = a(reader);
        T t = (T) a(a2, type);
        a(t, a2);
        return t;
    }

    public static void a(Object obj, c.d.b.x.a aVar) {
        if (obj != null) {
            try {
                if (aVar.C() == c.d.b.x.b.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public <T> T a(c.d.b.x.a aVar, Type type) {
        boolean s = aVar.s();
        boolean z = true;
        aVar.b(true);
        try {
            try {
                try {
                    aVar.C();
                    z = false;
                    T a2 = a((c.d.b.w.a) c.d.b.w.a.get(type)).a(aVar);
                    aVar.b(s);
                    return a2;
                } catch (IOException e2) {
                    throw new JsonSyntaxException(e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (z) {
                    aVar.b(s);
                    return null;
                }
                throw new JsonSyntaxException(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            aVar.b(s);
            throw th;
        }
    }
}
