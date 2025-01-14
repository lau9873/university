package p000a.p006b.p030g.p045k;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* renamed from: a.b.g.k.f */
/* loaded from: classes.dex */
public final class LayoutInflaterCompat {

    /* renamed from: a */
    public static Field f1627a;

    /* renamed from: b */
    public static boolean f1628b;

    /* renamed from: a */
    public static void m9512a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f1628b) {
            try {
                f1627a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1627a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1628b = true;
        }
        Field field = f1627a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    /* renamed from: b */
    public static void m9511b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m9512a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m9512a(layoutInflater, factory2);
            }
        }
    }
}
