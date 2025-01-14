package c.d.a.a.g.a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class e implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ SharedPreferences f3584a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3585b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ Integer f3586c;

    public e(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f3584a = sharedPreferences;
        this.f3585b = str;
        this.f3586c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() {
        return Integer.valueOf(this.f3584a.getInt(this.f3585b, this.f3586c.intValue()));
    }
}
