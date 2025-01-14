package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.g.a.i */
/* loaded from: classes.dex */
public final class CallableC1131i implements Callable<String> {

    /* renamed from: a */
    public /* synthetic */ SharedPreferences f5523a;

    /* renamed from: b */
    public /* synthetic */ String f5524b;

    /* renamed from: c */
    public /* synthetic */ String f5525c;

    public CallableC1131i(SharedPreferences sharedPreferences, String str, String str2) {
        this.f5523a = sharedPreferences;
        this.f5524b = str;
        this.f5525c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        return this.f5523a.getString(this.f5524b, this.f5525c);
    }
}
