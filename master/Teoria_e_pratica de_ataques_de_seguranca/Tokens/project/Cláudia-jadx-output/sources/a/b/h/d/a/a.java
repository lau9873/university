package a.b.h.d.a;

import a.b.g.b.b;
import a.b.h.k.k;
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
/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f1370a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0037a>> f1371b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1372c = new Object();

    /* compiled from: AppCompatResources.java */
    /* renamed from: a.b.h.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0037a {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f1373a;

        /* renamed from: b  reason: collision with root package name */
        public final Configuration f1374b;

        public C0037a(ColorStateList colorStateList, Configuration configuration) {
            this.f1373a = colorStateList;
            this.f1374b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i2) {
        C0037a c0037a;
        synchronized (f1372c) {
            SparseArray<C0037a> sparseArray = f1371b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0037a = sparseArray.get(i2)) != null) {
                if (c0037a.f1374b.equals(context.getResources().getConfiguration())) {
                    return c0037a.f1373a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList a2 = a(context, i2);
        if (a2 != null) {
            return a2;
        }
        ColorStateList d2 = d(context, i2);
        if (d2 != null) {
            a(context, i2, d2);
            return d2;
        }
        return b.b(context, i2);
    }

    public static Drawable c(Context context, int i2) {
        return k.a().c(context, i2);
    }

    public static ColorStateList d(Context context, int i2) {
        if (e(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return a.b.g.b.g.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    public static boolean e(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        int i3 = a2.type;
        return i3 >= 28 && i3 <= 31;
    }

    public static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f1372c) {
            SparseArray<C0037a> sparseArray = f1371b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f1371b.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0037a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static TypedValue a() {
        TypedValue typedValue = f1370a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f1370a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
