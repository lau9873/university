package p000a.p001a.p005b;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.arch.lifecycle.FullLifecycleObserver;
import android.arch.lifecycle.FullLifecycleObserverAdapter;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.ReflectiveGenericLifecycleObserver;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: a.a.b.h */
/* loaded from: classes.dex */
public class Lifecycling {

    /* renamed from: a */
    public static Map<Class, Integer> f44a = new HashMap();

    /* renamed from: b */
    public static Map<Class, List<Constructor<? extends GeneratedAdapter>>> f45b = new HashMap();

    /* renamed from: a */
    public static GenericLifecycleObserver m11279a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m11276b(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = f45b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m11277a(list.get(0), obj));
            }
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
            for (int i = 0; i < list.size(); i++) {
                generatedAdapterArr[i] = m11277a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    /* renamed from: b */
    public static int m11276b(Class<?> cls) {
        if (f44a.containsKey(cls)) {
            return f44a.get(cls).intValue();
        }
        int m11274d = m11274d(cls);
        f44a.put(cls, Integer.valueOf(m11274d));
        return m11274d;
    }

    /* renamed from: c */
    public static boolean m11275c(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* renamed from: d */
    public static int m11274d(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> m11280a = m11280a(cls);
        if (m11280a != null) {
            f45b.put(cls, Collections.singletonList(m11280a));
            return 2;
        } else if (ClassesInfoCache.f20c.m11304c(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m11275c(superclass)) {
                if (m11276b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f45b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (m11275c(cls2)) {
                    if (m11276b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f45b.get(cls2));
                }
            }
            if (arrayList != null) {
                f45b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }

    /* renamed from: a */
    public static GeneratedAdapter m11277a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: a */
    public static Constructor<? extends GeneratedAdapter> m11280a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String m11278a = m11278a(canonicalName);
            if (!name.isEmpty()) {
                m11278a = name + "." + m11278a;
            }
            Constructor declaredConstructor = Class.forName(m11278a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static String m11278a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
