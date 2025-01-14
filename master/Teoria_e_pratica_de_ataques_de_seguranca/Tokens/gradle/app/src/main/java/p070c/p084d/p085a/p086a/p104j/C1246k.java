package p070c.p084d.p085a.p086a.p104j;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: c.d.a.a.j.k */
/* loaded from: classes.dex */
public final class C1246k<TResult> {

    /* renamed from: a */
    public final Object f5636a = new Object();

    /* renamed from: b */
    public Queue<InterfaceC1245j<TResult>> f5637b;

    /* renamed from: c */
    public boolean f5638c;

    /* renamed from: a */
    public final void m4972a(AbstractC1237c<TResult> abstractC1237c) {
        InterfaceC1245j<TResult> poll;
        synchronized (this.f5636a) {
            if (this.f5637b != null && !this.f5638c) {
                this.f5638c = true;
                while (true) {
                    synchronized (this.f5636a) {
                        poll = this.f5637b.poll();
                        if (poll == null) {
                            this.f5638c = false;
                            return;
                        }
                    }
                    poll.onComplete(abstractC1237c);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m4971a(InterfaceC1245j<TResult> interfaceC1245j) {
        synchronized (this.f5636a) {
            if (this.f5637b == null) {
                this.f5637b = new ArrayDeque();
            }
            this.f5637b.add(interfaceC1245j);
        }
    }
}
