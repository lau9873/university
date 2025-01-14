package c.d.a.a.e.e.l;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;
/* loaded from: classes.dex */
public final class t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ LifecycleCallback f3412a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3413b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ s1 f3414c;

    public t1(s1 s1Var, LifecycleCallback lifecycleCallback, String str) {
        this.f3414c = s1Var;
        this.f3412a = lifecycleCallback;
        this.f3413b = str;
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
        i2 = this.f3414c.a0;
        if (i2 > 0) {
            LifecycleCallback lifecycleCallback = this.f3412a;
            bundle = this.f3414c.b0;
            if (bundle != null) {
                bundle3 = this.f3414c.b0;
                bundle2 = bundle3.getBundle(this.f3413b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.a(bundle2);
        }
        i3 = this.f3414c.a0;
        if (i3 >= 2) {
            this.f3412a.d();
        }
        i4 = this.f3414c.a0;
        if (i4 >= 3) {
            this.f3412a.c();
        }
        i5 = this.f3414c.a0;
        if (i5 >= 4) {
            this.f3412a.e();
        }
        i6 = this.f3414c.a0;
        if (i6 >= 5) {
            this.f3412a.b();
        }
    }
}
