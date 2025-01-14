package a.b.g.k;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;
/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public Object f1131a;

    public r(Object obj) {
        this.f1131a = obj;
    }

    public Object a() {
        return this.f1131a;
    }

    public static r a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new r(PointerIcon.getSystemIcon(context, i2));
        }
        return new r(null);
    }
}
