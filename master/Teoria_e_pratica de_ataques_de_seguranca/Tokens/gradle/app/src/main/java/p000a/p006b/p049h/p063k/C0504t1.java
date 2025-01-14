package p000a.p006b.p049h.p063k;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000a.p006b.p030g.p045k.ViewCompat;

/* compiled from: ViewUtils.java */
/* renamed from: a.b.h.k.t1 */
/* loaded from: classes.dex */
public class C0504t1 {

    /* renamed from: a */
    public static Method f2960a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f2960a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (f2960a.isAccessible()) {
                    return;
                }
                f2960a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* renamed from: a */
    public static boolean m8047a(View view) {
        return ViewCompat.m9422k(view) == 1;
    }

    /* renamed from: b */
    public static void m8045b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            }
        }
    }

    /* renamed from: a */
    public static void m8046a(View view, Rect rect, Rect rect2) {
        Method method = f2960a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }
}
