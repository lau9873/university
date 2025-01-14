package d.b.a.a.p;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* compiled from: RegexCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public a<String, Pattern> f4557a;

    /* compiled from: RegexCache.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public LinkedHashMap<K, V> f4558a;

        /* renamed from: b  reason: collision with root package name */
        public int f4559b;

        /* compiled from: RegexCache.java */
        /* renamed from: d.b.a.a.p.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0092a extends LinkedHashMap<K, V> {
            public C0092a(int i2, float f2, boolean z) {
                super(i2, f2, z);
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > a.this.f4559b;
            }
        }

        public a(int i2) {
            this.f4559b = i2;
            this.f4558a = new C0092a(((i2 * 4) / 3) + 1, 0.75f, true);
        }

        public synchronized V a(K k) {
            return this.f4558a.get(k);
        }

        public synchronized void a(K k, V v) {
            this.f4558a.put(k, v);
        }
    }

    public c(int i2) {
        this.f4557a = new a<>(i2);
    }

    public Pattern a(String str) {
        Pattern a2 = this.f4557a.a((a<String, Pattern>) str);
        if (a2 == null) {
            Pattern compile = Pattern.compile(str);
            this.f4557a.a(str, compile);
            return compile;
        }
        return a2;
    }
}
