package e;

import e.a0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: c  reason: collision with root package name */
    public Runnable f5902c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f5903d;

    /* renamed from: a  reason: collision with root package name */
    public int f5900a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f5901b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<a0.a> f5904e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<a0.a> f5905f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<a0> f5906g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f5903d == null) {
            this.f5903d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), e.i0.c.a("OkHttp Dispatcher", false));
        }
        return this.f5903d;
    }

    public final void b() {
        if (this.f5905f.size() < this.f5900a && !this.f5904e.isEmpty()) {
            Iterator<a0.a> it = this.f5904e.iterator();
            while (it.hasNext()) {
                a0.a next = it.next();
                if (c(next) < this.f5901b) {
                    it.remove();
                    this.f5905f.add(next);
                    a().execute(next);
                }
                if (this.f5905f.size() >= this.f5900a) {
                    return;
                }
            }
        }
    }

    public final int c(a0.a aVar) {
        int i2 = 0;
        for (a0.a aVar2 : this.f5905f) {
            if (aVar2.c().equals(aVar.c())) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized int c() {
        return this.f5905f.size() + this.f5906g.size();
    }

    public synchronized void a(a0.a aVar) {
        if (this.f5905f.size() < this.f5900a && c(aVar) < this.f5901b) {
            this.f5905f.add(aVar);
            a().execute(aVar);
        } else {
            this.f5904e.add(aVar);
        }
    }

    public synchronized void a(a0 a0Var) {
        this.f5906g.add(a0Var);
    }

    public void b(a0.a aVar) {
        a(this.f5905f, aVar, true);
    }

    public void b(a0 a0Var) {
        a(this.f5906g, a0Var, false);
    }

    public final <T> void a(Deque<T> deque, T t, boolean z) {
        int c2;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    b();
                }
                c2 = c();
                runnable = this.f5902c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (c2 != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
