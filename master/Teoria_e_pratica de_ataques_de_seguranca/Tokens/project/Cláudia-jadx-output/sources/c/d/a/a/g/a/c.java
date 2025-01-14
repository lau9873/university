package c.d.a.a.g.a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class c implements Callable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ SharedPreferences f3581a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3582b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ Boolean f3583c;

    public c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f3581a = sharedPreferences;
        this.f3582b = str;
        this.f3583c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        return Boolean.valueOf(this.f3581a.getBoolean(this.f3582b, this.f3583c.booleanValue()));
    }
}
