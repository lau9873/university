package p181e.p182i0.p187i;

import p181e.p182i0.Util;
import p192f.C1822f;

/* compiled from: Header.java */
/* renamed from: e.i0.i.b */
/* loaded from: classes.dex */
public final class C1766b {

    /* renamed from: d */
    public static final C1822f f8064d = C1822f.m2596c(":");

    /* renamed from: e */
    public static final C1822f f8065e = C1822f.m2596c(":status");

    /* renamed from: f */
    public static final C1822f f8066f = C1822f.m2596c(":method");

    /* renamed from: g */
    public static final C1822f f8067g = C1822f.m2596c(":path");

    /* renamed from: h */
    public static final C1822f f8068h = C1822f.m2596c(":scheme");

    /* renamed from: i */
    public static final C1822f f8069i = C1822f.m2596c(":authority");

    /* renamed from: a */
    public final C1822f f8070a;

    /* renamed from: b */
    public final C1822f f8071b;

    /* renamed from: c */
    public final int f8072c;

    public C1766b(String str, String str2) {
        this(C1822f.m2596c(str), C1822f.m2596c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1766b) {
            C1766b c1766b = (C1766b) obj;
            return this.f8070a.equals(c1766b.f8070a) && this.f8071b.equals(c1766b.f8071b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f8070a.hashCode()) * 31) + this.f8071b.hashCode();
    }

    public String toString() {
        return Util.m3161a("%s: %s", this.f8070a.mo2532i(), this.f8071b.mo2532i());
    }

    public C1766b(C1822f c1822f, String str) {
        this(c1822f, C1822f.m2596c(str));
    }

    public C1766b(C1822f c1822f, C1822f c1822f2) {
        this.f8070a = c1822f;
        this.f8071b = c1822f2;
        this.f8072c = c1822f.mo2535f() + 32 + c1822f2.mo2535f();
    }
}
