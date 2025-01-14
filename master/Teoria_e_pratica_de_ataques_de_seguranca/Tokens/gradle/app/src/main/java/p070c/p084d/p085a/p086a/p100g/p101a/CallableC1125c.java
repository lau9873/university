package p070c.p084d.p085a.p086a.p100g.p101a;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: c.d.a.a.g.a.c */
/* loaded from: classes.dex */
public final class CallableC1125c implements Callable<Boolean> {

    /* renamed from: a */
    public /* synthetic */ SharedPreferences f5514a;

    /* renamed from: b */
    public /* synthetic */ String f5515b;

    /* renamed from: c */
    public /* synthetic */ Boolean f5516c;

    public CallableC1125c(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f5514a = sharedPreferences;
        this.f5515b = str;
        this.f5516c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        return Boolean.valueOf(this.f5514a.getBoolean(this.f5515b, this.f5516c.booleanValue()));
    }
}
