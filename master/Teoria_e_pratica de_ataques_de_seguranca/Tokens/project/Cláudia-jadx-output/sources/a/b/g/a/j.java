package a.b.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class j<E> extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f686a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f687b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f688c;

    /* renamed from: d  reason: collision with root package name */
    public final l f689d;

    public j(g gVar) {
        this(gVar, gVar, gVar.f670b, 0);
    }

    public abstract void a(Fragment fragment);

    public abstract void a(Fragment fragment, Intent intent, int i2, Bundle bundle);

    public abstract void a(Fragment fragment, String[] strArr, int i2);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public Activity b() {
        return this.f686a;
    }

    public abstract boolean b(Fragment fragment);

    public Context c() {
        return this.f687b;
    }

    public l d() {
        return this.f689d;
    }

    public Handler e() {
        return this.f688c;
    }

    public abstract LayoutInflater f();

    public abstract int g();

    public abstract boolean h();

    public abstract void i();

    public j(Activity activity, Context context, Handler handler, int i2) {
        this.f689d = new l();
        this.f686a = activity;
        a.b.g.j.m.a(context, "context == null");
        this.f687b = context;
        a.b.g.j.m.a(handler, "handler == null");
        this.f688c = handler;
    }
}
