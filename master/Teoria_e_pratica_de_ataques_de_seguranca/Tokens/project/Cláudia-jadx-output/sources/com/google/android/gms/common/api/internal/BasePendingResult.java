package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import c.d.a.a.e.e.d;
import c.d.a.a.e.e.e;
import c.d.a.a.e.e.f;
import c.d.a.a.e.e.g;
import c.d.a.a.e.e.h;
import c.d.a.a.e.e.l.b2;
import c.d.a.a.e.e.l.r2;
import c.d.a.a.e.e.l.v1;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.q;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends g> extends e<R> {
    public static final ThreadLocal<Boolean> p = new r2();

    /* renamed from: a  reason: collision with root package name */
    public final Object f4075a;

    /* renamed from: b  reason: collision with root package name */
    public a<R> f4076b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<d> f4077c;

    /* renamed from: d  reason: collision with root package name */
    public final CountDownLatch f4078d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<e.a> f4079e;

    /* renamed from: f  reason: collision with root package name */
    public h<? super R> f4080f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<b2> f4081g;

    /* renamed from: h  reason: collision with root package name */
    public R f4082h;

    /* renamed from: i  reason: collision with root package name */
    public Status f4083i;
    public volatile boolean j;
    public boolean k;
    public boolean l;
    public q m;
    public volatile v1<R> n;
    public boolean o;

    /* loaded from: classes.dex */
    public static class a<R extends g> extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(h<? super R> hVar, R r) {
            sendMessage(obtainMessage(1, new Pair(hVar, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    ((BasePendingResult) message.obj).b(Status.f4069g);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            h hVar = (h) pair.first;
            g gVar = (g) pair.second;
            try {
                hVar.onResult(gVar);
            } catch (RuntimeException e2) {
                BasePendingResult.c(gVar);
                throw e2;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b {
        public b() {
        }

        public /* synthetic */ b(BasePendingResult basePendingResult, r2 r2Var) {
            this();
        }

        public final void finalize() {
            BasePendingResult.c(BasePendingResult.this.f4082h);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f4075a = new Object();
        this.f4078d = new CountDownLatch(1);
        this.f4079e = new ArrayList<>();
        this.f4081g = new AtomicReference<>();
        this.o = false;
        this.f4076b = new a<>(Looper.getMainLooper());
        this.f4077c = new WeakReference<>(null);
    }

    public BasePendingResult(d dVar) {
        this.f4075a = new Object();
        this.f4078d = new CountDownLatch(1);
        this.f4079e = new ArrayList<>();
        this.f4081g = new AtomicReference<>();
        this.o = false;
        this.f4076b = new a<>(dVar != null ? dVar.c() : Looper.getMainLooper());
        this.f4077c = new WeakReference<>(dVar);
    }

    public static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    public abstract R a(Status status);

    public void a() {
        synchronized (this.f4075a) {
            if (!this.k && !this.j) {
                if (this.m != null) {
                    try {
                        this.m.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                c(this.f4082h);
                this.k = true;
                Status status = Status.f4070h;
                a(status);
                b((BasePendingResult<R>) status);
            }
        }
    }

    public final void a(e.a aVar) {
        c0.a(aVar != null, "Callback cannot be null.");
        synchronized (this.f4075a) {
            if (d()) {
                aVar.a(this.f4083i);
            } else {
                this.f4079e.add(aVar);
            }
        }
    }

    public final void a(R r) {
        synchronized (this.f4075a) {
            if (this.l || this.k) {
                c(r);
                return;
            }
            d();
            boolean z = true;
            c0.b(!d(), "Results have already been set");
            if (this.j) {
                z = false;
            }
            c0.b(z, "Result has already been consumed");
            b((BasePendingResult<R>) r);
        }
    }

    @Override // c.d.a.a.e.e.e
    public final void a(h<? super R> hVar) {
        synchronized (this.f4075a) {
            if (hVar == null) {
                this.f4080f = null;
                return;
            }
            boolean z = true;
            c0.b(!this.j, "Result has already been consumed.");
            if (this.n != null) {
                z = false;
            }
            c0.b(z, "Cannot set callbacks if then() has been called.");
            if (c()) {
                return;
            }
            if (d()) {
                this.f4076b.a(hVar, b());
            } else {
                this.f4080f = hVar;
            }
        }
    }

    public final void a(b2 b2Var) {
        this.f4081g.set(b2Var);
    }

    public final R b() {
        R r;
        synchronized (this.f4075a) {
            c0.b(!this.j, "Result has already been consumed.");
            c0.b(d(), "Result is not ready.");
            r = this.f4082h;
            this.f4082h = null;
            this.f4080f = null;
            this.j = true;
        }
        b2 andSet = this.f4081g.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    public final void b(R r) {
        this.f4082h = r;
        this.m = null;
        this.f4078d.countDown();
        this.f4083i = this.f4082h.a();
        if (this.k) {
            this.f4080f = null;
        } else if (this.f4080f != null) {
            this.f4076b.removeMessages(2);
            this.f4076b.a(this.f4080f, b());
        } else if (this.f4082h instanceof f) {
            new b(this, null);
        }
        ArrayList<e.a> arrayList = this.f4079e;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            e.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f4083i);
        }
        this.f4079e.clear();
    }

    public final void b(Status status) {
        synchronized (this.f4075a) {
            if (!d()) {
                a(status);
                a((BasePendingResult<R>) status);
                this.l = true;
            }
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.f4075a) {
            z = this.k;
        }
        return z;
    }

    public final boolean d() {
        return this.f4078d.getCount() == 0;
    }

    public final Integer e() {
        return null;
    }

    public final boolean f() {
        boolean c2;
        synchronized (this.f4075a) {
            if (this.f4077c.get() == null || !this.o) {
                a();
            }
            c2 = c();
        }
        return c2;
    }

    public final void g() {
        this.o = this.o || p.get().booleanValue();
    }
}
