package c.d.a.a.e.f;

import android.app.PendingIntent;
import android.os.Bundle;
/* loaded from: classes.dex */
public abstract class i0 extends m0<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    public int f3507d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f3508e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ h0 f3509f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(h0 h0Var, int i2, Bundle bundle) {
        super(h0Var, true);
        this.f3509f = h0Var;
        this.f3507d = i2;
        this.f3508e = bundle;
    }

    public abstract void a(c.d.a.a.e.a aVar);

    @Override // c.d.a.a.e.f.m0
    public final /* synthetic */ void a(Boolean bool) {
        if (bool == null) {
            this.f3509f.a(1, (int) null);
            return;
        }
        int i2 = this.f3507d;
        if (i2 == 0) {
            if (e()) {
                return;
            }
            this.f3509f.a(1, (int) null);
            a(new c.d.a.a.e.a(8, null));
        } else if (i2 == 10) {
            this.f3509f.a(1, (int) null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        } else {
            this.f3509f.a(1, (int) null);
            Bundle bundle = this.f3508e;
            a(new c.d.a.a.e.a(this.f3507d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    @Override // c.d.a.a.e.f.m0
    public final void c() {
    }

    public abstract boolean e();
}
