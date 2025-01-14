package a.b.h.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f1275a = -1;

    public static f a(Activity activity, e eVar) {
        return new g(activity, activity.getWindow(), eVar);
    }

    public static int j() {
        return f1275a;
    }

    public abstract <T extends View> T a(int i2);

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(Toolbar toolbar);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a();

    public abstract MenuInflater b();

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b(int i2);

    public abstract a c();

    public abstract void c(int i2);

    public abstract void c(Bundle bundle);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public static f a(Dialog dialog, e eVar) {
        return new g(dialog.getContext(), dialog.getWindow(), eVar);
    }
}
