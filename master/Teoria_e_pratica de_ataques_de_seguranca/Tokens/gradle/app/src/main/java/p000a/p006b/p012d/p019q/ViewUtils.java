package p000a.p006b.p012d.p019q;

import android.graphics.PorterDuff;
import android.view.View;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.d.q.h */
/* loaded from: classes.dex */
public class ViewUtils {
    /* renamed from: a */
    public static PorterDuff.Mode m10859a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* renamed from: a */
    public static boolean m10858a(View view) {
        return ViewCompat.m9422k(view) == 1;
    }
}
