package p181e;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p181e.RealCall;
import p181e.p182i0.Util;

/* renamed from: e.o */
/* loaded from: classes.dex */
public final class Dispatcher {

    /* renamed from: c */
    public Runnable f8314c;

    /* renamed from: d */
    public ExecutorService f8315d;

    /* renamed from: a */
    public int f8312a = 64;

    /* renamed from: b */
    public int f8313b = 5;

    /* renamed from: e */
    public final Deque<RealCall.C1735a> f8316e = new ArrayDeque();

    /* renamed from: f */
    public final Deque<RealCall.C1735a> f8317f = new ArrayDeque();

    /* renamed from: g */
    public final Deque<RealCall> f8318g = new ArrayDeque();

    /* renamed from: a */
    public synchronized ExecutorService m2786a() {
        if (this.f8315d == null) {
            this.f8315d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.m3162a("OkHttp Dispatcher", false));
        }
        return this.f8315d;
    }

    /* renamed from: b */
    public final void m2782b() {
        if (this.f8317f.size() < this.f8312a && !this.f8316e.isEmpty()) {
            Iterator<RealCall.C1735a> it = this.f8316e.iterator();
            while (it.hasNext()) {
                RealCall.C1735a next = it.next();
                if (m2778c(next) < this.f8313b) {
                    it.remove();
                    this.f8317f.add(next);
                    m2786a().execute(next);
                }
                if (this.f8317f.size() >= this.f8312a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public final int m2778c(RealCall.C1735a c1735a) {
        int i = 0;
        for (RealCall.C1735a c1735a2 : this.f8317f) {
            if (c1735a2.m3263c().equals(c1735a.m3263c())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: c */
    public synchronized int m2779c() {
        return this.f8317f.size() + this.f8318g.size();
    }

    /* renamed from: a */
    public synchronized void m2785a(RealCall.C1735a c1735a) {
        if (this.f8317f.size() < this.f8312a && m2778c(c1735a) < this.f8313b) {
            this.f8317f.add(c1735a);
            m2786a().execute(c1735a);
        } else {
            this.f8316e.add(c1735a);
        }
    }

    /* renamed from: a */
    public synchronized void m2784a(RealCall realCall) {
        this.f8318g.add(realCall);
    }

    /* renamed from: b */
    public void m2781b(RealCall.C1735a c1735a) {
        m2783a(this.f8317f, c1735a, true);
    }

    /* renamed from: b */
    public void m2780b(RealCall realCall) {
        m2783a(this.f8318g, realCall, false);
    }

    /* renamed from: a */
    public final <T> void m2783a(Deque<T> deque, T t, boolean z) {
        int m2779c;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m2782b();
                }
                m2779c = m2779c();
                runnable = this.f8314c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (m2779c != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
