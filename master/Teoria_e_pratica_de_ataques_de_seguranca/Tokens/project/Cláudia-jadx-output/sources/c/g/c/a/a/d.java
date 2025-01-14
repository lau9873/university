package c.g.c.a.a;

import java.util.HashMap;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f4017c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f4018a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f4019b = new HashMap<>();

    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f4020a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f4021b = 0;

        public a(d dVar) {
        }
    }

    public static d b() {
        if (f4017c == null) {
            f4017c = new d();
        }
        return f4017c;
    }

    public void a() {
        f4017c = new d();
    }

    public void a(String str) {
        a(str, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str, String str2) {
        HashMap hashMap;
        Long l;
        long c2 = c(str);
        int b2 = b(str);
        long d2 = d(str) + (System.currentTimeMillis() - c(str));
        if (c2 != 0) {
            a aVar = new a(this);
            aVar.f4020a = d2;
            aVar.f4021b = b2 + 1;
            hashMap = this.f4018a;
            l = aVar;
        } else {
            hashMap = this.f4019b;
            l = 0L;
        }
        hashMap.put(str, l);
    }

    public int b(String str) {
        if (this.f4018a.containsKey(str)) {
            return this.f4018a.get(str).f4021b;
        }
        return 0;
    }

    public long c(String str) {
        if (this.f4019b.containsKey(str)) {
            return this.f4019b.get(str).longValue();
        }
        return 0L;
    }

    public long d(String str) {
        if (this.f4018a.containsKey(str)) {
            return this.f4018a.get(str).f4020a;
        }
        return 0L;
    }

    public void e(String str) {
        this.f4019b.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
