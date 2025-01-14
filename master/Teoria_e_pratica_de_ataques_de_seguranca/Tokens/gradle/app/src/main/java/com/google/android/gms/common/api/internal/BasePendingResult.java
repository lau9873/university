package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0927f;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1005r2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1020v1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0940b2;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1077q;

@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends InterfaceC0928g> extends AbstractC0925e<R> {

    /* renamed from: p */
    public static final ThreadLocal<Boolean> f6114p = new C1005r2();

    /* renamed from: a */
    public final Object f6115a;

    /* renamed from: b */
    public HandlerC1438a<R> f6116b;

    /* renamed from: c */
    public WeakReference<AbstractC0921d> f6117c;

    /* renamed from: d */
    public final CountDownLatch f6118d;

    /* renamed from: e */
    public final ArrayList<AbstractC0925e.InterfaceC0926a> f6119e;

    /* renamed from: f */
    public InterfaceC0929h<? super R> f6120f;

    /* renamed from: g */
    public final AtomicReference<InterfaceC0940b2> f6121g;

    /* renamed from: h */
    public R f6122h;

    /* renamed from: i */
    public Status f6123i;

    /* renamed from: j */
    public volatile boolean f6124j;

    /* renamed from: k */
    public boolean f6125k;

    /* renamed from: l */
    public boolean f6126l;

    /* renamed from: m */
    public InterfaceC1077q f6127m;

    /* renamed from: n */
    public volatile C1020v1<R> f6128n;

    /* renamed from: o */
    public boolean f6129o;

    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$a */
    /* loaded from: classes.dex */
    public static class HandlerC1438a<R extends InterfaceC0928g> extends Handler {
        public HandlerC1438a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m4352a(InterfaceC0929h<? super R> interfaceC0929h, R r) {
            sendMessage(obtainMessage(1, new Pair(interfaceC0929h, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).m4359b(Status.f6108g);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            InterfaceC0929h interfaceC0929h = (InterfaceC0929h) pair.first;
            InterfaceC0928g interfaceC0928g = (InterfaceC0928g) pair.second;
            try {
                interfaceC0929h.onResult(interfaceC0928g);
            } catch (RuntimeException e) {
                BasePendingResult.m4357c(interfaceC0928g);
                throw e;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$b */
    /* loaded from: classes.dex */
    public final class C1439b {
        public C1439b() {
        }

        public /* synthetic */ C1439b(BasePendingResult basePendingResult, C1005r2 c1005r2) {
            this();
        }

        public final void finalize() {
            BasePendingResult.m4357c(BasePendingResult.this.f6122h);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f6115a = new Object();
        this.f6118d = new CountDownLatch(1);
        this.f6119e = new ArrayList<>();
        this.f6121g = new AtomicReference<>();
        this.f6129o = false;
        this.f6116b = new HandlerC1438a<>(Looper.getMainLooper());
        this.f6117c = new WeakReference<>(null);
    }

    public BasePendingResult(AbstractC0921d abstractC0921d) {
        this.f6115a = new Object();
        this.f6118d = new CountDownLatch(1);
        this.f6119e = new ArrayList<>();
        this.f6121g = new AtomicReference<>();
        this.f6129o = false;
        this.f6116b = new HandlerC1438a<>(abstractC0921d != null ? abstractC0921d.mo5369c() : Looper.getMainLooper());
        this.f6117c = new WeakReference<>(abstractC0921d);
    }

    /* renamed from: c */
    public static void m4357c(InterfaceC0928g interfaceC0928g) {
        if (interfaceC0928g instanceof InterfaceC0927f) {
            try {
                ((InterfaceC0927f) interfaceC0928g).m5587a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(interfaceC0928g);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    /* renamed from: a */
    public abstract R mo4363a(Status status);

    /* renamed from: a */
    public void m4368a() {
        synchronized (this.f6115a) {
            if (!this.f6125k && !this.f6124j) {
                if (this.f6127m != null) {
                    try {
                        this.f6127m.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                m4357c(this.f6122h);
                this.f6125k = true;
                Status status = Status.f6109h;
                mo4363a(status);
                m4360b((BasePendingResult<R>) status);
            }
        }
    }

    /* renamed from: a */
    public final void m4367a(AbstractC0925e.InterfaceC0926a interfaceC0926a) {
        C1049c0.m5289a(interfaceC0926a != null, "Callback cannot be null.");
        synchronized (this.f6115a) {
            if (m4356d()) {
                interfaceC0926a.mo5522a(this.f6123i);
            } else {
                this.f6119e.add(interfaceC0926a);
            }
        }
    }

    /* renamed from: a */
    public final void m4366a(R r) {
        synchronized (this.f6115a) {
            if (this.f6126l || this.f6125k) {
                m4357c(r);
                return;
            }
            m4356d();
            boolean z = true;
            C1049c0.m5285b(!m4356d(), "Results have already been set");
            if (this.f6124j) {
                z = false;
            }
            C1049c0.m5285b(z, "Result has already been consumed");
            m4360b((BasePendingResult<R>) r);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e
    /* renamed from: a */
    public final void mo4365a(InterfaceC0929h<? super R> interfaceC0929h) {
        synchronized (this.f6115a) {
            if (interfaceC0929h == null) {
                this.f6120f = null;
                return;
            }
            boolean z = true;
            C1049c0.m5285b(!this.f6124j, "Result has already been consumed.");
            if (this.f6128n != null) {
                z = false;
            }
            C1049c0.m5285b(z, "Cannot set callbacks if then() has been called.");
            if (m4358c()) {
                return;
            }
            if (m4356d()) {
                this.f6116b.m4352a(interfaceC0929h, m4361b());
            } else {
                this.f6120f = interfaceC0929h;
            }
        }
    }

    /* renamed from: a */
    public final void m4364a(InterfaceC0940b2 interfaceC0940b2) {
        this.f6121g.set(interfaceC0940b2);
    }

    /* renamed from: b */
    public final R m4361b() {
        R r;
        synchronized (this.f6115a) {
            C1049c0.m5285b(!this.f6124j, "Result has already been consumed.");
            C1049c0.m5285b(m4356d(), "Result is not ready.");
            r = this.f6122h;
            this.f6122h = null;
            this.f6120f = null;
            this.f6124j = true;
        }
        InterfaceC0940b2 andSet = this.f6121g.getAndSet(null);
        if (andSet != null) {
            andSet.mo5303a(this);
        }
        return r;
    }

    /* renamed from: b */
    public final void m4360b(R r) {
        this.f6122h = r;
        this.f6127m = null;
        this.f6118d.countDown();
        this.f6123i = this.f6122h.mo4374a();
        if (this.f6125k) {
            this.f6120f = null;
        } else if (this.f6120f != null) {
            this.f6116b.removeMessages(2);
            this.f6116b.m4352a(this.f6120f, m4361b());
        } else if (this.f6122h instanceof InterfaceC0927f) {
            new C1439b(this, null);
        }
        ArrayList<AbstractC0925e.InterfaceC0926a> arrayList = this.f6119e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            AbstractC0925e.InterfaceC0926a interfaceC0926a = arrayList.get(i);
            i++;
            interfaceC0926a.mo5522a(this.f6123i);
        }
        this.f6119e.clear();
    }

    /* renamed from: b */
    public final void m4359b(Status status) {
        synchronized (this.f6115a) {
            if (!m4356d()) {
                mo4363a(status);
                m4366a((BasePendingResult<R>) status);
                this.f6126l = true;
            }
        }
    }

    /* renamed from: c */
    public boolean m4358c() {
        boolean z;
        synchronized (this.f6115a) {
            z = this.f6125k;
        }
        return z;
    }

    /* renamed from: d */
    public final boolean m4356d() {
        return this.f6118d.getCount() == 0;
    }

    /* renamed from: e */
    public final Integer m4355e() {
        return null;
    }

    /* renamed from: f */
    public final boolean m4354f() {
        boolean m4358c;
        synchronized (this.f6115a) {
            if (this.f6117c.get() == null || !this.f6129o) {
                m4368a();
            }
            m4358c = m4358c();
        }
        return m4358c;
    }

    /* renamed from: g */
    public final void m4353g() {
        this.f6129o = this.f6129o || f6114p.get().booleanValue();
    }
}
