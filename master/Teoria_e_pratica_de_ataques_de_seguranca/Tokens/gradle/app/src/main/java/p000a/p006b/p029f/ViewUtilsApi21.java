package p000a.p006b.p029f;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.f.f0 */
/* loaded from: classes.dex */
public class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: e */
    public static Method f906e;

    /* renamed from: f */
    public static boolean f907f;

    /* renamed from: g */
    public static Method f908g;

    /* renamed from: h */
    public static boolean f909h;

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: a */
    public void mo10519a(View view, Matrix matrix) {
        m10526c();
        Method method = f906e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: b */
    public void mo10517b(View view, Matrix matrix) {
        m10525d();
        Method method = f908g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* renamed from: c */
    public final void m10526c() {
        if (f907f) {
            return;
        }
        try {
            f906e = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f906e.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        f907f = true;
    }

    /* renamed from: d */
    public final void m10525d() {
        if (f909h) {
            return;
        }
        try {
            f908g = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f908g.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        f909h = true;
    }
}
