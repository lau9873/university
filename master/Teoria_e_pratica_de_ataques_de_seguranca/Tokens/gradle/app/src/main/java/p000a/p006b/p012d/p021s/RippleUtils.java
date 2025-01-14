package p000a.p006b.p012d.p021s;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import p000a.p006b.p030g.p034c.ColorUtils;

/* renamed from: a.b.d.s.a */
/* loaded from: classes.dex */
public class RippleUtils {

    /* renamed from: a */
    public static final boolean f542a;

    /* renamed from: b */
    public static final int[] f543b;

    /* renamed from: c */
    public static final int[] f544c;

    /* renamed from: d */
    public static final int[] f545d;

    /* renamed from: e */
    public static final int[] f546e;

    /* renamed from: f */
    public static final int[] f547f;

    /* renamed from: g */
    public static final int[] f548g;

    /* renamed from: h */
    public static final int[] f549h;

    /* renamed from: i */
    public static final int[] f550i;

    /* renamed from: j */
    public static final int[] f551j;

    static {
        f542a = Build.VERSION.SDK_INT >= 21;
        f543b = new int[]{16842919};
        f544c = new int[]{16843623, 16842908};
        f545d = new int[]{16842908};
        f546e = new int[]{16843623};
        f547f = new int[]{16842913, 16842919};
        f548g = new int[]{16842913, 16843623, 16842908};
        f549h = new int[]{16842913, 16842908};
        f550i = new int[]{16842913, 16843623};
        f551j = new int[]{16842913};
    }

    /* renamed from: a */
    public static ColorStateList m10854a(ColorStateList colorStateList) {
        if (f542a) {
            return new ColorStateList(new int[][]{f551j, StateSet.NOTHING}, new int[]{m10853a(colorStateList, f547f), m10853a(colorStateList, f543b)});
        }
        int[] iArr = f547f;
        int[] iArr2 = f548g;
        int[] iArr3 = f549h;
        int[] iArr4 = f550i;
        int[] iArr5 = f543b;
        int[] iArr6 = f544c;
        int[] iArr7 = f545d;
        int[] iArr8 = f546e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f551j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{m10853a(colorStateList, iArr), m10853a(colorStateList, iArr2), m10853a(colorStateList, iArr3), m10853a(colorStateList, iArr4), 0, m10853a(colorStateList, iArr5), m10853a(colorStateList, iArr6), m10853a(colorStateList, iArr7), m10853a(colorStateList, iArr8), 0});
    }

    /* renamed from: a */
    public static int m10853a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f542a ? m10855a(colorForState) : colorForState;
    }

    @TargetApi(21)
    /* renamed from: a */
    public static int m10855a(int i) {
        return ColorUtils.m9925c(i, Math.min(Color.alpha(i) * 2, 255));
    }
}
