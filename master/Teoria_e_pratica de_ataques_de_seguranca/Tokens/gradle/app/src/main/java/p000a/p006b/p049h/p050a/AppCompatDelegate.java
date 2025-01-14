package p000a.p006b.p049h.p050a;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p067v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.b.h.a.f */
/* loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* renamed from: a */
    public static int f1879a = -1;

    /* renamed from: a */
    public static AppCompatDelegate m9116a(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, activity.getWindow(), appCompatCallback);
    }

    /* renamed from: j */
    public static int m9114j() {
        return f1879a;
    }

    /* renamed from: a */
    public abstract <T extends View> T mo9111a(int i);

    /* renamed from: a */
    public abstract void mo9101a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo9100a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo9099a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo9096a(View view);

    /* renamed from: a */
    public abstract void mo9095a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo9091a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo9112a();

    /* renamed from: b */
    public abstract MenuInflater mo9090b();

    /* renamed from: b */
    public abstract void mo9083b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo9082b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: b */
    public abstract boolean mo9089b(int i);

    /* renamed from: c */
    public abstract ActionBar mo9081c();

    /* renamed from: c */
    public abstract void mo9080c(int i);

    /* renamed from: c */
    public abstract void mo9077c(Bundle bundle);

    /* renamed from: d */
    public abstract void mo9076d();

    /* renamed from: e */
    public abstract void mo9073e();

    /* renamed from: f */
    public abstract void mo9070f();

    /* renamed from: g */
    public abstract void mo9068g();

    /* renamed from: h */
    public abstract void mo9066h();

    /* renamed from: i */
    public abstract void mo9064i();

    /* renamed from: a */
    public static AppCompatDelegate m9115a(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }
}
