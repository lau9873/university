package p000a.p006b.p030g.p045k;

import android.os.Build;
import android.view.ViewGroup;
import p000a.p006b.p007a.C0017b;

/* renamed from: a.b.g.k.w */
/* loaded from: classes.dex */
public final class ViewGroupCompat {
    /* renamed from: a */
    public static boolean m9393a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(C0017b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.m9417p(viewGroup) == null) ? false : true;
    }
}
