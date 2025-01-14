package g.a.a.n;

import android.os.SystemClock;
/* compiled from: DetectionTracker.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f6097b = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f6098a = 0;

    public static b c() {
        return f6097b;
    }

    public long a() {
        return this.f6098a;
    }

    public void b() {
        this.f6098a = SystemClock.elapsedRealtime();
    }
}
