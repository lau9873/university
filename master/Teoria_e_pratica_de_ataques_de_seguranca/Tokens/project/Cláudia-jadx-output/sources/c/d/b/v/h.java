package c.d.b.v;

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
/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final Comparator<Comparable> f3775h = new a();

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f3776a;

    /* renamed from: b  reason: collision with root package name */
    public e<K, V> f3777b;

    /* renamed from: c  reason: collision with root package name */
    public int f3778c;

    /* renamed from: d  reason: collision with root package name */
    public int f3779d;

    /* renamed from: e  reason: collision with root package name */
    public final e<K, V> f3780e;

    /* renamed from: f  reason: collision with root package name */
    public h<K, V>.b f3781f;

    /* renamed from: g  reason: collision with root package name */
    public h<K, V>.c f3782g;

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        public class a extends h<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> a2;
            if ((obj instanceof Map.Entry) && (a2 = h.this.a((Map.Entry) obj)) != null) {
                h.this.b(a2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f3778c;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes.dex */
        public class a extends h<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f3794f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f3778c;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        public e<K, V> f3785a;

        /* renamed from: b  reason: collision with root package name */
        public e<K, V> f3786b;

        /* renamed from: c  reason: collision with root package name */
        public int f3787c;

        public d() {
            h hVar = h.this;
            this.f3785a = hVar.f3780e.f3792d;
            this.f3786b = null;
            this.f3787c = hVar.f3779d;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f3785a;
            h hVar = h.this;
            if (eVar != hVar.f3780e) {
                if (hVar.f3779d == this.f3787c) {
                    this.f3785a = eVar.f3792d;
                    this.f3786b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f3785a != h.this.f3780e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f3786b;
            if (eVar != null) {
                h.this.b(eVar, true);
                this.f3786b = null;
                this.f3787c = h.this.f3779d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f3775h);
    }

    public e<K, V> a(K k, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f3776a;
        e<K, V> eVar2 = this.f3777b;
        if (eVar2 != null) {
            Comparable comparable = comparator == f3775h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f3794f);
                } else {
                    i2 = comparator.compare(k, (K) eVar2.f3794f);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f3790b : eVar2.f3791c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.f3780e;
            if (eVar2 == null) {
                if (comparator == f3775h && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k, eVar4, eVar4.f3793e);
                this.f3777b = eVar;
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.f3793e);
                if (i2 < 0) {
                    eVar2.f3790b = eVar;
                } else {
                    eVar2.f3791c = eVar;
                }
                a((e) eVar2, true);
            }
            this.f3778c++;
            this.f3779d++;
            return eVar;
        }
        return null;
    }

    public void b(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f3793e;
            eVar2.f3792d = eVar.f3792d;
            eVar.f3792d.f3793e = eVar2;
        }
        e<K, V> eVar3 = eVar.f3790b;
        e<K, V> eVar4 = eVar.f3791c;
        e<K, V> eVar5 = eVar.f3789a;
        int i3 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.f3796h > eVar4.f3796h ? eVar3.b() : eVar4.a();
            b(b2, false);
            e<K, V> eVar6 = eVar.f3790b;
            if (eVar6 != null) {
                i2 = eVar6.f3796h;
                b2.f3790b = eVar6;
                eVar6.f3789a = b2;
                eVar.f3790b = null;
            } else {
                i2 = 0;
            }
            e<K, V> eVar7 = eVar.f3791c;
            if (eVar7 != null) {
                i3 = eVar7.f3796h;
                b2.f3791c = eVar7;
                eVar7.f3789a = b2;
                eVar.f3791c = null;
            }
            b2.f3796h = Math.max(i2, i3) + 1;
            a((e) eVar, (e) b2);
            return;
        }
        if (eVar3 != null) {
            a((e) eVar, (e) eVar3);
            eVar.f3790b = null;
        } else if (eVar4 != null) {
            a((e) eVar, (e) eVar4);
            eVar.f3791c = null;
        } else {
            a((e) eVar, (e) null);
        }
        a((e) eVar5, false);
        this.f3778c--;
        this.f3779d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f3777b = null;
        this.f3778c = 0;
        this.f3779d++;
        e<K, V> eVar = this.f3780e;
        eVar.f3793e = eVar;
        eVar.f3792d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f3781f;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f3781f = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f3795g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f3782g;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f3782g = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            e<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f3795g;
            a2.f3795g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f3795g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f3778c;
    }

    public h(Comparator<? super K> comparator) {
        this.f3778c = 0;
        this.f3779d = 0;
        this.f3780e = new e<>();
        this.f3776a = comparator == null ? f3775h : comparator;
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public e<K, V> f3789a;

        /* renamed from: b  reason: collision with root package name */
        public e<K, V> f3790b;

        /* renamed from: c  reason: collision with root package name */
        public e<K, V> f3791c;

        /* renamed from: d  reason: collision with root package name */
        public e<K, V> f3792d;

        /* renamed from: e  reason: collision with root package name */
        public e<K, V> f3793e;

        /* renamed from: f  reason: collision with root package name */
        public final K f3794f;

        /* renamed from: g  reason: collision with root package name */
        public V f3795g;

        /* renamed from: h  reason: collision with root package name */
        public int f3796h;

        public e() {
            this.f3794f = null;
            this.f3793e = this;
            this.f3792d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f3790b; eVar2 != null; eVar2 = eVar2.f3790b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f3791c; eVar2 != null; eVar2 = eVar2.f3791c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f3794f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f3795g;
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
            return this.f3794f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3795g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f3794f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f3795g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f3795g;
            this.f3795g = v;
            return v2;
        }

        public String toString() {
            return this.f3794f + SimpleComparison.EQUAL_TO_OPERATION + this.f3795g;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f3789a = eVar;
            this.f3794f = k;
            this.f3796h = 1;
            this.f3792d = eVar2;
            this.f3793e = eVar3;
            eVar3.f3792d = this;
            eVar2.f3793e = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a((h<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    public e<K, V> a(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.f3795g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    public final boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f3789a;
        eVar.f3789a = null;
        if (eVar2 != null) {
            eVar2.f3789a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f3790b == eVar) {
                eVar3.f3790b = eVar2;
                return;
            } else {
                eVar3.f3791c = eVar2;
                return;
            }
        }
        this.f3777b = eVar2;
    }

    public e<K, V> b(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        return a2;
    }

    public final void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f3790b;
            e<K, V> eVar3 = eVar.f3791c;
            int i2 = eVar2 != null ? eVar2.f3796h : 0;
            int i3 = eVar3 != null ? eVar3.f3796h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f3790b;
                e<K, V> eVar5 = eVar3.f3791c;
                int i5 = (eVar4 != null ? eVar4.f3796h : 0) - (eVar5 != null ? eVar5.f3796h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    b((e) eVar3);
                    a((e) eVar);
                } else {
                    a((e) eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f3790b;
                e<K, V> eVar7 = eVar2.f3791c;
                int i6 = (eVar6 != null ? eVar6.f3796h : 0) - (eVar7 != null ? eVar7.f3796h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    a((e) eVar2);
                    b((e) eVar);
                } else {
                    b((e) eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f3796h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f3796h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f3789a;
        }
    }

    public final void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f3790b;
        e<K, V> eVar3 = eVar.f3791c;
        e<K, V> eVar4 = eVar2.f3790b;
        e<K, V> eVar5 = eVar2.f3791c;
        eVar.f3790b = eVar5;
        if (eVar5 != null) {
            eVar5.f3789a = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.f3791c = eVar;
        eVar.f3789a = eVar2;
        eVar.f3796h = Math.max(eVar3 != null ? eVar3.f3796h : 0, eVar5 != null ? eVar5.f3796h : 0) + 1;
        eVar2.f3796h = Math.max(eVar.f3796h, eVar4 != null ? eVar4.f3796h : 0) + 1;
    }

    public final void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f3790b;
        e<K, V> eVar3 = eVar.f3791c;
        e<K, V> eVar4 = eVar3.f3790b;
        e<K, V> eVar5 = eVar3.f3791c;
        eVar.f3791c = eVar4;
        if (eVar4 != null) {
            eVar4.f3789a = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.f3790b = eVar;
        eVar.f3789a = eVar3;
        eVar.f3796h = Math.max(eVar2 != null ? eVar2.f3796h : 0, eVar4 != null ? eVar4.f3796h : 0) + 1;
        eVar3.f3796h = Math.max(eVar.f3796h, eVar5 != null ? eVar5.f3796h : 0) + 1;
    }
}
