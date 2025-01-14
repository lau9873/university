package a.b.f;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ViewGroupUtilsApi18.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static Method f599a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f600b;

    public static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f599a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e3);
            }
        }
    }

    public static void a() {
        if (f600b) {
            return;
        }
        try {
            f599a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f599a.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
        }
        f600b = true;
    }
}
