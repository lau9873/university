package a.b.g.k.e0;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: AccessibilityEventCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static void a(AccessibilityEvent accessibilityEvent, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }
}
