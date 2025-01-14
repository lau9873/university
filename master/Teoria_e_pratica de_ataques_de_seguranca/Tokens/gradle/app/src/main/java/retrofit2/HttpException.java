package retrofit2;

import p220i.C2632l;
import p220i.C2636o;

/* loaded from: classes.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a */
    public final int f10934a;

    public HttpException(C2632l<?> c2632l) {
        super(m0a(c2632l));
        this.f10934a = c2632l.m639b();
        c2632l.m637d();
    }

    /* renamed from: a */
    public static String m0a(C2632l<?> c2632l) {
        C2636o.m595a(c2632l, "response == null");
        return "HTTP " + c2632l.m639b() + " " + c2632l.m637d();
    }

    /* renamed from: a */
    public int m1a() {
        return this.f10934a;
    }
}
