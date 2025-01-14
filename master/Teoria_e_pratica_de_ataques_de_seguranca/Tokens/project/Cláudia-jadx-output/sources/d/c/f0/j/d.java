package d.c.f0.j;
/* compiled from: BlockingHelper.java */
/* loaded from: classes.dex */
public final class d {
    public static void a() {
        if (d.c.h0.a.a()) {
            if ((Thread.currentThread() instanceof d.c.f0.g.e) || d.c.h0.a.b()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
