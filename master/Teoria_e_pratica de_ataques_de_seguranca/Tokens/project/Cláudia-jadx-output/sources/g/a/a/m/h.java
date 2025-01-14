package g.a.a.m;

import android.util.Log;
/* compiled from: WarningAndroidLogger.java */
/* loaded from: classes.dex */
public final class h extends a {
    @Override // g.a.a.m.e
    public void a(String str, String str2, Object... objArr) {
        Log.w(str, a(str2, objArr));
    }

    @Override // g.a.a.m.e
    public void b(String str, String str2, Object... objArr) {
    }

    @Override // g.a.a.m.e
    public void b(Throwable th, String str, String str2, Object... objArr) {
        Log.e(str, a(str2, objArr), th);
    }

    @Override // g.a.a.m.e
    public void c(String str, String str2, Object... objArr) {
        Log.e(str, a(str2, objArr));
    }

    @Override // g.a.a.m.e
    public void d(String str, String str2, Object... objArr) {
    }

    @Override // g.a.a.m.e
    public void a(Throwable th, String str, String str2, Object... objArr) {
        Log.w(str, a(str2, objArr), th);
    }
}
