package p070c.p084d.p105b.p107v;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: c.d.b.v.h */
/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: h */
    public static final Comparator<Comparable> f5727h = new C1283a();

    /* renamed from: a */
    public Comparator<? super K> f5728a;

    /* renamed from: b */
    public C1289e<K, V> f5729b;

    /* renamed from: c */
    public int f5730c;

    /* renamed from: d */
    public int f5731d;

    /* renamed from: e */
    public final C1289e<K, V> f5732e;

    /* renamed from: f */
    public LinkedTreeMap<K, V>.C1284b f5733f;

    /* renamed from: g */
    public LinkedTreeMap<K, V>.C1286c f5734g;

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: c.d.b.v.h$a */
    /* loaded from: classes.dex */
    public static class C1283a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: c.d.b.v.h$b */
    /* loaded from: classes.dex */
    public class C1284b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: c.d.b.v.h$b$a */
        /* loaded from: classes.dex */
        public class C1285a extends LinkedTreeMap<K, V>.AbstractC1288d<Map.Entry<K, V>> {
            public C1285a(C1284b c1284b) {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return m4831a();
            }
        }

        public C1284b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.m4836a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1285a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            C1289e<K, V> m4836a;
            if ((obj instanceof Map.Entry) && (m4836a = LinkedTreeMap.this.m4836a((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.m4834b(m4836a, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f5730c;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: c.d.b.v.h$c */
    /* loaded from: classes.dex */
    public final class C1286c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: c.d.b.v.h$c$a */
        /* loaded from: classes.dex */
        public class C1287a extends LinkedTreeMap<K, V>.AbstractC1288d<K> {
            public C1287a(C1286c c1286c) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return m4831a().f5746f;
            }
        }

        public C1286c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C1287a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.m4833b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f5730c;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: c.d.b.v.h$d */
    /* loaded from: classes.dex */
    public abstract class AbstractC1288d<T> implements Iterator<T> {

        /* renamed from: a */
        public C1289e<K, V> f5737a;

        /* renamed from: b */
        public C1289e<K, V> f5738b;

        /* renamed from: c */
        public int f5739c;

        public AbstractC1288d() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.f5737a = linkedTreeMap.f5732e.f5744d;
            this.f5738b = null;
            this.f5739c = linkedTreeMap.f5731d;
        }

        /* renamed from: a */
        public final C1289e<K, V> m4831a() {
            C1289e<K, V> c1289e = this.f5737a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (c1289e != linkedTreeMap.f5732e) {
                if (linkedTreeMap.f5731d == this.f5739c) {
                    this.f5737a = c1289e.f5744d;
                    this.f5738b = c1289e;
                    return c1289e;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5737a != LinkedTreeMap.this.f5732e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            C1289e<K, V> c1289e = this.f5738b;
            if (c1289e != null) {
                LinkedTreeMap.this.m4834b(c1289e, true);
                this.f5738b = null;
                this.f5739c = LinkedTreeMap.this.f5731d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(f5727h);
    }

    /* renamed from: a */
    public C1289e<K, V> m4837a(K k, boolean z) {
        int i;
        C1289e<K, V> c1289e;
        Comparator<? super K> comparator = this.f5728a;
        C1289e<K, V> c1289e2 = this.f5729b;
        if (c1289e2 != null) {
            Comparable comparable = comparator == f5727h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(c1289e2.f5746f);
                } else {
                    i = comparator.compare(k, (K) c1289e2.f5746f);
                }
                if (i == 0) {
                    return c1289e2;
                }
                C1289e<K, V> c1289e3 = i < 0 ? c1289e2.f5742b : c1289e2.f5743c;
                if (c1289e3 == null) {
                    break;
                }
                c1289e2 = c1289e3;
            }
        } else {
            i = 0;
        }
        if (z) {
            C1289e<K, V> c1289e4 = this.f5732e;
            if (c1289e2 == null) {
                if (comparator == f5727h && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                c1289e = new C1289e<>(c1289e2, k, c1289e4, c1289e4.f5745e);
                this.f5729b = c1289e;
            } else {
                c1289e = new C1289e<>(c1289e2, k, c1289e4, c1289e4.f5745e);
                if (i < 0) {
                    c1289e2.f5742b = c1289e;
                } else {
                    c1289e2.f5743c = c1289e;
                }
                m4840a((C1289e) c1289e2, true);
            }
            this.f5730c++;
            this.f5731d++;
            return c1289e;
        }
        return null;
    }

    /* renamed from: b */
    public void m4834b(C1289e<K, V> c1289e, boolean z) {
        int i;
        if (z) {
            C1289e<K, V> c1289e2 = c1289e.f5745e;
            c1289e2.f5744d = c1289e.f5744d;
            c1289e.f5744d.f5745e = c1289e2;
        }
        C1289e<K, V> c1289e3 = c1289e.f5742b;
        C1289e<K, V> c1289e4 = c1289e.f5743c;
        C1289e<K, V> c1289e5 = c1289e.f5741a;
        int i2 = 0;
        if (c1289e3 != null && c1289e4 != null) {
            C1289e<K, V> m4829b = c1289e3.f5748h > c1289e4.f5748h ? c1289e3.m4829b() : c1289e4.m4830a();
            m4834b(m4829b, false);
            C1289e<K, V> c1289e6 = c1289e.f5742b;
            if (c1289e6 != null) {
                i = c1289e6.f5748h;
                m4829b.f5742b = c1289e6;
                c1289e6.f5741a = m4829b;
                c1289e.f5742b = null;
            } else {
                i = 0;
            }
            C1289e<K, V> c1289e7 = c1289e.f5743c;
            if (c1289e7 != null) {
                i2 = c1289e7.f5748h;
                m4829b.f5743c = c1289e7;
                c1289e7.f5741a = m4829b;
                c1289e.f5743c = null;
            }
            m4829b.f5748h = Math.max(i, i2) + 1;
            m4841a((C1289e) c1289e, (C1289e) m4829b);
            return;
        }
        if (c1289e3 != null) {
            m4841a((C1289e) c1289e, (C1289e) c1289e3);
            c1289e.f5742b = null;
        } else if (c1289e4 != null) {
            m4841a((C1289e) c1289e, (C1289e) c1289e4);
            c1289e.f5743c = null;
        } else {
            m4841a((C1289e) c1289e, (C1289e) null);
        }
        m4840a((C1289e) c1289e5, false);
        this.f5730c--;
        this.f5731d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f5729b = null;
        this.f5730c = 0;
        this.f5731d++;
        C1289e<K, V> c1289e = this.f5732e;
        c1289e.f5745e = c1289e;
        c1289e.f5744d = c1289e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m4839a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.C1284b c1284b = this.f5733f;
        if (c1284b != null) {
            return c1284b;
        }
        LinkedTreeMap<K, V>.C1284b c1284b2 = new C1284b();
        this.f5733f = c1284b2;
        return c1284b2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        C1289e<K, V> m4839a = m4839a(obj);
        if (m4839a != null) {
            return m4839a.f5747g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.C1286c c1286c = this.f5734g;
        if (c1286c != null) {
            return c1286c;
        }
        LinkedTreeMap<K, V>.C1286c c1286c2 = new C1286c();
        this.f5734g = c1286c2;
        return c1286c2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            C1289e<K, V> m4837a = m4837a((LinkedTreeMap<K, V>) k, true);
            V v2 = m4837a.f5747g;
            m4837a.f5747g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        C1289e<K, V> m4833b = m4833b(obj);
        if (m4833b != null) {
            return m4833b.f5747g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f5730c;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.f5730c = 0;
        this.f5731d = 0;
        this.f5732e = new C1289e<>();
        this.f5728a = comparator == null ? f5727h : comparator;
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: c.d.b.v.h$e */
    /* loaded from: classes.dex */
    public static final class C1289e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public C1289e<K, V> f5741a;

        /* renamed from: b */
        public C1289e<K, V> f5742b;

        /* renamed from: c */
        public C1289e<K, V> f5743c;

        /* renamed from: d */
        public C1289e<K, V> f5744d;

        /* renamed from: e */
        public C1289e<K, V> f5745e;

        /* renamed from: f */
        public final K f5746f;

        /* renamed from: g */
        public V f5747g;

        /* renamed from: h */
        public int f5748h;

        public C1289e() {
            this.f5746f = null;
            this.f5745e = this;
            this.f5744d = this;
        }

        /* renamed from: a */
        public C1289e<K, V> m4830a() {
            C1289e<K, V> c1289e = this;
            for (C1289e<K, V> c1289e2 = this.f5742b; c1289e2 != null; c1289e2 = c1289e2.f5742b) {
                c1289e = c1289e2;
            }
            return c1289e;
        }

        /* renamed from: b */
        public C1289e<K, V> m4829b() {
            C1289e<K, V> c1289e = this;
            for (C1289e<K, V> c1289e2 = this.f5743c; c1289e2 != null; c1289e2 = c1289e2.f5743c) {
                c1289e = c1289e2;
            }
            return c1289e;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f5746f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f5747g;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5746f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5747g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f5746f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f5747g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f5747g;
            this.f5747g = v;
            return v2;
        }

        public String toString() {
            return this.f5746f + SimpleComparison.EQUAL_TO_OPERATION + this.f5747g;
        }

        public C1289e(C1289e<K, V> c1289e, K k, C1289e<K, V> c1289e2, C1289e<K, V> c1289e3) {
            this.f5741a = c1289e;
            this.f5746f = k;
            this.f5748h = 1;
            this.f5744d = c1289e2;
            this.f5745e = c1289e3;
            c1289e3.f5744d = this;
            c1289e2.f5745e = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public C1289e<K, V> m4839a(Object obj) {
        if (obj != 0) {
            try {
                return m4837a((LinkedTreeMap<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1289e<K, V> m4836a(Map.Entry<?, ?> entry) {
        C1289e<K, V> m4839a = m4839a(entry.getKey());
        if (m4839a != null && m4838a(m4839a.f5747g, entry.getValue())) {
            return m4839a;
        }
        return null;
    }

    /* renamed from: a */
    public final boolean m4838a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public final void m4841a(C1289e<K, V> c1289e, C1289e<K, V> c1289e2) {
        C1289e<K, V> c1289e3 = c1289e.f5741a;
        c1289e.f5741a = null;
        if (c1289e2 != null) {
            c1289e2.f5741a = c1289e3;
        }
        if (c1289e3 != null) {
            if (c1289e3.f5742b == c1289e) {
                c1289e3.f5742b = c1289e2;
                return;
            } else {
                c1289e3.f5743c = c1289e2;
                return;
            }
        }
        this.f5729b = c1289e2;
    }

    /* renamed from: b */
    public C1289e<K, V> m4833b(Object obj) {
        C1289e<K, V> m4839a = m4839a(obj);
        if (m4839a != null) {
            m4834b(m4839a, true);
        }
        return m4839a;
    }

    /* renamed from: a */
    public final void m4840a(C1289e<K, V> c1289e, boolean z) {
        while (c1289e != null) {
            C1289e<K, V> c1289e2 = c1289e.f5742b;
            C1289e<K, V> c1289e3 = c1289e.f5743c;
            int i = c1289e2 != null ? c1289e2.f5748h : 0;
            int i2 = c1289e3 != null ? c1289e3.f5748h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C1289e<K, V> c1289e4 = c1289e3.f5742b;
                C1289e<K, V> c1289e5 = c1289e3.f5743c;
                int i4 = (c1289e4 != null ? c1289e4.f5748h : 0) - (c1289e5 != null ? c1289e5.f5748h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    m4835b((C1289e) c1289e3);
                    m4842a((C1289e) c1289e);
                } else {
                    m4842a((C1289e) c1289e);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C1289e<K, V> c1289e6 = c1289e2.f5742b;
                C1289e<K, V> c1289e7 = c1289e2.f5743c;
                int i5 = (c1289e6 != null ? c1289e6.f5748h : 0) - (c1289e7 != null ? c1289e7.f5748h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    m4842a((C1289e) c1289e2);
                    m4835b((C1289e) c1289e);
                } else {
                    m4835b((C1289e) c1289e);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c1289e.f5748h = i + 1;
                if (z) {
                    return;
                }
            } else {
                c1289e.f5748h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            c1289e = c1289e.f5741a;
        }
    }

    /* renamed from: b */
    public final void m4835b(C1289e<K, V> c1289e) {
        C1289e<K, V> c1289e2 = c1289e.f5742b;
        C1289e<K, V> c1289e3 = c1289e.f5743c;
        C1289e<K, V> c1289e4 = c1289e2.f5742b;
        C1289e<K, V> c1289e5 = c1289e2.f5743c;
        c1289e.f5742b = c1289e5;
        if (c1289e5 != null) {
            c1289e5.f5741a = c1289e;
        }
        m4841a((C1289e) c1289e, (C1289e) c1289e2);
        c1289e2.f5743c = c1289e;
        c1289e.f5741a = c1289e2;
        c1289e.f5748h = Math.max(c1289e3 != null ? c1289e3.f5748h : 0, c1289e5 != null ? c1289e5.f5748h : 0) + 1;
        c1289e2.f5748h = Math.max(c1289e.f5748h, c1289e4 != null ? c1289e4.f5748h : 0) + 1;
    }

    /* renamed from: a */
    public final void m4842a(C1289e<K, V> c1289e) {
        C1289e<K, V> c1289e2 = c1289e.f5742b;
        C1289e<K, V> c1289e3 = c1289e.f5743c;
        C1289e<K, V> c1289e4 = c1289e3.f5742b;
        C1289e<K, V> c1289e5 = c1289e3.f5743c;
        c1289e.f5743c = c1289e4;
        if (c1289e4 != null) {
            c1289e4.f5741a = c1289e;
        }
        m4841a((C1289e) c1289e, (C1289e) c1289e3);
        c1289e3.f5742b = c1289e;
        c1289e.f5741a = c1289e3;
        c1289e.f5748h = Math.max(c1289e2 != null ? c1289e2.f5748h : 0, c1289e4 != null ? c1289e4.f5748h : 0) + 1;
        c1289e3.f5748h = Math.max(c1289e.f5748h, c1289e5 != null ? c1289e5.f5748h : 0) + 1;
    }
}
