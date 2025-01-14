package p000a.p006b.p049h.p061j;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import p000a.p006b.p049h.p051b.C0362i;

/* renamed from: a.b.h.j.d */
/* loaded from: classes.dex */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: a */
    public int f2229a;

    /* renamed from: b */
    public Resources.Theme f2230b;

    /* renamed from: c */
    public LayoutInflater f2231c;

    /* renamed from: d */
    public Configuration f2232d;

    /* renamed from: e */
    public Resources f2233e;

    public ContextThemeWrapper() {
        super(null);
    }

    /* renamed from: a */
    public final Resources m8771a() {
        if (this.f2233e == null) {
            Configuration configuration = this.f2232d;
            if (configuration == null) {
                this.f2233e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f2233e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f2233e;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: b */
    public int m8769b() {
        return this.f2229a;
    }

    /* renamed from: c */
    public final void m8768c() {
        boolean z = this.f2230b == null;
        if (z) {
            this.f2230b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2230b.setTo(theme);
            }
        }
        m8770a(this.f2230b, this.f2229a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m8771a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f2231c == null) {
                this.f2231c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f2231c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2230b;
        if (theme != null) {
            return theme;
        }
        if (this.f2229a == 0) {
            this.f2229a = C0362i.Theme_AppCompat_Light;
        }
        m8768c();
        return this.f2230b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f2229a != i) {
            this.f2229a = i;
            m8768c();
        }
    }

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f2229a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f2230b = theme;
    }

    /* renamed from: a */
    public void m8770a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }
}
