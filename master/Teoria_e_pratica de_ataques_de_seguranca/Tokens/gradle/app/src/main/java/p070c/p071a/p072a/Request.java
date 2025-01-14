package p070c.p071a.p072a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import p070c.p071a.p072a.InterfaceC0779a;
import p070c.p071a.p072a.Response;
import p070c.p071a.p072a.VolleyLog;

/* renamed from: c.a.a.i */
/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* renamed from: a */
    public final VolleyLog.C0791a f4563a;

    /* renamed from: b */
    public final int f4564b;

    /* renamed from: c */
    public final String f4565c;

    /* renamed from: d */
    public final int f4566d;

    /* renamed from: e */
    public final Object f4567e;

    /* renamed from: f */
    public Response.InterfaceC0789a f4568f;

    /* renamed from: g */
    public Integer f4569g;

    /* renamed from: h */
    public RequestQueue f4570h;

    /* renamed from: i */
    public boolean f4571i;

    /* renamed from: j */
    public boolean f4572j;

    /* renamed from: k */
    public boolean f4573k;

    /* renamed from: m */
    public boolean f4574m;

    /* renamed from: n */
    public RetryPolicy f4575n;

    /* renamed from: o */
    public InterfaceC0779a.C0780a f4576o;

    /* renamed from: p */
    public InterfaceC0786b f4577p;

    /* compiled from: Request.java */
    /* renamed from: c.a.a.i$a */
    /* loaded from: classes.dex */
    public class RunnableC0785a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f4578a;

        /* renamed from: b */
        public final /* synthetic */ long f4579b;

        public RunnableC0785a(String str, long j) {
            this.f4578a = str;
            this.f4579b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Request.this.f4563a.m6162a(this.f4578a, this.f4579b);
            Request.this.f4563a.m6163a(Request.this.toString());
        }
    }

    /* compiled from: Request.java */
    /* renamed from: c.a.a.i$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0786b {
        /* renamed from: a */
        void mo6187a(Request<?> request);

        /* renamed from: a */
        void mo6186a(Request<?> request, Response<?> response);
    }

    /* compiled from: Request.java */
    /* renamed from: c.a.a.i$c */
    /* loaded from: classes.dex */
    public enum EnumC0787c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i, String str, Response.InterfaceC0789a interfaceC0789a) {
        this.f4563a = VolleyLog.C0791a.f4603c ? new VolleyLog.C0791a() : null;
        this.f4567e = new Object();
        this.f4571i = true;
        this.f4572j = false;
        this.f4573k = false;
        this.f4574m = false;
        this.f4576o = null;
        this.f4564b = i;
        this.f4565c = str;
        this.f4568f = interfaceC0789a;
        m6213a((RetryPolicy) new DefaultRetryPolicy());
        this.f4566d = m6206c(str);
    }

    /* renamed from: c */
    public static int m6206c(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Request<?> m6213a(RetryPolicy retryPolicy) {
        this.f4575n = retryPolicy;
        return this;
    }

    /* renamed from: a */
    public abstract Response<T> mo6098a(NetworkResponse networkResponse);

    /* renamed from: a */
    public abstract void mo6097a(T t);

    /* renamed from: b */
    public VolleyError m6208b(VolleyError volleyError) {
        return volleyError;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m6216a((Request) ((Request) obj));
    }

    /* renamed from: d */
    public String mo6094d() {
        return "application/x-www-form-urlencoded; charset=" + m6200j();
    }

    /* renamed from: e */
    public InterfaceC0779a.C0780a m6205e() {
        return this.f4576o;
    }

    /* renamed from: f */
    public String m6204f() {
        String m6194r = m6194r();
        int m6202h = m6202h();
        if (m6202h == 0 || m6202h == -1) {
            return m6194r;
        }
        return Integer.toString(m6202h) + '-' + m6194r;
    }

    /* renamed from: g */
    public Map<String, String> m6203g() {
        return Collections.emptyMap();
    }

    /* renamed from: h */
    public int m6202h() {
        return this.f4564b;
    }

    /* renamed from: i */
    public Map<String, String> m6201i() {
        return null;
    }

    /* renamed from: j */
    public String m6200j() {
        return "UTF-8";
    }

    @Deprecated
    /* renamed from: k */
    public byte[] mo6093k() {
        Map<String, String> m6199m = m6199m();
        if (m6199m == null || m6199m.size() <= 0) {
            return null;
        }
        return m6210a(m6199m, m6198n());
    }

    @Deprecated
    /* renamed from: l */
    public String mo6092l() {
        return mo6094d();
    }

    @Deprecated
    /* renamed from: m */
    public Map<String, String> m6199m() {
        return m6201i();
    }

    @Deprecated
    /* renamed from: n */
    public String m6198n() {
        return m6200j();
    }

    /* renamed from: o */
    public RetryPolicy m6197o() {
        return this.f4575n;
    }

    /* renamed from: p */
    public final int m6196p() {
        return m6197o().mo6173a();
    }

    /* renamed from: q */
    public int m6195q() {
        return this.f4566d;
    }

    /* renamed from: r */
    public String m6194r() {
        return this.f4565c;
    }

    /* renamed from: s */
    public boolean m6193s() {
        boolean z;
        synchronized (this.f4567e) {
            z = this.f4573k;
        }
        return z;
    }

    /* renamed from: t */
    public boolean m6192t() {
        boolean z;
        synchronized (this.f4567e) {
            z = this.f4572j;
        }
        return z;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(m6195q());
        StringBuilder sb = new StringBuilder();
        sb.append(m6192t() ? "[X] " : "[ ] ");
        sb.append(m6194r());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(m6220a());
        sb.append(" ");
        sb.append(this.f4569g);
        return sb.toString();
    }

    /* renamed from: u */
    public void m6191u() {
        synchronized (this.f4567e) {
            this.f4573k = true;
        }
    }

    /* renamed from: v */
    public void m6190v() {
        InterfaceC0786b interfaceC0786b;
        synchronized (this.f4567e) {
            interfaceC0786b = this.f4577p;
        }
        if (interfaceC0786b != null) {
            interfaceC0786b.mo6187a(this);
        }
    }

    /* renamed from: w */
    public final boolean m6189w() {
        return this.f4571i;
    }

    /* renamed from: x */
    public final boolean m6188x() {
        return this.f4574m;
    }

    /* renamed from: a */
    public void m6211a(String str) {
        if (VolleyLog.C0791a.f4603c) {
            this.f4563a.m6162a(str, Thread.currentThread().getId());
        }
    }

    /* renamed from: b */
    public void m6207b(String str) {
        RequestQueue requestQueue = this.f4570h;
        if (requestQueue != null) {
            requestQueue.m6182b(this);
        }
        if (VolleyLog.C0791a.f4603c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0785a(str, id));
                return;
            }
            this.f4563a.m6162a(str, id);
            this.f4563a.m6163a(toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Request<?> m6215a(RequestQueue requestQueue) {
        this.f4570h = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final Request<?> m6219a(int i) {
        this.f4569g = Integer.valueOf(i);
        return this;
    }

    /* renamed from: c */
    public byte[] mo6095c() {
        Map<String, String> m6201i = m6201i();
        if (m6201i == null || m6201i.size() <= 0) {
            return null;
        }
        return m6210a(m6201i, m6200j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public Request<?> m6218a(InterfaceC0779a.C0780a c0780a) {
        this.f4576o = c0780a;
        return this;
    }

    /* renamed from: a */
    public final byte[] m6210a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* renamed from: b */
    public void mo6096b() {
        synchronized (this.f4567e) {
            this.f4572j = true;
            this.f4568f = null;
        }
    }

    /* renamed from: a */
    public EnumC0787c m6220a() {
        return EnumC0787c.NORMAL;
    }

    /* renamed from: a */
    public void m6212a(VolleyError volleyError) {
        Response.InterfaceC0789a interfaceC0789a;
        synchronized (this.f4567e) {
            interfaceC0789a = this.f4568f;
        }
        if (interfaceC0789a != null) {
            interfaceC0789a.mo6089a(volleyError);
        }
    }

    /* renamed from: a */
    public void m6217a(InterfaceC0786b interfaceC0786b) {
        synchronized (this.f4567e) {
            this.f4577p = interfaceC0786b;
        }
    }

    /* renamed from: a */
    public void m6214a(Response<?> response) {
        InterfaceC0786b interfaceC0786b;
        synchronized (this.f4567e) {
            interfaceC0786b = this.f4577p;
        }
        if (interfaceC0786b != null) {
            interfaceC0786b.mo6186a(this, response);
        }
    }

    /* renamed from: a */
    public int m6216a(Request<T> request) {
        EnumC0787c m6220a = m6220a();
        EnumC0787c m6220a2 = request.m6220a();
        return m6220a == m6220a2 ? this.f4569g.intValue() - request.f4569g.intValue() : m6220a2.ordinal() - m6220a.ordinal();
    }
}
