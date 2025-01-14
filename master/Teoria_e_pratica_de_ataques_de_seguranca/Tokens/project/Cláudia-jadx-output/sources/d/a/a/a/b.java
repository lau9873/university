package d.a.a.a;

import android.util.Log;
/* compiled from: DefaultLogger.java */
/* loaded from: classes.dex */
public class b implements k {

    /* renamed from: a  reason: collision with root package name */
    public int f4184a;

    public b(int i2) {
        this.f4184a = i2;
    }

    @Override // d.a.a.a.k
    public boolean a(String str, int i2) {
        return this.f4184a <= i2;
    }

    @Override // d.a.a.a.k
    public void b(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // d.a.a.a.k
    public void c(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    @Override // d.a.a.a.k
    public void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public b() {
        this.f4184a = 4;
    }

    @Override // d.a.a.a.k
    public void b(String str, String str2) {
        d(str, str2, null);
    }

    @Override // d.a.a.a.k
    public void c(String str, String str2) {
        c(str, str2, null);
    }

    @Override // d.a.a.a.k
    public void d(String str, String str2) {
        e(str, str2, null);
    }

    @Override // d.a.a.a.k
    public void e(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    @Override // d.a.a.a.k
    public void a(String str, String str2) {
        b(str, str2, null);
    }

    @Override // d.a.a.a.k
    public void a(int i2, String str, String str2) {
        a(i2, str, str2, false);
    }

    @Override // d.a.a.a.k
    public void a(int i2, String str, String str2, boolean z) {
        if (z || a(str, i2)) {
            Log.println(i2, str, str2);
        }
    }
}
