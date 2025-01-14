package e.i0.j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: OptionalMethod.java */
/* loaded from: classes.dex */
public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f5837a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5838b;

    /* renamed from: c  reason: collision with root package name */
    public final Class[] f5839c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.f5837a = cls;
        this.f5838b = str;
        this.f5839c = clsArr;
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object c(T t, Object... objArr) {
        try {
            return b(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object a(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
                assertionError.initCause(e2);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f5838b + " not supported for object " + t);
    }

    public final Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f5838b;
        if (str != null) {
            Method a2 = a(cls, str, this.f5839c);
            if (a2 == null || (cls2 = this.f5837a) == null || cls2.isAssignableFrom(a2.getReturnType())) {
                return a2;
            }
            return null;
        }
        return null;
    }

    public static Method a(Class<?> cls, String str, Class[] clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) != 0) {
                return method;
            }
            return null;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }
}
