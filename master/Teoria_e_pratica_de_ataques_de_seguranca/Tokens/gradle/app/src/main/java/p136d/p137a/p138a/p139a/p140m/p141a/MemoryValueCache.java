package p136d.p137a.p138a.p139a.p140m.p141a;

import android.content.Context;

/* renamed from: d.a.a.a.m.a.b */
/* loaded from: classes.dex */
public class MemoryValueCache<T> extends AbstractValueCache<T> {

    /* renamed from: b */
    public T f6416b;

    public MemoryValueCache() {
        this(null);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p141a.AbstractValueCache
    /* renamed from: a */
    public T mo4143a(Context context) {
        return this.f6416b;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p141a.AbstractValueCache
    /* renamed from: b */
    public void mo4142b(Context context, T t) {
        this.f6416b = t;
    }

    public MemoryValueCache(ValueCache<T> valueCache) {
        super(valueCache);
    }
}
