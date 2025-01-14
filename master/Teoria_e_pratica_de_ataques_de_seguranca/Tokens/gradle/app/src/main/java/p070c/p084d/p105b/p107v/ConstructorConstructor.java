package p070c.p084d.p105b.p107v;

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
import p070c.p084d.p105b.InstanceCreator;
import p070c.p084d.p105b.p107v.p110o.ReflectionAccessor;
import p070c.p084d.p105b.p111w.TypeToken;

/* renamed from: c.d.b.v.c */
/* loaded from: classes.dex */
public final class ConstructorConstructor {

    /* renamed from: a */
    public final Map<Type, InstanceCreator<?>> f5700a;

    /* renamed from: b */
    public final ReflectionAccessor f5701b = ReflectionAccessor.m4745a();

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$a */
    /* loaded from: classes.dex */
    public class C1268a implements ObjectConstructor<T> {
        public C1268a(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new ConcurrentHashMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$b */
    /* loaded from: classes.dex */
    public class C1269b implements ObjectConstructor<T> {
        public C1269b(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new TreeMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$c */
    /* loaded from: classes.dex */
    public class C1270c implements ObjectConstructor<T> {
        public C1270c(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new LinkedHashMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$d */
    /* loaded from: classes.dex */
    public class C1271d implements ObjectConstructor<T> {
        public C1271d(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, c.d.b.v.h] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new LinkedTreeMap();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$e */
    /* loaded from: classes.dex */
    public class C1272e implements ObjectConstructor<T> {

        /* renamed from: a */
        public final UnsafeAllocator f5702a = UnsafeAllocator.m4818a();

        /* renamed from: b */
        public final /* synthetic */ Class f5703b;

        /* renamed from: c */
        public final /* synthetic */ Type f5704c;

        public C1272e(ConstructorConstructor constructorConstructor, Class cls, Type type) {
            this.f5703b = cls;
            this.f5704c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            try {
                return this.f5702a.mo4816a(this.f5703b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f5704c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$f */
    /* loaded from: classes.dex */
    public class C1273f implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ InstanceCreator f5705a;

        /* renamed from: b */
        public final /* synthetic */ Type f5706b;

        public C1273f(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.f5705a = instanceCreator;
            this.f5706b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return this.f5705a.m4913a(this.f5706b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$g */
    /* loaded from: classes.dex */
    public class C1274g implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ InstanceCreator f5707a;

        /* renamed from: b */
        public final /* synthetic */ Type f5708b;

        public C1274g(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.f5707a = instanceCreator;
            this.f5708b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return this.f5707a.m4913a(this.f5708b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$h */
    /* loaded from: classes.dex */
    public class C1275h implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ Constructor f5709a;

        public C1275h(ConstructorConstructor constructorConstructor, Constructor constructor) {
            this.f5709a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            try {
                return this.f5709a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.f5709a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.f5709a + " with no args", e3.getTargetException());
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$i */
    /* loaded from: classes.dex */
    public class C1276i implements ObjectConstructor<T> {
        public C1276i(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new TreeSet();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$j */
    /* loaded from: classes.dex */
    public class C1277j implements ObjectConstructor<T> {

        /* renamed from: a */
        public final /* synthetic */ Type f5710a;

        public C1277j(ConstructorConstructor constructorConstructor, Type type) {
            this.f5710a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            Type type = this.f5710a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f5710a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f5710a.toString());
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$k */
    /* loaded from: classes.dex */
    public class C1278k implements ObjectConstructor<T> {
        public C1278k(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new LinkedHashSet();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$l */
    /* loaded from: classes.dex */
    public class C1279l implements ObjectConstructor<T> {
        public C1279l(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new ArrayDeque();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$m */
    /* loaded from: classes.dex */
    public class C1280m implements ObjectConstructor<T> {
        public C1280m(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new ArrayList();
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* renamed from: c.d.b.v.c$n */
    /* loaded from: classes.dex */
    public class C1281n implements ObjectConstructor<T> {
        public C1281n(ConstructorConstructor constructorConstructor) {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // p070c.p084d.p105b.p107v.ObjectConstructor
        /* renamed from: a */
        public T mo4828a() {
            return new ConcurrentSkipListMap();
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.f5700a = map;
    }

    /* renamed from: a */
    public <T> ObjectConstructor<T> m4863a(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.f5700a.get(type);
        if (instanceCreator != null) {
            return new C1273f(this, instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.f5700a.get(rawType);
        if (instanceCreator2 != null) {
            return new C1274g(this, instanceCreator2, type);
        }
        ObjectConstructor<T> m4862a = m4862a(rawType);
        if (m4862a != null) {
            return m4862a;
        }
        ObjectConstructor<T> m4861a = m4861a(type, rawType);
        return m4861a != null ? m4861a : m4860b(type, rawType);
    }

    /* renamed from: b */
    public final <T> ObjectConstructor<T> m4860b(Type type, Class<? super T> cls) {
        return new C1272e(this, cls, type);
    }

    public String toString() {
        return this.f5700a.toString();
    }

    /* renamed from: a */
    public final <T> ObjectConstructor<T> m4862a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f5701b.mo4744a(declaredConstructor);
            }
            return new C1275h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final <T> ObjectConstructor<T> m4861a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C1276i(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new C1277j(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new C1278k(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C1279l(this);
            }
            return new C1280m(this);
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new C1281n(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new C1268a(this);
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C1269b(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new C1270c(this);
            }
            return new C1271d(this);
        } else {
            return null;
        }
    }
}
