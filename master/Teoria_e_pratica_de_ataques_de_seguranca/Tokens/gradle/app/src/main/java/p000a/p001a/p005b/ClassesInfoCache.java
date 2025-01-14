package p000a.p001a.p005b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p005b.Lifecycle;

/* renamed from: a.a.b.a */
/* loaded from: classes.dex */
public class ClassesInfoCache {

    /* renamed from: c */
    public static ClassesInfoCache f20c = new ClassesInfoCache();

    /* renamed from: a */
    public final Map<Class, C0009a> f21a = new HashMap();

    /* renamed from: b */
    public final Map<Class, Boolean> f22b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: a.a.b.a$b */
    /* loaded from: classes.dex */
    public static class C0010b {

        /* renamed from: a */
        public final int f25a;

        /* renamed from: b */
        public final Method f26b;

        public C0010b(int i, Method method) {
            this.f25a = i;
            this.f26b = method;
            this.f26b.setAccessible(true);
        }

        /* renamed from: a */
        public void m11301a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a, Object obj) {
            try {
                int i = this.f25a;
                if (i == 0) {
                    this.f26b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f26b.invoke(obj, lifecycleOwner);
                } else if (i != 2) {
                } else {
                    this.f26b.invoke(obj, lifecycleOwner, enumC0011a);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0010b.class != obj.getClass()) {
                return false;
            }
            C0010b c0010b = (C0010b) obj;
            return this.f25a == c0010b.f25a && this.f26b.getName().equals(c0010b.f26b.getName());
        }

        public int hashCode() {
            return (this.f25a * 31) + this.f26b.getName().hashCode();
        }
    }

    /* renamed from: a */
    public final Method[] m11308a(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* renamed from: b */
    public C0009a m11305b(Class cls) {
        C0009a c0009a = this.f21a.get(cls);
        return c0009a != null ? c0009a : m11307a(cls, null);
    }

    /* renamed from: c */
    public boolean m11304c(Class cls) {
        if (this.f22b.containsKey(cls)) {
            return this.f22b.get(cls).booleanValue();
        }
        Method[] m11308a = m11308a(cls);
        for (Method method : m11308a) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                m11307a(cls, m11308a);
                return true;
            }
        }
        this.f22b.put(cls, false);
        return false;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: a.a.b.a$a */
    /* loaded from: classes.dex */
    public static class C0009a {

        /* renamed from: a */
        public final Map<Lifecycle.EnumC0011a, List<C0010b>> f23a = new HashMap();

        /* renamed from: b */
        public final Map<C0010b, Lifecycle.EnumC0011a> f24b;

        public C0009a(Map<C0010b, Lifecycle.EnumC0011a> map) {
            this.f24b = map;
            for (Map.Entry<C0010b, Lifecycle.EnumC0011a> entry : map.entrySet()) {
                Lifecycle.EnumC0011a value = entry.getValue();
                List<C0010b> list = this.f23a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f23a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* renamed from: a */
        public void m11303a(LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a, Object obj) {
            m11302a(this.f23a.get(enumC0011a), lifecycleOwner, enumC0011a, obj);
            m11302a(this.f23a.get(Lifecycle.EnumC0011a.ON_ANY), lifecycleOwner, enumC0011a, obj);
        }

        /* renamed from: a */
        public static void m11302a(List<C0010b> list, LifecycleOwner lifecycleOwner, Lifecycle.EnumC0011a enumC0011a, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m11301a(lifecycleOwner, enumC0011a, obj);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m11306a(Map<C0010b, Lifecycle.EnumC0011a> map, C0010b c0010b, Lifecycle.EnumC0011a enumC0011a, Class cls) {
        Lifecycle.EnumC0011a enumC0011a2 = map.get(c0010b);
        if (enumC0011a2 == null || enumC0011a == enumC0011a2) {
            if (enumC0011a2 == null) {
                map.put(c0010b, enumC0011a);
                return;
            }
            return;
        }
        Method method = c0010b.f26b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0011a2 + ", new value " + enumC0011a);
    }

    /* renamed from: a */
    public final C0009a m11307a(Class cls, Method[] methodArr) {
        int i;
        C0009a m11305b;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (m11305b = m11305b(superclass)) != null) {
            hashMap.putAll(m11305b.f24b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0010b, Lifecycle.EnumC0011a> entry : m11305b(cls2).f24b.entrySet()) {
                m11306a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m11308a(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                Lifecycle.EnumC0011a value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(Lifecycle.EnumC0011a.class)) {
                        if (value != Lifecycle.EnumC0011a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m11306a(hashMap, new C0010b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0009a c0009a = new C0009a(hashMap);
        this.f21a.put(cls, c0009a);
        this.f22b.put(cls, Boolean.valueOf(z));
        return c0009a;
    }
}
