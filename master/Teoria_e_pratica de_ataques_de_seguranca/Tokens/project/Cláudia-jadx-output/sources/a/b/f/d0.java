package a.b.f;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f510a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f511b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f512c;

    /* renamed from: d  reason: collision with root package name */
    public static final Property<View, Float> f513d;

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(d0.c(view));
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Float f2) {
            d0.a(view, f2.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return a.b.g.k.u.e(view);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Rect rect) {
            a.b.g.k.u.a(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22) {
            f510a = new g0();
        } else if (i2 >= 21) {
            f510a = new f0();
        } else if (i2 >= 19) {
            f510a = new e0();
        } else {
            f510a = new h0();
        }
        f513d = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    public static void a(View view, float f2) {
        f510a.a(view, f2);
    }

    public static c0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new b0(view);
        }
        return a0.c(view);
    }

    public static float c(View view) {
        return f510a.b(view);
    }

    public static l0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new k0(view);
        }
        return new j0(view.getWindowToken());
    }

    public static void e(View view) {
        f510a.c(view);
    }

    public static void a(View view) {
        f510a.a(view);
    }

    public static void a(View view, int i2) {
        a();
        Field field = f511b;
        if (field != null) {
            try {
                f511b.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    public static void b(View view, Matrix matrix) {
        f510a.b(view, matrix);
    }

    public static void a(View view, Matrix matrix) {
        f510a.a(view, matrix);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f510a.a(view, i2, i3, i4, i5);
    }

    public static void a() {
        if (f512c) {
            return;
        }
        try {
            f511b = View.class.getDeclaredField("mViewFlags");
            f511b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f512c = true;
    }
}
