package a.b.f;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
public class g0 extends f0 {

    /* renamed from: i  reason: collision with root package name */
    public static Method f531i;
    public static boolean j;

    @Override // a.b.f.h0
    public void a(View view, int i2, int i3, int i4, int i5) {
        e();
        Method method = f531i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void e() {
        if (j) {
            return;
        }
        try {
            f531i = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f531i.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
        }
        j = true;
    }
}
