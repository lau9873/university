package p000a.p006b.p029f;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.f.z */
/* loaded from: classes.dex */
public class ViewGroupUtilsApi18 {

    /* renamed from: a */
    public static Method f1012a;

    /* renamed from: b */
    public static boolean f1013b;

    /* renamed from: a */
    public static void m10418a(ViewGroup viewGroup, boolean z) {
        m10419a();
        Method method = f1012a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    /* renamed from: a */
    public static void m10419a() {
        if (f1013b) {
            return;
        }
        try {
            f1012a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f1012a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        f1013b = true;
    }
}
