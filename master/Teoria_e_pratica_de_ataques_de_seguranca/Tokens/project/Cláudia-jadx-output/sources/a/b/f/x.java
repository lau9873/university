package a.b.f;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
public class x {
    public static w a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new v(viewGroup);
        }
        return u.a(viewGroup);
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            z.a(viewGroup, z);
        } else {
            y.a(viewGroup, z);
        }
    }
}
