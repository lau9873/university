package c.d.a.a.j;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
public final class k<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3693a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Queue<j<TResult>> f3694b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3695c;

    public final void a(c<TResult> cVar) {
        j<TResult> poll;
        synchronized (this.f3693a) {
            if (this.f3694b != null && !this.f3695c) {
                this.f3695c = true;
                while (true) {
                    synchronized (this.f3693a) {
                        poll = this.f3694b.poll();
                        if (poll == null) {
                            this.f3695c = false;
                            return;
                        }
                    }
                    poll.onComplete(cVar);
                }
            }
        }
    }

    public final void a(j<TResult> jVar) {
        synchronized (this.f3693a) {
            if (this.f3694b == null) {
                this.f3694b = new ArrayDeque();
            }
            this.f3694b.add(jVar);
        }
    }
}
