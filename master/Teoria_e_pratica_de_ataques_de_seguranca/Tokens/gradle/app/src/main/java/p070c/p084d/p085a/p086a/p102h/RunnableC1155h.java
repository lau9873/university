package p070c.p084d.p085a.p086a.p102h;

import android.os.Process;

/* renamed from: c.d.a.a.h.h */
/* loaded from: classes.dex */
public final class RunnableC1155h implements Runnable {

    /* renamed from: a */
    public final Runnable f5541a;

    /* renamed from: b */
    public final int f5542b;

    public RunnableC1155h(Runnable runnable, int i) {
        this.f5541a = runnable;
        this.f5542b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f5542b);
        this.f5541a.run();
    }
}
