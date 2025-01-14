package p220i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import p220i.CallAdapter;

/* compiled from: Platform.java */
/* renamed from: i.j */
/* loaded from: classes.dex */
public class C2627j {

    /* renamed from: a */
    public static final C2627j f10431a = m661b();

    /* compiled from: Platform.java */
    /* renamed from: i.j$a */
    /* loaded from: classes.dex */
    public static class C2628a extends C2627j {

        /* compiled from: Platform.java */
        /* renamed from: i.j$a$a */
        /* loaded from: classes.dex */
        public static class ExecutorC2629a implements Executor {

            /* renamed from: a */
            public final Handler f10432a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f10432a.post(runnable);
            }
        }

        @Override // p220i.C2627j
        /* renamed from: a */
        public Executor mo659a() {
            return new ExecutorC2629a();
        }

        @Override // p220i.C2627j
        /* renamed from: a */
        public CallAdapter.AbstractC2601a mo658a(Executor executor) {
            if (executor != null) {
                return new ExecutorCallAdapterFactory(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform.java */
    /* renamed from: i.j$b */
    /* loaded from: classes.dex */
    public static class C2630b extends C2627j {
        @Override // p220i.C2627j
        /* renamed from: a */
        public boolean mo657a(Method method) {
            return method.isDefault();
        }

        @Override // p220i.C2627j
        /* renamed from: a */
        public Object mo656a(Method method, Class<?> cls, Object obj, Object... objArr) {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    /* renamed from: b */
    public static C2627j m661b() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new C2628a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new C2630b();
        } catch (ClassNotFoundException unused2) {
            return new C2627j();
        }
    }

    /* renamed from: c */
    public static C2627j m660c() {
        return f10431a;
    }

    /* renamed from: a */
    public CallAdapter.AbstractC2601a mo658a(Executor executor) {
        if (executor != null) {
            return new ExecutorCallAdapterFactory(executor);
        }
        return DefaultCallAdapterFactory.f10380a;
    }

    /* renamed from: a */
    public Executor mo659a() {
        return null;
    }

    /* renamed from: a */
    public boolean mo657a(Method method) {
        return false;
    }

    /* renamed from: a */
    public Object mo656a(Method method, Class<?> cls, Object obj, Object... objArr) {
        throw new UnsupportedOperationException();
    }
}
