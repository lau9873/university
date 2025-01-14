package p136d.p149b.p150a.p151a.p152p;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: d.b.a.a.p.c */
/* loaded from: classes.dex */
public class RegexCache {

    /* renamed from: a */
    public C1532a<String, Pattern> f6850a;

    /* compiled from: RegexCache.java */
    /* renamed from: d.b.a.a.p.c$a */
    /* loaded from: classes.dex */
    public static class C1532a<K, V> {

        /* renamed from: a */
        public LinkedHashMap<K, V> f6851a;

        /* renamed from: b */
        public int f6852b;

        /* compiled from: RegexCache.java */
        /* renamed from: d.b.a.a.p.c$a$a */
        /* loaded from: classes.dex */
        public class C1533a extends LinkedHashMap<K, V> {
            public C1533a(int i, float f, boolean z) {
                super(i, f, z);
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > C1532a.this.f6852b;
            }
        }

        public C1532a(int i) {
            this.f6852b = i;
            this.f6851a = new C1533a(((i * 4) / 3) + 1, 0.75f, true);
        }

        /* renamed from: a */
        public synchronized V m3680a(K k) {
            return this.f6851a.get(k);
        }

        /* renamed from: a */
        public synchronized void m3679a(K k, V v) {
            this.f6851a.put(k, v);
        }
    }

    public RegexCache(int i) {
        this.f6850a = new C1532a<>(i);
    }

    /* renamed from: a */
    public Pattern m3682a(String str) {
        Pattern m3680a = this.f6850a.m3680a((C1532a<String, Pattern>) str);
        if (m3680a == null) {
            Pattern compile = Pattern.compile(str);
            this.f6850a.m3679a(str, compile);
            return compile;
        }
        return m3680a;
    }
}
