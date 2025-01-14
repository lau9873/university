package p181e.p182i0.p188j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: e.i0.j.d */
/* loaded from: classes.dex */
public class OptionalMethod<T> {

    /* renamed from: a */
    public final Class<?> f8245a;

    /* renamed from: b */
    public final String f8246b;

    /* renamed from: c */
    public final Class[] f8247c;

    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f8245a = cls;
        this.f8246b = str;
        this.f8247c = clsArr;
    }

    /* renamed from: a */
    public boolean m2867a(T t) {
        return m2869a(t.getClass()) != null;
    }

    /* renamed from: b */
    public Object m2865b(T t, Object... objArr) {
        Method m2869a = m2869a(t.getClass());
        if (m2869a == null) {
            return null;
        }
        try {
            return m2869a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public Object m2864c(T t, Object... objArr) {
        try {
            return m2865b(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m2863d(T t, Object... objArr) {
        try {
            return m2866a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    public Object m2866a(T t, Object... objArr) {
        Method m2869a = m2869a(t.getClass());
        if (m2869a != null) {
            try {
                return m2869a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + m2869a);
                assertionError.initCause(e);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f8246b + " not supported for object " + t);
    }

    /* renamed from: a */
    public final Method m2869a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f8246b;
        if (str != null) {
            Method m2868a = m2868a(cls, str, this.f8247c);
            if (m2868a == null || (cls2 = this.f8245a) == null || cls2.isAssignableFrom(m2868a.getReturnType())) {
                return m2868a;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public static Method m2868a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
