package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import p000a.p006b.p030g.p034c.ColorUtils;

/* renamed from: a.b.h.k.g1 */
/* loaded from: classes.dex */
public class ThemeUtils {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f2642a = new ThreadLocal<>();

    /* renamed from: b */
    public static final int[] f2643b = {-16842910};

    /* renamed from: c */
    public static final int[] f2644c = {16842908};

    /* renamed from: d */
    public static final int[] f2645d;

    /* renamed from: e */
    public static final int[] f2646e;

    /* renamed from: f */
    public static final int[] f2647f;

    /* renamed from: g */
    public static final int[] f2648g;

    static {
        new int[1][0] = 16843518;
        f2645d = new int[]{16842919};
        f2646e = new int[]{16842912};
        new int[1][0] = 16842913;
        f2647f = new int[0];
        f2648g = new int[1];
    }

    /* renamed from: a */
    public static int m8347a(Context context, int i) {
        ColorStateList m8344c = m8344c(context, i);
        if (m8344c != null && m8344c.isStateful()) {
            return m8344c.getColorForState(f2643b, m8344c.getDefaultColor());
        }
        TypedValue m8348a = m8348a();
        context.getTheme().resolveAttribute(16842803, m8348a, true);
        return m8346a(context, i, m8348a.getFloat());
    }

    /* renamed from: b */
    public static int m8345b(Context context, int i) {
        int[] iArr = f2648g;
        iArr[0] = i;
        TintTypedArray m8258a = TintTypedArray.m8258a(context, (AttributeSet) null, iArr);
        try {
            return m8258a.m8262a(0, 0);
        } finally {
            m8258a.m8265a();
        }
    }

    /* renamed from: c */
    public static ColorStateList m8344c(Context context, int i) {
        int[] iArr = f2648g;
        iArr[0] = i;
        TintTypedArray m8258a = TintTypedArray.m8258a(context, (AttributeSet) null, iArr);
        try {
            return m8258a.m8264a(0);
        } finally {
            m8258a.m8265a();
        }
    }

    /* renamed from: a */
    public static TypedValue m8348a() {
        TypedValue typedValue = f2642a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f2642a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* renamed from: a */
    public static int m8346a(Context context, int i, float f) {
        int m8345b = m8345b(context, i);
        return ColorUtils.m9925c(m8345b, Math.round(Color.alpha(m8345b) * f));
    }
}
