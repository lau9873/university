package c.a.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.a.a.a;
import c.a.a.k;
import c.a.a.n;
import com.android.volley.VolleyError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public abstract class i<T> implements Comparable<i<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final n.a f2773a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2774b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2775c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2776d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2777e;

    /* renamed from: f  reason: collision with root package name */
    public k.a f2778f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f2779g;

    /* renamed from: h  reason: collision with root package name */
    public j f2780h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2781i;
    public boolean j;
    public boolean k;
    public boolean m;
    public m n;
    public a.C0051a o;
    public b p;

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2782a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f2783b;

        public a(String str, long j) {
            this.f2782a = str;
            this.f2783b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f2773a.a(this.f2782a, this.f2783b);
            i.this.f2773a.a(i.this.toString());
        }
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(i<?> iVar);

        void a(i<?> iVar, k<?> kVar);
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public i(int i2, String str, k.a aVar) {
        this.f2773a = n.a.f2806c ? new n.a() : null;
        this.f2777e = new Object();
        this.f2781i = true;
        this.j = false;
        this.k = false;
        this.m = false;
        this.o = null;
        this.f2774b = i2;
        this.f2775c = str;
        this.f2778f = aVar;
        a((m) new c.a.a.c());
        this.f2776d = c(str);
    }

    public static int c(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i<?> a(m mVar) {
        this.n = mVar;
        return this;
    }

    public abstract k<T> a(h hVar);

    public abstract void a(T t);

    public VolleyError b(VolleyError volleyError) {
        return volleyError;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return a((i) ((i) obj));
    }

    public String d() {
        return "application/x-www-form-urlencoded; charset=" + j();
    }

    public a.C0051a e() {
        return this.o;
    }

    public String f() {
        String r = r();
        int h2 = h();
        if (h2 == 0 || h2 == -1) {
            return r;
        }
        return Integer.toString(h2) + '-' + r;
    }

    public Map<String, String> g() {
        return Collections.emptyMap();
    }

    public int h() {
        return this.f2774b;
    }

    public Map<String, String> i() {
        return null;
    }

    public String j() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] k() {
        Map<String, String> m = m();
        if (m == null || m.size() <= 0) {
            return null;
        }
        return a(m, n());
    }

    @Deprecated
    public String l() {
        return d();
    }

    @Deprecated
    public Map<String, String> m() {
        return i();
    }

    @Deprecated
    public String n() {
        return j();
    }

    public m o() {
        return this.n;
    }

    public final int p() {
        return o().a();
    }

    public int q() {
        return this.f2776d;
    }

    public String r() {
        return this.f2775c;
    }

    public boolean s() {
        boolean z;
        synchronized (this.f2777e) {
            z = this.k;
        }
        return z;
    }

    public boolean t() {
        boolean z;
        synchronized (this.f2777e) {
            z = this.j;
        }
        return z;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(q());
        StringBuilder sb = new StringBuilder();
        sb.append(t() ? "[X] " : "[ ] ");
        sb.append(r());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(a());
        sb.append(" ");
        sb.append(this.f2779g);
        return sb.toString();
    }

    public void u() {
        synchronized (this.f2777e) {
            this.k = true;
        }
    }

    public void v() {
        b bVar;
        synchronized (this.f2777e) {
            bVar = this.p;
        }
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean w() {
        return this.f2781i;
    }

    public final boolean x() {
        return this.m;
    }

    public void a(String str) {
        if (n.a.f2806c) {
            this.f2773a.a(str, Thread.currentThread().getId());
        }
    }

    public void b(String str) {
        j jVar = this.f2780h;
        if (jVar != null) {
            jVar.b(this);
        }
        if (n.a.f2806c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
                return;
            }
            this.f2773a.a(str, id);
            this.f2773a.a(toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i<?> a(j jVar) {
        this.f2780h = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(int i2) {
        this.f2779g = Integer.valueOf(i2);
        return this;
    }

    public byte[] c() {
        Map<String, String> i2 = i();
        if (i2 == null || i2.size() <= 0) {
            return null;
        }
        return a(i2, j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i<?> a(a.C0051a c0051a) {
        this.o = c0051a;
        return this;
    }

    public final byte[] a(Map<String, String> map, String str) {
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
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public void b() {
        synchronized (this.f2777e) {
            this.j = true;
            this.f2778f = null;
        }
    }

    public c a() {
        return c.NORMAL;
    }

    public void a(VolleyError volleyError) {
        k.a aVar;
        synchronized (this.f2777e) {
            aVar = this.f2778f;
        }
        if (aVar != null) {
            aVar.a(volleyError);
        }
    }

    public void a(b bVar) {
        synchronized (this.f2777e) {
            this.p = bVar;
        }
    }

    public void a(k<?> kVar) {
        b bVar;
        synchronized (this.f2777e) {
            bVar = this.p;
        }
        if (bVar != null) {
            bVar.a(this, kVar);
        }
    }

    public int a(i<T> iVar) {
        c a2 = a();
        c a3 = iVar.a();
        return a2 == a3 ? this.f2779g.intValue() - iVar.f2779g.intValue() : a3.ordinal() - a2.ordinal();
    }
}
