package p070c.p115g.p128c.p129a.p130a;

import java.util.HashMap;

/* renamed from: c.g.c.a.a.d */
/* loaded from: classes.dex */
public class C1426d {

    /* renamed from: c */
    public static C1426d f6046c;

    /* renamed from: a */
    public HashMap<String, C1427a> f6047a = new HashMap<>();

    /* renamed from: b */
    public HashMap<String, Long> f6048b = new HashMap<>();

    /* renamed from: c.g.c.a.a.d$a */
    /* loaded from: classes.dex */
    public class C1427a {

        /* renamed from: a */
        public long f6049a = 0;

        /* renamed from: b */
        public int f6050b = 0;

        public C1427a(C1426d c1426d) {
        }
    }

    /* renamed from: b */
    public static C1426d m4461b() {
        if (f6046c == null) {
            f6046c = new C1426d();
        }
        return f6046c;
    }

    /* renamed from: a */
    public void m4464a() {
        f6046c = new C1426d();
    }

    /* renamed from: a */
    public void m4463a(String str) {
        m4462a(str, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m4462a(String str, String str2) {
        HashMap hashMap;
        Long l;
        long m4459c = m4459c(str);
        int m4460b = m4460b(str);
        long m4458d = m4458d(str) + (System.currentTimeMillis() - m4459c(str));
        if (m4459c != 0) {
            C1427a c1427a = new C1427a(this);
            c1427a.f6049a = m4458d;
            c1427a.f6050b = m4460b + 1;
            hashMap = this.f6047a;
            l = c1427a;
        } else {
            hashMap = this.f6048b;
            l = 0L;
        }
        hashMap.put(str, l);
    }

    /* renamed from: b */
    public int m4460b(String str) {
        if (this.f6047a.containsKey(str)) {
            return this.f6047a.get(str).f6050b;
        }
        return 0;
    }

    /* renamed from: c */
    public long m4459c(String str) {
        if (this.f6048b.containsKey(str)) {
            return this.f6048b.get(str).longValue();
        }
        return 0L;
    }

    /* renamed from: d */
    public long m4458d(String str) {
        if (this.f6047a.containsKey(str)) {
            return this.f6047a.get(str).f6049a;
        }
        return 0L;
    }

    /* renamed from: e */
    public void m4457e(String str) {
        this.f6048b.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
