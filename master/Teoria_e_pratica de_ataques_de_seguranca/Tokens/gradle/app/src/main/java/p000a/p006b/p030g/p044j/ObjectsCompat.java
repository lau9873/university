package p000a.p006b.p030g.p044j;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: a.b.g.j.i */
/* loaded from: classes.dex */
public class ObjectsCompat {
    /* renamed from: a */
    public static boolean m9627a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m9626a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
