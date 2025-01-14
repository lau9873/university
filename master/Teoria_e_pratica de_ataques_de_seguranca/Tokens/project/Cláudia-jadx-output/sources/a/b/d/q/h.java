package a.b.d.q;

import a.b.g.k.u;
import android.graphics.PorterDuff;
import android.view.View;
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class h {
    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
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

    public static boolean a(View view) {
        return u.k(view) == 1;
    }
}
