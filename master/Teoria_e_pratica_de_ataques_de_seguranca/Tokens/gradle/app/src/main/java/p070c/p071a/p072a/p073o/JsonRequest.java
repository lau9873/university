package p070c.p071a.p072a.p073o;

import java.io.UnsupportedEncodingException;
import p070c.p071a.p072a.Request;
import p070c.p071a.p072a.Response;
import p070c.p071a.p072a.VolleyLog;

/* renamed from: c.a.a.o.l */
/* loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {

    /* renamed from: t */
    public static final String f4640t = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: q */
    public final Object f4641q;

    /* renamed from: r */
    public Response.InterfaceC0790b<T> f4642r;

    /* renamed from: s */
    public final String f4643s;

    public JsonRequest(int i, String str, String str2, Response.InterfaceC0790b<T> interfaceC0790b, Response.InterfaceC0789a interfaceC0789a) {
        super(i, str, interfaceC0789a);
        this.f4641q = new Object();
        this.f4642r = interfaceC0790b;
        this.f4643s = str2;
    }

    @Override // p070c.p071a.p072a.Request
    /* renamed from: a */
    public void mo6097a(T t) {
        Response.InterfaceC0790b<T> interfaceC0790b;
        synchronized (this.f4641q) {
            interfaceC0790b = this.f4642r;
        }
        if (interfaceC0790b != null) {
            interfaceC0790b.mo6087a(t);
        }
    }

    @Override // p070c.p071a.p072a.Request
    /* renamed from: b */
    public void mo6096b() {
        super.mo6096b();
        synchronized (this.f4641q) {
            this.f4642r = null;
        }
    }

    @Override // p070c.p071a.p072a.Request
    /* renamed from: c */
    public byte[] mo6095c() {
        try {
            if (this.f4643s == null) {
                return null;
            }
            return this.f4643s.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            VolleyLog.m6165e("Unsupported Encoding while trying to get the bytes of %s using %s", this.f4643s, "utf-8");
            return null;
        }
    }

    @Override // p070c.p071a.p072a.Request
    /* renamed from: d */
    public String mo6094d() {
        return f4640t;
    }

    @Override // p070c.p071a.p072a.Request
    @Deprecated
    /* renamed from: k */
    public byte[] mo6093k() {
        return mo6095c();
    }

    @Override // p070c.p071a.p072a.Request
    @Deprecated
    /* renamed from: l */
    public String mo6092l() {
        return mo6094d();
    }
}
