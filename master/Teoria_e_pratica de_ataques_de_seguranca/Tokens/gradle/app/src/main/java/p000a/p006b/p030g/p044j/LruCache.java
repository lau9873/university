package p000a.p006b.p030g.p044j;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.LinkedHashMap;
import java.util.Locale;

/* renamed from: a.b.g.j.g */
/* loaded from: classes.dex */
public class LruCache<K, V> {

    /* renamed from: a */
    public final LinkedHashMap<K, V> f1571a;

    /* renamed from: b */
    public int f1572b;

    /* renamed from: c */
    public int f1573c;

    /* renamed from: d */
    public int f1574d;

    /* renamed from: e */
    public int f1575e;

    /* renamed from: f */
    public int f1576f;

    /* renamed from: g */
    public int f1577g;

    /* renamed from: h */
    public int f1578h;

    public LruCache(int i) {
        if (i > 0) {
            this.f1573c = i;
            this.f1571a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* renamed from: a */
    public V m9652a(K k) {
        return null;
    }

    /* renamed from: a */
    public final V m9651a(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                this.f1574d++;
                this.f1572b += m9648b(k, v);
                put = this.f1571a.put(k, v);
                if (put != null) {
                    this.f1572b -= m9648b(k, put);
                }
            }
            if (put != null) {
                m9650a(false, k, put, v);
            }
            m9653a(this.f1573c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* renamed from: a */
    public void m9650a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    public final V m9649b(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.f1571a.get(k);
                if (v != null) {
                    this.f1577g++;
                    return v;
                }
                this.f1578h++;
                V m9652a = m9652a((LruCache<K, V>) k);
                if (m9652a == null) {
                    return null;
                }
                synchronized (this) {
                    this.f1575e++;
                    put = this.f1571a.put(k, m9652a);
                    if (put != null) {
                        this.f1571a.put(k, put);
                    } else {
                        this.f1572b += m9648b(k, m9652a);
                    }
                }
                if (put != null) {
                    m9650a(false, k, m9652a, put);
                    return put;
                }
                m9653a(this.f1573c);
                return m9652a;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* renamed from: c */
    public int m9647c(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        i = this.f1577g + this.f1578h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1573c), Integer.valueOf(this.f1577g), Integer.valueOf(this.f1578h), Integer.valueOf(i != 0 ? (this.f1577g * 100) / i : 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9653a(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f1572b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f1571a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f1572b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f1572b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f1571a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f1571a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f1571a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1572b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.m9648b(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f1572b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f1576f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f1576f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.m9650a(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p044j.LruCache.m9653a(int):void");
    }

    /* renamed from: b */
    public final int m9648b(K k, V v) {
        int m9647c = m9647c(k, v);
        if (m9647c >= 0) {
            return m9647c;
        }
        throw new IllegalStateException("Negative size: " + k + SimpleComparison.EQUAL_TO_OPERATION + v);
    }
}
