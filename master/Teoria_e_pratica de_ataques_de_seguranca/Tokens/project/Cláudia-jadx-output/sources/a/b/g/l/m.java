package a.b.g.l;

import a.b.g.k.u;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: PopupWindowCompat.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Method f1248a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1249b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f1250c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1251d;

    public static void a(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
            return;
        }
        if ((a.b.g.k.d.a(i4, u.k(view)) & 7) == 5) {
            i2 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i2 >= 21) {
            if (!f1251d) {
                try {
                    f1250c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1250c.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1251d = true;
            }
            Field field = f1250c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!f1249b) {
            try {
                f1248a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1248a.setAccessible(true);
            } catch (Exception unused) {
            }
            f1249b = true;
        }
        Method method = f1248a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }
}
