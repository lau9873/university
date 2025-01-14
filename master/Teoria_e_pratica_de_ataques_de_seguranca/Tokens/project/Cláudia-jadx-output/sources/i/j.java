package i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import i.c;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f7477a = b();

    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static class a extends j {

        /* compiled from: Platform.java */
        /* renamed from: i.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ExecutorC0173a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f7478a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f7478a.post(runnable);
            }
        }

        @Override // i.j
        public Executor a() {
            return new ExecutorC0173a();
        }

        @Override // i.j
        public c.a a(Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static class b extends j {
        @Override // i.j
        public boolean a(Method method) {
            return method.isDefault();
        }

        @Override // i.j
        public Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    public static j b() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new j();
        }
    }

    public static j c() {
        return f7477a;
    }

    public c.a a(Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.f7426a;
    }

    public Executor a() {
        return null;
    }

    public boolean a(Method method) {
        return false;
    }

    public Object a(Method method, Class<?> cls, Object obj, Object... objArr) {
        throw new UnsupportedOperationException();
    }
}
