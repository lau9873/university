package c.d.a.a.g.a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final class i implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ SharedPreferences f3590a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ String f3591b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ String f3592c;

    public i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f3590a = sharedPreferences;
        this.f3591b = str;
        this.f3592c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.f3590a.getString(this.f3591b, this.f3592c);
    }
}
