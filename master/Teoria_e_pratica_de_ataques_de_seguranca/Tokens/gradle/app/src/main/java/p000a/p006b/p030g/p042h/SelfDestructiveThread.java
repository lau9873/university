package p000a.p006b.p030g.p042h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: a.b.g.h.c */
/* loaded from: classes.dex */
public class SelfDestructiveThread {

    /* renamed from: b */
    public HandlerThread f1507b;

    /* renamed from: c */
    public Handler f1508c;

    /* renamed from: f */
    public final int f1511f;

    /* renamed from: g */
    public final int f1512g;

    /* renamed from: h */
    public final String f1513h;

    /* renamed from: a */
    public final Object f1506a = new Object();

    /* renamed from: e */
    public Handler.Callback f1510e = new C0253a();

    /* renamed from: d */
    public int f1509d = 0;

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.b.g.h.c$a */
    /* loaded from: classes.dex */
    public class C0253a implements Handler.Callback {
        public C0253a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SelfDestructiveThread.this.m9710a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.m9709a((Runnable) message.obj);
                return true;
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.b.g.h.c$b */
    /* loaded from: classes.dex */
    public class RunnableC0254b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Callable f1515a;

        /* renamed from: b */
        public final /* synthetic */ Handler f1516b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC0257d f1517c;

        /* compiled from: SelfDestructiveThread.java */
        /* renamed from: a.b.g.h.c$b$a */
        /* loaded from: classes.dex */
        public class RunnableC0255a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Object f1518a;

            public RunnableC0255a(Object obj) {
                this.f1518a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0254b.this.f1517c.mo9705a(this.f1518a);
            }
        }

        public RunnableC0254b(SelfDestructiveThread selfDestructiveThread, Callable callable, Handler handler, InterfaceC0257d interfaceC0257d) {
            this.f1515a = callable;
            this.f1516b = handler;
            this.f1517c = interfaceC0257d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f1515a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f1516b.post(new RunnableC0255a(obj));
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.b.g.h.c$c */
    /* loaded from: classes.dex */
    public class RunnableC0256c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AtomicReference f1520a;

        /* renamed from: b */
        public final /* synthetic */ Callable f1521b;

        /* renamed from: c */
        public final /* synthetic */ ReentrantLock f1522c;

        /* renamed from: d */
        public final /* synthetic */ AtomicBoolean f1523d;

        /* renamed from: e */
        public final /* synthetic */ Condition f1524e;

        public RunnableC0256c(SelfDestructiveThread selfDestructiveThread, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f1520a = atomicReference;
            this.f1521b = callable;
            this.f1522c = reentrantLock;
            this.f1523d = atomicBoolean;
            this.f1524e = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1520a.set(this.f1521b.call());
            } catch (Exception unused) {
            }
            this.f1522c.lock();
            try {
                this.f1523d.set(false);
                this.f1524e.signal();
            } finally {
                this.f1522c.unlock();
            }
        }
    }

    /* compiled from: SelfDestructiveThread.java */
    /* renamed from: a.b.g.h.c$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0257d<T> {
        /* renamed from: a */
        void mo9705a(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.f1513h = str;
        this.f1512g = i;
        this.f1511f = i2;
    }

    /* renamed from: a */
    public <T> void m9707a(Callable<T> callable, InterfaceC0257d<T> interfaceC0257d) {
        m9706b(new RunnableC0254b(this, callable, new Handler(), interfaceC0257d));
    }

    /* renamed from: b */
    public final void m9706b(Runnable runnable) {
        synchronized (this.f1506a) {
            if (this.f1507b == null) {
                this.f1507b = new HandlerThread(this.f1513h, this.f1512g);
                this.f1507b.start();
                this.f1508c = new Handler(this.f1507b.getLooper(), this.f1510e);
                this.f1509d++;
            }
            this.f1508c.removeMessages(0);
            this.f1508c.sendMessage(this.f1508c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public <T> T m9708a(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m9706b(new RunnableC0256c(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
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

    /* renamed from: a */
    public void m9709a(Runnable runnable) {
        runnable.run();
        synchronized (this.f1506a) {
            this.f1508c.removeMessages(0);
            this.f1508c.sendMessageDelayed(this.f1508c.obtainMessage(0), this.f1511f);
        }
    }

    /* renamed from: a */
    public void m9710a() {
        synchronized (this.f1506a) {
            if (this.f1508c.hasMessages(1)) {
                return;
            }
            this.f1507b.quit();
            this.f1507b = null;
            this.f1508c = null;
        }
    }
}
