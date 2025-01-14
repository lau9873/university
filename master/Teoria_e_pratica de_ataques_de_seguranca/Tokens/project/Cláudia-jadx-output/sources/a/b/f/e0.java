package a.b.f;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
public class e0 extends h0 {

    /* renamed from: a  reason: collision with root package name */
    public static Method f523a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f524b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f525c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f526d;

    @Override // a.b.f.h0
    public void a(View view) {
    }

    @Override // a.b.f.h0
    public void a(View view, float f2) {
        b();
        Method method = f523a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f2));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        view.setAlpha(f2);
    }

    @Override // a.b.f.h0
    public float b(View view) {
        a();
        Method method = f525c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.b(view);
    }

    @Override // a.b.f.h0
    public void c(View view) {
    }

    public final void a() {
        if (f526d) {
            return;
        }
        try {
            f525c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f525c.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
        }
        f526d = true;
    }

    public final void b() {
        if (f524b) {
            return;
        }
        try {
            f523a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f523a.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
        }
        f524b = true;
    }
}
