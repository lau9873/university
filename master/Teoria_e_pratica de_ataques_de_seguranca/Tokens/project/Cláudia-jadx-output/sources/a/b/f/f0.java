package a.b.f;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
public class f0 extends e0 {

    /* renamed from: e  reason: collision with root package name */
    public static Method f527e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f528f;

    /* renamed from: g  reason: collision with root package name */
    public static Method f529g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f530h;

    @Override // a.b.f.h0
    public void a(View view, Matrix matrix) {
        c();
        Method method = f527e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // a.b.f.h0
    public void b(View view, Matrix matrix) {
        d();
        Method method = f529g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public final void c() {
        if (f528f) {
            return;
        }
        try {
            f527e = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f527e.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
        }
        f528f = true;
    }

    public final void d() {
        if (f530h) {
            return;
        }
        try {
            f529g = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f529g.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
        }
        f530h = true;
    }
}
