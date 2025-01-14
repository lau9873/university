package retrofit2;

import i.l;
import i.o;
/* loaded from: classes.dex */
public class HttpException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public final int f7788a;

    public HttpException(l<?> lVar) {
        super(a(lVar));
        this.f7788a = lVar.b();
        lVar.d();
    }

    public static String a(l<?> lVar) {
        o.a(lVar, "response == null");
        return "HTTP " + lVar.b() + " " + lVar.d();
    }

    public int a() {
        return this.f7788a;
    }
}
