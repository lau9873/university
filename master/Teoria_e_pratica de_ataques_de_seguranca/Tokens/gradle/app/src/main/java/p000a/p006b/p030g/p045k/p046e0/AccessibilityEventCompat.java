package p000a.p006b.p030g.p045k.p046e0;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: a.b.g.k.e0.a */
/* loaded from: classes.dex */
public final class AccessibilityEventCompat {
    /* renamed from: a */
    public static void m9562a(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    /* renamed from: a */
    public static int m9563a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
