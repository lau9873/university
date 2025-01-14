package p000a.p006b.p012d.p013l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p000a.p006b.p030g.p045k.p047f0.FastOutLinearInInterpolator;
import p000a.p006b.p030g.p045k.p047f0.FastOutSlowInInterpolator;
import p000a.p006b.p030g.p045k.p047f0.LinearOutSlowInInterpolator;

/* renamed from: a.b.d.l.a */
/* loaded from: classes.dex */
public class AnimationUtils {

    /* renamed from: a */
    public static final TimeInterpolator f421a = new LinearInterpolator();

    /* renamed from: b */
    public static final TimeInterpolator f422b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f423c = new FastOutLinearInInterpolator();

    /* renamed from: d */
    public static final TimeInterpolator f424d = new LinearOutSlowInInterpolator();

    /* renamed from: e */
    public static final TimeInterpolator f425e = new DecelerateInterpolator();

    /* renamed from: a */
    public static float m10973a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
