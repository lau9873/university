package d.a.a.a.m.b;

import android.os.SystemClock;
import android.util.Log;
/* compiled from: TimingMetric.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public final String f4305a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4306b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4307c;

    /* renamed from: d  reason: collision with root package name */
    public long f4308d;

    /* renamed from: e  reason: collision with root package name */
    public long f4309e;

    public t(String str, String str2) {
        this.f4305a = str;
        this.f4306b = str2;
        this.f4307c = !Log.isLoggable(str2, 2);
    }

    public final void a() {
        String str = this.f4306b;
        Log.v(str, this.f4305a + ": " + this.f4309e + "ms");
    }

    public synchronized void b() {
        if (this.f4307c) {
            return;
        }
        this.f4308d = SystemClock.elapsedRealtime();
        this.f4309e = 0L;
    }

    public synchronized void c() {
        if (this.f4307c) {
            return;
        }
        if (this.f4309e != 0) {
            return;
        }
        this.f4309e = SystemClock.elapsedRealtime() - this.f4308d;
        a();
    }
}
