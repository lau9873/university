package p070c.p084d.p105b.p107v;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: c.d.b.v.k */
/* loaded from: classes.dex */
public final class Primitives {

    /* renamed from: a */
    public static final Map<Class<?>, Class<?>> f5749a;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        m4822a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m4822a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m4822a(hashMap, hashMap2, Character.TYPE, Character.class);
        m4822a(hashMap, hashMap2, Double.TYPE, Double.class);
        m4822a(hashMap, hashMap2, Float.TYPE, Float.class);
        m4822a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m4822a(hashMap, hashMap2, Long.TYPE, Long.class);
        m4822a(hashMap, hashMap2, Short.TYPE, Short.class);
        m4822a(hashMap, hashMap2, Void.TYPE, Void.class);
        f5749a = Collections.unmodifiableMap(hashMap);
        Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    public static void m4822a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* renamed from: a */
    public static boolean m4823a(Type type) {
        return f5749a.containsKey(type);
    }

    /* renamed from: a */
    public static <T> Class<T> m4824a(Class<T> cls) {
        Map<Class<?>, Class<?>> map = f5749a;
        C$Gson$Preconditions.m4886a(cls);
        Class<T> cls2 = (Class<T>) map.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
