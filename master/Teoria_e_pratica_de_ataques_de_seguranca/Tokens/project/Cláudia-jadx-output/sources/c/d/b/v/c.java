package c.d.b.v;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Type, c.d.b.h<?>> f3748a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.v.o.b f3749b = c.d.b.v.o.b.a();

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class a implements c.d.b.v.i<T> {
        public a(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // c.d.b.v.i
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class b implements c.d.b.v.i<T> {
        public b(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // c.d.b.v.i
        public T a() {
            return new TreeMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064c implements c.d.b.v.i<T> {
        public C0064c(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // c.d.b.v.i
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class d implements c.d.b.v.i<T> {
        public d(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, c.d.b.v.h] */
        @Override // c.d.b.v.i
        public T a() {
            return new c.d.b.v.h();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class e implements c.d.b.v.i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final c.d.b.v.m f3750a = c.d.b.v.m.a();

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Class f3751b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Type f3752c;

        public e(c cVar, Class cls, Type type) {
            this.f3751b = cls;
            this.f3752c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // c.d.b.v.i
        public T a() {
            try {
                return this.f3750a.a(this.f3751b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f3752c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class f implements c.d.b.v.i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.d.b.h f3753a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f3754b;

        public f(c cVar, c.d.b.h hVar, Type type) {
            this.f3753a = hVar;
            this.f3754b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // c.d.b.v.i
        public T a() {
            return this.f3753a.a(this.f3754b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class g implements c.d.b.v.i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.d.b.h f3755a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Type f3756b;

        public g(c cVar, c.d.b.h hVar, Type type) {
            this.f3755a = hVar;
            this.f3756b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // c.d.b.v.i
        public T a() {
            return this.f3755a.a(this.f3756b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class h implements c.d.b.v.i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Constructor f3757a;

        public h(c cVar, Constructor constructor) {
            this.f3757a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // c.d.b.v.i
        public T a() {
            try {
                return this.f3757a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f3757a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f3757a + " with no args", e4.getTargetException());
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class i implements c.d.b.v.i<T> {
        public i(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // c.d.b.v.i
        public T a() {
            return new TreeSet();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class j implements c.d.b.v.i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Type f3758a;

        public j(c cVar, Type type) {
            this.f3758a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // c.d.b.v.i
        public T a() {
            Type type = this.f3758a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f3758a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f3758a.toString());
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class k implements c.d.b.v.i<T> {
        public k(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // c.d.b.v.i
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class l implements c.d.b.v.i<T> {
        public l(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // c.d.b.v.i
        public T a() {
            return new ArrayDeque();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class m implements c.d.b.v.i<T> {
        public m(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // c.d.b.v.i
        public T a() {
            return new ArrayList();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes.dex */
    public class n implements c.d.b.v.i<T> {
        public n(c cVar) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // c.d.b.v.i
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, c.d.b.h<?>> map) {
        this.f3748a = map;
    }

    public <T> c.d.b.v.i<T> a(c.d.b.w.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        c.d.b.h<?> hVar = this.f3748a.get(type);
        if (hVar != null) {
            return new f(this, hVar, type);
        }
        c.d.b.h<?> hVar2 = this.f3748a.get(rawType);
        if (hVar2 != null) {
            return new g(this, hVar2, type);
        }
        c.d.b.v.i<T> a2 = a(rawType);
        if (a2 != null) {
            return a2;
        }
        c.d.b.v.i<T> a3 = a(type, rawType);
        return a3 != null ? a3 : b(type, rawType);
    }

    public final <T> c.d.b.v.i<T> b(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public String toString() {
        return this.f3748a.toString();
    }

    public final <T> c.d.b.v.i<T> a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f3749b.a(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> c.d.b.v.i<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            return new m(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new b(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(c.d.b.w.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new C0064c(this);
            }
            return new d(this);
        } else {
            return null;
        }
    }
}
