package p220i;

import p181e.C1744d0;
import p181e.ResponseBody;

/* compiled from: Response.java */
/* renamed from: i.l */
/* loaded from: classes.dex */
public final class C2632l<T> {

    /* renamed from: a */
    public final C1744d0 f10446a;

    /* renamed from: b */
    public final T f10447b;

    public C2632l(C1744d0 c1744d0, T t, ResponseBody responseBody) {
        this.f10446a = c1744d0;
        this.f10447b = t;
    }

    /* renamed from: a */
    public static <T> C2632l<T> m640a(T t, C1744d0 c1744d0) {
        C2636o.m595a(c1744d0, "rawResponse == null");
        if (c1744d0.m3220o()) {
            return new C2632l<>(c1744d0, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    /* renamed from: b */
    public int m639b() {
        return this.f10446a.m3223l();
    }

    /* renamed from: c */
    public boolean m638c() {
        return this.f10446a.m3220o();
    }

    /* renamed from: d */
    public String m637d() {
        return this.f10446a.m3219p();
    }

    public String toString() {
        return this.f10446a.toString();
    }

    /* renamed from: a */
    public static <T> C2632l<T> m641a(ResponseBody responseBody, C1744d0 c1744d0) {
        C2636o.m595a(responseBody, "body == null");
        C2636o.m595a(c1744d0, "rawResponse == null");
        if (!c1744d0.m3220o()) {
            return new C2632l<>(c1744d0, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    /* renamed from: a */
    public T m642a() {
        return this.f10447b;
    }
}
