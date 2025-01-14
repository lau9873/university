package a.a.b;

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
/* compiled from: Lifecycling.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class, Integer> f45a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<Class, List<Constructor<? extends b>>> f46b = new HashMap();

    public static GenericLifecycleObserver a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) == 2) {
            List<Constructor<? extends b>> list = f46b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
            }
            b[] bVarArr = new b[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                bVarArr[i2] = a(list.get(i2), obj);
            }
            return new CompositeGeneratedAdaptersObserver(bVarArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    public static int b(Class<?> cls) {
        if (f45a.containsKey(cls)) {
            return f45a.get(cls).intValue();
        }
        int d2 = d(cls);
        f45a.put(cls, Integer.valueOf(d2));
        return d2;
    }

    public static boolean c(Class<?> cls) {
        return cls != null && d.class.isAssignableFrom(cls);
    }

    public static int d(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends b> a2 = a(cls);
        if (a2 != null) {
            f46b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (a.f21c.c(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (c(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f46b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (c(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f46b.get(cls2));
                }
            }
            if (arrayList != null) {
                f46b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }

    public static b a(Constructor<? extends b> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static Constructor<? extends b> a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor declaredConstructor = Class.forName(a2).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
