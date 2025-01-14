package c.a.a.o;

import c.a.a.k;
import java.io.UnsupportedEncodingException;
/* compiled from: JsonRequest.java */
/* loaded from: classes.dex */
public abstract class l<T> extends c.a.a.i<T> {
    public static final String t = String.format("application/json; charset=%s", "utf-8");
    public final Object q;
    public k.b<T> r;
    public final String s;

    public l(int i2, String str, String str2, k.b<T> bVar, k.a aVar) {
        super(i2, str, aVar);
        this.q = new Object();
        this.r = bVar;
        this.s = str2;
    }

    @Override // c.a.a.i
    public void a(T t2) {
        k.b<T> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(t2);
        }
    }

    @Override // c.a.a.i
    public void b() {
        super.b();
        synchronized (this.q) {
            this.r = null;
        }
    }

    @Override // c.a.a.i
    public byte[] c() {
        try {
            if (this.s == null) {
                return null;
            }
            return this.s.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            c.a.a.n.e("Unsupported Encoding while trying to get the bytes of %s using %s", this.s, "utf-8");
            return null;
        }
    }

    @Override // c.a.a.i
    public String d() {
        return t;
    }

    @Override // c.a.a.i
    @Deprecated
    public byte[] k() {
        return c();
    }

    @Override // c.a.a.i
    @Deprecated
    public String l() {
        return d();
    }
}
