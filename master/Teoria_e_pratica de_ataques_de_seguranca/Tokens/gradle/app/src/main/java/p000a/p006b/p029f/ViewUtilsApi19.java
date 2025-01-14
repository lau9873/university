package p000a.p006b.p029f;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.f.e0 */
/* loaded from: classes.dex */
public class ViewUtilsApi19 extends ViewUtilsBase {

    /* renamed from: a */
    public static Method f902a;

    /* renamed from: b */
    public static boolean f903b;

    /* renamed from: c */
    public static Method f904c;

    /* renamed from: d */
    public static boolean f905d;

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: a */
    public void mo10522a(View view) {
    }

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: a */
    public void mo10521a(View view, float f) {
        m10528b();
        Method method = f902a;
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: b */
    public float mo10518b(View view) {
        m10529a();
        Method method = f904c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.mo10518b(view);
    }

    @Override // p000a.p006b.p029f.ViewUtilsBase
    /* renamed from: c */
    public void mo10516c(View view) {
    }

    /* renamed from: a */
    public final void m10529a() {
        if (f905d) {
            return;
        }
        try {
            f904c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            f904c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        f905d = true;
    }

    /* renamed from: b */
    public final void m10528b() {
        if (f903b) {
            return;
        }
        try {
            f902a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f902a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        f903b = true;
    }
}
