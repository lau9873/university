package a.b.h.k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class i1 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1741c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<WeakReference<i1>> f1742d;

    /* renamed from: a  reason: collision with root package name */
    public final Resources f1743a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources.Theme f1744b;

    public i1(Context context) {
        super(context);
        if (q1.b()) {
            this.f1743a = new q1(this, context.getResources());
            this.f1744b = this.f1743a.newTheme();
            this.f1744b.setTo(context.getTheme());
            return;
        }
        this.f1743a = new k1(this, context.getResources());
        this.f1744b = null;
    }

    public static boolean a(Context context) {
        if ((context instanceof i1) || (context.getResources() instanceof k1) || (context.getResources() instanceof q1)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || q1.b();
    }

    public static Context b(Context context) {
        if (a(context)) {
            synchronized (f1741c) {
                if (f1742d == null) {
                    f1742d = new ArrayList<>();
                } else {
                    for (int size = f1742d.size() - 1; size >= 0; size--) {
                        WeakReference<i1> weakReference = f1742d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1742d.remove(size);
                        }
                    }
                    for (int size2 = f1742d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<i1> weakReference2 = f1742d.get(size2);
                        i1 i1Var = weakReference2 != null ? weakReference2.get() : null;
                        if (i1Var != null && i1Var.getBaseContext() == context) {
                            return i1Var;
                        }
                    }
                }
                i1 i1Var2 = new i1(context);
                f1742d.add(new WeakReference<>(i1Var2));
                return i1Var2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1743a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1743a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1744b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f1744b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
