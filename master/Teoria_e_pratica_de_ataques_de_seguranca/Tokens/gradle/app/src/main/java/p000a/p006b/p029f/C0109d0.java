package p000a.p006b.p029f;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;
import p000a.p006b.p030g.p045k.ViewCompat;

/* compiled from: ViewUtils.java */
/* renamed from: a.b.f.d0 */
/* loaded from: classes.dex */
public class C0109d0 {

    /* renamed from: a */
    public static final ViewUtilsBase f889a;

    /* renamed from: b */
    public static Field f890b;

    /* renamed from: c */
    public static boolean f891c;

    /* renamed from: d */
    public static final Property<View, Float> f892d;

    /* compiled from: ViewUtils.java */
    /* renamed from: a.b.f.d0$a */
    /* loaded from: classes.dex */
    public static class C0110a extends Property<View, Float> {
        public C0110a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(C0109d0.m10537c(view));
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Float f) {
            C0109d0.m10543a(view, f.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* renamed from: a.b.f.d0$b */
    /* loaded from: classes.dex */
    public static class C0111b extends Property<View, Rect> {
        public C0111b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return ViewCompat.m9432e(view);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, Rect rect) {
            ViewCompat.m9448a(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f889a = new ViewUtilsApi22();
        } else if (i >= 21) {
            f889a = new ViewUtilsApi21();
        } else if (i >= 19) {
            f889a = new ViewUtilsApi19();
        } else {
            f889a = new ViewUtilsBase();
        }
        f892d = new C0110a(Float.class, "translationAlpha");
        new C0111b(Rect.class, "clipBounds");
    }

    /* renamed from: a */
    public static void m10543a(View view, float f) {
        f889a.mo10521a(view, f);
    }

    /* renamed from: b */
    public static ViewOverlayImpl m10539b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.m10573c(view);
    }

    /* renamed from: c */
    public static float m10537c(View view) {
        return f889a.mo10518b(view);
    }

    /* renamed from: d */
    public static WindowIdImpl m10536d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new WindowIdApi18(view);
        }
        return new WindowIdApi14(view.getWindowToken());
    }

    /* renamed from: e */
    public static void m10535e(View view) {
        f889a.mo10516c(view);
    }

    /* renamed from: a */
    public static void m10544a(View view) {
        f889a.mo10522a(view);
    }

    /* renamed from: a */
    public static void m10542a(View view, int i) {
        m10545a();
        Field field = f890b;
        if (field != null) {
            try {
                f890b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m10538b(View view, Matrix matrix) {
        f889a.mo10517b(view, matrix);
    }

    /* renamed from: a */
    public static void m10540a(View view, Matrix matrix) {
        f889a.mo10519a(view, matrix);
    }

    /* renamed from: a */
    public static void m10541a(View view, int i, int i2, int i3, int i4) {
        f889a.mo10520a(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m10545a() {
        if (f891c) {
            return;
        }
        try {
            f890b = View.class.getDeclaredField("mViewFlags");
            f890b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f891c = true;
    }
}
