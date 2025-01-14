package p000a.p006b.p030g.p041g;

import android.os.Build;
import android.os.Trace;

/* renamed from: a.b.g.g.h */
/* loaded from: classes.dex */
public final class TraceCompat {
    /* renamed from: a */
    public static void m9736a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: a */
    public static void m9737a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
