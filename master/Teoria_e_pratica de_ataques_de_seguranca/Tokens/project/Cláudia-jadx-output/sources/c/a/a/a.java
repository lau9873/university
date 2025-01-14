package c.a.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* compiled from: Cache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: Cache.java */
    /* renamed from: c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0051a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f2734a;

        /* renamed from: b  reason: collision with root package name */
        public String f2735b;

        /* renamed from: c  reason: collision with root package name */
        public long f2736c;

        /* renamed from: d  reason: collision with root package name */
        public long f2737d;

        /* renamed from: e  reason: collision with root package name */
        public long f2738e;

        /* renamed from: f  reason: collision with root package name */
        public long f2739f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, String> f2740g = Collections.emptyMap();

        /* renamed from: h  reason: collision with root package name */
        public List<e> f2741h;

        public boolean a() {
            return this.f2738e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f2739f < System.currentTimeMillis();
        }
    }

    C0051a a(String str);

    void a();

    void a(String str, C0051a c0051a);
}
