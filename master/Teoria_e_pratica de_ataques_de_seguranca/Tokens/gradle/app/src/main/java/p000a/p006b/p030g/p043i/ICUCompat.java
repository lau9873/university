package p000a.p006b.p030g.p043i;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: a.b.g.i.a */
/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: a */
    public static Method f1525a;

    /* renamed from: b */
    public static Method f1526b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f1526b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1525a = cls.getMethod("getScript", String.class);
                f1526b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f1525a = null;
            f1526b = null;
            Log.w("ICUCompat", e2);
        }
    }

    /* renamed from: a */
    public static String m9704a(String str) {
        try {
            if (f1525a != null) {
                return (String) f1525a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    /* renamed from: b */
    public static String m9702b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1526b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String m9703a = m9703a(locale);
        if (m9703a != null) {
            return m9704a(m9703a);
        }
        return null;
    }

    /* renamed from: a */
    public static String m9703a(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1526b != null) {
                return (String) f1526b.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }
}
