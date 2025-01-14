package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.g.a.e */
/* loaded from: classes.dex */
public final class CallableC1127e implements Callable<Integer> {

    /* renamed from: a */
    public /* synthetic */ SharedPreferences f5517a;

    /* renamed from: b */
    public /* synthetic */ String f5518b;

    /* renamed from: c */
    public /* synthetic */ Integer f5519c;

    public CallableC1127e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f5517a = sharedPreferences;
        this.f5518b = str;
        this.f5519c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() {
        return Integer.valueOf(this.f5517a.getInt(this.f5518b, this.f5519c.intValue()));
    }
}
