package a.b.g.i;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f1015a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f1016b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f1016b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1015a = cls.getMethod("getScript", String.class);
                f1016b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            f1015a = null;
            f1016b = null;
            Log.w("ICUCompat", e3);
        }
    }

    public static String a(String str) {
        try {
            if (f1015a != null) {
                return (String) f1015a.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return null;
    }

    public static String b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1016b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            } catch (InvocationTargetException e3) {
                Log.w("ICUCompat", e3);
                return locale.getScript();
            }
        }
        String a2 = a(locale);
        if (a2 != null) {
            return a(a2);
        }
        return null;
    }

    public static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1016b != null) {
                return (String) f1016b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompat", e2);
        } catch (InvocationTargetException e3) {
            Log.w("ICUCompat", e3);
        }
        return locale2;
    }
}
