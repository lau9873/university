package p000a.p006b.p030g.p045k.p046e0;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: a.b.g.k.e0.e */
/* loaded from: classes.dex */
public class AccessibilityRecordCompat {
    /* renamed from: a */
    public static void m9514a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: b */
    public static void m9513b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
