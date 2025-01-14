package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: c.d.a.a.e.e.l.t1 */
/* loaded from: classes.dex */
public final class RunnableC1012t1 implements Runnable {

    /* renamed from: a */
    public /* synthetic */ LifecycleCallback f5321a;

    /* renamed from: b */
    public /* synthetic */ String f5322b;

    /* renamed from: c */
    public /* synthetic */ C1008s1 f5323c;

    public RunnableC1012t1(C1008s1 c1008s1, LifecycleCallback lifecycleCallback, String str) {
        this.f5323c = c1008s1;
        this.f5321a = lifecycleCallback;
        this.f5322b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.f5323c.f5313a0;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f5321a;
            bundle = this.f5323c.f5314b0;
            if (bundle != null) {
                bundle3 = this.f5323c.f5314b0;
                bundle2 = bundle3.getBundle(this.f5322b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.mo4348a(bundle2);
        }
        i2 = this.f5323c.f5313a0;
        if (i2 >= 2) {
            this.f5321a.mo4342d();
        }
        i3 = this.f5323c.f5313a0;
        if (i3 >= 3) {
            this.f5321a.m4343c();
        }
        i4 = this.f5323c.f5313a0;
        if (i4 >= 4) {
            this.f5321a.mo4341e();
        }
        i5 = this.f5323c.f5313a0;
        if (i5 >= 5) {
            this.f5321a.m4345b();
        }
    }
}
