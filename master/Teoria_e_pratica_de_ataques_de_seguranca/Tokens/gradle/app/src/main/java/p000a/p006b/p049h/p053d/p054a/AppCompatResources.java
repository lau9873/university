package p000a.p006b.p049h.p053d.p054a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p032b.p033g.ColorStateListInflaterCompat;
import p000a.p006b.p049h.p063k.AppCompatDrawableManager;

/* renamed from: a.b.h.d.a.a */
/* loaded from: classes.dex */
public final class AppCompatResources {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f2043a = new ThreadLocal<>();

    /* renamed from: b */
    public static final WeakHashMap<Context, SparseArray<C0369a>> f2044b = new WeakHashMap<>(0);

    /* renamed from: c */
    public static final Object f2045c = new Object();

    /* compiled from: AppCompatResources.java */
    /* renamed from: a.b.h.d.a.a$a */
    /* loaded from: classes.dex */
    public static class C0369a {

        /* renamed from: a */
        public final ColorStateList f2046a;

        /* renamed from: b */
        public final Configuration f2047b;

        public C0369a(ColorStateList colorStateList, Configuration configuration) {
            this.f2046a = colorStateList;
            this.f2047b = configuration;
        }
    }

    /* renamed from: a */
    public static ColorStateList m8970a(Context context, int i) {
        C0369a c0369a;
        synchronized (f2045c) {
            SparseArray<C0369a> sparseArray = f2044b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0369a = sparseArray.get(i)) != null) {
                if (c0369a.f2047b.equals(context.getResources().getConfiguration())) {
                    return c0369a.f2046a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* renamed from: b */
    public static ColorStateList m8968b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList m8970a = m8970a(context, i);
        if (m8970a != null) {
            return m8970a;
        }
        ColorStateList m8966d = m8966d(context, i);
        if (m8966d != null) {
            m8969a(context, i, m8966d);
            return m8966d;
        }
        return ContextCompat.m10018b(context, i);
    }

    /* renamed from: c */
    public static Drawable m8967c(Context context, int i) {
        return AppCompatDrawableManager.m8318a().m8295c(context, i);
    }

    /* renamed from: d */
    public static ColorStateList m8966d(Context context, int i) {
        if (m8965e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return ColorStateListInflaterCompat.m9992a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* renamed from: e */
    public static boolean m8965e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue m8971a = m8971a();
        resources.getValue(i, m8971a, true);
        int i2 = m8971a.type;
        return i2 >= 28 && i2 <= 31;
    }

    /* renamed from: a */
    public static void m8969a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f2045c) {
            SparseArray<C0369a> sparseArray = f2044b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f2044b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0369a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: a */
    public static TypedValue m8971a() {
        TypedValue typedValue = f2043a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f2043a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
