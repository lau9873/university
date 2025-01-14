package p000a.p006b.p029f;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: a.b.f.x */
/* loaded from: classes.dex */
public class ViewGroupUtils {
    /* renamed from: a */
    public static ViewGroupOverlayImpl m10423a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.m10428a(viewGroup);
    }

    /* renamed from: a */
    public static void m10422a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.m10418a(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.m10420a(viewGroup, z);
        }
    }
}
