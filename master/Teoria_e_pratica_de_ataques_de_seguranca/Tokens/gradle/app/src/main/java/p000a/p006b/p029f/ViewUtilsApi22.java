package p000a.p006b.p029f;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.f.g0 */
/* loaded from: classes.dex */
public class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: i */
    public static Method f910i;

    /* renamed from: j */
    public static boolean f911j;

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: a */
    public void mo10520a(View view, int i, int i2, int i3, int i4) {
        m10524e();
        Method method = f910i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: e */
    public final void m10524e() {
        if (f911j) {
            return;
        }
        try {
            f910i = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f910i.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
        }
        f911j = true;
    }
}
