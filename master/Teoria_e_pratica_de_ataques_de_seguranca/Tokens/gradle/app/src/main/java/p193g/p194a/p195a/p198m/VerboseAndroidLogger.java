package p193g.p194a.p195a.p198m;

import android.util.Log;

/* renamed from: g.a.a.m.g */
/* loaded from: classes.dex */
public final class VerboseAndroidLogger extends AbstractAndroidLogger {
    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: a */
    public void mo2425a(String str, String str2, Object... objArr) {
        Log.w(str, m2434a(str2, objArr));
    }

    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: b */
    public void mo2423b(String str, String str2, Object... objArr) {
        Log.d(str, m2434a(str2, objArr));
    }

    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: c */
    public void mo2421c(String str, String str2, Object... objArr) {
        Log.e(str, m2434a(str2, objArr));
    }

    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: d */
    public void mo2420d(String str, String str2, Object... objArr) {
        Log.i(str, m2434a(str2, objArr));
    }

    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: a */
    public void mo2424a(Throwable th, String str, String str2, Object... objArr) {
        Log.w(str, m2434a(str2, objArr), th);
    }

    @Override // p193g.p194a.p195a.p198m.InterfaceC1835e
    /* renamed from: b */
    public void mo2422b(Throwable th, String str, String str2, Object... objArr) {
        Log.e(str, m2434a(str2, objArr), th);
    }
}
