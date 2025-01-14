package p070c.p071a.p072a.p073o;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import p070c.p071a.p072a.Header;

/* renamed from: c.a.a.o.h */
/* loaded from: classes.dex */
public final class HttpResponse {

    /* renamed from: a */
    public final int f4633a;

    /* renamed from: b */
    public final List<Header> f4634b;

    /* renamed from: c */
    public final int f4635c;

    /* renamed from: d */
    public final InputStream f4636d;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, null);
    }

    /* renamed from: a */
    public final InputStream m6114a() {
        return this.f4636d;
    }

    /* renamed from: b */
    public final int m6113b() {
        return this.f4635c;
    }

    /* renamed from: c */
    public final List<Header> m6112c() {
        return Collections.unmodifiableList(this.f4634b);
    }

    /* renamed from: d */
    public final int m6111d() {
        return this.f4633a;
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f4633a = i;
        this.f4634b = list;
        this.f4635c = i2;
        this.f4636d = inputStream;
    }
}
