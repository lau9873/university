package p070c.p084d.p105b.p107v;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: c.d.b.v.m */
/* loaded from: classes.dex */
public abstract class UnsafeAllocator {

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: c.d.b.v.m$a */
    /* loaded from: classes.dex */
    public static class C1292a extends UnsafeAllocator {

        /* renamed from: a */
        public final /* synthetic */ Method f5753a;

        /* renamed from: b */
        public final /* synthetic */ Object f5754b;

        public C1292a(Method method, Object obj) {
            this.f5753a = method;
            this.f5754b = obj;
        }

        @Override // p070c.p084d.p105b.p107v.UnsafeAllocator
        /* renamed from: a */
        public <T> T mo4816a(Class<T> cls) {
            UnsafeAllocator.m4817b(cls);
            return (T) this.f5753a.invoke(this.f5754b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: c.d.b.v.m$b */
    /* loaded from: classes.dex */
    public static class C1293b extends UnsafeAllocator {

        /* renamed from: a */
        public final /* synthetic */ Method f5755a;

        /* renamed from: b */
        public final /* synthetic */ int f5756b;

        public C1293b(Method method, int i) {
            this.f5755a = method;
            this.f5756b = i;
        }

        @Override // p070c.p084d.p105b.p107v.UnsafeAllocator
        /* renamed from: a */
        public <T> T mo4816a(Class<T> cls) {
            UnsafeAllocator.m4817b(cls);
            return (T) this.f5755a.invoke(null, cls, Integer.valueOf(this.f5756b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: c.d.b.v.m$c */
    /* loaded from: classes.dex */
    public static class C1294c extends UnsafeAllocator {

        /* renamed from: a */
        public final /* synthetic */ Method f5757a;

        public C1294c(Method method) {
            this.f5757a = method;
        }

        @Override // p070c.p084d.p105b.p107v.UnsafeAllocator
        /* renamed from: a */
        public <T> T mo4816a(Class<T> cls) {
            UnsafeAllocator.m4817b(cls);
            return (T) this.f5757a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: c.d.b.v.m$d */
    /* loaded from: classes.dex */
    public static class C1295d extends UnsafeAllocator {
        @Override // p070c.p084d.p105b.p107v.UnsafeAllocator
        /* renamed from: a */
        public <T> T mo4816a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    /* renamed from: a */
    public static UnsafeAllocator m4818a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C1292a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new C1293b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new C1294c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new C1295d();
            }
        }
    }

    /* renamed from: b */
    public static void m4817b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    /* renamed from: a */
    public abstract <T> T mo4816a(Class<T> cls);
}
