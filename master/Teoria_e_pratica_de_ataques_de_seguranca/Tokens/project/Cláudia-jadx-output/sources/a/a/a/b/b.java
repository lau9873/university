package a.a.a.b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public d<K, V> f8a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f9b;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<g<K, V>, Boolean> f10c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f11d = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0001b<K, V> extends f<K, V> {
        public C0001b(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // a.a.a.b.b.f
        public d<K, V> b(d<K, V> dVar) {
            return dVar.f15d;
        }

        @Override // a.a.a.b.b.f
        public d<K, V> c(d<K, V> dVar) {
            return dVar.f14c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class c<K, V> extends f<K, V> {
        public c(d<K, V> dVar, d<K, V> dVar2) {
            super(dVar, dVar2);
        }

        @Override // a.a.a.b.b.f
        public d<K, V> b(d<K, V> dVar) {
            return dVar.f14c;
        }

        @Override // a.a.a.b.b.f
        public d<K, V> c(d<K, V> dVar) {
            return dVar.f15d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final K f12a;

        /* renamed from: b  reason: collision with root package name */
        public final V f13b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f14c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f15d;

        public d(K k, V v) {
            this.f12a = k;
            this.f13b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f12a.equals(dVar.f12a) && this.f13b.equals(dVar.f13b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f12a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f13b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f12a + SimpleComparison.EQUAL_TO_OPERATION + this.f13b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class e implements Iterator<Map.Entry<K, V>>, g<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f16a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17b;

        public e() {
            this.f17b = true;
        }

        @Override // a.a.a.b.b.g
        public void a(d<K, V> dVar) {
            d<K, V> dVar2 = this.f16a;
            if (dVar == dVar2) {
                this.f16a = dVar2.f15d;
                this.f17b = this.f16a == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17b) {
                return b.this.f8a != null;
            }
            d<K, V> dVar = this.f16a;
            return (dVar == null || dVar.f14c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f17b) {
                this.f17b = false;
                this.f16a = b.this.f8a;
            } else {
                d<K, V> dVar = this.f16a;
                this.f16a = dVar != null ? dVar.f14c : null;
            }
            return this.f16a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static abstract class f<K, V> implements Iterator<Map.Entry<K, V>>, g<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f19a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f20b;

        public f(d<K, V> dVar, d<K, V> dVar2) {
            this.f19a = dVar2;
            this.f20b = dVar;
        }

        @Override // a.a.a.b.b.g
        public void a(d<K, V> dVar) {
            if (this.f19a == dVar && dVar == this.f20b) {
                this.f20b = null;
                this.f19a = null;
            }
            d<K, V> dVar2 = this.f19a;
            if (dVar2 == dVar) {
                this.f19a = b(dVar2);
            }
            if (this.f20b == dVar) {
                this.f20b = a();
            }
        }

        public abstract d<K, V> b(d<K, V> dVar);

        public abstract d<K, V> c(d<K, V> dVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            d<K, V> dVar = this.f20b;
            this.f20b = a();
            return dVar;
        }

        public final d<K, V> a() {
            d<K, V> dVar = this.f20b;
            d<K, V> dVar2 = this.f19a;
            if (dVar == dVar2 || dVar2 == null) {
                return null;
            }
            return c(dVar);
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface g<K, V> {
        void a(d<K, V> dVar);
    }

    public V b(K k, V v) {
        d<K, V> a2 = a((b<K, V>) k);
        if (a2 != null) {
            return a2.f13b;
        }
        a(k, v);
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        C0001b c0001b = new C0001b(this.f8a, this.f9b);
        this.f10c.put(c0001b, false);
        return c0001b;
    }

    public Map.Entry<K, V> n() {
        return this.f8a;
    }

    public b<K, V>.e o() {
        b<K, V>.e eVar = new e();
        this.f10c.put(eVar, false);
        return eVar;
    }

    public Map.Entry<K, V> p() {
        return this.f9b;
    }

    public V remove(K k) {
        d<K, V> a2 = a((b<K, V>) k);
        if (a2 == null) {
            return null;
        }
        this.f11d--;
        if (!this.f10c.isEmpty()) {
            for (g<K, V> gVar : this.f10c.keySet()) {
                gVar.a(a2);
            }
        }
        d<K, V> dVar = a2.f15d;
        if (dVar != null) {
            dVar.f14c = a2.f14c;
        } else {
            this.f8a = a2.f14c;
        }
        d<K, V> dVar2 = a2.f14c;
        if (dVar2 != null) {
            dVar2.f15d = a2.f15d;
        } else {
            this.f9b = a2.f15d;
        }
        a2.f14c = null;
        a2.f15d = null;
        return a2.f13b;
    }

    public int size() {
        return this.f11d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public d<K, V> a(K k) {
        d<K, V> dVar = this.f8a;
        while (dVar != null && !dVar.f12a.equals(k)) {
            dVar = dVar.f14c;
        }
        return dVar;
    }

    public d<K, V> a(K k, V v) {
        d<K, V> dVar = new d<>(k, v);
        this.f11d++;
        d<K, V> dVar2 = this.f9b;
        if (dVar2 == null) {
            this.f8a = dVar;
            this.f9b = this.f8a;
            return dVar;
        }
        dVar2.f14c = dVar;
        dVar.f15d = dVar2;
        this.f9b = dVar;
        return dVar;
    }

    public Iterator<Map.Entry<K, V>> a() {
        c cVar = new c(this.f9b, this.f8a);
        this.f10c.put(cVar, false);
        return cVar;
    }
}
