package p000a.p006b.p030g.p044j;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: a.b.g.j.a */
/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: h */
    public MapCollections<K, V> f1548h;

    /* compiled from: ArrayMap.java */
    /* renamed from: a.b.g.j.a$a */
    /* loaded from: classes.dex */
    public class C0266a extends MapCollections<K, V> {
        public C0266a() {
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public Object mo9644a(int i, int i2) {
            return ArrayMap.this.f1602b[(i << 1) + i2];
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: b */
        public int mo9635b(Object obj) {
            return ArrayMap.this.m9610b(obj);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: c */
        public int mo9633c() {
            return ArrayMap.this.f1603c;
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public int mo9642a(Object obj) {
            return ArrayMap.this.m9615a(obj);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: b */
        public Map<K, V> mo9637b() {
            return ArrayMap.this;
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9641a(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public V mo9643a(int i, V v) {
            return ArrayMap.this.m9617a(i, (int) v);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9645a(int i) {
            ArrayMap.this.m9608d(i);
        }

        @Override // p000a.p006b.p030g.p044j.MapCollections
        /* renamed from: a */
        public void mo9646a() {
            ArrayMap.this.clear();
        }
    }

    public ArrayMap() {
    }

    /* renamed from: a */
    public boolean m9683a(Collection<?> collection) {
        return MapCollections.m9632c(this, collection);
    }

    /* renamed from: b */
    public final MapCollections<K, V> m9682b() {
        if (this.f1548h == null) {
            this.f1548h = new C0266a();
        }
        return this.f1548h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m9682b().m9631d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m9682b().m9630e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m9611b(this.f1603c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m9682b().m9629f();
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
