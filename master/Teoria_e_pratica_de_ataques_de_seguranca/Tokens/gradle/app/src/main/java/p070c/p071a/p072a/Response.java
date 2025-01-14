package p070c.p071a.p072a;

import com.android.volley.VolleyError;
import p070c.p071a.p072a.InterfaceC0779a;

/* renamed from: c.a.a.k */
/* loaded from: classes.dex */
public class Response<T> {

    /* renamed from: a */
    public final T f4596a;

    /* renamed from: b */
    public final InterfaceC0779a.C0780a f4597b;

    /* renamed from: c */
    public final VolleyError f4598c;

    /* renamed from: d */
    public boolean f4599d;

    /* compiled from: Response.java */
    /* renamed from: c.a.a.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0789a {
        /* renamed from: a */
        void mo6089a(VolleyError volleyError);
    }

    /* compiled from: Response.java */
    /* renamed from: c.a.a.k$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0790b<T> {
        /* renamed from: a */
        void mo6087a(T t);
    }

    public Response(T t, InterfaceC0779a.C0780a c0780a) {
        this.f4599d = false;
        this.f4596a = t;
        this.f4597b = c0780a;
        this.f4598c = null;
    }

    /* renamed from: a */
    public static <T> Response<T> m6177a(T t, InterfaceC0779a.C0780a c0780a) {
        return new Response<>(t, c0780a);
    }

    /* renamed from: a */
    public static <T> Response<T> m6178a(VolleyError volleyError) {
        return new Response<>(volleyError);
    }

    /* renamed from: a */
    public boolean m6179a() {
        return this.f4598c == null;
    }

    public Response(VolleyError volleyError) {
        this.f4599d = false;
        this.f4596a = null;
        this.f4597b = null;
        this.f4598c = volleyError;
    }
}
