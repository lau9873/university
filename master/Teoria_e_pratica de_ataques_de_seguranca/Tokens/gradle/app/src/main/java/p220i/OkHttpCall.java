package p220i;

import java.io.IOException;
import p181e.C1744d0;
import p181e.Call;
import p181e.Callback;
import p181e.MediaType;
import p181e.ResponseBody;
import p192f.Buffer;
import p192f.BufferedSource;
import p192f.ForwardingSource;
import p192f.Okio;
import p192f.Source;

/* renamed from: i.h */
/* loaded from: classes.dex */
public final class OkHttpCall<T> implements InterfaceC2600b<T> {

    /* renamed from: a */
    public final ServiceMethod<T, ?> f10393a;

    /* renamed from: b */
    public final Object[] f10394b;

    /* renamed from: c */
    public volatile boolean f10395c;

    /* renamed from: d */
    public Call f10396d;

    /* renamed from: e */
    public Throwable f10397e;

    /* renamed from: f */
    public boolean f10398f;

    /* compiled from: OkHttpCall.java */
    /* renamed from: i.h$b */
    /* loaded from: classes.dex */
    public static final class C2611b extends ResponseBody {

        /* renamed from: b */
        public final ResponseBody f10401b;

        /* renamed from: c */
        public IOException f10402c;

        /* compiled from: OkHttpCall.java */
        /* renamed from: i.h$b$a */
        /* loaded from: classes.dex */
        public class C2612a extends ForwardingSource {
            public C2612a(Source source) {
                super(source);
            }

            @Override // p192f.ForwardingSource, p192f.Source
            /* renamed from: a */
            public long mo673a(Buffer buffer, long j) {
                try {
                    return super.mo673a(buffer, j);
                } catch (IOException e) {
                    C2611b.this.f10402c = e;
                    throw e;
                }
            }
        }

        public C2611b(ResponseBody responseBody) {
            this.f10401b = responseBody;
        }

        @Override // p181e.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f10401b.close();
        }

        @Override // p181e.ResponseBody
        /* renamed from: l */
        public long mo672l() {
            return this.f10401b.mo672l();
        }

        @Override // p181e.ResponseBody
        /* renamed from: m */
        public MediaType mo671m() {
            return this.f10401b.mo671m();
        }

        @Override // p181e.ResponseBody
        /* renamed from: n */
        public BufferedSource mo670n() {
            return Okio.m2586a(new C2612a(this.f10401b.mo670n()));
        }

        /* renamed from: o */
        public void m674o() {
            IOException iOException = this.f10402c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    /* renamed from: i.h$c */
    /* loaded from: classes.dex */
    public static final class C2613c extends ResponseBody {

        /* renamed from: b */
        public final MediaType f10404b;

        /* renamed from: c */
        public final long f10405c;

        public C2613c(MediaType mediaType, long j) {
            this.f10404b = mediaType;
            this.f10405c = j;
        }

        @Override // p181e.ResponseBody
        /* renamed from: l */
        public long mo672l() {
            return this.f10405c;
        }

        @Override // p181e.ResponseBody
        /* renamed from: m */
        public MediaType mo671m() {
            return this.f10404b;
        }

        @Override // p181e.ResponseBody
        /* renamed from: n */
        public BufferedSource mo670n() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(ServiceMethod<T, ?> serviceMethod, Object[] objArr) {
        this.f10393a = serviceMethod;
        this.f10394b = objArr;
    }

    @Override // p220i.InterfaceC2600b
    /* renamed from: a */
    public void mo681a(InterfaceC2602d<T> interfaceC2602d) {
        Call call;
        Throwable th;
        C2636o.m595a(interfaceC2602d, "callback == null");
        synchronized (this) {
            if (!this.f10398f) {
                this.f10398f = true;
                call = this.f10396d;
                th = this.f10397e;
                if (call == null && th == null) {
                    Call m683a = m683a();
                    this.f10396d = m683a;
                    call = m683a;
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            interfaceC2602d.mo579a(this, th);
            return;
        }
        if (this.f10395c) {
            call.cancel();
        }
        call.mo3198a(new C2610a(interfaceC2602d));
    }

    @Override // p220i.InterfaceC2600b
    public void cancel() {
        Call call;
        this.f10395c = true;
        synchronized (this) {
            call = this.f10396d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // p220i.InterfaceC2600b
    /* renamed from: j */
    public C2632l<T> mo680j() {
        Call call;
        synchronized (this) {
            if (!this.f10398f) {
                this.f10398f = true;
                if (this.f10397e != null) {
                    if (this.f10397e instanceof IOException) {
                        throw ((IOException) this.f10397e);
                    }
                    throw ((RuntimeException) this.f10397e);
                }
                call = this.f10396d;
                if (call == null) {
                    try {
                        call = m683a();
                        this.f10396d = call;
                    } catch (IOException | RuntimeException e) {
                        this.f10397e = e;
                        throw e;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f10395c) {
            call.cancel();
        }
        return m682a(call.mo3197j());
    }

    @Override // p220i.InterfaceC2600b
    /* renamed from: k */
    public boolean mo679k() {
        boolean z = true;
        if (this.f10395c) {
            return true;
        }
        synchronized (this) {
            if (this.f10396d == null || !this.f10396d.mo3196k()) {
                z = false;
            }
        }
        return z;
    }

    /* compiled from: OkHttpCall.java */
    /* renamed from: i.h$a */
    /* loaded from: classes.dex */
    public class C2610a implements Callback {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC2602d f10399a;

        public C2610a(InterfaceC2602d interfaceC2602d) {
            this.f10399a = interfaceC2602d;
        }

        @Override // p181e.Callback
        /* renamed from: a */
        public void mo678a(Call call, C1744d0 c1744d0) {
            try {
                m676a(OkHttpCall.this.m682a(c1744d0));
            } catch (Throwable th) {
                m675a(th);
            }
        }

        @Override // p181e.Callback
        /* renamed from: a */
        public void mo677a(Call call, IOException iOException) {
            try {
                this.f10399a.mo579a(OkHttpCall.this, iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* renamed from: a */
        public final void m675a(Throwable th) {
            try {
                this.f10399a.mo579a(OkHttpCall.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        /* renamed from: a */
        public final void m676a(C2632l<T> c2632l) {
            try {
                this.f10399a.mo580a(OkHttpCall.this, c2632l);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // p220i.InterfaceC2600b
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.f10393a, this.f10394b);
    }

    /* renamed from: a */
    public final Call m683a() {
        Call mo2680a = this.f10393a.f10466a.mo2680a(this.f10393a.m614a(this.f10394b));
        if (mo2680a != null) {
            return mo2680a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* renamed from: a */
    public C2632l<T> m682a(C1744d0 c1744d0) {
        ResponseBody m3225j = c1744d0.m3225j();
        C1744d0.C1745a m3218q = c1744d0.m3218q();
        m3218q.m3209a(new C2613c(m3225j.mo671m(), m3225j.mo672l()));
        C1744d0 m3214a = m3218q.m3214a();
        int m3223l = m3214a.m3223l();
        if (m3223l < 200 || m3223l >= 300) {
            try {
                return C2632l.m641a(C2636o.m599a(m3225j), m3214a);
            } finally {
                m3225j.close();
            }
        } else if (m3223l != 204 && m3223l != 205) {
            C2611b c2611b = new C2611b(m3225j);
            try {
                return C2632l.m640a(this.f10393a.m617a(c2611b), m3214a);
            } catch (RuntimeException e) {
                c2611b.m674o();
                throw e;
            }
        } else {
            m3225j.close();
            return C2632l.m640a((Object) null, m3214a);
        }
    }
}
