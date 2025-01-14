package a.b.g.j;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: MapCollections.java */
/* loaded from: classes.dex */
public abstract class h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public h<K, V>.b f1068a;

    /* renamed from: b  reason: collision with root package name */
    public h<K, V>.c f1069b;

    /* renamed from: c  reason: collision with root package name */
    public h<K, V>.e f1070c;

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    public final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f1071a;

        /* renamed from: b  reason: collision with root package name */
        public int f1072b;

        /* renamed from: c  reason: collision with root package name */
        public int f1073c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1074d = false;

        public a(int i2) {
            this.f1071a = i2;
            this.f1072b = h.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1073c < this.f1072b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) h.this.a(this.f1073c, this.f1071a);
                this.f1073c++;
                this.f1074d = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f1074d) {
                this.f1073c--;
                this.f1072b--;
                this.f1074d = false;
                h.this.a(this.f1073c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int c2 = h.this.c();
            for (Map.Entry<K, V> entry : collection) {
                h.this.a((h) entry.getKey(), (K) entry.getValue());
            }
            return c2 != h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int a2 = h.this.a(entry.getKey());
                if (a2 < 0) {
                    return false;
                }
                return a.b.g.j.c.a(h.this.a(a2, 1), entry.getValue());
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
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int c2 = h.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = h.this.a(c2, 0);
                Object a3 = h.this.a(c2, 1);
                i2 += (a2 == null ? 0 : a2.hashCode()) ^ (a3 == null ? 0 : a3.hashCode());
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
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
            return h.this.c();
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
    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        public c() {
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
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h.a((Map) h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int c2 = h.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = h.this.a(c2, 0);
                i2 += a2 == null ? 0 : a2.hashCode();
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a2 = h.this.a(obj);
            if (a2 >= 0) {
                h.this.a(a2);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return h.b(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return h.c(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return h.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 0);
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public int f1078a;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1080c = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1079b = -1;

        public d() {
            this.f1078a = h.this.c() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f1080c) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return a.b.g.j.c.a(entry.getKey(), h.this.a(this.f1079b, 0)) && a.b.g.j.c.a(entry.getValue(), h.this.a(this.f1079b, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f1080c) {
                return (K) h.this.a(this.f1079b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f1080c) {
                return (V) h.this.a(this.f1079b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1079b < this.f1078a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.f1080c) {
                Object a2 = h.this.a(this.f1079b, 0);
                Object a3 = h.this.a(this.f1079b, 1);
                return (a2 == null ? 0 : a2.hashCode()) ^ (a3 != null ? a3.hashCode() : 0);
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
            if (this.f1080c) {
                h.this.a(this.f1079b);
                this.f1079b--;
                this.f1078a--;
                this.f1080c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f1080c) {
                return (V) h.this.a(this.f1079b, (int) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + SimpleComparison.EQUAL_TO_OPERATION + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1079b++;
                this.f1080c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        public e() {
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
            h.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return h.this.b(obj) >= 0;
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
            return h.this.c() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b2 = h.this.b(obj);
            if (b2 >= 0) {
                h.this.a(b2);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int c2 = h.this.c();
            int i2 = 0;
            boolean z = false;
            while (i2 < c2) {
                if (collection.contains(h.this.a(i2, 1))) {
                    h.this.a(i2);
                    i2--;
                    c2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int c2 = h.this.c();
            int i2 = 0;
            boolean z = false;
            while (i2 < c2) {
                if (!collection.contains(h.this.a(i2, 1))) {
                    h.this.a(i2);
                    i2--;
                    c2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return h.this.c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return h.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract int a(Object obj);

    public abstract Object a(int i2, int i3);

    public abstract V a(int i2, V v);

    public abstract void a();

    public abstract void a(int i2);

    public abstract void a(K k, V v);

    public abstract int b(Object obj);

    public abstract Map<K, V> b();

    public abstract int c();

    public Set<Map.Entry<K, V>> d() {
        if (this.f1068a == null) {
            this.f1068a = new b();
        }
        return this.f1068a;
    }

    public Set<K> e() {
        if (this.f1069b == null) {
            this.f1069b = new c();
        }
        return this.f1069b;
    }

    public Collection<V> f() {
        if (this.f1070c == null) {
            this.f1070c = new e();
        }
        return this.f1070c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] a(T[] tArr, int i2) {
        int c2 = c();
        if (tArr.length < c2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), c2));
        }
        for (int i3 = 0; i3 < c2; i3++) {
            tArr[i3] = a(i3, i2);
        }
        if (tArr.length > c2) {
            tArr[c2] = null;
        }
        return tArr;
    }

    public Object[] b(int i2) {
        int c2 = c();
        Object[] objArr = new Object[c2];
        for (int i3 = 0; i3 < c2; i3++) {
            objArr[i3] = a(i3, i2);
        }
        return objArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
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
