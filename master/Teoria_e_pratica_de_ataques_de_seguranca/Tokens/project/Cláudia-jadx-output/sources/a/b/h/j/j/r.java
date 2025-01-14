package a.b.h.j.j;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: MenuWrapperFactory.java */
/* loaded from: classes.dex */
public final class r {
    public static Menu a(Context context, a.b.g.d.a.a aVar) {
        return new s(context, aVar);
    }

    public static MenuItem a(Context context, a.b.g.d.a.b bVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new m(context, bVar);
        }
        return new l(context, bVar);
    }

    public static SubMenu a(Context context, a.b.g.d.a.c cVar) {
        return new w(context, cVar);
    }
}
