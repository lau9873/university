package p000a.p001a.p002a.p004b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: a.a.a.b.b */
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    public C0005d<K, V> f7a;

    /* renamed from: b */
    public C0005d<K, V> f8b;

    /* renamed from: c */
    public WeakHashMap<InterfaceC0008g<K, V>, Boolean> f9c = new WeakHashMap<>();

    /* renamed from: d */
    public int f10d = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$b */
    /* loaded from: classes.dex */
    public static class C0003b<K, V> extends AbstractC0007f<K, V> {
        public C0003b(C0005d<K, V> c0005d, C0005d<K, V> c0005d2) {
            super(c0005d, c0005d2);
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.AbstractC0007f
        /* renamed from: b */
        public C0005d<K, V> mo11311b(C0005d<K, V> c0005d) {
            return c0005d.f14d;
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.AbstractC0007f
        /* renamed from: c */
        public C0005d<K, V> mo11310c(C0005d<K, V> c0005d) {
            return c0005d.f13c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$c */
    /* loaded from: classes.dex */
    public static class C0004c<K, V> extends AbstractC0007f<K, V> {
        public C0004c(C0005d<K, V> c0005d, C0005d<K, V> c0005d2) {
            super(c0005d, c0005d2);
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.AbstractC0007f
        /* renamed from: b */
        public C0005d<K, V> mo11311b(C0005d<K, V> c0005d) {
            return c0005d.f13c;
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.AbstractC0007f
        /* renamed from: c */
        public C0005d<K, V> mo11310c(C0005d<K, V> c0005d) {
            return c0005d.f14d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$d */
    /* loaded from: classes.dex */
    public static class C0005d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public final K f11a;

        /* renamed from: b */
        public final V f12b;

        /* renamed from: c */
        public C0005d<K, V> f13c;

        /* renamed from: d */
        public C0005d<K, V> f14d;

        public C0005d(K k, V v) {
            this.f11a = k;
            this.f12b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0005d) {
                C0005d c0005d = (C0005d) obj;
                return this.f11a.equals(c0005d.f11a) && this.f12b.equals(c0005d.f12b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f11a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f12b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f11a + SimpleComparison.EQUAL_TO_OPERATION + this.f12b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$e */
    /* loaded from: classes.dex */
    public class C0006e implements Iterator<Map.Entry<K, V>>, InterfaceC0008g<K, V> {

        /* renamed from: a */
        public C0005d<K, V> f15a;

        /* renamed from: b */
        public boolean f16b;

        public C0006e() {
            this.f16b = true;
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.InterfaceC0008g
        /* renamed from: a */
        public void mo11309a(C0005d<K, V> c0005d) {
            C0005d<K, V> c0005d2 = this.f15a;
            if (c0005d == c0005d2) {
                this.f15a = c0005d2.f14d;
                this.f16b = this.f15a == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f16b) {
                return SafeIterableMap.this.f7a != null;
            }
            C0005d<K, V> c0005d = this.f15a;
            return (c0005d == null || c0005d.f13c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f16b) {
                this.f16b = false;
                this.f15a = SafeIterableMap.this.f7a;
            } else {
                C0005d<K, V> c0005d = this.f15a;
                this.f15a = c0005d != null ? c0005d.f13c : null;
            }
            return this.f15a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$f */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0007f<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC0008g<K, V> {

        /* renamed from: a */
        public C0005d<K, V> f18a;

        /* renamed from: b */
        public C0005d<K, V> f19b;

        public AbstractC0007f(C0005d<K, V> c0005d, C0005d<K, V> c0005d2) {
            this.f18a = c0005d2;
            this.f19b = c0005d;
        }

        @Override // p000a.p001a.p002a.p004b.SafeIterableMap.InterfaceC0008g
        /* renamed from: a */
        public void mo11309a(C0005d<K, V> c0005d) {
            if (this.f18a == c0005d && c0005d == this.f19b) {
                this.f19b = null;
                this.f18a = null;
            }
            C0005d<K, V> c0005d2 = this.f18a;
            if (c0005d2 == c0005d) {
                this.f18a = mo11311b(c0005d2);
            }
            if (this.f19b == c0005d) {
                this.f19b = m11312a();
            }
        }

        /* renamed from: b */
        public abstract C0005d<K, V> mo11311b(C0005d<K, V> c0005d);

        /* renamed from: c */
        public abstract C0005d<K, V> mo11310c(C0005d<K, V> c0005d);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            C0005d<K, V> c0005d = this.f19b;
            this.f19b = m11312a();
            return c0005d;
        }

        /* renamed from: a */
        public final C0005d<K, V> m11312a() {
            C0005d<K, V> c0005d = this.f19b;
            C0005d<K, V> c0005d2 = this.f18a;
            if (c0005d == c0005d2 || c0005d2 == null) {
                return null;
            }
            return mo11310c(c0005d);
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: a.a.a.b.b$g */
    /* loaded from: classes.dex */
    public interface InterfaceC0008g<K, V> {
        /* renamed from: a */
        void mo11309a(C0005d<K, V> c0005d);
    }

    /* renamed from: b */
    public V mo11316b(K k, V v) {
        C0005d<K, V> mo11318a = mo11318a((SafeIterableMap<K, V>) k);
        if (mo11318a != null) {
            return mo11318a.f12b;
        }
        m11317a(k, v);
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SafeIterableMap) {
            SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
            if (size() != safeIterableMap.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
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
        C0003b c0003b = new C0003b(this.f7a, this.f8b);
        this.f9c.put(c0003b, false);
        return c0003b;
    }

    /* renamed from: n */
    public Map.Entry<K, V> m11315n() {
        return this.f7a;
    }

    /* renamed from: o */
    public SafeIterableMap<K, V>.C0006e m11314o() {
        SafeIterableMap<K, V>.C0006e c0006e = new C0006e();
        this.f9c.put(c0006e, false);
        return c0006e;
    }

    /* renamed from: p */
    public Map.Entry<K, V> m11313p() {
        return this.f8b;
    }

    public V remove(K k) {
        C0005d<K, V> mo11318a = mo11318a((SafeIterableMap<K, V>) k);
        if (mo11318a == null) {
            return null;
        }
        this.f10d--;
        if (!this.f9c.isEmpty()) {
            for (InterfaceC0008g<K, V> interfaceC0008g : this.f9c.keySet()) {
                interfaceC0008g.mo11309a(mo11318a);
            }
        }
        C0005d<K, V> c0005d = mo11318a.f14d;
        if (c0005d != null) {
            c0005d.f13c = mo11318a.f13c;
        } else {
            this.f7a = mo11318a.f13c;
        }
        C0005d<K, V> c0005d2 = mo11318a.f13c;
        if (c0005d2 != null) {
            c0005d2.f14d = mo11318a.f14d;
        } else {
            this.f8b = mo11318a.f14d;
        }
        mo11318a.f13c = null;
        mo11318a.f14d = null;
        return mo11318a.f12b;
    }

    public int size() {
        return this.f10d;
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

    /* renamed from: a */
    public C0005d<K, V> mo11318a(K k) {
        C0005d<K, V> c0005d = this.f7a;
        while (c0005d != null && !c0005d.f11a.equals(k)) {
            c0005d = c0005d.f13c;
        }
        return c0005d;
    }

    /* renamed from: a */
    public C0005d<K, V> m11317a(K k, V v) {
        C0005d<K, V> c0005d = new C0005d<>(k, v);
        this.f10d++;
        C0005d<K, V> c0005d2 = this.f8b;
        if (c0005d2 == null) {
            this.f7a = c0005d;
            this.f8b = this.f7a;
            return c0005d;
        }
        c0005d2.f13c = c0005d;
        c0005d.f14d = c0005d2;
        this.f8b = c0005d;
        return c0005d;
    }

    /* renamed from: a */
    public Iterator<Map.Entry<K, V>> m11320a() {
        C0004c c0004c = new C0004c(this.f8b, this.f7a);
        this.f9c.put(c0004c, false);
        return c0004c;
    }
}
