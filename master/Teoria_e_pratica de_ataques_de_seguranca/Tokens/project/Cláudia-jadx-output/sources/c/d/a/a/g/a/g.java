package c.d.a.a.g.a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class g implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ SharedPreferences f3587a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3588b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ Long f3589c;

    public g(SharedPreferences sharedPreferences, String str, Long l) {
        this.f3587a = sharedPreferences;
        this.f3588b = str;
        this.f3589c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() {
        return Long.valueOf(this.f3587a.getLong(this.f3588b, this.f3589c.longValue()));
    }
}
