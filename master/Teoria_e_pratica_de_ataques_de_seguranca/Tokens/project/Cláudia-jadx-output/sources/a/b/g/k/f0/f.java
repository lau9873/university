package a.b.g.k.f0;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public final class f {
    public static Interpolator a(float f2, float f3, float f4, float f5) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new PathInterpolator(f2, f3, f4, f5);
        }
        return new e(f2, f3, f4, f5);
    }
}
