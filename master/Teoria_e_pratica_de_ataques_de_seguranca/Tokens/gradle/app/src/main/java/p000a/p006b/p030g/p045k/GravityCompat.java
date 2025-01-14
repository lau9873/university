package p000a.p006b.p030g.p045k;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* renamed from: a.b.g.k.d */
/* loaded from: classes.dex */
public final class GravityCompat {
    /* renamed from: a */
    public static void m9578a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i, i2, i3, rect, rect2, i4);
        } else {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    /* renamed from: a */
    public static int m9579a(int i, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : i & (-8388609);
    }
}
