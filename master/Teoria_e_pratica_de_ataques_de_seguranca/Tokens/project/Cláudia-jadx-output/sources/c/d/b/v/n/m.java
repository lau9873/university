package c.d.b.v.n;

import c.d.b.s;
import c.d.b.v.n.i;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class m<T> extends s<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.f f3856a;

    /* renamed from: b  reason: collision with root package name */
    public final s<T> f3857b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f3858c;

    public m(c.d.b.f fVar, s<T> sVar, Type type) {
        this.f3856a = fVar;
        this.f3857b = sVar;
        this.f3858c = type;
    }

    @Override // c.d.b.s
    public T a(c.d.b.x.a aVar) {
        return this.f3857b.a(aVar);
    }

    @Override // c.d.b.s
    public void a(c.d.b.x.c cVar, T t) {
        s<T> sVar = this.f3857b;
        Type a2 = a(this.f3858c, t);
        if (a2 != this.f3858c) {
            sVar = this.f3856a.a((c.d.b.w.a) c.d.b.w.a.get(a2));
            if (sVar instanceof i.b) {
                s<T> sVar2 = this.f3857b;
                if (!(sVar2 instanceof i.b)) {
                    sVar = sVar2;
                }
            }
        }
        sVar.a(cVar, t);
    }

    public final Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
