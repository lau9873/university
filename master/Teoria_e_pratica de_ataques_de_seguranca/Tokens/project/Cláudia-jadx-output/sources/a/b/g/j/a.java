package a.b.g.j;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends n<K, V> implements Map<K, V> {

    /* renamed from: h  reason: collision with root package name */
    public h<K, V> f1038h;

    /* compiled from: ArrayMap.java */
    /* renamed from: a.b.g.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0031a extends h<K, V> {
        public C0031a() {
        }

        @Override // a.b.g.j.h
        public Object a(int i2, int i3) {
            return a.this.f1091b[(i2 << 1) + i3];
        }

        @Override // a.b.g.j.h
        public int b(Object obj) {
            return a.this.b(obj);
        }

        @Override // a.b.g.j.h
        public int c() {
            return a.this.f1092c;
        }

        @Override // a.b.g.j.h
        public int a(Object obj) {
            return a.this.a(obj);
        }

        @Override // a.b.g.j.h
        public Map<K, V> b() {
            return a.this;
        }

        @Override // a.b.g.j.h
        public void a(K k, V v) {
            a.this.put(k, v);
        }

        @Override // a.b.g.j.h
        public V a(int i2, V v) {
            return a.this.a(i2, (int) v);
        }

        @Override // a.b.g.j.h
        public void a(int i2) {
            a.this.d(i2);
        }

        @Override // a.b.g.j.h
        public void a() {
            a.this.clear();
        }
    }

    public a() {
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    public final h<K, V> b() {
        if (this.f1038h == null) {
            this.f1038h = new C0031a();
        }
        return this.f1038h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(this.f1092c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }

    public a(int i2) {
        super(i2);
    }

    public a(n nVar) {
        super(nVar);
    }
}
