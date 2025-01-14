package c.b.a.b;

import android.app.Activity;
import android.os.Bundle;
import c.b.a.b.w;
import d.a.a.a.a;
/* compiled from: AnswersLifecycleCallbacks.java */
/* loaded from: classes.dex */
public class g extends a.b {

    /* renamed from: a  reason: collision with root package name */
    public final u f2877a;

    /* renamed from: b  reason: collision with root package name */
    public final j f2878b;

    public g(u uVar, j jVar) {
        this.f2877a = uVar;
        this.f2878b = jVar;
    }

    @Override // d.a.a.a.a.b
    public void a(Activity activity) {
    }

    @Override // d.a.a.a.a.b
    public void a(Activity activity, Bundle bundle) {
    }

    @Override // d.a.a.a.a.b
    public void b(Activity activity) {
        this.f2877a.a(activity, w.c.PAUSE);
        this.f2878b.b();
    }

    @Override // d.a.a.a.a.b
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // d.a.a.a.a.b
    public void c(Activity activity) {
        this.f2877a.a(activity, w.c.RESUME);
        this.f2878b.c();
    }

    @Override // d.a.a.a.a.b
    public void d(Activity activity) {
        this.f2877a.a(activity, w.c.START);
    }

    @Override // d.a.a.a.a.b
    public void e(Activity activity) {
        this.f2877a.a(activity, w.c.STOP);
    }
}
