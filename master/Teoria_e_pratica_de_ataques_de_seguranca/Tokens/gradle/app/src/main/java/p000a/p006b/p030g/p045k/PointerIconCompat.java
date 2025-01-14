package p000a.p006b.p030g.p045k;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* renamed from: a.b.g.k.r */
/* loaded from: classes.dex */
public final class PointerIconCompat {

    /* renamed from: a */
    public Object f1642a;

    public PointerIconCompat(Object obj) {
        this.f1642a = obj;
    }

    /* renamed from: a */
    public Object m9466a() {
        return this.f1642a;
    }

    /* renamed from: a */
    public static PointerIconCompat m9465a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(PointerIcon.getSystemIcon(context, i));
        }
        return new PointerIconCompat(null);
    }
}
