package d.a.a.a.m.a;

import android.content.Context;
/* compiled from: AbstractValueCache.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f4223a;

    public a(c<T> cVar) {
        this.f4223a = cVar;
    }

    public abstract T a(Context context);

    @Override // d.a.a.a.m.a.c
    public final synchronized T a(Context context, d<T> dVar) {
        T a2;
        a2 = a(context);
        if (a2 == null) {
            a2 = this.f4223a != null ? this.f4223a.a(context, dVar) : dVar.a(context);
            a(context, (Context) a2);
        }
        return a2;
    }

    public abstract void b(Context context, T t);

    public final void a(Context context, T t) {
        if (t != null) {
            b(context, t);
            return;
        }
        throw new NullPointerException();
    }
}
