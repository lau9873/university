package p181e;

import java.io.IOException;
import java.util.ArrayList;
import p181e.EventListener;
import p181e.p182i0.NamedRunnable;
import p181e.p182i0.p183e.CacheInterceptor;
import p181e.p182i0.p184f.ConnectInterceptor;
import p181e.p182i0.p185g.BridgeInterceptor;
import p181e.p182i0.p185g.CallServerInterceptor;
import p181e.p182i0.p185g.RealInterceptorChain;
import p181e.p182i0.p185g.RetryAndFollowUpInterceptor;
import p181e.p182i0.p188j.Platform;

/* renamed from: e.a0 */
/* loaded from: classes.dex */
public final class RealCall implements Call {

    /* renamed from: a */
    public final OkHttpClient f7814a;

    /* renamed from: b */
    public final RetryAndFollowUpInterceptor f7815b;

    /* renamed from: c */
    public final C1737b0 f7816c;

    /* renamed from: d */
    public final boolean f7817d;

    /* renamed from: e */
    public boolean f7818e;

    /* compiled from: RealCall.java */
    /* renamed from: e.a0$a */
    /* loaded from: classes.dex */
    public final class C1735a extends NamedRunnable {

        /* renamed from: b */
        public final Callback f7819b;

        public C1735a(Callback callback) {
            super("OkHttp %s", RealCall.this.m3265c());
            this.f7819b = callback;
        }

        @Override // p181e.p182i0.NamedRunnable
        /* renamed from: b */
        public void mo2965b() {
            IOException e;
            C1744d0 m3266b;
            boolean z = true;
            try {
                try {
                    m3266b = RealCall.this.m3266b();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (RealCall.this.f7815b.m3047b()) {
                        this.f7819b.mo677a(RealCall.this, new IOException("Canceled"));
                    } else {
                        this.f7819b.mo678a(RealCall.this, m3266b);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (z) {
                        Platform m2853b = Platform.m2853b();
                        m2853b.mo2861a(4, "Callback failure for " + RealCall.this.m3264d(), e);
                    } else {
                        this.f7819b.mo677a(RealCall.this, e);
                    }
                }
            } finally {
                RealCall.this.f7814a.m2673g().m2781b(this);
            }
        }

        /* renamed from: c */
        public String m3263c() {
            return RealCall.this.f7816c.m3254g().m2730g();
        }
    }

    public RealCall(OkHttpClient okHttpClient, C1737b0 c1737b0, boolean z) {
        EventListener.InterfaceC1807c m2671i = okHttpClient.m2671i();
        this.f7814a = okHttpClient;
        this.f7816c = c1737b0;
        this.f7817d = z;
        this.f7815b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        m2671i.mo2775a(this);
    }

    /* renamed from: a */
    public final void m3267a() {
        this.f7815b.m3048a(Platform.m2853b().mo2860a("response.body().close()"));
    }

    /* renamed from: b */
    public C1744d0 m3266b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7814a.m2667o());
        arrayList.add(this.f7815b);
        arrayList.add(new BridgeInterceptor(this.f7814a.m2674f()));
        arrayList.add(new CacheInterceptor(this.f7814a.m2666p()));
        arrayList.add(new ConnectInterceptor(this.f7814a));
        if (!this.f7817d) {
            arrayList.addAll(this.f7814a.m2665q());
        }
        arrayList.add(new CallServerInterceptor(this.f7817d));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.f7816c).mo2695a(this.f7816c);
    }

    /* renamed from: c */
    public String m3265c() {
        return this.f7816c.m3254g().m2724m();
    }

    @Override // p181e.Call
    public void cancel() {
        this.f7815b.m3054a();
    }

    /* renamed from: d */
    public String m3264d() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo3196k() ? "canceled " : "");
        sb.append(this.f7817d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(m3265c());
        return sb.toString();
    }

    @Override // p181e.Call
    /* renamed from: j */
    public C1744d0 mo3197j() {
        synchronized (this) {
            if (!this.f7818e) {
                this.f7818e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m3267a();
        try {
            this.f7814a.m2673g().m2784a(this);
            C1744d0 m3266b = m3266b();
            if (m3266b != null) {
                return m3266b;
            }
            throw new IOException("Canceled");
        } finally {
            this.f7814a.m2673g().m2780b(this);
        }
    }

    @Override // p181e.Call
    /* renamed from: k */
    public boolean mo3196k() {
        return this.f7815b.m3047b();
    }

    /* renamed from: clone */
    public RealCall m11331clone() {
        return new RealCall(this.f7814a, this.f7816c, this.f7817d);
    }

    @Override // p181e.Call
    /* renamed from: a */
    public void mo3198a(Callback callback) {
        synchronized (this) {
            if (!this.f7818e) {
                this.f7818e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m3267a();
        this.f7814a.m2673g().m2785a(new C1735a(callback));
    }
}
