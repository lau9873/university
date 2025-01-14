package p000a.p006b.p030g.p048l;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p000a.p006b.p030g.p045k.GravityCompat;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.g.l.m */
/* loaded from: classes.dex */
public final class PopupWindowCompat {

    /* renamed from: a */
    public static Method f1833a;

    /* renamed from: b */
    public static boolean f1834b;

    /* renamed from: c */
    public static Field f1835c;

    /* renamed from: d */
    public static boolean f1836d;

    /* renamed from: a */
    public static void m9221a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((GravityCompat.m9579a(i3, ViewCompat.m9422k(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public static void m9220a(PopupWindow popupWindow, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i >= 21) {
            if (!f1836d) {
                try {
                    f1835c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1835c.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                f1836d = true;
            }
            Field field = f1835c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m9222a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f1834b) {
            try {
                f1833a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f1833a.setAccessible(true);
            } catch (Exception unused) {
            }
            f1834b = true;
        }
        Method method = f1833a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }
}
