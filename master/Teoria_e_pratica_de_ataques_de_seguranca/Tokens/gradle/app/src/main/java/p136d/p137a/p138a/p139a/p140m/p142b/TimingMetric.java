package p136d.p137a.p138a.p139a.p140m.p142b;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: d.a.a.a.m.b.t */
/* loaded from: classes.dex */
public class TimingMetric {

    /* renamed from: a */
    public final String f6504a;

    /* renamed from: b */
    public final String f6505b;

    /* renamed from: c */
    public final boolean f6506c;

    /* renamed from: d */
    public long f6507d;

    /* renamed from: e */
    public long f6508e;

    public TimingMetric(String str, String str2) {
        this.f6504a = str;
        this.f6505b = str2;
        this.f6506c = !Log.isLoggable(str2, 2);
    }

    /* renamed from: a */
    public final void m4006a() {
        String str = this.f6505b;
        Log.v(str, this.f6504a + ": " + this.f6508e + "ms");
    }

    /* renamed from: b */
    public synchronized void m4005b() {
        if (this.f6506c) {
            return;
        }
        this.f6507d = SystemClock.elapsedRealtime();
        this.f6508e = 0L;
    }

    /* renamed from: c */
    public synchronized void m4004c() {
        if (this.f6506c) {
            return;
        }
        if (this.f6508e != 0) {
            return;
        }
        this.f6508e = SystemClock.elapsedRealtime() - this.f6507d;
        m4006a();
    }
}
