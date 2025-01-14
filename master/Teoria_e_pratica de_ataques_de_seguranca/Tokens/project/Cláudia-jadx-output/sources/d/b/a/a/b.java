package d.b.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: AsYouTypeFormatter.java */
/* loaded from: classes.dex */
public class b {
    public static final k u;
    public static final Pattern v;
    public static final Pattern w;
    public static final Pattern x;
    public static final Pattern y;
    public static final Pattern z;
    public final i j;
    public String k;
    public k l;
    public k m;

    /* renamed from: a  reason: collision with root package name */
    public String f4468a = "";

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f4469b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    public String f4470c = "";

    /* renamed from: d  reason: collision with root package name */
    public StringBuilder f4471d = new StringBuilder();

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f4472e = new StringBuilder();

    /* renamed from: f  reason: collision with root package name */
    public boolean f4473f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4474g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4475h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4476i = false;
    public int n = 0;
    public StringBuilder o = new StringBuilder();
    public boolean p = false;
    public String q = "";
    public StringBuilder r = new StringBuilder();
    public List<j> s = new ArrayList();
    public d.b.a.a.p.c t = new d.b.a.a.p.c(64);

    static {
        k kVar = new k();
        kVar.b("NA");
        u = kVar;
        v = Pattern.compile("\\[([^\\[\\]])*\\]");
        w = Pattern.compile("\\d(?=[^,}][^,}])");
        x = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*)+");
        y = Pattern.compile("[- ]");
        z = Pattern.compile("\u2008");
    }

    public b(i iVar, String str) {
        this.j = iVar;
        this.k = str;
        this.m = c(this.k);
        this.l = this.m;
    }

    public final boolean a(j jVar) {
        String d2 = jVar.d();
        if (d2.indexOf(124) != -1) {
            return false;
        }
        String replaceAll = w.matcher(v.matcher(d2).replaceAll("\\\\d")).replaceAll("\\\\d");
        this.f4469b.setLength(0);
        String a2 = a(replaceAll, jVar.a());
        if (a2.length() > 0) {
            this.f4469b.append(a2);
            return true;
        }
        return false;
    }

    public final void b(String str) {
        List<j> x2;
        if (this.f4475h && this.m.u() > 0) {
            x2 = this.m.v();
        } else {
            x2 = this.m.x();
        }
        boolean s = this.m.s();
        for (j jVar : x2) {
            if (!s || this.f4475h || jVar.c() || i.g(jVar.b())) {
                if (d(jVar.a())) {
                    this.s.add(jVar);
                }
            }
        }
        e(str);
    }

    public final k c(String str) {
        k d2 = this.j.d(this.j.b(this.j.b(str)));
        return d2 != null ? d2 : u;
    }

    public final boolean d(String str) {
        return x.matcher(str).matches();
    }

    public final void e(String str) {
        int length = str.length() - 3;
        Iterator<j> it = this.s.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.e() != 0) {
                if (!this.t.a(next.a(Math.min(length, next.e() - 1))).matcher(str).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    public String f() {
        for (j jVar : this.s) {
            Matcher matcher = this.t.a(jVar.d()).matcher(this.r);
            if (matcher.matches()) {
                this.p = y.matcher(jVar.b()).find();
                return a(matcher.replaceAll(jVar.a()));
            }
        }
        return "";
    }

    public void g() {
        this.f4468a = "";
        this.f4471d.setLength(0);
        this.f4472e.setLength(0);
        this.f4469b.setLength(0);
        this.n = 0;
        this.f4470c = "";
        this.o.setLength(0);
        this.q = "";
        this.r.setLength(0);
        this.f4473f = true;
        this.f4474g = false;
        this.f4475h = false;
        this.f4476i = false;
        this.s.clear();
        this.p = false;
        if (this.m.equals(this.l)) {
            return;
        }
        this.m = c(this.k);
    }

    public final String h() {
        int length = this.r.length();
        if (length > 0) {
            String str = "";
            for (int i2 = 0; i2 < length; i2++) {
                str = b(this.r.charAt(i2));
            }
            return this.f4473f ? a(str) : this.f4471d.toString();
        }
        return this.o.toString();
    }

    public final boolean i() {
        return this.m.a() == 1 && this.r.charAt(0) == '1' && this.r.charAt(1) != '0' && this.r.charAt(1) != '1';
    }

    public final boolean j() {
        Iterator<j> it = this.s.iterator();
        while (it.hasNext()) {
            j next = it.next();
            String d2 = next.d();
            if (this.f4470c.equals(d2)) {
                return false;
            }
            if (a(next)) {
                this.f4470c = d2;
                this.p = y.matcher(next.b()).find();
                this.n = 0;
                return true;
            }
            it.remove();
        }
        this.f4473f = false;
        return false;
    }

    public final String k() {
        int i2 = 1;
        if (i()) {
            StringBuilder sb = this.o;
            sb.append('1');
            sb.append(' ');
            this.f4475h = true;
        } else {
            if (this.m.t()) {
                Matcher matcher = this.t.a(this.m.g()).matcher(this.r);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.f4475h = true;
                    i2 = matcher.end();
                    this.o.append(this.r.substring(0, i2));
                }
            }
            i2 = 0;
        }
        String substring = this.r.substring(0, i2);
        this.r.delete(0, i2);
        return substring;
    }

    public final boolean d() {
        StringBuilder sb;
        int a2;
        if (this.r.length() == 0 || (a2 = this.j.a(this.r, (sb = new StringBuilder()))) == 0) {
            return false;
        }
        this.r.setLength(0);
        this.r.append((CharSequence) sb);
        String b2 = this.j.b(a2);
        if ("001".equals(b2)) {
            this.m = this.j.a(a2);
        } else if (!b2.equals(this.k)) {
            this.m = c(b2);
        }
        String num = Integer.toString(a2);
        StringBuilder sb2 = this.o;
        sb2.append(num);
        sb2.append(' ');
        this.q = "";
        return true;
    }

    public final String c() {
        this.f4473f = true;
        this.f4476i = false;
        this.s.clear();
        this.n = 0;
        this.f4469b.setLength(0);
        this.f4470c = "";
        return b();
    }

    public final String a(String str, String str2) {
        Matcher matcher = this.t.a(str).matcher("999999999999999");
        matcher.find();
        String group = matcher.group();
        return group.length() < this.r.length() ? "" : group.replaceAll(str, str2).replaceAll("9", "\u2008");
    }

    public final boolean c(char c2) {
        if (Character.isDigit(c2)) {
            return true;
        }
        return this.f4471d.length() == 1 && i.l.matcher(Character.toString(c2)).matches();
    }

    public final boolean e() {
        d.b.a.a.p.c cVar = this.t;
        Matcher matcher = cVar.a("\\+|" + this.m.d()).matcher(this.f4472e);
        if (matcher.lookingAt()) {
            this.f4475h = true;
            int end = matcher.end();
            this.r.setLength(0);
            this.r.append(this.f4472e.substring(end));
            this.o.setLength(0);
            this.o.append(this.f4472e.substring(0, end));
            if (this.f4472e.charAt(0) != '+') {
                this.o.append(' ');
            }
            return true;
        }
        return false;
    }

    public final String b() {
        if (this.r.length() >= 3) {
            b(this.r.toString());
            String f2 = f();
            return f2.length() > 0 ? f2 : j() ? h() : this.f4471d.toString();
        }
        return a(this.r.toString());
    }

    public String a(char c2) {
        this.f4468a = a(c2, false);
        return this.f4468a;
    }

    public final String a(char c2, boolean z2) {
        this.f4471d.append(c2);
        if (z2) {
            this.f4471d.length();
        }
        if (!c(c2)) {
            this.f4473f = false;
            this.f4474g = true;
        } else {
            c2 = b(c2, z2);
        }
        if (!this.f4473f) {
            if (this.f4474g) {
                return this.f4471d.toString();
            }
            if (e()) {
                if (d()) {
                    return c();
                }
            } else if (a()) {
                this.o.append(' ');
                return c();
            }
            return this.f4471d.toString();
        }
        int length = this.f4472e.length();
        if (length != 0 && length != 1 && length != 2) {
            if (length == 3) {
                if (e()) {
                    this.f4476i = true;
                } else {
                    this.q = k();
                    return b();
                }
            }
            if (this.f4476i) {
                if (d()) {
                    this.f4476i = false;
                }
                return ((Object) this.o) + this.r.toString();
            } else if (this.s.size() > 0) {
                String b2 = b(c2);
                String f2 = f();
                if (f2.length() > 0) {
                    return f2;
                }
                e(this.r.toString());
                if (j()) {
                    return h();
                }
                if (this.f4473f) {
                    return a(b2);
                }
                return this.f4471d.toString();
            } else {
                return b();
            }
        }
        return this.f4471d.toString();
    }

    public final char b(char c2, boolean z2) {
        if (c2 == '+') {
            this.f4472e.append(c2);
        } else {
            c2 = Character.forDigit(Character.digit(c2, 10), 10);
            this.f4472e.append(c2);
            this.r.append(c2);
        }
        if (z2) {
            this.f4472e.length();
        }
        return c2;
    }

    public final String b(char c2) {
        Matcher matcher = z.matcher(this.f4469b);
        if (matcher.find(this.n)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c2));
            this.f4469b.replace(0, replaceFirst.length(), replaceFirst);
            this.n = matcher.start();
            return this.f4469b.substring(0, this.n + 1);
        }
        if (this.s.size() == 1) {
            this.f4473f = false;
        }
        this.f4470c = "";
        return this.f4471d.toString();
    }

    public final boolean a() {
        if (this.q.length() > 0) {
            this.r.insert(0, this.q);
            this.o.setLength(this.o.lastIndexOf(this.q));
        }
        return !this.q.equals(k());
    }

    public final String a(String str) {
        int length = this.o.length();
        if (this.p && length > 0 && this.o.charAt(length - 1) != ' ') {
            return new String(this.o) + ' ' + str;
        }
        return ((Object) this.o) + str;
    }
}
