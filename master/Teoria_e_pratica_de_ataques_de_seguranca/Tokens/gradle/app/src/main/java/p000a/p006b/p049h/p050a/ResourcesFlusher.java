package p000a.p006b.p049h.p050a;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: a.b.h.a.i */
/* loaded from: classes.dex */
public class ResourcesFlusher {

    /* renamed from: a */
    public static Field f1969a;

    /* renamed from: b */
    public static boolean f1970b;

    /* renamed from: c */
    public static Class f1971c;

    /* renamed from: d */
    public static boolean f1972d;

    /* renamed from: e */
    public static Field f1973e;

    /* renamed from: f */
    public static boolean f1974f;

    /* renamed from: g */
    public static Field f1975g;

    /* renamed from: h */
    public static boolean f1976h;

    /* renamed from: a */
    public static void m9024a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            m9020d(resources);
        } else if (i >= 23) {
            m9021c(resources);
        } else if (i >= 21) {
            m9022b(resources);
        }
    }

    /* renamed from: b */
    public static void m9022b(Resources resources) {
        Map map;
        if (!f1970b) {
            try {
                f1969a = Resources.class.getDeclaredField("mDrawableCache");
                f1969a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1970b = true;
        }
        Field field = f1969a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: c */
    public static void m9021c(Resources resources) {
        if (!f1970b) {
            try {
                f1969a = Resources.class.getDeclaredField("mDrawableCache");
                f1969a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1970b = true;
        }
        Object obj = null;
        Field field = f1969a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj == null) {
            return;
        }
        m9023a(obj);
    }

    /* renamed from: d */
    public static void m9020d(Resources resources) {
        Object obj;
        if (!f1976h) {
            try {
                f1975g = Resources.class.getDeclaredField("mResourcesImpl");
                f1975g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1976h = true;
        }
        Field field = f1975g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1970b) {
            try {
                f1969a = obj.getClass().getDeclaredField("mDrawableCache");
                f1969a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f1970b = true;
        }
        Field field2 = f1969a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        if (obj2 != null) {
            m9023a(obj2);
        }
    }

    /* renamed from: a */
    public static void m9023a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1972d) {
            try {
                f1971c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1972d = true;
        }
        Class cls = f1971c;
        if (cls == null) {
            return;
        }
        if (!f1974f) {
            try {
                f1973e = cls.getDeclaredField("mUnthemedEntries");
                f1973e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1974f = true;
        }
        Field field = f1973e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
