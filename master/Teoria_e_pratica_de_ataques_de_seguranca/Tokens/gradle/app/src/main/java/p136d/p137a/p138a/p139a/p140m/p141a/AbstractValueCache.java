package p136d.p137a.p138a.p139a.p140m.p141a;

import android.content.Context;

/* renamed from: d.a.a.a.m.a.a */
/* loaded from: classes.dex */
public abstract class AbstractValueCache<T> implements ValueCache<T> {

    /* renamed from: a */
    public final ValueCache<T> f6415a;

    public AbstractValueCache(ValueCache<T> valueCache) {
        this.f6415a = valueCache;
    }

    /* renamed from: a */
    public abstract T mo4143a(Context context);

    @Override // p136d.p137a.p138a.p139a.p140m.p141a.ValueCache
    /* renamed from: a */
    public final synchronized T mo4141a(Context context, ValueLoader<T> valueLoader) {
        T mo4143a;
        mo4143a = mo4143a(context);
        if (mo4143a == null) {
            mo4143a = this.f6415a != null ? this.f6415a.mo4141a(context, valueLoader) : valueLoader.mo4037a(context);
            m4144a(context, (Context) mo4143a);
        }
        return mo4143a;
    }

    /* renamed from: b */
    public abstract void mo4142b(Context context, T t);

    /* renamed from: a */
    public final void m4144a(Context context, T t) {
        if (t != null) {
            mo4142b(context, t);
            return;
        }
        throw new NullPointerException();
    }
}
