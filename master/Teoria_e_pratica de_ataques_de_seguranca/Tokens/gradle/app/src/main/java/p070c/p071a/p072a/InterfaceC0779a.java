package p070c.p071a.p072a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Cache.java */
/* renamed from: c.a.a.a */
/* loaded from: classes.dex */
public interface InterfaceC0779a {

    /* compiled from: Cache.java */
    /* renamed from: c.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C0780a {

        /* renamed from: a */
        public byte[] f4524a;

        /* renamed from: b */
        public String f4525b;

        /* renamed from: c */
        public long f4526c;

        /* renamed from: d */
        public long f4527d;

        /* renamed from: e */
        public long f4528e;

        /* renamed from: f */
        public long f4529f;

        /* renamed from: g */
        public Map<String, String> f4530g = Collections.emptyMap();

        /* renamed from: h */
        public List<Header> f4531h;

        /* renamed from: a */
        public boolean m6239a() {
            return this.f4528e < System.currentTimeMillis();
        }

        /* renamed from: b */
        public boolean m6238b() {
            return this.f4529f < System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    C0780a mo6142a(String str);

    /* renamed from: a */
    void mo6151a();

    /* renamed from: a */
    void mo6141a(String str, C0780a c0780a);
}
