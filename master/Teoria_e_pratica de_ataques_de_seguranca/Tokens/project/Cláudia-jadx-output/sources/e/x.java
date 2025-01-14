package e;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* compiled from: MultipartBody.java */
/* loaded from: classes.dex */
public final class x extends c0 {

    /* renamed from: e  reason: collision with root package name */
    public static final w f5949e = w.a("multipart/mixed");

    /* renamed from: f  reason: collision with root package name */
    public static final w f5950f;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f5951g;

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f5952h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f5953i;

    /* renamed from: a  reason: collision with root package name */
    public final f.f f5954a;

    /* renamed from: b  reason: collision with root package name */
    public final w f5955b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f5956c;

    /* renamed from: d  reason: collision with root package name */
    public long f5957d = -1;

    /* compiled from: MultipartBody.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final f.f f5958a;

        /* renamed from: b  reason: collision with root package name */
        public w f5959b;

        /* renamed from: c  reason: collision with root package name */
        public final List<b> f5960c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(w wVar) {
            if (wVar != null) {
                if (wVar.a().equals("multipart")) {
                    this.f5959b = wVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + wVar);
            }
            throw new NullPointerException("type == null");
        }

        public a(String str) {
            this.f5959b = x.f5949e;
            this.f5960c = new ArrayList();
            this.f5958a = f.f.c(str);
        }

        public a a(t tVar, c0 c0Var) {
            a(b.a(tVar, c0Var));
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f5960c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public x a() {
            if (!this.f5960c.isEmpty()) {
                return new x(this.f5958a, this.f5959b, this.f5960c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    static {
        w.a("multipart/alternative");
        w.a("multipart/digest");
        w.a("multipart/parallel");
        f5950f = w.a("multipart/form-data");
        f5951g = new byte[]{58, 32};
        f5952h = new byte[]{13, 10};
        f5953i = new byte[]{45, 45};
    }

    public x(f.f fVar, w wVar, List<b> list) {
        this.f5954a = fVar;
        this.f5955b = w.a(wVar + "; boundary=" + fVar.i());
        this.f5956c = e.i0.c.a(list);
    }

    @Override // e.c0
    public long a() {
        long j = this.f5957d;
        if (j != -1) {
            return j;
        }
        long a2 = a((f.d) null, true);
        this.f5957d = a2;
        return a2;
    }

    @Override // e.c0
    public w b() {
        return this.f5955b;
    }

    @Override // e.c0
    public void a(f.d dVar) {
        a(dVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(f.d dVar, boolean z) {
        f.c cVar;
        if (z) {
            dVar = new f.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.f5956c.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f5956c.get(i2);
            t tVar = bVar.f5961a;
            c0 c0Var = bVar.f5962b;
            dVar.write(f5953i);
            dVar.a(this.f5954a);
            dVar.write(f5952h);
            if (tVar != null) {
                int b2 = tVar.b();
                for (int i3 = 0; i3 < b2; i3++) {
                    dVar.a(tVar.a(i3)).write(f5951g).a(tVar.b(i3)).write(f5952h);
                }
            }
            w b3 = c0Var.b();
            if (b3 != null) {
                dVar.a("Content-Type: ").a(b3.toString()).write(f5952h);
            }
            long a2 = c0Var.a();
            if (a2 != -1) {
                dVar.a("Content-Length: ").f(a2).write(f5952h);
            } else if (z) {
                cVar.l();
                return -1L;
            }
            dVar.write(f5952h);
            if (z) {
                j += a2;
            } else {
                c0Var.a(dVar);
            }
            dVar.write(f5952h);
        }
        dVar.write(f5953i);
        dVar.a(this.f5954a);
        dVar.write(f5953i);
        dVar.write(f5952h);
        if (z) {
            long s = j + cVar.s();
            cVar.l();
            return s;
        }
        return j;
    }

    /* compiled from: MultipartBody.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final t f5961a;

        /* renamed from: b  reason: collision with root package name */
        public final c0 f5962b;

        public b(t tVar, c0 c0Var) {
            this.f5961a = tVar;
            this.f5962b = c0Var;
        }

        public static b a(t tVar, c0 c0Var) {
            if (c0Var != null) {
                if (tVar != null && tVar.a("Content-Type") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if (tVar != null && tVar.a("Content-Length") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new b(tVar, c0Var);
            }
            throw new NullPointerException("body == null");
        }

        public static b a(String str, String str2, c0 c0Var) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                x.a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    x.a(sb, str2);
                }
                return a(t.a("Content-Disposition", sb.toString()), c0Var);
            }
            throw new NullPointerException("name == null");
        }
    }

    public static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
