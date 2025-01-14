package p000a.p006b.p030g.p045k;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: a.b.g.k.g */
/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    /* renamed from: a */
    public static int m9508a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }

    /* renamed from: b */
    public static int m9507b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }
}
