package p000a.p006b.p030g.p044j;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: a.b.g.j.h */
/* loaded from: classes.dex */
public abstract class MapCollections<K, V> {

    /* renamed from: a */
    public MapCollections<K, V>.C0269b f1579a;

    /* renamed from: b */
    public MapCollections<K, V>.C0270c f1580b;

    /* renamed from: c */
    public MapCollections<K, V>.C0272e f1581c;

    /* compiled from: MapCollections.java */
    /* renamed from: a.b.g.j.h$a */
    /* loaded from: classes.dex */
    public final class C0268a<T> implements Iterator<T> {

        /* renamed from: a */
        public final int f1582a;

        /* renamed from: b */
        public int f1583b;

        /* renamed from: c */
        public int f1584c;

        /* renamed from: d */
        public boolean f1585d = false;

        public C0268a(int i) {
            this.f1582a = i;
            this.f1583b = MapCollections.this.mo9633c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1584c < this.f1583b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) MapCollections.this.mo9644a(this.f1584c, this.f1582a);
                this.f1584c++;
                this.f1585d = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1585d) {
                this.f1584c--;
                this.f1583b--;
                this.f1585d = false;
                MapCollections.this.mo9645a(this.f1584c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: a.b.g.j.h$b */
    /* loaded from: classes.dex */
    public final class C0269b implements Set<Map.Entry<K, V>> {
        public C0269b() {
        }

        /* renamed from: a */
        public boolean m9628a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            m9628a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int mo9633c = MapCollections.this.mo9633c();
            for (Map.Entry<K, V> entry : collection) {
                MapCollections.this.mo9641a((MapCollections) entry.getKey(), (K) entry.getValue());
            }
            return mo9633c != MapCollections.this.mo9633c();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.mo9646a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int mo9642a = MapCollections.this.mo9642a(entry.getKey());
                if (mo9642a < 0) {
                    return false;
                }
                return ContainerHelpers.m9672a(MapCollections.this.mo9644a(mo9642a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.m9639a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo9633c = MapCollections.this.mo9633c() - 1; mo9633c >= 0; mo9633c--) {
                Object mo9644a = MapCollections.this.mo9644a(mo9633c, 0);
                Object mo9644a2 = MapCollections.this.mo9644a(mo9633c, 1);
                i += (mo9644a == null ? 0 : mo9644a.hashCode()) ^ (mo9644a2 == null ? 0 : mo9644a2.hashCode());
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo9633c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0271d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.mo9633c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: a.b.g.j.h$c */
    /* loaded from: classes.dex */
    public final class C0270c implements Set<K> {
        public C0270c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            MapCollections.this.mo9646a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return MapCollections.this.mo9642a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return MapCollections.m9640a((Map) MapCollections.this.mo9637b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return MapCollections.m9639a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int mo9633c = MapCollections.this.mo9633c() - 1; mo9633c >= 0; mo9633c--) {
                Object mo9644a = MapCollections.this.mo9644a(mo9633c, 0);
                i += mo9644a == null ? 0 : mo9644a.hashCode();
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo9633c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new C0268a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int mo9642a = MapCollections.this.mo9642a(obj);
            if (mo9642a >= 0) {
                MapCollections.this.mo9645a(mo9642a);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return MapCollections.m9634b(MapCollections.this.mo9637b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return MapCollections.m9632c(MapCollections.this.mo9637b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return MapCollections.this.mo9633c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.m9636b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.m9638a(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: a.b.g.j.h$d */
    /* loaded from: classes.dex */
    public final class C0271d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        public int f1589a;

        /* renamed from: c */
        public boolean f1591c = false;

        /* renamed from: b */
        public int f1590b = -1;

        public C0271d() {
            this.f1589a = MapCollections.this.mo9633c() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f1591c) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return ContainerHelpers.m9672a(entry.getKey(), MapCollections.this.mo9644a(this.f1590b, 0)) && ContainerHelpers.m9672a(entry.getValue(), MapCollections.this.mo9644a(this.f1590b, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1591c) {
                return (K) MapCollections.this.mo9644a(this.f1590b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1591c) {
                return (V) MapCollections.this.mo9644a(this.f1590b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1590b < this.f1589a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f1591c) {
                Object mo9644a = MapCollections.this.mo9644a(this.f1590b, 0);
                Object mo9644a2 = MapCollections.this.mo9644a(this.f1590b, 1);
                return (mo9644a == null ? 0 : mo9644a.hashCode()) ^ (mo9644a2 != null ? mo9644a2.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            next();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1591c) {
                MapCollections.this.mo9645a(this.f1590b);
                this.f1590b--;
                this.f1589a--;
                this.f1591c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f1591c) {
                return (V) MapCollections.this.mo9643a(this.f1590b, (int) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + SimpleComparison.EQUAL_TO_OPERATION + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1590b++;
                this.f1591c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: a.b.g.j.h$e */
    /* loaded from: classes.dex */
    public final class C0272e implements Collection<V> {
        public C0272e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            MapCollections.this.mo9646a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return MapCollections.this.mo9635b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return MapCollections.this.mo9633c() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new C0268a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int mo9635b = MapCollections.this.mo9635b(obj);
            if (mo9635b >= 0) {
                MapCollections.this.mo9645a(mo9635b);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int mo9633c = MapCollections.this.mo9633c();
            int i = 0;
            boolean z = false;
            while (i < mo9633c) {
                if (collection.contains(MapCollections.this.mo9644a(i, 1))) {
                    MapCollections.this.mo9645a(i);
                    i--;
                    mo9633c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int mo9633c = MapCollections.this.mo9633c();
            int i = 0;
            boolean z = false;
            while (i < mo9633c) {
                if (!collection.contains(MapCollections.this.mo9644a(i, 1))) {
                    MapCollections.this.mo9645a(i);
                    i--;
                    mo9633c--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return MapCollections.this.mo9633c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return MapCollections.this.m9636b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapCollections.this.m9638a(tArr, 1);
        }
    }

    /* renamed from: a */
    public static <K, V> boolean m9640a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m9634b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m9632c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: a */
    public abstract int mo9642a(Object obj);

    /* renamed from: a */
    public abstract Object mo9644a(int i, int i2);

    /* renamed from: a */
    public abstract V mo9643a(int i, V v);

    /* renamed from: a */
    public abstract void mo9646a();

    /* renamed from: a */
    public abstract void mo9645a(int i);

    /* renamed from: a */
    public abstract void mo9641a(K k, V v);

    /* renamed from: b */
    public abstract int mo9635b(Object obj);

    /* renamed from: b */
    public abstract Map<K, V> mo9637b();

    /* renamed from: c */
    public abstract int mo9633c();

    /* renamed from: d */
    public Set<Map.Entry<K, V>> m9631d() {
        if (this.f1579a == null) {
            this.f1579a = new C0269b();
        }
        return this.f1579a;
    }

    /* renamed from: e */
    public Set<K> m9630e() {
        if (this.f1580b == null) {
            this.f1580b = new C0270c();
        }
        return this.f1580b;
    }

    /* renamed from: f */
    public Collection<V> m9629f() {
        if (this.f1581c == null) {
            this.f1581c = new C0272e();
        }
        return this.f1581c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> T[] m9638a(T[] tArr, int i) {
        int mo9633c = mo9633c();
        if (tArr.length < mo9633c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), mo9633c));
        }
        for (int i2 = 0; i2 < mo9633c; i2++) {
            tArr[i2] = mo9644a(i2, i);
        }
        if (tArr.length > mo9633c) {
            tArr[mo9633c] = null;
        }
        return tArr;
    }

    /* renamed from: b */
    public Object[] m9636b(int i) {
        int mo9633c = mo9633c();
        Object[] objArr = new Object[mo9633c];
        for (int i2 = 0; i2 < mo9633c; i2++) {
            objArr[i2] = mo9644a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public static <T> boolean m9639a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
