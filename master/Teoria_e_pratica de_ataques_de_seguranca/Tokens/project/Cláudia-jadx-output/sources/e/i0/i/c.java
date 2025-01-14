package e.i0.i;

import f.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Hpack.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final e.i0.i.b[] f5684a = {new e.i0.i.b(e.i0.i.b.f5680i, ""), new e.i0.i.b(e.i0.i.b.f5677f, "GET"), new e.i0.i.b(e.i0.i.b.f5677f, "POST"), new e.i0.i.b(e.i0.i.b.f5678g, "/"), new e.i0.i.b(e.i0.i.b.f5678g, "/index.html"), new e.i0.i.b(e.i0.i.b.f5679h, "http"), new e.i0.i.b(e.i0.i.b.f5679h, "https"), new e.i0.i.b(e.i0.i.b.f5676e, "200"), new e.i0.i.b(e.i0.i.b.f5676e, "204"), new e.i0.i.b(e.i0.i.b.f5676e, "206"), new e.i0.i.b(e.i0.i.b.f5676e, "304"), new e.i0.i.b(e.i0.i.b.f5676e, "400"), new e.i0.i.b(e.i0.i.b.f5676e, "404"), new e.i0.i.b(e.i0.i.b.f5676e, "500"), new e.i0.i.b("accept-charset", ""), new e.i0.i.b("accept-encoding", "gzip, deflate"), new e.i0.i.b("accept-language", ""), new e.i0.i.b("accept-ranges", ""), new e.i0.i.b("accept", ""), new e.i0.i.b("access-control-allow-origin", ""), new e.i0.i.b("age", ""), new e.i0.i.b("allow", ""), new e.i0.i.b("authorization", ""), new e.i0.i.b("cache-control", ""), new e.i0.i.b("content-disposition", ""), new e.i0.i.b("content-encoding", ""), new e.i0.i.b("content-language", ""), new e.i0.i.b("content-length", ""), new e.i0.i.b("content-location", ""), new e.i0.i.b("content-range", ""), new e.i0.i.b("content-type", ""), new e.i0.i.b("cookie", ""), new e.i0.i.b("date", ""), new e.i0.i.b("etag", ""), new e.i0.i.b("expect", ""), new e.i0.i.b("expires", ""), new e.i0.i.b("from", ""), new e.i0.i.b("host", ""), new e.i0.i.b("if-match", ""), new e.i0.i.b("if-modified-since", ""), new e.i0.i.b("if-none-match", ""), new e.i0.i.b("if-range", ""), new e.i0.i.b("if-unmodified-since", ""), new e.i0.i.b("last-modified", ""), new e.i0.i.b("link", ""), new e.i0.i.b("location", ""), new e.i0.i.b("max-forwards", ""), new e.i0.i.b("proxy-authenticate", ""), new e.i0.i.b("proxy-authorization", ""), new e.i0.i.b("range", ""), new e.i0.i.b("referer", ""), new e.i0.i.b("refresh", ""), new e.i0.i.b("retry-after", ""), new e.i0.i.b("server", ""), new e.i0.i.b("set-cookie", ""), new e.i0.i.b("strict-transport-security", ""), new e.i0.i.b("transfer-encoding", ""), new e.i0.i.b("user-agent", ""), new e.i0.i.b("vary", ""), new e.i0.i.b("via", ""), new e.i0.i.b("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    public static final Map<f.f, Integer> f5685b = a();

    /* compiled from: Hpack.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<e.i0.i.b> f5686a;

        /* renamed from: b  reason: collision with root package name */
        public final f.e f5687b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5688c;

        /* renamed from: d  reason: collision with root package name */
        public int f5689d;

        /* renamed from: e  reason: collision with root package name */
        public e.i0.i.b[] f5690e;

        /* renamed from: f  reason: collision with root package name */
        public int f5691f;

        /* renamed from: g  reason: collision with root package name */
        public int f5692g;

        /* renamed from: h  reason: collision with root package name */
        public int f5693h;

        public a(int i2, r rVar) {
            this(i2, i2, rVar);
        }

        public final void a() {
            int i2 = this.f5689d;
            int i3 = this.f5693h;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    b(i3 - i2);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f5690e, (Object) null);
            this.f5691f = this.f5690e.length - 1;
            this.f5692g = 0;
            this.f5693h = 0;
        }

        public List<e.i0.i.b> c() {
            ArrayList arrayList = new ArrayList(this.f5686a);
            this.f5686a.clear();
            return arrayList;
        }

        public final boolean d(int i2) {
            return i2 >= 0 && i2 <= c.f5684a.length - 1;
        }

        public final void e(int i2) {
            if (d(i2)) {
                this.f5686a.add(c.f5684a[i2]);
                return;
            }
            int a2 = a(i2 - c.f5684a.length);
            if (a2 >= 0) {
                e.i0.i.b[] bVarArr = this.f5690e;
                if (a2 <= bVarArr.length - 1) {
                    this.f5686a.add(bVarArr[a2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public void f() {
            while (!this.f5687b.e()) {
                int readByte = this.f5687b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f5689d = a(readByte, 31);
                    int i2 = this.f5689d;
                    if (i2 >= 0 && i2 <= this.f5688c) {
                        a();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f5689d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    g(a(readByte, 15) - 1);
                } else {
                    h();
                }
            }
        }

        public final void g(int i2) {
            this.f5686a.add(new e.i0.i.b(c(i2), e()));
        }

        public final void h() {
            f.f e2 = e();
            c.a(e2);
            this.f5686a.add(new e.i0.i.b(e2, e()));
        }

        public a(int i2, int i3, r rVar) {
            this.f5686a = new ArrayList();
            this.f5690e = new e.i0.i.b[8];
            this.f5691f = this.f5690e.length - 1;
            this.f5692g = 0;
            this.f5693h = 0;
            this.f5688c = i2;
            this.f5689d = i3;
            this.f5687b = f.k.a(rVar);
        }

        public final int d() {
            return this.f5687b.readByte() & 255;
        }

        public final f.f c(int i2) {
            if (d(i2)) {
                return c.f5684a[i2].f5681a;
            }
            return this.f5690e[a(i2 - c.f5684a.length)].f5681a;
        }

        public final int a(int i2) {
            return this.f5691f + 1 + i2;
        }

        public final void g() {
            f.f e2 = e();
            c.a(e2);
            a(-1, new e.i0.i.b(e2, e()));
        }

        public final void a(int i2, e.i0.i.b bVar) {
            this.f5686a.add(bVar);
            int i3 = bVar.f5683c;
            if (i2 != -1) {
                i3 -= this.f5690e[a(i2)].f5683c;
            }
            int i4 = this.f5689d;
            if (i3 > i4) {
                b();
                return;
            }
            int b2 = b((this.f5693h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f5692g + 1;
                e.i0.i.b[] bVarArr = this.f5690e;
                if (i5 > bVarArr.length) {
                    e.i0.i.b[] bVarArr2 = new e.i0.i.b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f5691f = this.f5690e.length - 1;
                    this.f5690e = bVarArr2;
                }
                int i6 = this.f5691f;
                this.f5691f = i6 - 1;
                this.f5690e[i6] = bVar;
                this.f5692g++;
            } else {
                this.f5690e[i2 + a(i2) + b2] = bVar;
            }
            this.f5693h += i3;
        }

        public final int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f5690e.length;
                while (true) {
                    length--;
                    if (length < this.f5691f || i2 <= 0) {
                        break;
                    }
                    e.i0.i.b[] bVarArr = this.f5690e;
                    i2 -= bVarArr[length].f5683c;
                    this.f5693h -= bVarArr[length].f5683c;
                    this.f5692g--;
                    i3++;
                }
                e.i0.i.b[] bVarArr2 = this.f5690e;
                int i4 = this.f5691f;
                System.arraycopy(bVarArr2, i4 + 1, bVarArr2, i4 + 1 + i3, this.f5692g);
                this.f5691f += i3;
            }
            return i3;
        }

        public f.f e() {
            int d2 = d();
            boolean z = (d2 & 128) == 128;
            int a2 = a(d2, 127);
            if (z) {
                return f.f.a(j.b().a(this.f5687b.c(a2)));
            }
            return this.f5687b.b(a2);
        }

        public final void f(int i2) {
            a(-1, new e.i0.i.b(c(i2), e()));
        }

        public int a(int i2, int i3) {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int d2 = d();
                if ((d2 & 128) == 0) {
                    return i3 + (d2 << i5);
                }
                i3 += (d2 & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final f.c f5694a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5695b;

        /* renamed from: c  reason: collision with root package name */
        public int f5696c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5697d;

        /* renamed from: e  reason: collision with root package name */
        public int f5698e;

        /* renamed from: f  reason: collision with root package name */
        public e.i0.i.b[] f5699f;

        /* renamed from: g  reason: collision with root package name */
        public int f5700g;

        /* renamed from: h  reason: collision with root package name */
        public int f5701h;

        /* renamed from: i  reason: collision with root package name */
        public int f5702i;

        public b(f.c cVar) {
            this(4096, true, cVar);
        }

        public final int a(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f5699f.length;
                while (true) {
                    length--;
                    if (length < this.f5700g || i2 <= 0) {
                        break;
                    }
                    e.i0.i.b[] bVarArr = this.f5699f;
                    i2 -= bVarArr[length].f5683c;
                    this.f5702i -= bVarArr[length].f5683c;
                    this.f5701h--;
                    i3++;
                }
                e.i0.i.b[] bVarArr2 = this.f5699f;
                int i4 = this.f5700g;
                System.arraycopy(bVarArr2, i4 + 1, bVarArr2, i4 + 1 + i3, this.f5701h);
                e.i0.i.b[] bVarArr3 = this.f5699f;
                int i5 = this.f5700g;
                Arrays.fill(bVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f5700g += i3;
            }
            return i3;
        }

        public final void b() {
            Arrays.fill(this.f5699f, (Object) null);
            this.f5700g = this.f5699f.length - 1;
            this.f5701h = 0;
            this.f5702i = 0;
        }

        public b(int i2, boolean z, f.c cVar) {
            this.f5696c = Integer.MAX_VALUE;
            this.f5699f = new e.i0.i.b[8];
            this.f5700g = this.f5699f.length - 1;
            this.f5701h = 0;
            this.f5702i = 0;
            this.f5698e = i2;
            this.f5695b = z;
            this.f5694a = cVar;
        }

        public void b(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f5698e;
            if (i3 == min) {
                return;
            }
            if (min < i3) {
                this.f5696c = Math.min(this.f5696c, min);
            }
            this.f5697d = true;
            this.f5698e = min;
            a();
        }

        public final void a(e.i0.i.b bVar) {
            int i2 = bVar.f5683c;
            int i3 = this.f5698e;
            if (i2 > i3) {
                b();
                return;
            }
            a((this.f5702i + i2) - i3);
            int i4 = this.f5701h + 1;
            e.i0.i.b[] bVarArr = this.f5699f;
            if (i4 > bVarArr.length) {
                e.i0.i.b[] bVarArr2 = new e.i0.i.b[bVarArr.length * 2];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.f5700g = this.f5699f.length - 1;
                this.f5699f = bVarArr2;
            }
            int i5 = this.f5700g;
            this.f5700g = i5 - 1;
            this.f5699f[i5] = bVar;
            this.f5701h++;
            this.f5702i += i2;
        }

        public void a(List<e.i0.i.b> list) {
            int i2;
            int i3;
            if (this.f5697d) {
                int i4 = this.f5696c;
                if (i4 < this.f5698e) {
                    a(i4, 31, 32);
                }
                this.f5697d = false;
                this.f5696c = Integer.MAX_VALUE;
                a(this.f5698e, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                e.i0.i.b bVar = list.get(i5);
                f.f g2 = bVar.f5681a.g();
                f.f fVar = bVar.f5682b;
                Integer num = c.f5685b.get(g2);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (e.i0.c.a(c.f5684a[i2 - 1].f5682b, fVar)) {
                            i3 = i2;
                        } else if (e.i0.c.a(c.f5684a[i2].f5682b, fVar)) {
                            i3 = i2;
                            i2++;
                        }
                    }
                    i3 = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                if (i2 == -1) {
                    int i6 = this.f5700g + 1;
                    int length = this.f5699f.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (e.i0.c.a(this.f5699f[i6].f5681a, g2)) {
                            if (e.i0.c.a(this.f5699f[i6].f5682b, fVar)) {
                                i2 = c.f5684a.length + (i6 - this.f5700g);
                                break;
                            } else if (i3 == -1) {
                                i3 = (i6 - this.f5700g) + c.f5684a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else if (i3 == -1) {
                    this.f5694a.writeByte(64);
                    a(g2);
                    a(fVar);
                    a(bVar);
                } else if (g2.b(e.i0.i.b.f5675d) && !e.i0.i.b.f5680i.equals(g2)) {
                    a(i3, 15, 0);
                    a(fVar);
                } else {
                    a(i3, 63, 64);
                    a(fVar);
                    a(bVar);
                }
            }
        }

        public void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f5694a.writeByte(i2 | i4);
                return;
            }
            this.f5694a.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f5694a.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f5694a.writeByte(i5);
        }

        public void a(f.f fVar) {
            if (this.f5695b && j.b().a(fVar) < fVar.f()) {
                f.c cVar = new f.c();
                j.b().a(fVar, cVar);
                f.f p = cVar.p();
                a(p.f(), 127, 128);
                this.f5694a.a(p);
                return;
            }
            a(fVar.f(), 127, 0);
            this.f5694a.a(fVar);
        }

        public final void a() {
            int i2 = this.f5698e;
            int i3 = this.f5702i;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    a(i3 - i2);
                }
            }
        }
    }

    public static Map<f.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5684a.length);
        int i2 = 0;
        while (true) {
            e.i0.i.b[] bVarArr = f5684a;
            if (i2 < bVarArr.length) {
                if (!linkedHashMap.containsKey(bVarArr[i2].f5681a)) {
                    linkedHashMap.put(f5684a[i2].f5681a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    public static f.f a(f.f fVar) {
        int f2 = fVar.f();
        for (int i2 = 0; i2 < f2; i2++) {
            byte a2 = fVar.a(i2);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.i());
            }
        }
        return fVar;
    }
}
