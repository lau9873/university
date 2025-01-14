package p136d.p137a.p138a.p139a;

import android.util.Log;

/* renamed from: d.a.a.a.b */
/* loaded from: classes.dex */
public class DefaultLogger implements Logger {

    /* renamed from: a */
    public int f6363a;

    public DefaultLogger(int i) {
        this.f6363a = i;
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: a */
    public boolean mo4165a(String str, int i) {
        return this.f6363a <= i;
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: b */
    public void mo4161b(String str, String str2, Throwable th) {
        if (mo4165a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: c */
    public void mo4159c(String str, String str2, Throwable th) {
        if (mo4165a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: d */
    public void m4220d(String str, String str2, Throwable th) {
        if (mo4165a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: e */
    public void m4219e(String str, String str2, Throwable th) {
        if (mo4165a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: a */
    public void mo4163a(String str, String str2, Throwable th) {
        if (mo4165a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public DefaultLogger() {
        this.f6363a = 4;
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: b */
    public void mo4162b(String str, String str2) {
        m4220d(str, str2, null);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: c */
    public void mo4160c(String str, String str2) {
        mo4159c(str, str2, null);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: d */
    public void mo4158d(String str, String str2) {
        m4219e(str, str2, null);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: e */
    public void mo4157e(String str, String str2) {
        mo4163a(str, str2, (Throwable) null);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: a */
    public void mo4164a(String str, String str2) {
        mo4161b(str, str2, null);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: a */
    public void mo4167a(int i, String str, String str2) {
        mo4166a(i, str, str2, false);
    }

    @Override // p136d.p137a.p138a.p139a.Logger
    /* renamed from: a */
    public void mo4166a(int i, String str, String str2, boolean z) {
        if (z || mo4165a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
