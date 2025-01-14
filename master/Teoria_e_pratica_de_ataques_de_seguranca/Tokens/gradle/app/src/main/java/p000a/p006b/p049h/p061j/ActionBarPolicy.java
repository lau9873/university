package p000a.p006b.p049h.p061j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0355b;
import p000a.p006b.p049h.p051b.C0357d;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.j.a */
/* loaded from: classes.dex */
public class ActionBarPolicy {

    /* renamed from: a */
    public Context f2226a;

    public ActionBarPolicy(Context context) {
        this.f2226a = context;
    }

    /* renamed from: a */
    public static ActionBarPolicy m8781a(Context context) {
        return new ActionBarPolicy(context);
    }

    /* renamed from: b */
    public int m8780b() {
        return this.f2226a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: c */
    public int m8779c() {
        Configuration configuration = this.f2226a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i <= 960 || i2 <= 720) {
            if (i <= 720 || i2 <= 960) {
                if (i < 500) {
                    if (i <= 640 || i2 <= 480) {
                        if (i <= 480 || i2 <= 640) {
                            return i >= 360 ? 3 : 2;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 4;
            }
            return 5;
        }
        return 5;
    }

    /* renamed from: d */
    public int m8778d() {
        return this.f2226a.getResources().getDimensionPixelSize(C0357d.abc_action_bar_stacked_tab_max_width);
    }

    /* renamed from: e */
    public int m8777e() {
        TypedArray obtainStyledAttributes = this.f2226a.obtainStyledAttributes(null, C0363j.ActionBar, C0354a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0363j.ActionBar_height, 0);
        Resources resources = this.f2226a.getResources();
        if (!m8776f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0357d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean m8776f() {
        return this.f2226a.getResources().getBoolean(C0355b.abc_action_bar_embed_tabs);
    }

    /* renamed from: g */
    public boolean m8775g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f2226a).hasPermanentMenuKey();
    }

    /* renamed from: a */
    public boolean m8782a() {
        return this.f2226a.getApplicationInfo().targetSdkVersion < 14;
    }
}
