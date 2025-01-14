package c.d.a.a.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class k implements Callable<SharedPreferences> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f3594a;

    public k(Context context) {
        this.f3594a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() {
        return this.f3594a.getSharedPreferences("google_sdk_flags", 0);
    }
}
