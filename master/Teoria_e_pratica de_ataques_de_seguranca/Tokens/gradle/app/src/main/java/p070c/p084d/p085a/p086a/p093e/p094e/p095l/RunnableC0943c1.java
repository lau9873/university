package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: c.d.a.a.e.e.l.c1 */
/* loaded from: classes.dex */
public final class RunnableC0943c1 implements Runnable {

    /* renamed from: a */
    public /* synthetic */ LifecycleCallback f5148a;

    /* renamed from: b */
    public /* synthetic */ String f5149b;

    /* renamed from: c */
    public /* synthetic */ FragmentC0939b1 f5150c;

    public RunnableC0943c1(FragmentC0939b1 fragmentC0939b1, LifecycleCallback lifecycleCallback, String str) {
        this.f5150c = fragmentC0939b1;
        this.f5148a = lifecycleCallback;
        this.f5149b = str;
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
        i = this.f5150c.f5145b;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f5148a;
            bundle = this.f5150c.f5146c;
            if (bundle != null) {
                bundle3 = this.f5150c.f5146c;
                bundle2 = bundle3.getBundle(this.f5149b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.mo4348a(bundle2);
        }
        i2 = this.f5150c.f5145b;
        if (i2 >= 2) {
            this.f5148a.mo4342d();
        }
        i3 = this.f5150c.f5145b;
        if (i3 >= 3) {
            this.f5148a.m4343c();
        }
        i4 = this.f5150c.f5145b;
        if (i4 >= 4) {
            this.f5148a.mo4341e();
        }
        i5 = this.f5150c.f5145b;
        if (i5 >= 5) {
            this.f5148a.m4345b();
        }
    }
}
