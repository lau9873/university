package i;

import e.b0;
import e.c0;
import e.r;
import e.t;
import e.u;
import e.w;
import e.x;
/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public final class k {
    public static final char[] k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f7479a;

    /* renamed from: b  reason: collision with root package name */
    public final u f7480b;

    /* renamed from: c  reason: collision with root package name */
    public String f7481c;

    /* renamed from: d  reason: collision with root package name */
    public u.a f7482d;

    /* renamed from: e  reason: collision with root package name */
    public final b0.a f7483e = new b0.a();

    /* renamed from: f  reason: collision with root package name */
    public w f7484f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f7485g;

    /* renamed from: h  reason: collision with root package name */
    public x.a f7486h;

    /* renamed from: i  reason: collision with root package name */
    public r.a f7487i;
    public c0 j;

    /* compiled from: RequestBuilder.java */
    /* loaded from: classes.dex */
    public static class a extends c0 {

        /* renamed from: a  reason: collision with root package name */
        public final c0 f7488a;

        /* renamed from: b  reason: collision with root package name */
        public final w f7489b;

        public a(c0 c0Var, w wVar) {
            this.f7488a = c0Var;
            this.f7489b = wVar;
        }

        @Override // e.c0
        public long a() {
            return this.f7488a.a();
        }

        @Override // e.c0
        public w b() {
            return this.f7489b;
        }

        @Override // e.c0
        public void a(f.d dVar) {
            this.f7488a.a(dVar);
        }
    }

    public k(String str, u uVar, String str2, t tVar, w wVar, boolean z, boolean z2, boolean z3) {
        this.f7479a = str;
        this.f7480b = uVar;
        this.f7481c = str2;
        this.f7484f = wVar;
        this.f7485g = z;
        if (tVar != null) {
            this.f7483e.a(tVar);
        }
        if (z2) {
            this.f7487i = new r.a();
        } else if (z3) {
            this.f7486h = new x.a();
            this.f7486h.a(x.f5950f);
        }
    }

    public void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            w a2 = w.a(str2);
            if (a2 != null) {
                this.f7484f = a2;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: " + str2);
        }
        this.f7483e.a(str, str2);
    }

    public void b(String str, String str2, boolean z) {
        String str3 = this.f7481c;
        if (str3 != null) {
            this.f7481c = str3.replace("{" + str + "}", a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    public void c(String str, String str2, boolean z) {
        String str3 = this.f7481c;
        if (str3 != null) {
            this.f7482d = this.f7480b.a(str3);
            if (this.f7482d != null) {
                this.f7481c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f7480b + ", Relative: " + this.f7481c);
            }
        }
        if (z) {
            this.f7482d.a(str, str2);
        } else {
            this.f7482d.b(str, str2);
        }
    }

    public static String a(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i2 += Character.charCount(codePointAt);
            } else {
                f.c cVar = new f.c();
                cVar.a(str, 0, i2);
                a(cVar, str, i2, length, z);
                return cVar.q();
            }
        }
        return str;
    }

    public static void a(f.c cVar, String str, int i2, int i3, boolean z) {
        f.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new f.c();
                    }
                    cVar2.c(codePointAt);
                    while (!cVar2.e()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) k[(readByte >> 4) & 15]);
                        cVar.writeByte((int) k[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            this.f7487i.b(str, str2);
        } else {
            this.f7487i.a(str, str2);
        }
    }

    public void a(t tVar, c0 c0Var) {
        this.f7486h.a(tVar, c0Var);
    }

    public void a(x.b bVar) {
        this.f7486h.a(bVar);
    }

    public void a(c0 c0Var) {
        this.j = c0Var;
    }

    public b0 a() {
        u b2;
        u.a aVar = this.f7482d;
        if (aVar != null) {
            b2 = aVar.a();
        } else {
            b2 = this.f7480b.b(this.f7481c);
            if (b2 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f7480b + ", Relative: " + this.f7481c);
            }
        }
        a aVar2 = this.j;
        if (aVar2 == null) {
            r.a aVar3 = this.f7487i;
            if (aVar3 != null) {
                aVar2 = aVar3.a();
            } else {
                x.a aVar4 = this.f7486h;
                if (aVar4 != null) {
                    aVar2 = aVar4.a();
                } else if (this.f7485g) {
                    aVar2 = c0.a((w) null, new byte[0]);
                }
            }
        }
        w wVar = this.f7484f;
        if (wVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, wVar);
            } else {
                this.f7483e.a("Content-Type", wVar.toString());
            }
        }
        b0.a aVar5 = this.f7483e;
        aVar5.a(b2);
        aVar5.a(this.f7479a, aVar2);
        return aVar5.a();
    }
}
