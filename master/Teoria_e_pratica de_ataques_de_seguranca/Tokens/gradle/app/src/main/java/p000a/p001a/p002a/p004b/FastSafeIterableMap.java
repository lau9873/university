package p000a.p001a.p002a.p004b;

import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.p004b.SafeIterableMap;

/* renamed from: a.a.a.b.a */
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: e */
    public HashMap<K, SafeIterableMap.C0005d<K, V>> f6e = new HashMap<>();

    @Override // p000a.p001a.p002a.p004b.SafeIterableMap
    /* renamed from: a */
    public SafeIterableMap.C0005d<K, V> mo11318a(K k) {
        return this.f6e.get(k);
    }

    @Override // p000a.p001a.p002a.p004b.SafeIterableMap
    /* renamed from: b */
    public V mo11316b(K k, V v) {
        SafeIterableMap.C0005d<K, V> mo11318a = mo11318a((FastSafeIterableMap<K, V>) k);
        if (mo11318a != null) {
            return mo11318a.f12b;
        }
        this.f6e.put(k, m11317a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f6e.containsKey(k);
    }

    @Override // p000a.p001a.p002a.p004b.SafeIterableMap
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f6e.remove(k);
        return v;
    }

    /* renamed from: b */
    public Map.Entry<K, V> m11321b(K k) {
        if (contains(k)) {
            return this.f6e.get(k).f14d;
        }
        return null;
    }
}
