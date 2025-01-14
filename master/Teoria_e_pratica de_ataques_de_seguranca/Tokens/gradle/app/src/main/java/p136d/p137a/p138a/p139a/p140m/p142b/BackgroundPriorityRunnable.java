package p136d.p137a.p138a.p139a.p140m.p142b;

import android.os.Process;

/* renamed from: d.a.a.a.m.b.h */
/* loaded from: classes.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    /* renamed from: a */
    public abstract void mo4057a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        mo4057a();
    }
}
