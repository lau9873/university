package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.g.a.k */
/* loaded from: classes.dex */
public final class CallableC1133k implements Callable<SharedPreferences> {

    /* renamed from: a */
    public /* synthetic */ Context f5527a;

    public CallableC1133k(Context context) {
        this.f5527a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.f5527a.getSharedPreferences("google_sdk_flags", 0);
    }
}
