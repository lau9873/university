package a.b.g.g;

import android.os.Build;
import android.os.Trace;
/* compiled from: TraceCompat.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
