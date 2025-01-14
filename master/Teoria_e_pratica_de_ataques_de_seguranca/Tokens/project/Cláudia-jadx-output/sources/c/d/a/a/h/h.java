package c.d.a.a.h;

import android.os.Process;
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f3608a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3609b;

    public h(Runnable runnable, int i2) {
        this.f3608a = runnable;
        this.f3609b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f3609b);
        this.f3608a.run();
    }
}
