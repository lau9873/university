package a.a.b;

import a.a.b.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f21c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class, C0002a> f22a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class, Boolean> f23b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f26a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f27b;

        public b(int i2, Method method) {
            this.f26a = i2;
            this.f27b = method;
            this.f27b.setAccessible(true);
        }

        public void a(e eVar, c.a aVar, Object obj) {
            try {
                int i2 = this.f26a;
                if (i2 == 0) {
                    this.f27b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f27b.invoke(obj, eVar);
                } else if (i2 != 2) {
                } else {
                    this.f27b.invoke(obj, eVar, aVar);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f26a == bVar.f26a && this.f27b.getName().equals(bVar.f27b.getName());
        }

        public int hashCode() {
            return (this.f26a * 31) + this.f27b.getName().hashCode();
        }
    }

    public final Method[] a(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    public C0002a b(Class cls) {
        C0002a c0002a = this.f22a.get(cls);
        return c0002a != null ? c0002a : a(cls, null);
    }

    public boolean c(Class cls) {
        if (this.f23b.containsKey(cls)) {
            return this.f23b.get(cls).booleanValue();
        }
        Method[] a2 = a(cls);
        for (Method method : a2) {
            if (((l) method.getAnnotation(l.class)) != null) {
                a(cls, a2);
                return true;
            }
        }
        this.f23b.put(cls, false);
        return false;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<c.a, List<b>> f24a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<b, c.a> f25b;

        public C0002a(Map<b, c.a> map) {
            this.f25b = map;
            for (Map.Entry<b, c.a> entry : map.entrySet()) {
                c.a value = entry.getValue();
                List<b> list = this.f24a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f24a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public void a(e eVar, c.a aVar, Object obj) {
            a(this.f24a.get(aVar), eVar, aVar, obj);
            a(this.f24a.get(c.a.ON_ANY), eVar, aVar, obj);
        }

        public static void a(List<b> list, e eVar, c.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(eVar, aVar, obj);
                }
            }
        }
    }

    public final void a(Map<b, c.a> map, b bVar, c.a aVar, Class cls) {
        c.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f27b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    public final C0002a a(Class cls, Method[] methodArr) {
        int i2;
        C0002a b2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.f25b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, c.a> entry : b(cls2).f25b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = a(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            l lVar = (l) method.getAnnotation(l.class);
            if (lVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (!parameterTypes[0].isAssignableFrom(e.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i2 = 1;
                }
                c.a value = lVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(c.a.class)) {
                        if (value != c.a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i2, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0002a c0002a = new C0002a(hashMap);
        this.f22a.put(cls, c0002a);
        this.f23b.put(cls, Boolean.valueOf(z));
        return c0002a;
    }
}
