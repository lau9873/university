package p000a.p006b.p030g.p031a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.p065v4.app.Fragment;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000a.p006b.p030g.p044j.Preconditions;

/* renamed from: a.b.g.a.j */
/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: a */
    public final Activity f1126a;

    /* renamed from: b */
    public final Context f1127b;

    /* renamed from: c */
    public final Handler f1128c;

    /* renamed from: d */
    public final LayoutInflater$Factory2C0152l f1129d;

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.f1107b, 0);
    }

    /* renamed from: a */
    public abstract void mo10297a(Fragment fragment);

    /* renamed from: a */
    public abstract void mo10296a(Fragment fragment, Intent intent, int i, Bundle bundle);

    /* renamed from: a */
    public abstract void mo10295a(Fragment fragment, String[] strArr, int i);

    /* renamed from: a */
    public abstract void mo10294a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public Activity m10293b() {
        return this.f1126a;
    }

    /* renamed from: b */
    public abstract boolean mo10292b(Fragment fragment);

    /* renamed from: c */
    public Context m10291c() {
        return this.f1127b;
    }

    /* renamed from: d */
    public LayoutInflater$Factory2C0152l m10290d() {
        return this.f1129d;
    }

    /* renamed from: e */
    public Handler m10289e() {
        return this.f1128c;
    }

    /* renamed from: f */
    public abstract LayoutInflater mo10288f();

    /* renamed from: g */
    public abstract int mo10287g();

    /* renamed from: h */
    public abstract boolean mo10286h();

    /* renamed from: i */
    public abstract void mo10285i();

    public FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f1129d = new LayoutInflater$Factory2C0152l();
        this.f1126a = activity;
        Preconditions.m9620a(context, "context == null");
        this.f1127b = context;
        Preconditions.m9620a(handler, "handler == null");
        this.f1128c = handler;
    }
}
