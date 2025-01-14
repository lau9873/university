package p000a.p006b.p049h.p061j.p062j;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p000a.p006b.p030g.p036d.p037a.SupportMenu;
import p000a.p006b.p030g.p036d.p037a.SupportMenuItem;
import p000a.p006b.p030g.p036d.p037a.SupportSubMenu;

/* renamed from: a.b.h.j.j.r */
/* loaded from: classes.dex */
public final class MenuWrapperFactory {
    /* renamed from: a */
    public static Menu m8592a(Context context, SupportMenu supportMenu) {
        return new MenuWrapperICS(context, supportMenu);
    }

    /* renamed from: a */
    public static MenuItem m8591a(Context context, SupportMenuItem supportMenuItem) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new MenuItemWrapperJB(context, supportMenuItem);
        }
        return new MenuItemWrapperICS(context, supportMenuItem);
    }

    /* renamed from: a */
    public static SubMenu m8590a(Context context, SupportSubMenu supportSubMenu) {
        return new SubMenuWrapperICS(context, supportSubMenu);
    }
}
