package c.d.a.a.e.e.l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
/* loaded from: classes.dex */
public final class c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ LifecycleCallback f3273a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3274b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ b1 f3275c;

    public c1(b1 b1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f3275c = b1Var;
        this.f3273a = lifecycleCallback;
        this.f3274b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i2 = this.f3275c.f3270b;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.f3273a;
            bundle = this.f3275c.f3271c;
            if (bundle != null) {
                bundle3 = this.f3275c.f3271c;
                bundle2 = bundle3.getBundle(this.f3274b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.a(bundle2);
        }
        i3 = this.f3275c.f3270b;
        if (i3 >= 2) {
            this.f3273a.d();
        }
        i4 = this.f3275c.f3270b;
        if (i4 >= 3) {
            this.f3273a.c();
        }
        i5 = this.f3275c.f3270b;
        if (i5 >= 4) {
            this.f3273a.e();
        }
        i6 = this.f3275c.f3270b;
        if (i6 >= 5) {
            this.f3273a.b();
        }
    }
}
