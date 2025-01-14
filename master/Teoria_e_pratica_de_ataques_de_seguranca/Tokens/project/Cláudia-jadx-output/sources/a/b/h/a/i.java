package a.b.h.a;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;
/* compiled from: ResourcesFlusher.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static Field f1317a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1318b;

    /* renamed from: c  reason: collision with root package name */
    public static Class f1319c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1320d;

    /* renamed from: e  reason: collision with root package name */
    public static Field f1321e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f1322f;

    /* renamed from: g  reason: collision with root package name */
    public static Field f1323g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f1324h;

    public static void a(Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else if (i2 >= 21) {
            b(resources);
        }
    }

    public static void b(Resources resources) {
        Map map;
        if (!f1318b) {
            try {
                f1317a = Resources.class.getDeclaredField("mDrawableCache");
                f1317a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f1318b = true;
        }
        Field field = f1317a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void c(Resources resources) {
        if (!f1318b) {
            try {
                f1317a = Resources.class.getDeclaredField("mDrawableCache");
                f1317a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f1318b = true;
        }
        Object obj = null;
        Field field = f1317a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        a(obj);
    }

    public static void d(Resources resources) {
        Object obj;
        if (!f1324h) {
            try {
                f1323g = Resources.class.getDeclaredField("mResourcesImpl");
                f1323g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f1324h = true;
        }
        Field field = f1323g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1318b) {
            try {
                f1317a = obj.getClass().getDeclaredField("mDrawableCache");
                f1317a.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f1318b = true;
        }
        Field field2 = f1317a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            a(obj2);
        }
    }

    public static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1320d) {
            try {
                f1319c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f1320d = true;
        }
        Class cls = f1319c;
        if (cls == null) {
            return;
        }
        if (!f1322f) {
            try {
                f1321e = cls.getDeclaredField("mUnthemedEntries");
                f1321e.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f1322f = true;
        }
        Field field = f1321e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
