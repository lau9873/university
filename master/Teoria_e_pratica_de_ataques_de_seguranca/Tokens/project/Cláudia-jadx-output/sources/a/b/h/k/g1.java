package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f1731a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f1732b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f1733c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1734d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f1735e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1736f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f1737g;

    static {
        new int[1][0] = 16843518;
        f1734d = new int[]{16842919};
        f1735e = new int[]{16842912};
        new int[1][0] = 16842913;
        f1736f = new int[0];
        f1737g = new int[1];
    }

    public static int a(Context context, int i2) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(f1732b, c2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i2, a2.getFloat());
    }

    public static int b(Context context, int i2) {
        int[] iArr = f1737g;
        iArr[0] = i2;
        l1 a2 = l1.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0, 0);
        } finally {
            a2.a();
        }
    }

    public static ColorStateList c(Context context, int i2) {
        int[] iArr = f1737g;
        iArr[0] = i2;
        l1 a2 = l1.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0);
        } finally {
            a2.a();
        }
    }

    public static TypedValue a() {
        TypedValue typedValue = f1731a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f1731a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static int a(Context context, int i2, float f2) {
        int b2 = b(context, i2);
        return a.b.g.c.a.c(b2, Math.round(Color.alpha(b2) * f2));
    }
}
