package a.b.d.s;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f288a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f289b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f290c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f291d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f292e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f293f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f294g;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f295h;

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f296i;
    public static final int[] j;

    static {
        f288a = Build.VERSION.SDK_INT >= 21;
        f289b = new int[]{16842919};
        f290c = new int[]{16843623, 16842908};
        f291d = new int[]{16842908};
        f292e = new int[]{16843623};
        f293f = new int[]{16842913, 16842919};
        f294g = new int[]{16842913, 16843623, 16842908};
        f295h = new int[]{16842913, 16842908};
        f296i = new int[]{16842913, 16843623};
        j = new int[]{16842913};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f288a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f293f), a(colorStateList, f289b)});
        }
        int[] iArr = f293f;
        int[] iArr2 = f294g;
        int[] iArr3 = f295h;
        int[] iArr4 = f296i;
        int[] iArr5 = f289b;
        int[] iArr6 = f290c;
        int[] iArr7 = f291d;
        int[] iArr8 = f292e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f288a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    public static int a(int i2) {
        return a.b.g.c.a.c(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
