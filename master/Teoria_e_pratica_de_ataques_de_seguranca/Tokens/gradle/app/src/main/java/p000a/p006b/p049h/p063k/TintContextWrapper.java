package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: a.b.h.k.i1 */
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: c */
    public static final Object f2652c = new Object();

    /* renamed from: d */
    public static ArrayList<WeakReference<TintContextWrapper>> f2653d;

    /* renamed from: a */
    public final Resources f2654a;

    /* renamed from: b */
    public final Resources.Theme f2655b;

    public TintContextWrapper(Context context) {
        super(context);
        if (VectorEnabledTintResources.m8129b()) {
            this.f2654a = new VectorEnabledTintResources(this, context.getResources());
            this.f2655b = this.f2654a.newTheme();
            this.f2655b.setTo(context.getTheme());
            return;
        }
        this.f2654a = new TintResources(this, context.getResources());
        this.f2655b = null;
    }

    /* renamed from: a */
    public static boolean m8343a(Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.m8129b();
    }

    /* renamed from: b */
    public static Context m8342b(Context context) {
        if (m8343a(context)) {
            synchronized (f2652c) {
                if (f2653d == null) {
                    f2653d = new ArrayList<>();
                } else {
                    for (int size = f2653d.size() - 1; size >= 0; size--) {
                        WeakReference<TintContextWrapper> weakReference = f2653d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2653d.remove(size);
                        }
                    }
                    for (int size2 = f2653d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<TintContextWrapper> weakReference2 = f2653d.get(size2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                    }
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                f2653d.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2654a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2654a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2655b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f2655b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
