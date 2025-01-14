package p000a.p006b.p030g.p045k.p047f0;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: PathInterpolatorCompat.java */
/* renamed from: a.b.g.k.f0.f */
/* loaded from: classes.dex */
public final class C0286f {
    /* renamed from: a */
    public static Interpolator m9509a(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f, f2, f3, f4);
        }
        return new PathInterpolatorApi14(f, f2, f3, f4);
    }
}
