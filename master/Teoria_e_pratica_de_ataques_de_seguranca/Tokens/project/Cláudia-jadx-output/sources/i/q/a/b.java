package i.q.a;

import c.d.b.f;
import c.d.b.s;
import e.c0;
import e.w;
import i.e;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes.dex */
public final class b<T> implements e<T, c0> {

    /* renamed from: c  reason: collision with root package name */
    public static final w f7556c = w.a("application/json; charset=UTF-8");

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f7557d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final f f7558a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f7559b;

    public b(f fVar, s<T> sVar) {
        this.f7558a = fVar;
        this.f7559b = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.e
    public /* bridge */ /* synthetic */ c0 a(Object obj) {
        return a((b<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // i.e
    public c0 a(T t) {
        f.c cVar = new f.c();
        c.d.b.x.c a2 = this.f7558a.a((Writer) new OutputStreamWriter(cVar.n(), f7557d));
        this.f7559b.a(a2, t);
        a2.close();
        return c0.a(f7556c, cVar.p());
    }
}
