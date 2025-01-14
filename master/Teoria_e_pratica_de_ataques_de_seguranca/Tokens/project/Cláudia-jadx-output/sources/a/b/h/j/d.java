package a.b.h.j;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public int f1479a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f1480b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f1481c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f1482d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f1483e;

    public d() {
        super(null);
    }

    public final Resources a() {
        if (this.f1483e == null) {
            Configuration configuration = this.f1482d;
            if (configuration == null) {
                this.f1483e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f1483e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f1483e;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f1479a;
    }

    public final void c() {
        boolean z = this.f1480b == null;
        if (z) {
            this.f1480b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1480b.setTo(theme);
            }
        }
        a(this.f1480b, this.f1479a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f1481c == null) {
                this.f1481c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f1481c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1480b;
        if (theme != null) {
            return theme;
        }
        if (this.f1479a == 0) {
            this.f1479a = a.b.h.b.i.Theme_AppCompat_Light;
        }
        c();
        return this.f1480b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.f1479a != i2) {
            this.f1479a = i2;
            c();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f1479a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1480b = theme;
    }

    public void a(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }
}
