package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.g.a.g */
/* loaded from: classes.dex */
public final class CallableC1129g implements Callable<Long> {

    /* renamed from: a */
    public /* synthetic */ SharedPreferences f5520a;

    /* renamed from: b */
    public /* synthetic */ String f5521b;

    /* renamed from: c */
    public /* synthetic */ Long f5522c;

    public CallableC1129g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f5520a = sharedPreferences;
        this.f5521b = str;
        this.f5522c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() {
        return Long.valueOf(this.f5520a.getLong(this.f5521b, this.f5522c.longValue()));
    }
}
