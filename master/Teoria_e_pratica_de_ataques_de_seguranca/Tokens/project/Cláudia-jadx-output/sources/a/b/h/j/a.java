package a.b.h.j;

import a.b.h.b.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f1476a;

    public a(Context context) {
        this.f1476a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public int b() {
        return this.f1476a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int c() {
        Configuration configuration = this.f1476a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 <= 960 || i3 <= 720) {
            if (i2 <= 720 || i3 <= 960) {
                if (i2 < 500) {
                    if (i2 <= 640 || i3 <= 480) {
                        if (i2 <= 480 || i3 <= 640) {
                            return i2 >= 360 ? 3 : 2;
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

    public int d() {
        return this.f1476a.getResources().getDimensionPixelSize(a.b.h.b.d.abc_action_bar_stacked_tab_max_width);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.f1476a.obtainStyledAttributes(null, j.ActionBar, a.b.h.b.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0);
        Resources resources = this.f1476a.getResources();
        if (!f()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.b.h.b.d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.f1476a.getResources().getBoolean(a.b.h.b.b.abc_action_bar_embed_tabs);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f1476a).hasPermanentMenuKey();
    }

    public boolean a() {
        return this.f1476a.getApplicationInfo().targetSdkVersion < 14;
    }
}
