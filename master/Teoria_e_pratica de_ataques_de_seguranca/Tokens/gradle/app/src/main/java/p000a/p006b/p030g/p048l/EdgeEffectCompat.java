package p000a.p006b.p030g.p048l;

import android.os.Build;
import android.widget.EdgeEffect;

/* renamed from: a.b.g.l.i */
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    /* renamed from: a */
    public static void m9232a(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }
}
