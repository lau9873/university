package a.b.g.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f997b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f998c;

    /* renamed from: f  reason: collision with root package name */
    public final int f1001f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1002g;

    /* renamed from: h  reason: collision with root package name */
    public final String f1003h;

    /* renamed from: a  reason: collision with root package name */
    public final Object f996a = new Object();

    /* renamed from: e  reason: collision with root package name */
    public Handler.Callback f1000e = new a();

    /* renamed from: d  reason: collision with root package name */
    public int f999d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c.this.a();
                return true;
            } else if (i2 != 1) {
                return true;
            } else {
                c.this.a((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callable f1005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f1006b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f1007c;

        /* compiled from: SelfDestructiveThread.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f1008a;

            public a(Object obj) {
                this.f1008a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f1007c.a(this.f1008a);
            }
        }

        public b(c cVar, Callable callable, Handler handler, d dVar) {
            this.f1005a = callable;
            this.f1006b = handler;
            this.f1007c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f1005a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f1006b.post(new a(obj));
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.b.g.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0028c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f1010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Callable f1011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f1012c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f1013d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Condition f1014e;

        public RunnableC0028c(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f1010a = atomicReference;
            this.f1011b = callable;
            this.f1012c = reentrantLock;
            this.f1013d = atomicBoolean;
            this.f1014e = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1010a.set(this.f1011b.call());
            } catch (Exception unused) {
            }
            this.f1012c.lock();
            try {
                this.f1013d.set(false);
                this.f1014e.signal();
            } finally {
                this.f1012c.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i2, int i3) {
        this.f1003h = str;
        this.f1002g = i2;
        this.f1001f = i3;
    }

    public <T> void a(Callable<T> callable, d<T> dVar) {
        b(new b(this, callable, new Handler(), dVar));
    }

    public final void b(Runnable runnable) {
        synchronized (this.f996a) {
            if (this.f997b == null) {
                this.f997b = new HandlerThread(this.f1003h, this.f1002g);
                this.f997b.start();
                this.f998c = new Handler(this.f997b.getLooper(), this.f1000e);
                this.f999d++;
            }
            this.f998c.removeMessages(0);
            this.f998c.sendMessage(this.f998c.obtainMessage(1, runnable));
        }
    }

    public <T> T a(Callable<T> callable, int i2) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new RunnableC0028c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i2);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f996a) {
            this.f998c.removeMessages(0);
            this.f998c.sendMessageDelayed(this.f998c.obtainMessage(0), this.f1001f);
        }
    }

    public void a() {
        synchronized (this.f996a) {
            if (this.f998c.hasMessages(1)) {
                return;
            }
            this.f997b.quit();
            this.f997b = null;
            this.f998c = null;
        }
    }
}
