package c.d.b.v;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class m {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    public static class a extends m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f3801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f3802b;

        public a(Method method, Object obj) {
            this.f3801a = method;
            this.f3802b = obj;
        }

        @Override // c.d.b.v.m
        public <T> T a(Class<T> cls) {
            m.b(cls);
            return (T) this.f3801a.invoke(this.f3802b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    public static class b extends m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f3803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3804b;

        public b(Method method, int i2) {
            this.f3803a = method;
            this.f3804b = i2;
        }

        @Override // c.d.b.v.m
        public <T> T a(Class<T> cls) {
            m.b(cls);
            return (T) this.f3803a.invoke(null, cls, Integer.valueOf(this.f3804b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    public static class c extends m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Method f3805a;

        public c(Method method) {
            this.f3805a = method;
        }

        @Override // c.d.b.v.m
        public <T> T a(Class<T> cls) {
            m.b(cls);
            return (T) this.f3805a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    public static class d extends m {
        @Override // c.d.b.v.m
        public <T> T a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static m a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public static void b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public abstract <T> T a(Class<T> cls);
}
