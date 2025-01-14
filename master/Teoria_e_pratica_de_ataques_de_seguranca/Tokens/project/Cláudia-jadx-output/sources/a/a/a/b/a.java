package a.a.a.b;

import a.a.a.b.b;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: e  reason: collision with root package name */
    public HashMap<K, b.d<K, V>> f7e = new HashMap<>();

    @Override // a.a.a.b.b
    public b.d<K, V> a(K k) {
        return this.f7e.get(k);
    }

    @Override // a.a.a.b.b
    public V b(K k, V v) {
        b.d<K, V> a2 = a((a<K, V>) k);
        if (a2 != null) {
            return a2.f13b;
        }
        this.f7e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f7e.containsKey(k);
    }

    @Override // a.a.a.b.b
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f7e.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.f7e.get(k).f15d;
        }
        return null;
    }
}
