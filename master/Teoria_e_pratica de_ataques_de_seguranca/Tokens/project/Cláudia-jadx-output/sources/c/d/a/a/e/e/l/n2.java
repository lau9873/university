package c.d.a.a.e.e.l;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class n2 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f3372b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<o2> f3373c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f3374d;

    /* renamed from: e  reason: collision with root package name */
    public final c.d.a.a.e.c f3375e;

    public n2(a1 a1Var) {
        this(a1Var, c.d.a.a.e.c.c());
    }

    public n2(a1 a1Var, c.d.a.a.e.c cVar) {
        super(a1Var);
        this.f3373c = new AtomicReference<>(null);
        this.f3374d = new Handler(Looper.getMainLooper());
        this.f3375e = cVar;
    }

    public static int a(o2 o2Var) {
        if (o2Var == null) {
            return -1;
        }
        return o2Var.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(int i2, int i3, Intent intent) {
        o2 o2Var = this.f3373c.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int a2 = this.f3375e.a(a());
                r1 = a2 == 0;
                if (o2Var == null) {
                    return;
                }
                if (o2Var.b().b() == 18 && a2 == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i3 != -1) {
            if (i3 == 0) {
                o2 o2Var2 = new o2(new c.d.a.a.e.a(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), a(o2Var));
                this.f3373c.set(o2Var2);
                o2Var = o2Var2;
            }
            r1 = false;
        }
        if (r1) {
            g();
        } else if (o2Var != null) {
            a(o2Var.b(), o2Var.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            this.f3373c.set(bundle.getBoolean("resolving_error", false) ? new o2(new c.d.a.a.e.a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public abstract void a(c.d.a.a.e.a aVar, int i2);

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void b(Bundle bundle) {
        super.b(bundle);
        o2 o2Var = this.f3373c.get();
        if (o2Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", o2Var.a());
            bundle.putInt("failed_status", o2Var.b().b());
            bundle.putParcelable("failed_resolution", o2Var.b().d());
        }
    }

    public final void b(c.d.a.a.e.a aVar, int i2) {
        o2 o2Var = new o2(aVar, i2);
        if (this.f3373c.compareAndSet(null, o2Var)) {
            this.f3374d.post(new p2(this, o2Var));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d() {
        super.d();
        this.f3372b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        super.e();
        this.f3372b = false;
    }

    public abstract void f();

    public final void g() {
        this.f3373c.set(null);
        f();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a(new c.d.a.a.e.a(13, null), a(this.f3373c.get()));
        g();
    }
}
