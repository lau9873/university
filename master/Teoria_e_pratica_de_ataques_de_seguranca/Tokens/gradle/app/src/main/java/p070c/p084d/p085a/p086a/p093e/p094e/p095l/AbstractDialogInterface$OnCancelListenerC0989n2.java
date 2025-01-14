package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;

/* renamed from: c.d.a.a.e.e.l.n2 */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterface$OnCancelListenerC0989n2 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b */
    public volatile boolean f5277b;

    /* renamed from: c */
    public final AtomicReference<C0993o2> f5278c;

    /* renamed from: d */
    public final Handler f5279d;

    /* renamed from: e */
    public final C0902c f5280e;

    public AbstractDialogInterface$OnCancelListenerC0989n2(InterfaceC0935a1 interfaceC0935a1) {
        this(interfaceC0935a1, C0902c.m5627c());
    }

    public AbstractDialogInterface$OnCancelListenerC0989n2(InterfaceC0935a1 interfaceC0935a1, C0902c c0902c) {
        super(interfaceC0935a1);
        this.f5278c = new AtomicReference<>(null);
        this.f5279d = new Handler(Looper.getMainLooper());
        this.f5280e = c0902c;
    }

    /* renamed from: a */
    public static int m5397a(C0993o2 c0993o2) {
        if (c0993o2 == null) {
            return -1;
        }
        return c0993o2.m5393a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: a */
    public final void mo4350a(int i, int i2, Intent intent) {
        C0993o2 c0993o2 = this.f5278c.get();
        if (i != 1) {
            if (i == 2) {
                int mo5123a = this.f5280e.mo5123a(m4351a());
                r1 = mo5123a == 0;
                if (c0993o2 == null) {
                    return;
                }
                if (c0993o2.m5392b().m5645b() == 18 && mo5123a == 18) {
                    return;
                }
            }
            r1 = false;
        } else if (i2 != -1) {
            if (i2 == 0) {
                C0993o2 c0993o22 = new C0993o2(new C0900a(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), m5397a(c0993o2));
                this.f5278c.set(c0993o22);
                c0993o2 = c0993o22;
            }
            r1 = false;
        }
        if (r1) {
            m5394g();
        } else if (c0993o2 != null) {
            mo5398a(c0993o2.m5392b(), c0993o2.m5393a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: a */
    public final void mo4348a(Bundle bundle) {
        super.mo4348a(bundle);
        if (bundle != null) {
            this.f5278c.set(bundle.getBoolean("resolving_error", false) ? new C0993o2(new C0900a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    /* renamed from: a */
    public abstract void mo5398a(C0900a c0900a, int i);

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: b */
    public final void mo4344b(Bundle bundle) {
        super.mo4344b(bundle);
        C0993o2 c0993o2 = this.f5278c.get();
        if (c0993o2 != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", c0993o2.m5393a());
            bundle.putInt("failed_status", c0993o2.m5392b().m5645b());
            bundle.putParcelable("failed_resolution", c0993o2.m5392b().m5643d());
        }
    }

    /* renamed from: b */
    public final void m5396b(C0900a c0900a, int i) {
        C0993o2 c0993o2 = new C0993o2(c0900a, i);
        if (this.f5278c.compareAndSet(null, c0993o2)) {
            this.f5279d.post(new RunnableC0997p2(this, c0993o2));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: d */
    public void mo4342d() {
        super.mo4342d();
        this.f5277b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: e */
    public void mo4341e() {
        super.mo4341e();
        this.f5277b = false;
    }

    /* renamed from: f */
    public abstract void mo5395f();

    /* renamed from: g */
    public final void m5394g() {
        this.f5278c.set(null);
        mo5395f();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        mo5398a(new C0900a(13, null), m5397a(this.f5278c.get()));
        m5394g();
    }
}
